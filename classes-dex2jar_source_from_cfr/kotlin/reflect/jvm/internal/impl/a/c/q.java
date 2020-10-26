/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.c.ad;
import kotlin.reflect.jvm.internal.impl.a.c.j;
import kotlin.reflect.jvm.internal.impl.a.c.u;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.g;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.l;

public final class q
extends j
implements ae {
    static final /* synthetic */ l[] a;
    private final kotlin.reflect.jvm.internal.impl.i.f b;
    private final kotlin.reflect.jvm.internal.impl.h.e.h c;
    private final u d;
    private final kotlin.reflect.jvm.internal.impl.e.b e;

    static {
        a = new l[]{v.a(new t(v.a(q.class), "fragments", "getFragments()Ljava/util/List;"))};
    }

    public q(u u2, kotlin.reflect.jvm.internal.impl.e.b b2, i i2) {
        kotlin.e.b.j.b(u2, "module");
        kotlin.e.b.j.b(b2, "fqName");
        kotlin.e.b.j.b(i2, "storageManager");
        super(h.a.a(), b2.f());
        this.d = u2;
        this.e = b2;
        this.b = i2.a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends ab>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<ab> b() {
                return this.j().g().a(this.a());
            }
        });
        this.c = new g(i2.a((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.h.e.h>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.h.e.h b() {
                if (this.f().isEmpty()) {
                    return h.c.a;
                }
                Object object = this.f();
                List<ad> list = new ArrayList(kotlin.a.m.a(object, 10));
                object = object.iterator();
                while (object.hasNext()) {
                    list.add((ad)((ab)object.next()).a());
                }
                list = kotlin.a.m.a((Collection)list, new ad(this.j(), this.a()));
                object = new StringBuilder();
                ((StringBuilder)object).append("package view scope for ");
                ((StringBuilder)object).append(this.a());
                ((StringBuilder)object).append(" in ");
                ((StringBuilder)object).append(this.j().h_());
                return new kotlin.reflect.jvm.internal.impl.h.e.b(((StringBuilder)object).toString(), list);
            }
        }));
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        kotlin.e.b.j.b(o2, "visitor");
        return o2.a(this, d2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.b a() {
        return this.e;
    }

    @Override
    public /* synthetic */ m b() {
        return this.h();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h c() {
        return this.c;
    }

    @Override
    public /* synthetic */ y e() {
        return this.j();
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2 = object;
        if (!(object instanceof ae)) {
            object2 = null;
        }
        object = (ae)object2;
        boolean bl3 = bl2 = false;
        if (object != null) {
            bl3 = bl2;
            if (kotlin.e.b.j.a((Object)this.a(), (Object)object.a())) {
                bl3 = bl2;
                if (kotlin.e.b.j.a((Object)this.j(), (Object)object.e())) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    @Override
    public List<ab> f() {
        return (List)kotlin.reflect.jvm.internal.impl.i.h.a(this.b, (Object)this, a[0]);
    }

    @Override
    public boolean g() {
        return ae.a.a(this);
    }

    public ae h() {
        if (this.a().c()) {
            return null;
        }
        u u2 = this.j();
        kotlin.reflect.jvm.internal.impl.e.b b2 = this.a().d();
        kotlin.e.b.j.a((Object)b2, "fqName.parent()");
        return u2.a(b2);
    }

    public int hashCode() {
        return this.j().hashCode() * 31 + this.a().hashCode();
    }

    public u j() {
        return this.d;
    }

}

