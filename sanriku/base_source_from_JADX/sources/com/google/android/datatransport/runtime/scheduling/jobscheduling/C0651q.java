package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.concurrent.Executor;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.q */
public class C0651q {

    /* renamed from: a */
    private final Executor f338a;

    /* renamed from: b */
    private final C0940c f339b;

    /* renamed from: c */
    private final C0653s f340c;

    /* renamed from: d */
    private final C0966b f341d;

    C0651q(Executor executor, C0940c cVar, C0653s sVar, C0966b bVar) {
        this.f338a = executor;
        this.f339b = cVar;
        this.f340c = sVar;
        this.f341d = bVar;
    }

    /* renamed from: a */
    static /* synthetic */ Object m268a(C0651q qVar) {
        for (C0903k a : qVar.f339b.mo20367e()) {
            qVar.f340c.mo9552a(a, 1);
        }
        return null;
    }

    /* renamed from: a */
    public void mo9579a() {
        this.f338a.execute(C0649o.m266a(this));
    }
}
