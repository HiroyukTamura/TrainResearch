/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.a.k;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.v;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.b.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.s;

public final class f {
    private static final kotlin.reflect.jvm.internal.impl.e.f a = kotlin.reflect.jvm.internal.impl.e.f.a("message");
    private static final kotlin.reflect.jvm.internal.impl.e.f b = kotlin.reflect.jvm.internal.impl.e.f.a("replaceWith");
    private static final kotlin.reflect.jvm.internal.impl.e.f c = kotlin.reflect.jvm.internal.impl.e.f.a("level");
    private static final kotlin.reflect.jvm.internal.impl.e.f d = kotlin.reflect.jvm.internal.impl.e.f.a("expression");
    private static final kotlin.reflect.jvm.internal.impl.e.f e = kotlin.reflect.jvm.internal.impl.e.f.a("imports");
    private static final kotlin.reflect.jvm.internal.impl.e.b f = new kotlin.reflect.jvm.internal.impl.e.b("kotlin.internal.InlineOnly");

    public static final c a(final KotlinBuiltIns kotlinBuiltIns, String object, String object2, String object3) {
        j.b(kotlinBuiltIns, "$receiver");
        j.b(object, "message");
        j.b(object2, "replaceWith");
        j.b(object3, "level");
        o<kotlin.reflect.jvm.internal.impl.e.f, kotlin.reflect.jvm.internal.impl.h.b.a> o2 = KotlinBuiltIns.FQ_NAMES.replaceWith;
        j.a((Object)o2, "KotlinBuiltIns.FQ_NAMES.replaceWith");
        o2 = new k(kotlinBuiltIns, (kotlin.reflect.jvm.internal.impl.e.b)((Object)o2), af.a(s.a(d, new kotlin.reflect.jvm.internal.impl.h.b.s((String)object2)), s.a(e, new kotlin.reflect.jvm.internal.impl.h.b.b(m.a(), (kotlin.e.a.b<? super y, ? extends w>)new kotlin.e.a.b<y, ad>(){

            @Override
            public final ad a(y a2) {
                j.b(a2, "module");
                a2 = a2.a().getArrayType(kotlin.reflect.jvm.internal.impl.j.ba.a, kotlinBuiltIns.getStringType());
                j.a((Object)a2, "module.builtIns.getArray\u2026ce.INVARIANT, stringType)");
                return a2;
            }
        }))));
        object2 = KotlinBuiltIns.FQ_NAMES.deprecated;
        j.a(object2, "KotlinBuiltIns.FQ_NAMES.deprecated");
        object = s.a(a, new kotlin.reflect.jvm.internal.impl.h.b.s((String)object));
        o2 = s.a(b, new kotlin.reflect.jvm.internal.impl.h.b.a((c)((Object)o2)));
        kotlin.reflect.jvm.internal.impl.e.f f2 = c;
        kotlin.reflect.jvm.internal.impl.e.a a2 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.deprecationLevel);
        j.a((Object)a2, "ClassId.topLevel(KotlinB\u2026Q_NAMES.deprecationLevel)");
        object3 = kotlin.reflect.jvm.internal.impl.e.f.a((String)object3);
        j.a(object3, "Name.identifier(level)");
        return new k(kotlinBuiltIns, (kotlin.reflect.jvm.internal.impl.e.b)object2, af.a(new o[]{object, o2, s.a(f2, new i(a2, (kotlin.reflect.jvm.internal.impl.e.f)object3))}));
    }

    public static /* bridge */ /* synthetic */ c a(KotlinBuiltIns kotlinBuiltIns, String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = "";
        }
        if ((n2 & 4) != 0) {
            string4 = "WARNING";
        }
        return f.a(kotlinBuiltIns, string2, string3, string4);
    }

    private static final boolean a(b iterator) {
        boolean bl2;
        block2 : {
            as as2;
            iterator = iterator.f();
            j.a((Object)iterator, "typeParameters");
            iterator = (Iterable)((Object)iterator);
            bl2 = iterator instanceof Collection;
            boolean bl3 = false;
            if (bl2 && ((Collection)((Object)iterator)).isEmpty()) {
                return false;
            }
            iterator = iterator.iterator();
            do {
                bl2 = bl3;
                if (!iterator.hasNext()) break block2;
                as2 = (as)iterator.next();
                j.a((Object)as2, "it");
            } while (!as2.l());
            bl2 = true;
        }
        return bl2;
    }

    public static final boolean a(v v2) {
        block2 : {
            block3 : {
                j.b(v2, "$receiver");
                if (!(v2 instanceof b)) break block2;
                b b2 = (b)v2;
                if (f.a(b2)) break block3;
                b2 = kotlin.reflect.jvm.internal.impl.h.c.b(b2);
                j.a((Object)b2, "DescriptorUtils.getDirectMember(this)");
                if (!f.a(b2) && !f.c(v2)) break block2;
            }
            return true;
        }
        return false;
    }

    private static final boolean b(b b2) {
        return b2.x().b(f);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final boolean b(v v2) {
        boolean bl2;
        boolean bl3;
        j.b(v2, "$receiver");
        boolean bl4 = f.a(v2);
        boolean bl5 = bl3 = true;
        if (bl4) return bl5;
        if (!(v2 instanceof t)) return false;
        if (!(v2 = (t)v2).D()) return false;
        if (!v2.a()) return false;
        Object object = v2.i();
        j.a(object, "valueParameters");
        object = (Iterable)object;
        if (!(object instanceof Collection) || !((Collection)object).isEmpty()) {
            object = object.iterator();
            while (object.hasNext()) {
                if (!((av)object.next()).o()) continue;
                bl2 = true;
                break;
            }
        } else {
            bl2 = false;
        }
        bl5 = bl3;
        if (bl2) return bl5;
        if (!j.a((Object)v2.p(), (Object)az.a)) return false;
        return true;
    }

    public static final boolean c(v v2) {
        block4 : {
            Object object;
            block5 : {
                j.b(v2, "$receiver");
                if (!(v2 instanceof t)) break block4;
                object = (b)v2;
                if (f.b((b)object)) break block5;
                object = kotlin.reflect.jvm.internal.impl.h.c.b((b)object);
                j.a(object, "DescriptorUtils.getDirectMember(this)");
                if (!f.b((b)object)) break block4;
            }
            boolean bl2 = ((t)v2).a();
            if (kotlin.y.a && !bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Function is not inline: ");
                ((StringBuilder)object).append(v2);
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
            }
            return true;
        }
        return false;
    }

}

