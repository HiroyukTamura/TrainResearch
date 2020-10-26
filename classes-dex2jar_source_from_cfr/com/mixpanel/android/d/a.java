/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.mixpanel.android.d;

import android.view.View;
import com.mixpanel.android.c.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class a {
    private final String a;
    private final Object[] b;
    private final Class<?> c;
    private final Class<?> d;
    private final Method e;

    public a(Class<?> class_, String charSequence, Object[] arrobject, Class<?> class_2) {
        this.a = charSequence;
        this.b = arrobject;
        this.c = class_2;
        this.e = this.b(class_);
        if (this.e != null) {
            this.d = this.e.getDeclaringClass();
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Method ");
        ((StringBuilder)charSequence).append(class_.getName());
        ((StringBuilder)charSequence).append(".");
        ((StringBuilder)charSequence).append(this.a);
        ((StringBuilder)charSequence).append(" doesn't exit");
        throw new NoSuchMethodException(((StringBuilder)charSequence).toString());
    }

    private static Class<?> a(Class<?> class_) {
        if (class_ == Byte.class) {
            return Byte.TYPE;
        }
        if (class_ == Short.class) {
            return Short.TYPE;
        }
        if (class_ == Integer.class) {
            return Integer.TYPE;
        }
        if (class_ == Long.class) {
            return Long.TYPE;
        }
        if (class_ == Float.class) {
            return Float.TYPE;
        }
        if (class_ == Double.class) {
            return Double.TYPE;
        }
        if (class_ == Boolean.class) {
            return Boolean.TYPE;
        }
        Class<Object> class_2 = class_;
        if (class_ == Character.class) {
            class_2 = Character.TYPE;
        }
        return class_2;
    }

    private Method b(Class<?> arrmethod) {
        Class[] arrclass = new Class[this.b.length];
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            arrclass[i2] = this.b[i2].getClass();
        }
        for (Method method : arrmethod.getMethods()) {
            Object object = method.getName();
            Class<?>[] arrclass2 = method.getParameterTypes();
            if (!((String)object).equals(this.a) || arrclass2.length != this.b.length || !a.a(this.c).isAssignableFrom(a.a(method.getReturnType()))) continue;
            boolean bl2 = true;
            for (int i3 = 0; i3 < arrclass2.length && bl2; ++i3) {
                object = a.a(arrclass[i3]);
                bl2 = a.a(arrclass2[i3]).isAssignableFrom((Class<?>)object);
            }
            if (!bl2) continue;
            return method;
        }
        return null;
    }

    public Object a(View view) {
        return this.a(view, this.b);
    }

    public Object a(View object, Object[] object2) {
        Class<?> class_ = object.getClass();
        if (this.d.isAssignableFrom(class_)) {
            void var3_7;
            try {
                object = this.e.invoke(object, object2);
                return object;
            }
            catch (InvocationTargetException invocationTargetException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Method ");
                ((StringBuilder)object).append(this.e.getName());
                object2 = " threw an exception";
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Method ");
                ((StringBuilder)object).append(this.e.getName());
                object2 = " called with arguments of the wrong type";
            }
            catch (IllegalAccessException illegalAccessException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Method ");
                ((StringBuilder)object).append(this.e.getName());
                object2 = " appears not to be public";
            }
            ((StringBuilder)object).append((String)object2);
            f.e("MixpanelABTest.Caller", ((StringBuilder)object).toString(), (Throwable)var3_7);
        }
        return null;
    }

    public boolean a(Object[] arrobject) {
        Class<?>[] arrclass = this.e.getParameterTypes();
        if (arrobject.length != arrclass.length) {
            return false;
        }
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            Class<?> class_ = a.a(arrclass[i2]);
            if (!(arrobject[i2] == null ? class_ == Byte.TYPE || class_ == Short.TYPE || class_ == Integer.TYPE || class_ == Long.TYPE || class_ == Float.TYPE || class_ == Double.TYPE || class_ == Boolean.TYPE || class_ == Character.TYPE : !class_.isAssignableFrom(a.a(arrobject[i2].getClass())))) continue;
            return false;
        }
        return true;
    }

    public Object[] a() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Caller ");
        stringBuilder.append(this.a);
        stringBuilder.append("(");
        stringBuilder.append(this.b);
        stringBuilder.append(")]");
        return stringBuilder.toString();
    }
}

