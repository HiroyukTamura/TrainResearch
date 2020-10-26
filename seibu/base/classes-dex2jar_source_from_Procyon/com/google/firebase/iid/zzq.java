// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.util.Log;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.content.Context;
import java.util.LinkedList;
import android.support.annotation.VisibleForTesting;
import android.content.Intent;
import java.util.Queue;
import android.support.v4.util.SimpleArrayMap;

public final class zzq
{
    private static zzq zzckM;
    private final SimpleArrayMap<String, String> zzckN;
    private Boolean zzckO;
    @VisibleForTesting
    final Queue<Intent> zzckP;
    @VisibleForTesting
    private Queue<Intent> zzckQ;
    
    private zzq() {
        this.zzckN = new SimpleArrayMap<String, String>();
        this.zzckO = null;
        this.zzckP = new LinkedList<Intent>();
        this.zzckQ = new LinkedList<Intent>();
    }
    
    public static zzq zzJX() {
        synchronized (zzq.class) {
            if (zzq.zzckM == null) {
                zzq.zzckM = new zzq();
            }
            return zzq.zzckM;
        }
    }
    
    public static PendingIntent zza(final Context context, final int n, final Intent intent, final int n2) {
        return zza(context, 0, "com.google.firebase.INSTANCE_ID_EVENT", intent, 134217728);
    }
    
