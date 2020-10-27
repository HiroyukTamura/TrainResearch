package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.q */
final class C2629q {

    /* renamed from: a */
    final Object f4340a;

    /* renamed from: b */
    final C2626o f4341b;

    /* renamed from: c */
    volatile boolean f4342c = true;

    C2629q(Object obj, C2626o oVar) {
        this.f4340a = obj;
        this.f4341b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2629q)) {
            return false;
        }
        C2629q qVar = (C2629q) obj;
        return this.f4340a == qVar.f4340a && this.f4341b.equals(qVar.f4341b);
    }

    public int hashCode() {
        return this.f4341b.f4327f.hashCode() + this.f4340a.hashCode();
    }
}
