// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view;

import android.view.PointerIcon;
import android.view.View;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(24)
@RequiresApi(24)
class ViewCompatApi24
{
    public static void setPointerIcon(final View view, final Object o) {
        view.setPointerIcon((PointerIcon)o);
    }
}
