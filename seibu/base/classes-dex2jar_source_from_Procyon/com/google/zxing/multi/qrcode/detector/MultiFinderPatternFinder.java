// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.multi.qrcode.detector;

import java.io.Serializable;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import com.google.zxing.qrcode.detector.FinderPatternFinder;

final class MultiFinderPatternFinder extends FinderPatternFinder
{
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY;
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;
    
    static {
        EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    }
    
    MultiFinderPatternFinder(final BitMatrix bitMatrix) {
        super(bitMatrix);
    }
    
    MultiFinderPatternFinder(final BitMatrix bitMatrix, final ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }
    
    private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
        final List<FinderPattern> possibleCenters = this.getPossibleCenters();
        final int size = possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size == 3) {
            return new FinderPattern[][] { { possibleCenters.get(0), possibleCenters.get(1), possibleCenters.get(2) } };
        }
        Collections.sort((List<Object>)possibleCenters, (Comparator<? super Object>)new ModuleSizeComparator());
        final ArrayList<FinderPattern[]> list = new ArrayList<FinderPattern[]>();
        for (int i = 0; i < size - 2; ++i) {
            final FinderPattern finderPattern = possibleCenters.get(i);
            if (finderPattern != null) {
                for (int j = i + 1; j < size - 1; ++j) {
                    final FinderPattern finderPattern2 = possibleCenters.get(j);
                    if (finderPattern2 != null) {
                        final float n = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) > 0.5f && n >= 0.05f) {
                            break;
                        }
                        for (int k = j + 1; k < size; ++k) {
                            final FinderPattern finderPattern3 = possibleCenters.get(k);
                            if (finderPattern3 != null) {
                                final float n2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > 0.5f && n2 >= 0.05f) {
                                    break;
                                }
                                final FinderPattern[] array = { finderPattern, finderPattern2, finderPattern3 };
                                ResultPoint.orderBestPatterns(array);
                                final FinderPatternInfo finderPatternInfo = new FinderPatternInfo(array);
                                final float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                final float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                final float distance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                final float n3 = (distance + distance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                if (n3 <= 180.0f && n3 >= 9.0f && Math.abs((distance - distance3) / Math.min(distance, distance3)) < 0.1f) {
                                    final float b = (float)Math.sqrt(distance * distance + distance3 * distance3);
                                    if (Math.abs((distance2 - b) / Math.min(distance2, b)) < 0.1f) {
                                        list.add(array);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!list.isEmpty()) {
            return list.toArray(new FinderPattern[list.size()][]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    public FinderPatternInfo[] findMulti(final Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean b;
        if (map != null && map.containsKey(DecodeHintType.TRY_HARDER)) {
            b = true;
        }
        else {
            b = false;
        }
        final BitMatrix image = this.getImage();
        final int height = image.getHeight();
        final int width = image.getWidth();
        int n = height * 3 / 388;
        if (n < 3 || b) {
            n = 3;
        }
        final int[] array = new int[5];
        for (int i = n - 1; i < height; i += n) {
            this.clearCounts(array);
            int n2 = 0;
            for (int j = 0; j < width; ++j) {
                if (image.get(j, i)) {
                    int n3 = n2;
                    if ((n2 & 0x1) == 0x1) {
                        n3 = n2 + 1;
                    }
                    ++array[n3];
                    n2 = n3;
                }
                else if ((n2 & 0x1) == 0x0) {
                    if (n2 == 4) {
                        if (FinderPatternFinder.foundPatternCross(array) && this.handlePossibleCenter(array, i, j)) {
                            n2 = 0;
                            this.clearCounts(array);
                        }
                        else {
                            this.shiftCounts2(array);
                            n2 = 3;
                        }
                    }
                    else {
                        ++n2;
                        ++array[n2];
                    }
                }
                else {
                    ++array[n2];
                }
            }
            if (FinderPatternFinder.foundPatternCross(array)) {
                this.handlePossibleCenter(array, i, width);
            }
        }
        final FinderPattern[][] selectMutipleBestPatterns = this.selectMutipleBestPatterns();
        final ArrayList<FinderPatternInfo> list = new ArrayList<FinderPatternInfo>();
        for (int length = selectMutipleBestPatterns.length, k = 0; k < length; ++k) {
            final FinderPattern[] array2 = selectMutipleBestPatterns[k];
            ResultPoint.orderBestPatterns(array2);
            list.add(new FinderPatternInfo(array2));
        }
        if (list.isEmpty()) {
            return MultiFinderPatternFinder.EMPTY_RESULT_ARRAY;
        }
        return list.toArray(new FinderPatternInfo[list.size()]);
    }
    
    private static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern>
    {
        @Override
        public int compare(final FinderPattern finderPattern, final FinderPattern finderPattern2) {
            final float n = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
            if (n < 0.0) {
                return -1;
            }
            if (n > 0.0) {
                return 1;
            }
            return 0;
        }
    }
}
