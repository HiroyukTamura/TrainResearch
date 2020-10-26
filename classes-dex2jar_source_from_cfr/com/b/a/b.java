/*
 * Decompiled with CFR 0.139.
 */
package com.b.a;

import com.b.a.a.a;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class b<T> {
    b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> b<T> a(final Class<?> class_) {
        try {
            Constructor<?> constructor = class_.getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
            return new b<T>(){

                @Override
                public T a() {
                    return Constructor.this.newInstance(null);
                }

                public String toString() {
                    return class_.getName();
                }
            };
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        try {
            Class<?> class_2 = Class.forName("sun.misc.Unsafe");
            final Object object = class_2.getDeclaredField("theUnsafe");
            ((AccessibleObject)object).setAccessible(true);
            object = ((Field)object).get(null);
            return new b<T>(){

                @Override
                public T a() {
                    return (T)Method.this.invoke(object, class_);
                }

                public String toString() {
                    return class_.getName();
                }
            };
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError();
        }
        catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException reflectiveOperationException) {}
        try {
            Object object = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            ((AccessibleObject)object).setAccessible(true);
            final int n2 = (Integer)((Method)object).invoke(null, Object.class);
            object = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            ((AccessibleObject)object).setAccessible(true);
            return new b<T>(){

                @Override
                public T a() {
                    return (T)Method.this.invoke(null, class_, n2);
                }

                public String toString() {
                    return class_.getName();
                }
            };
        }
        catch (InvocationTargetException invocationTargetException) {
            throw a.a(invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError();
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        try {
            Method method = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            method.setAccessible(true);
            return new b<T>(){

                @Override
                public T a() {
                    return (T)Method.this.invoke(null, class_, Object.class);
                }

                public String toString() {
                    return class_.getName();
                }
            };
        }
        catch (Exception exception) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cannot construct instances of ");
        stringBuilder.append(class_.getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    abstract T a();

}

