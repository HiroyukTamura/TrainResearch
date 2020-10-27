package p040i.p103M.p110i;

import com.google.android.gms.fitness.FitnessActivities;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.i.n */
public final class C1871n {

    /* renamed from: a */
    private int f2647a;

    /* renamed from: b */
    private final int[] f2648b = new int[10];

    /* renamed from: a */
    public final int mo27945a() {
        if ((this.f2647a & 2) != 0) {
            return this.f2648b[1];
        }
        return -1;
    }

    /* renamed from: a */
    public final int mo27946a(int i) {
        return this.f2648b[i];
    }

    /* renamed from: a */
    public final C1871n mo27947a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f2648b;
            if (i < iArr.length) {
                this.f2647a = (1 << i) | this.f2647a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* renamed from: a */
    public final void mo27948a(C1871n nVar) {
        Intrinsics.checkParameterIsNotNull(nVar, FitnessActivities.OTHER);
        for (int i = 0; i < 10; i++) {
            boolean z = true;
            if (((1 << i) & nVar.f2647a) == 0) {
                z = false;
            }
            if (z) {
                mo27947a(i, nVar.f2648b[i]);
            }
        }
    }

    /* renamed from: b */
    public final int mo27949b() {
        if ((this.f2647a & 128) != 0) {
            return this.f2648b[7];
        }
        return 65535;
    }

    /* renamed from: b */
    public final int mo27950b(int i) {
        return (this.f2647a & 32) != 0 ? this.f2648b[5] : i;
    }

    /* renamed from: c */
    public final int mo27951c() {
        if ((this.f2647a & 16) != 0) {
            return this.f2648b[4];
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: c */
    public final boolean mo27952c(int i) {
        return ((1 << i) & this.f2647a) != 0;
    }

    /* renamed from: d */
    public final int mo27953d() {
        return Integer.bitCount(this.f2647a);
    }
}
