/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b;

import androidx.constraintlayout.b.b;
import java.util.Arrays;

public class h {
    private static int j = 1;
    private static int k = 1;
    private static int l = 1;
    private static int m = 1;
    private static int n = 1;
    public int a = -1;
    int b = -1;
    public int c = 0;
    public float d;
    float[] e = new float[7];
    a f;
    b[] g = new b[8];
    int h = 0;
    public int i = 0;
    private String o;

    public h(a a2, String string2) {
        this.f = a2;
    }

    static void a() {
        ++k;
    }

    public final void a(b b2) {
        for (int i2 = 0; i2 < this.h; ++i2) {
            if (this.g[i2] != b2) continue;
            return;
        }
        if (this.h >= this.g.length) {
            this.g = Arrays.copyOf(this.g, this.g.length * 2);
        }
        this.g[this.h] = b2;
        ++this.h;
    }

    public void a(a a2, String string2) {
        this.f = a2;
    }

    public void b() {
        this.o = null;
        this.f = a.e;
        this.c = 0;
        this.a = -1;
        this.b = -1;
        this.d = 0.0f;
        this.h = 0;
        this.i = 0;
    }

    public final void b(b arrb) {
        int n2 = this.h;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.g[i2] != arrb) continue;
            while (n3 < n2 - i2 - 1) {
                arrb = this.g;
                int n4 = i2 + n3;
                arrb[n4] = this.g[n4 + 1];
                ++n3;
            }
            --this.h;
            return;
        }
    }

    public final void c(b b2) {
        int n2 = this.h;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.g[i2].d.a(this.g[i2], b2, false);
        }
        this.h = 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.o);
        return stringBuilder.toString();
    }

    public static enum a {
        a,
        b,
        c,
        d,
        e;
        
    }

}

