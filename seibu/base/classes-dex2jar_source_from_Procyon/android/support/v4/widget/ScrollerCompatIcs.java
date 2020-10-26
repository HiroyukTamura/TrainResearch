// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.widget;

import android.widget.OverScroller;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class ScrollerCompatIcs
{
    public static float getCurrVelocity(final Object o) {
        return ((OverScroller)o).getCurrVelocity();
    }
}
