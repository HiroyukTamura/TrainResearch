// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded;

import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.common.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import com.google.zxing.Result;
import java.util.Collections;
import java.util.Iterator;
import java.util.Collection;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.List;
import com.google.zxing.oned.rss.AbstractRSSReader;

public final class RSSExpandedReader extends AbstractRSSReader
{
    private static final int[] EVEN_TOTAL_SUBSET;
    private static final int[][] FINDER_PATTERNS;
    private static final int[][] FINDER_PATTERN_SEQUENCES;
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM;
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST;
    private static final int[][] WEIGHTS;
    private final List<ExpandedPair> pairs;
    private final List<ExpandedRow> rows;
    private final int[] startEnd;
    private boolean startFromEven;
    
    static {
        SYMBOL_WIDEST = new int[] { 7, 5, 4, 3, 1 };
        EVEN_TOTAL_SUBSET = new int[] { 4, 20, 52, 104, 204 };
        GSUM = new int[] { 0, 348, 1388, 2948, 3988 };
        FINDER_PATTERNS = new int[][] { { 1, 8, 4, 1 }, { 3, 6, 4, 1 }, { 3, 4, 6, 1 }, { 3, 2, 8, 1 }, { 2, 6, 5, 1 }, { 2, 2, 9, 1 } };
        WEIGHTS = new int[][] { { 1, 3, 9, 27, 81, 32, 96, 77 }, { 20, 60, 180, 118, 143, 7, 21, 63 }, { 189, 145, 13, 39, 117, 140, 209, 205 }, { 193, 157, 49, 147, 19, 57, 171, 91 }, { 62, 186, 136, 197, 169, 85, 44, 132 }, { 185, 133, 188, 142, 4, 12, 36, 108 }, { 113, 128, 173, 97, 80, 29, 87, 50 }, { 150, 28, 84, 41, 123, 158, 52, 156 }, { 46, 138, 203, 187, 139, 206, 196, 166 }, { 76, 17, 51, 153, 37, 111, 122, 155 }, { 43, 129, 176, 106, 107, 110, 119, 146 }, { 16, 48, 144, 10, 30, 90, 59, 177 }, { 109, 116, 137, 200, 178, 112, 125, 164 }, { 70, 210, 208, 202, 184, 130, 179, 115 }, { 134, 191, 151, 31, 93, 68, 204, 190 }, { 148, 22, 66, 198, 172, 94, 71, 2 }, { 6, 18, 54, 162, 64, 192, 154, 40 }, { 120, 149, 25, 75, 14, 42, 126, 167 }, { 79, 26, 78, 23, 69, 207, 199, 175 }, { 103, 98, 83, 38, 114, 131, 182, 124 }, { 161, 61, 183, 127, 170, 88, 53, 159 }, { 55, 165, 73, 8, 24, 72, 5, 15 }, { 45, 135, 194, 160, 58, 174, 100, 89 } };
        FINDER_PATTERN_SEQUENCES = new int[][] { { 0, 0 }, { 0, 1, 1 }, { 0, 2, 1, 3 }, { 0, 4, 1, 3, 2 }, { 0, 4, 1, 3, 3, 5 }, { 0, 4, 1, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 4, 4 }, { 0, 0, 1, 1, 2, 2, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5 } };
    }
    
    public RSSExpandedReader() {
        this.pairs = new ArrayList<ExpandedPair>(11);
        this.rows = new ArrayList<ExpandedRow>();
        this.startEnd = new int[2];
    }
    
