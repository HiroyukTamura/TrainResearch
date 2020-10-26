/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.f.i;

public final class g {
    public static final List<a.ac> a(a.ag object, h h2) {
        j.b(object, "$receiver");
        j.b(h2, "typeTable");
        Object object2 = ((a.ag)object).q();
        if (!(((Collection)object2).isEmpty() ^ true)) {
            object2 = null;
        }
        if (object2 != null) {
            return object2;
        }
        object = ((a.ag)object).s();
        j.a(object, "upperBoundIdList");
        object2 = (Iterable)object;
        object = new ArrayList(m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Integer n2 = (Integer)object2.next();
            j.a((Object)n2, "it");
            object.add(h2.a(n2));
        }
        return (List)object;
    }

    public static final List<a.ac> a(a.c object, h h2) {
        j.b(object, "$receiver");
        j.b(h2, "typeTable");
        Object object2 = ((a.c)object).q();
        if (!(((Collection)object2).isEmpty() ^ true)) {
            object2 = null;
        }
        if (object2 != null) {
            return object2;
        }
        object = ((a.c)object).s();
        j.a(object, "supertypeIdList");
        object2 = (Iterable)object;
        object = new ArrayList(m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Integer n2 = (Integer)object2.next();
            j.a((Object)n2, "it");
            object.add(h2.a(n2));
        }
        return (List)object;
    }

    public static final a.ac a(a.ac.a a2, h h2) {
        j.b(a2, "$receiver");
        j.b(h2, "typeTable");
        if (a2.f()) {
            return a2.g();
        }
        if (a2.j()) {
            return h2.a(a2.k());
        }
        return null;
    }

    public static final a.ac a(a.ac ac2, h h2) {
        j.b(ac2, "$receiver");
        j.b(h2, "typeTable");
        if (ac2.l()) {
            return ac2.p();
        }
        if (ac2.q()) {
            return h2.a(ac2.r());
        }
        return null;
    }

    public static final a.ac a(a.ad c2, h h2) {
        j.b(c2, "$receiver");
        j.b(h2, "typeTable");
        if (((a.ad)c2).l()) {
            c2 = ((a.ad)c2).p();
            j.a((Object)c2, "underlyingType");
            return c2;
        }
        if (((a.ad)c2).q()) {
            return h2.a(((a.ad)c2).r());
        }
        throw (Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final a.ac a(a.ak c2, h h2) {
        j.b(c2, "$receiver");
        j.b(h2, "typeTable");
        if (((a.ak)c2).j()) {
            c2 = ((a.ak)c2).k();
            j.a((Object)c2, "type");
            return c2;
        }
        if (((a.ak)c2).l()) {
            return h2.a(((a.ak)c2).p());
        }
        throw (Throwable)new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final a.ac a(a.o c2, h h2) {
        j.b(c2, "$receiver");
        j.b(h2, "typeTable");
        if (((a.o)c2).l()) {
            c2 = ((a.o)c2).p();
            j.a((Object)c2, "returnType");
            return c2;
        }
        if (((a.o)c2).q()) {
            return h2.a(((a.o)c2).r());
        }
        throw (Throwable)new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final a.ac a(a.w c2, h h2) {
        j.b(c2, "$receiver");
        j.b(h2, "typeTable");
        if (((a.w)c2).l()) {
            c2 = ((a.w)c2).p();
            j.a((Object)c2, "returnType");
            return c2;
        }
        if (((a.w)c2).q()) {
            return h2.a(((a.w)c2).r());
        }
        throw (Throwable)new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final boolean a(a.o o2) {
        j.b(o2, "$receiver");
        return o2.u() || o2.w();
        {
        }
    }

    public static final boolean a(a.w w2) {
        j.b(w2, "$receiver");
        return w2.u() || w2.w();
        {
        }
    }

    public static final a.ac b(a.ac ac2, h h2) {
        j.b(ac2, "$receiver");
        j.b(h2, "typeTable");
        if (ac2.A()) {
            return ac2.B();
        }
        if (ac2.C()) {
            return h2.a(ac2.D());
        }
        return null;
    }

    public static final a.ac b(a.ad c2, h h2) {
        j.b(c2, "$receiver");
        j.b(h2, "typeTable");
        if (((a.ad)c2).s()) {
            c2 = ((a.ad)c2).t();
            j.a((Object)c2, "expandedType");
            return c2;
        }
        if (((a.ad)c2).u()) {
            return h2.a(((a.ad)c2).v());
        }
        throw (Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final a.ac b(a.ak ak2, h h2) {
        j.b(ak2, "$receiver");
        j.b(h2, "typeTable");
        if (ak2.q()) {
            return ak2.r();
        }
        if (ak2.s()) {
            return h2.a(ak2.t());
        }
        return null;
    }

    public static final a.ac b(a.o o2, h h2) {
        j.b(o2, "$receiver");
        j.b(h2, "typeTable");
        if (o2.u()) {
            return o2.v();
        }
        if (o2.w()) {
            return h2.a(o2.x());
        }
        return null;
    }

    public static final a.ac b(a.w w2, h h2) {
        j.b(w2, "$receiver");
        j.b(h2, "typeTable");
        if (w2.u()) {
            return w2.v();
        }
        if (w2.w()) {
            return h2.a(w2.x());
        }
        return null;
    }

    public static final a.ac c(a.ac ac2, h h2) {
        j.b(ac2, "$receiver");
        j.b(h2, "typeTable");
        if (ac2.E()) {
            return ac2.F();
        }
        if (ac2.G()) {
            return h2.a(ac2.H());
        }
        return null;
    }
}

