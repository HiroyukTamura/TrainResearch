/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c.a.c;

import c.ad;
import c.v;
import d.e;
import javax.annotation.Nullable;

public final class h
extends ad {
    @Nullable
    private final String a;
    private final long b;
    private final e c;

    public h(@Nullable String string2, long l2, e e2) {
        this.a = string2;
        this.b = l2;
        this.c = e2;
    }

    @Override
    public v a() {
        if (this.a != null) {
            return v.a(this.a);
        }
        return null;
    }

    @Override
    public long b() {
        return this.b;
    }

    @Override
    public e d() {
        return this.c;
    }
}

