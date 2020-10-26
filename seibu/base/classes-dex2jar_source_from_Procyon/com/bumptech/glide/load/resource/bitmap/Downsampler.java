// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap$Config;
import android.os.Build$VERSION;
import java.io.IOException;
import android.util.Log;
import android.graphics.Rect;
import android.graphics.BitmapFactory;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.util.EnumSet;
import java.util.Set;
import android.graphics.BitmapFactory$Options;
import java.util.Queue;
import java.io.InputStream;

public abstract class Downsampler implements BitmapDecoder<InputStream>
{
    public static final Downsampler AT_LEAST;
    public static final Downsampler AT_MOST;
    private static final int MARK_POSITION = 5242880;
    public static final Downsampler NONE;
    private static final Queue<BitmapFactory$Options> OPTIONS_QUEUE;
    private static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL;
    
    static {
        TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
        OPTIONS_QUEUE = Util.createQueue(0);
        AT_LEAST = new Downsampler() {
            @Override
            public String getId() {
                return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
            }
            
            @Override
            protected int getSampleSize(final int n, final int n2, final int n3, final int n4) {
                return Math.min(n2 / n4, n / n3);
            }
        };
        AT_MOST = new Downsampler() {
            @Override
            public String getId() {
                return "AT_MOST.com.bumptech.glide.load.data.bitmap";
            }
            
            @Override
            protected int getSampleSize(int i, int max, final int n, final int n2) {
                final int n3 = 1;
                i = (int)Math.ceil(Math.max(max / (float)n2, i / (float)n));
                max = Math.max(1, Integer.highestOneBit(i));
                if (max < i) {
                    i = n3;
                }
                else {
                    i = 0;
                }
                return max << i;
            }
        };
        NONE = new Downsampler() {
            @Override
            public String getId() {
                return "NONE.com.bumptech.glide.load.data.bitmap";
            }
            
            @Override
            protected int getSampleSize(final int n, final int n2, final int n3, final int n4) {
                return 0;
            }
        };
    }
    
    private static Bitmap decodeStream(final MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream decodeStream, final BitmapFactory$Options bitmapFactory$Options) {
        Label_0033: {
            if (!bitmapFactory$Options.inJustDecodeBounds) {
                break Label_0033;
            }
            markEnforcingInputStream.mark(5242880);
            while (true) {
                decodeStream = (RecyclableBufferedInputStream)BitmapFactory.decodeStream((InputStream)markEnforcingInputStream, (Rect)null, bitmapFactory$Options);
                try {
                    if (bitmapFactory$Options.inJustDecodeBounds) {
                        markEnforcingInputStream.reset();
                    }
                    return (Bitmap)decodeStream;
                    decodeStream.fixMarkLimit();
                }
                catch (IOException ex) {
                    if (Log.isLoggable("Downsampler", 6)) {
                        Log.e("Downsampler", "Exception loading inDecodeBounds=" + bitmapFactory$Options.inJustDecodeBounds + " sample=" + bitmapFactory$Options.inSampleSize, (Throwable)ex);
                        return (Bitmap)decodeStream;
                    }
                    return (Bitmap)decodeStream;
                }
            }
        }
    }
    
