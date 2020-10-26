/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.i;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class e
implements Lock {
    public static final Lock a = new e();

    private e() {
    }

    @Override
    public void lock() {
    }

    @Override
    public void lockInterruptibly() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public boolean tryLock(long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public void unlock() {
    }
}