    private static PendingIntent zza(final Context context, final int n, final String action, final Intent intent, final int n2) {
        final Intent intent2 = new Intent(context, (Class)FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(action);
        intent2.putExtra("wrapped_intent", (Parcelable)intent);
        return PendingIntent.getBroadcast(context, n, intent2, n2);
    }
    
    public static PendingIntent zzb(final Context context, final int n, final Intent intent, final int n2) {
        return zza(context, n, "com.google.firebase.MESSAGING_EVENT", intent, 1073741824);
    }
    
    private final int zzf(final Context p0, final Intent p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/firebase/iid/zzq.zzckN:Landroid/support/v4/util/SimpleArrayMap;
        //     4: astore          4
        //     6: aload           4
        //     8: monitorenter   
        //     9: aload_0        
        //    10: getfield        com/google/firebase/iid/zzq.zzckN:Landroid/support/v4/util/SimpleArrayMap;
        //    13: aload_2        
        //    14: invokevirtual   android/content/Intent.getAction:()Ljava/lang/String;
        //    17: invokevirtual   android/support/v4/util/SimpleArrayMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    20: checkcast       Ljava/lang/String;
        //    23: astore          5
        //    25: aload           4
        //    27: monitorexit    
        //    28: aload           5
        //    30: astore          4
        //    32: aload           5
        //    34: ifnonnull       322
        //    37: aload_1        
        //    38: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //    41: aload_2        
        //    42: iconst_0       
        //    43: invokevirtual   android/content/pm/PackageManager.resolveService:(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
        //    46: astore          4
        //    48: aload           4
        //    50: ifnull          61
        //    53: aload           4
        //    55: getfield        android/content/pm/ResolveInfo.serviceInfo:Landroid/content/pm/ServiceInfo;
        //    58: ifnonnull       133
        //    61: ldc             "FirebaseInstanceId"
        //    63: ldc             "Failed to resolve target intent service, skipping classname enforcement"
        //    65: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //    68: pop            
        //    69: aload_0        
        //    70: getfield        com/google/firebase/iid/zzq.zzckO:Ljava/lang/Boolean;
        //    73: ifnonnull       95
        //    76: aload_1        
        //    77: ldc             "android.permission.WAKE_LOCK"
        //    79: invokevirtual   android/content/Context.checkCallingOrSelfPermission:(Ljava/lang/String;)I
        //    82: ifne            411
        //    85: iconst_1       
        //    86: istore_3       
        //    87: aload_0        
        //    88: iload_3        
        //    89: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    92: putfield        com/google/firebase/iid/zzq.zzckO:Ljava/lang/Boolean;
        //    95: aload_0        
        //    96: getfield        com/google/firebase/iid/zzq.zzckO:Ljava/lang/Boolean;
        //    99: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   102: ifeq            416
        //   105: aload_1        
        //   106: aload_2        
        //   107: invokestatic    android/support/v4/content/WakefulBroadcastReceiver.startWakefulService:(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;
        //   110: astore_1       
        //   111: aload_1        
        //   112: ifnonnull       447
        //   115: ldc             "FirebaseInstanceId"
        //   117: ldc             "Error while delivering the message: ServiceIntent not found."
        //   119: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   122: pop            
        //   123: sipush          404
        //   126: ireturn        
        //   127: astore_1       
        //   128: aload           4
        //   130: monitorexit    
        //   131: aload_1        
        //   132: athrow         
        //   133: aload           4
        //   135: getfield        android/content/pm/ResolveInfo.serviceInfo:Landroid/content/pm/ServiceInfo;
        //   138: astore          5
        //   140: aload_1        
        //   141: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   144: aload           5
        //   146: getfield        android/content/pm/ServiceInfo.packageName:Ljava/lang/String;
        //   149: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   152: ifeq            163
        //   155: aload           5
        //   157: getfield        android/content/pm/ServiceInfo.name:Ljava/lang/String;
        //   160: ifnonnull       242
        //   163: aload           5
        //   165: getfield        android/content/pm/ServiceInfo.packageName:Ljava/lang/String;
        //   168: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   171: astore          4
        //   173: aload           5
        //   175: getfield        android/content/pm/ServiceInfo.name:Ljava/lang/String;
        //   178: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   181: astore          5
        //   183: ldc             "FirebaseInstanceId"
        //   185: new             Ljava/lang/StringBuilder;
        //   188: dup            
        //   189: aload           4
        //   191: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   194: invokevirtual   java/lang/String.length:()I
        //   197: bipush          94
        //   199: iadd           
        //   200: aload           5
        //   202: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   205: invokevirtual   java/lang/String.length:()I
        //   208: iadd           
        //   209: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   212: ldc             "Error resolving target intent service, skipping classname enforcement. Resolved service was: "
        //   214: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   217: aload           4
        //   219: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   222: ldc             "/"
        //   224: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   227: aload           5
        //   229: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   232: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   235: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   238: pop            
        //   239: goto            69
        //   242: aload           5
        //   244: getfield        android/content/pm/ServiceInfo.name:Ljava/lang/String;
        //   247: astore          5
        //   249: aload           5
        //   251: astore          4
        //   253: aload           5
        //   255: ldc             "."
        //   257: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   260: ifeq            296
        //   263: aload_1        
        //   264: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   267: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   270: astore          4
        //   272: aload           5
        //   274: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   277: astore          5
        //   279: aload           5
        //   281: invokevirtual   java/lang/String.length:()I
        //   284: ifeq            377
        //   287: aload           4
        //   289: aload           5
        //   291: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   294: astore          4
        //   296: aload_0        
        //   297: getfield        com/google/firebase/iid/zzq.zzckN:Landroid/support/v4/util/SimpleArrayMap;
        //   300: astore          5
        //   302: aload           5
        //   304: monitorenter   
        //   305: aload_0        
        //   306: getfield        com/google/firebase/iid/zzq.zzckN:Landroid/support/v4/util/SimpleArrayMap;
        //   309: aload_2        
        //   310: invokevirtual   android/content/Intent.getAction:()Ljava/lang/String;
        //   313: aload           4
        //   315: invokevirtual   android/support/v4/util/SimpleArrayMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   318: pop            
        //   319: aload           5
        //   321: monitorexit    
        //   322: ldc             "FirebaseInstanceId"
        //   324: iconst_3       
        //   325: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   328: ifeq            363
        //   331: aload           4
        //   333: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   336: astore          5
        //   338: aload           5
        //   340: invokevirtual   java/lang/String.length:()I
        //   343: ifeq            397
        //   346: ldc             "Restricting intent to a specific service: "
        //   348: aload           5
        //   350: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   353: astore          5
        //   355: ldc             "FirebaseInstanceId"
        //   357: aload           5
        //   359: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   362: pop            
        //   363: aload_2        
        //   364: aload_1        
        //   365: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   368: aload           4
        //   370: invokevirtual   android/content/Intent.setClassName:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   373: pop            
        //   374: goto            69
        //   377: new             Ljava/lang/String;
        //   380: dup            
        //   381: aload           4
        //   383: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   386: astore          4
        //   388: goto            296
        //   391: astore_1       
        //   392: aload           5
        //   394: monitorexit    
        //   395: aload_1        
        //   396: athrow         
        //   397: new             Ljava/lang/String;
        //   400: dup            
        //   401: ldc             "Restricting intent to a specific service: "
        //   403: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   406: astore          5
        //   408: goto            355
        //   411: iconst_0       
        //   412: istore_3       
        //   413: goto            87
        //   416: aload_1        
        //   417: aload_2        
        //   418: invokevirtual   android/content/Context.startService:(Landroid/content/Intent;)Landroid/content/ComponentName;
        //   421: astore_1       
        //   422: ldc             "FirebaseInstanceId"
        //   424: ldc             "Missing wake lock permission, service start may be delayed"
        //   426: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   429: pop            
        //   430: goto            111
        //   433: astore_1       
        //   434: ldc             "FirebaseInstanceId"
        //   436: ldc             "Error while delivering the message to the serviceIntent"
        //   438: aload_1        
        //   439: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   442: pop            
        //   443: sipush          401
        //   446: ireturn        
        //   447: iconst_m1      
        //   448: ireturn        
        //   449: astore_1       
        //   450: aload_1        
        //   451: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   454: astore_1       
        //   455: ldc             "FirebaseInstanceId"
        //   457: new             Ljava/lang/StringBuilder;
        //   460: dup            
        //   461: aload_1        
        //   462: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   465: invokevirtual   java/lang/String.length:()I
        //   468: bipush          45
        //   470: iadd           
        //   471: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   474: ldc             "Failed to start service while in background: "
        //   476: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   479: aload_1        
        //   480: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   483: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   486: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   489: pop            
        //   490: sipush          402
        //   493: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  9      28     127    133    Any
        //  69     85     433    447    Ljava/lang/SecurityException;
        //  69     85     449    494    Ljava/lang/IllegalStateException;
        //  87     95     433    447    Ljava/lang/SecurityException;
        //  87     95     449    494    Ljava/lang/IllegalStateException;
        //  95     111    433    447    Ljava/lang/SecurityException;
        //  95     111    449    494    Ljava/lang/IllegalStateException;
        //  115    123    433    447    Ljava/lang/SecurityException;
        //  115    123    449    494    Ljava/lang/IllegalStateException;
        //  128    131    127    133    Any
        //  305    322    391    397    Any
        //  392    395    391    397    Any
        //  416    430    433    447    Ljava/lang/SecurityException;
        //  416    430    449    494    Ljava/lang/IllegalStateException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0069:
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
    
    public final Intent zzJY() {
        return this.zzckQ.poll();
    }
    
    public final int zza(final Context context, final String obj, final Intent intent) {
        switch (obj) {
            default: {
                final String value = String.valueOf(obj);
                String concat;
                if (value.length() != 0) {
                    concat = "Unknown service action: ".concat(value);
                }
                else {
                    concat = new String("Unknown service action: ");
                }
                Log.w("FirebaseInstanceId", concat);
                return 500;
            }
            case "com.google.firebase.INSTANCE_ID_EVENT": {
                this.zzckP.offer(intent);
                break;
            }
            case "com.google.firebase.MESSAGING_EVENT": {
                this.zzckQ.offer(intent);
                break;
            }
        }
        final Intent intent2 = new Intent(obj);
        intent2.setPackage(context.getPackageName());
        return this.zzf(context, intent2);
    }
    
    public final void zze(final Context context, final Intent intent) {
        this.zza(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }
}
