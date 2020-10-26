// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.util.AndroidRuntimeException;
import android.animation.TimeInterpolator;
import android.view.ViewGroup;
import android.support.annotation.RestrictTo;
import android.view.View;
import java.util.Iterator;
import java.util.ArrayList;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionSetPort extends TransitionPort
{
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    ArrayList<TransitionPort> mTransitions;
    
    public TransitionSetPort() {
        this.mTransitions = new ArrayList<TransitionPort>();
        this.mStarted = false;
        this.mPlayTogether = true;
    }
    
    private void setupStartEndListeners() {
        final TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        final Iterator<TransitionPort> iterator = this.mTransitions.iterator();
        while (iterator.hasNext()) {
            iterator.next().addListener((TransitionListener)transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }
    
    @Override
    public TransitionSetPort addListener(final TransitionListener transitionListener) {
        return (TransitionSetPort)super.addListener(transitionListener);
    }
    
    @Override
    public TransitionSetPort addTarget(final int n) {
        return (TransitionSetPort)super.addTarget(n);
    }
    
    @Override
    public TransitionSetPort addTarget(final View view) {
        return (TransitionSetPort)super.addTarget(view);
    }
    
    public TransitionSetPort addTransition(final TransitionPort e) {
        if (e != null) {
            this.mTransitions.add(e);
            e.mParent = this;
            if (this.mDuration >= 0L) {
                e.setDuration(this.mDuration);
            }
        }
        return this;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    @Override
    protected void cancel() {
        super.cancel();
        for (int size = this.mTransitions.size(), i = 0; i < size; ++i) {
            this.mTransitions.get(i).cancel();
        }
    }
    
    @Override
    public void captureEndValues(final TransitionValues transitionValues) {
        final int id = transitionValues.view.getId();
        if (this.isValidTarget(transitionValues.view, id)) {
            for (final TransitionPort transitionPort : this.mTransitions) {
                if (transitionPort.isValidTarget(transitionValues.view, id)) {
                    transitionPort.captureEndValues(transitionValues);
                }
            }
        }
    }
    
    @Override
    public void captureStartValues(final TransitionValues transitionValues) {
        final int id = transitionValues.view.getId();
        if (this.isValidTarget(transitionValues.view, id)) {
            for (final TransitionPort transitionPort : this.mTransitions) {
                if (transitionPort.isValidTarget(transitionValues.view, id)) {
                    transitionPort.captureStartValues(transitionValues);
                }
            }
        }
    }
    
    @Override
    public TransitionSetPort clone() {
        final TransitionSetPort transitionSetPort = (TransitionSetPort)super.clone();
        transitionSetPort.mTransitions = new ArrayList<TransitionPort>();
        for (int size = this.mTransitions.size(), i = 0; i < size; ++i) {
            transitionSetPort.addTransition(this.mTransitions.get(i).clone());
        }
        return transitionSetPort;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    @Override
    protected void createAnimators(final ViewGroup viewGroup, final TransitionValuesMaps transitionValuesMaps, final TransitionValuesMaps transitionValuesMaps2) {
        final Iterator<TransitionPort> iterator = this.mTransitions.iterator();
        while (iterator.hasNext()) {
            iterator.next().createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2);
        }
    }
    
    public int getOrdering() {
        if (this.mPlayTogether) {
            return 0;
        }
        return 1;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    @Override
    public void pause(final View view) {
        super.pause(view);
        for (int size = this.mTransitions.size(), i = 0; i < size; ++i) {
            this.mTransitions.get(i).pause(view);
        }
    }
    
    @Override
    public TransitionSetPort removeListener(final TransitionListener transitionListener) {
        return (TransitionSetPort)super.removeListener(transitionListener);
    }
    
    @Override
    public TransitionSetPort removeTarget(final int n) {
        return (TransitionSetPort)super.removeTarget(n);
    }
    
    @Override
    public TransitionSetPort removeTarget(final View view) {
        return (TransitionSetPort)super.removeTarget(view);
    }
    
    public TransitionSetPort removeTransition(final TransitionPort o) {
        this.mTransitions.remove(o);
        o.mParent = null;
        return this;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    @Override
    public void resume(final View view) {
        super.resume(view);
        for (int size = this.mTransitions.size(), i = 0; i < size; ++i) {
            this.mTransitions.get(i).resume(view);
        }
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    @Override
    protected void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            this.start();
            this.end();
        }
        else {
            this.setupStartEndListeners();
            if (!this.mPlayTogether) {
                for (int i = 1; i < this.mTransitions.size(); ++i) {
                    this.mTransitions.get(i - 1).addListener((TransitionListener)new TransitionListenerAdapter() {
                        final /* synthetic */ TransitionPort val$nextTransition = TransitionSetPort.this.mTransitions.get(i);
                        
                        @Override
                        public void onTransitionEnd(final TransitionPort transitionPort) {
                            this.val$nextTransition.runAnimators();
                            transitionPort.removeListener((TransitionListener)this);
                        }
                    });
                }
                final TransitionPort transitionPort = this.mTransitions.get(0);
                if (transitionPort != null) {
                    transitionPort.runAnimators();
                }
            }
            else {
                final Iterator<TransitionPort> iterator = this.mTransitions.iterator();
                while (iterator.hasNext()) {
                    iterator.next().runAnimators();
                }
            }
        }
    }
    
    @Override
    void setCanRemoveViews(final boolean b) {
        super.setCanRemoveViews(b);
        for (int size = this.mTransitions.size(), i = 0; i < size; ++i) {
            this.mTransitions.get(i).setCanRemoveViews(b);
        }
    }
    
    @Override
    public TransitionSetPort setDuration(final long n) {
        super.setDuration(n);
        if (this.mDuration >= 0L) {
            for (int size = this.mTransitions.size(), i = 0; i < size; ++i) {
                this.mTransitions.get(i).setDuration(n);
            }
        }
        return this;
    }
    
    @Override
    public TransitionSetPort setInterpolator(final TimeInterpolator interpolator) {
        return (TransitionSetPort)super.setInterpolator(interpolator);
    }
    
    public TransitionSetPort setOrdering(final int i) {
        switch (i) {
            default: {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            case 1: {
                this.mPlayTogether = false;
                return this;
            }
            case 0: {
                this.mPlayTogether = true;
                return this;
            }
        }
    }
    
    @Override
    TransitionSetPort setSceneRoot(final ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        for (int size = this.mTransitions.size(), i = 0; i < size; ++i) {
            this.mTransitions.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }
    
    @Override
    public TransitionSetPort setStartDelay(final long startDelay) {
        return (TransitionSetPort)super.setStartDelay(startDelay);
    }
    
    @Override
    String toString(final String str) {
        String str2 = super.toString(str);
        for (int i = 0; i < this.mTransitions.size(); ++i) {
            str2 = str2 + "\n" + this.mTransitions.get(i).toString(str + "  ");
        }
        return str2;
    }
    
    static class TransitionSetListener extends TransitionListenerAdapter
    {
        TransitionSetPort mTransitionSet;
        
        TransitionSetListener(final TransitionSetPort mTransitionSet) {
            this.mTransitionSet = mTransitionSet;
        }
        
        @Override
        public void onTransitionEnd(final TransitionPort transitionPort) {
            final TransitionSetPort mTransitionSet = this.mTransitionSet;
            --mTransitionSet.mCurrentListeners;
            if (this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }
            transitionPort.removeListener((TransitionListener)this);
        }
        
        @Override
        public void onTransitionStart(final TransitionPort transitionPort) {
            if (!this.mTransitionSet.mStarted) {
                this.mTransitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }
    }
}
