/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.af;
import kotlin.reflect.jvm.internal.impl.j.aw;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.s;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class ax {
    public static final az a(az az2, w w2) {
        j.b(az2, "$receiver");
        j.b(w2, "origin");
        return ax.b(az2, ax.a(w2));
    }

    public static final w a(w w2) {
        j.b(w2, "$receiver");
        if (w2 instanceof aw) {
            return ((aw)((Object)w2)).k();
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final az b(az az2, w w2) {
        j.b(az2, "$receiver");
        if (w2 == null) {
            return az2;
        }
        if (az2 instanceof ad) {
            return new af((ad)az2, w2);
        }
        if (!(az2 instanceof q)) throw new m();
        return new s((q)az2, w2);
    }

    public static final w b(w w2) {
        j.b(w2, "$receiver");
        w w3 = ax.a(w2);
        if (w3 != null) {
            w2 = w3;
        }
        return w2;
    }
}

