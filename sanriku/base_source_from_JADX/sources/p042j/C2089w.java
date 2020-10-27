package p042j;

import com.google.android.gms.fitness.FitnessActivities;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: j.w */
public final class C2089w extends C2073i {

    /* renamed from: f */
    private final transient byte[][] f2934f;

    /* renamed from: g */
    private final transient int[] f2935g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2089w(byte[][] bArr, int[] iArr) {
        super(C2073i.f2894d.mo29209b());
        Intrinsics.checkParameterIsNotNull(bArr, "segments");
        Intrinsics.checkParameterIsNotNull(iArr, "directory");
        this.f2934f = bArr;
        this.f2935g = iArr;
    }

    /* renamed from: l */
    private final C2073i m3624l() {
        return new C2073i(mo29256k());
    }

    /* renamed from: a */
    public C2073i mo29202a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = this.f2934f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f2935g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            instance.update(this.f2934f[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = instance.digest();
        Intrinsics.checkExpressionValueIsNotNull(digest, "digest.digest()");
        return new C2073i(digest);
    }

    /* renamed from: a */
    public String mo29203a() {
        return m3624l().mo29203a();
    }

    /* renamed from: d */
    public int mo29212d() {
        return this.f2935g[this.f2934f.length - 1];
    }

    /* renamed from: e */
    public String mo29213e() {
        return m3624l().mo29213e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2073i) {
            C2073i iVar = (C2073i) obj;
            if (iVar.mo29212d() != mo29212d() || !mo29205a(0, iVar, 0, mo29212d())) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public byte[] mo29215f() {
        return mo29256k();
    }

    /* renamed from: g */
    public C2073i mo29216g() {
        return m3624l().mo29216g();
    }

    public int hashCode() {
        int c = mo29210c();
        if (c != 0) {
            return c;
        }
        int length = this.f2934f.length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.f2935g;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            byte[] bArr = this.f2934f[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        mo29207b(i2);
        return i2;
    }

    /* renamed from: i */
    public final int[] mo29254i() {
        return this.f2935g;
    }

    /* renamed from: j */
    public final byte[][] mo29255j() {
        return this.f2934f;
    }

    /* renamed from: k */
    public byte[] mo29256k() {
        byte[] bArr = new byte[mo29212d()];
        int length = this.f2934f.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.f2935g;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(this.f2934f[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public String toString() {
        return m3624l().toString();
    }

    /* renamed from: a */
    public byte mo29201a(int i) {
        int i2;
        C1532a.m2135a((long) this.f2935g[this.f2934f.length - 1], (long) i, 1);
        int a = C1532a.m2121a(this, i);
        if (a == 0) {
            i2 = 0;
        } else {
            i2 = this.f2935g[a - 1];
        }
        int[] iArr = this.f2935g;
        byte[][] bArr = this.f2934f;
        return bArr[a][(i - i2) + iArr[bArr.length + a]];
    }

    /* renamed from: a */
    public boolean mo29205a(int i, C2073i iVar, int i2, int i3) {
        int i4;
        Intrinsics.checkParameterIsNotNull(iVar, FitnessActivities.OTHER);
        if (i < 0 || i > mo29212d() - i3) {
            return false;
        }
        int i5 = i3 + i;
        int a = C1532a.m2121a(this, i);
        while (i < i5) {
            if (a == 0) {
                i4 = 0;
            } else {
                i4 = this.f2935g[a - 1];
            }
            int[] iArr = this.f2935g;
            int i6 = iArr[this.f2934f.length + a];
            int min = Math.min(i5, (iArr[a] - i4) + i4) - i;
            if (!iVar.mo29206a(i2, this.f2934f[a], (i - i4) + i6, min)) {
                return false;
            }
            i2 += min;
            i += min;
            a++;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo29206a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        Intrinsics.checkParameterIsNotNull(bArr, FitnessActivities.OTHER);
        if (i < 0 || i > mo29212d() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i5 = i3 + i;
        int a = C1532a.m2121a(this, i);
        while (i < i5) {
            if (a == 0) {
                i4 = 0;
            } else {
                i4 = this.f2935g[a - 1];
            }
            int[] iArr = this.f2935g;
            int i6 = iArr[this.f2934f.length + a];
            int min = Math.min(i5, (iArr[a] - i4) + i4) - i;
            if (!C1532a.m2144a(this.f2934f[a], (i - i4) + i6, bArr, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            a++;
        }
        return true;
    }

    /* renamed from: a */
    public void mo29204a(C2068f fVar, int i, int i2) {
        int i3;
        Intrinsics.checkParameterIsNotNull(fVar, "buffer");
        int i4 = i2 + i;
        int a = C1532a.m2121a(this, i);
        while (i < i4) {
            if (a == 0) {
                i3 = 0;
            } else {
                i3 = this.f2935g[a - 1];
            }
            int[] iArr = this.f2935g;
            int i5 = iArr[this.f2934f.length + a];
            int min = Math.min(i4, (iArr[a] - i3) + i3) - i;
            int i6 = (i - i3) + i5;
            C2087u uVar = new C2087u(this.f2934f[a], i6, i6 + min, true, false);
            C2087u uVar2 = fVar.f2890a;
            if (uVar2 == null) {
                uVar.f2930g = uVar;
                uVar.f2929f = uVar;
                fVar.f2890a = uVar;
            } else {
                C2087u uVar3 = uVar2.f2930g;
                if (uVar3 == null) {
                    Intrinsics.throwNpe();
                }
                uVar3.mo29249a(uVar);
            }
            i += min;
            a++;
        }
        fVar.mo29170j(fVar.size() + ((long) mo29212d()));
    }
}
