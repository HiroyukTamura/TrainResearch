/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.g.a.a;

import android.view.animation.Interpolator;

abstract class d
implements Interpolator {
    private final float[] a;
    private final float b;

    protected d(float[] arrf) {
        this.a = arrf;
        this.b = 1.0f / (float)(this.a.length - 1);
    }

    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        int n2 = Math.min((int)((float)(this.a.length - 1) * f2), this.a.length - 2);
        f2 = (f2 - (float)n2 * this.b) / this.b;
        return this.a[n2] + f2 * (this.a[n2 + 1] - this.a[n2]);
    }
}

