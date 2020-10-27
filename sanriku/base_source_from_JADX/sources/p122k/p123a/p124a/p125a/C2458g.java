package p122k.p123a.p124a.p125a;

import java.io.Serializable;
import p009e.p010a.p011a.p012a.C0681a;
import p122k.p123a.p124a.p125a.p128G.C2442k;

/* renamed from: k.a.a.a.g */
public class C2458g implements C2353D, Serializable {

    /* renamed from: a */
    protected int f4018a;

    /* renamed from: b */
    protected int f4019b;

    /* renamed from: c */
    protected int f4020c = -1;

    /* renamed from: d */
    protected int f4021d = 0;

    /* renamed from: e */
    protected C2442k<C2479z, C2457f> f4022e;

    /* renamed from: f */
    protected String f4023f;

    /* renamed from: g */
    protected int f4024g = -1;

    /* renamed from: h */
    protected int f4025h;

    /* renamed from: i */
    protected int f4026i;

    public C2458g(C2442k<C2479z, C2457f> kVar, int i, int i2, int i3, int i4) {
        this.f4022e = kVar;
        this.f4018a = i;
        this.f4021d = i2;
        this.f4025h = i3;
        this.f4026i = i4;
        A a = kVar.f4007a;
        if (a != null) {
            this.f4019b = ((C2479z) a).mo34316a();
            this.f4020c = ((C2479z) kVar.f4007a).mo34318b();
        }
    }

    /* renamed from: a */
    public int mo34297a() {
        return this.f4019b;
    }

    /* renamed from: a */
    public void mo34035a(int i) {
        this.f4024g = i;
    }

    /* renamed from: b */
    public int mo34298b() {
        return this.f4020c;
    }

    /* renamed from: c */
    public C2479z mo34299c() {
        return (C2479z) this.f4022e.f4007a;
    }

    /* renamed from: d */
    public int mo34300d() {
        return this.f4021d;
    }

    /* renamed from: e */
    public int mo34301e() {
        return this.f4024g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r3 = r4.f4026i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getText() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f4023f
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            k.a.a.a.G.k<k.a.a.a.z, k.a.a.a.f> r0 = r4.f4022e
            B r0 = r0.f4008b
            k.a.a.a.f r0 = (p122k.p123a.p124a.p125a.C2457f) r0
            if (r0 != 0) goto L_0x000f
            r0 = 0
            return r0
        L_0x000f:
            int r1 = r0.size()
            int r2 = r4.f4025h
            if (r2 >= r1) goto L_0x0024
            int r3 = r4.f4026i
            if (r3 >= r1) goto L_0x0024
            k.a.a.a.G.h r1 = p122k.p123a.p124a.p125a.p128G.C2439h.m4146a(r2, r3)
            java.lang.String r0 = r0.mo34281a(r1)
            return r0
        L_0x0024:
            java.lang.String r0 = "<EOF>"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.C2458g.getText():java.lang.String");
    }

    public int getType() {
        return this.f4018a;
    }

    public String toString() {
        String str;
        if (this.f4021d > 0) {
            StringBuilder a = C0681a.m330a(",channel=");
            a.append(this.f4021d);
            str = a.toString();
        } else {
            str = "";
        }
        String text = getText();
        String replace = text != null ? text.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") : "<no text>";
        String valueOf = String.valueOf(this.f4018a);
        StringBuilder a2 = C0681a.m330a("[@");
        a2.append(this.f4024g);
        a2.append(",");
        a2.append(this.f4025h);
        a2.append(":");
        a2.append(this.f4026i);
        a2.append("='");
        a2.append(replace);
        a2.append("',<");
        C0681a.m335a(a2, valueOf, ">", str, ",");
        a2.append(this.f4019b);
        a2.append(":");
        return C0681a.m322a(a2, this.f4020c, "]");
    }
}
