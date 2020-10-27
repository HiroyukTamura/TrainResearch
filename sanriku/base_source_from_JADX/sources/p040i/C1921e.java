package p040i;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, mo21739d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.e */
public final class C1921e {
    @JvmField

    /* renamed from: n */
    public static final C1921e f2749n;

    /* renamed from: o */
    public static final C1921e f2750o = null;

    /* renamed from: a */
    private final boolean f2751a;

    /* renamed from: b */
    private final boolean f2752b;

    /* renamed from: c */
    private final int f2753c;

    /* renamed from: d */
    private final int f2754d;

    /* renamed from: e */
    private final boolean f2755e;

    /* renamed from: f */
    private final boolean f2756f;

    /* renamed from: g */
    private final boolean f2757g;

    /* renamed from: h */
    private final int f2758h;

    /* renamed from: i */
    private final int f2759i;

    /* renamed from: j */
    private final boolean f2760j;

    /* renamed from: k */
    private final boolean f2761k;

    /* renamed from: l */
    private final boolean f2762l;

    /* renamed from: m */
    private String f2763m;

    /* renamed from: i.e$a */
    public static final class C1922a {

        /* renamed from: a */
        private boolean f2764a;

        /* renamed from: b */
        private boolean f2765b;

        /* renamed from: c */
        private int f2766c = -1;

        /* renamed from: d */
        private int f2767d = -1;

        /* renamed from: e */
        private int f2768e = -1;

        /* renamed from: f */
        private boolean f2769f;

        /* renamed from: a */
        public final C1922a mo28050a(int i, TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                int i2 = Integer.MAX_VALUE;
                if (seconds <= ((long) Integer.MAX_VALUE)) {
                    i2 = (int) seconds;
                }
                this.f2767d = i2;
                return this;
            }
            throw new IllegalArgumentException(C0681a.m316a("maxStale < 0: ", i).toString());
        }

        /* renamed from: a */
        public final C1921e mo28051a() {
            return new C1921e(this.f2764a, this.f2765b, this.f2766c, -1, false, false, false, this.f2767d, this.f2768e, this.f2769f, false, false, (String) null, (DefaultConstructorMarker) null);
        }

        /* renamed from: b */
        public final C1922a mo28052b() {
            this.f2764a = true;
            return this;
        }

        /* renamed from: c */
        public final C1922a mo28053c() {
            this.f2765b = true;
            return this;
        }

