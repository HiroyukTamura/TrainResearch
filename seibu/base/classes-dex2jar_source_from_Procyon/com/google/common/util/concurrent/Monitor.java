// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Throwables;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import com.google.common.annotations.Beta;

@Beta
public final class Monitor
{
    @GuardedBy("lock")
    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;
    
    public Monitor() {
        this(false);
    }
    
    public Monitor(final boolean b) {
        this.activeGuards = null;
        this.fair = b;
        this.lock = new ReentrantLock(b);
    }
    
    @GuardedBy("lock")
    private void await(final Guard guard, final boolean b) throws InterruptedException {
        if (b) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(guard);
        try {
            do {
                guard.condition.await();
            } while (!guard.isSatisfied());
        }
        finally {
            this.endWaitingFor(guard);
        }
    }
    
    @GuardedBy("lock")
    private boolean awaitNanos(final Guard guard, long awaitNanos, final boolean b) throws InterruptedException {
        if (b) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(guard);
        while (awaitNanos >= 0L) {
            try {
                awaitNanos = guard.condition.awaitNanos(awaitNanos);
                if (guard.isSatisfied()) {
                    return true;
                }
                continue;
            }
            finally {
                this.endWaitingFor(guard);
            }
        }
        this.endWaitingFor(guard);
        return false;
    }
    
    @GuardedBy("lock")
    private void awaitUninterruptibly(final Guard guard, final boolean b) {
        if (b) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(guard);
        try {
            do {
                guard.condition.awaitUninterruptibly();
            } while (!guard.isSatisfied());
        }
        finally {
            this.endWaitingFor(guard);
        }
    }
    
    @GuardedBy("lock")
    private void beginWaitingFor(final Guard activeGuards) {
        if (activeGuards.waiterCount++ == 0) {
            activeGuards.next = this.activeGuards;
            this.activeGuards = activeGuards;
        }
    }
    
