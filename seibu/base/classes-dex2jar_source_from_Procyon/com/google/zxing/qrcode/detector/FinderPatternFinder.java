// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;
import com.google.zxing.NotFoundException;
import java.util.Iterator;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import com.google.zxing.ResultPointCallback;
import java.util.List;
import com.google.zxing.common.BitMatrix;

public class FinderPatternFinder
{
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;
    
    public FinderPatternFinder(final BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }
    
    public FinderPatternFinder(final BitMatrix image, final ResultPointCallback resultPointCallback) {
        this.image = image;
        this.possibleCenters = new ArrayList<FinderPattern>();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }
    
    private static float centerFromEnd(final int[] array, final int n) {
        return n - array[4] - array[3] - array[2] / 2.0f;
    }
    
    private boolean crossCheckDiagonal(final int n, final int n2) {
        final int[] crossCheckStateCount = this.getCrossCheckStateCount();
        int n3;
        for (n3 = 0; n >= n3 && n2 >= n3 && this.image.get(n2 - n3, n - n3); ++n3) {
            ++crossCheckStateCount[2];
        }
        if (crossCheckStateCount[2] != 0) {
            while (n >= n3 && n2 >= n3 && !this.image.get(n2 - n3, n - n3)) {
                ++crossCheckStateCount[1];
                ++n3;
            }
            if (crossCheckStateCount[1] != 0) {
                while (n >= n3 && n2 >= n3 && this.image.get(n2 - n3, n - n3)) {
                    ++crossCheckStateCount[0];
                    ++n3;
                }
                if (crossCheckStateCount[0] != 0) {
                    final int height = this.image.getHeight();
                    final int width = this.image.getWidth();
                    int n4 = 1;
                    int n5;
                    while (true) {
                        n5 = n4;
                        if (n + n4 >= height) {
                            break;
                        }
                        n5 = n4;
                        if (n2 + n4 >= width) {
                            break;
                        }
                        n5 = n4;
                        if (!this.image.get(n2 + n4, n + n4)) {
                            break;
                        }
                        ++crossCheckStateCount[2];
                        ++n4;
                    }
                    while (n + n5 < height && n2 + n5 < width && !this.image.get(n2 + n5, n + n5)) {
                        ++crossCheckStateCount[3];
                        ++n5;
                    }
                    if (crossCheckStateCount[3] != 0) {
                        while (n + n5 < height && n2 + n5 < width && this.image.get(n2 + n5, n + n5)) {
                            ++crossCheckStateCount[4];
                            ++n5;
                        }
                        if (crossCheckStateCount[4] != 0) {
                            return foundPatternDiagonal(crossCheckStateCount);
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private float crossCheckHorizontal(int n, final int n2, final int n3, final int n4) {
        final BitMatrix image = this.image;
        final int width = image.getWidth();
        final int[] crossCheckStateCount = this.getCrossCheckStateCount();
        int n5;
        for (n5 = n; n5 >= 0 && image.get(n5, n2); --n5) {
            ++crossCheckStateCount[2];
        }
        int n6;
        if ((n6 = n5) < 0) {
            return Float.NaN;
        }
        while (n6 >= 0 && !image.get(n6, n2) && crossCheckStateCount[1] <= n3) {
            ++crossCheckStateCount[1];
            --n6;
        }
        if (n6 < 0 || crossCheckStateCount[1] > n3) {
            return Float.NaN;
        }
        while (n6 >= 0 && image.get(n6, n2) && crossCheckStateCount[0] <= n3) {
            ++crossCheckStateCount[0];
            --n6;
        }
        if (crossCheckStateCount[0] > n3) {
            return Float.NaN;
        }
        for (++n; n < width && image.get(n, n2); ++n) {
            ++crossCheckStateCount[2];
        }
        int n7;
        if ((n7 = n) == width) {
            return Float.NaN;
        }
        while (n7 < width && !image.get(n7, n2) && crossCheckStateCount[3] < n3) {
            ++crossCheckStateCount[3];
            ++n7;
        }
        if (n7 == width || crossCheckStateCount[3] >= n3) {
            return Float.NaN;
        }
        while (n7 < width && image.get(n7, n2) && crossCheckStateCount[4] < n3) {
            ++crossCheckStateCount[4];
            ++n7;
        }
        if (crossCheckStateCount[4] >= n3) {
            return Float.NaN;
        }
        if (Math.abs(crossCheckStateCount[0] + crossCheckStateCount[1] + crossCheckStateCount[2] + crossCheckStateCount[3] + crossCheckStateCount[4] - n4) * 5 >= n4) {
            return Float.NaN;
        }
        if (foundPatternCross(crossCheckStateCount)) {
            return centerFromEnd(crossCheckStateCount, n7);
        }
        return Float.NaN;
    }
    
    private float crossCheckVertical(int n, final int n2, final int n3, final int n4) {
        final BitMatrix image = this.image;
        final int height = image.getHeight();
        final int[] crossCheckStateCount = this.getCrossCheckStateCount();
        int n5;
        for (n5 = n; n5 >= 0 && image.get(n2, n5); --n5) {
            ++crossCheckStateCount[2];
        }
        int n6;
        if ((n6 = n5) < 0) {
            return Float.NaN;
        }
        while (n6 >= 0 && !image.get(n2, n6) && crossCheckStateCount[1] <= n3) {
            ++crossCheckStateCount[1];
            --n6;
        }
        if (n6 < 0 || crossCheckStateCount[1] > n3) {
            return Float.NaN;
        }
        while (n6 >= 0 && image.get(n2, n6) && crossCheckStateCount[0] <= n3) {
            ++crossCheckStateCount[0];
            --n6;
        }
        if (crossCheckStateCount[0] > n3) {
            return Float.NaN;
        }
        for (++n; n < height && image.get(n2, n); ++n) {
            ++crossCheckStateCount[2];
        }
        int n7;
        if ((n7 = n) == height) {
            return Float.NaN;
        }
        while (n7 < height && !image.get(n2, n7) && crossCheckStateCount[3] < n3) {
            ++crossCheckStateCount[3];
            ++n7;
        }
        if (n7 == height || crossCheckStateCount[3] >= n3) {
            return Float.NaN;
        }
        while (n7 < height && image.get(n2, n7) && crossCheckStateCount[4] < n3) {
            ++crossCheckStateCount[4];
            ++n7;
        }
        if (crossCheckStateCount[4] >= n3) {
            return Float.NaN;
        }
        if (Math.abs(crossCheckStateCount[0] + crossCheckStateCount[1] + crossCheckStateCount[2] + crossCheckStateCount[3] + crossCheckStateCount[4] - n4) * 5 >= n4 * 2) {
            return Float.NaN;
        }
        if (foundPatternCross(crossCheckStateCount)) {
            return centerFromEnd(crossCheckStateCount, n7);
        }
        return Float.NaN;
    }
    
    private int findRowSkip() {
        if (this.possibleCenters.size() > 1) {
            ResultPoint resultPoint = null;
            for (final FinderPattern finderPattern : this.possibleCenters) {
                if (finderPattern.getCount() >= 2) {
                    if (resultPoint != null) {
                        this.hasSkipped = true;
                        return (int)(Math.abs(resultPoint.getX() - finderPattern.getX()) - Math.abs(resultPoint.getY() - finderPattern.getY())) / 2;
                    }
                    resultPoint = finderPattern;
                }
            }
        }
        return 0;
    }
    
    protected static boolean foundPatternCross(final int[] array) {
        int n = 0;
        for (int i = 0; i < 5; ++i) {
            final int n2 = array[i];
            if (n2 == 0) {
                return false;
            }
            n += n2;
        }
        if (n < 7) {
            return false;
        }
        final float n3 = n / 7.0f;
        final float n4 = n3 / 2.0f;
        if (Math.abs(n3 - array[0]) < n4 && Math.abs(n3 - array[1]) < n4 && Math.abs(3.0f * n3 - array[2]) < 3.0f * n4 && Math.abs(n3 - array[3]) < n4 && Math.abs(n3 - array[4]) < n4) {
            return true;
        }
        return false;
    }
    
    protected static boolean foundPatternDiagonal(final int[] array) {
        int n = 0;
        for (int i = 0; i < 5; ++i) {
            final int n2 = array[i];
            if (n2 == 0) {
                return false;
            }
            n += n2;
        }
        if (n < 7) {
            return false;
        }
        final float n3 = n / 7.0f;
        final float n4 = n3 / 1.333f;
        if (Math.abs(n3 - array[0]) < n4 && Math.abs(n3 - array[1]) < n4 && Math.abs(3.0f * n3 - array[2]) < 3.0f * n4 && Math.abs(n3 - array[3]) < n4 && Math.abs(n3 - array[4]) < n4) {
            return true;
        }
        return false;
    }
    
    private int[] getCrossCheckStateCount() {
        this.clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }
    
    private boolean haveMultiplyConfirmedCenters() {
        int n = 0;
        float n2 = 0.0f;
        final int size = this.possibleCenters.size();
        for (final FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                ++n;
                n2 += finderPattern.getEstimatedModuleSize();
            }
        }
        if (n >= 3) {
            final float n3 = n2 / size;
            float n4 = 0.0f;
            final Iterator<FinderPattern> iterator2 = this.possibleCenters.iterator();
            while (iterator2.hasNext()) {
                n4 += Math.abs(iterator2.next().getEstimatedModuleSize() - n3);
            }
            if (n4 <= 0.05f * n2) {
                return true;
            }
        }
        return false;
    }
    
    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        final int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size > 3) {
            float n = 0.0f;
            float n2 = 0.0f;
            final Iterator<FinderPattern> iterator = this.possibleCenters.iterator();
            while (iterator.hasNext()) {
                final float estimatedModuleSize = iterator.next().getEstimatedModuleSize();
                n += estimatedModuleSize;
                n2 += estimatedModuleSize * estimatedModuleSize;
            }
            final float n3 = n / size;
            final float b = (float)Math.sqrt(n2 / size - n3 * n3);
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(n3));
            final float max = Math.max(0.2f * n3, b);
            int n5;
            for (int n4 = 0; n4 < this.possibleCenters.size() && this.possibleCenters.size() > 3; n4 = n5 + 1) {
                n5 = n4;
                if (Math.abs(this.possibleCenters.get(n4).getEstimatedModuleSize() - n3) > max) {
                    this.possibleCenters.remove(n4);
                    n5 = n4 - 1;
                }
            }
        }
        if (this.possibleCenters.size() > 3) {
            float n6 = 0.0f;
            final Iterator<FinderPattern> iterator2 = this.possibleCenters.iterator();
            while (iterator2.hasNext()) {
                n6 += iterator2.next().getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(n6 / this.possibleCenters.size()));
            this.possibleCenters.subList(3, this.possibleCenters.size()).clear();
        }
        return new FinderPattern[] { this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2) };
    }
    
    protected final void clearCounts(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = 0;
        }
    }
    
