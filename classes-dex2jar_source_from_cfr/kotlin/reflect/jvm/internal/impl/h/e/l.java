/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.e.a.b;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.ap;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.a.a.c;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.j;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.t;

public final class l
implements kotlin.reflect.jvm.internal.impl.h.e.h {
    static final /* synthetic */ kotlin.reflect.l[] a;
    private final au b;
    private Map<m, m> d;
    private final g e;
    private final kotlin.reflect.jvm.internal.impl.h.e.h f;

    static {
        a = new kotlin.reflect.l[]{v.a(new kotlin.e.b.t(v.a(l.class), "_allDescriptors", "get_allDescriptors()Ljava/util/Collection;"))};
    }

    public l(kotlin.reflect.jvm.internal.impl.h.e.h object, au au2) {
        kotlin.e.b.j.b(object, "workerScope");
        kotlin.e.b.j.b(au2, "givenSubstitutor");
        this.f = object;
        object = au2.b();
        kotlin.e.b.j.a(object, "givenSubstitutor.substitution");
        this.b = c.a((as)object, false, 1, null).f();
        this.e = h.a((kotlin.e.a.a)new kotlin.e.a.a<Collection<? extends m>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Collection<m> b() {
                return this.a((D)j.a.a(this.f, null, null, 3, null));
            }
        });
    }

    private final <D extends m> Collection<D> a(Collection<? extends D> object) {
        if (this.b.a()) {
            return object;
        }
        if (object.isEmpty()) {
            return object;
        }
        LinkedHashSet<m> linkedHashSet = kotlin.reflect.jvm.internal.impl.l.a.c(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            linkedHashSet.add(this.a((m)object.next()));
        }
        return linkedHashSet;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final <D extends m> D a(D object) {
        Map<m, m> map;
        m m2;
        if (this.b.a()) {
            return object;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        if ((map = this.d) == null) {
            kotlin.e.b.j.a();
        }
        m m3 = map.get(object);
        Object object2 = m3;
        if (m3 == null) {
            if (!(object instanceof ap)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unknown descriptor in scope: ");
                ((StringBuilder)object2).append(object);
                throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString().toString());
            }
            object2 = ((ap)object).d(this.b);
            if (object2 == null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, ");
                ((StringBuilder)object2).append("but ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" substitution fails");
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object2).toString()));
            }
            object2 = (m)object2;
            map.put((m)object, (m)object2);
        }
        if ((m2 = object2) != null) {
            return (D)m2;
        }
        throw new t("null cannot be cast to non-null type D");
    }

    private final Collection<m> c() {
        g g2 = this.e;
        kotlin.reflect.l l2 = a[0];
        return (Collection)g2.a();
    }

    @Override
    public Collection<ai> a(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        return this.a((D)this.f.a(f2, b2));
    }

    @Override
    public Collection<m> a(d d2, b<? super f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        kotlin.e.b.j.b(b2, "nameFilter");
        return this.c();
    }

    @Override
    public Collection<am> b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        return this.a((D)this.f.b(f2, b2));
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(f object, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(object, "name");
        kotlin.e.b.j.b(b2, "location");
        object = this.f.c((f)object, b2);
        if (object != null) {
            return (kotlin.reflect.jvm.internal.impl.a.h)this.a((m)object);
        }
        return null;
    }

    @Override
    public Set<f> l_() {
        return this.f.l_();
    }

    @Override
    public Set<f> o_() {
        return this.f.o_();
    }

}