    private void adjustOddEvenCounts(int n) throws NotFoundException {
        final int n2 = 0;
        final int sum = MathUtils.sum(this.getOddCounts());
        final int sum2 = MathUtils.sum(this.getEvenCounts());
        int n3 = 0;
        final int n4 = 0;
        int n5;
        if (sum > 13) {
            n5 = 1;
        }
        else {
            n5 = n4;
            if (sum < 4) {
                n3 = 1;
                n5 = n4;
            }
        }
        boolean b = false;
        final int n6 = 0;
        int n7;
        if (sum2 > 13) {
            n7 = 1;
        }
        else {
            n7 = n6;
            if (sum2 < 4) {
                b = true;
                n7 = n6;
            }
        }
        final int n8 = sum + sum2 - n;
        boolean b2;
        if ((sum & 0x1) == 0x1) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        n = n2;
        if ((sum2 & 0x1) == 0x0) {
            n = 1;
        }
        if (n8 == 1) {
            if (b2) {
                if (n != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                n5 = 1;
            }
            else {
                if (n == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                n7 = 1;
            }
        }
        else if (n8 == -1) {
            if (b2) {
                if (n != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                n3 = 1;
            }
            else {
                if (n == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                b = true;
            }
        }
        else {
            if (n8 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (b2) {
                if (n == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum < sum2) {
                    n3 = 1;
                    n7 = 1;
                }
                else {
                    n5 = 1;
                    b = true;
                }
            }
            else if (n != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (n3 != 0) {
            if (n5 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(this.getOddCounts(), this.getOddRoundingErrors());
        }
        if (n5 != 0) {
            AbstractRSSReader.decrement(this.getOddCounts(), this.getOddRoundingErrors());
        }
        if (b) {
            if (n7 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(this.getEvenCounts(), this.getOddRoundingErrors());
        }
        if (n7 != 0) {
            AbstractRSSReader.decrement(this.getEvenCounts(), this.getEvenRoundingErrors());
        }
    }
    
    private boolean checkChecksum() {
        final ExpandedPair expandedPair = this.pairs.get(0);
        final DataCharacter leftChar = expandedPair.getLeftChar();
        final DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar != null) {
            int checksumPortion = rightChar.getChecksumPortion();
            int n = 2;
            for (int i = 1; i < this.pairs.size(); ++i) {
                final ExpandedPair expandedPair2 = this.pairs.get(i);
                final int n2 = checksumPortion + expandedPair2.getLeftChar().getChecksumPortion();
                final int n3 = n + 1;
                final DataCharacter rightChar2 = expandedPair2.getRightChar();
                checksumPortion = n2;
                n = n3;
                if (rightChar2 != null) {
                    checksumPortion = n2 + rightChar2.getChecksumPortion();
                    n = n3 + 1;
                }
            }
            if ((n - 4) * 211 + checksumPortion % 211 == leftChar.getValue()) {
                return true;
            }
        }
        return false;
    }
    
    private List<ExpandedPair> checkRows(final List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            final ExpandedRow expandedRow = this.rows.get(i);
            this.pairs.clear();
            final Iterator<ExpandedRow> iterator = list.iterator();
            while (iterator.hasNext()) {
                this.pairs.addAll(iterator.next().getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (this.checkChecksum()) {
                    return this.pairs;
                }
                final ArrayList<ExpandedRow> list2 = new ArrayList<ExpandedRow>();
                list2.addAll((Collection<?>)list);
                list2.add(expandedRow);
                try {
                    return this.checkRows(list2, i + 1);
                }
                catch (NotFoundException ex) {}
            }
            ++i;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private List<ExpandedPair> checkRows(final boolean b) {
        List<ExpandedPair> list;
        if (this.rows.size() > 25) {
            this.rows.clear();
            list = null;
        }
        else {
            this.pairs.clear();
            if (b) {
                Collections.reverse(this.rows);
            }
            List<ExpandedPair> checkRows = null;
            while (true) {
                try {
                    checkRows = this.checkRows(new ArrayList<ExpandedRow>(), 0);
                    list = checkRows;
                    if (b) {
                        Collections.reverse(this.rows);
                        return checkRows;
                    }
                }
                catch (NotFoundException ex) {
                    continue;
                }
                break;
            }
        }
        return list;
    }
    
    static Result constructResult(final List<ExpandedPair> list) throws NotFoundException, FormatException {
        final String information = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        final ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        final ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(information, null, new ResultPoint[] { resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1] }, BarcodeFormat.RSS_EXPANDED);
    }
    
    private void findNextPair(final BitArray bitArray, final List<ExpandedPair> list, int n) throws NotFoundException {
        final int[] decodeFinderCounters = this.getDecodeFinderCounters();
        decodeFinderCounters[1] = (decodeFinderCounters[0] = 0);
        decodeFinderCounters[3] = (decodeFinderCounters[2] = 0);
        final int size = bitArray.getSize();
        if (n < 0) {
            if (list.isEmpty()) {
                n = 0;
            }
            else {
                n = list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
            }
        }
        boolean b;
        if (list.size() % 2 != 0) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2 = b;
        if (this.startFromEven) {
            if (!b) {
                b2 = true;
            }
            else {
                b2 = false;
            }
        }
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n2;
            if (n >= size) {
                break;
            }
            n2 = (n3 = (bitArray.get(n) ? 0 : 1));
            if (n2 == 0) {
                break;
            }
            ++n;
        }
        final int n4 = 0;
        final int n5 = n;
        int i = n;
        n = n5;
        int n6 = n4;
        while (i < size) {
            int n7;
            if ((bitArray.get(i) ? 1 : 0) != n3) {
                ++decodeFinderCounters[n6];
                n7 = n3;
            }
            else {
                if (n6 == 3) {
                    if (b2) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        this.startEnd[0] = n;
                        this.startEnd[1] = i;
                        return;
                    }
                    if (b2) {
                        reverseCounters(decodeFinderCounters);
                    }
                    n += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[3] = (decodeFinderCounters[2] = 0);
                    --n6;
                }
                else {
                    ++n6;
                }
                decodeFinderCounters[n6] = 1;
                n7 = ((n3 != 0) ? 0 : 1);
            }
            ++i;
            n3 = n7;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static int getNextSecondBar(final BitArray bitArray, final int n) {
        if (bitArray.get(n)) {
            return bitArray.getNextSet(bitArray.getNextUnset(n));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(n));
    }
    
    private static boolean isNotA1left(final FinderPattern finderPattern, final boolean b, final boolean b2) {
        return finderPattern.getValue() != 0 || !b || !b2;
    }
    
    private static boolean isPartialRow(final Iterable<ExpandedPair> iterable, final Iterable<ExpandedRow> iterable2) {
    Label_0115_Outer:
        for (final ExpandedRow expandedRow : iterable2) {
            final int n = 1;
            final Iterator<ExpandedPair> iterator2 = iterable.iterator();
        Label_0109:
            while (true) {
                int i;
                do {
                    final int n2 = n;
                    if (iterator2.hasNext()) {
                        final ExpandedPair expandedPair = iterator2.next();
                        final int n3 = 0;
                        final Iterator<ExpandedPair> iterator3 = expandedRow.getPairs().iterator();
                        do {
                            i = n3;
                            if (iterator3.hasNext()) {
                                continue Label_0115_Outer;
                            }
                            continue Label_0109;
                        } while (!expandedPair.equals(iterator3.next()));
                        i = 1;
                    }
                    else {
                        if (n2 != 0) {
                            return true;
                        }
                        continue Label_0115_Outer;
                    }
                } while (i != 0);
                final int n2 = 0;
                continue;
            }
        }
        return false;
    }
    
    private static boolean isValidSequence(final List<ExpandedPair> list) {
        final int[][] finder_PATTERN_SEQUENCES = RSSExpandedReader.FINDER_PATTERN_SEQUENCES;
        for (int length = finder_PATTERN_SEQUENCES.length, i = 0; i < length; ++i) {
            final int[] array = finder_PATTERN_SEQUENCES[i];
            if (list.size() <= array.length) {
                final int n = 1;
                int n2 = 0;
                int n3;
                while (true) {
                    n3 = n;
                    if (n2 >= list.size()) {
                        break;
                    }
                    if (list.get(n2).getFinderPattern().getValue() != array[n2]) {
                        n3 = 0;
                        break;
                    }
                    ++n2;
                }
                if (n3 != 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private FinderPattern parseFoundFinderPattern(final BitArray bitArray, final int n, final boolean b) {
        Label_0120: {
            if (!b) {
                break Label_0120;
            }
            int n2;
            for (n2 = this.startEnd[0] - 1; n2 >= 0 && !bitArray.get(n2); --n2) {}
            int n3 = n2 + 1;
            int n4 = this.startEnd[0] - n3;
            int nextUnset = this.startEnd[1];
            while (true) {
                final int[] decodeFinderCounters = this.getDecodeFinderCounters();
                System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
                decodeFinderCounters[0] = n4;
                try {
                    return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, RSSExpandedReader.FINDER_PATTERNS), new int[] { n3, nextUnset }, n3, nextUnset, n);
                    n3 = this.startEnd[0];
                    nextUnset = bitArray.getNextUnset(this.startEnd[1] + 1);
                    n4 = nextUnset - this.startEnd[1];
                }
                catch (NotFoundException ex) {
                    return null;
                }
            }
        }
    }
    
    private static void removePartialRows(final List<ExpandedPair> list, final List<ExpandedRow> list2) {
        final Iterator<ExpandedRow> iterator = list2.iterator();
    Label_0134_Outer:
        while (iterator.hasNext()) {
            final ExpandedRow expandedRow = iterator.next();
            if (expandedRow.getPairs().size() != list.size()) {
                final int n = 1;
                final Iterator<ExpandedPair> iterator2 = expandedRow.getPairs().iterator();
            Label_0128:
                while (true) {
                    int i;
                    do {
                        final int n2 = n;
                        if (iterator2.hasNext()) {
                            final ExpandedPair expandedPair = iterator2.next();
                            final int n3 = 0;
                            final Iterator<ExpandedPair> iterator3 = list.iterator();
                            do {
                                i = n3;
                                if (iterator3.hasNext()) {
                                    continue Label_0134_Outer;
                                }
                                continue Label_0128;
                            } while (!expandedPair.equals(iterator3.next()));
                            i = 1;
                        }
                        else {
                            if (n2 != 0) {
                                iterator.remove();
                                continue Label_0134_Outer;
                            }
                            continue Label_0134_Outer;
                        }
                    } while (i != 0);
                    final int n2 = 0;
                    continue;
                }
            }
        }
    }
    
    private static void reverseCounters(final int[] array) {
        for (int length = array.length, i = 0; i < length / 2; ++i) {
            final int n = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = n;
        }
    }
    
    private void storeRow(final int n, final boolean b) {
        int n2 = 0;
        boolean equivalent = false;
        final int n3 = 0;
        int equivalent2;
        while (true) {
            equivalent2 = n3;
            if (n2 >= this.rows.size()) {
                break;
            }
            final ExpandedRow expandedRow = this.rows.get(n2);
            if (expandedRow.getRowNumber() > n) {
                equivalent2 = (expandedRow.isEquivalent(this.pairs) ? 1 : 0);
                break;
            }
            equivalent = expandedRow.isEquivalent(this.pairs);
            ++n2;
        }
        if (equivalent2 == 0 && !equivalent && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(n2, new ExpandedRow(this.pairs, n, b));
            removePartialRows(this.pairs, this.rows);
        }
    }
    
    DataCharacter decodeDataCharacter(final BitArray bitArray, final FinderPattern finderPattern, final boolean b, final boolean b2) throws NotFoundException {
        final int[] dataCharacterCounters = this.getDataCharacterCounters();
        for (int i = 0; i < dataCharacterCounters.length; ++i) {
            dataCharacterCounters[i] = 0;
        }
        if (b2) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        }
        else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            for (int j = 0, n = dataCharacterCounters.length - 1; j < n; ++j, --n) {
                final int n2 = dataCharacterCounters[j];
                dataCharacterCounters[j] = dataCharacterCounters[n];
                dataCharacterCounters[n] = n2;
            }
        }
        final float n3 = MathUtils.sum(dataCharacterCounters) / 17.0f;
        final float n4 = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (Math.abs(n3 - n4) / n4 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int[] oddCounts = this.getOddCounts();
        final int[] evenCounts = this.getEvenCounts();
        final float[] oddRoundingErrors = this.getOddRoundingErrors();
        final float[] evenRoundingErrors = this.getEvenRoundingErrors();
        for (int k = 0; k < dataCharacterCounters.length; ++k) {
            final float n5 = 1.0f * dataCharacterCounters[k] / n3;
            final int n6 = (int)(0.5f + n5);
            int n7;
            if (n6 <= 0) {
                if (n5 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                n7 = 1;
            }
            else if ((n7 = n6) > 8) {
                if (n5 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
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
        this.adjustOddEvenCounts(17);
        final int value = finderPattern.getValue();
        int n9;
        if (b) {
            n9 = 0;
        }
        else {
            n9 = 2;
        }
        int n10;
        if (b2) {
            n10 = 0;
        }
        else {
            n10 = 1;
        }
        final int n11 = n10 + (value * 4 + n9) - 1;
        int n12 = 0;
        int n13 = 0;
        int n14;
        for (int l = oddCounts.length - 1; l >= 0; --l, n13 = n14) {
            n14 = n13;
            if (isNotA1left(finderPattern, b, b2)) {
                n14 = n13 + oddCounts[l] * RSSExpandedReader.WEIGHTS[n11][l * 2];
            }
            n12 += oddCounts[l];
        }
        int n15 = 0;
        int n17;
        for (int n16 = evenCounts.length - 1; n16 >= 0; --n16, n15 = n17) {
            n17 = n15;
            if (isNotA1left(finderPattern, b, b2)) {
                n17 = n15 + evenCounts[n16] * RSSExpandedReader.WEIGHTS[n11][n16 * 2 + 1];
            }
        }
        if ((n12 & 0x1) != 0x0 || n12 > 13 || n12 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int n18 = (13 - n12) / 2;
        final int n19 = RSSExpandedReader.SYMBOL_WIDEST[n18];
        return new DataCharacter(RSSUtils.getRSSvalue(oddCounts, n19, true) * RSSExpandedReader.EVEN_TOTAL_SUBSET[n18] + RSSUtils.getRSSvalue(evenCounts, 9 - n19, false) + RSSExpandedReader.GSUM[n18], n13 + n15);
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(this.decodeRow2pairs(n, bitArray));
        }
        catch (NotFoundException ex) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(this.decodeRow2pairs(n, bitArray));
        }
    }
    
    List<ExpandedPair> decodeRow2pairs(final int n, final BitArray bitArray) throws NotFoundException {
        try {
            while (true) {
                this.pairs.add(this.retrieveNextPair(bitArray, this.pairs, n));
            }
        }
        catch (NotFoundException ex) {
            if (this.pairs.isEmpty()) {
                throw ex;
            }
            List<ExpandedPair> list;
            if (this.checkChecksum()) {
                list = this.pairs;
            }
            else {
                boolean b;
                if (!this.rows.isEmpty()) {
                    b = true;
                }
                else {
                    b = false;
                }
                this.storeRow(n, false);
                if (!b || ((list = this.checkRows(false)) == null && (list = this.checkRows(true)) == null)) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            return list;
        }
    }
    
    List<ExpandedRow> getRows() {
        return this.rows;
    }
    
    @Override
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }
    
    ExpandedPair retrieveNextPair(final BitArray bitArray, final List<ExpandedPair> list, final int n) throws NotFoundException {
        boolean b2;
        final boolean b = b2 = (list.size() % 2 == 0);
        if (this.startFromEven) {
            b2 = !b;
        }
        int n2 = 1;
        int nextSecondBar = -1;
        FinderPattern foundFinderPattern;
        int n3;
        do {
            this.findNextPair(bitArray, list, nextSecondBar);
            foundFinderPattern = this.parseFoundFinderPattern(bitArray, n, b2);
            if (foundFinderPattern == null) {
                nextSecondBar = getNextSecondBar(bitArray, this.startEnd[0]);
                n3 = n2;
            }
            else {
                n3 = 0;
            }
            n2 = n3;
        } while (n3 != 0);
        final DataCharacter decodeDataCharacter = this.decodeDataCharacter(bitArray, foundFinderPattern, b2, true);
        if (!list.isEmpty() && list.get(list.size() - 1).mustBeLast()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            final DataCharacter decodeDataCharacter2 = this.decodeDataCharacter(bitArray, foundFinderPattern, b2, false);
            return new ExpandedPair(decodeDataCharacter, decodeDataCharacter2, foundFinderPattern, true);
        }
        catch (NotFoundException ex) {
            final DataCharacter decodeDataCharacter2 = null;
            return new ExpandedPair(decodeDataCharacter, decodeDataCharacter2, foundFinderPattern, true);
        }
    }
}
