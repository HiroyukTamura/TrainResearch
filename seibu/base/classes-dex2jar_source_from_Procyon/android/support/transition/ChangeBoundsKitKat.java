// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.ChangeBounds;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class ChangeBoundsKitKat extends TransitionKitKat implements ChangeBoundsInterface
{
    public ChangeBoundsKitKat(final TransitionInterface transitionInterface) {
        this.init(transitionInterface, new ChangeBounds());
    }
    
    @Override
    public void setResizeClip(final boolean resizeClip) {
        ((ChangeBounds)this.mTransition).setResizeClip(resizeClip);
    }
}
