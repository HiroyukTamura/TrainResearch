/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.c.a.f;
import kotlin.reflect.jvm.internal.impl.d.c.b;

public final class q {
    public static final a a = new a(null);
    private final String b;

    private q(String string2) {
        this.b = string2;
    }

    public /* synthetic */ q(String string2, g g2) {
        this(string2);
    }

    public final String a() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof q)) break block3;
                object = (q)object;
                if (j.a((Object)this.b, (Object)((q)object).b)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String string2 = this.b;
        if (string2 != null) {
            return string2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MemberSignature(signature=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final q a(String string2, String string3) {
            j.b(string2, "name");
            j.b(string3, "desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            return new q(stringBuilder.toString(), null);
        }

        public final q a(q q2, int n2) {
            j.b(q2, "signature");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(q2.a());
            stringBuilder.append("@");
            stringBuilder.append(n2);
            return new q(stringBuilder.toString(), null);
        }

        public final q a(c c2, b.c c3) {
            j.b(c2, "nameResolver");
            j.b(c3, "signature");
            return this.a(c2.a(c3.e()), c2.a(c3.g()));
        }

        public final q a(f f2) {
            j.b(f2, "signature");
            if (f2 instanceof f.b) {
                return this.a(f2.a(), f2.b());
            }
            if (f2 instanceof f.a) {
                return this.b(f2.a(), f2.b());
            }
            throw new m();
        }

        public final q b(String string2, String string3) {
            j.b(string2, "name");
            j.b(string3, "desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("#");
            stringBuilder.append(string3);
            return new q(stringBuilder.toString(), null);
        }
    }

}

