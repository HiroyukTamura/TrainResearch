/*
 * Decompiled with CFR 0.139.
 */
package com.b.a;

import com.b.a.e;
import com.b.a.f;
import com.b.a.h;
import com.b.a.k;
import com.b.a.p;
import com.b.a.s;
import com.b.a.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class t {
    public static final f.a a = new f.a(){

        @Override
        public f<?> a(Type object, Set<? extends Annotation> object2, s s2) {
            if (!object2.isEmpty()) {
                return null;
            }
            if (object == Boolean.TYPE) {
                return t.b;
            }
            if (object == Byte.TYPE) {
                return t.c;
            }
            if (object == Character.TYPE) {
                return t.d;
            }
            if (object == Double.TYPE) {
                return t.e;
            }
            if (object == Float.TYPE) {
                return t.f;
            }
            if (object == Integer.TYPE) {
                return t.g;
            }
            if (object == Long.TYPE) {
                return t.h;
            }
            if (object == Short.TYPE) {
                return t.i;
            }
            if (object == Boolean.class) {
                return t.b.d();
            }
            if (object == Byte.class) {
                return t.c.d();
            }
            if (object == Character.class) {
                return t.d.d();
            }
            if (object == Double.class) {
                return t.e.d();
            }
            if (object == Float.class) {
                return t.f.d();
            }
            if (object == Integer.class) {
                return t.g.d();
            }
            if (object == Long.class) {
                return t.h.d();
            }
            if (object == Short.class) {
                return t.i.d();
            }
            if (object == String.class) {
                return t.j.d();
            }
            if (object == Object.class) {
                return new b(s2).d();
            }
            object2 = u.d((Type)object);
            if ((object = com.b.a.a.a.a(s2, (Type)object, object2)) != null) {
                return object;
            }
            if (((Class)object2).isEnum()) {
                return new a(object2).d();
            }
            return null;
        }
    };
    static final f<Boolean> b = new f<Boolean>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Boolean bl2) {
            p2.a(bl2);
        }

        public Boolean b(k k2) {
            return k2.k();
        }

        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    };
    static final f<Byte> c = new f<Byte>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Byte by2) {
            p2.a((long)(by2.intValue() & 255));
        }

        public Byte b(k k2) {
            return (byte)t.a(k2, "a byte", -128, 255);
        }

        public String toString() {
            return "JsonAdapter(Byte)";
        }
    };
    static final f<Character> d = new f<Character>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Character c2) {
            p2.b(c2.toString());
        }

        public Character b(k k2) {
            String string2 = k2.j();
            if (string2.length() <= 1) {
                return Character.valueOf(string2.charAt(0));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\"');
            stringBuilder.append(string2);
            stringBuilder.append('\"');
            throw new h(String.format("Expected %s but was %s at path %s", "a char", stringBuilder.toString(), k2.q()));
        }

        public String toString() {
            return "JsonAdapter(Character)";
        }
    };
    static final f<Double> e = new f<Double>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Double d2) {
            p2.a(d2);
        }

        public Double b(k k2) {
            return k2.m();
        }

        public String toString() {
            return "JsonAdapter(Double)";
        }
    };
    static final f<Float> f = new f<Float>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Float f2) {
            if (f2 != null) {
                p2.a(f2);
                return;
            }
            throw new NullPointerException();
        }

        public Float b(k k2) {
            float f2 = (float)k2.m();
            if (!k2.a() && Float.isInfinite(f2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("JSON forbids NaN and infinities: ");
                stringBuilder.append(f2);
                stringBuilder.append(" at path ");
                stringBuilder.append(k2.q());
                throw new h(stringBuilder.toString());
            }
            return Float.valueOf(f2);
        }

        public String toString() {
            return "JsonAdapter(Float)";
        }
    };
    static final f<Integer> g = new f<Integer>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Integer n2) {
            p2.a((long)n2.intValue());
        }

        public Integer b(k k2) {
            return k2.o();
        }

        public String toString() {
            return "JsonAdapter(Integer)";
        }
    };
    static final f<Long> h = new f<Long>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Long l2) {
            p2.a(l2);
        }

        public Long b(k k2) {
            return k2.n();
        }

        public String toString() {
            return "JsonAdapter(Long)";
        }
    };
    static final f<Short> i = new f<Short>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, Short s2) {
            p2.a((long)s2.intValue());
        }

        public Short b(k k2) {
            return (short)t.a(k2, "a short", -32768, 32767);
        }

        public String toString() {
            return "JsonAdapter(Short)";
        }
    };
    static final f<String> j = new f<String>(){

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, String string2) {
            p2.b(string2);
        }

        public String b(k k2) {
            return k2.j();
        }

        public String toString() {
            return "JsonAdapter(String)";
        }
    };

    static int a(k k2, String string2, int n2, int n3) {
        int n4 = k2.o();
        if (n4 >= n2 && n4 <= n3) {
            return n4;
        }
        throw new h(String.format("Expected %s but was %s at path %s", string2, n4, k2.q()));
    }

    static final class a<T extends Enum<T>>
    extends f<T> {
        private final Class<T> a;
        private final String[] b;
        private final T[] c;
        private final k.a d;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        a(Class<T> class_) {
            this.a = class_;
            try {
                this.c = (Enum[])class_.getEnumConstants();
                this.b = new String[this.c.length];
                int n2 = 0;
                do {
                    void var3_3;
                    if (n2 >= this.c.length) {
                        this.d = k.a.a(this.b);
                        return;
                    }
                    T t2 = this.c[n2];
                    e e2 = class_.getField(((Enum)t2).name()).getAnnotation(e.class);
                    if (e2 != null) {
                        String string2 = e2.a();
                    } else {
                        String string3 = ((Enum)t2).name();
                    }
                    this.b[n2] = var3_3;
                    ++n2;
                } while (true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Missing field in ");
                stringBuilder.append(class_.getName());
                throw new AssertionError(stringBuilder.toString(), noSuchFieldException);
            }
        }

        @Override
        public /* synthetic */ Object a(k k2) {
            return this.b(k2);
        }

        @Override
        public void a(p p2, T t2) {
            p2.b(this.b[((Enum)t2).ordinal()]);
        }

        public T b(k object) {
            int n2 = ((k)object).b(this.d);
            if (n2 != -1) {
                return this.c[n2];
            }
            String string2 = ((k)object).q();
            object = ((k)object).j();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected one of ");
            stringBuilder.append(Arrays.asList(this.b));
            stringBuilder.append(" but was ");
            stringBuilder.append((String)object);
            stringBuilder.append(" at path ");
            stringBuilder.append(string2);
            throw new h(stringBuilder.toString());
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JsonAdapter(");
            stringBuilder.append(this.a.getName());
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class b
    extends f<Object> {
        private final s a;
        private final f<List> b;
        private final f<Map> c;
        private final f<String> d;
        private final f<Double> e;
        private final f<Boolean> f;

        b(s s2) {
            this.a = s2;
            this.b = s2.a(List.class);
            this.c = s2.a(Map.class);
            this.d = s2.a(String.class);
            this.e = s2.a(Double.class);
            this.f = s2.a(Boolean.class);
        }

        private Class<?> a(Class<?> class_) {
            if (Map.class.isAssignableFrom(class_)) {
                return Map.class;
            }
            Class<Object> class_2 = class_;
            if (Collection.class.isAssignableFrom(class_)) {
                class_2 = Collection.class;
            }
            return class_2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Object a(k k2) {
            f<Object> f2;
            switch (3.a[k2.h().ordinal()]) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected a value but was ");
                    stringBuilder.append((Object)k2.h());
                    stringBuilder.append(" at path ");
                    stringBuilder.append(k2.q());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                case 6: {
                    return k2.l();
                }
                case 5: {
                    f2 = this.f;
                    do {
                        return f2.a(k2);
                        break;
                    } while (true);
                }
                case 4: {
                    f2 = this.e;
                    return f2.a(k2);
                }
                case 3: {
                    f2 = this.d;
                    return f2.a(k2);
                }
                case 2: {
                    f2 = this.c;
                    return f2.a(k2);
                }
                case 1: 
            }
            f2 = this.b;
            return f2.a(k2);
        }

        @Override
        public void a(p p2, Object object) {
            Class<?> class_ = object.getClass();
            if (class_ == Object.class) {
                p2.c();
                p2.d();
                return;
            }
            this.a.a(this.a(class_), com.b.a.a.a.a).a(p2, object);
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

}

