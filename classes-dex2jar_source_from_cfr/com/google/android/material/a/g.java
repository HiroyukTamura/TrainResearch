/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Matrix
 */
package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g
implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];
    private final float[] b = new float[9];
    private final Matrix c = new Matrix();

    public Matrix a(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        for (int i2 = 0; i2 < 9; ++i2) {
            float f3 = this.b[i2];
            float f4 = this.a[i2];
            this.b[i2] = this.a[i2] + (f3 - f4) * f2;
        }
        this.c.setValues(this.b);
        return this.c;
    }

    public /* synthetic */ Object evaluate(float f2, Object object, Object object2) {
        return this.a(f2, (Matrix)object, (Matrix)object2);
    }
}

