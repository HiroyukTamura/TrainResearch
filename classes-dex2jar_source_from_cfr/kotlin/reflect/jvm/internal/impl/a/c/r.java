/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.f;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.h.e.l;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.k;
import kotlin.reflect.jvm.internal.impl.j.x;

public class r
implements e {
    private final e a;
    private final au b;
    private au c;
    private List<as> d;
    private List<as> e;
    private kotlin.reflect.jvm.internal.impl.j.an f;

    public r(e e2, au au2) {
        this.a = e2;
        this.b = au2;
    }

    private au a() {
        if (this.c == null) {
            if (this.b.a()) {
                this.c = this.b;
            } else {
                List<as> list = this.a.e().b();
                this.d = new ArrayList<as>(list.size());
                this.c = k.a(list, this.b.b(), this, this.d);
                this.e = kotlin.a.m.b(this.d, new kotlin.e.a.b<as, Boolean>(){

                    @Override
                    public Boolean a(as as2) {
                        return as2.a() ^ true;
                    }
                });
            }
        }
        return this.c;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h C() {
        return this.a.C();
    }

    @Override
    public al D() {
        throw new UnsupportedOperationException();
    }

    @Override
    public e E() {
        return this.a.E();
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    public e a(au au2) {
        if (au2.a()) {
            return this;
        }
        return new r(this, au.a(au2.b(), this.a().b()));
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h a(kotlin.reflect.jvm.internal.impl.j.as object) {
        object = this.a.a((kotlin.reflect.jvm.internal.impl.j.as)object);
        if (this.b.a()) {
            return object;
        }
        return new l((kotlin.reflect.jvm.internal.impl.h.e.h)object, this.a());
    }

    @Override
    public m b() {
        return this.a.b();
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        Object object = this.a.e();
        if (this.b.a()) {
            return object;
        }
        if (this.f == null) {
            au au2 = this.a();
            Object object2 = object.k_();
            object = new ArrayList(object2.size());
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object.add(au2.b((kotlin.reflect.jvm.internal.impl.j.w)object2.next(), kotlin.reflect.jvm.internal.impl.j.ba.a));
            }
            this.f = new kotlin.reflect.jvm.internal.impl.j.e(this, this.d, (Collection<kotlin.reflect.jvm.internal.impl.j.w>)object, kotlin.reflect.jvm.internal.impl.i.b.a);
        }
        return this.f;
    }

    @Override
    public /* synthetic */ h f() {
        return this.E();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h f_() {
        return this.a.f_();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h g() {
        kotlin.reflect.jvm.internal.impl.h.e.h h2 = this.a.g();
        if (this.b.a()) {
            return h2;
        }
        return new l(h2, this.a());
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.f h_() {
        return this.a.h_();
    }

    @Override
    public e i() {
        return this.a.i();
    }

    @Override
    public ad i_() {
        List<ap> list = av.a(this.e().b());
        return x.a(this.x(), this, list);
    }

    @Override
    public Collection<d> k() {
        Object object = this.a.k();
        ArrayList<d> arrayList = new ArrayList<d>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            d d2 = (d)object.next();
            arrayList.add(d2.b(this, d2.m(), d2.p(), d2.n(), false).a(this.a()));
        }
        return arrayList;
    }

    @Override
    public f l() {
        return this.a.l();
    }

    @Override
    public w m() {
        return this.a.m();
    }

    @Override
    public /* synthetic */ m m_() {
        return this.E();
    }

    @Override
    public d o() {
        return this.a.o();
    }

    @Override
    public ba p() {
        return this.a.p();
    }

    @Override
    public boolean q() {
        return this.a.q();
    }

    @Override
    public boolean r() {
        return this.a.r();
    }

    @Override
    public boolean s() {
        return this.a.s();
    }

    @Override
    public boolean t() {
        return this.a.t();
    }

    @Override
    public boolean u() {
        return this.a.u();
    }

    @Override
    public boolean v() {
        return this.a.v();
    }

    @Override
    public boolean w() {
        return this.a.w();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.a.h x() {
        return this.a.x();
    }

    @Override
    public an y() {
        return an.a;
    }

    @Override
    public List<as> z() {
        this.a();
        return this.e;
    }

}

