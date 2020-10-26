// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.messaging;

import android.os.Bundle;
import android.util.Log;
import android.util.Base64;
import android.content.Intent;
import com.google.android.gms.measurement.AppMeasurement;
import android.content.Context;

final class zzd
{
    private static AppMeasurement zzaQ(final Context context) {
        try {
            return AppMeasurement.getInstance(context);
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return null;
        }
    }
    
    private static void zzb(final Context p0, final String p1, final Intent p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   android/os/Bundle.<init>:()V
        //     7: astore          4
        //     9: aload_2        
        //    10: ldc             "google.c.a.c_id"
        //    12: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //    15: astore_3       
        //    16: aload_3        
        //    17: ifnull          28
        //    20: aload           4
        //    22: ldc             "_nmid"
        //    24: aload_3        
        //    25: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //    28: aload_2        
        //    29: ldc             "google.c.a.c_l"
        //    31: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //    34: astore_3       
        //    35: aload_3        
        //    36: ifnull          47
        //    39: aload           4
        //    41: ldc             "_nmn"
        //    43: aload_3        
        //    44: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //    47: aload_2        
        //    48: ldc             "from"
        //    50: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //    53: astore_3       
        //    54: aload_3        
        //    55: ifnull          212
        //    58: aload_3        
        //    59: ldc             "/topics/"
        //    61: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    64: ifeq            212
        //    67: aload_3        
        //    68: ifnull          79
        //    71: aload           4
        //    73: ldc             "_nt"
        //    75: aload_3        
        //    76: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //    79: aload           4
        //    81: ldc             "_nmt"
        //    83: aload_2        
        //    84: ldc             "google.c.a.ts"
        //    86: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //    89: invokestatic    java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
        //    92: invokevirtual   java/lang/Integer.intValue:()I
        //    95: invokevirtual   android/os/Bundle.putInt:(Ljava/lang/String;I)V
        //    98: aload_2        
        //    99: ldc             "google.c.a.udt"
        //   101: invokevirtual   android/content/Intent.hasExtra:(Ljava/lang/String;)Z
        //   104: ifeq            126
        //   107: aload           4
        //   109: ldc             "_ndt"
        //   111: aload_2        
        //   112: ldc             "google.c.a.udt"
        //   114: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //   117: invokestatic    java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
        //   120: invokevirtual   java/lang/Integer.intValue:()I
        //   123: invokevirtual   android/os/Bundle.putInt:(Ljava/lang/String;I)V
        //   126: ldc             "FirebaseMessaging"
        //   128: iconst_3       
        //   129: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   132: ifeq            193
        //   135: aload           4
        //   137: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   140: astore_2       
        //   141: ldc             "FirebaseMessaging"
        //   143: new             Ljava/lang/StringBuilder;
        //   146: dup            
        //   147: aload_1        
        //   148: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   151: invokevirtual   java/lang/String.length:()I
        //   154: bipush          22
        //   156: iadd           
        //   157: aload_2        
        //   158: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   161: invokevirtual   java/lang/String.length:()I
        //   164: iadd           
        //   165: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   168: ldc             "Sending event="
        //   170: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: aload_1        
        //   174: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   177: ldc             " params="
        //   179: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: aload_2        
        //   183: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   186: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   189: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   192: pop            
        //   193: aload_0        
        //   194: invokestatic    com/google/firebase/messaging/zzd.zzaQ:(Landroid/content/Context;)Lcom/google/android/gms/measurement/AppMeasurement;
        //   197: astore_0       
        //   198: aload_0        
        //   199: ifnull          243
        //   202: aload_0        
        //   203: ldc             "fcm"
        //   205: aload_1        
        //   206: aload           4
        //   208: invokevirtual   com/google/android/gms/measurement/AppMeasurement.logEventInternal:(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
        //   211: return         
        //   212: aconst_null    
        //   213: astore_3       
        //   214: goto            67
        //   217: astore_3       
        //   218: ldc             "FirebaseMessaging"
        //   220: ldc             "Error while parsing timestamp in GCM event"
        //   222: aload_3        
        //   223: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   226: pop            
        //   227: goto            98
        //   230: astore_2       
        //   231: ldc             "FirebaseMessaging"
        //   233: ldc             "Error while parsing use_device_time in GCM event"
        //   235: aload_2        
        //   236: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   239: pop            
        //   240: goto            126
        //   243: ldc             "FirebaseMessaging"
        //   245: ldc             "Unable to log event: analytics library is missing"
        //   247: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   250: pop            
        //   251: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  79     98     217    230    Ljava/lang/NumberFormatException;
        //  107    126    230    243    Ljava/lang/NumberFormatException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0126:
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
    
    public static void zzg(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("google.c.a.abt");
        if (stringExtra != null) {
            zzc.zza(context, "fcm", Base64.decode(stringExtra, 0), new zzb(), 1);
        }
        zzb(context, "_nr", intent);
    }
    
    public static void zzh(final Context context, final Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                final AppMeasurement zzaQ = zzaQ(context);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (zzaQ != null) {
                    final String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    zzaQ.setUserPropertyInternal("fcm", "_ln", stringExtra);
                    final Bundle bundle = new Bundle();
                    bundle.putString("source", "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    zzaQ.logEventInternal("fcm", "_cmp", bundle);
                }
                else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            }
            else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        zzb(context, "_no", intent);
    }
    
    public static void zzi(final Context context, final Intent intent) {
        zzb(context, "_nd", intent);
    }
    
    public static void zzj(final Context context, final Intent intent) {
        zzb(context, "_nf", intent);
    }
}
