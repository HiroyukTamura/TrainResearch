package p009e.p028d.p030b.p031a.p032i;

import java.util.Set;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.C0878e;
import p009e.p028d.p030b.p031a.C0879f;
import p009e.p028d.p030b.p031a.C0880g;

/* renamed from: e.d.b.a.i.l */
final class C0905l implements C0880g {

    /* renamed from: a */
    private final Set<C0875b> f579a;

    /* renamed from: b */
    private final C0903k f580b;

    /* renamed from: c */
    private final C0908o f581c;

    C0905l(Set<C0875b> set, C0903k kVar, C0908o oVar) {
        this.f579a = set;
        this.f580b = kVar;
        this.f581c = oVar;
    }

    public <T> C0879f<T> getTransport(String str, Class<T> cls, C0875b bVar, C0878e<T, byte[]> eVar) {
        if (this.f579a.contains(bVar)) {
            return new C0907n(this.f580b, str, bVar, eVar, this.f581c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{bVar, this.f579a}));
    }
}
