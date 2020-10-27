package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;

/* renamed from: com.google.android.datatransport.runtime.backends.i */
class C0623i {

    /* renamed from: a */
    private final Context f270a;

    /* renamed from: b */
    private final C0968a f271b;

    /* renamed from: c */
    private final C0968a f272c;

    C0623i(Context context, C0968a aVar, C0968a aVar2) {
        this.f270a = context;
        this.f271b = aVar;
        this.f272c = aVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0622h mo9546a(String str) {
        return new C0615c(this.f270a, this.f271b, this.f272c, str);
    }
}
