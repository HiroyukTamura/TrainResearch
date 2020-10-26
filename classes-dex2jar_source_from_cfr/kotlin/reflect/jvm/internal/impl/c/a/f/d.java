/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import kotlin.reflect.jvm.internal.impl.c.a.f.e;
import kotlin.reflect.jvm.internal.impl.c.a.f.g;

public final class d {
    public static final a a = new a(null);
    private static final d f = new d(null, null, false, false, 8, null);
    private final g b;
    private final e c;
    private final boolean d;
    private final boolean e;

    public d(g g2, e e2, boolean bl2, boolean bl3) {
        this.b = g2;
        this.c = e2;
        this.d = bl2;
        this.e = bl3;
    }

    public /* synthetic */ d(g g2, e e2, boolean bl2, boolean bl3, int n2, kotlin.e.b.g g3) {
        if ((n2 & 8) != 0) {
            bl3 = false;
        }
        this(g2, e2, bl2, bl3);
    }

    public final g a() {
        return this.b;
    }

    public final e b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.e;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        public final d a() {
            return f;
        }
    }

}

