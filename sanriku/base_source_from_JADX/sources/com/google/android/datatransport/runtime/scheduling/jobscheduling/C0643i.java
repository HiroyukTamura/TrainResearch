package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.i */
final /* synthetic */ class C0643i implements C0966b.C0967a {

    /* renamed from: a */
    private final C0647m f311a;

    /* renamed from: b */
    private final C0903k f312b;

    private C0643i(C0647m mVar, C0903k kVar) {
        this.f311a = mVar;
        this.f312b = kVar;
    }

    /* renamed from: a */
    public static C0966b.C0967a m256a(C0647m mVar, C0903k kVar) {
        return new C0643i(mVar, kVar);
    }

    public Object execute() {
        return this.f311a.f324c.mo20358a(this.f312b);
    }
}
