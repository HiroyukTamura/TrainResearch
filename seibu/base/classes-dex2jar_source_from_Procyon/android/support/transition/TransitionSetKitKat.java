// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.TransitionSet;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class TransitionSetKitKat extends TransitionKitKat implements TransitionSetImpl
{
    private TransitionSet mTransitionSet;
    
    public TransitionSetKitKat(final TransitionInterface transitionInterface) {
        this.init(transitionInterface, this.mTransitionSet = new TransitionSet());
    }
    
    @Override
    public TransitionSetKitKat addTransition(final TransitionImpl transitionImpl) {
        this.mTransitionSet.addTransition(((TransitionKitKat)transitionImpl).mTransition);
        return this;
    }
    
    @Override
    public int getOrdering() {
        return this.mTransitionSet.getOrdering();
    }
    
    @Override
    public TransitionSetKitKat removeTransition(final TransitionImpl transitionImpl) {
        this.mTransitionSet.removeTransition(((TransitionKitKat)transitionImpl).mTransition);
        return this;
    }
    
    @Override
    public TransitionSetKitKat setOrdering(final int ordering) {
        this.mTransitionSet.setOrdering(ordering);
        return this;
    }
}
