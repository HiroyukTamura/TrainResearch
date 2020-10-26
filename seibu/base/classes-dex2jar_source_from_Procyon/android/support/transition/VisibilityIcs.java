// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class VisibilityIcs extends TransitionIcs implements VisibilityImpl
{
    @Override
    public void init(final TransitionInterface mExternalTransition, final Object o) {
        this.mExternalTransition = mExternalTransition;
        if (o == null) {
            this.mTransition = new VisibilityWrapper((VisibilityInterface)mExternalTransition);
            return;
        }
        this.mTransition = (VisibilityPort)o;
    }
    
    @Override
    public boolean isVisible(final TransitionValues transitionValues) {
        return ((VisibilityPort)this.mTransition).isVisible(transitionValues);
    }
    
    @Override
    public Animator onAppear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return ((VisibilityPort)this.mTransition).onAppear(viewGroup, transitionValues, n, transitionValues2, n2);
    }
    
    @Override
    public Animator onDisappear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return ((VisibilityPort)this.mTransition).onDisappear(viewGroup, transitionValues, n, transitionValues2, n2);
    }
    
    private static class VisibilityWrapper extends VisibilityPort
    {
        private VisibilityInterface mVisibility;
        
        VisibilityWrapper(final VisibilityInterface mVisibility) {
            this.mVisibility = mVisibility;
        }
        
        @Override
        public void captureEndValues(final TransitionValues transitionValues) {
            this.mVisibility.captureEndValues(transitionValues);
        }
        
        @Override
        public void captureStartValues(final TransitionValues transitionValues) {
            this.mVisibility.captureStartValues(transitionValues);
        }
        
        @Override
        public Animator createAnimator(final ViewGroup viewGroup, final TransitionValues transitionValues, final TransitionValues transitionValues2) {
            return this.mVisibility.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
        
        @Override
        public boolean isVisible(final TransitionValues transitionValues) {
            return this.mVisibility.isVisible(transitionValues);
        }
        
        @Override
        public Animator onAppear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
            return this.mVisibility.onAppear(viewGroup, transitionValues, n, transitionValues2, n2);
        }
        
        @Override
        public Animator onDisappear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
            return this.mVisibility.onDisappear(viewGroup, transitionValues, n, transitionValues2, n2);
        }
    }
}
