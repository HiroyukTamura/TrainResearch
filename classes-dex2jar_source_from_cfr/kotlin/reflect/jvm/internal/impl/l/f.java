/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import kotlin.e.b.j;

public final class f {
    private final String a;
    private final int b;

    public f(String string2, int n2) {
        j.b(string2, "number");
        this.a = string2;
        this.b = n2;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof f) {
                boolean bl2;
                object = (f)object;
                if (j.a((Object)this.a, (Object)((f)object).a) && (bl2 = this.b == ((f)object).b)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String string2 = this.a;
        int n2 = string2 != null ? string2.hashCode() : 0;
        return n2 * 31 + this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NumberWithRadix(number=");
        stringBuilder.append(this.a);
        stringBuilder.append(", radix=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

