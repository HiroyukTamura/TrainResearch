// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.Transition;
import android.animation.Animator;
import android.view.ViewGroup;
import android.transition.Visibility;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class VisibilityKitKat extends TransitionKitKat implements VisibilityImpl
{
    @Override
    public void init(final TransitionInterface mExternalTransition, final Object o) {
        this.mExternalTransition = mExternalTransition;
        if (o == null) {
            this.mTransition = (Transition)new VisibilityWrapper((VisibilityInterface)mExternalTransition);
            return;
        }
        this.mTransition = (Transition)o;
    }
    
    @Override
    public boolean isVisible(final TransitionValues transitionValues) {
        return ((Visibility)this.mTransition).isVisible(TransitionKitKat.convertToPlatform(transitionValues));
    }
    
    @Override
    public Animator onAppear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return ((Visibility)this.mTransition).onAppear(viewGroup, TransitionKitKat.convertToPlatform(transitionValues), n, TransitionKitKat.convertToPlatform(transitionValues2), n2);
    }
    
    @Override
    public Animator onDisappear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return ((Visibility)this.mTransition).onDisappear(viewGroup, TransitionKitKat.convertToPlatform(transitionValues), n, TransitionKitKat.convertToPlatform(transitionValues2), n2);
    }
    
    private static class VisibilityWrapper extends Visibility
    {
        private final VisibilityInterface mVisibility;
        
        VisibilityWrapper(final VisibilityInterface mVisibility) {
            this.mVisibility = mVisibility;
        }
        
        public void captureEndValues(final android.transition.TransitionValues transitionValues) {
            TransitionKitKat.wrapCaptureEndValues(this.mVisibility, transitionValues);
        }
        
        public void captureStartValues(final android.transition.TransitionValues transitionValues) {
            TransitionKitKat.wrapCaptureStartValues(this.mVisibility, transitionValues);
        }
        
        public Animator createAnimator(final ViewGroup viewGroup, final android.transition.TransitionValues transitionValues, final android.transition.TransitionValues transitionValues2) {
            return this.mVisibility.createAnimator(viewGroup, TransitionKitKat.convertToSupport(transitionValues), TransitionKitKat.convertToSupport(transitionValues2));
        }
        
        public boolean isVisible(final android.transition.TransitionValues transitionValues) {
            if (transitionValues == null) {
                return false;
            }
            final TransitionValues transitionValues2 = new TransitionValues();
            TransitionKitKat.copyValues(transitionValues, transitionValues2);
            return this.mVisibility.isVisible(transitionValues2);
        }
        
        public Animator onAppear(final ViewGroup viewGroup, final android.transition.TransitionValues transitionValues, final int n, final android.transition.TransitionValues transitionValues2, final int n2) {
            return this.mVisibility.onAppear(viewGroup, TransitionKitKat.convertToSupport(transitionValues), n, TransitionKitKat.convertToSupport(transitionValues2), n2);
        }
        
        public Animator onDisappear(final ViewGroup viewGroup, final android.transition.TransitionValues transitionValues, final int n, final android.transition.TransitionValues transitionValues2, final int n2) {
            return this.mVisibility.onDisappear(viewGroup, TransitionKitKat.convertToSupport(transitionValues), n, TransitionKitKat.convertToSupport(transitionValues2), n2);
        }
    }
}
