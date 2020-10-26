// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.content;

import android.content.Intent;
import java.io.File;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(11)
@RequiresApi(11)
class ContextCompatHoneycomb
{
    public static File getObbDir(final Context context) {
        return context.getObbDir();
    }
    
    static void startActivities(final Context context, final Intent[] array) {
        context.startActivities(array);
    }
}
