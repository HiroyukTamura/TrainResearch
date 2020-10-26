/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b {
    public static <N> Boolean a(Collection<N> collection, b<N> b2, final kotlin.e.a.b<N, Boolean> b3) {
        return (Boolean)b.a(collection, b2, new a<N, Boolean>(new boolean[1]){
            final /* synthetic */ boolean[] b;
            {
                this.b = arrbl;
            }

            public Boolean a() {
                return this.b[0];
            }

            @Override
            public boolean a(N n2) {
                if (((Boolean)b3.a(n2)).booleanValue()) {
                    this.b[0] = true;
                }
                return this.b[0] ^ true;
            }

            @Override
            public /* synthetic */ Object b() {
                return this.a();
            }
        });
    }

    public static <N, R> R a(Collection<N> collection, b<N> b2, c<N, R> c2) {
        return b.a(collection, b2, new e(), c2);
    }

    public static <N, R> R a(Collection<N> object, b<N> b2, d<N> d2, c<N, R> c2) {
        object = object.iterator();
        while (object.hasNext()) {
            b.a(object.next(), b2, d2, c2);
        }
        return c2.b();
    }

    public static <N> void a(N n2, b<N> b2, d<N> d2, c<N, ?> c2) {
        if (!d2.a(n2)) {
            return;
        }
        if (!c2.a(n2)) {
            return;
        }
        Iterator<N> iterator = b2.a(n2).iterator();
        while (iterator.hasNext()) {
            b.a(iterator.next(), b2, d2, c2);
        }
        c2.b(n2);
    }

    public static abstract class a<N, R>
    implements c<N, R> {
        @Override
        public boolean a(N n2) {
            return true;
        }

        @Override
        public void b(N n2) {
        }
    }

    public static interface b<N> {
        public Iterable<? extends N> a(N var1);
    }

    public static interface c<N, R> {
        public boolean a(N var1);

        public R b();

        public void b(N var1);
    }

    public static interface d<N> {
        public boolean a(N var1);
    }

    public static class e<N>
    implements d<N> {
        private final Set<N> a;

        public e() {
            this(new HashSet());
        }

        public e(Set<N> set) {
            this.a = set;
        }

        @Override
        public boolean a(N n2) {
            return this.a.add(n2);
        }
    }

}

