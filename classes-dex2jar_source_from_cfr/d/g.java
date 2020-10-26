/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.s;
import d.u;

public abstract class g
implements s {
    private final s a;

    public g(s s2) {
        if (s2 != null) {
            this.a = s2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override
    public u a() {
        return this.a.a();
    }

    @Override
    public void a_(c c2, long l2) {
        this.a.a_(c2, l2);
    }

    @Override
    public void close() {
        this.a.close();
    }

    @Override
    public void flush() {
        this.a.flush();
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

