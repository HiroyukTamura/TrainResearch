/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.c.aa;
import kotlin.reflect.jvm.internal.impl.a.c.ab;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.c.f;
import kotlin.reflect.jvm.internal.impl.a.c.z;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.h.e.a.e;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ba;

public class b {
    public static al a(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.j.w w2) {
        if (w2 == null) {
            return null;
        }
        return new ab(a2, new kotlin.reflect.jvm.internal.impl.h.e.a.b(a2, w2, null));
    }

    public static am a(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return ac.a(e2, h.a.a(), c.a, b.a.d, e2.y()).b(null, null, Collections.emptyList(), Collections.<av>emptyList(), kotlin.reflect.jvm.internal.impl.h.c.a.d(e2).getArrayType(ba.a, e2.i_()), w.a, az.e);
    }

    public static aa a(ai ai2, h h2) {
        return b.a(ai2, h2, true, false, false, ai2.y());
    }

    public static aa a(ai ai2, h h2, boolean bl2, boolean bl3, boolean bl4, an an2) {
        return b.a(ai2, h2, bl2, bl3, bl4, ai2.p(), an2);
    }

    public static aa a(ai b2, h h2, boolean bl2, boolean bl3, boolean bl4, kotlin.reflect.jvm.internal.impl.a.ba ba2, an an2) {
        b2 = new aa((ai)b2, h2, b2.m(), ba2, bl2, bl3, bl4, b.a.a, null, an2);
        ((aa)b2).F();
        return b2;
    }

    public static f a(kotlin.reflect.jvm.internal.impl.a.e e2, an an2) {
        return new a(e2, an2);
    }

    public static z a(ai ai2, h h2, boolean bl2, boolean bl3, boolean bl4) {
        return b.b(ai2, h2, bl2, bl3, bl4, ai2.y());
    }

    public static boolean a(t t2) {
        return t2.h_().equals(c.a) && b.c(t2);
    }

    public static am b(kotlin.reflect.jvm.internal.impl.a.e e2) {
        ac ac2 = ac.a(e2, h.a.a(), c.b, b.a.d, e2.y());
        ah ah2 = new ah(ac2, null, 0, h.a.a(), kotlin.reflect.jvm.internal.impl.e.f.a("value"), kotlin.reflect.jvm.internal.impl.h.c.a.d(e2).getStringType(), false, false, false, null, e2.y());
        return ac2.b(null, null, Collections.emptyList(), Collections.singletonList(ah2), e2.i_(), w.a, az.e);
    }

    public static z b(ai ai2, h h2) {
        return b.a(ai2, h2, true, false, false);
    }

    public static z b(ai ai2, h h2, boolean bl2, boolean bl3, boolean bl4, an an2) {
        return new z(ai2, h2, ai2.m(), ai2.p(), bl2, bl3, bl4, b.a.a, null, an2);
    }

    public static boolean b(t t2) {
        return t2.h_().equals(c.b) && b.c(t2);
    }

    private static boolean c(t t2) {
        return t2.n() == b.a.d && c.m(t2.b());
    }

    private static class a
    extends f {
        public a(kotlin.reflect.jvm.internal.impl.a.e e2, an an2) {
            super(e2, null, h.a.a(), true, b.a.a, an2);
            this.a(Collections.<av>emptyList(), c.b(e2));
        }
    }

}

