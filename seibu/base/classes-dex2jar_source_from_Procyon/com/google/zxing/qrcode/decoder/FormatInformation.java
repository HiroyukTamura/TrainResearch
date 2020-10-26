// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

final class FormatInformation
{
    private static final int[][] FORMAT_INFO_DECODE_LOOKUP;
    private static final int FORMAT_INFO_MASK_QR = 21522;
    private final byte dataMask;
    private final ErrorCorrectionLevel errorCorrectionLevel;
    
    static {
        FORMAT_INFO_DECODE_LOOKUP = new int[][] { { 21522, 0 }, { 20773, 1 }, { 24188, 2 }, { 23371, 3 }, { 17913, 4 }, { 16590, 5 }, { 20375, 6 }, { 19104, 7 }, { 30660, 8 }, { 29427, 9 }, { 32170, 10 }, { 30877, 11 }, { 26159, 12 }, { 25368, 13 }, { 27713, 14 }, { 26998, 15 }, { 5769, 16 }, { 5054, 17 }, { 7399, 18 }, { 6608, 19 }, { 1890, 20 }, { 597, 21 }, { 3340, 22 }, { 2107, 23 }, { 13663, 24 }, { 12392, 25 }, { 16177, 26 }, { 14854, 27 }, { 9396, 28 }, { 8579, 29 }, { 11994, 30 }, { 11245, 31 } };
    }
    
    private FormatInformation(final int n) {
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits(n >> 3 & 0x3);
        this.dataMask = (byte)(n & 0x7);
    }
    
    static FormatInformation decodeFormatInformation(final int n, final int n2) {
        final FormatInformation doDecodeFormatInformation = doDecodeFormatInformation(n, n2);
        if (doDecodeFormatInformation != null) {
            return doDecodeFormatInformation;
        }
        return doDecodeFormatInformation(n ^ 0x5412, n2 ^ 0x5412);
    }
    
    private static FormatInformation doDecodeFormatInformation(final int n, final int n2) {
        int n3 = Integer.MAX_VALUE;
        int n4 = 0;
        final int[][] format_INFO_DECODE_LOOKUP = FormatInformation.FORMAT_INFO_DECODE_LOOKUP;
        int n7;
        for (int length = format_INFO_DECODE_LOOKUP.length, i = 0; i < length; ++i, n4 = n7) {
            final int[] array = format_INFO_DECODE_LOOKUP[i];
            final int n5 = array[0];
            if (n5 == n || n5 == n2) {
                return new FormatInformation(array[1]);
            }
            final int numBitsDiffering = numBitsDiffering(n, n5);
            int n6;
            if (numBitsDiffering < (n6 = n3)) {
                n4 = array[1];
                n6 = numBitsDiffering;
            }
            n3 = n6;
            n7 = n4;
            if (n != n2) {
                final int numBitsDiffering2 = numBitsDiffering(n2, n5);
                n3 = n6;
                n7 = n4;
                if (numBitsDiffering2 < n6) {
                    n7 = array[1];
                    n3 = numBitsDiffering2;
                }
            }
        }
        if (n3 <= 3) {
            return new FormatInformation(n4);
        }
        return null;
    }
    
    static int numBitsDiffering(final int n, final int n2) {
        return Integer.bitCount(n ^ n2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof FormatInformation) {
            final FormatInformation formatInformation = (FormatInformation)o;
            if (this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask) {
                return true;
            }
        }
        return false;
    }
    
    byte getDataMask() {
        return this.dataMask;
    }
    
    ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }
    
    @Override
    public int hashCode() {
        return this.errorCorrectionLevel.ordinal() << 3 | this.dataMask;
    }
}
