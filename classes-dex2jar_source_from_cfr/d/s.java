/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.u;
import java.io.Closeable;
import java.io.Flushable;

public interface s
extends Closeable,
Flushable {
    public u a();

    public void a_(c var1, long var2);

    @Override
    public void close();

    @Override
    public void flush();
}

