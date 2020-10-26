// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityWindowInfo;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(24)
@RequiresApi(24)
class AccessibilityWindowInfoCompatApi24
{
    public static Object getAnchor(final Object o) {
        return ((AccessibilityWindowInfo)o).getAnchor();
    }
    
    public static CharSequence getTitle(final Object o) {
        return ((AccessibilityWindowInfo)o).getTitle();
    }
}
