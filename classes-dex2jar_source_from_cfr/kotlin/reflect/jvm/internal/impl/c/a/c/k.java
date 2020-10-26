/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import java.util.Collection;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.a;
import kotlin.reflect.jvm.internal.impl.c.a.f.h;

public final class k {
    private final h a;
    private final Collection<a.a> b;

    public k(h h2, Collection<? extends a.a> collection) {
        j.b(h2, "nullabilityQualifier");
        j.b(collection, "qualifierApplicabilityTypes");
        this.a = h2;
        this.b = collection;
    }

    public final h a() {
        return this.a;
    }

    public final Collection<a.a> b() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof k)) break block3;
                object = (k)object;
                if (j.a((Object)this.a, (Object)((k)object).a) && j.a(this.b, ((k)object).b)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Collection<a.a> collection = this.a;
        int n2 = 0;
        int n3 = collection != null ? ((Object)collection).hashCode() : 0;
        collection = this.b;
        if (collection != null) {
            n2 = ((Object)collection).hashCode();
        }
        return n3 * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NullabilityQualifierWithApplicability(nullabilityQualifier=");
        stringBuilder.append(this.a);
        stringBuilder.append(", qualifierApplicabilityTypes=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

