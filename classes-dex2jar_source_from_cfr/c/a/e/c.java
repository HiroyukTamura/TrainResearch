/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import d.f;

public final class c {
    public static final f a = f.a(":");
    public static final f b = f.a(":status");
    public static final f c = f.a(":method");
    public static final f d = f.a(":path");
    public static final f e = f.a(":scheme");
    public static final f f = f.a(":authority");
    public final f g;
    public final f h;
    final int i;

    public c(f f2, f f3) {
        this.g = f2;
        this.h = f3;
        this.i = f2.g() + 32 + f3.g();
    }

    public c(f f2, String string2) {
        this(f2, f.a(string2));
    }

    public c(String string2, String string3) {
        this(f.a(string2), f.a(string3));
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof c;
        boolean bl4 = bl2 = false;
        if (bl3) {
            object = (c)object;
            bl4 = bl2;
            if (this.g.equals(((c)object).g)) {
                bl4 = bl2;
                if (this.h.equals(((c)object).h)) {
                    bl4 = true;
                }
            }
        }
        return bl4;
    }

    public int hashCode() {
        return (527 + this.g.hashCode()) * 31 + this.h.hashCode();
    }

    public String toString() {
        return c.a.c.a("%s: %s", new Object[]{this.g.a(), this.h.a()});
    }
}

