/*
 * Decompiled with CFR 0.139.
 */
package c.a.g;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class e<T> {
    private final Class<?> a;
    private final String b;
    private final Class[] c;

    /* varargs */ e(Class<?> class_, String string2, Class ... arrclass) {
        this.a = class_;
        this.b = string2;
        this.c = arrclass;
    }

    private Method a(Class<?> class_) {
        String string2 = this.b;
        Method method = null;
        if (string2 != null && (method = e.a(class_, this.b, this.c)) != null && this.a != null && !this.a.isAssignableFrom(method.getReturnType())) {
            return null;
        }
        return method;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Method a(Class<?> genericDeclaration, String string2, Class[] arrclass) {
        try {
            genericDeclaration = ((Class)genericDeclaration).getMethod(string2, arrclass);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
        try {
            int n2 = ((Method)genericDeclaration).getModifiers();
            if ((n2 & 1) != 0) return genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return genericDeclaration;
        }
        do {
            return null;
            break;
        } while (true);
    }

    public /* varargs */ Object a(T object, Object ... arrobject) {
        Method method = this.a(object.getClass());
        if (method == null) {
            return null;
        }
        try {
            object = method.invoke(object, arrobject);
            return object;
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    public boolean a(T t2) {
        return this.a(t2.getClass()) != null;
    }

    public /* varargs */ Object b(T object, Object ... object2) {
        try {
            object = this.a(object, (Object[])object2);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            object2 = new AssertionError((Object)"Unexpected exception");
            ((Throwable)object2).initCause(throwable);
            throw object2;
        }
    }

    public /* varargs */ Object c(T object, Object ... object2) {
        Method method = this.a(object.getClass());
        if (method != null) {
            try {
                object = method.invoke(object, (Object[])object2);
                return object;
            }
            catch (IllegalAccessException illegalAccessException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unexpectedly could not call: ");
                ((StringBuilder)object2).append(method);
                object2 = new AssertionError((Object)((StringBuilder)object2).toString());
                ((Throwable)object2).initCause(illegalAccessException);
                throw object2;
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Method ");
        ((StringBuilder)object2).append(this.b);
        ((StringBuilder)object2).append(" not supported for object ");
        ((StringBuilder)object2).append(object);
        throw new AssertionError((Object)((StringBuilder)object2).toString());
    }

    public /* varargs */ Object d(T object, Object ... object2) {
        try {
            object = this.c(object, (Object[])object2);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            object2 = new AssertionError((Object)"Unexpected exception");
            ((Throwable)object2).initCause(throwable);
            throw object2;
        }
    }
}

