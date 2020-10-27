package p122k.p123a.p124a.p125a;

import java.util.ArrayList;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p122k.p123a.p124a.p125a.p128G.C2439h;

/* renamed from: k.a.a.a.e */
public class C2456e implements C2350A {

    /* renamed from: a */
    protected C2479z f4014a;

    /* renamed from: b */
    protected List<C2477x> f4015b = new ArrayList(100);

    /* renamed from: c */
    protected int f4016c = -1;

    /* renamed from: d */
    protected boolean f4017d;

    public C2456e(C2479z zVar) {
        if (zVar != null) {
            this.f4014a = zVar;
            return;
        }
        throw new NullPointerException("tokenSource cannot be null");
    }

    /* renamed from: a */
    public int mo34280a() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo34292a(int i, int i2) {
        mo34296g(i);
        if (i >= size()) {
            return size() - 1;
        }
        while (true) {
            C2477x xVar = this.f4015b.get(i);
            if (xVar.mo34300d() == i2 || xVar.getType() == -1) {
                return i;
            }
            i++;
            mo34296g(i);
        }
    }

    /* renamed from: a */
    public String mo34028a(C2477x xVar, C2477x xVar2) {
        if (xVar == null || xVar2 == null) {
            return "";
        }
        C2439h a = C2439h.m4146a(xVar.mo34301e(), xVar2.mo34301e());
        int i = a.f4000a;
        int i2 = a.f4001b;
        if (i < 0 || i2 < 0) {
            return "";
        }
        mo34294e();
        do {
        } while (mo34295f(1000) >= 1000);
        if (i2 >= this.f4015b.size()) {
            i2 = this.f4015b.size() - 1;
        }
        StringBuilder sb = new StringBuilder();
        while (i <= i2) {
            C2477x xVar3 = this.f4015b.get(i);
            if (xVar3.getType() == -1) {
                break;
            }
            sb.append(xVar3.getText());
            i++;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo34282a(int i) {
        mo34294e();
        this.f4016c = mo34293e(i);
    }

    /* renamed from: b */
    public int mo34283b() {
        return this.f4016c;
    }

    /* renamed from: b */
    public int mo34284b(int i) {
        return mo34029c(i).getType();
    }

    /* renamed from: c */
    public C2477x mo34029c(int i) {
        throw null;
    }

    /* renamed from: c */
    public C2479z mo34030c() {
        return this.f4014a;
    }

    /* renamed from: d */
    public void mo34285d() {
        int i = this.f4016c;
        boolean z = false;
        if (i >= 0 && (!this.f4017d ? i < this.f4015b.size() : i < this.f4015b.size() - 1)) {
            z = true;
        }
        if (!z && mo34284b(1) == -1) {
            throw new IllegalStateException("cannot consume EOF");
        } else if (mo34296g(this.f4016c + 1)) {
            this.f4016c = mo34293e(this.f4016c + 1);
        }
    }

    /* renamed from: d */
    public void mo34286d(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo34293e(int i) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo34294e() {
        if (this.f4016c == -1) {
            mo34296g(0);
            this.f4016c = mo34293e(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo34295f(int i) {
        if (this.f4017d) {
            return 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            C2477x c = this.f4014a.mo34319c();
            if (c instanceof C2353D) {
                ((C2353D) c).mo34035a(this.f4015b.size());
            }
            this.f4015b.add(c);
            if (c.getType() == -1) {
                this.f4017d = true;
                return i2 + 1;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo34296g(int i) {
        int size = (i - this.f4015b.size()) + 1;
        return size <= 0 || mo34295f(size) >= size;
    }

    public C2477x get(int i) {
        if (i >= 0 && i < this.f4015b.size()) {
            return this.f4015b.get(i);
        }
        StringBuilder b = C0681a.m338b("token index ", i, " out of range 0..");
        b.append(this.f4015b.size() - 1);
        throw new IndexOutOfBoundsException(b.toString());
    }

    public int size() {
        return this.f4015b.size();
    }
}
