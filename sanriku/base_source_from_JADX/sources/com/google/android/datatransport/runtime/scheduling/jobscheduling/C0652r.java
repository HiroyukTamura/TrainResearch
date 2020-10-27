package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.concurrent.Executor;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.r */
public final class C0652r implements C1585b<C0651q> {

    /* renamed from: a */
    private final C1743a<Executor> f342a;

    /* renamed from: b */
    private final C1743a<C0940c> f343b;

    /* renamed from: c */
    private final C1743a<C0653s> f344c;

    /* renamed from: d */
    private final C1743a<C0966b> f345d;

    public C0652r(C1743a<Executor> aVar, C1743a<C0940c> aVar2, C1743a<C0653s> aVar3, C1743a<C0966b> aVar4) {
        this.f342a = aVar;
        this.f343b = aVar2;
        this.f344c = aVar3;
        this.f345d = aVar4;
    }

    public Object get() {
        return new C0651q(this.f342a.get(), this.f343b.get(), this.f344c.get(), this.f345d.get());
    }
}
