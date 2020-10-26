// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.util;

import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.LinkedHashSet;
import java.util.Collections;
import java.util.Set;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

public abstract class ClassUtils
{
    public static final String ARRAY_SUFFIX = "[]";
    public static final String CGLIB_CLASS_SEPARATOR = "$$";
    public static final String CLASS_FILE_SUFFIX = ".class";
    private static final char INNER_CLASS_SEPARATOR = '$';
    private static final String INTERNAL_ARRAY_PREFIX = "[";
    private static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";
    private static final char PACKAGE_SEPARATOR = '.';
    private static final Map<String, Class<?>> commonClassCache;
    private static final Map<String, Class<?>> primitiveTypeNameMap;
    private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap;
    private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap;
    
    static {
        primitiveWrapperTypeMap = new HashMap<Class<?>, Class<?>>(8);
        primitiveTypeToWrapperMap = new HashMap<Class<?>, Class<?>>(8);
        primitiveTypeNameMap = new HashMap<String, Class<?>>(32);
        commonClassCache = new HashMap<String, Class<?>>(32);
        ClassUtils.primitiveWrapperTypeMap.put(Boolean.class, Boolean.TYPE);
        ClassUtils.primitiveWrapperTypeMap.put(Byte.class, Byte.TYPE);
        ClassUtils.primitiveWrapperTypeMap.put(Character.class, Character.TYPE);
        ClassUtils.primitiveWrapperTypeMap.put(Double.class, Double.TYPE);
        ClassUtils.primitiveWrapperTypeMap.put(Float.class, Float.TYPE);
        ClassUtils.primitiveWrapperTypeMap.put(Integer.class, Integer.TYPE);
        ClassUtils.primitiveWrapperTypeMap.put(Long.class, Long.TYPE);
        ClassUtils.primitiveWrapperTypeMap.put(Short.class, Short.TYPE);
        for (final Map.Entry<Class<?>, Class<?>> entry : ClassUtils.primitiveWrapperTypeMap.entrySet()) {
            ClassUtils.primitiveTypeToWrapperMap.put(entry.getValue(), entry.getKey());
            registerCommonClasses(entry.getKey());
        }
        final HashSet<Class<Void>> set = new HashSet<Class<Void>>(32);
        set.addAll((Collection<?>)ClassUtils.primitiveWrapperTypeMap.values());
        set.addAll((Collection<?>)Arrays.asList(boolean[].class, byte[].class, char[].class, double[].class, float[].class, int[].class, long[].class, short[].class));
        set.add(Void.TYPE);
        for (final Class<Void> clazz : set) {
            ClassUtils.primitiveTypeNameMap.put(clazz.getName(), clazz);
        }
        registerCommonClasses(Boolean[].class, Byte[].class, Character[].class, Double[].class, Float[].class, Integer[].class, Long[].class, Short[].class);
        registerCommonClasses(Number.class, Number[].class, String.class, String[].class, Object.class, Object[].class, Class.class, Class[].class);
        registerCommonClasses(Throwable.class, Exception.class, RuntimeException.class, Error.class, StackTraceElement.class, StackTraceElement[].class);
    }
    
    public static String addResourcePathToPackagePath(final Class<?> clazz, final String s) {
        Assert.notNull((Object)s, "Resource name must not be null");
        if (!s.startsWith("/")) {
            return classPackageAsResourcePath(clazz) + "/" + s;
        }
        return classPackageAsResourcePath(clazz) + s;
    }
    
    public static String classNamesToString(final Collection<Class> collection) {
        if (CollectionUtils.isEmpty((Collection)collection)) {
            return "[]";
        }
        final StringBuilder sb = new StringBuilder("[");
        final Iterator<Class> iterator = collection.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().getName());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static String classNamesToString(final Class... a) {
        return classNamesToString((Collection<Class>)Arrays.asList((Class[])a));
    }
    
