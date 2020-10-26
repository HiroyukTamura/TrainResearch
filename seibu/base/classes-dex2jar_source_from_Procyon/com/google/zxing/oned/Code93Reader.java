// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import com.google.zxing.common.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.ChecksumException;

public final class Code93Reader extends OneDReader
{
    private static final char[] ALPHABET;
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    
    static {
        ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
        final int[] array;
        final int[] character_ENCODINGS = array = new int[48];
        array[0] = 276;
        array[1] = 328;
        array[2] = 324;
        array[3] = 322;
        array[4] = 296;
        array[5] = 292;
        array[6] = 290;
        array[7] = 336;
        array[8] = 274;
        array[9] = 266;
        array[10] = 424;
        array[11] = 420;
        array[12] = 418;
        array[13] = 404;
        array[14] = 402;
        array[15] = 394;
        array[16] = 360;
        array[17] = 356;
        array[18] = 354;
        array[19] = 308;
        array[20] = 282;
        array[21] = 344;
        array[22] = 332;
        array[23] = 326;
        array[24] = 300;
        array[25] = 278;
        array[26] = 436;
        array[27] = 434;
        array[28] = 428;
        array[29] = 422;
        array[30] = 406;
        array[31] = 410;
        array[32] = 364;
        array[33] = 358;
        array[34] = 310;
        array[35] = 314;
        array[36] = 302;
        array[37] = 468;
        array[38] = 466;
        array[39] = 458;
        array[40] = 366;
        array[41] = 374;
        array[42] = 430;
        array[43] = 294;
        array[44] = 474;
        array[45] = 470;
        array[46] = 306;
        array[47] = 350;
        CHARACTER_ENCODINGS = character_ENCODINGS;
        ASTERISK_ENCODING = character_ENCODINGS[47];
    }
    
    public Code93Reader() {
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[6];
    }
    
    private static void checkChecksums(final CharSequence charSequence) throws ChecksumException {
        final int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }
    
    private static void checkOneChecksum(final CharSequence charSequence, final int n, final int n2) throws ChecksumException {
        int n3 = 1;
        int n4 = 0;
        for (int i = n - 1; i >= 0; --i) {
            n4 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i)) * n3;
            if (++n3 > n2) {
                n3 = 1;
            }
        }
        if (charSequence.charAt(n) != Code93Reader.ALPHABET[n4 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }
    
    private static String decodeExtended(final CharSequence charSequence) throws FormatException {
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (char1 >= 'a' && char1 <= 'd') {
                if (i >= length - 1) {
                    throw FormatException.getFormatInstance();
                }
                final char char2 = charSequence.charAt(i + 1);
                char c = '\0';
                switch (char1) {
                    case 100: {
                        if (char2 >= 'A' && char2 <= 'Z') {
                            c = (char)(char2 + ' ');
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                    case 97: {
                        if (char2 >= 'A' && char2 <= 'Z') {
                            c = (char)(char2 - '@');
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                    case 98: {
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
                        if (char2 >= 'P' && char2 <= 'S') {
                            c = (char)(char2 + '+');
                            break;
                        }
                        if (char2 >= 'T' && char2 <= 'Z') {
                            c = '\u007f';
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    }
                    case 99: {
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
    
    private int[] findAsteriskPattern(final BitArray bitArray) throws NotFoundException {
        final int size = bitArray.getSize();
        int i = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        final int[] counters = this.counters;
        int n = i;
        boolean b = false;
        final int length = counters.length;
        int n2 = 0;
        while (i < size) {
            if (bitArray.get(i) != b) {
                ++counters[n2];
            }
            else {
                if (n2 == length - 1) {
                    if (toPattern(counters) == Code93Reader.ASTERISK_ENCODING) {
                        return new int[] { n, i };
                    }
                    n += counters[0] + counters[1];
                    System.arraycopy(counters, 2, counters, 0, n2 - 1);
                    counters[n2] = (counters[n2 - 1] = 0);
                    --n2;
                }
                else {
                    ++n2;
                }
                counters[n2] = 1;
                b = !b;
            }
            ++i;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static char patternToChar(final int n) throws NotFoundException {
        for (int i = 0; i < Code93Reader.CHARACTER_ENCODINGS.length; ++i) {
            if (Code93Reader.CHARACTER_ENCODINGS[i] == n) {
                return Code93Reader.ALPHABET[i];
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static int toPattern(final int[] array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i];
        }
        int n2 = 0;
        final int length2 = array.length;
        int n3 = 0;
        int n4;
        while (true) {
            n4 = n2;
            if (n3 >= length2) {
                break;
            }
            final int round = Math.round(array[n3] * 9.0f / n);
            if (round <= 0 || round > 4) {
                n4 = -1;
                break;
            }
            int n6;
            if ((n3 & 0x1) == 0x0) {
                int n5 = 0;
                while (true) {
                    n6 = n2;
                    if (n5 >= round) {
                        break;
                    }
                    n2 = (n2 << 1 | 0x1);
                    ++n5;
                }
            }
            else {
                n6 = n2 << round;
            }
            ++n3;
            n2 = n6;
        }
        return n4;
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        final int[] asteriskPattern = this.findAsteriskPattern(bitArray);
        int n2 = bitArray.getNextSet(asteriskPattern[1]);
        final int size = bitArray.getSize();
        final int[] counters = this.counters;
        Arrays.fill(counters, 0);
        final StringBuilder decodeRowResult = this.decodeRowResult;
        decodeRowResult.setLength(0);
        char patternToChar;
        int n3;
        int n5;
        do {
            n3 = n2;
            OneDReader.recordPattern(bitArray, n3, counters);
            final int pattern = toPattern(counters);
            if (pattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            patternToChar = patternToChar(pattern);
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
        decodeRowResult.deleteCharAt(decodeRowResult.length() - 1);
        int n6 = 0;
        for (int length2 = counters.length, j = 0; j < length2; ++j) {
            n6 += counters[j];
        }
        if (n5 == size || !bitArray.get(n5)) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (decodeRowResult.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        checkChecksums(decodeRowResult);
        decodeRowResult.setLength(decodeRowResult.length() - 2);
        return new Result(decodeExtended(decodeRowResult), null, new ResultPoint[] { new ResultPoint((asteriskPattern[1] + asteriskPattern[0]) / 2.0f, (float)n), new ResultPoint(n3 + n6 / 2.0f, (float)n) }, BarcodeFormat.CODE_93);
    }
}
