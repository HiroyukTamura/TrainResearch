// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class AccessibilityEventCompatKitKat
{
    public static int getContentChangeTypes(final AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
    
    public static void setContentChangeTypes(final AccessibilityEvent accessibilityEvent, final int contentChangeTypes) {
        accessibilityEvent.setContentChangeTypes(contentChangeTypes);
    }
}
