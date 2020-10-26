// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

public final class ErrorCorrection
{
    private static final int[] ALOG;
    private static final int[][] FACTORS;
    private static final int[] FACTOR_SETS;
    private static final int[] LOG;
    private static final int MODULO_VALUE = 301;
    
    static {
        FACTOR_SETS = new int[] { 5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68 };
        FACTORS = new int[][] { { 228, 48, 15, 111, 62 }, { 23, 68, 144, 134, 240, 92, 254 }, { 28, 24, 185, 166, 223, 248, 116, 255, 110, 61 }, { 175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120 }, { 41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242 }, { 156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185 }, { 83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188 }, { 15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172 }, { 52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193 }, { 211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255 }, { 245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112 }, { 77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5 }, { 245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19 }, { 175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46 }, { 242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204 }, { 220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186 } };
        LOG = new int[256];
        ALOG = new int[255];
        int n = 1;
        for (int i = 0; i < 255; ++i) {
            ErrorCorrection.ALOG[i] = n;
            ErrorCorrection.LOG[n] = i;
            final int n2 = n << 1;
            if ((n = n2) >= 256) {
                n = (n2 ^ 0x12D);
            }
        }
    }
    
    private ErrorCorrection() {
    }
    
    private static String createECCBlock(final CharSequence charSequence, final int n) {
        return createECCBlock(charSequence, 0, charSequence.length(), n);
    }
    
    private static String createECCBlock(final CharSequence charSequence, int i, final int n, final int j) {
        final int n2 = -1;
        int n3 = 0;
        int n4;
        while (true) {
            n4 = n2;
            if (n3 >= ErrorCorrection.FACTOR_SETS.length) {
                break;
            }
            if (ErrorCorrection.FACTOR_SETS[n3] == j) {
                n4 = n3;
                break;
            }
            ++n3;
        }
        if (n4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + j);
        }
        final int[] array = ErrorCorrection.FACTORS[n4];
        final char[] array2 = new char[j];
        for (int k = 0; k < j; ++k) {
            array2[k] = '\0';
        }
        for (int l = i; l < i + n; ++l) {
            final int n5 = array2[j - 1] ^ charSequence.charAt(l);
            for (int n6 = j - 1; n6 > 0; --n6) {
                if (n5 != 0 && array[n6] != 0) {
                    array2[n6] = (char)(array2[n6 - 1] ^ ErrorCorrection.ALOG[(ErrorCorrection.LOG[n5] + ErrorCorrection.LOG[array[n6]]) % 255]);
                }
                else {
                    array2[n6] = array2[n6 - 1];
                }
            }
            if (n5 != 0 && array[0] != 0) {
                array2[0] = (char)ErrorCorrection.ALOG[(ErrorCorrection.LOG[n5] + ErrorCorrection.LOG[array[0]]) % 255];
            }
            else {
                array2[0] = '\0';
            }
        }
        final char[] data = new char[j];
        for (i = 0; i < j; ++i) {
            data[i] = array2[j - i - 1];
        }
        return String.valueOf(data);
    }
    
    public static String encodeECC200(final String str, final SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        final StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        final int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        }
        else {
            sb.setLength(sb.capacity());
            final int[] array = new int[interleavedBlockCount];
            final int[] array2 = new int[interleavedBlockCount];
            final int[] array3 = new int[interleavedBlockCount];
            for (int i = 0; i < interleavedBlockCount; ++i) {
                array[i] = symbolInfo.getDataLengthForInterleavedBlock(i + 1);
                array2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i + 1);
                array3[i] = 0;
                if (i > 0) {
                    array3[i] = array3[i - 1] + array[i];
                }
            }
            for (int j = 0; j < interleavedBlockCount; ++j) {
                final StringBuilder sb2 = new StringBuilder(array[j]);
                for (int k = j; k < symbolInfo.getDataCapacity(); k += interleavedBlockCount) {
                    sb2.append(str.charAt(k));
                }
                final String eccBlock = createECCBlock(sb2.toString(), array2[j]);
                for (int index = 0, l = j; l < array2[j] * interleavedBlockCount; l += interleavedBlockCount, ++index) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + l, eccBlock.charAt(index));
                }
            }
        }
        return sb.toString();
    }
}
