package p009e.p028d.p030b.p031a.p032i;

import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.C0876c;
import p009e.p028d.p030b.p031a.C0878e;
import p009e.p028d.p030b.p031a.C0879f;
import p009e.p028d.p030b.p031a.C0881h;
import p009e.p028d.p030b.p031a.p032i.C0885b;

/* renamed from: e.d.b.a.i.n */
final class C0907n<T> implements C0879f<T> {

    /* renamed from: a */
    private final C0903k f583a;

    /* renamed from: b */
    private final String f584b;

    /* renamed from: c */
    private final C0875b f585c;

    /* renamed from: d */
    private final C0878e<T, byte[]> f586d;

    /* renamed from: e */
    private final C0908o f587e;

    C0907n(C0903k kVar, String str, C0875b bVar, C0878e<T, byte[]> eVar, C0908o oVar) {
        this.f583a = kVar;
        this.f584b = str;
        this.f585c = bVar;
        this.f586d = eVar;
        this.f587e = oVar;
    }

    public void schedule(C0876c<T> cVar, C0881h hVar) {
        C0908o oVar = this.f587e;
        C0885b.C0887b bVar = new C0885b.C0887b();
        bVar.mo20318a(this.f583a);
        bVar.mo20316a((C0876c<?>) cVar);
        bVar.mo20319a(this.f584b);
        bVar.mo20317a((C0878e<?, byte[]>) this.f586d);
        bVar.mo20315a(this.f585c);
        ((C0909p) oVar).mo20352a(bVar.mo20320a(), hVar);
    }

    public void send(C0876c<T> cVar) {
        schedule(cVar, C0906m.m1239a());
    }
}
