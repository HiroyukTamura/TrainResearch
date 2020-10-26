/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;

class l {
    static int a(RecyclerView.u u2, j j2, View view, View view2, RecyclerView.i i2, boolean bl2) {
        if (i2.v() != 0 && u2.e() != 0 && view != null && view2 != null) {
            if (!bl2) {
                return Math.abs(i2.d(view) - i2.d(view2)) + 1;
            }
            int n2 = j2.b(view2);
            int n3 = j2.a(view);
            return Math.min(j2.f(), n2 - n3);
        }
        return 0;
    }

    static int a(RecyclerView.u u2, j j2, View view, View view2, RecyclerView.i i2, boolean bl2, boolean bl3) {
        if (i2.v() != 0 && u2.e() != 0 && view != null) {
            if (view2 == null) {
                return 0;
            }
            int n2 = Math.min(i2.d(view), i2.d(view2));
            int n3 = Math.max(i2.d(view), i2.d(view2));
            n2 = bl3 ? Math.max(0, u2.e() - n3 - 1) : Math.max(0, n2);
            if (!bl2) {
                return n2;
            }
            n3 = Math.abs(j2.b(view2) - j2.a(view));
            int n4 = Math.abs(i2.d(view) - i2.d(view2));
            float f2 = (float)n3 / (float)(n4 + 1);
            return Math.round((float)n2 * f2 + (float)(j2.c() - j2.a(view)));
        }
        return 0;
    }

    static int b(RecyclerView.u u2, j j2, View view, View view2, RecyclerView.i i2, boolean bl2) {
        if (i2.v() != 0 && u2.e() != 0 && view != null && view2 != null) {
            if (!bl2) {
                return u2.e();
            }
            int n2 = j2.b(view2);
            int n3 = j2.a(view);
            int n4 = Math.abs(i2.d(view) - i2.d(view2));
            return (int)((float)(n2 - n3) / (float)(n4 + 1) * (float)u2.e());
        }
        return 0;
    }
}

