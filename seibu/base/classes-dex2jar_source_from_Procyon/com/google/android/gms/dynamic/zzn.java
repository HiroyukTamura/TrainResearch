// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import java.lang.reflect.Field;
import android.os.IBinder;

public final class zzn<T> extends zza
{
    private final T mWrappedObject;
    
    private zzn(final T mWrappedObject) {
        this.mWrappedObject = mWrappedObject;
    }
    
    public static <T> T zzE(final IObjectWrapper objectWrapper) {
        int n = 0;
        if (objectWrapper instanceof zzn) {
            return (T)((zzn)objectWrapper).mWrappedObject;
        }
        final IBinder binder = objectWrapper.asBinder();
        final Field[] declaredFields = binder.getClass().getDeclaredFields();
        Field field = null;
        for (int length = declaredFields.length, i = 0; i < length; ++i) {
            final Field field2 = declaredFields[i];
            if (!field2.isSynthetic()) {
                ++n;
                field = field2;
            }
        }
        if (n == 1) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T)field.get(binder);
                }
                catch (NullPointerException cause) {
                    throw new IllegalArgumentException("Binder object is null.", cause);
                }
                catch (IllegalAccessException cause2) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", cause2);
                }
            }
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        throw new IllegalArgumentException(new StringBuilder(64).append("Unexpected number of IObjectWrapper declared fields: ").append(declaredFields.length).toString());
    }
    
    public static <T> IObjectWrapper zzw(final T t) {
        return new zzn<Object>(t);
    }
}
