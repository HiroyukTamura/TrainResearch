package p009e.p015c.p016a.p017a.p018a.p024s;

import p009e.p015c.p016a.p017a.p018a.p024s.C0734d;

/* renamed from: e.c.a.a.a.s.c */
class C0733c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f423a;

    /* renamed from: b */
    final /* synthetic */ C0734d.C0736b f424b;

    /* renamed from: c */
    final /* synthetic */ C0734d.C0735a f425c;

    /* renamed from: d */
    final /* synthetic */ C0734d f426d;

    C0733c(C0734d dVar, int i, C0734d.C0736b bVar, C0734d.C0735a aVar) {
        this.f426d = dVar;
        this.f423a = i;
        this.f424b = bVar;
        this.f425c = aVar;
    }

    public void run() {
        this.f426d.mo19951a("%s step #%d", "downgrade", Integer.valueOf(this.f423a));
        this.f424b.mo19958a(this.f425c);
    }
}
