// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.images;

import java.util.concurrent.CountDownLatch;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.content.Intent;
import android.os.ParcelFileDescriptor;
import android.os.Bundle;
import java.util.ArrayList;
import com.google.android.gms.common.annotation.KeepName;
import android.os.ResultReceiver;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzc;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.concurrent.Executors;
import android.os.Looper;
import java.util.Map;
import com.google.android.gms.internal.zzbfm;
import java.util.concurrent.ExecutorService;
import android.os.Handler;
import android.content.Context;
import android.net.Uri;
import java.util.HashSet;

public final class ImageManager
{
    private static final Object zzaFR;
    private static HashSet<Uri> zzaFS;
    private static ImageManager zzaFT;
    private final Context mContext;
    private final Handler mHandler;
    private final ExecutorService zzaFU;
    private final zza zzaFV;
    private final zzbfm zzaFW;
    private final Map<com.google.android.gms.common.images.zza, ImageReceiver> zzaFX;
    private final Map<Uri, ImageReceiver> zzaFY;
    private final Map<Uri, Long> zzaFZ;
    
    static {
        zzaFR = new Object();
        ImageManager.zzaFS = new HashSet<Uri>();
    }
    
    private ImageManager(final Context context, final boolean b) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzaFU = Executors.newFixedThreadPool(4);
        this.zzaFV = null;
        this.zzaFW = new zzbfm();
        this.zzaFX = new HashMap<com.google.android.gms.common.images.zza, ImageReceiver>();
        this.zzaFY = new HashMap<Uri, ImageReceiver>();
        this.zzaFZ = new HashMap<Uri, Long>();
    }
    
    public static ImageManager create(final Context context) {
        if (ImageManager.zzaFT == null) {
            ImageManager.zzaFT = new ImageManager(context, false);
        }
        return ImageManager.zzaFT;
    }
    
    private final Bitmap zza(final com.google.android.gms.common.images.zzb zzb) {
        if (this.zzaFV == null) {
            return null;
        }
        return this.zzaFV.get(zzb);
    }
    
    private final void zza(final com.google.android.gms.common.images.zza zza) {
        com.google.android.gms.common.internal.zzc.zzcz("ImageManager.loadImage() must be called in the main thread");
        new zzc(zza).run();
    }
    
    public final void loadImage(final ImageView imageView, final int n) {
        this.zza(new com.google.android.gms.common.images.zzc(imageView, n));
    }
    
    public final void loadImage(final ImageView imageView, final Uri uri) {
        this.zza(new com.google.android.gms.common.images.zzc(imageView, uri));
    }
    
    public final void loadImage(final ImageView imageView, final Uri uri, final int zzaGh) {
        final com.google.android.gms.common.images.zzc zzc = new com.google.android.gms.common.images.zzc(imageView, uri);
        zzc.zzaGh = zzaGh;
        this.zza(zzc);
    }
    
    public final void loadImage(final OnImageLoadedListener onImageLoadedListener, final Uri uri) {
        this.zza(new com.google.android.gms.common.images.zzd(onImageLoadedListener, uri));
    }
    
    public final void loadImage(final OnImageLoadedListener onImageLoadedListener, final Uri uri, final int zzaGh) {
        final com.google.android.gms.common.images.zzd zzd = new com.google.android.gms.common.images.zzd(onImageLoadedListener, uri);
        zzd.zzaGh = zzaGh;
        this.zza(zzd);
    }
    
    @KeepName
    final class ImageReceiver extends ResultReceiver
    {
        private final Uri mUri;
        private final ArrayList<com.google.android.gms.common.images.zza> zzaGa;
        
        ImageReceiver(final Uri mUri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = mUri;
            this.zzaGa = new ArrayList<com.google.android.gms.common.images.zza>();
        }
        
        public final void onReceiveResult(final int n, final Bundle bundle) {
            ImageManager.this.zzaFU.execute(new zzb(this.mUri, (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
        
        public final void zzb(final com.google.android.gms.common.images.zza e) {
            com.google.android.gms.common.internal.zzc.zzcz("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzaGa.add(e);
        }
        
        public final void zzc(final com.google.android.gms.common.images.zza o) {
            com.google.android.gms.common.internal.zzc.zzcz("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzaGa.remove(o);
        }
        
        public final void zzqV() {
            final Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", (Parcelable)this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", (Parcelable)this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }
    
    public interface OnImageLoadedListener
    {
        void onImageLoaded(final Uri p0, final Drawable p1, final boolean p2);
    }
    
    static final class zza extends LruCache<com.google.android.gms.common.images.zzb, Bitmap>
    {
    }
    
    final class zzb implements Runnable
    {
        private final Uri mUri;
        private final ParcelFileDescriptor zzaGc;
        
        public zzb(final Uri mUri, final ParcelFileDescriptor zzaGc) {
            this.mUri = mUri;
            this.zzaGc = zzaGc;
        }
        
        @Override
        public final void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: invokevirtual   android/os/Looper.getThread:()Ljava/lang/Thread;
            //     6: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
            //     9: if_acmpne       99
            //    12: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
            //    15: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //    18: astore_3       
            //    19: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
            //    22: invokevirtual   android/os/Looper.getThread:()Ljava/lang/Thread;
            //    25: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //    28: astore          4
            //    30: ldc             "Asserts"
            //    32: new             Ljava/lang/StringBuilder;
            //    35: dup            
            //    36: aload_3        
            //    37: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //    40: invokevirtual   java/lang/String.length:()I
            //    43: bipush          56
            //    45: iadd           
            //    46: aload           4
            //    48: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //    51: invokevirtual   java/lang/String.length:()I
            //    54: iadd           
            //    55: invokespecial   java/lang/StringBuilder.<init>:(I)V
            //    58: ldc             "checkNotMainThread: current thread "
            //    60: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    63: aload_3        
            //    64: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    67: ldc             " IS the main thread "
            //    69: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    72: aload           4
            //    74: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    77: ldc             "!"
            //    79: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    82: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    85: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
            //    88: pop            
            //    89: new             Ljava/lang/IllegalStateException;
            //    92: dup            
            //    93: ldc             "LoadBitmapFromDiskRunnable can't be executed in the main thread"
            //    95: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
            //    98: athrow         
            //    99: iconst_0       
            //   100: istore_1       
            //   101: iconst_0       
            //   102: istore_2       
            //   103: aconst_null    
            //   104: astore_3       
            //   105: aconst_null    
            //   106: astore          4
            //   108: aload_0        
            //   109: getfield        com/google/android/gms/common/images/ImageManager$zzb.zzaGc:Landroid/os/ParcelFileDescriptor;
            //   112: ifnull          135
            //   115: aload_0        
            //   116: getfield        com/google/android/gms/common/images/ImageManager$zzb.zzaGc:Landroid/os/ParcelFileDescriptor;
            //   119: invokevirtual   android/os/ParcelFileDescriptor.getFileDescriptor:()Ljava/io/FileDescriptor;
            //   122: invokestatic    android/graphics/BitmapFactory.decodeFileDescriptor:(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
            //   125: astore_3       
            //   126: iload_2        
            //   127: istore_1       
            //   128: aload_0        
            //   129: getfield        com/google/android/gms/common/images/ImageManager$zzb.zzaGc:Landroid/os/ParcelFileDescriptor;
            //   132: invokevirtual   android/os/ParcelFileDescriptor.close:()V
            //   135: new             Ljava/util/concurrent/CountDownLatch;
            //   138: dup            
            //   139: iconst_1       
            //   140: invokespecial   java/util/concurrent/CountDownLatch.<init>:(I)V
            //   143: astore          4
            //   145: aload_0        
            //   146: getfield        com/google/android/gms/common/images/ImageManager$zzb.zzaGb:Lcom/google/android/gms/common/images/ImageManager;
            //   149: invokestatic    com/google/android/gms/common/images/ImageManager.zzg:(Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
            //   152: new             Lcom/google/android/gms/common/images/ImageManager$zzd;
            //   155: dup            
            //   156: aload_0        
            //   157: getfield        com/google/android/gms/common/images/ImageManager$zzb.zzaGb:Lcom/google/android/gms/common/images/ImageManager;
            //   160: aload_0        
            //   161: getfield        com/google/android/gms/common/images/ImageManager$zzb.mUri:Landroid/net/Uri;
            //   164: aload_3        
            //   165: iload_1        
            //   166: aload           4
            //   168: invokespecial   com/google/android/gms/common/images/ImageManager$zzd.<init>:(Lcom/google/android/gms/common/images/ImageManager;Landroid/net/Uri;Landroid/graphics/Bitmap;ZLjava/util/concurrent/CountDownLatch;)V
            //   171: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
            //   174: pop            
            //   175: aload           4
            //   177: invokevirtual   java/util/concurrent/CountDownLatch.await:()V
            //   180: return         
            //   181: astore_3       
            //   182: aload_0        
            //   183: getfield        com/google/android/gms/common/images/ImageManager$zzb.mUri:Landroid/net/Uri;
            //   186: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   189: astore          5
            //   191: ldc             "ImageManager"
            //   193: new             Ljava/lang/StringBuilder;
            //   196: dup            
            //   197: aload           5
            //   199: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   202: invokevirtual   java/lang/String.length:()I
            //   205: bipush          34
            //   207: iadd           
            //   208: invokespecial   java/lang/StringBuilder.<init>:(I)V
            //   211: ldc             "OOM while loading bitmap for uri: "
            //   213: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   216: aload           5
            //   218: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   221: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   224: aload_3        
            //   225: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   228: pop            
            //   229: iconst_1       
            //   230: istore_1       
            //   231: aload           4
            //   233: astore_3       
            //   234: goto            128
            //   237: astore          4
            //   239: ldc             "ImageManager"
            //   241: ldc             "closed failed"
            //   243: aload           4
            //   245: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   248: pop            
            //   249: goto            135
            //   252: astore_3       
            //   253: aload_0        
            //   254: getfield        com/google/android/gms/common/images/ImageManager$zzb.mUri:Landroid/net/Uri;
            //   257: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   260: astore_3       
            //   261: ldc             "ImageManager"
            //   263: new             Ljava/lang/StringBuilder;
            //   266: dup            
            //   267: aload_3        
            //   268: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   271: invokevirtual   java/lang/String.length:()I
            //   274: bipush          32
            //   276: iadd           
            //   277: invokespecial   java/lang/StringBuilder.<init>:(I)V
            //   280: ldc             "Latch interrupted while posting "
            //   282: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   285: aload_3        
            //   286: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   289: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   292: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
            //   295: pop            
            //   296: return         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                            
            //  -----  -----  -----  -----  --------------------------------
            //  115    126    181    237    Ljava/lang/OutOfMemoryError;
            //  128    135    237    252    Ljava/io/IOException;
            //  175    180    252    297    Ljava/lang/InterruptedException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index 142 out of bounds for length 142
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
    
    final class zzc implements Runnable
    {
        private final com.google.android.gms.common.images.zza zzaGd;
        
        public zzc(final com.google.android.gms.common.images.zza zzaGd) {
            this.zzaGd = zzaGd;
        }
        
        @Override
        public final void run() {
            com.google.android.gms.common.internal.zzc.zzcz("LoadImageRunnable must be executed on the main thread");
            final ImageReceiver imageReceiver = ImageManager.this.zzaFX.get(this.zzaGd);
            if (imageReceiver != null) {
                ImageManager.this.zzaFX.remove(this.zzaGd);
                imageReceiver.zzc(this.zzaGd);
            }
            final com.google.android.gms.common.images.zzb zzaGf = this.zzaGd.zzaGf;
            if (zzaGf.uri == null) {
                this.zzaGd.zza(ImageManager.this.mContext, ImageManager.this.zzaFW, true);
                return;
            }
            final Bitmap zza = ImageManager.this.zza(zzaGf);
            if (zza != null) {
                this.zzaGd.zza(ImageManager.this.mContext, zza, true);
                return;
            }
            final Long n = ImageManager.this.zzaFZ.get(zzaGf.uri);
            if (n != null) {
                if (SystemClock.elapsedRealtime() - n < 3600000L) {
                    this.zzaGd.zza(ImageManager.this.mContext, ImageManager.this.zzaFW, true);
                    return;
                }
                ImageManager.this.zzaFZ.remove(zzaGf.uri);
            }
            this.zzaGd.zza(ImageManager.this.mContext, ImageManager.this.zzaFW);
            ResultReceiver resultReceiver;
            if ((resultReceiver = ImageManager.this.zzaFY.get(zzaGf.uri)) == null) {
                resultReceiver = new ImageReceiver(zzaGf.uri);
                ImageManager.this.zzaFY.put(zzaGf.uri, resultReceiver);
            }
            ((ImageReceiver)resultReceiver).zzb(this.zzaGd);
            if (!(this.zzaGd instanceof com.google.android.gms.common.images.zzd)) {
                ImageManager.this.zzaFX.put(this.zzaGd, resultReceiver);
            }
            synchronized (ImageManager.zzaFR) {
                if (!ImageManager.zzaFS.contains(zzaGf.uri)) {
                    ImageManager.zzaFS.add(zzaGf.uri);
                    ((ImageReceiver)resultReceiver).zzqV();
                }
            }
        }
    }
    
    final class zzd implements Runnable
    {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzaGe;
        private final CountDownLatch zztJ;
        
        public zzd(final Uri mUri, final Bitmap mBitmap, final boolean zzaGe, final CountDownLatch zztJ) {
            this.mUri = mUri;
            this.mBitmap = mBitmap;
            this.zzaGe = zzaGe;
            this.zztJ = zztJ;
        }
        
        @Override
        public final void run() {
            com.google.android.gms.common.internal.zzc.zzcz("OnBitmapLoadedRunnable must be executed in the main thread");
            final boolean b = this.mBitmap != null;
            if (ImageManager.this.zzaFV != null) {
                if (this.zzaGe) {
                    ImageManager.this.zzaFV.evictAll();
                    System.gc();
                    this.zzaGe = false;
                    ImageManager.this.mHandler.post((Runnable)this);
                    return;
                }
                if (b) {
                    ImageManager.this.zzaFV.put(new com.google.android.gms.common.images.zzb(this.mUri), this.mBitmap);
                }
            }
            final ImageReceiver imageReceiver = ImageManager.this.zzaFY.remove(this.mUri);
            if (imageReceiver != null) {
                final ArrayList zza = imageReceiver.zzaGa;
                for (int size = zza.size(), i = 0; i < size; ++i) {
                    final com.google.android.gms.common.images.zza zza2 = zza.get(i);
                    if (b) {
                        zza2.zza(ImageManager.this.mContext, this.mBitmap, false);
                    }
                    else {
                        ImageManager.this.zzaFZ.put(this.mUri, SystemClock.elapsedRealtime());
                        zza2.zza(ImageManager.this.mContext, ImageManager.this.zzaFW, false);
                    }
                    if (!(zza2 instanceof com.google.android.gms.common.images.zzd)) {
                        ImageManager.this.zzaFX.remove(zza2);
                    }
                }
            }
            this.zztJ.countDown();
            synchronized (ImageManager.zzaFR) {
                ImageManager.zzaFS.remove(this.mUri);
            }
        }
    }
}
