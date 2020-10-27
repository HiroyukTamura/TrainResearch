package kotlin.text;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, mo21739d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, mo21740k = 2, mo21741mv = {1, 1, 16})
@JvmName(name = "UStringsKt")
public final class UStringsKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: toString-JSWoG40  reason: not valid java name */
    public static final String m5566toStringJSWoG40(long j, int i) {
        return UnsignedKt.ulongToString(j, CharsKt__CharJVMKt.checkRadix(i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: toString-LxnNnR4  reason: not valid java name */
    public static final String m5567toStringLxnNnR4(byte b, int i) {
        String num = Integer.toString(b & UByte.MAX_VALUE, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: toString-V7xB4Y4  reason: not valid java name */
    public static final String m5568toStringV7xB4Y4(int i, int i2) {
        String l = Long.toString(((long) i) & 4294967295L, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkExpressionValueIsNotNull(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: toString-olVBNx4  reason: not valid java name */
    public static final String m5569toStringolVBNx4(short s, int i) {
        String num = Integer.toString(s & UShort.MAX_VALUE, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final byte toUByte(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.m4687unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final byte toUByte(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(str, i);
        if (uByteOrNull != null) {
            return uByteOrNull.m4687unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UByte toUByteOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUByteOrNull");
        return toUByteOrNull(str, 10);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UByte toUByteOrNull(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUByteOrNull");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int r1 = uIntOrNull.m4756unboximpl();
        if (UnsignedKt.uintCompare(r1, UInt.m4713constructorimpl(255)) > 0) {
            return null;
        }
        return UByte.m4640boximpl(UByte.m4646constructorimpl((byte) r1));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int toUInt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.m4756unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int toUInt(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull != null) {
            return uIntOrNull.m4756unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UInt toUIntOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUIntOrNull");
        return toUIntOrNull(str, 10);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UInt toUIntOrNull(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUIntOrNull");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        int i3 = 1;
        if (charAt >= '0') {
            i3 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int r5 = UInt.m4713constructorimpl(i);
        int i4 = 119304647;
        while (i3 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i3), i);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.uintCompare(i2, i4) > 0) {
                if (i4 == 119304647) {
                    i4 = UnsignedKt.m4939uintDivideJ1ME1BU(-1, r5);
                    if (UnsignedKt.uintCompare(i2, i4) > 0) {
                    }
                }
                return null;
            }
            int r3 = UInt.m4713constructorimpl(i2 * r5);
            int r8 = UInt.m4713constructorimpl(UInt.m4713constructorimpl(digitOf) + r3);
            if (UnsignedKt.uintCompare(r8, r3) < 0) {
                return null;
            }
            i3++;
            i2 = r8;
        }
        return UInt.m4707boximpl(i2);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final long toULong(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.m4825unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final long toULong(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(str, i);
        if (uLongOrNull != null) {
            return uLongOrNull.m4825unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final ULong toULongOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toULongOrNull");
        return toULongOrNull(str, 10);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final ULong toULongOrNull(String str, int i) {
        String str2 = str;
        int i2 = i;
        Intrinsics.checkParameterIsNotNull(str2, "$this$toULongOrNull");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j = -1;
        int i3 = 0;
        char charAt = str2.charAt(0);
        if (charAt < '0') {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i3 = 1;
        }
        long r9 = ULong.m4782constructorimpl((long) i2);
        long j2 = 0;
        long j3 = 512409557603043100L;
        while (i3 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str2.charAt(i3), i2);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.ulongCompare(j2, j3) > 0) {
                if (j3 == 512409557603043100L) {
                    j3 = UnsignedKt.m4941ulongDivideeb3DHEI(j, r9);
                    if (UnsignedKt.ulongCompare(j2, j3) > 0) {
                    }
                }
                return null;
            }
            long r11 = ULong.m4782constructorimpl(j2 * r9);
            long r4 = ULong.m4782constructorimpl(ULong.m4782constructorimpl(((long) UInt.m4713constructorimpl(digitOf)) & 4294967295L) + r11);
            if (UnsignedKt.ulongCompare(r4, r11) < 0) {
                return null;
            }
            i3++;
            j2 = r4;
            j = -1;
        }
        return ULong.m4776boximpl(j2);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final short toUShort(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.m4920unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final short toUShort(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(str, i);
        if (uShortOrNull != null) {
            return uShortOrNull.m4920unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw null;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UShort toUShortOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUShortOrNull");
        return toUShortOrNull(str, 10);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UShort toUShortOrNull(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUShortOrNull");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int r1 = uIntOrNull.m4756unboximpl();
        if (UnsignedKt.uintCompare(r1, UInt.m4713constructorimpl(65535)) > 0) {
            return null;
        }
        return UShort.m4873boximpl(UShort.m4879constructorimpl((short) r1));
    }
}
