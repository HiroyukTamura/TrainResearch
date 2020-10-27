package p040i;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: i.K */
public final class C1760K {

    /* renamed from: a */
    private final C1912a f2203a;

    /* renamed from: b */
    private final Proxy f2204b;

    /* renamed from: c */
    private final InetSocketAddress f2205c;

    public C1760K(C1912a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Intrinsics.checkParameterIsNotNull(aVar, "address");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "socketAddress");
        this.f2203a = aVar;
        this.f2204b = proxy;
        this.f2205c = inetSocketAddress;
    }

    @JvmName(name = "address")
    /* renamed from: a */
    public final C1912a mo27588a() {
        return this.f2203a;
    }

    @JvmName(name = "proxy")
    /* renamed from: b */
    public final Proxy mo27589b() {
        return this.f2204b;
    }

    /* renamed from: c */
    public final boolean mo27590c() {
        return this.f2203a.mo28019j() != null && this.f2204b.type() == Proxy.Type.HTTP;
    }

    @JvmName(name = "socketAddress")
    /* renamed from: d */
    public final InetSocketAddress mo27591d() {
        return this.f2205c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1760K) {
            C1760K k = (C1760K) obj;
            return Intrinsics.areEqual((Object) k.f2203a, (Object) this.f2203a) && Intrinsics.areEqual((Object) k.f2204b, (Object) this.f2204b) && Intrinsics.areEqual((Object) k.f2205c, (Object) this.f2205c);
        }
    }

    public int hashCode() {
        int hashCode = this.f2204b.hashCode();
        return this.f2205c.hashCode() + ((hashCode + ((this.f2203a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Route{");
        a.append(this.f2205c);
        a.append('}');
        return a.toString();
    }
}
