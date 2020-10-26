// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.EncodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;

public final class ITFWriter extends OneDimensionalCodeWriter
{
    private static final int[] END_PATTERN;
    private static final int N = 1;
    private static final int[][] PATTERNS;
    private static final int[] START_PATTERN;
    private static final int W = 3;
    
    static {
        START_PATTERN = new int[] { 1, 1, 1, 1 };
        END_PATTERN = new int[] { 3, 1, 1 };
        PATTERNS = new int[][] { { 1, 1, 3, 3, 1 }, { 3, 1, 1, 1, 3 }, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, { 1, 3, 3, 1, 1 }, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
    }
    
    @Override
    public BitMatrix encode(final String s, final BarcodeFormat obj, final int n, final int n2, final Map<EncodeHintType, ?> map) throws WriterException {
        if (obj != BarcodeFormat.ITF) {
            throw new IllegalArgumentException("Can only encode ITF, but got " + obj);
        }
        return super.encode(s, obj, n, n2, map);
    }
    
    @Override
    public boolean[] encode(final String s) {
        final int length = s.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        final boolean[] array = new boolean[length * 9 + 9];
        int appendPattern = OneDimensionalCodeWriter.appendPattern(array, 0, ITFWriter.START_PATTERN, true);
        for (int i = 0; i < length; i += 2) {
            final int digit = Character.digit(s.charAt(i), 10);
            final int digit2 = Character.digit(s.charAt(i + 1), 10);
            final int[] array2 = new int[10];
            for (int j = 0; j < 5; ++j) {
                array2[j * 2] = ITFWriter.PATTERNS[digit][j];
                array2[j * 2 + 1] = ITFWriter.PATTERNS[digit2][j];
            }
            appendPattern += OneDimensionalCodeWriter.appendPattern(array, appendPattern, array2, true);
        }
        OneDimensionalCodeWriter.appendPattern(array, appendPattern, ITFWriter.END_PATTERN, true);
        return array;
    }
}
