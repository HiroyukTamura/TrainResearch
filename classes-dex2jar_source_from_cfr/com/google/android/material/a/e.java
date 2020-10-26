/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 */
package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

public class e
extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> a = new e();
    private final WeakHashMap<Drawable, Integer> b = new WeakHashMap();

    private e() {
        super(Integer.class, "drawableAlphaCompat");
    }

    public Integer a(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable2.getAlpha();
        }
        if (this.b.containsKey((Object)drawable2)) {
            return this.b.get((Object)drawable2);
        }
        return 255;
    }

    public void a(Drawable drawable2, Integer n2) {
        if (Build.VERSION.SDK_INT < 19) {
            this.b.put(drawable2, n2);
        }
        drawable2.setAlpha(n2.intValue());
    }

    public /* synthetic */ Object get(Object object) {
        return this.a((Drawable)object);
    }

    public /* synthetic */ void set(Object object, Object object2) {
        this.a((Drawable)object, (Integer)object2);
    }
}

