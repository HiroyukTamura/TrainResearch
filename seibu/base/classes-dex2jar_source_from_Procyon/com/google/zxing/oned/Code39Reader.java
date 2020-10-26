// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.ChecksumException;
import java.util.Arrays;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import com.google.zxing.FormatException;

public final class Code39Reader extends OneDReader
{
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    static final int ASTERISK_ENCODING = 148;
    static final int[] CHARACTER_ENCODINGS;
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;
    
    static {
        CHARACTER_ENCODINGS = new int[] { 52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42 };
    }
    
    public Code39Reader() {
        this(false);
    }
    
    public Code39Reader(final boolean b) {
        this(b, false);
    }
    
    public Code39Reader(final boolean usingCheckDigit, final boolean extendedMode) {
        this.usingCheckDigit = usingCheckDigit;
        this.extendedMode = extendedMode;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }
    
    private static String decodeExtended(final CharSequence charSequence) throws FormatException {
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (char1 == '+' || char1 == '$' || char1 == '%' || char1 == '/') {
                final char char2 = charSequence.charAt(i + 1);
                char c = '\0';
                switch (char1) {
                    case 43: {
                        if (char2 >= 'A' && char2 <= 'Z') {
                            c = (char)(char2 + ' ');
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                    case 36: {
                        if (char2 >= 'A' && char2 <= 'Z') {
                            c = (char)(char2 - '@');
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                    case 37: {
                        if (char2 >= 'A' && char2 <= 'E') {
                            c = (char)(char2 - '&');
                            break;
                        }
                        if (char2 >= 'F' && char2 <= 'J') {
                            c = (char)(char2 - '\u000b');
                            break;
                        }
                        if (char2 >= 'K' && char2 <= 'O') {
                            c = (char)(char2 + '\u0010');
                            break;
                        }
                        if (char2 >= 'P' && char2 <= 'T') {
                            c = (char)(char2 + '+');
                            break;
                        }
                        if (char2 == 'U') {
                            c = '\0';
                            break;
                        }
                        if (char2 == 'V') {
                            c = '@';
                            break;
                        }
                        if (char2 == 'W') {
                            c = '`';
                            break;
                        }
                        if (char2 == 'X' || char2 == 'Y' || char2 == 'Z') {
                            c = '\u007f';
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                    case 47: {
                        if (char2 >= 'A' && char2 <= 'O') {
                            c = (char)(char2 - ' ');
                            break;
                        }
                        if (char2 == 'Z') {
                            c = ':';
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                }
                sb.append(c);
                ++i;
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    private static int[] findAsteriskPattern(final BitArray bitArray, final int[] array) throws NotFoundException {
        final int size = bitArray.getSize();
        int i = bitArray.getNextSet(0);
        int n = 0;
        int n2 = i;
        boolean b = false;
        final int length = array.length;
        while (i < size) {
            if (bitArray.get(i) != b) {
                ++array[n];
            }
            else {
                if (n == length - 1) {
                    if (toNarrowWidePattern(array) == 148 && bitArray.isRange(Math.max(0, n2 - (i - n2) / 2), n2, false)) {
                        return new int[] { n2, i };
                    }
                    n2 += array[0] + array[1];
                    System.arraycopy(array, 2, array, 0, n - 1);
                    array[n] = (array[n - 1] = 0);
                    --n;
                }
                else {
                    ++n;
                }
                array[n] = 1;
                b = !b;
            }
            ++i;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static char patternToChar(final int n) throws NotFoundException {
        for (int i = 0; i < Code39Reader.CHARACTER_ENCODINGS.length; ++i) {
            if (Code39Reader.CHARACTER_ENCODINGS[i] == n) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i);
            }
        }
        if (n == 148) {
            return '*';
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static int toNarrowWidePattern(final int[] array) {
        final int length = array.length;
        int n = 0;
        int i;
        do {
            int n2 = Integer.MAX_VALUE;
            int n4;
            for (int length2 = array.length, j = 0; j < length2; ++j, n2 = n4) {
                final int n3 = array[j];
                if (n3 < (n4 = n2)) {
                    n4 = n2;
                    if (n3 > n) {
                        n4 = n3;
                    }
                }
            }
            n = n2;
            i = 0;
            int n5 = 0;
            int n6 = 0;
            int n8;
            int n9;
            int n10;
            for (int k = 0; k < length; ++k, n6 = n8, n5 = n9, i = n10) {
                final int n7 = array[k];
                n8 = n6;
                n9 = n5;
                n10 = i;
                if (n7 > n) {
                    n8 = (n6 | 1 << length - 1 - k);
                    n10 = i + 1;
                    n9 = n5 + n7;
                }
            }
            if (i == 3) {
                final int n11 = 0;
                int n12 = i;
                int n13 = n11;
                int n14;
                while (true) {
                    n14 = n6;
                    if (n13 >= length) {
                        break;
                    }
                    n14 = n6;
                    if (n12 <= 0) {
                        break;
                    }
                    final int n15 = array[n13];
                    int n16 = n12;
                    if (n15 > n) {
                        n16 = n12 - 1;
                        if (n15 << 1 >= n5) {
                            n14 = -1;
                            break;
                        }
                    }
                    ++n13;
                    n12 = n16;
                }
                return n14;
            }
        } while (i > 3);
        return -1;
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        final int[] counters = this.counters;
        Arrays.fill(counters, 0);
        final StringBuilder decodeRowResult = this.decodeRowResult;
        decodeRowResult.setLength(0);
        final int[] asteriskPattern = findAsteriskPattern(bitArray, counters);
        int n2 = bitArray.getNextSet(asteriskPattern[1]);
        final int size = bitArray.getSize();
        char patternToChar;
        int n3;
        int n5;
        do {
            n3 = n2;
            OneDReader.recordPattern(bitArray, n3, counters);
            final int narrowWidePattern = toNarrowWidePattern(counters);
            if (narrowWidePattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            patternToChar = patternToChar(narrowWidePattern);
            decodeRowResult.append(patternToChar);
            final int length = counters.length;
            int i = 0;
            int n4 = n3;
            while (i < length) {
                n4 += counters[i];
                ++i;
            }
            n5 = (n2 = bitArray.getNextSet(n4));
        } while (patternToChar != '*');
        decodeRowResult.setLength(decodeRowResult.length() - 1);
        int n6 = 0;
        for (int length2 = counters.length, j = 0; j < length2; ++j) {
            n6 += counters[j];
        }
        if (n5 != size && n5 - n3 - n6 << 1 < n6) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.usingCheckDigit) {
            final int length3 = decodeRowResult.length() - 1;
            int n7 = 0;
            for (int k = 0; k < length3; ++k) {
                n7 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.decodeRowResult.charAt(k));
            }
            if (decodeRowResult.charAt(length3) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(n7 % 43)) {
                throw ChecksumException.getChecksumInstance();
            }
            decodeRowResult.setLength(length3);
        }
        if (decodeRowResult.length() == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        String s;
        if (this.extendedMode) {
            s = decodeExtended(decodeRowResult);
        }
        else {
            s = decodeRowResult.toString();
        }
        return new Result(s, null, new ResultPoint[] { new ResultPoint((asteriskPattern[1] + asteriskPattern[0]) / 2.0f, (float)n), new ResultPoint(n3 + n6 / 2.0f, (float)n) }, BarcodeFormat.CODE_39);
    }
}
