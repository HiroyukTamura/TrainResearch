/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.Collection;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class m {
    public static final m a = new m();

    private m() {
    }

    public final boolean a(ad ad2, ad ad3) {
        j.b(ad2, "a");
        j.b(ad3, "b");
        if (ad2.c() == ad3.c() && ag.c(ad2) == ag.c(ad3) && !(j.a((Object)ad2.g(), (Object)ad3.g()) ^ true)) {
            if (ad2.a().size() != ad3.a().size()) {
                return false;
            }
            if (ad2.a() == ad3.a()) {
                return true;
            }
            int n2 = ((Collection)ad2.a()).size();
            for (int i2 = 0; i2 < n2; ++i2) {
                ap ap2 = ad2.a().get(i2);
                ap ap3 = ad3.a().get(i2);
                if (ap2.a() != ap3.a()) {
                    return false;
                }
                if (ap2.a()) continue;
                if (ap2.b() != ap3.b()) {
                    return false;
                }
                if (this.a(ap2.c().l(), ap3.c().l())) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean a(az az2, az az3) {
        j.b(az2, "a");
        j.b(az3, "b");
        if (az2 == az3) {
            return true;
        }
        if (az2 instanceof ad && az3 instanceof ad) {
            return this.a((ad)az2, (ad)az3);
        }
        if (az2 instanceof q && az3 instanceof q) {
            ad ad2 = ((q)(az2 = (q)az2)).f();
            return this.a(ad2, ((q)(az3 = (q)az3)).f()) && this.a(((q)az2).h(), ((q)az3).h());
        }
        return false;
    }
}

