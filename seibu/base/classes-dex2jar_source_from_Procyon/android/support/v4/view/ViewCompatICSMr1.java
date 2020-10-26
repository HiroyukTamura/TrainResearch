// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view;

import android.view.View;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(15)
@RequiresApi(15)
class ViewCompatICSMr1
{
    public static boolean hasOnClickListeners(final View view) {
        return view.hasOnClickListeners();
    }
}
