/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.widget.ImageView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.a;
import androidx.appcompat.widget.am;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.x;
import androidx.core.widget.e;

public class k {
    private final ImageView a;
    private am b;
    private am c;
    private am d;

    public k(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable2) {
        if (this.d == null) {
            this.d = new am();
        }
        am am2 = this.d;
        am2.a();
        ColorStateList colorStateList = e.a(this.a);
        if (colorStateList != null) {
            am2.d = true;
            am2.a = colorStateList;
        }
        if ((colorStateList = e.b(this.a)) != null) {
            am2.c = true;
            am2.b = colorStateList;
        }
        if (!am2.d && !am2.c) {
            return false;
        }
        i.a(drawable2, am2, this.a.getDrawableState());
        return true;
    }

    private boolean e() {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        if (n2 > 21) {
            if (this.b != null) {
                bl2 = true;
            }
            return bl2;
        }
        return n2 == 21;
    }

    public void a(int n2) {
        if (n2 != 0) {
            Drawable drawable2 = androidx.appcompat.a.a.a.b(this.a.getContext(), n2);
            if (drawable2 != null) {
                x.a(drawable2);
            }
            this.a.setImageDrawable(drawable2);
        } else {
            this.a.setImageDrawable(null);
        }
        this.d();
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new am();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        this.d();
    }

    void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new am();
        }
        this.c.b = mode;
        this.c.c = true;
        this.d();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(AttributeSet attributeSet, int n2) {
        ao ao2 = ao.a(this.a.getContext(), attributeSet, a.j.AppCompatImageView, n2, 0);
        try {
            Drawable drawable2 = this.a.getDrawable();
            attributeSet = drawable2;
            if (drawable2 == null) {
                n2 = ao2.g(a.j.AppCompatImageView_srcCompat, -1);
                attributeSet = drawable2;
                if (n2 != -1) {
                    drawable2 = androidx.appcompat.a.a.a.b(this.a.getContext(), n2);
                    attributeSet = drawable2;
                    if (drawable2 != null) {
                        this.a.setImageDrawable(drawable2);
                        attributeSet = drawable2;
                    }
                }
            }
            if (attributeSet != null) {
                x.a((Drawable)attributeSet);
            }
            if (ao2.g(a.j.AppCompatImageView_tint)) {
                e.a(this.a, ao2.e(a.j.AppCompatImageView_tint));
            }
            if (!ao2.g(a.j.AppCompatImageView_tintMode)) return;
            e.a(this.a, x.a(ao2.a(a.j.AppCompatImageView_tintMode, -1), null));
            return;
        }
        finally {
            ao2.a();
        }
    }

    boolean a() {
        Drawable drawable2 = this.a.getBackground();
        return Build.VERSION.SDK_INT < 21 || !(drawable2 instanceof RippleDrawable);
    }

    ColorStateList b() {
        if (this.c != null) {
            return this.c.a;
        }
        return null;
    }

    PorterDuff.Mode c() {
        if (this.c != null) {
            return this.c.b;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    void d() {
        block5 : {
            am am2;
            Drawable drawable2;
            block7 : {
                block6 : {
                    drawable2 = this.a.getDrawable();
                    if (drawable2 != null) {
                        x.a(drawable2);
                    }
                    if (drawable2 == null) break block5;
                    if (this.e() && this.a(drawable2)) {
                        return;
                    }
                    if (this.c == null) break block6;
                    am2 = this.c;
                    break block7;
                }
                if (this.b == null) break block5;
                am2 = this.b;
            }
            i.a(drawable2, am2, this.a.getDrawableState());
            return;
        }
    }
}

