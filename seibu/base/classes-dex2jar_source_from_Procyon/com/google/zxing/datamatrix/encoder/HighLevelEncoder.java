// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;
import com.google.zxing.Dimension;

public final class HighLevelEncoder
{
    static final int ASCII_ENCODATION = 0;
    static final int BASE256_ENCODATION = 5;
    static final int C40_ENCODATION = 1;
    static final char C40_UNLATCH = '\u00fe';
    static final int EDIFACT_ENCODATION = 4;
    static final char LATCH_TO_ANSIX12 = '\u00ee';
    static final char LATCH_TO_BASE256 = '\u00e7';
    static final char LATCH_TO_C40 = '\u00e6';
    static final char LATCH_TO_EDIFACT = '\u00f0';
    static final char LATCH_TO_TEXT = '\u00ef';
    private static final char MACRO_05 = '\u00ec';
    private static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    private static final char MACRO_06 = '\u00ed';
    private static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    private static final String MACRO_TRAILER = "\u001e\u0004";
    private static final char PAD = '\u0081';
    static final int TEXT_ENCODATION = 2;
    static final char UPPER_SHIFT = '\u00eb';
    static final int X12_ENCODATION = 3;
    static final char X12_UNLATCH = '\u00fe';
    
    private HighLevelEncoder() {
    }
    
