/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.r;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.l;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a6\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u00a8\u0006\u0012\u00b2\u0006\r\u0010\u0013\u001a\u00020\rX\u008a\u0084\u0002\u00a2\u0006\u0000\u00b2\u0006\r\u0010\u0014\u001a\u00020\tX\u008a\u0084\u0002\u00a2\u0006\u0000"}, d2={"createAnnotationInstance", "", "annotationClass", "Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "values", "", "", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflect-api", "hashCode", "toString"}, k=2, mv={1, 1, 11})
public final class b {
    static final /* synthetic */ l[] a;

    static {
        a = new l[]{v.a(new r(v.a(b.class, "kotlin-reflect-api"), "hashCode", "<v#0>")), v.a(new r(v.a(b.class, "kotlin-reflect-api"), "toString", "<v#1>"))};
    }

    public static final /* synthetic */ Object a(Class class_, List list, Map map) {
        return b.b(class_, list, map);
    }

    public static final /* synthetic */ Object a(Object object, Class class_) {
        return b.b(object, class_);
    }

    public static final /* synthetic */ Void a(int n2, String string2, Class class_) {
        return b.b(n2, string2, class_);
    }

    private static final Object b(final Class<?> object, final List<Method> object2, final Map<String, ? extends Object> object3) {
        kotlin.e.a.b<Object, Boolean> b2 = new kotlin.e.a.b<Object, Boolean>(){

            @Override
            public /* synthetic */ Object a(Object object4) {
                return this.b(object4);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final boolean b(Object class_) {
                boolean bl2 = class_ instanceof Annotation;
                Object object4 = null;
                Object object22 = !bl2 ? null : class_;
                Annotation annotation = (Annotation)object22;
                object22 = object4;
                if (annotation != null) {
                    kotlin.reflect.c<Annotation> c2 = kotlin.e.a.a(annotation);
                    object22 = object4;
                    if (c2 != null) {
                        object22 = kotlin.e.a.a(c2);
                    }
                }
                if (!j.a(object22, (Object)object)) return false;
                object22 = object2;
                if (object22 instanceof Collection && ((Collection)object22).isEmpty()) {
                    return true;
                }
                object22 = object22.iterator();
                do {
                    if (!object22.hasNext()) return true;
                    object4 = (Method)object22.next();
                    Object v2 = object3.get(((Method)object4).getName());
                    object4 = ((Method)object4).invoke(class_, new Object[0]);
                    if (v2 instanceof boolean[]) {
                        boolean[] arrbl = (boolean[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.BooleanArray");
                        bl2 = Arrays.equals(arrbl, (boolean[])object4);
                        continue;
                    }
                    if (v2 instanceof char[]) {
                        char[] arrc = (char[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.CharArray");
                        bl2 = Arrays.equals(arrc, (char[])object4);
                        continue;
                    }
                    if (v2 instanceof byte[]) {
                        byte[] arrby = (byte[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.ByteArray");
                        bl2 = Arrays.equals(arrby, (byte[])object4);
                        continue;
                    }
                    if (v2 instanceof short[]) {
                        short[] arrs = (short[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.ShortArray");
                        bl2 = Arrays.equals(arrs, (short[])object4);
                        continue;
                    }
                    if (v2 instanceof int[]) {
                        int[] arrn = (int[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.IntArray");
                        bl2 = Arrays.equals(arrn, (int[])object4);
                        continue;
                    }
                    if (v2 instanceof float[]) {
                        float[] arrf = (float[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.FloatArray");
                        bl2 = Arrays.equals(arrf, (float[])object4);
                        continue;
                    }
                    if (v2 instanceof long[]) {
                        long[] arrl = (long[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.LongArray");
                        bl2 = Arrays.equals(arrl, (long[])object4);
                        continue;
                    }
                    if (v2 instanceof double[]) {
                        double[] arrd = (double[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.DoubleArray");
                        bl2 = Arrays.equals(arrd, (double[])object4);
                        continue;
                    }
                    if (v2 instanceof Object[]) {
                        Object[] arrobject = (Object[])v2;
                        if (object4 == null) throw new t("null cannot be cast to non-null type kotlin.Array<*>");
                        bl2 = Arrays.equals(arrobject, (Object[])object4);
                        continue;
                    }
                    bl2 = j.a(v2, object4);
                } while (bl2);
                return false;
            }
        };
        g<kotlin.e.a.a> g2 = h.a((kotlin.e.a.a)new kotlin.e.a.a<Integer>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final int b() {
                Iterator iterator = ((Iterable)object3.entrySet()).iterator();
                int n2 = 0;
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry)iterator.next();
                    String string2 = (String)entry.getKey();
                    int n3 = (entry = entry.getValue()) instanceof boolean[] ? Arrays.hashCode((boolean[])entry) : (entry instanceof char[] ? Arrays.hashCode((char[])entry) : (entry instanceof byte[] ? Arrays.hashCode((byte[])entry) : (entry instanceof short[] ? Arrays.hashCode((short[])entry) : (entry instanceof int[] ? Arrays.hashCode((int[])entry) : (entry instanceof float[] ? Arrays.hashCode((float[])entry) : (entry instanceof long[] ? Arrays.hashCode((long[])entry) : (entry instanceof double[] ? Arrays.hashCode((double[])entry) : (entry instanceof Object[] ? Arrays.hashCode((Object[])entry) : ((Object)entry).hashCode()))))))));
                    n2 += n3 ^ string2.hashCode() * 127;
                }
                return n2;
            }
        });
        l l2 = a[0];
        g<kotlin.e.a.a> g3 = h.a((kotlin.e.a.a)new kotlin.e.a.a<String>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final String b() {
                CharSequence charSequence = new StringBuilder();
                charSequence.append('@');
                charSequence.append(object.getCanonicalName());
                m.a(object3.entrySet(), charSequence, ", ", "(", ")", 0, null, a.a, 48, null);
                charSequence = charSequence.toString();
                j.a((Object)charSequence, "StringBuilder().apply(builderAction).toString()");
                return charSequence;
            }

        });
        l l3 = a[1];
        object2 = ((Class)object).getClassLoader();
        object3 = new InvocationHandler((Class)object, g3, l3, g2, l2, b2, (Map)object3){
            final /* synthetic */ Class a;
            final /* synthetic */ g b;
            final /* synthetic */ l c;
            final /* synthetic */ g d;
            final /* synthetic */ l e;
            final /* synthetic */ a f;
            final /* synthetic */ Map g;
            {
                this.a = class_;
                this.b = g2;
                this.c = l2;
                this.d = g3;
                this.e = l3;
                this.f = a2;
                this.g = map;
            }

            @Override
            public final Object invoke(Object object, Method object2, Object[] arrobject) {
                block8 : {
                    block11 : {
                        block9 : {
                            block10 : {
                                j.a(object2, "method");
                                object = ((Method)object2).getName();
                                if (object == null) break block8;
                                int n2 = ((String)object).hashCode();
                                if (n2 == -1776922004) break block9;
                                if (n2 == 147696667) break block10;
                                if (n2 == 1444986633 && ((String)object).equals("annotationType")) {
                                    return this.a;
                                }
                                break block8;
                            }
                            if (!((String)object).equals("hashCode")) break block8;
                            object = this.d;
                            object2 = this.e;
                            break block11;
                        }
                        if (!((String)object).equals("toString")) break block8;
                        object = this.b;
                        object2 = this.c;
                    }
                    return object.a();
                }
                if (j.a(object, (Object)"equals") && arrobject != null && arrobject.length == 1) {
                    return this.f.b(kotlin.a.g.f(arrobject));
                }
                if (this.g.containsKey(object)) {
                    return this.g.get(object);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Method is not supported: ");
                ((StringBuilder)object).append(object2);
                ((StringBuilder)object).append(" (args: ");
                if (arrobject == null) {
                    arrobject = new Object[]{};
                }
                ((StringBuilder)object).append(kotlin.a.g.h(arrobject));
                ((StringBuilder)object).append(')');
                throw (Throwable)new aa(((StringBuilder)object).toString());
            }
        };
        object = Proxy.newProxyInstance((ClassLoader)object2, new Class[]{object}, (InvocationHandler)object3);
        j.a(object, "Proxy.newProxyInstance(a\u2026        }\n        }\n    }");
        return object;
    }

    private static final Object b(Object arrobject, Class<?> class_) {
        Object object;
        if (arrobject instanceof Class) {
            return null;
        }
        if (arrobject instanceof kotlin.reflect.c) {
            object = kotlin.e.a.a((kotlin.reflect.c)arrobject);
        } else {
            object = arrobject;
            if (arrobject instanceof Object[]) {
                object = arrobject;
                if (object instanceof Class[]) {
                    return null;
                }
                if (object instanceof kotlin.reflect.c[]) {
                    if (arrobject != null) {
                        arrobject = (kotlin.reflect.c[])arrobject;
                        object = new ArrayList(arrobject.length);
                        int n2 = arrobject.length;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            object.add(kotlin.e.a.a(arrobject[i2]));
                        }
                        if ((object = ((Collection)((List)object)).toArray(new Class[0])) == null) {
                            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    } else {
                        throw new t("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                    }
                }
            }
        }
        if (class_.isInstance(object)) {
            return object;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static final Void b(int var0, String var1_1, Class<?> var2_2) {
        block4 : {
            if (!j.a(var2_2, Class.class)) break block4;
            var2_2 = kotlin.reflect.c.class;
            ** GOTO lbl7
        }
        if (var2_2.isArray() && j.a(var2_2.getComponentType(), Class.class)) {
            var2_2 = kotlin.reflect.c[].class;
lbl7: // 2 sources:
            var2_2 = v.a(var2_2);
        } else {
            var2_2 = kotlin.e.a.a(var2_2);
        }
        if (j.a((Object)var2_2.e_(), (Object)v.a(Object[].class).e_())) {
            var3_3 = new StringBuilder();
            var3_3.append(var2_2.e_());
            var3_3.append('<');
            var2_2 = kotlin.e.a.a(var2_2).getComponentType();
            j.a(var2_2, "kotlinClass.java.componentType");
            var3_3.append(kotlin.e.a.a(var2_2).e_());
            var3_3.append('>');
            var2_2 = var3_3.toString();
        } else {
            var2_2 = var2_2.e_();
        }
        var3_3 = new StringBuilder();
        var3_3.append("Argument #");
        var3_3.append(var0);
        var3_3.append(' ');
        var3_3.append(var1_1);
        var3_3.append(" is not of the required type ");
        var3_3.append((String)var2_2);
        throw (Throwable)new IllegalArgumentException(var3_3.toString());
    }

}

