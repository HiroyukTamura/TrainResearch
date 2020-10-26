// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.os.Looper;
import java.lang.ref.WeakReference;
import android.support.annotation.Nullable;
import java.util.concurrent.locks.ReentrantLock;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import android.os.Handler$Callback;

public class WeakHandler
{
    private final Handler$Callback mCallback;
    private final ExecHandler mExec;
    private Lock mLock;
    @VisibleForTesting
    final ChainedRef mRunnables;
    
    public WeakHandler() {
        this.mLock = new ReentrantLock();
        this.mRunnables = new ChainedRef(this.mLock, null);
        this.mCallback = null;
        this.mExec = new ExecHandler();
    }
    
    public WeakHandler(@Nullable final Handler$Callback handler$Callback) {
        this.mLock = new ReentrantLock();
        this.mRunnables = new ChainedRef(this.mLock, null);
        this.mCallback = handler$Callback;
        this.mExec = new ExecHandler(new WeakReference<Handler$Callback>(handler$Callback));
    }
    
    public WeakHandler(@NonNull final Looper looper) {
        this.mLock = new ReentrantLock();
        this.mRunnables = new ChainedRef(this.mLock, null);
        this.mCallback = null;
        this.mExec = new ExecHandler(looper);
    }
    
    public WeakHandler(@NonNull final Looper looper, @NonNull final Handler$Callback handler$Callback) {
        this.mLock = new ReentrantLock();
        this.mRunnables = new ChainedRef(this.mLock, null);
        this.mCallback = handler$Callback;
        this.mExec = new ExecHandler(looper, new WeakReference<Handler$Callback>(handler$Callback));
    }
    
    private WeakRunnable wrapRunnable(@NonNull final Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        final ChainedRef chainedRef = new ChainedRef(this.mLock, runnable);
        this.mRunnables.insertAfter(chainedRef);
        return chainedRef.wrapper;
    }
    
    public final Looper getLooper() {
        return this.mExec.getLooper();
    }
    
    public final boolean hasMessages(final int n) {
        return this.mExec.hasMessages(n);
    }
    
    public final boolean hasMessages(final int n, final Object o) {
        return this.mExec.hasMessages(n, o);
    }
    
    public final boolean post(@NonNull final Runnable runnable) {
        return this.mExec.post((Runnable)this.wrapRunnable(runnable));
    }
    
    public final boolean postAtFrontOfQueue(final Runnable runnable) {
        return this.mExec.postAtFrontOfQueue((Runnable)this.wrapRunnable(runnable));
    }
    
    public final boolean postAtTime(@NonNull final Runnable runnable, final long n) {
        return this.mExec.postAtTime((Runnable)this.wrapRunnable(runnable), n);
    }
    
    public final boolean postAtTime(final Runnable runnable, final Object o, final long n) {
        return this.mExec.postAtTime((Runnable)this.wrapRunnable(runnable), o, n);
    }
    
    public final boolean postDelayed(final Runnable runnable, final long n) {
        return this.mExec.postDelayed((Runnable)this.wrapRunnable(runnable), n);
    }
    
    public final void removeCallbacks(final Runnable runnable) {
        final WeakRunnable remove = this.mRunnables.remove(runnable);
        if (remove != null) {
            this.mExec.removeCallbacks((Runnable)remove);
        }
    }
    
    public final void removeCallbacks(final Runnable runnable, final Object o) {
        final WeakRunnable remove = this.mRunnables.remove(runnable);
        if (remove != null) {
            this.mExec.removeCallbacks((Runnable)remove, o);
        }
    }
    
    public final void removeCallbacksAndMessages(final Object o) {
        this.mExec.removeCallbacksAndMessages(o);
    }
    
    public final void removeMessages(final int n) {
        this.mExec.removeMessages(n);
    }
    
    public final void removeMessages(final int n, final Object o) {
        this.mExec.removeMessages(n, o);
    }
    
