// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view;

import android.view.ScaleGestureDetector;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class ScaleGestureDetectorCompatKitKat
{
    private ScaleGestureDetectorCompatKitKat() {
    }
    
    public static boolean isQuickScaleEnabled(final Object o) {
        return ((ScaleGestureDetector)o).isQuickScaleEnabled();
    }
    
    public static void setQuickScaleEnabled(final Object o, final boolean quickScaleEnabled) {
        ((ScaleGestureDetector)o).setQuickScaleEnabled(quickScaleEnabled);
    }
}
