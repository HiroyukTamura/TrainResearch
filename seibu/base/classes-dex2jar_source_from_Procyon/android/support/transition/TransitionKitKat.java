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
import android.transition.Transition$TransitionListener;
import java.util.Map;
import android.transition.Transition;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class TransitionKitKat extends TransitionImpl
{
    private CompatListener mCompatListener;
    TransitionInterface mExternalTransition;
    Transition mTransition;
    
    static android.transition.TransitionValues convertToPlatform(final TransitionValues transitionValues) {
        if (transitionValues == null) {
            return null;
        }
        final android.transition.TransitionValues transitionValues2 = new android.transition.TransitionValues();
        copyValues(transitionValues, transitionValues2);
        return transitionValues2;
    }
    
    static TransitionValues convertToSupport(final android.transition.TransitionValues transitionValues) {
        if (transitionValues == null) {
            return null;
        }
        final TransitionValues transitionValues2 = new TransitionValues();
        copyValues(transitionValues, transitionValues2);
        return transitionValues2;
    }
    
    static void copyValues(final TransitionValues transitionValues, final android.transition.TransitionValues transitionValues2) {
        if (transitionValues != null) {
            transitionValues2.view = transitionValues.view;
            if (transitionValues.values.size() > 0) {
                transitionValues2.values.putAll(transitionValues.values);
            }
        }
    }
    
    static void copyValues(final android.transition.TransitionValues transitionValues, final TransitionValues transitionValues2) {
        if (transitionValues != null) {
            transitionValues2.view = transitionValues.view;
            if (transitionValues.values.size() > 0) {
                transitionValues2.values.putAll(transitionValues.values);
            }
        }
    }
    
    static void wrapCaptureEndValues(final TransitionInterface transitionInterface, final android.transition.TransitionValues transitionValues) {
        final TransitionValues transitionValues2 = new TransitionValues();
        copyValues(transitionValues, transitionValues2);
        transitionInterface.captureEndValues(transitionValues2);
        copyValues(transitionValues2, transitionValues);
    }
    
    static void wrapCaptureStartValues(final TransitionInterface transitionInterface, final android.transition.TransitionValues transitionValues) {
        final TransitionValues transitionValues2 = new TransitionValues();
        copyValues(transitionValues, transitionValues2);
        transitionInterface.captureStartValues(transitionValues2);
        copyValues(transitionValues2, transitionValues);
    }
    
    @Override
    public TransitionImpl addListener(final TransitionInterfaceListener transitionInterfaceListener) {
        if (this.mCompatListener == null) {
            this.mCompatListener = new CompatListener();
            this.mTransition.addListener((Transition$TransitionListener)this.mCompatListener);
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
        final android.transition.TransitionValues transitionValues2 = new android.transition.TransitionValues();
        copyValues(transitionValues, transitionValues2);
        this.mTransition.captureEndValues(transitionValues2);
        copyValues(transitionValues2, transitionValues);
    }
    
    @Override
    public void captureStartValues(final TransitionValues transitionValues) {
        final android.transition.TransitionValues transitionValues2 = new android.transition.TransitionValues();
        copyValues(transitionValues, transitionValues2);
        this.mTransition.captureStartValues(transitionValues2);
        copyValues(transitionValues2, transitionValues);
    }
    
    @Override
    public Animator createAnimator(final ViewGroup viewGroup, final TransitionValues transitionValues, final TransitionValues transitionValues2) {
        android.transition.TransitionValues transitionValues4;
        if (transitionValues != null) {
            final android.transition.TransitionValues transitionValues3 = new android.transition.TransitionValues();
            copyValues(transitionValues, transitionValues3);
            transitionValues4 = transitionValues3;
        }
        else {
            transitionValues4 = null;
        }
        android.transition.TransitionValues transitionValues6;
        if (transitionValues2 != null) {
            final android.transition.TransitionValues transitionValues5 = new android.transition.TransitionValues();
            copyValues(transitionValues2, transitionValues5);
            transitionValues6 = transitionValues5;
        }
        else {
            transitionValues6 = null;
        }
        return this.mTransition.createAnimator(viewGroup, transitionValues4, transitionValues6);
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
        return (List<Integer>)this.mTransition.getTargetIds();
    }
    
    @Override
    public List<View> getTargets() {
        return (List<View>)this.mTransition.getTargets();
    }
    
    @Override
    public String[] getTransitionProperties() {
        return this.mTransition.getTransitionProperties();
    }
    
    @Override
    public TransitionValues getTransitionValues(final View view, final boolean b) {
        final TransitionValues transitionValues = new TransitionValues();
        copyValues(this.mTransition.getTransitionValues(view, b), transitionValues);
        return transitionValues;
    }
    
    @Override
    public void init(final TransitionInterface mExternalTransition, final Object o) {
        this.mExternalTransition = mExternalTransition;
        if (o == null) {
            this.mTransition = new TransitionWrapper(mExternalTransition);
            return;
        }
        this.mTransition = (Transition)o;
    }
    
    @Override
    public TransitionImpl removeListener(final TransitionInterfaceListener transitionInterfaceListener) {
        if (this.mCompatListener != null) {
            this.mCompatListener.removeListener(transitionInterfaceListener);
            if (this.mCompatListener.isEmpty()) {
                this.mTransition.removeListener((Transition$TransitionListener)this.mCompatListener);
                this.mCompatListener = null;
                return this;
            }
        }
        return this;
    }
    
    @Override
    public TransitionImpl removeTarget(final int i) {
        if (i > 0) {
            this.getTargetIds().remove((Object)i);
        }
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
    
    private class CompatListener implements Transition$TransitionListener
    {
        private final ArrayList<TransitionInterfaceListener> mListeners;
        
        CompatListener() {
            this.mListeners = new ArrayList<TransitionInterfaceListener>();
        }
        
        void addListener(final TransitionInterfaceListener e) {
            this.mListeners.add(e);
        }
        
        boolean isEmpty() {
            return this.mListeners.isEmpty();
        }
        
        public void onTransitionCancel(final Transition transition) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionCancel(TransitionKitKat.this.mExternalTransition);
            }
        }
        
        public void onTransitionEnd(final Transition transition) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionEnd(TransitionKitKat.this.mExternalTransition);
            }
        }
        
        public void onTransitionPause(final Transition transition) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionPause(TransitionKitKat.this.mExternalTransition);
            }
        }
        
        public void onTransitionResume(final Transition transition) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionResume(TransitionKitKat.this.mExternalTransition);
            }
        }
        
        public void onTransitionStart(final Transition transition) {
            final Iterator<TransitionInterfaceListener<TransitionInterface>> iterator = this.mListeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().onTransitionStart(TransitionKitKat.this.mExternalTransition);
            }
        }
        
        void removeListener(final TransitionInterfaceListener o) {
            this.mListeners.remove(o);
        }
    }
    
    private static class TransitionWrapper extends Transition
    {
        private TransitionInterface mTransition;
        
        public TransitionWrapper(final TransitionInterface mTransition) {
            this.mTransition = mTransition;
        }
        
        public void captureEndValues(final android.transition.TransitionValues transitionValues) {
            TransitionKitKat.wrapCaptureEndValues(this.mTransition, transitionValues);
        }
        
        public void captureStartValues(final android.transition.TransitionValues transitionValues) {
            TransitionKitKat.wrapCaptureStartValues(this.mTransition, transitionValues);
        }
        
        public Animator createAnimator(final ViewGroup viewGroup, final android.transition.TransitionValues transitionValues, final android.transition.TransitionValues transitionValues2) {
            return this.mTransition.createAnimator(viewGroup, TransitionKitKat.convertToSupport(transitionValues), TransitionKitKat.convertToSupport(transitionValues2));
        }
    }
}
