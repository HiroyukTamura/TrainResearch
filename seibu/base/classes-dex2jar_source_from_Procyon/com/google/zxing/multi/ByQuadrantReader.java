// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.multi;

import com.google.zxing.FormatException;
import com.google.zxing.ChecksumException;
import com.google.zxing.NotFoundException;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ResultPoint;
import com.google.zxing.Reader;

public final class ByQuadrantReader implements Reader
{
    private final Reader delegate;
    
    public ByQuadrantReader(final Reader delegate) {
        this.delegate = delegate;
    }
    
    private static void makeAbsolute(final ResultPoint[] array, final int n, final int n2) {
        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                final ResultPoint resultPoint = array[i];
                array[i] = new ResultPoint(resultPoint.getX() + n, resultPoint.getY() + n2);
            }
        }
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return this.decode(binaryBitmap, null);
    }
    
    @Override
    public Result decode(BinaryBitmap crop, final Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        final int width = crop.getWidth();
        final int height = crop.getHeight();
        final int n = width / 2;
        final int n2 = height / 2;
        try {
            return this.delegate.decode(crop.crop(0, 0, n, n2), map);
        }
        catch (NotFoundException ex) {
            try {
                final Result decode = this.delegate.decode(crop.crop(n, 0, n, n2), map);
                makeAbsolute(decode.getResultPoints(), n, 0);
                return decode;
            }
            catch (NotFoundException ex2) {
                try {
                    final Result decode2 = this.delegate.decode(crop.crop(0, n2, n, n2), map);
                    makeAbsolute(decode2.getResultPoints(), 0, n2);
                    return decode2;
                }
                catch (NotFoundException ex3) {
                    try {
                        final Result decode3 = this.delegate.decode(crop.crop(n, n2, n, n2), map);
                        makeAbsolute(decode3.getResultPoints(), n, n2);
                        return decode3;
                    }
                    catch (NotFoundException ex4) {
                        final int n3 = n / 2;
                        final int n4 = n2 / 2;
                        crop = crop.crop(n3, n4, n, n2);
                        final Result decode4 = this.delegate.decode(crop, map);
                        makeAbsolute(decode4.getResultPoints(), n3, n4);
                        return decode4;
                    }
                }
            }
        }
    }
    
    @Override
    public void reset() {
        this.delegate.reset();
    }
}
