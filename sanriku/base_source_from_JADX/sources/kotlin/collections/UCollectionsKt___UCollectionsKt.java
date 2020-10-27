package kotlin.collections;

import java.util.Collection;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u001a\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo21739d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, mo21740k = 5, mo21741mv = {1, 1, 16}, mo21743xi = 1, mo21744xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$sum");
        int i = 0;
        for (UByte r1 : iterable) {
            i = UInt.m4713constructorimpl(UInt.m4713constructorimpl(r1.m4687unboximpl() & UByte.MAX_VALUE) + i);
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$sum");
        int i = 0;
        for (UInt r1 : iterable) {
            i = UInt.m4713constructorimpl(r1.m4756unboximpl() + i);
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$sum");
        long j = 0;
        for (ULong r2 : iterable) {
            j = ULong.m4782constructorimpl(r2.m4825unboximpl() + j);
        }
        return j;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$sum");
        int i = 0;
        for (UShort r1 : iterable) {
            i = UInt.m4713constructorimpl(UInt.m4713constructorimpl(r1.m4920unboximpl() & UShort.MAX_VALUE) + i);
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "$this$toUByteArray");
        byte[] r0 = UByteArray.m4689constructorimpl(collection.size());
        int i = 0;
        for (UByte r2 : collection) {
            UByteArray.m4700setVurrAj0(r0, i, r2.m4687unboximpl());
            i++;
        }
        return r0;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "$this$toUIntArray");
        int[] r0 = UIntArray.m4758constructorimpl(collection.size());
        int i = 0;
        for (UInt r2 : collection) {
            UIntArray.m4769setVXSXFK8(r0, i, r2.m4756unboximpl());
            i++;
        }
        return r0;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "$this$toULongArray");
        long[] r0 = ULongArray.m4827constructorimpl(collection.size());
        int i = 0;
        for (ULong r2 : collection) {
            ULongArray.m4838setk8EXiF4(r0, i, r2.m4825unboximpl());
            i++;
        }
        return r0;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "$this$toUShortArray");
        short[] r0 = UShortArray.m4922constructorimpl(collection.size());
        int i = 0;
        for (UShort r2 : collection) {
            UShortArray.m4933set01HTLdE(r0, i, r2.m4920unboximpl());
            i++;
        }
        return r0;
    }
}
