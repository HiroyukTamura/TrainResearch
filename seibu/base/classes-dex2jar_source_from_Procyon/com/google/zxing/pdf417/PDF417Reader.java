// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.DecoderResult;
import java.util.Iterator;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.ResultPoint;
import com.google.zxing.pdf417.detector.Detector;
import java.util.ArrayList;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.Reader;

public final class PDF417Reader implements Reader, MultipleBarcodeReader
{
    private static Result[] decode(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map, final boolean b) throws NotFoundException, FormatException, ChecksumException {
        final ArrayList<Result> list = new ArrayList<Result>();
        final PDF417DetectorResult detect = Detector.detect(binaryBitmap, map, b);
        for (final ResultPoint[] array : detect.getPoints()) {
            final DecoderResult decode = PDF417ScanningDecoder.decode(detect.getBits(), array[4], array[5], array[6], array[7], getMinCodewordWidth(array), getMaxCodewordWidth(array));
            final Result result = new Result(decode.getText(), decode.getRawBytes(), array, BarcodeFormat.PDF_417);
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, decode.getECLevel());
            final PDF417ResultMetadata pdf417ResultMetadata = (PDF417ResultMetadata)decode.getOther();
            if (pdf417ResultMetadata != null) {
                result.putMetadata(ResultMetadataType.PDF417_EXTRA_METADATA, pdf417ResultMetadata);
            }
            list.add(result);
        }
        return list.toArray(new Result[list.size()]);
    }
    
    private static int getMaxCodewordWidth(final ResultPoint[] array) {
        return Math.max(Math.max(getMaxWidth(array[0], array[4]), getMaxWidth(array[6], array[2]) * 17 / 18), Math.max(getMaxWidth(array[1], array[5]), getMaxWidth(array[7], array[3]) * 17 / 18));
    }
    
    private static int getMaxWidth(final ResultPoint resultPoint, final ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int)Math.abs(resultPoint.getX() - resultPoint2.getX());
    }
    
    private static int getMinCodewordWidth(final ResultPoint[] array) {
        return Math.min(Math.min(getMinWidth(array[0], array[4]), getMinWidth(array[6], array[2]) * 17 / 18), Math.min(getMinWidth(array[1], array[5]), getMinWidth(array[7], array[3]) * 17 / 18));
    }
    
    private static int getMinWidth(final ResultPoint resultPoint, final ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int)Math.abs(resultPoint.getX() - resultPoint2.getX());
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, FormatException, ChecksumException {
        return this.decode(binaryBitmap, null);
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        final Result[] decode = decode(binaryBitmap, map, false);
        if (decode == null || decode.length == 0 || decode[0] == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        return decode[0];
    }
    
    @Override
    public Result[] decodeMultiple(final BinaryBitmap binaryBitmap) throws NotFoundException {
        return this.decodeMultiple(binaryBitmap, null);
    }
    
    @Override
    public Result[] decodeMultiple(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return decode(binaryBitmap, map, true);
        }
        catch (FormatException ex) {}
        catch (ChecksumException ex2) {
            goto Label_0010;
        }
    }
    
    @Override
    public void reset() {
    }
}
