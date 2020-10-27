package p040i.p103M.p110i;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;
import p042j.C2073i;

/* renamed from: i.M.i.e */
public final class C1840e {
    @JvmField

    /* renamed from: a */
    public static final C2073i f2506a = C2073i.f2895e.mo29221b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    private static final String[] f2507b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    private static final String[] f2508c = new String[64];

    /* renamed from: d */
    private static final String[] f2509d;

    /* renamed from: e */
    public static final C1840e f2510e = new C1840e();

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkExpressionValueIsNotNull(binaryString, "Integer.toBinaryString(it)");
            strArr[i] = StringsKt__StringsJVMKt.replace$default(C1764b.m2621a("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        f2509d = strArr;
        String[] strArr2 = f2508c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i2 = 0; i2 < 1; i2++) {
            int i3 = iArr[i2];
            String[] strArr3 = f2508c;
            strArr3[i3 | 8] = Intrinsics.stringPlus(strArr3[i3], "|PADDED");
        }
        String[] strArr4 = f2508c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 < 1; i6++) {
                int i7 = iArr[i6];
                String[] strArr5 = f2508c;
                int i8 = i7 | i5;
                strArr5[i8] = f2508c[i7] + "|" + f2508c[i5];
                StringBuilder sb = new StringBuilder();
                sb.append(f2508c[i7]);
                sb.append("|");
                f2508c[i8 | 8] = C0681a.m324a(sb, f2508c[i5], "|PADDED");
            }
        }
        int length = f2508c.length;
        for (int i9 = 0; i9 < length; i9++) {
            String[] strArr6 = f2508c;
            if (strArr6[i9] == null) {
                strArr6[i9] = f2509d[i9];
            }
        }
    }

    private C1840e() {
    }

    /* renamed from: a */
    public final String mo27822a(boolean z, int i, int i2, int i3, int i4) {
        String str;
        String str2;
        String str3;
        String str4;
        int i5 = i3;
        int i6 = i4;
        String[] strArr = f2507b;
        String a = i5 < strArr.length ? strArr[i5] : C1764b.m2621a("0x%02x", Integer.valueOf(i3));
        if (i6 == 0) {
            str = "";
        } else {
            if (!(i5 == 2 || i5 == 3)) {
                if (i5 == 4 || i5 == 6) {
                    str = i6 == 1 ? "ACK" : f2509d[i6];
                } else if (!(i5 == 7 || i5 == 8)) {
                    String[] strArr2 = f2508c;
                    if (i6 < strArr2.length) {
                        str2 = strArr2[i6];
                        if (str2 == null) {
                            Intrinsics.throwNpe();
                        }
                    } else {
                        str2 = f2509d[i6];
                    }
                    String str5 = str2;
                    if (i5 == 5 && (i6 & 4) != 0) {
                        str3 = "HEADERS";
                        str4 = "PUSH_PROMISE";
                    } else if (i5 != 0 || (i6 & 32) == 0) {
                        str = str5;
                    } else {
                        str3 = "PRIORITY";
                        str4 = "COMPRESSED";
                    }
                    str = StringsKt__StringsJVMKt.replace$default(str5, str3, str4, false, 4, (Object) null);
                }
            }
            str = f2509d[i6];
        }
        return C1764b.m2621a("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), a, str);
    }
}
