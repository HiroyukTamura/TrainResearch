/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.widget.PopupWindow
 */
package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.h.d;
import androidx.core.h.t;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class h {
    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void a(PopupWindow popupWindow, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(n2);
            return;
        }
        if (!b) {
            try {
                a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                a.setAccessible(true);
            }
            catch (Exception exception) {}
            b = true;
        }
        if (a == null) return;
        try {
            a.invoke((Object)popupWindow, n2);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void a(PopupWindow popupWindow, View view, int n2, int n3, int n4) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, n2, n3, n4);
            return;
        }
        int n5 = n2;
        if ((d.a(n4, t.f(view)) & 7) == 5) {
            n5 = n2 - (popupWindow.getWidth() - view.getWidth());
        }
        popupWindow.showAsDropDown(view, n5, n3);
    }

    public static void a(PopupWindow popupWindow, boolean bl2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(bl2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (!d) {
                try {
                    c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    c.setAccessible(true);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Log.i((String)"PopupWindowCompatApi21", (String)"Could not fetch mOverlapAnchor field from PopupWindow", (Throwable)noSuchFieldException);
                }
                d = true;
            }
            if (c != null) {
                try {
                    c.set((Object)popupWindow, bl2);
                    return;
                }
                catch (IllegalAccessException illegalAccessException) {
                    Log.i((String)"PopupWindowCompatApi21", (String)"Could not set overlap anchor field in PopupWindow", (Throwable)illegalAccessException);
                }
            }
        }
    }
}

