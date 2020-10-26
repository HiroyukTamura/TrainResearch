// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;

public final class Decoder
{
    private final ReedSolomonDecoder rsDecoder;
    
    public Decoder() {
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);
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
    
    private DecoderResult decode(final BitMatrixParser bitMatrixParser, final Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        final Version version = bitMatrixParser.readVersion();
        final ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser.readFormatInformation().getErrorCorrectionLevel();
        final DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), version, errorCorrectionLevel);
        int n = 0;
        for (int length = dataBlocks.length, i = 0; i < length; ++i) {
            n += dataBlocks[i].getNumDataCodewords();
        }
        final byte[] array = new byte[n];
        int n2 = 0;
        for (int length2 = dataBlocks.length, j = 0; j < length2; ++j) {
            final DataBlock dataBlock = dataBlocks[j];
            final byte[] codewords = dataBlock.getCodewords();
            final int numDataCodewords = dataBlock.getNumDataCodewords();
            this.correctErrors(codewords, numDataCodewords);
            for (int k = 0; k < numDataCodewords; ++k, ++n2) {
                array[n2] = codewords[k];
            }
        }
        return DecodedBitStreamParser.decode(array, version, errorCorrectionLevel, map);
    }
    
    public DecoderResult decode(final BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return this.decode(bitMatrix, null);
    }
    
    public DecoderResult decode(BitMatrix ex, Map<DecodeHintType, ?> decode) throws FormatException, ChecksumException {
        final BitMatrixParser bitMatrixParser = new BitMatrixParser((BitMatrix)ex);
        ex = null;
        try {
            return this.decode(bitMatrixParser, (Map<DecodeHintType, ?>)decode);
        }
        catch (FormatException ex2) {}
        catch (ChecksumException ex) {}
        try {
            bitMatrixParser.remask();
            bitMatrixParser.setMirror(true);
            bitMatrixParser.readVersion();
            bitMatrixParser.readFormatInformation();
            bitMatrixParser.mirror();
            decode = this.decode(bitMatrixParser, (Map<DecodeHintType, ?>)decode);
            decode.setOther(new QRCodeDecoderMetaData(true));
            return decode;
        }
        catch (FormatException ex3) {}
        catch (ChecksumException decode) {
            goto Label_0078;
        }
    }
    
    public DecoderResult decode(final boolean[][] array) throws ChecksumException, FormatException {
        return this.decode(array, null);
    }
    
    public DecoderResult decode(final boolean[][] array, final Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return this.decode(BitMatrix.parse(array), map);
    }
}
