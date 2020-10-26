// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix;

import java.util.List;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.datamatrix.detector.Detector;
import com.google.zxing.FormatException;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.ResultPoint;
import com.google.zxing.Reader;

public final class DataMatrixReader implements Reader
{
    private static final ResultPoint[] NO_POINTS;
    private final Decoder decoder;
    
    static {
        NO_POINTS = new ResultPoint[0];
    }
    
    public DataMatrixReader() {
        this.decoder = new Decoder();
    }
    
    private static BitMatrix extractPureBits(final BitMatrix bitMatrix) throws NotFoundException {
        final int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        final int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        final int n = topLeftOnBit[1];
        final int n2 = bottomRightOnBit[1];
        final int n3 = topLeftOnBit[0];
        final int n4 = (bottomRightOnBit[0] - n3 + 1) / moduleSize;
        final int n5 = (n2 - n + 1) / moduleSize;
        if (n4 <= 0 || n5 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int n6 = moduleSize / 2;
        final BitMatrix bitMatrix2 = new BitMatrix(n4, n5);
        for (int i = 0; i < n5; ++i) {
            for (int j = 0; j < n4; ++j) {
                if (bitMatrix.get(j * moduleSize + (n3 + n6), n + n6 + i * moduleSize)) {
                    bitMatrix2.set(j, i);
                }
            }
        }
        return bitMatrix2;
    }
    
    private static int moduleSize(final int[] array, final BitMatrix bitMatrix) throws NotFoundException {
        final int width = bitMatrix.getWidth();
        int n = array[0];
        for (int n2 = array[1]; n < width && bitMatrix.get(n, n2); ++n) {}
        if (n == width) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int n3 = n - array[0];
        if (n3 == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        return n3;
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return this.decode(binaryBitmap, null);
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        DecoderResult decoderResult;
        ResultPoint[] array;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()));
            array = DataMatrixReader.NO_POINTS;
        }
        else {
            final DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect();
            decoderResult = this.decoder.decode(detect.getBits());
            array = detect.getPoints();
        }
        final Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), array, BarcodeFormat.DATA_MATRIX);
        final List<byte[]> byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        final String ecLevel = decoderResult.getECLevel();
        if (ecLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, ecLevel);
        }
        return result;
    }
    
    @Override
    public void reset() {
    }
}
