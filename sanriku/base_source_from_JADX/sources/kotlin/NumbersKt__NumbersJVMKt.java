package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\b¨\u0006\u0016"}, mo21739d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, mo21740k = 5, mo21741mv = {1, 1, 16}, mo21743xi = 1, mo21744xs = "kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt extends NumbersKt__BigIntegersKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int countLeadingZeroBits(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int countLeadingZeroBits(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int countOneBits(int i) {
        return Integer.bitCount(i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int countOneBits(long j) {
        return Long.bitCount(j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int countTrailingZeroBits(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int countTrailingZeroBits(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double fromBits(DoubleCompanionObject doubleCompanionObject, long j) {
        return Double.longBitsToDouble(j);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float fromBits(FloatCompanionObject floatCompanionObject, int i) {
        return Float.intBitsToFloat(i);
    }

    @InlineOnly
    private static final boolean isFinite(double d) {
        return !Double.isInfinite(d) && !Double.isNaN(d);
    }

    @InlineOnly
    private static final boolean isFinite(float f) {
        return !Float.isInfinite(f) && !Float.isNaN(f);
    }

    @InlineOnly
    private static final boolean isInfinite(double d) {
        return Double.isInfinite(d);
    }

    @InlineOnly
    private static final boolean isInfinite(float f) {
        return Float.isInfinite(f);
    }

    @InlineOnly
    private static final boolean isNaN(double d) {
        return Double.isNaN(d);
    }

    @InlineOnly
    private static final boolean isNaN(float f) {
        return Float.isNaN(f);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int rotateLeft(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long rotateLeft(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int rotateRight(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long rotateRight(long j, int i) {
        return Long.rotateRight(j, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int takeHighestOneBit(int i) {
        return Integer.highestOneBit(i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long takeHighestOneBit(long j) {
        return Long.highestOneBit(j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int takeLowestOneBit(int i) {
        return Integer.lowestOneBit(i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long takeLowestOneBit(long j) {
        return Long.lowestOneBit(j);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toBits(float f) {
        return Float.floatToIntBits(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toBits(double d) {
        return Double.doubleToLongBits(d);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toRawBits(float f) {
        return Float.floatToRawIntBits(f);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toRawBits(double d) {
        return Double.doubleToRawLongBits(d);
    }
}