    public static String classPackageAsResourcePath(final Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        final String name = clazz.getName();
        final int lastIndex = name.lastIndexOf(46);
        if (lastIndex == -1) {
            return "";
        }
        return name.substring(0, lastIndex).replace('.', '/');
    }
    
    public static String convertClassNameToResourcePath(final String s) {
        Assert.notNull((Object)s, "Class name must not be null");
        return s.replace('.', '/');
    }
    
    public static String convertResourcePathToClassName(final String s) {
        Assert.notNull((Object)s, "Resource path must not be null");
        return s.replace('/', '.');
    }
    
    public static Class<?> createCompositeInterface(final Class<?>[] interfaces, final ClassLoader loader) {
        Assert.notEmpty((Object[])interfaces, "Interfaces must not be empty");
        Assert.notNull((Object)loader, "ClassLoader must not be null");
        return Proxy.getProxyClass(loader, interfaces);
    }
    
    @Deprecated
    public static Class<?> forName(final String s) throws ClassNotFoundException, LinkageError {
        return forName(s, getDefaultClassLoader());
    }
    
    public static Class<?> forName(String string, ClassLoader defaultClassLoader) throws ClassNotFoundException, LinkageError {
        Assert.notNull((Object)string, "Name must not be null");
        Class<?> resolvePrimitiveClassName;
        if ((resolvePrimitiveClassName = resolvePrimitiveClassName(string)) == null) {
            resolvePrimitiveClassName = ClassUtils.commonClassCache.get(string);
        }
        if (resolvePrimitiveClassName != null) {
            return resolvePrimitiveClassName;
        }
        if (string.endsWith("[]")) {
            return Array.newInstance(forName(string.substring(0, string.length() - "[]".length()), defaultClassLoader), 0).getClass();
        }
        if (string.startsWith("[L") && string.endsWith(";")) {
            return Array.newInstance(forName(string.substring("[L".length(), string.length() - 1), defaultClassLoader), 0).getClass();
        }
        if (string.startsWith("[")) {
            return Array.newInstance(forName(string.substring("[".length()), defaultClassLoader), 0).getClass();
        }
        if ((defaultClassLoader = defaultClassLoader) == null) {
            defaultClassLoader = getDefaultClassLoader();
        }
        try {
            return defaultClassLoader.loadClass(string);
        }
        catch (ClassNotFoundException ex) {
            final int lastIndex = string.lastIndexOf(46);
            if (lastIndex != -1) {
                string = string.substring(0, lastIndex) + '$' + string.substring(lastIndex + 1);
                try {
                    return defaultClassLoader.loadClass(string);
                }
                catch (ClassNotFoundException ex2) {}
            }
            throw ex;
        }
    }
    
    public static Class[] getAllInterfaces(final Object o) {
        Assert.notNull(o, "Instance must not be null");
        return getAllInterfacesForClass(o.getClass());
    }
    
    public static Set<Class> getAllInterfacesAsSet(final Object o) {
        Assert.notNull(o, "Instance must not be null");
        return getAllInterfacesForClassAsSet(o.getClass());
    }
    
    public static Class<?>[] getAllInterfacesForClass(final Class<?> clazz) {
        return getAllInterfacesForClass(clazz, null);
    }
    
    public static Class<?>[] getAllInterfacesForClass(final Class<?> clazz, final ClassLoader classLoader) {
        final Set<Class> allInterfacesForClassAsSet = getAllInterfacesForClassAsSet(clazz, classLoader);
        return allInterfacesForClassAsSet.toArray(new Class[allInterfacesForClassAsSet.size()]);
    }
    
    public static Set<Class> getAllInterfacesForClassAsSet(final Class clazz) {
        return getAllInterfacesForClassAsSet(clazz, null);
    }
    
