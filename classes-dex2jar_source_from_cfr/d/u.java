/*
 * Decompiled with CFR 0.139.
 */
package d;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class u {
    public static final u c = new u(){

        @Override
        public u a(long l2) {
            return this;
        }

        @Override
        public u a(long l2, TimeUnit timeUnit) {
            return this;
        }

        @Override
        public void g() {
        }
    };
    private boolean a;
    private long b;
    private long d;

    public u a(long l2) {
        this.a = true;
        this.b = l2;
        return this;
    }

    public u a(long l2, TimeUnit object) {
        if (l2 >= 0L) {
            if (object != null) {
                this.d = ((TimeUnit)((Object)object)).toNanos(l2);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("timeout < 0: ");
        ((StringBuilder)object).append(l2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public long d() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public u f() {
        this.a = false;
        return this;
    }

    public void g() {
        if (!Thread.interrupted()) {
            if (this.a) {
                if (this.b - System.nanoTime() > 0L) {
                    return;
                }
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public long u_() {
        return this.d;
    }

    public boolean v_() {
        return this.a;
    }

    public u w_() {
        this.d = 0L;
        return this;
    }

}

