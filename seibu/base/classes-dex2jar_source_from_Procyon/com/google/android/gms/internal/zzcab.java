// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.Context;

public final class zzcab
{
    private zzcac zzaXG;
    private boolean zzuH;
    
    public zzcab() {
        this.zzuH = false;
        this.zzaXG = null;
    }
    
    public final void initialize(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/google/android/gms/internal/zzcab.zzuH:Z
        //     6: ifeq            12
        //     9: aload_0        
        //    10: monitorexit    
        //    11: return         
        //    12: aload_0        
        //    13: aload_1        
        //    14: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSP:Lcom/google/android/gms/dynamite/DynamiteModule$zzd;
        //    17: ldc             "com.google.android.gms.flags"
        //    19: invokestatic    com/google/android/gms/dynamite/DynamiteModule.zza:(Landroid/content/Context;Lcom/google/android/gms/dynamite/DynamiteModule$zzd;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
        //    22: ldc             "com.google.android.gms.flags.impl.FlagProviderImpl"
        //    24: invokevirtual   com/google/android/gms/dynamite/DynamiteModule.zzcV:(Ljava/lang/String;)Landroid/os/IBinder;
        //    27: invokestatic    com/google/android/gms/internal/zzcad.asInterface:(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzcac;
        //    30: putfield        com/google/android/gms/internal/zzcab.zzaXG:Lcom/google/android/gms/internal/zzcac;
        //    33: aload_0        
        //    34: getfield        com/google/android/gms/internal/zzcab.zzaXG:Lcom/google/android/gms/internal/zzcac;
        //    37: aload_1        
        //    38: invokestatic    com/google/android/gms/dynamic/zzn.zzw:(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
        //    41: invokeinterface com/google/android/gms/internal/zzcac.init:(Lcom/google/android/gms/dynamic/IObjectWrapper;)V
        //    46: aload_0        
        //    47: iconst_1       
        //    48: putfield        com/google/android/gms/internal/zzcab.zzuH:Z
        //    51: aload_0        
        //    52: monitorexit    
        //    53: return         
        //    54: astore_1       
        //    55: aload_0        
        //    56: monitorexit    
        //    57: aload_1        
        //    58: athrow         
        //    59: astore_1       
        //    60: ldc             "FlagValueProvider"
        //    62: ldc             "Failed to initialize flags module."
        //    64: aload_1        
        //    65: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    68: pop            
        //    69: goto            51
        //    72: astore_1       
        //    73: goto            60
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                
        //  -----  -----  -----  -----  ----------------------------------------------------
        //  2      11     54     59     Any
        //  12     51     72     76     Lcom/google/android/gms/dynamite/DynamiteModule$zzc;
        //  12     51     59     60     Landroid/os/RemoteException;
        //  12     51     54     59     Any
        //  51     53     54     59     Any
        //  55     57     54     59     Any
        //  60     69     54     59     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0012:
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
    
    public final <T> T zzb(final zzbzu<T> zzbzu) {
        synchronized (this) {
            if (!this.zzuH) {
                return zzbzu.zzdI();
            }
            return zzbzu.zza(this.zzaXG);
        }
    }
}
