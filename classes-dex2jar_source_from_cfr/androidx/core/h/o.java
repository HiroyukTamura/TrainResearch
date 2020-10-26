/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.core.h;

import android.view.View;
import android.view.ViewGroup;

public class o {
    private final ViewGroup a;
    private int b;

    public o(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public int a() {
        return this.b;
    }

    public void a(View view) {
        this.a(view, 0);
    }

    public void a(View view, int n2) {
        this.b = 0;
    }

    public void a(View view, View view2, int n2) {
        this.a(view, view2, n2, 0);
    }

    public void a(View view, View view2, int n2, int n3) {
        this.b = n2;
    }
}

