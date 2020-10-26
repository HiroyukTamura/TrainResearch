// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.Iterator;
import android.os.UserManager;
import android.content.pm.PackageInstaller$SessionInfo;
import com.google.android.gms.common.util.zzq;
import android.annotation.TargetApi;
import com.google.android.gms.common.util.zzw;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.android.gms.internal.zzbha;
import android.app.NotificationManager;
import android.content.Intent;
import android.util.Log;
import android.content.res.Resources;
import android.content.pm.PackageManager$NameNotFoundException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import android.net.Uri;
import android.net.Uri$Builder;
import android.app.PendingIntent;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzo
{
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    private static boolean zzaAo;
    private static boolean zzaAp;
    private static boolean zzaAq;
    private static boolean zzaAr;
    static final AtomicBoolean zzaAs;
    private static final AtomicBoolean zzaAt;
    
    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = 11020000;
        zzo.zzaAo = false;
        zzo.zzaAp = false;
        zzo.zzaAq = false;
        zzo.zzaAr = false;
        zzaAs = new AtomicBoolean();
        zzaAt = new AtomicBoolean();
    }
    
    zzo() {
    }
    
    @Deprecated
    public static PendingIntent getErrorPendingIntent(final int n, final Context context, final int n2) {
        return zze.zzoW().getErrorResolutionPendingIntent(context, n, n2);
    }
    
    @Deprecated
    public static String getErrorString(final int n) {
        return ConnectionResult.getStatusString(n);
    }
    
    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(final Context context) {
        Object o = new Uri$Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
        try {
            final InputStream openInputStream = context.getContentResolver().openInputStream((Uri)o);
            try {
                return (String)(o = new Scanner(openInputStream).useDelimiter("\\A").next());
            }
            catch (NoSuchElementException ex) {}
            finally {
                if (openInputStream != null) {
                    openInputStream.close();
                }
            }
        }
        catch (Exception ex2) {
            o = null;
        }
        return (String)o;
    }
    
    public static Context getRemoteContext(Context packageContext) {
        try {
            packageContext = packageContext.createPackageContext("com.google.android.gms", 3);
            return packageContext;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return null;
        }
    }
    
    public static Resources getRemoteResource(final Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        }
        catch (PackageManager$NameNotFoundException ex) {
            return null;
        }
    }
    
    @Deprecated
    public static int isGooglePlayServicesAvailable(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //     4: astore          4
        //     6: aload_0        
        //     7: invokevirtual   android/content/Context.getResources:()Landroid/content/res/Resources;
        //    10: getstatic       com/google/android/gms/R$string.common_google_play_services_unknown_issue:I
        //    13: invokevirtual   android/content/res/Resources.getString:(I)Ljava/lang/String;
        //    16: pop            
        //    17: ldc             "com.google.android.gms"
        //    19: aload_0        
        //    20: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    23: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    26: ifne            147
        //    29: getstatic       com/google/android/gms/common/zzo.zzaAt:Ljava/util/concurrent/atomic/AtomicBoolean;
        //    32: invokevirtual   java/util/concurrent/atomic/AtomicBoolean.get:()Z
        //    35: ifne            147
        //    38: aload_0        
        //    39: invokestatic    com/google/android/gms/common/internal/zzbd.zzaE:(Landroid/content/Context;)I
        //    42: istore_1       
        //    43: iload_1        
        //    44: ifne            69
        //    47: new             Ljava/lang/IllegalStateException;
        //    50: dup            
        //    51: ldc             "A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"
        //    53: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    56: athrow         
        //    57: astore_3       
        //    58: ldc             "GooglePlayServicesUtil"
        //    60: ldc             "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
        //    62: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //    65: pop            
        //    66: goto            17
        //    69: iload_1        
        //    70: getstatic       com/google/android/gms/common/zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE:I
        //    73: if_icmpeq       147
        //    76: getstatic       com/google/android/gms/common/zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE:I
        //    79: istore_2       
        //    80: ldc             "com.google.android.gms.version"
        //    82: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    85: astore_0       
        //    86: new             Ljava/lang/IllegalStateException;
        //    89: dup            
        //    90: new             Ljava/lang/StringBuilder;
        //    93: dup            
        //    94: aload_0        
        //    95: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    98: invokevirtual   java/lang/String.length:()I
        //   101: sipush          290
        //   104: iadd           
        //   105: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   108: ldc             "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected "
        //   110: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   113: iload_2        
        //   114: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   117: ldc             " but found "
        //   119: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   122: iload_1        
        //   123: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   126: ldc             ".  You must have the following declaration within the <application> element:     <meta-data android:name=\""
        //   128: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   131: aload_0        
        //   132: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   135: ldc             "\" android:value=\"@integer/google_play_services_version\" />"
        //   137: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   140: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   143: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   146: athrow         
        //   147: aload_0        
        //   148: invokestatic    com/google/android/gms/common/util/zzj.zzaH:(Landroid/content/Context;)Z
        //   151: ifne            224
        //   154: aload_0        
        //   155: invokestatic    com/google/android/gms/common/util/zzj.zzaJ:(Landroid/content/Context;)Z
        //   158: ifne            224
        //   161: iconst_1       
        //   162: istore_1       
        //   163: aconst_null    
        //   164: astore_3       
        //   165: iload_1        
        //   166: ifeq            180
        //   169: aload           4
        //   171: ldc             "com.android.vending"
        //   173: sipush          8256
        //   176: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   179: astore_3       
        //   180: aload           4
        //   182: ldc             "com.google.android.gms"
        //   184: bipush          64
        //   186: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   189: astore          5
        //   191: aload_0        
        //   192: invokestatic    com/google/android/gms/common/zzp.zzax:(Landroid/content/Context;)Lcom/google/android/gms/common/zzp;
        //   195: pop            
        //   196: iload_1        
        //   197: ifeq            282
        //   200: aload_3        
        //   201: getstatic       com/google/android/gms/common/zzj.zzaAk:[Lcom/google/android/gms/common/zzg;
        //   204: invokestatic    com/google/android/gms/common/zzp.zza:(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzg;)Lcom/google/android/gms/common/zzg;
        //   207: astore_0       
        //   208: aload_0        
        //   209: ifnonnull       254
        //   212: ldc             "GooglePlayServicesUtil"
        //   214: ldc_w           "Google Play Store signature invalid."
        //   217: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   220: pop            
        //   221: bipush          9
        //   223: ireturn        
        //   224: iconst_0       
        //   225: istore_1       
        //   226: goto            163
        //   229: astore_0       
        //   230: ldc             "GooglePlayServicesUtil"
        //   232: ldc_w           "Google Play Store is missing."
        //   235: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   238: pop            
        //   239: bipush          9
        //   241: ireturn        
        //   242: astore_0       
        //   243: ldc             "GooglePlayServicesUtil"
        //   245: ldc_w           "Google Play services is missing."
        //   248: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   251: pop            
        //   252: iconst_1       
        //   253: ireturn        
        //   254: aload           5
        //   256: iconst_1       
        //   257: anewarray       Lcom/google/android/gms/common/zzg;
        //   260: dup            
        //   261: iconst_0       
        //   262: aload_0        
        //   263: aastore        
        //   264: invokestatic    com/google/android/gms/common/zzp.zza:(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzg;)Lcom/google/android/gms/common/zzg;
        //   267: ifnonnull       305
        //   270: ldc             "GooglePlayServicesUtil"
        //   272: ldc_w           "Google Play services signature invalid."
        //   275: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   278: pop            
        //   279: bipush          9
        //   281: ireturn        
        //   282: aload           5
        //   284: getstatic       com/google/android/gms/common/zzj.zzaAk:[Lcom/google/android/gms/common/zzg;
        //   287: invokestatic    com/google/android/gms/common/zzp.zza:(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzg;)Lcom/google/android/gms/common/zzg;
        //   290: ifnonnull       305
        //   293: ldc             "GooglePlayServicesUtil"
        //   295: ldc_w           "Google Play services signature invalid."
        //   298: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   301: pop            
        //   302: bipush          9
        //   304: ireturn        
        //   305: getstatic       com/google/android/gms/common/zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE:I
        //   308: sipush          1000
        //   311: idiv           
        //   312: istore_1       
        //   313: aload           5
        //   315: getfield        android/content/pm/PackageInfo.versionCode:I
        //   318: sipush          1000
        //   321: idiv           
        //   322: iload_1        
        //   323: if_icmpge       375
        //   326: getstatic       com/google/android/gms/common/zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE:I
        //   329: istore_1       
        //   330: aload           5
        //   332: getfield        android/content/pm/PackageInfo.versionCode:I
        //   335: istore_2       
        //   336: ldc             "GooglePlayServicesUtil"
        //   338: new             Ljava/lang/StringBuilder;
        //   341: dup            
        //   342: bipush          77
        //   344: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   347: ldc_w           "Google Play services out of date.  Requires "
        //   350: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   353: iload_1        
        //   354: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   357: ldc             " but found "
        //   359: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   362: iload_2        
        //   363: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   366: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   369: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   372: pop            
        //   373: iconst_2       
        //   374: ireturn        
        //   375: aload           5
        //   377: getfield        android/content/pm/PackageInfo.applicationInfo:Landroid/content/pm/ApplicationInfo;
        //   380: astore_3       
        //   381: aload_3        
        //   382: astore_0       
        //   383: aload_3        
        //   384: ifnonnull       396
        //   387: aload           4
        //   389: ldc             "com.google.android.gms"
        //   391: iconst_0       
        //   392: invokevirtual   android/content/pm/PackageManager.getApplicationInfo:(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
        //   395: astore_0       
        //   396: aload_0        
        //   397: getfield        android/content/pm/ApplicationInfo.enabled:Z
        //   400: ifne            418
        //   403: iconst_3       
        //   404: ireturn        
        //   405: astore_0       
        //   406: ldc             "GooglePlayServicesUtil"
        //   408: ldc_w           "Google Play services missing when getting application info."
        //   411: aload_0        
        //   412: invokestatic    android/util/Log.wtf:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   415: pop            
        //   416: iconst_1       
        //   417: ireturn        
        //   418: iconst_0       
        //   419: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                     
        //  -----  -----  -----  -----  ---------------------------------------------------------
        //  6      17     57     69     Ljava/lang/Throwable;
        //  169    180    229    242    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  180    191    242    254    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  387    396    405    418    Landroid/content/pm/PackageManager$NameNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0180:
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
    
    @Deprecated
    public static boolean isUserRecoverableError(final int n) {
        switch (n) {
            default: {
                return false;
            }
            case 1:
            case 2:
            case 3:
            case 9: {
                return true;
            }
        }
    }
    
    @Deprecated
    public static void zzah(final Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        final int googlePlayServicesAvailable = zze.zzoW().isGooglePlayServicesAvailable(context);
        if (googlePlayServicesAvailable == 0) {
            return;
        }
        zze.zzoW();
        final Intent zza = zze.zza(context, googlePlayServicesAvailable, "e");
        Log.e("GooglePlayServicesUtil", new StringBuilder(57).append("GooglePlayServices not available due to error ").append(googlePlayServicesAvailable).toString());
        if (zza == null) {
            throw new GooglePlayServicesNotAvailableException(googlePlayServicesAvailable);
        }
        throw new GooglePlayServicesRepairableException(googlePlayServicesAvailable, "Google Play Services not available", zza);
    }
    
    @Deprecated
    public static void zzat(final Context context) {
        if (!zzo.zzaAs.getAndSet(true)) {
            try {
                final NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            }
            catch (SecurityException ex) {}
        }
    }
    
    @Deprecated
    public static int zzau(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }
    
    public static boolean zzaw(final Context context) {
        boolean b = false;
        while (true) {
            if (zzo.zzaAr) {
                break Label_0056;
            }
            try {
                final PackageInfo packageInfo = zzbha.zzaP(context).getPackageInfo("com.google.android.gms", 64);
                while (true) {
                    Label_0078: {
                        if (packageInfo == null) {
                            break Label_0078;
                        }
                        zzp.zzax(context);
                        if (zzp.zza(packageInfo, zzj.zzaAk[1]) == null) {
                            break Label_0078;
                        }
                        zzo.zzaAq = true;
                        zzo.zzaAr = true;
                        if (zzo.zzaAq || !"user".equals(Build.TYPE)) {
                            b = true;
                        }
                        return b;
                    }
                    zzo.zzaAq = false;
                    continue;
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", (Throwable)ex);
                zzo.zzaAr = true;
                continue;
            }
            finally {
                zzo.zzaAr = true;
            }
            break;
        }
    }
    
    @Deprecated
    @TargetApi(19)
    public static boolean zzb(final Context context, final int n, final String s) {
        return zzw.zzb(context, n, s);
    }
    
    @Deprecated
    public static boolean zze(final Context context, final int n) {
        return n == 18 || (n == 1 && zzy(context, "com.google.android.gms"));
    }
    
    @Deprecated
    public static boolean zzf(final Context context, final int n) {
        return zzw.zzf(context, n);
    }
    
    @TargetApi(21)
    static boolean zzy(final Context context, final String s) {
        final boolean equals = s.equals("com.google.android.gms");
        if (zzq.zzse()) {
            final Iterator<PackageInstaller$SessionInfo> iterator = (Iterator<PackageInstaller$SessionInfo>)context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (iterator.hasNext()) {
                if (s.equals(iterator.next().getAppPackageName())) {
                    return true;
                }
            }
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            final ApplicationInfo applicationInfo = packageManager.getApplicationInfo(s, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled) {
                while (true) {
                    Label_0148: {
                        if (!zzq.zzsb()) {
                            break Label_0148;
                        }
                        final Bundle applicationRestrictions = ((UserManager)context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
                        if (applicationRestrictions == null || !"true".equals(applicationRestrictions.getString("restricted_profile"))) {
                            break Label_0148;
                        }
                        final int n = 1;
                        if (n == 0) {
                            return true;
                        }
                        return false;
                    }
                    final int n = 0;
                    continue;
                }
            }
            return false;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
}
