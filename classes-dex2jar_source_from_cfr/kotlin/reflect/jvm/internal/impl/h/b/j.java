/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.h.b.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.w;

public abstract class j
extends f<w> {
    public static final a a = new a(null);

    public j() {
        super(w.a);
    }

    @Override
    public /* synthetic */ Object a() {
        return this.b();
    }

    public w b() {
        throw (Throwable)new UnsupportedOperationException();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final j a(String string2) {
            kotlin.e.b.j.b(string2, "message");
            return new b(string2);
        }
    }

    public static final class b
    extends j {
        private final String b;

        public b(String string2) {
            kotlin.e.b.j.b(string2, "message");
            this.b = string2;
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.j.w a(y y2) {
            return this.b(y2);
        }

        public ad b(y y2) {
            kotlin.e.b.j.b(y2, "module");
            return p.c(this.b);
        }

        @Override
        public String toString() {
            return this.b;
        }
    }

}

