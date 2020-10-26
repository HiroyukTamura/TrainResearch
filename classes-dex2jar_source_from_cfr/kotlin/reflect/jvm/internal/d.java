/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001f\b \u0018\u0000 /*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u001b#$%&'()*+,-./0123456789:;<=B1\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\u0002\u0010\u000bJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH&\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u001f2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH\u0014\u00a2\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0004R\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00028\u0000X\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006>"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller;", "M", "Ljava/lang/reflect/Member;", "", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "arity", "", "getArity", "()I", "getInstanceClass$kotlin_reflect_api", "()Ljava/lang/Class;", "getMember$kotlin_reflect_api", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType$kotlin_reflect_api", "()Ljava/lang/reflect/Type;", "call", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "checkObjectInstance", "obj", "BoundClassCompanionFieldGetter", "BoundClassCompanionFieldSetter", "BoundConstructor", "BoundInstanceFieldGetter", "BoundInstanceFieldSetter", "BoundInstanceMethod", "BoundJvmStaticInObject", "BoundJvmStaticInObjectFieldGetter", "BoundJvmStaticInObjectFieldSetter", "BoundStaticMethod", "ClassCompanionFieldGetter", "ClassCompanionFieldSetter", "Companion", "Constructor", "FieldGetter", "FieldSetter", "InstanceFieldGetter", "InstanceFieldSetter", "InstanceMethod", "JvmStaticInObject", "JvmStaticInObjectFieldGetter", "JvmStaticInObjectFieldSetter", "Method", "StaticFieldGetter", "StaticFieldSetter", "StaticMethod", "ThrowingCaller", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public abstract class d<M extends Member> {
    public static final m a = new m(null);
    private final List<Type> b;
    private final M c;
    private final Type d;
    private final Class<?> e;

    public d(M object, Type object2, Class<?> class_, Type[] arrtype) {
        block3 : {
            block2 : {
                kotlin.e.b.j.b(object2, "returnType");
                kotlin.e.b.j.b(arrtype, "valueParameterTypes");
                this.c = object;
                this.d = object2;
                this.e = class_;
                object = this.e;
                if (object == null) break block2;
                object2 = new kotlin.e.b.x(2);
                ((kotlin.e.b.x)object2).b((Type)object);
                ((kotlin.e.b.x)object2).a((Object)arrtype);
                object = kotlin.a.m.b((Type[])((kotlin.e.b.x)object2).a(new Type[((kotlin.e.b.x)object2).a()]));
                if (object != null) break block3;
            }
            object = kotlin.a.g.h(arrtype);
        }
        this.b = object;
    }

    public abstract Object a(Object[] var1);

    public final List<Type> a() {
        return this.b;
    }

    protected final void a(Object object) {
        if (object != null) {
            M m2 = this.c;
            if (m2 == null) {
                kotlin.e.b.j.a();
            }
            if (m2.getDeclaringClass().isInstance(object)) {
                return;
            }
        }
        throw (Throwable)new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
    }

    public final int b() {
        return this.b.size();
    }

    protected void b(Object[] arrobject) {
        kotlin.e.b.j.b(arrobject, "args");
        if (this.b() == arrobject.length) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Callable expects ");
        stringBuilder.append(this.b());
        stringBuilder.append(" arguments, but ");
        stringBuilder.append(arrobject.length);
        stringBuilder.append(" were provided.");
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    public final M c() {
        return this.c;
    }

    public final Type d() {
        return this.d;
    }

    public final Class<?> e() {
        return this.e;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class a
    extends o {
        private final Object b;

        public a(Field field, Object object) {
            kotlin.e.b.j.b(field, "field");
            super(field, false);
            this.b = object;
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return ((Field)this.c()).get(this.b);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$ThrowingCaller;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "", "()V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class aa
    extends d {
        public static final aa b = new aa();

        private aa() {
            Class<Void> class_ = Void.TYPE;
            kotlin.e.b.j.a(class_, "Void.TYPE");
            super(null, class_, null, new Type[0]);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            throw (Throwable)new UnsupportedOperationException("call/callBy are not supported for this declaration.");
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class b
    extends d<Field> {
        public b(Field object, Class<?> class_) {
            kotlin.e.b.j.b(object, "field");
            kotlin.e.b.j.b(class_, "klass");
            Member member = (Member)object;
            Type type = Void.TYPE;
            kotlin.e.b.j.a(type, "Void.TYPE");
            type = type;
            object = ((Field)object).getGenericType();
            kotlin.e.b.j.a(object, "field.genericType");
            super(member, type, class_, new Type[]{object});
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            ((Field)this.c()).set(null, kotlin.a.g.e(arrobject));
            return kotlin.w.a;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundConstructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class c
    extends d<Constructor<?>> {
        private final Object b;

        public c(Constructor<?> arrtype, Object object) {
            kotlin.e.b.j.b(arrtype, "constructor");
            Member member = (Member)arrtype;
            Type type = arrtype.getDeclaringClass();
            kotlin.e.b.j.a(type, "constructor.declaringClass");
            type = type;
            arrtype = arrtype.getGenericParameterTypes();
            kotlin.e.b.j.a((Object)arrtype, "constructor.genericParameterTypes");
            super(member, type, null, arrtype);
            this.b = object;
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            Constructor constructor = (Constructor)this.c();
            arrobject = d.a.a(this.b, arrobject);
            return constructor.newInstance(Arrays.copyOf(arrobject, arrobject.length));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class d
    extends o {
        private final Object b;

        public d(Field field, Object object) {
            kotlin.e.b.j.b(field, "field");
            super(field, false);
            this.b = object;
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return ((Field)this.c()).get(this.b);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class e
    extends p {
        private final Object b;

        public e(Field field, boolean bl2, Object object) {
            kotlin.e.b.j.b(field, "field");
            super(field, bl2, false);
            this.b = object;
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            ((Field)this.c()).set(this.b, kotlin.a.g.c(arrobject));
            return kotlin.w.a;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class f
    extends w {
        private final Object b;

        public f(Method method, Object object) {
            kotlin.e.b.j.b(method, "method");
            super(method, false, null, 4, null);
            this.b = object;
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return this.a(this.b, arrobject);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class g
    extends w {
        public g(Method method) {
            kotlin.e.b.j.b(method, "method");
            super(method, false, null, 4, null);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return this.a(null, arrobject);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class h
    extends o {
        public h(Field field) {
            kotlin.e.b.j.b(field, "field");
            super(field, false);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class i
    extends p {
        public i(Field field, boolean bl2) {
            kotlin.e.b.j.b(field, "field");
            super(field, bl2, false);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            ((Field)this.c()).set(null, kotlin.a.g.e(arrobject));
            return kotlin.w.a;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundStaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class j
    extends w {
        private final Object b;

        public j(Method method, Object object) {
            block4 : {
                Type[] arrtype;
                block3 : {
                    block2 : {
                        kotlin.e.b.j.b(method, "method");
                        arrtype = d.a;
                        arrtype = method.getGenericParameterTypes();
                        kotlin.e.b.j.a((Object)arrtype, "method.genericParameterTypes");
                        if (arrtype.length > 1) break block2;
                        arrtype = new Type[]{};
                        break block3;
                    }
                    arrtype = Arrays.copyOfRange(arrtype, 1, arrtype.length);
                    kotlin.e.b.j.a((Object)arrtype, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
                    if (arrtype == null) break block4;
                }
                super(method, false, arrtype);
                this.b = object;
                return;
            }
            throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return this.a(null, d.a.a(this.b, arrobject));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class k
    extends d<Field> {
        public k(Field object, Class<?> class_) {
            kotlin.e.b.j.b(object, "field");
            kotlin.e.b.j.b(class_, "klass");
            Member member = (Member)object;
            object = ((Field)object).getGenericType();
            kotlin.e.b.j.a(object, "field.genericType");
            super(member, (Type)object, class_, new Type[0]);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return ((Field)this.c()).get(kotlin.a.g.c(arrobject));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class l
    extends d<Field> {
        public l(Field object, Class<?> class_) {
            kotlin.e.b.j.b(object, "field");
            kotlin.e.b.j.b(class_, "klass");
            Member member = (Member)object;
            Type type = Void.TYPE;
            kotlin.e.b.j.a(type, "Void.TYPE");
            type = type;
            object = ((Field)object).getGenericType();
            kotlin.e.b.j.a(object, "field.genericType");
            super(member, type, class_, new Type[]{object});
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            ((Field)this.c()).set(null, kotlin.a.g.e(arrobject));
            return kotlin.w.a;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0004\"\u0006\b\u0001\u0010\t\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u0004H\u0086\b\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004*\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\n\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$Companion;", "", "()V", "argsWithReceiver", "", "receiver", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirst", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstArg", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class m {
        private m() {
        }

        public /* synthetic */ m(kotlin.e.b.g g2) {
            this();
        }

        public final Object[] a(Object object, Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            Object[] arrobject2 = new Object[arrobject.length + 1];
            arrobject2[0] = object;
            System.arraycopy(arrobject, 0, arrobject2, 1, arrobject.length);
            return arrobject2;
        }

        public final Object[] a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "$receiver");
            m m2 = this;
            if (arrobject.length <= 1) {
                return new Object[0];
            }
            arrobject = Arrays.copyOfRange(arrobject, 1, arrobject.length);
            kotlin.e.b.j.a((Object)arrobject, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
            if (arrobject != null) {
                return arrobject;
            }
            throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$Constructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class n
    extends d<Constructor<?>> {
        public n(Constructor<?> arrtype) {
            kotlin.e.b.j.b(arrtype, "constructor");
            Member member = (Member)arrtype;
            Class<?> class_ = arrtype.getDeclaringClass();
            kotlin.e.b.j.a(class_, "constructor.declaringClass");
            Type type = class_;
            Class<?> class_2 = arrtype.getDeclaringClass();
            kotlin.e.b.j.a(class_2, "klass");
            class_ = class_2.getDeclaringClass();
            if (class_ == null || Modifier.isStatic(class_2.getModifiers())) {
                class_ = null;
            }
            arrtype = arrtype.getGenericParameterTypes();
            kotlin.e.b.j.a((Object)arrtype, "constructor.genericParameterTypes");
            super(member, type, class_, arrtype);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return ((Constructor)this.c()).newInstance(Arrays.copyOf(arrobject, arrobject.length));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static abstract class o
    extends d<Field> {
        public o(Field annotatedElement, boolean bl2) {
            kotlin.e.b.j.b(annotatedElement, "field");
            Member member = annotatedElement;
            Type type = annotatedElement.getGenericType();
            kotlin.e.b.j.a((Object)type, "field.genericType");
            annotatedElement = bl2 ? annotatedElement.getDeclaringClass() : null;
            super(member, type, (Class<?>)annotatedElement, new Type[0]);
        }

        public /* synthetic */ o(Field field, boolean bl2, int n2, kotlin.e.b.g g2) {
            if ((n2 & 2) != 0) {
                bl2 = Modifier.isStatic(field.getModifiers()) ^ true;
            }
            this(field, bl2);
        }

        @Override
        public Object a(Object[] object) {
            kotlin.e.b.j.b(object, "args");
            this.b((Object[])object);
            Field field = (Field)this.c();
            object = this.e() != null ? kotlin.a.g.c(object) : null;
            return field.get(object);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0014\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static abstract class p
    extends d<Field> {
        private final boolean b;

        public p(Field object, boolean bl2, boolean bl3) {
            kotlin.e.b.j.b(object, "field");
            Member member = (Member)object;
            Class<Void> class_ = Void.TYPE;
            kotlin.e.b.j.a(class_, "Void.TYPE");
            Type type = class_;
            class_ = bl3 ? ((Field)object).getDeclaringClass() : null;
            object = ((Field)object).getGenericType();
            kotlin.e.b.j.a(object, "field.genericType");
            super(member, type, class_, new Type[]{object});
            this.b = bl2;
        }

        public /* synthetic */ p(Field field, boolean bl2, boolean bl3, int n2, kotlin.e.b.g g2) {
            if ((n2 & 4) != 0) {
                bl3 = Modifier.isStatic(field.getModifiers()) ^ true;
            }
            this(field, bl2, bl3);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            Field field = (Field)this.c();
            Object object = this.e() != null ? kotlin.a.g.c(arrobject) : null;
            field.set(object, kotlin.a.g.e(arrobject));
            return kotlin.w.a;
        }

        @Override
        protected void b(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            super.b(arrobject);
            if (this.b) {
                if (kotlin.a.g.e(arrobject) != null) {
                    return;
                }
                throw (Throwable)new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class q
    extends o {
        public q(Field field) {
            kotlin.e.b.j.b(field, "field");
            super(field, false, 2, null);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class r
    extends p {
        public r(Field field, boolean bl2) {
            kotlin.e.b.j.b(field, "field");
            super(field, bl2, false, 4, null);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class s
    extends w {
        public s(Method method) {
            kotlin.e.b.j.b(method, "method");
            super(method, false, null, 6, null);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return this.a(arrobject[0], d.a.a(arrobject));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class t
    extends w {
        public t(Method method) {
            kotlin.e.b.j.b(method, "method");
            super(method, true, null, 4, null);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            this.a(kotlin.a.g.d(arrobject));
            return this.a(null, d.a.a(arrobject));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class u
    extends o {
        public u(Field field) {
            kotlin.e.b.j.b(field, "field");
            super(field, true);
        }

        @Override
        protected void b(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            super.b(arrobject);
            this.a(kotlin.a.g.d(arrobject));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0014\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class v
    extends p {
        public v(Field field, boolean bl2) {
            kotlin.e.b.j.b(field, "field");
            super(field, bl2, true);
        }

        @Override
        protected void b(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            super.b(arrobject);
            this.a(kotlin.a.g.d(arrobject));
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static abstract class w
    extends d<Method> {
        private final boolean b;

        public w(Method genericDeclaration, boolean bl2, Type[] arrtype) {
            kotlin.e.b.j.b(genericDeclaration, "method");
            kotlin.e.b.j.b(arrtype, "parameterTypes");
            Member member = genericDeclaration;
            Type type = genericDeclaration.getGenericReturnType();
            kotlin.e.b.j.a((Object)type, "method.genericReturnType");
            genericDeclaration = bl2 ? genericDeclaration.getDeclaringClass() : null;
            super(member, type, (Class<?>)genericDeclaration, arrtype);
            this.b = kotlin.e.b.j.a((Object)this.d(), Void.TYPE);
        }

        public /* synthetic */ w(Method method, boolean bl2, Type[] arrtype, int n2, kotlin.e.b.g g2) {
            if ((n2 & 2) != 0) {
                bl2 = Modifier.isStatic(method.getModifiers()) ^ true;
            }
            if ((n2 & 4) != 0) {
                arrtype = method.getGenericParameterTypes();
                kotlin.e.b.j.a((Object)arrtype, "method.genericParameterTypes");
            }
            this(method, bl2, arrtype);
        }

        protected final Object a(Object object, Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            object = ((Method)this.c()).invoke(object, Arrays.copyOf(arrobject, arrobject.length));
            if (this.b) {
                object = kotlin.w.a;
            }
            return object;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class x
    extends o {
        public x(Field field) {
            kotlin.e.b.j.b(field, "field");
            super(field, false, 2, null);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class y
    extends p {
        public y(Field field, boolean bl2) {
            kotlin.e.b.j.b(field, "field");
            super(field, bl2, false, 4, null);
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class z
    extends w {
        public z(Method method) {
            kotlin.e.b.j.b(method, "method");
            super(method, false, null, 6, null);
        }

        @Override
        public Object a(Object[] arrobject) {
            kotlin.e.b.j.b(arrobject, "args");
            this.b(arrobject);
            return this.a(null, arrobject);
        }
    }

}

