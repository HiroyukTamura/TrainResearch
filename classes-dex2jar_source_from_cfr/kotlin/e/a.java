/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.e.b.d;
import kotlin.e.b.j;
import kotlin.e.b.v;
import kotlin.reflect.c;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a\u00a2\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018GX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018\u00c7\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=2, mv={1, 1, 11})
public final class a {
    public static final <T> Class<T> a(c<T> object) {
        j.b(object, "$receiver");
        object = ((d)object).a();
        if (object != null) {
            return object;
        }
        throw new t("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static final <T> c<T> a(Class<T> class_) {
        j.b(class_, "$receiver");
        return v.a(class_);
    }

    public static final <T extends Annotation> c<? extends T> a(T object) {
        j.b(object, "$receiver");
        object = object.annotationType();
        j.a(object, "(this as java.lang.annot\u2026otation).annotationType()");
        object = a.a(object);
        if (object != null) {
            return object;
        }
        throw new t("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }

    public static final <T> Class<T> b(c<T> object) {
        j.b(object, "$receiver");
        object = ((d)object).a();
        if (((Class)object).isPrimitive()) {
            if (object != null) {
                return object;
            }
            throw new t("null cannot be cast to non-null type java.lang.Class<T>");
        }
        if ((object = ((Class)object).getName()) != null) {
            switch (((String)object).hashCode()) {
                default: {
                    break;
                }
                case 761287205: {
                    if (!((String)object).equals("java.lang.Double")) break;
                    return Double.TYPE;
                }
                case 399092968: {
                    if (!((String)object).equals("java.lang.Void")) break;
                    return Void.TYPE;
                }
                case 398795216: {
                    if (!((String)object).equals("java.lang.Long")) break;
                    return Long.TYPE;
                }
                case 398507100: {
                    if (!((String)object).equals("java.lang.Byte")) break;
                    return Byte.TYPE;
                }
                case 344809556: {
                    if (!((String)object).equals("java.lang.Boolean")) break;
                    return Boolean.TYPE;
                }
                case 155276373: {
                    if (!((String)object).equals("java.lang.Character")) break;
                    return Character.TYPE;
                }
                case -515992664: {
                    if (!((String)object).equals("java.lang.Short")) break;
                    return Short.TYPE;
                }
                case -527879800: {
                    if (!((String)object).equals("java.lang.Float")) break;
                    return Float.TYPE;
                }
                case -2056817302: {
                    if (!((String)object).equals("java.lang.Integer")) break;
                    return Integer.TYPE;
                }
            }
        }
        return null;
    }

    public static final <T> Class<T> c(c<T> class_) {
        j.b(class_, "$receiver");
        class_ = ((d)((Object)class_)).a();
        if (!class_.isPrimitive()) {
            if (class_ != null) {
                return class_;
            }
            throw new t("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String string2 = class_.getName();
        if (string2 != null) {
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 109413500: {
                    if (!string2.equals("short")) break;
                    class_ = Short.class;
                    break;
                }
                case 97526364: {
                    if (!string2.equals("float")) break;
                    class_ = Float.class;
                    break;
                }
                case 64711720: {
                    if (!string2.equals("boolean")) break;
                    class_ = Boolean.class;
                    break;
                }
                case 3625364: {
                    if (!string2.equals("void")) break;
                    class_ = Void.class;
                    break;
                }
                case 3327612: {
                    if (!string2.equals("long")) break;
                    class_ = Long.class;
                    break;
                }
                case 3052374: {
                    if (!string2.equals("char")) break;
                    class_ = Character.class;
                    break;
                }
                case 3039496: {
                    if (!string2.equals("byte")) break;
                    class_ = Byte.class;
                    break;
                }
                case 104431: {
                    if (!string2.equals("int")) break;
                    class_ = Integer.class;
                    break;
                }
                case -1325958191: {
                    if (!string2.equals("double")) break;
                    class_ = Double.class;
                }
            }
        }
        if (class_ != null) {
            return class_;
        }
        throw new t("null cannot be cast to non-null type java.lang.Class<T>");
    }
}

