/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.a.j;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.c.k;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.l.i;

public abstract class o
extends k
implements t {
    private List<as> a;
    private List<av> b;
    protected Map<t.b<?>, Object> c = null;
    private kotlin.reflect.jvm.internal.impl.j.w d;
    private al e;
    private al f;
    private w g;
    private ba h = az.i;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = true;
    private boolean t = false;
    private Collection<? extends t> u = null;
    private volatile kotlin.e.a.a<Collection<t>> v = null;
    private final t w;
    private final b.a x;
    private t y = null;

    protected o(m m2, t t2, h h2, f f2, b.a a2, an an2) {
        super(m2, h2, f2, an2);
        m2 = t2;
        if (t2 == null) {
            m2 = this;
        }
        this.w = m2;
        this.x = a2;
    }

    public static List<av> a(t t2, List<av> list, au au2) {
        return o.a(t2, list, au2, false, false, null);
    }

    public static List<av> a(t t2, List<av> object, au au2, boolean bl2, boolean bl3, boolean[] arrbl) {
        ArrayList<av> arrayList = new ArrayList<av>(object.size());
        Iterator<av> iterator = object.iterator();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            kotlin.reflect.jvm.internal.impl.j.w w2 = au2.b(object2.r(), kotlin.reflect.jvm.internal.impl.j.ba.b);
            Object object3 = object2.m();
            object = object3 == null ? null : au2.b((kotlin.reflect.jvm.internal.impl.j.w)object3, kotlin.reflect.jvm.internal.impl.j.ba.b);
            if (w2 == null) {
                return null;
            }
            if ((w2 != object2.r() || object3 != object) && arrbl != null) {
                arrbl[0] = true;
            }
            object3 = bl2 ? null : object2;
            int n2 = object2.c();
            h h2 = object2.x();
            f f2 = object2.h_();
            boolean bl4 = object2.l();
            boolean bl5 = object2.o();
            boolean bl6 = object2.q();
            object2 = bl3 ? object2.y() : an.a;
            arrayList.add(new ah(t2, (av)object3, n2, h2, f2, w2, bl4, bl5, bl6, (kotlin.reflect.jvm.internal.impl.j.w)object, (an)object2));
        }
        return arrayList;
    }

    static /* synthetic */ al a(o o2) {
        return o2.f;
    }

    private an a(boolean bl2, t t2) {
        if (bl2) {
            if (t2 == null) {
                t2 = this.s();
            }
            return t2.y();
        }
        return an.a;
    }

    private void a(t t2) {
        this.y = t2;
    }

    private void k(boolean bl2) {
        this.p = bl2;
    }

    private void l(boolean bl2) {
        this.q = bl2;
    }

    private void o() {
        kotlin.e.a.a<Collection<t>> a2 = this.v;
        if (a2 != null) {
            this.u = a2.a();
            this.v = null;
        }
    }

    private kotlin.reflect.jvm.internal.impl.j.w q() {
        if (this.e == null) {
            return null;
        }
        return this.e.r();
    }

    @Override
    public boolean A() {
        if (this.i) {
            return true;
        }
        Iterator<? extends t> iterator = this.s().k().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().A()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean B() {
        if (this.j) {
            return true;
        }
        Iterator<? extends t> iterator = this.s().k().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().B()) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean C() {
        return this.q;
    }

    @Override
    public boolean D() {
        return this.r;
    }

    @Override
    public t.a<? extends t> E() {
        return this.e(au.a);
    }

    public boolean H() {
        return this.s;
    }

    @Override
    public <R, D> R a(kotlin.reflect.jvm.internal.impl.a.o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    @Override
    public <V> V a(t.b<V> b2) {
        if (this.c == null) {
            return null;
        }
        return (V)this.c.get(b2);
    }

    @Override
    public /* synthetic */ b a(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.c(m2, w2, ba2, a2, bl2);
    }

    protected abstract o a(m var1, t var2, b.a var3, f var4, h var5, an var6);

    public o a(kotlin.reflect.jvm.internal.impl.j.w a2, al object, List<? extends as> list, List<av> list2, kotlin.reflect.jvm.internal.impl.j.w w2, w w3, ba ba2) {
        block3 : {
            this.a = kotlin.a.m.k(list);
            this.b = kotlin.a.m.k(list2);
            this.d = w2;
            this.g = w3;
            this.h = ba2;
            this.e = kotlin.reflect.jvm.internal.impl.h.b.a(this, (kotlin.reflect.jvm.internal.impl.j.w)a2);
            this.f = object;
            int n2 = 0;
            int n3 = 0;
            do {
                if (n3 >= list.size()) break block3;
                a2 = list.get(n3);
                if (a2.g() != n3) break;
                ++n3;
            } while (true);
            object = new StringBuilder();
            ((StringBuilder)object).append(a2);
            ((StringBuilder)object).append(" index is ");
            ((StringBuilder)object).append(a2.g());
            ((StringBuilder)object).append(" but position is ");
            ((StringBuilder)object).append(n3);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        for (int i2 = n2; i2 < list2.size(); ++i2) {
            a2 = list2.get(i2);
            if (a2.c() == i2 + 0) {
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(a2);
            ((StringBuilder)object).append("index is ");
            ((StringBuilder)object).append(a2.c());
            ((StringBuilder)object).append(" but position is ");
            ((StringBuilder)object).append(i2);
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        return this;
    }

    protected t a(a a2) {
        boolean bl2;
        Object object;
        boolean bl3;
        boolean[] object22 = new boolean[1];
        Object object2 = a2.t != null ? j.a(this.x(), a2.t) : this.x();
        o o2 = this.a(((a)a2).b, ((a)a2).e, ((a)a2).f, ((a)a2).k, (h)object2, this.a(((a)a2).n, ((a)a2).e));
        object2 = a2.s == null ? this.f() : a2.s;
        object22[0] = object22[0] | object2.isEmpty() ^ true;
        ArrayList<as> arrayList = new ArrayList<as>(object2.size());
        final au au2 = kotlin.reflect.jvm.internal.impl.j.k.a(object2, ((a)a2).a, o2, arrayList, object22);
        if (au2 == null) {
            return null;
        }
        if (((a)a2).h != null) {
            object2 = au2.b(((a)a2).h, kotlin.reflect.jvm.internal.impl.j.ba.b);
            if (object2 == null) {
                return null;
            }
            bl2 = object22[0];
            bl3 = object2 != ((a)a2).h;
            object22[0] = bl2 | bl3;
        } else {
            object2 = null;
        }
        if (((a)a2).i != null) {
            object = ((a)a2).i.a(au2);
            if (object == null) {
                return null;
            }
            bl2 = object22[0];
            bl3 = object != ((a)a2).i;
            object22[0] = bl2 | bl3;
        } else {
            object = null;
        }
        List<av> list = o.a(o2, ((a)a2).g, au2, ((a)a2).o, ((a)a2).n, object22);
        if (list == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.j.w w2 = au2.b(((a)a2).j, kotlin.reflect.jvm.internal.impl.j.ba.c);
        if (w2 == null) {
            return null;
        }
        bl2 = object22[0];
        bl3 = w2 != ((a)a2).j;
        object22[0] = bl2 | bl3;
        if (!object22[0] && ((a)a2).p) {
            return this;
        }
        o2.a((kotlin.reflect.jvm.internal.impl.j.w)object2, (al)object, arrayList, list, w2, ((a)a2).c, ((a)a2).d);
        o2.a(this.i);
        o2.b(this.j);
        o2.c(this.k);
        o2.d(this.l);
        o2.e(this.m);
        o2.h(this.r);
        o2.f(this.n);
        o2.g(this.o);
        o2.i(this.s);
        o2.k(a2.r);
        o2.l(a2.u);
        bl2 = a2.w != null ? a2.w : this.t;
        o2.j(bl2);
        if (!a2.v.isEmpty() || this.c != null) {
            object = a2.v;
            if (this.c != null) {
                for (Map.Entry entry : this.c.entrySet()) {
                    if (object.containsKey(entry.getKey())) continue;
                    object.put(entry.getKey(), entry.getValue());
                }
            }
            object2 = object;
            if (object.size() == 1) {
                object2 = Collections.singletonMap(object.keySet().iterator().next(), object.values().iterator().next());
            }
            o2.c = object2;
        }
        if (((a)a2).m || this.t() != null) {
            object2 = this.t() != null ? this.t() : this;
            o2.a(object2.c(au2));
        }
        if (((a)a2).l && !this.s().k().isEmpty()) {
            if (((a)a2).a.a()) {
                a2 = this.v;
                if (a2 == null) {
                    o2.a(this.k());
                    return o2;
                }
            } else {
                a2 = new kotlin.e.a.a<Collection<t>>(){

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public Collection<t> b() {
                        i i2 = new i();
                        Iterator<? extends t> iterator = o.this.k().iterator();
                        while (iterator.hasNext()) {
                            i2.add(iterator.next().c(au2));
                        }
                        return i2;
                    }
                };
            }
            o2.v = a2;
        }
        return o2;
    }

    @Override
    public void a(Collection<? extends b> object) {
        this.u = object;
        object = this.u.iterator();
        while (object.hasNext()) {
            if (!((t)object.next()).C()) continue;
            this.q = true;
            break;
        }
    }

    public void a(ba ba2) {
        this.h = ba2;
    }

    public <V> void a(t.b<V> b2, Object object) {
        if (this.c == null) {
            this.c = new LinkedHashMap<t.b<?>, Object>();
        }
        this.c.put(b2, object);
    }

    public void a(kotlin.reflect.jvm.internal.impl.j.w w2) {
        kotlin.reflect.jvm.internal.impl.j.w w3 = this.d;
        this.d = w2;
    }

    public void a(boolean bl2) {
        this.i = bl2;
    }

    @Override
    public boolean a() {
        return this.l;
    }

    public void b(boolean bl2) {
        this.j = bl2;
    }

    public t c(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.E().a(m2).a(w2).a(ba2).a(a2).a(bl2).f();
    }

    @Override
    public t c(au au2) {
        if (au2.a()) {
            return this;
        }
        return this.e(au2).a(this.s()).d(true).f();
    }

    public void c(boolean bl2) {
        this.k = bl2;
    }

    @Override
    public boolean c() {
        return this.m;
    }

    @Override
    public al d() {
        return this.e;
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.c(au2);
    }

    public void d(boolean bl2) {
        this.l = bl2;
    }

    @Override
    public al e() {
        return this.f;
    }

    protected a e(au au2) {
        return new a(au2.b(), this.b(), this.m(), this.p(), this.n(), this.i(), this.q(), this.g(), null);
    }

    public void e(boolean bl2) {
        this.m = bl2;
    }

    @Override
    public List<as> f() {
        return this.a;
    }

    public void f(boolean bl2) {
        this.n = bl2;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.w g() {
        return this.d;
    }

    public void g(boolean bl2) {
        this.o = bl2;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a h() {
        return this.s();
    }

    public void h(boolean bl2) {
        this.r = bl2;
    }

    @Override
    public List<av> i() {
        return this.b;
    }

    public void i(boolean bl2) {
        this.s = bl2;
    }

    public void j(boolean bl2) {
        this.t = bl2;
    }

    @Override
    public boolean j() {
        return this.t;
    }

    @Override
    public Collection<? extends t> k() {
        this.o();
        if (this.u != null) {
            return this.u;
        }
        return Collections.emptyList();
    }

    @Override
    public /* synthetic */ b l() {
        return this.s();
    }

    @Override
    public w m() {
        return this.g;
    }

    @Override
    public /* synthetic */ m m_() {
        return this.s();
    }

    @Override
    public b.a n() {
        return this.x;
    }

    @Override
    public /* synthetic */ p n_() {
        return this.s();
    }

    @Override
    public ba p() {
        return this.h;
    }

    @Override
    public t s() {
        if (this.w == this) {
            return this;
        }
        return this.w.s();
    }

    @Override
    public t t() {
        return this.y;
    }

    @Override
    public boolean u() {
        return this.n;
    }

    @Override
    public boolean v() {
        return this.o;
    }

    @Override
    public boolean w() {
        return this.k;
    }

    @Override
    public boolean z() {
        return this.p;
    }

    public class a
    implements t.a<t> {
        protected kotlin.reflect.jvm.internal.impl.j.as a;
        protected m b;
        protected w c;
        protected ba d;
        protected t e = null;
        protected b.a f;
        protected List<av> g;
        protected kotlin.reflect.jvm.internal.impl.j.w h;
        protected al i = o.a(o.this);
        protected kotlin.reflect.jvm.internal.impl.j.w j;
        protected f k;
        protected boolean l = true;
        protected boolean m = false;
        protected boolean n = false;
        protected boolean o = false;
        protected boolean p = false;
        private boolean r = o.this.z();
        private List<as> s = null;
        private h t = null;
        private boolean u = o.this.C();
        private Map<t.b<?>, Object> v = new LinkedHashMap();
        private Boolean w = null;

        public a(kotlin.reflect.jvm.internal.impl.j.as as2, m m2, w w2, ba ba2, b.a a2, List<av> list, kotlin.reflect.jvm.internal.impl.j.w w3, kotlin.reflect.jvm.internal.impl.j.w w4, f f2) {
            this.a = as2;
            this.b = m2;
            this.c = w2;
            this.d = ba2;
            this.f = a2;
            this.g = list;
            this.h = w3;
            this.j = w4;
            this.k = f2;
        }

        public a a(b b2) {
            this.e = (t)b2;
            return this;
        }

        @Override
        public /* synthetic */ t.a a() {
            return this.g();
        }

        @Override
        public /* synthetic */ t.a a(List list) {
            return this.b(list);
        }

        @Override
        public /* synthetic */ t.a a(h h2) {
            return this.b(h2);
        }

        @Override
        public /* synthetic */ t.a a(al al2) {
            return this.b(al2);
        }

        @Override
        public /* synthetic */ t.a a(b.a a2) {
            return this.b(a2);
        }

        @Override
        public /* synthetic */ t.a a(ba ba2) {
            return this.b(ba2);
        }

        @Override
        public /* synthetic */ t.a a(m m2) {
            return this.b(m2);
        }

        @Override
        public /* synthetic */ t.a a(w w2) {
            return this.b(w2);
        }

        @Override
        public /* synthetic */ t.a a(f f2) {
            return this.b(f2);
        }

        @Override
        public /* synthetic */ t.a a(kotlin.reflect.jvm.internal.impl.j.as as2) {
            return this.b(as2);
        }

        @Override
        public /* synthetic */ t.a a(kotlin.reflect.jvm.internal.impl.j.w w2) {
            return this.c(w2);
        }

        @Override
        public /* synthetic */ t.a a(boolean bl2) {
            return this.b(bl2);
        }

        public a b(List<av> list) {
            this.g = list;
            return this;
        }

        public a b(h h2) {
            this.t = h2;
            return this;
        }

        public a b(al al2) {
            this.i = al2;
            return this;
        }

        public a b(b.a a2) {
            this.f = a2;
            return this;
        }

        public a b(ba ba2) {
            this.d = ba2;
            return this;
        }

        public a b(m m2) {
            this.b = m2;
            return this;
        }

        public a b(w w2) {
            this.c = w2;
            return this;
        }

        public a b(f f2) {
            this.k = f2;
            return this;
        }

        public a b(kotlin.reflect.jvm.internal.impl.j.as as2) {
            this.a = as2;
            return this;
        }

        public a b(boolean bl2) {
            this.l = bl2;
            return this;
        }

        @Override
        public /* synthetic */ t.a b() {
            return this.h();
        }

        @Override
        public /* synthetic */ t.a b(kotlin.reflect.jvm.internal.impl.j.w w2) {
            return this.d(w2);
        }

        public a c(kotlin.reflect.jvm.internal.impl.j.w w2) {
            this.j = w2;
            return this;
        }

        public a c(boolean bl2) {
            this.w = bl2;
            return this;
        }

        @Override
        public /* synthetic */ t.a c() {
            return this.i();
        }

        public a d(kotlin.reflect.jvm.internal.impl.j.w w2) {
            this.h = w2;
            return this;
        }

        public a d(boolean bl2) {
            this.p = bl2;
            return this;
        }

        @Override
        public /* synthetic */ t.a d() {
            return this.j();
        }

        @Override
        public /* synthetic */ t.a e() {
            return this.k();
        }

        @Override
        public t f() {
            return o.this.a(this);
        }

        public a g() {
            this.m = true;
            return this;
        }

        public a h() {
            this.n = true;
            return this;
        }

        public a i() {
            this.o = true;
            return this;
        }

        public a j() {
            this.r = true;
            return this;
        }

        public a k() {
            this.u = true;
            return this;
        }
    }

}

