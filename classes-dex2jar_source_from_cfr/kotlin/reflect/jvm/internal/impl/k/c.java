/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import kotlin.e.b.g;
import kotlin.e.b.j;

public abstract class c {
    private final boolean a;

    private c(boolean bl2) {
        this.a = bl2;
    }

    public /* synthetic */ c(boolean bl2, g g2) {
        this(bl2);
    }

    public final boolean a() {
        return this.a;
    }

    public static final class a
    extends c {
        public static final a a = new a();

        private a() {
            super(false, null);
        }
    }

    public static final class b
    extends c {
        private final String a;

        public b(String string2) {
            j.b(string2, "error");
            super(false, null);
            this.a = string2;
        }
    }

    public static final class c
    extends c {
        public static final c a = new c();

        private c() {
            super(true, null);
        }
    }

}

