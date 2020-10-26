/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.v;
import kotlin.reflect.c;
import kotlin.reflect.d;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.f;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.x;
import kotlin.reflect.p;
import kotlin.reflect.q;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b\u00a8\u0006\t"}, d2={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class b {
    public static final c<?> a(d object) {
        block6 : {
            List<p> list;
            block7 : {
                block4 : {
                    block5 : {
                        Object t2;
                        boolean bl2;
                        j.b(object, "$receiver");
                        if (object instanceof c) {
                            return (c)object;
                        }
                        if (!(object instanceof q)) break block6;
                        list = ((q)object).a();
                        Iterator iterator = ((Iterable)list).iterator();
                        do {
                            boolean bl3 = iterator.hasNext();
                            object = null;
                            if (!bl3) break block4;
                            t2 = iterator.next();
                            Object object2 = (p)t2;
                            if (object2 == null) break block5;
                            if (!((object2 = ((x)object2).d().g().d()) instanceof e)) continue;
                            object = object2;
                        } while (!(bl2 = (object = (e)object) != null && object.l() != f.b && object.l() != f.e));
                        object = t2;
                        break block7;
                    }
                    throw new t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                }
                object = null;
            }
            object = (p)object;
            if (object == null) {
                object = m.g(list);
            }
            if (object != null && (object = b.a((p)object)) != null) {
                return object;
            }
            return v.a(Object.class);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot calculate JVM erasure for type: ");
        stringBuilder.append(object);
        throw (Throwable)new aa(stringBuilder.toString());
    }

    public static final c<?> a(p p2) {
        j.b(p2, "$receiver");
        Object object = p2.a();
        if (object != null && (object = b.a((d)object)) != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot calculate JVM erasure for type: ");
        ((StringBuilder)object).append(p2);
        throw (Throwable)new aa(((StringBuilder)object).toString());
    }
}

