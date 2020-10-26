/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.b.a;

import com.b.a.a.a;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class u {
    public static GenericArrayType a(Type type) {
        return new a.a(type);
    }

    public static /* varargs */ ParameterizedType a(Type type, Type ... arrtype) {
        return new a.b(null, type, arrtype);
    }

    public static Type a(Type type, Class<?> type2) {
        type = type2 = u.a(type, type2, Collection.class);
        if (type2 instanceof WildcardType) {
            type = ((WildcardType)type2).getUpperBounds()[0];
        }
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType)type).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    static Type a(Type type, Class<?> class_, Class<?> class_2) {
        if (class_2.isAssignableFrom(class_)) {
            return a.a(type, class_, a.a(type, class_, class_2));
        }
        throw new IllegalArgumentException();
    }

    public static boolean a(@Nullable Type object, @Nullable Type arrobject) {
        if (object == arrobject) {
            return true;
        }
        if (object instanceof Class) {
            if (arrobject instanceof GenericArrayType) {
                return u.a(((Class)object).getComponentType(), ((GenericArrayType)arrobject).getGenericComponentType());
            }
            return object.equals(arrobject);
        }
        if (object instanceof ParameterizedType) {
            if (!(arrobject instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType)object;
            ParameterizedType parameterizedType2 = (ParameterizedType)arrobject;
            object = parameterizedType instanceof a.b ? ((a.b)parameterizedType).a : parameterizedType.getActualTypeArguments();
            arrobject = parameterizedType2 instanceof a.b ? ((a.b)parameterizedType2).a : parameterizedType2.getActualTypeArguments();
            return u.a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals((Object[])object, arrobject);
        }
        if (object instanceof GenericArrayType) {
            if (arrobject instanceof Class) {
                return u.a(((Class)arrobject).getComponentType(), ((GenericArrayType)object).getGenericComponentType());
            }
            if (!(arrobject instanceof GenericArrayType)) {
                return false;
            }
            object = (GenericArrayType)object;
            arrobject = (GenericArrayType)arrobject;
            return u.a(object.getGenericComponentType(), arrobject.getGenericComponentType());
        }
        if (object instanceof WildcardType) {
            if (!(arrobject instanceof WildcardType)) {
                return false;
            }
            object = (WildcardType)object;
            arrobject = (WildcardType)arrobject;
            return Arrays.equals(object.getUpperBounds(), arrobject.getUpperBounds()) && Arrays.equals(object.getLowerBounds(), arrobject.getLowerBounds());
        }
        if (object instanceof TypeVariable) {
            if (!(arrobject instanceof TypeVariable)) {
                return false;
            }
            object = (TypeVariable)object;
            arrobject = (TypeVariable)arrobject;
            return object.getGenericDeclaration() == arrobject.getGenericDeclaration() && object.getName().equals(arrobject.getName());
        }
        return false;
    }

    public static WildcardType b(Type type) {
        Type[] arrtype = a.b;
        return new a.c(new Type[]{type}, arrtype);
    }

    static Type[] b(Type type, Class<?> class_) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        if ((type = u.a(type, class_, Map.class)) instanceof ParameterizedType) {
            return ((ParameterizedType)type).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static WildcardType c(Type type) {
        return new a.c(new Type[]{Object.class}, new Type[]{type});
    }

    public static Class<?> d(Type type) {
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            return (Class)((ParameterizedType)type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(u.d(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return u.d(((WildcardType)type).getUpperBounds()[0]);
        }
        String string2 = type == null ? "null" : type.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static Type e(Type type) {
        Class<?> class_ = u.d(type);
        return a.a(type, class_, class_.getGenericSuperclass());
    }

    static Type f(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType)type).getGenericComponentType();
        }
        if (type instanceof Class) {
            return ((Class)type).getComponentType();
        }
        return null;
    }

    static boolean g(Type type) {
        return type == Boolean.class || type == Byte.class || type == Character.class || type == Double.class || type == Float.class || type == Integer.class || type == Long.class || type == Short.class || type == String.class || type == Object.class;
        {
        }
    }
}

