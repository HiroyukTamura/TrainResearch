// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.common.BitArray;

final class MatrixUtil
{
    private static final int[][] POSITION_ADJUSTMENT_PATTERN;
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
    private static final int[][] POSITION_DETECTION_PATTERN;
    private static final int[][] TYPE_INFO_COORDINATES;
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    
    static {
        POSITION_DETECTION_PATTERN = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
        POSITION_ADJUSTMENT_PATTERN = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
        POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, { 6, 22, 38, -1, -1, -1, -1 }, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, { 6, 30, 54, 78, -1, -1, -1 }, { 6, 30, 56, 82, -1, -1, -1 }, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, { 6, 26, 50, 74, 98, 122, -1 }, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, { 6, 34, 60, 86, 112, 138, -1 }, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
        TYPE_INFO_COORDINATES = new int[][] { { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };
    }
    
    private MatrixUtil() {
    }
    
    static void buildMatrix(final BitArray bitArray, final ErrorCorrectionLevel errorCorrectionLevel, final Version version, final int n, final ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, n, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, n, byteMatrix);
    }
    
    static int calculateBCHCode(int n, final int n2) {
        if (n2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int msbSet;
        for (msbSet = findMSBSet(n2), n <<= msbSet - 1; findMSBSet(n) >= msbSet; n ^= n2 << findMSBSet(n) - msbSet) {}
        return n;
    }
    
    static void clearMatrix(final ByteMatrix byteMatrix) {
        byteMatrix.clear((byte)(-1));
    }
    
    static void embedBasicPatterns(final Version version, final ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }
    
    private static void embedDarkDotAtLeftBottomCorner(final ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }
    
    static void embedDataBits(final BitArray bitArray, final int n, final ByteMatrix byteMatrix) throws WriterException {
        int i = 0;
        int n2 = -1;
        int j = byteMatrix.getWidth() - 1;
        int n3 = byteMatrix.getHeight() - 1;
        while (j > 0) {
            int n4 = i;
            int n5 = j;
            int n6 = n3;
            if (j == 6) {
                n5 = j - 1;
                n6 = n3;
                n4 = i;
            }
            while (n6 >= 0 && n6 < byteMatrix.getHeight()) {
                int k = 0;
                int n7 = n4;
                while (k < 2) {
                    final int n8 = n5 - k;
                    int n9 = n7;
                    if (isEmpty(byteMatrix.get(n8, n6))) {
                        int value;
                        if (n7 < bitArray.getSize()) {
                            value = (bitArray.get(n7) ? 1 : 0);
                            ++n7;
                        }
                        else {
                            value = 0;
                        }
                        boolean b = value != 0;
                        if (n != -1) {
                            b = (value != 0);
                            if (MaskUtil.getDataMaskBit(n, n8, n6)) {
                                b = (value == 0);
                            }
                        }
                        byteMatrix.set(n8, n6, b);
                        n9 = n7;
                    }
                    ++k;
                    n7 = n9;
                }
                n6 += n2;
                n4 = n7;
            }
            n2 = -n2;
            n3 = n6 + n2;
            j = n5 - 2;
            i = n4;
        }
        if (i != bitArray.getSize()) {
            throw new WriterException("Not all bits consumed: " + i + '/' + bitArray.getSize());
        }
    }
    
    private static void embedHorizontalSeparationPattern(final int n, final int n2, final ByteMatrix byteMatrix) throws WriterException {
        for (int i = 0; i < 8; ++i) {
            if (!isEmpty(byteMatrix.get(n + i, n2))) {
                throw new WriterException();
            }
            byteMatrix.set(n + i, n2, 0);
        }
    }
    
    private static void embedPositionAdjustmentPattern(final int n, final int n2, final ByteMatrix byteMatrix) {
        for (int i = 0; i < 5; ++i) {
            final int[] array = MatrixUtil.POSITION_ADJUSTMENT_PATTERN[i];
            for (int j = 0; j < 5; ++j) {
                byteMatrix.set(n + j, n2 + i, array[j]);
            }
        }
    }
    
    private static void embedPositionDetectionPattern(final int n, final int n2, final ByteMatrix byteMatrix) {
        for (int i = 0; i < 7; ++i) {
            final int[] array = MatrixUtil.POSITION_DETECTION_PATTERN[i];
            for (int j = 0; j < 7; ++j) {
                byteMatrix.set(n + j, n2 + i, array[j]);
            }
        }
    }
    
    private static void embedPositionDetectionPatternsAndSeparators(final ByteMatrix byteMatrix) throws WriterException {
        final int length = MatrixUtil.POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern(byteMatrix.getHeight() - 7 - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }
    
    private static void embedTimingPatterns(final ByteMatrix byteMatrix) {
        for (int i = 8; i < byteMatrix.getWidth() - 8; ++i) {
            final int n = (i + 1) % 2;
            if (isEmpty(byteMatrix.get(i, 6))) {
                byteMatrix.set(i, 6, n);
            }
            if (isEmpty(byteMatrix.get(6, i))) {
                byteMatrix.set(6, i, n);
            }
        }
    }
    
    static void embedTypeInfo(final ErrorCorrectionLevel errorCorrectionLevel, int i, final ByteMatrix byteMatrix) throws WriterException {
        final BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i, bitArray);
        boolean value;
        int[] array;
        for (i = 0; i < bitArray.getSize(); ++i) {
            value = bitArray.get(bitArray.getSize() - 1 - i);
            array = MatrixUtil.TYPE_INFO_COORDINATES[i];
            byteMatrix.set(array[0], array[1], value);
            if (i < 8) {
                byteMatrix.set(byteMatrix.getWidth() - i - 1, 8, value);
            }
            else {
                byteMatrix.set(8, byteMatrix.getHeight() - 7 + (i - 8), value);
            }
        }
    }
    
    private static void embedVerticalSeparationPattern(final int n, final int n2, final ByteMatrix byteMatrix) throws WriterException {
        for (int i = 0; i < 7; ++i) {
            if (!isEmpty(byteMatrix.get(n, n2 + i))) {
                throw new WriterException();
            }
            byteMatrix.set(n, n2 + i, 0);
        }
    }
    
    static int findMSBSet(final int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }
    
    private static boolean isEmpty(final int n) {
        return n == -1;
    }
    
    static void makeTypeInfoBits(final ErrorCorrectionLevel errorCorrectionLevel, int n, final BitArray bitArray) throws WriterException {
        if (!QRCode.isValidMaskPattern(n)) {
            throw new WriterException("Invalid mask pattern");
        }
        n |= errorCorrectionLevel.getBits() << 3;
        bitArray.appendBits(n, 5);
        bitArray.appendBits(calculateBCHCode(n, 1335), 10);
        final BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(21522, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() != 15) {
            throw new WriterException("should not happen but we got: " + bitArray.getSize());
        }
    }
    
    static void makeVersionInfoBits(final Version version, final BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), 7973), 12);
        if (bitArray.getSize() != 18) {
            throw new WriterException("should not happen but we got: " + bitArray.getSize());
        }
    }
    
    private static void maybeEmbedPositionAdjustmentPatterns(final Version version, final ByteMatrix byteMatrix) {
        if (version.getVersionNumber() >= 2) {
            final int[] array = MatrixUtil.POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
            for (int length = array.length, i = 0; i < length; ++i) {
                final int n = array[i];
                if (n >= 0) {
                    for (int length2 = array.length, j = 0; j < length2; ++j) {
                        final int n2 = array[j];
                        if (n2 >= 0 && isEmpty(byteMatrix.get(n2, n))) {
                            embedPositionAdjustmentPattern(n2 - 2, n - 2, byteMatrix);
                        }
                    }
                }
            }
        }
    }
    
    static void maybeEmbedVersionInfo(final Version version, final ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() >= 7) {
            final BitArray bitArray = new BitArray();
            makeVersionInfoBits(version, bitArray);
            int n = 17;
            for (int i = 0; i < 6; ++i) {
                for (int j = 0; j < 3; ++j) {
                    final boolean value = bitArray.get(n);
                    --n;
                    byteMatrix.set(i, byteMatrix.getHeight() - 11 + j, value);
                    byteMatrix.set(byteMatrix.getHeight() - 11 + j, i, value);
                }
            }
        }
    }
}
