/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.e.g.e;
import b.a.e.g.f;
import b.a.h;
import java.util.concurrent.ThreadFactory;

public final class d
extends h {
    private static final f c = new f("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5))));
    final ThreadFactory b;

    public d() {
        this(c);
    }

    public d(ThreadFactory threadFactory) {
        this.b = threadFactory;
    }

    @Override
    public h.b a() {
        return new e(this.b);
    }
}

