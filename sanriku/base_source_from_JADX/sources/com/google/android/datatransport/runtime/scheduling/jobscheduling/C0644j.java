package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.backends.C0620g;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.j */
final /* synthetic */ class C0644j implements C0966b.C0967a {

    /* renamed from: a */
    private final C0647m f313a;

    /* renamed from: b */
    private final C0620g f314b;

    /* renamed from: c */
    private final Iterable f315c;

    /* renamed from: d */
    private final C0903k f316d;

    /* renamed from: e */
    private final int f317e;

    private C0644j(C0647m mVar, C0620g gVar, Iterable iterable, C0903k kVar, int i) {
        this.f313a = mVar;
        this.f314b = gVar;
        this.f315c = iterable;
        this.f316d = kVar;
        this.f317e = i;
    }

    /* renamed from: a */
    public static C0966b.C0967a m257a(C0647m mVar, C0620g gVar, Iterable iterable, C0903k kVar, int i) {
        return new C0644j(mVar, gVar, iterable, kVar, i);
    }

    public Object execute() {
        C0647m.m261a(this.f313a, this.f314b, this.f315c, this.f316d, this.f317e);
        return null;
    }
}
