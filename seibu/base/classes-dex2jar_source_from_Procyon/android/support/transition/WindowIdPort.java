// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.NonNull;
import android.view.View;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class WindowIdPort
{
    private final IBinder mToken;
    
    private WindowIdPort(final IBinder mToken) {
        this.mToken = mToken;
    }
    
    static WindowIdPort getWindowId(@NonNull final View view) {
        return new WindowIdPort(view.getWindowToken());
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof WindowIdPort && ((WindowIdPort)o).mToken.equals(this.mToken);
    }
}
