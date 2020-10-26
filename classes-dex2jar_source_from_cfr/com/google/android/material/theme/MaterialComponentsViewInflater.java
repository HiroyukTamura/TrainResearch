/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 */
package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.o;
import com.google.android.material.c.a;

@Keep
public class MaterialComponentsViewInflater
extends AppCompatViewInflater {
    private static int floatingToolbarItemBackgroundResId = -1;

    private boolean isFloatingToolbarItemButton(Context context, AttributeSet attributeSet) {
        if (floatingToolbarItemBackgroundResId == -1) {
            floatingToolbarItemBackgroundResId = context.getResources().getIdentifier("floatingToolbarItemBackgroundDrawable", "^attr-private", "android");
        }
        if (floatingToolbarItemBackgroundResId != 0 && floatingToolbarItemBackgroundResId != -1) {
            for (int i2 = 0; i2 < attributeSet.getAttributeCount(); ++i2) {
                int n2;
                if (attributeSet.getAttributeNameResource(i2) != 16842964 || floatingToolbarItemBackgroundResId != (n2 = attributeSet.getAttributeListValue(i2, null, 0))) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT == 23 && this.isFloatingToolbarItemButton(context, attributeSet)) {
            return new AppCompatButton(context, attributeSet);
        }
        return new com.google.android.material.b.a(context, attributeSet);
    }

    @Override
    protected g createCheckBox(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override
    protected o createRadioButton(Context context, AttributeSet attributeSet) {
        return new com.google.android.material.h.a(context, attributeSet);
    }
}

