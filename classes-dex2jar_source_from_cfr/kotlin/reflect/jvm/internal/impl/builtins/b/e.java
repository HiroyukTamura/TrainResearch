/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.b;

import java.util.List;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.b.c;
import kotlin.reflect.jvm.internal.impl.a.c.u;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.b.d;
import kotlin.reflect.jvm.internal.impl.builtins.b.f;
import kotlin.reflect.jvm.internal.impl.i.h;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.l;
import kotlin.y;

public final class e
extends KotlinBuiltIns {
    static final /* synthetic */ l[] b;
    private kotlin.reflect.jvm.internal.impl.a.y c;
    private boolean d;
    private final kotlin.reflect.jvm.internal.impl.i.f e;

    static {
        b = new l[]{v.a(new t(v.a(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;"))};
    }

    public e(final i i2, boolean bl2) {
        j.b(i2, "storageManager");
        super(i2);
        this.d = true;
        this.e = i2.a((kotlin.e.a.a)new kotlin.e.a.a<f>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final f b() {
                u u2 = this.getBuiltInsModule();
                j.a((Object)u2, "builtInsModule");
                return new f(u2, i2, (kotlin.e.a.a<? extends kotlin.reflect.jvm.internal.impl.a.y>)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.a.y>(){

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public final kotlin.reflect.jvm.internal.impl.a.y b() {
                        kotlin.reflect.jvm.internal.impl.a.y y2 = this.c;
                        if (y2 != null) {
                            return y2;
                        }
                        throw (Throwable)((Object)new AssertionError((Object)"JvmBuiltins has not been initialized properly"));
                    }
                }, new kotlin.e.a.a<Boolean>(){

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public final boolean b() {
                        if (this.c != null) {
                            return this.d;
                        }
                        throw (Throwable)((Object)new AssertionError((Object)"JvmBuiltins has not been initialized properly"));
                    }
                });
            }

        });
        if (bl2) {
            this.a();
        }
    }

    public /* synthetic */ e(i i2, boolean bl2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            bl2 = true;
        }
        this(i2, bl2);
    }

    public final void a(kotlin.reflect.jvm.internal.impl.a.y y2, boolean bl2) {
        j.b(y2, "moduleDescriptor");
        boolean bl3 = this.c == null;
        if (y.a && !bl3) {
            throw (Throwable)((Object)new AssertionError((Object)"JvmBuiltins repeated initialization"));
        }
        this.c = y2;
        this.d = bl2;
    }

    @Override
    protected kotlin.reflect.jvm.internal.impl.a.b.a b() {
        return this.g();
    }

    @Override
    protected c c() {
        return this.g();
    }

    public /* synthetic */ Iterable d() {
        return this.h();
    }

    public final f g() {
        return (f)h.a(this.e, (Object)this, b[0]);
    }

    protected List<kotlin.reflect.jvm.internal.impl.a.b.b> h() {
        Iterable<kotlin.reflect.jvm.internal.impl.a.b.b> iterable = super.d();
        j.a(iterable, "super.getClassDescriptorFactories()");
        i i2 = this.e();
        j.a((Object)i2, "storageManager");
        u u2 = this.getBuiltInsModule();
        j.a((Object)u2, "builtInsModule");
        return m.d(iterable, new d(i2, u2, null, 4, null));
    }

}

