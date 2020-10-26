// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.content;

import android.content.Intent;
import android.content.ComponentName;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(11)
@RequiresApi(11)
class IntentCompatHoneycomb
{
    public static Intent makeMainActivity(final ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }
    
    public static Intent makeRestartActivityTask(final ComponentName componentName) {
        return Intent.makeRestartActivityTask(componentName);
    }
}
