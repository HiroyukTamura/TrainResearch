// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.maxicode;

import com.google.zxing.common.DecoderResult;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.maxicode.decoder.Decoder;
import com.google.zxing.ResultPoint;
import com.google.zxing.Reader;

public final class MaxiCodeReader implements Reader
{
    private static final int MATRIX_HEIGHT = 33;
    private static final int MATRIX_WIDTH = 30;
    private static final ResultPoint[] NO_POINTS;
    private final Decoder decoder;
    
    static {
        NO_POINTS = new ResultPoint[0];
    }
    
    public MaxiCodeReader() {
        this.decoder = new Decoder();
    }
    
    private static BitMatrix extractPureBits(final BitMatrix bitMatrix) throws NotFoundException {
        final int[] enclosingRectangle = bitMatrix.getEnclosingRectangle();
        if (enclosingRectangle == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int n = enclosingRectangle[0];
        final int n2 = enclosingRectangle[1];
        final int n3 = enclosingRectangle[2];
        final int n4 = enclosingRectangle[3];
        final BitMatrix bitMatrix2 = new BitMatrix(30, 33);
        for (int i = 0; i < 33; ++i) {
            final int n5 = (i * n4 + n4 / 2) / 33;
            for (int j = 0; j < 30; ++j) {
                if (bitMatrix.get(n + (j * n3 + n3 / 2 + (i & 0x1) * n3 / 2) / 30, n2 + n5)) {
                    bitMatrix2.set(j, i);
                }
            }
        }
        return bitMatrix2;
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return this.decode(binaryBitmap, null);
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            final DecoderResult decode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            final Result result = new Result(decode.getText(), decode.getRawBytes(), MaxiCodeReader.NO_POINTS, BarcodeFormat.MAXICODE);
            final String ecLevel = decode.getECLevel();
            if (ecLevel != null) {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, ecLevel);
            }
            return result;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    @Override
    public void reset() {
    }
}