    private Bitmap downsampleWithSize(final MarkEnforcingInputStream markEnforcingInputStream, final RecyclableBufferedInputStream recyclableBufferedInputStream, final BitmapFactory$Options bitmapFactory$Options, final BitmapPool bitmapPool, final int n, final int n2, final int inSampleSize, final DecodeFormat decodeFormat) {
        final Bitmap$Config config = getConfig(markEnforcingInputStream, decodeFormat);
        bitmapFactory$Options.inSampleSize = inSampleSize;
        bitmapFactory$Options.inPreferredConfig = config;
        if ((bitmapFactory$Options.inSampleSize == 1 || 19 <= Build$VERSION.SDK_INT) && shouldUsePool(markEnforcingInputStream)) {
            setInBitmap(bitmapFactory$Options, bitmapPool.getDirty((int)Math.ceil(n / (double)inSampleSize), (int)Math.ceil(n2 / (double)inSampleSize), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, bitmapFactory$Options);
    }
    
    private static Bitmap$Config getConfig(final InputStream ex, final DecodeFormat obj) {
        if (obj == DecodeFormat.ALWAYS_ARGB_8888 || obj == DecodeFormat.PREFER_ARGB_8888 || Build$VERSION.SDK_INT == 16) {
            return Bitmap$Config.ARGB_8888;
        }
        boolean hasAlpha = false;
        ((InputStream)ex).mark(1024);
        while (true) {
            try {
                hasAlpha = new ImageHeaderParser((InputStream)ex).hasAlpha();
                try {
                    ((InputStream)ex).reset();
                    final int n = hasAlpha ? 1 : 0;
                    if (n != 0) {
                        return Bitmap$Config.ARGB_8888;
                    }
                    return Bitmap$Config.RGB_565;
                }
                catch (IOException ex) {
                    int n = hasAlpha ? 1 : 0;
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", (Throwable)ex);
                        n = (hasAlpha ? 1 : 0);
                    }
                    continue;
                }
            }
            catch (IOException ex2) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine whether the image has alpha or not from header for format " + obj, (Throwable)ex2);
                }
                try {
                    ((InputStream)ex).reset();
                    final int n = hasAlpha ? 1 : 0;
                    continue;
                }
                catch (IOException ex) {
                    int n = hasAlpha ? 1 : 0;
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", (Throwable)ex);
                        n = (hasAlpha ? 1 : 0);
                        continue;
                    }
                    continue;
                }
                continue;
            }
            finally {
                try {
                    ((InputStream)ex).reset();
                }
                catch (IOException ex3) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", (Throwable)ex3);
                    }
                }
            }
            break;
        }
        return Bitmap$Config.RGB_565;
    }
    
    @TargetApi(11)
    private static BitmapFactory$Options getDefaultOptions() {
        synchronized (Downsampler.class) {
            Object options_QUEUE = Downsampler.OPTIONS_QUEUE;
            synchronized (options_QUEUE) {
                final BitmapFactory$Options bitmapFactory$Options = Downsampler.OPTIONS_QUEUE.poll();
                // monitorexit(options_QUEUE)
                options_QUEUE = bitmapFactory$Options;
                if (bitmapFactory$Options == null) {
                    options_QUEUE = new BitmapFactory$Options();
                    resetOptions((BitmapFactory$Options)options_QUEUE);
                }
                return (BitmapFactory$Options)options_QUEUE;
            }
        }
    }
    
    private int getRoundedSampleSize(int n, final int n2, final int n3, int n4, int n5) {
        if (n5 == Integer.MIN_VALUE) {
            n5 = n3;
        }
        if (n4 == Integer.MIN_VALUE) {
            n4 = n2;
        }
        if (n == 90 || n == 270) {
            n = this.getSampleSize(n3, n2, n4, n5);
        }
        else {
            n = this.getSampleSize(n2, n3, n4, n5);
        }
        if (n == 0) {
            n = 0;
        }
        else {
            n = Integer.highestOneBit(n);
        }
        return Math.max(1, n);
    }
    
    private static void releaseOptions(final BitmapFactory$Options bitmapFactory$Options) {
        resetOptions(bitmapFactory$Options);
        synchronized (Downsampler.OPTIONS_QUEUE) {
            Downsampler.OPTIONS_QUEUE.offer(bitmapFactory$Options);
        }
    }
    
    @TargetApi(11)
    private static void resetOptions(final BitmapFactory$Options bitmapFactory$Options) {
        bitmapFactory$Options.inTempStorage = null;
        bitmapFactory$Options.inDither = false;
        bitmapFactory$Options.inScaled = false;
        bitmapFactory$Options.inSampleSize = 1;
        bitmapFactory$Options.inPreferredConfig = null;
        bitmapFactory$Options.inJustDecodeBounds = false;
        bitmapFactory$Options.outWidth = 0;
        bitmapFactory$Options.outHeight = 0;
        bitmapFactory$Options.outMimeType = null;
        if (11 <= Build$VERSION.SDK_INT) {
            bitmapFactory$Options.inBitmap = null;
            bitmapFactory$Options.inMutable = true;
        }
    }
    
    @TargetApi(11)
    private static void setInBitmap(final BitmapFactory$Options bitmapFactory$Options, final Bitmap inBitmap) {
        if (11 <= Build$VERSION.SDK_INT) {
            bitmapFactory$Options.inBitmap = inBitmap;
        }
    }
    
    private static boolean shouldUsePool(final InputStream ex) {
        boolean b;
        if (19 <= Build$VERSION.SDK_INT) {
            b = true;
        }
        else {
            ((InputStream)ex).mark(1024);
            try {
                final boolean contains = Downsampler.TYPES_THAT_USE_POOL.contains(new ImageHeaderParser((InputStream)ex).getType());
                try {
                    ((InputStream)ex).reset();
                    return contains;
                }
                catch (IOException ex) {
                    b = contains;
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", (Throwable)ex);
                        return contains;
                    }
                    return b;
                }
            }
            catch (IOException ex2) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine the image type from header", (Throwable)ex2);
                }
                try {
                    ((InputStream)ex).reset();
                    return false;
                }
                catch (IOException ex) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", (Throwable)ex);
                        return false;
                    }
                    return false;
                }
            }
            finally {
                try {
                    ((InputStream)ex).reset();
                }
                catch (IOException ex3) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", (Throwable)ex3);
                    }
                }
            }
        }
        return b;
    }
    
    @Override
    public Bitmap decode(final InputStream p0, final BitmapPool p1, final int p2, final int p3, final DecodeFormat p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore          9
        //     5: aload           9
        //     7: invokevirtual   com/bumptech/glide/util/ByteArrayPool.getBytes:()[B
        //    10: astore          10
        //    12: aload           9
        //    14: invokevirtual   com/bumptech/glide/util/ByteArrayPool.getBytes:()[B
        //    17: astore          11
        //    19: invokestatic    com/bumptech/glide/load/resource/bitmap/Downsampler.getDefaultOptions:()Landroid/graphics/BitmapFactory$Options;
        //    22: astore          12
        //    24: new             Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;
        //    27: dup            
        //    28: aload_1        
        //    29: aload           11
        //    31: invokespecial   com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.<init>:(Ljava/io/InputStream;[B)V
        //    34: astore_1       
        //    35: aload_1        
        //    36: invokestatic    com/bumptech/glide/util/ExceptionCatchingInputStream.obtain:(Ljava/io/InputStream;)Lcom/bumptech/glide/util/ExceptionCatchingInputStream;
        //    39: astore          13
        //    41: new             Lcom/bumptech/glide/util/MarkEnforcingInputStream;
        //    44: dup            
        //    45: aload           13
        //    47: invokespecial   com/bumptech/glide/util/MarkEnforcingInputStream.<init>:(Ljava/io/InputStream;)V
        //    50: astore          14
        //    52: aload           13
        //    54: ldc             5242880
        //    56: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.mark:(I)V
        //    59: iconst_0       
        //    60: istore          7
        //    62: new             Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser;
        //    65: dup            
        //    66: aload           13
        //    68: invokespecial   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.<init>:(Ljava/io/InputStream;)V
        //    71: invokevirtual   com/bumptech/glide/load/resource/bitmap/ImageHeaderParser.getOrientation:()I
        //    74: istore          6
        //    76: iload           6
        //    78: istore          7
        //    80: aload           13
        //    82: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.reset:()V
        //    85: iload           7
        //    87: istore          6
        //    89: aload           12
        //    91: aload           10
        //    93: putfield        android/graphics/BitmapFactory$Options.inTempStorage:[B
        //    96: aload_0        
        //    97: aload           14
        //    99: aload_1        
        //   100: aload           12
        //   102: invokevirtual   com/bumptech/glide/load/resource/bitmap/Downsampler.getDimensions:(Lcom/bumptech/glide/util/MarkEnforcingInputStream;Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;)[I
        //   105: astore          15
        //   107: aload           15
        //   109: iconst_0       
        //   110: iaload         
        //   111: istore          7
        //   113: aload           15
        //   115: iconst_1       
        //   116: iaload         
        //   117: istore          8
        //   119: aload_0        
        //   120: aload           14
        //   122: aload_1        
        //   123: aload           12
        //   125: aload_2        
        //   126: iload           7
        //   128: iload           8
        //   130: aload_0        
        //   131: iload           6
        //   133: invokestatic    com/bumptech/glide/load/resource/bitmap/TransformationUtils.getExifOrientationDegrees:(I)I
        //   136: iload           7
        //   138: iload           8
        //   140: iload_3        
        //   141: iload           4
        //   143: invokespecial   com/bumptech/glide/load/resource/bitmap/Downsampler.getRoundedSampleSize:(IIIII)I
        //   146: aload           5
        //   148: invokespecial   com/bumptech/glide/load/resource/bitmap/Downsampler.downsampleWithSize:(Lcom/bumptech/glide/util/MarkEnforcingInputStream;Lcom/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream;Landroid/graphics/BitmapFactory$Options;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;IIILcom/bumptech/glide/load/DecodeFormat;)Landroid/graphics/Bitmap;
        //   151: astore          14
        //   153: aload           13
        //   155: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.getException:()Ljava/io/IOException;
        //   158: astore_1       
        //   159: aload_1        
        //   160: ifnull          329
        //   163: new             Ljava/lang/RuntimeException;
        //   166: dup            
        //   167: aload_1        
        //   168: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   171: athrow         
        //   172: astore_1       
        //   173: aload           9
        //   175: aload           10
        //   177: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   180: pop            
        //   181: aload           9
        //   183: aload           11
        //   185: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   188: pop            
        //   189: aload           13
        //   191: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.release:()V
        //   194: aload           12
        //   196: invokestatic    com/bumptech/glide/load/resource/bitmap/Downsampler.releaseOptions:(Landroid/graphics/BitmapFactory$Options;)V
        //   199: aload_1        
        //   200: athrow         
        //   201: astore          15
        //   203: iload           7
        //   205: istore          6
        //   207: ldc             "Downsampler"
        //   209: iconst_5       
        //   210: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   213: ifeq            89
        //   216: ldc             "Downsampler"
        //   218: ldc             "Cannot reset the input stream"
        //   220: aload           15
        //   222: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   225: pop            
        //   226: iload           7
        //   228: istore          6
        //   230: goto            89
        //   233: astore          15
        //   235: ldc             "Downsampler"
        //   237: iconst_5       
        //   238: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   241: ifeq            255
        //   244: ldc             "Downsampler"
        //   246: ldc_w           "Cannot determine the image orientation from header"
        //   249: aload           15
        //   251: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   254: pop            
        //   255: aload           13
        //   257: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.reset:()V
        //   260: iload           7
        //   262: istore          6
        //   264: goto            89
        //   267: astore          15
        //   269: iload           7
        //   271: istore          6
        //   273: ldc             "Downsampler"
        //   275: iconst_5       
        //   276: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   279: ifeq            89
        //   282: ldc             "Downsampler"
        //   284: ldc             "Cannot reset the input stream"
        //   286: aload           15
        //   288: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   291: pop            
        //   292: iload           7
        //   294: istore          6
        //   296: goto            89
        //   299: astore_1       
        //   300: aload           13
        //   302: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.reset:()V
        //   305: aload_1        
        //   306: athrow         
        //   307: astore_2       
        //   308: ldc             "Downsampler"
        //   310: iconst_5       
        //   311: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   314: ifeq            305
        //   317: ldc             "Downsampler"
        //   319: ldc             "Cannot reset the input stream"
        //   321: aload_2        
        //   322: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   325: pop            
        //   326: goto            305
        //   329: aconst_null    
        //   330: astore_1       
        //   331: aload           14
        //   333: ifnull          381
        //   336: aload           14
        //   338: aload_2        
        //   339: iload           6
        //   341: invokestatic    com/bumptech/glide/load/resource/bitmap/TransformationUtils.rotateImageExif:(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;I)Landroid/graphics/Bitmap;
        //   344: astore          5
        //   346: aload           5
        //   348: astore_1       
        //   349: aload           14
        //   351: aload           5
        //   353: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   356: ifne            381
        //   359: aload           5
        //   361: astore_1       
        //   362: aload_2        
        //   363: aload           14
        //   365: invokeinterface com/bumptech/glide/load/engine/bitmap_recycle/BitmapPool.put:(Landroid/graphics/Bitmap;)Z
        //   370: ifne            381
        //   373: aload           14
        //   375: invokevirtual   android/graphics/Bitmap.recycle:()V
        //   378: aload           5
        //   380: astore_1       
        //   381: aload           9
        //   383: aload           10
        //   385: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   388: pop            
        //   389: aload           9
        //   391: aload           11
        //   393: invokevirtual   com/bumptech/glide/util/ByteArrayPool.releaseBytes:([B)Z
        //   396: pop            
        //   397: aload           13
        //   399: invokevirtual   com/bumptech/glide/util/ExceptionCatchingInputStream.release:()V
        //   402: aload           12
        //   404: invokestatic    com/bumptech/glide/load/resource/bitmap/Downsampler.releaseOptions:(Landroid/graphics/BitmapFactory$Options;)V
        //   407: aload_1        
        //   408: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  52     59     172    201    Any
        //  62     76     233    299    Ljava/io/IOException;
        //  62     76     299    329    Any
        //  80     85     201    233    Ljava/io/IOException;
        //  80     85     172    201    Any
        //  89     107    172    201    Any
        //  119    159    172    201    Any
        //  163    172    172    201    Any
        //  207    226    172    201    Any
        //  235    255    299    329    Any
        //  255    260    267    299    Ljava/io/IOException;
        //  255    260    172    201    Any
        //  273    292    172    201    Any
        //  300    305    307    329    Ljava/io/IOException;
        //  300    305    172    201    Any
        //  305    307    172    201    Any
        //  308    326    172    201    Any
        //  336    346    172    201    Any
        //  349    359    172    201    Any
        //  362    378    172    201    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0089:
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
    
    public int[] getDimensions(final MarkEnforcingInputStream markEnforcingInputStream, final RecyclableBufferedInputStream recyclableBufferedInputStream, final BitmapFactory$Options bitmapFactory$Options) {
        bitmapFactory$Options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, bitmapFactory$Options);
        bitmapFactory$Options.inJustDecodeBounds = false;
        return new int[] { bitmapFactory$Options.outWidth, bitmapFactory$Options.outHeight };
    }
    
    protected abstract int getSampleSize(final int p0, final int p1, final int p2, final int p3);
}
