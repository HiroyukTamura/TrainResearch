/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.a.q;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.b.c;
import kotlin.reflect.jvm.internal.impl.c.a.f.s;
import kotlin.reflect.jvm.internal.impl.c.b.h;
import kotlin.reflect.jvm.internal.impl.c.b.k;
import kotlin.reflect.jvm.internal.impl.c.b.v;
import kotlin.reflect.jvm.internal.impl.c.b.x;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.c;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.l.d;
import kotlin.t;
import kotlin.w;
import kotlin.y;

public final class z {
    private static final <T> T a(k<T> k2, T t2, boolean bl2) {
        T t3 = t2;
        if (bl2) {
            t3 = k2.a(t2);
        }
        return t3;
    }

    private static final <T> T a(kotlin.reflect.jvm.internal.impl.j.w object, k<T> k2, x object2) {
        Object object3;
        kotlin.reflect.jvm.internal.impl.a.m m2 = object3 = object.g().d();
        if (!(object3 instanceof e)) {
            m2 = null;
        }
        if ((m2 = (e)m2) != null) {
            object3 = SuspendFunctionTypesKt.getFAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL();
            boolean bl2 = false;
            boolean bl3 = false;
            if (m2 == object3) {
                return k2.b(z.a(false));
            }
            if (j.a((Object)m2, (Object)SuspendFunctionTypesKt.getFAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE())) {
                return k2.b(z.a(true));
            }
            object3 = KotlinBuiltIns.getPrimitiveType(m2 = (kotlin.reflect.jvm.internal.impl.a.m)m2);
            if (object3 != null) {
                object2 = kotlin.reflect.jvm.internal.impl.h.d.c.a((PrimitiveType)((Object)object3));
                j.a(object2, "JvmPrimitiveType.get(primitiveType)");
                object2 = ((kotlin.reflect.jvm.internal.impl.h.d.c)((Object)object2)).c();
                j.a(object2, "JvmPrimitiveType.get(primitiveType).desc");
                object2 = k2.a((String)object2);
                if (av.f(object) || s.a(object)) {
                    bl3 = true;
                }
                return (T)z.a(k2, object2, bl3);
            }
            object = KotlinBuiltIns.getPrimitiveArrayType(m2);
            if (object != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("[");
                object = kotlin.reflect.jvm.internal.impl.h.d.c.a((PrimitiveType)((Object)object));
                j.a(object, "JvmPrimitiveType.get(arrayElementType)");
                ((StringBuilder)object2).append(((kotlin.reflect.jvm.internal.impl.h.d.c)((Object)object)).c());
                return k2.a(((StringBuilder)object2).toString());
            }
            if (KotlinBuiltIns.isUnderKotlinPackage(m2) && (object = kotlin.reflect.jvm.internal.impl.builtins.b.c.a.a(kotlin.reflect.jvm.internal.impl.h.c.a.a(m2))) != null) {
                if (!((x)object2).e()) {
                    boolean bl4;
                    block13 : {
                        object2 = kotlin.reflect.jvm.internal.impl.builtins.b.c.a.a();
                        if (object2 instanceof Collection && ((Collection)object2).isEmpty()) {
                            bl4 = bl2;
                        } else {
                            object2 = object2.iterator();
                            do {
                                bl4 = bl2;
                                if (!object2.hasNext()) break block13;
                            } while (!j.a((Object)((c.a)object2.next()).a(), object));
                            bl4 = true;
                        }
                    }
                    if (bl4) {
                        return null;
                    }
                }
                object = kotlin.reflect.jvm.internal.impl.h.d.b.a((kotlin.reflect.jvm.internal.impl.e.a)object);
                j.a(object, "JvmClassName.byClassId(classId)");
                object = ((kotlin.reflect.jvm.internal.impl.h.d.b)object).c();
                j.a(object, "JvmClassName.byClassId(classId).internalName");
                return k2.b((String)object);
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final <T> T a(kotlin.reflect.jvm.internal.impl.j.w object, k<T> object2, x object3, v<? extends T> v2, h<T> object4, q<? super kotlin.reflect.jvm.internal.impl.j.w, ? super T, ? super x, w> q2, boolean bl2) {
        kotlin.reflect.jvm.internal.impl.a.h h2;
        boolean bl3;
        block20 : {
            block22 : {
                block23 : {
                    ap ap2;
                    block21 : {
                        j.b(object, "kotlinType");
                        j.b(object2, "factory");
                        j.b(object3, "mode");
                        j.b(v2, "typeMappingConfiguration");
                        j.b(q2, "writeGenericType");
                        if (FunctionTypesKt.isSuspendFunctionType((kotlin.reflect.jvm.internal.impl.j.w)object)) {
                            return (T)z.a(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType((kotlin.reflect.jvm.internal.impl.j.w)object, v2.a()), object2, (x)object3, v2, object4, q2, bl2);
                        }
                        T t2 = z.a((kotlin.reflect.jvm.internal.impl.j.w)object, object2, (x)object3);
                        if (t2 != null) {
                            object2 = z.a(object2, t2, ((x)object3).b());
                            q2.a(object, object2, object3);
                            return (T)object2;
                        }
                        an an2 = ((kotlin.reflect.jvm.internal.impl.j.w)object).g();
                        if (an2 instanceof kotlin.reflect.jvm.internal.impl.j.v) {
                            object = ((kotlin.reflect.jvm.internal.impl.j.v)an2).k_();
                            j.a(object, "constructor.supertypes");
                            return (T)z.a(a.g(v2.a((Collection<kotlin.reflect.jvm.internal.impl.j.w>)object)), object2, (x)object3, v2, object4, q2, bl2);
                        }
                        h2 = an2.d();
                        if (h2 == null) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("no descriptor for type constructor of ");
                            ((StringBuilder)object2).append(object);
                            throw (Throwable)new UnsupportedOperationException(((StringBuilder)object2).toString());
                        }
                        if (p.a(h2)) {
                            object2 = object2.b("error/NonExistentClass");
                            if (h2 == null) throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            v2.a((kotlin.reflect.jvm.internal.impl.j.w)object, (e)h2);
                            if (object4 == null) return (T)object2;
                            ((h)object4).a(object2);
                            return (T)object2;
                        }
                        bl3 = h2 instanceof e;
                        if (!bl3 || !KotlinBuiltIns.isArray(object)) break block20;
                        if (((kotlin.reflect.jvm.internal.impl.j.w)object).a().size() != 1) throw (Throwable)new UnsupportedOperationException("arrays must have one type argument");
                        ap2 = ((kotlin.reflect.jvm.internal.impl.j.w)object).a().get(0);
                        object = ap2.c();
                        if (ap2.b() != ba.b) break block21;
                        object = object3 = object2.b("java/lang/Object");
                        if (object4 == null) break block22;
                        ((h)object4).a();
                        ((h)object4).a(object3);
                        object = object3;
                        break block23;
                    }
                    if (object4 != null) {
                        ((h)object4).a();
                    }
                    j.a(object, "memberType");
                    ba ba2 = ap2.b();
                    j.a((Object)ba2, "memberProjection.projectionKind");
                    object = object3 = z.a((kotlin.reflect.jvm.internal.impl.j.w)object, object2, ((x)object3).a(ba2), v2, object4, q2, bl2);
                    if (object4 == null) break block22;
                    object = object3;
                }
                ((h)object4).b();
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("[");
            ((StringBuilder)object3).append(object2.b(object));
            return object2.a(((StringBuilder)object3).toString());
        }
        if (bl3) {
            kotlin.reflect.jvm.internal.impl.j.w w2;
            e e2 = (e)h2;
            if (e2.t() && !((x)object3).c() && (w2 = z.a((kotlin.reflect.jvm.internal.impl.j.w)object)) != null) {
                if (kotlin.reflect.jvm.internal.impl.h.e.c(w2)) {
                    return (T)z.a(w2, object2, (x)object3, v2, object4, q2, bl2);
                }
                object3 = ((x)object3).a();
                return (T)z.a(w2, object2, (x)object3, v2, object4, q2, bl2);
            }
            if (((x)object3).d() && KotlinBuiltIns.isKClass(e2)) {
                object2 = object2.a();
            } else {
                object4 = e2.E();
                j.a(object4, "descriptor.original");
                object4 = v2.a((e)object4);
                if (object4 != null) {
                    object2 = object4;
                } else {
                    object4 = e2;
                    if (e2.l() == kotlin.reflect.jvm.internal.impl.a.f.d) {
                        object4 = e2.b();
                        if (object4 == null) throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        object4 = (e)object4;
                    }
                    object4 = object4.E();
                    j.a(object4, "enumClassIfEnumEntry.original");
                    object2 = object2.b(z.a((e)object4, v2, bl2));
                }
            }
            q2.a(object, object2, object3);
            return (T)object2;
        }
        if (!(h2 instanceof as)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unknown type ");
            ((StringBuilder)object2).append(object);
            throw (Throwable)new UnsupportedOperationException(((StringBuilder)object2).toString());
        }
        object = z.a((as)h2);
        q2 = d.c();
        object = z.a((kotlin.reflect.jvm.internal.impl.j.w)object, object2, (x)object3, v2, null, q2, bl2);
        if (object4 == null) return (T)object;
        object2 = h2.h_();
        j.a(object2, "descriptor.getName()");
        ((h)object4).a((f)object2, object);
        return (T)object;
    }

    public static /* synthetic */ Object a(kotlin.reflect.jvm.internal.impl.j.w w2, k k2, x x2, v v2, h h2, q q2, boolean bl2, int n2, Object object) {
        if ((n2 & 32) != 0) {
            q2 = d.c();
        }
        return z.a(w2, k2, x2, v2, h2, q2, bl2);
    }

    public static final String a(e object, v<?> object2, boolean bl2) {
        j.b(object, "klass");
        j.b(object2, "typeMappingConfiguration");
        kotlin.reflect.jvm.internal.impl.a.m m2 = bl2 ? z.a(object.b()) : object.b();
        Object object3 = kotlin.reflect.jvm.internal.impl.e.h.a(object.h_());
        j.a(object3, "SpecialNames.safeIdentifier(klass.name)");
        String string2 = ((f)object3).b();
        if (m2 instanceof ab) {
            object2 = ((ab)m2).f();
            if (((b)object2).c()) {
                j.a((Object)string2, "name");
                return string2;
            }
            object = new StringBuilder();
            object2 = ((b)object2).a();
            j.a(object2, "fqName.asString()");
            ((StringBuilder)object).append(n.a((String)object2, '.', '/', false, 4, null));
            ((StringBuilder)object).append('/');
            ((StringBuilder)object).append(string2);
            return ((StringBuilder)object).toString();
        }
        object3 = !(m2 instanceof e) ? null : m2;
        if ((object3 = (e)object3) != null) {
            object = object2.b((e)object3);
            if (object == null) {
                object = z.a((e)object3, object2, bl2);
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("$");
            ((StringBuilder)object2).append(string2);
            return ((StringBuilder)object2).toString();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unexpected container: ");
        ((StringBuilder)object2).append(m2);
        ((StringBuilder)object2).append(" for ");
        ((StringBuilder)object2).append(object);
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object2).toString());
    }

    public static /* bridge */ /* synthetic */ String a(e e2, v v2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            v2 = kotlin.reflect.jvm.internal.impl.c.b.w.a;
        }
        return z.a(e2, v2, bl2);
    }

    private static final String a(boolean bl2) {
        Object object = bl2 ? kotlin.reflect.jvm.internal.impl.h.c.h : kotlin.reflect.jvm.internal.impl.h.c.g;
        object = kotlin.reflect.jvm.internal.impl.h.d.b.a(kotlin.reflect.jvm.internal.impl.e.a.a((b)object));
        j.a(object, "JvmClassName.byClassId(ClassId.topLevel(fqName))");
        object = ((kotlin.reflect.jvm.internal.impl.h.d.b)object).c();
        j.a(object, "JvmClassName.byClassId(C\u2026vel(fqName)).internalName");
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final kotlin.reflect.jvm.internal.impl.a.m a(kotlin.reflect.jvm.internal.impl.a.m m2) {
        boolean bl2 = m2 instanceof e;
        Object var3_2 = null;
        kotlin.reflect.jvm.internal.impl.a.m m3 = !bl2 ? null : m2;
        if ((m3 = (e)m3) == null) {
            m3 = !(m2 instanceof ab) ? null : m2;
            m3 = (ab)m3;
        }
        if (m3 != null) {
            return m3;
        }
        m3 = var3_2;
        if (m2 == null) return m3;
        return z.a(m2.b());
    }

    private static final kotlin.reflect.jvm.internal.impl.j.w a(as a2) {
        List<kotlin.reflect.jvm.internal.impl.j.w> list;
        block5 : {
            block4 : {
                Object t2;
                boolean bl2;
                list = a2.j();
                boolean bl3 = list.isEmpty();
                if (y.a && !(bl3 ^ true)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Upper bounds should not be empty: ");
                    stringBuilder.append(a2);
                    throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
                }
                j.a(list, "upperBounds");
                Iterator iterator = ((Iterable)list).iterator();
                do {
                    boolean bl4;
                    bl3 = iterator.hasNext();
                    a2 = null;
                    if (!bl3) break block4;
                    t2 = iterator.next();
                    kotlin.reflect.jvm.internal.impl.a.h h2 = ((kotlin.reflect.jvm.internal.impl.j.w)t2).g().d();
                    if (h2 instanceof e) {
                        a2 = h2;
                    }
                    a2 = (e)a2;
                    bl2 = bl4 = false;
                    if (a2 == null) continue;
                    bl2 = bl4;
                    if (a2.l() == kotlin.reflect.jvm.internal.impl.a.f.b) continue;
                    bl2 = bl4;
                    if (a2.l() == kotlin.reflect.jvm.internal.impl.a.f.e) continue;
                    bl2 = true;
                } while (!bl2);
                a2 = t2;
                break block5;
            }
            a2 = null;
        }
        a2 = (kotlin.reflect.jvm.internal.impl.j.w)a2;
        if (a2 != null) {
            return a2;
        }
        a2 = m.f(list);
        j.a((Object)a2, "upperBounds.first()");
        return (kotlin.reflect.jvm.internal.impl.j.w)a2;
    }

    public static final kotlin.reflect.jvm.internal.impl.j.w a(kotlin.reflect.jvm.internal.impl.j.w w2) {
        j.b(w2, "inlineClassType");
        if (!z.b(w2)) {
            return null;
        }
        Object object = kotlin.reflect.jvm.internal.impl.h.e.b(w2);
        if (object != null && (object = ((kotlin.reflect.jvm.internal.impl.j.w)object).g()) != null && (object = object.d()) != null) {
            if (object instanceof as) {
                return z.a((as)object);
            }
            return kotlin.reflect.jvm.internal.impl.h.e.d(w2);
        }
        return null;
    }

    public static final boolean a(kotlin.reflect.jvm.internal.impl.a.a a2) {
        j.b(a2, "descriptor");
        if (a2 instanceof l) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.j.w w2 = a2.g();
        if (w2 == null) {
            j.a();
        }
        if (KotlinBuiltIns.isUnit(w2)) {
            w2 = a2.g();
            if (w2 == null) {
                j.a();
            }
            if (!av.f(w2) && !(a2 instanceof aj)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(kotlin.reflect.jvm.internal.impl.j.w w2) {
        boolean bl2;
        block2 : {
            block3 : {
                boolean bl3;
                j.b(w2, "inlineClassType");
                kotlin.reflect.jvm.internal.impl.j.w w3 = kotlin.reflect.jvm.internal.impl.h.e.b(w2);
                bl2 = bl3 = false;
                if (w3 == null) break block2;
                if (!w2.c()) break block3;
                bl2 = bl3;
                if (av.f(w3)) break block2;
                bl2 = bl3;
                if (KotlinBuiltIns.isPrimitiveType(w3)) break block2;
            }
            bl2 = true;
        }
        return bl2;
    }
}

