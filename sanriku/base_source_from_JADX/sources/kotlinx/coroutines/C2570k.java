package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: kotlinx.coroutines.k */
public final class C2570k extends C2526c0<C1113f0> implements C1117j {
    @JvmField

    /* renamed from: e */
    public final C1118l f4211e;

    public C2570k(C1113f0 f0Var, C1118l lVar) {
        super(f0Var);
        this.f4211e = lVar;
    }

    /* renamed from: a */
    public boolean mo21870a(Throwable th) {
        return ((C1113f0) this.f4144d).mo21842a(th);
    }

    /* renamed from: b */
    public void mo21857b(Throwable th) {
        this.f4211e.mo21841a((C1119m0) this.f4144d);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        mo21857b((Throwable) obj);
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("ChildHandle[");
        a.append(this.f4211e);
        a.append(']');
        return a.toString();
    }
}
