package p040i.p103M.p107f;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1760K;
import p040i.C1912a;
import p040i.C1923f;
import p040i.C1943t;
import p040i.C1955z;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo21739d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "address", "Lokhttp3/Address;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "call", "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "inetSocketAddresses", "", "Ljava/net/InetSocketAddress;", "nextProxyIndex", "", "postponedRoutes", "", "Lokhttp3/Route;", "proxies", "Ljava/net/Proxy;", "hasNext", "", "hasNextProxy", "next", "Lokhttp3/internal/connection/RouteSelector$Selection;", "nextProxy", "resetNextInetSocketAddress", "", "proxy", "resetNextProxy", "url", "Lokhttp3/HttpUrl;", "Companion", "Selection", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.f.m */
public final class C1811m {

    /* renamed from: a */
    private List<? extends Proxy> f2406a = CollectionsKt__CollectionsKt.emptyList();

    /* renamed from: b */
    private int f2407b;

    /* renamed from: c */
    private List<? extends InetSocketAddress> f2408c = CollectionsKt__CollectionsKt.emptyList();

    /* renamed from: d */
    private final List<C1760K> f2409d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C1912a f2410e;

    /* renamed from: f */
    private final C1809k f2411f;

    /* renamed from: g */
    private final C1923f f2412g;

    /* renamed from: h */
    private final C1943t f2413h;

    /* renamed from: i.M.f.m$a */
    public static final class C1812a {

        /* renamed from: a */
        private int f2414a;

        /* renamed from: b */
        private final List<C1760K> f2415b;

        public C1812a(List<C1760K> list) {
            Intrinsics.checkParameterIsNotNull(list, "routes");
            this.f2415b = list;
        }

        /* renamed from: a */
        public final List<C1760K> mo27777a() {
            return this.f2415b;
        }

        /* renamed from: b */
        public final boolean mo27778b() {
            return this.f2414a < this.f2415b.size();
        }

        /* renamed from: c */
        public final C1760K mo27779c() {
            if (mo27778b()) {
                List<C1760K> list = this.f2415b;
                int i = this.f2414a;
                this.f2414a = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public C1811m(C1912a aVar, C1809k kVar, C1923f fVar, C1943t tVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "address");
        Intrinsics.checkParameterIsNotNull(kVar, "routeDatabase");
        Intrinsics.checkParameterIsNotNull(fVar, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(tVar, "eventListener");
        this.f2410e = aVar;
        this.f2411f = kVar;
        this.f2412g = fVar;
        this.f2413h = tVar;
        C1955z k = this.f2410e.mo28020k();
        C1813n nVar = new C1813n(this, this.f2410e.mo28014f(), k);
        C1943t tVar2 = this.f2413h;
        C1923f fVar2 = this.f2412g;
        if (tVar2 != null) {
            Intrinsics.checkParameterIsNotNull(fVar2, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkParameterIsNotNull(k, ImagesContract.URL);
            List<? extends Proxy> invoke = nVar.invoke();
            this.f2406a = invoke;
            this.f2407b = 0;
            C1943t tVar3 = this.f2413h;
            C1923f fVar3 = this.f2412g;
            if (tVar3 != null) {
                Intrinsics.checkParameterIsNotNull(fVar3, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(k, ImagesContract.URL);
                Intrinsics.checkParameterIsNotNull(invoke, "proxies");
                return;
            }
            throw null;
        }
        throw null;
    }

    /* renamed from: c */
    private final boolean m2852c() {
        return this.f2407b < this.f2406a.size();
    }

    /* renamed from: a */
    public final boolean mo27775a() {
        return m2852c() || (this.f2409d.isEmpty() ^ true);
    }

    /* renamed from: b */
    public final C1812a mo27776b() throws IOException {
        String str;
        int i;
        String str2;
        if (mo27775a()) {
            ArrayList arrayList = new ArrayList();
            while (m2852c()) {
                if (m2852c()) {
                    List<? extends Proxy> list = this.f2406a;
                    int i2 = this.f2407b;
                    this.f2407b = i2 + 1;
                    Proxy proxy = (Proxy) list.get(i2);
                    ArrayList arrayList2 = new ArrayList();
                    this.f2408c = arrayList2;
                    if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                        str = this.f2410e.mo28020k().mo28138f();
                        i = this.f2410e.mo28020k().mo28143j();
                    } else {
                        SocketAddress address = proxy.address();
                        if (address instanceof InetSocketAddress) {
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                            Intrinsics.checkParameterIsNotNull(inetSocketAddress, "$this$socketHost");
                            InetAddress address2 = inetSocketAddress.getAddress();
                            if (address2 != null) {
                                str = address2.getHostAddress();
                                str2 = "address.hostAddress";
                            } else {
                                str = inetSocketAddress.getHostName();
                                str2 = "hostName";
                            }
                            Intrinsics.checkExpressionValueIsNotNull(str, str2);
                            i = inetSocketAddress.getPort();
                        } else {
                            StringBuilder a = C0681a.m330a("Proxy.address() is not an InetSocketAddress: ");
                            a.append(address.getClass());
                            throw new IllegalArgumentException(a.toString().toString());
                        }
                    }
                    if (1 <= i && 65535 >= i) {
                        if (proxy.type() == Proxy.Type.SOCKS) {
                            arrayList2.add(InetSocketAddress.createUnresolved(str, i));
                        } else {
                            C1943t tVar = this.f2413h;
                            C1923f fVar = this.f2412g;
                            if (tVar != null) {
                                Intrinsics.checkParameterIsNotNull(fVar, NotificationCompat.CATEGORY_CALL);
                                Intrinsics.checkParameterIsNotNull(str, "domainName");
                                List<InetAddress> a2 = this.f2410e.mo28010c().mo28100a(str);
                                if (!a2.isEmpty()) {
                                    C1943t tVar2 = this.f2413h;
                                    C1923f fVar2 = this.f2412g;
                                    if (tVar2 != null) {
                                        Intrinsics.checkParameterIsNotNull(fVar2, NotificationCompat.CATEGORY_CALL);
                                        Intrinsics.checkParameterIsNotNull(str, "domainName");
                                        Intrinsics.checkParameterIsNotNull(a2, "inetAddressList");
                                        for (InetAddress inetSocketAddress2 : a2) {
                                            arrayList2.add(new InetSocketAddress(inetSocketAddress2, i));
                                        }
                                    } else {
                                        throw null;
                                    }
                                } else {
                                    throw new UnknownHostException(this.f2410e.mo28010c() + " returned no addresses for " + str);
                                }
                            } else {
                                throw null;
                            }
                        }
                        for (InetSocketAddress k : this.f2408c) {
                            C1760K k2 = new C1760K(this.f2410e, proxy, k);
                            if (this.f2411f.mo27771c(k2)) {
                                this.f2409d.add(k2);
                            } else {
                                arrayList.add(k2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            break;
                        }
                    } else {
                        throw new SocketException("No route to " + str + ':' + i + "; port is out of range");
                    }
                } else {
                    StringBuilder a3 = C0681a.m330a("No route to ");
                    a3.append(this.f2410e.mo28020k().mo28138f());
                    a3.append("; exhausted proxy configurations: ");
                    a3.append(this.f2406a);
                    throw new SocketException(a3.toString());
                }
            }
            if (arrayList.isEmpty()) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.f2409d);
                this.f2409d.clear();
            }
            return new C1812a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