    public static int determineConsecutiveDigitCount(final CharSequence charSequence, int n) {
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
    
    public static String encodeHighLevel(final String s) {
        return encodeHighLevel(s, SymbolShapeHint.FORCE_NONE, null, null);
    }
    
    public static String encodeHighLevel(final String s, final SymbolShapeHint symbolShape, final Dimension dimension, final Dimension dimension2) {
        final ASCIIEncoder asciiEncoder = new ASCIIEncoder();
        final C40Encoder c40Encoder = new C40Encoder();
        final TextEncoder textEncoder = new TextEncoder();
        final X12Encoder x12Encoder = new X12Encoder();
        final EdifactEncoder edifactEncoder = new EdifactEncoder();
        final Base256Encoder base256Encoder = new Base256Encoder();
        final EncoderContext encoderContext = new EncoderContext(s);
        encoderContext.setSymbolShape(symbolShape);
        encoderContext.setSizeConstraints(dimension, dimension2);
        if (s.startsWith("[)>\u001e05\u001d") && s.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword('\u00ec');
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        else if (s.startsWith("[)>\u001e06\u001d") && s.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword('\u00ed');
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        int newEncoding = 0;
        while (encoderContext.hasMoreCharacters()) {
            (new Encoder[] { asciiEncoder, c40Encoder, textEncoder, x12Encoder, edifactEncoder, base256Encoder })[newEncoding].encode(encoderContext);
            if (encoderContext.getNewEncoding() >= 0) {
                newEncoding = encoderContext.getNewEncoding();
                encoderContext.resetEncoderSignal();
            }
        }
        final int codewordCount = encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo();
        final int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
        if (codewordCount < dataCapacity && newEncoding != 0 && newEncoding != 5 && newEncoding != 4) {
            encoderContext.writeCodeword('\u00fe');
        }
        final StringBuilder codewords = encoderContext.getCodewords();
        if (codewords.length() < dataCapacity) {
            codewords.append('\u0081');
        }
        while (codewords.length() < dataCapacity) {
            codewords.append(randomize253State('\u0081', codewords.length() + 1));
        }
        return encoderContext.getCodewords().toString();
    }
    
    private static int findMinimums(final float[] array, final int[] array2, int i, final byte[] array3) {
        Arrays.fill(array3, (byte)0);
        final int n = 0;
        int n2 = i;
        int n3;
        int n4;
        for (i = n; i < 6; ++i, n2 = n4) {
            array2[i] = (int)Math.ceil(array[i]);
            n3 = array2[i];
            if ((n4 = n2) > n3) {
                n4 = n3;
                Arrays.fill(array3, (byte)0);
            }
            if (n4 == n3) {
                ++array3[i];
            }
        }
        return n2;
    }
    
    private static int getMinimumCount(final byte[] array) {
        int n = 0;
        for (int i = 0; i < 6; ++i) {
            n += array[i];
        }
        return n;
    }
    
    static void illegalCharacter(final char c) {
        final String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
    
    static boolean isDigit(final char c) {
        return c >= '0' && c <= '9';
    }
    
    static boolean isExtendedASCII(final char c) {
        return c >= '\u0080' && c <= '\u00ff';
    }
    
    private static boolean isNativeC40(final char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }
    
    private static boolean isNativeEDIFACT(final char c) {
        return c >= ' ' && c <= '^';
    }
    
    private static boolean isNativeText(final char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
    
    private static boolean isNativeX12(final char c) {
        return isX12TermSep(c) || c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }
    
    private static boolean isSpecialB256(final char c) {
        return false;
    }
    
    private static boolean isX12TermSep(final char c) {
        return c == '\r' || c == '*' || c == '>';
    }
    
    static int lookAheadTest(final CharSequence charSequence, int i, int n) {
        if (i >= charSequence.length()) {
            return n;
        }
        float[] array;
        if (n == 0) {
            final float[] array2;
            array = (array2 = new float[6]);
            array2[0] = 0.0f;
            array2[2] = (array2[1] = 1.0f);
            array2[4] = (array2[3] = 1.0f);
            array2[5] = 1.25f;
        }
        else {
            final float[] array3;
            array = (array3 = new float[6]);
            array3[0] = 1.0f;
            array3[2] = (array3[1] = 2.0f);
            array3[4] = (array3[3] = 2.0f);
            array3[5] = 2.25f;
            array[n] = 0.0f;
        }
        n = 0;
        while (i + n != charSequence.length()) {
            final char char1 = charSequence.charAt(i + n);
            final int n2 = n + 1;
            if (isDigit(char1)) {
                array[0] += 0.5f;
            }
            else if (isExtendedASCII(char1)) {
                array[0] = (float)Math.ceil(array[0]);
                array[0] += 2.0f;
            }
            else {
                array[0] = (float)Math.ceil(array[0]);
                ++array[0];
            }
            if (isNativeC40(char1)) {
                array[1] += 0.6666667f;
            }
            else if (isExtendedASCII(char1)) {
                array[1] += 2.6666667f;
            }
            else {
                array[1] += 1.3333334f;
            }
            if (isNativeText(char1)) {
                array[2] += 0.6666667f;
            }
            else if (isExtendedASCII(char1)) {
                array[2] += 2.6666667f;
            }
            else {
                array[2] += 1.3333334f;
            }
            if (isNativeX12(char1)) {
                array[3] += 0.6666667f;
            }
            else if (isExtendedASCII(char1)) {
                array[3] += 4.3333335f;
            }
            else {
                array[3] += 3.3333333f;
            }
            if (isNativeEDIFACT(char1)) {
                array[4] += 0.75f;
            }
            else if (isExtendedASCII(char1)) {
                array[4] += 4.25f;
            }
            else {
                array[4] += 3.25f;
            }
            if (isSpecialB256(char1)) {
                array[5] += 4.0f;
            }
            else {
                ++array[5];
            }
            n = n2;
            if (n2 >= 4) {
                final int[] array4 = new int[6];
                final byte[] array5 = new byte[6];
                findMinimums(array, array4, Integer.MAX_VALUE, array5);
                n = getMinimumCount(array5);
                if (array4[0] < array4[5] && array4[0] < array4[1] && array4[0] < array4[2] && array4[0] < array4[3] && array4[0] < array4[4]) {
                    return 0;
                }
                if (array4[5] < array4[0] || array5[1] + array5[2] + array5[3] + array5[4] == 0) {
                    return 5;
                }
                if (n == 1 && array5[4] > 0) {
                    return 4;
                }
                if (n == 1 && array5[2] > 0) {
                    return 2;
                }
                if (n == 1 && array5[3] > 0) {
                    return 3;
                }
                n = n2;
                if (array4[1] + 1 >= array4[0]) {
                    continue;
                }
                n = n2;
                if (array4[1] + 1 >= array4[5]) {
                    continue;
                }
                n = n2;
                if (array4[1] + 1 >= array4[4]) {
                    continue;
                }
                n = n2;
                if (array4[1] + 1 >= array4[2]) {
                    continue;
                }
                if (array4[1] < array4[3]) {
                    return 1;
                }
                n = n2;
                if (array4[1] == array4[3]) {
                    char char2;
                    for (i = i + n2 + 1; i < charSequence.length(); ++i) {
                        char2 = charSequence.charAt(i);
                        if (isX12TermSep(char2)) {
                            return 3;
                        }
                        if (!isNativeX12(char2)) {
                            break;
                        }
                    }
                    return 1;
                }
                continue;
            }
        }
        final byte[] array6 = new byte[6];
        final int[] array7 = new int[6];
        i = findMinimums(array, array7, Integer.MAX_VALUE, array6);
        n = getMinimumCount(array6);
        if (array7[0] == i) {
            return 0;
        }
        if (n == 1 && array6[5] > 0) {
            return 5;
        }
        if (n == 1 && array6[4] > 0) {
            return 4;
        }
        if (n == 1 && array6[2] > 0) {
            return 2;
        }
        if (n == 1 && array6[3] > 0) {
            return 3;
        }
        return 1;
    }
    
    private static char randomize253State(final char c, final int n) {
        int n2 = c + (n * 149 % 253 + 1);
        if (n2 > 254) {
            n2 -= 254;
        }
        return (char)n2;
    }
}
