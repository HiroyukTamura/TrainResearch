/*
 * Decompiled with CFR 0.139.
 */
package b.a.b;

import b.a.b.b;
import java.util.concurrent.atomic.AtomicReference;

abstract class d<T>
extends AtomicReference<T>
implements b {
    d(T t2) {
        super(b.a.e.b.b.a(t2, "value is null"));
    }

    @Override
    public final void a() {
        T t2;
        if (this.get() != null && (t2 = this.getAndSet(null)) != null) {
            this.a(t2);
        }
    }

    protected abstract void a(T var1);

    public final boolean b() {
        return this.get() == null;
    }
}
