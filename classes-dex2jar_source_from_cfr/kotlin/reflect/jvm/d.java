/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.e.b.i;
import kotlin.e.b.v;
import kotlin.o;
import kotlin.reflect.e;
import kotlin.reflect.f;
import kotlin.reflect.jvm.internal.ai;
import kotlin.reflect.jvm.internal.c;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.d.c.a.j;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import kotlin.reflect.jvm.internal.l;
import kotlin.reflect.jvm.internal.m;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u00a8\u0006\u0004"}, d2={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class d {
    public static final <R> f<R> a(kotlin.d<? extends R> object) {
        kotlin.e.b.j.b(object, "$receiver");
        Object object2 = object.getClass().getAnnotation(Metadata.class);
        if (object2 != null) {
            Object object3 = object2.d1();
            boolean bl2 = ((String[])object3).length == 0;
            if (bl2) {
                object3 = null;
            }
            if (object3 != null) {
                Serializable serializable = j.c(object3, object2.d2());
                object3 = ((o)serializable).c();
                serializable = ((o)serializable).d();
                object2 = object2.mv();
                object2 = new g(Arrays.copyOf(object2, ((int[])object2).length));
                object = object.getClass();
                q q2 = (q)((Object)serializable);
                object3 = (kotlin.reflect.jvm.internal.impl.d.b.c)object3;
                serializable = ((a.o)serializable).B();
                kotlin.e.b.j.a((Object)serializable, "proto.typeTable");
                object = (am)ai.a(object, q2, (kotlin.reflect.jvm.internal.impl.d.b.c)object3, new h((a.ai)serializable), (kotlin.reflect.jvm.internal.impl.d.b.a)object2, a.c);
                if (object != null) {
                    return new m(c.a, (kotlin.reflect.jvm.internal.impl.a.t)object);
                }
            }
        }
        return null;
    }

}

