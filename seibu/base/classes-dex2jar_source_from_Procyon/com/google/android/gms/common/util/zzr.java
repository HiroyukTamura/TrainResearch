// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.os.Process;

public final class zzr
{
    private static String zzaJW;
    private static final int zzaJX;
    
    static {
        zzr.zzaJW = null;
        zzaJX = Process.myPid();
    }
    
    private static String zzaD(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifgt            6
        //     4: aconst_null    
        //     5: areturn        
        //     6: invokestatic    android/os/StrictMode.allowThreadDiskReads:()Landroid/os/StrictMode$ThreadPolicy;
        //     9: astore_2       
        //    10: new             Ljava/io/BufferedReader;
        //    13: dup            
        //    14: new             Ljava/io/FileReader;
        //    17: dup            
        //    18: new             Ljava/lang/StringBuilder;
        //    21: dup            
        //    22: bipush          25
        //    24: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //    27: ldc             "/proc/"
        //    29: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    32: iload_0        
        //    33: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    36: ldc             "/cmdline"
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    41: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    44: invokespecial   java/io/FileReader.<init>:(Ljava/lang/String;)V
        //    47: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    50: astore_1       
        //    51: aload_2        
        //    52: invokestatic    android/os/StrictMode.setThreadPolicy:(Landroid/os/StrictMode$ThreadPolicy;)V
        //    55: aload_1        
        //    56: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    59: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    62: astore_2       
        //    63: aload_1        
        //    64: invokestatic    com/google/android/gms/common/util/zzn.closeQuietly:(Ljava/io/Closeable;)V
        //    67: aload_2        
        //    68: areturn        
        //    69: astore_1       
        //    70: aload_2        
        //    71: invokestatic    android/os/StrictMode.setThreadPolicy:(Landroid/os/StrictMode$ThreadPolicy;)V
        //    74: aload_1        
        //    75: athrow         
        //    76: astore_1       
        //    77: aconst_null    
        //    78: astore_1       
        //    79: aload_1        
        //    80: invokestatic    com/google/android/gms/common/util/zzn.closeQuietly:(Ljava/io/Closeable;)V
        //    83: aconst_null    
        //    84: areturn        
        //    85: astore_1       
        //    86: aconst_null    
        //    87: astore_3       
        //    88: aload_1        
        //    89: astore_2       
        //    90: aload_3        
        //    91: invokestatic    com/google/android/gms/common/util/zzn.closeQuietly:(Ljava/io/Closeable;)V
        //    94: aload_2        
        //    95: athrow         
        //    96: astore_2       
        //    97: aload_1        
        //    98: astore_3       
        //    99: goto            90
        //   102: astore_2       
        //   103: goto            79
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      10     76     79     Ljava/io/IOException;
        //  6      10     85     90     Any
        //  10     51     69     76     Any
        //  51     63     102    106    Ljava/io/IOException;
        //  51     63     96     102    Any
        //  70     76     76     79     Ljava/io/IOException;
        //  70     76     85     90     Any
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
    
    public static String zzsf() {
        if (zzr.zzaJW == null) {
            zzr.zzaJW = zzaD(zzr.zzaJX);
        }
        return zzr.zzaJW;
    }
}
