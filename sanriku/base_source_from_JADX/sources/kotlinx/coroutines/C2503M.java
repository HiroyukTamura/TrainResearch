package kotlinx.coroutines;

import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: kotlinx.coroutines.M */
final class C2503M implements C2514V {

    /* renamed from: a */
    private final boolean f4115a;

    public C2503M(boolean z) {
        this.f4115a = z;
    }

    /* renamed from: a */
    public C2569j0 mo21859a() {
        return null;
    }

    public boolean isActive() {
        return this.f4115a;
    }

    public String toString() {
        return C0681a.m323a(C0681a.m330a("Empty{"), this.f4115a ? "Active" : "New", '}');
    }
}
