// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.HashMap;
import com.bumptech.glide.load.Key;
import java.util.Map;

final class DiskCacheWriteLocker
{
    private final Map<Key, WriteLock> locks;
    private final WriteLockPool writeLockPool;
    
    DiskCacheWriteLocker() {
        this.locks = new HashMap<Key, WriteLock>();
        this.writeLockPool = new WriteLockPool();
    }
    
    void acquire(final Key key) {
        synchronized (this) {
            Object obtain;
            if ((obtain = this.locks.get(key)) == null) {
                obtain = this.writeLockPool.obtain();
                this.locks.put(key, (WriteLock)obtain);
            }
            ++((WriteLock)obtain).interestedThreads;
            // monitorexit(this)
            ((WriteLock)obtain).lock.lock();
        }
    }
    
    void release(final Key obj) {
        WriteLock writeLock;
        StringBuilder append;
        while (true) {
            while (true) {
                synchronized (this) {
                    writeLock = this.locks.get(obj);
                    if (writeLock != null && writeLock.interestedThreads > 0) {
                        break;
                    }
                    append = new StringBuilder().append("Cannot release a lock that is not held, key: ").append(obj).append(", interestedThreads: ");
                    if (writeLock == null) {
                        final int interestedThreads = 0;
                        throw new IllegalArgumentException(append.append(interestedThreads).toString());
                    }
                }
                final int interestedThreads = writeLock.interestedThreads;
                continue;
            }
        }
        if (--writeLock.interestedThreads == 0) {
            final WriteLock obj2 = this.locks.remove(append);
            if (!obj2.equals(writeLock)) {
                throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + obj2 + ", key: " + (Object)append);
            }
            this.writeLockPool.offer(obj2);
        }
        // monitorexit(this)
        writeLock.lock.unlock();
    }
    
    private static class WriteLock
    {
        int interestedThreads;
        final Lock lock;
        
        private WriteLock() {
            this.lock = new ReentrantLock();
        }
    }
    
    private static class WriteLockPool
    {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool;
        
        private WriteLockPool() {
            this.pool = new ArrayDeque<WriteLock>();
        }
        
        WriteLock obtain() {
            Object pool = this.pool;
            synchronized (pool) {
                final WriteLock writeLock = this.pool.poll();
                // monitorexit(pool)
                pool = writeLock;
                if (writeLock == null) {
                    pool = new WriteLock();
                }
                return (WriteLock)pool;
            }
        }
        
        void offer(final WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }
}
