/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import c.ac;
import c.ad;
import f.p;
import javax.annotation.Nullable;

public final class m<T> {
    private final ac a;
    @Nullable
    private final T b;
    @Nullable
    private final ad c;

    private m(ac ac2, @Nullable T t2, @Nullable ad ad2) {
        this.a = ac2;
        this.b = t2;
        this.c = ad2;
    }

    public static <T> m<T> a(ad ad2, ac ac2) {
        p.a(ad2, "body == null");
        p.a(ac2, "rawResponse == null");
        if (!ac2.c()) {
            return new m<Object>(ac2, null, ad2);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> m<T> a(@Nullable T t2, ac ac2) {
        p.a(ac2, "rawResponse == null");
        if (ac2.c()) {
            return new m<T>(ac2, t2, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public int a() {
        return this.a.b();
    }

    public String b() {
        return this.a.d();
    }

    public boolean c() {
        return this.a.c();
    }

    @Nullable
    public T d() {
        return this.b;
    }

    public String toString() {
        return this.a.toString();
    }
}

