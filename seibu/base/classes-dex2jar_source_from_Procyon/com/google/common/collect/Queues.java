// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Queue;
import java.util.Deque;
import java.util.concurrent.SynchronousQueue;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;

public final class Queues
{
    private Queues() {
    }
    
    @Beta
    public static <E> int drain(final BlockingQueue<E> blockingQueue, final Collection<? super E> collection, final int n, long nanos, final TimeUnit timeUnit) throws InterruptedException {
        Preconditions.checkNotNull(collection);
        final long nanoTime = System.nanoTime();
        nanos = timeUnit.toNanos(nanos);
        int n3;
        for (int n2 = 0; (n3 = n2) < n; n2 = n3 + 1) {
            n3 = n2 + blockingQueue.drainTo(collection, n - n2);
            if ((n2 = n3) < n) {
                final E poll = blockingQueue.poll(nanoTime + nanos - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (poll == null) {
                    break;
                }
                collection.add(poll);
            }
        }
        return n3;
    }
    
    @Beta
    public static <E> int drainUninterruptibly(final BlockingQueue<E> blockingQueue, final Collection<? super E> collection, final int n, long nanos, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(collection);
        final long nanoTime = System.nanoTime();
        nanos = timeUnit.toNanos(nanos);
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4 = n2;
            int n5 = n3;
            if (n2 >= n) {
                return n4;
            }
            n5 = n3;
            try {
                n4 = (n2 += blockingQueue.drainTo((Collection<? super Object>)collection, n - n2));
                if (n4 >= n) {
                    continue;
                }
                Object poll;
                while (true) {
                    n5 = n3;
                    try {
                        poll = blockingQueue.poll(nanoTime + nanos - System.nanoTime(), TimeUnit.NANOSECONDS);
                        if (poll == null) {
                            n5 = n3;
                            return n4;
                        }
                    }
                    catch (InterruptedException ex) {
                        n3 = 1;
                        continue;
                    }
                    break;
                }
                n5 = n3;
                collection.add(poll);
                n2 = n4 + 1;
            }
            finally {
                if (n5 != 0) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(final int capacity) {
        return new ArrayBlockingQueue<E>(capacity);
    }
    
    public static <E> ArrayDeque<E> newArrayDeque() {
        return new ArrayDeque<E>();
    }
    
    public static <E> ArrayDeque<E> newArrayDeque(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        final ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
        Iterables.addAll(arrayDeque, iterable);
        return (ArrayDeque<E>)arrayDeque;
    }
    
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue<E>();
    }
    
    public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        final ConcurrentLinkedQueue<Object> concurrentLinkedQueue = new ConcurrentLinkedQueue<Object>();
        Iterables.addAll(concurrentLinkedQueue, iterable);
        return (ConcurrentLinkedQueue<E>)concurrentLinkedQueue;
    }
    
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque() {
        return new LinkedBlockingDeque<E>();
    }
    
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(final int capacity) {
        return new LinkedBlockingDeque<E>(capacity);
    }
    
    public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        final LinkedBlockingDeque<Object> linkedBlockingDeque = new LinkedBlockingDeque<Object>();
        Iterables.addAll(linkedBlockingDeque, iterable);
        return (LinkedBlockingDeque<E>)linkedBlockingDeque;
    }
    
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue() {
        return new LinkedBlockingQueue<E>();
    }
    
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(final int capacity) {
        return new LinkedBlockingQueue<E>(capacity);
    }
    
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        final LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<Object>();
        Iterables.addAll(linkedBlockingQueue, iterable);
        return (LinkedBlockingQueue<E>)linkedBlockingQueue;
    }
    
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue() {
        return new PriorityBlockingQueue<E>();
    }
    
    public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        final PriorityBlockingQueue<Object> priorityBlockingQueue = new PriorityBlockingQueue<Object>();
        Iterables.addAll(priorityBlockingQueue, iterable);
        return (PriorityBlockingQueue<E>)priorityBlockingQueue;
    }
    
    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue() {
        return new PriorityQueue<E>();
    }
    
    public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        final PriorityQueue<Object> priorityQueue = new PriorityQueue<Object>();
        Iterables.addAll(priorityQueue, iterable);
        return (PriorityQueue<E>)priorityQueue;
    }
    
    public static <E> SynchronousQueue<E> newSynchronousQueue() {
        return new SynchronousQueue<E>();
    }
    
    public static <E> Deque<E> synchronizedDeque(final Deque<E> deque) {
        return Synchronized.deque(deque, null);
    }
    
    public static <E> Queue<E> synchronizedQueue(final Queue<E> queue) {
        return Synchronized.queue(queue, null);
    }
}
