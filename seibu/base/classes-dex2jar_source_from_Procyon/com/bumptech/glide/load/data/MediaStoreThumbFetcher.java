// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import android.provider.MediaStore$Video$Thumbnails;
import android.text.TextUtils;
import android.provider.MediaStore$Images$Thumbnails;
import android.database.Cursor;
import java.io.File;
import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.FileNotFoundException;
import android.util.Log;
import android.net.Uri;
import android.content.Context;
import java.io.InputStream;

public class MediaStoreThumbFetcher implements DataFetcher<InputStream>
{
    private static final ThumbnailStreamOpenerFactory DEFAULT_FACTORY;
    private static final int MINI_HEIGHT = 384;
    private static final int MINI_WIDTH = 512;
    private static final String TAG = "MediaStoreThumbFetcher";
    private final Context context;
    private final DataFetcher<InputStream> defaultFetcher;
    private final ThumbnailStreamOpenerFactory factory;
    private final int height;
    private InputStream inputStream;
    private final Uri mediaStoreUri;
    private final int width;
    
    static {
        DEFAULT_FACTORY = new ThumbnailStreamOpenerFactory();
    }
    
    public MediaStoreThumbFetcher(final Context context, final Uri uri, final DataFetcher<InputStream> dataFetcher, final int n, final int n2) {
        this(context, uri, dataFetcher, n, n2, MediaStoreThumbFetcher.DEFAULT_FACTORY);
    }
    
    MediaStoreThumbFetcher(final Context context, final Uri mediaStoreUri, final DataFetcher<InputStream> defaultFetcher, final int width, final int height, final ThumbnailStreamOpenerFactory factory) {
        this.context = context;
        this.mediaStoreUri = mediaStoreUri;
        this.defaultFetcher = defaultFetcher;
        this.width = width;
        this.height = height;
        this.factory = factory;
    }
    
    private static boolean isMediaStoreUri(final Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
    
    private static boolean isMediaStoreVideo(final Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("video");
    }
    
    private InputStream openThumbInputStream(final ThumbnailStreamOpener thumbnailStreamOpener) {
        InputStream open;
        while (true) {
            try {
                open = thumbnailStreamOpener.open(this.context, this.mediaStoreUri);
                int orientation = -1;
                if (open != null) {
                    orientation = thumbnailStreamOpener.getOrientation(this.context, this.mediaStoreUri);
                }
                if (orientation != -1) {
                    return new ExifOrientationStream(open, orientation);
                }
            }
            catch (FileNotFoundException ex) {
                if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                    Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", (Throwable)ex);
                }
                open = null;
                continue;
            }
            break;
        }
        return open;
    }
    
    @Override
    public void cancel() {
    }
    
