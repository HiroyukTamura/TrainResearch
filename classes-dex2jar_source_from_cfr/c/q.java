/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.ab;
import c.t;
import c.v;
import d.d;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public final class q
extends ab {
    private static final v a = v.a("application/x-www-form-urlencoded");
    private final List<String> b;
    private final List<String> c;

    q(List<String> list, List<String> list2) {
        this.b = c.a(list);
        this.c = c.a(list2);
    }

    private long a(@Nullable d d2, boolean bl2) {
        d2 = bl2 ? new d.c() : d2.c();
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                ((d.c)d2).b(38);
            }
            ((d.c)d2).a(this.b.get(i2));
            ((d.c)d2).b(61);
            ((d.c)d2).a(this.c.get(i2));
        }
        if (bl2) {
            long l2 = ((d.c)d2).b();
            ((d.c)d2).s();
            return l2;
        }
        return 0L;
    }

    @Override
    public v a() {
        return a;
    }

    @Override
    public void a(d d2) {
        this.a(d2, false);
    }

    @Override
    public long b() {
        return this.a(null, true);
    }

    public static final class a {
        private final List<String> a = new ArrayList<String>();
        private final List<String> b = new ArrayList<String>();
        private final Charset c;

        public a() {
            this(null);
        }

        public a(Charset charset) {
            this.c = charset;
        }

        public a a(String string2, String string3) {
            if (string2 != null) {
                if (string3 != null) {
                    this.a.add(t.a(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
                    this.b.add(t.a(string3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }

        public q a() {
            return new q(this.a, this.b);
        }

        public a b(String string2, String string3) {
            if (string2 != null) {
                if (string3 != null) {
                    this.a.add(t.a(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
                    this.b.add(t.a(string3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }
    }

}

