// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.Iterator;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

final class ListenerCallQueue<L> implements Runnable
{
    private static final Logger logger;
    private final Executor executor;
    @GuardedBy("this")
    private boolean isThreadScheduled;
    private final L listener;
    @GuardedBy("this")
    private final Queue<Callback<L>> waitQueue;
    
    static {
        logger = Logger.getLogger(ListenerCallQueue.class.getName());
    }
    
    ListenerCallQueue(final L l, final Executor executor) {
        this.waitQueue = (Queue<Callback<L>>)Queues.newArrayDeque();
        this.listener = Preconditions.checkNotNull(l);
        this.executor = Preconditions.checkNotNull(executor);
    }
    
    void add(final Callback<L> callback) {
        synchronized (this) {
            this.waitQueue.add(callback);
        }
    }
    
    void execute() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: aload_0        
        //     3: monitorenter   
        //     4: aload_0        
        //     5: getfield        com/google/common/util/concurrent/ListenerCallQueue.isThreadScheduled:Z
        //     8: ifne            18
        //    11: aload_0        
        //    12: iconst_1       
        //    13: putfield        com/google/common/util/concurrent/ListenerCallQueue.isThreadScheduled:Z
        //    16: iconst_1       
        //    17: istore_1       
        //    18: aload_0        
        //    19: monitorexit    
        //    20: iload_1        
        //    21: ifeq            34
        //    24: aload_0        
        //    25: getfield        com/google/common/util/concurrent/ListenerCallQueue.executor:Ljava/util/concurrent/Executor;
        //    28: aload_0        
        //    29: invokeinterface java/util/concurrent/Executor.execute:(Ljava/lang/Runnable;)V
        //    34: return         
        //    35: astore_2       
        //    36: aload_0        
        //    37: monitorexit    
        //    38: aload_2        
        //    39: athrow         
        //    40: astore_2       
        //    41: aload_0        
        //    42: monitorenter   
        //    43: aload_0        
        //    44: iconst_0       
        //    45: putfield        com/google/common/util/concurrent/ListenerCallQueue.isThreadScheduled:Z
        //    48: aload_0        
        //    49: monitorexit    
        //    50: getstatic       com/google/common/util/concurrent/ListenerCallQueue.logger:Ljava/util/logging/Logger;
        //    53: astore_3       
        //    54: getstatic       java/util/logging/Level.SEVERE:Ljava/util/logging/Level;
        //    57: astore          4
        //    59: aload_0        
        //    60: getfield        com/google/common/util/concurrent/ListenerCallQueue.listener:Ljava/lang/Object;
        //    63: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    66: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    69: astore          5
        //    71: aload_0        
        //    72: getfield        com/google/common/util/concurrent/ListenerCallQueue.executor:Ljava/util/concurrent/Executor;
        //    75: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    78: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    81: astore          6
        //    83: aload_3        
        //    84: aload           4
        //    86: new             Ljava/lang/StringBuilder;
        //    89: dup            
        //    90: aload           5
        //    92: invokevirtual   java/lang/String.length:()I
        //    95: bipush          42
        //    97: iadd           
        //    98: aload           6
        //   100: invokevirtual   java/lang/String.length:()I
        //   103: iadd           
        //   104: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   107: ldc             "Exception while running callbacks for "
        //   109: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: aload           5
        //   114: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   117: ldc             " on "
        //   119: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   122: aload           6
        //   124: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   127: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   130: aload_2        
        //   131: invokevirtual   java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   134: aload_2        
        //   135: athrow         
        //   136: astore_2       
        //   137: aload_0        
        //   138: monitorexit    
        //   139: aload_2        
        //   140: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  4      16     35     40     Any
        //  18     20     35     40     Any
        //  24     34     40     141    Ljava/lang/RuntimeException;
        //  36     38     35     40     Any
        //  43     50     136    141    Any
        //  137    139    136    141    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0034:
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
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3       
        //     2: iconst_1       
        //     3: istore_2       
        //     4: iload_2        
        //     5: istore_1       
        //     6: aload_0        
        //     7: monitorenter   
        //     8: iload_3        
        //     9: istore_1       
        //    10: aload_0        
        //    11: getfield        com/google/common/util/concurrent/ListenerCallQueue.isThreadScheduled:Z
        //    14: invokestatic    com/google/common/base/Preconditions.checkState:(Z)V
        //    17: iload_3        
        //    18: istore_1       
        //    19: aload_0        
        //    20: getfield        com/google/common/util/concurrent/ListenerCallQueue.waitQueue:Ljava/util/Queue;
        //    23: invokeinterface java/util/Queue.poll:()Ljava/lang/Object;
        //    28: checkcast       Lcom/google/common/util/concurrent/ListenerCallQueue$Callback;
        //    31: astore          8
        //    33: aload           8
        //    35: ifnonnull       63
        //    38: iload_3        
        //    39: istore_1       
        //    40: aload_0        
        //    41: iconst_0       
        //    42: putfield        com/google/common/util/concurrent/ListenerCallQueue.isThreadScheduled:Z
        //    45: iconst_0       
        //    46: istore_1       
        //    47: aload_0        
        //    48: monitorexit    
        //    49: iconst_0       
        //    50: ifeq            62
        //    53: aload_0        
        //    54: monitorenter   
        //    55: aload_0        
        //    56: iconst_0       
        //    57: putfield        com/google/common/util/concurrent/ListenerCallQueue.isThreadScheduled:Z
        //    60: aload_0        
        //    61: monitorexit    
        //    62: return         
        //    63: iload_3        
        //    64: istore_1       
        //    65: aload_0        
        //    66: monitorexit    
        //    67: iload_2        
        //    68: istore_1       
        //    69: aload           8
        //    71: aload_0        
        //    72: getfield        com/google/common/util/concurrent/ListenerCallQueue.listener:Ljava/lang/Object;
        //    75: invokevirtual   com/google/common/util/concurrent/ListenerCallQueue$Callback.call:(Ljava/lang/Object;)V
        //    78: goto            4
        //    81: astore          4
        //    83: iload_2        
        //    84: istore_1       
        //    85: getstatic       com/google/common/util/concurrent/ListenerCallQueue.logger:Ljava/util/logging/Logger;
        //    88: astore          5
        //    90: iload_2        
        //    91: istore_1       
        //    92: getstatic       java/util/logging/Level.SEVERE:Ljava/util/logging/Level;
        //    95: astore          6
        //    97: iload_2        
        //    98: istore_1       
        //    99: aload_0        
        //   100: getfield        com/google/common/util/concurrent/ListenerCallQueue.listener:Ljava/lang/Object;
        //   103: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   106: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   109: astore          7
        //   111: iload_2        
        //   112: istore_1       
        //   113: aload           8
        //   115: invokestatic    com/google/common/util/concurrent/ListenerCallQueue$Callback.access$000:(Lcom/google/common/util/concurrent/ListenerCallQueue$Callback;)Ljava/lang/String;
        //   118: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   121: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   124: astore          8
        //   126: iload_2        
        //   127: istore_1       
        //   128: aload           5
        //   130: aload           6
        //   132: new             Ljava/lang/StringBuilder;
        //   135: dup            
        //   136: aload           7
        //   138: invokevirtual   java/lang/String.length:()I
        //   141: bipush          37
        //   143: iadd           
        //   144: aload           8
        //   146: invokevirtual   java/lang/String.length:()I
        //   149: iadd           
        //   150: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   153: ldc             "Exception while executing callback: "
        //   155: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: aload           7
        //   160: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   163: ldc             "."
        //   165: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: aload           8
        //   170: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   176: aload           4
        //   178: invokevirtual   java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   181: goto            4
        //   184: astore          4
        //   186: iload_1        
        //   187: ifeq            199
        //   190: aload_0        
        //   191: monitorenter   
        //   192: aload_0        
        //   193: iconst_0       
        //   194: putfield        com/google/common/util/concurrent/ListenerCallQueue.isThreadScheduled:Z
        //   197: aload_0        
        //   198: monitorexit    
        //   199: aload           4
        //   201: athrow         
        //   202: astore          4
        //   204: aload_0        
        //   205: monitorexit    
        //   206: aload           4
        //   208: athrow         
        //   209: astore          4
        //   211: aload_0        
        //   212: monitorexit    
        //   213: aload           4
        //   215: athrow         
        //   216: astore          4
        //   218: aload_0        
        //   219: monitorexit    
        //   220: aload           4
        //   222: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  6      8      184    223    Any
        //  10     17     202    209    Any
        //  19     33     202    209    Any
        //  40     45     202    209    Any
        //  47     49     202    209    Any
        //  55     62     209    216    Any
        //  65     67     202    209    Any
        //  69     78     81     184    Ljava/lang/RuntimeException;
        //  69     78     184    223    Any
        //  85     90     184    223    Any
        //  92     97     184    223    Any
        //  99     111    184    223    Any
        //  113    126    184    223    Any
        //  128    181    184    223    Any
        //  192    199    216    223    Any
        //  204    206    202    209    Any
        //  206    209    184    223    Any
        //  211    213    209    216    Any
        //  218    220    216    223    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 128 out of bounds for length 128
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    abstract static class Callback<L>
    {
        private final String methodCall;
        
        Callback(final String methodCall) {
            this.methodCall = methodCall;
        }
        
        abstract void call(final L p0);
        
        void enqueueOn(final Iterable<ListenerCallQueue<L>> iterable) {
            final Iterator<ListenerCallQueue<L>> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                iterator.next().add(this);
            }
        }
    }
}
