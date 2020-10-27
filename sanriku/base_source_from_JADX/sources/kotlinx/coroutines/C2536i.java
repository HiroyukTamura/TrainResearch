package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: kotlinx.coroutines.i */
public final class C2536i extends C2526c0<C1111a0> {
    @JvmField

    /* renamed from: e */
    public final C2532g<?> f4158e;

    public C2536i(C1111a0 a0Var, C2532g<?> gVar) {
        super(a0Var);
        this.f4158e = gVar;
    }

    /* renamed from: b */
    public void mo21857b(Throwable th) {
        C2532g<?> gVar = this.f4158e;
        J j = this.f4144d;
        if (gVar != null) {
            gVar.mo35545b(j.mo21833h());
            return;
        }
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        mo21857b((Throwable) obj);
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("ChildContinuation[");
        a.append(this.f4158e);
        a.append(']');
        return a.toString();
    }
}
