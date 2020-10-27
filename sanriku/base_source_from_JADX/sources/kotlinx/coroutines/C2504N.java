package kotlinx.coroutines;

import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.internal.C2546d;

/* renamed from: kotlinx.coroutines.N */
public abstract class C2504N extends C1120x {

    /* renamed from: a */
    private long f4116a;

    /* renamed from: b */
    private boolean f4117b;

    /* renamed from: c */
    private C2546d<C2501J<?>> f4118c;

    /* renamed from: c */
    private final long m4333c(boolean z) {
        return z ? 4294967296L : 1;
    }

    /* renamed from: a */
    public final void mo35503a(C2501J<?> j) {
        C2546d<C2501J<?>> dVar = this.f4118c;
        if (dVar == null) {
            dVar = new C2546d<>();
            this.f4118c = dVar;
        }
        dVar.mo35551a(j);
    }

    /* renamed from: a */
    public final void mo35504a(boolean z) {
        long c = this.f4116a - m4333c(z);
        this.f4116a = c;
        if (c <= 0) {
            if (C2496E.m4305a()) {
                if (!(this.f4116a == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f4117b) {
                shutdown();
            }
        }
    }

    /* renamed from: b */
    public final void mo35505b(boolean z) {
        this.f4116a += m4333c(z);
        if (!z) {
            this.f4117b = true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public long mo35506o() {
        C2546d<C2501J<?>> dVar = this.f4118c;
        if (dVar == null || dVar.mo35552a()) {
            return LongCompanionObject.MAX_VALUE;
        }
        return 0;
    }

    /* renamed from: p */
    public final boolean mo35507p() {
        return this.f4116a >= m4333c(true);
    }

    /* renamed from: q */
    public final boolean mo35508q() {
        C2546d<C2501J<?>> dVar = this.f4118c;
        if (dVar != null) {
            return dVar.mo35552a();
        }
        return true;
    }

    /* renamed from: r */
    public final boolean mo35509r() {
        C2501J b;
        C2546d<C2501J<?>> dVar = this.f4118c;
        if (dVar == null || (b = dVar.mo35553b()) == null) {
            return false;
        }
        b.run();
        return true;
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
    }
}
