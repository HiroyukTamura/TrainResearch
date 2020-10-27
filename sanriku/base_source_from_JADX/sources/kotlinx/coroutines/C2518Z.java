package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.Z */
final class C2518Z extends C2530e0<C1111a0> {

    /* renamed from: e */
    private final Function1<Throwable, Unit> f4133e;

    public C2518Z(C1111a0 a0Var, Function1<? super Throwable, Unit> function1) {
        super(a0Var);
        this.f4133e = function1;
    }

    /* renamed from: b */
    public void mo21857b(Throwable th) {
        this.f4133e.invoke(th);
    }

    public Object invoke(Object obj) {
        this.f4133e.invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("InvokeOnCompletion[");
        a.append(C2518Z.class.getSimpleName());
        a.append('@');
        a.append(C1532a.m2147b(this));
        a.append(']');
        return a.toString();
    }
}
