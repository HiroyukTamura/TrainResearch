// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.detector;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import com.google.zxing.NotFoundException;
import java.util.List;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ResultPoint;

public final class Detector
{
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int[] INDEXES_START_PATTERN;
    private static final int[] INDEXES_STOP_PATTERN;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] START_PATTERN;
    private static final int[] STOP_PATTERN;
    
    static {
        INDEXES_START_PATTERN = new int[] { 0, 4, 1, 5 };
        INDEXES_STOP_PATTERN = new int[] { 6, 2, 7, 3 };
        START_PATTERN = new int[] { 8, 1, 1, 1, 1, 1, 1, 3 };
        STOP_PATTERN = new int[] { 7, 1, 1, 3, 1, 1, 1, 2, 1 };
    }
    
    private Detector() {
    }
    
    private static void copyToResult(final ResultPoint[] array, final ResultPoint[] array2, final int[] array3) {
        for (int i = 0; i < array3.length; ++i) {
            array[array3[i]] = array2[i];
        }
    }
    
    public static PDF417DetectorResult detect(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map, final boolean b) throws NotFoundException {
        final BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> list = detect(b, blackMatrix);
        BitMatrix clone = blackMatrix;
        if (list.isEmpty()) {
            clone = blackMatrix.clone();
            clone.rotate180();
            list = detect(b, clone);
        }
        return new PDF417DetectorResult(clone, list);
    }
    
    private static List<ResultPoint[]> detect(final boolean b, final BitMatrix bitMatrix) {
        final ArrayList<ResultPoint[]> list = new ArrayList<ResultPoint[]>();
        int i = 0;
        int n = 0;
        int n2 = 0;
        while (i < bitMatrix.getHeight()) {
            final ResultPoint[] vertices = findVertices(bitMatrix, i, n);
            if (vertices[0] == null && vertices[3] == null) {
                if (n2 == 0) {
                    break;
                }
                n2 = 0;
                final int n3 = 0;
                for (final ResultPoint[] array : list) {
                    int a = i;
                    if (array[1] != null) {
                        a = (int)Math.max((float)i, array[1].getY());
                    }
                    i = a;
                    if (array[3] != null) {
                        i = Math.max(a, (int)array[3].getY());
                    }
                }
                i += 5;
                n = n3;
            }
            else {
                n2 = 1;
                list.add(vertices);
                if (!b) {
                    break;
                }
                if (vertices[2] != null) {
                    n = (int)vertices[2].getX();
                    i = (int)vertices[2].getY();
                }
                else {
                    n = (int)vertices[4].getX();
                    i = (int)vertices[4].getY();
                }
            }
        }
        return list;
    }
    
    private static int[] findGuardPattern(final BitMatrix bitMatrix, int n, final int n2, final int n3, boolean b, final int[] array, final int[] a) {
        Arrays.fill(a, 0, a.length, 0);
        for (int n4 = 0; bitMatrix.get(n, n2) && n > 0 && n4 < 3; --n, ++n4) {}
        int i = n;
        int n5 = 0;
        final int length = array.length;
        while (i < n3) {
            if (bitMatrix.get(i, n2) != b) {
                ++a[n5];
            }
            else {
                if (n5 == length - 1) {
                    if (patternMatchVariance(a, array, 0.8f) < 0.42f) {
                        return new int[] { n, i };
                    }
                    n += a[0] + a[1];
                    System.arraycopy(a, 2, a, 0, n5 - 1);
                    a[n5] = (a[n5 - 1] = 0);
                    --n5;
                }
                else {
                    ++n5;
                }
                a[n5] = 1;
                if (!b) {
                    b = true;
                }
                else {
                    b = false;
                }
            }
            ++i;
        }
        if (n5 == length - 1 && patternMatchVariance(a, array, 0.8f) < 0.42f) {
            return new int[] { n, i - 1 };
        }
        return null;
    }
    
    private static ResultPoint[] findRowsWithPattern(final BitMatrix bitMatrix, final int n, final int n2, int n3, int i, final int[] array) {
        final ResultPoint[] a = new ResultPoint[4];
        final int n4 = 0;
        final int[] array2 = new int[array.length];
        int n5;
        int n6;
        while (true) {
            n5 = n4;
            n6 = n3;
            if (n3 >= n) {
                break;
            }
            int[] guardPattern = findGuardPattern(bitMatrix, i, n3, n2, false, array, array2);
            if (guardPattern != null) {
                int n7 = n3;
                while (true) {
                    n3 = n7;
                    if (n7 <= 0) {
                        break;
                    }
                    --n7;
                    final int[] guardPattern2 = findGuardPattern(bitMatrix, i, n7, n2, false, array, array2);
                    if (guardPattern2 == null) {
                        n3 = n7 + 1;
                        break;
                    }
                    guardPattern = guardPattern2;
                }
                a[0] = new ResultPoint((float)guardPattern[0], (float)n3);
                a[1] = new ResultPoint((float)guardPattern[1], (float)n3);
                n5 = 1;
                n6 = n3;
                break;
            }
            n3 += 5;
        }
        n3 = (i = n6 + 1);
        if (n5 != 0) {
            int n8 = 0;
            int[] array3 = { (int)a[0].getX(), (int)a[1].getX() };
            int[] guardPattern3;
            for (i = n3; i < n; ++i, n8 = n3) {
                guardPattern3 = findGuardPattern(bitMatrix, array3[0], i, n2, false, array, array2);
                if (guardPattern3 != null && Math.abs(array3[0] - guardPattern3[0]) < 5 && Math.abs(array3[1] - guardPattern3[1]) < 5) {
                    array3 = guardPattern3;
                    n3 = 0;
                }
                else {
                    if (n8 > 25) {
                        break;
                    }
                    n3 = n8 + 1;
                }
            }
            i -= n8 + 1;
            a[2] = new ResultPoint((float)array3[0], (float)i);
            a[3] = new ResultPoint((float)array3[1], (float)i);
        }
        if (i - n6 < 10) {
            Arrays.fill(a, null);
        }
        return a;
    }
    
    private static ResultPoint[] findVertices(final BitMatrix bitMatrix, int n, int n2) {
        final int height = bitMatrix.getHeight();
        final int width = bitMatrix.getWidth();
        final ResultPoint[] array = new ResultPoint[8];
        copyToResult(array, findRowsWithPattern(bitMatrix, height, width, n, n2, Detector.START_PATTERN), Detector.INDEXES_START_PATTERN);
        if (array[4] != null) {
            n2 = (int)array[4].getX();
            n = (int)array[4].getY();
        }
        copyToResult(array, findRowsWithPattern(bitMatrix, height, width, n, n2, Detector.STOP_PATTERN), Detector.INDEXES_STOP_PATTERN);
        return array;
    }
    
    private static float patternMatchVariance(final int[] array, final int[] array2, final float n) {
        final int length = array.length;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < length; ++i) {
            n2 += array[i];
            n3 += array2[i];
        }
        if (n2 >= n3) {
            final float n4 = n2 / (float)n3;
            float n5 = 0.0f;
            for (int j = 0; j < length; ++j) {
                final int n6 = array[j];
                final float n7 = array2[j] * n4;
                float n8;
                if (n6 > n7) {
                    n8 = n6 - n7;
                }
                else {
                    n8 = n7 - n6;
                }
                if (n8 > n * n4) {
                    return Float.POSITIVE_INFINITY;
                }
                n5 += n8;
            }
            return n5 / n2;
        }
        return Float.POSITIVE_INFINITY;
    }
}
