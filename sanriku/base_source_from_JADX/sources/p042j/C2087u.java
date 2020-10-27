package p042j;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.u */
public final class C2087u {
    @JvmField

    /* renamed from: a */
    public final byte[] f2924a;
    @JvmField

    /* renamed from: b */
    public int f2925b;
    @JvmField

    /* renamed from: c */
    public int f2926c;
    @JvmField

    /* renamed from: d */
    public boolean f2927d;
    @JvmField

    /* renamed from: e */
    public boolean f2928e;
    @JvmField

    /* renamed from: f */
    public C2087u f2929f;
    @JvmField

    /* renamed from: g */
    public C2087u f2930g;

    public C2087u() {
        this.f2924a = new byte[8192];
        this.f2928e = true;
        this.f2927d = false;
    }

    public C2087u(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f2924a = bArr;
        this.f2925b = i;
        this.f2926c = i2;
        this.f2927d = z;
        this.f2928e = z2;
    }

    /* renamed from: a */
    public final C2087u mo29248a() {
        C2087u uVar = this.f2929f;
        if (uVar == this) {
            uVar = null;
        }
        C2087u uVar2 = this.f2930g;
        if (uVar2 == null) {
            Intrinsics.throwNpe();
        }
        uVar2.f2929f = this.f2929f;
        C2087u uVar3 = this.f2929f;
        if (uVar3 == null) {
            Intrinsics.throwNpe();
        }
        uVar3.f2930g = this.f2930g;
        this.f2929f = null;
        this.f2930g = null;
        return uVar;
    }

    /* renamed from: a */
    public final C2087u mo29249a(C2087u uVar) {
        Intrinsics.checkParameterIsNotNull(uVar, "segment");
        uVar.f2930g = this;
        uVar.f2929f = this.f2929f;
        C2087u uVar2 = this.f2929f;
        if (uVar2 == null) {
            Intrinsics.throwNpe();
        }
        uVar2.f2930g = uVar;
        this.f2929f = uVar;
        return uVar;
    }

    /* renamed from: a */
    public final void mo29250a(C2087u uVar, int i) {
        Intrinsics.checkParameterIsNotNull(uVar, "sink");
        if (uVar.f2928e) {
            int i2 = uVar.f2926c;
            if (i2 + i > 8192) {
                if (!uVar.f2927d) {
                    int i3 = uVar.f2925b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = uVar.f2924a;
                        byte[] unused = ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr, 0, i3, i2, 2, (Object) null);
                        uVar.f2926c -= uVar.f2925b;
                        uVar.f2925b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f2924a;
            byte[] bArr3 = uVar.f2924a;
            int i4 = uVar.f2926c;
            int i5 = this.f2925b;
            byte[] unused2 = ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr3, i4, i5, i5 + i);
            uVar.f2926c += i;
            this.f2925b += i;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    /* renamed from: b */
    public final C2087u mo29251b() {
        this.f2927d = true;
        return new C2087u(this.f2924a, this.f2925b, this.f2926c, true, false);
    }
}
