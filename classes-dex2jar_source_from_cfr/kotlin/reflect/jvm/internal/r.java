/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ae;
import kotlin.reflect.jvm.internal.ai;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.a.af;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.x;
import kotlin.reflect.k;
import kotlin.reflect.l;
import kotlin.reflect.p;

@Metadata(bv={1, 0, 2}, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class r
implements k {
    static final /* synthetic */ l[] a;
    private final ac.a b;
    private final ac.a c;
    private final h<?> d;
    private final int e;
    private final k.a f;

    static {
        a = new l[]{v.a(new t(v.a(r.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), v.a(new t(v.a(r.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public r(h<?> h2, int n2, k.a a2, kotlin.e.a.a<? extends af> a3) {
        j.b(h2, "callable");
        j.b((Object)a2, "kind");
        j.b(a3, "computeDescriptor");
        this.d = h2;
        this.e = n2;
        this.f = a2;
        this.b = ac.b(a3);
        this.c = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends Annotation>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<Annotation> b() {
                return ai.a(this.g());
            }
        });
    }

    private final af g() {
        return (af)this.b.a(this, a[0]);
    }

    @Override
    public int a() {
        return this.e;
    }

    @Override
    public String b() {
        Object object = this.g();
        boolean bl2 = object instanceof av;
        Object var3_3 = null;
        if (!bl2) {
            object = null;
        }
        av av2 = (av)object;
        object = var3_3;
        if (av2 != null) {
            if (av2.a().j()) {
                return null;
            }
            object = av2.h_();
            j.a(object, "name");
            if (((f)object).c()) {
                return null;
            }
            object = ((f)object).a();
        }
        return object;
    }

    @Override
    public p c() {
        w w2 = this.g().r();
        j.a((Object)w2, "descriptor.type");
        return new x(w2, (kotlin.e.a.a<? extends Type>)new kotlin.e.a.a<Type>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Type b() {
                return this.f().d().a().get(this.a());
            }
        });
    }

    @Override
    public k.a d() {
        return this.f;
    }

    @Override
    public boolean e() {
        af af2;
        af af3 = af2 = this.g();
        if (!(af2 instanceof av)) {
            af3 = null;
        }
        if ((af3 = (av)af3) != null) {
            return kotlin.reflect.jvm.internal.impl.h.c.a.a((av)af3);
        }
        return false;
    }

    public boolean equals(Object object) {
        if (object instanceof r) {
            h<?> h2 = this.d;
            object = (r)object;
            if (j.a(h2, ((r)object).d) && j.a((Object)this.g(), (Object)r.super.g())) {
                return true;
            }
        }
        return false;
    }

    public final h<?> f() {
        return this.d;
    }

    public int hashCode() {
        return this.d.hashCode() * 31 + this.g().hashCode();
    }

    @Override
    public List<Annotation> k() {
        return (List)this.c.a(this, a[1]);
    }

    public String toString() {
        return ae.a.a(this);
    }

}

