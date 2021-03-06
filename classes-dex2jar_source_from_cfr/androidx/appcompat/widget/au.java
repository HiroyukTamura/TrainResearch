/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.h.t;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class au {
    private static Method a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        if (Build.VERSION.SDK_INT < 18) return;
        try {
            a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            if (a.isAccessible()) return;
            a.setAccessible(true);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        Log.d((String)"ViewUtils", (String)"Could not find method computeFitSystemWindows. Oh well.");
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (a != null) {
            try {
                a.invoke((Object)view, new Object[]{rect, rect2});
                return;
            }
            catch (Exception exception) {
                Log.d((String)"ViewUtils", (String)"Could not invoke computeFitSystemWindows", (Throwable)exception);
            }
        }
    }

    public static boolean a(View view) {
        return t.f(view) == 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke((Object)view, new Object[0]);
                return;
            }
            catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
                Log.d((String)"ViewUtils", (String)"Could not invoke makeOptionalFitsSystemWindows", (Throwable)reflectiveOperationException);
                return;
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            Log.d((String)"ViewUtils", (String)"Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
    }
}

