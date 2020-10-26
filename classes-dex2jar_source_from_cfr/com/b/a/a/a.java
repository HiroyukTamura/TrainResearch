/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.b.a.a;

import com.b.a.f;
import com.b.a.g;
import com.b.a.j;
import com.b.a.s;
import com.b.a.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

public final class a {
    public static final Set<Annotation> a = Collections.emptySet();
    public static final Type[] b = new Type[0];

    static int a(@Nullable Object object) {
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    static int a(Object[] arrobject, Object object) {
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            if (!object.equals(arrobject[i2])) continue;
            return i2;
        }
        throw new NoSuchElementException();
    }

    @Nullable
    public static f<?> a(s object, Type constructor, Class<?> class_) {
        Object object2 = class_.getAnnotation(g.class);
        if (object2 != null && object2.a()) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(class_.getName().replace("$", "_"));
            ((StringBuilder)object2).append("JsonAdapter");
            object2 = ((StringBuilder)object2).toString();
            try {
                object2 = Class.forName((String)object2, true, class_.getClassLoader());
                if (constructor instanceof ParameterizedType) {
                    object2 = ((Class)object2).getDeclaredConstructor(s.class, Type[].class);
                    ((AccessibleObject)object2).setAccessible(true);
                    return ((f)((Constructor)object2).newInstance(object, ((ParameterizedType)((Object)constructor)).getActualTypeArguments())).d();
                }
                constructor = ((Class)object2).getDeclaredConstructor(s.class);
                constructor.setAccessible(true);
                object = ((f)constructor.newInstance(object)).d();
                return object;
            }
            catch (InvocationTargetException invocationTargetException) {
                throw a.a(invocationTargetException);
            }
            catch (InstantiationException instantiationException) {
                constructor = new StringBuilder();
                ((StringBuilder)((Object)constructor)).append("Failed to instantiate the generated JsonAdapter for ");
                ((StringBuilder)((Object)constructor)).append(class_);
                throw new RuntimeException(((StringBuilder)((Object)constructor)).toString(), instantiationException);
            }
            catch (IllegalAccessException illegalAccessException) {
                constructor = new StringBuilder();
                ((StringBuilder)((Object)constructor)).append("Failed to access the generated JsonAdapter for ");
                ((StringBuilder)((Object)constructor)).append(class_);
                throw new RuntimeException(((StringBuilder)((Object)constructor)).toString(), illegalAccessException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                constructor = new StringBuilder();
                ((StringBuilder)((Object)constructor)).append("Failed to find the generated JsonAdapter constructor for ");
                ((StringBuilder)((Object)constructor)).append(class_);
                throw new RuntimeException(((StringBuilder)((Object)constructor)).toString(), noSuchMethodException);
            }
            catch (ClassNotFoundException classNotFoundException) {
                constructor = new StringBuilder();
                ((StringBuilder)((Object)constructor)).append("Failed to find the generated JsonAdapter class for ");
                ((StringBuilder)((Object)constructor)).append(class_);
                throw new RuntimeException(((StringBuilder)((Object)constructor)).toString(), classNotFoundException);
            }
        }
        return null;
    }

    @Nullable
    static Class<?> a(TypeVariable<?> typeVariable) {
        if ((typeVariable = typeVariable.getGenericDeclaration()) instanceof Class) {
            return (Class)((Object)typeVariable);
        }
        return null;
    }

    public static RuntimeException a(InvocationTargetException throwable) {
        if (!((throwable = throwable.getTargetException()) instanceof RuntimeException)) {
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
            throw new RuntimeException(throwable);
        }
        throw (RuntimeException)throwable;
    }

