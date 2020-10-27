package p122k.p123a.p124a.p125a;

import p122k.p123a.p124a.p125a.p128G.C2440i;

/* renamed from: k.a.a.a.u */
public class C2473u extends RuntimeException {

    /* renamed from: a */
    private final C2474v<?, ?> f4062a;

    /* renamed from: b */
    private final C2476w f4063b;

    /* renamed from: c */
    private final C2465n f4064c;

    /* renamed from: d */
    private C2477x f4065d;

    /* renamed from: e */
    private int f4066e = -1;

    public C2473u(String str, C2474v<?, ?> vVar, C2465n nVar, C2471s sVar) {
        super(str);
        this.f4062a = vVar;
        this.f4064c = nVar;
        this.f4063b = sVar;
        if (vVar != null) {
            this.f4066e = vVar.mo34352i();
        }
    }

    public C2473u(C2474v<?, ?> vVar, C2465n nVar, C2471s sVar) {
        this.f4062a = vVar;
        this.f4064c = nVar;
        this.f4063b = sVar;
        if (vVar != null) {
            this.f4066e = vVar.mo34352i();
        }
    }

    /* renamed from: a */
    public C2440i mo34345a() {
        C2474v<?, ?> vVar = this.f4062a;
        if (vVar != null) {
            return vVar.mo20159f().mo34113a(this.f4066e, this.f4063b);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo34346a(C2477x xVar) {
        this.f4065d = xVar;
    }

    /* renamed from: b */
    public C2465n mo34347b() {
        return this.f4064c;
    }

    /* renamed from: c */
    public C2477x mo34348c() {
        return this.f4065d;
    }
}
