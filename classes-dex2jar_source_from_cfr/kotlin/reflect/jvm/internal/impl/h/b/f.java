/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class f<T> {
    private final T a;

    public f(T t2) {
        this.a = t2;
    }

    public T a() {
        return this.a;
    }

    public abstract w a(y var1);

    public boolean equals(Object object) {
        if (this != object) {
            T t2 = this.a();
            boolean bl2 = object instanceof f;
            Object var3_4 = null;
            if (!bl2) {
                object = null;
            }
            f f2 = (f)object;
            object = var3_4;
            if (f2 != null) {
                object = f2.a();
            }
            if (!j.a(t2, object)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        T t2 = this.a();
        if (t2 != null) {
            return t2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(this.a());
    }
}

