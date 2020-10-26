// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(23)
@RequiresApi(23)
class TransitionApi23 extends TransitionKitKat
{
    @Override
    public TransitionImpl removeTarget(final int n) {
        this.mTransition.removeTarget(n);
        return this;
    }
}
