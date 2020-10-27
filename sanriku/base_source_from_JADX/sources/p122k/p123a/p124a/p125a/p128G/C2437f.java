package p122k.p123a.p124a.p125a.p128G;

import java.util.Arrays;
import p041io.realm.internal.OsCollectionChangeSet;

/* renamed from: k.a.a.a.G.f */
public class C2437f {

    /* renamed from: c */
    private static int[] f3996c = new int[0];

    /* renamed from: a */
    private int[] f3997a = f3996c;

    /* renamed from: b */
    private int f3998b;

    /* renamed from: a */
    public final void mo34236a() {
        Arrays.fill(this.f3997a, 0, this.f3998b, 0);
        this.f3998b = 0;
    }

    /* renamed from: a */
    public final void mo34237a(int i) {
        int[] iArr = this.f3997a;
        int length = iArr.length;
        int i2 = this.f3998b;
        if (length == i2) {
            int i3 = i2 + 1;
            if (i3 < 0 || i3 > 2147483639) {
                throw new OutOfMemoryError();
            }
            int length2 = iArr.length == 0 ? 4 : iArr.length;
            while (length2 < i3) {
                int i4 = length2 * 2;
                if (i4 < 0 || i4 > 2147483639) {
                    i4 = OsCollectionChangeSet.MAX_ARRAY_LENGTH;
                }
            }
            this.f3997a = Arrays.copyOf(this.f3997a, length2);
        }
        int[] iArr2 = this.f3997a;
        int i5 = this.f3998b;
        iArr2[i5] = i;
        this.f3998b = i5 + 1;
    }

    /* renamed from: b */
    public final int mo34238b(int i) {
        if (i >= 0 && i < this.f3998b) {
            return this.f3997a[i];
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: b */
    public final boolean mo34239b() {
        return this.f3998b == 0;
    }

    /* renamed from: c */
    public final int mo34240c() {
        return this.f3998b;
    }

    /* renamed from: c */
    public final int mo34241c(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.f3998b)) {
            throw new IndexOutOfBoundsException();
        }
        int[] iArr = this.f3997a;
        int i3 = iArr[i];
        System.arraycopy(iArr, i + 1, iArr, i, (i2 - i) - 1);
        int[] iArr2 = this.f3997a;
        int i4 = this.f3998b;
        iArr2[i4 - 1] = 0;
        this.f3998b = i4 - 1;
        return i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2437f)) {
            return false;
        }
        C2437f fVar = (C2437f) obj;
        if (this.f3998b != fVar.f3998b) {
            return false;
        }
        for (int i = 0; i < this.f3998b; i++) {
            if (this.f3997a[i] != fVar.f3997a[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3998b; i2++) {
            i = (i * 31) + this.f3997a[i2];
        }
        return i;
    }

    public String toString() {
        int i = this.f3998b;
        return Arrays.toString(i == 0 ? f3996c : Arrays.copyOf(this.f3997a, i));
    }
}
