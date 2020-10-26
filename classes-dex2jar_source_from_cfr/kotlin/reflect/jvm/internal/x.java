/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.m;
import kotlin.n;
import kotlin.reflect.d;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.ai;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.j;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.jvm.internal.z;
import kotlin.reflect.l;
import kotlin.reflect.p;
import kotlin.reflect.r;

@Metadata(bv={1, 0, 2}, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00068@X\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006%\u00b2\u0006\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u008a\u0084\u0002\u00a2\u0006\u0000"}, d2={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflect_api", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflect-api", "parameterizedTypeArguments"}, k=1, mv={1, 1, 11})
public final class x
implements p {
    static final /* synthetic */ l[] a;
    private final ac.a b;
    private final ac.a c;
    private final ac.a d;
    private final w e;

    static {
        a = new l[]{v.a(new t(v.a(x.class), "javaType", "getJavaType$kotlin_reflect_api()Ljava/lang/reflect/Type;")), v.a(new t(v.a(x.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), v.a(new t(v.a(x.class), "arguments", "getArguments()Ljava/util/List;")), v.a(new kotlin.e.b.r(v.a(x.class), "parameterizedTypeArguments", "<v#0>"))};
    }

    public x(w w2, kotlin.e.a.a<? extends Type> a2) {
        kotlin.e.b.j.b(w2, "type");
        kotlin.e.b.j.b(a2, "computeJavaType");
        this.e = w2;
        this.b = ac.b(a2);
        this.c = ac.b((kotlin.e.a.a)new kotlin.e.a.a<d>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final d b() {
                return this.a(this.d());
            }
        });
        this.d = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends r>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<r> b() {
                Object object = this.d().a();
                if (object.isEmpty()) {
                    return kotlin.a.m.a();
                }
                final g g2 = kotlin.h.a(kotlin.l.b, (kotlin.e.a.a)new kotlin.e.a.a<List<? extends Type>>(){

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public final List<Type> b() {
                        return kotlin.reflect.jvm.internal.c.b.a(this.c());
                    }
                });
                final l l2 = x.a[3];
                object = (Iterable)object;
                Collection collection = new ArrayList(kotlin.a.m.a(object, 10));
                final int n2 = 0;
                Iterator<ap> iterator = object.iterator();
                while (iterator.hasNext()) {
                    object = iterator.next();
                    if (object.a()) {
                        object = r.a.a();
                    } else {
                        Object object2 = object.c();
                        kotlin.e.b.j.a(object2, "typeProjection.type");
                        object2 = new x((w)object2, (kotlin.e.a.a<? extends Type>)new kotlin.e.a.a<Type>(){

                            @Override
                            public /* synthetic */ Object a() {
                                return this.b();
                            }

                            /*
                             * Enabled aggressive block sorting
                             */
                            public final Type b() {
                                void var1_7;
                                Object object;
                                Type type = this.c();
                                if (type instanceof Class) {
                                    void var1_5;
                                    Class class_ = (Class)type;
                                    if (class_.isArray()) {
                                        Class<?> class_2 = class_.getComponentType();
                                    } else {
                                        Class<Object> class_3 = Object.class;
                                    }
                                    kotlin.e.b.j.a((Object)var1_5, "if (javaType.isArray) ja\u2026Type else Any::class.java");
                                    return (Type)var1_5;
                                }
                                if (type instanceof GenericArrayType) {
                                    if (n2 != 0) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Array type has been queried for a non-0th argument: ");
                                        stringBuilder.append(this);
                                        throw (Throwable)new aa(stringBuilder.toString());
                                    }
                                    Type type2 = ((GenericArrayType)type).getGenericComponentType();
                                    object = "javaType.genericComponentType";
                                } else {
                                    if (!(type instanceof ParameterizedType)) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Non-generic type has been queried for arguments: ");
                                        stringBuilder.append(this);
                                        throw (Throwable)new aa(stringBuilder.toString());
                                    }
                                    g g22 = g2;
                                    object = l2;
                                    Type type3 = (Type)((List)g22.a()).get(n2);
                                    if (type3 instanceof WildcardType) {
                                        object = (WildcardType)type3;
                                        Type[] arrtype = object.getLowerBounds();
                                        kotlin.e.b.j.a((Object)arrtype, "argument.lowerBounds");
                                        Type type4 = kotlin.a.g.d(arrtype);
                                        if (type4 == null) {
                                            Type[] arrtype2 = object.getUpperBounds();
                                            kotlin.e.b.j.a((Object)arrtype2, "argument.upperBounds");
                                            Type type5 = kotlin.a.g.c(arrtype2);
                                        }
                                    }
                                    object = "if (argument !is Wildcar\u2026ument.upperBounds.first()";
                                }
                                kotlin.e.b.j.a((Object)var1_7, (String)object);
                                return var1_7;
                            }
                        });
                        object = object.b();
                        switch (y.a[((Enum)object).ordinal()]) {
                            default: {
                                throw new m();
                            }
                            case 3: {
                                object = r.a.c((p)object2);
                                break;
                            }
                            case 2: {
                                object = r.a.b((p)object2);
                                break;
                            }
                            case 1: {
                                object = r.a.a((p)object2);
                            }
                        }
                    }
                    collection.add(object);
                    ++n2;
                }
                return (List)collection;
            }

        });
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final d a(w object) {
        Object object2 = ((w)object).g().d();
        if (object2 instanceof kotlin.reflect.jvm.internal.impl.a.e) {
            if ((object2 = ai.a((kotlin.reflect.jvm.internal.impl.a.e)object2)) == null) return null;
            if (((Class)object2).isArray()) {
                if ((object = kotlin.a.m.k(((w)object).a())) != null && (object = object.c()) != null) {
                    kotlin.e.b.j.a(object, "argument");
                    object = this.a((w)object);
                    if (object != null) {
                        return new j(kotlin.reflect.jvm.internal.c.b.g(kotlin.e.a.a(kotlin.reflect.jvm.b.a(object))));
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Cannot determine classifier for array element type: ");
                    ((StringBuilder)object).append(this);
                    throw (Throwable)new aa(((StringBuilder)object).toString());
                }
                object = new j(object2);
                do {
                    return (d)object;
                    break;
                } while (true);
            }
            if (!av.f((w)object)) {
                Class<?> class_ = kotlin.reflect.jvm.internal.c.b.c(object2);
                object = object2;
                if (class_ != null) {
                    object = class_;
                }
                object = new j(object);
                return (d)object;
            }
            object = new j(object2);
            return (d)object;
        }
        if (object2 instanceof as) {
            object = new z((as)object2);
            return (d)object;
        }
        if (!(object2 instanceof ar)) {
            return null;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("An operation is not implemented: ");
        ((StringBuilder)object).append("Type alias classifiers are not yet supported");
        throw (Throwable)new n(((StringBuilder)object).toString());
    }

    @Override
    public d a() {
        return (d)this.c.a(this, a[1]);
    }

    @Override
    public boolean b() {
        return this.e.c();
    }

    public final Type c() {
        return (Type)this.b.a(this, a[0]);
    }

    public final w d() {
        return this.e;
    }

    public boolean equals(Object object) {
        return object instanceof x && kotlin.e.b.j.a((Object)this.e, (Object)((x)object).e);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        return ae.a.a(this.e);
    }

}

