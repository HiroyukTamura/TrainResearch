package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.o */
final /* synthetic */ class C0649o implements Runnable {

    /* renamed from: a */
    private final C0651q f336a;

    private C0649o(C0651q qVar) {
        this.f336a = qVar;
    }

    /* renamed from: a */
    public static Runnable m266a(C0651q qVar) {
        return new C0649o(qVar);
    }

    public void run() {
        this.f336a.f341d.mo20359a(C0650p.m267a(this.f336a));
    }
}
