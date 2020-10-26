/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.h;
import com.b.a.l;
import com.b.a.n;
import com.b.a.o;
import d.d;
import java.io.Closeable;
import java.io.Flushable;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public abstract class p
implements Closeable,
Flushable {
    int b = 0;
    int[] c = new int[32];
    String[] d = new String[32];
    int[] e = new int[32];
    String f;
    boolean g;
    boolean h;
    boolean i;
    int j = -1;

    p() {
    }

    @CheckReturnValue
    public static p a(d d2) {
        return new n(d2);
    }

    public abstract p a();

    public abstract p a(double var1);

    public abstract p a(long var1);

    public abstract p a(@Nullable Number var1);

    public abstract p a(String var1);

    public abstract p a(boolean var1);

    final void a(int n2) {
        int[] arrn = this.c;
        int n3 = this.b;
        this.b = n3 + 1;
        arrn[n3] = n2;
    }

    public abstract p b();

    public abstract p b(@Nullable String var1);

    final void b(int n2) {
        this.c[this.b - 1] = n2;
    }

    public final void b(boolean bl2) {
        this.g = bl2;
    }

    public abstract p c();

    public final void c(boolean bl2) {
        this.h = bl2;
    }

    public abstract p d();

    public abstract p e();

    final int f() {
        if (this.b != 0) {
            return this.c[this.b - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    final boolean g() {
        if (this.b != this.c.length) {
            return false;
        }
        if (this.b != 256) {
            this.c = Arrays.copyOf(this.c, this.c.length * 2);
            this.d = Arrays.copyOf(this.d, this.d.length * 2);
            this.e = Arrays.copyOf(this.e, this.e.length * 2);
            if (this instanceof o) {
                o o2 = (o)this;
                o2.a = Arrays.copyOf(o2.a, o2.a.length * 2);
            }
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nesting too deep at ");
        stringBuilder.append(this.k());
        stringBuilder.append(": circular reference?");
        throw new h(stringBuilder.toString());
    }

    @CheckReturnValue
    public final boolean h() {
        return this.g;
    }

    @CheckReturnValue
    public final boolean i() {
        return this.h;
    }

    final void j() {
        int n2 = this.f();
        if (n2 != 5 && n2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.i = true;
    }

    @CheckReturnValue
    public final String k() {
        return l.a(this.b, this.c, this.d, this.e);
    }
}

