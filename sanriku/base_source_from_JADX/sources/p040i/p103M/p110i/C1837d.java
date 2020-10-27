package p040i.p103M.p110i;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;
import p042j.C1016z;
import p042j.C2068f;
import p042j.C2071g;
import p042j.C2072h;
import p042j.C2073i;
import p042j.C2085t;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, mo21739d2 = {"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.i.d */
public final class C1837d {

    /* renamed from: a */
    private static final C1836c[] f2485a = {new C1836c(C1836c.f2481i, ""), new C1836c(C1836c.f2478f, "GET"), new C1836c(C1836c.f2478f, "POST"), new C1836c(C1836c.f2479g, "/"), new C1836c(C1836c.f2479g, "/index.html"), new C1836c(C1836c.f2480h, "http"), new C1836c(C1836c.f2480h, "https"), new C1836c(C1836c.f2477e, "200"), new C1836c(C1836c.f2477e, "204"), new C1836c(C1836c.f2477e, "206"), new C1836c(C1836c.f2477e, "304"), new C1836c(C1836c.f2477e, "400"), new C1836c(C1836c.f2477e, "404"), new C1836c(C1836c.f2477e, "500"), new C1836c("accept-charset", ""), new C1836c("accept-encoding", "gzip, deflate"), new C1836c("accept-language", ""), new C1836c("accept-ranges", ""), new C1836c("accept", ""), new C1836c("access-control-allow-origin", ""), new C1836c("age", ""), new C1836c("allow", ""), new C1836c("authorization", ""), new C1836c("cache-control", ""), new C1836c("content-disposition", ""), new C1836c("content-encoding", ""), new C1836c("content-language", ""), new C1836c("content-length", ""), new C1836c("content-location", ""), new C1836c("content-range", ""), new C1836c("content-type", ""), new C1836c("cookie", ""), new C1836c("date", ""), new C1836c("etag", ""), new C1836c("expect", ""), new C1836c("expires", ""), new C1836c("from", ""), new C1836c("host", ""), new C1836c("if-match", ""), new C1836c("if-modified-since", ""), new C1836c("if-none-match", ""), new C1836c("if-range", ""), new C1836c("if-unmodified-since", ""), new C1836c("last-modified", ""), new C1836c("link", ""), new C1836c((String) FirebaseAnalytics.Param.LOCATION, ""), new C1836c("max-forwards", ""), new C1836c("proxy-authenticate", ""), new C1836c("proxy-authorization", ""), new C1836c("range", ""), new C1836c("referer", ""), new C1836c("refresh", ""), new C1836c("retry-after", ""), new C1836c("server", ""), new C1836c("set-cookie", ""), new C1836c("strict-transport-security", ""), new C1836c("transfer-encoding", ""), new C1836c("user-agent", ""), new C1836c("vary", ""), new C1836c("via", ""), new C1836c("www-authenticate", "")};

    /* renamed from: b */
    private static final Map<C2073i, Integer> f2486b;

    /* renamed from: c */
    public static final C1837d f2487c = new C1837d();

    /* renamed from: i.M.i.d$b */
    public static final class C1839b {

        /* renamed from: a */
        private int f2496a;

        /* renamed from: b */
        private boolean f2497b;
        @JvmField

        /* renamed from: c */
        public int f2498c;
        @JvmField

        /* renamed from: d */
        public C1836c[] f2499d;

        /* renamed from: e */
        private int f2500e;
        @JvmField

        /* renamed from: f */
        public int f2501f;
        @JvmField

        /* renamed from: g */
        public int f2502g;
        @JvmField

        /* renamed from: h */
        public int f2503h;

        /* renamed from: i */
        private final boolean f2504i;

        /* renamed from: j */
        private final C2068f f2505j;

        public /* synthetic */ C1839b(int i, boolean z, C2068f fVar, int i2) {
            i = (i2 & 1) != 0 ? 4096 : i;
            z = (i2 & 2) != 0 ? true : z;
            Intrinsics.checkParameterIsNotNull(fVar, "out");
            this.f2503h = i;
            this.f2504i = z;
            this.f2505j = fVar;
            this.f2496a = Integer.MAX_VALUE;
            this.f2498c = i;
            this.f2499d = new C1836c[8];
            this.f2500e = 7;
        }

        /* renamed from: a */
        private final void m2933a() {
            ArraysKt___ArraysJvmKt.fill$default((Object[]) this.f2499d, (Object) null, 0, 0, 6, (Object) null);
            this.f2500e = this.f2499d.length - 1;
            this.f2501f = 0;
            this.f2502g = 0;
        }

        /* renamed from: a */
        private final void m2934a(C1836c cVar) {
            int i = cVar.f2482a;
            int i2 = this.f2498c;
            if (i > i2) {
                m2933a();
                return;
            }
            m2935b((this.f2502g + i) - i2);
            int i3 = this.f2501f + 1;
            C1836c[] cVarArr = this.f2499d;
            if (i3 > cVarArr.length) {
                C1836c[] cVarArr2 = new C1836c[(cVarArr.length * 2)];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f2500e = this.f2499d.length - 1;
                this.f2499d = cVarArr2;
            }
            int i4 = this.f2500e;
            this.f2500e = i4 - 1;
            this.f2499d[i4] = cVar;
            this.f2501f++;
            this.f2502g += i;
        }

        /* renamed from: b */
        private final int m2935b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f2499d.length;
                while (true) {
                    length--;
                    if (length < this.f2500e || i <= 0) {
                        C1836c[] cVarArr = this.f2499d;
                        int i3 = this.f2500e;
                        System.arraycopy(cVarArr, i3 + 1, cVarArr, i3 + 1 + i2, this.f2501f);
                        C1836c[] cVarArr2 = this.f2499d;
                        int i4 = this.f2500e;
                        Arrays.fill(cVarArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                        this.f2500e += i2;
                    } else {
                        C1836c cVar = this.f2499d[length];
                        if (cVar == null) {
                            Intrinsics.throwNpe();
                        }
                        i -= cVar.f2482a;
                        int i5 = this.f2502g;
                        C1836c cVar2 = this.f2499d[length];
                        if (cVar2 == null) {
                            Intrinsics.throwNpe();
                        }
                        this.f2502g = i5 - cVar2.f2482a;
                        this.f2501f--;
                        i2++;
                    }
                }
                C1836c[] cVarArr3 = this.f2499d;
                int i32 = this.f2500e;
                System.arraycopy(cVarArr3, i32 + 1, cVarArr3, i32 + 1 + i2, this.f2501f);
                C1836c[] cVarArr22 = this.f2499d;
                int i42 = this.f2500e;
                Arrays.fill(cVarArr22, i42 + 1, i42 + 1 + i2, (Object) null);
                this.f2500e += i2;
            }
            return i2;
        }

        /* renamed from: a */
        public final void mo27818a(int i) {
            this.f2503h = i;
            int min = Math.min(i, 16384);
            int i2 = this.f2498c;
            if (i2 != min) {
                if (min < i2) {
                    this.f2496a = Math.min(this.f2496a, min);
                }
                this.f2497b = true;
                this.f2498c = min;
                int i3 = this.f2502g;
                if (min >= i3) {
                    return;
                }
                if (min == 0) {
                    m2933a();
                } else {
                    m2935b(i3 - min);
                }
            }
        }

        /* renamed from: a */
        public final void mo27819a(int i, int i2, int i3) {
            int i4;
            C2068f fVar;
            if (i < i2) {
                fVar = this.f2505j;
                i4 = i | i3;
            } else {
                this.f2505j.writeByte(i3 | i2);
                i4 = i - i2;
                while (i4 >= 128) {
                    this.f2505j.writeByte(128 | (i4 & 127));
                    i4 >>>= 7;
                }
                fVar = this.f2505j;
            }
            fVar.writeByte(i4);
        }

        /* renamed from: a */
        public final void mo27820a(C2073i iVar) throws IOException {
            int i;
            int i2;
            Intrinsics.checkParameterIsNotNull(iVar, "data");
            if (!this.f2504i || C1867k.f2642d.mo27935a(iVar) >= iVar.mo29212d()) {
                i2 = iVar.mo29212d();
                i = 0;
            } else {
                C2068f fVar = new C2068f();
                C1867k.f2642d.mo27937a(iVar, fVar);
                iVar = fVar.mo29169j();
                i2 = iVar.mo29212d();
                i = 128;
            }
            mo27819a(i2, 127, i);
            this.f2505j.mo29137a(iVar);
        }

        /* renamed from: a */
        public final void mo27821a(List<C1836c> list) throws IOException {
            int i;
            int i2;
            Intrinsics.checkParameterIsNotNull(list, "headerBlock");
            if (this.f2497b) {
                int i3 = this.f2496a;
                if (i3 < this.f2498c) {
                    mo27819a(i3, 31, 32);
                }
                this.f2497b = false;
                this.f2496a = Integer.MAX_VALUE;
                mo27819a(this.f2498c, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C1836c cVar = list.get(i4);
                C2073i g = cVar.f2483b.mo29216g();
                C2073i iVar = cVar.f2484c;
                Integer num = C1837d.f2487c.mo27812a().get(g);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (2 <= i2 && 7 >= i2) {
                        if (Intrinsics.areEqual((Object) C1837d.f2487c.mo27813b()[i2 - 1].f2484c, (Object) iVar)) {
                            i = i2;
                        } else if (Intrinsics.areEqual((Object) C1837d.f2487c.mo27813b()[i2].f2484c, (Object) iVar)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i5 = this.f2500e + 1;
                    int length = this.f2499d.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        C1836c cVar2 = this.f2499d[i5];
                        if (cVar2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (Intrinsics.areEqual((Object) cVar2.f2483b, (Object) g)) {
                            C1836c cVar3 = this.f2499d[i5];
                            if (cVar3 == null) {
                                Intrinsics.throwNpe();
                            }
                            if (Intrinsics.areEqual((Object) cVar3.f2484c, (Object) iVar)) {
                                i2 = C1837d.f2487c.mo27813b().length + (i5 - this.f2500e);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.f2500e) + C1837d.f2487c.mo27813b().length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    mo27819a(i2, 127, 128);
                } else {
                    if (i == -1) {
                        this.f2505j.writeByte(64);
                        mo27820a(g);
                    } else {
                        C2073i iVar2 = C1836c.f2476d;
                        if (g != null) {
                            Intrinsics.checkParameterIsNotNull(iVar2, "prefix");
                            if (!g.mo29205a(0, iVar2, 0, iVar2.mo29212d()) || !(!Intrinsics.areEqual((Object) C1836c.f2481i, (Object) g))) {
                                mo27819a(i, 63, 64);
                            } else {
                                mo27819a(i, 15, 0);
                                mo27820a(iVar);
                            }
                        } else {
                            throw null;
                        }
                    }
                    mo27820a(iVar);
                    m2934a(cVar);
                }
            }
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f2485a.length);
        int length = f2485a.length;
        for (int i = 0; i < length; i++) {
            if (!linkedHashMap.containsKey(f2485a[i].f2483b)) {
                linkedHashMap.put(f2485a[i].f2483b, Integer.valueOf(i));
            }
        }
        Map<C2073i, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableMap, "Collections.unmodifiableMap(result)");
        f2486b = unmodifiableMap;
    }

    private C1837d() {
    }

    /* renamed from: a */
    public final C2073i mo27811a(C2073i iVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(iVar, AppMeasurementSdk.ConditionalUserProperty.NAME);
        int d = iVar.mo29212d();
        for (int i = 0; i < d; i++) {
            byte b = (byte) 65;
            byte b2 = (byte) 90;
            byte a = iVar.mo29201a(i);
            if (b <= a && b2 >= a) {
                StringBuilder a2 = C0681a.m330a("PROTOCOL_ERROR response malformed: mixed case name: ");
                a2.append(iVar.mo29217h());
                throw new IOException(a2.toString());
            }
        }
        return iVar;
    }

    /* renamed from: a */
    public final Map<C2073i, Integer> mo27812a() {
        return f2486b;
    }

    /* renamed from: b */
    public final C1836c[] mo27813b() {
        return f2485a;
    }

    /* renamed from: i.M.i.d$a */
    public static final class C1838a {

        /* renamed from: a */
        private final List<C1836c> f2488a;

        /* renamed from: b */
        private final C2072h f2489b;
        @JvmField

        /* renamed from: c */
        public C1836c[] f2490c;

        /* renamed from: d */
        private int f2491d;
        @JvmField

        /* renamed from: e */
        public int f2492e;
        @JvmField

        /* renamed from: f */
        public int f2493f;

        /* renamed from: g */
        private final int f2494g;

        /* renamed from: h */
        private int f2495h;

        public /* synthetic */ C1838a(C1016z zVar, int i, int i2, int i3) {
            i2 = (i3 & 4) != 0 ? i : i2;
            Intrinsics.checkParameterIsNotNull(zVar, FirebaseAnalytics.Param.SOURCE);
            this.f2494g = i;
            this.f2495h = i2;
            this.f2488a = new ArrayList();
            Intrinsics.checkParameterIsNotNull(zVar, "$this$buffer");
            this.f2489b = new C2085t(zVar);
            this.f2490c = new C1836c[8];
            this.f2491d = 7;
        }

        /* renamed from: a */
        private final int m2923a(int i) {
            return this.f2491d + 1 + i;
        }

        /* renamed from: a */
        private final void m2924a(int i, C1836c cVar) {
            this.f2488a.add(cVar);
            int i2 = cVar.f2482a;
            if (i != -1) {
                C1836c cVar2 = this.f2490c[this.f2491d + 1 + i];
                if (cVar2 == null) {
                    Intrinsics.throwNpe();
                }
                i2 -= cVar2.f2482a;
            }
            int i3 = this.f2495h;
            if (i2 > i3) {
                m2927d();
                return;
            }
            int b = m2925b((this.f2493f + i2) - i3);
            if (i == -1) {
                int i4 = this.f2492e + 1;
                C1836c[] cVarArr = this.f2490c;
                if (i4 > cVarArr.length) {
                    C1836c[] cVarArr2 = new C1836c[(cVarArr.length * 2)];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f2491d = this.f2490c.length - 1;
                    this.f2490c = cVarArr2;
                }
                int i5 = this.f2491d;
                this.f2491d = i5 - 1;
                this.f2490c[i5] = cVar;
                this.f2492e++;
            } else {
                this.f2490c[this.f2491d + 1 + i + b + i] = cVar;
            }
            this.f2493f += i2;
        }

        /* renamed from: b */
        private final int m2925b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f2490c.length;
                while (true) {
                    length--;
                    if (length < this.f2491d || i <= 0) {
                        C1836c[] cVarArr = this.f2490c;
                        int i3 = this.f2491d;
                        System.arraycopy(cVarArr, i3 + 1, cVarArr, i3 + 1 + i2, this.f2492e);
                        this.f2491d += i2;
                    } else {
                        C1836c cVar = this.f2490c[length];
                        if (cVar == null) {
                            Intrinsics.throwNpe();
                        }
                        int i4 = cVar.f2482a;
                        i -= i4;
                        this.f2493f -= i4;
                        this.f2492e--;
                        i2++;
                    }
                }
                C1836c[] cVarArr2 = this.f2490c;
                int i32 = this.f2491d;
                System.arraycopy(cVarArr2, i32 + 1, cVarArr2, i32 + 1 + i2, this.f2492e);
                this.f2491d += i2;
            }
            return i2;
        }

        /* renamed from: c */
        private final C2073i m2926c(int i) throws IOException {
            C1836c cVar;
            if (m2928d(i)) {
                cVar = C1837d.f2487c.mo27813b()[i];
            } else {
                int a = m2923a(i - C1837d.f2487c.mo27813b().length);
                if (a >= 0) {
                    C1836c[] cVarArr = this.f2490c;
                    if (a < cVarArr.length) {
                        cVar = cVarArr[a];
                        if (cVar == null) {
                            Intrinsics.throwNpe();
                        }
                    }
                }
                StringBuilder a2 = C0681a.m330a("Header index too large ");
                a2.append(i + 1);
                throw new IOException(a2.toString());
            }
            return cVar.f2483b;
        }

        /* renamed from: d */
        private final void m2927d() {
            ArraysKt___ArraysJvmKt.fill$default((Object[]) this.f2490c, (Object) null, 0, 0, 6, (Object) null);
            this.f2491d = this.f2490c.length - 1;
            this.f2492e = 0;
            this.f2493f = 0;
        }

        /* renamed from: d */
        private final boolean m2928d(int i) {
            return i >= 0 && i <= C1837d.f2487c.mo27813b().length - 1;
        }

        /* renamed from: a */
        public final List<C1836c> mo27815a() {
            List<C1836c> list = CollectionsKt___CollectionsKt.toList(this.f2488a);
            this.f2488a.clear();
            return list;
        }

        /* renamed from: b */
        public final C2073i mo27816b() throws IOException {
            int a = C1764b.m2604a(this.f2489b.readByte(), 255);
            boolean z = (a & 128) == 128;
            long a2 = (long) mo27814a(a, 127);
            if (!z) {
                return this.f2489b.mo29142a(a2);
            }
            C2068f fVar = new C2068f();
            C1867k.f2642d.mo27936a(this.f2489b, a2, (C2071g) fVar);
            return fVar.mo29169j();
        }

        /* renamed from: c */
        public final void mo27817c() throws IOException {
            while (!this.f2489b.mo29152c()) {
                int a = C1764b.m2604a(this.f2489b.readByte(), 255);
                if (a == 128) {
                    throw new IOException("index == 0");
                } else if ((a & 128) == 128) {
                    int a2 = mo27814a(a, 127) - 1;
                    if (m2928d(a2)) {
                        this.f2488a.add(C1837d.f2487c.mo27813b()[a2]);
                    } else {
                        int a3 = m2923a(a2 - C1837d.f2487c.mo27813b().length);
                        if (a3 >= 0) {
                            C1836c[] cVarArr = this.f2490c;
                            if (a3 < cVarArr.length) {
                                List<C1836c> list = this.f2488a;
                                C1836c cVar = cVarArr[a3];
                                if (cVar == null) {
                                    Intrinsics.throwNpe();
                                }
                                list.add(cVar);
                            }
                        }
                        StringBuilder a4 = C0681a.m330a("Header index too large ");
                        a4.append(a2 + 1);
                        throw new IOException(a4.toString());
                    }
                } else if (a == 64) {
                    C1837d dVar = C1837d.f2487c;
                    C2073i b = mo27816b();
                    dVar.mo27811a(b);
                    m2924a(-1, new C1836c(b, mo27816b()));
                } else if ((a & 64) == 64) {
                    m2924a(-1, new C1836c(m2926c(mo27814a(a, 63) - 1), mo27816b()));
                } else if ((a & 32) == 32) {
                    int a5 = mo27814a(a, 31);
                    this.f2495h = a5;
                    if (a5 < 0 || a5 > this.f2494g) {
                        StringBuilder a6 = C0681a.m330a("Invalid dynamic table size update ");
                        a6.append(this.f2495h);
                        throw new IOException(a6.toString());
                    }
                    int i = this.f2493f;
                    if (a5 < i) {
                        if (a5 == 0) {
                            m2927d();
                        } else {
                            m2925b(i - a5);
                        }
                    }
                } else if (a == 16 || a == 0) {
                    C1837d dVar2 = C1837d.f2487c;
                    C2073i b2 = mo27816b();
                    dVar2.mo27811a(b2);
                    this.f2488a.add(new C1836c(b2, mo27816b()));
                } else {
                    this.f2488a.add(new C1836c(m2926c(mo27814a(a, 15) - 1), mo27816b()));
                }
            }
        }

        /* renamed from: a */
        public final int mo27814a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int a = C1764b.m2604a(this.f2489b.readByte(), 255);
                if ((a & 128) == 0) {
                    return i2 + (a << i4);
                }
                i2 += (a & 127) << i4;
                i4 += 7;
            }
        }
    }
}
