/*
 * Decompiled with CFR 0.139.
 */
package b.a.c;

public final class d
extends RuntimeException {
    public d(Throwable throwable) {
        String string2 = throwable != null ? throwable.getMessage() : null;
        if (throwable == null) {
            throwable = new NullPointerException();
        }
        super(string2, throwable);
    }
}

