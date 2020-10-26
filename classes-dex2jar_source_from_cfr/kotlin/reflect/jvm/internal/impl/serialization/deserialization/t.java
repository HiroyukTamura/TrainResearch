/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.c.z;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.d.b.i;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.n;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.aa;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;

public final class t {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.d a;
    private final l b;

    public t(l l2) {
        kotlin.e.b.j.b(l2, "c");
        this.b = l2;
        this.a = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.d(this.b.d().c(), this.b.d().m());
    }

    private final int a(int n2) {
        return (n2 & 63) + (n2 >> 8 << 6);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final List<av> a(List<a.ak> var1_1, q var2_2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a var3_3) {
        var9_4 = this.b.f();
        if (var9_4 == null) throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        var11_5 = (kotlin.reflect.jvm.internal.impl.a.a)var9_4;
        var9_4 = var11_5.b();
        kotlin.e.b.j.a(var9_4, "callableDescriptor.containingDeclaration");
        var12_6 = this.a((kotlin.reflect.jvm.internal.impl.a.m)var9_4);
        var9_4 = var1_1;
        var1_1 = new ArrayList<E>(m.a(var9_4, 10));
        var13_7 = var9_4.iterator();
        var4_8 = 0;
        while (var13_7.hasNext() != false) {
            var10_13 = (a.ak)var13_7.next();
            var5_9 = var10_13.d() != false ? var10_13.e() : 0;
            if (var12_6 == null) ** GOTO lbl-1000
            var9_4 = kotlin.reflect.jvm.internal.impl.d.b.b.b.a(var5_9);
            kotlin.e.b.j.a(var9_4, "Flags.HAS_ANNOTATIONS.get(flags)");
            if (var9_4.booleanValue()) {
                var9_4 = new n(this.b.c(), (kotlin.e.a.a<? extends List<? extends kotlin.reflect.jvm.internal.impl.a.a.c>>)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.a.c>>((a.ak)var10_13, this, var12_6, var2_2, var3_3, var11_5){
                    final /* synthetic */ a.ak b;
                    final /* synthetic */ t c;
                    final /* synthetic */ w d;
                    final /* synthetic */ q e;
                    final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.a f;
                    final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a g;
                    {
                        this.b = ak2;
                        this.c = t2;
                        this.d = w2;
                        this.e = q2;
                        this.f = a2;
                        this.g = a3;
                        super(0);
                    }

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public final List<kotlin.reflect.jvm.internal.impl.a.a.c> b() {
                        return m.k((Iterable)this.c.b.d().f().a(this.d, this.e, this.f, var4_8, this.b));
                    }
                });
            } else lbl-1000: // 2 sources:
            {
                var9_4 = h.a.a();
            }
            var14_14 = u.b(this.b.e(), var10_13.g());
            var15_15 = aa.a(this.b.a(), kotlin.reflect.jvm.internal.impl.d.b.g.a((a.ak)var10_13, this.b.g()), null, 2, null);
            var16_16 = kotlin.reflect.jvm.internal.impl.d.b.b.C.a(var5_9);
            kotlin.e.b.j.a(var16_16, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
            var6_10 = var16_16.booleanValue();
            var16_16 = kotlin.reflect.jvm.internal.impl.d.b.b.D.a(var5_9);
            kotlin.e.b.j.a(var16_16, "Flags.IS_CROSSINLINE.get(flags)");
            var7_11 = var16_16.booleanValue();
            var16_16 = kotlin.reflect.jvm.internal.impl.d.b.b.E.a(var5_9);
            kotlin.e.b.j.a(var16_16, "Flags.IS_NOINLINE.get(flags)");
            var8_12 = var16_16.booleanValue();
            var10_13 = kotlin.reflect.jvm.internal.impl.d.b.g.b((a.ak)var10_13, this.b.g());
            var10_13 = var10_13 != null ? aa.a(this.b.a(), (a.ac)var10_13, null, 2, null) : null;
            var16_16 = an.a;
            kotlin.e.b.j.a(var16_16, "SourceElement.NO_SOURCE");
            var1_1.add((a.ak)new ah(var11_5, null, var4_8, (h)var9_4, var14_14, var15_15, var6_10, var7_11, var8_12, (kotlin.reflect.jvm.internal.impl.j.w)var10_13, (an)var16_16));
            ++var4_8;
        }
        return m.k((List)var1_1);
    }

    private final h a(final q q2, int n2, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.a a2) {
        if (!kotlin.reflect.jvm.internal.impl.d.b.b.b.a(n2).booleanValue()) {
            return h.a.a();
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.o(this.b.c(), (kotlin.e.a.a<? extends List<kotlin.reflect.jvm.internal.impl.a.a.g>>)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.a.g>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<kotlin.reflect.jvm.internal.impl.a.a.g> b() {
                Object object = this.a(this.b.f());
                object = object != null ? m.k((Iterable)this.b.d().f().a((w)object, q2, a2)) : null;
                if (object != null) {
                    return object;
                }
                return m.a();
            }
        });
    }

    private final h a(final q q2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a a2, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.a a3) {
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.b(this.b.c(), (kotlin.e.a.a<? extends List<kotlin.reflect.jvm.internal.impl.a.a.g>>)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.a.g>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<kotlin.reflect.jvm.internal.impl.a.a.g> b() {
                Object object = this.a(this.b.f());
                if (object != null) {
                    Object object2 = this.b.d().f().b((w)object, q2, a3);
                    object = new ArrayList(m.a(object2, 10));
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        object.add(new kotlin.reflect.jvm.internal.impl.a.a.g((kotlin.reflect.jvm.internal.impl.a.a.c)object2.next(), kotlin.reflect.jvm.internal.impl.a.a.e.f));
                    }
                    object = m.k((List)object);
                } else {
                    object = null;
                }
                if (object != null) {
                    return object;
                }
                return m.a();
            }
        });
    }

