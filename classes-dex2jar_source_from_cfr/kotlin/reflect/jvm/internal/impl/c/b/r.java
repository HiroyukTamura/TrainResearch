/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.List;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.d;
import kotlin.reflect.jvm.internal.impl.c.a.s;
import kotlin.reflect.jvm.internal.impl.c.b.j;
import kotlin.reflect.jvm.internal.impl.c.b.l;
import kotlin.reflect.jvm.internal.impl.c.b.u;
import kotlin.reflect.jvm.internal.impl.c.b.w;
import kotlin.reflect.jvm.internal.impl.c.b.x;
import kotlin.reflect.jvm.internal.impl.c.b.z;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.h.c.a;

public final class r {
    public static final String a(e object) {
        kotlin.e.b.j.b(object, "$receiver");
        Object object2 = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
        kotlin.reflect.jvm.internal.impl.e.c c2 = a.b((kotlin.reflect.jvm.internal.impl.a.m)object).b();
        kotlin.e.b.j.a((Object)c2, "fqNameSafe.toUnsafe()");
        object2 = ((kotlin.reflect.jvm.internal.impl.builtins.b.c)object2).a(c2);
        if (object2 != null) {
            object = kotlin.reflect.jvm.internal.impl.h.d.b.a((kotlin.reflect.jvm.internal.impl.e.a)object2);
            kotlin.e.b.j.a(object, "JvmClassName.byClassId(it)");
            object = ((kotlin.reflect.jvm.internal.impl.h.d.b)object).c();
            kotlin.e.b.j.a(object, "JvmClassName.byClassId(it).internalName");
            return object;
        }
        return z.a((e)object, null, false, 2, null);
    }

    public static final String a(t object, boolean bl2, boolean bl3) {
        kotlin.e.b.j.b(object, "$receiver");
        StringBuilder stringBuilder = new StringBuilder();
        if (bl3) {
            Object object2;
            if (object instanceof kotlin.reflect.jvm.internal.impl.a.l) {
                object2 = "<init>";
            } else {
                object2 = object.h_().a();
                kotlin.e.b.j.a(object2, "name.asString()");
            }
            stringBuilder.append((String)object2);
        }
        stringBuilder.append("(");
        for (kotlin.reflect.jvm.internal.impl.a.a.a a2 : object.i()) {
            kotlin.e.b.j.a((Object)a2, "parameter");
            a2 = a2.r();
            kotlin.e.b.j.a((Object)a2, "parameter.type");
            r.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.j.w)a2);
        }
        stringBuilder.append(")");
        if (bl2) {
            if (z.a((kotlin.reflect.jvm.internal.impl.a.a)object)) {
                stringBuilder.append("V");
            } else {
                if ((object = object.g()) == null) {
                    kotlin.e.b.j.a();
                }
                kotlin.e.b.j.a(object, "returnType!!");
                r.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.j.w)object);
            }
        }
        object = stringBuilder.toString();
        kotlin.e.b.j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public static /* bridge */ /* synthetic */ String a(t t2, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        if ((n2 & 2) != 0) {
            bl3 = true;
        }
        return r.a(t2, bl2, bl3);
    }

    public static final j a(kotlin.reflect.jvm.internal.impl.j.w w2) {
        kotlin.e.b.j.b(w2, "$receiver");
        return (j)z.a(w2, l.a, x.c, w.a, null, null, false, 32, null);
    }

    private static final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.w w2) {
        stringBuilder.append(r.a(w2));
    }

    public static final boolean a(kotlin.reflect.jvm.internal.impl.a.a object) {
        kotlin.e.b.j.b(object, "f");
        boolean bl2 = object instanceof t;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        t t2 = (t)object;
        bl2 = bl3;
        if (t2.i().size() == 1) {
            bl2 = bl3;
            if (!s.f((kotlin.reflect.jvm.internal.impl.a.b)object)) {
                if (kotlin.e.b.j.a((Object)t2.h_().a(), (Object)"remove") ^ true) {
                    return false;
                }
                object = t2.s();
                kotlin.e.b.j.a(object, "f.original");
                object = object.i();
                kotlin.e.b.j.a(object, "f.original.valueParameters");
                object = m.j(object);
                kotlin.e.b.j.a(object, "f.original.valueParameters.single()");
                object = ((av)object).r();
                kotlin.e.b.j.a(object, "f.original.valueParameters.single().type");
                object = r.a((kotlin.reflect.jvm.internal.impl.j.w)object);
                bl2 = object instanceof j.c;
                Object object2 = null;
                if (!bl2) {
                    object = null;
                }
                j.c c2 = (j.c)object;
                object = object2;
                if (c2 != null) {
                    object = c2.a();
                }
                if (object != kotlin.reflect.jvm.internal.impl.h.d.c.e) {
                    return false;
                }
                object = d.a(t2);
                bl2 = bl3;
                if (object != null) {
                    object2 = object.s();
                    kotlin.e.b.j.a(object2, "overridden.original");
                    object2 = object2.i();
                    kotlin.e.b.j.a(object2, "overridden.original.valueParameters");
                    object2 = m.j(object2);
                    kotlin.e.b.j.a(object2, "overridden.original.valueParameters.single()");
                    object2 = ((av)object2).r();
                    kotlin.e.b.j.a(object2, "overridden.original.valueParameters.single().type");
                    object2 = r.a((kotlin.reflect.jvm.internal.impl.j.w)object2);
                    object = object.b();
                    kotlin.e.b.j.a(object, "overridden.containingDeclaration");
                    bl2 = bl3;
                    if (kotlin.e.b.j.a((Object)a.a((kotlin.reflect.jvm.internal.impl.a.m)object), (Object)KotlinBuiltIns.FQ_NAMES.mutableCollection.b())) {
                        bl2 = bl3;
                        if (object2 instanceof j.b) {
                            bl2 = bl3;
                            if (kotlin.e.b.j.a((Object)((j.b)object2).a(), (Object)"java/lang/Object")) {
                                bl2 = true;
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public static final String b(kotlin.reflect.jvm.internal.impl.a.a object) {
        kotlin.e.b.j.b(object, "$receiver");
        u u2 = u.a;
        if (c.b((kotlin.reflect.jvm.internal.impl.a.m)object)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.a.m m2 = object.b();
        Object object2 = m2;
        if (!(m2 instanceof e)) {
            object2 = null;
        }
        if ((m2 = (e)object2) != null) {
            object2 = m2.h_();
            kotlin.e.b.j.a(object2, "classDescriptor.name");
            if (((f)object2).c()) {
                return null;
            }
            object = object2 = object.h();
            if (!(object2 instanceof am)) {
                object = null;
            }
            if ((object = (am)object) != null) {
                return u2.a((e)m2, r.a((t)object, false, false, 3, null));
            }
        }
        return null;
    }
}

