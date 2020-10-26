// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.multi;

import java.util.ArrayList;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import java.util.Iterator;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.List;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Reader;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader
{
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;
    
    public GenericMultipleBarcodeReader(final Reader delegate) {
        this.delegate = delegate;
    }
    
    private void doDecodeMultiple(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map, final List<Result> list, final int n, final int n2, final int n3) {
        if (n3 <= 4) {
            try {
                final Result decode = this.delegate.decode(binaryBitmap, map);
                final int n4 = 0;
                final Iterator<Result> iterator = list.iterator();
                while (true) {
                    do {
                        final int n5 = n4;
                        if (iterator.hasNext()) {
                            continue;
                        }
                        if (n5 == 0) {
                            list.add(translateResultPoints(decode, n, n2));
                        }
                        final ResultPoint[] resultPoints = decode.getResultPoints();
                        if (resultPoints == null || resultPoints.length == 0) {
                            return;
                        }
                        final int width = binaryBitmap.getWidth();
                        final int height = binaryBitmap.getHeight();
                        float n6 = (float)width;
                        float n7 = (float)height;
                        float n8 = 0.0f;
                        float n9 = 0.0f;
                        float n10;
                        float n11;
                        float n12;
                        float n13;
                        for (int length = resultPoints.length, i = 0; i < length; ++i, n8 = n10, n9 = n11, n6 = n12, n7 = n13) {
                            final ResultPoint resultPoint = resultPoints[i];
                            n10 = n8;
                            n11 = n9;
                            n12 = n6;
                            n13 = n7;
                            if (resultPoint != null) {
                                final float x = resultPoint.getX();
                                final float y = resultPoint.getY();
                                float n14 = n6;
                                if (x < n6) {
                                    n14 = x;
                                }
                                float n15 = n7;
                                if (y < n7) {
                                    n15 = y;
                                }
                                float n16 = n8;
                                if (x > n8) {
                                    n16 = x;
                                }
                                n10 = n16;
                                n11 = n9;
                                n12 = n14;
                                n13 = n15;
                                if (y > n9) {
                                    n13 = n15;
                                    n12 = n14;
                                    n11 = y;
                                    n10 = n16;
                                }
                            }
                        }
                        if (n6 > 100.0f) {
                            this.doDecodeMultiple(binaryBitmap.crop(0, 0, (int)n6, height), map, list, n, n2, n3 + 1);
                        }
                        if (n7 > 100.0f) {
                            this.doDecodeMultiple(binaryBitmap.crop(0, 0, width, (int)n7), map, list, n, n2, n3 + 1);
                        }
                        if (n8 < width - 100) {
                            this.doDecodeMultiple(binaryBitmap.crop((int)n8, 0, width - (int)n8, height), map, list, n + (int)n8, n2, n3 + 1);
                        }
                        if (n9 < height - 100) {
                            this.doDecodeMultiple(binaryBitmap.crop(0, (int)n9, width, height - (int)n9), map, list, n, n2 + (int)n9, n3 + 1);
                        }
                        return;
                    } while (!iterator.next().getText().equals(decode.getText()));
                    final int n5 = 1;
                    continue;
                }
            }
            catch (ReaderException ex) {}
        }
    }
    
    private static Result translateResultPoints(final Result result, final int n, final int n2) {
        final ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        final ResultPoint[] array = new ResultPoint[resultPoints.length];
        for (int i = 0; i < resultPoints.length; ++i) {
            final ResultPoint resultPoint = resultPoints[i];
            if (resultPoint != null) {
                array[i] = new ResultPoint(resultPoint.getX() + n, resultPoint.getY() + n2);
            }
        }
        final Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), array, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
    
    @Override
    public Result[] decodeMultiple(final BinaryBitmap binaryBitmap) throws NotFoundException {
        return this.decodeMultiple(binaryBitmap, null);
    }
    
    @Override
    public Result[] decodeMultiple(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map) throws NotFoundException {
        final ArrayList<Result> list = new ArrayList<Result>();
        this.doDecodeMultiple(binaryBitmap, map, list, 0, 0, 0);
        if (list.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return list.toArray(new Result[list.size()]);
    }
}
