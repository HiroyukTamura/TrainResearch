package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.k */
final /* synthetic */ class C0645k implements C0966b.C0967a {

    /* renamed from: a */
    private final C0940c f318a;

    private C0645k(C0940c cVar) {
        this.f318a = cVar;
    }

    /* renamed from: a */
    public static C0966b.C0967a m258a(C0940c cVar) {
        return new C0645k(cVar);
    }

    public Object execute() {
        return Integer.valueOf(this.f318a.mo20356a());
    }
}
