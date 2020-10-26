/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.e.g.a;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public final class g
extends a
implements Callable<Void> {
    public g(Runnable runnable) {
        super(runnable);
    }

    public Void b() {
        this.b = Thread.currentThread();
        try {
            this.a.run();
            return null;
        }
        finally {
            this.lazySet(c);
            this.b = null;
        }
    }

    @Override
    public /* synthetic */ Object call() {
        return this.b();
    }
}

