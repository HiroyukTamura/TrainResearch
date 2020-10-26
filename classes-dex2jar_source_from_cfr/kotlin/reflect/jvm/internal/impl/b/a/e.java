/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.b.a;

import java.io.Serializable;
import kotlin.e.b.g;

public final class e
implements Serializable {
    public static final a a = new a(null);
    private static final e d = new e(-1, -1);
    private final int b;
    private final int c;

    public e(int n2, int n3) {
        this.b = n2;
        this.c = n3;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof e) {
                object = (e)object;
                boolean bl2 = this.b == ((e)object).b;
                if (bl2 && (bl2 = this.c == ((e)object).c)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.b * 31 + this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position(line=");
        stringBuilder.append(this.b);
        stringBuilder.append(", column=");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final e a() {
            return d;
        }
    }

}

