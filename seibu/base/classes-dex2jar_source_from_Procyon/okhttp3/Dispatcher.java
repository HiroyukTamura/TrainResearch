// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.annotation.Nullable;
import java.util.concurrent.ExecutorService;

public final class Dispatcher
{
    @Nullable
    private ExecutorService executorService;
    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final Deque<RealCall$AsyncCall> readyAsyncCalls;
    private final Deque<RealCall$AsyncCall> runningAsyncCalls;
    private final Deque<RealCall> runningSyncCalls;
    
    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<RealCall$AsyncCall>();
        this.runningAsyncCalls = new ArrayDeque<RealCall$AsyncCall>();
        this.runningSyncCalls = new ArrayDeque<RealCall>();
    }
    
    public Dispatcher(final ExecutorService executorService) {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<RealCall$AsyncCall>();
        this.runningAsyncCalls = new ArrayDeque<RealCall$AsyncCall>();
        this.runningSyncCalls = new ArrayDeque<RealCall>();
        this.executorService = executorService;
    }
    
    private <T> void finished(final Deque<T> deque, final T t, final boolean b) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError((Object)"Call wasn't in-flight!");
            }
        }
        if (b) {
            this.promoteCalls();
        }
        final int runningCallsCount = this.runningCallsCount();
        final Runnable idleCallback = this.idleCallback;
        // monitorexit(this)
        if (runningCallsCount == 0 && idleCallback != null) {
            idleCallback.run();
        }
    }
    
    private void promoteCalls() {
        if (this.runningAsyncCalls.size() < this.maxRequests && !this.readyAsyncCalls.isEmpty()) {
            final Iterator<RealCall$AsyncCall> iterator = this.readyAsyncCalls.iterator();
            while (iterator.hasNext()) {
                final RealCall$AsyncCall realCall$AsyncCall = iterator.next();
                if (this.runningCallsForHost(realCall$AsyncCall) < this.maxRequestsPerHost) {
                    iterator.remove();
                    this.runningAsyncCalls.add(realCall$AsyncCall);
                    this.executorService().execute((Runnable)realCall$AsyncCall);
                }
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    return;
                }
            }
        }
    }
    
    private int runningCallsForHost(final RealCall$AsyncCall realCall$AsyncCall) {
        int n = 0;
        final Iterator<RealCall$AsyncCall> iterator = this.runningAsyncCalls.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().host().equals(realCall$AsyncCall.host())) {
                ++n;
            }
        }
        return n;
    }
    
    public void cancelAll() {
        synchronized (this) {
            final Iterator<RealCall$AsyncCall> iterator = this.readyAsyncCalls.iterator();
            while (iterator.hasNext()) {
                iterator.next().get().cancel();
            }
        }
        final Iterator<RealCall$AsyncCall> iterator2 = this.runningAsyncCalls.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().get().cancel();
        }
        final Iterator<RealCall> iterator3 = this.runningSyncCalls.iterator();
        while (iterator3.hasNext()) {
            iterator3.next().cancel();
        }
    }
    // monitorexit(this)
    
    void enqueue(final RealCall$AsyncCall realCall$AsyncCall) {
        synchronized (this) {
            if (this.runningAsyncCalls.size() < this.maxRequests && this.runningCallsForHost(realCall$AsyncCall) < this.maxRequestsPerHost) {
                this.runningAsyncCalls.add(realCall$AsyncCall);
                this.executorService().execute((Runnable)realCall$AsyncCall);
            }
            else {
                this.readyAsyncCalls.add(realCall$AsyncCall);
            }
        }
    }
    
    void executed(final RealCall realCall) {
        synchronized (this) {
            this.runningSyncCalls.add(realCall);
        }
    }
    
    public ExecutorService executorService() {
        synchronized (this) {
            if (this.executorService == null) {
                this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp Dispatcher", false));
            }
            return this.executorService;
        }
    }
    
    void finished(final RealCall$AsyncCall realCall$AsyncCall) {
        this.finished(this.runningAsyncCalls, realCall$AsyncCall, true);
    }
    
    void finished(final RealCall realCall) {
        this.finished(this.runningSyncCalls, realCall, false);
    }
    
    public int getMaxRequests() {
        synchronized (this) {
            return this.maxRequests;
        }
    }
    
    public int getMaxRequestsPerHost() {
        synchronized (this) {
            return this.maxRequestsPerHost;
        }
    }
    
    public List<Call> queuedCalls() {
        synchronized (this) {
            final ArrayList<RealCall> list = new ArrayList<RealCall>();
            final Iterator<RealCall$AsyncCall> iterator = this.readyAsyncCalls.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().get());
            }
        }
        final List<? extends Call> list2;
        // monitorexit(this)
        return Collections.unmodifiableList(list2);
    }
    
    public int queuedCallsCount() {
        synchronized (this) {
            return this.readyAsyncCalls.size();
        }
    }
    
    public List<Call> runningCalls() {
        synchronized (this) {
            final ArrayList<Object> list = new ArrayList<Object>();
            list.addAll(this.runningSyncCalls);
            final Iterator<RealCall$AsyncCall> iterator = this.runningAsyncCalls.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().get());
            }
        }
        final List<? extends Call> list2;
        // monitorexit(this)
        return Collections.unmodifiableList(list2);
    }
    
    public int runningCallsCount() {
        synchronized (this) {
            return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
        }
    }
    
    public void setIdleCallback(@Nullable final Runnable idleCallback) {
        synchronized (this) {
            this.idleCallback = idleCallback;
        }
    }
    
    public void setMaxRequests(final int n) {
        // monitorenter(this)
        if (n < 1) {
            try {
                throw new IllegalArgumentException("max < 1: " + n);
            }
            finally {
            }
            // monitorexit(this)
        }
        this.maxRequests = n;
        this.promoteCalls();
    }
    // monitorexit(this)
    
    public void setMaxRequestsPerHost(final int n) {
        // monitorenter(this)
        if (n < 1) {
            try {
                throw new IllegalArgumentException("max < 1: " + n);
            }
            finally {
            }
            // monitorexit(this)
        }
        this.maxRequestsPerHost = n;
        this.promoteCalls();
    }
    // monitorexit(this)
}
