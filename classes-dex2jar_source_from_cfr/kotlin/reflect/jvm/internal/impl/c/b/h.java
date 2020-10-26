/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.c.b.k;
import kotlin.reflect.jvm.internal.impl.e.f;

public class h<T> {
    private int a;
    private T b;
    private final k<T> c;

    public void a() {
        if (this.b == null) {
            ++this.a;
            int n2 = this.a;
        }
    }

    public void a(T t2) {
        j.b(t2, "objectType");
        this.b(t2);
    }

    public void a(f f2, T t2) {
        j.b(f2, "name");
        j.b(t2, "type");
        this.b(t2);
    }

    public void b() {
    }

    protected final void b(T t2) {
        j.b(t2, "type");
        if (this.b == null) {
            k<T> k2 = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n.a("[", this.a));
            stringBuilder.append(this.c.b(t2));
            this.b = k2.a(stringBuilder.toString());
        }
    }
}

