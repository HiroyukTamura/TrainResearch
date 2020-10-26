/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class aq
implements ap {
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ap)) {
            return false;
        }
        object = (ap)object;
        if (this.a() != object.a()) {
            return false;
        }
        if (this.b() != object.b()) {
            return false;
        }
        return this.c().equals(object.c());
    }

    public int hashCode() {
        int n2 = this.b().hashCode();
        int n3 = this.a() ? 17 : this.c().hashCode();
        return n2 * 31 + n3;
    }

    public String toString() {
        if (this.a()) {
            return "*";
        }
        if (this.b() == ba.a) {
            return this.c().toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.b());
        stringBuilder.append(" ");
        stringBuilder.append(this.c());
        return stringBuilder.toString();
    }
}

