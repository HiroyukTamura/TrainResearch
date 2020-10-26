// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.encoder;

import java.math.BigInteger;
import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.CharsetEncoder;
import com.google.zxing.WriterException;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;

final class PDF417HighLevelEncoder
{
    private static final int BYTE_COMPACTION = 1;
    private static final Charset DEFAULT_ENCODING;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED;
    private static final int NUMERIC_COMPACTION = 2;
    private static final byte[] PUNCTUATION;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW;
    private static final byte[] TEXT_PUNCTUATION_RAW;
    
    static {
        TEXT_MIXED_RAW = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0 };
        TEXT_PUNCTUATION_RAW = new byte[] { 59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0 };
        MIXED = new byte[128];
        PUNCTUATION = new byte[128];
        DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
        Arrays.fill(PDF417HighLevelEncoder.MIXED, (byte)(-1));
        for (int i = 0; i < PDF417HighLevelEncoder.TEXT_MIXED_RAW.length; ++i) {
            final byte b = PDF417HighLevelEncoder.TEXT_MIXED_RAW[i];
            if (b > 0) {
                PDF417HighLevelEncoder.MIXED[b] = (byte)i;
            }
        }
        Arrays.fill(PDF417HighLevelEncoder.PUNCTUATION, (byte)(-1));
        for (int j = 0; j < PDF417HighLevelEncoder.TEXT_PUNCTUATION_RAW.length; ++j) {
            final byte b2 = PDF417HighLevelEncoder.TEXT_PUNCTUATION_RAW[j];
            if (b2 > 0) {
                PDF417HighLevelEncoder.PUNCTUATION[b2] = (byte)j;
            }
        }
    }
    
    private PDF417HighLevelEncoder() {
    }
    
    private static int determineConsecutiveBinaryCount(final String s, final int n, final Charset charset) throws WriterException {
        final CharsetEncoder encoder = charset.newEncoder();
        int length;
        int i;
        for (length = s.length(), i = n; i < length; ++i) {
            char c = s.charAt(i);
            int n2 = 0;
            int n3;
            while (true) {
                n3 = n2;
                if (n2 >= 13) {
                    break;
                }
                n3 = n2;
                if (!isDigit(c)) {
                    break;
                }
                ++n2;
                final int index = i + n2;
                n3 = n2;
                if (index >= length) {
                    break;
                }
                c = s.charAt(index);
            }
            if (n3 >= 13) {
                return i - n;
            }
            final char char1 = s.charAt(i);
            if (!encoder.canEncode(char1)) {
                throw new WriterException("Non-encodable character detected: " + char1 + " (Unicode: " + (int)char1 + ')');
            }
        }
        return i - n;
    }
    
    private static int determineConsecutiveDigitCount(final CharSequence charSequence, int n) {
        int n2 = 0;
        final int n3 = 0;
        final int length = charSequence.length();
        int n4 = n;
        if (n < length) {
            char c = charSequence.charAt(n);
            n = n3;
            while (true) {
                n2 = n;
                if (!isDigit(c)) {
                    break;
                }
                n2 = n;
                if (n4 >= length) {
                    break;
                }
                final int n5 = n + 1;
                final int n6 = n4 + 1;
                n = n5;
                if ((n4 = n6) >= length) {
                    continue;
                }
                c = charSequence.charAt(n6);
                n = n5;
                n4 = n6;
            }
        }
        return n2;
    }
    
    private static int determineConsecutiveTextCount(final CharSequence charSequence, final int n) {
        final int length = charSequence.length();
        int n2 = n;
        int n3;
        while ((n3 = n2) < length) {
            char c;
            int n4;
            int n5;
            int n6;
            int n7;
            for (c = charSequence.charAt(n2), n4 = 0, n5 = n2; n4 < 13 && isDigit(c) && n5 < length; c = charSequence.charAt(n7), n5 = n7, n4 = n6) {
                n6 = n4 + 1;
                n7 = ++n5;
                n4 = n6;
                if (n7 < length) {}
            }
            if (n4 >= 13) {
                return n5 - n - n4;
            }
            n2 = n5;
            if (n4 > 0) {
                continue;
            }
            n3 = n5;
            if (!isText(charSequence.charAt(n5))) {
                break;
            }
            n2 = n5 + 1;
        }
        return n3 - n;
    }
    
    private static void encodeBinary(final byte[] array, final int n, final int n2, int n3, final StringBuilder sb) {
        if (n2 == 1 && n3 == 0) {
            sb.append('\u0391');
        }
        else if (n2 % 6 == 0) {
            sb.append('\u039c');
        }
        else {
            sb.append('\u0385');
        }
        int i;
        n3 = (i = n);
        if (n2 >= 6) {
            final char[] array2 = new char[5];
            while (true) {
                i = n3;
                if (n + n2 - n3 < 6) {
                    break;
                }
                long n4 = 0L;
                for (int j = 0; j < 6; ++j) {
                    n4 = (n4 << 8) + (array[n3 + j] & 0xFF);
                }
                for (int k = 0; k < 5; ++k) {
                    array2[k] = (char)(n4 % 900L);
                    n4 /= 900L;
                }
                for (int l = 4; l >= 0; --l) {
                    sb.append(array2[l]);
                }
                n3 += 6;
            }
        }
        while (i < n + n2) {
            sb.append((char)(array[i] & 0xFF));
            ++i;
        }
    }
    
    static String encodeHighLevel(final String s, final Compaction compaction, final Charset ob) throws WriterException {
        final StringBuilder sb = new StringBuilder(s.length());
        Charset default_ENCODING;
        if (ob == null) {
            default_ENCODING = PDF417HighLevelEncoder.DEFAULT_ENCODING;
        }
        else {
            default_ENCODING = ob;
            if (!PDF417HighLevelEncoder.DEFAULT_ENCODING.equals(ob)) {
                final CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(ob.name());
                default_ENCODING = ob;
                if (characterSetECIByName != null) {
                    encodingECI(characterSetECIByName.getValue(), sb);
                    default_ENCODING = ob;
                }
            }
        }
        final int length = s.length();
        int i = 0;
        int encodeText = 0;
        switch (compaction) {
            default: {
                int n = 0;
                while (i < length) {
                    final int determineConsecutiveDigitCount = determineConsecutiveDigitCount(s, i);
                    if (determineConsecutiveDigitCount >= 13) {
                        sb.append('\u0386');
                        n = 2;
                        encodeText = 0;
                        encodeNumeric(s, i, determineConsecutiveDigitCount, sb);
                        i += determineConsecutiveDigitCount;
                    }
                    else {
                        final int determineConsecutiveTextCount = determineConsecutiveTextCount(s, i);
                        if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                            int n2;
                            if ((n2 = n) != 0) {
                                sb.append('\u0384');
                                n2 = 0;
                                encodeText = 0;
                            }
                            encodeText = encodeText(s, i, determineConsecutiveTextCount, sb, encodeText);
                            i += determineConsecutiveTextCount;
                            n = n2;
                        }
                        else {
                            int determineConsecutiveBinaryCount;
                            if ((determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(s, i, default_ENCODING)) == 0) {
                                determineConsecutiveBinaryCount = 1;
                            }
                            final byte[] bytes = s.substring(i, i + determineConsecutiveBinaryCount).getBytes(default_ENCODING);
                            if (bytes.length == 1 && n == 0) {
                                encodeBinary(bytes, 0, 1, 0, sb);
                            }
                            else {
                                encodeBinary(bytes, 0, bytes.length, n, sb);
                                n = 1;
                                encodeText = 0;
                            }
                            i += determineConsecutiveBinaryCount;
                        }
                    }
                }
                break;
            }
            case TEXT: {
                encodeText(s, 0, length, sb, 0);
                break;
            }
            case BYTE: {
                final byte[] bytes2 = s.getBytes(default_ENCODING);
                encodeBinary(bytes2, 0, bytes2.length, 1, sb);
                break;
            }
            case NUMERIC: {
                sb.append('\u0386');
                encodeNumeric(s, 0, length, sb);
                break;
            }
        }
        return sb.toString();
    }
    
    private static void encodeNumeric(final String s, final int n, final int n2, final StringBuilder sb) {
        int i = 0;
        final StringBuilder sb2 = new StringBuilder(n2 / 3 + 1);
        final BigInteger value = BigInteger.valueOf(900L);
        final BigInteger value2 = BigInteger.valueOf(0L);
        while (i < n2) {
            sb2.setLength(0);
            final int min = Math.min(44, n2 - i);
            BigInteger divide = new BigInteger("1" + s.substring(n + i, n + i + min));
            do {
                sb2.append((char)divide.mod(value).intValue());
            } while (!(divide = divide.divide(value)).equals(value2));
            for (int j = sb2.length() - 1; j >= 0; --j) {
                sb.append(sb2.charAt(j));
            }
            i += min;
        }
    }
    
    private static int encodeText(final CharSequence charSequence, int i, int char1, final StringBuilder sb, int n) {
        final StringBuilder sb2 = new StringBuilder(char1);
        int n2 = 0;
        while (true) {
            final char char2 = charSequence.charAt(i + n2);
            switch (n) {
                default: {
                    if (isPunctuation(char2)) {
                        sb2.append((char)PDF417HighLevelEncoder.PUNCTUATION[char2]);
                        break;
                    }
                    n = 0;
                    sb2.append('\u001d');
                    continue;
                }
                case 0: {
                    if (isAlphaUpper(char2)) {
                        if (char2 == ' ') {
                            sb2.append('\u001a');
                            break;
                        }
                        sb2.append((char)(char2 - 'A'));
                        break;
                    }
                    else {
                        if (isAlphaLower(char2)) {
                            n = 1;
                            sb2.append('\u001b');
                            continue;
                        }
                        if (isMixed(char2)) {
                            n = 2;
                            sb2.append('\u001c');
                            continue;
                        }
                        sb2.append('\u001d');
                        sb2.append((char)PDF417HighLevelEncoder.PUNCTUATION[char2]);
                        break;
                    }
                    break;
                }
                case 1: {
                    if (isAlphaLower(char2)) {
                        if (char2 == ' ') {
                            sb2.append('\u001a');
                            break;
                        }
                        sb2.append((char)(char2 - 'a'));
                        break;
                    }
                    else {
                        if (isAlphaUpper(char2)) {
                            sb2.append('\u001b');
                            sb2.append((char)(char2 - 'A'));
                            break;
                        }
                        if (isMixed(char2)) {
                            n = 2;
                            sb2.append('\u001c');
                            continue;
                        }
                        sb2.append('\u001d');
                        sb2.append((char)PDF417HighLevelEncoder.PUNCTUATION[char2]);
                        break;
                    }
                    break;
                }
                case 2: {
                    if (isMixed(char2)) {
                        sb2.append((char)PDF417HighLevelEncoder.MIXED[char2]);
                        break;
                    }
                    if (isAlphaUpper(char2)) {
                        n = 0;
                        sb2.append('\u001c');
                        continue;
                    }
                    if (isAlphaLower(char2)) {
                        n = 1;
                        sb2.append('\u001b');
                        continue;
                    }
                    if (i + n2 + 1 < char1 && isPunctuation(charSequence.charAt(i + n2 + 1))) {
                        n = 3;
                        sb2.append('\u0019');
                        continue;
                    }
                    sb2.append('\u001d');
                    sb2.append((char)PDF417HighLevelEncoder.PUNCTUATION[char2]);
                    break;
                }
            }
            if (++n2 >= char1) {
                break;
            }
        }
        char1 = 0;
        int length;
        int n3;
        char c;
        for (length = sb2.length(), i = 0; i < length; ++i) {
            if (i % 2 != 0) {
                n3 = 1;
            }
            else {
                n3 = 0;
            }
            if (n3 != 0) {
                c = (char)(char1 * 30 + sb2.charAt(i));
                sb.append(c);
                char1 = c;
            }
            else {
                char1 = sb2.charAt(i);
            }
        }
        if (length % 2 != 0) {
            sb.append((char)(char1 * 30 + 29));
        }
        return n;
    }
    
    private static void encodingECI(final int i, final StringBuilder sb) throws WriterException {
        if (i >= 0 && i < 900) {
            sb.append('\u039f');
            sb.append((char)i);
            return;
        }
        if (i < 810900) {
            sb.append('\u039e');
            sb.append((char)(i / 900 - 1));
            sb.append((char)(i % 900));
            return;
        }
        if (i < 811800) {
            sb.append('\u039d');
            sb.append((char)(810900 - i));
            return;
        }
        throw new WriterException("ECI number not in valid range from 0..811799, but was " + i);
    }
    
    private static boolean isAlphaLower(final char c) {
        return c == ' ' || (c >= 'a' && c <= 'z');
    }
    
    private static boolean isAlphaUpper(final char c) {
        return c == ' ' || (c >= 'A' && c <= 'Z');
    }
    
    private static boolean isDigit(final char c) {
        return c >= '0' && c <= '9';
    }
    
    private static boolean isMixed(final char c) {
        return PDF417HighLevelEncoder.MIXED[c] != -1;
    }
    
    private static boolean isPunctuation(final char c) {
        return PDF417HighLevelEncoder.PUNCTUATION[c] != -1;
    }
    
    private static boolean isText(final char c) {
        return c == '\t' || c == '\n' || c == '\r' || (c >= ' ' && c <= '~');
    }
}
