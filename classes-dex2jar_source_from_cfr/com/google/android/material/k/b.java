/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 */
package com.google.android.material.k;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.a;

public class b {
    private static final int[] g = new int[3];
    private static final float[] h = new float[]{0.0f, 0.5f, 1.0f};
    private static final int[] i = new int[4];
    private static final float[] j = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private int d;
    private int e;
    private int f;
    private final Path k;

    public Paint a() {
        return this.a;
    }

    public void a(int n2) {
        this.d = a.b(n2, 68);
        this.e = a.b(n2, 20);
        this.f = a.b(n2, 0);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int n2) {
        rectF.bottom += (float)n2;
        rectF.offset(0.0f, (float)(-n2));
        b.g[0] = this.f;
        b.g[1] = this.e;
        b.g[2] = this.d;
        this.c.setShader((Shader)new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, g, h, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.c);
        canvas.restore();
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int n2, float f2, float f3) {
        float f4;
        boolean bl2 = f3 < 0.0f;
        Path path = this.k;
        if (bl2) {
            b.i[0] = 0;
            b.i[1] = this.f;
            b.i[2] = this.e;
            b.i[3] = this.d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            f4 = -n2;
            rectF.inset(f4, f4);
            b.i[0] = 0;
            b.i[1] = this.d;
            b.i[2] = this.e;
            b.i[3] = this.f;
        }
        f4 = 1.0f - (float)n2 / (rectF.width() / 2.0f);
        float f5 = (1.0f - f4) / 2.0f;
        b.j[1] = f4;
        b.j[2] = f5 + f4;
        this.b.setShader((Shader)new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, i, j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!bl2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        canvas.drawArc(rectF, f2, f3, true, this.b);
        canvas.restore();
    }
}

