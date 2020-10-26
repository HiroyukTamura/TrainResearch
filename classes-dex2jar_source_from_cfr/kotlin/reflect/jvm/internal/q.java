/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.v;
import kotlin.o;
import kotlin.r;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.a.e;
import kotlin.reflect.jvm.internal.a.k;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.d.c.a.j;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.l;

@Metadata(bv={1, 0, 2}, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001,B\u001d\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012 \u000f*\b\u0018\u00010\u000eR\u00020\u00000\u000eR\u00020\u00000\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006-"}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "usageModuleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getUsageModuleName", "()Ljava/lang/String;", "equals", "", "other", "", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "toString", "Data", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class q
extends l {
    private final ac.b<a> a;
    private final Class<?> c;
    private final String d;

    public q(Class<?> class_, String string2) {
        kotlin.e.b.j.b(class_, "jClass");
        this.c = class_;
        this.d = string2;
        this.a = ac.a((kotlin.e.a.a)new kotlin.e.a.a<a>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final a b() {
                return new a();
            }
        });
    }

    private final kotlin.reflect.jvm.internal.impl.h.e.h c() {
        return this.a.a().a().c();
    }

    @Override
    public Class<?> a() {
        return this.c;
    }

    @Override
    public Collection<ai> a(f f2) {
        kotlin.e.b.j.b(f2, "name");
        return this.c().a(f2, d.h);
    }

    @Override
    public ai a(int n2) {
        Object object = this.a.a().c();
        kotlin.reflect.jvm.internal.impl.f.q q2 = null;
        Object object2 = q2;
        if (object != null) {
            kotlin.reflect.jvm.internal.impl.d.b.c c2 = ((r)object).d();
            i i2 = ((r)object).e();
            object = ((r)object).f();
            object2 = i2;
            Object object3 = kotlin.reflect.jvm.internal.impl.d.c.b.m;
            kotlin.e.b.j.a(object3, "JvmProtoBuf.packageLocalVariable");
            object3 = kotlin.reflect.jvm.internal.impl.d.b.f.a(object2, object3, n2);
            object2 = q2;
            if (object3 != null) {
                object2 = this.a();
                q2 = (kotlin.reflect.jvm.internal.impl.f.q)object3;
                c2 = c2;
                i2 = i2.p();
                kotlin.e.b.j.a((Object)i2, "packageProto.typeTable");
                object2 = (ai)kotlin.reflect.jvm.internal.ai.a(object2, q2, c2, new kotlin.reflect.jvm.internal.impl.d.b.h((a.ai)i2), (kotlin.reflect.jvm.internal.impl.d.b.a)object, c.c);
            }
        }
        return object2;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.l> b() {
        return kotlin.a.m.a();
    }

    @Override
    public Collection<t> b(f f2) {
        kotlin.e.b.j.b(f2, "name");
        return this.c().b(f2, d.h);
    }

    public boolean equals(Object object) {
        return object instanceof q && kotlin.e.b.j.a(this.a(), ((q)object).a());
    }

    public int hashCode() {
        return this.a().hashCode();
    }

    @Override
    protected Class<?> l() {
        return this.a.a().b();
    }

    public String toString() {
        Object object = kotlin.reflect.jvm.internal.c.b.e(this.a()).a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package ");
        kotlin.e.b.j.a(object, "fqName");
        if (((kotlin.reflect.jvm.internal.impl.e.b)object).c()) {
            object = "<default>";
        } else {
            object = ((kotlin.reflect.jvm.internal.impl.e.b)object).a();
            kotlin.e.b.j.a(object, "fqName.asString()");
        }
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR%\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!\u00a8\u0006#"}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PackageViewDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlinClass", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "getKotlinClass", "()Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "kotlinClass$delegate", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner$delegate", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    private final class kotlin.reflect.jvm.internal.q$a
    extends l.b {
        static final /* synthetic */ kotlin.reflect.l[] a;
        private final ac.a e;
        private final ac.a f;
        private final ac.b g;
        private final ac.b h;
        private final ac.a i;

        static {
            a = new kotlin.reflect.l[]{v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.q$a.class), "kotlinClass", "getKotlinClass()Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.q$a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.q$a.class), "methodOwner", "getMethodOwner()Ljava/lang/Class;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.q$a.class), "metadata", "getMetadata()Lkotlin/Triple;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.q$a.class), "members", "getMembers()Ljava/util/Collection;"))};
        }

        public kotlin.reflect.jvm.internal.q$a() {
            super((l)q.this);
            this.e = ac.b((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.a.e>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final kotlin.reflect.jvm.internal.a.e b() {
                    return kotlin.reflect.jvm.internal.a.e.a.a(q.this.a());
                }
            });
            this.f = ac.b((kotlin.e.a.a)new kotlin.e.a.a<ae>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final ae b() {
                    Object object = this.i();
                    Object object2 = this.d();
                    if (object2 != null && (object2 = kotlin.reflect.jvm.internal.ai.a((kotlin.reflect.jvm.internal.a.e)object2)) != null) {
                        ((kotlin.reflect.jvm.internal.a.j)object).c().a((String)object2);
                    }
                    object = ((kotlin.reflect.jvm.internal.a.j)object).a();
                    object2 = kotlin.reflect.jvm.internal.c.b.e(q.this.a()).a();
                    kotlin.e.b.j.a(object2, "jClass.classId.packageFqName");
                    return object.a((kotlin.reflect.jvm.internal.impl.e.b)object2);
                }
            });
            this.g = ac.a(new kotlin.e.a.a<Class<?>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final Class<?> b() {
                    boolean bl2;
                    Object object = this.d();
                    object = object != null && (object = ((kotlin.reflect.jvm.internal.a.e)object).d()) != null ? ((kotlin.reflect.jvm.internal.impl.c.b.a.a)object).a() : null;
                    if (object != null && (bl2 = ((CharSequence)object).length() > 0)) {
                        return q.this.a().getClassLoader().loadClass(kotlin.i.n.a((String)object, '/', '.', false, 4, null));
                    }
                    return q.this.a();
                }
            });
            this.h = ac.a((kotlin.e.a.a)new kotlin.e.a.a<r<? extends kotlin.reflect.jvm.internal.impl.d.c.a.h, ? extends a.s, ? extends g>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final r<kotlin.reflect.jvm.internal.impl.d.c.a.h, a.s, g> b() {
                    o<kotlin.reflect.jvm.internal.impl.d.c.a.h, a.s> o2;
                    Object object = this.d();
                    Serializable serializable = o2 = null;
                    if (object != null) {
                        object = ((kotlin.reflect.jvm.internal.a.e)object).d();
                        serializable = o2;
                        if (object != null) {
                            String[] arrstring = ((kotlin.reflect.jvm.internal.impl.c.b.a.a)object).f();
                            String[] arrstring2 = ((kotlin.reflect.jvm.internal.impl.c.b.a.a)object).h();
                            serializable = o2;
                            if (arrstring != null) {
                                serializable = o2;
                                if (arrstring2 != null) {
                                    serializable = j.b(arrstring, arrstring2);
                                    serializable = new r<kotlin.reflect.jvm.internal.impl.d.c.a.h, a.s, g>(serializable.c(), serializable.d(), ((kotlin.reflect.jvm.internal.impl.c.b.a.a)object).e());
                                }
                            }
                        }
                    }
                    return serializable;
                }
            });
            this.i = ac.b(new kotlin.e.a.a<List<? extends h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<h<?>> b() {
                    Object object = q.this.a(q.this.c(), l.c.a);
                    Collection collection = new ArrayList();
                    Iterator iterator = object.iterator();
                    while (iterator.hasNext()) {
                        Object t2 = iterator.next();
                        object = ((h)t2).c();
                        if (object != null) {
                            kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c c2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c)object;
                            object = c2.b();
                            if (object != null) {
                                object = (ab)object;
                                boolean bl2 = object instanceof kotlin.reflect.jvm.internal.impl.c.a.c.a.h;
                                Object var4_6 = null;
                                if (!bl2) {
                                    object = null;
                                }
                                object = (object = (kotlin.reflect.jvm.internal.impl.c.a.c.a.h)object) != null ? ((kotlin.reflect.jvm.internal.impl.c.a.c.a.h)object).y() : null;
                                Class<?> class_ = object;
                                if (!(object instanceof kotlin.reflect.jvm.internal.impl.c.b.o)) {
                                    class_ = null;
                                }
                                object = (object = (kotlin.reflect.jvm.internal.impl.c.b.o)((Object)class_)) != null ? ((kotlin.reflect.jvm.internal.impl.c.b.o)object).a(c2) : null;
                                class_ = object;
                                if (!(object instanceof kotlin.reflect.jvm.internal.a.e)) {
                                    class_ = null;
                                }
                                class_ = (kotlin.reflect.jvm.internal.a.e)((Object)class_);
                                object = var4_6;
                                if (class_ != null) {
                                    object = ((kotlin.reflect.jvm.internal.a.e)((Object)class_)).c();
                                }
                                if (!kotlin.e.b.j.a(object, q.this.a())) continue;
                                collection.add(t2);
                                continue;
                            }
                            throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor");
                        }
                        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor");
                    }
                    return (List)collection;
                }
            });
        }

        private final kotlin.reflect.jvm.internal.a.e d() {
            return (kotlin.reflect.jvm.internal.a.e)this.e.a(this, a[0]);
        }

        public final ae a() {
            return (ae)this.f.a(this, a[1]);
        }

        public final Class<?> b() {
            return (Class)this.g.a(this, a[2]);
        }

        public final r<kotlin.reflect.jvm.internal.impl.d.c.a.h, a.s, g> c() {
            return (r)this.h.a(this, a[3]);
        }

    }

}