    static /* bridge */ /* synthetic */ h a(t t2, q q2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a a2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a a3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            a3 = a2;
        }
        return t2.a(q2, a2, a3);
    }

    private final al a() {
        kotlin.reflect.jvm.internal.impl.a.m m2 = this.b.f();
        boolean bl2 = m2 instanceof kotlin.reflect.jvm.internal.impl.a.e;
        Object var3_3 = null;
        if (!bl2) {
            m2 = null;
        }
        kotlin.reflect.jvm.internal.impl.a.e e2 = (kotlin.reflect.jvm.internal.impl.a.e)m2;
        m2 = var3_3;
        if (e2 != null) {
            m2 = e2.D();
        }
        return m2;
    }

    private final w a(kotlin.reflect.jvm.internal.impl.a.m m2) {
        if (m2 instanceof ab) {
            return new w.b(((ab)m2).f(), this.b.e(), this.b.g(), this.b.i());
        }
        if (m2 instanceof e) {
            return ((e)m2).c();
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final boolean a(g var1_1) {
        block1 : {
            var5_2 = this.b.d().d().e();
            var3_4 = var4_3 = false;
            if (var5_2 == false) return var3_4;
            if ((var1_1 = (Iterable)var1_1.P()) instanceof Collection && ((Collection)var1_1).isEmpty()) ** GOTO lbl8
            var1_1 = var1_1.iterator();
            do {
                if (var1_1.hasNext()) continue;
lbl8: // 2 sources:
                var2_5 = true;
                break block1;
            } while (!(var2_5 = kotlin.e.b.j.a((Object)(var6_6 = (kotlin.reflect.jvm.internal.impl.d.b.i)var1_1.next()).a(), (Object)new i.b(1, 3, 0, 4, null)) != false && var6_6.b() == a.am.c.a));
            var2_5 = false;
        }
        var3_4 = var4_3;
        if (var2_5 == false) return var3_4;
        return true;
    }

    private final boolean a(g g2, aa aa2) {
        Iterator iterator = ((Iterable)aa2.a()).iterator();
        while (iterator.hasNext()) {
            ((as)iterator.next()).j();
        }
        return aa2.b() && this.a(g2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final ai a(final a.w var1_1) {
        block20 : {
            block19 : {
                block18 : {
                    block17 : {
                        kotlin.e.b.j.b(var1_1, "proto");
                        var2_2 = var1_1.d() != false ? var1_1.e() : this.a(var1_1.g());
                        var10_3 = this.b.f();
                        var13_4 = var1_1;
                        var11_5 = this.a((q)var13_4, var2_2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.b);
                        var12_6 = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.d.b(var2_2));
                        var14_13 = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.c.b(var2_2));
                        kotlin.e.b.j.a(var14_13, "ProtoEnumFlags.visibilit\u2026gs.VISIBILITY.get(flags))");
                        var15_14 = kotlin.reflect.jvm.internal.impl.d.b.b.t.a(var2_2);
                        kotlin.e.b.j.a(var15_14, "Flags.IS_VAR.get(flags)");
                        var5_15 = var15_14.booleanValue();
                        var15_14 = u.b(this.b.e(), var1_1.k());
                        var16_16 = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.l.b(var2_2));
                        var17_17 = kotlin.reflect.jvm.internal.impl.d.b.b.x.a(var2_2);
                        kotlin.e.b.j.a(var17_17, "Flags.IS_LATEINIT.get(flags)");
                        var6_18 = var17_17.booleanValue();
                        var17_17 = kotlin.reflect.jvm.internal.impl.d.b.b.w.a(var2_2);
                        kotlin.e.b.j.a(var17_17, "Flags.IS_CONST.get(flags)");
                        var7_19 = var17_17.booleanValue();
                        var17_17 = kotlin.reflect.jvm.internal.impl.d.b.b.z.a(var2_2);
                        kotlin.e.b.j.a(var17_17, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
                        var8_20 = var17_17.booleanValue();
                        var17_17 = kotlin.reflect.jvm.internal.impl.d.b.b.A.a(var2_2);
                        kotlin.e.b.j.a(var17_17, "Flags.IS_DELEGATED.get(flags)");
                        var9_21 = var17_17.booleanValue();
                        var17_17 = kotlin.reflect.jvm.internal.impl.d.b.b.B.a(var2_2);
                        kotlin.e.b.j.a(var17_17, "Flags.IS_EXPECT_PROPERTY.get(flags)");
                        var11_5 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j((kotlin.reflect.jvm.internal.impl.a.m)var10_3, null, (h)var11_5, var12_6, (ba)var14_13, var5_15, (kotlin.reflect.jvm.internal.impl.e.f)var15_14, (b.a)var16_16, var6_18, var7_19, var8_20, var9_21, var17_17.booleanValue(), var1_1, this.b.e(), this.b.g(), this.b.h(), this.b.i());
                        var10_3 = this.b;
                        var12_7 = (kotlin.reflect.jvm.internal.impl.a.m)var11_5;
                        var14_13 = var1_1.s();
                        kotlin.e.b.j.a(var14_13, "proto.typeParameterList");
                        var15_14 = l.a((l)var10_3, var12_7, (List)var14_13, null, null, null, null, 60, null);
                        var16_16 = kotlin.reflect.jvm.internal.impl.d.b.b.u.a(var2_2);
                        kotlin.e.b.j.a(var16_16, "hasGetter");
                        var10_3 = var16_16.booleanValue() != false && kotlin.reflect.jvm.internal.impl.d.b.g.a(var1_1) != false ? t.a(this, (q)var13_4, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c, null, 4, null) : h.a.a();
                        var3_22 = var2_2;
                        var12_8 = var1_1;
                        var17_17 = var15_14.a();
                        var18_23 = kotlin.reflect.jvm.internal.impl.d.b.g.a(var12_8, this.b.g());
                        var14_13 = null;
                        var17_17 = aa.a((aa)var17_17, (a.ac)var18_23, null, 2, null);
                        var18_23 = var15_14.a().a();
                        var19_24 = this.a();
                        var12_9 = kotlin.reflect.jvm.internal.impl.d.b.g.b(var12_8, this.b.g());
                        var10_3 = var12_9 != null ? var15_14.a().a(var12_9, (h)var10_3) : null;
                        var11_5.a((kotlin.reflect.jvm.internal.impl.j.w)var17_17, (List<? extends as>)var18_23, var19_24, (kotlin.reflect.jvm.internal.impl.j.w)var10_3);
                        if (!var16_16.booleanValue()) break block17;
                        var4_25 = var1_1.B();
                        if (!var1_1.A()) ** GOTO lbl-1000
                        var10_3 = kotlin.reflect.jvm.internal.impl.d.b.b.F.a(var4_25);
                        kotlin.e.b.j.a(var10_3, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
                        if (var10_3.booleanValue()) {
                            var2_2 = 1;
                        } else lbl-1000: // 2 sources:
                        {
                            var2_2 = 0;
                        }
                        if (!var1_1.A()) ** GOTO lbl-1000
                        var10_3 = kotlin.reflect.jvm.internal.impl.d.b.b.G.a(var4_25);
                        kotlin.e.b.j.a(var10_3, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
                        if (var10_3.booleanValue()) {
                            var5_15 = true;
                        } else lbl-1000: // 2 sources:
                        {
                            var5_15 = false;
                        }
                        if (!var1_1.A()) ** GOTO lbl-1000
                        var10_3 = kotlin.reflect.jvm.internal.impl.d.b.b.H.a(var4_25);
                        kotlin.e.b.j.a(var10_3, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
                        if (var10_3.booleanValue()) {
                            var6_18 = true;
                        } else lbl-1000: // 2 sources:
                        {
                            var6_18 = false;
                        }
                        var10_3 = this.a((q)var13_4, var4_25, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c);
                        if (var2_2 != 0) {
                            var10_3 = new z((ai)var11_5, (h)var10_3, x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.d.b(var4_25)), x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.c.b(var4_25)), (boolean)(var2_2 ^ 1), var5_15, var6_18, var11_5.n(), null, an.a);
                        } else {
                            var10_3 = kotlin.reflect.jvm.internal.impl.h.b.b((ai)var11_5, (h)var10_3);
                            kotlin.e.b.j.a(var10_3, "DescriptorFactory.create\u2026er(property, annotations)");
                        }
                        var10_3.a(var11_5.g());
                        var12_10 = var10_3;
                        break block18;
                    }
                    var12_11 = null;
                }
                var10_3 = kotlin.reflect.jvm.internal.impl.d.b.b.v.a(var3_22);
                kotlin.e.b.j.a(var10_3, "Flags.HAS_SETTER.get(flags)");
                if (!var10_3.booleanValue()) break block19;
                var4_25 = var1_1.D();
                if (!var1_1.C()) ** GOTO lbl-1000
                var10_3 = kotlin.reflect.jvm.internal.impl.d.b.b.F.a(var4_25);
                kotlin.e.b.j.a(var10_3, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
                if (var10_3.booleanValue()) {
                    var2_2 = 1;
                } else lbl-1000: // 2 sources:
                {
                    var2_2 = 0;
                }
                if (!var1_1.C()) ** GOTO lbl-1000
                var10_3 = kotlin.reflect.jvm.internal.impl.d.b.b.G.a(var4_25);
                kotlin.e.b.j.a(var10_3, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
                if (var10_3.booleanValue()) {
                    var5_15 = true;
                } else lbl-1000: // 2 sources:
                {
                    var5_15 = false;
                }
                if (!var1_1.A()) ** GOTO lbl-1000
                var10_3 = kotlin.reflect.jvm.internal.impl.d.b.b.H.a(var4_25);
                kotlin.e.b.j.a(var10_3, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
                if (var10_3.booleanValue()) {
                    var6_18 = true;
                } else lbl-1000: // 2 sources:
                {
                    var6_18 = false;
                }
                var10_3 = this.a((q)var13_4, var4_25, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.d);
                if (var2_2 != 0) {
                    var10_3 = new kotlin.reflect.jvm.internal.impl.a.c.aa((ai)var11_5, (h)var10_3, x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.d.b(var4_25)), x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.c.b(var4_25)), (boolean)(var2_2 ^ 1), var5_15, var6_18, var11_5.n(), null, an.a);
                    var10_3.a(m.j(l.a((l)var15_14, (kotlin.reflect.jvm.internal.impl.a.m)var10_3, m.<T>a(), null, null, null, null, 60, null).b().a(m.a(var1_1.z()), (q)var13_4, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.d)));
                } else {
                    var10_3 = kotlin.reflect.jvm.internal.impl.h.b.a((ai)var11_5, (h)var10_3);
                    kotlin.e.b.j.a(var10_3, "DescriptorFactory.create\u2026er(property, annotations)");
                }
                break block20;
            }
            var10_3 = var14_13;
        }
        var13_4 = kotlin.reflect.jvm.internal.impl.d.b.b.y.a(var3_22);
        kotlin.e.b.j.a(var13_4, "Flags.HAS_CONSTANT.get(flags)");
        if (var13_4.booleanValue()) {
            var11_5.a(this.b.c().b((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.h.b.f<?>>((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j)var11_5){
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j c;
                {
                    this.c = j2;
                    super(0);
                }

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final kotlin.reflect.jvm.internal.impl.h.b.f<?> b() {
                    w w2 = this.a(this.b.f());
                    if (w2 == null) {
                        kotlin.e.b.j.a();
                    }
                    kotlin.reflect.jvm.internal.impl.serialization.deserialization.b<kotlin.reflect.jvm.internal.impl.a.a.c, kotlin.reflect.jvm.internal.impl.h.b.f<?>, kotlin.reflect.jvm.internal.impl.a.a.g> b2 = this.b.d().f();
                    a.w w3 = var1_1;
                    kotlin.reflect.jvm.internal.impl.j.w w4 = this.c.g();
                    kotlin.e.b.j.a((Object)w4, "property.returnType");
                    return b2.a(w2, w3, w4);
                }
            }));
        }
        var11_5.a((z)var12_12, (ak)var10_3, this.a((g)var11_5, var15_14.a()));
        return (ai)var11_5;
    }

    public final am a(a.o serializable) {
        kotlin.e.b.j.b(serializable, "proto");
        int n2 = ((a.o)serializable).d() ? ((a.o)serializable).e() : this.a(((a.o)serializable).g());
        Object object = (q)((Object)serializable);
        Object object2 = this.a((q)object, n2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a);
        Object object3 = kotlin.reflect.jvm.internal.impl.d.b.g.a((a.o)serializable) ? t.a(this, (q)object, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a, null, 4, null) : h.a.a();
        object2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.k(this.b.f(), null, (h)object2, u.b(this.b.e(), ((a.o)serializable).k()), x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.l.b(n2)), (a.o)serializable, this.b.e(), this.b.g(), this.b.h(), this.b.i(), null, 1024, null);
        l l2 = this.b;
        Object object4 = (kotlin.reflect.jvm.internal.impl.a.m)object2;
        List<Object> list = ((a.o)serializable).s();
        kotlin.e.b.j.a(list, "proto.typeParameterList");
        l2 = l.a(l2, (kotlin.reflect.jvm.internal.impl.a.m)object4, list, null, null, null, null, 60, null);
        object4 = kotlin.reflect.jvm.internal.impl.d.b.g.b((a.o)serializable, this.b.g());
        object3 = object4 != null ? l2.a().a((a.ac)object4, (h)object3) : null;
        object4 = this.a();
        list = l2.a().a();
        Object object5 = l2.b();
        Object object6 = ((a.o)serializable).y();
        kotlin.e.b.j.a(object6, "proto.valueParameterList");
        object = ((t)object5).a((List<a.ak>)object6, (q)object, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a);
        object5 = aa.a(l2.a(), kotlin.reflect.jvm.internal.impl.d.b.g.a((a.o)serializable, this.b.g()), null, 2, null);
        object6 = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.d.b(n2));
        ba ba2 = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.c.b(n2));
        kotlin.e.b.j.a((Object)ba2, "ProtoEnumFlags.visibilit\u2026gs.VISIBILITY.get(flags))");
        Map map = af.a();
        Boolean bl2 = kotlin.reflect.jvm.internal.impl.d.b.b.r.a(n2);
        kotlin.e.b.j.a((Object)bl2, "Flags.IS_SUSPEND.get(flags)");
        boolean bl3 = bl2 != false && this.a((g)object2) || this.a((g)object2, l2.a());
        ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.k)object2).a((kotlin.reflect.jvm.internal.impl.j.w)object3, (al)object4, (List<? extends as>)list, (List<? extends av>)object, (kotlin.reflect.jvm.internal.impl.j.w)object5, (kotlin.reflect.jvm.internal.impl.a.w)((Object)object6), ba2, map, bl3);
        object3 = kotlin.reflect.jvm.internal.impl.d.b.b.m.a(n2);
        kotlin.e.b.j.a(object3, "Flags.IS_OPERATOR.get(flags)");
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).a((Boolean)object3);
        object3 = kotlin.reflect.jvm.internal.impl.d.b.b.n.a(n2);
        kotlin.e.b.j.a(object3, "Flags.IS_INFIX.get(flags)");
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).b((Boolean)object3);
        object3 = kotlin.reflect.jvm.internal.impl.d.b.b.q.a(n2);
        kotlin.e.b.j.a(object3, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).c((Boolean)object3);
        object3 = kotlin.reflect.jvm.internal.impl.d.b.b.o.a(n2);
        kotlin.e.b.j.a(object3, "Flags.IS_INLINE.get(flags)");
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).d((Boolean)object3);
        object3 = kotlin.reflect.jvm.internal.impl.d.b.b.p.a(n2);
        kotlin.e.b.j.a(object3, "Flags.IS_TAILREC.get(flags)");
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).e((Boolean)object3);
        object3 = kotlin.reflect.jvm.internal.impl.d.b.b.r.a(n2);
        kotlin.e.b.j.a(object3, "Flags.IS_SUSPEND.get(flags)");
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).h((Boolean)object3);
        object3 = kotlin.reflect.jvm.internal.impl.d.b.b.s.a(n2);
        kotlin.e.b.j.a(object3, "Flags.IS_EXPECT_FUNCTION.get(flags)");
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).f((Boolean)object3);
        serializable = this.b.d().n().a((a.o)serializable, (kotlin.reflect.jvm.internal.impl.a.t)object2, this.b.g(), this.b.a());
        if (serializable != null) {
            ((kotlin.reflect.jvm.internal.impl.a.c.o)object2).a((t.b)((o)serializable).a(), ((o)serializable).b());
        }
        return (am)object2;
    }

    public final ar a(a.ad ad2) {
        Object object;
        List<a.ag> list;
        kotlin.e.b.j.b(ad2, "proto");
        Object object2 = ad2.w();
        kotlin.e.b.j.a(object2, "proto.annotationList");
        Object object3 = (Iterable)object2;
        object2 = new ArrayList(m.a(object3, 10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object = (a.a)object3.next();
            list = this.a;
            kotlin.e.b.j.a(object, "it");
            object2.add((a.a)((Object)((kotlin.reflect.jvm.internal.impl.serialization.deserialization.d)((Object)list)).a((a.a)object, this.b.e())));
        }
        list = new kotlin.reflect.jvm.internal.impl.a.a.i((List<? extends kotlin.reflect.jvm.internal.impl.a.a.c>)object2);
        object2 = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.c.b(ad2.e()));
        object3 = this.b.c();
        object = this.b.f();
        list = (h)((Object)list);
        kotlin.reflect.jvm.internal.impl.e.f f2 = u.b(this.b.e(), ad2.g());
        kotlin.e.b.j.a(object2, "visibility");
        object2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.l((kotlin.reflect.jvm.internal.impl.i.i)object3, (kotlin.reflect.jvm.internal.impl.a.m)object, (h)((Object)list), f2, (ba)object2, ad2, this.b.e(), this.b.g(), this.b.h(), this.b.i());
        object3 = this.b;
        object = (kotlin.reflect.jvm.internal.impl.a.m)object2;
        list = ad2.j();
        kotlin.e.b.j.a(list, "proto.typeParameterList");
        object3 = l.a((l)object3, (kotlin.reflect.jvm.internal.impl.a.m)object, list, null, null, null, null, 60, null);
        ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.l)object2).a(((l)object3).a().a(), aa.b(((l)object3).a(), kotlin.reflect.jvm.internal.impl.d.b.g.a(ad2, this.b.g()), null, 2, null), aa.b(((l)object3).a(), kotlin.reflect.jvm.internal.impl.d.b.g.b(ad2, this.b.g()), null, 2, null), this.a((g)object2, ((l)object3).a()));
        return (ar)object2;
    }

    public final kotlin.reflect.jvm.internal.impl.a.d a(a.e object, boolean bl2) {
        kotlin.e.b.j.b(object, "proto");
        Object object2 = this.b.f();
        if (object2 != null) {
            boolean bl3;
            kotlin.reflect.jvm.internal.impl.a.h h22 = (kotlin.reflect.jvm.internal.impl.a.e)object2;
            q q2 = (q)object;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.d d2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.d((kotlin.reflect.jvm.internal.impl.a.e)h22, null, this.a(q2, ((a.e)object).e(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a), bl2, b.a.a, (a.e)object, this.b.e(), this.b.g(), this.b.h(), this.b.i(), null, 1024, null);
            object2 = l.a(this.b, d2, m.a(), null, null, null, null, 60, null);
            t t2 = ((l)object2).b();
            List<a.ak> list = ((a.e)object).f();
            kotlin.e.b.j.a(list, "proto.valueParameterList");
            d2.a(t2.a(list, q2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a), x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.c.b(((a.e)object).e())));
            d2.a(h22.i_());
            object = d2.f();
            kotlin.e.b.j.a(object, "descriptor.typeParameters");
            for (kotlin.reflect.jvm.internal.impl.a.h h22 : (Iterable)object) {
                kotlin.e.b.j.a((Object)h22, "it");
                h22.j();
            }
            boolean bl4 = ((l)object2).a().b();
            bl2 = bl3 = true;
            if (!bl4) {
                object = object2 = this.b.f();
                if (!(object2 instanceof e)) {
                    object = null;
                }
                bl2 = (object = (e)object) != null && (object = ((e)object).a()) != null && (object = ((l)object).a()) != null && ((aa)object).b() && this.a(d2) ? bl3 : false;
            }
            d2.k(bl2);
            return d2;
        }
        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

}

