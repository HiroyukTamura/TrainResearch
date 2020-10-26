/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.h.a;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public final class d
implements SwipeRefreshLayout.b {
    final a a;
    final int b;

    public d(a a2, int n2) {
        this.a = a2;
        this.b = n2;
    }

    @Override
    public void a() {
        this.a.c(this.b);
    }

    public static interface a {
        public void c(int var1);
    }

}

