// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.reflect;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import com.google.common.annotations.Beta;
import java.lang.reflect.GenericDeclaration;

@Beta
public abstract class Invokable<T, R> extends Element implements GenericDeclaration
{
     <M extends java.lang.reflect.AccessibleObject> Invokable(final M m) {
        super(m);
    }
    
    public static <T> Invokable<T, T> from(final Constructor<T> constructor) {
        return (Invokable<T, T>)new ConstructorInvokable((Constructor<?>)constructor);
    }
    
    public static Invokable<?, Object> from(final Method method) {
        return new MethodInvokable<Object>(method);
    }
    
    @Override
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>)super.getDeclaringClass();
    }
    
    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        final ImmutableList.Builder<TypeToken<? extends Throwable>> builder = ImmutableList.builder();
        final Type[] genericExceptionTypes = this.getGenericExceptionTypes();
        for (int length = genericExceptionTypes.length, i = 0; i < length; ++i) {
            builder.add((TypeToken<? extends Throwable>)TypeToken.of(genericExceptionTypes[i]));
        }
        return builder.build();
    }
    
    abstract Type[] getGenericExceptionTypes();
    
    abstract Type[] getGenericParameterTypes();
    
    abstract Type getGenericReturnType();
    
    @Override
    public TypeToken<T> getOwnerType() {
        return TypeToken.of(this.getDeclaringClass());
    }
    
    abstract Annotation[][] getParameterAnnotations();
    
    public final ImmutableList<Parameter> getParameters() {
        final Type[] genericParameterTypes = this.getGenericParameterTypes();
        final Annotation[][] parameterAnnotations = this.getParameterAnnotations();
        final ImmutableList.Builder<Parameter> builder = ImmutableList.builder();
        for (int i = 0; i < genericParameterTypes.length; ++i) {
            builder.add(new Parameter(this, i, TypeToken.of(genericParameterTypes[i]), parameterAnnotations[i]));
        }
        return builder.build();
    }
    
    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>)TypeToken.of(this.getGenericReturnType());
    }
    
    public final R invoke(@Nullable final T t, final Object... array) throws InvocationTargetException, IllegalAccessException {
        return (R)this.invokeInternal(t, Preconditions.checkNotNull(array));
    }
    
    abstract Object invokeInternal(@Nullable final Object p0, final Object[] p1) throws InvocationTargetException, IllegalAccessException;
    
    public abstract boolean isOverridable();
    
    public abstract boolean isVarArgs();
    
    public final <R1 extends R> Invokable<T, R1> returning(final TypeToken<R1> obj) {
        if (!obj.isAssignableFrom(this.getReturnType())) {
            final String value = String.valueOf(String.valueOf(this.getReturnType()));
            final String value2 = String.valueOf(String.valueOf(obj));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 35 + value2.length()).append("Invokable is known to return ").append(value).append(", not ").append(value2).toString());
        }
        return (Invokable<T, R1>)this;
    }
    
    public final <R1 extends R> Invokable<T, R1> returning(final Class<R1> clazz) {
        return this.returning((TypeToken<R1>)TypeToken.of((Class<R1>)clazz));
    }
    
    static class ConstructorInvokable<T> extends Invokable<T, T>
    {
        final Constructor<?> constructor;
        
        ConstructorInvokable(final Constructor<?> constructor) {
            super(constructor);
            this.constructor = constructor;
        }
        
        private boolean mayNeedHiddenThis() {
            final Class<?> declaringClass = this.constructor.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() == null) {
                final Method enclosingMethod = declaringClass.getEnclosingMethod();
                if (enclosingMethod != null) {
                    if (Modifier.isStatic(enclosingMethod.getModifiers())) {
                        return false;
                    }
                }
                else if (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }
        
        @Override
        Type[] getGenericParameterTypes() {
            final Type[] genericParameterTypes = this.constructor.getGenericParameterTypes();
            if (genericParameterTypes.length > 0 && this.mayNeedHiddenThis()) {
                final Class<?>[] parameterTypes = this.constructor.getParameterTypes();
                if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == this.getDeclaringClass().getEnclosingClass()) {
                    return Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                }
            }
            return genericParameterTypes;
        }
        
        @Override
        Type getGenericReturnType() {
            final Class<? super T> declaringClass = this.getDeclaringClass();
            final TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            Object parameterizedType = declaringClass;
            if (typeParameters.length > 0) {
                parameterizedType = Types.newParameterizedType(declaringClass, (Type[])typeParameters);
            }
            return (Type)parameterizedType;
        }
        
        @Override
        final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }
        
        @Override
        public final TypeVariable<?>[] getTypeParameters() {
            final TypeVariable<Class<? super T>>[] typeParameters = this.getDeclaringClass().getTypeParameters();
            final TypeVariable<Constructor<?>>[] typeParameters2 = this.constructor.getTypeParameters();
            final TypeVariable[] array = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, array, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, array, typeParameters.length, typeParameters2.length);
            return (TypeVariable<?>[])array;
        }
        
        @Override
        final Object invokeInternal(@Nullable Object instance, final Object[] initargs) throws InvocationTargetException, IllegalAccessException {
            try {
                instance = this.constructor.newInstance(initargs);
                return instance;
            }
            catch (InstantiationException cause) {
                final String value = String.valueOf(String.valueOf(this.constructor));
                throw new RuntimeException(new StringBuilder(value.length() + 8).append(value).append(" failed.").toString(), cause);
            }
        }
        
        @Override
        public final boolean isOverridable() {
            return false;
        }
        
        @Override
        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }
    }
    
    static class MethodInvokable<T> extends Invokable<T, Object>
    {
        final Method method;
        
        MethodInvokable(final Method method) {
            super(method);
            this.method = method;
        }
        
        @Override
        Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }
        
        @Override
        Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }
        
        @Override
        Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }
        
        @Override
        final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }
        
        @Override
        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }
        
        @Override
        final Object invokeInternal(@Nullable final Object obj, final Object[] args) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(obj, args);
        }
        
        @Override
        public final boolean isOverridable() {
            return !this.isFinal() && !this.isPrivate() && !this.isStatic() && !Modifier.isFinal(this.getDeclaringClass().getModifiers());
        }
        
        @Override
        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }
}
