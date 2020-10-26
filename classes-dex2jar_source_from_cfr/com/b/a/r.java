/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.f;
import com.b.a.h;
import com.b.a.k;
import com.b.a.p;
import com.b.a.q;
import com.b.a.s;
import com.b.a.u;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

final class r<K, V>
extends f<Map<K, V>> {
    public static final f.a a = new f.a(){

        @Nullable
        @Override
        public f<?> a(Type arrtype, Set<? extends Annotation> class_, s s2) {
            if (!class_.isEmpty()) {
                return null;
            }
            class_ = u.d((Type)arrtype);
            if (class_ != Map.class) {
                return null;
            }
            arrtype = u.b((Type)arrtype, class_);
            return new r(s2, arrtype[0], arrtype[1]).d();
        }
    };
    private final f<K> b;
    private final f<V> c;

    r(s s2, Type type, Type type2) {
        this.b = s2.a(type);
        this.c = s2.a(type2);
    }

    @Override
    public /* synthetic */ Object a(k k2) {
        return this.b(k2);
    }

    @Override
    public void a(p p2, Map<K, V> object) {
        p2.c();
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            if (entry.getKey() != null) {
                p2.j();
                this.b.a(p2, entry.getKey());
                this.c.a(p2, entry.getValue());
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Map key is null at ");
            ((StringBuilder)object).append(p2.k());
            throw new h(((StringBuilder)object).toString());
        }
        p2.d();
    }

    public Map<K, V> b(k k2) {
        Serializable serializable = new q<K, V>();
        k2.e();
        while (k2.g()) {
            k2.r();
            K k3 = this.b.a(k2);
            V v2 = this.c.a(k2);
            Object v3 = ((q)serializable).put(k3, v2);
            if (v3 == null) continue;
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Map key '");
            ((StringBuilder)serializable).append(k3);
            ((StringBuilder)serializable).append("' has multiple values at path ");
            ((StringBuilder)serializable).append(k2.q());
            ((StringBuilder)serializable).append(": ");
            ((StringBuilder)serializable).append(v3);
            ((StringBuilder)serializable).append(" and ");
            ((StringBuilder)serializable).append(v2);
            throw new h(((StringBuilder)serializable).toString());
        }
        k2.f();
        return serializable;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonAdapter(");
        stringBuilder.append(this.b);
        stringBuilder.append("=");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}

