/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package uk.co.chrisjenx.calligraphy;

import android.util.Log;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    ReflectionUtils() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Field getField(Class annotatedElement, String string2) {
        try {
            annotatedElement = ((Class)annotatedElement).getDeclaredField(string2);
            ((AccessibleObject)annotatedElement).setAccessible(true);
            return annotatedElement;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return null;
        }
    }

    static Method getMethod(Class arrmethod, String string2) {
        for (Method method : arrmethod.getMethods()) {
            if (!method.getName().equals(string2)) continue;
            method.setAccessible(true);
            return method;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Object getValue(Field object, Object object2) {
        try {
            return ((Field)object).get(object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    static /* varargs */ void invokeMethod(Object object, Method method, Object ... arrobject) {
        if (method == null) {
            return;
        }
        try {
            method.invoke(object, arrobject);
            return;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            Log.d((String)TAG, (String)"Can't invoke method using reflection", (Throwable)reflectiveOperationException);
            return;
        }
    }

    static void setValue(Field field, Object object, Object object2) {
        try {
            field.set(object, object2);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            return;
        }
    }
}

