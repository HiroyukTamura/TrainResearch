package p122k.p123a.p124a.p125a.p126E;

import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: k.a.a.a.E.u */
public class C2418u extends C2389b {

    /* renamed from: f */
    private final C2422x f3935f;

    /* renamed from: g */
    private final boolean f3936g;

    public C2418u(C2403g gVar, int i, C2371Q q) {
        super(gVar, i, q, C2380Y.f3865a);
        this.f3936g = false;
        this.f3935f = null;
    }

    public C2418u(C2418u uVar, C2403g gVar) {
        super((C2389b) uVar, gVar, uVar.f3886c, uVar.f3888e);
        this.f3935f = uVar.f3935f;
        this.f3936g = m4103a(uVar, gVar);
    }

    public C2418u(C2418u uVar, C2403g gVar, C2371Q q) {
        super((C2389b) uVar, gVar, q, uVar.f3888e);
        this.f3935f = uVar.f3935f;
        this.f3936g = m4103a(uVar, gVar);
    }

    public C2418u(C2418u uVar, C2403g gVar, C2422x xVar) {
        super((C2389b) uVar, gVar, uVar.f3886c, uVar.f3888e);
        this.f3935f = xVar;
        this.f3936g = m4103a(uVar, gVar);
    }

    /* renamed from: a */
    private static boolean m4103a(C2418u uVar, C2403g gVar) {
        return uVar.f3936g || ((gVar instanceof C2414q) && ((C2414q) gVar).f3932h);
    }

    /* renamed from: a */
    public boolean mo34119a(C2389b bVar) {
        boolean z = true;
        if (this == bVar) {
            return true;
        }
        if (!(bVar instanceof C2418u)) {
            return false;
        }
        C2418u uVar = (C2418u) bVar;
        if (this.f3936g != uVar.f3936g) {
            return false;
        }
        C2422x xVar = this.f3935f;
        C2422x xVar2 = uVar.f3935f;
        if (xVar != null) {
            z = xVar.equals(xVar2);
        } else if (xVar2 != null) {
            z = false;
        }
        if (!z) {
            return false;
        }
        return super.mo34119a(bVar);
    }

    /* renamed from: c */
    public final C2422x mo34166c() {
        return this.f3935f;
    }

    /* renamed from: d */
    public final boolean mo34167d() {
        return this.f3936g;
    }

    public int hashCode() {
        return C1532a.m2119a(C1532a.m2120a(C1532a.m2145b(C1532a.m2120a(C1532a.m2120a(C1532a.m2145b(C1532a.m2145b(7, this.f3884a.f3916b), this.f3885b), (Object) this.f3886c), (Object) this.f3888e), this.f3936g ? 1 : 0), (Object) this.f3935f), 6);
    }
}
