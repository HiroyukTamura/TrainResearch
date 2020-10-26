// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.internal;

import java.io.Closeable;

public final class Compose
{
    private Compose() {
    }
    
    public static Runnable closeables(final Closeable closeable, final Closeable closeable2) {
        return new Runnable() {
            @Override
            public void run() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getfield        com/annimon/stream/internal/Compose$2.val$a:Ljava/io/Closeable;
                //     4: invokeinterface java/io/Closeable.close:()V
                //     9: aload_0        
                //    10: getfield        com/annimon/stream/internal/Compose$2.val$b:Ljava/io/Closeable;
                //    13: invokeinterface java/io/Closeable.close:()V
                //    18: return         
                //    19: astore_1       
                //    20: aload_0        
                //    21: getfield        com/annimon/stream/internal/Compose$2.val$b:Ljava/io/Closeable;
                //    24: invokeinterface java/io/Closeable.close:()V
                //    29: aload_1        
                //    30: instanceof      Ljava/lang/RuntimeException;
                //    33: ifeq            41
                //    36: aload_1        
                //    37: checkcast       Ljava/lang/RuntimeException;
                //    40: athrow         
                //    41: aload_1        
                //    42: checkcast       Ljava/lang/Error;
                //    45: athrow         
                //    46: astore_1       
                //    47: aload_1        
                //    48: instanceof      Ljava/lang/RuntimeException;
                //    51: ifeq            59
                //    54: aload_1        
                //    55: checkcast       Ljava/lang/RuntimeException;
                //    58: athrow         
                //    59: aload_1        
                //    60: instanceof      Ljava/lang/Error;
                //    63: ifeq            71
                //    66: aload_1        
                //    67: checkcast       Ljava/lang/Error;
                //    70: athrow         
                //    71: new             Ljava/lang/RuntimeException;
                //    74: dup            
                //    75: aload_1        
                //    76: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
                //    79: athrow         
                //    80: astore_2       
                //    81: goto            29
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  0      9      19     46     Ljava/lang/Throwable;
                //  9      18     46     80     Ljava/lang/Throwable;
                //  20     29     80     84     Ljava/lang/Throwable;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 40 out of bounds for length 40
                //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
                //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
                //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
                //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
        };
    }
    
    public static Runnable runnables(final Runnable runnable, final Runnable runnable2) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                    runnable2.run();
                }
                catch (Throwable t) {
                    try {
                        runnable2.run();
                        if (t instanceof RuntimeException) {
                            throw (RuntimeException)t;
                        }
                        throw (Error)t;
                    }
                    catch (Throwable t2) {}
                }
            }
        };
    }
}
