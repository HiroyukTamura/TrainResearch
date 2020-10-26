// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executor;
import com.google.common.base.Supplier;
import java.util.logging.Logger;
import com.google.common.annotations.Beta;

@Beta
public abstract class AbstractExecutionThreadService implements Service
{
    private static final Logger logger;
    private final Service delegate;
    
    static {
        logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    }
    
    protected AbstractExecutionThreadService() {
        this.delegate = new AbstractService() {
            @Override
            protected final void doStart() {
                MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), new Supplier<String>() {
                    @Override
                    public String get() {
                        return AbstractExecutionThreadService.this.serviceName();
                    }
                }).execute(new Runnable() {
                    @Override
                    public void run() {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //     4: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1.this$0:Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
                        //     7: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService.startUp:()V
                        //    10: aload_0        
                        //    11: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //    14: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService$1.notifyStarted:()V
                        //    17: aload_0        
                        //    18: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //    21: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService$1.isRunning:()Z
                        //    24: istore_1       
                        //    25: iload_1        
                        //    26: ifeq            39
                        //    29: aload_0        
                        //    30: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //    33: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1.this$0:Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
                        //    36: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService.run:()V
                        //    39: aload_0        
                        //    40: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //    43: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1.this$0:Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
                        //    46: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService.shutDown:()V
                        //    49: aload_0        
                        //    50: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //    53: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService$1.notifyStopped:()V
                        //    56: return         
                        //    57: astore_2       
                        //    58: aload_0        
                        //    59: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //    62: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1.this$0:Lcom/google/common/util/concurrent/AbstractExecutionThreadService;
                        //    65: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService.shutDown:()V
                        //    68: aload_2        
                        //    69: athrow         
                        //    70: astore_2       
                        //    71: aload_0        
                        //    72: getfield        com/google/common/util/concurrent/AbstractExecutionThreadService$1$2.this$1:Lcom/google/common/util/concurrent/AbstractExecutionThreadService$1;
                        //    75: aload_2        
                        //    76: invokevirtual   com/google/common/util/concurrent/AbstractExecutionThreadService$1.notifyFailed:(Ljava/lang/Throwable;)V
                        //    79: aload_2        
                        //    80: invokestatic    com/google/common/base/Throwables.propagate:(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
                        //    83: athrow         
                        //    84: astore_3       
                        //    85: invokestatic    com/google/common/util/concurrent/AbstractExecutionThreadService.access$000:()Ljava/util/logging/Logger;
                        //    88: getstatic       java/util/logging/Level.WARNING:Ljava/util/logging/Level;
                        //    91: ldc             "Error while attempting to shut down the service after failure."
                        //    93: aload_3        
                        //    94: invokevirtual   java/util/logging/Logger.log:(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
                        //    97: goto            68
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                 
                        //  -----  -----  -----  -----  ---------------------
                        //  0      25     70     84     Ljava/lang/Throwable;
                        //  29     39     57     100    Ljava/lang/Throwable;
                        //  39     56     70     84     Ljava/lang/Throwable;
                        //  58     68     84     100    Ljava/lang/Exception;
                        //  58     68     70     84     Ljava/lang/Throwable;
                        //  68     70     70     84     Ljava/lang/Throwable;
                        //  85     97     70     84     Ljava/lang/Throwable;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
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
            
            @Override
            protected void doStop() {
                AbstractExecutionThreadService.this.triggerShutdown();
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
    
    protected Executor executor() {
        return new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), runnable).start();
            }
        };
    }
    
    @Override
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }
    
    @Override
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }
    
    protected abstract void run() throws Exception;
    
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
    
    protected void triggerShutdown() {
    }
}
