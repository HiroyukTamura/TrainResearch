package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: com.google.android.datatransport.runtime.backends.l */
public final class C0627l implements C1585b<C0625k> {

    /* renamed from: a */
    private final C1743a<Context> f281a;

    /* renamed from: b */
    private final C1743a<C0623i> f282b;

    public C0627l(C1743a<Context> aVar, C1743a<C0623i> aVar2) {
        this.f281a = aVar;
        this.f282b = aVar2;
    }

    public Object get() {
        return new C0625k(this.f281a.get(), this.f282b.get());
    }
}
