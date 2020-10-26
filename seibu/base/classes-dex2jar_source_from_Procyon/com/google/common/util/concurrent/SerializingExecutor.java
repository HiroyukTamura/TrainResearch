// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
import java.util.logging.Logger;
import java.util.concurrent.Executor;

final class SerializingExecutor implements Executor
{
    private static final Logger log;
    private final Executor executor;
    private final Object internalLock;
    @GuardedBy("internalLock")
    private boolean isThreadScheduled;
    private final TaskRunner taskRunner;
    @GuardedBy("internalLock")
    private final Queue<Runnable> waitQueue;
    
    static {
        log = Logger.getLogger(SerializingExecutor.class.getName());
    }
    
    public SerializingExecutor(final Executor executor) {
        this.waitQueue = new ArrayDeque<Runnable>();
        this.isThreadScheduled = false;
        this.taskRunner = new TaskRunner();
        this.internalLock = new Object() {
            @Override
            public String toString() {
                final String value = String.valueOf(super.toString());
                if (value.length() != 0) {
                    return "SerializingExecutor lock: ".concat(value);
                }
                return new String("SerializingExecutor lock: ");
            }
        };
        Preconditions.checkNotNull(executor, (Object)"'executor' must not be null.");
        this.executor = executor;
    }
    
    @Override
    public void execute(final Runnable p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "'r' must not be null."
        //     3: invokestatic    com/google/common/base/Preconditions.checkNotNull:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //     6: pop            
        //     7: iconst_0       
        //     8: istore_2       
        //     9: aload_0        
        //    10: getfield        com/google/common/util/concurrent/SerializingExecutor.internalLock:Ljava/lang/Object;
        //    13: astore_3       
        //    14: aload_3        
        //    15: monitorenter   
        //    16: aload_0        
        //    17: getfield        com/google/common/util/concurrent/SerializingExecutor.waitQueue:Ljava/util/Queue;
        //    20: aload_1        
        //    21: invokeinterface java/util/Queue.add:(Ljava/lang/Object;)Z
        //    26: pop            
        //    27: aload_0        
        //    28: getfield        com/google/common/util/concurrent/SerializingExecutor.isThreadScheduled:Z
        //    31: ifne            41
        //    34: aload_0        
        //    35: iconst_1       
        //    36: putfield        com/google/common/util/concurrent/SerializingExecutor.isThreadScheduled:Z
        //    39: iconst_1       
        //    40: istore_2       
        //    41: aload_3        
        //    42: monitorexit    
        //    43: iload_2        
        //    44: ifeq            78
        //    47: aload_0        
        //    48: getfield        com/google/common/util/concurrent/SerializingExecutor.executor:Ljava/util/concurrent/Executor;
        //    51: aload_0        
        //    52: getfield        com/google/common/util/concurrent/SerializingExecutor.taskRunner:Lcom/google/common/util/concurrent/SerializingExecutor$TaskRunner;
        //    55: invokeinterface java/util/concurrent/Executor.execute:(Ljava/lang/Runnable;)V
        //    60: iconst_0       
        //    61: ifeq            78
        //    64: aload_0        
        //    65: getfield        com/google/common/util/concurrent/SerializingExecutor.internalLock:Ljava/lang/Object;
        //    68: astore_1       
        //    69: aload_1        
        //    70: monitorenter   
        //    71: aload_0        
        //    72: iconst_0       
        //    73: putfield        com/google/common/util/concurrent/SerializingExecutor.isThreadScheduled:Z
        //    76: aload_1        
        //    77: monitorexit    
        //    78: return         
        //    79: astore_1       
        //    80: aload_3        
        //    81: monitorexit    
        //    82: aload_1        
        //    83: athrow         
        //    84: astore_3       
        //    85: aload_1        
        //    86: monitorexit    
        //    87: aload_3        
        //    88: athrow         
        //    89: astore_3       
        //    90: iconst_1       
        //    91: ifeq            108
        //    94: aload_0        
        //    95: getfield        com/google/common/util/concurrent/SerializingExecutor.internalLock:Ljava/lang/Object;
        //    98: astore_1       
        //    99: aload_1        
        //   100: monitorenter   
        //   101: aload_0        
        //   102: iconst_0       
        //   103: putfield        com/google/common/util/concurrent/SerializingExecutor.isThreadScheduled:Z
        //   106: aload_1        
        //   107: monitorexit    
        //   108: aload_3        
        //   109: athrow         
        //   110: astore_3       
        //   111: aload_1        
        //   112: monitorexit    
        //   113: aload_3        
        //   114: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  16     27     79     84     Any
        //  27     39     79     84     Any
        //  41     43     79     84     Any
        //  47     60     89     115    Any
        //  71     78     84     89     Any
        //  80     82     79     84     Any
        //  85     87     84     89     Any
        //  101    108    110    115    Any
        //  111    113    110    115    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0078:
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
    
    private class TaskRunner implements Runnable
    {
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
            //     7: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //    10: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$100:(Lcom/google/common/util/concurrent/SerializingExecutor;)Z
            //    13: invokestatic    com/google/common/base/Preconditions.checkState:(Z)V
            //    16: iload_2        
            //    17: istore_1       
            //    18: aload_0        
            //    19: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //    22: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$200:(Lcom/google/common/util/concurrent/SerializingExecutor;)Ljava/lang/Object;
            //    25: astore          5
            //    27: iload_2        
            //    28: istore_1       
            //    29: aload           5
            //    31: monitorenter   
            //    32: iload_3        
            //    33: istore_1       
            //    34: aload_0        
            //    35: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //    38: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$300:(Lcom/google/common/util/concurrent/SerializingExecutor;)Ljava/util/Queue;
            //    41: invokeinterface java/util/Queue.poll:()Ljava/lang/Object;
            //    46: checkcast       Ljava/lang/Runnable;
            //    49: astore          4
            //    51: aload           4
            //    53: ifnonnull       101
            //    56: iload_3        
            //    57: istore_1       
            //    58: aload_0        
            //    59: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //    62: iconst_0       
            //    63: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$102:(Lcom/google/common/util/concurrent/SerializingExecutor;Z)Z
            //    66: pop            
            //    67: iconst_0       
            //    68: istore_1       
            //    69: aload           5
            //    71: monitorexit    
            //    72: iconst_0       
            //    73: ifeq            100
            //    76: aload_0        
            //    77: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //    80: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$200:(Lcom/google/common/util/concurrent/SerializingExecutor;)Ljava/lang/Object;
            //    83: astore          4
            //    85: aload           4
            //    87: monitorenter   
            //    88: aload_0        
            //    89: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //    92: iconst_0       
            //    93: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$102:(Lcom/google/common/util/concurrent/SerializingExecutor;Z)Z
            //    96: pop            
            //    97: aload           4
            //    99: monitorexit    
            //   100: return         
            //   101: iload_3        
            //   102: istore_1       
            //   103: aload           5
            //   105: monitorexit    
            //   106: iload_2        
            //   107: istore_1       
            //   108: aload           4
            //   110: invokeinterface java/lang/Runnable.run:()V
            //   115: goto            4
            //   118: astore          5
            //   120: iload_2        
            //   121: istore_1       
            //   122: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$400:()Ljava/util/logging/Logger;
            //   125: astore          6
            //   127: iload_2        
            //   128: istore_1       
            //   129: getstatic       java/util/logging/Level.SEVERE:Ljava/util/logging/Level;
            //   132: astore          7
            //   134: iload_2        
            //   135: istore_1       
            //   136: aload           4
            //   138: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   141: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   144: astore          4
            //   146: iload_2        
            //   147: istore_1       
            //   148: aload           6
            //   150: aload           7
            //   152: new             Ljava/lang/StringBuilder;
            //   155: dup            
            //   156: aload           4
            //   158: invokevirtual   java/lang/String.length:()I
            //   161: bipush          35
            //   163: iadd           
            //   164: invokespecial   java/lang/StringBuilder.<init>:(I)V
            //   167: ldc             "Exception while executing runnable "
            //   169: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   172: aload           4
            //   174: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   177: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   180: aload           5
            //   182: invokevirtual   java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   185: goto            4
            //   188: astore          5
            //   190: iload_1        
            //   191: ifeq            218
            //   194: aload_0        
            //   195: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //   198: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$200:(Lcom/google/common/util/concurrent/SerializingExecutor;)Ljava/lang/Object;
            //   201: astore          4
            //   203: aload           4
            //   205: monitorenter   
            //   206: aload_0        
            //   207: getfield        com/google/common/util/concurrent/SerializingExecutor$TaskRunner.this$0:Lcom/google/common/util/concurrent/SerializingExecutor;
            //   210: iconst_0       
            //   211: invokestatic    com/google/common/util/concurrent/SerializingExecutor.access$102:(Lcom/google/common/util/concurrent/SerializingExecutor;Z)Z
            //   214: pop            
            //   215: aload           4
            //   217: monitorexit    
            //   218: aload           5
            //   220: athrow         
            //   221: astore          4
            //   223: aload           5
            //   225: monitorexit    
            //   226: aload           4
            //   228: athrow         
            //   229: astore          5
            //   231: aload           4
            //   233: monitorexit    
            //   234: aload           5
            //   236: athrow         
            //   237: astore          5
            //   239: aload           4
            //   241: monitorexit    
            //   242: aload           5
            //   244: athrow         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                        
            //  -----  -----  -----  -----  ----------------------------
            //  6      16     188    245    Any
            //  18     27     188    245    Any
            //  29     32     188    245    Any
            //  34     51     221    229    Any
            //  58     67     221    229    Any
            //  69     72     221    229    Any
            //  88     100    229    237    Any
            //  103    106    221    229    Any
            //  108    115    118    188    Ljava/lang/RuntimeException;
            //  108    115    188    245    Any
            //  122    127    188    245    Any
            //  129    134    188    245    Any
            //  136    146    188    245    Any
            //  148    185    188    245    Any
            //  206    218    237    245    Any
            //  223    226    221    229    Any
            //  226    229    188    245    Any
            //  231    234    229    237    Any
            //  239    242    237    245    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index 133 out of bounds for length 133
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
}
