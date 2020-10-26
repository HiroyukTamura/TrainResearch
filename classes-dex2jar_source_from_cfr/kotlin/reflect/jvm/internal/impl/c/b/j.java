/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.c.b.l;

public abstract class j {
    private j() {
    }

    public /* synthetic */ j(g g2) {
        this();
    }

    public String toString() {
        return l.a.b(this);
    }

    public static final class a
    extends j {
        private final j a;

        public a(j j2) {
            kotlin.e.b.j.b(j2, "elementType");
            super(null);
            this.a = j2;
        }

        public final j a() {
            return this.a;
        }
    }

    public static final class b
    extends j {
        private final String a;

        public b(String string2) {
            kotlin.e.b.j.b(string2, "internalName");
            super(null);
            this.a = string2;
        }

        public final String a() {
            return this.a;
        }
    }

    public static final class c
    extends j {
        private final kotlin.reflect.jvm.internal.impl.h.d.c a;

        public c(kotlin.reflect.jvm.internal.impl.h.d.c c2) {
            super(null);
            this.a = c2;
        }

        public final kotlin.reflect.jvm.internal.impl.h.d.c a() {
            return this.a;
        }
    }

}

