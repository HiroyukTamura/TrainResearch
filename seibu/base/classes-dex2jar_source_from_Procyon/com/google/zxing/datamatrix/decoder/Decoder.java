// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;

public final class Decoder
{
    private final ReedSolomonDecoder rsDecoder;
    
    public Decoder() {
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);
    }
    
    private void correctErrors(final byte[] array, final int n) throws ChecksumException {
        final int length = array.length;
        final int[] array2 = new int[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = (array[i] & 0xFF);
        }
        try {
            this.rsDecoder.decode(array2, array.length - n);
            for (int j = 0; j < n; ++j) {
                array[j] = (byte)array2[j];
            }
        }
        catch (ReedSolomonException ex) {
            throw ChecksumException.getChecksumInstance();
        }
    }
    
    public DecoderResult decode(final BitMatrix bitMatrix) throws FormatException, ChecksumException {
        final BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        final DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), bitMatrixParser.getVersion());
        int n = 0;
        for (int length = dataBlocks.length, i = 0; i < length; ++i) {
            n += dataBlocks[i].getNumDataCodewords();
        }
        final byte[] array = new byte[n];
        for (int length2 = dataBlocks.length, j = 0; j < length2; ++j) {
            final DataBlock dataBlock = dataBlocks[j];
            final byte[] codewords = dataBlock.getCodewords();
            final int numDataCodewords = dataBlock.getNumDataCodewords();
            this.correctErrors(codewords, numDataCodewords);
            for (int k = 0; k < numDataCodewords; ++k) {
                array[k * length2 + j] = codewords[k];
            }
        }
        return DecodedBitStreamParser.decode(array);
    }
    
    public DecoderResult decode(final boolean[][] array) throws FormatException, ChecksumException {
        return this.decode(BitMatrix.parse(array));
    }
}
