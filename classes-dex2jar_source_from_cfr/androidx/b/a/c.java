/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.view.View
 */
package androidx.b.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.b.a.e;
import androidx.b.a.f;
import androidx.b.a.g;
import androidx.b.a.h;

class c
implements f {
    c() {
    }

    private g j(e e2) {
        return (g)e2.a();
    }

    @Override
    public float a(e e2) {
        return this.j(e2).a();
    }

    @Override
    public void a() {
    }

    @Override
    public void a(e e2, float f2) {
        this.j(e2).a(f2);
    }

    @Override
    public void a(e e2, ColorStateList colorStateList) {
        this.j(e2).a(colorStateList);
    }

    @Override
    public float b(e e2) {
        return this.d(e2) * 2.0f;
    }

    @Override
    public void b(e e2, float f2) {
        this.j(e2).a(f2, e2.b(), e2.c());
        this.f(e2);
    }

    @Override
    public float c(e e2) {
        return this.d(e2) * 2.0f;
    }

    @Override
    public void c(e e2, float f2) {
        e2.d().setElevation(f2);
    }

    @Override
    public float d(e e2) {
        return this.j(e2).b();
    }

    @Override
    public float e(e e2) {
        return e2.d().getElevation();
    }

    public void f(e e2) {
        if (!e2.b()) {
            e2.a(0, 0, 0, 0);
            return;
        }
        float f2 = this.a(e2);
        float f3 = this.d(e2);
        int n2 = (int)Math.ceil(h.b(f2, f3, e2.c()));
        int n3 = (int)Math.ceil(h.a(f2, f3, e2.c()));
        e2.a(n2, n3, n2, n3);
    }

    @Override
    public void g(e e2) {
        this.b(e2, this.a(e2));
    }

    @Override
    public void h(e e2) {
        this.b(e2, this.a(e2));
    }

    @Override
    public ColorStateList i(e e2) {
        return this.j(e2).c();
    }
}

