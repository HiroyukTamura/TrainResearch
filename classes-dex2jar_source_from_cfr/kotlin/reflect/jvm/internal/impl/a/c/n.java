/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.g;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.f;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.h.j;
import kotlin.reflect.jvm.internal.impl.i.c;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;

public class n
extends g {
    static final /* synthetic */ boolean c;
    private final kotlin.reflect.jvm.internal.impl.j.an d;
    private final kotlin.reflect.jvm.internal.impl.h.e.h e;
    private final kotlin.reflect.jvm.internal.impl.i.f<Set<kotlin.reflect.jvm.internal.impl.e.f>> f;
    private final h g;

    static {
        c = n.class.desiredAssertionStatus() ^ true;
    }

    private n(i i2, e e2, kotlin.reflect.jvm.internal.impl.j.w w2, kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.i.f<Set<kotlin.reflect.jvm.internal.impl.e.f>> f3, h h2, an an2) {
        super(i2, e2, f2, an2, false);
        if (!c && e2.l() != f.c) {
            throw new AssertionError();
        }
        this.g = h2;
        this.d = new kotlin.reflect.jvm.internal.impl.j.e(this, Collections.emptyList(), Collections.singleton(w2), i2);
        this.e = new a(i2);
        this.f = f3;
    }

    public static n a(i i2, e e2, kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.i.f<Set<kotlin.reflect.jvm.internal.impl.e.f>> f3, h h2, an an2) {
        return new n(i2, e2, e2.i_(), f2, f3, h2, an2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        return this.d;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h f_() {
        return h.c.a;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h g() {
        return this.e;
    }

    @Override
    public e i() {
        return null;
    }

    @Override
    public Collection<d> k() {
        return Collections.emptyList();
    }

    @Override
    public f l() {
        return f.d;
    }

    @Override
    public w m() {
        return w.a;
    }

    @Override
    public d o() {
        return null;
    }

    @Override
    public ba p() {
        return az.e;
    }

    @Override
    public boolean q() {
        return false;
    }

    @Override
    public boolean r() {
        return false;
    }

    @Override
    public boolean s() {
        return false;
    }

    @Override
    public boolean t() {
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("enum entry ");
        stringBuilder.append(this.h_());
        return stringBuilder.toString();
    }

    @Override
    public boolean u() {
        return false;
    }

    @Override
    public boolean v() {
        return false;
    }

    @Override
    public h x() {
        return this.g;
    }

    @Override
    public List<as> z() {
        return Collections.emptyList();
    }

    private class a
    extends kotlin.reflect.jvm.internal.impl.h.e.i {
        static final /* synthetic */ boolean a;
        private final c<kotlin.reflect.jvm.internal.impl.e.f, Collection<am>> d;
        private final c<kotlin.reflect.jvm.internal.impl.e.f, Collection<ai>> e;
        private final kotlin.reflect.jvm.internal.impl.i.f<Collection<m>> f;

        static {
            a = n.class.desiredAssertionStatus() ^ true;
        }

        public a(i i2) {
            this.d = i2.a(new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<am>>(){

                @Override
                public Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                    return a.this.b(f2);
                }
            });
            this.e = i2.a(new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<ai>>(){

                @Override
                public Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                    return a.this.a(f2);
                }
            });
            this.f = i2.a(new kotlin.e.a.a<Collection<m>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public Collection<m> b() {
                    return a.this.d();
                }
            });
        }

        private Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
            return this.a(f2, this.c().a(f2, kotlin.reflect.jvm.internal.impl.b.a.d.p));
        }

        private <D extends b> Collection<D> a(kotlin.reflect.jvm.internal.impl.e.f f2, Collection<D> collection) {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            j.a(f2, collection, Collections.emptySet(), n.this, new kotlin.reflect.jvm.internal.impl.h.h(){

                @Override
                public void a(b b2) {
                    j.a(b2, null);
                    linkedHashSet.add(b2);
                }

                @Override
                protected void a(b b2, b b3) {
                }
            });
            return linkedHashSet;
        }

        private Collection<am> b(kotlin.reflect.jvm.internal.impl.e.f f2) {
            return this.a(f2, this.c().b(f2, kotlin.reflect.jvm.internal.impl.b.a.d.p));
        }

        private kotlin.reflect.jvm.internal.impl.h.e.h c() {
            Collection<kotlin.reflect.jvm.internal.impl.j.w> collection = n.this.e().k_();
            if (!a && collection.size() != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Enum entry and its companion object both should have exactly one supertype: ");
                stringBuilder.append(collection);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            return collection.iterator().next().b();
        }

        private Collection<m> d() {
            HashSet<m> hashSet = new HashSet<m>();
            for (kotlin.reflect.jvm.internal.impl.e.f f2 : (Set)n.this.f.a()) {
                hashSet.addAll(this.b(f2, kotlin.reflect.jvm.internal.impl.b.a.d.p));
                hashSet.addAll(this.a(f2, kotlin.reflect.jvm.internal.impl.b.a.d.p));
            }
            return hashSet;
        }

        public Collection a(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            return (Collection)this.e.a(f2);
        }

        @Override
        public Collection<m> a(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
            return (Collection)this.f.a();
        }

        public Collection b(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            return (Collection)this.d.a(f2);
        }

        @Override
        public Set<kotlin.reflect.jvm.internal.impl.e.f> l_() {
            return (Set)n.this.f.a();
        }

        @Override
        public Set<kotlin.reflect.jvm.internal.impl.e.f> o_() {
            return (Set)n.this.f.a();
        }

    }

}

