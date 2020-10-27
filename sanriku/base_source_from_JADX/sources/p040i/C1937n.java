package p040i;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p040i.p103M.C1764b;
import p040i.p103M.p108g.C1816c;

/* renamed from: i.n */
public final class C1937n {

    /* renamed from: j */
    private static final Pattern f2812j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    private static final Pattern f2813k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    private static final Pattern f2814l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    private static final Pattern f2815m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: n */
    public static final C1937n f2816n = null;

    /* renamed from: a */
    private final String f2817a;

    /* renamed from: b */
    private final String f2818b;

    /* renamed from: c */
    private final long f2819c;

    /* renamed from: d */
    private final String f2820d;

    /* renamed from: e */
    private final String f2821e;

    /* renamed from: f */
    private final boolean f2822f;

    /* renamed from: g */
    private final boolean f2823g;

    /* renamed from: h */
    private final boolean f2824h;

    /* renamed from: i */
    private final boolean f2825i;

    public /* synthetic */ C1937n(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this.f2817a = str;
        this.f2818b = str2;
        this.f2819c = j;
        this.f2820d = str3;
        this.f2821e = str4;
        this.f2822f = z;
        this.f2823g = z2;
        this.f2824h = z3;
        this.f2825i = z4;
    }

    /* renamed from: a */
    private static final int m3338a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || ('0' <= charAt && '9' >= charAt) || (('a' <= charAt && 'z' >= charAt) || (('A' <= charAt && 'Z' >= charAt) || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d6, code lost:
        if (okhttp3.internal.publicsuffix.PublicSuffixDatabase.m4558a().mo35638a(r5) == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01be, code lost:
        if ((kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5) || (kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r0, r5, false, 2, (java.lang.Object) null) && r0.charAt((r0.length() - r5.length()) - 1) == '.' && !p040i.p103M.C1764b.m2633a(r0))) == false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0235 A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<p040i.C1937n> m3340a(p040i.C1955z r36, p040i.C1952y r37) {
        /*
            r1 = r36
            r0 = r37
            java.lang.String r2 = "url"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r2)
            java.lang.String r3 = "headers"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r3)
            java.lang.String r3 = "Set-Cookie"
            java.util.List r3 = r0.mo28114a((java.lang.String) r3)
            int r4 = r3.size()
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x001b:
            if (r7 >= r4) goto L_0x023a
            java.lang.Object r0 = r3.get(r7)
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r2)
            java.lang.String r0 = "setCookie"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            long r10 = java.lang.System.currentTimeMillis()
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r2)
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            r0 = 6
            r12 = 59
            int r0 = p040i.p103M.C1764b.m2609a(r9, r12, r6, r6, r0)
            r13 = 61
            int r14 = p040i.p103M.C1764b.m2608a((java.lang.String) r9, (char) r13, (int) r6, (int) r0)
            if (r14 != r0) goto L_0x0049
        L_0x0045:
            r9 = 0
            r11 = 0
            goto L_0x0227
        L_0x0049:
            java.lang.String r16 = p040i.p103M.C1764b.m2642c(r9, r6, r14)
            int r15 = r16.length()
            r5 = 1
            if (r15 != 0) goto L_0x0056
            r15 = 1
            goto L_0x0057
        L_0x0056:
            r15 = 0
        L_0x0057:
            if (r15 != 0) goto L_0x0045
            int r15 = p040i.p103M.C1764b.m2636b((java.lang.String) r16)
            r6 = -1
            if (r15 == r6) goto L_0x0061
            goto L_0x0045
        L_0x0061:
            int r14 = r14 + 1
            java.lang.String r17 = p040i.p103M.C1764b.m2642c(r9, r14, r0)
            int r14 = p040i.p103M.C1764b.m2636b((java.lang.String) r17)
            if (r14 == r6) goto L_0x006e
            goto L_0x0045
        L_0x006e:
            int r0 = r0 + 1
            int r6 = r9.length()
            r18 = -1
            r20 = r18
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 1
            r27 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r29 = 0
            r30 = 0
        L_0x0089:
            r31 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r33 = -9223372036854775808
            r14 = 2
            if (r0 >= r6) goto L_0x0156
            int r15 = p040i.p103M.C1764b.m2608a((java.lang.String) r9, (char) r12, (int) r0, (int) r6)
            int r12 = p040i.p103M.C1764b.m2608a((java.lang.String) r9, (char) r13, (int) r0, (int) r15)
            java.lang.String r0 = p040i.p103M.C1764b.m2642c(r9, r0, r12)
            if (r12 >= r15) goto L_0x00a8
            int r12 = r12 + 1
            java.lang.String r12 = p040i.p103M.C1764b.m2642c(r9, r12, r15)
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r12 = ""
        L_0x00aa:
            java.lang.String r13 = "expires"
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r13, r5)
            if (r13 == 0) goto L_0x00bc
            int r0 = r12.length()     // Catch:{ IllegalArgumentException -> 0x014d }
            r13 = 0
            long r27 = m3339a(r12, r13, r0)     // Catch:{ IllegalArgumentException -> 0x014d }
            goto L_0x00f1
        L_0x00bc:
            java.lang.String r13 = "max-age"
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r13, r5)
            if (r13 == 0) goto L_0x00f5
            long r12 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x00d4 }
            r20 = 0
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 > 0) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r33 = r12
        L_0x00d1:
            r20 = r33
            goto L_0x00f1
        L_0x00d4:
            r0 = move-exception
            r13 = r0
            kotlin.text.Regex r0 = new kotlin.text.Regex     // Catch:{  }
            java.lang.String r5 = "-?\\d+"
            r0.<init>((java.lang.String) r5)     // Catch:{  }
            boolean r0 = r0.matches(r12)     // Catch:{  }
            if (r0 == 0) goto L_0x00f4
            java.lang.String r0 = "-"
            r5 = 0
            r13 = 0
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r12, r0, r13, r14, r5)     // Catch:{  }
            if (r0 == 0) goto L_0x00ef
            r31 = r33
        L_0x00ef:
            r20 = r31
        L_0x00f1:
            r24 = 1
            goto L_0x014d
        L_0x00f4:
            throw r13     // Catch:{  }
        L_0x00f5:
            java.lang.String r5 = "domain"
            r13 = 1
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r5, r13)
            if (r5 == 0) goto L_0x012c
            java.lang.String r0 = "."
            r5 = 0
            r13 = 0
            boolean r14 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r12, r0, r13, r14, r5)     // Catch:{ IllegalArgumentException -> 0x014d }
            r5 = 1
            r13 = r14 ^ 1
            if (r13 == 0) goto L_0x0120
            java.lang.String r0 = kotlin.text.StringsKt__StringsKt.removePrefix((java.lang.String) r12, (java.lang.CharSequence) r0)     // Catch:{ IllegalArgumentException -> 0x014d }
            java.lang.String r0 = p040i.p103M.C1763a.m2602a(r0)     // Catch:{ IllegalArgumentException -> 0x014d }
            if (r0 == 0) goto L_0x011a
            r29 = r0
            r25 = 0
            goto L_0x014d
        L_0x011a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x014d }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x014d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x014d }
        L_0x0120:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x014d }
            java.lang.String r5 = "Failed requirement."
            java.lang.String r5 = r5.toString()     // Catch:{ IllegalArgumentException -> 0x014d }
            r0.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x014d }
            throw r0     // Catch:{ IllegalArgumentException -> 0x014d }
        L_0x012c:
            java.lang.String r5 = "path"
            r13 = 1
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r5, r13)
            if (r5 == 0) goto L_0x0138
            r30 = r12
            goto L_0x014d
        L_0x0138:
            java.lang.String r5 = "secure"
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r5, r13)
            if (r5 == 0) goto L_0x0143
            r22 = 1
            goto L_0x014d
        L_0x0143:
            java.lang.String r5 = "httponly"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r5, r13)
            if (r0 == 0) goto L_0x014d
            r23 = 1
        L_0x014d:
            int r0 = r15 + 1
            r5 = 1
            r12 = 59
            r13 = 61
            goto L_0x0089
        L_0x0156:
            int r0 = (r20 > r33 ? 1 : (r20 == r33 ? 0 : -1))
            if (r0 != 0) goto L_0x015d
            r18 = r33
            goto L_0x0187
        L_0x015d:
            int r0 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0185
            r5 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r0 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x016f
            r0 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r0
            long r31 = r20 * r5
        L_0x016f:
            long r31 = r10 + r31
            int r0 = (r31 > r10 ? 1 : (r31 == r10 ? 0 : -1))
            r5 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            if (r0 < 0) goto L_0x0182
            int r0 = (r31 > r5 ? 1 : (r31 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x017f
            goto L_0x0182
        L_0x017f:
            r18 = r31
            goto L_0x0187
        L_0x0182:
            r18 = r5
            goto L_0x0187
        L_0x0185:
            r18 = r27
        L_0x0187:
            java.lang.String r0 = r36.mo28138f()
            r5 = r29
            if (r5 != 0) goto L_0x0191
            r5 = r0
            goto L_0x01c2
        L_0x0191:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r6 == 0) goto L_0x019a
        L_0x0197:
            r35 = 1
            goto L_0x01be
        L_0x019a:
            r6 = 0
            r9 = 0
            boolean r10 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r0, r5, r9, r14, r6)
            if (r10 == 0) goto L_0x01bc
            int r6 = r0.length()
            int r9 = r5.length()
            int r6 = r6 - r9
            r9 = 1
            int r6 = r6 - r9
            char r6 = r0.charAt(r6)
            r10 = 46
            if (r6 != r10) goto L_0x01bc
            boolean r6 = p040i.p103M.C1764b.m2633a((java.lang.String) r0)
            if (r6 != 0) goto L_0x01bc
            goto L_0x0197
        L_0x01bc:
            r35 = 0
        L_0x01be:
            if (r35 != 0) goto L_0x01c2
            goto L_0x0045
        L_0x01c2:
            int r0 = r0.length()
            int r6 = r5.length()
            if (r0 == r6) goto L_0x01da
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$a r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.f4286h
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.f4285g
            java.lang.String r0 = r0.mo35638a(r5)
            if (r0 != 0) goto L_0x01da
            goto L_0x0045
        L_0x01da:
            java.lang.String r0 = "/"
            r6 = r30
            r9 = 0
            if (r6 == 0) goto L_0x01ed
            r10 = 0
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r6, r0, r10, r14, r9)
            if (r11 != 0) goto L_0x01e9
            goto L_0x01ed
        L_0x01e9:
            r21 = r6
            r11 = 0
            goto L_0x021b
        L_0x01ed:
            java.lang.String r6 = r36.mo28133b()
            r28 = 47
            r29 = 0
            r30 = 0
            r31 = 6
            r32 = 0
            r27 = r6
            int r10 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r27, (char) r28, (int) r29, (boolean) r30, (int) r31, (java.lang.Object) r32)
            if (r10 == 0) goto L_0x0218
            if (r6 == 0) goto L_0x0210
            r11 = 0
            java.lang.String r0 = r6.substring(r11, r10)
            java.lang.String r6 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            goto L_0x0219
        L_0x0210:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L_0x0218:
            r11 = 0
        L_0x0219:
            r21 = r0
        L_0x021b:
            i.n r0 = new i.n
            r26 = 0
            r15 = r0
            r20 = r5
            r15.<init>(r16, r17, r18, r20, r21, r22, r23, r24, r25, r26)
            r5 = r0
            goto L_0x0228
        L_0x0227:
            r5 = r9
        L_0x0228:
            if (r5 == 0) goto L_0x0235
            if (r8 != 0) goto L_0x0232
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r8 = r0
        L_0x0232:
            r8.add(r5)
        L_0x0235:
            int r7 = r7 + 1
            r6 = 0
            goto L_0x001b
        L_0x023a:
            if (r8 == 0) goto L_0x0246
            java.util.List r0 = java.util.Collections.unmodifiableList(r8)
            java.lang.String r1 = "Collections.unmodifiableList(cookies)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            goto L_0x024a
        L_0x0246:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x024a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C1937n.m3340a(i.z, i.y):java.util.List");
    }

    @JvmName(name = "name")
    /* renamed from: a */
    public final String mo28087a() {
        return this.f2817a;
    }

    @JvmName(name = "value")
    /* renamed from: b */
    public final String mo28088b() {
        return this.f2818b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1937n) {
            C1937n nVar = (C1937n) obj;
            return Intrinsics.areEqual((Object) nVar.f2817a, (Object) this.f2817a) && Intrinsics.areEqual((Object) nVar.f2818b, (Object) this.f2818b) && nVar.f2819c == this.f2819c && Intrinsics.areEqual((Object) nVar.f2820d, (Object) this.f2820d) && Intrinsics.areEqual((Object) nVar.f2821e, (Object) this.f2821e) && nVar.f2822f == this.f2822f && nVar.f2823g == this.f2823g && nVar.f2824h == this.f2824h && nVar.f2825i == this.f2825i;
        }
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int hashCode = this.f2818b.hashCode();
        int hashCode2 = this.f2820d.hashCode();
        return ((((((((this.f2821e.hashCode() + ((hashCode2 + ((((hashCode + ((this.f2817a.hashCode() + 527) * 31)) * 31) + C0680d.m300a(this.f2819c)) * 31)) * 31)) * 31) + C0534b.m20a(this.f2822f)) * 31) + C0534b.m20a(this.f2823g)) * 31) + C0534b.m20a(this.f2824h)) * 31) + C0534b.m20a(this.f2825i);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2817a);
        sb.append('=');
        sb.append(this.f2818b);
        if (this.f2824h) {
            if (this.f2819c == Long.MIN_VALUE) {
                str = "; max-age=0";
            } else {
                sb.append("; expires=");
                str = C1816c.m2858a(new Date(this.f2819c));
            }
            sb.append(str);
        }
        if (!this.f2825i) {
            sb.append("; domain=");
            sb.append(this.f2820d);
        }
        sb.append("; path=");
        sb.append(this.f2821e);
        if (this.f2822f) {
            sb.append("; secure");
        }
        if (this.f2823g) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "toString()");
        return sb2;
    }

