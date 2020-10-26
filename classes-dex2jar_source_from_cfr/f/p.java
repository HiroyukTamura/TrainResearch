/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import c.ad;
import c.v;
import d.e;
import d.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

final class p {
    static final Type[] a = new Type[0];

    private static int a(Object[] arrobject, Object object) {
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            if (!object.equals(arrobject[i2])) continue;
            return i2;
        }
        throw new NoSuchElementException();
    }

    static ad a(ad ad2) {
        d.c c2 = new d.c();
        ad2.d().a(c2);
        return ad.a(ad2.a(), ad2.b(), c2);
    }

    static Class<?> a(Type type) {
        p.a(type, "type == null");
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            if ((type = ((ParameterizedType)type).getRawType()) instanceof Class) {
                return (Class)type;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(p.a(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return p.a(((WildcardType)type).getUpperBounds()[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(type.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        if ((typeVariable = typeVariable.getGenericDeclaration()) instanceof Class) {
            return (Class)((Object)typeVariable);
        }
        return null;
    }

    static <T> T a(@Nullable T t2, String string2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(string2);
    }

    static Type a(int n2, ParameterizedType object) {
        Object object2 = object.getActualTypeArguments();
        if (n2 >= 0 && n2 < ((Type[])object2).length) {
            object = object2 = object2[n2];
            if (object2 instanceof WildcardType) {
                object = ((WildcardType)object2).getUpperBounds()[0];
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(n2);
        stringBuilder.append(" not in range [0,");
        stringBuilder.append(((Type[])object2).length);
        stringBuilder.append(") for ");
        stringBuilder.append(object);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Type a(Type object, Class<?> object2, Class<?> class_) {
        if (class_ == object2) {
            return object;
        }
        if (class_.isInterface()) {
            object = ((Class)object2).getInterfaces();
            int n2 = ((Class<?>[])object).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (object[i2] == class_) {
                    return ((Class)object2).getGenericInterfaces()[i2];
                }
                if (!class_.isAssignableFrom(object[i2])) continue;
                return p.a(((Class)object2).getGenericInterfaces()[i2], object[i2], class_);
            }
        }
        if (!((Class)object2).isInterface()) {
            while (object2 != Object.class) {
                object = ((Class)object2).getSuperclass();
                if (object == class_) {
                    return ((Class)object2).getGenericSuperclass();
                }
                if (class_.isAssignableFrom((Class<?>)object)) {
                    return p.a(((Class)object2).getGenericSuperclass(), object, class_);
                }
                object2 = object;
            }
        }
        return class_;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Type a(Type type, Class<?> arrtype, Type type2) {
        Type type3;
        while (type2 instanceof TypeVariable) {
            type3 = (TypeVariable)type2;
            type2 = p.a(type, arrtype, type3);
            if (type2 != type3) continue;
            return type2;
        }
        if (type2 instanceof Class && ((Class)(type3 = (Class)type2)).isArray()) {
            type2 = ((Class)type3).getComponentType();
            if (type2 != (type = p.a(type, arrtype, type2))) return new a(type);
            return type3;
        }
        if (type2 instanceof GenericArrayType) {
            type3 = (type2 = (GenericArrayType)type2).getGenericComponentType();
            if (type3 != (type = p.a(type, arrtype, type3))) return new a(type);
            return type2;
        }
        boolean bl2 = type2 instanceof ParameterizedType;
        if (bl2) {
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            type2 = parameterizedType.getOwnerType();
            Type type4 = p.a(type, arrtype, type2);
            boolean bl3 = type4 != type2;
            type2 = parameterizedType.getActualTypeArguments();
            int n2 = ((Type)type2).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Type type5 = p.a(type, arrtype, type2[i2]);
                boolean bl4 = bl3;
                type3 = type2;
                if (type5 != type2[i2]) {
                    bl4 = bl3;
                    type3 = type2;
                    if (!bl3) {
                        type3 = (Type[])type2.clone();
                        bl4 = true;
                    }
                    type3[i2] = type5;
                }
                bl3 = bl4;
                type2 = type3;
            }
            if (!bl3) return parameterizedType;
            return new b(type4, parameterizedType.getRawType(), (Type[])type2);
        }
        type3 = type2;
        if (!(type2 instanceof WildcardType)) return type3;
        type2 = (WildcardType)type2;
        Type[] arrtype2 = type2.getLowerBounds();
        Type[] arrtype3 = type2.getUpperBounds();
        if (arrtype2.length == 1) {
            type = p.a(type, arrtype, arrtype2[0]);
            type3 = type2;
            if (type == arrtype2[0]) return type3;
            return new c(new Type[]{Object.class}, new Type[]{type});
        }
        type3 = type2;
        if (arrtype3.length != 1) return type3;
        type3 = arrtype3[0];
        type = p.a(type, arrtype, type3);
        type3 = type2;
        if (type == arrtype3[0]) return type3;
        arrtype = a;
        return new c(new Type[]{type}, arrtype);
    }

    private static Type a(Type type, Class<?> class_, TypeVariable<?> typeVariable) {
        Class<?> class_2 = p.a(typeVariable);
        if (class_2 == null) {
            return typeVariable;
        }
        if ((type = p.a(type, class_, class_2)) instanceof ParameterizedType) {
            int n2 = p.a(class_2.getTypeParameters(), typeVariable);
            return ((ParameterizedType)type).getActualTypeArguments()[n2];
        }
        return typeVariable;
    }

    static <T> void a(Class<T> class_) {
        if (class_.isInterface()) {
            if (class_.getInterfaces().length <= 0) {
                return;
            }
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    static void a(Throwable throwable) {
        if (!(throwable instanceof VirtualMachineError)) {
            if (!(throwable instanceof ThreadDeath)) {
                if (!(throwable instanceof LinkageError)) {
                    return;
                }
                throw (LinkageError)throwable;
            }
            throw (ThreadDeath)throwable;
        }
        throw (VirtualMachineError)throwable;
    }

    static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            Type type3;
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            type = (ParameterizedType)type;
            type2 = (ParameterizedType)type2;
            Type type4 = type.getOwnerType();
            return (type4 == (type3 = type2.getOwnerType()) || type4 != null && type4.equals(type3)) && type.getRawType().equals(type2.getRawType()) && Arrays.equals(type.getActualTypeArguments(), type2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            type = (GenericArrayType)type;
            type2 = (GenericArrayType)type2;
            return p.a(type.getGenericComponentType(), type2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            type = (WildcardType)type;
            type2 = (WildcardType)type2;
            return Arrays.equals(type.getUpperBounds(), type2.getUpperBounds()) && Arrays.equals(type.getLowerBounds(), type2.getLowerBounds());
        }
        if (type instanceof TypeVariable) {
            if (!(type2 instanceof TypeVariable)) {
                return false;
            }
            type = (TypeVariable)type;
            type2 = (TypeVariable)type2;
            return type.getGenericDeclaration() == type2.getGenericDeclaration() && type.getName().equals(type2.getName());
        }
        return false;
    }

    static boolean a(Annotation[] arrannotation, Class<? extends Annotation> class_) {
        int n2 = arrannotation.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!class_.isInstance(arrannotation[i2])) continue;
            return true;
        }
        return false;
    }

    static String b(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }

    static Type b(Type type, Class<?> class_, Class<?> class_2) {
        if (class_2.isAssignableFrom(class_)) {
            return p.a(type, class_, p.a(type, class_, class_2));
        }
        throw new IllegalArgumentException();
    }

    static void c(Type type) {
        if (type instanceof Class) {
            if (!((Class)type).isPrimitive()) {
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    static boolean d(@Nullable Type arrtype) {
        if (arrtype instanceof Class) {
            return false;
        }
        if (arrtype instanceof ParameterizedType) {
            arrtype = ((ParameterizedType)arrtype).getActualTypeArguments();
            int n2 = arrtype.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!p.d(arrtype[i2])) continue;
                return true;
            }
            return false;
        }
        if (arrtype instanceof GenericArrayType) {
            return p.d(((GenericArrayType)arrtype).getGenericComponentType());
        }
        if (arrtype instanceof TypeVariable) {
            return true;
        }
        if (arrtype instanceof WildcardType) {
            return true;
        }
        String string2 = arrtype == null ? "null" : arrtype.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(arrtype);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Type e(Type type) {
        if (type instanceof ParameterizedType) {
            return p.a(0, (ParameterizedType)type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    private static final class a
    implements GenericArrayType {
        private final Type a;

        a(Type type) {
            this.a = type;
        }

        public boolean equals(Object object) {
            return object instanceof GenericArrayType && p.a(this, (GenericArrayType)object);
        }

        @Override
        public Type getGenericComponentType() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(p.b(this.a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    private static final class b
    implements ParameterizedType {
        private final Type a;
        private final Type b;
        private final Type[] c;

        /* varargs */ b(@Nullable Type type, Type type2, Type ... arrtype) {
            int n2;
            int n3;
            boolean bl2 = type2 instanceof Class;
            int n4 = 0;
            if (bl2) {
                n2 = 1;
                n3 = type == null ? 1 : 0;
                if (((Class)type2).getEnclosingClass() != null) {
                    n2 = 0;
                }
                if (n3 != n2) {
                    throw new IllegalArgumentException();
                }
            }
            n2 = arrtype.length;
            for (n3 = n4; n3 < n2; ++n3) {
                Type type3 = arrtype[n3];
                p.a(type3, "typeArgument == null");
                p.c(type3);
            }
            this.a = type;
            this.b = type2;
            this.c = (Type[])arrtype.clone();
        }

        public boolean equals(Object object) {
            return object instanceof ParameterizedType && p.a(this, (Type)((ParameterizedType)object));
        }

        @Override
        public Type[] getActualTypeArguments() {
            return (Type[])this.c.clone();
        }

        @Override
        public Type getOwnerType() {
            return this.a;
        }

        @Override
        public Type getRawType() {
            return this.b;
        }

        public int hashCode() {
            int n2 = Arrays.hashCode(this.c);
            int n3 = this.b.hashCode();
            int n4 = this.a != null ? this.a.hashCode() : 0;
            return n2 ^ n3 ^ n4;
        }

        public String toString() {
            if (this.c.length == 0) {
                return p.b(this.b);
            }
            int n2 = this.c.length;
            StringBuilder stringBuilder = new StringBuilder((n2 + 1) * 30);
            stringBuilder.append(p.b(this.b));
            stringBuilder.append("<");
            stringBuilder.append(p.b(this.c[0]));
            for (int i2 = 1; i2 < this.c.length; ++i2) {
                stringBuilder.append(", ");
                stringBuilder.append(p.b(this.c[i2]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    private static final class c
    implements WildcardType {
        private final Type a;
        private final Type b;

        c(Type[] object, Type[] arrtype) {
            block2 : {
                block3 : {
                    block8 : {
                        block7 : {
                            block4 : {
                                block5 : {
                                    block6 : {
                                        if (arrtype.length > 1) break block2;
                                        if (((Type[])object).length != 1) break block3;
                                        if (arrtype.length != 1) break block4;
                                        if (arrtype[0] == null) break block5;
                                        p.c(arrtype[0]);
                                        if (object[0] != Object.class) break block6;
                                        this.b = arrtype[0];
                                        object = Object.class;
                                        break block7;
                                    }
                                    throw new IllegalArgumentException();
                                }
                                throw new NullPointerException();
                            }
                            if (object[0] == null) break block8;
                            p.c(object[0]);
                            this.b = null;
                            object = object[0];
                        }
                        this.a = object;
                        return;
                    }
                    throw new NullPointerException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public boolean equals(Object object) {
            return object instanceof WildcardType && p.a(this, (WildcardType)object);
        }

        @Override
        public Type[] getLowerBounds() {
            if (this.b != null) {
                return new Type[]{this.b};
            }
            return p.a;
        }

        @Override
        public Type[] getUpperBounds() {
            return new Type[]{this.a};
        }

        public int hashCode() {
            int n2 = this.b != null ? this.b.hashCode() + 31 : 1;
            return n2 ^ this.a.hashCode() + 31;
        }

        /*
         * Enabled aggressive block sorting
         */
        public String toString() {
            StringBuilder stringBuilder;
            Type type;
            if (this.b != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("? super ");
                type = this.b;
            } else {
                if (this.a == Object.class) {
                    return "?";
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("? extends ");
                type = this.a;
            }
            stringBuilder.append(p.b(type));
            return stringBuilder.toString();
        }
    }

}

