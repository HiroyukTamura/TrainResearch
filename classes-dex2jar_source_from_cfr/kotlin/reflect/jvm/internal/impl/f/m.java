/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.s;

public class m {
    protected volatile q a;
    private d b;
    private g c;
    private volatile boolean d;

    public q a(q q2) {
        this.c(q2);
        return this.a;
    }

    public int b() {
        if (this.d) {
            return this.a.i();
        }
        return this.b.a();
    }

    public q b(q q2) {
        q q3 = this.a;
        this.a = q2;
        this.b = null;
        this.d = true;
        return q3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void c(q q2) {
        if (this.a != null) {
            return;
        }
        synchronized (this) {
            if (this.a != null) {
                return;
            }
            q q3 = q2;
            try {
                if (this.b != null) {
                    q3 = q2.c().c(this.b, this.c);
                }
                this.a = q3;
            }
            catch (IOException iOException) {}
            return;
        }
    }
}

