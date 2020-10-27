package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import p009e.p010a.p011a.p012a.C0681a;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int zaa(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        throw new IllegalStateException(C0681a.m309a(33, "Unknown color scheme: ", i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configure(android.content.res.Resources r7, int r8, int r9) {
        /*
            r6 = this;
            android.graphics.Typeface r0 = android.graphics.Typeface.DEFAULT_BOLD
            r6.setTypeface(r0)
            r0 = 1096810496(0x41600000, float:14.0)
            r6.setTextSize(r0)
            android.util.DisplayMetrics r0 = r7.getDisplayMetrics()
            float r0 = r0.density
            r1 = 1111490560(0x42400000, float:48.0)
            float r0 = r0 * r1
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            int r0 = (int) r0
            r6.setMinHeight(r0)
            r6.setMinWidth(r0)
            int r0 = com.google.android.gms.base.C0665R.C0666drawable.common_google_signin_btn_icon_dark
            int r1 = com.google.android.gms.base.C0665R.C0666drawable.common_google_signin_btn_icon_light
            int r0 = zaa(r9, r0, r1, r1)
            int r1 = com.google.android.gms.base.C0665R.C0666drawable.common_google_signin_btn_text_dark
            int r2 = com.google.android.gms.base.C0665R.C0666drawable.common_google_signin_btn_text_light
            int r1 = zaa(r9, r1, r2, r2)
            java.lang.String r2 = "Unknown button size: "
            r3 = 32
            r4 = 2
            r5 = 1
            if (r8 == 0) goto L_0x0045
            if (r8 == r5) goto L_0x0045
            if (r8 != r4) goto L_0x003b
            goto L_0x0046
        L_0x003b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = p009e.p010a.p011a.p012a.C0681a.m309a((int) r3, (java.lang.String) r2, (int) r8)
            r7.<init>(r8)
            throw r7
        L_0x0045:
            r0 = r1
        L_0x0046:
            android.graphics.drawable.Drawable r0 = r7.getDrawable(r0)
            android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.DrawableCompat.wrap(r0)
            int r1 = com.google.android.gms.base.C0665R.color.common_google_signin_btn_tint
            android.content.res.ColorStateList r1 = r7.getColorStateList(r1)
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r0, r1)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_ATOP
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(r0, r1)
            r6.setBackgroundDrawable(r0)
            int r0 = com.google.android.gms.base.C0665R.color.common_google_signin_btn_text_dark
            int r1 = com.google.android.gms.base.C0665R.color.common_google_signin_btn_text_light
            int r9 = zaa(r9, r0, r1, r1)
            android.content.res.ColorStateList r9 = r7.getColorStateList(r9)
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            android.content.res.ColorStateList r9 = (android.content.res.ColorStateList) r9
            r6.setTextColor(r9)
            r9 = 0
            if (r8 == 0) goto L_0x008c
            if (r8 == r5) goto L_0x0089
            if (r8 != r4) goto L_0x007f
            r6.setText(r9)
            goto L_0x0095
        L_0x007f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = p009e.p010a.p011a.p012a.C0681a.m309a((int) r3, (java.lang.String) r2, (int) r8)
            r7.<init>(r8)
            throw r7
        L_0x0089:
            int r8 = com.google.android.gms.base.C0665R.string.common_signin_button_text_long
            goto L_0x008e
        L_0x008c:
            int r8 = com.google.android.gms.base.C0665R.string.common_signin_button_text
        L_0x008e:
            java.lang.String r7 = r7.getString(r8)
            r6.setText(r7)
        L_0x0095:
            r6.setTransformationMethod(r9)
            android.content.Context r7 = r6.getContext()
            boolean r7 = com.google.android.gms.common.util.DeviceProperties.isWearable(r7)
            if (r7 == 0) goto L_0x00a7
            r7 = 19
            r6.setGravity(r7)
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.SignInButtonImpl.configure(android.content.res.Resources, int, int):void");
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
    }
}
