// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.reflect;

import java.util.jar.Attributes;
import javax.annotation.Nullable;
import java.util.jar.Manifest;
import java.io.File;
import com.google.common.collect.Sets;
import java.util.Comparator;
import com.google.common.collect.Ordering;
import java.util.Set;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import java.net.URL;
import java.util.LinkedHashMap;
import java.net.URISyntaxException;
import java.net.URLClassLoader;
import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableMap;
import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.util.Iterator;
import java.net.URI;
import java.util.Map;
import com.google.common.collect.ImmutableSet;
import java.util.logging.Logger;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.annotations.Beta;

@Beta
public final class ClassPath
{
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR;
    private static final Predicate<ClassInfo> IS_TOP_LEVEL;
    private static final Logger logger;
    private final ImmutableSet<ResourceInfo> resources;
    
    static {
        logger = Logger.getLogger(ClassPath.class.getName());
        IS_TOP_LEVEL = new Predicate<ClassInfo>() {
            @Override
            public boolean apply(final ClassInfo classInfo) {
                return classInfo.className.indexOf(36) == -1;
            }
        };
        CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    }
    
    private ClassPath(final ImmutableSet<ResourceInfo> resources) {
        this.resources = resources;
    }
    
    public static ClassPath from(final ClassLoader classLoader) throws IOException {
        final Scanner scanner = new Scanner();
        for (final Map.Entry<URI, V> entry : getClassPathEntries(classLoader).entrySet()) {
            scanner.scan(entry.getKey(), (ClassLoader)entry.getValue());
        }
        return new ClassPath(scanner.getResources());
    }
    
    @VisibleForTesting
    static String getClassName(final String s) {
        return s.substring(0, s.length() - ".class".length()).replace('/', '.');
    }
    
