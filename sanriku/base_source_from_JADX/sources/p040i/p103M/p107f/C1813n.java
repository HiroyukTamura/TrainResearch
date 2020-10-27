package p040i.p103M.p107f;

import java.net.Proxy;
import java.net.URI;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p040i.C1955z;
import p040i.p103M.C1764b;

/* renamed from: i.M.f.n */
final class C1813n extends Lambda implements Function0<List<? extends Proxy>> {

    /* renamed from: a */
    final /* synthetic */ C1811m f2416a;

    /* renamed from: b */
    final /* synthetic */ Proxy f2417b;

    /* renamed from: c */
    final /* synthetic */ C1955z f2418c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1813n(C1811m mVar, Proxy proxy, C1955z zVar) {
        super(0);
        this.f2416a = mVar;
        this.f2417b = proxy;
        this.f2418c = zVar;
    }

    public final List<Proxy> invoke() {
        Proxy proxy = this.f2417b;
        if (proxy != null) {
            return CollectionsKt__CollectionsJVMKt.listOf(proxy);
        }
        URI n = this.f2418c.mo28147n();
        if (n.getHost() == null) {
            return C1764b.m2624a((T[]) new Proxy[]{Proxy.NO_PROXY});
        }
        List<Proxy> select = this.f2416a.f2410e.mo28016h().select(n);
        if (!(select == null || select.isEmpty())) {
            return C1764b.m2639b(select);
        }
        return C1764b.m2624a((T[]) new Proxy[]{Proxy.NO_PROXY});
    }
}
