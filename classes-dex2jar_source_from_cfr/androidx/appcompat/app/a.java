/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.b;

public abstract class a {
    public abstract int a();

    public androidx.appcompat.view.b a(b.a a2) {
        return null;
    }

    public void a(float f2) {
        if (f2 == 0.0f) {
            return;
        }
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void a(Configuration configuration) {
    }

    public void a(CharSequence charSequence) {
    }

    public abstract void a(boolean var1);

    public boolean a(int n2, KeyEvent keyEvent) {
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public Context b() {
        return null;
    }

    public void b(boolean bl2) {
    }

    public void c(boolean bl2) {
        if (!bl2) {
            return;
        }
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public boolean c() {
        return false;
    }

    public void d(boolean bl2) {
    }

    public boolean d() {
        return false;
    }

    public void e(boolean bl2) {
    }

    public boolean e() {
        return false;
    }

    public void f(boolean bl2) {
    }

    public boolean f() {
        return false;
    }

    void g() {
    }

    public static class a
    extends ViewGroup.MarginLayoutParams {
        public int a = 0;

        public a(int n2, int n3) {
            super(n2, n3);
            this.a = 8388627;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, a.j.ActionBarLayout);
            this.a = context.getInt(a.j.ActionBarLayout_android_layout_gravity, 0);
            context.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(a a2) {
            super((ViewGroup.MarginLayoutParams)a2);
            this.a = a2.a;
        }
    }

    public static interface b {
        public void a(boolean var1);
    }

    @Deprecated
    public static abstract class c {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();
    }

}

