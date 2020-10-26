// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.maxicode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;

public final class Decoder
{
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final ReedSolomonDecoder rsDecoder;
    
    public Decoder() {
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);
    }
    
    private void correctErrors(final byte[] array, final int n, final int n2, int i, final int n3) throws ChecksumException {
        final int n4 = n2 + i;
        int n5;
        if (n3 == 0) {
            n5 = 1;
        }
        else {
            n5 = 2;
        }
        final int[] array2 = new int[n4 / n5];
        for (int j = 0; j < n4; ++j) {
            if (n3 == 0 || j % 2 == n3 - 1) {
                array2[j / n5] = (array[j + n] & 0xFF);
            }
        }
        try {
            this.rsDecoder.decode(array2, i / n5);
            for (i = 0; i < n2; ++i) {
                if (n3 == 0 || i % 2 == n3 - 1) {
                    array[i + n] = (byte)array2[i / n5];
                }
            }
        }
        catch (ReedSolomonException ex) {
            throw ChecksumException.getChecksumInstance();
        }
    }
    
    public DecoderResult decode(final BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return this.decode(bitMatrix, null);
    }
    
    public DecoderResult decode(final BitMatrix bitMatrix, final Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        final byte[] codewords = new BitMatrixParser(bitMatrix).readCodewords();
        this.correctErrors(codewords, 0, 10, 10, 0);
        final int n = codewords[0] & 0xF;
        byte[] array = null;
        switch (n) {
            default: {
                throw FormatException.getFormatInstance();
            }
            case 2:
            case 3:
            case 4: {
                this.correctErrors(codewords, 20, 84, 40, 1);
                this.correctErrors(codewords, 20, 84, 40, 2);
                array = new byte[94];
                break;
            }
            case 5: {
                this.correctErrors(codewords, 20, 68, 56, 1);
                this.correctErrors(codewords, 20, 68, 56, 2);
                array = new byte[78];
                break;
            }
        }
        System.arraycopy(codewords, 0, array, 0, 10);
        System.arraycopy(codewords, 20, array, 10, array.length - 10);
        return DecodedBitStreamParser.decode(array, n);
    }
}
