package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo21739d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, mo21740k = 2, mo21741mv = {1, 1, 16})
public final class PlatformImplementationsKt {
    @JvmField
    public static final PlatformImplementations IMPLEMENTATIONS;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.internal.PlatformImplementations} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: kotlin.internal.PlatformImplementations} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<kotlin.internal.PlatformImplementations> r0 = kotlin.internal.PlatformImplementations.class
            int r1 = getJavaVersion()
            java.lang.String r2 = "ClassCastException(\"Inst…baseTypeCL\").initCause(e)"
            java.lang.String r3 = ", base type classloader: "
            java.lang.String r4 = "Instance classloader: "
            java.lang.String r5 = "Class.forName(\"kotlin.in…entations\").newInstance()"
            r6 = 65544(0x10008, float:9.1847E-41)
            if (r1 < r6) goto L_0x0094
            java.lang.String r6 = "kotlin.internal.jdk8.JDK8PlatformImplementations"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.Object r6 = r6.newInstance()     // Catch:{ ClassNotFoundException -> 0x0053 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r5)     // Catch:{ ClassNotFoundException -> 0x0053 }
            kotlin.internal.PlatformImplementations r6 = (kotlin.internal.PlatformImplementations) r6     // Catch:{ ClassCastException -> 0x0024 }
            goto L_0x011e
        L_0x0024:
            r7 = move-exception
            java.lang.Class r6 = r6.getClass()     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.ClassLoader r8 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.ClassCastException r9 = new java.lang.ClassCastException     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0053 }
            r10.<init>()     // Catch:{ ClassNotFoundException -> 0x0053 }
            r10.append(r4)     // Catch:{ ClassNotFoundException -> 0x0053 }
            r10.append(r6)     // Catch:{ ClassNotFoundException -> 0x0053 }
            r10.append(r3)     // Catch:{ ClassNotFoundException -> 0x0053 }
            r10.append(r8)     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.String r6 = r10.toString()     // Catch:{ ClassNotFoundException -> 0x0053 }
            r9.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x0053 }
            java.lang.Throwable r6 = r9.initCause(r7)     // Catch:{ ClassNotFoundException -> 0x0053 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)     // Catch:{ ClassNotFoundException -> 0x0053 }
            throw r6     // Catch:{ ClassNotFoundException -> 0x0053 }
        L_0x0053:
            java.lang.String r6 = "kotlin.internal.JRE8PlatformImplementations"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.Object r6 = r6.newInstance()     // Catch:{ ClassNotFoundException -> 0x0093 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r5)     // Catch:{ ClassNotFoundException -> 0x0093 }
            kotlin.internal.PlatformImplementations r6 = (kotlin.internal.PlatformImplementations) r6     // Catch:{ ClassCastException -> 0x0064 }
            goto L_0x011e
        L_0x0064:
            r7 = move-exception
            java.lang.Class r6 = r6.getClass()     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.ClassLoader r8 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.ClassCastException r9 = new java.lang.ClassCastException     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0093 }
            r10.<init>()     // Catch:{ ClassNotFoundException -> 0x0093 }
            r10.append(r4)     // Catch:{ ClassNotFoundException -> 0x0093 }
            r10.append(r6)     // Catch:{ ClassNotFoundException -> 0x0093 }
            r10.append(r3)     // Catch:{ ClassNotFoundException -> 0x0093 }
            r10.append(r8)     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.String r6 = r10.toString()     // Catch:{ ClassNotFoundException -> 0x0093 }
            r9.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x0093 }
            java.lang.Throwable r6 = r9.initCause(r7)     // Catch:{ ClassNotFoundException -> 0x0093 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)     // Catch:{ ClassNotFoundException -> 0x0093 }
            throw r6     // Catch:{ ClassNotFoundException -> 0x0093 }
        L_0x0093:
        L_0x0094:
            r6 = 65543(0x10007, float:9.1845E-41)
            if (r1 < r6) goto L_0x0119
            java.lang.String r1 = "kotlin.internal.jdk7.JDK7PlatformImplementations"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ ClassNotFoundException -> 0x00d9 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            r6 = r1
            kotlin.internal.PlatformImplementations r6 = (kotlin.internal.PlatformImplementations) r6     // Catch:{ ClassCastException -> 0x00aa }
            goto L_0x011e
        L_0x00aa:
            r6 = move-exception
            java.lang.Class r1 = r1.getClass()     // Catch:{ ClassNotFoundException -> 0x00d9 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00d9 }
            java.lang.ClassLoader r7 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00d9 }
            java.lang.ClassCastException r8 = new java.lang.ClassCastException     // Catch:{ ClassNotFoundException -> 0x00d9 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x00d9 }
            r9.<init>()     // Catch:{ ClassNotFoundException -> 0x00d9 }
            r9.append(r4)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            r9.append(r1)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            r9.append(r3)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            r9.append(r7)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            java.lang.String r1 = r9.toString()     // Catch:{ ClassNotFoundException -> 0x00d9 }
            r8.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            java.lang.Throwable r1 = r8.initCause(r6)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ ClassNotFoundException -> 0x00d9 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00d9 }
        L_0x00d9:
            java.lang.String r1 = "kotlin.internal.JRE7PlatformImplementations"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0119 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ ClassNotFoundException -> 0x0119 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)     // Catch:{ ClassNotFoundException -> 0x0119 }
            r6 = r1
            kotlin.internal.PlatformImplementations r6 = (kotlin.internal.PlatformImplementations) r6     // Catch:{ ClassCastException -> 0x00ea }
            goto L_0x011e
        L_0x00ea:
            r5 = move-exception
            java.lang.Class r1 = r1.getClass()     // Catch:{ ClassNotFoundException -> 0x0119 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0119 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0119 }
            java.lang.ClassCastException r6 = new java.lang.ClassCastException     // Catch:{ ClassNotFoundException -> 0x0119 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0119 }
            r7.<init>()     // Catch:{ ClassNotFoundException -> 0x0119 }
            r7.append(r4)     // Catch:{ ClassNotFoundException -> 0x0119 }
            r7.append(r1)     // Catch:{ ClassNotFoundException -> 0x0119 }
            r7.append(r3)     // Catch:{ ClassNotFoundException -> 0x0119 }
            r7.append(r0)     // Catch:{ ClassNotFoundException -> 0x0119 }
            java.lang.String r0 = r7.toString()     // Catch:{ ClassNotFoundException -> 0x0119 }
            r6.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x0119 }
            java.lang.Throwable r0 = r6.initCause(r5)     // Catch:{ ClassNotFoundException -> 0x0119 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)     // Catch:{ ClassNotFoundException -> 0x0119 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x0119 }
        L_0x0119:
            kotlin.internal.PlatformImplementations r6 = new kotlin.internal.PlatformImplementations
            r6.<init>()
        L_0x011e:
            IMPLEMENTATIONS = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementationsKt.<clinit>():void");
    }

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final boolean apiVersionIsAtLeast(int i, int i2, int i3) {
        return KotlinVersion.CURRENT.isAtLeast(i, i2, i3);
    }

    @InlineOnly
    private static final /* synthetic */ <T> T castToBaseType(Object obj) {
        try {
            Intrinsics.reifiedOperationMarker(1, "T");
            return obj;
        } catch (ClassCastException e) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
            Intrinsics.checkExpressionValueIsNotNull(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw initCause;
        }
    }

    private static final int getJavaVersion() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        } else {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', i, false, 4, (Object) null);
            if (indexOf$default2 < 0) {
                indexOf$default2 = property.length();
            }
            String substring = property.substring(0, indexOf$default);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = property.substring(i, indexOf$default2);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
            } catch (NumberFormatException unused2) {
                return 65542;
            }
        }
    }
}
