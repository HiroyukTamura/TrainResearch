/*
 * Decompiled with CFR 0.139.
 */
package kotlin.c;

import kotlin.Metadata;
import kotlin.c.a;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b\u00a2\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k=2, mv={1, 1, 11})
public final class b {
    public static final a a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static {
        a a2;
        block18 : {
            int n2 = b.a();
            if (n2 >= 65544) {
                try {
                    Object object = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    j.a(object, "Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                    if (object == null) throw new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    try {
                        a2 = (a)object;
                        break block18;
                    }
                    catch (ClassCastException classCastException) {
                        object = object.getClass().getClassLoader();
                        ClassLoader classLoader = a.class.getClassLoader();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Instance classloader: ");
                        stringBuilder.append(object);
                        stringBuilder.append(", base type classloader: ");
                        stringBuilder.append(classLoader);
                        Throwable throwable = new ClassCastException(stringBuilder.toString()).initCause(classCastException);
                        j.a((Object)throwable, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                        throw throwable;
                    }
                }
                catch (ClassNotFoundException classNotFoundException) {}
                try {
                    Object object = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    j.a(object, "Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                    if (object == null) throw new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    try {
                        a2 = (a)object;
                        break block18;
                    }
                    catch (ClassCastException classCastException) {
                        object = object.getClass().getClassLoader();
                        ClassLoader classLoader = a.class.getClassLoader();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Instance classloader: ");
                        stringBuilder.append(object);
                        stringBuilder.append(", base type classloader: ");
                        stringBuilder.append(classLoader);
                        Throwable throwable = new ClassCastException(stringBuilder.toString()).initCause(classCastException);
                        j.a((Object)throwable, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                        throw throwable;
                    }
                }
                catch (ClassNotFoundException classNotFoundException) {}
            }
            if (n2 >= 65543) {
                try {
                    Object object = Class.forName("kotlin.c.a.a").newInstance();
                    j.a(object, "Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                    if (object == null) throw new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    try {
                        a2 = (a)object;
                        break block18;
                    }
                    catch (ClassCastException classCastException) {
                        object = object.getClass().getClassLoader();
                        ClassLoader classLoader = a.class.getClassLoader();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Instance classloader: ");
                        stringBuilder.append(object);
                        stringBuilder.append(", base type classloader: ");
                        stringBuilder.append(classLoader);
                        Throwable throwable = new ClassCastException(stringBuilder.toString()).initCause(classCastException);
                        j.a((Object)throwable, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                        throw throwable;
                    }
                }
                catch (ClassNotFoundException classNotFoundException) {}
                try {
                    Object object = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    j.a(object, "Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                    if (object == null) throw new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    try {
                        a2 = (a)object;
                        break block18;
                    }
                    catch (ClassCastException classCastException) {
                        object = object.getClass().getClassLoader();
                        ClassLoader classLoader = a.class.getClassLoader();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Instance classloader: ");
                        stringBuilder.append(object);
                        stringBuilder.append(", base type classloader: ");
                        stringBuilder.append(classLoader);
                        Throwable throwable = new ClassCastException(stringBuilder.toString()).initCause(classCastException);
                        j.a((Object)throwable, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                        throw throwable;
                    }
                }
                catch (ClassNotFoundException classNotFoundException) {}
            }
            a2 = new a();
        }
        a = a2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static final int a() {
        int n2;
        String string2 = System.getProperty("java.specification.version");
        if (string2 == null) return 65542;
        CharSequence charSequence = string2;
        int n3 = n.a(charSequence, '.', 0, false, 6, null);
        if (n3 < 0) {
            int n4 = Integer.parseInt(string2);
            return n4 * 65536;
        }
        int n5 = n3 + 1;
        int n6 = n2 = n.a(charSequence, '.', n5, false, 4, null);
        if (n2 < 0) {
            n6 = string2.length();
        }
        if (string2 == null) throw new t("null cannot be cast to non-null type java.lang.String");
        charSequence = string2.substring(0, n3);
        j.a((Object)charSequence, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        if (string2 == null) throw new t("null cannot be cast to non-null type java.lang.String");
        string2 = string2.substring(n5, n6);
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        try {
            n6 = Integer.parseInt((String)charSequence);
            n2 = Integer.parseInt(string2);
            return n6 * 65536 + n2;
        }
        catch (NumberFormatException numberFormatException) {
            return 65542;
        }
        catch (NumberFormatException numberFormatException) {
            return 65542;
        }
    }
}

