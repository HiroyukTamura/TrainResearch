/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.widget.CompoundButton
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.a;
import androidx.appcompat.widget.x;
import androidx.core.widget.c;

class h {
    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    h(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    int a(int n2) {
        int n3 = n2;
        if (Build.VERSION.SDK_INT < 17) {
            Drawable drawable2 = c.b(this.a);
            n3 = n2;
            if (drawable2 != null) {
                n3 = n2 + drawable2.getIntrinsicWidth();
            }
        }
        return n3;
    }

    ColorStateList a() {
        return this.b;
    }

    void a(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        this.d();
    }

    void a(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        this.d();
    }

    void a(AttributeSet attributeSet, int n2) {
        attributeSet = this.a.getContext().obtainStyledAttributes(attributeSet, a.j.CompoundButton, n2, 0);
        try {
            if (attributeSet.hasValue(a.j.CompoundButton_android_button) && (n2 = attributeSet.getResourceId(a.j.CompoundButton_android_button, 0)) != 0) {
                this.a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.a.getContext(), n2));
            }
            if (attributeSet.hasValue(a.j.CompoundButton_buttonTint)) {
                c.a(this.a, attributeSet.getColorStateList(a.j.CompoundButton_buttonTint));
            }
            if (attributeSet.hasValue(a.j.CompoundButton_buttonTintMode)) {
                c.a(this.a, x.a(attributeSet.getInt(a.j.CompoundButton_buttonTintMode, -1), null));
            }
            return;
        }
        finally {
            attributeSet.recycle();
        }
    }

    PorterDuff.Mode b() {
        return this.c;
    }

    void c() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        this.d();
    }

    void d() {
        Drawable drawable2 = c.b(this.a);
        if (drawable2 != null && (this.d || this.e)) {
            drawable2 = androidx.core.graphics.drawable.a.g(drawable2).mutate();
            if (this.d) {
                androidx.core.graphics.drawable.a.a(drawable2, this.b);
            }
            if (this.e) {
                androidx.core.graphics.drawable.a.a(drawable2, this.c);
            }
            if (drawable2.isStateful()) {
                drawable2.setState(this.a.getDrawableState());
            }
            this.a.setButtonDrawable(drawable2);
        }
    }
}

