// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.util.zzj;
import android.text.method.TransformationMethod;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.support.v4.graphics.drawable.DrawableCompat;
import com.google.android.gms.R;
import android.graphics.Typeface;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.Button;

public final class zzbw extends Button
{
    public zzbw(final Context context) {
        this(context, null);
    }
    
    private zzbw(final Context context, final AttributeSet set) {
        super(context, (AttributeSet)null, 16842824);
    }
    
    private static int zzf(final int i, int n, final int n2, final int n3) {
        switch (i) {
            default: {
                throw new IllegalStateException(new StringBuilder(33).append("Unknown color scheme: ").append(i).toString());
            }
            case 1: {
                n = n2;
            }
            case 0: {
                return n;
            }
            case 2: {
                return n3;
            }
        }
    }
    
    public final void zza(final Resources resources, final int n, final int n2) {
        this.setTypeface(Typeface.DEFAULT_BOLD);
        this.setTextSize(14.0f);
        final float density = resources.getDisplayMetrics().density;
        this.setMinHeight((int)(density * 48.0f + 0.5f));
        this.setMinWidth((int)(density * 48.0f + 0.5f));
        final int zzf = zzf(n2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light);
        int zzf2 = zzf(n2, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light);
        switch (n) {
            default: {
                throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(n).toString());
            }
            case 2: {
                zzf2 = zzf;
            }
            case 0:
            case 1: {
                final Drawable wrap = DrawableCompat.wrap(resources.getDrawable(zzf2));
                DrawableCompat.setTintList(wrap, resources.getColorStateList(R.color.common_google_signin_btn_tint));
                DrawableCompat.setTintMode(wrap, PorterDuff$Mode.SRC_ATOP);
                this.setBackgroundDrawable(wrap);
                this.setTextColor((ColorStateList)zzbo.zzu(resources.getColorStateList(zzf(n2, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light))));
                switch (n) {
                    default: {
                        throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(n).toString());
                    }
                    case 0: {
                        this.setText((CharSequence)resources.getString(R.string.common_signin_button_text));
                        break;
                    }
                    case 1: {
                        this.setText((CharSequence)resources.getString(R.string.common_signin_button_text_long));
                        break;
                    }
                    case 2: {
                        this.setText((CharSequence)null);
                        break;
                    }
                }
                this.setTransformationMethod((TransformationMethod)null);
                if (zzj.zzaG(this.getContext())) {
                    this.setGravity(19);
                }
            }
        }
    }
}
