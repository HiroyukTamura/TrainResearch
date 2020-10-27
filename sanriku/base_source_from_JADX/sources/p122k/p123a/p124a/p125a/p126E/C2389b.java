package p122k.p123a.p124a.p125a.p126E;

import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: k.a.a.a.E.b */
public class C2389b {

    /* renamed from: a */
    public final C2403g f3884a;

    /* renamed from: b */
    public final int f3885b;

    /* renamed from: c */
    public C2371Q f3886c;

    /* renamed from: d */
    public int f3887d;

    /* renamed from: e */
    public final C2380Y f3888e;

    public C2389b(C2389b bVar, C2403g gVar) {
        this(bVar, gVar, bVar.f3886c, bVar.f3888e);
    }

    public C2389b(C2389b bVar, C2403g gVar, C2371Q q, C2380Y y) {
        this.f3884a = gVar;
        this.f3885b = bVar.f3885b;
        this.f3886c = q;
        this.f3888e = y;
        this.f3887d = bVar.f3887d;
    }

    public C2389b(C2403g gVar, int i, C2371Q q) {
        C2380Y y = C2380Y.f3865a;
        this.f3884a = gVar;
        this.f3885b = i;
        this.f3886c = q;
        this.f3888e = y;
    }

    public C2389b(C2403g gVar, int i, C2371Q q, C2380Y y) {
        this.f3884a = gVar;
        this.f3885b = i;
        this.f3886c = q;
        this.f3888e = y;
    }

    /* renamed from: a */
    public final int mo34118a() {
        return this.f3887d & -1073741825;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r2 = r4.f3886c;
        r3 = r5.f3886c;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo34119a(p122k.p123a.p124a.p125a.p126E.C2389b r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 != 0) goto L_0x0008
            return r1
        L_0x0008:
            k.a.a.a.E.g r2 = r4.f3884a
            int r2 = r2.f3916b
            k.a.a.a.E.g r3 = r5.f3884a
            int r3 = r3.f3916b
            if (r2 != r3) goto L_0x003b
            int r2 = r4.f3885b
            int r3 = r5.f3885b
            if (r2 != r3) goto L_0x003b
            k.a.a.a.E.Q r2 = r4.f3886c
            k.a.a.a.E.Q r3 = r5.f3886c
            if (r2 == r3) goto L_0x0026
            if (r2 == 0) goto L_0x003b
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003b
        L_0x0026:
            k.a.a.a.E.Y r2 = r4.f3888e
            k.a.a.a.E.Y r3 = r5.f3888e
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003b
            boolean r2 = r4.mo34120b()
            boolean r5 = r5.mo34120b()
            if (r2 != r5) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2389b.mo34119a(k.a.a.a.E.b):boolean");
    }

    /* renamed from: b */
    public final boolean mo34120b() {
        return (this.f3887d & 1073741824) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2389b)) {
            return false;
        }
        return mo34119a((C2389b) obj);
    }

    public int hashCode() {
        return C1532a.m2119a(C1532a.m2120a(C1532a.m2120a(C1532a.m2145b(C1532a.m2145b(7, this.f3884a.f3916b), this.f3885b), (Object) this.f3886c), (Object) this.f3888e), 4);
    }

    public String toString() {
        StringBuilder a = C0681a.m329a('(');
        a.append(this.f3884a);
        a.append(",");
        a.append(this.f3885b);
        if (this.f3886c != null) {
            a.append(",[");
            a.append(this.f3886c.toString());
            a.append("]");
        }
        C2380Y y = this.f3888e;
        if (!(y == null || y == C2380Y.f3865a)) {
            a.append(",");
            a.append(this.f3888e);
        }
        if (mo34118a() > 0) {
            a.append(",up=");
            a.append(mo34118a());
        }
        a.append(')');
        return a.toString();
    }
}
