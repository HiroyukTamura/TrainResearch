// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view;

import android.view.View;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class ViewCompatKitKat
{
    public static int getAccessibilityLiveRegion(final View view) {
        return view.getAccessibilityLiveRegion();
    }
    
    public static boolean isAttachedToWindow(final View view) {
        return view.isAttachedToWindow();
    }
    
    public static boolean isLaidOut(final View view) {
        return view.isLaidOut();
    }
    
    public static boolean isLayoutDirectionResolved(final View view) {
        return view.isLayoutDirectionResolved();
    }
    
    public static void setAccessibilityLiveRegion(final View view, final int accessibilityLiveRegion) {
        view.setAccessibilityLiveRegion(accessibilityLiveRegion);
    }
}
