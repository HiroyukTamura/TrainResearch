/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.a.c;
import c.a.c.e;
import c.a.c.h;
import c.a.d;
import c.aa;
import c.ab;
import c.ac;
import c.ad;
import c.l;
import c.m;
import c.s;
import c.t;
import c.u;
import c.v;
import d.j;
import java.util.List;

public final class a
implements u {
    private final m a;

    public a(m m2) {
        this.a = m2;
    }

    private String a(List<l> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append("; ");
            }
            l l2 = list.get(i2);
            stringBuilder.append(l2.a());
            stringBuilder.append('=');
            stringBuilder.append(l2.b());
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public ac a(u.a object) {
        Object object2 = object.a();
        aa.a a2 = ((aa)object2).e();
        Object object3 = ((aa)object2).d();
        if (object3 != null) {
            long l2;
            v v2 = ((ab)object3).a();
            if (v2 != null) {
                a2.a("Content-Type", v2.toString());
            }
            if ((l2 = ((ab)object3).b()) != -1L) {
                a2.a("Content-Length", Long.toString(l2));
                object3 = "Transfer-Encoding";
            } else {
                a2.a("Transfer-Encoding", "chunked");
                object3 = "Content-Length";
            }
            a2.a((String)object3);
        }
        object3 = ((aa)object2).a("Host");
        boolean bl2 = false;
        if (object3 == null) {
            a2.a("Host", c.a(((aa)object2).a(), false));
        }
        if (((aa)object2).a("Connection") == null) {
            a2.a("Connection", "Keep-Alive");
        }
        boolean bl3 = bl2;
        if (((aa)object2).a("Accept-Encoding") == null) {
            bl3 = bl2;
            if (((aa)object2).a("Range") == null) {
                bl3 = true;
                a2.a("Accept-Encoding", "gzip");
            }
        }
        if (!(object3 = this.a.a(((aa)object2).a())).isEmpty()) {
            a2.a("Cookie", this.a((List<l>)object3));
        }
        if (((aa)object2).a("User-Agent") == null) {
            a2.a("User-Agent", d.a());
        }
        object = object.a(a2.a());
        e.a(this.a, ((aa)object2).a(), ((ac)object).f());
        object3 = ((ac)object).h().a((aa)object2);
        if (bl3 && "gzip".equalsIgnoreCase(((ac)object).a("Content-Encoding")) && e.b((ac)object)) {
            object2 = new j(((ac)object).g().d());
            ((ac.a)object3).a(((ac)object).f().b().b("Content-Encoding").b("Content-Length").a());
            ((ac.a)object3).a(new h(((ac)object).a("Content-Type"), -1L, d.l.a((d.t)object2)));
        }
        return ((ac.a)object3).a();
    }
}