    public static String a(Type object, Set<? extends Annotation> set) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object);
        if (set.isEmpty()) {
            object = " (with no annotations)";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append(" annotated ");
            ((StringBuilder)object).append(set);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            Class class_ = (Class)type;
            type = class_;
            if (class_.isArray()) {
                type = new a(a.a(class_.getComponentType()));
            }
            return type;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof b) {
                return type;
            }
            type = (ParameterizedType)type;
            return new b(type.getOwnerType(), type.getRawType(), type.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type instanceof a) {
                return type;
            }
            return new a(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (type instanceof c) {
                return type;
            }
            type = (WildcardType)type;
            return new c(type.getUpperBounds(), type.getLowerBounds());
        }
        return type;
    }

    public static Type a(Type object, Class<?> object2, Class<?> class_) {
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
                return a.a(((Class)object2).getGenericInterfaces()[i2], object[i2], class_);
            }
        }
        if (!((Class)object2).isInterface()) {
            while (object2 != Object.class) {
                object = ((Class)object2).getSuperclass();
                if (object == class_) {
                    return ((Class)object2).getGenericSuperclass();
                }
                if (class_.isAssignableFrom((Class<?>)object)) {
                    return a.a(((Class)object2).getGenericSuperclass(), object, class_);
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
    public static Type a(Type type, Class<?> class_, Type type2) {
        Type type3;
        while (type2 instanceof TypeVariable) {
            type3 = (TypeVariable)type2;
            type2 = a.a(type, class_, type3);
            if (type2 != type3) continue;
            return type2;
        }
        if (type2 instanceof Class && ((Class)(type3 = (Class)type2)).isArray()) {
            type2 = ((Class)type3).getComponentType();
            if (type2 != (type = a.a(type, class_, type2))) return u.a(type);
            return type3;
        }
        if (type2 instanceof GenericArrayType) {
            type3 = (type2 = (GenericArrayType)type2).getGenericComponentType();
            if (type3 != (type = a.a(type, class_, type3))) return u.a(type);
            return type2;
        }
        boolean bl2 = type2 instanceof ParameterizedType;
        if (bl2) {
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            type2 = parameterizedType.getOwnerType();
            Type type4 = a.a(type, class_, type2);
            boolean bl3 = type4 != type2;
            type2 = parameterizedType.getActualTypeArguments();
            int n2 = ((Type)type2).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Type type5 = a.a(type, class_, type2[i2]);
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
        Type[] arrtype = type2.getLowerBounds();
        Type[] arrtype2 = type2.getUpperBounds();
        if (arrtype.length == 1) {
            type = a.a(type, class_, arrtype[0]);
            type3 = type2;
            if (type == arrtype[0]) return type3;
            return u.c(type);
        }
        type3 = type2;
        if (arrtype2.length != 1) return type3;
        type3 = arrtype2[0];
        type = a.a(type, class_, type3);
        type3 = type2;
        if (type == arrtype2[0]) return type3;
        return u.b(type);
    }

    static Type a(Type type, Class<?> class_, TypeVariable<?> typeVariable) {
        Class<?> class_2 = a.a(typeVariable);
        if (class_2 == null) {
            return typeVariable;
        }
        if ((type = a.a(type, class_, class_2)) instanceof ParameterizedType) {
            int n2 = a.a(class_2.getTypeParameters(), typeVariable);
            return ((ParameterizedType)type).getActualTypeArguments()[n2];
        }
        return typeVariable;
    }

    public static Set<? extends Annotation> a(AnnotatedElement annotatedElement) {
        return a.a(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> a(Annotation[] arrannotation) {
        int n2 = arrannotation.length;
        LinkedHashSet<Annotation> linkedHashSet = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            Annotation annotation = arrannotation[i2];
            LinkedHashSet<Annotation> linkedHashSet2 = linkedHashSet;
            if (annotation.annotationType().isAnnotationPresent(j.class)) {
                linkedHashSet2 = linkedHashSet;
                if (linkedHashSet == null) {
                    linkedHashSet2 = new LinkedHashSet<Annotation>();
                }
                linkedHashSet2.add(annotation);
            }
            linkedHashSet = linkedHashSet2;
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return a;
    }

    public static boolean a(Class<?> object) {
        return ((String)(object = ((Class)object).getName())).startsWith("android.") || ((String)object).startsWith("androidx.") || ((String)object).startsWith("java.") || ((String)object).startsWith("javax.") || ((String)object).startsWith("kotlin.") || ((String)object).startsWith("scala.");
        {
        }
    }

    static String b(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }

    static void c(Type type) {
        if (type instanceof Class) {
            if (!((Class)type).isPrimitive()) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected primitive ");
            stringBuilder.append(type);
            stringBuilder.append(". Use the boxed type.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static final class a
    implements GenericArrayType {
        private final Type a;

        public a(Type type) {
            this.a = a.a(type);
        }

        public boolean equals(Object object) {
            return object instanceof GenericArrayType && u.a((Type)this, (Type)((GenericArrayType)object));
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
            stringBuilder.append(a.b(this.a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    public static final class b
    implements ParameterizedType {
        public final Type[] a;
        @Nullable
        private final Type b;
        private final Type c;

        public /* varargs */ b(@Nullable Type object, Type type, Type ... object2) {
            if (type instanceof Class) {
                Class<?> class_ = ((Class)type).getEnclosingClass();
                if (object != null) {
                    if (class_ == null || u.d((Type)object) != class_) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("unexpected owner type for ");
                        ((StringBuilder)object2).append(type);
                        ((StringBuilder)object2).append(": ");
                        ((StringBuilder)object2).append(object);
                        throw new IllegalArgumentException(((StringBuilder)object2).toString());
                    }
                } else if (class_ != null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("unexpected owner type for ");
                    ((StringBuilder)object).append(type);
                    ((StringBuilder)object).append(": null");
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
            }
            object = object == null ? null : a.a((Type)object);
            this.b = object;
            this.c = a.a(type);
            this.a = (Type[])object2.clone();
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                if (this.a[i2] != null) {
                    a.c(this.a[i2]);
                    this.a[i2] = a.a(this.a[i2]);
                    continue;
                }
                throw new NullPointerException();
            }
        }

        public boolean equals(Object object) {
            return object instanceof ParameterizedType && u.a((Type)this, (Type)((ParameterizedType)object));
        }

        @Override
        public Type[] getActualTypeArguments() {
            return (Type[])this.a.clone();
        }

        @Nullable
        @Override
        public Type getOwnerType() {
            return this.b;
        }

        @Override
        public Type getRawType() {
            return this.c;
        }

        public int hashCode() {
            return Arrays.hashCode(this.a) ^ this.c.hashCode() ^ a.a((Object)this.b);
        }

        public String toString() {
            int n2 = this.a.length;
            StringBuilder stringBuilder = new StringBuilder((n2 + 1) * 30);
            stringBuilder.append(a.b(this.c));
            if (this.a.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<");
            stringBuilder.append(a.b(this.a[0]));
            for (int i2 = 1; i2 < this.a.length; ++i2) {
                stringBuilder.append(", ");
                stringBuilder.append(a.b(this.a[i2]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    public static final class c
    implements WildcardType {
        private final Type a;
        @Nullable
        private final Type b;

        public c(Type[] object, Type[] arrtype) {
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
                                        a.c(arrtype[0]);
                                        if (object[0] != Object.class) break block6;
                                        this.b = a.a(arrtype[0]);
                                        object = Object.class;
                                        break block7;
                                    }
                                    throw new IllegalArgumentException();
                                }
                                throw new NullPointerException();
                            }
                            if (object[0] == null) break block8;
                            a.c(object[0]);
                            this.b = null;
                            object = a.a(object[0]);
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
            return object instanceof WildcardType && u.a((Type)this, (Type)((WildcardType)object));
        }

        @Override
        public Type[] getLowerBounds() {
            if (this.b != null) {
                return new Type[]{this.b};
            }
            return a.b;
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
            stringBuilder.append(a.b(type));
            return stringBuilder.toString();
        }
    }

}

