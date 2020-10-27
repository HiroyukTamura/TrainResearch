package p040i;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1955z;
import p040i.p103M.C1764b;

/* renamed from: i.a */
public final class C1912a {

    /* renamed from: a */
    private final C1955z f2708a;

    /* renamed from: b */
    private final List<C0974E> f2709b;

    /* renamed from: c */
    private final List<C1936m> f2710c;

    /* renamed from: d */
    private final C1942s f2711d;

    /* renamed from: e */
    private final SocketFactory f2712e;

    /* renamed from: f */
    private final SSLSocketFactory f2713f;

    /* renamed from: g */
    private final HostnameVerifier f2714g;

    /* renamed from: h */
    private final C1926h f2715h;

    /* renamed from: i */
    private final C1914c f2716i;

    /* renamed from: j */
    private final Proxy f2717j;

    /* renamed from: k */
    private final ProxySelector f2718k;

    public C1912a(String str, int i, C1942s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C1926h hVar, C1914c cVar, Proxy proxy, List<? extends C0974E> list, List<C1936m> list2, ProxySelector proxySelector) {
        Intrinsics.checkParameterIsNotNull(str, "uriHost");
        Intrinsics.checkParameterIsNotNull(sVar, "dns");
        Intrinsics.checkParameterIsNotNull(socketFactory, "socketFactory");
        Intrinsics.checkParameterIsNotNull(cVar, "proxyAuthenticator");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        Intrinsics.checkParameterIsNotNull(list2, "connectionSpecs");
        Intrinsics.checkParameterIsNotNull(proxySelector, "proxySelector");
        this.f2711d = sVar;
        this.f2712e = socketFactory;
        this.f2713f = sSLSocketFactory;
        this.f2714g = hostnameVerifier;
        this.f2715h = hVar;
        this.f2716i = cVar;
        this.f2717j = proxy;
        this.f2718k = proxySelector;
        C1955z.C1956a aVar = new C1955z.C1956a();
        aVar.mo28161d(this.f2713f != null ? "https" : "http");
        aVar.mo28155b(str);
        aVar.mo28150a(i);
        this.f2708a = aVar.mo28154a();
        this.f2709b = C1764b.m2639b(list);
        this.f2710c = C1764b.m2639b(list2);
    }

    @JvmName(name = "certificatePinner")
    /* renamed from: a */
    public final C1926h mo28007a() {
        return this.f2715h;
    }

    /* renamed from: a */
    public final boolean mo28008a(C1912a aVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "that");
        return Intrinsics.areEqual((Object) this.f2711d, (Object) aVar.f2711d) && Intrinsics.areEqual((Object) this.f2716i, (Object) aVar.f2716i) && Intrinsics.areEqual((Object) this.f2709b, (Object) aVar.f2709b) && Intrinsics.areEqual((Object) this.f2710c, (Object) aVar.f2710c) && Intrinsics.areEqual((Object) this.f2718k, (Object) aVar.f2718k) && Intrinsics.areEqual((Object) this.f2717j, (Object) aVar.f2717j) && Intrinsics.areEqual((Object) this.f2713f, (Object) aVar.f2713f) && Intrinsics.areEqual((Object) this.f2714g, (Object) aVar.f2714g) && Intrinsics.areEqual((Object) this.f2715h, (Object) aVar.f2715h) && this.f2708a.mo28143j() == aVar.f2708a.mo28143j();
    }

    @JvmName(name = "connectionSpecs")
    /* renamed from: b */
    public final List<C1936m> mo28009b() {
        return this.f2710c;
    }

    @JvmName(name = "dns")
    /* renamed from: c */
    public final C1942s mo28010c() {
        return this.f2711d;
    }

    @JvmName(name = "hostnameVerifier")
    /* renamed from: d */
    public final HostnameVerifier mo28011d() {
        return this.f2714g;
    }

    @JvmName(name = "protocols")
    /* renamed from: e */
    public final List<C0974E> mo28012e() {
        return this.f2709b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1912a) {
            C1912a aVar = (C1912a) obj;
            return Intrinsics.areEqual((Object) this.f2708a, (Object) aVar.f2708a) && mo28008a(aVar);
        }
    }

    @JvmName(name = "proxy")
    /* renamed from: f */
    public final Proxy mo28014f() {
        return this.f2717j;
    }

    @JvmName(name = "proxyAuthenticator")
    /* renamed from: g */
    public final C1914c mo28015g() {
        return this.f2716i;
    }

    @JvmName(name = "proxySelector")
    /* renamed from: h */
    public final ProxySelector mo28016h() {
        return this.f2718k;
    }

    public int hashCode() {
        int hashCode = this.f2711d.hashCode();
        int hashCode2 = this.f2716i.hashCode();
        int hashCode3 = this.f2709b.hashCode();
        int hashCode4 = this.f2710c.hashCode();
        int hashCode5 = this.f2718k.hashCode();
        int hashCode6 = Objects.hashCode(this.f2717j);
        int hashCode7 = Objects.hashCode(this.f2713f);
        int hashCode8 = Objects.hashCode(this.f2714g);
        return Objects.hashCode(this.f2715h) + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((this.f2708a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @JvmName(name = "socketFactory")
    /* renamed from: i */
    public final SocketFactory mo28018i() {
        return this.f2712e;
    }

    @JvmName(name = "sslSocketFactory")
    /* renamed from: j */
    public final SSLSocketFactory mo28019j() {
        return this.f2713f;
    }

    @JvmName(name = "url")
    /* renamed from: k */
    public final C1955z mo28020k() {
        return this.f2708a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb;
        StringBuilder a = C0681a.m330a("Address{");
        a.append(this.f2708a.mo28138f());
        a.append(':');
        a.append(this.f2708a.mo28143j());
        a.append(", ");
        if (this.f2717j != null) {
            sb = C0681a.m330a("proxy=");
            obj = this.f2717j;
        } else {
            sb = C0681a.m330a("proxySelector=");
            obj = this.f2718k;
        }
        sb.append(obj);
        a.append(sb.toString());
        a.append("}");
        return a.toString();
    }
}
