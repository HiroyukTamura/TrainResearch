/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.v;
import d.d;
import d.f;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class ab {
    public static ab a(@Nullable v v2, final f f2) {
        return new ab(){

            @Nullable
            @Override
            public v a() {
                return v.this;
            }

            @Override
            public void a(d d2) {
                d2.d(f2);
            }

            @Override
            public long b() {
                return f2.g();
            }
        };
    }

    public static ab a(@Nullable v v2, String string2) {
        Charset charset = c.e;
        Object object = v2;
        if (v2 != null) {
            Charset charset2;
            charset = charset2 = v2.b();
            object = v2;
            if (charset2 == null) {
                charset = c.e;
                object = new StringBuilder();
                ((StringBuilder)object).append(v2);
                ((StringBuilder)object).append("; charset=utf-8");
                object = v.a(((StringBuilder)object).toString());
            }
        }
        return ab.a((v)object, string2.getBytes(charset));
    }

    public static ab a(@Nullable v v2, byte[] arrby) {
        return ab.a(v2, arrby, 0, arrby.length);
    }

    public static ab a(@Nullable v v2, final byte[] arrby, final int n2, final int n3) {
        if (arrby != null) {
            c.a(arrby.length, (long)n2, (long)n3);
            return new ab(){

                @Nullable
                @Override
                public v a() {
                    return v.this;
                }

                @Override
                public void a(d d2) {
                    d2.c(arrby, n2, n3);
                }

                @Override
                public long b() {
                    return n3;
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    @Nullable
    public abstract v a();

    public abstract void a(d var1);

    public long b() {
        return -1L;
    }

}

