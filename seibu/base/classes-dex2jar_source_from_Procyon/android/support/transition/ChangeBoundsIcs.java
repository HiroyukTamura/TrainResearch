// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class ChangeBoundsIcs extends TransitionIcs implements ChangeBoundsInterface
{
    public ChangeBoundsIcs(final TransitionInterface transitionInterface) {
        this.init(transitionInterface, new ChangeBoundsPort());
    }
    
    @Override
    public void setResizeClip(final boolean resizeClip) {
        ((ChangeBoundsPort)this.mTransition).setResizeClip(resizeClip);
    }
}
