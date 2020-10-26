/*
 * Decompiled with CFR 0.139.
 */
package c.a;

import c.a.c;

public abstract class b
implements Runnable {
    protected final String b;

    public /* varargs */ b(String string2, Object ... arrobject) {
        this.b = c.a(string2, arrobject);
    }

    protected abstract void c();

    @Override
    public final void run() {
        String string2 = Thread.currentThread().getName();
        Thread.currentThread().setName(this.b);
        try {
            this.c();
            return;
        }
        finally {
            Thread.currentThread().setName(string2);
        }
    }
}

