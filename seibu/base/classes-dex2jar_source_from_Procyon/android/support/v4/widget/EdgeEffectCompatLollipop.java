// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.widget;

import android.widget.EdgeEffect;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(21)
@RequiresApi(21)
class EdgeEffectCompatLollipop
{
    public static boolean onPull(final Object o, final float n, final float n2) {
        ((EdgeEffect)o).onPull(n, n2);
        return true;
    }
}
