package p040i.p103M.p105d;

import kotlin.Unit;
import p040i.p103M.p105d.C1775e;
import p042j.C1015k;
import p042j.C1016z;

/* renamed from: i.M.d.f */
public final class C1782f extends C1015k {

    /* renamed from: a */
    private boolean f2293a;

    /* renamed from: b */
    final /* synthetic */ C1775e.C1778b f2294b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1782f(C1775e.C1778b bVar, C1016z zVar, C1016z zVar2) {
        super(zVar2);
        this.f2294b = bVar;
    }

    public void close() {
        super.close();
        if (!this.f2293a) {
            this.f2293a = true;
            synchronized (this.f2294b.f2286j) {
                C1775e.C1778b bVar = this.f2294b;
                bVar.mo27627a(bVar.mo27638f() - 1);
                if (this.f2294b.mo27638f() == 0 && this.f2294b.mo27641i()) {
                    this.f2294b.f2286j.mo27607a(this.f2294b);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
