// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.animation.TimeInterpolator;
import android.animation.Animator;
import android.view.ViewGroup;
import android.view.View;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionIcs extends TransitionImpl
{
    private CompatListener mCompatListener;
    TransitionInterface mExternalTransition;
    TransitionPort mTransition;
    
    @Override
    public TransitionImpl addListener(final TransitionInterfaceListener transitionInterfaceListener) {
        if (this.mCompatListener == null) {
            this.mCompatListener = new CompatListener();
            this.mTransition.addListener((TransitionPort.TransitionListener)this.mCompatListener);
        }
        this.mCompatListener.addListener(transitionInterfaceListener);
        return this;
    }
    
    @Override
    public TransitionImpl addTarget(final int n) {
        this.mTransition.addTarget(n);
        return this;
    }
    
    @Override
    public TransitionImpl addTarget(final View view) {
        this.mTransition.addTarget(view);
        return this;
    }
    
    @Override
    public void captureEndValues(final TransitionValues transitionValues) {
        this.mTransition.captureEndValues(transitionValues);
    }
    
    @Override
    public void captureStartValues(final TransitionValues transitionValues) {
        this.mTransition.captureStartValues(transitionValues);
    }
    
    @Override
    public Animator createAnimator(final ViewGroup viewGroup, final TransitionValues transitionValues, final TransitionValues transitionValues2) {
        return this.mTransition.createAnimator(viewGroup, transitionValues, transitionValues2);
    }
    
    @Override
    public TransitionImpl excludeChildren(final int n, final boolean b) {
        this.mTransition.excludeChildren(n, b);
        return this;
    }
    
    @Override
    public TransitionImpl excludeChildren(final View view, final boolean b) {
        this.mTransition.excludeChildren(view, b);
        return this;
    }
    
    @Override
    public TransitionImpl excludeChildren(final Class clazz, final boolean b) {
        this.mTransition.excludeChildren(clazz, b);
        return this;
    }
    
    @Override
    public TransitionImpl excludeTarget(final int n, final boolean b) {
        this.mTransition.excludeTarget(n, b);
        return this;
    }
    
    @Override
    public TransitionImpl excludeTarget(final View view, final boolean b) {
        this.mTransition.excludeTarget(view, b);
        return this;
    }
    
    @Override
    public TransitionImpl excludeTarget(final Class clazz, final boolean b) {
        this.mTransition.excludeTarget(clazz, b);
        return this;
    }
    
    @Override
    public long getDuration() {
        return this.mTransition.getDuration();
    }
    
    @Override
    public TimeInterpolator getInterpolator() {
        return this.mTransition.getInterpolator();
    }
    
    @Override
    public String getName() {
        return this.mTransition.getName();
    }
    
    @Override
    public long getStartDelay() {
        return this.mTransition.getStartDelay();
    }
    
    @Override
    public List<Integer> getTargetIds() {
        return this.mTransition.getTargetIds();
    }
    
    @Override
    public List<View> getTargets() {
        return this.mTransition.getTargets();
    }
    
    @Override
    public String[] getTransitionProperties() {
        return this.mTransition.getTransitionProperties();
    }
    
    @Override
    public TransitionValues getTransitionValues(final View view, final boolean b) {
        return this.mTransition.getTransitionValues(view, b);
    }
    
    @Override
    public void init(final TransitionInterface mExternalTransition, final Object o) {
        this.mExternalTransition = mExternalTransition;
        if (o == null) {
            this.mTransition = new TransitionWrapper(mExternalTransition);
            return;
        }
        this.mTransition = (TransitionPort)o;
    }
    
    @Override
    public TransitionImpl removeListener(final TransitionInterfaceListener transitionInterfaceListener) {
        if (this.mCompatListener != null) {
            this.mCompatListener.removeListener(transitionInterfaceListener);
            if (this.mCompatListener.isEmpty()) {
                this.mTransition.removeListener((TransitionPort.TransitionListener)this.mCompatListener);
                this.mCompatListener = null;
                return this;
            }
        }
        return this;
    }
    
    @Override
    public TransitionImpl removeTarget(final int n) {
        this.mTransition.removeTarget(n);
        return this;
    }
    
    @Override
    public TransitionImpl removeTarget(final View view) {
        this.mTransition.removeTarget(view);
        return this;
    }
    
    @Override
    public TransitionImpl setDuration(final long duration) {
        this.mTransition.setDuration(duration);
        return this;
    }
    
    @Override
    public TransitionImpl setInterpolator(final TimeInterpolator interpolator) {
        this.mTransition.setInterpolator(interpolator);
        return this;
    }
    
    @Override
    public TransitionImpl setStartDelay(final long startDelay) {
        this.mTransition.setStartDelay(startDelay);
        return this;
    }
    
    @Override
    public String toString() {
        return this.mTransition.toString();
    }
    
    private class CompatListener implements TransitionListener
    {
        private final ArrayList<TransitionInterfaceListener> mListeners;
        
        CompatListener() {
            this.mListeners = new ArrayList<TransitionInterfaceListener>();
        }
        
        public void addListener(final TransitionInterfaceListener e) {
            this.mListeners.add(e);
        }
        
        public boolean isEmpty() {
            return this.mListeners.isEmpty();
        }
        
        @Override
        public void onTransitionCancel(final TransitionPort transitionPort) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionCancel(TransitionIcs.this.mExternalTransition);
            }
        }
        
        @Override
        public void onTransitionEnd(final TransitionPort transitionPort) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionEnd(TransitionIcs.this.mExternalTransition);
            }
        }
        
        @Override
        public void onTransitionPause(final TransitionPort transitionPort) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionPause(TransitionIcs.this.mExternalTransition);
            }
        }
        
        @Override
        public void onTransitionResume(final TransitionPort transitionPort) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionResume(TransitionIcs.this.mExternalTransition);
            }
        }
        
        @Override
        public void onTransitionStart(final TransitionPort transitionPort) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionStart(TransitionIcs.this.mExternalTransition);
            }
        }
        
        public void removeListener(final TransitionInterfaceListener o) {
            this.mListeners.remove(o);
        }
    }
    
    private static class TransitionWrapper extends TransitionPort
    {
        private TransitionInterface mTransition;
        
        public TransitionWrapper(final TransitionInterface mTransition) {
            this.mTransition = mTransition;
        }
        
        @Override
        public void captureEndValues(final TransitionValues transitionValues) {
            this.mTransition.captureEndValues(transitionValues);
        }
        
        @Override
        public void captureStartValues(final TransitionValues transitionValues) {
            this.mTransition.captureStartValues(transitionValues);
        }
        
        @Override
        public Animator createAnimator(final ViewGroup viewGroup, final TransitionValues transitionValues, final TransitionValues transitionValues2) {
            return this.mTransition.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
    }
}
