// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import com.journeyapps.barcodescanner.Size;
import java.util.List;

public abstract class PreviewScalingStrategy
{
    private static final String TAG;
    
    static {
        TAG = PreviewScalingStrategy.class.getSimpleName();
    }
    
    public List<Size> getBestPreviewOrder(final List<Size> list, final Size size) {
        if (size == null) {
            return list;
        }
        Collections.sort((List<Object>)list, (Comparator<? super Object>)new Comparator<Size>() {
            @Override
            public int compare(final Size size, final Size size2) {
                return Float.compare(PreviewScalingStrategy.this.getScore(size2, size), PreviewScalingStrategy.this.getScore(size, size));
            }
        });
        return list;
    }
    
    public Size getBestPreviewSize(final List<Size> list, final Size obj) {
        final List<Size> bestPreviewOrder = this.getBestPreviewOrder(list, obj);
        Log.i(PreviewScalingStrategy.TAG, "Viewfinder size: " + obj);
        Log.i(PreviewScalingStrategy.TAG, "Preview in order of preference: " + bestPreviewOrder);
        return bestPreviewOrder.get(0);
    }
    
    protected float getScore(final Size size, final Size size2) {
        return 0.5f;
    }
    
    public abstract Rect scalePreview(final Size p0, final Size p1);
}
