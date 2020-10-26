/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.f;
import d.m;
import d.s;
import d.t;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface e
extends t,
ReadableByteChannel {
    public int a(m var1);

    public long a(byte var1);

    public long a(s var1);

    public String a(Charset var1);

    public void a(long var1);

    public void a(byte[] var1);

    public boolean a(long var1, f var3);

    public long b(f var1);

    public boolean b(long var1);

    public long c(f var1);

    @Deprecated
    public c c();

    public c d();

    public f d(long var1);

    public String f(long var1);

    public boolean f();

    public InputStream g();

    public byte[] h(long var1);

    public byte i();

    public void i(long var1);

    public short j();

    public int k();

    public short l();

    public int m();

    public long n();

    public String p();

    public String q();
}

