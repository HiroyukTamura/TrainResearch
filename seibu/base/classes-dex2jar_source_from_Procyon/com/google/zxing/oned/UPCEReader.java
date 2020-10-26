// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

public final class UPCEReader extends UPCEANReader
{
    private static final int[] MIDDLE_END_PATTERN;
    static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS;
    private final int[] decodeMiddleCounters;
    
    static {
        MIDDLE_END_PATTERN = new int[] { 1, 1, 1, 1, 1, 1 };
        NUMSYS_AND_CHECK_DIGIT_PATTERNS = new int[][] { { 56, 52, 50, 49, 44, 38, 35, 42, 41, 37 }, { 7, 11, 13, 14, 19, 25, 28, 21, 22, 26 } };
    }
    
    public UPCEReader() {
        this.decodeMiddleCounters = new int[4];
    }
    
    public static String convertUPCEtoUPCA(final String s) {
        final char[] str = new char[6];
        s.getChars(1, 7, str, 0);
        final StringBuilder sb = new StringBuilder(12);
        sb.append(s.charAt(0));
        final char c = str[5];
        switch (c) {
            default: {
                sb.append(str, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
            }
            case 48:
            case 49:
            case 50: {
                sb.append(str, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(str, 2, 3);
                break;
            }
            case 51: {
                sb.append(str, 0, 3);
                sb.append("00000");
                sb.append(str, 3, 2);
                break;
            }
            case 52: {
                sb.append(str, 0, 4);
                sb.append("00000");
                sb.append(str[4]);
                break;
            }
        }
        if (s.length() >= 8) {
            sb.append(s.charAt(7));
        }
        return sb.toString();
    }
    
    private static void determineNumSysAndCheckDigit(final StringBuilder sb, final int n) throws NotFoundException {
        for (int i = 0; i <= 1; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (n == UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[i][j]) {
                    sb.insert(0, (char)(i + 48));
                    sb.append((char)(j + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    protected boolean checkChecksum(final String s) throws FormatException {
        return super.checkChecksum(convertUPCEtoUPCA(s));
    }
    
    protected int[] decodeEnd(final BitArray bitArray, final int n) throws NotFoundException {
        return UPCEANReader.findGuardPattern(bitArray, n, true, UPCEReader.MIDDLE_END_PATTERN);
    }
    
    @Override
    protected int decodeMiddle(final BitArray bitArray, final int[] array, final StringBuilder sb) throws NotFoundException {
        final int[] decodeMiddleCounters = this.decodeMiddleCounters;
        decodeMiddleCounters[1] = (decodeMiddleCounters[0] = 0);
        decodeMiddleCounters[3] = (decodeMiddleCounters[2] = 0);
        final int size = bitArray.getSize();
        int n = array[1];
        int n2 = 0;
        int n4;
        for (int n3 = 0; n3 < 6 && n < size; ++n3, n2 = n4) {
            final int decodeDigit = UPCEANReader.decodeDigit(bitArray, decodeMiddleCounters, n, UPCEReader.L_AND_G_PATTERNS);
            sb.append((char)(decodeDigit % 10 + 48));
            for (int length = decodeMiddleCounters.length, i = 0; i < length; ++i) {
                n += decodeMiddleCounters[i];
            }
            n4 = n2;
            if (decodeDigit >= 10) {
                n4 = (n2 | 1 << 5 - n3);
            }
        }
        determineNumSysAndCheckDigit(sb, n2);
        return n;
    }
    
    @Override
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_E;
    }
}
