// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.Context;

public final class zzbgy
{
    private static Context zzaKh;
    private static Boolean zzaKi;
    
    public static boolean zzaN(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: monitorenter   
        //     3: aload_0        
        //     4: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
        //     7: astore_2       
        //     8: getstatic       com/google/android/gms/internal/zzbgy.zzaKh:Landroid/content/Context;
        //    11: ifnull          39
        //    14: getstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //    17: ifnull          39
        //    20: getstatic       com/google/android/gms/internal/zzbgy.zzaKh:Landroid/content/Context;
        //    23: aload_2        
        //    24: if_acmpne       39
        //    27: getstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //    30: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //    33: istore_1       
        //    34: ldc             Lcom/google/android/gms/internal/zzbgy;.class
        //    36: monitorexit    
        //    37: iload_1        
        //    38: ireturn        
        //    39: aconst_null    
        //    40: putstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //    43: invokestatic    com/google/android/gms/common/util/zzq.isAtLeastO:()Z
        //    46: istore_1       
        //    47: iload_1        
        //    48: ifeq            109
        //    51: ldc             Landroid/content/pm/PackageManager;.class
        //    53: ldc             "isInstantApp"
        //    55: iconst_0       
        //    56: anewarray       Ljava/lang/Class;
        //    59: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    62: aload_2        
        //    63: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //    66: iconst_0       
        //    67: anewarray       Ljava/lang/Object;
        //    70: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    73: checkcast       Ljava/lang/Boolean;
        //    76: putstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //    79: aload_2        
        //    80: putstatic       com/google/android/gms/internal/zzbgy.zzaKh:Landroid/content/Context;
        //    83: getstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //    86: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //    89: istore_1       
        //    90: goto            34
        //    93: iconst_0       
        //    94: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    97: putstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //   100: goto            79
        //   103: astore_0       
        //   104: ldc             Lcom/google/android/gms/internal/zzbgy;.class
        //   106: monitorexit    
        //   107: aload_0        
        //   108: athrow         
        //   109: aload_0        
        //   110: invokevirtual   android/content/Context.getClassLoader:()Ljava/lang/ClassLoader;
        //   113: ldc             "com.google.android.instantapps.supervisor.InstantAppsRuntime"
        //   115: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //   118: pop            
        //   119: iconst_1       
        //   120: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   123: putstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //   126: goto            79
        //   129: astore_0       
        //   130: iconst_0       
        //   131: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   134: putstatic       com/google/android/gms/internal/zzbgy.zzaKi:Ljava/lang/Boolean;
        //   137: goto            79
        //   140: astore_0       
        //   141: goto            93
        //   144: astore_0       
        //   145: goto            93
        //   148: astore_0       
        //   149: goto            93
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                         
        //  -----  -----  -----  -----  ---------------------------------------------
        //  3      34     103    109    Any
        //  39     47     103    109    Any
        //  51     79     140    144    Ljava/lang/NoSuchMethodException;
        //  51     79     144    148    Ljava/lang/reflect/InvocationTargetException;
        //  51     79     148    152    Ljava/lang/IllegalAccessException;
        //  51     79     103    109    Any
        //  79     90     103    109    Any
        //  93     100    103    109    Any
        //  109    126    129    140    Ljava/lang/ClassNotFoundException;
        //  109    126    103    109    Any
        //  130    137    103    109    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0079:
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
