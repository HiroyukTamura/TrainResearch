/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.h;
import androidx.appcompat.widget.t;
import androidx.core.widget.j;

public class g
extends CheckBox
implements j {
    private final h a = new h((CompoundButton)this);
    private final t b;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.checkboxStyle);
    }

    public g(Context context, AttributeSet attributeSet, int n2) {
        super(al.a(context), attributeSet, n2);
        this.a.a(attributeSet, n2);
        this.b = new t((TextView)this);
        this.b.a(attributeSet, n2);
    }

    public int getCompoundPaddingLeft() {
        int n2;
        int n3 = n2 = super.getCompoundPaddingLeft();
        if (this.a != null) {
            n3 = this.a.a(n2);
        }
        return n3;
    }

    @Override
    public ColorStateList getSupportButtonTintList() {
        if (this.a != null) {
            return this.a.a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public void setButtonDrawable(int n2) {
        this.setButtonDrawable(androidx.appcompat.a.a.a.b(this.getContext(), n2));
    }

    public void setButtonDrawable(Drawable drawable2) {
        super.setButtonDrawable(drawable2);
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    @Override
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }
}

