// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.eventbus;

import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

class EventSubscriber
{
    private final Method method;
    private final Object target;
    
    EventSubscriber(final Object target, final Method method) {
        Preconditions.checkNotNull(target, (Object)"EventSubscriber target cannot be null.");
        Preconditions.checkNotNull(method, (Object)"EventSubscriber method cannot be null.");
        this.target = target;
        (this.method = method).setAccessible(true);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof EventSubscriber) {
            final EventSubscriber eventSubscriber = (EventSubscriber)o;
            b2 = b;
            if (this.target == eventSubscriber.target) {
                b2 = b;
                if (this.method.equals(eventSubscriber.method)) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public Method getMethod() {
        return this.method;
    }
    
    public Object getSubscriber() {
        return this.target;
    }
    
    public void handleEvent(final Object o) throws InvocationTargetException {
        Preconditions.checkNotNull(o);
        try {
            this.method.invoke(this.target, o);
        }
        catch (IllegalArgumentException cause) {
            final String value = String.valueOf(String.valueOf(o));
            throw new Error(new StringBuilder(value.length() + 33).append("Method rejected target/argument: ").append(value).toString(), cause);
        }
        catch (IllegalAccessException cause2) {
            final String value2 = String.valueOf(String.valueOf(o));
            throw new Error(new StringBuilder(value2.length() + 28).append("Method became inaccessible: ").append(value2).toString(), cause2);
        }
        catch (InvocationTargetException ex) {
            if (ex.getCause() instanceof Error) {
                throw (Error)ex.getCause();
            }
            throw ex;
        }
    }
    
    @Override
    public int hashCode() {
        return (this.method.hashCode() + 31) * 31 + System.identityHashCode(this.target);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.method));
        return new StringBuilder(value.length() + 10).append("[wrapper ").append(value).append("]").toString();
    }
}
