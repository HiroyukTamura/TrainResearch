/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.b;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.e;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;

public final class a
extends e {
    public static final a a = new a(null);
    private static final f d = f.a("clone");

    public a(i i2, kotlin.reflect.jvm.internal.impl.a.e e2) {
        j.b(i2, "storageManager");
        j.b(e2, "containingClass");
        super(i2, e2);
    }

    @Override
    protected List<t> a() {
        ac ac2 = ac.a(this.c(), h.a.a(), d, b.a.a, an.a);
        ac2.b(null, this.c().D(), m.a(), m.<av>a(), kotlin.reflect.jvm.internal.impl.h.c.a.d(this.c()).getAnyType(), w.c, az.c);
        return m.a(ac2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final f a() {
            return d;
        }
    }

}

