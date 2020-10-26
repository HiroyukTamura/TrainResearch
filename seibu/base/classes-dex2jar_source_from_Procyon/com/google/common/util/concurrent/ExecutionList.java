// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Logger;

public final class ExecutionList
{
    @VisibleForTesting
    static final Logger log;
    @GuardedBy("this")
    private boolean executed;
    @GuardedBy("this")
    private RunnableExecutorPair runnables;
    
    static {
        log = Logger.getLogger(ExecutionList.class.getName());
    }
    
    private static void executeListener(final Runnable obj, final Executor obj2) {
        try {
            obj2.execute(obj);
        }
        catch (RuntimeException thrown) {
            final Logger log = ExecutionList.log;
            final Level severe = Level.SEVERE;
            final String value = String.valueOf(String.valueOf(obj));
            final String value2 = String.valueOf(String.valueOf(obj2));
            log.log(severe, new StringBuilder(value.length() + 57 + value2.length()).append("RuntimeException while executing runnable ").append(value).append(" with executor ").append(value2).toString(), thrown);
        }
    }
    
    public void add(final Runnable runnable, final Executor executor) {
        Preconditions.checkNotNull(runnable, (Object)"Runnable was null.");
        Preconditions.checkNotNull(executor, (Object)"Executor was null.");
        synchronized (this) {
            if (!this.executed) {
                this.runnables = new RunnableExecutorPair(runnable, executor, this.runnables);
                return;
            }
            // monitorexit(this)
            executeListener(runnable, executor);
        }
    }
    
    public void execute() {
        RunnableExecutorPair runnableExecutorPair;
        synchronized (this) {
            if (this.executed) {
                return;
            }
            this.executed = true;
            RunnableExecutorPair runnables = this.runnables;
            this.runnables = null;
            // monitorexit(this)
            RunnableExecutorPair next = null;
            while (true) {
                runnableExecutorPair = next;
                if (runnables == null) {
                    break;
                }
                runnableExecutorPair = runnables.next;
                runnables.next = next;
                next = runnables;
                runnables = runnableExecutorPair;
            }
        }
        while (runnableExecutorPair != null) {
            executeListener(runnableExecutorPair.runnable, runnableExecutorPair.executor);
            runnableExecutorPair = runnableExecutorPair.next;
        }
    }
    
    private static final class RunnableExecutorPair
    {
        final Executor executor;
        @Nullable
        RunnableExecutorPair next;
        final Runnable runnable;
        
        RunnableExecutorPair(final Runnable runnable, final Executor executor, final RunnableExecutorPair next) {
            this.runnable = runnable;
            this.executor = executor;
            this.next = next;
        }
    }
}
