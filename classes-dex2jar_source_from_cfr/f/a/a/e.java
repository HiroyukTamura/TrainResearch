/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f.a.a;

import f.m;
import javax.annotation.Nullable;

public final class e<T> {
    @Nullable
    private final m<T> a;
    @Nullable
    private final Throwable b;

    private e(@Nullable m<T> m2, @Nullable Throwable throwable) {
        this.a = m2;
        this.b = throwable;
    }

    public static <T> e<T> a(m<T> m2) {
        if (m2 != null) {
            return new e<T>(m2, null);
        }
        throw new NullPointerException("response == null");
    }

    public static <T> e<T> a(Throwable throwable) {
        if (throwable != null) {
            return new e<T>(null, throwable);
        }
        throw new NullPointerException("error == null");
    }
}

