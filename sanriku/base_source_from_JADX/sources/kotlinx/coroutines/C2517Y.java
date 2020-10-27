package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.Y */
final class C2517Y extends C2526c0<C1111a0> {

    /* renamed from: f */
    private static final AtomicIntegerFieldUpdater f4131f = AtomicIntegerFieldUpdater.newUpdater(C2517Y.class, "_invoked");
    private volatile int _invoked = 0;

    /* renamed from: e */
    private final Function1<Throwable, Unit> f4132e;

    public C2517Y(C1111a0 a0Var, Function1<? super Throwable, Unit> function1) {
        super(a0Var);
        this.f4132e = function1;
    }

    /* renamed from: b */
    public void mo21857b(Throwable th) {
        if (f4131f.compareAndSet(this, 0, 1)) {
            this.f4132e.invoke(th);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        mo21857b((Throwable) obj);
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("InvokeOnCancelling[");
        a.append(C2517Y.class.getSimpleName());
        a.append('@');
        a.append(C1532a.m2147b(this));
        a.append(']');
        return a.toString();
    }
}
