/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 */
package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.c;
import androidx.databinding.d;
import androidx.databinding.e;

public class f {
    private static c a = new d();
    private static e b = null;

    public static <T extends ViewDataBinding> T a(Activity activity, int n2) {
        return f.a(activity, n2, b);
    }

    public static <T extends ViewDataBinding> T a(Activity activity, int n2, e e2) {
        activity.setContentView(n2);
        return f.a(e2, (ViewGroup)activity.getWindow().getDecorView().findViewById(16908290), 0, n2);
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int n2, ViewGroup viewGroup, boolean bl2) {
        return f.a(layoutInflater, n2, viewGroup, bl2, b);
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int n2, ViewGroup viewGroup, boolean bl2, e e2) {
        int n3 = 0;
        boolean bl3 = viewGroup != null && bl2;
        if (bl3) {
            n3 = viewGroup.getChildCount();
        }
        layoutInflater = layoutInflater.inflate(n2, viewGroup, bl2);
        if (bl3) {
            return f.a(e2, viewGroup, n3, n2);
        }
        return f.a(e2, (View)layoutInflater, n2);
    }

    static <T extends ViewDataBinding> T a(e e2, View view, int n2) {
        return (T)a.a(e2, view, n2);
    }

    private static <T extends ViewDataBinding> T a(e e2, ViewGroup viewGroup, int n2, int n3) {
        int n4 = viewGroup.getChildCount();
        int n5 = n4 - n2;
        if (n5 == 1) {
            return f.a(e2, viewGroup.getChildAt(n4 - 1), n3);
        }
        View[] arrview = new View[n5];
        for (n4 = 0; n4 < n5; ++n4) {
            arrview[n4] = viewGroup.getChildAt(n4 + n2);
        }
        return f.a(e2, arrview, n3);
    }

    static <T extends ViewDataBinding> T a(e e2, View[] arrview, int n2) {
        return (T)a.a(e2, arrview, n2);
    }

    public static e a() {
        return b;
    }
}

