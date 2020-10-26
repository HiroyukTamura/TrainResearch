/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.f;
import d.s;
import java.nio.channels.WritableByteChannel;

public interface d
extends s,
WritableByteChannel {
    public d b(String var1);

    public d b(String var1, int var2, int var3);

    public c c();

    public d c(byte[] var1);

    public d c(byte[] var1, int var2, int var3);

    public d d(f var1);

    @Override
    public void flush();

    public d g(int var1);

    public d h(int var1);

    public d i(int var1);

    public d l(long var1);

    public d m(long var1);

    public d v();
}

