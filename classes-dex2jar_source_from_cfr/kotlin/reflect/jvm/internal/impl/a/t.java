/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;

public interface t
extends kotlin.reflect.jvm.internal.impl.a.b {
    public boolean A();

    public boolean B();

    public boolean C();

    public boolean D();

    public a<? extends t> E();

    public <V> V a(b<V> var1);

    public boolean a();

    @Override
    public m b();

    public t c(au var1);

    public boolean c();

    public Collection<? extends t> k();

    public t s();

    public t t();

    public boolean z();

    public static interface a<D extends t> {
        public a<D> a();

        public a<D> a(List<av> var1);

        public a<D> a(h var1);

        public a<D> a(al var1);

        public a<D> a(b.a var1);

        public a<D> a(ba var1);

        public a<D> a(m var1);

        public a<D> a(w var1);

        public a<D> a(f var1);

        public a<D> a(as var1);

        public a<D> a(kotlin.reflect.jvm.internal.impl.j.w var1);

        public a<D> a(boolean var1);

        public a<D> b();

        public a<D> b(kotlin.reflect.jvm.internal.impl.j.w var1);

        public a<D> c();

        public a<D> d();

        public a<D> e();

        public D f();
    }

    public static interface b<V> {
    }

}

