/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.c.p;
import kotlin.reflect.jvm.internal.impl.a.c.r;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.l;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.av;

public abstract class a
implements e {
    static final /* synthetic */ boolean b;
    protected final kotlin.reflect.jvm.internal.impl.i.f<ad> a;
    private final f c;
    private final kotlin.reflect.jvm.internal.impl.i.f<kotlin.reflect.jvm.internal.impl.h.e.h> d;
    private final kotlin.reflect.jvm.internal.impl.i.f<al> e;

    static {
        b = a.class.desiredAssertionStatus() ^ true;
    }

    public a(i i2, f f2) {
        this.c = f2;
        this.a = i2.a(new kotlin.e.a.a<ad>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public ad b() {
                return av.a(a.this, a.this.g());
            }
        });
        this.d = i2.a(new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.h.e.h>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public kotlin.reflect.jvm.internal.impl.h.e.h b() {
                return new kotlin.reflect.jvm.internal.impl.h.e.f(a.this.g());
            }
        });
        this.e = i2.a(new kotlin.e.a.a<al>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public al b() {
                return new p(a.this);
            }
        });
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h C() {
        return (kotlin.reflect.jvm.internal.impl.h.e.h)this.d.a();
    }

    @Override
    public al D() {
        return (al)this.e.a();
    }

    @Override
    public e E() {
        return this;
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    public e a(au au2) {
        if (au2.a()) {
            return this;
        }
        return new r(this, au2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h a(as object) {
        if (((as)object).a()) {
            return this.g();
        }
        object = au.a((as)object);
        return new l(this.g(), (au)object);
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
    }

    @Override
    public /* synthetic */ h f() {
        return this.E();
    }

    @Override
    public f h_() {
        return this.c;
    }

    @Override
    public ad i_() {
        return (ad)this.a.a();
    }

    @Override
    public /* synthetic */ m m_() {
        return this.E();
    }

}

