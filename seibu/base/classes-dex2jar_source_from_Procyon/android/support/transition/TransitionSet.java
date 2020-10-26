// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.Nullable;
import android.animation.Animator;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.os.Build$VERSION;

public class TransitionSet extends Transition
{
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    
    public TransitionSet() {
        super(true);
        if (Build$VERSION.SDK_INT < 19) {
            this.mImpl = new TransitionSetIcs(this);
            return;
        }
        this.mImpl = new TransitionSetKitKat(this);
    }
    
    @NonNull
    public TransitionSet addTransition(@NonNull final Transition transition) {
        ((TransitionSetImpl)this.mImpl).addTransition(transition.mImpl);
        return this;
    }
    
    @Override
    public void captureEndValues(@NonNull final TransitionValues transitionValues) {
        this.mImpl.captureEndValues(transitionValues);
    }
    
    @Override
    public void captureStartValues(@NonNull final TransitionValues transitionValues) {
        this.mImpl.captureStartValues(transitionValues);
    }
    
    @Nullable
    @Override
    public Animator createAnimator(@NonNull final ViewGroup viewGroup, @NonNull final TransitionValues transitionValues, @NonNull final TransitionValues transitionValues2) {
        return this.mImpl.createAnimator(viewGroup, transitionValues, transitionValues2);
    }
    
    public int getOrdering() {
        return ((TransitionSetImpl)this.mImpl).getOrdering();
    }
    
    @NonNull
    public TransitionSet removeTransition(@NonNull final Transition transition) {
        ((TransitionSetImpl)this.mImpl).removeTransition(transition.mImpl);
        return this;
    }
    
    @NonNull
    public TransitionSet setOrdering(final int ordering) {
        ((TransitionSetImpl)this.mImpl).setOrdering(ordering);
        return this;
    }
}
