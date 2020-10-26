// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import com.google.common.base.Stopwatch;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.ThreadSafe;
import com.google.common.annotations.Beta;

@Beta
@ThreadSafe
public abstract class RateLimiter
{
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;
    
    RateLimiter(final SleepingStopwatch sleepingStopwatch) {
        this.stopwatch = Preconditions.checkNotNull(sleepingStopwatch);
    }
    
    private boolean canAcquire(final long n, final long n2) {
        return this.queryEarliestAvailable(n) - n2 <= n;
    }
    
    private static int checkPermits(final int i) {
        Preconditions.checkArgument(i > 0, "Requested permits (%s) must be positive", i);
        return i;
    }
    
    public static RateLimiter create(final double n) {
        return create(SleepingStopwatch.createFromSystemTimer(), n);
    }
    
    public static RateLimiter create(final double n, final long l, final TimeUnit timeUnit) {
        Preconditions.checkArgument(l >= 0L, "warmupPeriod must not be negative: %s", l);
        return create(SleepingStopwatch.createFromSystemTimer(), n, l, timeUnit);
    }
    
    @VisibleForTesting
    static RateLimiter create(final SleepingStopwatch sleepingStopwatch, final double rate) {
        final SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0);
        smoothBursty.setRate(rate);
        return smoothBursty;
    }
    
    @VisibleForTesting
    static RateLimiter create(final SleepingStopwatch sleepingStopwatch, final double rate, final long n, final TimeUnit timeUnit) {
        final SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, n, timeUnit);
        smoothWarmingUp.setRate(rate);
        return smoothWarmingUp;
    }
    
    private Object mutex() {
        final Object mutexDoNotUseDirectly = this.mutexDoNotUseDirectly;
        if (mutexDoNotUseDirectly != null) {
            return mutexDoNotUseDirectly;
        }
        // monitorenter(this)
    Label_0039:
        while (true) {
            try {
                while (true) {
                    Object mutexDoNotUseDirectly2;
                    if ((mutexDoNotUseDirectly2 = this.mutexDoNotUseDirectly) == null) {
                        mutexDoNotUseDirectly2 = new Object();
                        try {
                            this.mutexDoNotUseDirectly = mutexDoNotUseDirectly2;
                            // monitorexit(this)
                            return mutexDoNotUseDirectly2;
                            // monitorexit(this)
                            throw;
                        }
                        finally {
                            continue Label_0039;
                        }
                        return mutexDoNotUseDirectly;
                    }
                    continue;
                }
            }
            finally {
                continue Label_0039;
            }
            break;
        }
    }
    
    public double acquire() {
        return this.acquire(1);
    }
    
    public double acquire(final int n) {
        final long reserve = this.reserve(n);
        this.stopwatch.sleepMicrosUninterruptibly(reserve);
        return 1.0 * reserve / TimeUnit.SECONDS.toMicros(1L);
    }
    
    abstract double doGetRate();
    
    abstract void doSetRate(final double p0, final long p1);
    
    public final double getRate() {
        synchronized (this.mutex()) {
            return this.doGetRate();
        }
    }
    
    abstract long queryEarliestAvailable(final long p0);
    
    final long reserve(final int n) {
        checkPermits(n);
        synchronized (this.mutex()) {
            return this.reserveAndGetWaitLength(n, this.stopwatch.readMicros());
        }
    }
    
    final long reserveAndGetWaitLength(final int n, final long n2) {
        return Math.max(this.reserveEarliestAvailable(n, n2) - n2, 0L);
    }
    
    abstract long reserveEarliestAvailable(final int p0, final long p1);
    
    public final void setRate(final double v) {
        while (true) {
            Label_0054: {
                if (v <= 0.0 || Double.isNaN(v)) {
                    break Label_0054;
                }
                final boolean b = true;
                Preconditions.checkArgument(b, (Object)"rate must be positive");
                synchronized (this.mutex()) {
                    this.doSetRate(v, this.stopwatch.readMicros());
                    return;
                }
            }
            final boolean b = false;
            continue;
        }
    }
    
    @Override
    public String toString() {
        return String.format("RateLimiter[stableRate=%3.1fqps]", this.getRate());
    }
    
    public boolean tryAcquire() {
        return this.tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }
    
    public boolean tryAcquire(final int n) {
        return this.tryAcquire(n, 0L, TimeUnit.MICROSECONDS);
    }
    
    public boolean tryAcquire(final int n, long duration, final TimeUnit timeUnit) {
        duration = Math.max(timeUnit.toMicros(duration), 0L);
        checkPermits(n);
        synchronized (this.mutex()) {
            final long micros = this.stopwatch.readMicros();
            if (!this.canAcquire(micros, duration)) {
                return false;
            }
            duration = this.reserveAndGetWaitLength(n, micros);
            // monitorexit(this.mutex())
            this.stopwatch.sleepMicrosUninterruptibly(duration);
            return true;
        }
    }
    
    public boolean tryAcquire(final long n, final TimeUnit timeUnit) {
        return this.tryAcquire(1, n, timeUnit);
    }
    
    @VisibleForTesting
    abstract static class SleepingStopwatch
    {
        static final SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() {
                final Stopwatch stopwatch = Stopwatch.createStarted();
                
                @Override
                long readMicros() {
                    return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
                }
                
                @Override
                void sleepMicrosUninterruptibly(final long n) {
                    if (n > 0L) {
                        Uninterruptibles.sleepUninterruptibly(n, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }
        
        abstract long readMicros();
        
        abstract void sleepMicrosUninterruptibly(final long p0);
    }
}
