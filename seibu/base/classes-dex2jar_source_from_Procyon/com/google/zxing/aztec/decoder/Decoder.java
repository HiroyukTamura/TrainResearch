// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.decoder;

import java.util.List;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.BitMatrix;
import java.util.Arrays;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.aztec.AztecDetectorResult;

public final class Decoder
{
    private static final String[] DIGIT_TABLE;
    private static final String[] LOWER_TABLE;
    private static final String[] MIXED_TABLE;
    private static final String[] PUNCT_TABLE;
    private static final String[] UPPER_TABLE;
    private AztecDetectorResult ddata;
    
    static {
        UPPER_TABLE = new String[] { "CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS" };
        LOWER_TABLE = new String[] { "CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS" };
        MIXED_TABLE = new String[] { "CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS" };
        PUNCT_TABLE = new String[] { "", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL" };
        DIGIT_TABLE = new String[] { "CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US" };
    }
    
    static byte[] convertBoolArrayToByteArray(final boolean[] array) {
        final byte[] array2 = new byte[(array.length + 7) / 8];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = readByte(array, i << 3);
        }
        return array2;
    }
    
    private boolean[] correctBits(boolean[] a) throws FormatException {
        int n;
        GenericGF genericGF;
        if (this.ddata.getNbLayers() <= 2) {
            n = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        }
        else if (this.ddata.getNbLayers() <= 8) {
            n = 8;
            genericGF = GenericGF.AZTEC_DATA_8;
        }
        else if (this.ddata.getNbLayers() <= 22) {
            n = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        }
        else {
            n = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        final int nbDatablocks = this.ddata.getNbDatablocks();
        final int n2 = a.length / n;
        if (n2 < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int n3 = a.length % n;
        final int[] array = new int[n2];
        for (int i = 0; i < n2; ++i, n3 += n) {
            array[i] = readCode(a, n3, n);
        }
        int n4;
        int n5;
        while (true) {
            while (true) {
                int n6;
                int n7;
                try {
                    new ReedSolomonDecoder(genericGF).decode(array, n2 - nbDatablocks);
                    n4 = (1 << n) - 1;
                    n5 = 0;
                    n6 = 0;
                    if (n6 >= nbDatablocks) {
                        break;
                    }
                    n7 = array[n6];
                    if (n7 == 0 || n7 == n4) {
                        throw FormatException.getFormatInstance();
                    }
                }
                catch (ReedSolomonException ex) {
                    throw FormatException.getFormatInstance(ex);
                }
                int n8 = 0;
                Label_0237: {
                    if (n7 != 1) {
                        n8 = n5;
                        if (n7 != n4 - 1) {
                            break Label_0237;
                        }
                    }
                    n8 = n5 + 1;
                }
                ++n6;
                n5 = n8;
                continue;
            }
        }
        a = new boolean[nbDatablocks * n - n5];
        int fromIndex = 0;
        for (int j = 0; j < nbDatablocks; ++j) {
            final int n9 = array[j];
            if (n9 == 1 || n9 == n4 - 1) {
                Arrays.fill(a, fromIndex, fromIndex + n - 1, n9 > 1);
                fromIndex += n - 1;
            }
            else {
                for (int k = n - 1; k >= 0; --k, ++fromIndex) {
                    a[fromIndex] = ((1 << k & n9) != 0x0);
                }
            }
        }
        return a;
    }
    
    private boolean[] extractBits(final BitMatrix bitMatrix) {
        final boolean compact = this.ddata.isCompact();
        final int nbLayers = this.ddata.getNbLayers();
        int n;
        if (compact) {
            n = 11;
        }
        else {
            n = 14;
        }
        final int n2 = n + (nbLayers << 2);
        final int[] array = new int[n2];
        final boolean[] array2 = new boolean[totalBitsInLayer(nbLayers, compact)];
        if (compact) {
            for (int i = 0; i < array.length; ++i) {
                array[i] = i;
            }
        }
        else {
            final int n3 = (n2 / 2 - 1) / 15;
            final int n4 = n2 / 2;
            final int n5 = (n2 + 1 + n3 * 2) / 2;
            for (int j = 0; j < n4; ++j) {
                final int n6 = j + j / 15;
                array[n4 - j - 1] = n5 - n6 - 1;
                array[n4 + j] = n5 + n6 + 1;
            }
        }
        int k = 0;
        int n7 = 0;
        while (k < nbLayers) {
            int n8;
            if (compact) {
                n8 = 9;
            }
            else {
                n8 = 12;
            }
            final int n9 = (nbLayers - k << 2) + n8;
            final int n10 = k << 1;
            final int n11 = n2 - 1 - n10;
            for (int l = 0; l < n9; ++l) {
                final int n12 = l << 1;
                for (int n13 = 0; n13 < 2; ++n13) {
                    array2[n7 + n12 + n13] = bitMatrix.get(array[n10 + n13], array[n10 + l]);
                    array2[n9 * 2 + n7 + n12 + n13] = bitMatrix.get(array[n10 + l], array[n11 - n13]);
                    array2[n9 * 4 + n7 + n12 + n13] = bitMatrix.get(array[n11 - n13], array[n11 - l]);
                    array2[n9 * 6 + n7 + n12 + n13] = bitMatrix.get(array[n11 - l], array[n10 + n13]);
                }
            }
            n7 += n9 << 3;
            ++k;
        }
        return array2;
    }
    
    private static String getCharacter(final Table table, final int n) {
        switch (table) {
            default: {
                throw new IllegalStateException("Bad table");
            }
            case UPPER: {
                return Decoder.UPPER_TABLE[n];
            }
            case LOWER: {
                return Decoder.LOWER_TABLE[n];
            }
            case MIXED: {
                return Decoder.MIXED_TABLE[n];
            }
            case PUNCT: {
                return Decoder.PUNCT_TABLE[n];
            }
            case DIGIT: {
                return Decoder.DIGIT_TABLE[n];
            }
        }
    }
    
    private static String getEncodedData(final boolean[] array) {
        final int length = array.length;
        Table upper = Table.UPPER;
        Table upper2 = Table.UPPER;
        final StringBuilder sb = new StringBuilder(20);
        int i = 0;
        while (i < length) {
            if (upper2 == Table.BINARY) {
                if (length - i < 5) {
                    break;
                }
                final int code = readCode(array, i, 5);
                int n2;
                final int n = n2 = i + 5;
                int n3;
                if ((n3 = code) == 0) {
                    if (length - n < 11) {
                        break;
                    }
                    n3 = readCode(array, n, 11) + 31;
                    n2 = n + 11;
                }
                int n4 = 0;
                int n5;
                while (true) {
                    n5 = n2;
                    if (n4 >= n3) {
                        break;
                    }
                    if (length - n2 < 8) {
                        n5 = length;
                        break;
                    }
                    sb.append((char)readCode(array, n2, 8));
                    n2 += 8;
                    ++n4;
                }
                upper2 = upper;
                i = n5;
            }
            else {
                int n6;
                if (upper2 == Table.DIGIT) {
                    n6 = 4;
                }
                else {
                    n6 = 5;
                }
                if (length - i < n6) {
                    break;
                }
                final int code2 = readCode(array, i, n6);
                final int n7 = i + n6;
                final String character = getCharacter(upper2, code2);
                if (character.startsWith("CTRL_")) {
                    upper = upper2;
                    final Table table = getTable(character.charAt(5));
                    i = n7;
                    upper2 = table;
                    if (character.charAt(6) != 'L') {
                        continue;
                    }
                    upper = table;
                    i = n7;
                    upper2 = table;
                }
                else {
                    sb.append(character);
                    upper2 = upper;
                    i = n7;
                }
            }
        }
        return sb.toString();
    }
    
    private static Table getTable(final char c) {
        switch (c) {
            default: {
                return Table.UPPER;
            }
            case 'L': {
                return Table.LOWER;
            }
            case 'P': {
                return Table.PUNCT;
            }
            case 'M': {
                return Table.MIXED;
            }
            case 'D': {
                return Table.DIGIT;
            }
            case 'B': {
                return Table.BINARY;
            }
        }
    }
    
    public static String highLevelDecode(final boolean[] array) {
        return getEncodedData(array);
    }
    
    private static byte readByte(final boolean[] array, final int n) {
        final int n2 = array.length - n;
        if (n2 >= 8) {
            return (byte)readCode(array, n, 8);
        }
        return (byte)(readCode(array, n, n2) << 8 - n2);
    }
    
    private static int readCode(final boolean[] array, final int n, final int n2) {
        int n3 = 0;
        for (int i = n; i < n + n2; ++i) {
            final int n4 = n3 <<= 1;
            if (array[i]) {
                n3 = (n4 | 0x1);
            }
        }
        return n3;
    }
    
    private static int totalBitsInLayer(final int n, final boolean b) {
        int n2;
        if (b) {
            n2 = 88;
        }
        else {
            n2 = 112;
        }
        return (n2 + (n << 4)) * n;
    }
    
    public DecoderResult decode(final AztecDetectorResult ddata) throws FormatException {
        this.ddata = ddata;
        final boolean[] correctBits = this.correctBits(this.extractBits(ddata.getBits()));
        final DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
    
    private enum Table
    {
        BINARY, 
        DIGIT, 
        LOWER, 
        MIXED, 
        PUNCT, 
        UPPER;
    }
}
