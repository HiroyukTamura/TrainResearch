// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.FormatException;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.common.BitArray;
import com.google.zxing.NotFoundException;

public final class ITFReader extends OneDReader
{
    private static final int[] DEFAULT_ALLOWED_LENGTHS;
    private static final int[][] END_PATTERN_REVERSED;
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.5f;
    private static final int N = 1;
    private static final int[][] PATTERNS;
    private static final int[] START_PATTERN;
    private static final int W = 3;
    private static final int w = 2;
    private int narrowLineWidth;
    
    static {
        DEFAULT_ALLOWED_LENGTHS = new int[] { 6, 8, 10, 12, 14 };
        START_PATTERN = new int[] { 1, 1, 1, 1 };
        END_PATTERN_REVERSED = new int[][] { { 1, 1, 2 }, { 1, 1, 3 } };
        PATTERNS = new int[][] { { 1, 1, 2, 2, 1 }, { 2, 1, 1, 1, 2 }, { 1, 2, 1, 1, 2 }, { 2, 2, 1, 1, 1 }, { 1, 1, 2, 1, 2 }, { 2, 1, 2, 1, 1 }, { 1, 2, 2, 1, 1 }, { 1, 1, 1, 2, 2 }, { 2, 1, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, { 1, 1, 3, 3, 1 }, { 3, 1, 1, 1, 3 }, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, { 1, 3, 3, 1, 1 }, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
    }
    
    public ITFReader() {
        this.narrowLineWidth = -1;
    }
    
    private static int decodeDigit(final int[] array) throws NotFoundException {
        float n = 0.38f;
        int n2 = -1;
        float n3;
        for (int length = ITFReader.PATTERNS.length, i = 0; i < length; ++i, n = n3) {
            final float patternMatchVariance = OneDReader.patternMatchVariance(array, ITFReader.PATTERNS[i], 0.5f);
            if (patternMatchVariance < n) {
                n3 = patternMatchVariance;
                n2 = i;
            }
            else {
                n3 = n;
                if (patternMatchVariance == n) {
                    n2 = -1;
                    n3 = n;
                }
            }
        }
        if (n2 >= 0) {
            return n2 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private int[] decodeEnd(final BitArray bitArray) throws NotFoundException {
        bitArray.reverse();
        try {
            int skipWhiteSpace = skipWhiteSpace(bitArray);
            try {
                final int[] array = findGuardPattern(bitArray, skipWhiteSpace, ITFReader.END_PATTERN_REVERSED[0]);
                this.validateQuietZone(bitArray, array[0]);
                skipWhiteSpace = array[0];
                array[0] = bitArray.getSize() - array[1];
                array[1] = bitArray.getSize() - skipWhiteSpace;
                return array;
            }
            catch (NotFoundException ex) {
                final int[] array = findGuardPattern(bitArray, skipWhiteSpace, ITFReader.END_PATTERN_REVERSED[1]);
            }
        }
        finally {
            bitArray.reverse();
        }
    }
    
    private static void decodeMiddle(final BitArray bitArray, int i, final int n, final StringBuilder sb) throws NotFoundException {
        final int[] array = new int[10];
        final int[] array2 = new int[5];
        final int[] array3 = new int[5];
        while (i < n) {
            OneDReader.recordPattern(bitArray, i, array);
            for (int j = 0; j < 5; ++j) {
                final int n2 = j * 2;
                array2[j] = array[n2];
                array3[j] = array[n2 + 1];
            }
            sb.append((char)(decodeDigit(array2) + 48));
            sb.append((char)(decodeDigit(array3) + 48));
            int n3 = 0;
            int n4 = i;
            while (true) {
                i = n4;
                if (n3 >= 10) {
                    break;
                }
                n4 += array[n3];
                ++n3;
            }
        }
    }
    
    private int[] decodeStart(final BitArray bitArray) throws NotFoundException {
        final int[] guardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), ITFReader.START_PATTERN);
        this.narrowLineWidth = (guardPattern[1] - guardPattern[0]) / 4;
        this.validateQuietZone(bitArray, guardPattern[0]);
        return guardPattern;
    }
    
    private static int[] findGuardPattern(final BitArray bitArray, int n, final int[] array) throws NotFoundException {
        final int length = array.length;
        final int[] array2 = new int[length];
        final int size = bitArray.getSize();
        boolean b = false;
        final int n2 = 0;
        final int n3 = n;
        int i = n;
        n = n3;
        int n4 = n2;
        while (i < size) {
            if (bitArray.get(i) != b) {
                ++array2[n4];
            }
            else {
                if (n4 == length - 1) {
                    if (OneDReader.patternMatchVariance(array2, array, 0.5f) < 0.38f) {
                        return new int[] { n, i };
                    }
                    n += array2[0] + array2[1];
                    System.arraycopy(array2, 2, array2, 0, n4 - 1);
                    array2[n4] = (array2[n4 - 1] = 0);
                    --n4;
                }
                else {
                    ++n4;
                }
                array2[n4] = 1;
                b = !b;
            }
            ++i;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static int skipWhiteSpace(final BitArray bitArray) throws NotFoundException {
        final int size = bitArray.getSize();
        final int nextSet = bitArray.getNextSet(0);
        if (nextSet == size) {
            throw NotFoundException.getNotFoundInstance();
        }
        return nextSet;
    }
    
    private void validateQuietZone(final BitArray bitArray, int n) throws NotFoundException {
        int n2 = this.narrowLineWidth * 10;
        if (n2 >= n) {
            n2 = n;
        }
        for (--n; n2 > 0 && n >= 0 && !bitArray.get(n); --n2, --n) {}
        if (n2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        final int[] decodeStart = this.decodeStart(bitArray);
        final int[] decodeEnd = this.decodeEnd(bitArray);
        final StringBuilder sb = new StringBuilder(20);
        decodeMiddle(bitArray, decodeStart[1], decodeEnd[0], sb);
        final String string = sb.toString();
        int[] array = null;
        if (map != null) {
            array = (int[])(Object)map.get(DecodeHintType.ALLOWED_LENGTHS);
        }
        int[] default_ALLOWED_LENGTHS;
        if ((default_ALLOWED_LENGTHS = array) == null) {
            default_ALLOWED_LENGTHS = ITFReader.DEFAULT_ALLOWED_LENGTHS;
        }
        final int length = string.length();
        final int n2 = 0;
        int n3 = 0;
        final int length2 = default_ALLOWED_LENGTHS.length;
        int n4 = 0;
        int n5;
        while (true) {
            n5 = n2;
            if (n4 >= length2) {
                break;
            }
            final int n6 = default_ALLOWED_LENGTHS[n4];
            if (length == n6) {
                n5 = 1;
                break;
            }
            int n7;
            if (n6 > (n7 = n3)) {
                n7 = n6;
            }
            ++n4;
            n3 = n7;
        }
        int n8;
        if ((n8 = n5) == 0) {
            n8 = n5;
            if (length > n3) {
                n8 = 1;
            }
        }
        if (n8 == 0) {
            throw FormatException.getFormatInstance();
        }
        return new Result(string, null, new ResultPoint[] { new ResultPoint((float)decodeStart[1], (float)n), new ResultPoint((float)decodeEnd[0], (float)n) }, BarcodeFormat.ITF);
    }
}
