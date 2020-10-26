/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.ah;
import kotlin.reflect.jvm.internal.f;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.c.a.n;
import kotlin.reflect.jvm.internal.impl.c.b.i;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.d.c.a.f;
import kotlin.reflect.jvm.internal.impl.d.c.a.j;
import kotlin.reflect.jvm.internal.impl.d.c.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0004\t\n\u000b\f\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public abstract class g {
    private g() {
    }

    public /* synthetic */ g(kotlin.e.b.g g2) {
        this();
    }

    public abstract String a();

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class a
    extends g {
        private final Field a;

        public a(Field field) {
            kotlin.e.b.j.b(field, "field");
            super(null);
            this.a = field;
        }

        @Override
        public String a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n.c(this.a.getName()));
            stringBuilder.append("()");
            Class<?> class_ = this.a.getType();
            kotlin.e.b.j.a(class_, "field.type");
            stringBuilder.append(kotlin.reflect.jvm.internal.c.b.f(class_));
            return stringBuilder.toString();
        }

        public final Field b() {
            return this.a;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class b
    extends g {
        private final Method a;
        private final Method b;

        public b(Method method, Method method2) {
            kotlin.e.b.j.b(method, "getterMethod");
            super(null);
            this.a = method;
            this.b = method2;
        }

        @Override
        public String a() {
            return ah.a(this.a);
        }

        public final Method b() {
            return this.a;
        }

        public final Method c() {
            return this.b;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class c
    extends g {
        private final String a;
        private final ai b;
        private final a.w c;
        private final b.e d;
        private final kotlin.reflect.jvm.internal.impl.d.b.c e;
        private final h f;

        public c(ai object, a.w object2, b.e serializable, kotlin.reflect.jvm.internal.impl.d.b.c c2, h h2) {
            block4 : {
                block3 : {
                    block2 : {
                        kotlin.e.b.j.b(object, "descriptor");
                        kotlin.e.b.j.b(object2, "proto");
                        kotlin.e.b.j.b(serializable, "signature");
                        kotlin.e.b.j.b(c2, "nameResolver");
                        kotlin.e.b.j.b(h2, "typeTable");
                        super(null);
                        this.b = object;
                        this.c = object2;
                        this.d = serializable;
                        this.e = c2;
                        this.f = h2;
                        if (!this.d.j()) break block2;
                        object = new StringBuilder();
                        object2 = this.e;
                        serializable = this.d.k();
                        kotlin.e.b.j.a((Object)serializable, "signature.getter");
                        ((StringBuilder)object).append(object2.a(((b.c)serializable).e()));
                        object2 = this.e;
                        serializable = this.d.k();
                        kotlin.e.b.j.a((Object)serializable, "signature.getter");
                        ((StringBuilder)object).append(object2.a(((b.c)serializable).g()));
                        object = ((StringBuilder)object).toString();
                        break block3;
                    }
                    object2 = j.a.a(this.c, this.e, this.f);
                    if (object2 == null) break block4;
                    object = ((f.a)object2).d();
                    object2 = ((f.a)object2).e();
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append(n.c((String)object));
                    ((StringBuilder)serializable).append(this.g());
                    ((StringBuilder)serializable).append("()");
                    ((StringBuilder)serializable).append((String)object2);
                    object = ((StringBuilder)serializable).toString();
                }
                this.a = object;
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("No field signature for property: ");
            ((StringBuilder)object).append(this.b);
            throw (Throwable)new aa(((StringBuilder)object).toString());
        }

        /*
         * Enabled aggressive block sorting
         */
        private final String g() {
            block7 : {
                Object object;
                Object object2;
                block6 : {
                    block5 : {
                        object = this.b.b();
                        if (!kotlin.e.b.j.a((Object)this.b.p(), (Object)az.d) || !(object instanceof e)) break block5;
                        object = ((e)object).H();
                        object2 = kotlin.reflect.jvm.internal.impl.d.c.b.i;
                        kotlin.e.b.j.a(object2, "JvmProtoBuf.classModuleName");
                        object = kotlin.reflect.jvm.internal.impl.d.b.f.a(object, object2);
                        if (object == null || (object = this.e.a(((Number)object).intValue())) == null) {
                            object = "main";
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("$");
                        object = kotlin.reflect.jvm.internal.impl.e.g.a((String)object);
                        break block6;
                    }
                    if (!kotlin.e.b.j.a((Object)this.b.p(), (Object)az.a) || !(object instanceof ab)) break block7;
                    object = this.b;
                    if (object == null) {
                        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                    }
                    if (!((object = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j)object).O()) instanceof i) || ((i)(object = (i)object)).e() == null) break block7;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("$");
                    object = ((i)object).b().a();
                }
                ((StringBuilder)object2).append((String)object);
                return ((StringBuilder)object2).toString();
            }
            return "";
        }

        @Override
        public String a() {
            return this.a;
        }

        public final ai b() {
            return this.b;
        }

        public final a.w c() {
            return this.c;
        }

        public final b.e d() {
            return this.d;
        }

        public final kotlin.reflect.jvm.internal.impl.d.b.c e() {
            return this.e;
        }

        public final h f() {
            return this.f;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class d
    extends g {
        private final f.e a;
        private final f.e b;

        public d(f.e e2, f.e e3) {
            kotlin.e.b.j.b(e2, "getterSignature");
            super(null);
            this.a = e2;
            this.b = e3;
        }

        @Override
        public String a() {
            return this.a.a();
        }

        public final f.e b() {
            return this.a;
        }

        public final f.e c() {
            return this.b;
        }
    }

}

