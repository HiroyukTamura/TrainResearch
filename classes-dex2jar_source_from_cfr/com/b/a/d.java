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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

abstract class d<C extends Collection<T>, T>
extends f<C> {
    public static final f.a a = new f.a(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Nullable
        @Override
        public f<?> a(Type f2, Set<? extends Annotation> set, s s2) {
            Class<?> class_ = u.d(f2);
            if (!set.isEmpty()) {
                return null;
            }
            if (class_ != List.class && class_ != Collection.class) {
                if (class_ != Set.class) return null;
                f2 = d.b(f2, s2);
                do {
                    return f2.d();
                    break;
                } while (true);
            }
            f2 = d.a(f2, s2);
            return f2.d();
        }
    };
    private final f<T> b;

    private d(f<T> f2) {
        this.b = f2;
    }

    static <T> f<Collection<T>> a(Type type, s s2) {
        return new d<Collection<T>, T>(s2.a(u.a(type, Collection.class))){

            @Override
            public /* synthetic */ Object a(k k2) {
                return super.b(k2);
            }

            @Override
            Collection<T> a() {
                return new ArrayList();
            }
        };
    }

    static <T> f<Set<T>> b(Type type, s s2) {
        return new d<Set<T>, T>(s2.a(u.a(type, Collection.class))){

            @Override
            public /* synthetic */ Object a(k k2) {
                return super.b(k2);
            }

            @Override
            /* synthetic */ Collection a() {
                return this.b();
            }

            Set<T> b() {
                return new LinkedHashSet();
            }
        };
    }

    @Override
    public /* synthetic */ Object a(k k2) {
        return this.b(k2);
    }

    abstract C a();

    @Override
    public void a(p p2, C object) {
        p2.a();
        object = object.iterator();
        while (object.hasNext()) {
            E e2 = object.next();
            this.b.a(p2, e2);
        }
        p2.b();
    }

    public C b(k k2) {
        C c2 = this.a();
        k2.c();
        while (k2.g()) {
            c2.add(this.b.a(k2));
        }
        k2.d();
        return c2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(".collection()");
        return stringBuilder.toString();
    }

}

