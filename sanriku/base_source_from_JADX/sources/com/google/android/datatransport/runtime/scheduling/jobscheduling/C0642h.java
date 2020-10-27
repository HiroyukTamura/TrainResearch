package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import p009e.p028d.p030b.p031a.p032i.C0903k;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.h */
final /* synthetic */ class C0642h implements Runnable {

    /* renamed from: a */
    private final C0647m f307a;

    /* renamed from: b */
    private final C0903k f308b;

    /* renamed from: c */
    private final int f309c;

    /* renamed from: d */
    private final Runnable f310d;

    private C0642h(C0647m mVar, C0903k kVar, int i, Runnable runnable) {
        this.f307a = mVar;
        this.f308b = kVar;
        this.f309c = i;
        this.f310d = runnable;
    }

    /* renamed from: a */
    public static Runnable m255a(C0647m mVar, C0903k kVar, int i, Runnable runnable) {
        return new C0642h(mVar, kVar, i, runnable);
    }

    public void run() {
        C0647m.m263a(this.f307a, this.f308b, this.f309c, this.f310d);
    }
}
