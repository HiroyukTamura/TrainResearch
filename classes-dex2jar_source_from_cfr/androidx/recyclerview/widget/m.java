/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class m
extends RecyclerView.f {
    boolean h = true;

    public final void a(RecyclerView.x x2, boolean bl2) {
        this.d(x2, bl2);
        this.f(x2);
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public abstract boolean a(RecyclerView.x var1);

    public abstract boolean a(RecyclerView.x var1, int var2, int var3, int var4, int var5);

    @Override
    public boolean a(RecyclerView.x x2, RecyclerView.f.c c2, RecyclerView.f.c c3) {
        int n2 = c2.a;
        int n3 = c2.b;
        c2 = x2.a;
        int n4 = c3 == null ? c2.getLeft() : c3.a;
        int n5 = c3 == null ? c2.getTop() : c3.b;
        if (!(x2.q() || n2 == n4 && n3 == n5)) {
            c2.layout(n4, n5, c2.getWidth() + n4, c2.getHeight() + n5);
            return this.a(x2, n2, n3, n4, n5);
        }
        return this.a(x2);
    }

    public abstract boolean a(RecyclerView.x var1, RecyclerView.x var2, int var3, int var4, int var5, int var6);

    @Override
    public boolean a(RecyclerView.x x2, RecyclerView.x x3, RecyclerView.f.c c2, RecyclerView.f.c c3) {
        int n2;
        int n3;
        int n4 = c2.a;
        int n5 = c2.b;
        if (x3.c()) {
            n2 = c2.a;
            n3 = c2.b;
        } else {
            n2 = c3.a;
            n3 = c3.b;
        }
        return this.a(x2, x3, n4, n5, n2, n3);
    }

    public final void b(RecyclerView.x x2, boolean bl2) {
        this.c(x2, bl2);
    }

    public abstract boolean b(RecyclerView.x var1);

    @Override
    public boolean b(RecyclerView.x x2, RecyclerView.f.c c2, RecyclerView.f.c c3) {
        if (c2 != null && (c2.a != c3.a || c2.b != c3.b)) {
            return this.a(x2, c2.a, c2.b, c3.a, c3.b);
        }
        return this.b(x2);
    }

    public void c(RecyclerView.x x2, boolean bl2) {
    }

    @Override
    public boolean c(RecyclerView.x x2, RecyclerView.f.c c2, RecyclerView.f.c c3) {
        if (c2.a == c3.a && c2.b == c3.b) {
            this.j(x2);
            return false;
        }
        return this.a(x2, c2.a, c2.b, c3.a, c3.b);
    }

    public void d(RecyclerView.x x2, boolean bl2) {
    }

    @Override
    public boolean h(RecyclerView.x x2) {
        return !this.h || x2.n();
        {
        }
    }

    public final void i(RecyclerView.x x2) {
        this.p(x2);
        this.f(x2);
    }

    public final void j(RecyclerView.x x2) {
        this.t(x2);
        this.f(x2);
    }

    public final void k(RecyclerView.x x2) {
        this.r(x2);
        this.f(x2);
    }

    public final void l(RecyclerView.x x2) {
        this.o(x2);
    }

    public final void m(RecyclerView.x x2) {
        this.s(x2);
    }

    public final void n(RecyclerView.x x2) {
        this.q(x2);
    }

    public void o(RecyclerView.x x2) {
    }

    public void p(RecyclerView.x x2) {
    }

    public void q(RecyclerView.x x2) {
    }

    public void r(RecyclerView.x x2) {
    }

    public void s(RecyclerView.x x2) {
    }

    public void t(RecyclerView.x x2) {
    }
}

