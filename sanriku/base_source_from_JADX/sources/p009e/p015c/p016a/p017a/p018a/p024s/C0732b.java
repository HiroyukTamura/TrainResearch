package p009e.p015c.p016a.p017a.p018a.p024s;

import p009e.p015c.p016a.p017a.p018a.p024s.C0734d;

/* renamed from: e.c.a.a.a.s.b */
class C0732b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f419a;

    /* renamed from: b */
    final /* synthetic */ C0734d.C0736b f420b;

    /* renamed from: c */
    final /* synthetic */ C0734d.C0735a f421c;

    /* renamed from: d */
    final /* synthetic */ C0734d f422d;

    C0732b(C0734d dVar, int i, C0734d.C0736b bVar, C0734d.C0735a aVar) {
        this.f422d = dVar;
        this.f419a = i;
        this.f420b = bVar;
        this.f421c = aVar;
    }

    public void run() {
        this.f422d.mo19951a("%s step #%d", "upgrade", Integer.valueOf(this.f419a));
        this.f420b.mo19959b(this.f421c);
    }
}
