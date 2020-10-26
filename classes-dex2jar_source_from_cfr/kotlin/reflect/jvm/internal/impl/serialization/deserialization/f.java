/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;

public final class f {
    private final c a;
    private final a.c b;
    private final kotlin.reflect.jvm.internal.impl.d.b.a c;
    private final an d;

    public f(c c2, a.c c3, kotlin.reflect.jvm.internal.impl.d.b.a a2, an an2) {
        j.b(c2, "nameResolver");
        j.b(c3, "classProto");
        j.b(a2, "metadataVersion");
        j.b(an2, "sourceElement");
        this.a = c2;
        this.b = c3;
        this.c = a2;
        this.d = an2;
    }

    public final c a() {
        return this.a;
    }

    public final a.c b() {
        return this.b;
    }

    public final kotlin.reflect.jvm.internal.impl.d.b.a c() {
        return this.c;
    }

    public final an d() {
        return this.d;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof f)) break block3;
                object = (f)object;
                if (j.a((Object)this.a, (Object)((f)object).a) && j.a((Object)this.b, (Object)((f)object).b) && j.a((Object)this.c, (Object)((f)object).c) && j.a((Object)this.d, (Object)((f)object).d)) break block2;
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
        int n4 = object != null ? object.hashCode() : 0;
        object = this.c;
        int n5 = object != null ? object.hashCode() : 0;
        object = this.d;
        if (object != null) {
            n2 = object.hashCode();
        }
        return ((n3 * 31 + n4) * 31 + n5) * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassData(nameResolver=");
        stringBuilder.append(this.a);
        stringBuilder.append(", classProto=");
        stringBuilder.append(this.b);
        stringBuilder.append(", metadataVersion=");
        stringBuilder.append(this.c);
        stringBuilder.append(", sourceElement=");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

