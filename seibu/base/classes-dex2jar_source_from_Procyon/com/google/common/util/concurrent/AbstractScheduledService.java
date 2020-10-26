// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executor;
import com.google.common.base.Throwables;
import com.google.common.base.Supplier;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import com.google.common.annotations.Beta;

@Beta
public abstract class AbstractScheduledService implements Service
{
    private static final Logger logger;
    private final AbstractService delegate;
    
    static {
        logger = Logger.getLogger(AbstractScheduledService.class.getName());
    }
    
    protected AbstractScheduledService() {
        this.delegate = new AbstractService() {
            private volatile ScheduledExecutorService executorService;
            private final ReentrantLock lock = new ReentrantLock();
            private volatile Future<?> runningTask;
            private final Runnable task = new Runnable() {
                @Override
                public void run() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$1.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                    //     4: invokestatic    com/google/common/util/concurrent/AbstractScheduledService$1.access$100:(Lcom/google/common/util/concurrent/AbstractScheduledService$1;)Ljava/util/concurrent/locks/ReentrantLock;
                    //     7: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
                    //    10: aload_0        
                    //    11: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$1.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                    //    14: getfield        com/google/common/util/concurrent/AbstractScheduledService$1.this$0:Lcom/google/common/util/concurrent/AbstractScheduledService;
                    //    17: invokevirtual   com/google/common/util/concurrent/AbstractScheduledService.runOneIteration:()V
                    //    20: aload_0        
                    //    21: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$1.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                    //    24: invokestatic    com/google/common/util/concurrent/AbstractScheduledService$1.access$100:(Lcom/google/common/util/concurrent/AbstractScheduledService$1;)Ljava/util/concurrent/locks/ReentrantLock;
                    //    27: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
                    //    30: return         
                    //    31: astore_1       
                    //    32: aload_0        
                    //    33: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$1.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                    //    36: getfield        com/google/common/util/concurrent/AbstractScheduledService$1.this$0:Lcom/google/common/util/concurrent/AbstractScheduledService;
                    //    39: invokevirtual   com/google/common/util/concurrent/AbstractScheduledService.shutDown:()V
                    //    42: aload_0        
                    //    43: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$1.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                    //    46: aload_1        
                    //    47: invokevirtual   com/google/common/util/concurrent/AbstractScheduledService$1.notifyFailed:(Ljava/lang/Throwable;)V
                    //    50: aload_1        
                    //    51: invokestatic    com/google/common/base/Throwables.propagate:(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
                    //    54: athrow         
                    //    55: astore_1       
                    //    56: aload_0        
                    //    57: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$1.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                    //    60: invokestatic    com/google/common/util/concurrent/AbstractScheduledService$1.access$100:(Lcom/google/common/util/concurrent/AbstractScheduledService$1;)Ljava/util/concurrent/locks/ReentrantLock;
                    //    63: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
                    //    66: aload_1        
                    //    67: athrow         
                    //    68: astore_2       
                    //    69: invokestatic    com/google/common/util/concurrent/AbstractScheduledService.access$200:()Ljava/util/logging/Logger;
                    //    72: getstatic       java/util/logging/Level.WARNING:Ljava/util/logging/Level;
                    //    75: ldc             "Error while attempting to shut down the service after failure."
                    //    77: aload_2        
                    //    78: invokevirtual   java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
                    //    81: goto            42
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type                 
                    //  -----  -----  -----  -----  ---------------------
                    //  10     20     31     84     Ljava/lang/Throwable;
                    //  10     20     55     68     Any
                    //  32     42     68     84     Ljava/lang/Exception;
                    //  32     42     55     68     Any
                    //  42     55     55     68     Any
                    //  69     81     55     68     Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.IllegalStateException: Expression is linked from several locations: Label_0042:
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
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
                    //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
            
            @Override
            protected final void doStart() {
                (this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), new Supplier<String>() {
                    @Override
                    public String get() {
                        final String value = String.valueOf(String.valueOf(AbstractScheduledService.this.serviceName()));
                        final String value2 = String.valueOf(String.valueOf(AbstractService.this.state()));
                        return new StringBuilder(value.length() + 1 + value2.length()).append(value).append(" ").append(value2).toString();
                    }
                })).execute(new Runnable() {
                    @Override
                    public void run() {
                        AbstractService.this.lock.lock();
                        try {
                            AbstractScheduledService.this.startUp();
                            AbstractService.this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, AbstractService.this.executorService, AbstractService.this.task);
                            AbstractService.this.notifyStarted();
                        }
                        catch (Throwable t) {
                            AbstractService.this.notifyFailed(t);
                            throw Throwables.propagate(t);
                        }
                        finally {
                            AbstractService.this.lock.unlock();
                        }
                    }
                });
            }
            
