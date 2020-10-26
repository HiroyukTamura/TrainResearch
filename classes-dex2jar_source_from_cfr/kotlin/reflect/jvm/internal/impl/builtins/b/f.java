/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.e.b.u;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.r;
import kotlin.reflect.jvm.internal.impl.a.s;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.a.x;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.b.a;
import kotlin.reflect.jvm.internal.impl.builtins.b.b;
import kotlin.reflect.jvm.internal.impl.builtins.b.d;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.h.j;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.z;
import kotlin.reflect.jvm.internal.impl.l.b;
import kotlin.reflect.jvm.internal.impl.l.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
public class f
implements kotlin.reflect.jvm.internal.impl.a.b.a,
kotlin.reflect.jvm.internal.impl.a.b.c {
    static final /* synthetic */ kotlin.reflect.l[] a;
    public static final a b;
    private static final Set<String> k;
    private static final Set<String> l;
    private static final Set<String> m;
    private static final Set<String> n;
    private static final Set<String> o;
    private static final Set<String> p;
    private final kotlin.reflect.jvm.internal.impl.builtins.b.c c;
    private final kotlin.g d;
    private final kotlin.g e;
    private final kotlin.reflect.jvm.internal.impl.j.w f;
    private final kotlin.reflect.jvm.internal.impl.i.f g;
    private final kotlin.reflect.jvm.internal.impl.i.a<kotlin.reflect.jvm.internal.impl.e.b, kotlin.reflect.jvm.internal.impl.a.e> h;
    private final kotlin.reflect.jvm.internal.impl.i.f i;
    private final y j;

    static {
        a = new kotlin.reflect.l[]{v.a(new kotlin.e.b.t(v.a(f.class), "ownerModuleDescriptor", "getOwnerModuleDescriptor()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;")), v.a(new kotlin.e.b.t(v.a(f.class), "isAdditionalBuiltInsFeatureSupported", "isAdditionalBuiltInsFeatureSupported()Z")), v.a(new kotlin.e.b.t(v.a(f.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), v.a(new kotlin.e.b.t(v.a(f.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationsImpl;"))};
        b = new a(null);
        k = al.a((Set)kotlin.reflect.jvm.internal.impl.c.b.u.a.b("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        kotlin.reflect.jvm.internal.impl.c.b.u u2 = kotlin.reflect.jvm.internal.impl.c.b.u.a;
        l = al.a(al.a(al.a(al.a(al.a(f.b.d(), (Iterable)u2.b("List", "sort(Ljava/util/Comparator;)V")), (Iterable)u2.a("String", new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"})), (Iterable)u2.a("Double", new String[]{"isInfinite()Z", "isNaN()Z"})), (Iterable)u2.a("Float", new String[]{"isInfinite()Z", "isNaN()Z"})), (Iterable)u2.a("Enum", new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"}));
        u2 = kotlin.reflect.jvm.internal.impl.c.b.u.a;
        m = al.a(al.a(al.a(al.a(al.a(al.a((Set)u2.a("CharSequence", new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}), (Iterable)u2.b("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable)u2.a("Iterable", new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"})), (Iterable)u2.a("Throwable", new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"})), (Iterable)u2.b("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable)u2.b("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable)u2.b("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        u2 = kotlin.reflect.jvm.internal.impl.c.b.u.a;
        n = al.a(al.a((Set)u2.b("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable)u2.b("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable)u2.b("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        u2 = kotlin.reflect.jvm.internal.impl.c.b.u.a;
        String[] arrstring = f.b.e();
        String[] arrstring2 = u2.a(new String[]{"D"});
        arrstring = al.a(arrstring, (Iterable)u2.a("Float", Arrays.copyOf(arrstring2, arrstring2.length)));
        arrstring2 = u2.a(new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"});
        o = al.a(arrstring, (Iterable)u2.a("String", Arrays.copyOf(arrstring2, arrstring2.length)));
        u2 = kotlin.reflect.jvm.internal.impl.c.b.u.a;
        arrstring = u2.a(new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"});
        p = u2.a("Throwable", Arrays.copyOf(arrstring, arrstring.length));
    }

    public f(y y2, final kotlin.reflect.jvm.internal.impl.i.i i2, kotlin.e.a.a<? extends y> a2, kotlin.e.a.a<Boolean> a3) {
        kotlin.e.b.j.b(y2, "moduleDescriptor");
        kotlin.e.b.j.b(i2, "storageManager");
        kotlin.e.b.j.b(a2, "deferredOwnerModuleDescriptor");
        kotlin.e.b.j.b(a3, "isAdditionalBuiltInsFeatureSupported");
        this.j = y2;
        this.c = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
        this.d = kotlin.h.a(a2);
        this.e = kotlin.h.a(a3);
        this.f = this.a(i2);
        this.g = i2.a((kotlin.e.a.a)new kotlin.e.a.a<ad>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final ad b() {
                y y2 = this.d();
                kotlin.reflect.jvm.internal.impl.e.a a2 = kotlin.reflect.jvm.internal.impl.builtins.b.d.b.a();
                kotlin.e.b.j.a((Object)a2, "JvmBuiltInClassDescripto\u2026actory.CLONEABLE_CLASS_ID");
                return s.a(y2, a2, new aa(i2, this.d())).i_();
            }
        });
        this.h = i2.b();
        this.i = i2.a((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.a.a.i>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.a.a.i b() {
                return new kotlin.reflect.jvm.internal.impl.a.a.i(kotlin.a.m.a(kotlin.reflect.jvm.internal.impl.a.a.f.a(this.j.a(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    private final Collection<am> a(kotlin.reflect.jvm.internal.impl.a.e object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.h.e.h, ? extends Collection<? extends am>> iterator) {
        Object object2;
        kotlin.reflect.jvm.internal.impl.l.j j2;
        kotlin.reflect.jvm.internal.impl.a.m m2;
        Object object3;
        Object object4;
        final kotlin.reflect.jvm.internal.impl.c.a.c.a.f f2 = this.e((kotlin.reflect.jvm.internal.impl.a.e)object);
        if (f2 != null && (object4 = (kotlin.reflect.jvm.internal.impl.a.e)kotlin.a.m.e(object3 = (Iterable)((kotlin.reflect.jvm.internal.impl.builtins.b.c)((Object)(j2 = this.c))).a(kotlin.reflect.jvm.internal.impl.h.c.a.b(m2 = (kotlin.reflect.jvm.internal.impl.a.m)f2), kotlin.reflect.jvm.internal.impl.builtins.b.b.b.a()))) != null) {
            j2 = kotlin.reflect.jvm.internal.impl.l.j.a;
            object2 = new ArrayList(kotlin.a.m.a(object3, 10));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                object2.add(kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.m)((kotlin.reflect.jvm.internal.impl.a.e)object3.next())));
            }
        } else {
            return kotlin.a.m.a();
        }
        j2 = ((j.b)((Object)j2)).a((List)object2);
        boolean bl2 = this.c.a((kotlin.reflect.jvm.internal.impl.a.e)object);
        object = this.h.a(kotlin.reflect.jvm.internal.impl.h.c.a.b(m2), (kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.a.e>)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.c.a.c.a.f>((kotlin.reflect.jvm.internal.impl.a.e)object4){
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.e b;
            {
                this.b = e2;
                super(0);
            }

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.c.a.c.a.f b() {
                kotlin.reflect.jvm.internal.impl.c.a.c.a.f f22 = f2;
                kotlin.reflect.jvm.internal.impl.c.a.a.g g2 = kotlin.reflect.jvm.internal.impl.c.a.a.g.a;
                kotlin.e.b.j.a((Object)g2, "JavaResolverCache.EMPTY");
                return f22.a(g2, this.b);
            }
        }).g();
        kotlin.e.b.j.a(object, "scope");
        iterator = (Iterable)iterator.a(object);
        object = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            boolean bl3;
            Object t2 = iterator.next();
            m2 = (am)t2;
            object4 = m2.n();
            object2 = b.a.a;
            boolean bl4 = false;
            if (object4 != object2) {
                bl3 = bl4;
            } else if (!m2.p().c()) {
                bl3 = bl4;
            } else if (KotlinBuiltIns.isDeprecated(m2)) {
                bl3 = bl4;
            } else {
                object4 = m2.k();
                kotlin.e.b.j.a(object4, "analogueMember.overriddenDescriptors");
                object4 = (Iterable)object4;
                if (!(object4 instanceof Collection) || !((Collection)object4).isEmpty()) {
                    object4 = object4.iterator();
                    while (object4.hasNext()) {
                        object2 = (kotlin.reflect.jvm.internal.impl.a.t)object4.next();
                        kotlin.e.b.j.a(object2, "it");
                        object2 = object2.b();
                        kotlin.e.b.j.a(object2, "it.containingDeclaration");
                        if (!j2.contains(kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.m)object2))) continue;
                        bl3 = true;
                        break;
                    }
                } else {
                    bl3 = false;
                }
                if (bl3) {
                    bl3 = bl4;
                } else {
                    bl3 = bl4;
                    if (!this.a((am)m2, bl2)) {
                        bl3 = true;
                    }
                }
            }
            if (!bl3) continue;
            object.add(t2);
        }
        return (List)object;
    }

    private final am a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e e2, am object) {
        object = object.E();
        object.a(e2);
        object.a(az.e);
        object.a(e2.i_());
        object.a(e2.D());
        e2 = object.f();
        if (e2 == null) {
            kotlin.e.b.j.a();
        }
        return (am)((Object)e2);
    }

    private final b a(kotlin.reflect.jvm.internal.impl.a.t object) {
        kotlin.reflect.jvm.internal.impl.a.m m2 = object.b();
        if (m2 != null) {
            m2 = (kotlin.reflect.jvm.internal.impl.a.e)m2;
            object = kotlin.reflect.jvm.internal.impl.c.b.r.a((kotlin.reflect.jvm.internal.impl.a.t)object, false, false, 3, null);
            u.a a2 = new u.a();
            a2.a = null;
            object = kotlin.reflect.jvm.internal.impl.l.b.a((Collection)kotlin.a.m.a(m2), }
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    