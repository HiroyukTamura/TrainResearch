/*
 * Decompiled with CFR 0.139.
 */
package com.b.a.b.a;

import com.b.a.b.a.a;
import com.b.a.b.a.c;
import com.b.a.e;
import com.b.a.f;
import com.b.a.k;
import com.b.a.s;
import com.b.a.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.z;
import kotlin.g.d;
import kotlin.reflect.i;
import kotlin.reflect.n;
import kotlin.reflect.p;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2={"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "moshi-kotlin"}, k=1, mv={1, 1, 11})
public final class b
implements f.a {
    @Override
    public f<?> a(Type object6, Set<? extends Annotation> object22, s collection) {
        RuntimeException runtimeException2;
        block30 : {
            Object object5;
            Object object2;
            j.b(object6, "type");
            j.b(object5, "annotations");
            j.b(object2, "moshi");
            if (!object5.isEmpty()) {
                return null;
            }
            Class<?> class_ = u.d((Type)object6);
            j.a(class_, "rawType");
            if (class_.isInterface()) {
                return null;
            }
            if (class_.isEnum()) {
                return null;
            }
            if (!class_.isAnnotationPresent(c.b())) {
                return null;
            }
            if (com.b.a.a.a.a(class_)) {
                return null;
            }
            try {
                object5 = com.b.a.a.a.a((s)object2, (Type)object6, class_);
                if (object5 != null) {
                    return object5;
                }
            }
            catch (RuntimeException runtimeException2) {
                if (!(runtimeException2.getCause() instanceof ClassNotFoundException)) break block30;
            }
            if (!class_.isLocalClass()) {
                object5 = kotlin.e.a.a(class_);
                if (!object5.d()) {
                    if (!object5.e()) {
                        if (object5.c() == null) {
                            kotlin.reflect.f f2 = kotlin.reflect.a.c.a(object5);
                            if (f2 != null) {
                                Object object3;
                                Object object4 = f2.i();
                                Map map = new LinkedHashMap(d.c(af.a(m.a(object4, 10)), 16));
                                object4 = object4.iterator();
                                while (object4.hasNext()) {
                                    object3 = object4.next();
                                    map.put(((kotlin.reflect.k)object3).b(), object3);
                                }
                                kotlin.reflect.jvm.a.a(f2, true);
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                for (n n2 : kotlin.reflect.a.c.b(object5)) {
                                    kotlin.reflect.k k2;
                                    block31 : {
                                        k2 = (kotlin.reflect.k)map.get(n2.g());
                                        object5 = kotlin.reflect.jvm.c.a(n2);
                                        int n3 = object5 != null ? object5.getModifiers() : 0;
                                        if (Modifier.isTransient(n3)) {
                                            if (k2 == null || k2.e()) continue;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("No default value for transient constructor ");
                                            stringBuilder.append(k2);
                                            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
                                        }
                                        if (k2 != null && j.a((Object)k2.c(), (Object)n2.j()) ^ true) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append('\'');
                                            stringBuilder.append(n2.g());
                                            stringBuilder.append("' has a constructor parameter of type ");
                                            stringBuilder.append(k2.c());
                                            stringBuilder.append(" but a property of type ");
                                            stringBuilder.append(n2.j());
                                            stringBuilder.append('.');
                                            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
                                        }
                                        if (!(n2 instanceof i) && k2 == null) continue;
                                        kotlin.reflect.jvm.a.a(n2, true);
                                        object3 = n2.k();
                                        for (Object object5 : (Iterable)((kotlin.reflect.a)n2).k()) {
                                            if (!((Annotation)object5 instanceof e)) continue;
                                            break block31;
                                        }
                                        object5 = null;
                                    }
                                    Object object7 = (e)object5;
                                    object5 = object3;
                                    object4 = object7;
                                    if (k2 != null) {
                                        object3 = m.b((Collection)object3, (Iterable)k2.k());
                                        object5 = object3;
                                        object4 = object7;
                                        if (object7 == null) {
                                            block32 : {
                                                for (Object object5 : (Iterable)((kotlin.reflect.a)k2).k()) {
                                                    if (!((Annotation)object5 instanceof e)) continue;
                                                    break block32;
                                                }
                                                object5 = null;
                                            }
                                            object4 = (e)object5;
                                            object5 = object3;
                                        }
                                    }
                                    if (object4 == null || (object4 = object4.a()) == null) {
                                        object4 = n2.g();
                                    }
                                    object3 = com.b.a.a.a.a((Type)object6, class_, kotlin.reflect.jvm.c.a(n2.j()));
                                    object5 = (Collection)object5;
                                    if (object5 != null) {
                                        if ((object5 = object5.toArray(new Annotation[0])) != null) {
                                            object5 = ((s)object2).a((Type)object3, com.b.a.a.a.a(object5), n2.g());
                                            object3 = linkedHashMap;
                                            object7 = n2.g();
                                            j.a(object5, "adapter");
                                            if (n2 != null) {
                                                object3.put((Object)object7, new a.a((String)object4, (f<?>)object5, n2, k2));
                                                continue;
                                            }
                                            throw new t("null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>");
                                        }
                                        throw new t("null cannot be cast to non-null type kotlin.Array<T>");
                                    }
                                    throw new t("null cannot be cast to non-null type java.util.Collection<T>");
                                }
                                object5 = new ArrayList();
                                for (kotlin.reflect.k k3 : f2.i()) {
                                    object4 = linkedHashMap;
                                    object3 = k3.b();
                                    if ((object4 = (a.a)z.e(object4).remove(object3)) == null && !k3.e()) {
                                        object5 = new StringBuilder();
                                        object5.append("No property for required constructor ");
                                        object5.append(k3);
                                        throw (Throwable)new IllegalArgumentException(object5.toString());
                                    }
                                    ((Collection)object5).add(object4);
                                }
                                Collection collection2 = (Collection)object5;
                                object2 = linkedHashMap.values();
                                j.a(object2, "bindingsByName.values");
                                m.a(collection2, (Iterable)object2);
                                Iterable iterable = (Iterable)object5;
                                object2 = new ArrayList(m.a(iterable, 10));
                                for (a.a a2 : iterable) {
                                    String string2;
                                    void var1_13;
                                    if (a2 == null || (string2 = a2.a()) == null) {
                                        String string3 = "\u0000";
                                    }
                                    object2.add(var1_13);
                                }
                                String[] arrstring = ((Collection)((List)object2)).toArray(new String[0]);
                                if (arrstring != null) {
                                    String[] arrstring2 = arrstring;
                                    k.a a3 = k.a.a(Arrays.copyOf(arrstring2, arrstring2.length));
                                    object5 = (List)object5;
                                    j.a((Object)a3, "options");
                                    return new a(f2, object5, a3).d();
                                }
                                throw new t("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            return null;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Cannot serialize object declaration ");
                        stringBuilder.append(class_.getName());
                        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot serialize inner class ");
                    stringBuilder.append(class_.getName());
                    throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot serialize abstract class ");
                stringBuilder.append(class_.getName());
                throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot serialize local class or object expression ");
            stringBuilder.append(class_.getName());
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        throw (Throwable)runtimeException2;
    }
}

