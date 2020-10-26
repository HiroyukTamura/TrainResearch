/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.e.f;

final class q {
    private final f a;
    private final String b;

    public q(f f2, String string2) {
        j.b(f2, "name");
        j.b(string2, "signature");
        this.a = f2;
        this.b = string2;
    }

    public final f a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof q)) break block3;
                object = (q)object;
                if (j.a((Object)this.a, (Object)((q)object).a) && j.a((Object)this.b, (Object)((q)object).b)) break block2;
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
        stringBuilder.append("NameAndSignature(name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

