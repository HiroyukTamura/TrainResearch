/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.a.m;
import kotlin.e.a.a;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.l;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.b.b;
import kotlin.reflect.jvm.internal.impl.a.b.c;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.i.i;

public interface BuiltInsLoader {
    public static final Companion Companion = Companion.b;

    public ac createPackageFragmentProvider(i var1, y var2, Iterable<? extends b> var3, c var4, kotlin.reflect.jvm.internal.impl.a.b.a var5);

    public static final class Companion {
        static final /* synthetic */ kotlin.reflect.l[] a;
        static final /* synthetic */ Companion b;
        private static final g c;

        static {
            a = new kotlin.reflect.l[]{v.a(new t(v.a(Companion.class), "Instance", "getInstance()Lorg/jetbrains/kotlin/builtins/BuiltInsLoader;"))};
            b = new Companion();
            c = h.a(l.b, a.a);
        }

        private Companion() {
        }

        public final BuiltInsLoader getInstance() {
            g g2 = c;
            kotlin.reflect.l l2 = a[0];
            return (BuiltInsLoader)g2.a();
        }

    }

}

