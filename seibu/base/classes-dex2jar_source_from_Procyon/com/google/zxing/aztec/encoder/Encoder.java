// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.encoder;

import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.BitArray;

public final class Encoder
{
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE;
    
    static {
        WORD_SIZE = new int[] { 4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
    }
    
    private Encoder() {
    }
    
    private static int[] bitsToWords(final BitArray bitArray, final int n, int i) {
        final int[] array = new int[i];
        int n2;
        int j;
        int n3;
        for (i = 0; i < bitArray.getSize() / n; ++i) {
            n2 = 0;
            for (j = 0; j < n; ++j) {
                if (bitArray.get(i * n + j)) {
                    n3 = 1 << n - j - 1;
                }
                else {
                    n3 = 0;
                }
                n2 |= n3;
            }
            array[i] = n2;
        }
        return array;
    }
    
    private static void drawBullsEye(final BitMatrix bitMatrix, final int n, final int n2) {
        for (int i = 0; i < n2; i += 2) {
            for (int j = n - i; j <= n + i; ++j) {
                bitMatrix.set(j, n - i);
                bitMatrix.set(j, n + i);
                bitMatrix.set(n - i, j);
                bitMatrix.set(n + i, j);
            }
        }
        bitMatrix.set(n - n2, n - n2);
        bitMatrix.set(n - n2 + 1, n - n2);
        bitMatrix.set(n - n2, n - n2 + 1);
        bitMatrix.set(n + n2, n - n2);
        bitMatrix.set(n + n2, n - n2 + 1);
        bitMatrix.set(n + n2, n + n2 - 1);
    }
    
    private static void drawModeMessage(final BitMatrix bitMatrix, final boolean b, int i, final BitArray bitArray) {
        final int n = i / 2;
        if (b) {
            int n2;
            for (i = 0; i < 7; ++i) {
                n2 = n - 3 + i;
                if (bitArray.get(i)) {
                    bitMatrix.set(n2, n - 5);
                }
                if (bitArray.get(i + 7)) {
                    bitMatrix.set(n + 5, n2);
                }
                if (bitArray.get(20 - i)) {
                    bitMatrix.set(n2, n + 5);
                }
                if (bitArray.get(27 - i)) {
                    bitMatrix.set(n - 5, n2);
                }
            }
        }
        else {
            int n3;
            for (i = 0; i < 10; ++i) {
                n3 = n - 5 + i + i / 5;
                if (bitArray.get(i)) {
                    bitMatrix.set(n3, n - 7);
                }
                if (bitArray.get(i + 10)) {
                    bitMatrix.set(n + 7, n3);
                }
                if (bitArray.get(29 - i)) {
                    bitMatrix.set(n3, n + 7);
                }
                if (bitArray.get(39 - i)) {
                    bitMatrix.set(n - 7, n3);
                }
            }
        }
    }
    
    public static AztecCode encode(final byte[] array) {
        return encode(array, 33, 0);
    }
    
    public static AztecCode encode(final byte[] array, int totalBitsInLayer, int i) {
        final BitArray encode = new HighLevelEncoder(array).encode();
        final int n = encode.getSize() * totalBitsInLayer / 100 + 11;
        final int size = encode.getSize();
        int layers = 0;
        boolean compact = false;
        BitArray bitArray2 = null;
        int n4 = 0;
        int n5 = 0;
        Label_0380: {
            if (i == 0) {
                int n2 = 0;
                BitArray stuffBits = null;
                boolean b;
                int totalBitsInLayer2;
                BitArray bitArray;
                int n3;
                for (i = 0; i <= 32; ++i, stuffBits = bitArray, n2 = n3) {
                    b = (i <= 3);
                    if (b) {
                        layers = i + 1;
                    }
                    else {
                        layers = i;
                    }
                    totalBitsInLayer2 = totalBitsInLayer(layers, b);
                    bitArray = stuffBits;
                    n3 = n2;
                    if (size + n <= totalBitsInLayer2) {
                        if ((totalBitsInLayer = n2) != Encoder.WORD_SIZE[layers]) {
                            totalBitsInLayer = Encoder.WORD_SIZE[layers];
                            stuffBits = stuffBits(encode, totalBitsInLayer);
                        }
                        if (b) {
                            bitArray = stuffBits;
                            n3 = totalBitsInLayer;
                            if (stuffBits.getSize() > totalBitsInLayer << 6) {
                                continue;
                            }
                        }
                        compact = b;
                        bitArray2 = stuffBits;
                        n4 = totalBitsInLayer2;
                        n5 = totalBitsInLayer;
                        if (stuffBits.getSize() + n <= totalBitsInLayer2 - totalBitsInLayer2 % totalBitsInLayer) {
                            break Label_0380;
                        }
                        n3 = totalBitsInLayer;
                        bitArray = stuffBits;
                    }
                }
                throw new IllegalArgumentException("Data too large for an Aztec code");
            }
            final boolean b2 = i < 0;
            final int abs = Math.abs(i);
            if (b2) {
                totalBitsInLayer = 4;
            }
            else {
                totalBitsInLayer = 32;
            }
            if (abs > totalBitsInLayer) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", i));
            }
            totalBitsInLayer = totalBitsInLayer(abs, b2);
            i = Encoder.WORD_SIZE[abs];
            final BitArray stuffBits2 = stuffBits(encode, i);
            if (stuffBits2.getSize() + n > totalBitsInLayer - totalBitsInLayer % i) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            compact = b2;
            layers = abs;
            bitArray2 = stuffBits2;
            n4 = totalBitsInLayer;
            n5 = i;
            if (b2) {
                compact = b2;
                layers = abs;
                bitArray2 = stuffBits2;
                n4 = totalBitsInLayer;
                n5 = i;
                if (stuffBits2.getSize() > i << 6) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            }
        }
        final BitArray generateCheckWords = generateCheckWords(bitArray2, n4, n5);
        final int codeWords = bitArray2.getSize() / n5;
        final BitArray generateModeMessage = generateModeMessage(compact, layers, codeWords);
        if (compact) {
            totalBitsInLayer = 11;
        }
        else {
            totalBitsInLayer = 14;
        }
        final int n6 = totalBitsInLayer + (layers << 2);
        final int[] array2 = new int[n6];
        if (compact) {
            i = n6;
            int n7 = 0;
            while (true) {
                totalBitsInLayer = i;
                if (n7 >= array2.length) {
                    break;
                }
                array2[n7] = n7;
                ++n7;
            }
        }
        else {
            final int n8 = n6 + 1 + (n6 / 2 - 1) / 15 * 2;
            final int n9 = n6 / 2;
            final int n10 = n8 / 2;
            i = 0;
            while (true) {
                totalBitsInLayer = n8;
                if (i >= n9) {
                    break;
                }
                totalBitsInLayer = i + i / 15;
                array2[n9 - i - 1] = n10 - totalBitsInLayer - 1;
                array2[n9 + i] = n10 + totalBitsInLayer + 1;
                ++i;
            }
        }
        final BitMatrix matrix = new BitMatrix(totalBitsInLayer);
        i = 0;
        int n11 = 0;
        while (i < layers) {
            int n12;
            if (compact) {
                n12 = 9;
            }
            else {
                n12 = 12;
            }
            final int n13 = (layers - i << 2) + n12;
            for (int j = 0; j < n13; ++j) {
                final int n14 = j << 1;
                for (int k = 0; k < 2; ++k) {
                    if (generateCheckWords.get(n11 + n14 + k)) {
                        matrix.set(array2[(i << 1) + k], array2[(i << 1) + j]);
                    }
                    if (generateCheckWords.get((n13 << 1) + n11 + n14 + k)) {
                        matrix.set(array2[(i << 1) + j], array2[n6 - 1 - (i << 1) - k]);
                    }
                    if (generateCheckWords.get((n13 << 2) + n11 + n14 + k)) {
                        matrix.set(array2[n6 - 1 - (i << 1) - k], array2[n6 - 1 - (i << 1) - j]);
                    }
                    if (generateCheckWords.get(n13 * 6 + n11 + n14 + k)) {
                        matrix.set(array2[n6 - 1 - (i << 1) - j], array2[(i << 1) + k]);
                    }
                }
            }
            n11 += n13 << 3;
            ++i;
        }
        drawModeMessage(matrix, compact, totalBitsInLayer, generateModeMessage);
        if (compact) {
            drawBullsEye(matrix, totalBitsInLayer / 2, 5);
        }
        else {
            drawBullsEye(matrix, totalBitsInLayer / 2, 7);
            int l;
            int n15;
            for (l = 0, i = 0; l < n6 / 2 - 1; l += 15, i += 16) {
                for (n15 = (totalBitsInLayer / 2 & 0x1); n15 < totalBitsInLayer; n15 += 2) {
                    matrix.set(totalBitsInLayer / 2 - i, n15);
                    matrix.set(totalBitsInLayer / 2 + i, n15);
                    matrix.set(n15, totalBitsInLayer / 2 - i);
                    matrix.set(n15, totalBitsInLayer / 2 + i);
                }
            }
        }
        final AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(compact);
        aztecCode.setSize(totalBitsInLayer);
        aztecCode.setLayers(layers);
        aztecCode.setCodeWords(codeWords);
        aztecCode.setMatrix(matrix);
        return aztecCode;
    }
    
