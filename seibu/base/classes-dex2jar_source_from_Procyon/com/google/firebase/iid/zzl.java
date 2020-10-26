// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import java.util.Random;
import android.os.SystemClock;
import android.os.Message;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.common.util.zzq;
import android.os.Process;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.io.IOException;
import android.os.Bundle;
import android.util.Log;
import java.util.Iterator;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.security.KeyPair;
import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.iid.MessengerCompat;
import android.os.Messenger;
import android.content.BroadcastReceiver;
import android.app.PendingIntent;

public final class zzl
{
    private static PendingIntent zzbfP;
    private static String zzbgZ;
    private static boolean zzbha;
    private static int zzbhb;
    private static int zzbhc;
    private static int zzbhd;
    private static BroadcastReceiver zzbhe;
    private Messenger zzbfT;
    private Messenger zzbhg;
    private MessengerCompat zzbhh;
    private long zzbhi;
    private long zzbhj;
    private int zzbhk;
    private int zzbhl;
    private long zzbhm;
    private final SimpleArrayMap<String, zzp> zzckI;
    private Context zzqD;
    
    static {
        zzl.zzbgZ = null;
        zzl.zzbha = false;
        zzl.zzbhb = 0;
        zzl.zzbhc = 0;
        zzl.zzbhd = 0;
        zzl.zzbhe = null;
    }
    
    public zzl(final Context zzqD) {
        this.zzckI = new SimpleArrayMap<String, zzp>();
        this.zzqD = zzqD;
    }
    
