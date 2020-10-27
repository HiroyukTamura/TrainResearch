package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;

/* renamed from: kotlinx.coroutines.p */
public class C2579p {

    /* renamed from: b */
    private static final AtomicIntegerFieldUpdater f4217b = AtomicIntegerFieldUpdater.newUpdater(C2579p.class, "_handled");
    private volatile int _handled;
    @JvmField

    /* renamed from: a */
    public final Throwable f4218a;

    public C2579p(Throwable th, boolean z) {
        this.f4218a = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ C2579p(Throwable th, boolean z, int i) {
        z = (i & 2) != 0 ? false : z;
        this.f4218a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    /* renamed from: a */
    public final boolean mo35592a() {
        return this._handled;
    }

    /* renamed from: b */
    public final boolean mo35593b() {
        return f4217b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return getClass().getSimpleName() + '[' + this.f4218a + ']';
    }
}