    @GuardedBy("lock")
    private void endWaitingFor(final Guard guard) {
        final int waiterCount = guard.waiterCount - 1;
        guard.waiterCount = waiterCount;
        if (waiterCount == 0) {
            Guard guard2 = this.activeGuards;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.next;
            }
            if (guard3 == null) {
                this.activeGuards = guard2.next;
            }
            else {
                guard3.next = guard2.next;
            }
            guard2.next = null;
        }
    }
    
    @GuardedBy("lock")
    private boolean isSatisfied(final Guard guard) {
        try {
            return guard.isSatisfied();
        }
        catch (Throwable t) {
            this.signalAllWaiters();
            throw Throwables.propagate(t);
        }
    }
    
    @GuardedBy("lock")
    private void signalAllWaiters() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            guard.condition.signalAll();
        }
    }
    
    @GuardedBy("lock")
    private void signalNextWaiter() {
        for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
            if (this.isSatisfied(guard)) {
                guard.condition.signal();
                break;
            }
        }
    }
    
    public void enter() {
        this.lock.lock();
    }
    
    public boolean enter(long nanoTime, final TimeUnit timeUnit) {
        final long nanos = timeUnit.toNanos(nanoTime);
        final ReentrantLock lock = this.lock;
        if (!this.fair && lock.tryLock()) {
            return true;
        }
        final long nanoTime2 = System.nanoTime();
        boolean interrupted = Thread.interrupted();
        nanoTime = nanos;
        while (true) {
            boolean tryLock = interrupted;
            try {
                return tryLock = lock.tryLock(nanoTime, TimeUnit.NANOSECONDS);
            }
            catch (InterruptedException ex) {
                tryLock = true;
                interrupted = true;
                nanoTime = System.nanoTime();
                nanoTime = nanoTime2 + nanos - nanoTime;
            }
            finally {
                if (tryLock) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    public boolean enterIf(final Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            final boolean satisfied = guard.isSatisfied();
            if (!satisfied) {
                lock.unlock();
            }
            return satisfied;
        }
        finally {
            if (!false) {
                lock.unlock();
            }
        }
    }
    
    public boolean enterIf(final Guard guard, final long n, final TimeUnit timeUnit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        boolean b;
        if (!this.enter(n, timeUnit)) {
            b = false;
        }
        else {
            try {
                final boolean satisfied = guard.isSatisfied();
                if (!(b = satisfied)) {
                    this.lock.unlock();
                    return satisfied;
                }
            }
            finally {
                if (!false) {
                    this.lock.unlock();
                }
            }
        }
        return b;
    }
    
    public boolean enterIfInterruptibly(final Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            final boolean satisfied = guard.isSatisfied();
            if (!satisfied) {
                lock.unlock();
            }
            return satisfied;
        }
        finally {
            if (!false) {
                lock.unlock();
            }
        }
    }
    
    public boolean enterIfInterruptibly(final Guard guard, final long timeout, final TimeUnit unit) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        boolean b;
        if (!lock.tryLock(timeout, unit)) {
            b = false;
        }
        else {
            try {
                final boolean satisfied = guard.isSatisfied();
                if (!(b = satisfied)) {
                    lock.unlock();
                    return satisfied;
                }
            }
            finally {
                if (!false) {
                    lock.unlock();
                }
            }
        }
        return b;
    }
    
    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }
    
    public boolean enterInterruptibly(final long timeout, final TimeUnit unit) throws InterruptedException {
        return this.lock.tryLock(timeout, unit);
    }
    
    public void enterWhen(final Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        final boolean heldByCurrentThread = lock.isHeldByCurrentThread();
        lock.lockInterruptibly();
        try {
            if (!guard.isSatisfied()) {
                this.await(guard, heldByCurrentThread);
            }
            if (!true) {
                this.leave();
            }
        }
        finally {
            if (!false) {
                this.leave();
            }
        }
    }
    
    public boolean enterWhen(final Guard guard, final long n, final TimeUnit unit) throws InterruptedException {
        final long nanos = unit.toNanos(n);
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        final boolean heldByCurrentThread = lock.isHeldByCurrentThread();
        Label_0089: {
            long n2 = 0L;
            if (!this.fair) {
                n2 = nanos;
                if (lock.tryLock()) {
                    break Label_0089;
                }
            }
            final long nanoTime = System.nanoTime();
            Block_4: {
                if (lock.tryLock(n, unit)) {
                    n2 = nanoTime + nanos - System.nanoTime();
                    break Block_4;
                }
                return false;
            }
            try {
                Label_0145: {
                    if (!guard.isSatisfied()) {
                        final boolean awaitNanos = this.awaitNanos(guard, n2, heldByCurrentThread);
                        if (!awaitNanos) {
                            break Label_0145;
                        }
                    }
                    boolean awaitNanos = true;
                    final boolean b = awaitNanos;
                    if (awaitNanos) {
                        return b;
                    }
                    if (!false || heldByCurrentThread) {
                        return awaitNanos;
                    }
                    try {
                        this.signalNextWaiter();
                        return awaitNanos;
                        awaitNanos = false;
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }
            finally {
                Label_0182: {
                    if (false) {
                        break Label_0182;
                    }
                    Label_0177: {
                        if (!true || heldByCurrentThread) {
                            break Label_0177;
                        }
                        try {
                            this.signalNextWaiter();
                            lock.unlock();
                        }
                        finally {
                            lock.unlock();
                        }
                    }
                }
            }
        }
    }
    
    public void enterWhenUninterruptibly(final Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        final boolean heldByCurrentThread = lock.isHeldByCurrentThread();
        lock.lock();
        try {
            if (!guard.isSatisfied()) {
                this.awaitUninterruptibly(guard, heldByCurrentThread);
            }
            if (!true) {
                this.leave();
            }
        }
        finally {
            if (!false) {
                this.leave();
            }
        }
    }
    
    public boolean enterWhenUninterruptibly(final Guard guard, long duration, TimeUnit lock) {
        long nanos = lock.toNanos(duration);
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        lock = (TimeUnit)this.lock;
        final long n = System.nanoTime() + nanos;
        final boolean heldByCurrentThread = ((ReentrantLock)lock).isHeldByCurrentThread();
        int n3;
        int n2 = n3 = (Thread.interrupted() ? 1 : 0);
        try {
            int n4 = 0;
            Label_0183: {
                if (!this.fair) {
                    n3 = n2;
                    final int tryLock = ((ReentrantLock)lock).tryLock() ? 1 : 0;
                    n4 = n2;
                    duration = nanos;
                    if (tryLock != 0) {
                        break Label_0183;
                    }
                }
                int tryLock = 0;
                int i;
                do {
                    n3 = n2;
                    try {
                        n3 = (((ReentrantLock)lock).tryLock(nanos, TimeUnit.NANOSECONDS) ? 1 : 0);
                        n4 = n2;
                        i = n3;
                        if (n3 == 0) {
                            final int n5 = n3 = 0;
                            if (n2 != 0) {
                                Thread.currentThread().interrupt();
                                n3 = n5;
                            }
                            return n3 != 0;
                        }
                    }
                    catch (InterruptedException ex) {
                        n4 = 1;
                        i = tryLock;
                    }
                    n3 = n4;
                    duration = System.nanoTime();
                    duration = n - duration;
                    n2 = n4;
                    tryLock = i;
                    nanos = duration;
                } while (i == 0);
            }
            n3 = (heldByCurrentThread ? 1 : 0);
            while (true) {
                int n6 = n4;
                try {
                    Label_0220: {
                        if (!guard.isSatisfied()) {
                            n6 = n4;
                            n3 = (this.awaitNanos(guard, duration, (boolean)(n3 != 0)) ? 1 : 0);
                            if (n3 == 0) {
                                n6 = 0;
                                break Label_0220;
                            }
                        }
                        n6 = 1;
                    }
                    if (n6 == 0) {
                        n3 = n4;
                        ((ReentrantLock)lock).unlock();
                    }
                    n3 = n6;
                    return n6 != 0;
                }
                catch (InterruptedException ex2) {
                    n6 = 1;
                    n4 = 1;
                    n3 = 0;
                    duration = System.nanoTime();
                    duration = n - duration;
                }
                finally {
                    if (!false) {
                        n3 = n6;
                        ((ReentrantLock)lock).unlock();
                    }
                    n3 = n6;
                }
            }
        }
        finally {
            if (n3 != 0) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }
    
    public int getQueueLength() {
        return this.lock.getQueueLength();
    }
    
    public int getWaitQueueLength(final Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            return guard.waiterCount;
        }
        finally {
            this.lock.unlock();
        }
    }
    
    public boolean hasQueuedThread(final Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }
    
    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }
    
    public boolean hasWaiters(final Guard guard) {
        return this.getWaitQueueLength(guard) > 0;
    }
    
    public boolean isFair() {
        return this.fair;
    }
    
    public boolean isOccupied() {
        return this.lock.isLocked();
    }
    
    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }
    
    public void leave() {
        final ReentrantLock lock = this.lock;
        try {
            if (lock.getHoldCount() == 1) {
                this.signalNextWaiter();
            }
        }
        finally {
            lock.unlock();
        }
    }
    
    public boolean tryEnter() {
        return this.lock.tryLock();
    }
    
    public boolean tryEnterIf(final Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        final ReentrantLock lock = this.lock;
        boolean b;
        if (!lock.tryLock()) {
            b = false;
        }
        else {
            try {
                final boolean satisfied = guard.isSatisfied();
                if (!(b = satisfied)) {
                    lock.unlock();
                    return satisfied;
                }
            }
            finally {
                if (!false) {
                    lock.unlock();
                }
            }
        }
        return b;
    }
    
    public void waitFor(final Guard guard) throws InterruptedException {
        if (!(guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (!guard.isSatisfied()) {
            this.await(guard, true);
        }
    }
    
    public boolean waitFor(final Guard guard, long nanos, final TimeUnit timeUnit) throws InterruptedException {
        boolean b = false;
        nanos = timeUnit.toNanos(nanos);
        if (!(guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied() || this.awaitNanos(guard, nanos, true)) {
            b = true;
        }
        return b;
    }
    
    public void waitForUninterruptibly(final Guard guard) {
        if (!(guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        if (!guard.isSatisfied()) {
            this.awaitUninterruptibly(guard, true);
        }
    }
    
    public boolean waitForUninterruptibly(final Guard guard, long nanoTime, final TimeUnit timeUnit) {
        final long nanos = timeUnit.toNanos(nanoTime);
        if (!(guard.monitor == this & this.lock.isHeldByCurrentThread())) {
            throw new IllegalMonitorStateException();
        }
        boolean awaitNanos;
        if (guard.isSatisfied()) {
            awaitNanos = true;
        }
        else {
            boolean satisfied = true;
            final long nanoTime2 = System.nanoTime();
            boolean interrupted = Thread.interrupted();
            nanoTime = nanos;
            while (true) {
                awaitNanos = interrupted;
                try {
                    satisfied = (awaitNanos = this.awaitNanos(guard, nanoTime, satisfied));
                    return satisfied;
                }
                catch (InterruptedException ex) {
                    final boolean b = true;
                    interrupted = true;
                    awaitNanos = b;
                    satisfied = guard.isSatisfied();
                    if (satisfied) {
                        awaitNanos = true;
                        if (true) {
                            Thread.currentThread().interrupt();
                            return true;
                        }
                        break;
                    }
                    else {
                        satisfied = false;
                        awaitNanos = b;
                        nanoTime = System.nanoTime();
                        nanoTime = nanoTime2 + nanos - nanoTime;
                    }
                }
                finally {
                    if (awaitNanos) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        return awaitNanos;
    }
    
    @Beta
    public abstract static class Guard
    {
        final Condition condition;
        final Monitor monitor;
        @GuardedBy("monitor.lock")
        Guard next;
        @GuardedBy("monitor.lock")
        int waiterCount;
        
        protected Guard(final Monitor monitor) {
            this.waiterCount = 0;
            this.monitor = Preconditions.checkNotNull(monitor, (Object)"monitor");
            this.condition = monitor.lock.newCondition();
        }
        
        public abstract boolean isSatisfied();
    }
}
