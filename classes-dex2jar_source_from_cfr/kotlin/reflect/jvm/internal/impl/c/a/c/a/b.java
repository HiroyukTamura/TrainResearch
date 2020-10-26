/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.e.n;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.e.f;

public interface b {
    public Collection<q> a(f var1);

    public Set<f> a();

    public Set<f> b();

    public n b(f var1);

    public static final class a
    implements b {
        public static final a a = new a();

        private a() {
        }

        public /* synthetic */ Collection a(f f2) {
            return this.c(f2);
        }

        @Override
        public Set<f> a() {
            return al.a();
        }

        @Override
        public Set<f> b() {
            return al.a();
        }

        @Override
        public n b(f f2) {
            j.b(f2, "name");
            return null;
        }

        public List<q> c(f f2) {
            j.b(f2, "name");
            return m.a();
        }
    }

}

