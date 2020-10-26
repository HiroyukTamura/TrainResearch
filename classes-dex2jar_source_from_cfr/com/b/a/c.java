/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.b;
import com.b.a.e;
import com.b.a.f;
import com.b.a.k;
import com.b.a.p;
import com.b.a.s;
import com.b.a.u;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

final class c<T>
extends f<T> {
    public static final f.a a = new f.a(){

        private void a(s object, Type type, Map<String, a<?>> map) {
            Class<?> class_ = u.d(type);
            boolean bl2 = com.b.a.a.a.a(class_);
            for (Field field : class_.getDeclaredFields()) {
                if (!this.a(bl2, field.getModifiers())) continue;
                Object object2 = com.b.a.a.a.a(type, class_, field.getGenericType());
                Object object3 = com.b.a.a.a.a(field);
                Object object5 = field.getName();
                object2 = ((s)object).a((Type)object2, (Set<? extends Annotation>)object3, (String)object5);
                field.setAccessible(true);
                object3 = field.getAnnotation(e.class);
                if (object3 != null) {
                    object5 = object3.a();
                }
                a a2 = new a((String)object5, field, object2);
                if ((object5 = map.put((String)object5, a2)) == null) {
                    continue;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Conflicting fields:\n    ");
                ((StringBuilder)object).append(((a)object5).b);
                ((StringBuilder)object).append("\n    ");
                ((StringBuilder)object).append(a2.b);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
        }

        private boolean a(boolean bl2, int n2) {
            boolean bl3;
            block4 : {
                block5 : {
                    boolean bl4;
                    boolean bl5 = Modifier.isStatic(n2);
                    bl3 = bl4 = false;
                    if (bl5) break block4;
                    if (Modifier.isTransient(n2)) {
                        return false;
                    }
                    if (Modifier.isPublic(n2) || Modifier.isProtected(n2)) break block5;
                    bl3 = bl4;
                    if (bl2) break block4;
                }
                bl3 = true;
            }
            return bl3;
        }

        @Nullable
        @Override
        public f<?> a(Type object, Set<? extends Annotation> object2, s object3) {
            if (!(object instanceof Class) && !(object instanceof ParameterizedType)) {
                return null;
            }
            Serializable serializable = u.d((Type)object);
            if (!((Class)serializable).isInterface()) {
                if (((Class)serializable).isEnum()) {
                    return null;
                }
                if (com.b.a.a.a.a(serializable) && !u.g(serializable)) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Platform ");
                    ((StringBuilder)object3).append(com.b.a.a.a.a((Type)object, object2));
                    ((StringBuilder)object3).append(" requires explicit JsonAdapter to be registered");
                    throw new IllegalArgumentException(((StringBuilder)object3).toString());
                }
                if (!object2.isEmpty()) {
                    return null;
                }
                if (!((Class)serializable).isAnonymousClass()) {
                    if (!((Class)serializable).isLocalClass()) {
                        if (((Class)serializable).getEnclosingClass() != null && !Modifier.isStatic(((Class)serializable).getModifiers())) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Cannot serialize non-static nested class ");
                            ((StringBuilder)object).append(((Class)serializable).getName());
                            throw new IllegalArgumentException(((StringBuilder)object).toString());
                        }
                        if (!Modifier.isAbstract(((Class)serializable).getModifiers())) {
                            object2 = b.a(serializable);
                            serializable = new TreeMap();
                            while (object != Object.class) {
                                this.a((s)object3, (Type)object, (Map<String, a<?>>)((Object)serializable));
                                object = u.e((Type)object);
                            }
                            return new c(object2, (Map<String, a<?>>)((Object)serializable)).d();
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Cannot serialize abstract class ");
                        ((StringBuilder)object).append(((Class)serializable).getName());
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Cannot serialize local class ");
                    ((StringBuilder)object).append(((Class)serializable).getName());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Cannot serialize anonymous class ");
                ((StringBuilder)object).append(((Class)serializable).getName());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            return null;
        }
    };
    private final b<T> b;
    private final a<?>[] c;
    private final k.a d;

    c(b<T> b2, Map<String, a<?>> map) {
        this.b = b2;
        this.c = map.values().toArray(new a[map.size()]);
        this.d = k.a.a(map.keySet().toArray(new String[map.size()]));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public T a(k k2) {
        T t2 = this.b.a();
        try {
            k2.e();
            while (k2.g()) {
                int n2 = k2.a(this.d);
                if (n2 == -1) {
                    k2.i();
                    k2.p();
                    continue;
                }
                this.c[n2].a(k2, t2);
            }
            k2.f();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError();
        }
        return t2;
        catch (InvocationTargetException invocationTargetException) {
            throw com.b.a.a.a.a(invocationTargetException);
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException(instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void a(p p2, T t2) {
        p2.c();
        for (a<?> a2 : this.c) {
            p2.a(a2.a);
            a2.a(p2, t2);
        }
        try {
            p2.d();
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonAdapter(");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    static class a<T> {
        final String a;
        final Field b;
        final f<T> c;

        a(String string2, Field field, f<T> f2) {
            this.a = string2;
            this.b = field;
            this.c = f2;
        }

        void a(k k2, Object object) {
            k2 = this.c.a(k2);
            this.b.set(object, k2);
        }

        void a(p p2, Object object) {
            object = this.b.get(object);
            this.c.a(p2, object);
        }
    }

}