    private static BitArray generateCheckWords(final BitArray bitArray, int i, final int n) {
        final int n2 = 0;
        final int n3 = bitArray.getSize() / n;
        final ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(n));
        final int n4 = i / n;
        final int[] bitsToWords = bitsToWords(bitArray, n, n4);
        reedSolomonEncoder.encode(bitsToWords, n4 - n3);
        final BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % n);
        int length;
        for (length = bitsToWords.length, i = n2; i < length; ++i) {
            bitArray2.appendBits(bitsToWords[i], n);
        }
        return bitArray2;
    }
    
    static BitArray generateModeMessage(final boolean b, final int n, final int n2) {
        final BitArray bitArray = new BitArray();
        if (b) {
            bitArray.appendBits(n - 1, 2);
            bitArray.appendBits(n2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(n - 1, 5);
        bitArray.appendBits(n2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }
    
    private static GenericGF getGF(final int i) {
        switch (i) {
            default: {
                throw new IllegalArgumentException("Unsupported word size " + i);
            }
            case 4: {
                return GenericGF.AZTEC_PARAM;
            }
            case 6: {
                return GenericGF.AZTEC_DATA_6;
            }
            case 8: {
                return GenericGF.AZTEC_DATA_8;
            }
            case 10: {
                return GenericGF.AZTEC_DATA_10;
            }
            case 12: {
                return GenericGF.AZTEC_DATA_12;
            }
        }
    }
    
    static BitArray stuffBits(final BitArray bitArray, final int n) {
        final BitArray bitArray2 = new BitArray();
        final int size = bitArray.getSize();
        final int n2 = (1 << n) - 2;
        for (int i = 0; i < size; i += n) {
            int n3 = 0;
            int n4;
            for (int j = 0; j < n; ++j, n3 = n4) {
                if (i + j < size) {
                    n4 = n3;
                    if (!bitArray.get(i + j)) {
                        continue;
                    }
                }
                n4 = (n3 | 1 << n - 1 - j);
            }
            if ((n3 & n2) == n2) {
                bitArray2.appendBits(n3 & n2, n);
                --i;
            }
            else if ((n3 & n2) == 0x0) {
                bitArray2.appendBits(n3 | 0x1, n);
                --i;
            }
            else {
                bitArray2.appendBits(n3, n);
            }
        }
        return bitArray2;
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
}
