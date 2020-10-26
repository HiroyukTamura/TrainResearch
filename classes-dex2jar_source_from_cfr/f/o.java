/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import c.aa;
import c.ab;
import c.ac;
import c.ad;
import c.e;
import c.s;
import c.w;
import f.c.b;
import f.c.c;
import f.c.d;
import f.c.e;
import f.c.f;
import f.c.g;
import f.c.h;
import f.c.i;
import f.c.k;
import f.c.q;
import f.c.r;
import f.c.s;
import f.c.t;
import f.c.u;
import f.c.v;
import f.c.x;
import f.j;
import f.l;
import f.m;
import f.n;
import f.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

final class o<R, T> {
    static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    static final Pattern b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    private final e.a c;
    private final f.c<R, T> d;
    private final c.t e;
    private final f.e<ad, R> f;
    private final String g;
    private final String h;
    private final c.s i;
    private final c.v j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final j<?>[] n;

    o(a<R, T> a2) {
        this.c = a2.a.a();
        this.d = a2.w;
        this.e = a2.a.b();
        this.f = a2.v;
        this.g = a2.m;
        this.h = a2.q;
        this.i = a2.r;
        this.j = a2.s;
        this.k = a2.n;
        this.l = a2.o;
        this.m = a2.p;
        this.n = a2.u;
    }

    static Class<?> a(Class<?> class_) {
        if (Boolean.TYPE == class_) {
            return Boolean.class;
        }
        if (Byte.TYPE == class_) {
            return Byte.class;
        }
        if (Character.TYPE == class_) {
            return Character.class;
        }
        if (Double.TYPE == class_) {
            return Double.class;
        }
        if (Float.TYPE == class_) {
            return Float.class;
        }
        if (Integer.TYPE == class_) {
            return Integer.class;
        }
        if (Long.TYPE == class_) {
            return Long.class;
        }
        Class<Object> class_2 = class_;
        if (Short.TYPE == class_) {
            class_2 = Short.class;
        }
        return class_2;
    }

    static Set<String> a(String object) {
        object = a.matcher((CharSequence)object);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        while (((Matcher)object).find()) {
            linkedHashSet.add(((Matcher)object).group(1));
        }
        return linkedHashSet;
    }

