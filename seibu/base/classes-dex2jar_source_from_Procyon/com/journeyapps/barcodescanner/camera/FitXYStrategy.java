// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import com.journeyapps.barcodescanner.Size;

public class FitXYStrategy extends PreviewScalingStrategy
{
    private static final String TAG;
    
    static {
        TAG = FitXYStrategy.class.getSimpleName();
    }
    
    private static float absRatio(final float n) {
        float n2 = n;
        if (n < 1.0f) {
            n2 = 1.0f / n;
        }
        return n2;
    }
    
    @Override
    protected float getScore(final Size size, final Size size2) {
        if (size.width <= 0 || size.height <= 0) {
            return 0.0f;
        }
        final float n = 1.0f / absRatio(size.width * 1.0f / size2.width) / absRatio(size.height * 1.0f / size2.height);
        final float absRatio = absRatio(size.width * 1.0f / size.height / (size2.width * 1.0f / size2.height));
        return n * (1.0f / absRatio / absRatio / absRatio);
    }
    
    @Override
    public Rect scalePreview(final Size size, final Size size2) {
        return new Rect(0, 0, size2.width, size2.height);
    }
}
