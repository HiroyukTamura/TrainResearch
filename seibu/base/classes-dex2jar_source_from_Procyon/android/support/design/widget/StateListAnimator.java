// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.util.StateSet;
import java.util.ArrayList;

final class StateListAnimator
{
    private final ValueAnimatorCompat.AnimatorListener mAnimationListener;
    private Tuple mLastMatch;
    ValueAnimatorCompat mRunningAnimator;
    private final ArrayList<Tuple> mTuples;
    
    StateListAnimator() {
        this.mTuples = new ArrayList<Tuple>();
        this.mLastMatch = null;
        this.mRunningAnimator = null;
        this.mAnimationListener = new ValueAnimatorCompat.AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
                if (StateListAnimator.this.mRunningAnimator == valueAnimatorCompat) {
                    StateListAnimator.this.mRunningAnimator = null;
                }
            }
        };
    }
    
    private void cancel() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.cancel();
            this.mRunningAnimator = null;
        }
    }
    
    private void start(final Tuple tuple) {
        (this.mRunningAnimator = tuple.mAnimator).start();
    }
    
    public void addState(final int[] array, final ValueAnimatorCompat valueAnimatorCompat) {
        final Tuple e = new Tuple(array, valueAnimatorCompat);
        valueAnimatorCompat.addListener(this.mAnimationListener);
        this.mTuples.add(e);
    }
    
    public void jumpToCurrentState() {
        if (this.mRunningAnimator != null) {
            this.mRunningAnimator.end();
            this.mRunningAnimator = null;
        }
    }
    
    void setState(final int[] array) {
        final Tuple tuple = null;
        final int size = this.mTuples.size();
        int index = 0;
        Tuple mLastMatch;
        while (true) {
            mLastMatch = tuple;
            if (index >= size) {
                break;
            }
            mLastMatch = this.mTuples.get(index);
            if (StateSet.stateSetMatches(mLastMatch.mSpecs, array)) {
                break;
            }
            ++index;
        }
        if (mLastMatch != this.mLastMatch) {
            if (this.mLastMatch != null) {
                this.cancel();
            }
            if ((this.mLastMatch = mLastMatch) != null) {
                this.start(mLastMatch);
            }
        }
    }
    
    static class Tuple
    {
        final ValueAnimatorCompat mAnimator;
        final int[] mSpecs;
        
        Tuple(final int[] mSpecs, final ValueAnimatorCompat mAnimator) {
            this.mSpecs = mSpecs;
            this.mAnimator = mAnimator;
        }
    }
}
