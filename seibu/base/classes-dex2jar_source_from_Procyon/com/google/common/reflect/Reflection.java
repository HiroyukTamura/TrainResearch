// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.reflect;

import java.lang.reflect.Proxy;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import com.google.common.annotations.Beta;

@Beta
public final class Reflection
{
    private Reflection() {
    }
    
    public static String getPackageName(final Class<?> clazz) {
        return getPackageName(clazz.getName());
    }
    
    public static String getPackageName(final String s) {
        final int lastIndex = s.lastIndexOf(46);
        if (lastIndex < 0) {
            return "";
        }
        return s.substring(0, lastIndex);
    }
    
    public static void initialize(final Class<?>... array) {
        final int length = array.length;
        int i = 0;
        while (i < length) {
            final Class<?> clazz = array[i];
            try {
                Class.forName(clazz.getName(), true, clazz.getClassLoader());
                ++i;
                continue;
            }
            catch (ClassNotFoundException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
            break;
        }
    }
    
    public static <T> T newProxy(final Class<T> clazz, final InvocationHandler h) {
        Preconditions.checkNotNull(h);
        Preconditions.checkArgument(clazz.isInterface(), "%s is not an interface", clazz);
        return clazz.cast(Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, h));
    }
}
