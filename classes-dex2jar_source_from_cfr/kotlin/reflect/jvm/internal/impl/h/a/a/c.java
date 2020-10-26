/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.g;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.u;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.z;
import kotlin.t;

public final class c {
    public static final kotlin.reflect.jvm.internal.impl.j.as a(kotlin.reflect.jvm.internal.impl.j.as arras, boolean bl2) {
        j.b(arras, "$receiver");
        if (arras instanceof u) {
            ap[] arrap = (u)arras;
            arras = arrap.d();
            Object object = g.a(arrap.e(), arrap.d());
            arrap = new ArrayList(m.a(object, 10));
            object = object.iterator();
            while (object.hasNext()) {
                o o2 = (o)object.next();
                arrap.add(c.b((ap)o2.a(), (as)o2.b()));
            }
            if ((arrap = ((Collection)((List)arrap)).toArray(new ap[0])) != null) {
                return new u(arras, arrap, bl2);
            }
            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return new kotlin.reflect.jvm.internal.impl.j.h((kotlin.reflect.jvm.internal.impl.j.as)arras, bl2, (kotlin.reflect.jvm.internal.impl.j.as)arras){
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.j.as a;
            final /* synthetic */ boolean b;
            {
                this.a = as2;
                this.b = bl2;
                super(as3);
            }

            @Override
            public ap b(w a2) {
                j.b(a2, "key");
                ap ap2 = super.b((w)a2);
                Object object = null;
                if (ap2 != null) {
                    object = a2.g().d();
                    a2 = object;
                    if (!(object instanceof as)) {
                        a2 = null;
                    }
                    object = c.b(ap2, (as)a2);
                }
                return object;
            }

            @Override
            public boolean b() {
                return this.b;
            }
        };
    }

    public static /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.j.as a(kotlin.reflect.jvm.internal.impl.j.as as2, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        return c.a(as2, bl2);
    }

    public static final w a(ap ap2) {
        j.b(ap2, "typeProjection");
        return new kotlin.reflect.jvm.internal.impl.h.a.a.a(ap2, null, false, null, 14, null);
    }

    public static final boolean a(w w2) {
        j.b(w2, "$receiver");
        return w2.g() instanceof kotlin.reflect.jvm.internal.impl.h.a.a.b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final ap b(final ap ap2, as object) {
        if (object == null) return ap2;
        if (ap2.b() == ba.a) {
            return ap2;
        }
        if (object.k() != ap2.b()) return new ar(c.a(ap2));
        if (!ap2.a()) return new ar(ap2.c());
        object = kotlin.reflect.jvm.internal.impl.i.b.a;
        j.a(object, "LockBasedStorageManager.NO_LOCKS");
        return new ar(new z((i)object, (kotlin.e.a.a<? extends w>)new kotlin.e.a.a<w>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final w b() {
                w w2 = ap2.c();
                j.a((Object)w2, "this@createCapturedIfNeeded.type");
                return w2;
            }
        }));
    }

}

