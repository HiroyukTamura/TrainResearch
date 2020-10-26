/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.List;
import java.util.Set;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.b.d;
import kotlin.reflect.jvm.internal.impl.c.a.e;
import kotlin.reflect.jvm.internal.impl.c.a.q;
import kotlin.reflect.jvm.internal.impl.c.b.u;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.t;

public final class s {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final <T extends kotlin.reflect.jvm.internal.impl.a.b> T a(T t2) {
        void var1_2;
        j.b(t2, "$receiver");
        if (!kotlin.reflect.jvm.internal.impl.c.a.c.a.a().contains(t2.h_()) && !e.a.a().contains(kotlin.reflect.jvm.internal.impl.h.c.a.a(t2).h_())) {
            return null;
        }
        if (t2 instanceof ai || t2 instanceof ah) {
            a a2 = a.a;
            do {
                return (T)kotlin.reflect.jvm.internal.impl.h.c.a.a(t2, false, (kotlin.e.a.b)var1_2, 1, null);
                break;
            } while (true);
        }
        if (!(t2 instanceof am)) return null;
        b b2 = b.a;
        return (T)kotlin.reflect.jvm.internal.impl.h.c.a.a(t2, false, (kotlin.e.a.b)var1_2, 1, null);
    }

    public static final /* synthetic */ q a(String string2, String string3, String string4, String string5) {
        return s.b(string2, string3, string4, string5);
    }

    public static final /* synthetic */ kotlin.reflect.jvm.internal.impl.e.b a(kotlin.reflect.jvm.internal.impl.e.b b2, String string2) {
        return s.b(b2, string2);
    }

    public static final /* synthetic */ kotlin.reflect.jvm.internal.impl.e.b a(kotlin.reflect.jvm.internal.impl.e.c c2, String string2) {
        return s.b(c2, string2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final boolean a(kotlin.reflect.jvm.internal.impl.a.e var0, kotlin.reflect.jvm.internal.impl.a.a var1_1) {
        j.b(var0 /* !! */ , "$receiver");
        j.b(var1_4, "specialCallableDescriptor");
        var1_4 = var1_4.b();
        if (var1_4 == null) throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        var3_5 = ((kotlin.reflect.jvm.internal.impl.a.e)var1_4).i_();
        do lbl-1000: // 3 sources:
        {
            var1_4 = kotlin.reflect.jvm.internal.impl.h.c.a((kotlin.reflect.jvm.internal.impl.a.e)var0_1);
            var2_6 = false;
            if (var1_4 == null) return false;
            var0_2 = var1_4;
            if (var1_4 instanceof d) ** GOTO lbl-1000
            if (kotlin.reflect.jvm.internal.impl.j.a.q.a(var1_4.i_(), var3_5) != null) {
                var2_6 = true;
            }
            var0_3 = var1_4;
        } while (!var2_6);
        return KotlinBuiltIns.isBuiltIn(var1_4) ^ true;
    }

    private static final q b(String string2, String string3, String string4, String string5) {
        f f2 = f.a(string3);
        j.a((Object)f2, "Name.identifier(name)");
        u u2 = u.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append('(');
        stringBuilder.append(string4);
        stringBuilder.append(')');
        stringBuilder.append(string5);
        return new q(f2, u2.a(string2, stringBuilder.toString()));
    }

    private static final kotlin.reflect.jvm.internal.impl.e.b b(kotlin.reflect.jvm.internal.impl.e.b b2, String string2) {
        b2 = b2.a(f.a(string2));
        j.a((Object)b2, "child(Name.identifier(name))");
        return b2;
    }

    private static final kotlin.reflect.jvm.internal.impl.e.b b(kotlin.reflect.jvm.internal.impl.e.c object, String string2) {
        object = ((kotlin.reflect.jvm.internal.impl.e.c)object).a(f.a(string2)).c();
        j.a(object, "child(Name.identifier(name)).toSafe()");
        return object;
    }

    public static final boolean b(kotlin.reflect.jvm.internal.impl.a.b b2) {
        j.b(b2, "$receiver");
        return s.a(b2) != null;
    }

    public static final <T extends kotlin.reflect.jvm.internal.impl.a.b> T c(T t2) {
        j.b(t2, "$receiver");
        Object object = s.a(t2);
        if (object != null) {
            return (T)object;
        }
        object = kotlin.reflect.jvm.internal.impl.c.a.d.a;
        f f2 = t2.h_();
        j.a((Object)f2, "name");
        if (!((kotlin.reflect.jvm.internal.impl.c.a.d)object).a(f2)) {
            return null;
        }
        return (T)kotlin.reflect.jvm.internal.impl.h.c.a.a(t2, false, c.a, 1, null);
    }

    public static final String d(kotlin.reflect.jvm.internal.impl.a.b object) {
        j.b(object, "callableMemberDescriptor");
        Object object2 = s.g((kotlin.reflect.jvm.internal.impl.a.b)object);
        Object var1_2 = null;
        object = var1_2;
        if (object2 != null) {
            object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.b)object2);
            object = var1_2;
            if (object2 != null) {
                if (object2 instanceof ai) {
                    return e.a.b((kotlin.reflect.jvm.internal.impl.a.b)object2);
                }
                object = var1_2;
                if (object2 instanceof am) {
                    object2 = kotlin.reflect.jvm.internal.impl.c.a.c.a.a((am)object2);
                    object = var1_2;
                    if (object2 != null) {
                        object = ((f)object2).a();
                    }
                }
            }
        }
        return object;
    }

    public static final boolean e(kotlin.reflect.jvm.internal.impl.a.b b2) {
        j.b(b2, "$receiver");
        return kotlin.reflect.jvm.internal.impl.h.c.a.a(b2).b() instanceof d;
    }

    public static final boolean f(kotlin.reflect.jvm.internal.impl.a.b b2) {
        j.b(b2, "$receiver");
        return s.e(b2) || KotlinBuiltIns.isBuiltIn(b2);
        {
        }
    }

    private static final kotlin.reflect.jvm.internal.impl.a.b g(kotlin.reflect.jvm.internal.impl.a.b b2) {
        if (KotlinBuiltIns.isBuiltIn(b2)) {
            return s.a(b2);
        }
        return null;
    }

}

