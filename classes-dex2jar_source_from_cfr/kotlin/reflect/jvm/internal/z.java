/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.n;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.x;
import kotlin.reflect.l;
import kotlin.reflect.p;
import kotlin.reflect.q;

@Metadata(bv={1, 0, 2}, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class z
implements q {
    static final /* synthetic */ l[] a;
    private final ac.a b;
    private final as c;

    static {
        a = new l[]{v.a(new t(v.a(z.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }

    public z(as as2) {
        j.b(as2, "descriptor");
        this.c = as2;
        this.b = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends x>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<x> b() {
                Collection<w> collection = this.b().j();
                j.a(collection, "descriptor.upperBounds");
                Object object = collection;
                collection = new ArrayList(m.a(object, 10));
                object = object.iterator();
                while (object.hasNext()) {
                    w w2 = (w)object.next();
                    j.a((Object)w2, "kotlinType");
                    collection.add((w)((Object)new x(w2, new kotlin.e.a.a(){

                        public /* synthetic */ Object a() {
                            return this.b();
                        }

                        public final Void b() {
                            CharSequence charSequence = new StringBuilder();
                            charSequence.append("Java type is not yet supported for type parameters: ");
                            charSequence.append(this.b());
                            charSequence = charSequence.toString();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("An operation is not implemented: ");
                            stringBuilder.append((String)charSequence);
                            throw (Throwable)new n(stringBuilder.toString());
                        }
                    })));
                }
                return collection;
            }

        });
    }

    @Override
    public List<p> a() {
        return (List)this.b.a(this, a[0]);
    }

    public as b() {
        return this.c;
    }

    public boolean equals(Object object) {
        return object instanceof z && j.a((Object)this.b(), (Object)((z)object).b());
    }

    public int hashCode() {
        return this.b().hashCode();
    }

    public String toString() {
        return ae.a.a(this.b());
    }

}

