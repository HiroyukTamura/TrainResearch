package p042j;

import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@JvmName(name = "-Base64")
/* renamed from: j.a */
public final class C2061a {

    /* renamed from: a */
    private static final byte[] f2878a = C2073i.f2895e.mo29221b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").mo29209b();

    static {
        C2073i.f2895e.mo29221b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }

    /* renamed from: a */
    public static /* synthetic */ String m3458a(byte[] bArr, byte[] bArr2, int i) {
        if ((i & 1) != 0) {
            bArr2 = f2878a;
        }
        Intrinsics.checkParameterIsNotNull(bArr, "$this$encodeBase64");
        Intrinsics.checkParameterIsNotNull(bArr2, "map");
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            int i6 = i5 + 1;
            byte b3 = bArr[i5];
            int i7 = i3 + 1;
            bArr3[i3] = bArr2[(b & UByte.MAX_VALUE) >> 2];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b & 3) << 4) | ((b2 & UByte.MAX_VALUE) >> 4)];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[((b2 & 15) << 2) | ((b3 & UByte.MAX_VALUE) >> 6)];
            i3 = i9 + 1;
            bArr3[i9] = bArr2[b3 & 63];
            i2 = i6;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i2];
            int i10 = i3 + 1;
            bArr3[i3] = bArr2[(b4 & UByte.MAX_VALUE) >> 2];
            int i11 = i10 + 1;
            bArr3[i10] = bArr2[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr3[i11] = b5;
            bArr3[i11 + 1] = b5;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            byte b6 = bArr[i2];
            byte b7 = bArr[i12];
            int i13 = i3 + 1;
            bArr3[i3] = bArr2[(b6 & UByte.MAX_VALUE) >> 2];
            int i14 = i13 + 1;
            bArr3[i13] = bArr2[((b6 & 3) << 4) | ((b7 & UByte.MAX_VALUE) >> 4)];
            bArr3[i14] = bArr2[(b7 & 15) << 2];
            bArr3[i14 + 1] = (byte) 61;
        }
        Intrinsics.checkParameterIsNotNull(bArr3, "$this$toUtf8String");
        return new String(bArr3, Charsets.UTF_8);
    }

    /* renamed from: a */
    public static final byte[] m3459a(String str) {
        int i;
        Intrinsics.checkParameterIsNotNull(str, "$this$decodeBase64ToArray");
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == 10 || r5 == 13 || r5 == ' ' || r5 == 9)) {
            length--;
        }
        int i2 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if ('A' <= charAt && 'Z' >= charAt) {
                i = charAt - 'A';
            } else if ('a' <= charAt && 'z' >= charAt) {
                i = charAt - 'G';
            } else if ('0' <= charAt && '9' >= charAt) {
                i = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i = 62;
            } else if (charAt == '/' || charAt == '_') {
                i = 63;
            } else {
                if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                int i7 = i5 + 1;
                bArr[i5] = (byte) (i4 >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i4 >> 8);
                bArr[i8] = (byte) i4;
                i5 = i8 + 1;
            }
        }
        int i9 = i3 % 4;
        if (i9 == 1) {
            return null;
        }
        if (i9 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i9 == 3) {
            int i10 = i4 << 6;
            int i11 = i5 + 1;
            bArr[i5] = (byte) (i10 >> 16);
            i5 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 8);
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i5);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }
}
