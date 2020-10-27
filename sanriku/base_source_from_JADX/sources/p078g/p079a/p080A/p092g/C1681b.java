package p078g.p079a.p080A.p092g;

/* renamed from: g.a.A.g.b */
public final class C1681b<T> {

    /* renamed from: a */
    final float f2032a = 0.75f;

    /* renamed from: b */
    int f2033b;

    /* renamed from: c */
    int f2034c;

    /* renamed from: d */
    int f2035d;

    /* renamed from: e */
    T[] f2036e;

    public C1681b() {
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
        this.f2033b = numberOfLeadingZeros - 1;
        this.f2035d = (int) (0.75f * ((float) numberOfLeadingZeros));
        this.f2036e = new Object[numberOfLeadingZeros];
    }

    /* renamed from: a */
    static int m2366a(int i) {
        int i2 = i * -1640531527;
        return i2 ^ (i2 >>> 16);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27411a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f2034c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a = m2366a(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= a || a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    if (i >= a && a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* renamed from: a */
    public boolean mo27412a(T t) {
        T t2;
        T[] tArr = this.f2036e;
        int i = this.f2033b;
        int a = m2366a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i;
                t2 = tArr[a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a] = t;
        int i2 = this.f2034c + 1;
        this.f2034c = i2;
        if (i2 >= this.f2035d) {
            T[] tArr2 = this.f2036e;
            int length = tArr2.length;
            int i3 = length << 1;
            int i4 = i3 - 1;
            T[] tArr3 = new Object[i3];
            while (true) {
                int i5 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                do {
                    length--;
                } while (tArr2[length] == null);
                int a2 = m2366a(tArr2[length].hashCode()) & i4;
                if (tArr3[a2] != null) {
                    do {
                        a2 = (a2 + 1) & i4;
                    } while (tArr3[a2] != null);
                }
                tArr3[a2] = tArr2[length];
                i2 = i5;
            }
            this.f2033b = i4;
            this.f2035d = (int) (((float) i3) * this.f2032a);
            this.f2036e = tArr3;
        }
        return true;
    }

    /* renamed from: a */
    public Object[] mo27413a() {
        return this.f2036e;
    }

    /* renamed from: b */
    public boolean mo27414b(T t) {
        T t2;
        T[] tArr = this.f2036e;
        int i = this.f2033b;
        int a = m2366a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            mo27411a(a, tArr, i);
            return true;
        }
        do {
            a = (a + 1) & i;
            t2 = tArr[a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        mo27411a(a, tArr, i);
        return true;
    }
}
