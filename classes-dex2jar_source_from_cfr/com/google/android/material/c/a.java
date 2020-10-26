/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CompoundButton
 */
package com.google.android.material.c;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.g;
import androidx.core.widget.c;
import com.google.android.material.a;
import com.google.android.material.internal.f;

public class a
extends g {
    private final int[][] a;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.checkboxStyle);
    }

    public a(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        int[] arrn = new int[]{-16842910, 16842912};
        this.a = new int[][]{{16842910, 16842912}, {16842910, -16842912}, arrn, {-16842910, -16842912}};
        context = f.a(context, attributeSet, a.i.MaterialCheckBox, n2, a.h.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        boolean bl2 = context.getBoolean(a.i.MaterialCheckBox_useMaterialThemeColors, false);
        context.recycle();
        if (bl2 && c.a((CompoundButton)this) == null) {
            this.a();
        }
    }

    private void a() {
        int[] arrn = new int[this.a.length];
        int n2 = com.google.android.material.e.a.a((View)this, a.b.colorSecondary);
        int n3 = com.google.android.material.e.a.a((View)this, a.b.colorSurface);
        int n4 = com.google.android.material.e.a.a((View)this, a.b.colorOnSurface);
        arrn[0] = com.google.android.material.e.a.a(n3, n2, 1.0f);
        arrn[1] = com.google.android.material.e.a.a(n3, n4, 0.54f);
        arrn[2] = com.google.android.material.e.a.a(n3, n4, 0.38f);
        arrn[3] = com.google.android.material.e.a.a(n3, n4, 0.38f);
        c.a((CompoundButton)this, new ColorStateList(this.a, arrn));
    }
}

