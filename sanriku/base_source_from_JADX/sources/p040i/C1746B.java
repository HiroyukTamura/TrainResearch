package p040i;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0019"}, mo21739d2 = {"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "parameterNamesAndValues", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "[Ljava/lang/String;", "()Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", "other", "hashCode", "", "parameter", "name", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.B */
public final class C1746B {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Pattern f2078d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Pattern f2079e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: f */
    public static final C1747a f2080f = null;

    /* renamed from: a */
    private final String f2081a;

    /* renamed from: b */
    private final String f2082b;

    /* renamed from: c */
    private final String[] f2083c;

    /* renamed from: i.B$a */
    public static final class C1747a {
        @JvmStatic
        @JvmName(name = "get")
        /* renamed from: a */
        public static final C1746B m2460a(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toMediaType");
            Matcher matcher = C1746B.f2078d.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Intrinsics.checkExpressionValueIsNotNull(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                String lowerCase = group.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String group2 = matcher.group(2);
                Intrinsics.checkExpressionValueIsNotNull(group2, "typeSubtype.group(2)");
                Locale locale2 = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
                String lowerCase2 = group2.toLowerCase(locale2);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = C1746B.f2079e.matcher(str);
                int end = matcher.end();
                while (end < str.length()) {
                    matcher2.region(end, str.length());
                    if (matcher2.lookingAt()) {
                        String group3 = matcher2.group(1);
                        if (group3 != null) {
                            String group4 = matcher2.group(2);
                            if (group4 == null) {
                                group4 = matcher2.group(3);
                            } else if (StringsKt__StringsJVMKt.startsWith$default(group4, "'", false, 2, (Object) null) && StringsKt__StringsJVMKt.endsWith$default(group4, "'", false, 2, (Object) null) && group4.length() > 2) {
                                group4 = group4.substring(1, group4.length() - 1);
                                Intrinsics.checkExpressionValueIsNotNull(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            arrayList.add(group3);
                            arrayList.add(group4);
                        }
                        end = matcher2.end();
                    } else {
                        StringBuilder a = C0681a.m330a("Parameter is not formatted correctly: \"");
                        String substring = str.substring(end);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                        a.append(substring);
                        a.append("\" for: \"");
                        a.append(str);
                        a.append(Typography.quote);
                        throw new IllegalArgumentException(a.toString().toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    return new C1746B(str, lowerCase, lowerCase2, (String[]) array, (DefaultConstructorMarker) null);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + Typography.quote).toString());
        }

        @JvmStatic
        @JvmName(name = "parse")
        /* renamed from: b */
        public static final C1746B m2461b(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toMediaTypeOrNull");
            try {
                return m2460a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public /* synthetic */ C1746B(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.f2081a = str;
        this.f2082b = str2;
        this.f2083c = strArr;
    }

    @JvmStatic
    @JvmName(name = "get")
    /* renamed from: a */
    public static final C1746B m2454a(String str) {
        return C1747a.m2460a(str);
    }

    /* renamed from: a */
    public static /* synthetic */ Charset m2455a(C1746B b, Charset charset, int i) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return b.mo27454a(charset);
    }

    @JvmName(name = "type")
    /* renamed from: a */
    public final String mo27453a() {
        return this.f2082b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d A[SYNTHETIC, Splitter:B:11:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmOverloads
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.nio.charset.Charset mo27454a(java.nio.charset.Charset r7) {
        /*
            r6 = this;
            java.lang.String r0 = "charset"
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            java.lang.String[] r1 = r6.f2083c
            kotlin.ranges.IntRange r1 = kotlin.collections.ArraysKt___ArraysKt.getIndices((T[]) r1)
            r2 = 2
            kotlin.ranges.IntProgression r1 = kotlin.ranges.RangesKt___RangesKt.step((kotlin.ranges.IntProgression) r1, (int) r2)
            int r2 = r1.getFirst()
            int r3 = r1.getLast()
            int r1 = r1.getStep()
            if (r1 < 0) goto L_0x0023
            if (r2 > r3) goto L_0x003a
            goto L_0x0025
        L_0x0023:
            if (r2 < r3) goto L_0x003a
        L_0x0025:
            java.lang.String[] r4 = r6.f2083c
            r4 = r4[r2]
            r5 = 1
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, r0, r5)
            if (r4 == 0) goto L_0x0036
            java.lang.String[] r0 = r6.f2083c
            int r2 = r2 + r5
            r0 = r0[r2]
            goto L_0x003b
        L_0x0036:
            if (r2 == r3) goto L_0x003a
            int r2 = r2 + r1
            goto L_0x0025
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x0041
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r0)     // Catch:{ IllegalArgumentException -> 0x0041 }
        L_0x0041:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C1746B.mo27454a(java.nio.charset.Charset):java.nio.charset.Charset");
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1746B) && Intrinsics.areEqual((Object) ((C1746B) obj).f2081a, (Object) this.f2081a);
    }

    public int hashCode() {
        return this.f2081a.hashCode();
    }

    public String toString() {
        return this.f2081a;
    }
}
