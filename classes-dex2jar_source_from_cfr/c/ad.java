/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.v;
import d.e;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class ad
implements Closeable {
    public static ad a(@Nullable v v2, final long l2, final e e2) {
        if (e2 != null) {
            return new ad(){

                @Nullable
                @Override
                public v a() {
                    return v.this;
                }

                @Override
                public long b() {
                    return l2;
                }

                @Override
                public e d() {
                    return e2;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public static ad a(@Nullable v v2, byte[] arrby) {
        d.c c2 = new d.c().b(arrby);
        return ad.a(v2, arrby.length, c2);
    }

    private Charset f() {
        v v2 = this.a();
        if (v2 != null) {
            return v2.a(c.e);
        }
        return c.e;
    }

    @Nullable
    public abstract v a();

    public abstract long b();

    public final InputStream c() {
        return this.d().g();
    }

    @Override
    public void close() {
        c.a(this.d());
    }

    public abstract e d();

    public final String e() {
        e e2 = this.d();
        try {
            String string2 = e2.a(c.a(e2, this.f()));
            return string2;
        }
        finally {
            c.a(e2);
        }
    }

}

