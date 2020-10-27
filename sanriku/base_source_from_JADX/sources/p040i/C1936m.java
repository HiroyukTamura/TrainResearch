package p040i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1931j;
import p040i.p103M.C1764b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007¢\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0015J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b J\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bH\u0007¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\rR\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006%"}, mo21739d2 = {"Lokhttp3/ConnectionSpec;", "", "isTls", "", "supportsTlsExtensions", "cipherSuitesAsString", "", "", "tlsVersionsAsString", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "cipherSuites", "", "Lokhttp3/CipherSuite;", "()Ljava/util/List;", "[Ljava/lang/String;", "()Z", "tlsVersions", "Lokhttp3/TlsVersion;", "apply", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "-deprecated_cipherSuites", "equals", "other", "hashCode", "", "isCompatible", "socket", "supportedSpec", "-deprecated_supportsTlsExtensions", "-deprecated_tlsVersions", "toString", "Builder", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.m */
public final class C1936m {

    /* renamed from: e */
    private static final C1931j[] f2804e = {C1931j.f2798q, C1931j.f2799r, C1931j.f2800s, C1931j.f2792k, C1931j.f2794m, C1931j.f2793l, C1931j.f2795n, C1931j.f2797p, C1931j.f2796o};

    /* renamed from: f */
    private static final C1931j[] f2805f = {C1931j.f2798q, C1931j.f2799r, C1931j.f2800s, C1931j.f2792k, C1931j.f2794m, C1931j.f2793l, C1931j.f2795n, C1931j.f2797p, C1931j.f2796o, C1931j.f2790i, C1931j.f2791j, C1931j.f2788g, C1931j.f2789h, C1931j.f2786e, C1931j.f2787f, C1931j.f2785d};
    @JvmField

    /* renamed from: g */
    public static final C1936m f2806g;
    @JvmField

    /* renamed from: h */
    public static final C1936m f2807h = new C0984a(false).mo20426a();

    /* renamed from: a */
    private final boolean f2808a;

    /* renamed from: b */
    private final boolean f2809b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String[] f2810c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String[] f2811d;

    /* renamed from: i.m$a */
    public static final class C0984a {

        /* renamed from: a */
        private boolean f714a;

        /* renamed from: b */
        private String[] f715b;

        /* renamed from: c */
        private String[] f716c;

        /* renamed from: d */
        private boolean f717d;

        public C0984a(C1936m mVar) {
            Intrinsics.checkParameterIsNotNull(mVar, "connectionSpec");
            this.f714a = mVar.mo28081b();
            this.f715b = mVar.f2810c;
            this.f716c = mVar.f2811d;
            this.f717d = mVar.mo28082c();
        }

        public C0984a(boolean z) {
            this.f714a = z;
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        /* renamed from: a */
        public final C0984a mo20422a(boolean z) {
            if (this.f714a) {
                this.f717d = z;
                return this;
            }
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }

        /* renamed from: a */
        public final C0984a mo20423a(C1761L... lArr) {
            Intrinsics.checkParameterIsNotNull(lArr, "tlsVersions");
            if (this.f714a) {
                ArrayList arrayList = new ArrayList(lArr.length);
                for (C1761L a : lArr) {
                    arrayList.add(a.mo27595a());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    mo20427b((String[]) Arrays.copyOf(strArr, strArr.length));
                    return this;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        /* renamed from: a */
        public final C0984a mo20424a(C1931j... jVarArr) {
            Intrinsics.checkParameterIsNotNull(jVarArr, "cipherSuites");
            if (this.f714a) {
                ArrayList arrayList = new ArrayList(jVarArr.length);
                for (C1931j a : jVarArr) {
                    arrayList.add(a.mo28073a());
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    mo20425a((String[]) Arrays.copyOf(strArr, strArr.length));
                    return this;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        /* renamed from: a */
        public final C0984a mo20425a(String... strArr) {
            Intrinsics.checkParameterIsNotNull(strArr, "cipherSuites");
            if (this.f714a) {
                if (!(strArr.length == 0)) {
                    Object clone = strArr.clone();
                    if (clone != null) {
                        this.f715b = (String[]) clone;
                        return this;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        /* renamed from: a */
        public final C1936m mo20426a() {
            return new C1936m(this.f714a, this.f717d, this.f715b, this.f716c);
        }

        /* renamed from: b */
        public final C0984a mo20427b(String... strArr) {
            Intrinsics.checkParameterIsNotNull(strArr, "tlsVersions");
            if (this.f714a) {
                if (!(strArr.length == 0)) {
                    Object clone = strArr.clone();
                    if (clone != null) {
                        this.f716c = (String[]) clone;
                        return this;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
    }

    static {
        C0984a aVar = new C0984a(true);
        C1931j[] jVarArr = f2804e;
        aVar.mo20424a((C1931j[]) Arrays.copyOf(jVarArr, jVarArr.length));
        aVar.mo20423a(C1761L.TLS_1_3, C1761L.TLS_1_2);
        aVar.mo20422a(true);
        aVar.mo20426a();
        C0984a aVar2 = new C0984a(true);
        C1931j[] jVarArr2 = f2805f;
        aVar2.mo20424a((C1931j[]) Arrays.copyOf(jVarArr2, jVarArr2.length));
        aVar2.mo20423a(C1761L.TLS_1_3, C1761L.TLS_1_2);
        aVar2.mo20422a(true);
        f2806g = aVar2.mo20426a();
        C0984a aVar3 = new C0984a(true);
        C1931j[] jVarArr3 = f2805f;
        aVar3.mo20424a((C1931j[]) Arrays.copyOf(jVarArr3, jVarArr3.length));
        aVar3.mo20423a(C1761L.TLS_1_3, C1761L.TLS_1_2, C1761L.TLS_1_1, C1761L.TLS_1_0);
        aVar3.mo20422a(true);
        aVar3.mo20426a();
    }

    public C1936m(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.f2808a = z;
        this.f2809b = z2;
        this.f2810c = strArr;
        this.f2811d = strArr2;
    }

    @JvmName(name = "cipherSuites")
    /* renamed from: a */
    public final List<C1931j> mo28078a() {
        String[] strArr = this.f2810c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a : strArr) {
            arrayList.add(C1931j.f2801t.mo28076a(a));
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    /* renamed from: a */
    public final void mo28079a(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (this.f2810c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            Intrinsics.checkExpressionValueIsNotNull(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            String[] strArr3 = this.f2810c;
            C1931j.C1933b bVar = C1931j.f2801t;
            strArr = C1764b.m2641b(enabledCipherSuites, strArr3, (Comparator<? super String>) C1931j.f2783b);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f2811d != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            Intrinsics.checkExpressionValueIsNotNull(enabledProtocols, "sslSocket.enabledProtocols");
            strArr2 = C1764b.m2641b(enabledProtocols, this.f2811d, (Comparator<? super String>) ComparisonsKt__ComparisonsKt.naturalOrder());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        Intrinsics.checkExpressionValueIsNotNull(supportedCipherSuites, "supportedCipherSuites");
        C1931j.C1933b bVar2 = C1931j.f2801t;
        int a = C1764b.m2615a(supportedCipherSuites, "TLS_FALLBACK_SCSV", (Comparator<String>) C1931j.f2783b);
        if (z && a != -1) {
            Intrinsics.checkExpressionValueIsNotNull(strArr, "cipherSuitesIntersection");
            String str = supportedCipherSuites[a];
            Intrinsics.checkExpressionValueIsNotNull(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Intrinsics.checkParameterIsNotNull(strArr, "$this$concat");
            Intrinsics.checkParameterIsNotNull(str, "value");
            Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            strArr = (String[]) copyOf;
            strArr[ArraysKt___ArraysKt.getLastIndex((T[]) strArr)] = str;
        }
        C0984a aVar = new C0984a(this);
        Intrinsics.checkExpressionValueIsNotNull(strArr, "cipherSuitesIntersection");
        aVar.mo20425a((String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkExpressionValueIsNotNull(strArr2, "tlsVersionsIntersection");
        aVar.mo20427b((String[]) Arrays.copyOf(strArr2, strArr2.length));
        C1936m a2 = aVar.mo20426a();
        if (a2.mo28083d() != null) {
            sSLSocket.setEnabledProtocols(a2.f2811d);
        }
        if (a2.mo28078a() != null) {
            sSLSocket.setEnabledCipherSuites(a2.f2810c);
        }
    }

    @JvmName(name = "isTls")
    /* renamed from: b */
    public final boolean mo28081b() {
        return this.f2808a;
    }

    @JvmName(name = "supportsTlsExtensions")
    /* renamed from: c */
    public final boolean mo28082c() {
        return this.f2809b;
    }

    @JvmName(name = "tlsVersions")
    /* renamed from: d */
    public final List<C1761L> mo28083d() {
        String[] strArr = this.f2811d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a : strArr) {
            arrayList.add(C1761L.f2211g.mo27596a(a));
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1936m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.f2808a;
        C1936m mVar = (C1936m) obj;
        if (z != mVar.f2808a) {
            return false;
        }
        return !z || (Arrays.equals(this.f2810c, mVar.f2810c) && Arrays.equals(this.f2811d, mVar.f2811d) && this.f2809b == mVar.f2809b);
    }

    public int hashCode() {
        if (!this.f2808a) {
            return 17;
        }
        String[] strArr = this.f2810c;
        int i = 0;
        int hashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f2811d;
        if (strArr2 != null) {
            i = Arrays.hashCode(strArr2);
        }
        return ((hashCode + i) * 31) + (this.f2809b ^ true ? 1 : 0);
    }

    public String toString() {
        if (!this.f2808a) {
            return "ConnectionSpec()";
        }
        StringBuilder c = C0681a.m340c("ConnectionSpec(", "cipherSuites=");
        c.append(Objects.toString(mo28078a(), "[all enabled]"));
        c.append(", ");
        c.append("tlsVersions=");
        c.append(Objects.toString(mo28083d(), "[all enabled]"));
        c.append(", ");
        c.append("supportsTlsExtensions=");
        c.append(this.f2809b);
        c.append(')');
        return c.toString();
    }

    /* renamed from: a */
    public final boolean mo28080a(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "socket");
        if (!this.f2808a) {
            return false;
        }
        String[] strArr = this.f2811d;
        if (strArr != null && !C1764b.m2635a(strArr, sSLSocket.getEnabledProtocols(), (Comparator<? super String>) ComparisonsKt__ComparisonsKt.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.f2810c;
        if (strArr2 == null) {
            return true;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        C1931j.C1933b bVar = C1931j.f2801t;
        if (!C1764b.m2635a(strArr2, enabledCipherSuites, (Comparator<? super String>) C1931j.f2783b)) {
            return false;
        }
        return true;
    }
}
