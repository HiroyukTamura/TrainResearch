package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.C0617e;
import com.google.android.datatransport.runtime.backends.C0618f;
import com.google.android.datatransport.runtime.backends.C0620g;
import com.google.android.datatransport.runtime.backends.C0628m;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import p009e.p028d.p030b.p031a.p032i.C0896g;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p033s.C0913a;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0946h;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.m */
public class C0647m {

    /* renamed from: a */
    private final Context f322a;

    /* renamed from: b */
    private final C0617e f323b;

    /* renamed from: c */
    private final C0940c f324c;

    /* renamed from: d */
    private final C0653s f325d;

    /* renamed from: e */
    private final Executor f326e;

    /* renamed from: f */
    private final C0966b f327f;

    /* renamed from: g */
    private final C0968a f328g;

    public C0647m(Context context, C0617e eVar, C0940c cVar, C0653s sVar, Executor executor, C0966b bVar, C0968a aVar) {
        this.f322a = context;
        this.f323b = eVar;
        this.f324c = cVar;
        this.f325d = sVar;
        this.f326e = executor;
        this.f327f = bVar;
        this.f328g = aVar;
    }

    /* renamed from: a */
    static /* synthetic */ Object m261a(C0647m mVar, C0620g gVar, Iterable iterable, C0903k kVar, int i) {
        if (gVar.mo9535b() == C0620g.C0621a.TRANSIENT_ERROR) {
            mVar.f324c.mo20363b((Iterable<C0946h>) iterable);
            mVar.f325d.mo9552a(kVar, i + 1);
            return null;
        }
        mVar.f324c.mo20361a((Iterable<C0946h>) iterable);
        if (gVar.mo9535b() == C0620g.C0621a.OK) {
            mVar.f324c.mo20360a(kVar, gVar.mo9534a() + mVar.f328g.mo20396a());
        }
        if (!mVar.f324c.mo20364c(kVar)) {
            return null;
        }
        mVar.f325d.mo9552a(kVar, 1);
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r3.f325d.mo9552a(r4, r5 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        throw r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003a */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m263a(com.google.android.datatransport.runtime.scheduling.jobscheduling.C0647m r3, p009e.p028d.p030b.p031a.p032i.C0903k r4, int r5, java.lang.Runnable r6) {
        /*
            r0 = 1
            e.d.b.a.i.v.b r1 = r3.f327f     // Catch:{ a -> 0x003a }
            e.d.b.a.i.u.h.c r2 = r3.f324c     // Catch:{ a -> 0x003a }
            r2.getClass()     // Catch:{ a -> 0x003a }
            e.d.b.a.i.v.b$a r2 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C0645k.m258a(r2)     // Catch:{ a -> 0x003a }
            r1.mo20359a(r2)     // Catch:{ a -> 0x003a }
            android.content.Context r1 = r3.f322a     // Catch:{ a -> 0x003a }
            java.lang.String r2 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ a -> 0x003a }
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch:{ a -> 0x003a }
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch:{ a -> 0x003a }
            if (r1 == 0) goto L_0x0027
            boolean r1 = r1.isConnected()     // Catch:{ a -> 0x003a }
            if (r1 == 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            if (r1 != 0) goto L_0x0034
            e.d.b.a.i.v.b r1 = r3.f327f     // Catch:{ a -> 0x003a }
            e.d.b.a.i.v.b$a r2 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C0646l.m259a(r3, r4, r5)     // Catch:{ a -> 0x003a }
            r1.mo20359a(r2)     // Catch:{ a -> 0x003a }
            goto L_0x0040
        L_0x0034:
            r3.mo9576a((p009e.p028d.p030b.p031a.p032i.C0903k) r4, (int) r5)     // Catch:{ a -> 0x003a }
            goto L_0x0040
        L_0x0038:
            r3 = move-exception
            goto L_0x0044
        L_0x003a:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.s r3 = r3.f325d     // Catch:{ all -> 0x0038 }
            int r5 = r5 + r0
            r3.mo9552a(r4, r5)     // Catch:{ all -> 0x0038 }
        L_0x0040:
            r6.run()
            return
        L_0x0044:
            r6.run()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.C0647m.m263a(com.google.android.datatransport.runtime.scheduling.jobscheduling.m, e.d.b.a.i.k, int, java.lang.Runnable):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9576a(C0903k kVar, int i) {
        C0620g gVar;
        C0628m mVar = this.f323b.get(kVar.mo20321a());
        Iterable<C0946h> iterable = (Iterable) this.f327f.mo20359a(C0643i.m256a(this, kVar));
        if (iterable.iterator().hasNext()) {
            if (mVar == null) {
                C0913a.m1249a("Uploader", "Unknown backend for %s, deleting event batch for it...", (Object) kVar);
                gVar = C0620g.m215c();
            } else {
                ArrayList arrayList = new ArrayList();
                for (C0946h a : iterable) {
                    arrayList.add(a.mo20390a());
                }
                C0618f.C0619a c = C0618f.m208c();
                c.mo9531a((Iterable<C0896g>) arrayList);
                c.mo9532a(kVar.mo20322b());
                gVar = mVar.mo9523a(c.mo9533a());
            }
            this.f327f.mo20359a(C0644j.m257a(this, gVar, iterable, kVar, i));
        }
    }

    /* renamed from: a */
    public void mo9577a(C0903k kVar, int i, Runnable runnable) {
        this.f326e.execute(C0642h.m255a(this, kVar, i, runnable));
    }
}
