// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.ResultPoint;
import java.util.List;

public interface BarcodeCallback
{
    void barcodeResult(final BarcodeResult p0);
    
    void possibleResultPoints(final List<ResultPoint> p0);
}
