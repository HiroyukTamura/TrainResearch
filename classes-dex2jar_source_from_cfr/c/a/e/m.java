/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import java.util.Arrays;

public final class m {
    private int a;
    private final int[] b = new int[10];

    m a(int n2, int n3) {
        if (n2 >= 0) {
            if (n2 >= this.b.length) {
                return this;
            }
            this.a = 1 << n2 | this.a;
            this.b[n2] = n3;
        }
        return this;
    }

    void a() {
        this.a = 0;
        Arrays.fill(this.b, 0);
    }

    void a(m m2) {
        for (int i2 = 0; i2 < 10; ++i2) {
            if (!m2.a(i2)) continue;
            this.a(i2, m2.b(i2));
        }
    }

    boolean a(int n2) {
        return (1 << n2 & this.a) != 0;
    }

    int b() {
        return Integer.bitCount(this.a);
    }

    int b(int n2) {
        return this.b[n2];
    }

    int c() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    int c(int n2) {
        if ((this.a & 16) != 0) {
            n2 = this.b[4];
        }
        return n2;
    }

    int d() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    int d(int n2) {
        if ((this.a & 32) != 0) {
            n2 = this.b[5];
        }
        return n2;
    }
}

