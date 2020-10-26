/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.SeekBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.appcompat.a;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.n;
import androidx.appcompat.widget.x;
import androidx.core.h.t;

class r
extends n {
    private final SeekBar a;
    private Drawable b;
    private ColorStateList c = null;
    private PorterDuff.Mode d = null;
    private boolean e = false;
    private boolean f = false;

    r(SeekBar seekBar) {
        super((ProgressBar)seekBar);
        this.a = seekBar;
    }

    private void d() {
        if (this.b != null && (this.e || this.f)) {
            this.b = androidx.core.graphics.drawable.a.g(this.b.mutate());
            if (this.e) {
                androidx.core.graphics.drawable.a.a(this.b, this.c);
            }
            if (this.f) {
                androidx.core.graphics.drawable.a.a(this.b, this.d);
            }
            if (this.b.isStateful()) {
                this.b.setState(this.a.getDrawableState());
            }
        }
    }

    void a(Canvas canvas) {
        if (this.b != null) {
            int n2 = this.a.getMax();
            int n3 = 1;
            if (n2 > 1) {
                int n4 = this.b.getIntrinsicWidth();
                int n5 = this.b.getIntrinsicHeight();
                n4 = n4 >= 0 ? (n4 /= 2) : 1;
                if (n5 >= 0) {
                    n3 = n5 / 2;
                }
                this.b.setBounds(-n4, -n3, n4, n3);
                float f2 = (float)(this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight()) / (float)n2;
                n3 = canvas.save();
                canvas.translate((float)this.a.getPaddingLeft(), (float)(this.a.getHeight() / 2));
                for (n4 = 0; n4 <= n2; ++n4) {
                    this.b.draw(canvas);
                    canvas.translate(f2, 0.0f);
                }
                canvas.restoreToCount(n3);
            }
        }
    }

    void a(Drawable drawable2) {
        if (this.b != null) {
            this.b.setCallback(null);
        }
        this.b = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this.a);
            androidx.core.graphics.drawable.a.b(drawable2, t.f((View)this.a));
            if (drawable2.isStateful()) {
                drawable2.setState(this.a.getDrawableState());
            }
            this.d();
        }
        this.a.invalidate();
    }

    @Override
    void a(AttributeSet object, int n2) {
        super.a((AttributeSet)object, n2);
        object = ao.a(this.a.getContext(), (AttributeSet)object, a.j.AppCompatSeekBar, n2, 0);
        Drawable drawable2 = ((ao)object).b(a.j.AppCompatSeekBar_android_thumb);
        if (drawable2 != null) {
            this.a.setThumb(drawable2);
        }
        this.a(((ao)object).a(a.j.AppCompatSeekBar_tickMark));
        if (((ao)object).g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = x.a(((ao)object).a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (((ao)object).g(a.j.AppCompatSeekBar_tickMarkTint)) {
            this.c = ((ao)object).e(a.j.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        ((ao)object).a();
        this.d();
    }

    void b() {
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    void c() {
        Drawable drawable2 = this.b;
        if (drawable2 != null && drawable2.isStateful() && drawable2.setState(this.a.getDrawableState())) {
            this.a.invalidateDrawable(drawable2);
        }
    }
}

