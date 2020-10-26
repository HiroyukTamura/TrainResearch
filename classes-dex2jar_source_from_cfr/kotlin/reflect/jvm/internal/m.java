/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.a;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.ag;
import kotlin.reflect.jvm.internal.ai;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.e;
import kotlin.reflect.jvm.internal.f;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.l;
import kotlin.reflect.k;

@Metadata(bv={1, 0, 2}, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00132\n\u0010,\u001a\u0006\u0012\u0002\b\u00030+H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0013\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\"R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "getArity", "", "hashCode", "toString", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class m
extends kotlin.reflect.jvm.internal.h<Object>
implements kotlin.e.b.h,
kotlin.reflect.f<Object>,
e {
    static final /* synthetic */ kotlin.reflect.l[] a;
    private final ac.a b;
    private final ac.a c;
    private final ac.a d;
    private final l e;
    private final String f;
    private final Object g;

    static {
        a = new kotlin.reflect.l[]{v.a(new kotlin.e.b.t(v.a(m.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), v.a(new kotlin.e.b.t(v.a(m.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;")), v.a(new kotlin.e.b.t(v.a(m.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
    }

    public m(l l2, String string2, String string3, Object object) {
        j.b(l2, "container");
        j.b(string2, "name");
        j.b(string3, "signature");
        this(l2, string2, string3, null, object);
    }

    private m(l l2, final String string2, String string3, t t2, Object object) {
        this.e = l2;
        this.f = string3;
        this.g = object;
        this.b = ac.a(t2, (kotlin.e.a.a)new kotlin.e.a.a<t>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final t b() {
                return this.f().b(string2, this.f);
            }
        });
        this.c = ac.b((kotlin.e.a.a)new kotlin.e.a.a<d<? extends Member>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            /*
             * Enabled aggressive block sorting
             */
            public final d<Member> b() {
                Object object;
                Object object2;
                block17 : {
                    Object object3;
                    block14 : {
                        block16 : {
                            block15 : {
                                block13 : {
                                    object2 = ag.a.a(this.b());
                                    if (!(object2 instanceof f.d)) break block13;
                                    if (this.o()) {
                                        object = this.f().a();
                                        Object object4 = this.i();
                                        object2 = new ArrayList(kotlin.a.m.a(object4, 10));
                                        object4 = object4.iterator();
                                        do {
                                            if (!object4.hasNext()) {
                                                object = new kotlin.reflect.jvm.internal.a((Class)object, (List)object2, a.a.b, a.b.b, null, 16, null);
                                                return (d)object;
                                            }
                                            String string2 = ((k)object4.next()).b();
                                            if (string2 == null) {
                                                j.a();
                                            }
                                            object2.add(string2);
                                        } while (true);
                                    }
                                    object3 = this.f().a(((f.d)object2).b(), ai.a(this.b()));
                                    break block14;
                                }
                                if (!(object2 instanceof f.e)) break block15;
                                object3 = this.f();
                                object2 = (f.e)object2;
                                object3 = ((l)object3).a(((f.e)object2).b(), ((f.e)object2).c(), ai.a(this.b()));
                                break block14;
                            }
                            if (!(object2 instanceof f.c)) break block16;
                            object3 = ((f.c)object2).b();
                            break block14;
                        }
                        if (!(object2 instanceof f.b)) break block17;
                        object3 = ((f.b)object2).b();
                    }
                    object3 = (Member)object3;
                    if (object3 instanceof Constructor) {
                        return this.a(object3);
                    }
                    if (!(object3 instanceof Method)) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Could not compute caller for function: ");
                        ((StringBuilder)object2).append(this.b());
                        ((StringBuilder)object2).append(" (member = ");
                        ((StringBuilder)object2).append(object3);
                        ((StringBuilder)object2).append(')');
                        throw (Throwable)new aa(((StringBuilder)object2).toString());
                    }
                    if (!Modifier.isStatic(((Method)(object3 = (Method)object3)).getModifiers())) {
                        object3 = this.c((Method)object3);
                        return (d)object3;
                    }
                    if (this.b().x().a(ai.a()) != null) {
                        object3 = this.b((Method)object3);
                        return (d)object3;
                    }
                    object3 = this.a((Method)object3);
                    return (d)object3;
                }
                if (!(object2 instanceof f.a)) throw new kotlin.m();
                object = ((f.a)object2).b();
                object2 = this.f().a();
                Object object5 = (Iterable)object;
                Collection collection = new ArrayList(kotlin.a.m.a(object5, 10));
                object5 = object5.iterator();
                do {
                    if (!object5.hasNext()) {
                        object = new kotlin.reflect.jvm.internal.a((Class<?>)object2, (List)collection, a.a.b, a.b.a, (List<Method>)object);
                        return (d)object;
                    }
                    Method method = (Method)object5.next();
                    j.a((Object)method, "it");
                    collection.add(method.getName());
                } while (true);
            }
        });
        this.d = ac.b((kotlin.e.a.a)new kotlin.e.a.a<d<? extends Member>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public final d<Member> b() {
                block13 : {
                    var4_1 = ag.a.a(this.b());
                    var1_2 = var4_1 instanceof f.e;
                    var3_3 = null;
                    if (!var1_2) break block13;
                    var2_4 = this.f();
                    var5_6 = (f.e)var4_1;
                    var4_1 = var5_6.b();
                    var5_6 = var5_6.c();
                    var6_9 = this.d().c();
                    if (var6_9 == null) {
                        j.a();
                    }
                    var2_4 = var2_4.a((String)var4_1, (String)var5_6, Modifier.isStatic(var6_9.getModifiers()) ^ true, ai.a(this.b()));
                    ** GOTO lbl31
                }
                if (var4_1 instanceof f.d) {
                    if (this.o()) {
                        var2_5 = this.f().a();
                        var4_1 = this.i();
                        var3_3 = new ArrayList<E>(kotlin.a.m.a(var4_1, 10));
                        var4_1 = var4_1.iterator();
                        do {
                            if (!var4_1.hasNext()) {
                                var2_5 = new kotlin.reflect.jvm.internal.a((Class)var2_5, (List)var3_3, a.a.a, a.b.b, null, 16, null);
                                return (d)var2_5;
                            }
                            var5_7 = ((k)var4_1.next()).b();
                            if (var5_7 == null) {
                                j.a();
                            }
                            var3_3.add(var5_7);
                        } while (true);
                    }
                    var2_4 = this.f().b(((f.d)var4_1).b(), ai.a(this.b()));
lbl31: // 2 sources:
                    var2_4 = (Member)var2_4;
                } else {
                    if (var4_1 instanceof f.a) {
                        var2_5 = ((f.a)var4_1).b();
                        var3_3 = this.f().a();
                        var5_8 = (Iterable)var2_5;
                        var4_1 = new ArrayList<E>(kotlin.a.m.a(var5_8, 10));
                        var5_8 = var5_8.iterator();
                        do {
                            if (!var5_8.hasNext()) {
                                var2_5 = new kotlin.reflect.jvm.internal.a((Class<?>)var3_3, (List)var4_1, a.a.a, a.b.a, (List<Method>)var2_5);
                                return (d)var2_5;
                            }
                            var6_10 = (Method)var5_8.next();
                            j.a((Object)var6_10, "it");
                            var4_1.add((String)var6_10.getName());
                        } while (true);
                    }
                    var2_4 = null;
                }
                if (var2_4 instanceof Constructor) {
                    return m.a(this, (Constructor)var2_4);
                }
                if (var2_4 instanceof Method == false) return var3_3;
                if (this.b().x().a(ai.a()) == null) ** GOTO lbl-1000
                var3_3 = this.b().b();
                if (var3_3 == null) throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((kotlin.reflect.jvm.internal.impl.a.e)var3_3).q()) {
                    var2_4 = m.b(this, (Method)var2_4);
                    return (d)var2_4;
                } else lbl-1000: // 2 sources:
                {
                    var2_4 = m.c(this, (Method)var2_4);
                }
                return (d)var2_4;
            }
        });
    }

    /* synthetic */ m(l l2, String string2, String string3, t t2, Object object, int n2, g g2) {
        if ((n2 & 16) != 0) {
            object = kotlin.e.b.c.b;
        }
        this(l2, string2, string3, t2, object);
    }

    public m(l l2, t t2) {
        j.b(l2, "container");
        j.b(t2, "descriptor");
        String string2 = t2.h_().a();
        j.a((Object)string2, "descriptor.name.asString()");
        this(l2, string2, ag.a.a(t2).a(), t2, null, 16, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    private final d.w a(Method object) {
        if (this.h()) {
            object = new d.j((Method)object, this.g);
            do {
                return (d.w)object;
                break;
            } while (true);
        }
        object = new d.z((Method)object);
        return (d.w)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    private final d<Constructor<?>> a(Constructor<?> object) {
        if (this.h()) {
            object = new d.c((Constructor<?>)object, this.g);
            do {
                return (d)object;
                break;
            } while (true);
        }
        object = new d.n((Constructor<?>)object);
        return (d)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final d.w b(Method object) {
        if (this.h()) {
            object = new d.g((Method)object);
            do {
                return (d.w)object;
                break;
            } while (true);
        }
        object = new d.t((Method)object);
        return (d.w)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final d.w c(Method object) {
        if (this.h()) {
            object = new d.f((Method)object, this.g);
            do {
                return (d.w)object;
                break;
            } while (true);
        }
        object = new d.s((Method)object);
        return (d.w)object;
    }

    @Override
    public Object a() {
        return e.a.a(this);
    }

    @Override
    public Object a(Object object) {
        return e.a.a(this, object);
    }

    @Override
    public Object a(Object object, Object object2) {
        return e.a.a(this, object, object2);
    }

    @Override
    public Object a(Object object, Object object2, Object object3) {
        return e.a.a(this, object, object2, object3);
    }

    public t b() {
        return (t)this.b.a(this, a[0]);
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b c() {
        return this.b();
    }

    @Override
    public d<?> d() {
        return (d)this.c.a(this, a[1]);
    }

    @Override
    public d<?> e() {
        return (d)this.d.a(this, a[2]);
    }

    public boolean equals(Object object) {
        boolean bl2;
        object = ai.a(object);
        boolean bl3 = bl2 = false;
        if (object != null) {
            bl3 = bl2;
            if (j.a((Object)this.f(), (Object)((m)object).f())) {
                bl3 = bl2;
                if (j.a((Object)this.g(), (Object)((m)object).g())) {
                    bl3 = bl2;
                    if (j.a((Object)this.f, (Object)((m)object).f)) {
                        bl3 = bl2;
                        if (j.a(this.g, ((m)object).g)) {
                            bl3 = true;
                        }
                    }
                }
            }
        }
        return bl3;
    }

    @Override
    public l f() {
        return this.e;
    }

    @Override
    public String g() {
        String string2 = this.b().h_().a();
        j.a((Object)string2, "descriptor.name.asString()");
        return string2;
    }

    @Override
    public boolean h() {
        return j.a(this.g, kotlin.e.b.c.b) ^ true;
    }

    public int hashCode() {
        return (this.f().hashCode() * 31 + this.g().hashCode()) * 31 + this.f.hashCode();
    }

    public String toString() {
        return ae.a.a(this.b());
    }

}

