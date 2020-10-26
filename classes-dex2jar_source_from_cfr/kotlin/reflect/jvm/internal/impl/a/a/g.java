/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.e;

public final class g {
    private final c a;
    private final e b;

    public g(c c2, e e2) {
        j.b(c2, "annotation");
        this.a = c2;
        this.b = e2;
    }

    public final c a() {
        return this.a;
    }

    public final e b() {
        return this.b;
    }

    public final c c() {
        return this.a;
    }

    public final e d() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof g)) break block3;
                object = (g)object;
                if (j.a((Object)this.a, (Object)((g)object).a) && j.a((Object)this.b, (Object)((g)object).b)) break block2;
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
        stringBuilder.append("AnnotationWithTarget(annotation=");
        stringBuilder.append(this.a);
        stringBuilder.append(", target=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

