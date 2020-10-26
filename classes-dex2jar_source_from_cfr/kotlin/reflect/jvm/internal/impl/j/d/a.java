/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.d;

import kotlin.e.b.j;

public final class a<T> {
    private final T a;
    private final T b;

    public a(T t2, T t3) {
        this.a = t2;
        this.b = t3;
    }

    public final T a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final T c() {
        return this.a;
    }

    public final T d() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof a)) break block3;
                object = (a)object;
                if (j.a(this.a, ((a)object).a) && j.a(this.b, ((a)object).b)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t2 = this.a;
        int n2 = 0;
        int n3 = t2 != null ? t2.hashCode() : 0;
        t2 = this.b;
        if (t2 != null) {
            n2 = t2.hashCode();
        }
        return n3 * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApproximationBounds(lower=");
        stringBuilder.append(this.a);
        stringBuilder.append(", upper=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

