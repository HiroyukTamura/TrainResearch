/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package d;

import d.q;
import javax.annotation.Nullable;

final class p {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    p f;
    p g;

    p() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    p(byte[] arrby, int n2, int n3, boolean bl2, boolean bl3) {
        this.a = arrby;
        this.b = n2;
        this.c = n3;
        this.d = bl2;
        this.e = bl3;
    }

    final p a() {
        this.d = true;
        return new p(this.a, this.b, this.c, true, false);
    }

    public final p a(int n2) {
        if (n2 > 0 && n2 <= this.c - this.b) {
            p p2;
            if (n2 >= 1024) {
                p2 = this.a();
            } else {
                p2 = q.a();
                System.arraycopy(this.a, this.b, p2.a, 0, n2);
            }
            p2.c = p2.b + n2;
            this.b += n2;
            this.g.a(p2);
            return p2;
        }
        throw new IllegalArgumentException();
    }

    public final p a(p p2) {
        p2.g = this;
        p2.f = this.f;
        this.f.g = p2;
        this.f = p2;
        return p2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void a(p p2, int n2) {
        if (!p2.e) throw new IllegalArgumentException();
        if (p2.c + n2 > 8192) {
            if (p2.d) throw new IllegalArgumentException();
            if (p2.c + n2 - p2.b > 8192) throw new IllegalArgumentException();
            System.arraycopy(p2.a, p2.b, p2.a, 0, p2.c - p2.b);
            p2.c -= p2.b;
            p2.b = 0;
        }
        System.arraycopy(this.a, this.b, p2.a, p2.c, n2);
        p2.c += n2;
        this.b += n2;
    }

    @Nullable
    public final p b() {
        p p2 = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return p2;
    }

    public final void c() {
        if (this.g != this) {
            if (!this.g.e) {
                return;
            }
            int n2 = this.c - this.b;
            int n3 = this.g.c;
            int n4 = this.g.d ? 0 : this.g.b;
            if (n2 > 8192 - n3 + n4) {
                return;
            }
            this.a(this.g, n2);
            this.b();
            q.a(this);
            return;
        }
        throw new IllegalStateException();
    }
}