        /* renamed from: d */
        public final C1922a mo28054d() {
            this.f2769f = true;
            return this;
        }
    }

    static {
        C1922a aVar = new C1922a();
        aVar.mo28052b();
        aVar.mo28051a();
        C1922a aVar2 = new C1922a();
        aVar2.mo28054d();
        aVar2.mo28050a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        f2749n = aVar2.mo28051a();
    }

    public /* synthetic */ C1921e(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f2751a = z;
        this.f2752b = z2;
        this.f2753c = i;
        this.f2754d = i2;
        this.f2755e = z3;
        this.f2756f = z4;
        this.f2757g = z5;
        this.f2758h = i3;
        this.f2759i = i4;
        this.f2760j = z6;
        this.f2761k = z7;
        this.f2762l = z8;
        this.f2763m = str;
    }

    /* renamed from: a */
    private static final int m3294a(String str, String str2, int i) {
        int length = str.length();
        while (i < length) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    @kotlin.jvm.JvmStatic
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final p040i.C1921e m3295a(p040i.C1952y r28) {
        /*
            r0 = r28
            java.lang.String r1 = "headers"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            int r1 = r28.size()
            r5 = 1
            r6 = 0
            r7 = 1
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = -1
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x0021:
            if (r6 >= r1) goto L_0x0167
            java.lang.String r9 = r0.mo28113a((int) r6)
            java.lang.String r2 = r0.mo28115b(r6)
            java.lang.String r4 = "Cache-Control"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r4, r5)
            if (r4 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r8 = r2
            goto L_0x0041
        L_0x0038:
            java.lang.String r4 = "Pragma"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r4, r5)
            if (r4 == 0) goto L_0x015e
        L_0x0040:
            r7 = 0
        L_0x0041:
            r4 = 0
        L_0x0042:
            int r9 = r2.length()
            if (r4 >= r9) goto L_0x015e
            java.lang.String r9 = "=,;"
            int r9 = m3294a(r2, r9, r4)
            java.lang.String r4 = r2.substring(r4, r9)
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r3)
            java.lang.CharSequence r4 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r4)
            java.lang.String r4 = r4.toString()
            int r5 = r2.length()
            if (r9 == r5) goto L_0x00bc
            char r5 = r2.charAt(r9)
            r0 = 44
            if (r5 == r0) goto L_0x00bc
            char r0 = r2.charAt(r9)
            r5 = 59
            if (r0 != r5) goto L_0x0076
            goto L_0x00bc
        L_0x0076:
            int r9 = r9 + 1
            int r0 = p040i.p103M.C1764b.m2610a((java.lang.String) r2, (int) r9)
            int r5 = r2.length()
            if (r0 >= r5) goto L_0x00a6
            char r5 = r2.charAt(r0)
            r9 = 34
            if (r5 != r9) goto L_0x00a6
            int r0 = r0 + 1
            r23 = 34
            r25 = 0
            r26 = 4
            r27 = 0
            r22 = r2
            r24 = r0
            int r5 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r22, (char) r23, (int) r24, (boolean) r25, (int) r26, (java.lang.Object) r27)
            java.lang.String r0 = r2.substring(r0, r5)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r3 = 1
            int r5 = r5 + r3
            goto L_0x00c0
        L_0x00a6:
            java.lang.String r5 = ",;"
            int r5 = m3294a(r2, r5, r0)
            java.lang.String r0 = r2.substring(r0, r5)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.CharSequence r0 = kotlin.text.StringsKt__StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            goto L_0x00c0
        L_0x00bc:
            int r9 = r9 + 1
            r5 = r9
            r0 = 0
        L_0x00c0:
            java.lang.String r3 = "no-cache"
            r9 = 1
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x00cd
            r3 = -1
            r10 = 1
            goto L_0x0158
        L_0x00cd:
            java.lang.String r3 = "no-store"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x00d9
            r3 = -1
            r11 = 1
            goto L_0x0158
        L_0x00d9:
            java.lang.String r3 = "max-age"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x00e8
            r3 = -1
            int r12 = p040i.p103M.C1764b.m2637b(r0, r3)
            goto L_0x0158
        L_0x00e8:
            java.lang.String r3 = "s-maxage"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x00f6
            r3 = -1
            int r13 = p040i.p103M.C1764b.m2637b(r0, r3)
            goto L_0x0158
        L_0x00f6:
            java.lang.String r3 = "private"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x0101
            r3 = -1
            r14 = 1
            goto L_0x0158
        L_0x0101:
            java.lang.String r3 = "public"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x010c
            r3 = -1
            r15 = 1
            goto L_0x0158
        L_0x010c:
            java.lang.String r3 = "must-revalidate"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x0118
            r3 = -1
            r16 = 1
            goto L_0x0158
        L_0x0118:
            java.lang.String r3 = "max-stale"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x0129
            r3 = 2147483647(0x7fffffff, float:NaN)
            int r17 = p040i.p103M.C1764b.m2637b(r0, r3)
            r3 = -1
            goto L_0x0158
        L_0x0129:
            java.lang.String r3 = "min-fresh"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.equals(r3, r4, r9)
            if (r3 == 0) goto L_0x0137
            r3 = -1
            int r18 = p040i.p103M.C1764b.m2637b(r0, r3)
            goto L_0x0158
        L_0x0137:
            r3 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r4, r9)
            if (r0 == 0) goto L_0x0143
            r19 = 1
            goto L_0x0158
        L_0x0143:
            java.lang.String r0 = "no-transform"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r4, r9)
            if (r0 == 0) goto L_0x014e
            r20 = 1
            goto L_0x0158
        L_0x014e:
            java.lang.String r0 = "immutable"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.equals(r0, r4, r9)
            if (r0 == 0) goto L_0x0158
            r21 = 1
        L_0x0158:
            r0 = r28
            r4 = r5
            r5 = 1
            goto L_0x0042
        L_0x015e:
            r3 = -1
            r9 = 1
            int r6 = r6 + 1
            r5 = 1
            r0 = r28
            goto L_0x0021
        L_0x0167:
            if (r7 != 0) goto L_0x016c
            r22 = 0
            goto L_0x016e
        L_0x016c:
            r22 = r8
        L_0x016e:
            i.e r0 = new i.e
            r23 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.C1921e.m3295a(i.y):i.e");
    }

    /* renamed from: a */
    public final boolean mo28040a() {
        return this.f2755e;
    }

    /* renamed from: b */
    public final boolean mo28041b() {
        return this.f2756f;
    }

    @JvmName(name = "maxAgeSeconds")
    /* renamed from: c */
    public final int mo28042c() {
        return this.f2753c;
    }

    @JvmName(name = "maxStaleSeconds")
    /* renamed from: d */
    public final int mo28043d() {
        return this.f2758h;
    }

    @JvmName(name = "minFreshSeconds")
    /* renamed from: e */
    public final int mo28044e() {
        return this.f2759i;
    }

    @JvmName(name = "mustRevalidate")
    /* renamed from: f */
    public final boolean mo28045f() {
        return this.f2757g;
    }

    @JvmName(name = "noCache")
    /* renamed from: g */
    public final boolean mo28046g() {
        return this.f2751a;
    }

    @JvmName(name = "noStore")
    /* renamed from: h */
    public final boolean mo28047h() {
        return this.f2752b;
    }

    @JvmName(name = "onlyIfCached")
    /* renamed from: i */
    public final boolean mo28048i() {
        return this.f2760j;
    }

    public String toString() {
        String str = this.f2763m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f2751a) {
            sb.append("no-cache, ");
        }
        if (this.f2752b) {
            sb.append("no-store, ");
        }
        if (this.f2753c != -1) {
            sb.append("max-age=");
            sb.append(this.f2753c);
            sb.append(", ");
        }
        if (this.f2754d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f2754d);
            sb.append(", ");
        }
        if (this.f2755e) {
            sb.append("private, ");
        }
        if (this.f2756f) {
            sb.append("public, ");
        }
        if (this.f2757g) {
            sb.append("must-revalidate, ");
        }
        if (this.f2758h != -1) {
            sb.append("max-stale=");
            sb.append(this.f2758h);
            sb.append(", ");
        }
        if (this.f2759i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f2759i);
            sb.append(", ");
        }
        if (this.f2760j) {
            sb.append("only-if-cached, ");
        }
        if (this.f2761k) {
            sb.append("no-transform, ");
        }
        if (this.f2762l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        this.f2763m = sb2;
        return sb2;
    }
}
