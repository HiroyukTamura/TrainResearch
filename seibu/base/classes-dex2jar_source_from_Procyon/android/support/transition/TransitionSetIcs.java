// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionSetIcs extends TransitionIcs implements TransitionSetImpl
{
    private TransitionSetPort mTransitionSet;
    
    public TransitionSetIcs(final TransitionInterface transitionInterface) {
        this.init(transitionInterface, this.mTransitionSet = new TransitionSetPort());
    }
    
    @Override
    public TransitionSetIcs addTransition(final TransitionImpl transitionImpl) {
        this.mTransitionSet.addTransition(((TransitionIcs)transitionImpl).mTransition);
        return this;
    }
    
    @Override
    public int getOrdering() {
        return this.mTransitionSet.getOrdering();
    }
    
    @Override
    public TransitionSetIcs removeTransition(final TransitionImpl transitionImpl) {
        this.mTransitionSet.removeTransition(((TransitionIcs)transitionImpl).mTransition);
        return this;
    }
    
    @Override
    public TransitionSetIcs setOrdering(final int ordering) {
        this.mTransitionSet.setOrdering(ordering);
        return this;
    }
}
