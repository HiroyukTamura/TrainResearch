/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.c.k;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.g;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.c;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;

public abstract class e
extends k
implements as {
    private final ba a;
    private final boolean b;
    private final int c;
    private final kotlin.reflect.jvm.internal.impl.i.f<kotlin.reflect.jvm.internal.impl.j.an> d;
    private final kotlin.reflect.jvm.internal.impl.i.f<ad> e;

    protected e(final i i2, m m2, kotlin.reflect.jvm.internal.impl.a.a.h h2, final f f2, ba ba2, boolean bl2, int n2, an an2, final aq aq2) {
        super(m2, h2, f2, an2);
        this.a = ba2;
        this.b = bl2;
        this.c = n2;
        this.d = i2.a(new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.j.an>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public kotlin.reflect.jvm.internal.impl.j.an b() {
                return new a(i2, aq2);
            }
        });
        this.e = i2.a(new kotlin.e.a.a<ad>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public ad b() {
                return x.a(kotlin.reflect.jvm.internal.impl.a.a.h.a.a(), e.this.e(), Collections.emptyList(), false, new g(i2.a(new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.h.e.h>(){

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Scope for type parameter ");
                        stringBuilder.append(f2.a());
                        return kotlin.reflect.jvm.internal.impl.h.e.m.a(stringBuilder.toString(), e.this.j());
                    }
                })));
            }

        });
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        return o2.a(this, d2);
    }

    protected abstract void a(w var1);

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public as c() {
        return (as)super.n_();
    }

    @Override
    public final kotlin.reflect.jvm.internal.impl.j.an e() {
        return (kotlin.reflect.jvm.internal.impl.j.an)this.d.a();
    }

    @Override
    public /* synthetic */ h f() {
        return this.c();
    }

    @Override
    public int g() {
        return this.c;
    }

    @Override
    public ad i_() {
        return (ad)this.e.a();
    }

    @Override
    public List<w> j() {
        return ((a)this.e()).j();
    }

    @Override
    public ba k() {
        return this.a;
    }

    @Override
    public boolean l() {
        return this.b;
    }

    protected abstract List<w> m();

    @Override
    public /* synthetic */ m m_() {
        return this.c();
    }

    @Override
    public /* synthetic */ p n_() {
        return this.c();
    }

    private class a
    extends c {
        private final aq b;

        public a(i i2, aq aq2) {
            super(i2);
            this.b = aq2;
        }

        @Override
        protected Collection<w> a() {
            return e.this.m();
        }

        @Override
        protected void a(w w2) {
            e.this.a(w2);
        }

        @Override
        public List<as> b() {
            return Collections.emptyList();
        }

        @Override
        public h d() {
            return e.this;
        }

        @Override
        public KotlinBuiltIns e() {
            return kotlin.reflect.jvm.internal.impl.h.c.a.d(e.this);
        }

        @Override
        public boolean f() {
            return true;
        }

        @Override
        protected aq g() {
            return this.b;
        }

        @Override
        protected w h() {
            return kotlin.reflect.jvm.internal.impl.j.p.c("Cyclic upper bounds");
        }

        public String toString() {
            return e.this.h_().toString();
        }
    }

}

