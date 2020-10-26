/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.p;
import com.b.a.q;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class o
extends p {
    Object[] a = new Object[32];
    @Nullable
    private String k;

    o() {
        this.a(6);
    }

    private o a(@Nullable Object object) {
        int n2 = this.f();
        if (this.b == 1) {
            if (n2 == 6) {
                this.c[this.b - 1] = 7;
                this.a[this.b - 1] = object;
                return this;
            }
            throw new IllegalStateException("JSON must have only one top-level value.");
        }
        if (n2 == 3 && this.k != null) {
            Object object2;
            if (object == null && !this.h || (object2 = ((Map)this.a[this.b - 1]).put(this.k, object)) == null) {
                this.k = null;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Map key '");
            stringBuilder.append(this.k);
            stringBuilder.append("' has multiple values at path ");
            stringBuilder.append(this.k());
            stringBuilder.append(": ");
            stringBuilder.append(object2);
            stringBuilder.append(" and ");
            stringBuilder.append(object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 == 1) {
            ((List)this.a[this.b - 1]).add(object);
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override
    public p a() {
        if (!this.i) {
            if (this.b == this.j && this.c[this.b - 1] == 1) {
                this.j = this.j;
                return this;
            }
            this.g();
            ArrayList arrayList = new ArrayList();
            this.a(arrayList);
            this.a[this.b] = arrayList;
            this.e[this.b] = 0;
            this.a(1);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array cannot be used as a map key in JSON at path ");
        stringBuilder.append(this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public p a(double d2) {
        if (!this.g && (Double.isNaN(d2) || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(d2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.i) {
            return this.a(Double.toString(d2));
        }
        this.a((Object)d2);
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
        this.a((Object)l2);
        int[] arrn = this.e;
        int n2 = this.b - 1;
        arrn[n2] = arrn[n2] + 1;
        return this;
    }

    @Override
    public p a(@Nullable Number object) {
        if (!(object instanceof Byte || object instanceof Short || object instanceof Integer || object instanceof Long)) {
            if (!(object instanceof Float) && !(object instanceof Double)) {
                if (object == null) {
                    return this.e();
                }
                object = object instanceof BigDecimal ? (BigDecimal)object : new BigDecimal(object.toString());
                if (this.i) {
                    return this.a(object.toString());
                }
                this.a(object);
                object = this.e;
                int n2 = this.b - 1;
                object[n2] = object[n2] + 1;
                return this;
            }
            return this.a(object.doubleValue());
        }
        return this.a(object.longValue());
    }

    @Override
    public p a(String string2) {
        if (string2 != null) {
            if (this.b != 0) {
                if (this.f() == 3 && this.k == null) {
                    this.k = string2;
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
            this.a((Object)bl2);
            int[] arrn = this.e;
            int n2 = this.b - 1;
            arrn[n2] = arrn[n2] + 1;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Boolean cannot be used as a map key in JSON at path ");
        stringBuilder.append(this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public p b() {
        if (this.f() == 1) {
            if (this.b == this.j) {
                this.j = this.j;
                return this;
            }
            --this.b;
            this.a[this.b] = null;
            int[] arrn = this.e;
            int n2 = this.b - 1;
            arrn[n2] = arrn[n2] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override
    public p b(@Nullable String arrn) {
        if (this.i) {
            return this.a((String)arrn);
        }
        this.a(arrn);
        arrn = this.e;
        int n2 = this.b - 1;
        arrn[n2] = arrn[n2] + 1;
        return this;
    }

    @Override
    public p c() {
        if (!this.i) {
            if (this.b == this.j && this.c[this.b - 1] == 3) {
                this.j = this.j;
                return this;
            }
            this.g();
            q q2 = new q();
            this.a(q2);
            this.a[this.b] = q2;
            this.a(3);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Object cannot be used as a map key in JSON at path ");
        stringBuilder.append(this.k());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void close() {
        int n2 = this.b;
        if (n2 <= 1 && (n2 != 1 || this.c[n2 - 1] == 7)) {
            this.b = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override
    public p d() {
        if (this.f() == 3) {
            if (this.k == null) {
                if (this.b == this.j) {
                    this.j = this.j;
                    return this;
                }
                this.i = false;
                --this.b;
                this.a[this.b] = null;
                this.d[this.b] = null;
                int[] arrn = this.e;
                int n2 = this.b - 1;
                arrn[n2] = arrn[n2] + 1;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Dangling name: ");
            stringBuilder.append(this.k);
            throw new IllegalStateException(stringBuilder.toString());
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override
    public p e() {
        if (!this.i) {
            this.a((Object)null);
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
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
}

