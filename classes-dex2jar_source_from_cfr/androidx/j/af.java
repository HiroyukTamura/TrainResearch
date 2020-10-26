/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Log
 *  android.view.View
 */
package androidx.j;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.j.ae;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class af
extends ae {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    af() {
    }

    private void a() {
        if (!b) {
            try {
                a = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
                a.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)"ViewUtilsApi21", (String)"Failed to retrieve transformMatrixToGlobal method", (Throwable)noSuchMethodException);
            }
            b = true;
        }
    }

    private void b() {
        if (!d) {
            try {
                c = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
                c.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)"ViewUtilsApi21", (String)"Failed to retrieve transformMatrixToLocal method", (Throwable)noSuchMethodException);
            }
            d = true;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void a(View view, Matrix matrix) {
        this.a();
        if (a == null) return;
        try {
            a.invoke((Object)view, new Object[]{matrix});
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException.getCause());
        }
        catch (IllegalAccessException illegalAccessException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void b(View view, Matrix matrix) {
        this.b();
        if (c == null) return;
        try {
            c.invoke((Object)view, new Object[]{matrix});
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException.getCause());
        }
        catch (IllegalAccessException illegalAccessException) {
            return;
        }
    }
}

