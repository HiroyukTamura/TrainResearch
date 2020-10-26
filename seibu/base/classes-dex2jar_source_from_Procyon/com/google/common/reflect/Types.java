// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.reflect;

import java.util.Iterator;
import java.util.Arrays;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import com.google.common.base.Objects;
import java.io.Serializable;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.GenericDeclaration;
import javax.annotation.Nullable;
import java.lang.reflect.WildcardType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.GenericArrayType;
import java.util.concurrent.atomic.AtomicReference;
import java.lang.reflect.Array;
import com.google.common.collect.Iterables;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.lang.reflect.Type;
import com.google.common.base.Function;
import com.google.common.base.Joiner;

final class Types
{
    private static final Joiner COMMA_JOINER;
    private static final Function<Type, String> TYPE_NAME;
    
    static {
        TYPE_NAME = new Function<Type, String>() {
            @Override
            public String apply(final Type type) {
                return JavaVersion.CURRENT.typeName(type);
            }
        };
        COMMA_JOINER = Joiner.on(", ").useForNull("null");
    }
    
    private Types() {
    }
    
    private static void disallowPrimitiveType(final Type[] array, final String s) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final Type type = array[i];
            if (type instanceof Class) {
                final Class clazz = (Class)type;
                Preconditions.checkArgument(!clazz.isPrimitive(), "Primitive type '%s' used as %s", clazz, s);
            }
        }
    }
    
    private static Iterable<Type> filterUpperBounds(final Iterable<Type> iterable) {
        return Iterables.filter(iterable, (Predicate<? super Type>)Predicates.not((Predicate<? super T>)Predicates.equalTo((T)Object.class)));
    }
    
    static Class<?> getArrayClass(final Class<?> componentType) {
        return Array.newInstance(componentType, 0).getClass();
    }
    
    @Nullable
    static Type getComponentType(final Type type) {
        Preconditions.checkNotNull(type);
        final AtomicReference<Type> atomicReference = new AtomicReference<Type>();
        new TypeVisitor() {
            @Override
            void visitClass(final Class<?> clazz) {
                atomicReference.set(clazz.getComponentType());
            }
            
            @Override
            void visitGenericArrayType(final GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }
            
            @Override
            void visitTypeVariable(final TypeVariable<?> typeVariable) {
                atomicReference.set(subtypeOfComponentType(typeVariable.getBounds()));
            }
            
            @Override
            void visitWildcardType(final WildcardType wildcardType) {
                atomicReference.set(subtypeOfComponentType(wildcardType.getUpperBounds()));
            }
        }.visit(type);
        return atomicReference.get();
    }
    
    static Type newArrayType(final Type type) {
        final boolean b = true;
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        final WildcardType wildcardType = (WildcardType)type;
        final Type[] lowerBounds = wildcardType.getLowerBounds();
        Preconditions.checkArgument(lowerBounds.length <= 1, (Object)"Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return supertypeOf(newArrayType(lowerBounds[0]));
        }
        final Type[] upperBounds = wildcardType.getUpperBounds();
        Preconditions.checkArgument(upperBounds.length == 1 && b, (Object)"Wildcard should have only one upper bound.");
        return subtypeOf(newArrayType(upperBounds[0]));
    }
    
    static <D extends GenericDeclaration> TypeVariable<D> newArtificialTypeVariable(final D n, final String s, final Type... array) {
        Type[] array2 = array;
        if (array.length == 0) {
            array2 = new Type[] { Object.class };
        }
        return new TypeVariableImpl<D>(n, s, array2);
    }
    
    static ParameterizedType newParameterizedType(final Class<?> clazz, final Type... array) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(clazz), clazz, array);
    }
    
    static ParameterizedType newParameterizedTypeWithOwner(@Nullable final Type type, final Class<?> clazz, final Type... array) {
        if (type == null) {
            return newParameterizedType(clazz, array);
        }
        Preconditions.checkNotNull(array);
        Preconditions.checkArgument(clazz.getEnclosingClass() != null, "Owner type for unenclosed %s", clazz);
        return new ParameterizedTypeImpl(type, clazz, array);
    }
    
    @VisibleForTesting
    static WildcardType subtypeOf(final Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[] { type });
    }
    
    @Nullable
    private static Type subtypeOfComponentType(final Type[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final Type componentType = getComponentType(array[i]);
            if (componentType != null) {
                if (componentType instanceof Class) {
                    final Class clazz = (Class)componentType;
                    if (clazz.isPrimitive()) {
                        return clazz;
                    }
                }
                return subtypeOf(componentType);
            }
        }
        return null;
    }
    
    @VisibleForTesting
    static WildcardType supertypeOf(final Type type) {
        return new WildcardTypeImpl(new Type[] { type }, new Type[] { Object.class });
    }
    
    private static Type[] toArray(final Collection<Type> collection) {
        return collection.toArray(new Type[collection.size()]);
    }
    
    static String toString(final Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }
    
    private enum ClassOwnership
    {
        static final ClassOwnership JVM_BEHAVIOR;
        
        LOCAL_CLASS_HAS_NO_OWNER {
            @Nullable
            @Override
            Class<?> getOwnerType(final Class<?> clazz) {
                if (clazz.isLocalClass()) {
                    return null;
                }
                return (Class<?>)clazz.getEnclosingClass();
            }
        }, 
        OWNED_BY_ENCLOSING_CLASS {
            @Nullable
            @Override
            Class<?> getOwnerType(final Class<?> clazz) {
                return (Class<?>)clazz.getEnclosingClass();
            }
        };
        
        static {
            JVM_BEHAVIOR = detectJvmBehavior();
        }
        
        private static ClassOwnership detectJvmBehavior() {
            final ParameterizedType parameterizedType = (ParameterizedType)new LocalClass<String>() {}.getClass().getGenericSuperclass();
            final ClassOwnership[] values = values();
            for (int length = values.length, i = 0; i < length; ++i) {
                final ClassOwnership classOwnership = values[i];
                if (classOwnership.getOwnerType(LocalClass.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }
        
        @Nullable
        abstract Class<?> getOwnerType(final Class<?> p0);
        
        class LocalClass<T>
        {
        }
    }
    
    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final Type componentType;
        
        GenericArrayTypeImpl(final Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof GenericArrayType && Objects.equal(this.getGenericComponentType(), ((GenericArrayType)o).getGenericComponentType());
        }
        
        @Override
        public Type getGenericComponentType() {
            return this.componentType;
        }
        
        @Override
        public int hashCode() {
            return this.componentType.hashCode();
        }
        
        @Override
        public String toString() {
            return String.valueOf(Types.toString(this.componentType)).concat("[]");
        }
    }
    
    enum JavaVersion
    {
        static final JavaVersion CURRENT;
        
        JAVA6 {
            @Override
            GenericArrayType newArrayType(final Type type) {
                return new GenericArrayTypeImpl(type);
            }
            
            @Override
            Type usedInGenericType(final Type type) {
                Preconditions.checkNotNull(type);
                Type type2 = type;
                if (type instanceof Class) {
                    final Class clazz = (Class)type;
                    type2 = type;
                    if (clazz.isArray()) {
                        type2 = new GenericArrayTypeImpl(clazz.getComponentType());
                    }
                }
                return type2;
            }
        }, 
        JAVA7 {
            @Override
            Type newArrayType(final Type type) {
                if (type instanceof Class) {
                    return Types.getArrayClass((Class<?>)type);
                }
                return new GenericArrayTypeImpl(type);
            }
            
            @Override
            Type usedInGenericType(final Type type) {
                return Preconditions.checkNotNull(type);
            }
        }, 
        JAVA8 {
            @Override
            Type newArrayType(final Type type) {
                return Types$JavaVersion$3.JAVA7.newArrayType(type);
            }
            
            @Override
            String typeName(final Type obj) {
                try {
                    return (String)Type.class.getMethod("getTypeName", (Class<?>[])new Class[0]).invoke(obj, new Object[0]);
                }
                catch (NoSuchMethodException ex) {
                    throw new AssertionError((Object)"Type.getTypeName should be available in Java 8");
                }
                catch (InvocationTargetException cause) {
                    throw new RuntimeException(cause);
                }
                catch (IllegalAccessException cause2) {
                    throw new RuntimeException(cause2);
                }
            }
            
            @Override
            Type usedInGenericType(final Type type) {
                return Types$JavaVersion$3.JAVA7.usedInGenericType(type);
            }
        };
        
        static {
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                CURRENT = JavaVersion.JAVA8;
                return;
            }
            if (new TypeCapture<int[]>() {}.capture() instanceof Class) {
                CURRENT = JavaVersion.JAVA7;
                return;
            }
            CURRENT = JavaVersion.JAVA6;
        }
        
        abstract Type newArrayType(final Type p0);
        
        String typeName(final Type type) {
            return Types.toString(type);
        }
        
        final ImmutableList<Type> usedInGenericType(final Type[] array) {
            final ImmutableList.Builder<Type> builder = ImmutableList.builder();
            for (int length = array.length, i = 0; i < length; ++i) {
                builder.add(this.usedInGenericType(array[i]));
            }
            return builder.build();
        }
        
        abstract Type usedInGenericType(final Type p0);
    }
    
    static final class NativeTypeVariableEquals<X>
    {
        static final boolean NATIVE_TYPE_VARIABLE_ONLY;
        
        static {
            boolean native_TYPE_VARIABLE_ONLY = false;
            if (!NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.newArtificialTypeVariable(NativeTypeVariableEquals.class, "X", new Type[0]))) {
                native_TYPE_VARIABLE_ONLY = true;
            }
            NATIVE_TYPE_VARIABLE_ONLY = native_TYPE_VARIABLE_ONLY;
        }
    }
    
    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;
        
        ParameterizedTypeImpl(@Nullable final Type ownerType, final Class<?> rawType, final Type[] array) {
            Preconditions.checkNotNull(rawType);
            Preconditions.checkArgument(array.length == rawType.getTypeParameters().length);
            disallowPrimitiveType(array, "type parameter");
            this.ownerType = ownerType;
            this.rawType = rawType;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(array);
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o instanceof ParameterizedType) {
                final ParameterizedType parameterizedType = (ParameterizedType)o;
                if (this.getRawType().equals(parameterizedType.getRawType()) && Objects.equal(this.getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(this.getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public Type[] getActualTypeArguments() {
            return toArray(this.argumentsList);
        }
        
        @Override
        public Type getOwnerType() {
            return this.ownerType;
        }
        
        @Override
        public Type getRawType() {
            return this.rawType;
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            if (this.ownerType == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.ownerType.hashCode();
            }
            return hashCode ^ this.argumentsList.hashCode() ^ this.rawType.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            if (this.ownerType != null) {
                sb.append(JavaVersion.CURRENT.typeName(this.ownerType)).append('.');
            }
            sb.append(this.rawType.getName()).append('<').append(Types.COMMA_JOINER.join(Iterables.transform((Iterable<Type>)this.argumentsList, (Function<? super Type, ?>)Types.TYPE_NAME))).append('>');
            return sb.toString();
        }
    }
    
    private static final class TypeVariableImpl<D extends GenericDeclaration> implements TypeVariable<D>
    {
        private final ImmutableList<Type> bounds;
        private final D genericDeclaration;
        private final String name;
        
        TypeVariableImpl(final D n, final String s, final Type[] array) {
            disallowPrimitiveType(array, "bound for type variable");
            this.genericDeclaration = Preconditions.checkNotNull(n);
            this.name = Preconditions.checkNotNull(s);
            this.bounds = ImmutableList.copyOf(array);
        }
        
        @Override
        public boolean equals(final Object o) {
            if (NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY) {
                if (!(o instanceof TypeVariableImpl)) {
                    return false;
                }
                final TypeVariableImpl typeVariableImpl = (TypeVariableImpl)o;
                if (!this.name.equals(typeVariableImpl.getName()) || !this.genericDeclaration.equals(typeVariableImpl.getGenericDeclaration()) || !this.bounds.equals(typeVariableImpl.bounds)) {
                    return false;
                }
            }
            else {
                if (!(o instanceof TypeVariable)) {
                    return false;
                }
                final TypeVariable typeVariable = (TypeVariable)o;
                if (!this.name.equals(typeVariable.getName()) || !this.genericDeclaration.equals(typeVariable.getGenericDeclaration())) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public Type[] getBounds() {
            return toArray(this.bounds);
        }
        
        @Override
        public D getGenericDeclaration() {
            return this.genericDeclaration;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        @Override
        public int hashCode() {
            return this.genericDeclaration.hashCode() ^ this.name.hashCode();
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
    
    static final class WildcardTypeImpl implements WildcardType, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;
        
        WildcardTypeImpl(final Type[] array, final Type[] array2) {
            disallowPrimitiveType(array, "lower bound for wildcard");
            disallowPrimitiveType(array2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(array);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(array2);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof WildcardType) {
                final WildcardType wildcardType = (WildcardType)o;
                b2 = b;
                if (this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds()))) {
                    b2 = b;
                    if (this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public Type[] getLowerBounds() {
            return toArray(this.lowerBounds);
        }
        
        @Override
        public Type[] getUpperBounds() {
            return toArray(this.upperBounds);
        }
        
        @Override
        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("?");
            final Iterator iterator = this.lowerBounds.iterator();
            while (iterator.hasNext()) {
                sb.append(" super ").append(JavaVersion.CURRENT.typeName(iterator.next()));
            }
            final Iterator<Type> iterator2 = filterUpperBounds(this.upperBounds).iterator();
            while (iterator2.hasNext()) {
                sb.append(" extends ").append(JavaVersion.CURRENT.typeName(iterator2.next()));
            }
            return sb.toString();
        }
    }
}
