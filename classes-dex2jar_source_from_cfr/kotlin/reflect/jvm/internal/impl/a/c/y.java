/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.ax;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.aa;
import kotlin.reflect.jvm.internal.impl.a.c.aj;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.c.x;
import kotlin.reflect.jvm.internal.impl.a.c.z;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.g;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.k;
import kotlin.reflect.jvm.internal.impl.l.j;

public class y
extends aj
implements ai {
    private final w e;
    private ba f;
    private Collection<? extends ai> g = null;
    private final ai h;
    private final b.a i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private al p;
    private al q;
    private List<as> r;
    private z s;
    private ak t;
    private boolean u;

    protected y(m m2, ai ai2, h h2, w w2, ba ba2, boolean bl2, f f2, b.a a2, an an2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        super(m2, h2, f2, null, bl2, an2);
        this.e = w2;
        this.f = ba2;
        m2 = ai2 == null ? this : ai2;
        this.h = m2;
        this.i = a2;
        this.j = bl3;
        this.k = bl4;
        this.l = bl5;
        this.m = bl6;
        this.n = bl7;
        this.o = bl8;
    }

    private static ba a(ba ba2, b.a a2) {
        ba ba3 = ba2;
        if (a2 == b.a.b) {
            ba3 = ba2;
            if (az.a(ba2.b())) {
                ba3 = az.h;
            }
        }
        return ba3;
    }

    public static y a(m m2, h h2, w w2, ba ba2, boolean bl2, f f2, b.a a2, an an2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        return new y(m2, null, h2, w2, ba2, bl2, f2, a2, an2, bl3, bl4, bl5, bl6, bl7, bl8);
    }

    private static t a(au au2, ah ah2) {
        if (ah2.t() != null) {
            return ah2.t().c(au2);
        }
        return null;
    }

    @Override
    public boolean A() {
        return this.j;
    }

    @Override
    public boolean B() {
        return this.o;
    }

    public z C() {
        return this.s;
    }

    public boolean D() {
        return this.u;
    }

    public a E() {
        return new a();
    }

    @Override
    public /* synthetic */ ax F() {
        return this.q();
    }

    @Override
    public <R, D> R a(kotlin.reflect.jvm.internal.impl.a.o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    protected ai a(a object) {
        Object object2;
        boolean bl2;
        Object object3;
        boolean bl3;
        boolean bl4;
        y y2 = this.a(((a)object).b, ((a)object).c, ((a)object).d, ((a)object).e, ((a)object).f, ((a)object).k);
        Object object4 = ((a)object).j == null ? this.f() : ((a)object).j;
        Object object5 = new ArrayList<as>(object4.size());
        au au2 = k.a((List<as>)object4, ((a)object).g, y2, object5);
        Object object6 = au2.b(this.r(), kotlin.reflect.jvm.internal.impl.j.ba.c);
        Object object7 = null;
        if (object6 == null) {
            return null;
        }
        object4 = ((a)object).i;
        if (object4 != null) {
            object4 = object3 = object4.a(au2);
            if (object3 == null) {
                return null;
            }
        } else {
            object4 = null;
        }
        if (this.q != null) {
            object3 = object2 = au2.b(this.q.r(), kotlin.reflect.jvm.internal.impl.j.ba.b);
            if (object2 == null) {
                return null;
            }
        } else {
            object3 = null;
        }
        y2.a((kotlin.reflect.jvm.internal.impl.j.w)object6, (List<? extends as>)object5, (al)object4, (kotlin.reflect.jvm.internal.impl.j.w)object3);
        if (this.s == null) {
            object4 = null;
        } else {
            object3 = this.s.x();
            object2 = ((a)object).c;
            object5 = y.a(this.s.p(), ((a)object).f);
            bl4 = this.s.o();
            bl3 = this.s.w();
            bl2 = this.s.a();
            object6 = ((a)object).f;
            object4 = ((a)object).e == null ? null : ((a)object).e.a();
            object4 = new z(y2, (h)object3, (w)((Object)object2), (ba)object5, bl4, bl3, bl2, (b.a)((Object)object6), (kotlin.reflect.jvm.internal.impl.a.aj)object4, an.a);
        }
        if (object4 != null) {
            object3 = this.s.g();
            ((x)object4).a(y.a(au2, this.s));
            object3 = object3 != null ? au2.b((kotlin.reflect.jvm.internal.impl.j.w)object3, kotlin.reflect.jvm.internal.impl.j.ba.c) : null;
            ((z)object4).a((kotlin.reflect.jvm.internal.impl.j.w)object3);
        }
        if (this.t == null) {
            object3 = null;
        } else {
            object2 = this.t.x();
            object5 = ((a)object).c;
            object6 = y.a(this.t.p(), ((a)object).f);
            bl4 = this.t.o();
            bl3 = this.t.w();
            bl2 = this.t.a();
            b.a a2 = ((a)object).f;
            object3 = ((a)object).e == null ? object7 : ((a)object).e.c();
            object3 = new aa(y2, (h)object2, (w)((Object)object5), (ba)object6, bl4, bl3, bl2, a2, (ak)object3, an.a);
        }
        if (object3 != null) {
            object7 = object2 = o.a((t)object3, this.t.i(), au2, false, false, null);
            if (object2 == null) {
                y2.a(true);
                object7 = Collections.singletonList(aa.a((ak)object3, kotlin.reflect.jvm.internal.impl.h.c.a.d(((a)object).b).getNothingType()));
            }
            if (object7.size() == 1) {
                ((x)object3).a(y.a(au2, this.t));
                ((aa)object3).a((av)object7.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        y2.a((z)object4, (ak)object3);
        if (((a)object).h) {
            object = j.b();
            object4 = this.k().iterator();
            while (object4.hasNext()) {
                object.add(object4.next().a(au2));
            }
            y2.a((Collection<? extends b>)object);
        }
        if (this.z() && this.a != null) {
            y2.a(this.a);
        }
        return y2;
    }

    @Override
    public ai a(au au2) {
        if (au2.a()) {
            return this;
        }
        return this.E().a(au2.b()).a(this.q()).a();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.aj a() {
        return this.C();
    }

    @Override
    public /* synthetic */ b a(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    protected y a(m m2, w w2, ba ba2, ai ai2, b.a a2, f f2) {
        return new y(m2, ai2, this.x(), w2, ba2, this.s(), f2, a2, an.a, this.A(), this.z(), this.u(), this.v(), this.w(), this.B());
    }

    @Override
    public void a(Collection<? extends b> collection) {
        this.g = collection;
    }

    public void a(ba ba2) {
        this.f = ba2;
    }

    public void a(z z2, ak ak2) {
        this.s = z2;
        this.t = ak2;
    }

    public void a(kotlin.reflect.jvm.internal.impl.j.w w2, List<? extends as> list, al al2, al al3) {
        this.a(w2);
        this.r = new ArrayList<as>(list);
        this.q = al3;
        this.p = al2;
    }

    public void a(kotlin.reflect.jvm.internal.impl.j.w w2, List<? extends as> list, al al2, kotlin.reflect.jvm.internal.impl.j.w w3) {
        this.a(w2, list, al2, kotlin.reflect.jvm.internal.impl.h.b.a((kotlin.reflect.jvm.internal.impl.a.a)this, w3));
    }

    public void a(boolean bl2) {
        this.u = bl2;
    }

    public ai b(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.E().a(m2).a((b)null).a(w2).a(ba2).a(a2).a(bl2).a();
    }

    @Override
    public ak c() {
        return this.t;
    }

    @Override
    public al d() {
        return this.q;
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
    }

    @Override
    public al e() {
        return this.p;
    }

    @Override
    public List<as> f() {
        return this.r;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.w g() {
        return this.r();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a h() {
        return this.q();
    }

    @Override
    public Collection<? extends ai> k() {
        if (this.g != null) {
            return this.g;
        }
        return Collections.emptyList();
    }

    @Override
    public /* synthetic */ b l() {
        return this.q();
    }

    @Override
    public w m() {
        return this.e;
    }

    @Override
    public /* synthetic */ m m_() {
        return this.q();
    }

    @Override
    public b.a n() {
        return this.i;
    }

    @Override
    public /* synthetic */ p n_() {
        return this.q();
    }

    @Override
    public List<ah> o() {
        ArrayList<ah> arrayList = new ArrayList<ah>(2);
        if (this.s != null) {
            arrayList.add(this.s);
        }
        if (this.t != null) {
            arrayList.add(this.t);
        }
        return arrayList;
    }

    @Override
    public ba p() {
        return this.f;
    }

    @Override
    public ai q() {
        if (this.h == this) {
            return this;
        }
        return this.h.q();
    }

    @Override
    public boolean u() {
        return this.l;
    }

    @Override
    public boolean v() {
        return this.m;
    }

    @Override
    public boolean w() {
        return this.n;
    }

    @Override
    public boolean z() {
        return this.k;
    }

    public class a {
        private m b;
        private w c;
        private ba d;
        private ai e;
        private b.a f;
        private kotlin.reflect.jvm.internal.impl.j.as g;
        private boolean h;
        private al i;
        private List<as> j;
        private f k;

        public a() {
            this.b = y.this.b();
            this.c = y.this.m();
            this.d = y.this.p();
            this.e = null;
            this.f = y.this.n();
            this.g = kotlin.reflect.jvm.internal.impl.j.as.d;
            this.h = true;
            this.i = y.this.p;
            this.j = null;
            this.k = y.this.h_();
        }

        public ai a() {
            return y.this.a(this);
        }

        public a a(b.a a2) {
            this.f = a2;
            return this;
        }

        public a a(b b2) {
            this.e = (ai)b2;
            return this;
        }

        public a a(ba ba2) {
            this.d = ba2;
            return this;
        }

        public a a(m m2) {
            this.b = m2;
            return this;
        }

        public a a(w w2) {
            this.c = w2;
            return this;
        }

        public a a(kotlin.reflect.jvm.internal.impl.j.as as2) {
            this.g = as2;
            return this;
        }

        public a a(boolean bl2) {
            this.h = bl2;
            return this;
        }
    }

}

