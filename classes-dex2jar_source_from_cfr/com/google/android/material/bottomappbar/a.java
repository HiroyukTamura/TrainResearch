/*
 * Decompiled with CFR 0.139.
 */
package com.google.android.material.bottomappbar;

import com.google.android.material.l.b;
import com.google.android.material.l.f;

public class a
extends b {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;

    float a() {
        return this.d;
    }

    void a(float f2) {
        this.e = f2;
    }

    @Override
    public void a(float f2, float f3, float f4, f f5) {
        if (this.c == 0.0f) {
            f5.b(f2, 0.0f);
            return;
        }
        float f6 = (this.b * 2.0f + this.c) / 2.0f;
        float f7 = f4 * this.a;
        f3 += this.e;
        if ((f4 = this.d * f4 + (1.0f - f4) * f6) / f6 >= 1.0f) {
            f5.b(f2, 0.0f);
            return;
        }
        float f8 = f6 + f7;
        float f9 = f4 + f7;
        float f10 = (float)Math.sqrt(f8 * f8 - f9 * f9);
        f8 = f3 - f10;
        float f11 = f3 + f10;
        f9 = (float)Math.toDegrees(Math.atan(f10 / f9));
        f10 = 90.0f - f9;
        f5.b(f8, 0.0f);
        float f12 = f7 * 2.0f;
        f5.a(f8 - f7, 0.0f, f8 + f7, f12, 270.0f, f9);
        f5.a(f3 - f6, -f6 - f4, f3 + f6, f6 - f4, 180.0f - f10, f10 * 2.0f - 180.0f);
        f5.a(f11 - f7, 0.0f, f11 + f7, f12, 270.0f - f9, f9);
        f5.b(f2, 0.0f);
    }

    float b() {
        return this.c;
    }

    void b(float f2) {
        this.d = f2;
    }

    float c() {
        return this.b;
    }

    void c(float f2) {
        this.c = f2;
    }

    float d() {
        return this.a;
    }

    void d(float f2) {
        this.b = f2;
    }

    void e(float f2) {
        this.a = f2;
    }
}

