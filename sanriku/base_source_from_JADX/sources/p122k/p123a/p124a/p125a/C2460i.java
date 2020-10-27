package p122k.p123a.p124a.p125a;

/* renamed from: k.a.a.a.i */
public class C2460i extends C2456e {

    /* renamed from: e */
    protected int f4029e = 0;

    public C2460i(C2479z zVar) {
        super(zVar);
    }

    /* renamed from: c */
    public C2477x mo34029c(int i) {
        mo34294e();
        if (i == 0) {
            return null;
        }
        if (i < 0) {
            return mo34306h(-i);
        }
        int i2 = this.f4016c;
        for (int i3 = 1; i3 < i; i3++) {
            int i4 = i2 + 1;
            if (mo34296g(i4)) {
                i2 = mo34292a(i4, this.f4029e);
            }
        }
        return this.f4015b.get(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo34293e(int i) {
        return mo34292a(i, this.f4029e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public C2477x mo34306h(int i) {
        if (i != 0) {
            int i2 = this.f4016c;
            if (i2 - i >= 0) {
                for (int i3 = 1; i3 <= i && i2 > 0; i3++) {
                    i2--;
                    int i4 = this.f4029e;
                    mo34296g(i2);
                    if (i2 < size()) {
                        while (i2 >= 0) {
                            C2477x xVar = this.f4015b.get(i2);
                            if (xVar.getType() == -1 || xVar.mo34300d() == i4) {
                                break;
                            }
                            i2--;
                        }
                    } else {
                        i2 = size() - 1;
                    }
                }
                if (i2 < 0) {
                    return null;
                }
                return this.f4015b.get(i2);
            }
        }
        return null;
    }
}
