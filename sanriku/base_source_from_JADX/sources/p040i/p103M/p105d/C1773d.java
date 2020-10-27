package p040i.p103M.p105d;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1952y;
import p040i.p103M.C1764b;
import p040i.p103M.p108g.C1816c;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, mo21739d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getCacheResponse", "()Lokhttp3/Response;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.d.d */
public final class C1773d {

    /* renamed from: a */
    private final C1755F f2232a;

    /* renamed from: b */
    private final C1758I f2233b;

    /* renamed from: i.M.d.d$a */
    public static final class C1774a {

        /* renamed from: a */
        private Date f2234a;

        /* renamed from: b */
        private String f2235b;

        /* renamed from: c */
        private Date f2236c;

        /* renamed from: d */
        private String f2237d;

        /* renamed from: e */
        private Date f2238e;

        /* renamed from: f */
        private long f2239f;

        /* renamed from: g */
        private long f2240g;

        /* renamed from: h */
        private String f2241h;

        /* renamed from: i */
        private int f2242i = -1;

        /* renamed from: j */
        private final long f2243j;

        /* renamed from: k */
        private final C1755F f2244k;

        /* renamed from: l */
        private final C1758I f2245l;

        public C1774a(long j, C1755F f, C1758I i) {
            Intrinsics.checkParameterIsNotNull(f, "request");
            this.f2243j = j;
            this.f2244k = f;
            this.f2245l = i;
            if (i != null) {
                this.f2239f = i.mo27570z();
                this.f2240g = this.f2245l.mo27568x();
                C1952y r = this.f2245l.mo27561r();
                int size = r.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String a = r.mo28113a(i2);
                    String b = r.mo28115b(i2);
                    if (StringsKt__StringsJVMKt.equals(a, "Date", true)) {
                        this.f2234a = C1816c.m2859a(b);
                        this.f2235b = b;
                    } else if (StringsKt__StringsJVMKt.equals(a, "Expires", true)) {
                        this.f2238e = C1816c.m2859a(b);
                    } else if (StringsKt__StringsJVMKt.equals(a, "Last-Modified", true)) {
                        this.f2236c = C1816c.m2859a(b);
                        this.f2237d = b;
                    } else if (StringsKt__StringsJVMKt.equals(a, "ETag", true)) {
                        this.f2241h = b;
                    } else if (StringsKt__StringsJVMKt.equals(a, "Age", true)) {
                        this.f2242i = C1764b.m2637b(b, -1);
                    }
                }
            }
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [i.F, i.I] */
        /* JADX WARNING: type inference failed for: r1v3 */
        /* JADX WARNING: type inference failed for: r1v10 */
        /* JADX WARNING: type inference failed for: r1v18 */
        /* JADX WARNING: type inference failed for: r1v21 */
        /* JADX WARNING: type inference failed for: r1v28 */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ce, code lost:
            if (r2 > 0) goto L_0x0106;
         */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0201  */
        /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p040i.p103M.p105d.C1773d mo27604a() {
            /*
                r17 = this;
                r0 = r17
                i.I r1 = r0.f2245l
                r2 = 0
                if (r1 != 0) goto L_0x000f
                i.M.d.d r1 = new i.M.d.d
                i.F r3 = r0.f2244k
                r1.<init>(r3, r2)
                goto L_0x0038
            L_0x000f:
                i.F r1 = r0.f2244k
                boolean r1 = r1.mo27540e()
                if (r1 == 0) goto L_0x0027
                i.I r1 = r0.f2245l
                i.x r1 = r1.mo27560q()
                if (r1 != 0) goto L_0x0027
                i.M.d.d r1 = new i.M.d.d
                i.F r3 = r0.f2244k
                r1.<init>(r3, r2)
                goto L_0x0038
            L_0x0027:
                i.I r1 = r0.f2245l
                i.F r3 = r0.f2244k
                boolean r1 = p040i.p103M.p105d.C1773d.m2652a(r1, r3)
                if (r1 != 0) goto L_0x003f
                i.M.d.d r1 = new i.M.d.d
                i.F r3 = r0.f2244k
                r1.<init>(r3, r2)
            L_0x0038:
                r16 = r2
                r2 = r1
                r1 = r16
                goto L_0x01ef
            L_0x003f:
                i.F r1 = r0.f2244k
                i.e r1 = r1.mo27536b()
                boolean r3 = r1.mo28046g()
                if (r3 != 0) goto L_0x01e7
                i.F r3 = r0.f2244k
                java.lang.String r4 = "If-Modified-Since"
                java.lang.String r5 = r3.mo27535a((java.lang.String) r4)
                java.lang.String r6 = "If-None-Match"
                if (r5 != 0) goto L_0x0060
                java.lang.String r3 = r3.mo27535a((java.lang.String) r6)
                if (r3 == 0) goto L_0x005e
                goto L_0x0060
            L_0x005e:
                r3 = 0
                goto L_0x0061
            L_0x0060:
                r3 = 1
            L_0x0061:
                if (r3 == 0) goto L_0x0065
                goto L_0x01e7
            L_0x0065:
                i.I r3 = r0.f2245l
                i.e r3 = r3.mo27555h()
                java.util.Date r5 = r0.f2234a
                r9 = 0
                if (r5 == 0) goto L_0x007d
                long r11 = r0.f2240g
                long r13 = r5.getTime()
                long r11 = r11 - r13
                long r11 = java.lang.Math.max(r9, r11)
                goto L_0x007e
            L_0x007d:
                r11 = r9
            L_0x007e:
                int r5 = r0.f2242i
                r13 = -1
                if (r5 == r13) goto L_0x008e
                java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.SECONDS
                long r7 = (long) r5
                long r7 = r14.toMillis(r7)
                long r11 = java.lang.Math.max(r11, r7)
            L_0x008e:
                long r7 = r0.f2240g
                r14 = r3
                long r2 = r0.f2239f
                long r2 = r7 - r2
                r15 = r6
                long r5 = r0.f2243j
                long r5 = r5 - r7
                long r11 = r11 + r2
                long r11 = r11 + r5
                i.I r2 = r0.f2245l
                if (r2 != 0) goto L_0x00a2
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x00a2:
                i.e r2 = r2.mo27555h()
                int r3 = r2.mo28042c()
                if (r3 == r13) goto L_0x00b8
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
                int r2 = r2.mo28042c()
                long r5 = (long) r2
                long r2 = r3.toMillis(r5)
                goto L_0x0106
            L_0x00b8:
                java.util.Date r2 = r0.f2238e
                if (r2 == 0) goto L_0x00d1
                java.util.Date r3 = r0.f2234a
                if (r3 == 0) goto L_0x00c5
                long r5 = r3.getTime()
                goto L_0x00c7
            L_0x00c5:
                long r5 = r0.f2240g
            L_0x00c7:
                long r2 = r2.getTime()
                long r2 = r2 - r5
                int r5 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
                if (r5 <= 0) goto L_0x0105
                goto L_0x0106
            L_0x00d1:
                java.util.Date r2 = r0.f2236c
                if (r2 == 0) goto L_0x0105
                i.I r2 = r0.f2245l
                i.F r2 = r2.mo27569y()
                i.z r2 = r2.mo27542g()
                java.lang.String r2 = r2.mo28144k()
                if (r2 != 0) goto L_0x0105
                java.util.Date r2 = r0.f2234a
                if (r2 == 0) goto L_0x00ee
                long r2 = r2.getTime()
                goto L_0x00f0
            L_0x00ee:
                long r2 = r0.f2239f
            L_0x00f0:
                java.util.Date r5 = r0.f2236c
                if (r5 != 0) goto L_0x00f7
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x00f7:
                long r5 = r5.getTime()
                long r2 = r2 - r5
                int r5 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
                if (r5 <= 0) goto L_0x0105
                r5 = 10
                long r5 = (long) r5
                long r2 = r2 / r5
                goto L_0x0106
            L_0x0105:
                r2 = r9
            L_0x0106:
                int r5 = r1.mo28042c()
                if (r5 == r13) goto L_0x011b
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
                int r6 = r1.mo28042c()
                long r6 = (long) r6
                long r5 = r5.toMillis(r6)
                long r2 = java.lang.Math.min(r2, r5)
            L_0x011b:
                int r5 = r1.mo28044e()
                if (r5 == r13) goto L_0x012d
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
                int r6 = r1.mo28044e()
                long r6 = (long) r6
                long r5 = r5.toMillis(r6)
                goto L_0x012e
            L_0x012d:
                r5 = r9
            L_0x012e:
                boolean r7 = r14.mo28045f()
                if (r7 != 0) goto L_0x0145
                int r7 = r1.mo28043d()
                if (r7 == r13) goto L_0x0145
                java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
                int r1 = r1.mo28043d()
                long r8 = (long) r1
                long r9 = r7.toMillis(r8)
            L_0x0145:
                boolean r1 = r14.mo28046g()
                if (r1 != 0) goto L_0x019a
                long r5 = r5 + r11
                long r9 = r9 + r2
                int r1 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r1 >= 0) goto L_0x019a
                i.I r1 = r0.f2245l
                if (r1 == 0) goto L_0x0198
                i.I$a r4 = new i.I$a
                r4.<init>(r1)
                java.lang.String r1 = "Warning"
                int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r7 < 0) goto L_0x0165
                java.lang.String r2 = "110 HttpURLConnection \"Response is stale\""
                r4.mo27580a((java.lang.String) r1, (java.lang.String) r2)
            L_0x0165:
                r2 = 86400000(0x5265c00, double:4.2687272E-316)
                int r5 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r5 <= 0) goto L_0x018b
                i.I r2 = r0.f2245l
                if (r2 != 0) goto L_0x0173
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0173:
                i.e r2 = r2.mo27555h()
                int r2 = r2.mo28042c()
                if (r2 != r13) goto L_0x0183
                java.util.Date r2 = r0.f2238e
                if (r2 != 0) goto L_0x0183
                r7 = 1
                goto L_0x0184
            L_0x0183:
                r7 = 0
            L_0x0184:
                if (r7 == 0) goto L_0x018b
                java.lang.String r2 = "113 HttpURLConnection \"Heuristic expiration\""
                r4.mo27580a((java.lang.String) r1, (java.lang.String) r2)
            L_0x018b:
                i.M.d.d r1 = new i.M.d.d
                i.I r2 = r4.mo27581a()
                r3 = 0
                r1.<init>(r3, r2)
                r2 = r1
                r1 = r3
                goto L_0x01ef
            L_0x0198:
                r3 = 0
                throw r3
            L_0x019a:
                java.lang.String r1 = r0.f2241h
                if (r1 == 0) goto L_0x01a0
                r4 = r15
                goto L_0x01ad
            L_0x01a0:
                java.util.Date r1 = r0.f2236c
                if (r1 == 0) goto L_0x01a7
                java.lang.String r1 = r0.f2237d
                goto L_0x01ad
            L_0x01a7:
                java.util.Date r1 = r0.f2234a
                if (r1 == 0) goto L_0x01de
                java.lang.String r1 = r0.f2235b
            L_0x01ad:
                i.F r2 = r0.f2244k
                i.y r2 = r2.mo27539d()
                i.y$a r2 = r2.mo28112a()
                if (r1 != 0) goto L_0x01bc
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x01bc:
                r2.mo28125b(r4, r1)
                i.F r1 = r0.f2244k
                if (r1 == 0) goto L_0x01dc
                i.F$a r3 = new i.F$a
                r3.<init>(r1)
                i.y r1 = r2.mo28124a()
                r3.mo27545a((p040i.C1952y) r1)
                i.F r1 = r3.mo27551a()
                i.M.d.d r2 = new i.M.d.d
                i.I r3 = r0.f2245l
                r2.<init>(r1, r3)
                r1 = 0
                goto L_0x01ef
            L_0x01dc:
                r1 = 0
                throw r1
            L_0x01de:
                r1 = 0
                i.M.d.d r2 = new i.M.d.d
                i.F r3 = r0.f2244k
                r2.<init>(r3, r1)
                goto L_0x01ef
            L_0x01e7:
                r1 = r2
                i.M.d.d r2 = new i.M.d.d
                i.F r3 = r0.f2244k
                r2.<init>(r3, r1)
            L_0x01ef:
                i.F r3 = r2.mo27603b()
                if (r3 == 0) goto L_0x0206
                i.F r3 = r0.f2244k
                i.e r3 = r3.mo27536b()
                boolean r3 = r3.mo28048i()
                if (r3 == 0) goto L_0x0206
                i.M.d.d r2 = new i.M.d.d
                r2.<init>(r1, r1)
            L_0x0206:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p105d.C1773d.C1774a.mo27604a():i.M.d.d");
        }
    }

    public C1773d(C1755F f, C1758I i) {
        this.f2232a = f;
        this.f2233b = i;
    }

    /* renamed from: a */
    public static final boolean m2652a(C1758I i, C1755F f) {
        Intrinsics.checkParameterIsNotNull(i, "response");
        Intrinsics.checkParameterIsNotNull(f, "request");
        int o = i.mo27558o();
        if (!(o == 200 || o == 410 || o == 414 || o == 501 || o == 203 || o == 204)) {
            if (o != 307) {
                if (!(o == 308 || o == 404 || o == 405)) {
                    switch (o) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (C1758I.m2561a(i, "Expires", (String) null, 2) == null && i.mo27555h().mo28042c() == -1 && !i.mo27555h().mo28041b() && !i.mo27555h().mo28040a()) {
                return false;
            }
        }
        return !i.mo27555h().mo28047h() && !f.mo27536b().mo28047h();
    }

    /* renamed from: a */
    public final C1758I mo27602a() {
        return this.f2233b;
    }

    /* renamed from: b */
    public final C1755F mo27603b() {
        return this.f2232a;
    }
}
