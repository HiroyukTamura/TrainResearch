// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.view;

import android.view.ViewConfiguration;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class ViewConfigurationCompatICS
{
    static boolean hasPermanentMenuKey(final ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }
}
