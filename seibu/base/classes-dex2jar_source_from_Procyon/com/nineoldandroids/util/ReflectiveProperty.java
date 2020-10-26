// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

class ReflectiveProperty<T, V> extends Property<T, V>
{
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;
    
    public ReflectiveProperty(final Class<T> clazz, final Class<V> clazz2, String returnType) {
        super(clazz2, returnType);
        final String string = Character.toUpperCase(returnType.charAt(0)) + returnType.substring(1);
        String s = "get" + string;
        try {
            this.mGetter = clazz.getMethod(s, (Class[])null);
            returnType = (String)this.mGetter.getReturnType();
            if (!this.typesMatch(clazz2, (Class)returnType)) {
                throw new NoSuchPropertyException("Underlying type (" + (Object)returnType + ") " + "does not match Property type (" + clazz2 + ")");
            }
        }
        catch (NoSuchMethodException ex) {
            try {
                (this.mGetter = clazz.getDeclaredMethod(s, (Class[])null)).setAccessible(true);
            }
            catch (NoSuchMethodException ex2) {
                s = "is" + string;
                try {
                    this.mGetter = clazz.getMethod(s, (Class[])null);
                }
                catch (NoSuchMethodException ex3) {
                    try {
                        (this.mGetter = clazz.getDeclaredMethod(s, (Class[])null)).setAccessible(true);
                    }
                    catch (NoSuchMethodException ex4) {
                        try {
                            this.mField = clazz.getField(returnType);
                            final Class<?> type = this.mField.getType();
                            if (!this.typesMatch(clazz2, type)) {
                                throw new NoSuchPropertyException("Underlying type (" + type + ") " + "does not match Property type (" + clazz2 + ")");
                            }
                            return;
                        }
                        catch (NoSuchFieldException ex5) {
                            throw new NoSuchPropertyException("No accessor method or field found for property with name " + returnType);
                        }
                    }
                }
            }
        }
        final String string2 = "set" + string;
        try {
            (this.mSetter = clazz.getDeclaredMethod(string2, (Class)returnType)).setAccessible(true);
        }
        catch (NoSuchMethodException ex6) {}
    }
    
    private boolean typesMatch(final Class<V> clazz, final Class clazz2) {
        final boolean b = false;
        if (clazz2 != clazz) {
            boolean b2 = b;
            if (clazz2.isPrimitive()) {
                if ((clazz2 != Float.TYPE || clazz != Float.class) && (clazz2 != Integer.TYPE || clazz != Integer.class) && (clazz2 != Boolean.TYPE || clazz != Boolean.class) && (clazz2 != Long.TYPE || clazz != Long.class) && (clazz2 != Double.TYPE || clazz != Double.class) && (clazz2 != Short.TYPE || clazz != Short.class) && (clazz2 != Byte.TYPE || clazz != Byte.class)) {
                    b2 = b;
                    if (clazz2 != Character.TYPE) {
                        return b2;
                    }
                    b2 = b;
                    if (clazz != Character.class) {
                        return b2;
                    }
                }
                b2 = true;
            }
            return b2;
        }
        return true;
    }
    
    @Override
    public V get(final T t) {
        if (this.mGetter != null) {
            try {
                return (V)this.mGetter.invoke(t, (Object[])null);
            }
            catch (IllegalAccessException ex2) {
                throw new AssertionError();
            }
            catch (InvocationTargetException ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
        if (this.mField != null) {
            try {
                return (V)this.mField.get(t);
            }
            catch (IllegalAccessException ex3) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }
    
    @Override
    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }
    
    @Override
    public void set(final T t, final V value) {
        if (this.mSetter != null) {
            try {
                this.mSetter.invoke(t, value);
                return;
            }
            catch (IllegalAccessException ex2) {
                throw new AssertionError();
            }
            catch (InvocationTargetException ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
        if (this.mField != null) {
            try {
                this.mField.set(t, value);
                return;
            }
            catch (IllegalAccessException ex3) {
                throw new AssertionError();
            }
        }
        throw new UnsupportedOperationException("Property " + this.getName() + " is read-only");
    }
}
