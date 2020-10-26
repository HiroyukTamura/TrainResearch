// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode;

import java.util.List;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import com.google.zxing.FormatException;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.ResultPoint;
import com.google.zxing.Reader;

public class QRCodeReader implements Reader
{
    private static final ResultPoint[] NO_POINTS;
    private final Decoder decoder;
    
    static {
        NO_POINTS = new ResultPoint[0];
    }
    
    public QRCodeReader() {
        this.decoder = new Decoder();
    }
    
    private static BitMatrix extractPureBits(final BitMatrix bitMatrix) throws NotFoundException {
        final int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        final int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        final float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        final int n = topLeftOnBit[1];
        final int n2 = bottomRightOnBit[1];
        final int n3 = topLeftOnBit[0];
        final int n4 = bottomRightOnBit[0];
        if (n3 >= n4 || n >= n2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int n5 = n4;
        if (n2 - n != n4 - n3 && (n5 = n3 + (n2 - n)) >= bitMatrix.getWidth()) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int round = Math.round((n5 - n3 + 1) / moduleSize);
        final int round2 = Math.round((n2 - n + 1) / moduleSize);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        }
        final int n6 = (int)(moduleSize / 2.0f);
        final int n7 = n + n6;
        final int n8 = n3 + n6;
        final int n9 = (int)((round - 1) * moduleSize) + n8 - n5;
        int n10 = n8;
        if (n9 > 0) {
            if (n9 > n6) {
                throw NotFoundException.getNotFoundInstance();
            }
            n10 = n8 - n9;
        }
        final int n11 = (int)((round2 - 1) * moduleSize) + n7 - n2;
        int n12 = n7;
        if (n11 > 0) {
            if (n11 > n6) {
                throw NotFoundException.getNotFoundInstance();
            }
            n12 = n7 - n11;
        }
        final BitMatrix bitMatrix2 = new BitMatrix(round, round2);
        for (int i = 0; i < round2; ++i) {
            final int n13 = (int)(i * moduleSize);
            for (int j = 0; j < round; ++j) {
                if (bitMatrix.get((int)(j * moduleSize) + n10, n12 + n13)) {
                    bitMatrix2.set(j, i);
                }
            }
        }
        return bitMatrix2;
    }
    
    private static float moduleSize(final int[] array, final BitMatrix bitMatrix) throws NotFoundException {
        final int height = bitMatrix.getHeight();
        final int width = bitMatrix.getWidth();
        int n = array[0];
        int n2 = array[1];
        int n3 = 1;
        int n4 = 0;
        while (n < width && n2 < height) {
            int n5 = n3;
            int n6 = n4;
            if (n3 != (bitMatrix.get(n, n2) ? 1 : 0)) {
                n6 = n4 + 1;
                if (n6 == 5) {
                    break;
                }
                n5 = ((n3 != 0) ? 0 : 1);
            }
            ++n;
            ++n2;
            n3 = n5;
            n4 = n6;
        }
        if (n == width || n2 == height) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (n - array[0]) / 7.0f;
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return this.decode(binaryBitmap, null);
    }
    
    @Override
    public final Result decode(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        DecoderResult decoderResult;
        ResultPoint[] array;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            array = QRCodeReader.NO_POINTS;
        }
        else {
            final DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            decoderResult = this.decoder.decode(detect.getBits(), map);
            array = detect.getPoints();
        }
        if (decoderResult.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData)decoderResult.getOther()).applyMirroredCorrection(array);
        }
        final Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), array, BarcodeFormat.QR_CODE);
        final List<byte[]> byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        final String ecLevel = decoderResult.getECLevel();
        if (ecLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, ecLevel);
        }
        if (decoderResult.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, decoderResult.getStructuredAppendSequenceNumber());
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, decoderResult.getStructuredAppendParity());
        }
        return result;
    }
    
    protected final Decoder getDecoder() {
        return this.decoder;
    }
    
    @Override
    public void reset() {
    }
}
