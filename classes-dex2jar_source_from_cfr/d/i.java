/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.u;
import java.util.concurrent.TimeUnit;

public class i
extends u {
    private u a;

    public i(u u2) {
        if (u2 != null) {
            this.a = u2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final i a(u u2) {
        if (u2 != null) {
            this.a = u2;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final u a() {
        return this.a;
    }

    @Override
    public u a(long l2) {
        return this.a.a(l2);
    }

    @Override
    public u a(long l2, TimeUnit timeUnit) {
        return this.a.a(l2, timeUnit);
    }

    @Override
    public long d() {
        return this.a.d();
    }

    @Override
    public u f() {
        return this.a.f();
    }

    @Override
    public void g() {
        this.a.g();
    }

    @Override
    public long u_() {
        return this.a.u_();
    }

    @Override
    public boolean v_() {
        return this.a.v_();
    }

    @Override
    public u w_() {
        return this.a.w_();
    }
}

