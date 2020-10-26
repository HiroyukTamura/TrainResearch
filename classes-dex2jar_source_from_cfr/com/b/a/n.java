/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.p;
import d.d;
import java.io.IOException;
import javax.annotation.Nullable;

final class n
extends p {
    private static final String[] a = new String[128];
    private final d k;
    private String l = ":";
    private String m;

    static {
        for (int i2 = 0; i2 <= 31; ++i2) {
            n.a[i2] = String.format("\\u%04x", i2);
        }
        n.a[34] = "\\\"";
        n.a[92] = "\\\\";
        n.a[9] = "\\t";
        n.a[8] = "\\b";
        n.a[10] = "\\n";
        n.a[13] = "\\r";
        n.a[12] = "\\f";
    }

    n(d d2) {
        if (d2 != null) {
            this.k = d2;
            this.a(6);
            return;
        }
        throw new NullPointerException("sink == null");
    }

    private p a(int n2, int n3, String string2) {
        if (this.b == this.j && (this.c[this.b - 1] == n2 || this.c[this.b - 1] == n3)) {
            this.j = this.j;
            return this;
        }
        this.o();
        this.g();
        this.a(n2);
        this.e[this.b - 1] = 0;
        this.k.b(string2);
        return this;
    }

    static void a(d d2, String string2) {
        String[] arrstring = a;
        d2.i(34);
        int n2 = string2.length();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4;
            block8 : {
                String string3;
                block7 : {
                    char c2;
                    block9 : {
                        block6 : {
                            String string4;
                            c2 = string2.charAt(i2);
                            if (c2 >= '') break block6;
                            string3 = string4 = arrstring[c2];
                            if (string4 != null) break block7;
                            n4 = n3;
                            break block8;
                        }
                        if (c2 != '\u2028') break block9;
                        string3 = "\\u2028";
                        break block7;
                    }
                    n4 = n3;
                    if (c2 != '\u2029') break block8;
                    string3 = "\\u2029";
                }
                if (n3 < i2) {
                    d2.b(string2, n3, i2);
                }
                d2.b(string3);
                n4 = i2 + 1;
            }
            n3 = n4;
        }
        if (n3 < n2) {
            d2.b(string2, n3, n2);
        }
        d2.i(34);
    }

    private p b(int n2, int n3, String charSequence) {
        int n4 = this.f();
        if (n4 != n3 && n4 != n2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.m == null) {
            if (this.b == this.j) {
                this.j = this.j;
                return this;
            }
            --this.b;
            this.d[this.b] = null;
            int[] arrn = this.e;
            n2 = this.b - 1;
            arrn[n2] = arrn[n2] + 1;
            if (n4 == n3) {
                this.m();
            }
            this.k.b((String)charSequence);
            return this;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Dangling name: ");
        ((StringBuilder)charSequence).append(this.m);
        throw new IllegalStateException(((StringBuilder)charSequence).toString());
    }

    private void l() {
        if (this.m != null) {
            this.n();
            n.a(this.k, this.m);
            this.m = null;
        }
    }

    private void m() {
        if (this.f == null) {
            return;
        }
        this.k.i(10);
        int n2 = this.b;
        for (int i2 = 1; i2 < n2; ++i2) {
            this.k.b(this.f);
        }
    }

    private void n() {
        block4 : {
            block3 : {
                int n2;
                block2 : {
                    n2 = this.f();
                    if (n2 != 5) break block2;
                    this.k.i(44);
                    break block3;
                }
                if (n2 != 3) break block4;
            }
            this.m();
            this.b(4);
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void o() {
        block7 : {
            switch (this.f()) {
                default: {
                    throw new IllegalStateException("Nesting problem.");
                }
                case 7: {
                    if (this.g == false) throw new IllegalStateException("JSON must have only one top-level value.");
                }
                case 6: {
                    var1_1 = 7;
                    ** GOTO lbl12
                }
                case 4: {
                    this.k.b(this.l);
                    var1_1 = 5;
lbl12: // 2 sources:
                    this.b(var1_1);
                    return;
                }
                case 2: {
                    this.k.i(44);
                    break block7;
                }
                case 1: 
            }
            this.b(2);
        }
        this.m();
    }

    @Override
    public p a() {
        if (!this.i) {
            this.l();
            return this.a(1, 2, "[");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array cannot be used as a map key in JSON at path ");
        stringBuilder.append(this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public p a(double d2) {
        if (!this.g && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(d2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.i) {
            return this.a(Double.toString(d2));
        }
        this.l();
        this.o();
        this.k.b(Double.toString(d2));
        int[] arrn = this.e;
        int n2 = this.b - 1;
        arrn[n2] = arrn[n2] + 1;
        return this;
    }

    @Override
    public p a(long l2) {
        if (this.i) {
            return this.a(Long.toString(l2));
        }
        this.l();
        this.o();
        this.k.b(Long.toString(l2));
        int[] arrn = this.e;
        int n2 = this.b - 1;
        arrn[n2] = arrn[n2] + 1;
        return this;
    }

    @Override
    public p a(@Nullable Number arrn) {
        if (arrn == null) {
            return this.e();
        }
        CharSequence charSequence = arrn.toString();
        if (!this.g && (((String)charSequence).equals("-Infinity") || ((String)charSequence).equals("Infinity") || ((String)charSequence).equals("NaN"))) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Numeric values must be finite, but was ");
            ((StringBuilder)charSequence).append(arrn);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        if (this.i) {
            return this.a((String)charSequence);
        }
        this.l();
        this.o();
        this.k.b((String)charSequence);
        arrn = this.e;
        int n2 = this.b - 1;
        arrn[n2] = arrn[n2] + 1;
        return this;
    }

    @Override
    public p a(String string2) {
        if (string2 != null) {
            if (this.b != 0) {
                int n2 = this.f();
                if ((n2 == 3 || n2 == 5) && this.m == null) {
                    this.m = string2;
                    this.d[this.b - 1] = string2;
                    this.i = false;
                    return this;
                }
                throw new IllegalStateException("Nesting problem.");
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new NullPointerException("name == null");
    }

    @Override
    public p a(boolean bl2) {
        if (!this.i) {
            this.l();
            this.o();
            d d2 = this.k;
            Object object = bl2 ? "true" : "false";
            d2.b((String)object);
            object = this.e;
            int n2 = this.b - 1;
            object[n2] = object[n2] + 1;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Boolean cannot be used as a map key in JSON at path ");
        stringBuilder.append(this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public p b() {
        return this.b(1, 2, "]");
    }

    @Override
    public p b(String arrn) {
        if (arrn == null) {
            return this.e();
        }
        if (this.i) {
            return this.a((String)arrn);
        }
        this.l();
        this.o();
        n.a(this.k, (String)arrn);
        arrn = this.e;
        int n2 = this.b - 1;
        arrn[n2] = arrn[n2] + 1;
        return this;
    }

    @Override
    public p c() {
        if (!this.i) {
            this.l();
            return this.a(3, 5, "{");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Object cannot be used as a map key in JSON at path ");
        stringBuilder.append(this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void close() {
        this.k.close();
        int n2 = this.b;
        if (n2 <= 1 && (n2 != 1 || this.c[n2 - 1] == 7)) {
            this.b = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override
    public p d() {
        this.i = false;
        return this.b(3, 5, "}");
    }

    @Override
    public p e() {
        if (!this.i) {
            if (this.m != null) {
                if (this.h) {
                    this.l();
                } else {
                    this.m = null;
                    return this;
                }
            }
            this.o();
            this.k.b("null");
            int[] arrn = this.e;
            int n2 = this.b - 1;
            arrn[n2] = arrn[n2] + 1;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null cannot be used as a map key in JSON at path ");
        stringBuilder.append(this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void flush() {
        if (this.b != 0) {
            this.k.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
}

