/*
 * Decompiled with CFR 0.139.
 */
package a.a;

import a.a.b;
import a.a.e;
import a.b.c;
import java.util.Map;
import javax.a.a;

public final class f<T>
implements c<e<T>> {
    private final a<Map<Class<? extends T>, a<b.b<? extends T>>>> a;

    public static <T> e<T> a(Map<Class<? extends T>, a<b.b<? extends T>>> map) {
        return new e<T>(map);
    }

    public static <T> e<T> a(a<Map<Class<? extends T>, a<b.b<? extends T>>>> a2) {
        return new e<T>(a2.b());
    }

    public e<T> a() {
        return f.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

