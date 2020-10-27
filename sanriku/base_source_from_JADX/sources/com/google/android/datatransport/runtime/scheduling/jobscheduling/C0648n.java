package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.C0617e;
import java.util.concurrent.Executor;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.n */
public final class C0648n implements C1585b<C0647m> {

    /* renamed from: a */
    private final C1743a<Context> f329a;

    /* renamed from: b */
    private final C1743a<C0617e> f330b;

    /* renamed from: c */
    private final C1743a<C0940c> f331c;

    /* renamed from: d */
    private final C1743a<C0653s> f332d;

    /* renamed from: e */
    private final C1743a<Executor> f333e;

    /* renamed from: f */
    private final C1743a<C0966b> f334f;

    /* renamed from: g */
    private final C1743a<C0968a> f335g;

    public C0648n(C1743a<Context> aVar, C1743a<C0617e> aVar2, C1743a<C0940c> aVar3, C1743a<C0653s> aVar4, C1743a<Executor> aVar5, C1743a<C0966b> aVar6, C1743a<C0968a> aVar7) {
        this.f329a = aVar;
        this.f330b = aVar2;
        this.f331c = aVar3;
        this.f332d = aVar4;
        this.f333e = aVar5;
        this.f334f = aVar6;
        this.f335g = aVar7;
    }

    public Object get() {
        return new C0647m(this.f329a.get(), this.f330b.get(), this.f331c.get(), this.f332d.get(), this.f333e.get(), this.f334f.get(), this.f335g.get());
    }
}
