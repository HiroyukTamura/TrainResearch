/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package jp.co.jreast.jreastapp.commuter.h.a;

import android.view.View;

public final class b
implements View.OnClickListener {
    final a a;
    final int b;

    public b(a a2, int n2) {
        this.a = a2;
        this.b = n2;
    }

    public void onClick(View view) {
        this.a.a(this.b, view);
    }

    public static interface a {
        public void a(int var1, View var2);
    }

}

