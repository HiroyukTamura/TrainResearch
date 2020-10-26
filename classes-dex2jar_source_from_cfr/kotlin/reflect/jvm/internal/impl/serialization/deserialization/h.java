/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.i.d;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;

public final class h {
    public static final b a = new b(null);
    private static final Set<kotlin.reflect.jvm.internal.impl.e.a> d = al.a(kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.cloneable.c()));
    private final kotlin.e.a.b<a, kotlin.reflect.jvm.internal.impl.a.e> b;
    private final j c;

    public h(j j2) {
        kotlin.e.b.j.b(j2, "components");
        this.c = j2;
        this.b = this.c.b().b((kotlin.e.a.b)new kotlin.e.a.b<a, kotlin.reflect.jvm.internal.impl.a.e>(){

            @Override
            public final kotlin.reflect.jvm.internal.impl.a.e a(a a2) {
                kotlin.e.b.j.b(a2, "key");
                return this.a(a2);
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final kotlin.reflect.jvm.internal.impl.a.e a(a var1_1) {
        block9 : {
            var8_2 = var1_1.a();
            var3_3 = this.c.l().iterator();
            while (var3_3.hasNext()) {
                var4_4 = var3_3.next().a((kotlin.reflect.jvm.internal.impl.e.a)var8_2);
                if (var4_4 == null) continue;
                return var4_4;
            }
            if (h.d.contains(var8_2)) {
                return null;
            }
            if ((var1_1 = var1_1.b()) == null) {
                var1_1 = this.c.e().a((kotlin.reflect.jvm.internal.impl.e.a)var8_2);
            }
            if (var1_1 == null) return null;
            var4_4 = var1_1.a();
            var5_5 = var1_1.b();
            var6_6 = var1_1.c();
            var7_7 = var1_1.d();
            var1_1 = var8_2.e();
            if (var1_1 != null) {
                var1_1 = var3_3 = h.a(this, (kotlin.reflect.jvm.internal.impl.e.a)var1_1, null, 2, null);
                if (!(var3_3 instanceof e)) {
                    var1_1 = null;
                }
                if ((var1_1 = (e)var1_1) == null) return null;
                var3_3 = var8_2.c();
                kotlin.e.b.j.a(var3_3, "classId.shortClassName");
                if (!var1_1.a((kotlin.reflect.jvm.internal.impl.e.f)var3_3)) {
                    return null;
                }
                var1_1 = var1_1.a();
                return new e((l)var1_1, var5_5, (kotlin.reflect.jvm.internal.impl.d.b.c)var4_4, var6_6, var7_7);
            }
            var1_1 = this.c.g();
            var3_3 = var8_2.a();
            kotlin.e.b.j.a(var3_3, "classId.packageFqName");
            for (Object var1_1 : (Iterable)var1_1.a((kotlin.reflect.jvm.internal.impl.e.b)var3_3)) {
                var9_9 = (ab)var1_1;
                if (!(var9_9 instanceof n)) ** GOTO lbl-1000
                var9_9 = (n)var9_9;
                var10_10 = var8_2.c();
                kotlin.e.b.j.a(var10_10, "classId.shortClassName");
                if (!var9_9.a((kotlin.reflect.jvm.internal.impl.e.f)var10_10)) {
                    var2_8 = false;
                } else lbl-1000: // 2 sources:
                {
                    var2_8 = true;
                }
                if (!var2_8) continue;
                break block9;
            }
            var1_1 = null;
        }
        var1_1 = (ab)var1_1;
        if (var1_1 == null) return null;
        var3_3 = this.c;
        var8_2 = var5_5.G();
        kotlin.e.b.j.a(var8_2, "classProto.typeTable");
        var8_2 = new kotlin.reflect.jvm.internal.impl.d.b.h((a.ai)var8_2);
        var9_9 = k.a;
        var10_10 = var5_5.J();
        kotlin.e.b.j.a(var10_10, "classProto.versionRequirementTable");
        var1_1 = var3_3.a((ab)var1_1, (kotlin.reflect.jvm.internal.impl.d.b.c)var4_4, (kotlin.reflect.jvm.internal.impl.d.b.h)var8_2, var9_9.a((a.ao)var10_10), var6_6, null);
        return new e((l)var1_1, var5_5, (kotlin.reflect.jvm.internal.impl.d.b.c)var4_4, var6_6, var7_7);
    }

    public static /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.a.e a(h h2, kotlin.reflect.jvm.internal.impl.e.a a2, f f2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            f2 = null;
        }
        return h2.a(a2, f2);
    }

    public final kotlin.reflect.jvm.internal.impl.a.e a(kotlin.reflect.jvm.internal.impl.e.a a2, f f2) {
        kotlin.e.b.j.b(a2, "classId");
        return this.b.a(new a(a2, f2));
    }

    private static final class a {
        private final kotlin.reflect.jvm.internal.impl.e.a a;
        private final f b;

        public a(kotlin.reflect.jvm.internal.impl.e.a a2, f f2) {
            kotlin.e.b.j.b(a2, "classId");
            this.a = a2;
            this.b = f2;
        }

        public final kotlin.reflect.jvm.internal.impl.e.a a() {
            return this.a;
        }

        public final f b() {
            return this.b;
        }

        public boolean equals(Object object) {
            return object instanceof a && kotlin.e.b.j.a((Object)this.a, (Object)((a)object).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.e.b.g g2) {
            this();
        }

        public final Set<kotlin.reflect.jvm.internal.impl.e.a> a() {
            return d;
        }
    }

}

