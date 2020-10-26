/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Property
 *  android.widget.ImageView
 */
package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class f
extends Property<ImageView, Matrix> {
    private final Matrix a = new Matrix();

    public f() {
        super(Matrix.class, "imageMatrixProperty");
    }

    public Matrix a(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    public void a(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    public /* synthetic */ Object get(Object object) {
        return this.a((ImageView)object);
    }

    public /* synthetic */ void set(Object object, Object object2) {
        this.a((ImageView)object, (Matrix)object2);
    }
}

