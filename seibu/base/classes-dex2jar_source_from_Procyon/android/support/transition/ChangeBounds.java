// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.Nullable;
import android.animation.Animator;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.os.Build$VERSION;

public class ChangeBounds extends Transition
{
    public ChangeBounds() {
        super(true);
        if (Build$VERSION.SDK_INT < 19) {
            this.mImpl = new ChangeBoundsIcs(this);
            return;
        }
        this.mImpl = new ChangeBoundsKitKat(this);
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
    
    public void setResizeClip(final boolean resizeClip) {
        ((ChangeBoundsInterface)this.mImpl).setResizeClip(resizeClip);
    }
}
