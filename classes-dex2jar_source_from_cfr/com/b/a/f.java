/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.h;
import com.b.a.k;
import com.b.a.p;
import com.b.a.s;
import d.c;
import d.d;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public abstract class f<T> {
    @CheckReturnValue
    @Nullable
    public abstract T a(k var1);

    @CheckReturnValue
    @Nullable
    public final T a(String object) {
        object = k.a(new c().a((String)object));
        T t2 = this.a((k)object);
        if (!this.g()) {
            if (((k)object).h() == k.b.j) {
                return t2;
            }
            throw new h("JSON document was not fully consumed.");
        }
        return t2;
    }

    @CheckReturnValue
    public final String a(@Nullable T t2) {
        c c2 = new c();
        try {
            this.a(c2, t2);
            return c2.p();
        }
        catch (IOException iOException) {
            throw new AssertionError(iOException);
        }
    }

    public abstract void a(p var1, @Nullable T var2);

    public final void a(d d2, @Nullable T t2) {
        this.a(p.a(d2), t2);
    }

    @CheckReturnValue
    public final f<T> c() {
        return new f<T>(){

            @Nullable
            @Override
            public T a(k k2) {
                return this.a(k2);
            }

            @Override
            public void a(p p2, @Nullable T t2) {
                boolean bl2 = p2.i();
                p2.c(true);
                try {
                    this.a(p2, t2);
                    return;
                }
                finally {
                    p2.c(bl2);
                }
            }

            @Override
            boolean g() {
                return this.g();
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".serializeNulls()");
                return stringBuilder.toString();
            }
        };
    }

    @CheckReturnValue
    public final f<T> d() {
        return new f<T>(){

            @Nullable
            @Override
            public T a(k k2) {
                if (k2.h() == k.b.i) {
                    return k2.l();
                }
                return this.a(k2);
            }

            @Override
            public void a(p p2, @Nullable T t2) {
                if (t2 == null) {
                    p2.e();
                    return;
                }
                this.a(p2, t2);
            }

            @Override
            boolean g() {
                return this.g();
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".nullSafe()");
                return stringBuilder.toString();
            }
        };
    }

    @CheckReturnValue
    public final f<T> e() {
        return new f<T>(){

            @Nullable
            @Override
            public T a(k k2) {
                boolean bl2 = k2.a();
                k2.a(true);
                try {
                    Object t2 = this.a(k2);
                    return t2;
                }
                finally {
                    k2.a(bl2);
                }
            }

            @Override
            public void a(p p2, @Nullable T t2) {
                boolean bl2 = p2.h();
                p2.b(true);
                try {
                    this.a(p2, t2);
                    return;
                }
                finally {
                    p2.b(bl2);
                }
            }

            @Override
            boolean g() {
                return true;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".lenient()");
                return stringBuilder.toString();
            }
        };
    }

    @CheckReturnValue
    public final f<T> f() {
        return new f<T>(){

            @Nullable
            @Override
            public T a(k k2) {
                boolean bl2 = k2.b();
                k2.b(true);
                try {
                    Object t2 = this.a(k2);
                    return t2;
                }
                finally {
                    k2.b(bl2);
                }
            }

            @Override
            public void a(p p2, @Nullable T t2) {
                this.a(p2, t2);
            }

            @Override
            boolean g() {
                return this.g();
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this);
                stringBuilder.append(".failOnUnknown()");
                return stringBuilder.toString();
            }
        };
    }

    boolean g() {
        return false;
    }

    public static interface a {
        @CheckReturnValue
        @Nullable
        public f<?> a(Type var1, Set<? extends Annotation> var2, s var3);
    }

}

