/*
 * Decompiled with CFR 0.139.
 */
package c.a.d;

import c.a.b.g;
import c.a.c.h;
import c.a.c.i;
import c.a.c.k;
import c.aa;
import c.ac;
import c.ad;
import c.ae;
import c.m;
import c.p;
import c.s;
import c.t;
import c.x;
import c.y;
import d.l;
import d.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class a
implements c.a.c.c {
    final x a;
    final g b;
    final d.e c;
    final d.d d;
    int e = 0;
    private long f = 262144L;

    public a(x x2, g g2, d.e e2, d.d d2) {
        this.a = x2;
        this.b = g2;
        this.c = e2;
        this.d = d2;
    }

    private String g() {
        String string2 = this.c.f(this.f);
        this.f -= (long)string2.length();
        return string2;
    }

    @Override
    public ac.a a(boolean bl2) {
        Object object;
        block7 : {
            k k2;
            block6 : {
                if (this.e != 1 && this.e != 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("state: ");
                    stringBuilder.append(this.e);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                try {
                    k2 = k.a(this.g());
                    object = new ac.a().a(k2.a).a(k2.b).a(k2.c).a(this.d());
                    if (!bl2) break block6;
                }
                catch (EOFException eOFException) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("unexpected end of stream on ");
                    ((StringBuilder)object).append(this.b);
                    object = new IOException(((StringBuilder)object).toString());
                    ((Throwable)object).initCause(eOFException);
                    throw object;
                }
                if (k2.b != 100) break block6;
                return null;
            }
            if (k2.b != 100) break block7;
            this.e = 3;
            return object;
        }
        this.e = 4;
        return object;
    }

    @Override
    public ad a(ac ac2) {
        this.b.c.f(this.b.b);
        String string2 = ac2.a("Content-Type");
        if (!c.a.c.e.b(ac2)) {
            return new h(string2, 0L, l.a(this.b(0L)));
        }
        if ("chunked".equalsIgnoreCase(ac2.a("Transfer-Encoding"))) {
            return new h(string2, -1L, l.a(this.a(ac2.a().a())));
        }
        long l2 = c.a.c.e.a(ac2);
        if (l2 != -1L) {
            return new h(string2, l2, l.a(this.b(l2)));
        }
        return new h(string2, -1L, l.a(this.f()));
    }

    public d.s a(long l2) {
        if (this.e == 1) {
            this.e = 2;
            return new d(l2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public d.s a(aa aa2, long l2) {
        if ("chunked".equalsIgnoreCase(aa2.a("Transfer-Encoding"))) {
            return this.e();
        }
        if (l2 != -1L) {
            return this.a(l2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public d.t a(t object) {
        if (this.e == 4) {
            this.e = 5;
            return new c((t)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("state: ");
        ((StringBuilder)object).append(this.e);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    @Override
    public void a() {
        this.d.flush();
    }

    @Override
    public void a(aa aa2) {
        String string2 = i.a(aa2, this.b.c().a().b().type());
        this.a(aa2.c(), string2);
    }

    public void a(s object, String string2) {
        if (this.e == 0) {
            this.d.b(string2).b("\r\n");
            int n2 = ((s)object).a();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.d.b(((s)object).a(i2)).b(": ").b(((s)object).b(i2)).b("\r\n");
            }
            this.d.b("\r\n");
            this.e = 1;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("state: ");
        ((StringBuilder)object).append(this.e);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    void a(d.i i2) {
        u u2 = i2.a();
        i2.a(u.c);
        u2.f();
        u2.w_();
    }

    public d.t b(long l2) {
        if (this.e == 4) {
            this.e = 5;
            return new e(l2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void b() {
        this.d.flush();
    }

    @Override
    public void c() {
        c.a.b.c c2 = this.b.c();
        if (c2 != null) {
            c2.b();
        }
    }

    public s d() {
        String string2;
        s.a a2 = new s.a();
        while ((string2 = this.g()).length() != 0) {
            c.a.a.a.a(a2, string2);
        }
        return a2.a();
    }

    public d.s e() {
        if (this.e == 1) {
            this.e = 2;
            return new b();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public d.t f() {
        if (this.e == 4) {
            if (this.b != null) {
                this.e = 5;
                this.b.e();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.e);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private abstract class a
    implements d.t {
        protected final d.i a;
        protected boolean b;
        protected long c;

        private a() {
            this.a = new d.i(a.this.c.a());
            this.c = 0L;
        }

        @Override
        public long a(d.c c2, long l2) {
            block3 : {
                try {
                    l2 = a.this.c.a(c2, l2);
                    if (l2 <= 0L) break block3;
                }
                catch (IOException iOException) {
                    this.a(false, iOException);
                    throw iOException;
                }
                this.c += l2;
            }
            return l2;
        }

        @Override
        public u a() {
            return this.a;
        }

        protected final void a(boolean bl2, IOException serializable) {
            if (a.this.e == 6) {
                return;
            }
            if (a.this.e == 5) {
                a.this.a(this.a);
                a.this.e = 6;
                if (a.this.b != null) {
                    a.this.b.a(bl2 ^ true, a.this, this.c, (IOException)serializable);
                }
                return;
            }
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("state: ");
            ((StringBuilder)serializable).append(a.this.e);
            throw new IllegalStateException(((StringBuilder)serializable).toString());
        }
    }

    private final class b
    implements d.s {
        private final d.i b;
        private boolean c;

        b() {
            this.b = new d.i(a.this.d.a());
        }

        @Override
        public u a() {
            return this.b;
        }

        @Override
        public void a_(d.c c2, long l2) {
            if (!this.c) {
                if (l2 == 0L) {
                    return;
                }
                a.this.d.l(l2);
                a.this.d.b("\r\n");
                a.this.d.a_(c2, l2);
                a.this.d.b("\r\n");
                return;
            }
            throw new IllegalStateException("closed");
        }

        @Override
        public void close() {
            synchronized (this) {
                block4 : {
                    boolean bl2 = this.c;
                    if (!bl2) break block4;
                    return;
                }
                this.c = true;
                a.this.d.b("0\r\n\r\n");
                a.this.a(this.b);
                a.this.e = 3;
                return;
            }
        }

        @Override
        public void flush() {
            synchronized (this) {
                block4 : {
                    boolean bl2 = this.c;
                    if (!bl2) break block4;
                    return;
                }
                a.this.d.flush();
                return;
            }
        }
    }

    private class c
    extends a {
        private final t f;
        private long g = -1L;
        private boolean h = true;

        c(t t2) {
            this.f = t2;
        }

        private void b() {
            String string2;
            block4 : {
                block5 : {
                    if (this.g != -1L) {
                        a.this.c.q();
                    }
                    try {
                        boolean bl2;
                        this.g = a.this.c.n();
                        string2 = a.this.c.q().trim();
                        if (this.g < 0L || !string2.isEmpty() && !(bl2 = string2.startsWith(";"))) break block4;
                        if (this.g != 0L) break block5;
                    }
                    catch (NumberFormatException numberFormatException) {
                        throw new ProtocolException(numberFormatException.getMessage());
                    }
                    this.h = false;
                    c.a.c.e.a(a.this.a.g(), this.f, a.this.d());
                    this.a(true, null);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected chunk size and optional extensions but was \"");
            stringBuilder.append(this.g);
            stringBuilder.append(string2);
            stringBuilder.append("\"");
            throw new ProtocolException(stringBuilder.toString());
        }

        @Override
        public long a(d.c object, long l2) {
            if (l2 >= 0L) {
                if (!this.b) {
                    if (!this.h) {
                        return -1L;
                    }
                    if (this.g == 0L || this.g == -1L) {
                        this.b();
                        if (!this.h) {
                            return -1L;
                        }
                    }
                    if ((l2 = super.a((d.c)object, Math.min(l2, this.g))) != -1L) {
                        this.g -= l2;
                        return l2;
                    }
                    object = new ProtocolException("unexpected end of stream");
                    this.a(false, (IOException)object);
                    throw object;
                }
                throw new IllegalStateException("closed");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("byteCount < 0: ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        @Override
        public void close() {
            if (this.b) {
                return;
            }
            if (this.h && !c.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.a(false, null);
            }
            this.b = true;
        }
    }

    private final class d
    implements d.s {
        private final d.i b;
        private boolean c;
        private long d;

        d(long l2) {
            this.b = new d.i(a.this.d.a());
            this.d = l2;
        }

        @Override
        public u a() {
            return this.b;
        }

        @Override
        public void a_(d.c object, long l2) {
            if (!this.c) {
                c.a.c.a(((d.c)object).b(), 0L, l2);
                if (l2 <= this.d) {
                    a.this.d.a_((d.c)object, l2);
                    this.d -= l2;
                    return;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("expected ");
                ((StringBuilder)object).append(this.d);
                ((StringBuilder)object).append(" bytes but received ");
                ((StringBuilder)object).append(l2);
                throw new ProtocolException(((StringBuilder)object).toString());
            }
            throw new IllegalStateException("closed");
        }

        @Override
        public void close() {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.d <= 0L) {
                a.this.a(this.b);
                a.this.e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override
        public void flush() {
            if (this.c) {
                return;
            }
            a.this.d.flush();
        }
    }

    private class e
    extends a {
        private long f;

        e(long l2) {
            this.f = l2;
            if (this.f == 0L) {
                this.a(true, null);
            }
        }

        @Override
        public long a(d.c object, long l2) {
            if (l2 >= 0L) {
                if (!this.b) {
                    if (this.f == 0L) {
                        return -1L;
                    }
                    if ((l2 = super.a((d.c)object, Math.min(this.f, l2))) != -1L) {
                        this.f -= l2;
                        if (this.f == 0L) {
                            this.a(true, null);
                        }
                        return l2;
                    }
                    object = new ProtocolException("unexpected end of stream");
                    this.a(false, (IOException)object);
                    throw object;
                }
                throw new IllegalStateException("closed");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("byteCount < 0: ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        @Override
        public void close() {
            if (this.b) {
                return;
            }
            if (this.f != 0L && !c.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.a(false, null);
            }
            this.b = true;
        }
    }

    private class f
    extends a {
        private boolean f;

        f() {
        }

        @Override
        public long a(d.c object, long l2) {
            if (l2 >= 0L) {
                if (!this.b) {
                    if (this.f) {
                        return -1L;
                    }
                    if ((l2 = super.a((d.c)object, l2)) == -1L) {
                        this.f = true;
                        this.a(true, null);
                        return -1L;
                    }
                    return l2;
                }
                throw new IllegalStateException("closed");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("byteCount < 0: ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        @Override
        public void close() {
            if (this.b) {
                return;
            }
            if (!this.f) {
                this.a(false, null);
            }
            this.b = true;
        }
    }

}

