/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.d;
import kotlin.reflect.jvm.internal.impl.j.w;

final class p {
    private final w a;
    private final d b;

    public p(w w2, d d2) {
        j.b(w2, "type");
        this.a = w2;
        this.b = d2;
    }

    public final w a() {
        return this.a;
    }

    public final w b() {
        return this.a;
    }

    public final d c() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof p)) break block3;
                object = (p)object;
                if (j.a((Object)this.a, (Object)((p)object).a) && j.a((Object)this.b, (Object)((p)object).b)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object object = this.a;
        int n2 = 0;
        int n3 = object != null ? object.hashCode() : 0;
        object = this.b;
        if (object != null) {
            n2 = object.hashCode();
        }
        return n3 * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TypeAndDefaultQualifiers(type=");
        stringBuilder.append(this.a);
        stringBuilder.append(", defaultQualifiers=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

