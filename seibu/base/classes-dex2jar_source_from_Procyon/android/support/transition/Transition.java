// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import java.util.List;
import android.animation.TimeInterpolator;
import android.animation.Animator;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.View;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.os.Build$VERSION;

public abstract class Transition implements TransitionInterface
{
    TransitionImpl mImpl;
    
    public Transition() {
        this(false);
    }
    
    Transition(final boolean b) {
        if (!b) {
            if (Build$VERSION.SDK_INT >= 23) {
                this.mImpl = new TransitionApi23();
            }
            else if (Build$VERSION.SDK_INT >= 19) {
                this.mImpl = new TransitionKitKat();
            }
            else {
                this.mImpl = new TransitionIcs();
            }
            this.mImpl.init(this);
        }
    }
    
    @NonNull
    public Transition addListener(@NonNull final TransitionListener transitionListener) {
        this.mImpl.addListener(transitionListener);
        return this;
    }
    
    @NonNull
    public Transition addTarget(@IdRes final int n) {
        this.mImpl.addTarget(n);
        return this;
    }
    
    @NonNull
    public Transition addTarget(@NonNull final View view) {
        this.mImpl.addTarget(view);
        return this;
    }
    
    @Override
    public abstract void captureEndValues(@NonNull final TransitionValues p0);
    
    @Override
    public abstract void captureStartValues(@NonNull final TransitionValues p0);
    
    @Nullable
    @Override
    public Animator createAnimator(@NonNull final ViewGroup viewGroup, @Nullable final TransitionValues transitionValues, @Nullable final TransitionValues transitionValues2) {
        return null;
    }
    
    @NonNull
    public Transition excludeChildren(@IdRes final int n, final boolean b) {
        this.mImpl.excludeChildren(n, b);
        return this;
    }
    
    @NonNull
    public Transition excludeChildren(@NonNull final View view, final boolean b) {
        this.mImpl.excludeChildren(view, b);
        return this;
    }
    
    @NonNull
    public Transition excludeChildren(@NonNull final Class clazz, final boolean b) {
        this.mImpl.excludeChildren(clazz, b);
        return this;
    }
    
    @NonNull
    public Transition excludeTarget(@IdRes final int n, final boolean b) {
        this.mImpl.excludeTarget(n, b);
        return this;
    }
    
    @NonNull
    public Transition excludeTarget(@NonNull final View view, final boolean b) {
        this.mImpl.excludeTarget(view, b);
        return this;
    }
    
    @NonNull
    public Transition excludeTarget(@NonNull final Class clazz, final boolean b) {
        this.mImpl.excludeTarget(clazz, b);
        return this;
    }
    
    public long getDuration() {
        return this.mImpl.getDuration();
    }
    
    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }
    
    @NonNull
    public String getName() {
        return this.mImpl.getName();
    }
    
    public long getStartDelay() {
        return this.mImpl.getStartDelay();
    }
    
    @NonNull
    public List<Integer> getTargetIds() {
        return this.mImpl.getTargetIds();
    }
    
    @NonNull
    public List<View> getTargets() {
        return this.mImpl.getTargets();
    }
    
    @Nullable
    public String[] getTransitionProperties() {
        return this.mImpl.getTransitionProperties();
    }
    
    @NonNull
    public TransitionValues getTransitionValues(@NonNull final View view, final boolean b) {
        return this.mImpl.getTransitionValues(view, b);
    }
    
    @NonNull
    public Transition removeListener(@NonNull final TransitionListener transitionListener) {
        this.mImpl.removeListener(transitionListener);
        return this;
    }
    
    @NonNull
    public Transition removeTarget(@IdRes final int n) {
        this.mImpl.removeTarget(n);
        return this;
    }
    
    @NonNull
    public Transition removeTarget(@NonNull final View view) {
        this.mImpl.removeTarget(view);
        return this;
    }
    
    @NonNull
    public Transition setDuration(final long duration) {
        this.mImpl.setDuration(duration);
        return this;
    }
    
    @NonNull
    public Transition setInterpolator(@Nullable final TimeInterpolator interpolator) {
        this.mImpl.setInterpolator(interpolator);
        return this;
    }
    
    @NonNull
    public Transition setStartDelay(final long startDelay) {
        this.mImpl.setStartDelay(startDelay);
        return this;
    }
    
    @Override
    public String toString() {
        return this.mImpl.toString();
    }
    
    public interface TransitionListener extends TransitionInterfaceListener<Transition>
    {
        void onTransitionCancel(@NonNull final Transition p0);
        
        void onTransitionEnd(@NonNull final Transition p0);
        
        void onTransitionPause(@NonNull final Transition p0);
        
        void onTransitionResume(@NonNull final Transition p0);
        
        void onTransitionStart(@NonNull final Transition p0);
    }
}
