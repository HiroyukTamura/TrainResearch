package p122k.p123a.p124a.p125a;

import p122k.p123a.p124a.p125a.p128G.C2439h;

/* renamed from: k.a.a.a.b */
public class C2453b implements C2457f {

    /* renamed from: a */
    protected char[] f4011a;

    /* renamed from: b */
    protected int f4012b;

    /* renamed from: c */
    protected int f4013c = 0;

    public C2453b(String str) {
        this.f4011a = str.toCharArray();
        this.f4012b = str.length();
    }

    /* renamed from: a */
    public int mo34280a() {
        return -1;
    }

    /* renamed from: a */
    public String mo34281a(C2439h hVar) {
        int i = hVar.f4000a;
        int i2 = hVar.f4001b;
        int i3 = this.f4012b;
        if (i2 >= i3) {
            i2 = i3 - 1;
        }
        return i >= this.f4012b ? "" : new String(this.f4011a, i, (i2 - i) + 1);
    }

    /* renamed from: a */
    public void mo34282a(int i) {
        if (i <= this.f4013c) {
            this.f4013c = i;
            return;
        }
        int min = Math.min(i, this.f4012b);
        while (this.f4013c < min) {
            mo34285d();
        }
    }

    /* renamed from: b */
    public int mo34283b() {
        return this.f4013c;
    }

    /* renamed from: b */
    public int mo34284b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 0) {
            i++;
            if ((this.f4013c + i) - 1 < 0) {
                return -1;
            }
        }
        int i2 = this.f4013c;
        if ((i2 + i) - 1 >= this.f4012b) {
            return -1;
        }
        return this.f4011a[(i2 + i) - 1];
    }

    /* renamed from: d */
    public void mo34285d() {
        int i = this.f4013c;
        int i2 = this.f4012b;
        if (i >= i2) {
            throw new IllegalStateException("cannot consume EOF");
        } else if (i < i2) {
            this.f4013c = i + 1;
        }
    }

    /* renamed from: d */
    public void mo34286d(int i) {
    }

    public int size() {
        return this.f4012b;
    }

    public String toString() {
        return new String(this.f4011a);
    }
}
