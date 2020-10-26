// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public final class Callables
{
    private Callables() {
    }
    
    public static <T> Callable<T> returning(@Nullable final T t) {
        return new Callable<T>() {
            @Override
            public T call() {
                return t;
            }
        };
    }
    
    static Runnable threadRenaming(final Runnable runnable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new Runnable() {
            @Override
            public void run() {
                final Thread currentThread = Thread.currentThread();
                final String name = currentThread.getName();
                final boolean access$000 = trySetName(supplier.get(), currentThread);
                try {
                    runnable.run();
                }
                finally {
                    if (access$000) {
                        trySetName(name, currentThread);
                    }
                }
            }
        };
    }
    
    static <T> Callable<T> threadRenaming(final Callable<T> callable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callable<T>() {
            @Override
            public T call() throws Exception {
                final Thread currentThread = Thread.currentThread();
                final String name = currentThread.getName();
                final boolean access$000 = trySetName(supplier.get(), currentThread);
                try {
                    return callable.call();
                }
                finally {
                    if (access$000) {
                        trySetName(name, currentThread);
                    }
                }
            }
        };
    }
    
    private static boolean trySetName(final String name, final Thread thread) {
        try {
            thread.setName(name);
            return true;
        }
        catch (SecurityException ex) {
            return false;
        }
    }
}
