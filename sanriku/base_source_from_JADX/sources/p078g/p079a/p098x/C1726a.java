package p078g.p079a.p098x;

import p078g.p079a.p080A.p081a.C1587a;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p092g.C1681b;

/* renamed from: g.a.x.a */
public final class C1726a implements C1727b, C1587a {

    /* renamed from: a */
    C1681b<C1727b> f2071a;

    /* renamed from: b */
    volatile boolean f2072b;

    /* renamed from: a */
    public boolean mo27340a() {
        return this.f2072b;
    }

    /* renamed from: a */
    public boolean mo27347a(C1727b bVar) {
        if (!mo27349c(bVar)) {
            return false;
        }
        bVar.mo27341b();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r1 != null) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1 = r1.mo27413a();
        r3 = r1.length;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r5 >= r3) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r6 = r1[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if ((r6 instanceof p078g.p079a.p098x.C1727b) == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        ((p078g.p079a.p098x.C1727b) r6).mo27341b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        p009e.p028d.p030b.p054b.C1532a.m2139a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        if (r2 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        r2.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r2.size() != 1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        throw p078g.p079a.p080A.p092g.C1679a.m2365a((java.lang.Throwable) r2.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        throw new p078g.p079a.p099y.C1730a((java.lang.Iterable<? extends java.lang.Throwable>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27341b() {
        /*
            r8 = this;
            boolean r0 = r8.f2072b
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r8)
            boolean r0 = r8.f2072b     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            return
        L_0x000c:
            r0 = 1
            r8.f2072b = r0     // Catch:{ all -> 0x0058 }
            g.a.A.g.b<g.a.x.b> r1 = r8.f2071a     // Catch:{ all -> 0x0058 }
            r2 = 0
            r8.f2071a = r2     // Catch:{ all -> 0x0058 }
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0057
        L_0x0018:
            java.lang.Object[] r1 = r1.mo27413a()
            int r3 = r1.length
            r4 = 0
            r5 = 0
        L_0x001f:
            if (r5 >= r3) goto L_0x003e
            r6 = r1[r5]
            boolean r7 = r6 instanceof p078g.p079a.p098x.C1727b
            if (r7 == 0) goto L_0x003b
            g.a.x.b r6 = (p078g.p079a.p098x.C1727b) r6     // Catch:{ all -> 0x002d }
            r6.mo27341b()     // Catch:{ all -> 0x002d }
            goto L_0x003b
        L_0x002d:
            r6 = move-exception
            p009e.p028d.p030b.p054b.C1532a.m2139a((java.lang.Throwable) r6)
            if (r2 != 0) goto L_0x0038
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0038:
            r2.add(r6)
        L_0x003b:
            int r5 = r5 + 1
            goto L_0x001f
        L_0x003e:
            if (r2 == 0) goto L_0x0057
            int r1 = r2.size()
            if (r1 != r0) goto L_0x0051
            java.lang.Object r0 = r2.get(r4)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.RuntimeException r0 = p078g.p079a.p080A.p092g.C1679a.m2365a(r0)
            throw r0
        L_0x0051:
            g.a.y.a r0 = new g.a.y.a
            r0.<init>((java.lang.Iterable<? extends java.lang.Throwable>) r2)
            throw r0
        L_0x0057:
            return
        L_0x0058:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            goto L_0x005c
        L_0x005b:
            throw r0
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: p078g.p079a.p098x.C1726a.mo27341b():void");
    }

    /* renamed from: b */
    public boolean mo27348b(C1727b bVar) {
        C1599b.m2241a(bVar, "disposable is null");
        if (!this.f2072b) {
            synchronized (this) {
                if (!this.f2072b) {
                    C1681b<C1727b> bVar2 = this.f2071a;
                    if (bVar2 == null) {
                        bVar2 = new C1681b<>();
                        this.f2071a = bVar2;
                    }
                    bVar2.mo27412a(bVar);
                    return true;
                }
            }
        }
        bVar.mo27341b();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo27349c(p078g.p079a.p098x.C1727b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposables is null"
            p078g.p079a.p080A.p082b.C1599b.m2241a(r3, (java.lang.String) r0)
            boolean r0 = r2.f2072b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f2072b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            g.a.A.g.b<g.a.x.b> r0 = r2.f2071a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.mo27414b(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p078g.p079a.p098x.C1726a.mo27349c(g.a.x.b):boolean");
    }
}
