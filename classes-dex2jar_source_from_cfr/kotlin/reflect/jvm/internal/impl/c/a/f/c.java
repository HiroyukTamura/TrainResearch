/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;

final class c<T> {
    private final T a;
    private final h b;

    public c(T t2, h h2) {
        this.a = t2;
        this.b = h2;
    }

    public final T a() {
        return this.a;
    }

    public final h b() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof c)) break block3;
                object = (c)object;
                if (j.a(this.a, ((c)object).a) && j.a((Object)this.b, (Object)((c)object).b)) break block2;
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
        stringBuilder.append("EnhancementResult(result=");
        stringBuilder.append(this.a);
        stringBuilder.append(", enhancementAnnotations=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

