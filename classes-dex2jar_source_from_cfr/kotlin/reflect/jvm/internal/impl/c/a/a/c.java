/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.a.af;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.a.b;
import kotlin.reflect.jvm.internal.impl.c.a.a.e;
import kotlin.reflect.jvm.internal.impl.c.a.a.h;
import kotlin.reflect.jvm.internal.impl.c.a.a.i;
import kotlin.reflect.jvm.internal.impl.c.a.e.a;
import kotlin.reflect.jvm.internal.impl.c.a.e.d;
import kotlin.reflect.jvm.internal.impl.c.a.e.l;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.s;

public final class c {
    public static final c a = new c();
    private static final kotlin.reflect.jvm.internal.impl.e.b b = new kotlin.reflect.jvm.internal.impl.e.b(Target.class.getCanonicalName());
    private static final kotlin.reflect.jvm.internal.impl.e.b c = new kotlin.reflect.jvm.internal.impl.e.b(Retention.class.getCanonicalName());
    private static final kotlin.reflect.jvm.internal.impl.e.b d = new kotlin.reflect.jvm.internal.impl.e.b(Deprecated.class.getCanonicalName());
    private static final kotlin.reflect.jvm.internal.impl.e.b e = new kotlin.reflect.jvm.internal.impl.e.b(Documented.class.getCanonicalName());
    private static final kotlin.reflect.jvm.internal.impl.e.b f = new kotlin.reflect.jvm.internal.impl.e.b("java.lang.annotation.Repeatable");
    private static final f g = f.a("message");
    private static final f h = f.a("allowedTargets");
    private static final f i = f.a("value");
    private static final Map<kotlin.reflect.jvm.internal.impl.e.b, kotlin.reflect.jvm.internal.impl.e.b> j = af.a(s.a(KotlinBuiltIns.FQ_NAMES.target, b), s.a(KotlinBuiltIns.FQ_NAMES.retention, c), s.a(KotlinBuiltIns.FQ_NAMES.repeatable, f), s.a(KotlinBuiltIns.FQ_NAMES.mustBeDocumented, e));
    private static final Map<kotlin.reflect.jvm.internal.impl.e.b, kotlin.reflect.jvm.internal.impl.e.b> k = af.a(s.a(b, KotlinBuiltIns.FQ_NAMES.target), s.a(c, KotlinBuiltIns.FQ_NAMES.retention), s.a(d, KotlinBuiltIns.FQ_NAMES.deprecated), s.a(f, KotlinBuiltIns.FQ_NAMES.repeatable), s.a(e, KotlinBuiltIns.FQ_NAMES.mustBeDocumented));

    private c() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final kotlin.reflect.jvm.internal.impl.a.a.c a(a object, kotlin.reflect.jvm.internal.impl.c.a.c.h h2) {
        j.b(object, "annotation");
        j.b(h2, "c");
        Object object2 = object.b();
        if (j.a(object2, (Object)kotlin.reflect.jvm.internal.impl.e.a.a(b))) {
            object = new i((a)object, h2);
            do {
                return (kotlin.reflect.jvm.internal.impl.a.a.c)object;
                break;
            } while (true);
        }
        if (j.a(object2, (Object)kotlin.reflect.jvm.internal.impl.e.a.a(c))) {
            object = new h((a)object, h2);
            return (kotlin.reflect.jvm.internal.impl.a.a.c)object;
        }
        if (j.a(object2, (Object)kotlin.reflect.jvm.internal.impl.e.a.a(f))) {
            object2 = KotlinBuiltIns.FQ_NAMES.repeatable;
            j.a(object2, "KotlinBuiltIns.FQ_NAMES.repeatable");
            object = new b(h2, (a)object, (kotlin.reflect.jvm.internal.impl.e.b)object2);
            return (kotlin.reflect.jvm.internal.impl.a.a.c)object;
        }
        if (j.a(object2, (Object)kotlin.reflect.jvm.internal.impl.e.a.a(e))) {
            object2 = KotlinBuiltIns.FQ_NAMES.mustBeDocumented;
            j.a(object2, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
            object = new b(h2, (a)object, (kotlin.reflect.jvm.internal.impl.e.b)object2);
            return (kotlin.reflect.jvm.internal.impl.a.a.c)object;
        }
        if (j.a(object2, (Object)kotlin.reflect.jvm.internal.impl.e.a.a(d))) {
            return null;
        }
        object = new kotlin.reflect.jvm.internal.impl.c.a.c.a.e(h2, (a)object);
        return (kotlin.reflect.jvm.internal.impl.a.a.c)object;
    }

    public final kotlin.reflect.jvm.internal.impl.a.a.c a(kotlin.reflect.jvm.internal.impl.e.b object, d l2, kotlin.reflect.jvm.internal.impl.c.a.c.h h2) {
        a a2;
        j.b(object, "kotlinName");
        j.b(l2, "annotationOwner");
        j.b(h2, "c");
        if (j.a(object, (Object)KotlinBuiltIns.FQ_NAMES.deprecated) && ((a2 = l2.a(d)) != null || l2.b())) {
            return new e(a2, h2);
        }
        kotlin.reflect.jvm.internal.impl.e.b b2 = j.get(object);
        a2 = null;
        object = a2;
        if (b2 != null) {
            l2 = l2.a(b2);
            object = a2;
            if (l2 != null) {
                object = a.a((a)l2, h2);
            }
        }
        return object;
    }

    public final f a() {
        return g;
    }

    public final f b() {
        return h;
    }

    public final f c() {
        return i;
    }
}

