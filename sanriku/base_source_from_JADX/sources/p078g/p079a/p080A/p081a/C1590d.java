package p078g.p079a.p080A.p081a;

import java.util.LinkedList;
import java.util.List;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.a.d */
public final class C1590d implements C1727b, C1587a {

    /* renamed from: a */
    List<C1727b> f1861a;

    /* renamed from: b */
    volatile boolean f1862b;

    /* renamed from: a */
    public boolean mo27340a() {
        return this.f1862b;
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
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r1.hasNext() == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.next().mo27341b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        p009e.p028d.p030b.p054b.C1532a.m2139a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r2 == null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        r2.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        if (r2.size() != 1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        throw p078g.p079a.p080A.p092g.C1679a.m2365a((java.lang.Throwable) r2.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        throw new p078g.p079a.p099y.C1730a((java.lang.Iterable<? extends java.lang.Throwable>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27341b() {
        /*
            r4 = this;
            boolean r0 = r4.f1862b
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r4)
            boolean r0 = r4.f1862b     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            return
        L_0x000c:
            r0 = 1
            r4.f1862b = r0     // Catch:{ all -> 0x0056 }
            java.util.List<g.a.x.b> r1 = r4.f1861a     // Catch:{ all -> 0x0056 }
            r2 = 0
            r4.f1861a = r2     // Catch:{ all -> 0x0056 }
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0055
        L_0x0018:
            java.util.Iterator r1 = r1.iterator()
        L_0x001c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r1.next()
            g.a.x.b r3 = (p078g.p079a.p098x.C1727b) r3
            r3.mo27341b()     // Catch:{ all -> 0x002c }
            goto L_0x001c
        L_0x002c:
            r3 = move-exception
            p009e.p028d.p030b.p054b.C1532a.m2139a((java.lang.Throwable) r3)
            if (r2 != 0) goto L_0x0037
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0037:
            r2.add(r3)
            goto L_0x001c
        L_0x003b:
            if (r2 == 0) goto L_0x0055
            int r1 = r2.size()
            if (r1 != r0) goto L_0x004f
            r0 = 0
            java.lang.Object r0 = r2.get(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.RuntimeException r0 = p078g.p079a.p080A.p092g.C1679a.m2365a(r0)
            throw r0
        L_0x004f:
            g.a.y.a r0 = new g.a.y.a
            r0.<init>((java.lang.Iterable<? extends java.lang.Throwable>) r2)
            throw r0
        L_0x0055:
            return
        L_0x0056:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0056 }
            goto L_0x005a
        L_0x0059:
            throw r0
        L_0x005a:
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: p078g.p079a.p080A.p081a.C1590d.mo27341b():void");
    }

    /* renamed from: b */
    public boolean mo27348b(C1727b bVar) {
        C1599b.m2241a(bVar, "d is null");
        if (!this.f1862b) {
            synchronized (this) {
                if (!this.f1862b) {
                    List list = this.f1861a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f1861a = list;
                    }
                    list.add(bVar);
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
            java.lang.String r0 = "Disposable item is null"
            p078g.p079a.p080A.p082b.C1599b.m2241a(r3, (java.lang.String) r0)
            boolean r0 = r2.f1862b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f1862b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<g.a.x.b> r0 = r2.f1861a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: p078g.p079a.p080A.p081a.C1590d.mo27349c(g.a.x.b):boolean");
    }
}
