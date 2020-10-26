/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.t;
import d.u;

public abstract class h
implements t {
    private final t a;

    public h(t t2) {
        if (t2 != null) {
            this.a = t2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override
    public long a(c c2, long l2) {
        return this.a.a(c2, l2);
    }

    @Override
    public u a() {
        return this.a.a();
    }

    public final t b() {
        return this.a;
    }

    @Override
    public void close() {
        this.a.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.a.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

