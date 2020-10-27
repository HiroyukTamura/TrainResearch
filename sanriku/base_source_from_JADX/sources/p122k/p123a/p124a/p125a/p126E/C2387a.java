package p122k.p123a.p124a.p125a.p126E;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import p122k.p123a.p124a.p125a.C2476w;
import p122k.p123a.p124a.p125a.p128G.C2436e;
import p122k.p123a.p124a.p125a.p128G.C2440i;

/* renamed from: k.a.a.a.E.a */
public class C2387a {

    /* renamed from: a */
    public final List<C2403g> f3873a = new ArrayList();

    /* renamed from: b */
    public final List<C2414q> f3874b = new ArrayList();

    /* renamed from: c */
    public C2377V[] f3875c;

    /* renamed from: d */
    public C2378W[] f3876d;

    /* renamed from: e */
    public final C2405h f3877e;

    /* renamed from: f */
    public final int f3878f;

    /* renamed from: g */
    public int[] f3879g;

    /* renamed from: h */
    public C2421w[] f3880h;

    /* renamed from: i */
    public final List<C2399e0> f3881i;

    public C2387a(C2405h hVar, int i) {
        new LinkedHashMap();
        this.f3881i = new ArrayList();
        this.f3877e = hVar;
        this.f3878f = i;
    }

    /* renamed from: a */
    public int mo34111a() {
        return this.f3874b.size();
    }

    /* renamed from: a */
    public C2414q mo34112a(int i) {
        if (!this.f3874b.isEmpty()) {
            return this.f3874b.get(i);
        }
        return null;
    }

    /* renamed from: a */
    public C2440i mo34113a(int i, C2476w wVar) {
        if (i < 0 || i >= this.f3873a.size()) {
            throw new IllegalArgumentException("Invalid state number.");
        }
        C2440i b = mo34116b(this.f3873a.get(i));
        if (!b.mo34259b(-2)) {
            return b;
        }
        C2440i iVar = new C2440i(new int[0]);
        iVar.mo34254a((C2436e) b);
        iVar.mo34261c(-2);
        while (wVar != null && wVar.f4072b >= 0 && b.mo34259b(-2)) {
            b = mo34116b(((C2379X) this.f3873a.get(wVar.f4072b).mo34154a(0)).f3864c);
            iVar.mo34254a((C2436e) b);
            iVar.mo34261c(-2);
            wVar = wVar.f4071a;
        }
        if (b.mo34259b(-2)) {
            iVar.mo34255a(-1);
        }
        return iVar;
    }

    /* renamed from: a */
    public C2440i mo34114a(C2403g gVar, C2476w wVar) {
        C2417t tVar = new C2417t(this);
        C2440i iVar = new C2440i(new int[0]);
        tVar.mo34165a(gVar, (C2403g) null, wVar != null ? C2371Q.m3999a(gVar.f3915a, wVar) : null, iVar, new HashSet(), new BitSet(), true, true);
        return iVar;
    }

    /* renamed from: a */
    public void mo34115a(C2403g gVar) {
        if (gVar != null) {
            gVar.f3915a = this;
            gVar.f3916b = this.f3873a.size();
        }
        this.f3873a.add(gVar);
    }

    /* renamed from: b */
    public C2440i mo34116b(C2403g gVar) {
        C2440i iVar = gVar.f3920f;
        if (iVar != null) {
            return iVar;
        }
        C2440i a = mo34114a(gVar, (C2476w) null);
        gVar.f3920f = a;
        a.mo34257a(true);
        return gVar.f3920f;
    }
}
