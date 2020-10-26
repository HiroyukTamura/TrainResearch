// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss;

import com.google.zxing.ResultPointCallback;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.common.BitArray;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.Result;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public final class RSS14Reader extends AbstractRSSReader
{
    private static final int[][] FINDER_PATTERNS;
    private static final int[] INSIDE_GSUM;
    private static final int[] INSIDE_ODD_TOTAL_SUBSET;
    private static final int[] INSIDE_ODD_WIDEST;
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET;
    private static final int[] OUTSIDE_GSUM;
    private static final int[] OUTSIDE_ODD_WIDEST;
    private final List<Pair> possibleLeftPairs;
    private final List<Pair> possibleRightPairs;
    
    static {
        OUTSIDE_EVEN_TOTAL_SUBSET = new int[] { 1, 10, 34, 70, 126 };
        INSIDE_ODD_TOTAL_SUBSET = new int[] { 4, 20, 48, 81 };
        OUTSIDE_GSUM = new int[] { 0, 161, 961, 2015, 2715 };
        INSIDE_GSUM = new int[] { 0, 336, 1036, 1516 };
        OUTSIDE_ODD_WIDEST = new int[] { 8, 6, 4, 3, 1 };
        INSIDE_ODD_WIDEST = new int[] { 2, 4, 6, 8 };
        FINDER_PATTERNS = new int[][] { { 3, 8, 2, 1 }, { 3, 5, 5, 1 }, { 3, 3, 7, 1 }, { 3, 1, 9, 1 }, { 2, 7, 4, 1 }, { 2, 5, 6, 1 }, { 2, 3, 8, 1 }, { 1, 5, 7, 1 }, { 1, 3, 9, 1 } };
    }
    
    public RSS14Reader() {
        this.possibleLeftPairs = new ArrayList<Pair>();
        this.possibleRightPairs = new ArrayList<Pair>();
    }
    
    private static void addOrTally(final Collection<Pair> collection, final Pair pair) {
        if (pair != null) {
            final int n = 0;
            final Iterator<Pair> iterator = collection.iterator();
            while (true) {
                Pair pair2;
                do {
                    final int n2 = n;
                    if (iterator.hasNext()) {
                        pair2 = iterator.next();
                    }
                    else {
                        if (n2 == 0) {
                            collection.add(pair);
                        }
                        return;
                    }
                } while (pair2.getValue() != pair.getValue());
                pair2.incrementCount();
                final int n2 = 1;
                continue;
            }
        }
    }
    
    private void adjustOddEvenCounts(final boolean b, int n) throws NotFoundException {
        final int n2 = 0;
        final int sum = MathUtils.sum(this.getOddCounts());
        final int sum2 = MathUtils.sum(this.getEvenCounts());
        final int n3 = 0;
        boolean b2 = false;
        final int n4 = 0;
        final int n5 = 0;
        boolean b3 = false;
        final int n6 = 0;
        int n8;
        int n9;
        int n10;
        if (b) {
            int n7;
            if (sum > 12) {
                n7 = 1;
            }
            else {
                n7 = n5;
                if (sum < 4) {
                    b2 = true;
                    n7 = n5;
                }
            }
            if (sum2 > 12) {
                n8 = 1;
                n9 = (b2 ? 1 : 0);
                n10 = n7;
            }
            else {
                n8 = n6;
                n10 = n7;
                n9 = (b2 ? 1 : 0);
                if (sum2 < 4) {
                    b3 = true;
                    n8 = n6;
                    n10 = n7;
                    n9 = (b2 ? 1 : 0);
                }
            }
        }
        else {
            int n11;
            int n12;
            if (sum > 11) {
                n11 = 1;
                n12 = n3;
            }
            else {
                n11 = n4;
                n12 = n3;
                if (sum < 5) {
                    n12 = 1;
                    n11 = n4;
                }
            }
            if (sum2 > 10) {
                n8 = 1;
                n10 = n11;
                n9 = n12;
            }
            else {
                n8 = n6;
                n10 = n11;
                n9 = n12;
                if (sum2 < 4) {
                    b3 = true;
                    n8 = n6;
                    n10 = n11;
                    n9 = n12;
                }
            }
        }
        final int n13 = sum + sum2 - n;
        if (b) {
            n = 1;
        }
        else {
            n = 0;
        }
        boolean b4;
        if ((sum & 0x1) == n) {
            b4 = true;
        }
        else {
            b4 = false;
        }
        n = n2;
        if ((sum2 & 0x1) == 0x1) {
            n = 1;
        }
        if (n13 == 1) {
            if (b4) {
                if (n != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                n10 = 1;
            }
            else {
                if (n == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                n8 = 1;
            }
        }
        else if (n13 == -1) {
            if (b4) {
                if (n != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                n9 = 1;
            }
            else {
                if (n == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                b3 = true;
            }
        }
        else {
            if (n13 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (b4) {
                if (n == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum < sum2) {
                    n9 = 1;
                    n8 = 1;
                }
                else {
                    n10 = 1;
                    b3 = true;
                }
            }
            else if (n != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (n9 != 0) {
            if (n10 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(this.getOddCounts(), this.getOddRoundingErrors());
        }
        if (n10 != 0) {
            AbstractRSSReader.decrement(this.getOddCounts(), this.getOddRoundingErrors());
        }
        if (b3) {
            if (n8 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(this.getEvenCounts(), this.getOddRoundingErrors());
        }
        if (n8 != 0) {
            AbstractRSSReader.decrement(this.getEvenCounts(), this.getEvenRoundingErrors());
        }
    }
    
    private static boolean checkChecksum(final Pair pair, final Pair pair2) {
        final int checksumPortion = pair.getChecksumPortion();
        final int checksumPortion2 = pair2.getChecksumPortion();
        int n2;
        final int n = n2 = pair.getFinderPattern().getValue() * 9 + pair2.getFinderPattern().getValue();
        if (n > 72) {
            n2 = n - 1;
        }
        int n3;
        if ((n3 = n2) > 8) {
            n3 = n2 - 1;
        }
        return (checksumPortion + checksumPortion2 * 16) % 79 == n3;
    }
    
    private static Result constructResult(final Pair pair, final Pair pair2) {
        final String value = String.valueOf(4537077L * pair.getValue() + pair2.getValue());
        final StringBuilder sb = new StringBuilder(14);
        for (int i = 13 - value.length(); i > 0; --i) {
            sb.append('0');
        }
        sb.append(value);
        int n = 0;
        for (int j = 0; j < 13; ++j) {
            int n2 = sb.charAt(j) - '0';
            if ((j & 0x1) == 0x0) {
                n2 *= 3;
            }
            n += n2;
        }
        int k;
        if ((k = 10 - n % 10) == 10) {
            k = 0;
        }
        sb.append(k);
        final ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        final ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(sb.toString(), null, new ResultPoint[] { resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1] }, BarcodeFormat.RSS_14);
    }
    
    private DataCharacter decodeDataCharacter(final BitArray bitArray, final FinderPattern finderPattern, final boolean b) throws NotFoundException {
        final int[] dataCharacterCounters = this.getDataCharacterCounters();
        for (int i = 0; i < dataCharacterCounters.length; ++i) {
            dataCharacterCounters[i] = 0;
        }
        if (b) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        }
        else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            for (int j = 0, n = dataCharacterCounters.length - 1; j < n; ++j, --n) {
                final int n2 = dataCharacterCounters[j];
                dataCharacterCounters[j] = dataCharacterCounters[n];
                dataCharacterCounters[n] = n2;
            }
        }
        int n3;
        if (b) {
            n3 = 16;
        }
        else {
            n3 = 15;
        }
        final float n4 = MathUtils.sum(dataCharacterCounters) / (float)n3;
        final int[] oddCounts = this.getOddCounts();
        final int[] evenCounts = this.getEvenCounts();
        final float[] oddRoundingErrors = this.getOddRoundingErrors();
        final float[] evenRoundingErrors = this.getEvenRoundingErrors();
        for (int k = 0; k < dataCharacterCounters.length; ++k) {
            final float n5 = dataCharacterCounters[k] / n4;
            final int n6 = (int)(0.5f + n5);
            int n7;
            if (n6 <= 0) {
                n7 = 1;
            }
            else if ((n7 = n6) > 8) {
                n7 = 8;
            }
            final int n8 = k / 2;
            if ((k & 0x1) == 0x0) {
                oddCounts[n8] = n7;
                oddRoundingErrors[n8] = n5 - n7;
            }
            else {
                evenCounts[n8] = n7;
                evenRoundingErrors[n8] = n5 - n7;
            }
        }
        this.adjustOddEvenCounts(b, n3);
        int n9 = 0;
        int n10 = 0;
        for (int l = oddCounts.length - 1; l >= 0; --l) {
            n10 = n10 * 9 + oddCounts[l];
            n9 += oddCounts[l];
        }
        int n11 = 0;
        int n12 = 0;
        for (int n13 = evenCounts.length - 1; n13 >= 0; --n13) {
            n11 = n11 * 9 + evenCounts[n13];
            n12 += evenCounts[n13];
        }
        final int n14 = n10 + n11 * 3;
        if (b) {
            if ((n9 & 0x1) != 0x0 || n9 > 12 || n9 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            final int n15 = (12 - n9) / 2;
            final int n16 = RSS14Reader.OUTSIDE_ODD_WIDEST[n15];
            return new DataCharacter(RSSUtils.getRSSvalue(oddCounts, n16, false) * RSS14Reader.OUTSIDE_EVEN_TOTAL_SUBSET[n15] + RSSUtils.getRSSvalue(evenCounts, 9 - n16, true) + RSS14Reader.OUTSIDE_GSUM[n15], n14);
        }
        else {
            if ((n12 & 0x1) != 0x0 || n12 > 10 || n12 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            final int n17 = (10 - n12) / 2;
            final int n18 = RSS14Reader.INSIDE_ODD_WIDEST[n17];
            return new DataCharacter(RSSUtils.getRSSvalue(evenCounts, 9 - n18, false) * RSS14Reader.INSIDE_ODD_TOTAL_SUBSET[n17] + RSSUtils.getRSSvalue(oddCounts, n18, true) + RSS14Reader.INSIDE_GSUM[n17], n14);
        }
    }
    
    private Pair decodePair(final BitArray bitArray, final boolean b, final int n, final Map<DecodeHintType, ?> map) {
        try {
            final int[] finderPattern = this.findFinderPattern(bitArray, b);
            final FinderPattern foundFinderPattern = this.parseFoundFinderPattern(bitArray, n, b, finderPattern);
            ResultPointCallback resultPointCallback;
            if (map == null) {
                resultPointCallback = null;
            }
            else {
                resultPointCallback = (ResultPointCallback)map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            if (resultPointCallback != null) {
                float n2 = (finderPattern[0] + finderPattern[1]) / 2.0f;
                if (b) {
                    n2 = bitArray.getSize() - 1 - n2;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(n2, (float)n));
            }
            final DataCharacter decodeDataCharacter = this.decodeDataCharacter(bitArray, foundFinderPattern, true);
            final DataCharacter decodeDataCharacter2 = this.decodeDataCharacter(bitArray, foundFinderPattern, false);
            return new Pair(decodeDataCharacter.getValue() * 1597 + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + decodeDataCharacter2.getChecksumPortion() * 4, foundFinderPattern);
        }
        catch (NotFoundException ex) {
            return null;
        }
    }
    
    private int[] findFinderPattern(final BitArray bitArray, final boolean b) throws NotFoundException {
        final int[] decodeFinderCounters = this.getDecodeFinderCounters();
        decodeFinderCounters[1] = (decodeFinderCounters[0] = 0);
        decodeFinderCounters[3] = (decodeFinderCounters[2] = 0);
        final int size = bitArray.getSize();
        int n = 0;
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n;
            if (n2 >= size) {
                break;
            }
            n = (bitArray.get(n2) ? 0 : 1);
            if ((b ? 1 : 0) == (n3 = n)) {
                break;
            }
            ++n2;
        }
        final int n4 = 0;
        final int n5 = n2;
        int i = n2;
        int n6 = n5;
        int n7 = n4;
        while (i < size) {
            boolean b2;
            if ((bitArray.get(i) ? 1 : 0) != n3) {
                ++decodeFinderCounters[n7];
                b2 = (n3 != 0);
            }
            else {
                if (n7 == 3) {
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        return new int[] { n6, i };
                    }
                    n6 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[3] = (decodeFinderCounters[2] = 0);
                    --n7;
                }
                else {
                    ++n7;
                }
                decodeFinderCounters[n7] = 1;
                b2 = (n3 == 0);
            }
            ++i;
            n3 = (b2 ? 1 : 0);
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private FinderPattern parseFoundFinderPattern(final BitArray bitArray, final int n, final boolean b, final int[] array) throws NotFoundException {
        boolean value;
        int n2;
        for (value = bitArray.get(array[0]), n2 = array[0] - 1; n2 >= 0 && value != bitArray.get(n2); --n2) {}
        final int n3 = n2 + 1;
        final int n4 = array[0];
        final int[] decodeFinderCounters = this.getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = n4 - n3;
        final int finderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, RSS14Reader.FINDER_PATTERNS);
        final int n5 = n3;
        final int n6 = array[1];
        int n7 = n5;
        int n8 = n6;
        if (b) {
            n7 = bitArray.getSize() - 1 - n5;
            n8 = bitArray.getSize() - 1 - n6;
        }
        return new FinderPattern(finderValue, new int[] { n3, array[1] }, n7, n8, n);
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, this.decodePair(bitArray, false, n, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, this.decodePair(bitArray, true, n, map));
        bitArray.reverse();
        for (final Pair pair : this.possibleLeftPairs) {
            if (pair.getCount() > 1) {
                for (final Pair pair2 : this.possibleRightPairs) {
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    @Override
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }
}
