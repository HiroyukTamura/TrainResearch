// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

abstract class SmoothRateLimiter extends RateLimiter
{
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;
    
    private SmoothRateLimiter(final SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }
    
    private void resync(final long nextFreeTicketMicros) {
        if (nextFreeTicketMicros > this.nextFreeTicketMicros) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (nextFreeTicketMicros - this.nextFreeTicketMicros) / this.stableIntervalMicros);
            this.nextFreeTicketMicros = nextFreeTicketMicros;
        }
    }
    
    @Override
    final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
    }
    
    abstract void doSetRate(final double p0, final double p1);
    
    @Override
    final void doSetRate(final double n, final long n2) {
        this.resync(n2);
        this.doSetRate(n, this.stableIntervalMicros = TimeUnit.SECONDS.toMicros(1L) / n);
    }
    
    @Override
    final long queryEarliestAvailable(final long n) {
        return this.nextFreeTicketMicros;
    }
    
    @Override
    final long reserveEarliestAvailable(final int n, long nextFreeTicketMicros) {
        this.resync(nextFreeTicketMicros);
        nextFreeTicketMicros = this.nextFreeTicketMicros;
        final double min = Math.min(n, this.storedPermits);
        this.nextFreeTicketMicros += this.storedPermitsToWaitTime(this.storedPermits, min) + (long)(this.stableIntervalMicros * (n - min));
        this.storedPermits -= min;
        return nextFreeTicketMicros;
    }
    
    abstract long storedPermitsToWaitTime(final double p0, final double p1);
    
    static final class SmoothBursty extends SmoothRateLimiter
    {
        final double maxBurstSeconds;
        
        SmoothBursty(final SleepingStopwatch sleepingStopwatch, final double maxBurstSeconds) {
            super(sleepingStopwatch, null);
            this.maxBurstSeconds = maxBurstSeconds;
        }
        
        @Override
        void doSetRate(double storedPermits, double n) {
            n = 0.0;
            final double maxPermits = this.maxPermits;
            this.maxPermits = this.maxBurstSeconds * storedPermits;
            if (maxPermits == Double.POSITIVE_INFINITY) {
                this.storedPermits = this.maxPermits;
                return;
            }
            if (maxPermits == 0.0) {
                storedPermits = n;
            }
            else {
                storedPermits = this.storedPermits * this.maxPermits / maxPermits;
            }
            this.storedPermits = storedPermits;
        }
        
        @Override
        long storedPermitsToWaitTime(final double n, final double n2) {
            return 0L;
        }
    }
    
    static final class SmoothWarmingUp extends SmoothRateLimiter
    {
        private double halfPermits;
        private double slope;
        private final long warmupPeriodMicros;
        
        SmoothWarmingUp(final SleepingStopwatch sleepingStopwatch, final long duration, final TimeUnit timeUnit) {
            super(sleepingStopwatch, null);
            this.warmupPeriodMicros = timeUnit.toMicros(duration);
        }
        
        private double permitsToTime(final double n) {
            return this.stableIntervalMicros + this.slope * n;
        }
        
        @Override
        void doSetRate(double storedPermits, final double n) {
            storedPermits = this.maxPermits;
            this.maxPermits = this.warmupPeriodMicros / n;
            this.halfPermits = this.maxPermits / 2.0;
            this.slope = (n * 3.0 - n) / this.halfPermits;
            if (storedPermits == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0;
                return;
            }
            if (storedPermits == 0.0) {
                storedPermits = this.maxPermits;
            }
            else {
                storedPermits = this.storedPermits * this.maxPermits / storedPermits;
            }
            this.storedPermits = storedPermits;
        }
        
        @Override
        long storedPermitsToWaitTime(double min, final double b) {
            final double a = min - this.halfPermits;
            long n = 0L;
            min = b;
            if (a > 0.0) {
                min = Math.min(a, b);
                n = (long)((this.permitsToTime(a) + this.permitsToTime(a - min)) * min / 2.0);
                min = b - min;
            }
            return (long)(n + this.stableIntervalMicros * min);
        }
    }
}
