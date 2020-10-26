// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.InputStream;
import android.os.ParcelFileDescriptor;

public class ImageVideoModelLoader<A> implements ModelLoader<A, ImageVideoWrapper>
{
    private static final String TAG = "IVML";
    private final ModelLoader<A, ParcelFileDescriptor> fileDescriptorLoader;
    private final ModelLoader<A, InputStream> streamLoader;
    
    public ImageVideoModelLoader(final ModelLoader<A, InputStream> streamLoader, final ModelLoader<A, ParcelFileDescriptor> fileDescriptorLoader) {
        if (streamLoader == null && fileDescriptorLoader == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.streamLoader = streamLoader;
        this.fileDescriptorLoader = fileDescriptorLoader;
    }
    
    @Override
    public DataFetcher<ImageVideoWrapper> getResourceFetcher(final A a, final int n, final int n2) {
        DataFetcher<InputStream> resourceFetcher = null;
        if (this.streamLoader != null) {
            resourceFetcher = this.streamLoader.getResourceFetcher(a, n, n2);
        }
        DataFetcher<ParcelFileDescriptor> resourceFetcher2 = null;
        if (this.fileDescriptorLoader != null) {
            resourceFetcher2 = this.fileDescriptorLoader.getResourceFetcher(a, n, n2);
        }
        if (resourceFetcher != null || resourceFetcher2 != null) {
            return new ImageVideoFetcher(resourceFetcher, resourceFetcher2);
        }
        return null;
    }
    
    static class ImageVideoFetcher implements DataFetcher<ImageVideoWrapper>
    {
        private final DataFetcher<ParcelFileDescriptor> fileDescriptorFetcher;
        private final DataFetcher<InputStream> streamFetcher;
        
        public ImageVideoFetcher(final DataFetcher<InputStream> streamFetcher, final DataFetcher<ParcelFileDescriptor> fileDescriptorFetcher) {
            this.streamFetcher = streamFetcher;
            this.fileDescriptorFetcher = fileDescriptorFetcher;
        }
        
        @Override
        public void cancel() {
            if (this.streamFetcher != null) {
                this.streamFetcher.cancel();
            }
            if (this.fileDescriptorFetcher != null) {
                this.fileDescriptorFetcher.cancel();
            }
        }
        
        @Override
        public void cleanup() {
            if (this.streamFetcher != null) {
                this.streamFetcher.cleanup();
            }
            if (this.fileDescriptorFetcher != null) {
                this.fileDescriptorFetcher.cleanup();
            }
        }
        
        @Override
        public String getId() {
            if (this.streamFetcher != null) {
                return this.streamFetcher.getId();
            }
            return this.fileDescriptorFetcher.getId();
        }
        
        @Override
        public ImageVideoWrapper loadData(final Priority p0) throws Exception {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: astore_3       
            //     2: aload_3        
            //     3: astore_2       
            //     4: aload_0        
            //     5: getfield        com/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher.streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;
            //     8: ifnull          25
            //    11: aload_0        
            //    12: getfield        com/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher.streamFetcher:Lcom/bumptech/glide/load/data/DataFetcher;
            //    15: aload_1        
            //    16: invokeinterface com/bumptech/glide/load/data/DataFetcher.loadData:(Lcom/bumptech/glide/Priority;)Ljava/lang/Object;
            //    21: checkcast       Ljava/io/InputStream;
            //    24: astore_2       
            //    25: aconst_null    
            //    26: astore          4
            //    28: aload           4
            //    30: astore_3       
            //    31: aload_0        
            //    32: getfield        com/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher.fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;
            //    35: ifnull          52
            //    38: aload_0        
            //    39: getfield        com/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher.fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;
            //    42: aload_1        
            //    43: invokeinterface com/bumptech/glide/load/data/DataFetcher.loadData:(Lcom/bumptech/glide/Priority;)Ljava/lang/Object;
            //    48: checkcast       Landroid/os/ParcelFileDescriptor;
            //    51: astore_3       
            //    52: new             Lcom/bumptech/glide/load/model/ImageVideoWrapper;
            //    55: dup            
            //    56: aload_2        
            //    57: aload_3        
            //    58: invokespecial   com/bumptech/glide/load/model/ImageVideoWrapper.<init>:(Ljava/io/InputStream;Landroid/os/ParcelFileDescriptor;)V
            //    61: areturn        
            //    62: astore          4
            //    64: ldc             "IVML"
            //    66: iconst_2       
            //    67: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
            //    70: ifeq            83
            //    73: ldc             "IVML"
            //    75: ldc             "Exception fetching input stream, trying ParcelFileDescriptor"
            //    77: aload           4
            //    79: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //    82: pop            
            //    83: aload_3        
            //    84: astore_2       
            //    85: aload_0        
            //    86: getfield        com/bumptech/glide/load/model/ImageVideoModelLoader$ImageVideoFetcher.fileDescriptorFetcher:Lcom/bumptech/glide/load/data/DataFetcher;
            //    89: ifnonnull       25
            //    92: aload           4
            //    94: athrow         
            //    95: astore_1       
            //    96: ldc             "IVML"
            //    98: iconst_2       
            //    99: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
            //   102: ifeq            114
            //   105: ldc             "IVML"
            //   107: ldc             "Exception fetching ParcelFileDescriptor"
            //   109: aload_1        
            //   110: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   113: pop            
            //   114: aload           4
            //   116: astore_3       
            //   117: aload_2        
            //   118: ifnonnull       52
            //   121: aload_1        
            //   122: athrow         
            //    Exceptions:
            //  throws java.lang.Exception
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  11     25     62     95     Ljava/lang/Exception;
            //  38     52     95     123    Ljava/lang/Exception;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
