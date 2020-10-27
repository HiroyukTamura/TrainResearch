package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.C0042Px;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.C1196d;
import p009e.p028d.p030b.p054b.C1532a;
import p009e.p028d.p030b.p054b.C1533b;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;

public class MaterialButton extends AppCompatButton {
    @Nullable

    /* renamed from: a */
    private final C1173b f1115a;
    @C0042Px

    /* renamed from: b */
    private int f1116b;

    /* renamed from: c */
    private PorterDuff.Mode f1117c;

    /* renamed from: d */
    private ColorStateList f1118d;

    /* renamed from: e */
    private Drawable f1119e;
    @C0042Px

    /* renamed from: f */
    private int f1120f;
    @C0042Px

    /* renamed from: g */
    private int f1121g;

    /* renamed from: h */
    private int f1122h;

    public MaterialButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray a = C1196d.m1820a(context, attributeSet, C1533b.f1763f, i, C2092R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f1116b = a.getDimensionPixelSize(9, 0);
        this.f1117c = C1532a.m2124a(a.getInt(12, -1), PorterDuff.Mode.SRC_IN);
        this.f1118d = C1532a.m2123a(getContext(), a, 11);
        this.f1119e = C1532a.m2146b(getContext(), a, 7);
        this.f1122h = a.getInteger(8, 1);
        this.f1120f = a.getDimensionPixelSize(10, 0);
        C1173b bVar = new C1173b(this);
        this.f1115a = bVar;
        bVar.mo25396a(a);
        a.recycle();
        setCompoundDrawablePadding(this.f1116b);
        m1753b();
    }

    /* renamed from: a */
    private boolean m1752a() {
        C1173b bVar = this.f1115a;
        return bVar != null && !bVar.mo25400c();
    }

    /* renamed from: b */
    private void m1753b() {
        Drawable drawable = this.f1119e;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f1119e = mutate;
            DrawableCompat.setTintList(mutate, this.f1118d);
            PorterDuff.Mode mode = this.f1117c;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f1119e, mode);
            }
            int i = this.f1120f;
            if (i == 0) {
                i = this.f1119e.getIntrinsicWidth();
            }
            int i2 = this.f1120f;
            if (i2 == 0) {
                i2 = this.f1119e.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f1119e;
            int i3 = this.f1121g;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        TextViewCompat.setCompoundDrawablesRelative(this, this.f1119e, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25382a(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return m1752a() ? this.f1115a.mo25392a() : super.getSupportBackgroundTintList();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return m1752a() ? this.f1115a.mo25399b() : super.getSupportBackgroundTintMode();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && m1752a()) {
            this.f1115a.mo25397a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C1173b bVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT == 21 && (bVar = this.f1115a) != null) {
            bVar.mo25394a(i4 - i2, i3 - i);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1119e != null && this.f1122h == 2) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i3 = this.f1120f;
            if (i3 == 0) {
                i3 = this.f1119e.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - measureText) - ViewCompat.getPaddingEnd(this)) - i3) - this.f1116b) - ViewCompat.getPaddingStart(this)) / 2;
            boolean z = true;
            if (ViewCompat.getLayoutDirection(this) != 1) {
                z = false;
            }
            if (z) {
                measuredWidth = -measuredWidth;
            }
            if (this.f1121g != measuredWidth) {
                this.f1121g = measuredWidth;
                m1753b();
            }
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(@ColorInt int i) {
        if (m1752a()) {
            this.f1115a.mo25393a(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (m1752a()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.f1115a.mo25401d();
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(@DrawableRes int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (m1752a()) {
            this.f1115a.mo25395a(colorStateList);
        } else if (this.f1115a != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (m1752a()) {
            this.f1115a.mo25398a(mode);
        } else if (this.f1115a != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }
}
