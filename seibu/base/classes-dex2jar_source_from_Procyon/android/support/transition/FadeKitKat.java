// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;
import android.transition.Fade;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class FadeKitKat extends TransitionKitKat implements VisibilityImpl
{
    public FadeKitKat(final TransitionInterface transitionInterface) {
        this.init(transitionInterface, new Fade());
    }
    
    public FadeKitKat(final TransitionInterface transitionInterface, final int n) {
        this.init(transitionInterface, new Fade(n));
    }
    
    @Override
    public boolean isVisible(final TransitionValues transitionValues) {
        return ((Fade)this.mTransition).isVisible(TransitionKitKat.convertToPlatform(transitionValues));
    }
    
    @Override
    public Animator onAppear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return ((Fade)this.mTransition).onAppear(viewGroup, TransitionKitKat.convertToPlatform(transitionValues), n, TransitionKitKat.convertToPlatform(transitionValues2), n2);
    }
    
    @Override
    public Animator onDisappear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return ((Fade)this.mTransition).onDisappear(viewGroup, TransitionKitKat.convertToPlatform(transitionValues), n, TransitionKitKat.convertToPlatform(transitionValues2), n2);
    }
}
