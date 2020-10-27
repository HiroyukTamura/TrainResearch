package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.l */
final /* synthetic */ class C0646l implements C0966b.C0967a {

    /* renamed from: a */
    private final C0647m f319a;

    /* renamed from: b */
    private final C0903k f320b;

    /* renamed from: c */
    private final int f321c;

    private C0646l(C0647m mVar, C0903k kVar, int i) {
        this.f319a = mVar;
        this.f320b = kVar;
        this.f321c = i;
    }

    /* renamed from: a */
    public static C0966b.C0967a m259a(C0647m mVar, C0903k kVar, int i) {
        return new C0646l(mVar, kVar, i);
    }

    public Object execute() {
        Object unused = this.f319a.f325d.mo9552a(this.f320b, this.f321c + 1);
        return null;
    }
}