    final FinderPatternInfo find(final Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean b;
        if (map != null && map.containsKey(DecodeHintType.TRY_HARDER)) {
            b = true;
        }
        else {
            b = false;
        }
        final int height = this.image.getHeight();
        final int width = this.image.getWidth();
        int n = height * 3 / 388;
        if (n < 3 || b) {
            n = 3;
        }
        int n2 = 0;
        final int[] array = new int[5];
        int haveMultiplyConfirmedCenters2;
        int n8;
        for (int n3 = n - 1; n3 < height && n2 == 0; n3 += n8, n2 = haveMultiplyConfirmedCenters2, n = n8) {
            this.clearCounts(array);
            int n4 = 0;
            for (int i = 0; i < width; ++i) {
                if (this.image.get(i, n3)) {
                    int n5 = n4;
                    if ((n4 & 0x1) == 0x1) {
                        n5 = n4 + 1;
                    }
                    ++array[n5];
                    n4 = n5;
                }
                else if ((n4 & 0x1) == 0x0) {
                    if (n4 == 4) {
                        if (foundPatternCross(array)) {
                            if (this.handlePossibleCenter(array, n3, i)) {
                                final int n6 = 2;
                                int haveMultiplyConfirmedCenters;
                                int n7;
                                if (this.hasSkipped) {
                                    haveMultiplyConfirmedCenters = (this.haveMultiplyConfirmedCenters() ? 1 : 0);
                                    n7 = n3;
                                }
                                else {
                                    final int rowSkip = this.findRowSkip();
                                    haveMultiplyConfirmedCenters = n2;
                                    n7 = n3;
                                    if (rowSkip > array[2]) {
                                        n7 = n3 + (rowSkip - array[2] - 2);
                                        i = width - 1;
                                        haveMultiplyConfirmedCenters = n2;
                                    }
                                }
                                n4 = 0;
                                this.clearCounts(array);
                                n2 = haveMultiplyConfirmedCenters;
                                n3 = n7;
                                n = n6;
                            }
                            else {
                                this.shiftCounts2(array);
                                n4 = 3;
                            }
                        }
                        else {
                            this.shiftCounts2(array);
                            n4 = 3;
                        }
                    }
                    else {
                        ++n4;
                        ++array[n4];
                    }
                }
                else {
                    ++array[n4];
                }
            }
            haveMultiplyConfirmedCenters2 = n2;
            n8 = n;
            if (foundPatternCross(array)) {
                haveMultiplyConfirmedCenters2 = n2;
                n8 = n;
                if (this.handlePossibleCenter(array, n3, width)) {
                    final int n9 = array[0];
                    haveMultiplyConfirmedCenters2 = n2;
                    n8 = n9;
                    if (this.hasSkipped) {
                        haveMultiplyConfirmedCenters2 = (this.haveMultiplyConfirmedCenters() ? 1 : 0);
                        n8 = n9;
                    }
                }
            }
        }
        final FinderPattern[] selectBestPatterns = this.selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }
    
