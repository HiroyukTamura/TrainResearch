/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.d;
import d.f;
import d.s;
import d.u;
import d.v;
import java.nio.ByteBuffer;

final class n
implements d {
    public final c a = new c();
    public final s b;
    boolean c;

    n(s s2) {
        if (s2 != null) {
            this.b = s2;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override
    public u a() {
        return this.b.a();
    }

    @Override
    public void a_(c c2, long l2) {
        if (!this.c) {
            this.a.a_(c2, l2);
            this.v();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d b(String string2) {
        if (!this.c) {
            this.a.a(string2);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d b(String string2, int n2, int n3) {
        if (!this.c) {
            this.a.a(string2, n2, n3);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public c c() {
        return this.a;
    }

    @Override
    public d c(byte[] arrby) {
        if (!this.c) {
            this.a.b(arrby);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d c(byte[] arrby, int n2, int n3) {
        if (!this.c) {
            this.a.b(arrby, n2, n3);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public void close() {
        Throwable throwable;
        block7 : {
            if (this.c) {
                return;
            }
            Throwable throwable2 = throwable = null;
            try {
                if (this.a.b > 0L) {
                    this.b.a_(this.a, this.a.b);
                    throwable2 = throwable;
                }
            }
            catch (Throwable throwable3) {
                // empty catch block
            }
            try {
                this.b.close();
                throwable = throwable2;
            }
            catch (Throwable throwable4) {
                throwable = throwable2;
                if (throwable2 != null) break block7;
                throwable = throwable4;
            }
        }
        this.c = true;
        if (throwable != null) {
            v.a(throwable);
        }
    }

    @Override
    public d d(f f2) {
        if (!this.c) {
            this.a.a(f2);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public void flush() {
        if (!this.c) {
            if (this.a.b > 0L) {
                this.b.a_(this.a, this.a.b);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d g(int n2) {
        if (!this.c) {
            this.a.d(n2);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d h(int n2) {
        if (!this.c) {
            this.a.c(n2);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d i(int n2) {
        if (!this.c) {
            this.a.b(n2);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public boolean isOpen() {
        return this.c ^ true;
    }

    @Override
    public d l(long l2) {
        if (!this.c) {
            this.a.k(l2);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public d m(long l2) {
        if (!this.c) {
            this.a.j(l2);
            return this.v();
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public d v() {
        if (!this.c) {
            long l2 = this.a.h();
            if (l2 > 0L) {
                this.b.a_(this.a, l2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        if (!this.c) {
            int n2 = this.a.write(byteBuffer);
            this.v();
            return n2;
        }
        throw new IllegalStateException("closed");
    }
}

