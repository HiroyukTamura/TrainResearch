/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;

public abstract class w {
    private final c a;
    private final h b;
    private final an c;

    private w(c c2, h h2, an an2) {
        this.a = c2;
        this.b = h2;
        this.c = an2;
    }

    public /* synthetic */ w(c c2, h h2, an an2, g g2) {
        this(c2, h2, an2);
    }

    public abstract kotlin.reflect.jvm.internal.impl.e.b a();

    public final c b() {
        return this.a;
    }

    public final h c() {
        return this.b;
    }

    public final an d() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a());
        return stringBuilder.toString();
    }

    public static final class a
    extends w {
        private final kotlin.reflect.jvm.internal.impl.e.a a;
        private final a.c.b b;
        private final boolean c;
        private final a.c d;
        private final a e;

        public a(a.c object, c c2, h h2, an an2, a a2) {
            j.b(object, "classProto");
            j.b(c2, "nameResolver");
            j.b(h2, "typeTable");
            super(c2, h2, an2, null);
            this.d = object;
            this.e = a2;
            this.a = u.a(c2, this.d.g());
            object = kotlin.reflect.jvm.internal.impl.d.b.b.e.b(this.d.e());
            if (object == null) {
                object = a.c.b.a;
            }
            this.b = object;
            object = kotlin.reflect.jvm.internal.impl.d.b.b.f.a(this.d.e());
            j.a(object, "Flags.IS_INNER.get(classProto.flags)");
            this.c = (Boolean)object;
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.e.b a() {
            kotlin.reflect.jvm.internal.impl.e.b b2 = this.a.g();
            j.a((Object)b2, "classId.asSingleFqName()");
            return b2;
        }

        public final kotlin.reflect.jvm.internal.impl.e.a e() {
            return this.a;
        }

        public final a.c.b f() {
            return this.b;
        }

        public final boolean g() {
            return this.c;
        }

        public final a.c h() {
            return this.d;
        }

        public final a i() {
            return this.e;
        }
    }

    public static final class b
    extends w {
        private final kotlin.reflect.jvm.internal.impl.e.b a;

        public b(kotlin.reflect.jvm.internal.impl.e.b b2, c c2, h h2, an an2) {
            j.b(b2, "fqName");
            j.b(c2, "nameResolver");
            j.b(h2, "typeTable");
            super(c2, h2, an2, null);
            this.a = b2;
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.e.b a() {
            return this.a;
        }
    }

}

