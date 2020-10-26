/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.e.a;

public final class r<T extends kotlin.reflect.jvm.internal.impl.d.b.a> {
    private final T a;
    private final T b;
    private final String c;
    private final a d;

    public r(T t2, T t3, String string2, a a2) {
        j.b(t2, "actualVersion");
        j.b(t3, "expectedVersion");
        j.b(string2, "filePath");
        j.b(a2, "classId");
        this.a = t2;
        this.b = t3;
        this.c = string2;
        this.d = a2;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof r)) break block3;
                object = (r)object;
                if (j.a(this.a, ((r)object).a) && j.a(this.b, ((r)object).b) && j.a((Object)this.c, (Object)((r)object).c) && j.a((Object)this.d, (Object)((r)object).d)) break block2;
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
        stringBuilder.append("IncompatibleVersionErrorData(actualVersion=");
        stringBuilder.append(this.a);
        stringBuilder.append(", expectedVersion=");
        stringBuilder.append(this.b);
        stringBuilder.append(", filePath=");
        stringBuilder.append(this.c);
        stringBuilder.append(", classId=");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

