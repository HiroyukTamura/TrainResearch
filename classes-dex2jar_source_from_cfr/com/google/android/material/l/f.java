/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.RectF
 */
package com.google.android.material.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class f {
    public float a;
    public float b;
    public float c;
    public float d;
    private final List<e> e;
    private final List<f> f;

    f a() {
        return new f(new ArrayList<f>(this.f)){
            final /* synthetic */ List a;
            {
                this.a = list;
            }

            @Override
            public void a(Matrix matrix, com.google.android.material.k.b b2, int n2, Canvas canvas) {
                Iterator iterator = this.a.iterator();
                while (iterator.hasNext()) {
                    ((f)iterator.next()).a(matrix, b2, n2, canvas);
                }
            }
        };
    }

    public void a(float f2, float f3) {
        this.a = f2;
        this.b = f3;
        this.c = f2;
        this.d = f3;
        this.e.clear();
        this.f.clear();
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c c2 = new c(f2, f3, f4, f5);
        c2.e = f6;
        c2.f = f7;
        this.e.add(c2);
        this.f.add(new a(c2));
        float f8 = (f4 - f2) / 2.0f;
        double d2 = f6 + f7;
        this.c = (f2 + f4) * 0.5f + f8 * (float)Math.cos(Math.toRadians(d2));
        this.d = (f3 + f5) * 0.5f + (f5 - f3) / 2.0f * (float)Math.sin(Math.toRadians(d2));
    }

    public void a(Matrix matrix, Path path) {
        int n2 = this.e.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.e.get(i2).a(matrix, path);
        }
    }

    public void b(float f2, float f3) {
        d d2 = new d();
        d2.a = f2;
        d2.b = f3;
        this.e.add(d2);
        this.f.add(new b(d2, this.c, this.d));
        this.c = f2;
        this.d = f3;
    }

    static class a
    extends f {
        private final c a;

        public a(c c2) {
            this.a = c2;
        }

        @Override
        public void a(Matrix matrix, com.google.android.material.k.b b2, int n2, Canvas canvas) {
            float f2 = this.a.e;
            float f3 = this.a.f;
            b2.a(canvas, matrix, new RectF(this.a.a, this.a.b, this.a.c, this.a.d), n2, f2, f3);
        }
    }

    static class b
    extends f {
        private final d a;
        private final float b;
        private final float c;

        public b(d d2, float f2, float f3) {
            this.a = d2;
            this.b = f2;
            this.c = f3;
        }

        @Override
        public void a(Matrix matrix, com.google.android.material.k.b b2, int n2, Canvas canvas) {
            RectF rectF = new RectF();
            rectF.top = this.c;
            rectF.bottom = this.c;
            rectF.left = this.b;
            rectF.right = this.a.a;
            b2.a(canvas, matrix, rectF, n2);
        }
    }

    public static class c
    extends e {
        private static final RectF h = new RectF();
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;

        public c(float f2, float f3, float f4, float f5) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
        }

        @Override
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(this.a, this.b, this.c, this.d);
            path.arcTo(h, this.e, this.f, false);
            path.transform(matrix);
        }
    }

    public static class d
    extends e {
        private float a;
        private float b;

        @Override
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.a, this.b);
            path.transform(matrix);
        }
    }

    public static abstract class e {
        protected final Matrix g = new Matrix();

        public abstract void a(Matrix var1, Path var2);
    }

    static abstract class f {
        f() {
        }

        public abstract void a(Matrix var1, com.google.android.material.k.b var2, int var3, Canvas var4);
    }

}

