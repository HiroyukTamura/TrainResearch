/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.a;

import b.a.b.b;
import b.a.e.c.a;
import b.a.g;

public enum c implements a<Object>
{
    a,
    b;
    

    public static void a(g<?> g2) {
        g2.a(a);
        g2.b_();
    }

    @Override
    public int a(int n2) {
        return n2 & 2;
    }

    @Override
    public void a() {
    }

    @Override
    public boolean a(Object object) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override
    public Object b() {
        return null;
    }

    @Override
    public boolean c() {
        return true;
    }

    @Override
    public void d() {
    }
}

