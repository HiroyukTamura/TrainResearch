/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.PropertyValuesHolder
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 */
package androidx.j;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import androidx.j.h;

class i {
    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, null, (Path)path);
        }
        return PropertyValuesHolder.ofFloat(new h(property, path), (float[])new float[]{0.0f, 1.0f});
    }
}

