/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.widget.am;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.x;
import androidx.core.h.t;

class f {
    private final View a;
    private final i b;
    private int c = -1;
    private am d;
    private am e;
    private am f;

    f(View view) {
        this.a = view;
        this.b = i.a();
    }

    private boolean b(Drawable drawable2) {
        if (this.f == null) {
            this.f = new am();
        }
        am am2 = this.f;
        am2.a();
        ColorStateList colorStateList = t.u(this.a);
        if (colorStateList != null) {
            am2.d = true;
            am2.a = colorStateList;
        }
        if ((colorStateList = t.v(this.a)) != null) {
            am2.c = true;
            am2.b = colorStateList;
        }
        if (!am2.d && !am2.c) {
            return false;
        }
        i.a(drawable2, am2, this.a.getDrawableState());
        return true;
    }

    private boolean d() {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        if (n2 > 21) {
            if (this.d != null) {
                bl2 = true;
            }
            return bl2;
        }
        return n2 == 21;
    }

    ColorStateList a() {
        if (this.e != null) {
            return this.e.a;
        }
        return null;
    }

    void a(int n2) {
        this.c = n2;
        ColorStateList colorStateList = this.b != null ? this.b.b(this.a.getContext(), n2) : null;
        this.b(colorStateList);
        this.c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new am();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        this.c();
    }

    void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new am();
        }
        this.e.b = mode;
        this.e.c = true;
        this.c();
    }

    void a(Drawable drawable2) {
        this.c = -1;
        this.b((ColorStateList)null);
        this.c();
    }

    void a(AttributeSet object, int n2) {
        object = ao.a(this.a.getContext(), (AttributeSet)object, a.j.ViewBackgroundHelper, n2, 0);
        try {
            if (((ao)object).g(a.j.ViewBackgroundHelper_android_background)) {
                this.c = ((ao)object).g(a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateList = this.b.b(this.a.getContext(), this.c);
                if (colorStateList != null) {
                    this.b(colorStateList);
                }
            }
            if (((ao)object).g(a.j.ViewBackgroundHelper_backgroundTint)) {
                t.a(this.a, ((ao)object).e(a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (((ao)object).g(a.j.ViewBackgroundHelper_backgroundTintMode)) {
                t.a(this.a, x.a(((ao)object).a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            return;
        }
        finally {
            ((ao)object).a();
        }
    }

    PorterDuff.Mode b() {
        if (this.e != null) {
            return this.e.b;
        }
        return null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new am();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        this.c();
    }

    /*
     * Enabled aggressive block sorting
     */
    void c() {
        block4 : {
            am am2;
            Drawable drawable2;
            block6 : {
                block5 : {
                    drawable2 = this.a.getBackground();
                    if (drawable2 == null) break block4;
                    if (this.d() && this.b(drawable2)) {
                        return;
                    }
                    if (this.e == null) break block5;
                    am2 = this.e;
                    break block6;
                }
                if (this.d == null) break block4;
                am2 = this.d;
            }
            i.a(drawable2, am2, this.a.getDrawableState());
            return;
        }
    }
}

