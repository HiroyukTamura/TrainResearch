// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.os;

import android.os.Environment;
import java.io.File;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class EnvironmentCompatKitKat
{
    public static String getStorageState(final File file) {
        return Environment.getStorageState(file);
    }
}
