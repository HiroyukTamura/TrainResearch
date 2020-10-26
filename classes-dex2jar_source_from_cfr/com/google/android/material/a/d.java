/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.a;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.a;

public class d
extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> a = new d("childrenAlpha");

    private d(String string2) {
        super(Float.class, string2);
    }

    public Float a(ViewGroup object) {
        if ((object = (Float)object.getTag(a.e.mtrl_internal_children_alpha_tag)) != null) {
            return object;
        }
        return Float.valueOf(1.0f);
    }

    public void a(ViewGroup viewGroup, Float f2) {
        float f3 = f2.floatValue();
        viewGroup.setTag(a.e.mtrl_internal_children_alpha_tag, (Object)Float.valueOf(f3));
        int n2 = viewGroup.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            viewGroup.getChildAt(i2).setAlpha(f3);
        }
    }

    public /* synthetic */ Object get(Object object) {
        return this.a((ViewGroup)object);
    }

    public /* synthetic */ void set(Object object, Object object2) {
        this.a((ViewGroup)object, (Float)object2);
    }
}