    @VisibleForTesting
    static ImmutableMap<URI, ClassLoader> getClassPathEntries(final ClassLoader value) {
        final LinkedHashMap<URI, ClassLoader> linkedHashMap = (LinkedHashMap<URI, ClassLoader>)Maps.newLinkedHashMap();
        final ClassLoader parent = value.getParent();
        if (parent != null) {
            linkedHashMap.putAll((Map<?, ?>)getClassPathEntries(parent));
        }
        if (value instanceof URLClassLoader) {
            final URL[] urLs = ((URLClassLoader)value).getURLs();
            final int length = urLs.length;
            int i = 0;
            while (i < length) {
                final URL url = urLs[i];
                try {
                    final URI uri = url.toURI();
                    if (!linkedHashMap.containsKey(uri)) {
                        linkedHashMap.put(uri, value);
                    }
                    ++i;
                    continue;
                }
                catch (URISyntaxException cause) {
                    throw new IllegalArgumentException(cause);
                }
                break;
            }
        }
        return (ImmutableMap<URI, ClassLoader>)ImmutableMap.copyOf((Map<?, ?>)linkedHashMap);
    }
    
    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).toSet();
    }
    
    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }
    
    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.resources).filter(ClassInfo.class).filter(ClassPath.IS_TOP_LEVEL).toSet();
    }
    
    public ImmutableSet<ClassInfo> getTopLevelClasses(final String anObject) {
        Preconditions.checkNotNull(anObject);
        final ImmutableSet.Builder<ClassInfo> builder = ImmutableSet.builder();
        for (final ClassInfo classInfo : this.getTopLevelClasses()) {
            if (classInfo.getPackageName().equals(anObject)) {
                builder.add(classInfo);
            }
        }
        return builder.build();
    }
    
    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String prefix) {
        Preconditions.checkNotNull(prefix);
        prefix = String.valueOf(String.valueOf(prefix));
        prefix = new StringBuilder(prefix.length() + 1).append(prefix).append(".").toString();
        final ImmutableSet.Builder<ClassInfo> builder = ImmutableSet.builder();
        for (final ClassInfo classInfo : this.getTopLevelClasses()) {
            if (classInfo.getName().startsWith(prefix)) {
                builder.add(classInfo);
            }
        }
        return builder.build();
    }
    
    @Beta
    public static final class ClassInfo extends ResourceInfo
    {
        private final String className;
        
        ClassInfo(final String s, final ClassLoader classLoader) {
            super(s, classLoader);
            this.className = ClassPath.getClassName(s);
        }
        
        public String getName() {
            return this.className;
        }
        
        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }
        
        public String getSimpleName() {
            final int lastIndex = this.className.lastIndexOf(36);
            if (lastIndex != -1) {
                return CharMatcher.DIGIT.trimLeadingFrom(this.className.substring(lastIndex + 1));
            }
            final String packageName = this.getPackageName();
            if (packageName.isEmpty()) {
                return this.className;
            }
            return this.className.substring(packageName.length() + 1);
        }
        
        public Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            }
            catch (ClassNotFoundException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public String toString() {
            return this.className;
        }
    }
    
    @Beta
    public static class ResourceInfo
    {
        final ClassLoader loader;
        private final String resourceName;
        
        ResourceInfo(final String s, final ClassLoader classLoader) {
            this.resourceName = Preconditions.checkNotNull(s);
            this.loader = Preconditions.checkNotNull(classLoader);
        }
        
        static ResourceInfo of(final String s, final ClassLoader classLoader) {
            if (s.endsWith(".class")) {
                return (ResourceInfo)new ClassInfo(s, classLoader);
            }
            return new ResourceInfo(s, classLoader);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof ResourceInfo) {
                final ResourceInfo resourceInfo = (ResourceInfo)o;
                b2 = b;
                if (this.resourceName.equals(resourceInfo.resourceName)) {
                    b2 = b;
                    if (this.loader == resourceInfo.loader) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        public final String getResourceName() {
            return this.resourceName;
        }
        
        @Override
        public int hashCode() {
            return this.resourceName.hashCode();
        }
        
        @Override
        public String toString() {
            return this.resourceName;
        }
        
        public final URL url() {
            return Preconditions.checkNotNull(this.loader.getResource(this.resourceName), "Failed to load resource: %s", this.resourceName);
        }
    }
    
    @VisibleForTesting
    static final class Scanner
    {
        private final ImmutableSortedSet.Builder<ResourceInfo> resources;
        private final Set<URI> scannedUris;
        
        Scanner() {
            this.resources = (ImmutableSortedSet.Builder<ResourceInfo>)new ImmutableSortedSet.Builder(Ordering.usingToString());
            this.scannedUris = (Set<URI>)Sets.newHashSet();
        }
        
        @VisibleForTesting
        static URI getClassPathEntry(final File file, final String str) throws URISyntaxException {
            final URI uri = new URI(str);
            if (uri.isAbsolute()) {
                return uri;
            }
            return new File(file.getParentFile(), str.replace('/', File.separatorChar)).toURI();
        }
        
        @VisibleForTesting
        static ImmutableSet<URI> getClassPathFromManifest(final File file, @Nullable Manifest obj) {
            if (obj == null) {
                return ImmutableSet.of();
            }
            final ImmutableSet.Builder<URI> builder = ImmutableSet.builder();
            final String value = obj.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (value != null) {
                final Iterator<String> iterator = ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(value).iterator();
                while (iterator.hasNext()) {
                    obj = (Manifest)iterator.next();
                    try {
                        builder.add(getClassPathEntry(file, (String)obj));
                        continue;
                    }
                    catch (URISyntaxException ex) {
                        final Logger access$100 = ClassPath.logger;
                        final String value2 = String.valueOf(obj);
                        String concat;
                        if (value2.length() != 0) {
                            concat = "Invalid Class-Path entry: ".concat(value2);
                        }
                        else {
                            concat = new String("Invalid Class-Path entry: ");
                        }
                        access$100.warning(concat);
                        continue;
                    }
                    break;
                }
            }
            return builder.build();
        }
        
        private void scanDirectory(final File file, final ClassLoader classLoader) throws IOException {
            this.scanDirectory(file, classLoader, "", ImmutableSet.of());
        }
        
        private void scanDirectory(File obj, final ClassLoader classLoader, final String s, final ImmutableSet<File> set) throws IOException {
            final File canonicalFile = obj.getCanonicalFile();
            if (!set.contains(canonicalFile)) {
                final File[] listFiles = obj.listFiles();
                if (listFiles == null) {
                    final Logger access$100 = ClassPath.logger;
                    final String value = String.valueOf(String.valueOf(obj));
                    access$100.warning(new StringBuilder(value.length() + 22).append("Cannot read directory ").append(value).toString());
                    return;
                }
                final ImmutableSet<File> build = ImmutableSet.builder().addAll(set).add(canonicalFile).build();
                for (int length = listFiles.length, i = 0; i < length; ++i) {
                    obj = listFiles[i];
                    final String name = obj.getName();
                    if (obj.isDirectory()) {
                        final String value2 = String.valueOf(String.valueOf(s));
                        final String value3 = String.valueOf(String.valueOf(name));
                        this.scanDirectory(obj, classLoader, new StringBuilder(value2.length() + 1 + value3.length()).append(value2).append(value3).append("/").toString(), build);
                    }
                    else {
                        final String value4 = String.valueOf(s);
                        final String value5 = String.valueOf(name);
                        String concat;
                        if (value5.length() != 0) {
                            concat = value4.concat(value5);
                        }
                        else {
                            concat = new String(value4);
                        }
                        if (!concat.equals("META-INF/MANIFEST.MF")) {
                            this.resources.add(ResourceInfo.of(concat, classLoader));
                        }
                    }
                }
            }
        }
        
        private void scanJar(final File p0, final ClassLoader p1) throws IOException {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: dup            
            //     4: aload_1        
            //     5: invokespecial   java/util/jar/JarFile.<init>:(Ljava/io/File;)V
            //     8: astore_3       
            //     9: aload_1        
            //    10: aload_3        
            //    11: invokevirtual   java/util/jar/JarFile.getManifest:()Ljava/util/jar/Manifest;
            //    14: invokestatic    com/google/common/reflect/ClassPath$Scanner.getClassPathFromManifest:(Ljava/io/File;Ljava/util/jar/Manifest;)Lcom/google/common/collect/ImmutableSet;
            //    17: invokevirtual   com/google/common/collect/ImmutableSet.iterator:()Ljava/util/Iterator;
            //    20: astore_1       
            //    21: aload_1        
            //    22: invokeinterface java/util/Iterator.hasNext:()Z
            //    27: ifeq            56
            //    30: aload_0        
            //    31: aload_1        
            //    32: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //    37: checkcast       Ljava/net/URI;
            //    40: aload_2        
            //    41: invokevirtual   com/google/common/reflect/ClassPath$Scanner.scan:(Ljava/net/URI;Ljava/lang/ClassLoader;)V
            //    44: goto            21
            //    47: astore_1       
            //    48: aload_3        
            //    49: invokevirtual   java/util/jar/JarFile.close:()V
            //    52: aload_1        
            //    53: athrow         
            //    54: astore_1       
            //    55: return         
            //    56: aload_3        
            //    57: invokevirtual   java/util/jar/JarFile.entries:()Ljava/util/Enumeration;
            //    60: astore_1       
            //    61: aload_1        
            //    62: invokeinterface java/util/Enumeration.hasMoreElements:()Z
            //    67: ifeq            122
            //    70: aload_1        
            //    71: invokeinterface java/util/Enumeration.nextElement:()Ljava/lang/Object;
            //    76: checkcast       Ljava/util/jar/JarEntry;
            //    79: astore          4
            //    81: aload           4
            //    83: invokevirtual   java/util/jar/JarEntry.isDirectory:()Z
            //    86: ifne            61
            //    89: aload           4
            //    91: invokevirtual   java/util/jar/JarEntry.getName:()Ljava/lang/String;
            //    94: ldc             "META-INF/MANIFEST.MF"
            //    96: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
            //    99: ifne            61
            //   102: aload_0        
            //   103: getfield        com/google/common/reflect/ClassPath$Scanner.resources:Lcom/google/common/collect/ImmutableSortedSet$Builder;
            //   106: aload           4
            //   108: invokevirtual   java/util/jar/JarEntry.getName:()Ljava/lang/String;
            //   111: aload_2        
            //   112: invokestatic    com/google/common/reflect/ClassPath$ResourceInfo.of:(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/google/common/reflect/ClassPath$ResourceInfo;
            //   115: invokevirtual   com/google/common/collect/ImmutableSortedSet$Builder.add:(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSortedSet$Builder;
            //   118: pop            
            //   119: goto            61
            //   122: aload_3        
            //   123: invokevirtual   java/util/jar/JarFile.close:()V
            //   126: return         
            //   127: astore_1       
            //   128: return         
            //   129: astore_2       
            //   130: goto            52
            //    Exceptions:
            //  throws java.io.IOException
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  0      9      54     56     Ljava/io/IOException;
            //  9      21     47     54     Any
            //  21     44     47     54     Any
            //  48     52     129    133    Ljava/io/IOException;
            //  56     61     47     54     Any
            //  61     119    47     54     Any
            //  122    126    127    129    Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        ImmutableSortedSet<ResourceInfo> getResources() {
            return this.resources.build();
        }
        
        void scan(final URI uri, final ClassLoader classLoader) throws IOException {
            if (uri.getScheme().equals("file") && this.scannedUris.add(uri)) {
                this.scanFrom(new File(uri), classLoader);
            }
        }
        
        @VisibleForTesting
        void scanFrom(final File file, final ClassLoader classLoader) throws IOException {
            if (!file.exists()) {
                return;
            }
            if (file.isDirectory()) {
                this.scanDirectory(file, classLoader);
                return;
            }
            this.scanJar(file, classLoader);
        }
    }
}
