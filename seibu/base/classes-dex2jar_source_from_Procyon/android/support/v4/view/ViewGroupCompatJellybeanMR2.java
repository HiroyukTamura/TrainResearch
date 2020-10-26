// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(18)
@RequiresApi(18)
class ViewGroupCompatJellybeanMR2
{
    public static int getLayoutMode(final ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }
    
    public static void setLayoutMode(final ViewGroup viewGroup, final int layoutMode) {
        viewGroup.setLayoutMode(layoutMode);
    }
}
