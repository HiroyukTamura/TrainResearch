// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417;

import java.nio.charset.Charset;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import java.lang.reflect.Array;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.encoder.PDF417;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.Writer;

public final class PDF417Writer implements Writer
{
    private static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    private static final int WHITE_SPACE = 30;
    
    private static BitMatrix bitMatrixFromBitArray(final byte[][] array, final int n) {
        final BitMatrix bitMatrix = new BitMatrix(array[0].length + n * 2, array.length + n * 2);
        bitMatrix.clear();
        for (int i = 0, n2 = bitMatrix.getHeight() - n - 1; i < array.length; ++i, --n2) {
            final byte[] array2 = array[i];
            for (int j = 0; j < array[0].length; ++j) {
                if (array2[j] == 1) {
                    bitMatrix.set(j + n, n2);
                }
            }
        }
        return bitMatrix;
    }
    
    private static BitMatrix bitMatrixFromEncoder(final PDF417 pdf417, final String s, int n, int n2, int n3, final int n4) throws WriterException {
        pdf417.generateBarcodeLogic(s, n);
        final byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
        n = 0;
        int n5;
        if (n3 > n2) {
            n5 = 1;
        }
        else {
            n5 = 0;
        }
        int n6;
        if (scaledMatrix[0].length < scaledMatrix.length) {
            n6 = 1;
        }
        else {
            n6 = 0;
        }
        byte[][] rotateArray = scaledMatrix;
        if (n5 != n6) {
            rotateArray = rotateArray(scaledMatrix);
            n = 1;
        }
        n2 /= rotateArray[0].length;
        n3 /= rotateArray.length;
        if (n2 >= n3) {
            n2 = n3;
        }
        if (n2 > 1) {
            byte[][] array = pdf417.getBarcodeMatrix().getScaledMatrix(n2, n2 << 2);
            if (n != 0) {
                array = rotateArray(array);
            }
            return bitMatrixFromBitArray(array, n4);
        }
        return bitMatrixFromBitArray(rotateArray, n4);
    }
    
    private static byte[][] rotateArray(final byte[][] array) {
        final byte[][] array2 = (byte[][])Array.newInstance(Byte.TYPE, array[0].length, array.length);
        for (int i = 0; i < array.length; ++i) {
            final int length = array.length;
            for (int j = 0; j < array[0].length; ++j) {
                array2[j][length - i - 1] = array[i][j];
            }
        }
        return array2;
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat barcodeFormat, final int n, final int n2) throws WriterException {
        return this.encode(s, barcodeFormat, n, n2, null);
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        if (obj != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + obj);
        }
        final PDF417 pdf417 = new PDF417();
        int int1 = 30;
        int n3;
        int int2 = n3 = 2;
        int n4 = int1;
        if (map != null) {
            if (map.containsKey(EncodeHintType.PDF417_COMPACT)) {
                pdf417.setCompact(Boolean.valueOf(map.get(EncodeHintType.PDF417_COMPACT).toString()));
            }
            if (map.containsKey(EncodeHintType.PDF417_COMPACTION)) {
                pdf417.setCompaction(Compaction.valueOf(map.get(EncodeHintType.PDF417_COMPACTION).toString()));
            }
            if (map.containsKey(EncodeHintType.PDF417_DIMENSIONS)) {
                final Dimensions dimensions = (Dimensions)map.get(EncodeHintType.PDF417_DIMENSIONS);
                pdf417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
            }
            if (map.containsKey(EncodeHintType.MARGIN)) {
                int1 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                int2 = Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            n3 = int2;
            n4 = int1;
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                pdf417.setEncoding(Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString()));
                n4 = int1;
                n3 = int2;
            }
        }
        return bitMatrixFromEncoder(pdf417, s, n3, n, n2, n4);
    }
}
