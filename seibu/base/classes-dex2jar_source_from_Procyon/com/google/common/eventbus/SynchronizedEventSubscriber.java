// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class SynchronizedEventSubscriber extends EventSubscriber
{
    public SynchronizedEventSubscriber(final Object o, final Method method) {
        super(o, method);
    }
    
    @Override
    public void handleEvent(final Object o) throws InvocationTargetException {
        synchronized (this) {
            super.handleEvent(o);
        }
    }
}