    /* varargs */ c.e a(@Nullable Object ... object) {
        l l2 = new l(this.g, this.e, this.h, this.i, this.j, this.k, this.l, this.m);
        j<?>[] arrj = this.n;
        int n2 = object != null ? ((Object[])object).length : 0;
        if (n2 == arrj.length) {
            for (int i2 = 0; i2 < n2; ++i2) {
                arrj[i2].a(l2, object[i2]);
            }
            return this.c.a(l2.a());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Argument count (");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(") doesn't match expected count (");
        ((StringBuilder)object).append(arrj.length);
        ((StringBuilder)object).append(")");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    R a(ad ad2) {
        return this.f.a(ad2);
    }

    T a(f.b<R> b2) {
        return this.d.a(b2);
    }

    static final class a<T, R> {
        final n a;
        final Method b;
        final Annotation[] c;
        final Annotation[][] d;
        final Type[] e;
        Type f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        String m;
        boolean n;
        boolean o;
        boolean p;
        String q;
        c.s r;
        c.v s;
        Set<String> t;
        j<?>[] u;
        f.e<ad, T> v;
        f.c<T, R> w;

        a(n n2, Method method) {
            this.a = n2;
            this.b = method;
            this.c = method.getAnnotations();
            this.e = method.getGenericParameterTypes();
            this.d = method.getParameterAnnotations();
        }

        private c.s a(String[] arrstring) {
            s.a a2 = new s.a();
            for (String string2 : arrstring) {
                int n2 = string2.indexOf(58);
                if (n2 != -1 && n2 != 0 && n2 != string2.length() - 1) {
                    Object object = string2.substring(0, n2);
                    string2 = string2.substring(n2 + 1).trim();
                    if ("Content-Type".equalsIgnoreCase((String)object)) {
                        object = c.v.a(string2);
                        if (object != null) {
                            this.s = object;
                            continue;
                        }
                        throw this.a("Malformed content type: %s", string2);
                    }
                    a2.a((String)object, string2);
                    continue;
                }
                throw this.a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", string2);
            }
            return a2.a();
        }

        private j<?> a(int n2, Type type, Annotation[] arrannotation) {
            int n3 = arrannotation.length;
            j<?> j2 = null;
            for (int i2 = 0; i2 < n3; ++i2) {
                j<?> j3 = this.a(n2, type, arrannotation, arrannotation[i2]);
                if (j3 == null) continue;
                if (j2 == null) {
                    j2 = j3;
                    continue;
                }
                throw this.a(n2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
            }
            if (j2 != null) {
                return j2;
            }
            throw this.a(n2, "No Retrofit annotation found.", new Object[0]);
        }

        private j<?> a(int n2, Type type, Annotation[] object, Annotation class_) {
            if (class_ instanceof x) {
                if (!this.l) {
                    if (!this.j) {
                        if (!this.k) {
                            if (this.q == null) {
                                this.l = true;
                                if (!(type == c.t.class || type == String.class || type == URI.class || type instanceof Class && "android.net.Uri".equals(((Class)type).getName()))) {
                                    throw this.a(n2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                }
                                return new j.m();
                            }
                            throw this.a(n2, "@Url cannot be used with @%s URL", this.m);
                        }
                        throw this.a(n2, "A @Url parameter must not come after a @Query", new Object[0]);
                    }
                    throw this.a(n2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw this.a(n2, "Multiple @Url method annotations found.", new Object[0]);
            }
            if (class_ instanceof s) {
                if (!this.k) {
                    if (!this.l) {
                        if (this.q != null) {
                            this.j = true;
                            class_ = (s)((Object)class_);
                            String string2 = class_.a();
                            this.a(n2, string2);
                            return new j.h(string2, this.a.c(type, (Annotation[])object), class_.b());
                        }
                        throw this.a(n2, "@Path can only be used with relative url on @%s", this.m);
                    }
                    throw this.a(n2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw this.a(n2, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (class_ instanceof t) {
                Object object2 = (t)((Object)class_);
                class_ = object2.a();
                boolean bl2 = object2.b();
                object2 = p.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom((Class<?>)object2)) {
                    if (type instanceof ParameterizedType) {
                        type = p.a(0, (ParameterizedType)type);
                        return new j.i((String)((Object)class_), this.a.c(type, (Annotation[])object), bl2).a();
                    }
                    type = new StringBuilder();
                    ((StringBuilder)((Object)type)).append(((Class)object2).getSimpleName());
                    ((StringBuilder)((Object)type)).append(" must include generic type (e.g., ");
                    ((StringBuilder)((Object)type)).append(((Class)object2).getSimpleName());
                    ((StringBuilder)((Object)type)).append("<String>)");
                    throw this.a(n2, ((StringBuilder)((Object)type)).toString(), new Object[0]);
                }
                if (((Class)object2).isArray()) {
                    type = o.a(((Class)object2).getComponentType());
                    return new j.i((String)((Object)class_), this.a.c(type, (Annotation[])object), bl2).b();
                }
                return new j.i((String)((Object)class_), this.a.c(type, (Annotation[])object), bl2);
            }
            if (class_ instanceof v) {
                boolean bl3 = ((v)((Object)class_)).a();
                class_ = p.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(class_)) {
                    if (type instanceof ParameterizedType) {
                        type = p.a(0, (ParameterizedType)type);
                        return new j.k(this.a.c(type, (Annotation[])object), bl3).a();
                    }
                    type = new StringBuilder();
                    ((StringBuilder)((Object)type)).append(class_.getSimpleName());
                    ((StringBuilder)((Object)type)).append(" must include generic type (e.g., ");
                    ((StringBuilder)((Object)type)).append(class_.getSimpleName());
                    ((StringBuilder)((Object)type)).append("<String>)");
                    throw this.a(n2, ((StringBuilder)((Object)type)).toString(), new Object[0]);
                }
                if (class_.isArray()) {
                    type = o.a(class_.getComponentType());
                    return new j.k(this.a.c(type, (Annotation[])object), bl3).b();
                }
                return new j.k(this.a.c(type, (Annotation[])object), bl3);
            }
            if (class_ instanceof u) {
                Type type2 = p.a(type);
                if (Map.class.isAssignableFrom((Class<?>)type2)) {
                    if ((type = p.b(type, type2, Map.class)) instanceof ParameterizedType) {
                        type2 = (ParameterizedType)type;
                        type = p.a(0, type2);
                        if (String.class == type) {
                            type = p.a(1, type2);
                            return new j.j(this.a.c(type, (Annotation[])object), ((u)((Object)class_)).a());
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("@QueryMap keys must be of type String: ");
                        ((StringBuilder)object).append(type);
                        throw this.a(n2, ((StringBuilder)object).toString(), new Object[0]);
                    }
                    throw this.a(n2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw this.a(n2, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (class_ instanceof i) {
                class_ = ((i)((Object)class_)).a();
                Class<?> class_2 = p.a(type);
                if (Iterable.class.isAssignableFrom(class_2)) {
                    if (type instanceof ParameterizedType) {
                        type = p.a(0, (ParameterizedType)type);
                        return new j.d((String)((Object)class_), this.a.c(type, (Annotation[])object)).a();
                    }
                    type = new StringBuilder();
                    ((StringBuilder)((Object)type)).append(class_2.getSimpleName());
                    ((StringBuilder)((Object)type)).append(" must include generic type (e.g., ");
                    ((StringBuilder)((Object)type)).append(class_2.getSimpleName());
                    ((StringBuilder)((Object)type)).append("<String>)");
                    throw this.a(n2, ((StringBuilder)((Object)type)).toString(), new Object[0]);
                }
                if (class_2.isArray()) {
                    type = o.a(class_2.getComponentType());
                    return new j.d((String)((Object)class_), this.a.c(type, (Annotation[])object)).b();
                }
                return new j.d((String)((Object)class_), this.a.c(type, (Annotation[])object));
            }
            if (class_ instanceof f.c.j) {
                class_ = p.a(type);
                if (Map.class.isAssignableFrom(class_)) {
                    if ((type = p.b(type, class_, Map.class)) instanceof ParameterizedType) {
                        class_ = (ParameterizedType)type;
                        type = p.a(0, (ParameterizedType)((Object)class_));
                        if (String.class == type) {
                            type = p.a(1, class_);
                            return new j.e(this.a.c(type, (Annotation[])object));
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("@HeaderMap keys must be of type String: ");
                        ((StringBuilder)object).append(type);
                        throw this.a(n2, ((StringBuilder)object).toString(), new Object[0]);
                    }
                    throw this.a(n2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw this.a(n2, "@HeaderMap parameter type must be Map.", new Object[0]);
            }
            if (class_ instanceof c) {
                if (this.o) {
                    Class<?> class_3 = (c)((Object)class_);
                    class_ = class_3.a();
                    boolean bl4 = class_3.b();
                    this.g = true;
                    class_3 = p.a(type);
                    if (Iterable.class.isAssignableFrom(class_3)) {
                        if (type instanceof ParameterizedType) {
                            type = p.a(0, (ParameterizedType)type);
                            return new j.b((String)((Object)class_), this.a.c(type, (Annotation[])object), bl4).a();
                        }
                        type = new StringBuilder();
                        ((StringBuilder)((Object)type)).append(class_3.getSimpleName());
                        ((StringBuilder)((Object)type)).append(" must include generic type (e.g., ");
                        ((StringBuilder)((Object)type)).append(class_3.getSimpleName());
                        ((StringBuilder)((Object)type)).append("<String>)");
                        throw this.a(n2, ((StringBuilder)((Object)type)).toString(), new Object[0]);
                    }
                    if (class_3.isArray()) {
                        type = o.a(class_3.getComponentType());
                        return new j.b((String)((Object)class_), this.a.c(type, (Annotation[])object), bl4).b();
                    }
                    return new j.b((String)((Object)class_), this.a.c(type, (Annotation[])object), bl4);
                }
                throw this.a(n2, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (class_ instanceof d) {
                if (this.o) {
                    Type type3 = p.a(type);
                    if (Map.class.isAssignableFrom((Class<?>)type3)) {
                        if ((type = p.b(type, type3, Map.class)) instanceof ParameterizedType) {
                            type3 = (ParameterizedType)type;
                            type = p.a(0, type3);
                            if (String.class == type) {
                                type = p.a(1, type3);
                                type = this.a.c(type, (Annotation[])object);
                                this.g = true;
                                return new j.c(type, ((d)((Object)class_)).a());
                            }
                            object = new StringBuilder();
                            ((StringBuilder)object).append("@FieldMap keys must be of type String: ");
                            ((StringBuilder)object).append(type);
                            throw this.a(n2, ((StringBuilder)object).toString(), new Object[0]);
                        }
                        throw this.a(n2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw this.a(n2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw this.a(n2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            if (class_ instanceof q) {
                if (this.p) {
                    Object object3 = (q)((Object)class_);
                    this.h = true;
                    String string3 = object3.a();
                    class_ = p.a(type);
                    if (string3.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(class_)) {
                            if (type instanceof ParameterizedType) {
                                if (w.b.class.isAssignableFrom(p.a(p.a(0, (ParameterizedType)type)))) {
                                    return j.l.a.a();
                                }
                                throw this.a(n2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            type = new StringBuilder();
                            ((StringBuilder)((Object)type)).append(class_.getSimpleName());
                            ((StringBuilder)((Object)type)).append(" must include generic type (e.g., ");
                            ((StringBuilder)((Object)type)).append(class_.getSimpleName());
                            ((StringBuilder)((Object)type)).append("<String>)");
                            throw this.a(n2, ((StringBuilder)((Object)type)).toString(), new Object[0]);
                        }
                        if (class_.isArray()) {
                            if (w.b.class.isAssignableFrom(class_.getComponentType())) {
                                return j.l.a.b();
                            }
                            throw this.a(n2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (w.b.class.isAssignableFrom(class_)) {
                            return j.l.a;
                        }
                        throw this.a(n2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("form-data; name=\"");
                    stringBuilder.append(string3);
                    stringBuilder.append("\"");
                    object3 = c.s.a("Content-Disposition", stringBuilder.toString(), "Content-Transfer-Encoding", object3.b());
                    if (Iterable.class.isAssignableFrom(class_)) {
                        if (type instanceof ParameterizedType) {
                            if (!w.b.class.isAssignableFrom(p.a(type = p.a(0, (ParameterizedType)type)))) {
                                return new j.f((c.s)object3, this.a.a(type, (Annotation[])object, this.c)).a();
                            }
                            throw this.a(n2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        type = new StringBuilder();
                        ((StringBuilder)((Object)type)).append(class_.getSimpleName());
                        ((StringBuilder)((Object)type)).append(" must include generic type (e.g., ");
                        ((StringBuilder)((Object)type)).append(class_.getSimpleName());
                        ((StringBuilder)((Object)type)).append("<String>)");
                        throw this.a(n2, ((StringBuilder)((Object)type)).toString(), new Object[0]);
                    }
                    if (class_.isArray()) {
                        type = o.a(class_.getComponentType());
                        if (!w.b.class.isAssignableFrom((Class<?>)type)) {
                            return new j.f((c.s)object3, this.a.a(type, (Annotation[])object, this.c)).b();
                        }
                        throw this.a(n2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!w.b.class.isAssignableFrom(class_)) {
                        return new j.f((c.s)object3, this.a.a(type, (Annotation[])object, this.c));
                    }
                    throw this.a(n2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw this.a(n2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (class_ instanceof r) {
                if (this.p) {
                    this.h = true;
                    Type type4 = p.a(type);
                    if (Map.class.isAssignableFrom((Class<?>)type4)) {
                        if ((type = p.b(type, type4, Map.class)) instanceof ParameterizedType) {
                            type4 = (ParameterizedType)type;
                            type = p.a(0, type4);
                            if (String.class == type) {
                                type = p.a(1, type4);
                                if (!w.b.class.isAssignableFrom(p.a(type))) {
                                    return new j.g(this.a.a(type, (Annotation[])object, this.c), ((r)((Object)class_)).a());
                                }
                                throw this.a(n2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            object = new StringBuilder();
                            ((StringBuilder)object).append("@PartMap keys must be of type String: ");
                            ((StringBuilder)object).append(type);
                            throw this.a(n2, ((StringBuilder)object).toString(), new Object[0]);
                        }
                        throw this.a(n2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw this.a(n2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw this.a(n2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (class_ instanceof f.c.a) {
                if (!this.o && !this.p) {
                    if (!this.i) {
                        try {
                            object = this.a.a(type, (Annotation[])object, this.c);
                        }
                        catch (RuntimeException runtimeException) {
                            throw this.a((Throwable)runtimeException, n2, "Unable to create @Body converter for %s", type);
                        }
                        this.i = true;
                        return new j.a(object);
                    }
                    throw this.a(n2, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw this.a(n2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            }
            return null;
        }

        private /* varargs */ RuntimeException a(int n2, String string2, Object ... arrobject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" (parameter #");
            stringBuilder.append(n2 + 1);
            stringBuilder.append(")");
            return this.a(stringBuilder.toString(), arrobject);
        }

        private /* varargs */ RuntimeException a(String string2, Object ... arrobject) {
            return this.a(null, string2, arrobject);
        }

        private /* varargs */ RuntimeException a(Throwable throwable, int n2, String string2, Object ... arrobject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" (parameter #");
            stringBuilder.append(n2 + 1);
            stringBuilder.append(")");
            return this.a(throwable, stringBuilder.toString(), arrobject);
        }

        private /* varargs */ RuntimeException a(Throwable throwable, String string2, Object ... object) {
            string2 = String.format(string2, (Object[])object);
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("\n    for method ");
            ((StringBuilder)object).append(this.b.getDeclaringClass().getSimpleName());
            ((StringBuilder)object).append(".");
            ((StringBuilder)object).append(this.b.getName());
            return new IllegalArgumentException(((StringBuilder)object).toString(), throwable);
        }

        private void a(int n2, String string2) {
            if (o.b.matcher(string2).matches()) {
                if (this.t.contains(string2)) {
                    return;
                }
                throw this.a(n2, "URL \"%s\" does not contain \"{%s}\".", this.q, string2);
            }
            throw this.a(n2, "@Path parameter name must match %s. Found: %s", o.a.pattern(), string2);
        }

        private void a(String string2, String string3, boolean bl2) {
            if (this.m == null) {
                this.m = string2;
                this.n = bl2;
                if (string3.isEmpty()) {
                    return;
                }
                int n2 = string3.indexOf(63);
                if (n2 != -1 && n2 < string3.length() - 1 && o.a.matcher(string2 = string3.substring(n2 + 1)).find()) {
                    throw this.a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", string2);
                }
                this.q = string3;
                this.t = o.a(string3);
                return;
            }
            throw this.a("Only one HTTP method is allowed. Found: %s and %s.", this.m, string2);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(Annotation object) {
            block22 : {
                String string2;
                block16 : {
                    block21 : {
                        String string3;
                        block19 : {
                            block20 : {
                                block18 : {
                                    block17 : {
                                        block15 : {
                                            if (!(object instanceof b)) break block15;
                                            String string4 = "DELETE";
                                            string2 = ((b)object).a();
                                            object = string4;
                                            break block16;
                                        }
                                        if (!(object instanceof f)) break block17;
                                        string2 = "GET";
                                        String string5 = ((f)object).a();
                                        object = string2;
                                        string2 = string5;
                                        break block16;
                                    }
                                    if (object instanceof g) {
                                        this.a("HEAD", ((g)object).a(), false);
                                        if (Void.class.equals((Object)this.f)) {
                                            return;
                                        }
                                        throw this.a("HEAD method must use Void as response type.", new Object[0]);
                                    }
                                    if (!(object instanceof f.c.n)) break block18;
                                    String string6 = "PATCH";
                                    string3 = ((f.c.n)object).a();
                                    object = string6;
                                    break block19;
                                }
                                if (!(object instanceof f.c.o)) break block20;
                                string3 = "POST";
                                String string7 = ((f.c.o)object).a();
                                object = string3;
                                string3 = string7;
                                break block19;
                            }
                            if (!(object instanceof f.c.p)) break block21;
                            string3 = "PUT";
                            String string8 = ((f.c.p)object).a();
                            object = string3;
                            string3 = string8;
                        }
                        this.a((String)object, string3, true);
                        return;
                    }
                    if (!(object instanceof f.c.m)) break block22;
                    string2 = "OPTIONS";
                    String string9 = ((f.c.m)object).a();
                    object = string2;
                    string2 = string9;
                }
                this.a((String)object, string2, false);
                return;
            }
            if (object instanceof h) {
                object = (h)object;
                this.a(object.a(), object.b(), object.c());
                return;
            }
            if (object instanceof k) {
                if (((Object)(object = ((k)object).a())).length != 0) {
                    this.r = this.a((String[])object);
                    return;
                }
                throw this.a("@Headers annotation is empty.", new Object[0]);
            }
            if (object instanceof f.c.l) {
                if (!this.o) {
                    this.p = true;
                    return;
                }
                throw this.a("Only one encoding annotation is allowed.", new Object[0]);
            }
            if (!(object instanceof e)) {
                return;
            }
            if (!this.p) {
                this.o = true;
                return;
            }
            throw this.a("Only one encoding annotation is allowed.", new Object[0]);
        }

        private f.c<T, R> b() {
            Type type = this.b.getGenericReturnType();
            if (!p.d(type)) {
                if (type != Void.TYPE) {
                    Object object = this.b.getAnnotations();
                    try {
                        object = this.a.a(type, (Annotation[])object);
                        return object;
                    }
                    catch (RuntimeException runtimeException) {
                        throw this.a((Throwable)runtimeException, "Unable to create call adapter for %s", type);
                    }
                }
                throw this.a("Service methods cannot return void.", new Object[0]);
            }
            throw this.a("Method return type must not include a type variable or wildcard: %s", type);
        }

        private f.e<ad, T> c() {
            Object object = this.b.getAnnotations();
            try {
                object = this.a.b(this.f, (Annotation[])object);
                return object;
            }
            catch (RuntimeException runtimeException) {
                throw this.a((Throwable)runtimeException, "Unable to create converter for %s", this.f);
            }
        }

        public o a() {
            this.w = this.b();
            this.f = this.w.a();
            if (this.f != m.class && this.f != ac.class) {
                int n2;
                this.v = this.c();
                Object object = this.c;
                int n3 = ((Annotation[])object).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    this.a(object[n2]);
                }
                if (this.m != null) {
                    if (!this.n) {
                        if (!this.p) {
                            if (this.o) {
                                throw this.a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                            }
                        } else {
                            throw this.a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    }
                    n3 = this.d.length;
                    this.u = new j[n3];
                    for (n2 = 0; n2 < n3; ++n2) {
                        object = this.e[n2];
                        if (!p.d((Type)object)) {
                            Annotation[] arrannotation = this.d[n2];
                            if (arrannotation != null) {
                                this.u[n2] = this.a(n2, (Type)object, arrannotation);
                                continue;
                            }
                            throw this.a(n2, "No Retrofit annotation found.", new Object[0]);
                        }
                        throw this.a(n2, "Parameter type must not include a type variable or wildcard: %s", object);
                    }
                    if (this.q == null && !this.l) {
                        throw this.a("Missing either @%s URL or @Url parameter.", this.m);
                    }
                    if (!this.o && !this.p && !this.n && this.i) {
                        throw this.a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                    }
                    if (this.o && !this.g) {
                        throw this.a("Form-encoded method must contain at least one @Field.", new Object[0]);
                    }
                    if (this.p && !this.h) {
                        throw this.a("Multipart method must contain at least one @Part.", new Object[0]);
                    }
                    return new o(this);
                }
                throw this.a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            stringBuilder.append(p.a(this.f).getName());
            stringBuilder.append("' is not a valid response body type. Did you mean ResponseBody?");
            throw this.a(stringBuilder.toString(), new Object[0]);
        }
    }

}

