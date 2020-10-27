package org.greenrobot.eventbus;

/* renamed from: org.greenrobot.eventbus.k */
final class C2623k {

    /* renamed from: a */
    private C2622j f4317a;

    /* renamed from: b */
    private C2622j f4318b;

    C2623k() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C2622j mo35647a() {
        C2622j jVar;
        jVar = this.f4317a;
        if (this.f4317a != null) {
            C2622j jVar2 = this.f4317a.f4316c;
            this.f4317a = jVar2;
            if (jVar2 == null) {
                this.f4318b = null;
            }
        }
        return jVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C2622j mo35648a(int i) throws InterruptedException {
        if (this.f4317a == null) {
            wait((long) i);
        }
        return mo35647a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo35649a(C2622j jVar) {
        if (jVar != null) {
            try {
                if (this.f4318b != null) {
                    this.f4318b.f4316c = jVar;
                    this.f4318b = jVar;
                } else if (this.f4317a == null) {
                    this.f4318b = jVar;
                    this.f4317a = jVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }
}
