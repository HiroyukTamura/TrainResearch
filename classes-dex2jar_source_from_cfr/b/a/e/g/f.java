/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class f
extends AtomicLong
implements ThreadFactory {
    final String a;
    final int b;
    final boolean c;

    public f(String string2) {
        this(string2, 5, false);
    }

    public f(String string2, int n2) {
        this(string2, n2, false);
    }

    public f(String string2, int n2, boolean bl2) {
        this.a = string2;
        this.b = n2;
        this.c = bl2;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder(this.a);
        charSequence.append('-');
        charSequence.append(this.incrementAndGet());
        charSequence = charSequence.toString();
        runnable = this.c ? new a(runnable, (String)charSequence) : new Thread(runnable, (String)charSequence);
        ((Thread)runnable).setPriority(this.b);
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxThreadFactory[");
        stringBuilder.append(this.a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static final class a
    extends Thread {
        a(Runnable runnable, String string2) {
            super(runnable, string2);
        }
    }

}

