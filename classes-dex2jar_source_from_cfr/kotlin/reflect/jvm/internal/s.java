/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.g;
import kotlin.h;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.v;
import kotlin.reflect.l;
import kotlin.reflect.m;

@Metadata(bv={1, 0, 2}, d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\r\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0019R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0012*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\u00110\u0010X\u0088\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public class s<R>
extends v<R>
implements m<R> {
    private final ac.b<a<R>> b;
    private final g<Object> c;

    public s(kotlin.reflect.jvm.internal.l l2, String string2, String string3, Object object) {
        j.b(l2, "container");
        j.b(string2, "name");
        j.b(string3, "signature");
        super(l2, string2, string3, object);
        this.b = ac.a(new kotlin.e.a.a<a<? extends R>>(this){
            final /* synthetic */ s a;
            {
                this.a = s2;
                super(0);
            }

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final a<R> b() {
                return new a(this.a);
            }
        });
        this.c = h.a(kotlin.l.b, (kotlin.e.a.a)new kotlin.e.a.a<Object>(this){
            final /* synthetic */ s a;
            {
                this.a = s2;
                super(0);
            }

            @Override
            public final Object a() {
                return this.a.a(this.a.s(), this.a.v());
            }
        });
    }

    public s(kotlin.reflect.jvm.internal.l l2, ai ai2) {
        j.b(l2, "container");
        j.b(ai2, "descriptor");
        super(l2, ai2);
        this.b = ac.a(new /* invalid duplicate definition of identical inner class */);
        this.c = h.a(kotlin.l.b, (kotlin.e.a.a)new /* invalid duplicate definition of identical inner class */);
    }

    @Override
    public R a() {
        return this.m();
    }

    @Override
    public /* synthetic */ m.a l() {
        return this.p();
    }

    @Override
    public R m() {
        return this.p().a(new Object[0]);
    }

    @Override
    public /* synthetic */ l.b n() {
        return this.p();
    }

    public a<R> p() {
        a<R> a2 = this.b.a();
        j.a(a2, "_getter()");
        return a2;
    }

    @Override
    public /* synthetic */ v.c q() {
        return this.p();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class a<R>
    extends v.c<R>
    implements m.a<R> {
        private final s<R> b;

        public a(s<? extends R> s2) {
            j.b(s2, "property");
            this.b = s2;
        }

        @Override
        public R a() {
            return this.m().m();
        }

        @Override
        public /* synthetic */ l b() {
            return this.m();
        }

        @Override
        public /* synthetic */ v l() {
            return this.m();
        }

        public s<R> m() {
            return this.b;
        }
    }

}

