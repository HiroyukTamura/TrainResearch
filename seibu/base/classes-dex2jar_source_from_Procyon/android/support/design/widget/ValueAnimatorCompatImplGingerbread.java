// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.os.Looper;
import java.util.ArrayList;
import android.view.animation.Interpolator;
import android.os.Handler;

class ValueAnimatorCompatImplGingerbread extends Impl
{
    private static final int DEFAULT_DURATION = 200;
    private static final int HANDLER_DELAY = 10;
    private static final Handler sHandler;
    private float mAnimatedFraction;
    private long mDuration;
    private final float[] mFloatValues;
    private final int[] mIntValues;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private ArrayList<AnimatorListenerProxy> mListeners;
    private final Runnable mRunnable;
    private long mStartTime;
    private ArrayList<AnimatorUpdateListenerProxy> mUpdateListeners;
    
    static {
        sHandler = new Handler(Looper.getMainLooper());
    }
    
    ValueAnimatorCompatImplGingerbread() {
        this.mIntValues = new int[2];
        this.mFloatValues = new float[2];
        this.mDuration = 200L;
        this.mRunnable = new Runnable() {
            @Override
            public void run() {
                ValueAnimatorCompatImplGingerbread.this.update();
            }
        };
    }
    
    private void dispatchAnimationCancel() {
        if (this.mListeners != null) {
            for (int i = 0; i < this.mListeners.size(); ++i) {
                this.mListeners.get(i).onAnimationCancel();
            }
        }
    }
    
    private void dispatchAnimationEnd() {
        if (this.mListeners != null) {
            for (int i = 0; i < this.mListeners.size(); ++i) {
                this.mListeners.get(i).onAnimationEnd();
            }
        }
    }
    
    private void dispatchAnimationStart() {
        if (this.mListeners != null) {
            for (int i = 0; i < this.mListeners.size(); ++i) {
                this.mListeners.get(i).onAnimationStart();
            }
        }
    }
    
    private void dispatchAnimationUpdate() {
        if (this.mUpdateListeners != null) {
            for (int i = 0; i < this.mUpdateListeners.size(); ++i) {
                this.mUpdateListeners.get(i).onAnimationUpdate();
            }
        }
    }
    
    public void addListener(final AnimatorListenerProxy e) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<AnimatorListenerProxy>();
        }
        this.mListeners.add(e);
    }
    
    public void addUpdateListener(final AnimatorUpdateListenerProxy e) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<AnimatorUpdateListenerProxy>();
        }
        this.mUpdateListeners.add(e);
    }
    
    public void cancel() {
        this.mIsRunning = false;
        ValueAnimatorCompatImplGingerbread.sHandler.removeCallbacks(this.mRunnable);
        this.dispatchAnimationCancel();
        this.dispatchAnimationEnd();
    }
    
    public void end() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            ValueAnimatorCompatImplGingerbread.sHandler.removeCallbacks(this.mRunnable);
            this.mAnimatedFraction = 1.0f;
            this.dispatchAnimationUpdate();
            this.dispatchAnimationEnd();
        }
    }
    
    public float getAnimatedFloatValue() {
        return AnimationUtils.lerp(this.mFloatValues[0], this.mFloatValues[1], this.getAnimatedFraction());
    }
    
    public float getAnimatedFraction() {
        return this.mAnimatedFraction;
    }
    
    public int getAnimatedIntValue() {
        return AnimationUtils.lerp(this.mIntValues[0], this.mIntValues[1], this.getAnimatedFraction());
    }
    
    public long getDuration() {
        return this.mDuration;
    }
    
    public boolean isRunning() {
        return this.mIsRunning;
    }
    
    public void setDuration(final long mDuration) {
        this.mDuration = mDuration;
    }
    
    public void setFloatValues(final float n, final float n2) {
        this.mFloatValues[0] = n;
        this.mFloatValues[1] = n2;
    }
    
    public void setIntValues(final int n, final int n2) {
        this.mIntValues[0] = n;
        this.mIntValues[1] = n2;
    }
    
    public void setInterpolator(final Interpolator mInterpolator) {
        this.mInterpolator = mInterpolator;
    }
    
    public void start() {
        if (this.mIsRunning) {
            return;
        }
        if (this.mInterpolator == null) {
            this.mInterpolator = (Interpolator)new AccelerateDecelerateInterpolator();
        }
        this.mIsRunning = true;
        this.mAnimatedFraction = 0.0f;
        this.startInternal();
    }
    
    final void startInternal() {
        this.mStartTime = SystemClock.uptimeMillis();
        this.dispatchAnimationUpdate();
        this.dispatchAnimationStart();
        ValueAnimatorCompatImplGingerbread.sHandler.postDelayed(this.mRunnable, 10L);
    }
    
    final void update() {
        if (this.mIsRunning) {
            float mAnimatedFraction = MathUtils.constrain((SystemClock.uptimeMillis() - this.mStartTime) / (float)this.mDuration, 0.0f, 1.0f);
            if (this.mInterpolator != null) {
                mAnimatedFraction = this.mInterpolator.getInterpolation(mAnimatedFraction);
            }
            this.mAnimatedFraction = mAnimatedFraction;
            this.dispatchAnimationUpdate();
            if (SystemClock.uptimeMillis() >= this.mStartTime + this.mDuration) {
                this.mIsRunning = false;
                this.dispatchAnimationEnd();
            }
        }
        if (this.mIsRunning) {
            ValueAnimatorCompatImplGingerbread.sHandler.postDelayed(this.mRunnable, 10L);
        }
    }
}
