/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.c;
import d.e;
import d.p;
import d.q;
import d.t;
import d.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k
implements t {
    private final e a;
    private final Inflater b;
    private int c;
    private boolean d;

    k(e e2, Inflater inflater) {
        if (e2 != null) {
            if (inflater != null) {
                this.a = e2;
                this.b = inflater;
                return;
            }
            throw new IllegalArgumentException("inflater == null");
        }
        throw new IllegalArgumentException("source == null");
    }

    private void c() {
        if (this.c == 0) {
            return;
        }
        int n2 = this.c - this.b.getRemaining();
        this.c -= n2;
        this.a.i(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public long a(c object, long l2) {
        boolean bl2;
        long l3 = l2 LCMP 0L;
        if (l3 < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("byteCount < 0: ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (l3 == false) {
            return 0L;
        }
        do {
            bl2 = this.b();
            try {
                p p2 = ((c)object).e(1);
                l3 = (int)Math.min(l2, (long)(8192 - p2.c));
                l3 = this.b.inflate(p2.a, p2.c, (int)l3);
                if (l3 > 0) {
                    p2.c += l3;
                    l2 = ((c)object).b;
                    long l4 = l3;
                    ((c)object).b = l2 + l4;
                    return l4;
                }
                if (this.b.finished() || this.b.needsDictionary()) {
                    this.c();
                    if (p2.b == p2.c) {
                        ((c)object).a = p2.b();
                        q.a(p2);
                    }
                    return -1L;
                }
            }
            catch (DataFormatException dataFormatException) {
                throw new IOException(dataFormatException);
            }
        } while (!bl2);
        throw new EOFException("source exhausted prematurely");
    }

    @Override
    public u a() {
        return this.a.a();
    }

    public final boolean b() {
        if (!this.b.needsInput()) {
            return false;
        }
        this.c();
        if (this.b.getRemaining() == 0) {
            if (this.a.f()) {
                return true;
            }
            p p2 = this.a.c().a;
            this.c = p2.c - p2.b;
            this.b.setInput(p2.a, p2.b, this.c);
            return false;
        }
        throw new IllegalStateException("?");
    }

    @Override
    public void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }
}

