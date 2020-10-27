package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.X */
final class C2516X extends C2529e {

    /* renamed from: a */
    private final Function1<Throwable, Unit> f4130a;

    public C2516X(Function1<? super Throwable, Unit> function1) {
        this.f4130a = function1;
    }

    /* renamed from: a */
    public void mo35527a(Throwable th) {
        this.f4130a.invoke(th);
    }

    public Object invoke(Object obj) {
        this.f4130a.invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("InvokeOnCancel[");
        a.append(C1532a.m2129a((Object) this.f4130a));
        a.append('@');
        a.append(C1532a.m2147b(this));
        a.append(']');
        return a.toString();
    }
}
