/*
 * Decompiled with CFR 0.139.
 */
package com.b.a.b.a;

import com.b.a.b.a.c;
import com.b.a.f;
import com.b.a.h;
import com.b.a.k;
import com.b.a.p;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.i;
import kotlin.reflect.n;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u001e\u001fB9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R'\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2={"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "constructor", "Lkotlin/reflect/KFunction;", "bindings", "", "Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "(Lkotlin/reflect/KFunction;Ljava/util/List;Lcom/squareup/moshi/JsonReader$Options;)V", "getBindings", "()Ljava/util/List;", "getConstructor", "()Lkotlin/reflect/KFunction;", "getOptions", "()Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "(Lcom/squareup/moshi/JsonReader;)Ljava/lang/Object;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "(Lcom/squareup/moshi/JsonWriter;Ljava/lang/Object;)V", "toString", "", "Binding", "IndexedParameterMap", "moshi-kotlin"}, k=1, mv={1, 1, 11})
public final class a<T>
extends f<T> {
    private final kotlin.reflect.f<T> a;
    private final List<a<T, Object>> b;
    private final k.a c;

    public a(kotlin.reflect.f<? extends T> f2, List<a<T, Object>> list, k.a a2) {
        j.b(f2, "constructor");
        j.b(list, "bindings");
        j.b(a2, "options");
        this.a = f2;
        this.b = list;
        this.c = a2;
    }

    @Override
    public T a(k k2) {
        int n2;
        int n3;
        a<T, Object> a2;
        Object object;
        int n4;
        block8 : {
            block9 : {
                j.b(k2, "reader");
                n4 = this.a.i().size();
                object = new Object[this.b.size()];
                int n5 = ((Object[])object).length;
                n2 = 0;
                for (n3 = 0; n3 < n5; ++n3) {
                    object[n3] = c.a();
                }
                k2.e();
                do {
                    boolean bl2 = k2.g();
                    a2 = null;
                    if (!bl2) break block8;
                    n3 = k2.a(this.c);
                    if (n3 != -1) {
                        a2 = this.b.get(n3);
                    }
                    if (a2 == null) {
                        k2.i();
                        k2.p();
                        continue;
                    }
                    if (object[n3] != c.a()) break block9;
                    object[n3] = a2.b().a(k2);
                    if (object[n3] == null && !a2.c().j().b()) break;
                } while (true);
                object = new StringBuilder();
                ((StringBuilder)object).append("Non-null value '");
                ((StringBuilder)object).append(a2.c().g());
                ((StringBuilder)object).append("' was null at ");
                ((StringBuilder)object).append(k2.q());
                throw (Throwable)new h(((StringBuilder)object).toString());
            }
            a2 = new StringBuilder();
            ((StringBuilder)((Object)a2)).append("Multiple values for '");
            ((StringBuilder)((Object)a2)).append(this.a.i().get(n3).b());
            ((StringBuilder)((Object)a2)).append("' at ");
            ((StringBuilder)((Object)a2)).append(k2.q());
            throw (Throwable)new h(((StringBuilder)((Object)a2)).toString());
        }
        k2.f();
        for (n3 = n2; n3 < n4; ++n3) {
            if (object[n3] != c.a() || this.a.i().get(n3).e()) continue;
            if (this.a.i().get(n3).c().b()) {
                object[n3] = null;
                continue;
            }
            a2 = new StringBuilder();
            ((StringBuilder)((Object)a2)).append("Required value '");
            ((StringBuilder)((Object)a2)).append(this.a.i().get(n3).b());
            ((StringBuilder)((Object)a2)).append("' missing at ");
            ((StringBuilder)((Object)a2)).append(k2.q());
            throw (Throwable)new h(((StringBuilder)((Object)a2)).toString());
        }
        k2 = this.a.a(new b(this.a.i(), (Object[])object));
        n2 = this.b.size();
        for (n3 = n4; n3 < n2; ++n3) {
            a2 = this.b.get(n3);
            if (a2 == null) {
                j.a();
            }
            a2.a(k2, object[n3]);
        }
        return (T)k2;
    }

    @Override
    public void a(p p2, T t2) {
        j.b(p2, "writer");
        if (t2 != null) {
            p2.c();
            for (a<T, Object> a2 : this.b) {
                if (a2 == null) continue;
                p2.a(a2.a());
                a2.b().a(p2, a2.a(t2));
            }
            p2.d();
            return;
        }
        throw (Throwable)new NullPointerException("value == null");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KotlinJsonAdapter(");
        stringBuilder.append(this.a.j());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u0003B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u00c6\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\tH\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JQ\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003J\u0013\u0010\u001d\u001a\u00028\u00022\u0006\u0010\u001e\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020!H\u00d6\u0001J\u001b\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00028\u0002\u00a2\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006'"}, d2={"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "K", "P", "", "name", "", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "property", "Lkotlin/reflect/KProperty1;", "parameter", "Lkotlin/reflect/KParameter;", "(Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KParameter;)V", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "getName", "()Ljava/lang/String;", "getParameter", "()Lkotlin/reflect/KParameter;", "getProperty", "()Lkotlin/reflect/KProperty1;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "get", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "", "set", "", "result", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "moshi-kotlin"}, k=1, mv={1, 1, 11})
    public static final class a<K, P> {
        private final String a;
        private final f<P> b;
        private final n<K, P> c;
        private final kotlin.reflect.k d;

        public a(String string2, f<P> f2, n<K, ? extends P> n2, kotlin.reflect.k k2) {
            j.b(string2, "name");
            j.b(f2, "adapter");
            j.b(n2, "property");
            this.a = string2;
            this.b = f2;
            this.c = n2;
            this.d = k2;
        }

        public final P a(K k2) {
            return this.c.b(k2);
        }

        public final String a() {
            return this.a;
        }

        public final void a(K k2, P p2) {
            if (p2 != c.a()) {
                n<K, P> n2 = this.c;
                if (n2 != null) {
                    ((i)n2).a(k2, p2);
                    return;
                }
                throw new t("null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K, P>");
            }
        }

        public final f<P> b() {
            return this.b;
        }

        public final n<K, P> c() {
            return this.c;
        }

        public boolean equals(Object object) {
            block2 : {
                block3 : {
                    if (this == object) break block2;
                    if (!(object instanceof a)) break block3;
                    object = (a)object;
                    if (j.a((Object)this.a, (Object)((a)object).a) && j.a(this.b, ((a)object).b) && j.a(this.c, ((a)object).c) && j.a((Object)this.d, (Object)((a)object).d)) break block2;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            kotlin.reflect.a a2 = this.a;
            int n2 = 0;
            int n3 = a2 != null ? a2.hashCode() : 0;
            a2 = this.b;
            int n4 = a2 != null ? a2.hashCode() : 0;
            a2 = this.c;
            int n5 = a2 != null ? a2.hashCode() : 0;
            a2 = this.d;
            if (a2 != null) {
                n2 = a2.hashCode();
            }
            return ((n3 * 31 + n4) * 31 + n5) * 31 + n2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Binding(name=");
            stringBuilder.append(this.a);
            stringBuilder.append(", adapter=");
            stringBuilder.append(this.b);
            stringBuilder.append(", property=");
            stringBuilder.append(this.c);
            stringBuilder.append(", parameter=");
            stringBuilder.append(this.d);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0096\u0002R(\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2={"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$IndexedParameterMap;", "Lkotlin/collections/AbstractMap;", "Lkotlin/reflect/KParameter;", "", "parameterKeys", "", "parameterValues", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "getParameterKeys", "()Ljava/util/List;", "getParameterValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "containsKey", "", "key", "get", "moshi-kotlin"}, k=1, mv={1, 1, 11})
    public static final class b
    extends kotlin.a.c<kotlin.reflect.k, Object> {
        private final List<kotlin.reflect.k> b;
        private final Object[] c;

        public b(List<? extends kotlin.reflect.k> list, Object[] arrobject) {
            j.b(list, "parameterKeys");
            j.b(arrobject, "parameterValues");
            this.b = list;
            this.c = arrobject;
        }

        public Object a(kotlin.reflect.k k2, Object object) {
            return super.getOrDefault(k2, object);
        }

        @Override
        public Set<Map.Entry<kotlin.reflect.k, Object>> a() {
            Iterator iterator = this.b;
            Collection collection = new ArrayList(m.a(iterator, 10));
            iterator = iterator.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                collection.add(new AbstractMap.SimpleEntry<kotlin.reflect.k, Object>((kotlin.reflect.k)iterator.next(), this.c[n2]));
                ++n2;
            }
            iterator = (List)collection;
            collection = new LinkedHashSet();
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                Object t2 = iterator.next();
                n2 = ((AbstractMap.SimpleEntry)t2).getValue() != c.a() ? 1 : 0;
                if (n2 == 0) continue;
                collection.add(t2);
            }
            return (Set)collection;
        }

        public boolean a(kotlin.reflect.k k2) {
            j.b(k2, "key");
            return this.c[k2.a()] != c.a();
        }

        public Object b(kotlin.reflect.k object) {
            j.b(object, "key");
            object = this.c[object.a()];
            if (object != c.a()) {
                return object;
            }
            return null;
        }

        @Override
        public final boolean containsKey(Object object) {
            if (object instanceof kotlin.reflect.k) {
                return this.a((kotlin.reflect.k)object);
            }
            return false;
        }

        @Override
        public final Object get(Object object) {
            if (object instanceof kotlin.reflect.k) {
                return this.b((kotlin.reflect.k)object);
            }
            return null;
        }

        @Override
        public final Object getOrDefault(Object object, Object object2) {
            if (object instanceof kotlin.reflect.k) {
                return this.a((kotlin.reflect.k)object, object2);
            }
            return object2;
        }
    }

}

