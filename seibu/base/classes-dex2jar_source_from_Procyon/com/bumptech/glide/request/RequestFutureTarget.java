// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.SizeReadyCallback;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import com.bumptech.glide.util.Util;
import android.os.Handler;

public class RequestFutureTarget<T, R> implements FutureTarget<R>, Runnable
{
    private static final Waiter DEFAULT_WAITER;
    private final boolean assertBackgroundThread;
    private Exception exception;
    private boolean exceptionReceived;
    private final int height;
    private boolean isCancelled;
    private final Handler mainHandler;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;
    
    static {
        DEFAULT_WAITER = new Waiter();
    }
    
    public RequestFutureTarget(final Handler handler, final int n, final int n2) {
        this(handler, n, n2, true, RequestFutureTarget.DEFAULT_WAITER);
    }
    
    RequestFutureTarget(final Handler mainHandler, final int width, final int height, final boolean assertBackgroundThread, final Waiter waiter) {
        this.mainHandler = mainHandler;
        this.width = width;
        this.height = height;
        this.assertBackgroundThread = assertBackgroundThread;
        this.waiter = waiter;
    }
    
    private R doGet(final Long n) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            if (this.assertBackgroundThread) {
                Util.assertBackgroundThread();
            }
            if (this.isCancelled) {
                throw new CancellationException();
            }
        }
        if (this.exceptionReceived) {
            throw new ExecutionException(this.exception);
        }
        R r;
        if (this.resultReceived) {
            r = this.resource;
        }
        else {
            final Long n2;
            if (n2 == null) {
                this.waiter.waitForTimeout(this, 0L);
            }
            else if (n2 > 0L) {
                this.waiter.waitForTimeout(this, n2);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.exceptionReceived) {
                throw new ExecutionException(this.exception);
            }
            if (this.isCancelled) {
                throw new CancellationException();
            }
            if (!this.resultReceived) {
                throw new TimeoutException();
            }
            r = this.resource;
        }
        // monitorexit(this)
        return r;
    }
    
    @Override
    public boolean cancel(final boolean b) {
        while (true) {
            int n = 1;
            boolean b2 = true;
            while (true) {
                Label_0067: {
                    synchronized (this) {
                        if (!this.isCancelled) {
                            if (this.isDone()) {
                                break Label_0067;
                            }
                            b2 = (n != 0);
                            if (n != 0) {
                                this.isCancelled = true;
                                if (b) {
                                    this.clear();
                                }
                                this.waiter.notifyAll(this);
                                b2 = (n != 0);
                            }
                        }
                        return b2;
                    }
                }
                n = (false ? 1 : 0);
                continue;
            }
        }
    }
    
    @Override
    public void clear() {
        this.mainHandler.post((Runnable)this);
    }
    
    @Override
    public R get() throws InterruptedException, ExecutionException {
        try {
            return this.doGet(null);
        }
        catch (TimeoutException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public R get(final long duration, final TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.doGet(timeUnit.toMillis(duration));
    }
    
    @Override
    public Request getRequest() {
        return this.request;
    }
    
    @Override
    public void getSize(final SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }
    
    @Override
    public boolean isCancelled() {
        synchronized (this) {
            return this.isCancelled;
        }
    }
    
    @Override
    public boolean isDone() {
        synchronized (this) {
            return this.isCancelled || this.resultReceived;
        }
    }
    
    @Override
    public void onDestroy() {
    }
    
    @Override
    public void onLoadCleared(final Drawable drawable) {
    }
    
    @Override
    public void onLoadFailed(final Exception exception, final Drawable drawable) {
        synchronized (this) {
            this.exceptionReceived = true;
            this.exception = exception;
            this.waiter.notifyAll(this);
        }
    }
    
    @Override
    public void onLoadStarted(final Drawable drawable) {
    }
    
    @Override
    public void onResourceReady(final R resource, final GlideAnimation<? super R> glideAnimation) {
        synchronized (this) {
            this.resultReceived = true;
            this.resource = resource;
            this.waiter.notifyAll(this);
        }
    }
    
    @Override
    public void onStart() {
    }
    
    @Override
    public void onStop() {
    }
    
    @Override
    public void run() {
        if (this.request != null) {
            this.request.clear();
            this.cancel(false);
        }
    }
    
    @Override
    public void setRequest(final Request request) {
        this.request = request;
    }
    
    static class Waiter
    {
        public void notifyAll(final Object o) {
            o.notifyAll();
        }
        
        public void waitForTimeout(final Object o, final long n) throws InterruptedException {
            o.wait(n);
        }
    }
}