            @Override
            protected final void doStop() {
                this.runningTask.cancel(false);
                this.executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //     4: invokestatic    com/google/common/util/concurrent/AbstractScheduledService$1.access$100:(Lcom/google/common/util/concurrent/AbstractScheduledService$1;)Ljava/util/concurrent/locks/ReentrantLock;
                        //     7: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
                        //    10: aload_0        
                        //    11: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //    14: invokevirtual   com/google/common/util/concurrent/AbstractScheduledService$1.state:()Lcom/google/common/util/concurrent/Service$State;
                        //    17: astore_1       
                        //    18: getstatic       com/google/common/util/concurrent/Service$State.STOPPING:Lcom/google/common/util/concurrent/Service$State;
                        //    21: astore_2       
                        //    22: aload_1        
                        //    23: aload_2        
                        //    24: if_acmpeq       38
                        //    27: aload_0        
                        //    28: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //    31: invokestatic    com/google/common/util/concurrent/AbstractScheduledService$1.access$100:(Lcom/google/common/util/concurrent/AbstractScheduledService$1;)Ljava/util/concurrent/locks/ReentrantLock;
                        //    34: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
                        //    37: return         
                        //    38: aload_0        
                        //    39: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //    42: getfield        com/google/common/util/concurrent/AbstractScheduledService$1.this$0:Lcom/google/common/util/concurrent/AbstractScheduledService;
                        //    45: invokevirtual   com/google/common/util/concurrent/AbstractScheduledService.shutDown:()V
                        //    48: aload_0        
                        //    49: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //    52: invokestatic    com/google/common/util/concurrent/AbstractScheduledService$1.access$100:(Lcom/google/common/util/concurrent/AbstractScheduledService$1;)Ljava/util/concurrent/locks/ReentrantLock;
                        //    55: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
                        //    58: aload_0        
                        //    59: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //    62: invokevirtual   com/google/common/util/concurrent/AbstractScheduledService$1.notifyStopped:()V
                        //    65: return         
                        //    66: astore_1       
                        //    67: aload_0        
                        //    68: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //    71: aload_1        
                        //    72: invokevirtual   com/google/common/util/concurrent/AbstractScheduledService$1.notifyFailed:(Ljava/lang/Throwable;)V
                        //    75: aload_1        
                        //    76: invokestatic    com/google/common/base/Throwables.propagate:(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
                        //    79: athrow         
                        //    80: astore_1       
                        //    81: aload_0        
                        //    82: getfield        com/google/common/util/concurrent/AbstractScheduledService$1$4.this$1:Lcom/google/common/util/concurrent/AbstractScheduledService$1;
                        //    85: invokestatic    com/google/common/util/concurrent/AbstractScheduledService$1.access$100:(Lcom/google/common/util/concurrent/AbstractScheduledService$1;)Ljava/util/concurrent/locks/ReentrantLock;
                        //    88: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
                        //    91: aload_1        
                        //    92: athrow         
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                 
                        //  -----  -----  -----  -----  ---------------------
                        //  0      10     66     80     Ljava/lang/Throwable;
                        //  10     22     80     93     Any
                        //  27     37     66     80     Ljava/lang/Throwable;
                        //  38     48     80     93     Any
                        //  48     65     66     80     Ljava/lang/Throwable;
                        //  81     93     66     80     Ljava/lang/Throwable;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
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
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
                });
            }
        };
    }
    
    @Override
    public final void addListener(final Listener listener, final Executor executor) {
        this.delegate.addListener(listener, executor);
    }
    
    @Override
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }
    
    @Override
    public final void awaitRunning(final long n, final TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(n, timeUnit);
    }
    
    @Override
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }
    
    @Override
    public final void awaitTerminated(final long n, final TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(n, timeUnit);
    }
    
    protected ScheduledExecutorService executor() {
        final ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        this.addListener(new Listener() {
            @Override
            public void failed(final State state, final Throwable t) {
                singleThreadScheduledExecutor.shutdown();
            }
            
            @Override
            public void terminated(final State state) {
                singleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return singleThreadScheduledExecutor;
    }
    
    @Override
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }
    
    @Override
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }
    
    protected abstract void runOneIteration() throws Exception;
    
    protected abstract Scheduler scheduler();
    
    protected String serviceName() {
        return this.getClass().getSimpleName();
    }
    
    protected void shutDown() throws Exception {
    }
    
    @Override
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }
    
    protected void startUp() throws Exception {
    }
    
    @Override
    public final State state() {
        return this.delegate.state();
    }
    
    @Override
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.serviceName()));
        final String value2 = String.valueOf(String.valueOf(this.state()));
        return new StringBuilder(value.length() + 3 + value2.length()).append(value).append(" [").append(value2).append("]").toString();
    }
    
    @Beta
    public abstract static class CustomScheduler extends Scheduler
    {
        protected abstract Schedule getNextSchedule() throws Exception;
        
        @Override
        final Future<?> schedule(final AbstractService abstractService, final ScheduledExecutorService scheduledExecutorService, final Runnable runnable) {
            final ReschedulableCallable reschedulableCallable = new ReschedulableCallable(abstractService, scheduledExecutorService, runnable);
            reschedulableCallable.reschedule();
            return reschedulableCallable;
        }
        
        private class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void>
        {
            @GuardedBy("lock")
            private Future<Void> currentFuture;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock;
            private final AbstractService service;
            private final Runnable wrappedRunnable;
            
            ReschedulableCallable(final AbstractService service, final ScheduledExecutorService executor, final Runnable wrappedRunnable) {
                this.lock = new ReentrantLock();
                this.wrappedRunnable = wrappedRunnable;
                this.executor = executor;
                this.service = service;
            }
            
            @Override
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                this.reschedule();
                return null;
            }
            
            @Override
            public boolean cancel(final boolean b) {
                this.lock.lock();
                try {
                    return this.currentFuture.cancel(b);
                }
                finally {
                    this.lock.unlock();
                }
            }
            
            @Override
            protected Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel is supported by this future");
            }
            
            public void reschedule() {
                this.lock.lock();
                try {
                    if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                        final Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                        this.currentFuture = (Future<Void>)this.executor.schedule((Callable<Object>)this, nextSchedule.delay, nextSchedule.unit);
                    }
                }
                catch (Throwable t) {
                    this.service.notifyFailed(t);
                }
                finally {
                    this.lock.unlock();
                }
            }
        }
        
        @Beta
        protected static final class Schedule
        {
            private final long delay;
            private final TimeUnit unit;
            
            public Schedule(final long delay, final TimeUnit timeUnit) {
                this.delay = delay;
                this.unit = Preconditions.checkNotNull(timeUnit);
            }
        }
    }
    
    public abstract static class Scheduler
    {
        private Scheduler() {
        }
        
        public static Scheduler newFixedDelaySchedule(final long n, final long n2, final TimeUnit timeUnit) {
            return new Scheduler() {
                public Future<?> schedule(final AbstractService abstractService, final ScheduledExecutorService scheduledExecutorService, final Runnable runnable) {
                    return scheduledExecutorService.scheduleWithFixedDelay(runnable, n, n2, timeUnit);
                }
            };
        }
        
        public static Scheduler newFixedRateSchedule(final long n, final long n2, final TimeUnit timeUnit) {
            return new Scheduler() {
                public Future<?> schedule(final AbstractService abstractService, final ScheduledExecutorService scheduledExecutorService, final Runnable runnable) {
                    return scheduledExecutorService.scheduleAtFixedRate(runnable, n, n2, timeUnit);
                }
            };
        }
        
        abstract Future<?> schedule(final AbstractService p0, final ScheduledExecutorService p1, final Runnable p2);
    }
}