    @Override
    public void cleanup() {
        while (true) {
            if (this.inputStream == null) {
                break Label_0014;
            }
            try {
                this.inputStream.close();
                this.defaultFetcher.cleanup();
            }
            catch (IOException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public String getId() {
        return this.mediaStoreUri.toString();
    }
    
    @Override
    public InputStream loadData(final Priority priority) throws Exception {
        final ThumbnailStreamOpener build = this.factory.build(this.mediaStoreUri, this.width, this.height);
        if (build != null) {
            this.inputStream = this.openThumbInputStream(build);
        }
        if (this.inputStream == null) {
            this.inputStream = this.defaultFetcher.loadData(priority);
        }
        return this.inputStream;
    }
    
    static class FileService
    {
        public boolean exists(final File file) {
            return file.exists();
        }
        
        public File get(final String pathname) {
            return new File(pathname);
        }
        
        public long length(final File file) {
            return file.length();
        }
    }
    
    static class ImageThumbnailQuery implements ThumbnailQuery
    {
        private static final String[] PATH_PROJECTION;
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        
        static {
            PATH_PROJECTION = new String[] { "_data" };
        }
        
        @Override
        public Cursor queryPath(final Context context, final Uri uri) {
            return context.getContentResolver().query(MediaStore$Images$Thumbnails.EXTERNAL_CONTENT_URI, ImageThumbnailQuery.PATH_PROJECTION, "kind = 1 AND image_id = ?", new String[] { uri.getLastPathSegment() }, (String)null);
        }
    }
    
    interface ThumbnailQuery
    {
        Cursor queryPath(final Context p0, final Uri p1);
    }
    
    static class ThumbnailStreamOpener
    {
        private static final FileService DEFAULT_SERVICE;
        private ThumbnailQuery query;
        private final FileService service;
        
        static {
            DEFAULT_SERVICE = new FileService();
        }
        
        public ThumbnailStreamOpener(final FileService service, final ThumbnailQuery query) {
            this.service = service;
            this.query = query;
        }
        
        public ThumbnailStreamOpener(final ThumbnailQuery thumbnailQuery) {
            this(ThumbnailStreamOpener.DEFAULT_SERVICE, thumbnailQuery);
        }
        
        private Uri parseThumbUri(final Cursor cursor) {
            final Uri uri = null;
            final String string = cursor.getString(0);
            Uri fromFile = uri;
            if (!TextUtils.isEmpty((CharSequence)string)) {
                final File value = this.service.get(string);
                fromFile = uri;
                if (this.service.exists(value)) {
                    fromFile = uri;
                    if (this.service.length(value) > 0L) {
                        fromFile = Uri.fromFile(value);
                    }
                }
            }
            return fromFile;
        }
        
        public int getOrientation(final Context p0, final Uri p1) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: istore          4
            //     3: aconst_null    
            //     4: astore          6
            //     6: aconst_null    
            //     7: astore          5
            //     9: aload_1        
            //    10: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
            //    13: aload_2        
            //    14: invokevirtual   android/content/ContentResolver.openInputStream:(Landroid/net/Uri;)Ljava/io/InputStream;
            //    17: astore_1       
            //    18: aload_1        
            //    19: astore          5
            //    21: aload_1        
            //    22: astore          6
            //    24: new             Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;
            //    27: dup            
            //    28: aload_1        
            //    29: invokespecial   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.<init>:(Ljava/io/InputStream;)V
            //    32: invokevirtual   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.getOrientation:()I
            //    35: istore_3       
            //    36: iload_3        
            //    37: istore          4
            //    39: aload_1        
            //    40: ifnull          50
            //    43: aload_1        
            //    44: invokevirtual   java/io/InputStream.close:()V
            //    47: iload_3        
            //    48: istore          4
            //    50: iload           4
            //    52: ireturn        
            //    53: astore_1       
            //    54: aload           5
            //    56: astore          6
            //    58: ldc             "MediaStoreThumbFetcher"
            //    60: iconst_3       
            //    61: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
            //    64: ifeq            97
            //    67: aload           5
            //    69: astore          6
            //    71: ldc             "MediaStoreThumbFetcher"
            //    73: new             Ljava/lang/StringBuilder;
            //    76: dup            
            //    77: invokespecial   java/lang/StringBuilder.<init>:()V
            //    80: ldc             "Failed to open uri: "
            //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    85: aload_2        
            //    86: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //    89: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    92: aload_1        
            //    93: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //    96: pop            
            //    97: aload           5
            //    99: ifnull          50
            //   102: aload           5
            //   104: invokevirtual   java/io/InputStream.close:()V
            //   107: iconst_m1      
            //   108: ireturn        
            //   109: astore_1       
            //   110: iconst_m1      
            //   111: ireturn        
            //   112: astore_1       
            //   113: aload           6
            //   115: ifnull          123
            //   118: aload           6
            //   120: invokevirtual   java/io/InputStream.close:()V
            //   123: aload_1        
            //   124: athrow         
            //   125: astore_1       
            //   126: iload_3        
            //   127: ireturn        
            //   128: astore_2       
            //   129: goto            123
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  9      18     53     112    Ljava/io/IOException;
            //  9      18     112    125    Any
            //  24     36     53     112    Ljava/io/IOException;
            //  24     36     112    125    Any
            //  43     47     125    128    Ljava/io/IOException;
            //  58     67     112    125    Any
            //  71     97     112    125    Any
            //  102    107    109    112    Ljava/io/IOException;
            //  118    123    128    132    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index 73 out of bounds for length 73
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
        
        public InputStream open(final Context context, Uri thumbUri) throws FileNotFoundException {
            final Uri uri = null;
            InputStream openInputStream = null;
            final Cursor queryPath = this.query.queryPath(context, thumbUri);
            thumbUri = uri;
            Label_0046: {
                if (queryPath == null) {
                    break Label_0046;
                }
                thumbUri = uri;
                try {
                    if (queryPath.moveToFirst()) {
                        thumbUri = this.parseThumbUri(queryPath);
                    }
                    if (queryPath != null) {
                        queryPath.close();
                    }
                    if (thumbUri != null) {
                        openInputStream = context.getContentResolver().openInputStream(thumbUri);
                    }
                    return openInputStream;
                }
                finally {
                    if (queryPath != null) {
                        queryPath.close();
                    }
                }
            }
        }
    }
    
    static class ThumbnailStreamOpenerFactory
    {
        public ThumbnailStreamOpener build(final Uri uri, final int n, final int n2) {
            if (!isMediaStoreUri(uri) || n > 512 || n2 > 384) {
                return null;
            }
            if (isMediaStoreVideo(uri)) {
                return new ThumbnailStreamOpener(new VideoThumbnailQuery());
            }
            return new ThumbnailStreamOpener(new ImageThumbnailQuery());
        }
    }
    
    static class VideoThumbnailQuery implements ThumbnailQuery
    {
        private static final String[] PATH_PROJECTION;
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        
        static {
            PATH_PROJECTION = new String[] { "_data" };
        }
        
        @Override
        public Cursor queryPath(final Context context, final Uri uri) {
            return context.getContentResolver().query(MediaStore$Video$Thumbnails.EXTERNAL_CONTENT_URI, VideoThumbnailQuery.PATH_PROJECTION, "kind = 1 AND video_id = ?", new String[] { uri.getLastPathSegment() }, (String)null);
        }
    }
}
