/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.h;

public final class a {
    public static final Throwable a = new a();

    public static RuntimeException a(Throwable throwable) {
        if (!(throwable instanceof Error)) {
            if (throwable instanceof RuntimeException) {
                return (RuntimeException)throwable;
            }
            return new RuntimeException(throwable);
        }
        throw (Error)throwable;
    }

    static final class a
    extends Throwable {
        a() {
            super("No further exceptions");
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

}
