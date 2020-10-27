package com.squareup.picasso;

import android.net.NetworkInfo;
import android.os.Handler;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1530z;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0980J;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1921e;

/* renamed from: com.squareup.picasso.s */
class C1509s extends C1530z {

    /* renamed from: a */
    private final C1498j f1665a;

    /* renamed from: b */
    private final C1467B f1666b;

    /* renamed from: com.squareup.picasso.s$a */
    static class C1510a extends IOException {
        C1510a(String str) {
            super(str);
        }
    }

    /* renamed from: com.squareup.picasso.s$b */
    static final class C1511b extends IOException {

        /* renamed from: a */
        final int f1667a;

        /* renamed from: b */
        final int f1668b;

        C1511b(int i, int i2) {
            super(C0681a.m316a("HTTP ", i));
            this.f1667a = i;
            this.f1668b = i2;
        }
    }

    C1509s(C1498j jVar, C1467B b) {
        this.f1665a = jVar;
        this.f1666b = b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo27240a() {
        return 2;
    }

    /* renamed from: a */
    public C1530z.C1531a mo27173a(C1526x xVar, int i) throws IOException {
        C1921e eVar;
        if (i != 0) {
            boolean z = false;
            if ((C1508r.OFFLINE.f1664a & i) != 0) {
                eVar = C1921e.f2749n;
            } else {
                C1921e.C1922a aVar = new C1921e.C1922a();
                if (!((C1508r.NO_CACHE.f1664a & i) == 0)) {
                    aVar.mo28052b();
                }
                if ((i & C1508r.NO_STORE.f1664a) == 0) {
                    z = true;
                }
                if (!z) {
                    aVar.mo28053c();
                }
                eVar = aVar.mo28051a();
            }
        } else {
            eVar = null;
        }
        C1755F.C1756a aVar2 = new C1755F.C1756a();
        aVar2.mo27552b(xVar.f1717d.toString());
        if (eVar != null) {
            aVar2.mo27544a(eVar);
        }
        C1758I execute = ((C1512t) this.f1665a).f1669a.mo27469a(aVar2.mo27551a()).execute();
        C0980J d = execute.mo27554d();
        if (execute.mo27562s()) {
            C1513u.C1519e eVar2 = execute.mo27556i() == null ? C1513u.C1519e.NETWORK : C1513u.C1519e.DISK;
            if (eVar2 == C1513u.C1519e.DISK && d.contentLength() == 0) {
                d.close();
                throw new C1510a("Received response with 0 content-length header.");
            }
            if (eVar2 == C1513u.C1519e.NETWORK && d.contentLength() > 0) {
                C1467B b = this.f1666b;
                long contentLength = d.contentLength();
                Handler handler = b.f1539c;
                handler.sendMessage(handler.obtainMessage(4, Long.valueOf(contentLength)));
            }
            return new C1530z.C1531a(d.source(), eVar2);
        }
        d.close();
        throw new C1511b(execute.mo27558o(), xVar.f1716c);
    }

    /* renamed from: a */
    public boolean mo27174a(C1526x xVar) {
        String scheme = xVar.f1717d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27241a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo27242b() {
        return true;
    }
}