    /* renamed from: a */
    private static final long m3339a(String str, int i, int i2) {
        String str2 = str;
        int i3 = i2;
        int a = m3338a(str2, i, i3, false);
        Matcher matcher = f2815m.matcher(str2);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a < i3) {
            int a2 = m3338a(str2, a + 1, i3, true);
            matcher.region(a, a2);
            if (i5 == -1 && matcher.usePattern(f2815m).matches()) {
                String group = matcher.group(1);
                Intrinsics.checkExpressionValueIsNotNull(group, "matcher.group(1)");
                i5 = Integer.parseInt(group);
                String group2 = matcher.group(2);
                Intrinsics.checkExpressionValueIsNotNull(group2, "matcher.group(2)");
                i8 = Integer.parseInt(group2);
                String group3 = matcher.group(3);
                Intrinsics.checkExpressionValueIsNotNull(group3, "matcher.group(3)");
                i9 = Integer.parseInt(group3);
            } else if (i6 == -1 && matcher.usePattern(f2814l).matches()) {
                String group4 = matcher.group(1);
                Intrinsics.checkExpressionValueIsNotNull(group4, "matcher.group(1)");
                i6 = Integer.parseInt(group4);
            } else if (i7 == -1 && matcher.usePattern(f2813k).matches()) {
                String group5 = matcher.group(1);
                Intrinsics.checkExpressionValueIsNotNull(group5, "matcher.group(1)");
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                String lowerCase = group5.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String pattern = f2813k.pattern();
                Intrinsics.checkExpressionValueIsNotNull(pattern, "MONTH_PATTERN.pattern()");
                i7 = StringsKt__StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null) / 4;
            } else if (i4 == -1 && matcher.usePattern(f2812j).matches()) {
                String group6 = matcher.group(1);
                Intrinsics.checkExpressionValueIsNotNull(group6, "matcher.group(1)");
                i4 = Integer.parseInt(group6);
            }
            a = m3338a(str2, a2 + 1, i3, false);
        }
        if (70 <= i4 && 99 >= i4) {
            i4 += 1900;
        }
        if (i4 >= 0 && 69 >= i4) {
            i4 += CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
        }
        if (i4 >= 1601) {
            if (i7 != -1) {
                if (1 <= i6 && 31 >= i6) {
                    if (i5 >= 0 && 23 >= i5) {
                        if (i8 >= 0 && 59 >= i8) {
                            if (i9 >= 0 && 59 >= i9) {
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(C1764b.f2217e);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, i4);
                                gregorianCalendar.set(2, i7 - 1);
                                gregorianCalendar.set(5, i6);
                                gregorianCalendar.set(11, i5);
                                gregorianCalendar.set(12, i8);
                                gregorianCalendar.set(13, i9);
                                gregorianCalendar.set(14, 0);
                                return gregorianCalendar.getTimeInMillis();
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