    public static Set<Class> getAllInterfacesForClassAsSet(Class superclass, final ClassLoader classLoader) {
        Assert.notNull((Object)superclass, "Class must not be null");
        Object singleton;
        if (superclass.isInterface() && isVisible(superclass, classLoader)) {
            singleton = Collections.singleton(superclass);
        }
        else {
            final LinkedHashSet<Object> set = new LinkedHashSet<Object>();
            while (true) {
                singleton = set;
                if (superclass == null) {
                    break;
                }
                final Class<?>[] interfaces = superclass.getInterfaces();
                for (int length = interfaces.length, i = 0; i < length; ++i) {
                    set.addAll(getAllInterfacesForClassAsSet(interfaces[i], classLoader));
                }
                superclass = superclass.getSuperclass();
            }
        }
        return (Set<Class>)singleton;
    }
    
    public static String getClassFileName(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        final String name = clazz.getName();
        return name.substring(name.lastIndexOf(46) + 1) + ".class";
    }
    
    public static <T> Constructor<T> getConstructorIfAvailable(final Class<T> clazz, final Class<?>... parameterTypes) {
        Assert.notNull((Object)clazz, "Class must not be null");
        try {
            return clazz.getConstructor(parameterTypes);
        }
        catch (NoSuchMethodException ex) {
            return null;
        }
    }
    
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader contextClassLoader = null;
        while (true) {
            try {
                contextClassLoader = Thread.currentThread().getContextClassLoader();
                ClassLoader classLoader = contextClassLoader;
                if (contextClassLoader == null) {
                    classLoader = ClassUtils.class.getClassLoader();
                }
                return classLoader;
            }
            catch (Throwable t) {
                continue;
            }
            break;
        }
    }
    
    public static String getDescriptiveType(final Object o) {
        if (o == null) {
            return null;
        }
        final Class<?> class1 = o.getClass();
        if (Proxy.isProxyClass(class1)) {
            final StringBuilder sb = new StringBuilder(class1.getName());
            sb.append(" implementing ");
            final Class<?>[] interfaces = class1.getInterfaces();
            for (int i = 0; i < interfaces.length; ++i) {
                sb.append(interfaces[i].getName());
                if (i < interfaces.length - 1) {
                    sb.append(',');
                }
            }
            return sb.toString();
        }
        if (class1.isArray()) {
            return getQualifiedNameForArray(class1);
        }
        return class1.getName();
    }
    
    public static Method getMethod(final Class<?> clazz, final String name, final Class<?>... parameterTypes) {
        Assert.notNull((Object)clazz, "Class must not be null");
        Assert.notNull((Object)name, "Method name must not be null");
        try {
            return clazz.getMethod(name, parameterTypes);
        }
        catch (NoSuchMethodException obj) {
            throw new IllegalStateException("Expected method not found: " + obj);
        }
    }
    
    public static int getMethodCountForName(final Class<?> clazz, final String s) {
        Assert.notNull((Object)clazz, "Class must not be null");
        Assert.notNull((Object)s, "Method name must not be null");
        int n = 0;
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        int n2;
        for (int length = declaredMethods.length, i = 0; i < length; ++i, n = n2) {
            n2 = n;
            if (s.equals(declaredMethods[i].getName())) {
                n2 = n + 1;
            }
        }
        final Class<?>[] interfaces = clazz.getInterfaces();
        for (int length2 = interfaces.length, j = 0; j < length2; ++j) {
            n += getMethodCountForName(interfaces[j], s);
        }
        int n3 = n;
        if (clazz.getSuperclass() != null) {
            n3 = n + getMethodCountForName(clazz.getSuperclass(), s);
        }
        return n3;
    }
    
    public static Method getMethodIfAvailable(final Class<?> clazz, final String name, final Class<?>... parameterTypes) {
        Assert.notNull((Object)clazz, "Class must not be null");
        Assert.notNull((Object)name, "Method name must not be null");
        try {
            return clazz.getMethod(name, parameterTypes);
        }
        catch (NoSuchMethodException ex) {
            return null;
        }
    }
    
    public static String getPackageName(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        final String name = clazz.getName();
        final int lastIndex = name.lastIndexOf(46);
        if (lastIndex != -1) {
            return name.substring(0, lastIndex);
        }
        return "";
    }
    
    public static String getQualifiedMethodName(final Method method) {
        Assert.notNull((Object)method, "Method must not be null");
        return method.getDeclaringClass().getName() + "." + method.getName();
    }
    
    public static String getQualifiedName(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        if (clazz.isArray()) {
            return getQualifiedNameForArray(clazz);
        }
        return clazz.getName();
    }
    
    private static String getQualifiedNameForArray(Class<?> componentType) {
        final StringBuilder sb = new StringBuilder();
        while (componentType.isArray()) {
            componentType = componentType.getComponentType();
            sb.append("[]");
        }
        sb.insert(0, componentType.getName());
        return sb.toString();
    }
    
    public static String getShortName(final Class<?> clazz) {
        return getShortName(getQualifiedName(clazz));
    }
    
    public static String getShortName(final String s) {
        Assert.hasLength(s, "Class name must not be empty");
        final int lastIndex = s.lastIndexOf(46);
        int endIndex;
        if ((endIndex = s.indexOf("$$")) == -1) {
            endIndex = s.length();
        }
        return s.substring(lastIndex + 1, endIndex).replace('$', '.');
    }
    
    public static Method getStaticMethod(final Class<?> clazz, final String name, final Class<?>... parameterTypes) {
        Assert.notNull((Object)clazz, "Class must not be null");
        Assert.notNull((Object)name, "Method name must not be null");
        try {
            final Method method = clazz.getMethod(name, (Class[])parameterTypes);
            if (Modifier.isStatic(method.getModifiers())) {
                return method;
            }
            return null;
        }
        catch (NoSuchMethodException ex) {
            return null;
        }
    }
    
    public static Class<?> getUserClass(final Class<?> clazz) {
        if (clazz != null && clazz.getName().contains("$$")) {
            final Class<?> superclass = clazz.getSuperclass();
            if (superclass != null && !Object.class.equals(superclass)) {
                return superclass;
            }
        }
        return clazz;
    }
    
    public static Class<?> getUserClass(final Object o) {
        Assert.notNull(o, "Instance must not be null");
        return getUserClass(o.getClass());
    }
    
    public static boolean hasAtLeastOneMethodWithName(final Class<?> clazz, final String anObject) {
        Assert.notNull((Object)clazz, "Class must not be null");
        Assert.notNull((Object)anObject, "Method name must not be null");
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int length = declaredMethods.length, i = 0; i < length; ++i) {
            if (declaredMethods[i].getName().equals(anObject)) {
                return true;
            }
        }
        final Class<?>[] interfaces = clazz.getInterfaces();
        for (int length2 = interfaces.length, j = 0; j < length2; ++j) {
            if (hasAtLeastOneMethodWithName(interfaces[j], anObject)) {
                return true;
            }
        }
        if (clazz.getSuperclass() == null || !hasAtLeastOneMethodWithName(clazz.getSuperclass(), anObject)) {
            return false;
        }
        return true;
    }
    
    public static boolean hasConstructor(final Class<?> clazz, final Class<?>... array) {
        return getConstructorIfAvailable(clazz, array) != null;
    }
    
    public static boolean hasMethod(final Class<?> clazz, final String s, final Class<?>... array) {
        return getMethodIfAvailable(clazz, s, array) != null;
    }
    
    public static boolean isAssignable(final Class<?> clazz, final Class<?> clazz2) {
        Assert.notNull((Object)clazz, "Left-hand side type must not be null");
        Assert.notNull((Object)clazz2, "Right-hand side type must not be null");
        if (!clazz.isAssignableFrom(clazz2)) {
            if (clazz.isPrimitive()) {
                final Class<?> obj = ClassUtils.primitiveWrapperTypeMap.get(clazz2);
                if (obj != null && clazz.equals(obj)) {
                    return true;
                }
            }
            else {
                final Class<?> clazz3 = ClassUtils.primitiveTypeToWrapperMap.get(clazz2);
                if (clazz3 != null && clazz.isAssignableFrom(clazz3)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public static boolean isAssignableValue(final Class<?> clazz, final Object o) {
        Assert.notNull((Object)clazz, "Type must not be null");
        if (o != null) {
            return isAssignable(clazz, o.getClass());
        }
        return !clazz.isPrimitive();
    }
    
    public static boolean isCacheSafe(final Class<?> clazz, ClassLoader parent) {
        Assert.notNull((Object)clazz, "Class must not be null");
        final ClassLoader classLoader = clazz.getClassLoader();
        if (classLoader != null) {
            ClassLoader classLoader2;
            if ((classLoader2 = parent) == classLoader) {
                return true;
            }
            while (classLoader2 != null) {
                parent = classLoader2.getParent();
                if ((classLoader2 = parent) == classLoader) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Deprecated
    public static boolean isPresent(final String s) {
        return isPresent(s, getDefaultClassLoader());
    }
    
    public static boolean isPresent(final String s, final ClassLoader classLoader) {
        try {
            forName(s, classLoader);
            return true;
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    public static boolean isPrimitiveArray(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        return clazz.isArray() && clazz.getComponentType().isPrimitive();
    }
    
    public static boolean isPrimitiveOrWrapper(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        return clazz.isPrimitive() || isPrimitiveWrapper(clazz);
    }
    
    public static boolean isPrimitiveWrapper(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        return ClassUtils.primitiveWrapperTypeMap.containsKey(clazz);
    }
    
    public static boolean isPrimitiveWrapperArray(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        return clazz.isArray() && isPrimitiveWrapper(clazz.getComponentType());
    }
    
    public static boolean isVisible(final Class<?> clazz, final ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                if (clazz != classLoader.loadClass(clazz.getName())) {
                    return false;
                }
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean matchesTypeName(final Class<?> clazz, final String s) {
        return s != null && (s.equals(clazz.getName()) || s.equals(clazz.getSimpleName()) || (clazz.isArray() && s.equals(getQualifiedNameForArray(clazz))));
    }
    
    public static ClassLoader overrideThreadContextClassLoader(final ClassLoader contextClassLoader) {
        final Thread currentThread = Thread.currentThread();
        final ClassLoader contextClassLoader2 = currentThread.getContextClassLoader();
        if (contextClassLoader != null && !contextClassLoader.equals(contextClassLoader2)) {
            currentThread.setContextClassLoader(contextClassLoader);
            return contextClassLoader2;
        }
        return null;
    }
    
    private static void registerCommonClasses(final Class<?>... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final Class<?> clazz = array[i];
            ClassUtils.commonClassCache.put(clazz.getName(), clazz);
        }
    }
    
    public static Class<?> resolveClassName(final String s, final ClassLoader classLoader) throws IllegalArgumentException {
        try {
            return forName(s, classLoader);
        }
        catch (ClassNotFoundException cause) {
            throw new IllegalArgumentException("Cannot find class [" + s + "]", cause);
        }
        catch (LinkageError cause2) {
            throw new IllegalArgumentException("Error loading class [" + s + "]: problem with class file or dependent class.", cause2);
        }
    }
    
    public static Class<?> resolvePrimitiveClassName(final String s) {
        Class<?> clazz = null;
        if (s != null) {
            clazz = clazz;
            if (s.length() <= 8) {
                clazz = ClassUtils.primitiveTypeNameMap.get(s);
            }
        }
        return clazz;
    }
    
    public static Class<?> resolvePrimitiveIfNecessary(final Class<?> clazz) {
        Assert.notNull((Object)clazz, "Class must not be null");
        if (clazz.isPrimitive() && clazz != Void.TYPE) {
            return ClassUtils.primitiveTypeToWrapperMap.get(clazz);
        }
        return clazz;
    }
}
