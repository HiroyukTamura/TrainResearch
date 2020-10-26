/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.h;
import com.b.a.i;
import com.b.a.l;
import com.b.a.m;
import com.b.a.n;
import d.c;
import d.e;
import d.f;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public abstract class k
implements Closeable {
    int a;
    int[] b = new int[32];
    String[] c = new String[32];
    int[] d = new int[32];
    boolean e;
    boolean f;

    k() {
    }

    @CheckReturnValue
    public static k a(e e2) {
        return new m(e2);
    }

    @CheckReturnValue
    public abstract int a(a var1);

    final i a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" at path ");
        stringBuilder.append(this.q());
        throw new i(stringBuilder.toString());
    }

    final void a(int n2) {
        if (this.a == this.b.length) {
            if (this.a != 256) {
                this.b = Arrays.copyOf(this.b, this.b.length * 2);
                this.c = Arrays.copyOf(this.c, this.c.length * 2);
                this.d = Arrays.copyOf(this.d, this.d.length * 2);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Nesting too deep at ");
                stringBuilder.append(this.q());
                throw new h(stringBuilder.toString());
            }
        }
        int[] arrn = this.b;
        int n3 = this.a;
        this.a = n3 + 1;
        arrn[n3] = n2;
    }

    public final void a(boolean bl2) {
        this.e = bl2;
    }

    @CheckReturnValue
    public final boolean a() {
        return this.e;
    }

    @CheckReturnValue
    public abstract int b(a var1);

    public final void b(boolean bl2) {
        this.f = bl2;
    }

    @CheckReturnValue
    public final boolean b() {
        return this.f;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    @CheckReturnValue
    public abstract boolean g();

    @CheckReturnValue
    public abstract b h();

    public abstract void i();

    public abstract String j();

    public abstract boolean k();

    @Nullable
    public abstract <T> T l();

    public abstract double m();

    public abstract long n();

    public abstract int o();

    public abstract void p();

    @CheckReturnValue
    public final String q() {
        return l.a(this.a, this.b, this.c, this.d);
    }

    abstract void r();

    public static final class a {
        final String[] a;
        final d.m b;

        private a(String[] arrstring, d.m m2) {
            this.a = arrstring;
            this.b = m2;
        }

        @CheckReturnValue
        public static /* varargs */ a a(String ... object) {
            f[] arrf = new f[((String[])object).length];
            c c2 = new c();
            int n2 = 0;
            do {
                if (n2 >= ((String[])object).length) break;
                n.a(c2, object[n2]);
                c2.i();
                arrf[n2] = c2.o();
                ++n2;
                continue;
                break;
            } while (true);
            try {
                object = new a((String[])object.clone(), d.m.a(arrf));
                return object;
            }
            catch (IOException iOException) {
                throw new AssertionError(iOException);
            }
        }
    }

    public static enum b {
        a,
        b,
        c,
        d,
        e,
        f,
        g,
        h,
        i,
        j;
        
    }

}

