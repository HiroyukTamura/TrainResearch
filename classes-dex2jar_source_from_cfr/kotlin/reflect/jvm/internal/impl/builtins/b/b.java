/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.b;

import kotlin.e.b.g;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.b.c;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsInitializer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.i.i;

final class b
extends KotlinBuiltIns {
    public static final a b = new a(null);
    private static final BuiltInsInitializer<b> c = new BuiltInsInitializer(b.a);

    private b() {
        super(new kotlin.reflect.jvm.internal.impl.i.b());
        this.a();
    }

    public /* synthetic */ b(g g2) {
        this();
    }

    @Override
    public /* synthetic */ c c() {
        return this.g();
    }

    protected c.a g() {
        return c.a.a;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final KotlinBuiltIns a() {
            return c.get();
        }
    }

}

