/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.util.Log
 *  android.view.View
 */
package androidx.j;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import androidx.j.af;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ag
extends af {
    private static Method a;
    private static boolean b;

    ag() {
    }

    @SuppressLint(value={"PrivateApi"})
    private void a() {
        if (!b) {
            try {
                a = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                a.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)"ViewUtilsApi22", (String)"Failed to retrieve setLeftTopRightBottom method", (Throwable)noSuchMethodException);
            }
            b = true;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void a(View view, int n2, int n3, int n4, int n5) {
        this.a();
        if (a == null) return;
        try {
            a.invoke((Object)view, n2, n3, n4, n5);
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

