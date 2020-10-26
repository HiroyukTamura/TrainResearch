// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.Nullable;
import android.animation.Animator;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.os.Build$VERSION;

public class Fade extends Visibility
{
    public static final int IN = 1;
    public static final int OUT = 2;
    
    public Fade() {
        this(-1);
    }
    
    public Fade(final int n) {
        super(true);
        if (Build$VERSION.SDK_INT >= 19) {
            if (n > 0) {
                this.mImpl = new FadeKitKat(this, n);
                return;
            }
            this.mImpl = new FadeKitKat(this);
        }
        else {
            if (n > 0) {
                this.mImpl = new FadeIcs(this, n);
                return;
            }
            this.mImpl = new FadeIcs(this);
        }
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
}
