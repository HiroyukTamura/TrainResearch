/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.k.b;

public abstract class k
implements kotlin.reflect.jvm.internal.impl.k.b {
    private final String a;
    private final String b;
    private final kotlin.e.a.b<KotlinBuiltIns, w> c;

    private k(String charSequence, kotlin.e.a.b<? super KotlinBuiltIns, ? extends w> b2) {
        this.b = charSequence;
        this.c = b2;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("must return ");
        ((StringBuilder)charSequence).append(this.b);
        this.a = ((StringBuilder)charSequence).toString();
    }

    public /* synthetic */ k(String string2, kotlin.e.a.b b2, g g2) {
        this(string2, b2);
    }

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public boolean a(t t2) {
        j.b(t2, "functionDescriptor");
        return j.a((Object)t2.g(), (Object)this.c.a(kotlin.reflect.jvm.internal.impl.h.c.a.d(t2)));
    }

    @Override
    public String b(t t2) {
        j.b(t2, "functionDescriptor");
        return b.a.a(this, t2);
    }

    public static final class a
    extends k {
        public static final a a = new a();

        private a() {
            super("Boolean", 1.a, null);
        }

    }

    public static final class b
    extends k {
        public static final b a = new b();

        private b() {
            super("Int", 1.a, null);
        }

    }

    public static final class c
    extends k {
        public static final c a = new c();

        private c() {
            super("Unit", 1.a, null);
        }

    }

}

