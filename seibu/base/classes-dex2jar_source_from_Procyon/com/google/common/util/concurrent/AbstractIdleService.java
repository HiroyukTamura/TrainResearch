// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executor;
import com.google.common.base.Throwables;
import com.google.common.base.Supplier;
import com.google.common.annotations.Beta;

@Beta
public abstract class AbstractIdleService implements Service
{
    private final Service delegate;
    private final Supplier<String> threadNameSupplier;
    
    protected AbstractIdleService() {
        this.threadNameSupplier = new Supplier<String>() {
            @Override
            public String get() {
                final String value = String.valueOf(String.valueOf(AbstractIdleService.this.serviceName()));
                final String value2 = String.valueOf(String.valueOf(AbstractIdleService.this.state()));
                return new StringBuilder(value.length() + 1 + value2.length()).append(value).append(" ").append(value2).toString();
            }
        };
        this.delegate = new AbstractService() {
            @Override
            protected final void doStart() {
                MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AbstractIdleService.this.startUp();
                            AbstractService.this.notifyStarted();
                        }
                        catch (Throwable t) {
                            AbstractService.this.notifyFailed(t);
                            throw Throwables.propagate(t);
                        }
                    }
                });
            }
            
            @Override
            protected final void doStop() {
                MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AbstractIdleService.this.shutDown();
                            AbstractService.this.notifyStopped();
                        }
                        catch (Throwable t) {
                            AbstractService.this.notifyFailed(t);
                            throw Throwables.propagate(t);
                        }
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
    
    protected Executor executor() {
        return new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                MoreExecutors.newThread(AbstractIdleService.this.threadNameSupplier.get(), runnable).start();
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
    
    protected String serviceName() {
        return this.getClass().getSimpleName();
    }
    
    protected abstract void shutDown() throws Exception;
    
    @Override
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }
    
    protected abstract void startUp() throws Exception;
    
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
}
