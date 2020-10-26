// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import java.net.URLClassLoader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.lang.ref.Reference;
import java.util.logging.Level;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;
import java.lang.reflect.Method;
import java.util.logging.Logger;
import java.io.Closeable;

public class FinalizableReferenceQueue implements Closeable
{
    private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    private static final Logger logger;
    private static final Method startFinalizer;
    final PhantomReference<Object> frqRef;
    final ReferenceQueue<Object> queue;
    final boolean threadStarted;
    
    static {
        logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
        startFinalizer = getStartFinalizer(loadFinalizer((FinalizerLoader)new SystemLoader(), (FinalizerLoader)new DecoupledLoader(), (FinalizerLoader)new DirectLoader()));
    }
    
    public FinalizableReferenceQueue() {
        this.queue = new ReferenceQueue<Object>();
        this.frqRef = new PhantomReference<Object>(this, this.queue);
        boolean threadStarted = false;
        while (true) {
            try {
                FinalizableReferenceQueue.startFinalizer.invoke(null, FinalizableReference.class, this.queue, this.frqRef);
                threadStarted = true;
                this.threadStarted = threadStarted;
            }
            catch (IllegalAccessException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
            catch (Throwable thrown) {
                FinalizableReferenceQueue.logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", thrown);
                continue;
            }
            break;
        }
    }
    
    static Method getStartFinalizer(final Class<?> clazz) {
        try {
            return clazz.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        }
        catch (NoSuchMethodException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    private static Class<?> loadFinalizer(final FinalizerLoader... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final Class<?> loadFinalizer = array[i].loadFinalizer();
            if (loadFinalizer != null) {
                return loadFinalizer;
            }
        }
        throw new AssertionError();
    }
    
    void cleanUp() {
        if (!this.threadStarted) {
            while (true) {
                final Reference<?> poll = this.queue.poll();
                if (poll == null) {
                    break;
                }
                poll.clear();
                try {
                    ((FinalizableReference)poll).finalizeReferent();
                }
                catch (Throwable thrown) {
                    FinalizableReferenceQueue.logger.log(Level.SEVERE, "Error cleaning up after reference.", thrown);
                }
            }
        }
    }
    
    @Override
    public void close() {
        this.frqRef.enqueue();
        this.cleanUp();
    }
    
    static class DecoupledLoader implements FinalizerLoader
    {
        private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.";
        
        URL getBaseUrl() throws IOException {
            final String concat = String.valueOf("com.google.common.base.internal.Finalizer".replace('.', '/')).concat(".class");
            final URL resource = this.getClass().getClassLoader().getResource(concat);
            if (resource == null) {
                throw new FileNotFoundException(concat);
            }
            final String string = resource.toString();
            if (!string.endsWith(concat)) {
                final String value = String.valueOf(string);
                String concat2;
                if (value.length() != 0) {
                    concat2 = "Unsupported path style: ".concat(value);
                }
                else {
                    concat2 = new String("Unsupported path style: ");
                }
                throw new IOException(concat2);
            }
            return new URL(resource, string.substring(0, string.length() - concat.length()));
        }
        
        @Override
        public Class<?> loadFinalizer() {
            try {
                return this.newLoader(this.getBaseUrl()).loadClass("com.google.common.base.internal.Finalizer");
            }
            catch (Exception thrown) {
                FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.", thrown);
                return null;
            }
        }
        
        URLClassLoader newLoader(final URL url) {
            return new URLClassLoader(new URL[] { url }, (ClassLoader)null);
        }
    }
    
    static class DirectLoader implements FinalizerLoader
    {
        @Override
        public Class<?> loadFinalizer() {
            try {
                return Class.forName("com.google.common.base.internal.Finalizer");
            }
            catch (ClassNotFoundException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
    }
    
    interface FinalizerLoader
    {
        @Nullable
        Class<?> loadFinalizer();
    }
    
    static class SystemLoader implements FinalizerLoader
    {
        @VisibleForTesting
        static boolean disabled;
        
        @Override
        public Class<?> loadFinalizer() {
            if (!SystemLoader.disabled) {
                ClassLoader systemClassLoader;
                try {
                    systemClassLoader = ClassLoader.getSystemClassLoader();
                    if (systemClassLoader != null) {
                        final ClassLoader classLoader = systemClassLoader;
                        final String s = "com.google.common.base.internal.Finalizer";
                        final Class<?> loadClass = classLoader.loadClass(s);
                        return loadClass;
                    }
                    return null;
                }
                catch (SecurityException ex) {
                    FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
                    return null;
                }
                try {
                    final ClassLoader classLoader = systemClassLoader;
                    final String s = "com.google.common.base.internal.Finalizer";
                    final Class<?> loadClass2;
                    final Class<?> loadClass = loadClass2 = classLoader.loadClass(s);
                    return loadClass2;
                }
                catch (ClassNotFoundException ex2) {
                    return null;
                }
            }
            return null;
        }
    }
}
