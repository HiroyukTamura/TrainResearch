// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.util.Log;
import android.graphics.Rect;
import com.journeyapps.barcodescanner.Size;

public class CenterCropStrategy extends PreviewScalingStrategy
{
    private static final String TAG;
    
    static {
        TAG = CenterCropStrategy.class.getSimpleName();
    }
    
    @Override
    protected float getScore(final Size size, final Size size2) {
        if (size.width <= 0 || size.height <= 0) {
            return 0.0f;
        }
        final Size scaleCrop = size.scaleCrop(size2);
        float n = scaleCrop.width * 1.0f / size.width;
        if (n > 1.0f) {
            n = (float)Math.pow(1.0f / n, 1.1);
        }
        final float n2 = scaleCrop.width * 1.0f / size2.width + scaleCrop.height * 1.0f / size2.height;
        return n * (1.0f / n2 / n2);
    }
    
    @Override
    public Rect scalePreview(final Size obj, final Size obj2) {
        final Size scaleCrop = obj.scaleCrop(obj2);
        Log.i(CenterCropStrategy.TAG, "Preview: " + obj + "; Scaled: " + scaleCrop + "; Want: " + obj2);
        final int n = (scaleCrop.width - obj2.width) / 2;
        final int n2 = (scaleCrop.height - obj2.height) / 2;
        return new Rect(-n, -n2, scaleCrop.width - n, scaleCrop.height - n2);
    }
}