    public final boolean sendEmptyMessage(final int n) {
        return this.mExec.sendEmptyMessage(n);
    }
    
    public final boolean sendEmptyMessageAtTime(final int n, final long n2) {
        return this.mExec.sendEmptyMessageAtTime(n, n2);
    }
    
    public final boolean sendEmptyMessageDelayed(final int n, final long n2) {
        return this.mExec.sendEmptyMessageDelayed(n, n2);
    }
    
    public final boolean sendMessage(final Message message) {
        return this.mExec.sendMessage(message);
    }
    
    public final boolean sendMessageAtFrontOfQueue(final Message message) {
        return this.mExec.sendMessageAtFrontOfQueue(message);
    }
    
    public boolean sendMessageAtTime(final Message message, final long n) {
        return this.mExec.sendMessageAtTime(message, n);
    }
    
    public final boolean sendMessageDelayed(final Message message, final long n) {
        return this.mExec.sendMessageDelayed(message, n);
    }
    
    static class ChainedRef
    {
        @NonNull
        Lock lock;
        @Nullable
        ChainedRef next;
        @Nullable
        ChainedRef prev;
        @NonNull
        final Runnable runnable;
        @NonNull
        final WeakRunnable wrapper;
        
        public ChainedRef(@NonNull final Lock lock, @NonNull final Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.wrapper = new WeakRunnable(new WeakReference<Runnable>(runnable), new WeakReference<ChainedRef>(this));
        }
        
        public void insertAfter(@NonNull final ChainedRef chainedRef) {
            this.lock.lock();
            try {
                if (this.next != null) {
                    this.next.prev = chainedRef;
                }
                chainedRef.next = this.next;
                this.next = chainedRef;
                chainedRef.prev = this;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        public WeakRunnable remove() {
            this.lock.lock();
            try {
                if (this.prev != null) {
                    this.prev.next = this.next;
                }
                if (this.next != null) {
                    this.next.prev = this.prev;
                }
                this.prev = null;
                this.next = null;
                this.lock.unlock();
                return this.wrapper;
            }
            finally {
                this.lock.unlock();
            }
        }
        
        @Nullable
        public WeakRunnable remove(final Runnable runnable) {
            this.lock.lock();
            try {
                for (ChainedRef chainedRef = this.next; chainedRef != null; chainedRef = chainedRef.next) {
                    if (chainedRef.runnable == runnable) {
                        return chainedRef.remove();
                    }
                }
                return null;
            }
            finally {
                this.lock.unlock();
            }
        }
    }
    
    private static class ExecHandler extends Handler
    {
        private final WeakReference<Handler$Callback> mCallback;
        
        ExecHandler() {
            this.mCallback = null;
        }
        
        ExecHandler(final Looper looper) {
            super(looper);
            this.mCallback = null;
        }
        
        ExecHandler(final Looper looper, final WeakReference<Handler$Callback> mCallback) {
            super(looper);
            this.mCallback = mCallback;
        }
        
        ExecHandler(final WeakReference<Handler$Callback> mCallback) {
            this.mCallback = mCallback;
        }
        
        public void handleMessage(@NonNull final Message message) {
            if (this.mCallback != null) {
                final Handler$Callback handler$Callback = this.mCallback.get();
                if (handler$Callback != null) {
                    handler$Callback.handleMessage(message);
                }
            }
        }
    }
    
    static class WeakRunnable implements Runnable
    {
        private final WeakReference<Runnable> mDelegate;
        private final WeakReference<ChainedRef> mReference;
        
        WeakRunnable(final WeakReference<Runnable> mDelegate, final WeakReference<ChainedRef> mReference) {
            this.mDelegate = mDelegate;
            this.mReference = mReference;
        }
        
        @Override
        public void run() {
            final Runnable runnable = this.mDelegate.get();
            final ChainedRef chainedRef = this.mReference.get();
            if (chainedRef != null) {
                chainedRef.remove();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
