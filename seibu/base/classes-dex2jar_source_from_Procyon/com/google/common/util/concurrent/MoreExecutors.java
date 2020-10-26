// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.Future;
import java.util.concurrent.BlockingQueue;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Executor;
import com.google.common.annotations.Beta;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public final class MoreExecutors
{
    private MoreExecutors() {
    }
    
    @Beta
    public static void addDelayedShutdownHook(final ExecutorService executorService, final long n, final TimeUnit timeUnit) {
        new Application().addDelayedShutdownHook(executorService, n, timeUnit);
    }
    
    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }
    
    @Beta
    public static ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor) {
        return new Application().getExitingExecutorService(threadPoolExecutor);
    }
    
    @Beta
    public static ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor, final long n, final TimeUnit timeUnit) {
        return new Application().getExitingExecutorService(threadPoolExecutor, n, timeUnit);
    }
    
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }
    
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, final long n, final TimeUnit timeUnit) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, n, timeUnit);
    }
    
    static <T> T invokeAnyImpl(final ListeningExecutorService p0, final Collection<? extends Callable<T>> p1, final boolean p2, final long p3) throws InterruptedException, ExecutionException, TimeoutException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/google/common/base/Preconditions.checkNotNull:(Ljava/lang/Object;)Ljava/lang/Object;
        //     4: pop            
        //     5: aload_1        
        //     6: invokeinterface java/util/Collection.size:()I
        //    11: istore          5
        //    13: iload           5
        //    15: ifle            233
        //    18: iconst_1       
        //    19: istore          9
        //    21: iload           9
        //    23: invokestatic    com/google/common/base/Preconditions.checkArgument:(Z)V
        //    26: iload           5
        //    28: invokestatic    com/google/common/collect/Lists.newArrayListWithCapacity:(I)Ljava/util/ArrayList;
        //    31: astore          18
        //    33: invokestatic    com/google/common/collect/Queues.newLinkedBlockingQueue:()Ljava/util/concurrent/LinkedBlockingQueue;
        //    36: astore          19
        //    38: iload_2        
        //    39: ifeq            239
        //    42: invokestatic    java/lang/System.nanoTime:()J
        //    45: lstore          10
        //    47: aload_1        
        //    48: invokeinterface java/util/Collection.iterator:()Ljava/util/Iterator;
        //    53: astore          20
        //    55: aload           18
        //    57: aload_0        
        //    58: aload           20
        //    60: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    65: checkcast       Ljava/util/concurrent/Callable;
        //    68: aload           19
        //    70: invokestatic    com/google/common/util/concurrent/MoreExecutors.submitAndAddQueueListener:(Lcom/google/common/util/concurrent/ListeningExecutorService;Ljava/util/concurrent/Callable;Ljava/util/concurrent/BlockingQueue;)Lcom/google/common/util/concurrent/ListenableFuture;
        //    73: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    78: pop            
        //    79: iload           5
        //    81: iconst_1       
        //    82: isub           
        //    83: istore          8
        //    85: iconst_1       
        //    86: istore          5
        //    88: aconst_null    
        //    89: astore_1       
        //    90: aload           19
        //    92: invokeinterface java/util/concurrent/BlockingQueue.poll:()Ljava/lang/Object;
        //    97: checkcast       Ljava/util/concurrent/Future;
        //   100: astore          17
        //   102: iload           5
        //   104: istore          6
        //   106: aload           17
        //   108: astore          16
        //   110: iload           8
        //   112: istore          7
        //   114: lload           10
        //   116: lstore          12
        //   118: lload_3        
        //   119: lstore          14
        //   121: aload           17
        //   123: ifnonnull       178
        //   126: iload           8
        //   128: ifle            245
        //   131: iload           8
        //   133: iconst_1       
        //   134: isub           
        //   135: istore          7
        //   137: aload           18
        //   139: aload_0        
        //   140: aload           20
        //   142: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   147: checkcast       Ljava/util/concurrent/Callable;
        //   150: aload           19
        //   152: invokestatic    com/google/common/util/concurrent/MoreExecutors.submitAndAddQueueListener:(Lcom/google/common/util/concurrent/ListeningExecutorService;Ljava/util/concurrent/Callable;Ljava/util/concurrent/BlockingQueue;)Lcom/google/common/util/concurrent/ListenableFuture;
        //   155: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   160: pop            
        //   161: iload           5
        //   163: iconst_1       
        //   164: iadd           
        //   165: istore          6
        //   167: lload_3        
        //   168: lstore          14
        //   170: lload           10
        //   172: lstore          12
        //   174: aload           17
        //   176: astore          16
        //   178: aload           16
        //   180: ifnull          412
        //   183: iload           6
        //   185: iconst_1       
        //   186: isub           
        //   187: istore          5
        //   189: aload           16
        //   191: invokeinterface java/util/concurrent/Future.get:()Ljava/lang/Object;
        //   196: astore_1       
        //   197: aload           18
        //   199: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   204: astore_0       
        //   205: aload_0        
        //   206: invokeinterface java/util/Iterator.hasNext:()Z
        //   211: ifeq            405
        //   214: aload_0        
        //   215: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   220: checkcast       Ljava/util/concurrent/Future;
        //   223: iconst_1       
        //   224: invokeinterface java/util/concurrent/Future.cancel:(Z)Z
        //   229: pop            
        //   230: goto            205
        //   233: iconst_0       
        //   234: istore          9
        //   236: goto            21
        //   239: lconst_0       
        //   240: lstore          10
        //   242: goto            47
        //   245: iload           5
        //   247: ifne            302
        //   250: aload_1        
        //   251: ifnonnull       407
        //   254: new             Ljava/util/concurrent/ExecutionException;
        //   257: dup            
        //   258: aconst_null    
        //   259: invokespecial   java/util/concurrent/ExecutionException.<init>:(Ljava/lang/Throwable;)V
        //   262: astore_0       
        //   263: aload_0        
        //   264: athrow         
        //   265: astore_0       
        //   266: aload           18
        //   268: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   273: astore_1       
        //   274: aload_1        
        //   275: invokeinterface java/util/Iterator.hasNext:()Z
        //   280: ifeq            403
        //   283: aload_1        
        //   284: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   289: checkcast       Ljava/util/concurrent/Future;
        //   292: iconst_1       
        //   293: invokeinterface java/util/concurrent/Future.cancel:(Z)Z
        //   298: pop            
        //   299: goto            274
        //   302: iload_2        
        //   303: ifeq            360
        //   306: aload           19
        //   308: lload_3        
        //   309: getstatic       java/util/concurrent/TimeUnit.NANOSECONDS:Ljava/util/concurrent/TimeUnit;
        //   312: invokeinterface java/util/concurrent/BlockingQueue.poll:(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
        //   317: checkcast       Ljava/util/concurrent/Future;
        //   320: astore          16
        //   322: aload           16
        //   324: ifnonnull       335
        //   327: new             Ljava/util/concurrent/TimeoutException;
        //   330: dup            
        //   331: invokespecial   java/util/concurrent/TimeoutException.<init>:()V
        //   334: athrow         
        //   335: invokestatic    java/lang/System.nanoTime:()J
        //   338: lstore          12
        //   340: lload_3        
        //   341: lload           12
        //   343: lload           10
        //   345: lsub           
        //   346: lsub           
        //   347: lstore          14
        //   349: iload           5
        //   351: istore          6
        //   353: iload           8
        //   355: istore          7
        //   357: goto            178
        //   360: aload           19
        //   362: invokeinterface java/util/concurrent/BlockingQueue.take:()Ljava/lang/Object;
        //   367: checkcast       Ljava/util/concurrent/Future;
        //   370: astore          16
        //   372: iload           5
        //   374: istore          6
        //   376: iload           8
        //   378: istore          7
        //   380: lload           10
        //   382: lstore          12
        //   384: lload_3        
        //   385: lstore          14
        //   387: goto            178
        //   390: astore_1       
        //   391: new             Ljava/util/concurrent/ExecutionException;
        //   394: dup            
        //   395: aload_1        
        //   396: invokespecial   java/util/concurrent/ExecutionException.<init>:(Ljava/lang/Throwable;)V
        //   399: astore_1       
        //   400: goto            424
        //   403: aload_0        
        //   404: athrow         
        //   405: aload_1        
        //   406: areturn        
        //   407: aload_1        
        //   408: astore_0       
        //   409: goto            263
        //   412: iload           6
        //   414: istore          5
        //   416: goto            424
        //   419: astore_0       
        //   420: goto            266
        //   423: astore_1       
        //   424: iload           7
        //   426: istore          8
        //   428: lload           12
        //   430: lstore          10
        //   432: lload           14
        //   434: lstore_3       
        //   435: goto            90
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //  throws java.util.concurrent.ExecutionException
        //  throws java.util.concurrent.TimeoutException
        //    Signature:
        //  <T:Ljava/lang/Object;>(Lcom/google/common/util/concurrent/ListeningExecutorService;Ljava/util/Collection<+Ljava/util/concurrent/Callable<TT;>;>;ZJ)TT;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  42     47     265    266    Any
        //  47     79     265    266    Any
        //  90     102    419    423    Any
        //  137    161    419    423    Any
        //  189    197    423    424    Ljava/util/concurrent/ExecutionException;
        //  189    197    390    403    Ljava/lang/RuntimeException;
        //  189    197    419    423    Any
        //  254    263    419    423    Any
        //  263    265    265    266    Any
        //  306    322    419    423    Any
        //  327    335    419    423    Any
        //  335    340    419    423    Any
        //  360    372    419    423    Any
        //  391    400    419    423    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0090:
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
    
    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") != null) {
            try {
                if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", (Class<?>[])new Class[0]).invoke(null, new Object[0]) != null) {
                    return true;
                }
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
            catch (InvocationTargetException ex2) {
                return false;
            }
            catch (IllegalAccessException ex3) {
                return false;
            }
            catch (NoSuchMethodException ex4) {
                return false;
            }
        }
        return false;
    }
    
    public static ListeningExecutorService listeningDecorator(final ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService)executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new ScheduledListeningDecorator((ScheduledExecutorService)executorService);
        }
        return new ListeningDecorator(executorService);
    }
    
    public static ListeningScheduledExecutorService listeningDecorator(final ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService instanceof ListeningScheduledExecutorService) {
            return (ListeningScheduledExecutorService)scheduledExecutorService;
        }
        return new ScheduledListeningDecorator(scheduledExecutorService);
    }
    
    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService();
    }
    
    static Thread newThread(final String name, Runnable thread) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(thread);
        thread = platformThreadFactory().newThread(thread);
        try {
            ((Thread)thread).setName(name);
            return (Thread)thread;
        }
        catch (SecurityException ex) {
            return (Thread)thread;
        }
    }
    
    @Beta
    public static ThreadFactory platformThreadFactory() {
        if (!isAppEngine()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
        }
        catch (IllegalAccessException cause) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", cause);
        }
        catch (ClassNotFoundException cause2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", cause2);
        }
        catch (NoSuchMethodException cause3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", cause3);
        }
        catch (InvocationTargetException ex) {
            throw Throwables.propagate(ex.getCause());
        }
    }
    
    static Executor renamingDecorator(final Executor executor, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executor;
        }
        return new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                executor.execute(Callables.threadRenaming(runnable, supplier));
            }
        };
    }
    
    static ExecutorService renamingDecorator(final ExecutorService executorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executorService;
        }
        return new WrappingExecutorService(executorService) {
            @Override
            protected Runnable wrapTask(final Runnable runnable) {
                return Callables.threadRenaming(runnable, supplier);
            }
            
            @Override
            protected <T> Callable<T> wrapTask(final Callable<T> callable) {
                return Callables.threadRenaming(callable, supplier);
            }
        };
    }
    
    static ScheduledExecutorService renamingDecorator(final ScheduledExecutorService scheduledExecutorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return scheduledExecutorService;
        }
        return new WrappingScheduledExecutorService(scheduledExecutorService) {
            @Override
            protected Runnable wrapTask(final Runnable runnable) {
                return Callables.threadRenaming(runnable, supplier);
            }
            
            @Override
            protected <T> Callable<T> wrapTask(final Callable<T> callable) {
                return Callables.threadRenaming(callable, supplier);
            }
        };
    }
    
    @Deprecated
    public static ListeningExecutorService sameThreadExecutor() {
        return new DirectExecutorService();
    }
    
    @Beta
    public static boolean shutdownAndAwaitTermination(final ExecutorService executorService, long sourceDuration, final TimeUnit sourceUnit) {
        Preconditions.checkNotNull(sourceUnit);
        executorService.shutdown();
        try {
            sourceDuration = TimeUnit.NANOSECONDS.convert(sourceDuration, sourceUnit) / 2L;
            if (!executorService.awaitTermination(sourceDuration, TimeUnit.NANOSECONDS)) {
                executorService.shutdownNow();
                executorService.awaitTermination(sourceDuration, TimeUnit.NANOSECONDS);
            }
            return executorService.isTerminated();
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
            return executorService.isTerminated();
        }
    }
    
    private static <T> ListenableFuture<T> submitAndAddQueueListener(final ListeningExecutorService listeningExecutorService, final Callable<T> callable, final BlockingQueue<Future<T>> blockingQueue) {
        final ListenableFuture<T> submit = listeningExecutorService.submit(callable);
        submit.addListener(new Runnable() {
            @Override
            public void run() {
                blockingQueue.add(submit);
            }
        }, directExecutor());
        return submit;
    }
    
    private static void useDaemonThreadFactory(final ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }
    
    @VisibleForTesting
    static class Application
    {
        final void addDelayedShutdownHook(final ExecutorService obj, final long n, final TimeUnit timeUnit) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(timeUnit);
            final String value = String.valueOf(String.valueOf(obj));
            this.addShutdownHook(MoreExecutors.newThread(new StringBuilder(value.length() + 24).append("DelayedShutdownHook-for-").append(value).toString(), new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.shutdown();
                        obj.awaitTermination(n, timeUnit);
                    }
                    catch (InterruptedException ex) {}
                }
            }));
        }
        
        @VisibleForTesting
        void addShutdownHook(final Thread hook) {
            Runtime.getRuntime().addShutdownHook(hook);
        }
        
        final ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor) {
            return this.getExitingExecutorService(threadPoolExecutor, 120L, TimeUnit.SECONDS);
        }
        
        final ExecutorService getExitingExecutorService(final ThreadPoolExecutor executor, final long n, final TimeUnit timeUnit) {
            useDaemonThreadFactory(executor);
            final ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(executor);
            this.addDelayedShutdownHook(unconfigurableExecutorService, n, timeUnit);
            return unconfigurableExecutorService;
        }
        
        final ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return this.getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
        }
        
        final ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor executor, final long n, final TimeUnit timeUnit) {
            useDaemonThreadFactory(executor);
            final ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(executor);
            this.addDelayedShutdownHook(unconfigurableScheduledExecutorService, n, timeUnit);
            return unconfigurableScheduledExecutorService;
        }
    }
    
    private enum DirectExecutor implements Executor
    {
        INSTANCE;
        
        @Override
        public void execute(final Runnable runnable) {
            runnable.run();
        }
    }
    
    private static class DirectExecutorService extends AbstractListeningExecutorService
    {
        private final Lock lock;
        private int runningTasks;
        private boolean shutdown;
        private final Condition termination;
        
        private DirectExecutorService() {
            this.lock = new ReentrantLock();
            this.termination = this.lock.newCondition();
            this.runningTasks = 0;
            this.shutdown = false;
        }
        
        private void endTask() {
            this.lock.lock();
            try {
                --this.runningTasks;
                if (this.isTerminated()) {
                    this.termination.signalAll();
                }
            }
            finally {
                this.lock.unlock();
            }
        }
        
        private void startTask() {
            this.lock.lock();
            try {
                if (this.isShutdown()) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
            }
            finally {
                this.lock.unlock();
            }
            ++this.runningTasks;
            this.lock.unlock();
        }
        
        @Override
        public boolean awaitTermination(long duration, final TimeUnit timeUnit) throws InterruptedException {
            duration = timeUnit.toNanos(duration);
            this.lock.lock();
            try {
                while (!this.isTerminated()) {
                    if (duration <= 0L) {
                        return false;
                    }
                    duration = this.termination.awaitNanos(duration);
                }
                return true;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Override
        public void execute(final Runnable runnable) {
            this.startTask();
            try {
                runnable.run();
            }
            finally {
                this.endTask();
            }
        }
        
        @Override
        public boolean isShutdown() {
            this.lock.lock();
            try {
                return this.shutdown;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Override
        public boolean isTerminated() {
            this.lock.lock();
            try {
                return this.shutdown && this.runningTasks == 0;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Override
        public void shutdown() {
            this.lock.lock();
            try {
                this.shutdown = true;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Override
        public List<Runnable> shutdownNow() {
            this.shutdown();
            return Collections.emptyList();
        }
    }
    
    private static class ListeningDecorator extends AbstractListeningExecutorService
    {
        private final ExecutorService delegate;
        
        ListeningDecorator(final ExecutorService executorService) {
            this.delegate = Preconditions.checkNotNull(executorService);
        }
        
        @Override
        public boolean awaitTermination(final long n, final TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(n, timeUnit);
        }
        
        @Override
        public void execute(final Runnable runnable) {
            this.delegate.execute(runnable);
        }
        
        @Override
        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }
        
        @Override
        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }
        
        @Override
        public void shutdown() {
            this.delegate.shutdown();
        }
        
        @Override
        public List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }
    }
    
    private static class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService
    {
        final ScheduledExecutorService delegate;
        
        ScheduledListeningDecorator(final ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.delegate = Preconditions.checkNotNull(scheduledExecutorService);
        }
        
        @Override
        public ListenableScheduledFuture<?> schedule(final Runnable runnable, final long n, final TimeUnit timeUnit) {
            final ListenableFutureTask<Object> create = ListenableFutureTask.create(runnable, (Object)null);
            return new ListenableScheduledTask<Object>(create, this.delegate.schedule(create, n, timeUnit));
        }
        
        @Override
        public <V> ListenableScheduledFuture<V> schedule(final Callable<V> callable, final long n, final TimeUnit timeUnit) {
            final ListenableFutureTask<V> create = ListenableFutureTask.create(callable);
            return new ListenableScheduledTask<V>((ListenableFuture<Object>)create, this.delegate.schedule(create, n, timeUnit));
        }
        
        @Override
        public ListenableScheduledFuture<?> scheduleAtFixedRate(final Runnable runnable, final long n, final long n2, final TimeUnit timeUnit) {
            final NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask<Object>((ListenableFuture<Object>)neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, n, n2, timeUnit));
        }
        
        @Override
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(final Runnable runnable, final long n, final long n2, final TimeUnit timeUnit) {
            final NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask<Object>((ListenableFuture<Object>)neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, n, n2, timeUnit));
        }
        
        private static final class ListenableScheduledTask<V> extends SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V>
        {
            private final ScheduledFuture<?> scheduledDelegate;
            
            public ListenableScheduledTask(final ListenableFuture<V> listenableFuture, final ScheduledFuture<?> scheduledDelegate) {
                super(listenableFuture);
                this.scheduledDelegate = scheduledDelegate;
            }
            
            @Override
            public boolean cancel(final boolean b) {
                final boolean cancel = super.cancel(b);
                if (cancel) {
                    this.scheduledDelegate.cancel(b);
                }
                return cancel;
            }
            
            @Override
            public int compareTo(final Delayed delayed) {
                return this.scheduledDelegate.compareTo(delayed);
            }
            
            @Override
            public long getDelay(final TimeUnit timeUnit) {
                return this.scheduledDelegate.getDelay(timeUnit);
            }
        }
        
        private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable
        {
            private final Runnable delegate;
            
            public NeverSuccessfulListenableFutureTask(final Runnable runnable) {
                this.delegate = Preconditions.checkNotNull(runnable);
            }
            
            @Override
            public void run() {
                try {
                    this.delegate.run();
                }
                catch (Throwable exception) {
                    this.setException(exception);
                    throw Throwables.propagate(exception);
                }
            }
        }
    }
}
