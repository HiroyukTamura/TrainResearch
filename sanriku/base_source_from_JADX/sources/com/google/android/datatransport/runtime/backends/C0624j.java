package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: com.google.android.datatransport.runtime.backends.j */
public final class C0624j implements C1585b<C0623i> {

    /* renamed from: a */
    private final C1743a<Context> f273a;

    /* renamed from: b */
    private final C1743a<C0968a> f274b;

    /* renamed from: c */
    private final C1743a<C0968a> f275c;

    public C0624j(C1743a<Context> aVar, C1743a<C0968a> aVar2, C1743a<C0968a> aVar3) {
        this.f273a = aVar;
        this.f274b = aVar2;
        this.f275c = aVar3;
    }

    public Object get() {
        return new C0623i(this.f273a.get(), this.f274b.get(), this.f275c.get());
    }
}
