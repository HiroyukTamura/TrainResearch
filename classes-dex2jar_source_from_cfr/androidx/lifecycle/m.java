/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import androidx.lifecycle.b;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.i;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m {
    private static Map<Class, Integer> a = new HashMap<Class, Integer>();
    private static Map<Class, List<Constructor<? extends e>>> b = new HashMap<Class, List<Constructor<? extends e>>>();

    private static e a(Constructor<? extends e> object, Object object2) {
        try {
            object = ((Constructor)object).newInstance(object2);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException(instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    static f a(Object object) {
        if (object instanceof d) {
            return new FullLifecycleObserverAdapter((d)object);
        }
        if (object instanceof f) {
            return (f)object;
        }
        Class<?> class_ = object.getClass();
        if (m.b(class_) == 2) {
            class_ = b.get(class_);
            int n2 = class_.size();
            if (n2 == 1) {
                return new SingleGeneratedAdapterObserver(m.a((Constructor)class_.get(0), object));
            }
            e[] arre = new e[class_.size()];
            for (int i2 = 0; i2 < class_.size(); ++i2) {
                arre[i2] = m.a((Constructor)class_.get(i2), object);
            }
            return new CompositeGeneratedAdaptersObserver(arre);
        }
        return new ReflectiveGenericLifecycleObserver(object);
    }

    public static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2.replace(".", "_"));
        stringBuilder.append("_LifecycleAdapter");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Constructor<? extends e> a(Class<?> genericDeclaration) {
        try {
            Object object = ((Class)genericDeclaration).getPackage();
            String string2 = ((Class)genericDeclaration).getCanonicalName();
            object = object != null ? ((Package)object).getName() : "";
            if (!((String)object).isEmpty()) {
                string2 = string2.substring(((String)object).length() + 1);
            }
            string2 = m.a(string2);
            if (((String)object).isEmpty()) {
                object = string2;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object);
                stringBuilder.append(".");
                stringBuilder.append(string2);
                object = stringBuilder.toString();
            }
            genericDeclaration = Class.forName((String)object).getDeclaredConstructor(new Class[]{genericDeclaration});
            if (((AccessibleObject)((Object)genericDeclaration)).isAccessible()) return genericDeclaration;
            ((AccessibleObject)((Object)genericDeclaration)).setAccessible(true);
            return genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException(noSuchMethodException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    private static int b(Class<?> class_) {
        if (a.containsKey(class_)) {
            return a.get(class_);
        }
        int n2 = m.c(class_);
        a.put(class_, n2);
        return n2;
    }

    private static int c(Class<?> class_) {
        if (class_.getCanonicalName() == null) {
            return 1;
        }
        Object object = m.a(class_);
        if (object != null) {
            b.put(class_, Collections.singletonList(object));
            return 2;
        }
        if (b.a.a(class_)) {
            return 1;
        }
        ArrayList arrayList = class_.getSuperclass();
        object = null;
        if (m.d(arrayList)) {
            if (m.b(arrayList) == 1) {
                return 1;
            }
            object = new ArrayList(b.get(arrayList));
        }
        for (Class<?> class_2 : class_.getInterfaces()) {
            if (!m.d(class_2)) continue;
            if (m.b(class_2) == 1) {
                return 1;
            }
            arrayList = object;
            if (object == null) {
                arrayList = new ArrayList();
            }
            arrayList.addAll(b.get(class_2));
            object = arrayList;
        }
        if (object != null) {
            b.put(class_, (List<Constructor<? extends e>>)object);
            return 2;
        }
        return 1;
    }

    private static boolean d(Class<?> class_) {
        return class_ != null && i.class.isAssignableFrom(class_);
    }
}

