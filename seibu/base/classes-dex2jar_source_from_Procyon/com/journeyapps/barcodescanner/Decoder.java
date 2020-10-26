// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.Binarizer;
import com.google.zxing.common.HybridBinarizer;
import java.util.Collection;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;
import java.util.ArrayList;
import com.google.zxing.Reader;
import com.google.zxing.ResultPoint;
import java.util.List;
import com.google.zxing.ResultPointCallback;

public class Decoder implements ResultPointCallback
{
    private List<ResultPoint> possibleResultPoints;
    private Reader reader;
    
    public Decoder(final Reader reader) {
        this.possibleResultPoints = new ArrayList<ResultPoint>();
        this.reader = reader;
    }
    
    protected Result decode(final BinaryBitmap binaryBitmap) {
        this.possibleResultPoints.clear();
        try {
            if (this.reader instanceof MultiFormatReader) {
                return ((MultiFormatReader)this.reader).decodeWithState(binaryBitmap);
            }
            return this.reader.decode(binaryBitmap);
        }
        catch (Exception ex) {
            return null;
        }
        finally {
            this.reader.reset();
        }
    }
    
    public Result decode(final LuminanceSource luminanceSource) {
        return this.decode(this.toBitmap(luminanceSource));
    }
    
    @Override
    public void foundPossibleResultPoint(final ResultPoint resultPoint) {
        this.possibleResultPoints.add(resultPoint);
    }
    
    public List<ResultPoint> getPossibleResultPoints() {
        return new ArrayList<ResultPoint>(this.possibleResultPoints);
    }
    
    protected Reader getReader() {
        return this.reader;
    }
    
    protected BinaryBitmap toBitmap(final LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }
}
