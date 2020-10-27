package p009e.p028d.p030b.p031a.p032i.p035u;

import p009e.p028d.p030b.p031a.C0881h;
import p009e.p028d.p030b.p031a.p032i.C0896g;
import p009e.p028d.p030b.p031a.p032i.C0903k;

/* renamed from: e.d.b.a.i.u.a */
final /* synthetic */ class C0916a implements Runnable {

    /* renamed from: a */
    private final C0918c f598a;

    /* renamed from: b */
    private final C0903k f599b;

    /* renamed from: c */
    private final C0881h f600c;

    /* renamed from: d */
    private final C0896g f601d;

    private C0916a(C0918c cVar, C0903k kVar, C0881h hVar, C0896g gVar) {
        this.f598a = cVar;
        this.f599b = kVar;
        this.f600c = hVar;
        this.f601d = gVar;
    }

    /* renamed from: a */
    public static Runnable m1253a(C0918c cVar, C0903k kVar, C0881h hVar, C0896g gVar) {
        return new C0916a(cVar, kVar, hVar, gVar);
    }

    public void run() {
        C0918c.m1256a(this.f598a, this.f599b, this.f600c, this.f601d);
    }
}
