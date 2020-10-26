/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.i.k;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.ag;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.f;
import kotlin.reflect.jvm.internal.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.c.a.j;
import kotlin.reflect.jvm.internal.impl.d.c.b;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.l;
import kotlin.reflect.jvm.internal.v;
import kotlin.t;
import kotlin.y;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u00a8\u0006\u0005"}, d2={"computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "isGetter", "", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class w {
    public static final /* synthetic */ kotlin.reflect.jvm.internal.d a(v.a a2, boolean bl2) {
        return w.b(a2, bl2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static final kotlin.reflect.jvm.internal.d<?> b(v.a<?, ?> var0, boolean var1_1) {
        block22 : {
            block28 : {
                block29 : {
                    block27 : {
                        block25 : {
                            block26 : {
                                block24 : {
                                    block23 : {
                                        if (l.b.a().a(var0.l().u())) {
                                            return d.aa.b;
                                        }
                                        var2_2 = new kotlin.e.a.a<Boolean>((v.a)var0){
                                            final /* synthetic */ v.a a;
                                            {
                                                this.a = a2;
                                                super(0);
                                            }

                                            @Override
                                            public /* synthetic */ Object a() {
                                                return this.b();
                                            }

                                            public final boolean b() {
                                                m m2 = this.a.l().t().b();
                                                if (kotlin.reflect.jvm.internal.impl.h.c.i(m2)) {
                                                    kotlin.e.b.j.a((Object)m2, "possibleCompanionObject");
                                                    if (!kotlin.reflect.jvm.internal.impl.h.c.o(m2.b())) {
                                                        return true;
                                                    }
                                                }
                                                return false;
                                            }
                                        };
                                        var3_3 = new kotlin.e.a.a<Boolean>((v.a)var0, new kotlin.e.a.a<Boolean>((v.a)var0){
                                            final /* synthetic */ v.a a;
                                            {
                                                this.a = a2;
                                                super(0);
                                            }

                                            @Override
                                            public /* synthetic */ Object a() {
                                                return this.b();
                                            }

                                            public final boolean b() {
                                                m m2 = this.a.l().t().b();
                                                if (kotlin.reflect.jvm.internal.impl.h.c.i(m2)) {
                                                    kotlin.e.b.j.a((Object)m2, "possibleCompanionObject");
                                                    if (kotlin.reflect.jvm.internal.impl.h.c.o(m2.b()) || kotlin.reflect.jvm.internal.impl.h.c.n(m2.b())) {
                                                        return true;
                                                    }
                                                }
                                                return false;
                                            }
                                        }){
                                            final /* synthetic */ v.a a;
                                            final /* synthetic */ b b;
                                            {
                                                this.a = a2;
                                                this.b = b2;
                                                super(0);
                                            }

                                            @Override
                                            public /* synthetic */ Object a() {
                                                return this.b();
                                            }

                                            public final boolean b() {
                                                ai ai2 = this.a.l().t();
                                                if (ai2 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j && this.b.b()) {
                                                    return j.a(((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j)ai2).H());
                                                }
                                                return false;
                                            }
                                        };
                                        var4_4 = new kotlin.e.a.a<Boolean>((v.a)var0){
                                            final /* synthetic */ v.a a;
                                            {
                                                this.a = a2;
                                                super(0);
                                            }

                                            @Override
                                            public /* synthetic */ Object a() {
                                                return this.b();
                                            }

                                            public final boolean b() {
                                                return this.a.l().t().x().a(kotlin.reflect.jvm.internal.ai.a()) != null;
                                            }
                                        };
                                        var5_5 = new kotlin.e.a.b<Field, kotlin.reflect.jvm.internal.d<? extends Field>>((v.a)var0, var2_2, var3_3, var1_1, new kotlin.e.a.a<Boolean>((v.a)var0){
                                            final /* synthetic */ v.a a;
                                            {
                                                this.a = a2;
                                                super(0);
                                            }

                                            @Override
                                            public /* synthetic */ Object a() {
                                                return this.b();
                                            }

                                            public final boolean b() {
                                                return av.f(this.a.l().t().r()) ^ true;
                                            }
                                        }, var4_4){
                                            final /* synthetic */ v.a a;
                                            final /* synthetic */ a b;
                                            final /* synthetic */ c c;
                                            final /* synthetic */ boolean d;
                                            final /* synthetic */ e e;
                                            final /* synthetic */ d f;
                                            {
                                                this.a = a2;
                                                this.b = a3;
                                                this.c = c2;
                                                this.d = bl2;
                                                this.e = e2;
                                                this.f = d2;
                                                super(1);
                                            }

                                            /*
                                             * Enabled aggressive block sorting
                                             */
                                            @Override
                                            public final kotlin.reflect.jvm.internal.d<Field> a(Field object) {
                                                block8 : {
                                                    block13 : {
                                                        block12 : {
                                                            block14 : {
                                                                block11 : {
                                                                    block9 : {
                                                                        block10 : {
                                                                            kotlin.e.b.j.b(object, "field");
                                                                            if (this.b.b() || this.c.b()) break block8;
                                                                            if (Modifier.isStatic(((Field)object).getModifiers())) break block9;
                                                                            if (!this.d) break block10;
                                                                            object = this.a.h() ? new d.d((Field)object, this.a.l().v()) : new d.q((Field)object);
                                                                            break block11;
                                                                        }
                                                                        object = this.a.h() ? new d.e((Field)object, this.e.b(), this.a.l().v()) : new d.r((Field)object, this.e.b());
                                                                        break block12;
                                                                    }
                                                                    if (!this.f.b()) break block13;
                                                                    if (!this.d) break block14;
                                                                    object = this.a.h() ? new d.h((Field)object) : new d.u((Field)object);
                                                                }
                                                                object = (d.o)object;
                                                                return (kotlin.reflect.jvm.internal.d)object;
                                                            }
                                                            object = this.a.h() ? new d.i((Field)object, this.e.b()) : new d.v((Field)object, this.e.b());
                                                        }
                                                        object = (d.p)object;
                                                        return (kotlin.reflect.jvm.internal.d)object;
                                                    }
                                                    if (this.d) {
                                                        object = new d.x((Field)object);
                                                        return (kotlin.reflect.jvm.internal.d)object;
                                                    }
                                                    object = new d.y((Field)object, this.e.b());
                                                    return (kotlin.reflect.jvm.internal.d)object;
                                                }
                                                Object object2 = this.a.n().b();
                                                if (object2 == null) throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                                                if ((object2 = kotlin.reflect.jvm.internal.ai.a((kotlin.reflect.jvm.internal.impl.a.e)object2)) == null) {
                                                    kotlin.e.b.j.a();
                                                }
                                                if (this.d) {
                                                    if (this.a.h()) {
                                                        object = new d.a((Field)object, object2);
                                                        return (kotlin.reflect.jvm.internal.d)object;
                                                    }
                                                    object = new d.k((Field)object, (Class<?>)object2);
                                                    return (kotlin.reflect.jvm.internal.d)object;
                                                }
                                                if (this.a.h()) {
                                                    object = new d.b((Field)object, (Class<?>)object2);
                                                    return (kotlin.reflect.jvm.internal.d)object;
                                                }
                                                object = new d.l((Field)object, (Class<?>)object2);
                                                return (kotlin.reflect.jvm.internal.d)object;
                                            }
                                        };
                                        var2_2 = ag.a.a(var0.l().t());
                                        if (!(var2_2 instanceof g.c)) break block22;
                                        var6_6 = (g.c)var2_2;
                                        var2_2 = var6_6.d();
                                        var3_3 = null;
                                        if (!var1_1) break block23;
                                        if (!var2_2.j()) ** GOTO lbl-1000
                                        var2_2 = var2_2.k();
                                        break block24;
                                    }
                                    if (var2_2.l()) {
                                        var2_2 = var2_2.p();
                                    } else lbl-1000: // 2 sources:
                                    {
                                        var2_2 = null;
                                    }
                                }
                                if (var2_2 != null) {
                                    var3_3 = var0.l().f().a(var6_6.e().a(var2_2.e()), var6_6.e().a(var2_2.g()), kotlin.reflect.jvm.internal.ai.a(var0.n()));
                                }
                                if (var3_3 == null) {
                                    var2_2 = var0.l().r();
                                    if (var2_2 != null) {
                                        return var5_5.a((Field)var2_2);
                                    }
                                    var2_2 = new StringBuilder();
                                    var2_2.append("No accessors or field is found for property ");
                                    var2_2.append(var0.l());
                                    throw (Throwable)new aa(var2_2.toString());
                                }
                                if (Modifier.isStatic(var3_3.getModifiers())) break block25;
                                if (!var0.h()) break block26;
                                var0 = new d.f((Method)var3_3, var0.l().v());
                                break block27;
                            }
                            var0 = new d.s((Method)var3_3);
                            break block28;
                        }
                        if (var4_4.b()) {
                            var0 = var0.h() != false ? new d.g((Method)var3_3) : new d.t((Method)var3_3);
                            var0 = (d.w)var0;
                            return (kotlin.reflect.jvm.internal.d)var0;
                        }
                        if (!var0.h()) break block29;
                        var0 = new d.j((Method)var3_3, var0.l().v());
                    }
                    var0 = (d.w)var0;
                    return (kotlin.reflect.jvm.internal.d)var0;
                }
                var0 = new d.z((Method)var3_3);
            }
            var0 = (d.w)var0;
            return (kotlin.reflect.jvm.internal.d)var0;
        }
        if (var2_2 instanceof g.a) {
            return var5_5.a(((g.a)var2_2).b());
        }
        if (var2_2 instanceof g.b) {
            if (var1_1) {
                var2_2 = ((g.b)var2_2).b();
            } else {
                var3_3 = (g.b)var2_2;
                var2_2 = var3_3.c();
                if (var2_2 == null) {
                    var0 = new StringBuilder();
                    var0.append("No source found for setter of Java method property: ");
                    var0.append(var3_3.b());
                    throw (Throwable)new aa(var0.toString());
                }
            }
            if (var0.h()) {
                var0 = new d.f((Method)var2_2, var0.l().v());
                return (kotlin.reflect.jvm.internal.d)var0;
            }
            var0 = new d.s((Method)var2_2);
            return (kotlin.reflect.jvm.internal.d)var0;
        }
        if (var2_2 instanceof g.d == false) throw new kotlin.m();
        if (var1_1) {
            var2_2 = ((g.d)var2_2).b();
        } else if ((var2_2 = ((g.d)var2_2).c()) == null) {
            var2_2 = new StringBuilder();
            var2_2.append("No setter found for property ");
            var2_2.append(var0.l());
            throw (Throwable)new aa(var2_2.toString());
        }
        var2_2 = var0.l().f().a(var2_2.b(), var2_2.c(), kotlin.reflect.jvm.internal.ai.a(var0.n()));
        if (var2_2 == null) {
            var2_2 = new StringBuilder();
            var2_2.append("No accessor found for property ");
            var2_2.append(var0.l());
            throw (Throwable)new aa(var2_2.toString());
        }
        var1_1 = Modifier.isStatic(var2_2.getModifiers());
        if (y.a && !(var1_1 ^ true)) {
            var2_2 = new StringBuilder();
            var2_2.append("Mapped property cannot have a static accessor: ");
            var2_2.append(var0.l());
            throw (Throwable)new AssertionError((Object)var2_2.toString());
        }
        if (var0.h() == false) return new d.s((Method)var2_2);
        return new d.f((Method)var2_2, var0.l().v());
    }

}

