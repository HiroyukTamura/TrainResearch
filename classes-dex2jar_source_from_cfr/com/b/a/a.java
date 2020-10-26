/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.f;
import com.b.a.k;
import com.b.a.p;
import com.b.a.s;
import com.b.a.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.Nullable;

final class a
extends f<Object> {
    public static final f.a a = new f.a(){

        @Nullable
        @Override
        public f<?> a(Type type, Set<? extends Annotation> set, s s2) {
            if ((type = u.f(type)) == null) {
                return null;
            }
            if (!set.isEmpty()) {
                return null;
            }
            return new a(u.d(type), s2.a(type)).d();
        }
    };
    private final Class<?> b;
    private final f<Object> c;

    a(Class<?> class_, f<Object> f2) {
        this.b = class_;
        this.c = f2;
    }

    @Override
    public Object a(k object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ((k)object).c();
        while (((k)object).g()) {
            arrayList.add(this.c.a((k)object));
        }
        ((k)object).d();
        object = Array.newInstance(this.b, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            Array.set(object, i2, arrayList.get(i2));
        }
        return object;
    }

    @Override
    public void a(p p2, Object object) {
        p2.a();
        int n2 = Array.getLength(object);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c.a(p2, Array.get(object, i2));
        }
        p2.b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(".array()");
        return stringBuilder.toString();
    }

}

