package p042j.p118B;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p042j.C2068f;
import p042j.C2081q;
import p042j.C2087u;

/* renamed from: j.B.a */
public final class C2059a {

    /* renamed from: a */
    private static final byte[] f2876a;

    static {
        Intrinsics.checkParameterIsNotNull("0123456789abcdef", "$this$asUtf8ToByteArray");
        byte[] bytes = "0123456789abcdef".getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        f2876a = bytes;
    }

    /* renamed from: a */
    public static final int m3453a(C2068f fVar, C2081q qVar, boolean z) {
        int i;
        int i2;
        int i3;
        C2087u uVar;
        int i4;
        C2068f fVar2 = fVar;
        Intrinsics.checkParameterIsNotNull(fVar2, "$this$selectPrefix");
        Intrinsics.checkParameterIsNotNull(qVar, "options");
        C2087u uVar2 = fVar2.f2890a;
        if (uVar2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = uVar2.f2924a;
        int i5 = uVar2.f2925b;
        int i6 = uVar2.f2926c;
        int[] b = qVar.mo29227b();
        C2087u uVar3 = uVar2;
        int i7 = 0;
        int i8 = -1;
        loop0:
        while (true) {
            int i9 = i7 + 1;
            int i10 = b[i7];
            int i11 = i9 + 1;
            int i12 = b[i9];
            if (i12 != -1) {
                i8 = i12;
            }
            if (uVar3 == null) {
                break;
            }
            if (i10 < 0) {
                int i13 = (i10 * -1) + i11;
                while (true) {
                    int i14 = i5 + 1;
                    int i15 = i11 + 1;
                    if ((bArr[i5] & UByte.MAX_VALUE) != b[i11]) {
                        return i8;
                    }
                    boolean z2 = i15 == i13;
                    if (i14 == i6) {
                        if (uVar3 == null) {
                            Intrinsics.throwNpe();
                        }
                        C2087u uVar4 = uVar3.f2929f;
                        if (uVar4 == null) {
                            Intrinsics.throwNpe();
                        }
                        i4 = uVar4.f2925b;
                        byte[] bArr2 = uVar4.f2924a;
                        i3 = uVar4.f2926c;
                        if (uVar4 != uVar2) {
                            byte[] bArr3 = bArr2;
                            uVar = uVar4;
                            bArr = bArr3;
                        } else if (!z2) {
                            break loop0;
                        } else {
                            bArr = bArr2;
                            uVar = null;
                        }
                    } else {
                        C2087u uVar5 = uVar3;
                        i3 = i6;
                        i4 = i14;
                        uVar = uVar5;
                    }
                    if (z2) {
                        i2 = b[i15];
                        i = i4;
                        i6 = i3;
                        uVar3 = uVar;
                        break;
                    }
                    i5 = i4;
                    i6 = i3;
                    i11 = i15;
                    uVar3 = uVar;
                }
            } else {
                i = i5 + 1;
                byte b2 = bArr[i5] & UByte.MAX_VALUE;
                int i16 = i11 + i10;
                while (i11 != i16) {
                    if (b2 == b[i11]) {
                        i2 = b[i11 + i10];
                        if (i == i6) {
                            uVar3 = uVar3.f2929f;
                            if (uVar3 == null) {
                                Intrinsics.throwNpe();
                            }
                            i = uVar3.f2925b;
                            bArr = uVar3.f2924a;
                            i6 = uVar3.f2926c;
                            if (uVar3 == uVar2) {
                                uVar3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i8;
            }
            if (i2 >= 0) {
                return i2;
            }
            i7 = -i2;
            i5 = i;
        }
        if (z) {
            return -2;
        }
        return i8;
    }

    /* renamed from: a */
    public static final String m3454a(C2068f fVar, long j) {
        String str;
        Intrinsics.checkParameterIsNotNull(fVar, "$this$readUtf8Line");
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (fVar.mo29163h(j3) == ((byte) 13)) {
                str = fVar.mo29167i(j3);
                j2 = 2;
                fVar.skip(j2);
                return str;
            }
        }
        str = fVar.mo29167i(j);
        fVar.skip(j2);
        return str;
    }

    /* renamed from: a */
    public static final byte[] m3455a() {
        return f2876a;
    }
}
