package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import p009e.p028d.p030b.p054b.C1533b;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.internal.b */
public class C1192b extends LinearLayoutCompat {

    /* renamed from: a */
    private Drawable f1215a;

    /* renamed from: b */
    private final Rect f1216b;

    /* renamed from: c */
    private final Rect f1217c;

    /* renamed from: d */
    private int f1218d;

    /* renamed from: e */
    protected boolean f1219e;

    /* renamed from: f */
    boolean f1220f;

    public C1192b(Context context) {
        this(context, (AttributeSet) null);
    }

    public C1192b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1192b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1216b = new Rect();
        this.f1217c = new Rect();
        this.f1218d = 119;
        this.f1219e = true;
        this.f1220f = false;
        TypedArray a = C1196d.m1820a(context, attributeSet, C1533b.f1762e, i, 0, new int[0]);
        this.f1218d = a.getInt(1, this.f1218d);
        Drawable drawable = a.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f1219e = a.getBoolean(2, true);
        a.recycle();
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f1215a;
        if (drawable != null) {
            if (this.f1220f) {
                this.f1220f = false;
                Rect rect = this.f1216b;
                Rect rect2 = this.f1217c;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f1219e) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f1218d, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f1215a;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1215a;
        if (drawable != null && drawable.isStateful()) {
            this.f1215a.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f1215a;
    }

    public int getForegroundGravity() {
        return this.f1218d;
    }

    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1215a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1220f = z | this.f1220f;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1220f = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f1215a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f1215a);
            }
            this.f1215a = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f1218d == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.f1218d != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f1218d = i;
            if (i == 119 && this.f1215a != null) {
                this.f1215a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1215a;
    }
}
