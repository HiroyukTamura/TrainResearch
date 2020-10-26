// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import com.google.common.collect.ObjectArrays;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.util.HashSet;
import com.google.common.collect.Sets;
import java.util.Set;
import java.lang.reflect.Method;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import com.google.common.annotations.Beta;

@Beta
public final class SimpleTimeLimiter implements TimeLimiter
{
    private final ExecutorService executor;
    
    public SimpleTimeLimiter() {
        this(Executors.newCachedThreadPool());
    }
    
    public SimpleTimeLimiter(final ExecutorService executorService) {
        this.executor = Preconditions.checkNotNull(executorService);
    }
    
    private static boolean declaresInterruptedEx(final Method method) {
        final Class<?>[] exceptionTypes = method.getExceptionTypes();
        for (int length = exceptionTypes.length, i = 0; i < length; ++i) {
            if (exceptionTypes[i] == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }
    
    private static Set<Method> findInterruptibleMethods(final Class<?> clazz) {
        final HashSet<Method> hashSet = Sets.newHashSet();
        final Method[] methods = clazz.getMethods();
        for (int length = methods.length, i = 0; i < length; ++i) {
            final Method method = methods[i];
            if (declaresInterruptedEx(method)) {
                hashSet.add(method);
            }
        }
        return hashSet;
    }
    
    private static <T> T newProxy(final Class<T> clazz, final InvocationHandler h) {
        return clazz.cast(Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, h));
    }
    
    private static Exception throwCause(final Exception ex, final boolean b) throws Exception {
        final Throwable cause = ex.getCause();
        if (cause == null) {
            throw ex;
        }
        if (b) {
            cause.setStackTrace(ObjectArrays.concat(cause.getStackTrace(), ex.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw (Exception)cause;
        }
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        throw ex;
    }
    
    @Override
    public <T> T callWithTimeout(Callable<T> submit, final long l, final TimeUnit timeUnit, final boolean b) throws Exception {
        Preconditions.checkNotNull(submit);
        Preconditions.checkNotNull(timeUnit);
        Label_0068: {
            if (l <= 0L) {
                break Label_0068;
            }
            boolean b2 = true;
            Preconditions.checkArgument(b2, "timeout must be positive: %s", l);
            submit = this.executor.submit((Callable<T>)submit);
            if (!b) {
                goto Label_0094;
            }
            try {
                try {
                    return submit.get(l, timeUnit);
                    b2 = false;
                }
                catch (InterruptedException ex) {
                    submit.cancel(true);
                    throw ex;
                }
            }
            catch (ExecutionException ex2) {
                throw throwCause(ex2, true);
            }
            catch (TimeoutException ex3) {
                submit.cancel(true);
                throw new UncheckedTimeoutException(ex3);
            }
        }
    }
    
    @Override
    public <T> T newProxy(final T t, final Class<T> clazz, final long l, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(l > 0L, "bad timeout: %s", l);
        Preconditions.checkArgument(clazz.isInterface(), (Object)"interfaceType must be an interface type");
        return newProxy(clazz, new InvocationHandler() {
            final /* synthetic */ Set val$interruptibleMethods = findInterruptibleMethods(clazz);
            
            @Override
            public Object invoke(final Object o, final Method method, final Object[] array) throws Throwable {
                return SimpleTimeLimiter.this.callWithTimeout((Callable<Object>)new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        try {
                            return method.invoke(t, array);
                        }
                        catch (InvocationTargetException ex) {
                            throwCause(ex, false);
                            throw new AssertionError((Object)"can't get here");
                        }
                    }
                }, l, timeUnit, this.val$interruptibleMethods.contains(method));
            }
        });
    }
}
