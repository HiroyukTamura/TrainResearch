/*
 * Decompiled with CFR 0.139.
 */
package b.a.b;

import b.a.b.d;

final class e
extends d<Runnable> {
    e(Runnable runnable) {
        super(runnable);
    }

    @Override
    protected void a(Runnable runnable) {
        runnable.run();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnableDisposable(disposed=");
        stringBuilder.append(this.b());
        stringBuilder.append(", ");
        stringBuilder.append(this.get());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

