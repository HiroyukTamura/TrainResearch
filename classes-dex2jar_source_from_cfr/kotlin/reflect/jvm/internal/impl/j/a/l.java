/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.j.a.j;
import kotlin.reflect.jvm.internal.impl.j.a.o;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class l {
    public static final l a = new l();

    private l() {
    }

    private final boolean a(o object, ad ad2, o.c c2) {
        Set set;
        boolean bl2 = j.a(ad2) && !ad2.c() || ag.c(ad2);
        if (bl2) {
            return true;
        }
        o.b((o)object);
        ArrayDeque arrayDeque = o.c((o)object);
        if (arrayDeque == null) {
            kotlin.e.b.j.a();
        }
        if ((set = o.d((o)object)) == null) {
            kotlin.e.b.j.a();
        }
        arrayDeque.push(ad2);
        while (((Collection)arrayDeque).isEmpty() ^ true) {
            if (set.size() <= 1000) {
                ad ad3 = (ad)arrayDeque.pop();
                kotlin.e.b.j.a((Object)ad3, "current");
                if (!set.add(ad3)) continue;
                o.c c3 = ad3.c() ? (o.c)o.c.c.a : c2;
                if (!(kotlin.e.b.j.a((Object)c3, (Object)o.c.c.a) ^ true)) {
                    c3 = null;
                }
                if (c3 == null) continue;
                for (w w2 : ad3.g().k_()) {
                    kotlin.e.b.j.a((Object)w2, "supertype");
                    w2 = c3.a(w2);
                    bl2 = j.a((ad)w2) && !w2.c() || ag.c(w2);
                    if (bl2) {
                        o.e((o)object);
                        return true;
                    }
                    arrayDeque.add(w2);
                }
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Too many supertypes for type: ");
            ((StringBuilder)object).append(ad2);
            ((StringBuilder)object).append(". Supertypes = ");
            ((StringBuilder)object).append(m.a(set, null, null, null, 0, null, null, 63, null));
            throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
        }
        o.e((o)object);
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final boolean a(o var1_1, ad var2_2, an var3_3) {
        if (!var2_2.c() && kotlin.e.b.j.a((Object)var2_2.g(), (Object)var3_3)) {
            return true;
        }
        var4_4 = false;
        if (var4_4) {
            return true;
        }
        o.b((o)var1_1);
        var7_5 = o.c((o)var1_1);
        if (var7_5 == null) {
            kotlin.e.b.j.a();
        }
        if ((var6_6 = o.d((o)var1_1)) == null) {
            kotlin.e.b.j.a();
        }
        var7_5.push(var2_2);
        block0 : do lbl-1000: // 4 sources:
        {
            if (!(((Collection)var7_5).isEmpty() ^ true)) {
                o.e((o)var1_1);
                return false;
            }
            if (var6_6.size() > 1000) {
                var1_1 = new StringBuilder();
                var1_1.append("Too many supertypes for type: ");
                var1_1.append(var2_2);
                var1_1.append(". Supertypes = ");
                var1_1.append(m.a(var6_6, null, null, null, 0, null, null, 63, null));
                throw (Throwable)new IllegalStateException(var1_1.toString().toString());
            }
            var8_8 = (ad)var7_5.pop();
            kotlin.e.b.j.a(var8_8, "current");
            if (!var6_6.add(var8_8)) ** GOTO lbl-1000
            var5_7 = var8_8.c() != false ? o.c.c.a : o.c.a.a;
            if (!(kotlin.e.b.j.a((Object)(var5_7 = (o.c)var5_7), (Object)o.c.c.a) ^ true)) {
                var5_7 = null;
            }
            if (var5_7 == null) ** GOTO lbl-1000
            var8_8 = var8_8.g().k_().iterator();
            do {
                if (!var8_8.hasNext()) continue block0;
                var9_9 = (w)var8_8.next();
                kotlin.e.b.j.a((Object)var9_9, "supertype");
                var9_9 = var5_7.a(var9_9);
                var4_4 = var9_9.c() == false && kotlin.e.b.j.a((Object)var9_9.g(), (Object)var3_3) != false;
                if (var4_4) {
                    o.e((o)var1_1);
                    return true;
                }
                var7_5.add(var9_9);
            } while (true);
            break;
        } while (true);
    }

    private final boolean b(o object, ad ad2, ad ad3) {
        boolean bl2 = j.c(ad2) || j.b(ad2) || ((o)object).a(ad2);
        if (y.a && !bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Not singleClassifierType superType: ");
            ((StringBuilder)object).append(ad3);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        bl2 = j.b(ad3) || ((o)object).a(ad3);
        if (y.a && !bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Not singleClassifierType superType: ");
            ((StringBuilder)object).append(ad3);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        if (ad3.c()) {
            return true;
        }
        if (ag.c(ad2)) {
            return true;
        }
        if (this.a((o)object, ad2, o.c.a.a)) {
            return true;
        }
        if (ag.c(ad3)) {
            return false;
        }
        if (this.a((o)object, ad3, o.c.d.a)) {
            return false;
        }
        if (j.a(ad2)) {
            return false;
        }
        return this.a((o)object, ad2, ad3.g());
    }

    public final boolean a(o o2, ad ad2, ad ad3) {
        kotlin.e.b.j.b(o2, "context");
        kotlin.e.b.j.b(ad2, "subType");
        kotlin.e.b.j.b(ad3, "superType");
        return this.b(o2, ad2, ad3);
    }

    public final boolean a(az az2) {
        kotlin.e.b.j.b(az2, "type");
        return this.a(new o(false, false, 2, null), t.c(az2), o.c.a.a);
    }
}

