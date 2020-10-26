// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base.internal;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.logging.Logger;
import java.lang.reflect.Field;

public class Finalizer implements Runnable
{
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    private static final Field inheritableThreadLocals;
    private static final Logger logger;
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;
    
    static {
        logger = Logger.getLogger(Finalizer.class.getName());
        inheritableThreadLocals = getInheritableThreadLocalsField();
    }
    
    private Finalizer(final Class<?> referent, final ReferenceQueue<Object> queue, final PhantomReference<Object> frqReference) {
        this.queue = queue;
        this.finalizableReferenceClassReference = new WeakReference<Class<?>>(referent);
        this.frqReference = frqReference;
    }
    
    private boolean cleanUp(Reference<?> poll) {
        final Method finalizeReferentMethod = this.getFinalizeReferentMethod();
        if (finalizeReferentMethod != null) {
        Label_0033_Outer:
            while (true) {
                poll.clear();
                if (poll == this.frqReference) {
                    break;
                }
                while (true) {
                    try {
                        finalizeReferentMethod.invoke(poll, new Object[0]);
                        if ((poll = this.queue.poll()) == null) {
                            return true;
                        }
                        continue Label_0033_Outer;
                    }
                    catch (Throwable thrown) {
                        Finalizer.logger.log(Level.SEVERE, "Error cleaning up after reference.", thrown);
                        continue;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private Method getFinalizeReferentMethod() {
        final Class clazz = this.finalizableReferenceClassReference.get();
        if (clazz == null) {
            return null;
        }
        try {
            return clazz.getMethod("finalizeReferent", (Class[])new Class[0]);
        }
        catch (NoSuchMethodException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    public static Field getInheritableThreadLocalsField() {
        try {
            final Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        }
        catch (Throwable t) {
            Finalizer.logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }
    
    public static void startFinalizer(Class<?> obj, final ReferenceQueue<Object> referenceQueue, final PhantomReference<Object> phantomReference) {
        if (!((Class)obj).getName().equals("com.google.common.base.FinalizableReference")) {
            throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
        }
        obj = new Thread(new Finalizer((Class<?>)obj, referenceQueue, phantomReference));
        obj.setName(Finalizer.class.getName());
        obj.setDaemon(true);
        while (true) {
            try {
                if (Finalizer.inheritableThreadLocals != null) {
                    Finalizer.inheritableThreadLocals.set(obj, null);
                }
                obj.start();
            }
            catch (Throwable thrown) {
                Finalizer.logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", thrown);
                continue;
            }
            break;
        }
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                while (this.cleanUp(this.queue.remove())) {}
            }
            catch (InterruptedException ex) {
                continue;
            }
            break;
        }
    }
}
