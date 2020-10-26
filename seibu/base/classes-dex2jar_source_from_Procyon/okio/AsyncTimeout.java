// 
// Decompiled by Procyon v0.5.36
// 

package okio;

import java.io.InterruptedIOException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout extends Timeout
{
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    @Nullable
    static AsyncTimeout head;
    private boolean inQueue;
    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;
    
    static {
        IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
    }
    
    @Nullable
    static AsyncTimeout awaitTimeout() throws InterruptedException {
        final AsyncTimeout asyncTimeout = null;
        final AsyncTimeout next = AsyncTimeout.head.next;
        if (next == null) {
            final long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
            AsyncTimeout head = asyncTimeout;
            if (AsyncTimeout.head.next == null) {
                head = asyncTimeout;
                if (System.nanoTime() - nanoTime >= AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    head = AsyncTimeout.head;
                }
            }
            return head;
        }
        final long remainingNanos = next.remainingNanos(System.nanoTime());
        if (remainingNanos > 0L) {
            final long timeoutMillis = remainingNanos / 1000000L;
            AsyncTimeout.class.wait(timeoutMillis, (int)(remainingNanos - timeoutMillis * 1000000L));
            return null;
        }
        AsyncTimeout.head.next = next.next;
        next.next = null;
        return next;
    }
    
    private static boolean cancelScheduledTimeout(final AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                if (asyncTimeout2.next == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return false;
                }
            }
            return true;
        }
    }
    
    private long remainingNanos(final long n) {
        return this.timeoutAt - n;
    }
    
    private static void scheduleTimeout(final AsyncTimeout next, long remainingNanos, final boolean b) {
    Label_0074_Outer:
        while (true) {
            while (true) {
                AsyncTimeout asyncTimeout = null;
                Label_0175: {
                    while (true) {
                        Label_0152: {
                            synchronized (AsyncTimeout.class) {
                                if (AsyncTimeout.head == null) {
                                    AsyncTimeout.head = new AsyncTimeout();
                                    new AsyncTimeout.AsyncTimeout$Watchdog().start();
                                }
                                final long nanoTime = System.nanoTime();
                                if (remainingNanos != 0L && b) {
                                    next.timeoutAt = Math.min(remainingNanos, next.deadlineNanoTime() - nanoTime) + nanoTime;
                                }
                                else {
                                    if (remainingNanos == 0L) {
                                        break Label_0152;
                                    }
                                    next.timeoutAt = nanoTime + remainingNanos;
                                }
                                remainingNanos = next.remainingNanos(nanoTime);
                                asyncTimeout = AsyncTimeout.head;
                                if (asyncTimeout.next == null || remainingNanos < asyncTimeout.next.remainingNanos(nanoTime)) {
                                    next.next = asyncTimeout.next;
                                    asyncTimeout.next = next;
                                    if (asyncTimeout == AsyncTimeout.head) {
                                        AsyncTimeout.class.notify();
                                    }
                                    return;
                                }
                                break Label_0175;
                            }
                        }
                        if (b) {
                            next.timeoutAt = next.deadlineNanoTime();
                            continue Label_0074_Outer;
                        }
                        break;
                    }
                    break;
                }
                asyncTimeout = asyncTimeout.next;
                continue;
            }
        }
        throw new AssertionError();
    }
    
    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        final long timeoutNanos = this.timeoutNanos();
        final boolean hasDeadline = this.hasDeadline();
        if (timeoutNanos == 0L && !hasDeadline) {
            return;
        }
        this.inQueue = true;
        scheduleTimeout(this, timeoutNanos, hasDeadline);
    }
    
    final IOException exit(final IOException ex) throws IOException {
        if (!this.exit()) {
            return ex;
        }
        return this.newTimeoutException(ex);
    }
    
    final void exit(final boolean b) throws IOException {
        if (this.exit() && b) {
            throw this.newTimeoutException(null);
        }
    }
    
    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }
    
    protected IOException newTimeoutException(@Nullable final IOException cause) {
        final InterruptedIOException ex = new InterruptedIOException("timeout");
        if (cause != null) {
            ex.initCause(cause);
        }
        return ex;
    }
    
    public final Sink sink(final Sink sink) {
        return (Sink)new AsyncTimeout$1(this, sink);
    }
    
    public final Source source(final Source source) {
        return (Source)new AsyncTimeout$2(this, source);
    }
    
    protected void timedOut() {
    }
}
