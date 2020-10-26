/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewGroup
 */
package androidx.j;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class z {
    private static Method a;
    private static boolean b;

    private static void a() {
        if (!b) {
            try {
                a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
                a.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)"ViewUtilsApi18", (String)"Failed to retrieve suppressLayout method", (Throwable)noSuchMethodException);
            }
            b = true;
        }
    }

    static void a(ViewGroup object, boolean bl2) {
        z.a();
        if (a != null) {
            void var2_4;
            try {
                a.invoke(object, bl2);
                return;
            }
            catch (InvocationTargetException invocationTargetException) {
                object = "Error invoking suppressLayout method";
            }
            catch (IllegalAccessException illegalAccessException) {
                object = "Failed to invoke suppressLayout method";
            }
            Log.i((String)"ViewUtilsApi18", (String)object, (Throwable)var2_4);
        }
    }
}

