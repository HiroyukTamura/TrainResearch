package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0006H\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, mo21739d2 = {"toUByte", "Lkotlin/UByte;", "", "(B)B", "", "(I)B", "", "(J)B", "", "(S)B", "kotlin-stdlib"}, mo21740k = 2, mo21741mv = {1, 1, 16})
public final class UByteKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final byte toUByte(byte b) {
        return UByte.m4646constructorimpl(b);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final byte toUByte(int i) {
        return UByte.m4646constructorimpl((byte) i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final byte toUByte(long j) {
        return UByte.m4646constructorimpl((byte) ((int) j));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final byte toUByte(short s) {
        return UByte.m4646constructorimpl((byte) s);
    }
}
