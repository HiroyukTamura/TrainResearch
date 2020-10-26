// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.content.res.TypedArray;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import com.google.android.gms.dynamic.zzq;
import com.google.android.gms.common.internal.zzbw;
import android.util.Log;
import com.google.android.gms.common.internal.zzbv;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.R;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;

public final class SignInButton extends FrameLayout implements View$OnClickListener
{
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzaAv;
    private View$OnClickListener zzaAw;
    
    public SignInButton(final Context context) {
        this(context, null);
    }
    
    public SignInButton(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public SignInButton(Context obtainStyledAttributes, final AttributeSet set, final int n) {
        super(obtainStyledAttributes, set, n);
        this.zzaAw = null;
        obtainStyledAttributes = (Context)obtainStyledAttributes.getTheme().obtainStyledAttributes(set, R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = ((TypedArray)obtainStyledAttributes).getInt(R.styleable.SignInButton_buttonSize, 0);
            this.mColor = ((TypedArray)obtainStyledAttributes).getInt(R.styleable.SignInButton_colorScheme, 2);
            ((TypedArray)obtainStyledAttributes).recycle();
            this.setStyle(this.mSize, this.mColor);
        }
        finally {
            ((TypedArray)obtainStyledAttributes).recycle();
        }
    }
    
    public final void onClick(final View view) {
        if (this.zzaAw != null && view == this.zzaAv) {
            this.zzaAw.onClick((View)this);
        }
    }
    
    public final void setColorScheme(final int n) {
        this.setStyle(this.mSize, n);
    }
    
    public final void setEnabled(final boolean b) {
        super.setEnabled(b);
        this.zzaAv.setEnabled(b);
    }
    
    public final void setOnClickListener(final View$OnClickListener zzaAw) {
        this.zzaAw = zzaAw;
        if (this.zzaAv != null) {
            this.zzaAv.setOnClickListener((View$OnClickListener)this);
        }
    }
    
    @Deprecated
    public final void setScopes(final Scope[] array) {
        this.setStyle(this.mSize, this.mColor);
    }
    
    public final void setSize(final int n) {
        this.setStyle(n, this.mColor);
    }
    
    public final void setStyle(int mSize, int mColor) {
        this.mSize = mSize;
        this.mColor = mColor;
        final Context context = this.getContext();
        if (this.zzaAv != null) {
            this.removeView(this.zzaAv);
        }
        while (true) {
            try {
                this.zzaAv = zzbv.zzc(context, this.mSize, this.mColor);
                this.addView(this.zzaAv);
                this.zzaAv.setEnabled(this.isEnabled());
                this.zzaAv.setOnClickListener((View$OnClickListener)this);
            }
            catch (zzq zzq) {
                Log.w("SignInButton", "Sign in button not found, using placeholder instead");
                mSize = this.mSize;
                mColor = this.mColor;
                final zzbw zzaAv = new zzbw(context);
                zzaAv.zza(context.getResources(), mSize, mColor);
                this.zzaAv = (View)zzaAv;
                continue;
            }
            break;
        }
    }
    
    @Deprecated
    public final void setStyle(final int n, final int n2, final Scope[] array) {
        this.setStyle(n, n2);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }
}
