/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Layout
 *  android.text.TextPaint
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 */
package com.google.android.material.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.h.t;
import androidx.core.widget.i;
import com.google.android.material.a;
import com.google.android.material.b.c;
import com.google.android.material.i.b;
import com.google.android.material.internal.f;
import com.google.android.material.internal.g;

public class a
extends AppCompatButton {
    private final c a;
    private int b;
    private PorterDuff.Mode c;
    private ColorStateList e;
    private Drawable f;
    private int g;
    private int h;
    private int i;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.materialButtonStyle);
    }

    public a(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        context = f.a(context, attributeSet, a.i.MaterialButton, n2, a.h.Widget_MaterialComponents_Button, new int[0]);
        this.b = context.getDimensionPixelSize(a.i.MaterialButton_iconPadding, 0);
        this.c = g.a(context.getInt(a.i.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.e = b.a(this.getContext(), (TypedArray)context, a.i.MaterialButton_iconTint);
        this.f = b.b(this.getContext(), (TypedArray)context, a.i.MaterialButton_icon);
        this.i = context.getInteger(a.i.MaterialButton_iconGravity, 1);
        this.g = context.getDimensionPixelSize(a.i.MaterialButton_iconSize, 0);
        this.a = new c(this);
        this.a.a((TypedArray)context);
        context.recycle();
        this.setCompoundDrawablePadding(this.b);
        this.b();
    }

    private boolean a() {
        return t.f((View)this) == 1;
    }

    private void b() {
        if (this.f != null) {
            this.f = androidx.core.graphics.drawable.a.g(this.f).mutate();
            androidx.core.graphics.drawable.a.a(this.f, this.e);
            if (this.c != null) {
                androidx.core.graphics.drawable.a.a(this.f, this.c);
            }
            int n2 = this.g != 0 ? this.g : this.f.getIntrinsicWidth();
            int n3 = this.g != 0 ? this.g : this.f.getIntrinsicHeight();
            this.f.setBounds(this.h, 0, this.h + n2, n3);
        }
        i.a((TextView)this, this.f, null, null, null);
    }

    private boolean c() {
        return this.a != null && !this.a.b();
    }

    public ColorStateList getBackgroundTintList() {
        return this.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (this.c()) {
            return this.a.h();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f;
    }

    public int getIconGravity() {
        return this.i;
    }

    public int getIconPadding() {
        return this.b;
    }

    public int getIconSize() {
        return this.g;
    }

    public ColorStateList getIconTint() {
        return this.e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.c;
    }

    public ColorStateList getRippleColor() {
        if (this.c()) {
            return this.a.e();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (this.c()) {
            return this.a.f();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (this.c()) {
            return this.a.g();
        }
        return 0;
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.c()) {
            return this.a.c();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.c()) {
            return this.a.d();
        }
        return super.getSupportBackgroundTintMode();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && this.c()) {
            this.a.a(canvas);
        }
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        if (Build.VERSION.SDK_INT == 21 && this.a != null) {
            this.a.a(n5 - n3, n4 - n2);
        }
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (this.f != null) {
            String string2;
            if (this.i != 2) {
                return;
            }
            TextPaint textPaint = this.getPaint();
            String string3 = string2 = this.getText().toString();
            if (this.getTransformationMethod() != null) {
                string3 = this.getTransformationMethod().getTransformation((CharSequence)string2, (View)this).toString();
            }
            n3 = Math.min((int)textPaint.measureText(string3), this.getLayout().getWidth());
            n2 = this.g == 0 ? this.f.getIntrinsicWidth() : this.g;
            n2 = n3 = (this.getMeasuredWidth() - n3 - t.h((View)this) - n2 - this.b - t.g((View)this)) / 2;
            if (this.a()) {
                n2 = -n3;
            }
            if (this.h != n2) {
                this.h = n2;
                this.b();
            }
        }
    }

    public void setBackground(Drawable drawable2) {
        this.setBackgroundDrawable(drawable2);
    }

    public void setBackgroundColor(int n2) {
        if (this.c()) {
            this.a.a(n2);
            return;
        }
        super.setBackgroundColor(n2);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable2) {
        if (this.c()) {
            if (drawable2 != this.getBackground()) {
                Log.i((String)"MaterialButton", (String)"Setting a custom background is not supported.");
                this.a.a();
            } else {
                this.getBackground().setState(drawable2.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable2);
    }

    @Override
    public void setBackgroundResource(int n2) {
        Drawable drawable2 = n2 != 0 ? androidx.appcompat.a.a.a.b(this.getContext(), n2) : null;
        this.setBackgroundDrawable(drawable2);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int n2) {
        if (this.c()) {
            this.a.c(n2);
        }
    }

    public void setCornerRadiusResource(int n2) {
        if (this.c()) {
            this.setCornerRadius(this.getResources().getDimensionPixelSize(n2));
        }
    }

    public void setIcon(Drawable drawable2) {
        if (this.f != drawable2) {
            this.f = drawable2;
            this.b();
        }
    }

    public void setIconGravity(int n2) {
        this.i = n2;
    }

    public void setIconPadding(int n2) {
        if (this.b != n2) {
            this.b = n2;
            this.setCompoundDrawablePadding(n2);
        }
    }

    public void setIconResource(int n2) {
        Drawable drawable2 = n2 != 0 ? androidx.appcompat.a.a.a.b(this.getContext(), n2) : null;
        this.setIcon(drawable2);
    }

    public void setIconSize(int n2) {
        if (n2 >= 0) {
            if (this.g != n2) {
                this.g = n2;
                this.b();
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            this.b();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.c != mode) {
            this.c = mode;
            this.b();
        }
    }

    public void setIconTintResource(int n2) {
        this.setIconTint(androidx.appcompat.a.a.a.a(this.getContext(), n2));
    }

    void setInternalBackground(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.c()) {
            this.a.b(colorStateList);
        }
    }

    public void setRippleColorResource(int n2) {
        if (this.c()) {
            this.setRippleColor(androidx.appcompat.a.a.a.a(this.getContext(), n2));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.c()) {
            this.a.c(colorStateList);
        }
    }

    public void setStrokeColorResource(int n2) {
        if (this.c()) {
            this.setStrokeColor(androidx.appcompat.a.a.a.a(this.getContext(), n2));
        }
    }

    public void setStrokeWidth(int n2) {
        if (this.c()) {
            this.a.b(n2);
        }
    }

    public void setStrokeWidthResource(int n2) {
        if (this.c()) {
            this.setStrokeWidth(this.getResources().getDimensionPixelSize(n2));
        }
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.c()) {
            this.a.a(colorStateList);
            return;
        }
        if (this.a != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.c()) {
            this.a.a(mode);
            return;
        }
        if (this.a != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }
}

