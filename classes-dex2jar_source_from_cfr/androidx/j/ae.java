/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 */
package androidx.j;

import android.util.Log;
import android.view.View;
import androidx.j.ah;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ae
extends ah {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    ae() {
    }

    private void a() {
        if (!b) {
            try {
                a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
                a.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)"ViewUtilsApi19", (String)"Failed to retrieve setTransitionAlpha method", (Throwable)noSuchMethodException);
            }
            b = true;
        }
    }

    private void b() {
        if (!d) {
            try {
                c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                c.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)"ViewUtilsApi19", (String)"Failed to retrieve getTransitionAlpha method", (Throwable)noSuchMethodException);
            }
            d = true;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public float a(View view) {
        this.b();
        if (c == null) return super.a(view);
        try {
            return ((Float)c.invoke((Object)view, new Object[0])).floatValue();
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException.getCause());
        }
        catch (IllegalAccessException illegalAccessException) {
            return super.a(view);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(View view, float f2) {
        this.a();
        if (a == null) {
            view.setAlpha(f2);
            return;
        }
        try {
            a.invoke((Object)view, Float.valueOf(f2));
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException.getCause());
        }
        catch (IllegalAccessException illegalAccessException) {
            return;
        }
    }

    @Override
    public void b(View view) {
    }

    @Override
    public void c(View view) {
    }
}

