/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class l
extends as {
    public static final a a = new a(null);
    private final as b;
    private final as c;

    private l(as as2, as as3) {
        this.b = as2;
        this.c = as3;
    }

    public /* synthetic */ l(as as2, as as3, g g2) {
        this(as2, as3);
    }

    public static final as a(as as2, as as3) {
        return a.a(as2, as3);
    }

    @Override
    public h a(h h2) {
        j.b(h2, "annotations");
        return this.c.a(this.b.a(h2));
    }

    @Override
    public w a(w w2, ba ba2) {
        j.b(w2, "topLevelType");
        j.b((Object)ba2, "position");
        return this.c.a(this.b.a(w2, ba2), ba2);
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public ap b(w w2) {
        j.b(w2, "key");
        ap ap2 = this.b.b(w2);
        if (ap2 != null) {
            return ap2;
        }
        return this.c.b(w2);
    }

    @Override
    public boolean b() {
        return this.b.b() || this.c.b();
        {
        }
    }

    @Override
    public boolean c() {
        return this.b.c() || this.c.c();
        {
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final as a(as as2, as as3) {
            j.b(as2, "first");
            j.b(as3, "second");
            if (as2.a()) {
                return as3;
            }
            if (as3.a()) {
                return as2;
            }
            return new l(as2, as3, null);
        }
    }

}

