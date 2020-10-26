// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import java.util.Arrays;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import com.google.zxing.Result;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Reader;

public abstract class OneDReader implements Reader
{
    private Result doDecode(final BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        final int width = binaryBitmap.getWidth();
        final int height = binaryBitmap.getHeight();
        BitArray blackRow = new BitArray(width);
        while (true) {
            int n2 = 0;
            BitArray bitArray = null;
            Map<DecodeHintType, ?> map2 = null;
            Label_0332: {
                if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) {
                    break Label_0332;
                }
                int n = 1;
                Label_0337: {
                    if (n == 0) {
                        break Label_0337;
                    }
                    n2 = 8;
                Label_0049:
                    while (true) {
                        final int max = Math.max(1, height >> n2);
                        Label_0343: {
                            if (n == 0) {
                                break Label_0343;
                            }
                            n = height;
                        Label_0067:
                            while (true) {
                                final int n3 = height / 2;
                                n2 = 0;
                                if (n2 >= n) {
                                    throw NotFoundException.getNotFoundInstance();
                                }
                                int n4 = (n2 + 1) / 2;
                                Label_0349: {
                                    if ((n2 & 0x1) != 0x0) {
                                        break Label_0349;
                                    }
                                    int n5 = 1;
                                Label_0100:
                                    while (true) {
                                        Label_0355: {
                                            if (n5 == 0) {
                                                break Label_0355;
                                            }
                                            n5 = n4;
                                        Label_0109:
                                            while (true) {
                                                n4 = n3 + max * n5;
                                                if (n4 < 0 || n4 >= height) {
                                                    throw NotFoundException.getNotFoundInstance();
                                                }
                                                try {
                                                    blackRow = binaryBitmap.getBlackRow(n4, blackRow);
                                                    n5 = 0;
                                                    while (true) {
                                                        bitArray = blackRow;
                                                        map2 = map;
                                                        if (n5 >= 2) {
                                                            break;
                                                        }
                                                        map2 = map;
                                                        if (n5 == 1) {
                                                            blackRow.reverse();
                                                            if ((map2 = map) != null) {
                                                                map2 = map;
                                                                if (map.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                                                                    map2 = new EnumMap<DecodeHintType, Object>(DecodeHintType.class);
                                                                    map2.putAll(map);
                                                                    map2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                                                                }
                                                            }
                                                        }
                                                        try {
                                                            final Result decodeRow = this.decodeRow(n4, blackRow, map2);
                                                            if (n5 == 1) {
                                                                decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                                                final ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                                                if (resultPoints != null) {
                                                                    resultPoints[0] = new ResultPoint(width - resultPoints[0].getX() - 1.0f, resultPoints[0].getY());
                                                                    resultPoints[1] = new ResultPoint(width - resultPoints[1].getX() - 1.0f, resultPoints[1].getY());
                                                                }
                                                            }
                                                            return decodeRow;
                                                            n5 = 0;
                                                            continue Label_0100;
                                                            n5 = -n4;
                                                            continue Label_0109;
                                                            n = 15;
                                                            continue Label_0067;
                                                            n2 = 5;
                                                            continue Label_0049;
                                                            n = 0;
                                                        }
                                                        catch (ReaderException map) {
                                                            ++n5;
                                                            map = map2;
                                                        }
                                                    }
                                                }
                                                catch (NotFoundException ex) {
                                                    map2 = map;
                                                    bitArray = blackRow;
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            ++n2;
            blackRow = bitArray;
            map = map2;
            continue;
        }
    }
    
    protected static float patternMatchVariance(final int[] array, final int[] array2, final float n) {
        final int length = array.length;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < length; ++i) {
            n2 += array[i];
            n3 += array2[i];
        }
        if (n2 >= n3) {
            final float n4 = n2 / (float)n3;
            float n5 = 0.0f;
            for (int j = 0; j < length; ++j) {
                final int n6 = array[j];
                final float n7 = array2[j] * n4;
                float n8;
                if (n6 > n7) {
                    n8 = n6 - n7;
                }
                else {
                    n8 = n7 - n6;
                }
                if (n8 > n * n4) {
                    return Float.POSITIVE_INFINITY;
                }
                n5 += n8;
            }
            return n5 / n2;
        }
        return Float.POSITIVE_INFINITY;
    }
    
    protected static void recordPattern(final BitArray bitArray, int n, final int[] a) throws NotFoundException {
        final int length = a.length;
        Arrays.fill(a, 0, length, 0);
        final int size = bitArray.getSize();
        if (n >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean b = !bitArray.get(n);
        final int n2 = 0;
        int n3 = n;
        n = n2;
        int n4;
        while (true) {
            n4 = n;
            if (n3 >= size) {
                break;
            }
            if (bitArray.get(n3) != b) {
                ++a[n];
            }
            else {
                ++n;
                if ((n4 = n) == length) {
                    break;
                }
                a[n] = 1;
                b = !b;
            }
            ++n3;
        }
        if (n4 != length && (n4 != length - 1 || n3 != size)) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
    
    protected static void recordPatternInReverse(final BitArray bitArray, int n, final int[] array) throws NotFoundException {
        int length = array.length;
        int n2;
        for (boolean value = bitArray.get(n); n > 0 && length >= 0; --length, value = !value, n = n2) {
            n2 = --n;
            if (bitArray.get(n2) != value) {}
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, n + 1, array);
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return this.decode(binaryBitmap, null);
    }
    
    @Override
    public Result decode(BinaryBitmap doDecode, Map<DecodeHintType, ?> doDecode2) throws NotFoundException, FormatException {
        try {
            doDecode = this.doDecode((BinaryBitmap)doDecode, (Map<DecodeHintType, ?>)doDecode2);
            return (Result)doDecode;
        }
        catch (NotFoundException ex) {
            boolean b;
            if (doDecode2 != null && ((Map)doDecode2).containsKey(DecodeHintType.TRY_HARDER)) {
                b = true;
            }
            else {
                b = false;
            }
            if (!b || !((BinaryBitmap)doDecode).isRotateSupported()) {
                throw ex;
            }
            final BinaryBitmap rotateCounterClockwise = ((BinaryBitmap)doDecode).rotateCounterClockwise();
            doDecode2 = this.doDecode(rotateCounterClockwise, (Map<DecodeHintType, ?>)doDecode2);
            final Map<ResultMetadataType, Object> resultMetadata = doDecode2.getResultMetadata();
            int i = 270;
            if (resultMetadata != null) {
                i = i;
                if (resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                    i = (resultMetadata.get(ResultMetadataType.ORIENTATION) + 270) % 360;
                }
            }
            doDecode2.putMetadata(ResultMetadataType.ORIENTATION, i);
            final ResultPoint[] resultPoints = doDecode2.getResultPoints();
            doDecode = doDecode2;
            if (resultPoints == null) {
                return (Result)doDecode;
            }
            final int height = rotateCounterClockwise.getHeight();
            int n = 0;
            while (true) {
                doDecode = doDecode2;
                if (n >= resultPoints.length) {
                    return (Result)doDecode;
                }
                resultPoints[n] = new ResultPoint(height - resultPoints[n].getY() - 1.0f, resultPoints[n].getX());
                ++n;
            }
        }
    }
    
    public abstract Result decodeRow(final int p0, final BitArray p1, final Map<DecodeHintType, ?> p2) throws NotFoundException, ChecksumException, FormatException;
    
    @Override
    public void reset() {
    }
}
