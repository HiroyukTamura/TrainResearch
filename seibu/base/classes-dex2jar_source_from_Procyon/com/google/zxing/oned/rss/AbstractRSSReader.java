// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader
{
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters;
    private final int[] decodeFinderCounters;
    private final int[] evenCounts;
    private final float[] evenRoundingErrors;
    private final int[] oddCounts;
    private final float[] oddRoundingErrors;
    
    protected AbstractRSSReader() {
        this.decodeFinderCounters = new int[4];
        this.dataCharacterCounters = new int[8];
        this.oddRoundingErrors = new float[4];
        this.evenRoundingErrors = new float[4];
        this.oddCounts = new int[this.dataCharacterCounters.length / 2];
        this.evenCounts = new int[this.dataCharacterCounters.length / 2];
    }
    
    @Deprecated
    protected static int count(final int[] array) {
        return MathUtils.sum(array);
    }
    
    protected static void decrement(final int[] array, final float[] array2) {
        int n = 0;
        float n2 = array2[0];
        float n3;
        for (int i = 1; i < array.length; ++i, n2 = n3) {
            n3 = n2;
            if (array2[i] < n2) {
                n3 = array2[i];
                n = i;
            }
        }
        --array[n];
    }
    
    protected static void increment(final int[] array, final float[] array2) {
        int n = 0;
        float n2 = array2[0];
        float n3;
        for (int i = 1; i < array.length; ++i, n2 = n3) {
            n3 = n2;
            if (array2[i] > n2) {
                n3 = array2[i];
                n = i;
            }
        }
        ++array[n];
    }
    
    protected static boolean isFinderPattern(final int[] array) {
        final int n = array[0] + array[1];
        final float n2 = n / (float)(array[2] + n + array[3]);
        if (n2 >= 0.7916667f && n2 <= 0.89285713f) {
            int n3 = Integer.MAX_VALUE;
            int n4 = Integer.MIN_VALUE;
            int n6;
            int n7;
            for (int length = array.length, i = 0; i < length; ++i, n4 = n6, n3 = n7) {
                final int n5 = array[i];
                if (n5 > (n6 = n4)) {
                    n6 = n5;
                }
                if (n5 < (n7 = n3)) {
                    n7 = n5;
                }
            }
            return n4 < n3 * 10;
        }
        return false;
    }
    
    protected static int parseFinderValue(final int[] array, final int[][] array2) throws NotFoundException {
        for (int i = 0; i < array2.length; ++i) {
            if (OneDReader.patternMatchVariance(array, array2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    protected final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }
    
    protected final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }
    
    protected final int[] getEvenCounts() {
        return this.evenCounts;
    }
    
    protected final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }
    
    protected final int[] getOddCounts() {
        return this.oddCounts;
    }
    
    protected final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }
}
