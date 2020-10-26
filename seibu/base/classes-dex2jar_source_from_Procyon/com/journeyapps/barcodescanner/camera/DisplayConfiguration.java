// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import java.util.List;
import com.journeyapps.barcodescanner.Size;

public class DisplayConfiguration
{
    private static final String TAG;
    private boolean center;
    private PreviewScalingStrategy previewScalingStrategy;
    private int rotation;
    private Size viewfinderSize;
    
    static {
        TAG = DisplayConfiguration.class.getSimpleName();
    }
    
    public DisplayConfiguration(final int rotation) {
        this.center = false;
        this.previewScalingStrategy = new FitCenterStrategy();
        this.rotation = rotation;
    }
    
    public DisplayConfiguration(final int rotation, final Size viewfinderSize) {
        this.center = false;
        this.previewScalingStrategy = new FitCenterStrategy();
        this.rotation = rotation;
        this.viewfinderSize = viewfinderSize;
    }
    
    public Size getBestPreviewSize(final List<Size> list, final boolean b) {
        return this.previewScalingStrategy.getBestPreviewSize(list, this.getDesiredPreviewSize(b));
    }
    
    public Size getDesiredPreviewSize(final boolean b) {
        if (this.viewfinderSize == null) {
            return null;
        }
        if (b) {
            return this.viewfinderSize.rotate();
        }
        return this.viewfinderSize;
    }
    
    public PreviewScalingStrategy getPreviewScalingStrategy() {
        return this.previewScalingStrategy;
    }
    
    public int getRotation() {
        return this.rotation;
    }
    
    public Size getViewfinderSize() {
        return this.viewfinderSize;
    }
    
    public Rect scalePreview(final Size size) {
        return this.previewScalingStrategy.scalePreview(size, this.viewfinderSize);
    }
    
    public void setPreviewScalingStrategy(final PreviewScalingStrategy previewScalingStrategy) {
        this.previewScalingStrategy = previewScalingStrategy;
    }
}