    private static String zza(final KeyPair p0, final String... p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: aload_1        
        //     3: invokestatic    android/text/TextUtils.join:(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
        //     6: ldc             "UTF-8"
        //     8: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //    11: astore_1       
        //    12: aload_0        
        //    13: invokevirtual   java/security/KeyPair.getPrivate:()Ljava/security/PrivateKey;
        //    16: astore_2       
        //    17: aload_2        
        //    18: instanceof      Ljava/security/interfaces/RSAPrivateKey;
        //    21: ifeq            64
        //    24: ldc             "SHA256withRSA"
        //    26: astore_0       
        //    27: aload_0        
        //    28: invokestatic    java/security/Signature.getInstance:(Ljava/lang/String;)Ljava/security/Signature;
        //    31: astore_0       
        //    32: aload_0        
        //    33: aload_2        
        //    34: invokevirtual   java/security/Signature.initSign:(Ljava/security/PrivateKey;)V
        //    37: aload_0        
        //    38: aload_1        
        //    39: invokevirtual   java/security/Signature.update:([B)V
        //    42: aload_0        
        //    43: invokevirtual   java/security/Signature.sign:()[B
        //    46: invokestatic    com/google/firebase/iid/FirebaseInstanceId.zzj:([B)Ljava/lang/String;
        //    49: astore_0       
        //    50: aload_0        
        //    51: areturn        
        //    52: astore_0       
        //    53: ldc             "InstanceID/Rpc"
        //    55: ldc             "Unable to encode string"
        //    57: aload_0        
        //    58: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    61: pop            
        //    62: aconst_null    
        //    63: areturn        
        //    64: ldc             "SHA256withECDSA"
        //    66: astore_0       
        //    67: goto            27
        //    70: astore_0       
        //    71: ldc             "InstanceID/Rpc"
        //    73: ldc             "Unable to sign registration request"
        //    75: aload_0        
        //    76: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    79: pop            
        //    80: aconst_null    
        //    81: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                    
        //  -----  -----  -----  -----  ----------------------------------------
        //  0      12     52     64     Ljava/io/UnsupportedEncodingException;
        //  12     24     70     82     Ljava/security/GeneralSecurityException;
        //  27     50     70     82     Ljava/security/GeneralSecurityException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0027:
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
    
    private static boolean zza(final PackageManager packageManager) {
        final Iterator<ResolveInfo> iterator = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (iterator.hasNext()) {
            if (zza(packageManager, iterator.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                return zzl.zzbha = true;
            }
        }
        return false;
    }
    
    private static boolean zza(final PackageManager packageManager, final String s, final String s2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", s) == 0) {
            return zzb(packageManager, s);
        }
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(s).length() + 56 + String.valueOf(s2).length()).append("Possible malicious package ").append(s).append(" declares ").append(s2).append(" without permission").toString());
        return false;
    }
    
    private final void zzah(String s, final String s2) {
        final SimpleArrayMap<String, zzp> zzckI = this.zzckI;
        // monitorenter(zzckI)
        Label_0061: {
            if (s != null) {
                break Label_0061;
            }
            int i = 0;
        Label_0098_Outer:
            while (true) {
                zzp zzp;
                while (true) {
                    try {
                        while (i < this.zzckI.size()) {
                            this.zzckI.valueAt(i).onError(s2);
                            ++i;
                        }
                        this.zzckI.clear();
                        return;
                        while (true) {
                            s = String.valueOf(s);
                            s = "Missing callback for ".concat(s);
                            Log.w("InstanceID/Rpc", s);
                            return;
                            zzp = this.zzckI.remove(s);
                            continue Label_0098_Outer;
                        }
                    }
                    // iftrue(Label_0115:, s.length() == 0)
                    // iftrue(Label_0128:, zzp != null)
                    finally {
                    }
                    // monitorexit(zzckI)
                    Label_0115: {
                        s = new String("Missing callback for ");
                    }
                    continue;
                }
                Label_0128: {
                    zzp.onError(s2);
                }
            }
        }
    }
    
    private final Intent zzb(final Bundle p0, final KeyPair p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore          10
        //     5: new             Lcom/google/firebase/iid/zzo;
        //     8: dup            
        //     9: aconst_null    
        //    10: invokespecial   com/google/firebase/iid/zzo.<init>:(Lcom/google/firebase/iid/zzm;)V
        //    13: astore          11
        //    15: aload_0        
        //    16: getfield        com/google/firebase/iid/zzl.zzckI:Landroid/support/v4/util/SimpleArrayMap;
        //    19: astore          9
        //    21: aload           9
        //    23: monitorenter   
        //    24: aload_0        
        //    25: getfield        com/google/firebase/iid/zzl.zzckI:Landroid/support/v4/util/SimpleArrayMap;
        //    28: aload           10
        //    30: aload           11
        //    32: invokevirtual   android/support/v4/util/SimpleArrayMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    35: pop            
        //    36: aload           9
        //    38: monitorexit    
        //    39: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //    42: lstore          4
        //    44: aload_0        
        //    45: getfield        com/google/firebase/iid/zzl.zzbhm:J
        //    48: lconst_0       
        //    49: lcmp           
        //    50: ifeq            133
        //    53: lload           4
        //    55: aload_0        
        //    56: getfield        com/google/firebase/iid/zzl.zzbhm:J
        //    59: lcmp           
        //    60: ifgt            133
        //    63: aload_0        
        //    64: getfield        com/google/firebase/iid/zzl.zzbhm:J
        //    67: lstore          6
        //    69: aload_0        
        //    70: getfield        com/google/firebase/iid/zzl.zzbhl:I
        //    73: istore_3       
        //    74: ldc             "InstanceID/Rpc"
        //    76: new             Ljava/lang/StringBuilder;
        //    79: dup            
        //    80: bipush          78
        //    82: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    85: ldc_w           "Backoff mode, next request attempt: "
        //    88: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    91: lload           6
        //    93: lload           4
        //    95: lsub           
        //    96: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    99: ldc_w           " interval: "
        //   102: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: iload_3        
        //   106: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   109: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   112: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   115: pop            
        //   116: new             Ljava/io/IOException;
        //   119: dup            
        //   120: ldc_w           "RETRY_LATER"
        //   123: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   126: athrow         
        //   127: astore_1       
        //   128: aload           9
        //   130: monitorexit    
        //   131: aload_1        
        //   132: athrow         
        //   133: aload_0        
        //   134: invokespecial   com/google/firebase/iid/zzl.zzvN:()V
        //   137: getstatic       com/google/firebase/iid/zzl.zzbgZ:Ljava/lang/String;
        //   140: ifnonnull       154
        //   143: new             Ljava/io/IOException;
        //   146: dup            
        //   147: ldc_w           "MISSING_INSTANCEID_SERVICE"
        //   150: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   153: athrow         
        //   154: aload_0        
        //   155: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //   158: putfield        com/google/firebase/iid/zzl.zzbhi:J
        //   161: getstatic       com/google/firebase/iid/zzl.zzbha:Z
        //   164: ifeq            631
        //   167: ldc             "com.google.iid.TOKEN_REQUEST"
        //   169: astore          9
        //   171: new             Landroid/content/Intent;
        //   174: dup            
        //   175: aload           9
        //   177: invokespecial   android/content/Intent.<init>:(Ljava/lang/String;)V
        //   180: astore          9
        //   182: aload           9
        //   184: getstatic       com/google/firebase/iid/zzl.zzbgZ:Ljava/lang/String;
        //   187: invokevirtual   android/content/Intent.setPackage:(Ljava/lang/String;)Landroid/content/Intent;
        //   190: pop            
        //   191: aload_1        
        //   192: ldc_w           "gmsv"
        //   195: aload_0        
        //   196: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   199: aload_0        
        //   200: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   203: invokestatic    com/google/firebase/iid/zzl.zzbd:(Landroid/content/Context;)Ljava/lang/String;
        //   206: invokestatic    com/google/firebase/iid/FirebaseInstanceId.zzO:(Landroid/content/Context;Ljava/lang/String;)I
        //   209: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   212: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   215: aload_1        
        //   216: ldc_w           "osv"
        //   219: getstatic       android/os/Build$VERSION.SDK_INT:I
        //   222: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   225: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   228: aload_1        
        //   229: ldc_w           "app_ver"
        //   232: aload_0        
        //   233: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   236: invokestatic    com/google/firebase/iid/FirebaseInstanceId.zzbF:(Landroid/content/Context;)I
        //   239: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   242: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   245: aload_1        
        //   246: ldc_w           "app_ver_name"
        //   249: aload_0        
        //   250: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   253: invokestatic    com/google/firebase/iid/FirebaseInstanceId.zzbb:(Landroid/content/Context;)Ljava/lang/String;
        //   256: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   259: aload_1        
        //   260: ldc_w           "cliv"
        //   263: ldc_w           "fiid-11020000"
        //   266: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   269: aload_1        
        //   270: ldc_w           "appid"
        //   273: aload_2        
        //   274: invokestatic    com/google/firebase/iid/FirebaseInstanceId.zza:(Ljava/security/KeyPair;)Ljava/lang/String;
        //   277: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   280: aload_2        
        //   281: invokevirtual   java/security/KeyPair.getPublic:()Ljava/security/PublicKey;
        //   284: invokeinterface java/security/PublicKey.getEncoded:()[B
        //   289: invokestatic    com/google/firebase/iid/FirebaseInstanceId.zzj:([B)Ljava/lang/String;
        //   292: astore          12
        //   294: aload_1        
        //   295: ldc_w           "pub2"
        //   298: aload           12
        //   300: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   303: aload_1        
        //   304: ldc_w           "sig"
        //   307: aload_2        
        //   308: iconst_2       
        //   309: anewarray       Ljava/lang/String;
        //   312: dup            
        //   313: iconst_0       
        //   314: aload_0        
        //   315: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   318: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   321: aastore        
        //   322: dup            
        //   323: iconst_1       
        //   324: aload           12
        //   326: aastore        
        //   327: invokestatic    com/google/firebase/iid/zzl.zza:(Ljava/security/KeyPair;[Ljava/lang/String;)Ljava/lang/String;
        //   330: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   333: aload           9
        //   335: aload_1        
        //   336: invokevirtual   android/content/Intent.putExtras:(Landroid/os/Bundle;)Landroid/content/Intent;
        //   339: pop            
        //   340: aload_0        
        //   341: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   344: aload           9
        //   346: invokestatic    com/google/firebase/iid/zzl.zzd:(Landroid/content/Context;Landroid/content/Intent;)V
        //   349: aload_0        
        //   350: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //   353: putfield        com/google/firebase/iid/zzl.zzbhi:J
        //   356: aload           9
        //   358: ldc_w           "kid"
        //   361: new             Ljava/lang/StringBuilder;
        //   364: dup            
        //   365: aload           10
        //   367: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   370: invokevirtual   java/lang/String.length:()I
        //   373: iconst_5       
        //   374: iadd           
        //   375: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   378: ldc_w           "|ID|"
        //   381: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   384: aload           10
        //   386: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   389: ldc_w           "|"
        //   392: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   395: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   398: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   401: pop            
        //   402: aload           9
        //   404: ldc_w           "X-kid"
        //   407: new             Ljava/lang/StringBuilder;
        //   410: dup            
        //   411: aload           10
        //   413: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   416: invokevirtual   java/lang/String.length:()I
        //   419: iconst_5       
        //   420: iadd           
        //   421: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   424: ldc_w           "|ID|"
        //   427: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   430: aload           10
        //   432: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   435: ldc_w           "|"
        //   438: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   441: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   444: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   447: pop            
        //   448: ldc_w           "com.google.android.gsf"
        //   451: getstatic       com/google/firebase/iid/zzl.zzbgZ:Ljava/lang/String;
        //   454: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   457: istore          8
        //   459: ldc             "InstanceID/Rpc"
        //   461: iconst_3       
        //   462: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   465: ifeq            513
        //   468: aload           9
        //   470: invokevirtual   android/content/Intent.getExtras:()Landroid/os/Bundle;
        //   473: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   476: astore_1       
        //   477: ldc             "InstanceID/Rpc"
        //   479: new             Ljava/lang/StringBuilder;
        //   482: dup            
        //   483: aload_1        
        //   484: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   487: invokevirtual   java/lang/String.length:()I
        //   490: bipush          8
        //   492: iadd           
        //   493: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   496: ldc_w           "Sending "
        //   499: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   502: aload_1        
        //   503: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   506: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   509: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   512: pop            
        //   513: iload           8
        //   515: ifeq            644
        //   518: aload_0        
        //   519: monitorenter   
        //   520: getstatic       com/google/firebase/iid/zzl.zzbhe:Landroid/content/BroadcastReceiver;
        //   523: ifnonnull       592
        //   526: new             Lcom/google/firebase/iid/zzn;
        //   529: dup            
        //   530: aload_0        
        //   531: invokespecial   com/google/firebase/iid/zzn.<init>:(Lcom/google/firebase/iid/zzl;)V
        //   534: putstatic       com/google/firebase/iid/zzl.zzbhe:Landroid/content/BroadcastReceiver;
        //   537: ldc             "InstanceID/Rpc"
        //   539: iconst_3       
        //   540: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   543: ifeq            555
        //   546: ldc             "InstanceID/Rpc"
        //   548: ldc_w           "Registered GSF callback receiver"
        //   551: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   554: pop            
        //   555: new             Landroid/content/IntentFilter;
        //   558: dup            
        //   559: ldc_w           "com.google.android.c2dm.intent.REGISTRATION"
        //   562: invokespecial   android/content/IntentFilter.<init>:(Ljava/lang/String;)V
        //   565: astore_1       
        //   566: aload_1        
        //   567: aload_0        
        //   568: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   571: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   574: invokevirtual   android/content/IntentFilter.addCategory:(Ljava/lang/String;)V
        //   577: aload_0        
        //   578: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   581: getstatic       com/google/firebase/iid/zzl.zzbhe:Landroid/content/BroadcastReceiver;
        //   584: aload_1        
        //   585: ldc             "com.google.android.c2dm.permission.SEND"
        //   587: aconst_null    
        //   588: invokevirtual   android/content/Context.registerReceiver:(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
        //   591: pop            
        //   592: aload_0        
        //   593: monitorexit    
        //   594: aload_0        
        //   595: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   598: aload           9
        //   600: invokevirtual   android/content/Context.startService:(Landroid/content/Intent;)Landroid/content/ComponentName;
        //   603: pop            
        //   604: aload           11
        //   606: invokevirtual   com/google/firebase/iid/zzo.zzJW:()Landroid/content/Intent;
        //   609: astore_2       
        //   610: aload_0        
        //   611: getfield        com/google/firebase/iid/zzl.zzckI:Landroid/support/v4/util/SimpleArrayMap;
        //   614: astore_1       
        //   615: aload_1        
        //   616: monitorenter   
        //   617: aload_0        
        //   618: getfield        com/google/firebase/iid/zzl.zzckI:Landroid/support/v4/util/SimpleArrayMap;
        //   621: aload           10
        //   623: invokevirtual   android/support/v4/util/SimpleArrayMap.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //   626: pop            
        //   627: aload_1        
        //   628: monitorexit    
        //   629: aload_2        
        //   630: areturn        
        //   631: ldc_w           "com.google.android.c2dm.intent.REGISTER"
        //   634: astore          9
        //   636: goto            171
        //   639: astore_1       
        //   640: aload_0        
        //   641: monitorexit    
        //   642: aload_1        
        //   643: athrow         
        //   644: aload           9
        //   646: ldc_w           "google.messenger"
        //   649: aload_0        
        //   650: getfield        com/google/firebase/iid/zzl.zzbfT:Landroid/os/Messenger;
        //   653: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
        //   656: pop            
        //   657: aload_0        
        //   658: getfield        com/google/firebase/iid/zzl.zzbhg:Landroid/os/Messenger;
        //   661: ifnonnull       671
        //   664: aload_0        
        //   665: getfield        com/google/firebase/iid/zzl.zzbhh:Lcom/google/android/gms/iid/MessengerCompat;
        //   668: ifnull          718
        //   671: invokestatic    android/os/Message.obtain:()Landroid/os/Message;
        //   674: astore_1       
        //   675: aload_1        
        //   676: aload           9
        //   678: putfield        android/os/Message.obj:Ljava/lang/Object;
        //   681: aload_0        
        //   682: getfield        com/google/firebase/iid/zzl.zzbhg:Landroid/os/Messenger;
        //   685: ifnull          736
        //   688: aload_0        
        //   689: getfield        com/google/firebase/iid/zzl.zzbhg:Landroid/os/Messenger;
        //   692: aload_1        
        //   693: invokevirtual   android/os/Messenger.send:(Landroid/os/Message;)V
        //   696: goto            604
        //   699: astore_1       
        //   700: ldc             "InstanceID/Rpc"
        //   702: iconst_3       
        //   703: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   706: ifeq            718
        //   709: ldc             "InstanceID/Rpc"
        //   711: ldc_w           "Messenger failed, fallback to startService"
        //   714: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   717: pop            
        //   718: getstatic       com/google/firebase/iid/zzl.zzbha:Z
        //   721: ifeq            747
        //   724: aload_0        
        //   725: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   728: aload           9
        //   730: invokevirtual   android/content/Context.sendBroadcast:(Landroid/content/Intent;)V
        //   733: goto            604
        //   736: aload_0        
        //   737: getfield        com/google/firebase/iid/zzl.zzbhh:Lcom/google/android/gms/iid/MessengerCompat;
        //   740: aload_1        
        //   741: invokevirtual   com/google/android/gms/iid/MessengerCompat.send:(Landroid/os/Message;)V
        //   744: goto            604
        //   747: aload_0        
        //   748: getfield        com/google/firebase/iid/zzl.zzqD:Landroid/content/Context;
        //   751: aload           9
        //   753: invokevirtual   android/content/Context.startService:(Landroid/content/Intent;)Landroid/content/ComponentName;
        //   756: pop            
        //   757: goto            604
        //   760: astore_2       
        //   761: aload_1        
        //   762: monitorexit    
        //   763: aload_2        
        //   764: athrow         
        //   765: astore_2       
        //   766: aload_0        
        //   767: getfield        com/google/firebase/iid/zzl.zzckI:Landroid/support/v4/util/SimpleArrayMap;
        //   770: astore_1       
        //   771: aload_1        
        //   772: monitorenter   
        //   773: aload_0        
        //   774: getfield        com/google/firebase/iid/zzl.zzckI:Landroid/support/v4/util/SimpleArrayMap;
        //   777: aload           10
        //   779: invokevirtual   android/support/v4/util/SimpleArrayMap.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //   782: pop            
        //   783: aload_1        
        //   784: monitorexit    
        //   785: aload_2        
        //   786: athrow         
        //   787: astore_2       
        //   788: aload_1        
        //   789: monitorexit    
        //   790: aload_2        
        //   791: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  24     39     127    133    Any
        //  128    131    127    133    Any
        //  520    555    639    644    Any
        //  555    592    639    644    Any
        //  592    594    639    644    Any
        //  604    610    765    792    Any
        //  617    629    760    765    Any
        //  640    642    639    644    Any
        //  681    696    699    718    Landroid/os/RemoteException;
        //  736    744    699    718    Landroid/os/RemoteException;
        //  761    763    760    765    Any
        //  773    785    787    792    Any
        //  788    790    787    792    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0604:
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
    
    private final void zzb(String s, final Intent intent) {
        final zzp zzp;
        synchronized (this.zzckI) {
            zzp = this.zzckI.remove(s);
            if (zzp == null) {
                s = String.valueOf(s);
                if (s.length() != 0) {
                    s = "Missing callback for ".concat(s);
                }
                else {
                    s = new String("Missing callback for ");
                }
                Log.w("InstanceID/Rpc", s);
                return;
            }
        }
        zzp.zzq(intent);
    }
    // monitorexit(simpleArrayMap)
    
    private static boolean zzb(final PackageManager packageManager, final String s) {
        try {
            final ApplicationInfo applicationInfo = packageManager.getApplicationInfo(s, 0);
            zzl.zzbgZ = applicationInfo.packageName;
            zzl.zzbhc = applicationInfo.uid;
            return true;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
    
    public static String zzbd(final Context context) {
        if (zzl.zzbgZ != null) {
            return zzl.zzbgZ;
        }
        zzl.zzbhb = Process.myUid();
        final PackageManager packageManager = context.getPackageManager();
        Label_0101: {
            if (!zzq.isAtLeastO()) {
                final Iterator iterator = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
                while (true) {
                    while (iterator.hasNext()) {
                        if (zza(packageManager, iterator.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                            zzl.zzbha = false;
                            final int n = 1;
                            if (n != 0) {
                                return zzl.zzbgZ;
                            }
                            break Label_0101;
                        }
                    }
                    final int n = 0;
                    continue;
                }
            }
        }
        if (zza(packageManager)) {
            return zzl.zzbgZ;
        }
        Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
        if (zzb(packageManager, "com.google.android.gms")) {
            zzl.zzbha = zzq.isAtLeastO();
            return zzl.zzbgZ;
        }
        if (!zzq.zzse() && zzb(packageManager, "com.google.android.gsf")) {
            zzl.zzbha = false;
            return zzl.zzbgZ;
        }
        Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
        return null;
    }
    
    public static void zzd(final Context context, final Intent intent) {
        synchronized (zzl.class) {
            if (zzl.zzbfP == null) {
                final Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzl.zzbfP = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", (Parcelable)zzl.zzbfP);
        }
    }
    
    private final void zzvN() {
        if (this.zzbfT != null) {
            return;
        }
        zzbd(this.zzqD);
        this.zzbfT = new Messenger((Handler)new zzm(this, Looper.getMainLooper()));
    }
    
    public static String zzvO() {
        synchronized (zzl.class) {
            final int zzbhd = zzl.zzbhd;
            zzl.zzbhd = zzbhd + 1;
            return Integer.toString(zzbhd);
        }
    }
    
    final Intent zza(final Bundle bundle, final KeyPair keyPair) throws IOException {
        Intent zzb;
        final Intent intent = zzb = this.zzb(bundle, keyPair);
        if (intent != null) {
            zzb = intent;
            if (intent.hasExtra("google.messenger")) {
                final Intent zzb2 = this.zzb(bundle, keyPair);
                if ((zzb = zzb2) != null) {
                    zzb = zzb2;
                    if (zzb2.hasExtra("google.messenger")) {
                        zzb = null;
                    }
                }
            }
        }
        return zzb;
    }
    
    final void zzc(final Message message) {
        if (message == null) {
            return;
        }
        if (message.obj instanceof Intent) {
            final Intent intent = (Intent)message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                final Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    this.zzbhh = (MessengerCompat)parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzbhg = (Messenger)parcelableExtra;
                }
            }
            this.zzi((Intent)message.obj);
            return;
        }
        Log.w("InstanceID/Rpc", "Dropping invalid message");
    }
    
    final void zzi(final Intent intent) {
        String s = null;
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
            }
        }
        else if (!"com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                final String value = String.valueOf(intent.getAction());
                String concat;
                if (value.length() != 0) {
                    concat = "Unexpected response ".concat(value);
                }
                else {
                    concat = new String("Unexpected response ");
                }
                Log.d("InstanceID/Rpc", concat);
            }
        }
        else {
            String obj;
            if ((obj = intent.getStringExtra("registration_id")) == null) {
                obj = intent.getStringExtra("unregistered");
            }
            if (obj == null) {
                final String stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    final String value2 = String.valueOf(intent.getExtras());
                    Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(value2).length() + 49).append("Unexpected response, no error or registration id ").append(value2).toString());
                    return;
                }
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    final String value3 = String.valueOf(stringExtra);
                    String concat2;
                    if (value3.length() != 0) {
                        concat2 = "Received InstanceID error ".concat(value3);
                    }
                    else {
                        concat2 = new String("Received InstanceID error ");
                    }
                    Log.d("InstanceID/Rpc", concat2);
                }
                String s4;
                String substring;
                if (stringExtra.startsWith("|")) {
                    final String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        final String value4 = String.valueOf(stringExtra);
                        String concat3;
                        if (value4.length() != 0) {
                            concat3 = "Unexpected structured response ".concat(value4);
                        }
                        else {
                            concat3 = new String("Unexpected structured response ");
                        }
                        Log.w("InstanceID/Rpc", concat3);
                    }
                    if (split.length > 2) {
                        final String s2 = split[2];
                        final String s3 = split[3];
                        s4 = s2;
                        substring = s3;
                        if (s3.startsWith(":")) {
                            substring = s3.substring(1);
                            s4 = s2;
                        }
                    }
                    else {
                        substring = "UNKNOWN";
                        s4 = null;
                    }
                    intent.putExtra("error", substring);
                }
                else {
                    final String s5 = null;
                    substring = stringExtra;
                    s4 = s5;
                }
                this.zzah(s4, substring);
                final long longExtra = intent.getLongExtra("Retry-After", 0L);
                if (longExtra > 0L) {
                    this.zzbhj = SystemClock.elapsedRealtime();
                    this.zzbhl = (int)longExtra * 1000;
                    this.zzbhm = SystemClock.elapsedRealtime() + this.zzbhl;
                    Log.w("InstanceID/Rpc", new StringBuilder(52).append("Explicit request from server to backoff: ").append(this.zzbhl).toString());
                    return;
                }
                if (("SERVICE_NOT_AVAILABLE".equals(substring) || "AUTHENTICATION_FAILED".equals(substring)) && "com.google.android.gsf".equals(zzl.zzbgZ)) {
                    ++this.zzbhk;
                    if (this.zzbhk >= 3) {
                        if (this.zzbhk == 3) {
                            this.zzbhl = new Random().nextInt(1000) + 1000;
                        }
                        this.zzbhl <<= 1;
                        this.zzbhm = SystemClock.elapsedRealtime() + this.zzbhl;
                        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(substring).length() + 31).append("Backoff due to ").append(substring).append(" for ").append(this.zzbhl).toString());
                    }
                }
            }
            else {
                this.zzbhi = SystemClock.elapsedRealtime();
                this.zzbhm = 0L;
                this.zzbhk = 0;
                this.zzbhl = 0;
                if (obj.startsWith("|")) {
                    final String[] split2 = obj.split("\\|");
                    if (!"ID".equals(split2[1])) {
                        final String value5 = String.valueOf(obj);
                        String concat4;
                        if (value5.length() != 0) {
                            concat4 = "Unexpected structured response ".concat(value5);
                        }
                        else {
                            concat4 = new String("Unexpected structured response ");
                        }
                        Log.w("InstanceID/Rpc", concat4);
                    }
                    s = split2[2];
                    if (split2.length > 4) {
                        if ("SYNC".equals(split2[3])) {
                            FirebaseInstanceId.zzbG(this.zzqD);
                        }
                        else if ("RST".equals(split2[3])) {
                            final Context zzqD = this.zzqD;
                            zzj.zzb(this.zzqD, null);
                            FirebaseInstanceId.zza(zzqD, zzj.zzJT());
                            intent.removeExtra("registration_id");
                            this.zzb(s, intent);
                            return;
                        }
                    }
                    String substring2;
                    final String s6 = substring2 = split2[split2.length - 1];
                    if (s6.startsWith(":")) {
                        substring2 = s6.substring(1);
                    }
                    intent.putExtra("registration_id", substring2);
                }
                if (s != null) {
                    this.zzb(s, intent);
                    return;
                }
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Ignoring response without a request ID");
                }
            }
        }
    }
}
