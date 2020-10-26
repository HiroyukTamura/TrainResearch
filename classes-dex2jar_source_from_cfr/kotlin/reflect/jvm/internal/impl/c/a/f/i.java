/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.c.a.f.m;

public final class i {
    private static final kotlin.reflect.jvm.internal.impl.c.a.f.d a = new kotlin.reflect.jvm.internal.impl.c.a.f.d(kotlin.reflect.jvm.internal.impl.c.a.f.g.a, null, false, false, 8, null);
    private static final kotlin.reflect.jvm.internal.impl.c.a.f.d b = new kotlin.reflect.jvm.internal.impl.c.a.f.d(kotlin.reflect.jvm.internal.impl.c.a.f.g.b, null, false, false, 8, null);
    private static final kotlin.reflect.jvm.internal.impl.c.a.f.d c = new kotlin.reflect.jvm.internal.impl.c.a.f.d(kotlin.reflect.jvm.internal.impl.c.a.f.g.b, null, true, false, 8, null);
    private static final Map<String, kotlin.reflect.jvm.internal.impl.c.a.f.j> d;

    static {
        final kotlin.reflect.jvm.internal.impl.c.b.u u2 = kotlin.reflect.jvm.internal.impl.c.b.u.a;
        final String string2 = u2.a("Object");
        final String string3 = u2.c("Predicate");
        final String string4 = u2.c("Function");
        final String string5 = u2.c("Consumer");
        final String string6 = u2.c("BiFunction");
        final String string7 = u2.c("BiConsumer");
        final String string8 = u2.c("UnaryOperator");
        final String string9 = u2.b("stream/Stream");
        final String string10 = u2.b("Optional");
        kotlin.reflect.jvm.internal.impl.c.a.f.m m2 = new kotlin.reflect.jvm.internal.impl.c.a.f.m();
        new m.a(m2, u2.b("Iterator")).a("forEachRemaining", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string5, b, b);
            }
        });
        new m.a(m2, u2.a("Iterable")).a("spliterator", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.b(u2.b("Spliterator"), b, b);
            }
        });
        m.a a2 = new m.a(m2, u2.b("Collection"));
        a2.a("removeIf", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string3, b, b);
                a2.a(kotlin.reflect.jvm.internal.impl.h.d.c.a);
            }
        });
        a2.a("stream", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.b(string9, b, b);
            }
        });
        a2.a("parallelStream", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.b(string9, b, b);
            }
        });
        new m.a(m2, u2.b("List")).a("replaceAll", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string8, b, b);
            }
        });
        a2 = new m.a(m2, u2.b("Map"));
        a2.a("forEach", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string7, b, b, b);
            }
        });
        a2.a("putIfAbsent", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string2, b);
                a2.b(string2, a);
            }
        });
        a2.a("replace", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string2, b);
                a2.b(string2, a);
            }
        });
        a2.a("replace", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string2, b);
                a2.a(string2, b);
                a2.a(kotlin.reflect.jvm.internal.impl.h.d.c.a);
            }
        });
        a2.a("replaceAll", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string6, b, b, b, b);
            }
        });
        a2.a("compute", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string6, b, b, a, a);
                a2.b(string2, a);
            }
        });
        a2.a("computeIfAbsent", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string4, b, b, b);
                a2.b(string2, b);
            }
        });
        a2.a("computeIfPresent", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string6, b, b, c, a);
                a2.b(string2, a);
            }
        });
        a2.a("merge", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string2, c);
                a2.a(string6, b, c, c, a);
                a2.b(string2, a);
            }
        });
        a2 = new m.a(m2, string10);
        a2.a("empty", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.b(string10, b, c);
            }
        });
        a2.a("of", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, c);
                a2.b(string10, b, c);
            }
        });
        a2.a("ofNullable", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, a);
                a2.b(string10, b, c);
            }
        });
        a2.a("get", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.b(string2, c);
            }
        });
        a2.a("ifPresent", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string5, b, c);
            }
        });
        new m.a(m2, u2.a("ref/Reference")).a("get", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.b(string2, a);
            }
        });
        new m.a(m2, string3).a("test", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(kotlin.reflect.jvm.internal.impl.h.d.c.a);
            }
        });
        new m.a(m2, u2.c("BiPredicate")).a("test", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string2, b);
                a2.a(kotlin.reflect.jvm.internal.impl.h.d.c.a);
            }
        });
        new m.a(m2, string5).a("accept", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
            }
        });
        new m.a(m2, string7).a("accept", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string2, b);
            }
        });
        new m.a(m2, string4).a("apply", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.b(string2, b);
            }
        });
        new m.a(m2, string6).a("apply", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.a(string2, b);
                a2.a(string2, b);
                a2.b(string2, b);
            }
        });
        new m.a(m2, u2.c("Supplier")).a("get", (kotlin.e.a.b<? super m.a.a, kotlin.w>)new kotlin.e.a.b<m.a.a, kotlin.w>(){

            @Override
            public final void a(m.a.a a2) {
                kotlin.e.b.j.b(a2, "$receiver");
                a2.b(string2, b);
            }
        });
        d = m2.a();
    }

    public static final Map<String, kotlin.reflect.jvm.internal.impl.c.a.f.j> a() {
        return d;
    }

}

