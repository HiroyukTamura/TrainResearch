/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.b;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.i;
import kotlin.reflect.l;
import kotlin.y;

public final class k
extends i {
    static final /* synthetic */ l[] a;
    private final kotlin.reflect.jvm.internal.impl.i.f b;
    private final kotlin.reflect.jvm.internal.impl.a.e d;

    static {
        a = new l[]{v.a(new t(v.a(k.class), "functions", "getFunctions()Ljava/util/List;"))};
    }

    public k(kotlin.reflect.jvm.internal.impl.i.i object, kotlin.reflect.jvm.internal.impl.a.e e2) {
        j.b(object, "storageManager");
        j.b(e2, "containingClass");
        this.d = e2;
        boolean bl2 = this.d.l() == kotlin.reflect.jvm.internal.impl.a.f.c;
        if (y.a && !bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Class should be an enum: ");
            ((StringBuilder)object).append(this.d);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        this.b = object.a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends am>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<am> b() {
                return m.b(b.b(this.d), b.a(this.d));
            }
        });
    }

    private final List<am> c() {
        return (List)kotlin.reflect.jvm.internal.impl.i.h.a(this.b, (Object)this, a[0]);
    }

    public /* synthetic */ Collection a(d d2, kotlin.e.a.b b2) {
        return this.b(d2, b2);
    }

    public /* synthetic */ Collection b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        return this.f(f2, b2);
    }

    public List<am> b(d d2, kotlin.e.a.b<? super f, Boolean> b2) {
        j.b(d2, "kindFilter");
        j.b(b2, "nameFilter");
        return this.c();
    }

    @Override
    public /* synthetic */ h c(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        return (h)((Object)this.e(f2, b2));
    }

    public Void e(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return null;
    }

    public ArrayList<am> f(f f2, kotlin.reflect.jvm.internal.impl.b.a.b object) {
        j.b(f2, "name");
        j.b(object, "location");
        Object object2 = this.c();
        object = new ArrayList(1);
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object e2 = object2.next();
            if (!j.a((Object)((am)e2).h_(), (Object)f2)) continue;
            object.add(e2);
        }
        return (ArrayList)object;
    }

}