    protected final BitMatrix getImage() {
        return this.image;
    }
    
    protected final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }
    
    protected final boolean handlePossibleCenter(final int[] array, int n, int n2) {
        final int n3 = array[0] + array[1] + array[2] + array[3] + array[4];
        final float centerFromEnd = centerFromEnd(array, n2);
        final float crossCheckVertical = this.crossCheckVertical(n, (int)centerFromEnd, array[2], n3);
        if (!Float.isNaN(crossCheckVertical)) {
            final float crossCheckHorizontal = this.crossCheckHorizontal((int)centerFromEnd, (int)crossCheckVertical, array[2], n3);
            if (!Float.isNaN(crossCheckHorizontal) && this.crossCheckDiagonal((int)crossCheckVertical, (int)crossCheckHorizontal)) {
                final float n4 = n3 / 7.0f;
                final int n5 = 0;
                n = 0;
                while (true) {
                    n2 = n5;
                    if (n >= this.possibleCenters.size()) {
                        break;
                    }
                    final FinderPattern finderPattern = this.possibleCenters.get(n);
                    if (finderPattern.aboutEquals(n4, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(n, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, n4));
                        n2 = 1;
                        break;
                    }
                    ++n;
                }
                if (n2 == 0) {
                    final FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, n4);
                    this.possibleCenters.add(finderPattern2);
                    if (this.resultPointCallback != null) {
                        this.resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    protected final boolean handlePossibleCenter(final int[] array, final int n, final int n2, final boolean b) {
        return this.handlePossibleCenter(array, n, n2);
    }
    
    protected final void shiftCounts2(final int[] array) {
        array[0] = array[2];
        array[1] = array[3];
        array[2] = array[4];
        array[3] = 1;
        array[4] = 0;
    }
    
    private static final class CenterComparator implements Serializable, Comparator<FinderPattern>
    {
        private final float average;
        
        private CenterComparator(final float average) {
            this.average = average;
        }
        
        @Override
        public int compare(final FinderPattern finderPattern, final FinderPattern finderPattern2) {
            int n;
            if ((n = Integer.compare(finderPattern2.getCount(), finderPattern.getCount())) == 0) {
                n = Float.compare(Math.abs(finderPattern.getEstimatedModuleSize() - this.average), Math.abs(finderPattern2.getEstimatedModuleSize() - this.average));
            }
            return n;
        }
    }
    
    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern>
    {
        private final float average;
        
        private FurthestFromAverageComparator(final float average) {
            this.average = average;
        }
        
        @Override
        public int compare(final FinderPattern finderPattern, final FinderPattern finderPattern2) {
            return Float.compare(Math.abs(finderPattern2.getEstimatedModuleSize() - this.average), Math.abs(finderPattern.getEstimatedModuleSize() - this.average));
        }
    }
}
