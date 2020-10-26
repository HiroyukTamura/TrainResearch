/*
 * Decompiled with CFR 0.139.
 */
package c;

import c.a.a.d;
import c.a.a.e;
import java.io.Closeable;
import java.io.Flushable;

public final class c
implements Closeable,
Flushable {
    final e a;
    final d b;

    @Override
    public void close() {
        this.b.close();
    }

    @Override
    public void flush() {
        this.b.flush();
    }
}

