// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.ads.identifier;

import java.util.concurrent.CountDownLatch;
import java.lang.ref.WeakReference;
import android.os.RemoteException;
import android.content.ServiceConnection;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.zze;
import java.util.Iterator;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.zzfe;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzfd;
import com.google.android.gms.common.zza;
import android.support.annotation.Nullable;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;

@KeepForSdkWithMembers
public class AdvertisingIdClient
{
    private final Context mContext;
    private Object zzsA;
    @Nullable
    private zza zzsB;
    private long zzsC;
    @Nullable
    private com.google.android.gms.common.zza zzsx;
    @Nullable
    private zzfd zzsy;
    private boolean zzsz;
    
    public AdvertisingIdClient(final Context context) {
        this(context, 30000L, false);
    }
    
    public AdvertisingIdClient(Context context, final long zzsC, final boolean b) {
        this.zzsA = new Object();
        zzbo.zzu(context);
        if (b) {
            final Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.mContext = context;
        }
        else {
            this.mContext = context;
        }
        this.zzsz = false;
        this.zzsC = zzsC;
    }
    
    @Nullable
    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        final float n = 0.0f;
        final boolean b = false;
        final boolean b2 = false;
        boolean boolean1 = b;
        float float1;
        while (true) {
            try {
                final Context remoteContext = zzo.getRemoteContext(context);
                float1 = n;
                boolean1 = b2;
                if (remoteContext != null) {
                    boolean1 = b;
                    final SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
                    boolean1 = b;
                    final boolean b3 = boolean1 = sharedPreferences.getBoolean("gads:ad_id_app_context:enabled", (boolean)(0 != 0));
                    float1 = sharedPreferences.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
                    boolean1 = b3;
                }
                final Object o;
                context = (Context)(o = new AdvertisingIdClient(context, -1L, boolean1));
                final boolean b4 = false;
                ((AdvertisingIdClient)o).start(b4);
                final Context context2 = context;
                final Info info = ((AdvertisingIdClient)context2).getInfo();
                final Context context3 = context;
                final Info info2 = info;
                final boolean b5 = boolean1;
                final float n2 = float1;
                final Throwable t = null;
                ((AdvertisingIdClient)context3).zza(info2, b5, n2, t);
                return info;
            }
            catch (Exception ex) {
                Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", (Throwable)ex);
                float1 = n;
                continue;
            }
            break;
        }
        try {
            final Object o = context;
            final boolean b4 = false;
            ((AdvertisingIdClient)o).start(b4);
            final Context context2 = context;
            final Info info = ((AdvertisingIdClient)context2).getInfo();
            final Context context3 = context;
            final Info info2 = info;
            final boolean b5 = boolean1;
            final float n2 = float1;
            final Throwable t = null;
            ((AdvertisingIdClient)context3).zza(info2, b5, n2, t);
            return info;
        }
        catch (Throwable t2) {
            ((AdvertisingIdClient)context).zza(null, boolean1, float1, t2);
            return null;
        }
        finally {
            ((AdvertisingIdClient)context).finish();
        }
    }
    
    public static void setShouldSkipGmsCoreVersionCheck(final boolean b) {
    }
    
    private final void start(final boolean b) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzbo.zzcG("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzsz) {
                this.finish();
            }
            this.zzsx = zzd(this.mContext);
            this.zzsy = zza(this.mContext, this.zzsx);
            this.zzsz = true;
            if (b) {
                this.zzaj();
            }
        }
    }
    
    private static zzfd zza(final Context context, final com.google.android.gms.common.zza zza) throws IOException {
        try {
            return zzfe.zzc(zza.zza(10000L, TimeUnit.MILLISECONDS));
        }
        catch (InterruptedException ex) {
            throw new IOException("Interrupted exception");
        }
        catch (Throwable cause) {
            throw new IOException(cause);
        }
    }
    
    private final void zza(final Info info, final boolean b, final float n, final Throwable t) {
        if (Math.random() > n) {
            return;
        }
        final Bundle bundle = new Bundle();
        String s;
        if (b) {
            s = "1";
        }
        else {
            s = "0";
        }
        bundle.putString("app_context", s);
        if (info != null) {
            String s2;
            if (info.isLimitAdTrackingEnabled()) {
                s2 = "1";
            }
            else {
                s2 = "0";
            }
            bundle.putString("limit_ad_tracking", s2);
        }
        if (info != null && info.getId() != null) {
            bundle.putString("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (t != null) {
            bundle.putString("error", t.getClass().getName());
        }
        final Uri$Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (final String s3 : bundle.keySet()) {
            buildUpon.appendQueryParameter(s3, bundle.getString(s3));
        }
        new com.google.android.gms.ads.identifier.zza(this, buildUpon.build().toString()).start();
    }
    
    private final void zzaj() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsA:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsB:Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
        //    11: ifnull          31
        //    14: aload_0        
        //    15: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsB:Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
        //    18: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.zzsG:Ljava/util/concurrent/CountDownLatch;
        //    21: invokevirtual   java/util/concurrent/CountDownLatch.countDown:()V
        //    24: aload_0        
        //    25: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsB:Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
        //    28: invokevirtual   com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.join:()V
        //    31: aload_0        
        //    32: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsC:J
        //    35: lconst_0       
        //    36: lcmp           
        //    37: ifle            56
        //    40: aload_0        
        //    41: new             Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
        //    44: dup            
        //    45: aload_0        
        //    46: aload_0        
        //    47: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsC:J
        //    50: invokespecial   com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.<init>:(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;J)V
        //    53: putfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsB:Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
        //    56: aload_1        
        //    57: monitorexit    
        //    58: return         
        //    59: astore_2       
        //    60: aload_1        
        //    61: monitorexit    
        //    62: aload_2        
        //    63: athrow         
        //    64: astore_2       
        //    65: goto            31
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  7      24     59     64     Any
        //  24     31     64     68     Ljava/lang/InterruptedException;
        //  24     31     59     64     Any
        //  31     56     59     64     Any
        //  56     58     59     64     Any
        //  60     62     59     64     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0031:
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
    
    private static com.google.android.gms.common.zza zzd(final Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (zze.zzoW().isGooglePlayServicesAvailable(context)) {
                default: {
                    throw new IOException("Google Play services not available");
                }
                case 0:
                case 2: {
                    break;
                }
            }
        }
        catch (PackageManager$NameNotFoundException ex) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
        final com.google.android.gms.common.zza zza = new com.google.android.gms.common.zza();
        final Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (com.google.android.gms.common.stats.zza.zzrU().zza(context, intent, (ServiceConnection)zza, 1)) {
                return zza;
            }
        }
        catch (Throwable cause) {
            throw new IOException(cause);
        }
        throw new IOException("Connection failure");
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.finish();
        super.finalize();
    }
    
    public void finish() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    com/google/android/gms/common/internal/zzbo.zzcG:(Ljava/lang/String;)V
        //     5: aload_0        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.mContext:Landroid/content/Context;
        //    11: ifnull          21
        //    14: aload_0        
        //    15: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsx:Lcom/google/android/gms/common/zza;
        //    18: ifnonnull       24
        //    21: aload_0        
        //    22: monitorexit    
        //    23: return         
        //    24: aload_0        
        //    25: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsz:Z
        //    28: ifeq            46
        //    31: invokestatic    com/google/android/gms/common/stats/zza.zzrU:()Lcom/google/android/gms/common/stats/zza;
        //    34: pop            
        //    35: aload_0        
        //    36: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.mContext:Landroid/content/Context;
        //    39: aload_0        
        //    40: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsx:Lcom/google/android/gms/common/zza;
        //    43: invokevirtual   android/content/Context.unbindService:(Landroid/content/ServiceConnection;)V
        //    46: aload_0        
        //    47: iconst_0       
        //    48: putfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsz:Z
        //    51: aload_0        
        //    52: aconst_null    
        //    53: putfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsy:Lcom/google/android/gms/internal/zzfd;
        //    56: aload_0        
        //    57: aconst_null    
        //    58: putfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.zzsx:Lcom/google/android/gms/common/zza;
        //    61: aload_0        
        //    62: monitorexit    
        //    63: return         
        //    64: astore_1       
        //    65: aload_0        
        //    66: monitorexit    
        //    67: aload_1        
        //    68: athrow         
        //    69: astore_1       
        //    70: ldc             "AdvertisingIdClient"
        //    72: ldc_w           "AdvertisingIdClient unbindService failed."
        //    75: aload_1        
        //    76: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    79: pop            
        //    80: goto            46
        //    83: astore_1       
        //    84: ldc             "AdvertisingIdClient"
        //    86: ldc_w           "AdvertisingIdClient unbindService failed."
        //    89: aload_1        
        //    90: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    93: pop            
        //    94: goto            46
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  7      21     64     69     Any
        //  21     23     64     69     Any
        //  24     46     69     83     Ljava/lang/IllegalArgumentException;
        //  24     46     83     97     Ljava/lang/Throwable;
        //  24     46     64     69     Any
        //  46     63     64     69     Any
        //  65     67     64     69     Any
        //  70     80     64     69     Any
        //  84     94     64     69     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0024:
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
    
    public Info getInfo() throws IOException {
        zzbo.zzcG("Calling this from your main thread can lead to deadlock");
        // monitorexit(t)
        Label_0097: {
            synchronized (this) {
                if (this.zzsz) {
                    break Label_0097;
                }
                synchronized (this.zzsA) {
                    if (this.zzsB == null || !this.zzsB.zzsH) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
            }
            try {
                this.start(false);
                if (!this.zzsz) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.");
                }
            }
            catch (Exception cause) {
                throw new IOException("AdvertisingIdClient cannot reconnect.", cause);
            }
        }
        zzbo.zzu(this.zzsx);
        zzbo.zzu(this.zzsy);
        try {
            final Info info = new Info(this.zzsy.getId(), this.zzsy.zzb(true));
            // monitorexit(this)
            this.zzaj();
            return info;
        }
        catch (RemoteException ex) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", (Throwable)ex);
            throw new IOException("Remote exception");
        }
    }
    
    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        this.start(true);
    }
    
    public static final class Info
    {
        private final String zzsI;
        private final boolean zzsJ;
        
        public Info(final String zzsI, final boolean zzsJ) {
            this.zzsI = zzsI;
            this.zzsJ = zzsJ;
        }
        
        public final String getId() {
            return this.zzsI;
        }
        
        public final boolean isLimitAdTrackingEnabled() {
            return this.zzsJ;
        }
        
        @Override
        public final String toString() {
            final String zzsI = this.zzsI;
            return new StringBuilder(String.valueOf(zzsI).length() + 7).append("{").append(zzsI).append("}").append(this.zzsJ).toString();
        }
    }
    
    static final class zza extends Thread
    {
        private WeakReference<AdvertisingIdClient> zzsE;
        private long zzsF;
        CountDownLatch zzsG;
        boolean zzsH;
        
        public zza(final AdvertisingIdClient referent, final long zzsF) {
            this.zzsE = new WeakReference<AdvertisingIdClient>(referent);
            this.zzsF = zzsF;
            this.zzsG = new CountDownLatch(1);
            this.zzsH = false;
            this.start();
        }
        
        private final void disconnect() {
            final AdvertisingIdClient advertisingIdClient = this.zzsE.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzsH = true;
            }
        }
        
        @Override
        public final void run() {
            try {
                if (!this.zzsG.await(this.zzsF, TimeUnit.MILLISECONDS)) {
                    this.disconnect();
                }
            }
            catch (InterruptedException ex) {
                this.disconnect();
            }
        }
    }
}
