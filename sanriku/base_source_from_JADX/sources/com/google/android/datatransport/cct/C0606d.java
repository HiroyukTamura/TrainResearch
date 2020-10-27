package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.C0607e;
import java.net.URL;
import p009e.p028d.p030b.p031a.p032i.p033s.C0913a;
import p009e.p028d.p030b.p031a.p032i.p034t.C0915b;

/* renamed from: com.google.android.datatransport.cct.d */
final /* synthetic */ class C0606d implements C0915b {

    /* renamed from: a */
    private static final C0606d f244a = new C0606d();

    private C0606d() {
    }

    /* renamed from: a */
    public static C0915b m191a() {
        return f244a;
    }

    /* renamed from: a */
    public Object mo9522a(Object obj, Object obj2) {
        C0607e.C0608a aVar = (C0607e.C0608a) obj;
        C0607e.C0609b bVar = (C0607e.C0609b) obj2;
        URL url = bVar.f255b;
        if (url == null) {
            return null;
        }
        C0913a.m1249a("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return new C0607e.C0608a(bVar.f255b, aVar.f252b, aVar.f253c);
    }
}
