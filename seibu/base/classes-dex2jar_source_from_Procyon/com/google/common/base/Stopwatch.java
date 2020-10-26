// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.TimeUnit;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible(emulated = true)
public final class Stopwatch
{
    private long elapsedNanos;
    private boolean isRunning;
    private long startTick;
    private final Ticker ticker;
    
    @Deprecated
    Stopwatch() {
        this(Ticker.systemTicker());
    }
    
    @Deprecated
    Stopwatch(final Ticker ticker) {
        this.ticker = Preconditions.checkNotNull(ticker, (Object)"ticker");
    }
    
    private static String abbreviate(final TimeUnit timeUnit) {
        switch (timeUnit) {
            default: {
                throw new AssertionError();
            }
            case NANOSECONDS: {
                return "ns";
            }
            case MICROSECONDS: {
                return "\u03bcs";
            }
            case MILLISECONDS: {
                return "ms";
            }
            case SECONDS: {
                return "s";
            }
            case MINUTES: {
                return "min";
            }
            case HOURS: {
                return "h";
            }
            case DAYS: {
                return "d";
            }
        }
    }
    
    private static TimeUnit chooseUnit(final long n) {
        if (TimeUnit.DAYS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }
    
    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }
    
    public static Stopwatch createStarted(final Ticker ticker) {
        return new Stopwatch(ticker).start();
    }
    
    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }
    
    public static Stopwatch createUnstarted(final Ticker ticker) {
        return new Stopwatch(ticker);
    }
    
    private long elapsedNanos() {
        if (this.isRunning) {
            return this.ticker.read() - this.startTick + this.elapsedNanos;
        }
        return this.elapsedNanos;
    }
    
    public long elapsed(final TimeUnit timeUnit) {
        return timeUnit.convert(this.elapsedNanos(), TimeUnit.NANOSECONDS);
    }
    
    public boolean isRunning() {
        return this.isRunning;
    }
    
    public Stopwatch reset() {
        this.elapsedNanos = 0L;
        this.isRunning = false;
        return this;
    }
    
    public Stopwatch start() {
        Preconditions.checkState(!this.isRunning, (Object)"This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }
    
    public Stopwatch stop() {
        final long read = this.ticker.read();
        Preconditions.checkState(this.isRunning, (Object)"This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos += read - this.startTick;
        return this;
    }
    
    @GwtIncompatible("String.format()")
    @Override
    public String toString() {
        final long elapsedNanos = this.elapsedNanos();
        final TimeUnit chooseUnit = chooseUnit(elapsedNanos);
        return String.format("%.4g %s", elapsedNanos / (double)TimeUnit.NANOSECONDS.convert(1L, chooseUnit), abbreviate(chooseUnit));
    }
}
