/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.reflect.g;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.ag;
import kotlin.reflect.jvm.internal.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.c.a.n;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.c.a.f;
import kotlin.reflect.jvm.internal.impl.d.c.a.j;
import kotlin.reflect.jvm.internal.l;
import kotlin.reflect.jvm.internal.w;
import kotlin.reflect.l;

@Metadata(bv={1, 0, 2}, d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 ;*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004:;<=B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0010J\n\u00101\u001a\u0004\u0018\u00010\u0015H\u0004J\u0013\u00102\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u001e\u00104\u001a\u0004\u0018\u00010\n2\b\u00105\u001a\u0004\u0018\u00010\u00152\b\u00106\u001a\u0004\u0018\u00010\nH\u0004J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0007H\u0016R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\r0\r0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010(R\u0014\u0010)\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010(R\u0013\u0010+\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010/\u00a8\u0006>"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public abstract class v<R>
extends kotlin.reflect.jvm.internal.h<R>
implements kotlin.reflect.l<R> {
    public static final b a = new b(null);
    private static final Object h = new Object();
    private final ac.a<Field> b;
    private final ac.a<ai> c;
    private final l d;
    private final String e;
    private final String f;
    private final Object g;

    public v(l l2, String string2, String string3, Object object) {
        kotlin.e.b.j.b(l2, "container");
        kotlin.e.b.j.b(string2, "name");
        kotlin.e.b.j.b(string3, "signature");
        this(l2, string2, string3, null, object);
    }

    private v(l l2, String string2, String string3, ai ai2, Object object) {
        this.d = l2;
        this.e = string2;
        this.f = string3;
        this.g = object;
        this.b = ac.b((kotlin.e.a.a)new kotlin.e.a.a<Field>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public final Field b() {
                Object object = ag.a.a(this.t());
                if (object instanceof g.c) {
                    object = (g.c)object;
                    ai ai2 = ((g.c)object).b();
                    f.a a2 = j.a.a(((g.c)object).c(), ((g.c)object).e(), ((g.c)object).f());
                    if (a2 == null) return null;
                    object = !n.a(ai2) && !j.a(((g.c)object).c()) ? ((object = ai2.b()) instanceof kotlin.reflect.jvm.internal.impl.a.e ? kotlin.reflect.jvm.internal.ai.a((kotlin.reflect.jvm.internal.impl.a.e)object) : this.f().a()) : this.f().a().getEnclosingClass();
                    if (object == null) {
                        return null;
                    }
                    return ((Class)object).getDeclaredField(a2.a());
                }
                if (object instanceof g.a) {
                    return ((g.a)object).b();
                }
                if (object instanceof g.b) {
                    return null;
                }
                if (!(object instanceof g.d)) throw new kotlin.m();
                return null;
                catch (NoSuchFieldException noSuchFieldException) {
                    return null;
                }
            }
        });
        this.c = ac.a(ai2, (kotlin.e.a.a)new kotlin.e.a.a<ai>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final ai b() {
                return this.f().a(this.g(), this.u());
            }
        });
    }

    public v(l l2, ai ai2) {
        kotlin.e.b.j.b(l2, "container");
        kotlin.e.b.j.b(ai2, "descriptor");
        String string2 = ai2.h_().a();
        kotlin.e.b.j.a((Object)string2, "descriptor.name.asString()");
        this(l2, string2, ag.a.a(ai2).a(), ai2, kotlin.e.b.c.b);
    }

    protected final Object a(Field object, Object object2) {
        block4 : {
            try {
                if (object2 == h && this.t().d() == null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append('\'');
                    ((StringBuilder)object).append(this);
                    ((StringBuilder)object).append("' is not an extension property and thus getExtensionDelegate() ");
                    ((StringBuilder)object).append("is not going to work, use getDelegate() instead");
                    throw (Throwable)new RuntimeException(((StringBuilder)object).toString());
                }
                if (object == null) break block4;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw (Throwable)new kotlin.reflect.a.b(illegalAccessException);
            }
            object = ((Field)object).get(object2);
            return object;
        }
        return null;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b c() {
        return this.t();
    }

    @Override
    public kotlin.reflect.jvm.internal.d<?> d() {
        return this.q().d();
    }

    @Override
    public kotlin.reflect.jvm.internal.d<?> e() {
        return this.q().e();
    }

    public boolean equals(Object v2) {
        boolean bl2;
        v2 = kotlin.reflect.jvm.internal.ai.b(v2);
        boolean bl3 = bl2 = false;
        if (v2 != null) {
            bl3 = bl2;
            if (kotlin.e.b.j.a((Object)this.f(), (Object)v2.f())) {
                bl3 = bl2;
                if (kotlin.e.b.j.a((Object)this.g(), (Object)v2.g())) {
                    bl3 = bl2;
                    if (kotlin.e.b.j.a((Object)this.f, (Object)v2.f)) {
                        bl3 = bl2;
                        if (kotlin.e.b.j.a(this.g, v2.g)) {
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
        return this.d;
    }

    @Override
    public String g() {
        return this.e;
    }

    @Override
    public boolean h() {
        return kotlin.e.b.j.a(this.g, kotlin.e.b.c.b) ^ true;
    }

    public int hashCode() {
        return (this.f().hashCode() * 31 + this.g().hashCode()) * 31 + this.f.hashCode();
    }

    public abstract c<R> q();

    public final Field r() {
        return this.b.a();
    }

    protected final Field s() {
        if (this.t().B()) {
            return this.r();
        }
        return null;
    }

    public ai t() {
        ai ai2 = this.c.a();
        kotlin.e.b.j.a((Object)ai2, "_descriptor()");
        return ai2;
    }

    public String toString() {
        return ae.a.a(this.t());
    }

    public final String u() {
        return this.f;
    }

    public final Object v() {
        return this.g;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static abstract class a<PropertyType, ReturnType>
    extends kotlin.reflect.jvm.internal.h<ReturnType>
    implements kotlin.reflect.f<ReturnType>,
    l.a<PropertyType> {
        @Override
        public kotlin.reflect.jvm.internal.d<?> e() {
            return null;
        }

        @Override
        public l f() {
            return this.l().f();
        }

        @Override
        public boolean h() {
            return this.l().h();
        }

        public abstract v<PropertyType> l();

        public abstract ah n();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.e.b.g g2) {
            this();
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static abstract class c<R>
    extends kotlin.reflect.jvm.internal.v$a<R, R>
    implements l.b<R> {
        static final /* synthetic */ kotlin.reflect.l[] a;
        private final ac.a b = ac.b((kotlin.e.a.a)new kotlin.e.a.a<aj>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final aj b() {
                aj aj2 = this.l().t().a();
                if (aj2 != null) {
                    return aj2;
                }
                return kotlin.reflect.jvm.internal.impl.h.b.b(this.l().t(), h.a.a());
            }
        });
        private final ac.a c = ac.b(new kotlin.e.a.a<kotlin.reflect.jvm.internal.d<?>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.d<?> b() {
                return w.a(this, true);
            }
        });

        static {
            a = new kotlin.reflect.l[]{kotlin.e.b.v.a(new t(kotlin.e.b.v.a(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), kotlin.e.b.v.a(new t(kotlin.e.b.v.a(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b c() {
            return this.p();
        }

        @Override
        public kotlin.reflect.jvm.internal.d<?> d() {
            return (kotlin.reflect.jvm.internal.d)this.c.a(this, a[1]);
        }

        @Override
        public String g() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<get-");
            stringBuilder.append(this.l().g());
            stringBuilder.append('>');
            return stringBuilder.toString();
        }

        @Override
        public /* synthetic */ ah n() {
            return this.p();
        }

        public aj p() {
            return (aj)this.b.a(this, a[0]);
        }

    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static abstract class d<R>
    extends kotlin.reflect.jvm.internal.v$a<R, kotlin.w>
    implements g.a<R> {
        static final /* synthetic */ kotlin.reflect.l[] a;
        private final ac.a b = ac.b((kotlin.e.a.a)new kotlin.e.a.a<ak>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final ak b() {
                ak ak2 = this.l().t().c();
                if (ak2 != null) {
                    return ak2;
                }
                return kotlin.reflect.jvm.internal.impl.h.b.a(this.l().t(), h.a.a());
            }
        });
        private final ac.a c = ac.b(new kotlin.e.a.a<kotlin.reflect.jvm.internal.d<?>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.d<?> b() {
                return w.a(this, false);
            }
        });

        static {
            a = new kotlin.reflect.l[]{kotlin.e.b.v.a(new t(kotlin.e.b.v.a(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), kotlin.e.b.v.a(new t(kotlin.e.b.v.a(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b c() {
            return this.m();
        }

        @Override
        public kotlin.reflect.jvm.internal.d<?> d() {
            return (kotlin.reflect.jvm.internal.d)this.c.a(this, a[1]);
        }

        @Override
        public String g() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<set-");
            stringBuilder.append(this.l().g());
            stringBuilder.append('>');
            return stringBuilder.toString();
        }

        public ak m() {
            return (ak)this.b.a(this, a[0]);
        }

        @Override
        public /* synthetic */ ah n() {
            return this.m();
        }

    }

}

