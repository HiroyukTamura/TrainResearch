/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ai;
import kotlin.reflect.jvm.internal.impl.a.af;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.l;
import kotlin.reflect.jvm.internal.r;
import kotlin.reflect.jvm.internal.x;
import kotlin.reflect.jvm.internal.z;
import kotlin.reflect.k;
import kotlin.reflect.p;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J%\u00105\u001a\u00028\u00002\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010807\"\u0004\u0018\u000108H\u0016\u00a2\u0006\u0002\u00109J#\u0010:\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0002\u00a2\u0006\u0002\u0010<J#\u0010=\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0016\u00a2\u0006\u0002\u0010<J#\u0010>\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0002\u00a2\u0006\u0002\u0010<J\u0012\u0010?\u001a\u0004\u0018\u0001082\u0006\u0010@\u001a\u00020AH\u0002R(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \b*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \b*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00060\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001d\u001a\u00020\u001eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010$\u001a\u00020\"8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010#R\u0012\u0010%\u001a\u00020\"X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u0012R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u0006B"}, d2={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public abstract class h<R>
implements kotlin.reflect.b<R> {
    private final ac.a<List<Annotation>> a = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends Annotation>>(){

        @Override
        public /* synthetic */ Object a() {
            return this.b();
        }

        public final List<Annotation> b() {
            return ai.a((kotlin.reflect.jvm.internal.impl.a.a.a)this.c());
        }
    });
    private final ac.a<ArrayList<k>> b = ac.b((kotlin.e.a.a)new kotlin.e.a.a<ArrayList<k>>(){

        @Override
        public /* synthetic */ Object a() {
            return this.b();
        }

        public final ArrayList<k> b() {
            int n2;
            Object object = this.c();
            ArrayList<k> arrayList = new ArrayList<k>();
            Object object2 = object.e();
            int n3 = 0;
            if (object2 != null && !this.h()) {
                arrayList.add(new r(this, 0, k.a.a, (kotlin.e.a.a<? extends af>)new kotlin.e.a.a<al>((kotlin.reflect.jvm.internal.impl.a.b)object){
                    final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b a;
                    {
                        this.a = b2;
                        super(0);
                    }

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public final al b() {
                        al al2 = this.a.e();
                        if (al2 == null) {
                            j.a();
                        }
                        return al2;
                    }
                }));
                n2 = 1;
            } else {
                n2 = 0;
            }
            int n4 = n2;
            if (object.d() != null) {
                n4 = n2;
                if (!this.h()) {
                    arrayList.add(new r(this, n2, k.a.b, (kotlin.e.a.a<? extends af>)new kotlin.e.a.a<al>((kotlin.reflect.jvm.internal.impl.a.b)object){
                        final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b a;
                        {
                            this.a = b2;
                            super(0);
                        }

                        @Override
                        public /* synthetic */ Object a() {
                            return this.b();
                        }

                        public final al b() {
                            al al2 = this.a.d();
                            if (al2 == null) {
                                j.a();
                            }
                            return al2;
                        }
                    }));
                    n4 = n2 + 1;
                }
            }
            object2 = object.i();
            j.a(object2, "descriptor.valueParameters");
            int n5 = ((Collection)object2).size();
            n2 = n3;
            while (n2 < n5) {
                arrayList.add(new r(this, n4, k.a.c, (kotlin.e.a.a<? extends af>)new kotlin.e.a.a<av>((kotlin.reflect.jvm.internal.impl.a.b)object, n2){
                    final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b a;
                    final /* synthetic */ int b;
                    {
                        this.a = b2;
                        this.b = n2;
                        super(0);
                    }

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public final av b() {
                        av av2 = this.a.i().get(this.b);
                        j.a((Object)av2, "descriptor.valueParameters[i]");
                        return av2;
                    }
                }));
                ++n2;
                ++n4;
            }
            if (this.o() && object instanceof kotlin.reflect.jvm.internal.impl.c.a.b.b && (object = (List)arrayList).size() > 1) {
                m.a(object, }
        }
        java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
        
        