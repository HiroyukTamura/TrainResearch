// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine;

import java.io.FileNotFoundException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.Priority;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.load.data.DataFetcher;

class DecodeJob<A, T, Z>
{
    private static final FileOpener DEFAULT_FILE_OPENER;
    private static final String TAG = "DecodeJob";
    private final DiskCacheProvider diskCacheProvider;
    private final DiskCacheStrategy diskCacheStrategy;
    private final DataFetcher<A> fetcher;
    private final FileOpener fileOpener;
    private final int height;
    private volatile boolean isCancelled;
    private final DataLoadProvider<A, T> loadProvider;
    private final Priority priority;
    private final EngineKey resultKey;
    private final ResourceTranscoder<T, Z> transcoder;
    private final Transformation<T> transformation;
    private final int width;
    
    static {
        DEFAULT_FILE_OPENER = new FileOpener();
    }
    
    public DecodeJob(final EngineKey engineKey, final int n, final int n2, final DataFetcher<A> dataFetcher, final DataLoadProvider<A, T> dataLoadProvider, final Transformation<T> transformation, final ResourceTranscoder<T, Z> resourceTranscoder, final DiskCacheProvider diskCacheProvider, final DiskCacheStrategy diskCacheStrategy, final Priority priority) {
        this(engineKey, n, n2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, diskCacheProvider, diskCacheStrategy, priority, DecodeJob.DEFAULT_FILE_OPENER);
    }
    
    DecodeJob(final EngineKey resultKey, final int width, final int height, final DataFetcher<A> fetcher, final DataLoadProvider<A, T> loadProvider, final Transformation<T> transformation, final ResourceTranscoder<T, Z> transcoder, final DiskCacheProvider diskCacheProvider, final DiskCacheStrategy diskCacheStrategy, final Priority priority, final FileOpener fileOpener) {
        this.resultKey = resultKey;
        this.width = width;
        this.height = height;
        this.fetcher = fetcher;
        this.loadProvider = loadProvider;
        this.transformation = transformation;
        this.transcoder = transcoder;
        this.diskCacheProvider = diskCacheProvider;
        this.diskCacheStrategy = diskCacheStrategy;
        this.priority = priority;
        this.fileOpener = fileOpener;
    }
    
