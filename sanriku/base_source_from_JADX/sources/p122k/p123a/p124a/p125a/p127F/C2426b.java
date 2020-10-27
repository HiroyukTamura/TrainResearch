package p122k.p123a.p124a.p125a.p127F;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import p122k.p123a.p124a.p125a.C2352C;
import p122k.p123a.p124a.p125a.p126E.C2391c;
import p122k.p123a.p124a.p125a.p126E.C2395c0;
import p122k.p123a.p124a.p125a.p126E.C2414q;

/* renamed from: k.a.a.a.F.b */
public class C2426b {

    /* renamed from: a */
    public final Map<C2428d, C2428d> f3961a = new HashMap();

    /* renamed from: b */
    public volatile C2428d f3962b;

    /* renamed from: c */
    public final int f3963c;

    /* renamed from: d */
    public final C2414q f3964d;

    /* renamed from: e */
    private final boolean f3965e;

    public C2426b(C2414q qVar, int i) {
        this.f3964d = qVar;
        this.f3963c = i;
        boolean z = true;
        if (!(qVar instanceof C2395c0) || !((C2395c0) qVar).f3900j) {
            z = false;
        } else {
            C2428d dVar = new C2428d(new C2391c(true));
            dVar.f3970c = new C2428d[0];
            dVar.f3971d = false;
            dVar.f3974g = false;
            this.f3962b = dVar;
        }
        this.f3965e = z;
    }

    /* renamed from: a */
    public final C2428d mo34185a(int i) {
        if (!this.f3965e) {
            throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
        } else if (i < 0 || i >= this.f3962b.f3970c.length) {
            return null;
        } else {
            return this.f3962b.f3970c[i];
        }
    }

    /* renamed from: a */
    public final boolean mo34187a() {
        return this.f3965e;
    }

    public String toString() {
        return this.f3962b == null ? "" : new C2427c(this, C2352C.f3822e).toString();
    }

    /* renamed from: a */
    public final void mo34186a(int i, C2428d dVar) {
        if (!this.f3965e) {
            throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
        } else if (i >= 0) {
            synchronized (this.f3962b) {
                if (i >= this.f3962b.f3970c.length) {
                    this.f3962b.f3970c = (C2428d[]) Arrays.copyOf(this.f3962b.f3970c, i + 1);
                }
                this.f3962b.f3970c[i] = dVar;
            }
        }
    }
}
