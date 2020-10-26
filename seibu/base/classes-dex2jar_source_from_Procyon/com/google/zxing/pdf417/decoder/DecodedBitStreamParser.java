// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

import java.util.Arrays;
import java.util.List;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.nio.charset.StandardCharsets;
import com.google.zxing.common.DecoderResult;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.math.BigInteger;

final class DecodedBitStreamParser
{
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    
    static {
        PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
        MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
        (EXP900 = new BigInteger[16])[0] = BigInteger.ONE;
        final BigInteger value = BigInteger.valueOf(900L);
        DecodedBitStreamParser.EXP900[1] = value;
        for (int i = 2; i < DecodedBitStreamParser.EXP900.length; ++i) {
            DecodedBitStreamParser.EXP900[i] = DecodedBitStreamParser.EXP900[i - 1].multiply(value);
        }
    }
    
    private DecodedBitStreamParser() {
    }
    
    private static int byteCompaction(int i, final int[] array, final Charset charset, int n, final StringBuilder sb) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = 0;
        final int n3 = 0;
        final long n4 = 0L;
        int n5 = 0;
        final int n6 = 0;
        long n7 = n4;
        int n8 = n;
        Label_0060: {
            switch (i) {
                case 901: {
                    final int[] array2 = new int[6];
                    int n9 = array[n];
                    i = n + 1;
                    long n10 = n4;
                    int n11 = n6;
                    n = n3;
                    while (i < array[0] && n11 == 0) {
                        final int n12 = n + 1;
                        array2[n] = n9;
                        n10 = 900L * n10 + n9;
                        n = i + 1;
                        n9 = array[i];
                        switch (n9) {
                            default: {
                                if (n12 % 5 == 0 && n12 > 0) {
                                    for (i = 0; i < 6; ++i) {
                                        byteArrayOutputStream.write((byte)(n10 >> (5 - i) * 8));
                                    }
                                    n10 = 0L;
                                    final int n13 = 0;
                                    i = n;
                                    n = n13;
                                    continue;
                                }
                                i = n;
                                n = n12;
                                continue;
                            }
                            case 900:
                            case 901:
                            case 902:
                            case 922:
                            case 923:
                            case 924:
                            case 928: {
                                i = n - 1;
                                n11 = 1;
                                n = n12;
                                continue;
                            }
                        }
                    }
                    int n14 = n;
                    if (i == array[0]) {
                        n14 = n;
                        if (n9 < 900) {
                            array2[n] = n9;
                            n14 = n + 1;
                        }
                    }
                    int n15 = 0;
                    while (true) {
                        n = i;
                        if (n15 >= n14) {
                            break Label_0060;
                        }
                        byteArrayOutputStream.write((byte)array2[n15]);
                        ++n15;
                    }
                    break;
                }
                case 924: {
                    while ((n = n8) < array[0]) {
                        n = n8;
                        if (n5 != 0) {
                            break;
                        }
                        i = n8 + 1;
                        n = array[n8];
                        int n16 = 0;
                        long n17 = 0L;
                        if (n < 900) {
                            n16 = n2 + 1;
                            n17 = 900L * n7 + n;
                            n = n5;
                        }
                        else {
                            switch (n) {
                                default: {
                                    n16 = n2;
                                    n = n5;
                                    n17 = n7;
                                    break;
                                }
                                case 900:
                                case 901:
                                case 902:
                                case 922:
                                case 923:
                                case 924:
                                case 928: {
                                    --i;
                                    n = 1;
                                    n16 = n2;
                                    n17 = n7;
                                    break;
                                }
                            }
                        }
                        n2 = n16;
                        n5 = n;
                        n7 = n17;
                        n8 = i;
                        if (n16 % 5 != 0) {
                            continue;
                        }
                        n2 = n16;
                        n5 = n;
                        n7 = n17;
                        n8 = i;
                        if (n16 <= 0) {
                            continue;
                        }
                        for (int j = 0; j < 6; ++j) {
                            byteArrayOutputStream.write((byte)(n17 >> (5 - j) * 8));
                        }
                        n7 = 0L;
                        n2 = 0;
                        n8 = i;
                        n5 = n;
                    }
                    break;
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return n;
    }
    
    static DecoderResult decode(final int[] array, final String s) throws FormatException {
        final StringBuilder sb = new StringBuilder(array.length << 1);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i = 1 + 1;
        int n = array[1];
        final PDF417ResultMetadata other = new PDF417ResultMetadata();
        while (i < array[0]) {
            int n2 = 0;
            switch (n) {
                default: {
                    n2 = textCompaction(array, i - 1, sb);
                    break;
                }
                case 900: {
                    n2 = textCompaction(array, i, sb);
                    break;
                }
                case 901:
                case 924: {
                    n2 = byteCompaction(n, array, charset, i, sb);
                    break;
                }
                case 913: {
                    sb.append((char)array[i]);
                    n2 = i + 1;
                    break;
                }
                case 902: {
                    n2 = numericCompaction(array, i, sb);
                    break;
                }
                case 927: {
                    charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(array[i]).name());
                    n2 = i + 1;
                    break;
                }
                case 926: {
                    n2 = i + 2;
                    break;
                }
                case 925: {
                    n2 = i + 1;
                    break;
                }
                case 928: {
                    n2 = decodeMacroBlock(array, i, other);
                    break;
                }
                case 922:
                case 923: {
                    throw FormatException.getFormatInstance();
                }
            }
            if (n2 >= array.length) {
                throw FormatException.getFormatInstance();
            }
            final int n3 = array[n2];
            final int n4 = n2 + 1;
            n = n3;
            i = n4;
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        final DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, s);
        decoderResult.setOther(other);
        return decoderResult;
    }
    
    private static String decodeBase900toBase10(final int[] array, final int n) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i = 0; i < n; ++i) {
            bigInteger = bigInteger.add(DecodedBitStreamParser.EXP900[n - i - 1].multiply(BigInteger.valueOf(array[i])));
        }
        final String string = bigInteger.toString();
        if (string.charAt(0) != '1') {
            throw FormatException.getFormatInstance();
        }
        return string.substring(1);
    }
    
    private static int decodeMacroBlock(final int[] array, int textCompaction, final PDF417ResultMetadata pdf417ResultMetadata) throws FormatException {
        if (textCompaction + 2 > array[0]) {
            throw FormatException.getFormatInstance();
        }
        final int[] array2 = new int[2];
        for (int i = 0; i < 2; ++i, ++textCompaction) {
            array2[i] = array[textCompaction];
        }
        pdf417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(array2, 2)));
        final StringBuilder sb = new StringBuilder();
        textCompaction = textCompaction(array, textCompaction, sb);
        pdf417ResultMetadata.setFileId(sb.toString());
        switch (array[textCompaction]) {
            default: {
                return textCompaction;
            }
            case 923: {
                ++textCompaction;
                final int[] original = new int[array[0] - textCompaction];
                int newLength = 0;
                int n = 0;
                while (textCompaction < array[0] && n == 0) {
                    final int n2 = textCompaction + 1;
                    textCompaction = array[textCompaction];
                    if (textCompaction < 900) {
                        original[newLength] = textCompaction;
                        ++newLength;
                        textCompaction = n2;
                    }
                    else {
                        switch (textCompaction) {
                            default: {
                                throw FormatException.getFormatInstance();
                            }
                            case 922: {
                                pdf417ResultMetadata.setLastSegment(true);
                                textCompaction = n2 + 1;
                                n = 1;
                                continue;
                            }
                        }
                    }
                }
                pdf417ResultMetadata.setOptionalData(Arrays.copyOf(original, newLength));
                return textCompaction;
            }
            case 922: {
                pdf417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            }
        }
    }
    
    private static void decodeTextCompaction(final int[] array, final int[] array2, final int n, final StringBuilder sb) {
        Mode mode = Mode.ALPHA;
        Mode alpha = Mode.ALPHA;
        for (int i = 0; i < n; ++i) {
            final int n2 = array[i];
            char c = '\0';
            Label_0076: {
                switch (mode) {
                    case ALPHA: {
                        if (n2 < 26) {
                            c = (char)(n2 + 65);
                            break;
                        }
                        switch (n2) {
                            default: {
                                break Label_0076;
                            }
                            case 26: {
                                c = ' ';
                                break Label_0076;
                            }
                            case 27: {
                                mode = Mode.LOWER;
                                break Label_0076;
                            }
                            case 28: {
                                mode = Mode.MIXED;
                                break Label_0076;
                            }
                            case 29: {
                                final Mode punct_SHIFT = Mode.PUNCT_SHIFT;
                                alpha = mode;
                                mode = punct_SHIFT;
                                break Label_0076;
                            }
                            case 913: {
                                sb.append((char)array2[i]);
                                break Label_0076;
                            }
                            case 900: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                        }
                        break;
                    }
                    case LOWER: {
                        if (n2 < 26) {
                            c = (char)(n2 + 97);
                            break;
                        }
                        switch (n2) {
                            default: {
                                break Label_0076;
                            }
                            case 26: {
                                c = ' ';
                                break Label_0076;
                            }
                            case 27: {
                                final Mode alpha_SHIFT = Mode.ALPHA_SHIFT;
                                alpha = mode;
                                mode = alpha_SHIFT;
                                break Label_0076;
                            }
                            case 28: {
                                mode = Mode.MIXED;
                                break Label_0076;
                            }
                            case 29: {
                                final Mode punct_SHIFT2 = Mode.PUNCT_SHIFT;
                                alpha = mode;
                                mode = punct_SHIFT2;
                                break Label_0076;
                            }
                            case 913: {
                                sb.append((char)array2[i]);
                                break Label_0076;
                            }
                            case 900: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                        }
                        break;
                    }
                    case MIXED: {
                        if (n2 < 25) {
                            c = DecodedBitStreamParser.MIXED_CHARS[n2];
                            break;
                        }
                        switch (n2) {
                            default: {
                                break Label_0076;
                            }
                            case 25: {
                                mode = Mode.PUNCT;
                                break Label_0076;
                            }
                            case 26: {
                                c = ' ';
                                break Label_0076;
                            }
                            case 27: {
                                mode = Mode.LOWER;
                                break Label_0076;
                            }
                            case 28: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                            case 29: {
                                final Mode punct_SHIFT3 = Mode.PUNCT_SHIFT;
                                alpha = mode;
                                mode = punct_SHIFT3;
                                break Label_0076;
                            }
                            case 913: {
                                sb.append((char)array2[i]);
                                break Label_0076;
                            }
                            case 900: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                        }
                        break;
                    }
                    case PUNCT: {
                        if (n2 < 29) {
                            c = DecodedBitStreamParser.PUNCT_CHARS[n2];
                            break;
                        }
                        switch (n2) {
                            default: {
                                break Label_0076;
                            }
                            case 29: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                            case 913: {
                                sb.append((char)array2[i]);
                                break Label_0076;
                            }
                            case 900: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                        }
                        break;
                    }
                    case ALPHA_SHIFT: {
                        mode = alpha;
                        if (n2 < 26) {
                            c = (char)(n2 + 65);
                            break;
                        }
                        switch (n2) {
                            default: {
                                break Label_0076;
                            }
                            case 26: {
                                c = ' ';
                                break Label_0076;
                            }
                            case 900: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                        }
                        break;
                    }
                    case PUNCT_SHIFT: {
                        mode = alpha;
                        if (n2 < 29) {
                            c = DecodedBitStreamParser.PUNCT_CHARS[n2];
                            break;
                        }
                        switch (n2) {
                            default: {
                                break Label_0076;
                            }
                            case 29: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                            case 913: {
                                sb.append((char)array2[i]);
                                break Label_0076;
                            }
                            case 900: {
                                mode = Mode.ALPHA;
                                break Label_0076;
                            }
                        }
                        break;
                    }
                }
            }
            if (c != '\0') {
                sb.append(c);
            }
        }
    }
    
    private static int numericCompaction(final int[] array, int n, final StringBuilder sb) throws FormatException {
        int n2 = 0;
        int n3 = 0;
        final int[] array2 = new int[15];
        int n4 = n;
        while (n4 < array[0] && n3 == 0) {
            n = n4 + 1;
            final int n5 = array[n4];
            int n6 = n3;
            if (n == array[0]) {
                n6 = 1;
            }
            int n7 = 0;
            if (n5 < 900) {
                array2[n2] = n5;
                n7 = n2 + 1;
            }
            else {
                switch (n5) {
                    default: {
                        n7 = n2;
                        break;
                    }
                    case 900:
                    case 901:
                    case 922:
                    case 923:
                    case 924:
                    case 928: {
                        --n;
                        n6 = 1;
                        n7 = n2;
                        break;
                    }
                }
            }
            if (n7 % 15 != 0 && n5 != 902) {
                n2 = n7;
                n3 = n6;
                n4 = n;
                if (n6 == 0) {
                    continue;
                }
            }
            n2 = n7;
            n3 = n6;
            n4 = n;
            if (n7 > 0) {
                sb.append(decodeBase900toBase10(array2, n7));
                n2 = 0;
                n3 = n6;
                n4 = n;
            }
        }
        return n4;
    }
    
    private static int textCompaction(final int[] array, int n, final StringBuilder sb) {
        final int[] array2 = new int[array[0] - n << 1];
        final int[] array3 = new int[array[0] - n << 1];
        int n2 = 0;
        int n3 = 0;
        while (n < array[0] && n3 == 0) {
            final int n4 = n + 1;
            n = array[n];
            if (n < 900) {
                array2[n2] = n / 30;
                array2[n2 + 1] = n % 30;
                n2 += 2;
                n = n4;
            }
            else {
                switch (n) {
                    default: {
                        n = n4;
                        continue;
                    }
                    case 900: {
                        array2[n2] = 900;
                        ++n2;
                        n = n4;
                        continue;
                    }
                    case 901:
                    case 902:
                    case 922:
                    case 923:
                    case 924:
                    case 928: {
                        n = n4 - 1;
                        n3 = 1;
                        continue;
                    }
                    case 913: {
                        array2[n2] = 913;
                        n = n4 + 1;
                        array3[n2] = array[n4];
                        ++n2;
                        continue;
                    }
                }
            }
        }
        decodeTextCompaction(array2, array3, n2, sb);
        return n;
    }
    
    private enum Mode
    {
        ALPHA, 
        ALPHA_SHIFT, 
        LOWER, 
        MIXED, 
        PUNCT, 
        PUNCT_SHIFT;
    }
}
