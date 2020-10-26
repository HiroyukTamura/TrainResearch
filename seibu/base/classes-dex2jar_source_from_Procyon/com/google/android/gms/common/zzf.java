// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import com.google.android.gms.common.internal.zzay;

final class zzf
{
    private static zzay zzaAd;
    private static final Object zzaAe;
    private static Context zzaAf;
    
    static {
        zzaAe = new Object();
    }
    
    static boolean zza(final String s, final zzg zzg) {
        return zza(s, zzg, false);
    }
    
    private static boolean zza(final String s, final zzg zzg, final boolean b) {
        if (!zzoX()) {
            return false;
        }
        zzbo.zzu(zzf.zzaAf);
        try {
            return zzf.zzaAd.zza(new zzm(s, zzg, b), zzn.zzw(zzf.zzaAf.getPackageManager()));
        }
        catch (RemoteException ex) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex);
            return false;
        }
    }
    
    static void zzav(final Context context) {
        synchronized (zzf.class) {
            if (zzf.zzaAf == null) {
                if (context != null) {
                    zzf.zzaAf = context.getApplicationContext();
                }
            }
            else {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            }
        }
    }
    
    static boolean zzb(final String s, final zzg zzg) {
        return zza(s, zzg, true);
    }
    
    private static boolean zzoX() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifnull          8
        //     6: iconst_1       
        //     7: ireturn        
        //     8: getstatic       com/google/android/gms/common/zzf.zzaAf:Landroid/content/Context;
        //    11: invokestatic    com/google/android/gms/common/internal/zzbo.zzu:(Ljava/lang/Object;)Ljava/lang/Object;
        //    14: pop            
        //    15: getstatic       com/google/android/gms/common/zzf.zzaAe:Ljava/lang/Object;
        //    18: astore_0       
        //    19: aload_0        
        //    20: monitorenter   
        //    21: getstatic       com/google/android/gms/common/zzf.zzaAd:Lcom/google/android/gms/common/internal/zzay;
        //    24: astore_1       
        //    25: aload_1        
        //    26: ifnonnull       51
        //    29: getstatic       com/google/android/gms/common/zzf.zzaAf:Landroid/content/Context;
        //    32: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSP:Lcom/google/android/gms/dynamite/DynamiteModule$zzd;
        //    35: ldc             "com.google.android.gms.googlecertificates"
        //    37: invokestatic    com/google/android/gms/dynamite/DynamiteModule.zza:(Landroid/content/Context;Lcom/google/android/gms/dynamite/DynamiteModule$zzd;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
        //    40: ldc             "com.google.android.gms.common.GoogleCertificatesImpl"
        //    42: invokevirtual   com/google/android/gms/dynamite/DynamiteModule.zzcV:(Ljava/lang/String;)Landroid/os/IBinder;
        //    45: invokestatic    com/google/android/gms/common/internal/zzaz.zzJ:(Landroid/os/IBinder;)Lcom/google/android/gms/common/internal/zzay;
        //    48: putstatic       com/google/android/gms/common/zzf.zzaAd:Lcom/google/android/gms/common/internal/zzay;
        //    51: aload_0        
        //    52: monitorexit    
        //    53: iconst_1       
        //    54: ireturn        
        //    55: astore_1       
        //    56: aload_0        
        //    57: monitorexit    
        //    58: aload_1        
        //    59: athrow         
        //    60: astore_1       
        //    61: ldc             "GoogleCertificates"
        //    63: ldc             "Failed to load com.google.android.gms.googlecertificates"
        //    65: aload_1        
        //    66: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    69: pop            
        //    70: aload_0        
        //    71: monitorexit    
        //    72: iconst_0       
        //    73: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                
        //  -----  -----  -----  -----  ----------------------------------------------------
        //  21     25     55     60     Any
        //  29     51     60     74     Lcom/google/android/gms/dynamite/DynamiteModule$zzc;
        //  29     51     55     60     Any
        //  51     53     55     60     Any
        //  56     58     55     60     Any
        //  61     72     55     60     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0051:
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
}
