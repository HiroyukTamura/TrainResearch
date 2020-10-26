// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.math.BigInteger;
import java.util.Locale;
import com.google.android.gms.common.util.zze;
import android.content.Context;
import android.support.annotation.WorkerThread;
import com.google.firebase.iid.FirebaseInstanceId;

public final class zzcfg extends zzchj
{
    private String mAppId;
    private String zzXB;
    private String zzaeH;
    private String zzaeI;
    private String zzboB;
    private long zzboF;
    private int zzbqC;
    private long zzbqD;
    private int zzbqE;
    
    zzcfg(final zzcgl zzcgl) {
        super(zzcgl);
    }
    
    @WorkerThread
    private final String zzwK() {
        super.zzjC();
        try {
            return FirebaseInstanceId.getInstance().getId();
        }
        catch (IllegalStateException ex) {
            super.zzwF().zzyz().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }
    
    final String getGmpAppId() {
        this.zzkD();
        return this.zzXB;
    }
    
    @WorkerThread
    final zzceh zzdV(final String s) {
        super.zzjC();
        final String zzhl = this.zzhl();
        final String gmpAppId = this.getGmpAppId();
        this.zzkD();
        final String zzaeI = this.zzaeI;
        final long n = this.zzyv();
        this.zzkD();
        final String zzboB = this.zzboB;
        final long zzwP = zzcem.zzwP();
        this.zzkD();
        super.zzjC();
        if (this.zzbqD == 0L) {
            this.zzbqD = this.zzboe.zzwB().zzI(super.getContext(), super.getContext().getPackageName());
        }
        final long zzbqD = this.zzbqD;
        final boolean enabled = this.zzboe.isEnabled();
        final boolean b = !super.zzwG().zzbrC;
        final String zzwK = this.zzwK();
        this.zzkD();
        final long zzyY = this.zzboe.zzyY();
        this.zzkD();
        return new zzceh(zzhl, gmpAppId, zzaeI, n, zzboB, zzwP, zzbqD, s, enabled, b, zzwK, 0L, zzyY, this.zzbqE);
    }
    
    final String zzhl() {
        this.zzkD();
        return this.mAppId;
    }
    
    @Override
    protected final void zzjD() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2       
        //     2: ldc             "unknown"
        //     4: astore          5
        //     6: ldc             "Unknown"
        //     8: astore          9
        //    10: ldc             -2147483648
        //    12: istore_3       
        //    13: ldc             "Unknown"
        //    15: astore          6
        //    17: aload_0        
        //    18: invokespecial   com/google/android/gms/internal/zzchj.getContext:()Landroid/content/Context;
        //    21: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    24: astore          10
        //    26: aload_0        
        //    27: invokespecial   com/google/android/gms/internal/zzchj.getContext:()Landroid/content/Context;
        //    30: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //    33: astore          11
        //    35: aload           11
        //    37: ifnonnull       285
        //    40: aload_0        
        //    41: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //    44: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //    47: ldc             "PackageManager is null, app identity information might be inaccurate. appId"
        //    49: aload           10
        //    51: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //    54: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //    57: aload           5
        //    59: astore          8
        //    61: aload           9
        //    63: astore          7
        //    65: iload_3        
        //    66: istore_1       
        //    67: aload           6
        //    69: astore          5
        //    71: aload_0        
        //    72: aload           10
        //    74: putfield        com/google/android/gms/internal/zzcfg.mAppId:Ljava/lang/String;
        //    77: aload_0        
        //    78: aload           8
        //    80: putfield        com/google/android/gms/internal/zzcfg.zzboB:Ljava/lang/String;
        //    83: aload_0        
        //    84: aload           7
        //    86: putfield        com/google/android/gms/internal/zzcfg.zzaeI:Ljava/lang/String;
        //    89: aload_0        
        //    90: iload_1        
        //    91: putfield        com/google/android/gms/internal/zzcfg.zzbqC:I
        //    94: aload_0        
        //    95: aload           5
        //    97: putfield        com/google/android/gms/internal/zzcfg.zzaeH:Ljava/lang/String;
        //   100: aload_0        
        //   101: lconst_0       
        //   102: putfield        com/google/android/gms/internal/zzcfg.zzbqD:J
        //   105: invokestatic    com/google/android/gms/internal/zzcem.zzxE:()Z
        //   108: pop            
        //   109: aload_0        
        //   110: invokespecial   com/google/android/gms/internal/zzchj.getContext:()Landroid/content/Context;
        //   113: invokestatic    com/google/android/gms/internal/zzbdm.zzaz:(Landroid/content/Context;)Lcom/google/android/gms/common/api/Status;
        //   116: astore          4
        //   118: aload           4
        //   120: ifnull          526
        //   123: aload           4
        //   125: invokevirtual   com/google/android/gms/common/api/Status.isSuccess:()Z
        //   128: ifeq            526
        //   131: iconst_1       
        //   132: istore_1       
        //   133: iload_1        
        //   134: ifne            154
        //   137: aload           4
        //   139: ifnonnull       531
        //   142: aload_0        
        //   143: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   146: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   149: ldc             "GoogleService failed to initialize (no status)"
        //   151: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   154: iload_1        
        //   155: ifeq            674
        //   158: aload_0        
        //   159: invokespecial   com/google/android/gms/internal/zzchj.zzwH:()Lcom/google/android/gms/internal/zzcem;
        //   162: ldc             "firebase_analytics_collection_enabled"
        //   164: invokevirtual   com/google/android/gms/internal/zzcem.zzdN:(Ljava/lang/String;)Ljava/lang/Boolean;
        //   167: astore          4
        //   169: aload_0        
        //   170: invokespecial   com/google/android/gms/internal/zzchj.zzwH:()Lcom/google/android/gms/internal/zzcem;
        //   173: invokevirtual   com/google/android/gms/internal/zzcem.zzxF:()Z
        //   176: ifeq            560
        //   179: aload_0        
        //   180: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   183: invokevirtual   com/google/android/gms/internal/zzcfl.zzyB:()Lcom/google/android/gms/internal/zzcfn;
        //   186: ldc             "Collection disabled with firebase_analytics_collection_deactivated=1"
        //   188: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   191: iconst_0       
        //   192: istore_1       
        //   193: aload_0        
        //   194: ldc             ""
        //   196: putfield        com/google/android/gms/internal/zzcfg.zzXB:Ljava/lang/String;
        //   199: aload_0        
        //   200: lconst_0       
        //   201: putfield        com/google/android/gms/internal/zzcfg.zzboF:J
        //   204: invokestatic    com/google/android/gms/internal/zzcem.zzxE:()Z
        //   207: pop            
        //   208: invokestatic    com/google/android/gms/internal/zzbdm.zzqA:()Ljava/lang/String;
        //   211: astore          5
        //   213: aload           5
        //   215: astore          4
        //   217: aload           5
        //   219: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   222: ifeq            229
        //   225: ldc             ""
        //   227: astore          4
        //   229: aload_0        
        //   230: aload           4
        //   232: putfield        com/google/android/gms/internal/zzcfg.zzXB:Ljava/lang/String;
        //   235: iload_1        
        //   236: ifeq            259
        //   239: aload_0        
        //   240: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   243: invokevirtual   com/google/android/gms/internal/zzcfl.zzyD:()Lcom/google/android/gms/internal/zzcfn;
        //   246: ldc             "App package, google app id"
        //   248: aload_0        
        //   249: getfield        com/google/android/gms/internal/zzcfg.mAppId:Ljava/lang/String;
        //   252: aload_0        
        //   253: getfield        com/google/android/gms/internal/zzcfg.zzXB:Ljava/lang/String;
        //   256: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   259: getstatic       android/os/Build$VERSION.SDK_INT:I
        //   262: bipush          16
        //   264: if_icmplt       668
        //   267: aload_0        
        //   268: invokespecial   com/google/android/gms/internal/zzchj.getContext:()Landroid/content/Context;
        //   271: invokestatic    com/google/android/gms/internal/zzbgy.zzaN:(Landroid/content/Context;)Z
        //   274: ifeq            663
        //   277: iload_2        
        //   278: istore_1       
        //   279: aload_0        
        //   280: iload_1        
        //   281: putfield        com/google/android/gms/internal/zzcfg.zzbqE:I
        //   284: return         
        //   285: aload           11
        //   287: aload           10
        //   289: invokevirtual   android/content/pm/PackageManager.getInstallerPackageName:(Ljava/lang/String;)Ljava/lang/String;
        //   292: astore          4
        //   294: aload           4
        //   296: astore          5
        //   298: aload           5
        //   300: ifnonnull       469
        //   303: ldc             "manual_install"
        //   305: astore          4
        //   307: aload           6
        //   309: astore          8
        //   311: aload           9
        //   313: astore          7
        //   315: aload           11
        //   317: aload_0        
        //   318: invokespecial   com/google/android/gms/internal/zzchj.getContext:()Landroid/content/Context;
        //   321: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   324: iconst_0       
        //   325: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   328: astore          12
        //   330: aload           6
        //   332: astore          5
        //   334: iload_3        
        //   335: istore_1       
        //   336: aload           9
        //   338: astore          7
        //   340: aload           4
        //   342: astore          8
        //   344: aload           12
        //   346: ifnull          71
        //   349: aload           6
        //   351: astore          8
        //   353: aload           9
        //   355: astore          7
        //   357: aload           11
        //   359: aload           12
        //   361: getfield        android/content/pm/PackageInfo.applicationInfo:Landroid/content/pm/ApplicationInfo;
        //   364: invokevirtual   android/content/pm/PackageManager.getApplicationLabel:(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
        //   367: astore          11
        //   369: aload           6
        //   371: astore          5
        //   373: aload           6
        //   375: astore          8
        //   377: aload           9
        //   379: astore          7
        //   381: aload           11
        //   383: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   386: ifne            406
        //   389: aload           6
        //   391: astore          8
        //   393: aload           9
        //   395: astore          7
        //   397: aload           11
        //   399: invokeinterface java/lang/CharSequence.toString:()Ljava/lang/String;
        //   404: astore          5
        //   406: aload           5
        //   408: astore          8
        //   410: aload           9
        //   412: astore          7
        //   414: aload           12
        //   416: getfield        android/content/pm/PackageInfo.versionName:Ljava/lang/String;
        //   419: astore          6
        //   421: aload           5
        //   423: astore          8
        //   425: aload           6
        //   427: astore          7
        //   429: aload           12
        //   431: getfield        android/content/pm/PackageInfo.versionCode:I
        //   434: istore_1       
        //   435: aload           6
        //   437: astore          7
        //   439: aload           4
        //   441: astore          8
        //   443: goto            71
        //   446: astore          4
        //   448: aload_0        
        //   449: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   452: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   455: ldc_w           "Error retrieving app installer package name. appId"
        //   458: aload           10
        //   460: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   463: invokevirtual   com/google/android/gms/internal/zzcfn.zzj:(Ljava/lang/String;Ljava/lang/Object;)V
        //   466: goto            298
        //   469: aload           5
        //   471: astore          4
        //   473: ldc_w           "com.android.vending"
        //   476: aload           5
        //   478: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   481: ifeq            307
        //   484: ldc             ""
        //   486: astore          4
        //   488: goto            307
        //   491: astore          5
        //   493: aload_0        
        //   494: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   497: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   500: ldc_w           "Error retrieving package info. appId, appName"
        //   503: aload           10
        //   505: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   508: aload           8
        //   510: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   513: aload           8
        //   515: astore          5
        //   517: iload_3        
        //   518: istore_1       
        //   519: aload           4
        //   521: astore          8
        //   523: goto            71
        //   526: iconst_0       
        //   527: istore_1       
        //   528: goto            133
        //   531: aload_0        
        //   532: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   535: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   538: ldc_w           "GoogleService failed to initialize, status"
        //   541: aload           4
        //   543: invokevirtual   com/google/android/gms/common/api/Status.getStatusCode:()I
        //   546: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   549: aload           4
        //   551: invokevirtual   com/google/android/gms/common/api/Status.getStatusMessage:()Ljava/lang/String;
        //   554: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   557: goto            154
        //   560: aload           4
        //   562: ifnull          591
        //   565: aload           4
        //   567: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   570: ifne            591
        //   573: aload_0        
        //   574: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   577: invokevirtual   com/google/android/gms/internal/zzcfl.zzyB:()Lcom/google/android/gms/internal/zzcfn;
        //   580: ldc_w           "Collection disabled with firebase_analytics_collection_enabled=0"
        //   583: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   586: iconst_0       
        //   587: istore_1       
        //   588: goto            193
        //   591: aload           4
        //   593: ifnonnull       620
        //   596: invokestatic    com/google/android/gms/internal/zzcem.zzqB:()Z
        //   599: ifeq            620
        //   602: aload_0        
        //   603: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   606: invokevirtual   com/google/android/gms/internal/zzcfl.zzyB:()Lcom/google/android/gms/internal/zzcfn;
        //   609: ldc_w           "Collection disabled with google_app_measurement_enable=0"
        //   612: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   615: iconst_0       
        //   616: istore_1       
        //   617: goto            193
        //   620: aload_0        
        //   621: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   624: invokevirtual   com/google/android/gms/internal/zzcfl.zzyD:()Lcom/google/android/gms/internal/zzcfn;
        //   627: ldc_w           "Collection enabled"
        //   630: invokevirtual   com/google/android/gms/internal/zzcfn.log:(Ljava/lang/String;)V
        //   633: iconst_1       
        //   634: istore_1       
        //   635: goto            193
        //   638: astore          4
        //   640: aload_0        
        //   641: invokespecial   com/google/android/gms/internal/zzchj.zzwF:()Lcom/google/android/gms/internal/zzcfl;
        //   644: invokevirtual   com/google/android/gms/internal/zzcfl.zzyx:()Lcom/google/android/gms/internal/zzcfn;
        //   647: ldc_w           "getGoogleAppId or isMeasurementEnabled failed with exception. appId"
        //   650: aload           10
        //   652: invokestatic    com/google/android/gms/internal/zzcfl.zzdZ:(Ljava/lang/String;)Ljava/lang/Object;
        //   655: aload           4
        //   657: invokevirtual   com/google/android/gms/internal/zzcfn.zze:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   660: goto            259
        //   663: iconst_0       
        //   664: istore_1       
        //   665: goto            279
        //   668: aload_0        
        //   669: iconst_0       
        //   670: putfield        com/google/android/gms/internal/zzcfg.zzbqE:I
        //   673: return         
        //   674: iconst_0       
        //   675: istore_1       
        //   676: goto            193
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                     
        //  -----  -----  -----  -----  ---------------------------------------------------------
        //  208    213    638    663    Ljava/lang/IllegalStateException;
        //  217    225    638    663    Ljava/lang/IllegalStateException;
        //  229    235    638    663    Ljava/lang/IllegalStateException;
        //  239    259    638    663    Ljava/lang/IllegalStateException;
        //  285    294    446    469    Ljava/lang/IllegalArgumentException;
        //  315    330    491    526    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  357    369    491    526    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  381    389    491    526    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  397    406    491    526    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  414    421    491    526    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  429    435    491    526    Landroid/content/pm/PackageManager$NameNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0406:
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
    
    @WorkerThread
    final String zzyu() {
        final byte[] array = new byte[16];
        super.zzwB().zzzt().nextBytes(array);
        return String.format(Locale.US, "%032x", new BigInteger(1, array));
    }
    
    final int zzyv() {
        this.zzkD();
        return this.zzbqC;
    }
}
