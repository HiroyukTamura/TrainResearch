// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.BlockingQueue;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;
import com.google.common.annotations.Beta;

@Beta
public final class Uninterruptibles
{
    private Uninterruptibles() {
    }
    
    public static void awaitUninterruptibly(final CountDownLatch countDownLatch) {
        boolean b = false;
        while (true) {
            try {
                countDownLatch.await();
            }
            catch (InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    public static boolean awaitUninterruptibly(final CountDownLatch countDownLatch, long nanoTime, final TimeUnit timeUnit) {
        final boolean b = false;
        int n = 0;
        int n2 = b ? 1 : 0;
        try {
            final long nanos = timeUnit.toNanos(nanoTime);
            n2 = (b ? 1 : 0);
            final long nanoTime2 = System.nanoTime();
            nanoTime = nanos;
            while (true) {
                n2 = n;
                try {
                    return countDownLatch.await(nanoTime, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException ex) {
                    n2 = 1;
                    n = 1;
                    nanoTime = System.nanoTime();
                    nanoTime = nanoTime2 + nanos - nanoTime;
                }
            }
        }
        finally {
            if (n2 != 0) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static <V> V getUninterruptibly(final Future<V> future) throws ExecutionException {
        boolean b = false;
        try {
            return future.get();
        }
        catch (InterruptedException ex) {
            b = true;
            return future.get();
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static <V> V getUninterruptibly(final Future<V> future, long nanoTime, final TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        final boolean b = false;
        int n = 0;
        int n2 = b ? 1 : 0;
        try {
            final long nanos = timeUnit.toNanos(nanoTime);
            n2 = (b ? 1 : 0);
            final long nanoTime2 = System.nanoTime();
            nanoTime = nanos;
            while (true) {
                n2 = n;
                try {
                    return future.get(nanoTime, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException ex) {
                    n2 = 1;
                    n = 1;
                    nanoTime = System.nanoTime();
                    nanoTime = nanoTime2 + nanos - nanoTime;
                }
            }
        }
        finally {
            if (n2 != 0) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static void joinUninterruptibly(final Thread thread) {
        boolean b = false;
        while (true) {
            try {
                thread.join();
            }
            catch (InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    public static void joinUninterruptibly(final Thread thread, long nanoTime, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(thread);
        final boolean b = false;
        int n = 0;
        int n2 = b ? 1 : 0;
        try {
            final long nanos = timeUnit.toNanos(nanoTime);
            n2 = (b ? 1 : 0);
            final long nanoTime2 = System.nanoTime();
            nanoTime = nanos;
            while (true) {
                n2 = n;
                try {
                    TimeUnit.NANOSECONDS.timedJoin(thread, nanoTime);
                }
                catch (InterruptedException ex) {
                    n2 = 1;
                    n = 1;
                    nanoTime = System.nanoTime();
                    nanoTime = nanoTime2 + nanos - nanoTime;
                }
            }
        }
        finally {
            if (n2 != 0) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static <E> void putUninterruptibly(final BlockingQueue<E> blockingQueue, final E e) {
        boolean b = false;
        while (true) {
            try {
                blockingQueue.put(e);
            }
            catch (InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    public static void sleepUninterruptibly(long nanoTime, final TimeUnit timeUnit) {
        final boolean b = false;
        int n = 0;
        int n2 = b ? 1 : 0;
        try {
            final long nanos = timeUnit.toNanos(nanoTime);
            n2 = (b ? 1 : 0);
            final long nanoTime2 = System.nanoTime();
            nanoTime = nanos;
            while (true) {
                n2 = n;
                try {
                    TimeUnit.NANOSECONDS.sleep(nanoTime);
                }
                catch (InterruptedException ex) {
                    n2 = 1;
                    n = 1;
                    nanoTime = System.nanoTime();
                    nanoTime = nanoTime2 + nanos - nanoTime;
                }
            }
        }
        finally {
            if (n2 != 0) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static <E> E takeUninterruptibly(final BlockingQueue<E> blockingQueue) {
        boolean b = false;
        try {
            return blockingQueue.take();
        }
        catch (InterruptedException ex) {
            b = true;
            return blockingQueue.take();
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static boolean tryAcquireUninterruptibly(final Semaphore semaphore, final int permits, long nanoTime, final TimeUnit timeUnit) {
        final boolean b = false;
        int n = 0;
        int n2 = b ? 1 : 0;
        try {
            final long nanos = timeUnit.toNanos(nanoTime);
            n2 = (b ? 1 : 0);
            final long nanoTime2 = System.nanoTime();
            nanoTime = nanos;
            while (true) {
                n2 = n;
                try {
                    return semaphore.tryAcquire(permits, nanoTime, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException ex) {
                    n2 = 1;
                    n = 1;
                    nanoTime = System.nanoTime();
                    nanoTime = nanoTime2 + nanos - nanoTime;
                }
            }
        }
        finally {
            if (n2 != 0) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static boolean tryAcquireUninterruptibly(final Semaphore semaphore, final long n, final TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, n, timeUnit);
    }
}
