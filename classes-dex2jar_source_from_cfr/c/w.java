/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.ab;
import c.s;
import c.v;
import d.d;
import d.f;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

public final class w
extends ab {
    public static final v a = v.a("multipart/mixed");
    public static final v b = v.a("multipart/alternative");
    public static final v c = v.a("multipart/digest");
    public static final v d = v.a("multipart/parallel");
    public static final v e = v.a("multipart/form-data");
    private static final byte[] f = new byte[]{58, 32};
    private static final byte[] g = new byte[]{13, 10};
    private static final byte[] h = new byte[]{45, 45};
    private final f i;
    private final v j;
    private final v k;
    private final List<b> l;
    private long m = -1L;

    w(f f2, v v2, List<b> list) {
        this.i = f2;
        this.j = v2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v2);
        stringBuilder.append("; boundary=");
        stringBuilder.append(f2.a());
        this.k = v.a(stringBuilder.toString());
        this.l = c.a(list);
    }

    private long a(@Nullable d d2, boolean bl2) {
        long l2;
        Object object;
        d d3;
        if (bl2) {
            d2 = d3 = new d.c();
        } else {
            object = null;
            d3 = d2;
            d2 = object;
        }
        int n2 = this.l.size();
        long l3 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = this.l.get(i2);
            object = ((b)object2).a;
            object2 = ((b)object2).b;
            d3.c(h);
            d3.d(this.i);
            d3.c(g);
            if (object != null) {
                int n3 = ((s)object).a();
                for (int i3 = 0; i3 < n3; ++i3) {
                    d3.b(((s)object).a(i3)).c(f).b(((s)object).b(i3)).c(g);
                }
            }
            if ((object = ((ab)object2).a()) != null) {
                d3.b("Content-Type: ").b(((v)object).toString()).c(g);
            }
            if ((l2 = ((ab)object2).b()) != -1L) {
                d3.b("Content-Length: ").m(l2).c(g);
            } else if (bl2) {
                ((d.c)d2).s();
                return -1L;
            }
            d3.c(g);
            if (bl2) {
                l3 += l2;
            } else {
                ((ab)object2).a(d3);
            }
            d3.c(g);
        }
        d3.c(h);
        d3.d(this.i);
        d3.c(h);
        d3.c(g);
        l2 = l3;
        if (bl2) {
            l2 = l3 + ((d.c)d2).b();
            ((d.c)d2).s();
        }
        return l2;
    }

    @Override
    public v a() {
        return this.k;
    }

    @Override
    public void a(d d2) {
        this.a(d2, false);
    }

    @Override
    public long b() {
        long l2 = this.m;
        if (l2 != -1L) {
            return l2;
        }
        this.m = l2 = this.a(null, true);
        return l2;
    }

    public static final class a {
        private final f a;
        private v b = w.a;
        private final List<b> c = new ArrayList<b>();

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String string2) {
            this.a = f.a(string2);
        }

        public a a(@Nullable s s2, ab ab2) {
            return this.a(b.a(s2, ab2));
        }

        public a a(v v2) {
            if (v2 != null) {
                if (v2.a().equals("multipart")) {
                    this.b = v2;
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("multipart != ");
                stringBuilder.append(v2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new NullPointerException("type == null");
        }

        public a a(b b2) {
            if (b2 != null) {
                this.c.add(b2);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public w a() {
            if (!this.c.isEmpty()) {
                return new w(this.a, this.b, this.c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public static final class b {
        @Nullable
        final s a;
        final ab b;

        private b(@Nullable s s2, ab ab2) {
            this.a = s2;
            this.b = ab2;
        }

        public static b a(@Nullable s s2, ab ab2) {
            if (ab2 != null) {
                if (s2 != null && s2.a("Content-Type") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if (s2 != null && s2.a("Content-Length") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                return new b(s2, ab2);
            }
            throw new NullPointerException("body == null");
        }
    }

}

