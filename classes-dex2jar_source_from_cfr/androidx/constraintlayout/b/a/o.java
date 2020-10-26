/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.p;

public class o
extends p {
    float a = 0.0f;

    public void a(int n2) {
        if (this.i == 0 || this.a != (float)n2) {
            this.a = n2;
            if (this.i == 1) {
                this.e();
            }
            this.f();
        }
    }

    @Override
    public void b() {
        super.b();
        this.a = 0.0f;
    }

    public void c() {
        this.i = 2;
    }
}

