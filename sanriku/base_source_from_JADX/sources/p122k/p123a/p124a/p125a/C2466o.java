package p122k.p123a.p124a.p125a;

import p009e.p010a.p011a.p012a.C0681a;
import p122k.p123a.p124a.p125a.p126E.C2419v;
import p122k.p123a.p124a.p125a.p128G.C2438g;
import p122k.p123a.p124a.p125a.p128G.C2439h;
import p122k.p123a.p124a.p125a.p128G.C2442k;

/* renamed from: k.a.a.a.o */
public abstract class C2466o extends C2474v<Integer, C2419v> implements C2479z {

    /* renamed from: d */
    public C2457f f4034d;

    /* renamed from: e */
    protected C2442k<C2479z, C2457f> f4035e;

    /* renamed from: f */
    protected C2478y<?> f4036f = C2459h.f4027b;

    /* renamed from: g */
    public C2477x f4037g;

    /* renamed from: h */
    public int f4038h = -1;

    /* renamed from: i */
    public int f4039i;

    /* renamed from: j */
    public int f4040j;

    /* renamed from: k */
    public boolean f4041k;

    /* renamed from: l */
    public int f4042l;

    /* renamed from: m */
    public int f4043m;

    /* renamed from: n */
    public final C2438g f4044n = new C2438g();

    /* renamed from: o */
    public int f4045o = 0;

    /* renamed from: p */
    public String f4046p;

    public C2466o(C2457f fVar) {
        this.f4034d = fVar;
        this.f4035e = new C2442k<>(this, fVar);
    }

    /* renamed from: a */
    public int mo34316a() {
        return ((C2419v) this.f4068b).mo34176c();
    }

    /* renamed from: b */
    public int mo34318b() {
        return ((C2419v) this.f4068b).mo34174b();
    }

    /* renamed from: c */
    public C2477x mo34319c() {
        int i;
        C2457f fVar = this.f4034d;
        if (fVar != null) {
            int a = fVar.mo34280a();
            while (true) {
                try {
                    if (this.f4041k) {
                        mo34322j();
                        break;
                    }
                    this.f4037g = null;
                    this.f4042l = 0;
                    this.f4038h = this.f4034d.mo34283b();
                    this.f4040j = ((C2419v) this.f4068b).mo34174b();
                    this.f4039i = ((C2419v) this.f4068b).mo34176c();
                    this.f4046p = null;
                    while (true) {
                        this.f4043m = 0;
                        i = ((C2419v) this.f4068b).mo34168a(this.f4034d, this.f4045o);
                        if (this.f4034d.mo34284b(1) == -1) {
                            this.f4041k = true;
                        }
                        if (this.f4043m == 0) {
                            this.f4043m = i;
                        }
                        if (this.f4043m == -3) {
                            break;
                        } else if (this.f4043m != -2) {
                            if (this.f4037g == null) {
                                this.f4037g = ((C2459h) this.f4036f).mo34305a(this.f4035e, this.f4043m, this.f4046p, this.f4042l, this.f4038h, this.f4034d.mo34283b() - 1, this.f4039i, this.f4040j);
                            }
                        }
                    }
                } catch (C2467p e) {
                    mo34317a(e);
                    if (this.f4034d.mo34284b(1) != -1) {
                        ((C2419v) this.f4068b).mo34172a(this.f4034d);
                    }
                    i = -3;
                } catch (Throwable th) {
                    this.f4034d.mo34286d(a);
                    throw th;
                }
            }
            C2477x xVar = this.f4037g;
            this.f4034d.mo34286d(a);
            return xVar;
        }
        throw new IllegalStateException("nextToken requires a non-null input stream.");
    }

    /* renamed from: d */
    public C2478y<? extends C2477x> mo34320d() {
        return this.f4036f;
    }

    /* renamed from: e */
    public C2457f mo34321e() {
        return this.f4034d;
    }

    /* renamed from: j */
    public C2477x mo34322j() {
        int b = ((C2419v) this.f4068b).mo34174b();
        int c = ((C2419v) this.f4068b).mo34176c();
        C2478y<?> yVar = this.f4036f;
        C2477x a = ((C2459h) yVar).mo34305a(this.f4035e, -1, (String) null, 0, this.f4034d.mo34283b(), this.f4034d.mo34283b() - 1, c, b);
        this.f4037g = a;
        return a;
    }

    /* renamed from: a */
    public void mo34317a(C2467p pVar) {
        C2457f fVar = this.f4034d;
        String a = fVar.mo34281a(C2439h.m4146a(this.f4038h, fVar.mo34283b()));
        StringBuilder a2 = C0681a.m330a("token recognition error at: '");
        StringBuilder sb = new StringBuilder();
        for (char c : a.toCharArray()) {
            String valueOf = String.valueOf((char) c);
            if (c == 65535) {
                valueOf = "<EOF>";
            } else if (c == 13) {
                valueOf = "\\r";
            } else if (c == 9) {
                valueOf = "\\t";
            } else if (c == 10) {
                valueOf = "\\n";
            }
            sb.append(valueOf);
        }
        a2.append(sb.toString());
        a2.append("'");
        mo34350g().mo34279a((C2474v<?, ?>) this, (Object) null, this.f4039i, this.f4040j, a2.toString(), (C2473u) pVar);
    }
}