    private Resource<T> cacheAndDecodeSourceData(final A a) throws IOException {
        final long logTime = LogTime.getLogTime();
        this.diskCacheProvider.getDiskCache().put(this.resultKey.getOriginalKey(), (DiskCache.Writer)new SourceWriter((Encoder<Object>)this.loadProvider.getSourceEncoder(), a));
        if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Wrote source to cache", logTime);
        }
        final long logTime2 = LogTime.getLogTime();
        final Resource<T> loadFromCache = this.loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", 2) && loadFromCache != null) {
            this.logWithTimeAndKey("Decoded source from cache", logTime2);
        }
        return loadFromCache;
    }
    
    private Resource<T> decodeFromSourceData(final A a) throws IOException {
        Resource<T> resource;
        if (this.diskCacheStrategy.cacheSource()) {
            resource = this.cacheAndDecodeSourceData(a);
        }
        else {
            final long logTime = LogTime.getLogTime();
            resource = this.loadProvider.getSourceDecoder().decode(a, this.width, this.height);
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Decoded from source", logTime);
                return resource;
            }
        }
        return resource;
    }
    
    private Resource<T> decodeSource() throws Exception {
        try {
            final long logTime = LogTime.getLogTime();
            final A loadData = this.fetcher.loadData(this.priority);
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Fetched data", logTime);
            }
            if (this.isCancelled) {
                return null;
            }
            return this.decodeFromSourceData(loadData);
        }
        finally {
            this.fetcher.cleanup();
        }
    }
    
    private Resource<T> loadFromCache(final Key key) throws IOException {
        final File value = this.diskCacheProvider.getDiskCache().get(key);
        Resource<T> resource = null;
        if (value == null) {
            resource = null;
        }
        else {
            try {
                final Resource<T> decode = this.loadProvider.getCacheDecoder().decode(value, this.width, this.height);
                final Resource<T> resource2;
                if ((resource2 = decode) == null) {
                    this.diskCacheProvider.getDiskCache().delete(key);
                    return decode;
                }
            }
            finally {
                if (!false) {
                    this.diskCacheProvider.getDiskCache().delete(key);
                }
            }
        }
        return resource;
    }
    
    private void logWithTimeAndKey(final String str, final long n) {
        Log.v("DecodeJob", str + " in " + LogTime.getElapsedMillis(n) + ", key: " + this.resultKey);
    }
    
    private Resource<Z> transcode(final Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        return this.transcoder.transcode(resource);
    }
    
    private Resource<T> transform(final Resource<T> resource) {
        Resource<T> transform;
        if (resource == null) {
            transform = null;
        }
        else {
            final Resource<T> obj = transform = this.transformation.transform(resource, this.width, this.height);
            if (!resource.equals(obj)) {
                resource.recycle();
                return obj;
            }
        }
        return transform;
    }
    
    private Resource<Z> transformEncodeAndTranscode(final Resource<T> resource) {
        final long logTime = LogTime.getLogTime();
        final Resource<T> transform = this.transform(resource);
        if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Transformed resource from source", logTime);
        }
        this.writeTransformedToCache(transform);
        final long logTime2 = LogTime.getLogTime();
        final Resource<Z> transcode = this.transcode(transform);
        if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Transcoded transformed from source", logTime2);
        }
        return transcode;
    }
    
    private void writeTransformedToCache(final Resource<T> resource) {
        if (resource != null && this.diskCacheStrategy.cacheResult()) {
            final long logTime = LogTime.getLogTime();
            this.diskCacheProvider.getDiskCache().put(this.resultKey, (DiskCache.Writer)new SourceWriter((Encoder<Object>)this.loadProvider.getEncoder(), resource));
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Wrote transformed from source to cache", logTime);
            }
        }
    }
    
    public void cancel() {
        this.isCancelled = true;
        this.fetcher.cancel();
    }
    
    public Resource<Z> decodeFromSource() throws Exception {
        return this.transformEncodeAndTranscode(this.decodeSource());
    }
    
    public Resource<Z> decodeResultFromCache() throws Exception {
        Resource<Z> transcode;
        if (!this.diskCacheStrategy.cacheResult()) {
            transcode = null;
        }
        else {
            final long logTime = LogTime.getLogTime();
            final Resource<T> loadFromCache = this.loadFromCache(this.resultKey);
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Decoded transformed from cache", logTime);
            }
            final long logTime2 = LogTime.getLogTime();
            transcode = this.transcode(loadFromCache);
            if (Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Transcoded transformed from cache", logTime2);
                return transcode;
            }
        }
        return transcode;
    }
    
    public Resource<Z> decodeSourceFromCache() throws Exception {
        if (!this.diskCacheStrategy.cacheSource()) {
            return null;
        }
        final long logTime = LogTime.getLogTime();
        final Resource<T> loadFromCache = this.loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Decoded source from cache", logTime);
        }
        return this.transformEncodeAndTranscode(loadFromCache);
    }
    
    interface DiskCacheProvider
    {
        DiskCache getDiskCache();
    }
    
    static class FileOpener
    {
        public OutputStream open(final File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }
    
    class SourceWriter<DataType> implements Writer
    {
        private final DataType data;
        private final Encoder<DataType> encoder;
        
        public SourceWriter(final Encoder<DataType> encoder, final DataType data) {
            this.encoder = encoder;
            this.data = data;
        }
        
        @Override
        public boolean write(final File p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: istore_3       
            //     2: aconst_null    
            //     3: astore          5
            //     5: aconst_null    
            //     6: astore          4
            //     8: aload_0        
            //     9: getfield        com/bumptech/glide/load/engine/DecodeJob$SourceWriter.this$0:Lcom/bumptech/glide/load/engine/DecodeJob;
            //    12: invokestatic    com/bumptech/glide/load/engine/DecodeJob.access$000:(Lcom/bumptech/glide/load/engine/DecodeJob;)Lcom/bumptech/glide/load/engine/DecodeJob$FileOpener;
            //    15: aload_1        
            //    16: invokevirtual   com/bumptech/glide/load/engine/DecodeJob$FileOpener.open:(Ljava/io/File;)Ljava/io/OutputStream;
            //    19: astore_1       
            //    20: aload_1        
            //    21: astore          4
            //    23: aload_1        
            //    24: astore          5
            //    26: aload_0        
            //    27: getfield        com/bumptech/glide/load/engine/DecodeJob$SourceWriter.encoder:Lcom/bumptech/glide/load/Encoder;
            //    30: aload_0        
            //    31: getfield        com/bumptech/glide/load/engine/DecodeJob$SourceWriter.data:Ljava/lang/Object;
            //    34: aload_1        
            //    35: invokeinterface com/bumptech/glide/load/Encoder.encode:(Ljava/lang/Object;Ljava/io/OutputStream;)Z
            //    40: istore_2       
            //    41: iload_2        
            //    42: istore_3       
            //    43: aload_1        
            //    44: ifnull          53
            //    47: aload_1        
            //    48: invokevirtual   java/io/OutputStream.close:()V
            //    51: iload_2        
            //    52: istore_3       
            //    53: iload_3        
            //    54: ireturn        
            //    55: astore_1       
            //    56: aload           4
            //    58: astore          5
            //    60: ldc             "DecodeJob"
            //    62: iconst_3       
            //    63: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
            //    66: ifeq            82
            //    69: aload           4
            //    71: astore          5
            //    73: ldc             "DecodeJob"
            //    75: ldc             "Failed to find file to write to disk cache"
            //    77: aload_1        
            //    78: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //    81: pop            
            //    82: aload           4
            //    84: ifnull          53
            //    87: aload           4
            //    89: invokevirtual   java/io/OutputStream.close:()V
            //    92: iconst_0       
            //    93: ireturn        
            //    94: astore_1       
            //    95: iconst_0       
            //    96: ireturn        
            //    97: astore_1       
            //    98: aload           5
            //   100: ifnull          108
            //   103: aload           5
            //   105: invokevirtual   java/io/OutputStream.close:()V
            //   108: aload_1        
            //   109: athrow         
            //   110: astore_1       
            //   111: iload_2        
            //   112: ireturn        
            //   113: astore          4
            //   115: goto            108
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  8      20     55     97     Ljava/io/FileNotFoundException;
            //  8      20     97     110    Any
            //  26     41     55     97     Ljava/io/FileNotFoundException;
            //  26     41     97     110    Any
            //  47     51     110    113    Ljava/io/IOException;
            //  60     69     97     110    Any
            //  73     82     97     110    Any
            //  87     92     94     97     Ljava/io/IOException;
            //  103    108    113    118    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index 68 out of bounds for length 68
            //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
            //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
            //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
    }
}
