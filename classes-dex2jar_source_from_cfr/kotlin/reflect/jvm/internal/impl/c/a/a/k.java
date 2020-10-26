/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.j.w;

public interface k {
    public static final k a = new k(){

        @Override
        public a a(q q2, e e2, w w2, w w3, List<av> list, List<as> list2) {
            return new a(w2, w3, list, list2, Collections.<String>emptyList(), false);
        }

        @Override
        public void a(b b2, List<String> list) {
            throw new UnsupportedOperationException("Should not be called");
        }
    };

    public a a(q var1, e var2, w var3, w var4, List<av> var5, List<as> var6);

    public void a(b var1, List<String> var2);

    public static class a {
        private final w a;
        private final w b;
        private final List<av> c;
        private final List<as> d;
        private final List<String> e;
        private final boolean f;

        public a(w w2, w w3, List<av> list, List<as> list2, List<String> list3, boolean bl2) {
            this.a = w2;
            this.b = w3;
            this.c = list;
            this.d = list2;
            this.e = list3;
            this.f = bl2;
        }

        public w a() {
            return this.a;
        }

        public w b() {
            return this.b;
        }

        public List<av> c() {
            return this.c;
        }

        public List<as> d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public List<String> f() {
            return this.e;
        }
    }

}

