/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public abstract class j {
    protected final RecyclerView.i a;
    final Rect b = new Rect();
    private int c = Integer.MIN_VALUE;

    private j(RecyclerView.i i2) {
        this.a = i2;
    }

    public static j a(RecyclerView.i i2) {
        return new j(i2){

            @Override
            public int a(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.h(view) - j2.leftMargin;
            }

            @Override
            public void a(int n2) {
                this.a.j(n2);
            }

            @Override
            public int b(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.j(view) + j2.rightMargin;
            }

            @Override
            public int c() {
                return this.a.A();
            }

            @Override
            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.right;
            }

            @Override
            public int d() {
                return this.a.y() - this.a.C();
            }

            @Override
            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.left;
            }

            @Override
            public int e() {
                return this.a.y();
            }

            @Override
            public int e(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.f(view) + j2.leftMargin + j2.rightMargin;
            }

            @Override
            public int f() {
                return this.a.y() - this.a.A() - this.a.C();
            }

            @Override
            public int f(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.g(view) + j2.topMargin + j2.bottomMargin;
            }

            @Override
            public int g() {
                return this.a.C();
            }

            @Override
            public int h() {
                return this.a.w();
            }

            @Override
            public int i() {
                return this.a.x();
            }
        };
    }

    public static j a(RecyclerView.i i2, int n2) {
        switch (n2) {
            default: {
                throw new IllegalArgumentException("invalid orientation");
            }
            case 1: {
                return j.b(i2);
            }
            case 0: 
        }
        return j.a(i2);
    }

    public static j b(RecyclerView.i i2) {
        return new j(i2){

            @Override
            public int a(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.i(view) - j2.topMargin;
            }

            @Override
            public void a(int n2) {
                this.a.k(n2);
            }

            @Override
            public int b(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.k(view) + j2.bottomMargin;
            }

            @Override
            public int c() {
                return this.a.B();
            }

            @Override
            public int c(View view) {
                this.a.a(view, true, this.b);
                return this.b.bottom;
            }

            @Override
            public int d() {
                return this.a.z() - this.a.D();
            }

            @Override
            public int d(View view) {
                this.a.a(view, true, this.b);
                return this.b.top;
            }

            @Override
            public int e() {
                return this.a.z();
            }

            @Override
            public int e(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.g(view) + j2.topMargin + j2.bottomMargin;
            }

            @Override
            public int f() {
                return this.a.z() - this.a.B() - this.a.D();
            }

            @Override
            public int f(View view) {
                RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                return this.a.f(view) + j2.leftMargin + j2.rightMargin;
            }

            @Override
            public int g() {
                return this.a.D();
            }

            @Override
            public int h() {
                return this.a.x();
            }

            @Override
            public int i() {
                return this.a.w();
            }
        };
    }

    public abstract int a(View var1);

    public void a() {
        this.c = this.f();
    }

    public abstract void a(int var1);

    public int b() {
        if (Integer.MIN_VALUE == this.c) {
            return 0;
        }
        return this.f() - this.c;
    }

    public abstract int b(View var1);

    public abstract int c();

    public abstract int c(View var1);

    public abstract int d();

    public abstract int d(View var1);

    public abstract int e();

    public abstract int e(View var1);

    public abstract int f();

    public abstract int f(View var1);

    public abstract int g();

    public abstract int h();

    public abstract int i();

}

