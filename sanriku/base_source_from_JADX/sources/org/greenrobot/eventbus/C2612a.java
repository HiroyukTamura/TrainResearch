package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.a */
class C2612a implements Runnable, C2624l {

    /* renamed from: a */
    private final C2623k f4291a = new C2623k();

    /* renamed from: b */
    private final C1126c f4292b;

    C2612a(C1126c cVar) {
        this.f4292b = cVar;
    }

    /* renamed from: a */
    public void mo35639a(C2629q qVar, Object obj) {
        this.f4291a.mo35649a(C2622j.m4571a(qVar, obj));
        this.f4292b.mo21902a().execute(this);
    }

    public void run() {
        C2622j a = this.f4291a.mo35647a();
        if (a != null) {
            this.f4292b.mo21904a(a);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
