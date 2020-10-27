package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\nø\u0001\u0000¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\nø\u0001\u0000¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u0015\u0010C\u001a\u00020\u0005*\u00020%H\bø\u0001\u0000¢\u0006\u0002\u0010D\u001a\u001c\u0010C\u001a\u00020\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010F\u001a\u0015\u0010C\u001a\u00020\b*\u00020/H\bø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010C\u001a\u00020\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%H\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\b*\u00020/H\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\f\u0010J\u001a\u000208*\u000208H\u0007\u001a\f\u0010J\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010K\u001a\u000208*\u0002082\u0006\u0010K\u001a\u00020LH\u0004\u001a\u0015\u0010K\u001a\u00020>*\u00020>2\u0006\u0010K\u001a\u00020MH\u0004\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010N\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010N\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, mo21739d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, mo21740k = 5, mo21741mv = {1, 1, 16}, mo21743xi = 1, mo21744xs = "kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m5532coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare((int) s & UShort.MAX_VALUE, (int) 65535 & s2) < 0 ? s2 : s;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m5533coerceAtLeastJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : i;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m5534coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare((int) b & UByte.MAX_VALUE, (int) b2 & UByte.MAX_VALUE) < 0 ? b2 : b;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m5535coerceAtLeasteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m5536coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare((int) s & UShort.MAX_VALUE, (int) 65535 & s2) > 0 ? s2 : s;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m5537coerceAtMostJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) > 0 ? i2 : i;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m5538coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare((int) b & UByte.MAX_VALUE, (int) b2 & UByte.MAX_VALUE) > 0 ? b2 : b;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m5539coerceAtMosteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [kotlin.ranges.ClosedRange<kotlin.ULong>, java.lang.Object, kotlin.ranges.ClosedRange] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.ExperimentalUnsignedTypes
    @kotlin.SinceKotlin(version = "1.3")
    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long m5540coerceInJPwROB0(long r2, kotlin.ranges.ClosedRange<kotlin.ULong> r4) {
        /*
            java.lang.String r0 = "range"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            boolean r0 = r4 instanceof kotlin.ranges.ClosedFloatingPointRange
            if (r0 == 0) goto L_0x001a
            kotlin.ULong r2 = kotlin.ULong.m4776boximpl(r2)
            kotlin.ranges.ClosedFloatingPointRange r4 = (kotlin.ranges.ClosedFloatingPointRange) r4
            java.lang.Comparable r2 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r2, r4)
            kotlin.ULong r2 = (kotlin.ULong) r2
            long r2 = r2.m4825unboximpl()
            return r2
        L_0x001a:
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x0051
            java.lang.Comparable r0 = r4.getStart()
            kotlin.ULong r0 = (kotlin.ULong) r0
            long r0 = r0.m4825unboximpl()
            int r0 = kotlin.UnsignedKt.ulongCompare(r2, r0)
            if (r0 >= 0) goto L_0x003b
            java.lang.Comparable r2 = r4.getStart()
        L_0x0034:
            kotlin.ULong r2 = (kotlin.ULong) r2
            long r2 = r2.m4825unboximpl()
            goto L_0x0050
        L_0x003b:
            java.lang.Comparable r0 = r4.getEndInclusive()
            kotlin.ULong r0 = (kotlin.ULong) r0
            long r0 = r0.m4825unboximpl()
            int r0 = kotlin.UnsignedKt.ulongCompare(r2, r0)
            if (r0 <= 0) goto L_0x0050
            java.lang.Comparable r2 = r4.getEndInclusive()
            goto L_0x0034
        L_0x0050:
            return r2
        L_0x0051:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Cannot coerce value to an empty range: "
            r3.append(r0)
            r3.append(r4)
            r4 = 46
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            goto L_0x006e
        L_0x006d:
            throw r2
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.URangesKt___URangesKt.m5540coerceInJPwROB0(long, kotlin.ranges.ClosedRange):long");
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m5541coerceInVKSA0NQ(short s, short s2, short s3) {
        short s4 = s2 & UShort.MAX_VALUE;
        short s5 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare((int) s4, (int) s5) <= 0) {
            short s6 = 65535 & s;
            return Intrinsics.compare((int) s6, (int) s4) < 0 ? s2 : Intrinsics.compare((int) s6, (int) s5) > 0 ? s3 : s;
        }
        StringBuilder a = C0681a.m330a("Cannot coerce value to an empty range: maximum ");
        a.append(UShort.m4914toStringimpl(s3));
        a.append(" is less than minimum ");
        a.append(UShort.m4914toStringimpl(s2));
        a.append('.');
        throw new IllegalArgumentException(a.toString());
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m5542coerceInWZ9TVnA(int i, int i2, int i3) {
        if (UnsignedKt.uintCompare(i2, i3) <= 0) {
            return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : UnsignedKt.uintCompare(i, i3) > 0 ? i3 : i;
        }
        StringBuilder a = C0681a.m330a("Cannot coerce value to an empty range: maximum ");
        a.append(UInt.m4750toStringimpl(i3));
        a.append(" is less than minimum ");
        a.append(UInt.m4750toStringimpl(i2));
        a.append('.');
        throw new IllegalArgumentException(a.toString());
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m5543coerceInb33U2AM(byte b, byte b2, byte b3) {
        byte b4 = b2 & UByte.MAX_VALUE;
        byte b5 = b3 & UByte.MAX_VALUE;
        if (Intrinsics.compare((int) b4, (int) b5) <= 0) {
            byte b6 = b & UByte.MAX_VALUE;
            return Intrinsics.compare((int) b6, (int) b4) < 0 ? b2 : Intrinsics.compare((int) b6, (int) b5) > 0 ? b3 : b;
        }
        StringBuilder a = C0681a.m330a("Cannot coerce value to an empty range: maximum ");
        a.append(UByte.m4681toStringimpl(b3));
        a.append(" is less than minimum ");
        a.append(UByte.m4681toStringimpl(b2));
        a.append('.');
        throw new IllegalArgumentException(a.toString());
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m5544coerceInsambcqE(long j, long j2, long j3) {
        if (UnsignedKt.ulongCompare(j2, j3) <= 0) {
            return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : UnsignedKt.ulongCompare(j, j3) > 0 ? j3 : j;
        }
        StringBuilder a = C0681a.m330a("Cannot coerce value to an empty range: maximum ");
        a.append(ULong.m4819toStringimpl(j3));
        a.append(" is less than minimum ");
        a.append(ULong.m4819toStringimpl(j2));
        a.append('.');
        throw new IllegalArgumentException(a.toString());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.ranges.ClosedRange<kotlin.UInt>, java.lang.Object, kotlin.ranges.ClosedRange] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.ExperimentalUnsignedTypes
    @kotlin.SinceKotlin(version = "1.3")
    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int m5545coerceInwuiCnnA(int r2, kotlin.ranges.ClosedRange<kotlin.UInt> r3) {
        /*
            java.lang.String r0 = "range"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            boolean r0 = r3 instanceof kotlin.ranges.ClosedFloatingPointRange
            if (r0 == 0) goto L_0x001a
            kotlin.UInt r2 = kotlin.UInt.m4707boximpl(r2)
            kotlin.ranges.ClosedFloatingPointRange r3 = (kotlin.ranges.ClosedFloatingPointRange) r3
            java.lang.Comparable r2 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r2, r3)
            kotlin.UInt r2 = (kotlin.UInt) r2
            int r2 = r2.m4756unboximpl()
            return r2
        L_0x001a:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0051
            java.lang.Comparable r0 = r3.getStart()
            kotlin.UInt r0 = (kotlin.UInt) r0
            int r0 = r0.m4756unboximpl()
            int r0 = kotlin.UnsignedKt.uintCompare(r2, r0)
            if (r0 >= 0) goto L_0x003b
            java.lang.Comparable r2 = r3.getStart()
        L_0x0034:
            kotlin.UInt r2 = (kotlin.UInt) r2
            int r2 = r2.m4756unboximpl()
            goto L_0x0050
        L_0x003b:
            java.lang.Comparable r0 = r3.getEndInclusive()
            kotlin.UInt r0 = (kotlin.UInt) r0
            int r0 = r0.m4756unboximpl()
            int r0 = kotlin.UnsignedKt.uintCompare(r2, r0)
            if (r0 <= 0) goto L_0x0050
            java.lang.Comparable r2 = r3.getEndInclusive()
            goto L_0x0034
        L_0x0050:
            return r2
        L_0x0051:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot coerce value to an empty range: "
            r0.append(r1)
            r0.append(r3)
            r3 = 46
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            goto L_0x006e
        L_0x006d:
            throw r2
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.URangesKt___URangesKt.m5545coerceInwuiCnnA(int, kotlin.ranges.ClosedRange):int");
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m5546contains68kG9v0(UIntRange uIntRange, byte b) {
        Intrinsics.checkParameterIsNotNull(uIntRange, "$this$contains");
        return uIntRange.m5529containsWZ4Q5Ns(UInt.m4713constructorimpl(b & UByte.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    private static final boolean m5547containsGYNo2lE(ULongRange uLongRange, ULong uLong) {
        Intrinsics.checkParameterIsNotNull(uLongRange, "$this$contains");
        return uLong != null && uLongRange.m5531containsVKZWuLQ(uLong.m4825unboximpl());
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m5548containsGab390E(ULongRange uLongRange, int i) {
        Intrinsics.checkParameterIsNotNull(uLongRange, "$this$contains");
        return uLongRange.m5531containsVKZWuLQ(ULong.m4782constructorimpl(((long) i) & 4294967295L));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m5549containsULbyJY(ULongRange uLongRange, byte b) {
        Intrinsics.checkParameterIsNotNull(uLongRange, "$this$contains");
        return uLongRange.m5531containsVKZWuLQ(ULong.m4782constructorimpl(((long) b) & 255));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m5550containsZsK3CEQ(UIntRange uIntRange, short s) {
        Intrinsics.checkParameterIsNotNull(uIntRange, "$this$contains");
        return uIntRange.m5529containsWZ4Q5Ns(UInt.m4713constructorimpl(s & UShort.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: contains-biwQdVI  reason: not valid java name */
    private static final boolean m5551containsbiwQdVI(UIntRange uIntRange, UInt uInt) {
        Intrinsics.checkParameterIsNotNull(uIntRange, "$this$contains");
        return uInt != null && uIntRange.m5529containsWZ4Q5Ns(uInt.m4756unboximpl());
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m5552containsfz5IDCE(UIntRange uIntRange, long j) {
        Intrinsics.checkParameterIsNotNull(uIntRange, "$this$contains");
        return ULong.m4782constructorimpl(j >>> 32) == 0 && uIntRange.m5529containsWZ4Q5Ns(UInt.m4713constructorimpl((int) j));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m5553containsuhHAxoY(ULongRange uLongRange, short s) {
        Intrinsics.checkParameterIsNotNull(uLongRange, "$this$contains");
        return uLongRange.m5531containsVKZWuLQ(ULong.m4782constructorimpl(((long) s) & 65535));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m5554downTo5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.m5528fromClosedRangeNkh28Cs(UInt.m4713constructorimpl(s & UShort.MAX_VALUE), UInt.m4713constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m5555downToJ1ME1BU(int i, int i2) {
        return UIntProgression.Companion.m5528fromClosedRangeNkh28Cs(i, i2, -1);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m5556downToKr8caGY(byte b, byte b2) {
        return UIntProgression.Companion.m5528fromClosedRangeNkh28Cs(UInt.m4713constructorimpl(b & UByte.MAX_VALUE), UInt.m4713constructorimpl(b2 & UByte.MAX_VALUE), -1);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m5557downToeb3DHEI(long j, long j2) {
        return ULongProgression.Companion.m5530fromClosedRange7ftBX0g(j, j2, -1);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int random(UIntRange uIntRange) {
        return random(uIntRange, (Random) Random.Default);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int random(UIntRange uIntRange, Random random) {
        Intrinsics.checkParameterIsNotNull(uIntRange, "$this$random");
        Intrinsics.checkParameterIsNotNull(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long random(ULongRange uLongRange) {
        return random(uLongRange, (Random) Random.Default);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final long random(ULongRange uLongRange, Random random) {
        Intrinsics.checkParameterIsNotNull(uLongRange, "$this$random");
        Intrinsics.checkParameterIsNotNull(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final UInt randomOrNull(UIntRange uIntRange) {
        return randomOrNull(uIntRange, (Random) Random.Default);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final UInt randomOrNull(UIntRange uIntRange, Random random) {
        Intrinsics.checkParameterIsNotNull(uIntRange, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m4707boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final ULong randomOrNull(ULongRange uLongRange) {
        return randomOrNull(uLongRange, (Random) Random.Default);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final ULong randomOrNull(ULongRange uLongRange, Random random) {
        Intrinsics.checkParameterIsNotNull(uLongRange, "$this$randomOrNull");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m4776boximpl(URandomKt.nextULong(random, uLongRange));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkParameterIsNotNull(uIntProgression, "$this$reversed");
        return UIntProgression.Companion.m5528fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkParameterIsNotNull(uLongProgression, "$this$reversed");
        return ULongProgression.Companion.m5530fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final UIntProgression step(UIntProgression uIntProgression, int i) {
        Intrinsics.checkParameterIsNotNull(uIntProgression, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m5528fromClosedRangeNkh28Cs(first, last, i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final ULongProgression step(ULongProgression uLongProgression, long j) {
        Intrinsics.checkParameterIsNotNull(uLongProgression, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m5530fromClosedRange7ftBX0g(first, last, j);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m5558until5PvTz6A(short s, short s2) {
        short s3 = s2 & UShort.MAX_VALUE;
        return Intrinsics.compare((int) s3, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m4713constructorimpl(s & UShort.MAX_VALUE), UInt.m4713constructorimpl(UInt.m4713constructorimpl(s3) - 1), (DefaultConstructorMarker) null);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m5559untilJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i2, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(i, UInt.m4713constructorimpl(i2 - 1), (DefaultConstructorMarker) null);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m5560untilKr8caGY(byte b, byte b2) {
        byte b3 = b2 & UByte.MAX_VALUE;
        return Intrinsics.compare((int) b3, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m4713constructorimpl(b & UByte.MAX_VALUE), UInt.m4713constructorimpl(UInt.m4713constructorimpl(b3) - 1), (DefaultConstructorMarker) null);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m5561untileb3DHEI(long j, long j2) {
        if (UnsignedKt.ulongCompare(j2, 0) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }
        return new ULongRange(j, ULong.m4782constructorimpl(j2 - ULong.m4782constructorimpl(((long) 1) & 4294967295L)), (DefaultConstructorMarker) null);
    }
}
