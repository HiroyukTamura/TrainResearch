// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

import android.os.Message;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.view.animation.AnimationUtils;
import java.util.Iterator;
import android.util.AndroidRuntimeException;
import android.os.Looper;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.HashMap;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class ValueAnimator extends Animator
{
    static final int ANIMATION_FRAME = 1;
    static final int ANIMATION_START = 0;
    private static final long DEFAULT_FRAME_DELAY = 10L;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private static ThreadLocal<AnimationHandler> sAnimationHandler;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations;
    private static final Interpolator sDefaultInterpolator;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims;
    private static final TypeEvaluator sFloatEvaluator;
    private static long sFrameDelay;
    private static final TypeEvaluator sIntEvaluator;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims;
    private float mCurrentFraction;
    private int mCurrentIteration;
    private long mDelayStartTime;
    private long mDuration;
    boolean mInitialized;
    private Interpolator mInterpolator;
    private boolean mPlayingBackwards;
    int mPlayingState;
    private int mRepeatCount;
    private int mRepeatMode;
    private boolean mRunning;
    long mSeekTime;
    private long mStartDelay;
    long mStartTime;
    private boolean mStarted;
    private boolean mStartedDelay;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;
    
    static {
        ValueAnimator.sAnimationHandler = new ThreadLocal<AnimationHandler>();
        sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
            @Override
            protected ArrayList<ValueAnimator> initialValue() {
                return new ArrayList<ValueAnimator>();
            }
        };
        sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
            @Override
            protected ArrayList<ValueAnimator> initialValue() {
                return new ArrayList<ValueAnimator>();
            }
        };
        sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
            @Override
            protected ArrayList<ValueAnimator> initialValue() {
                return new ArrayList<ValueAnimator>();
            }
        };
        sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
            @Override
            protected ArrayList<ValueAnimator> initialValue() {
                return new ArrayList<ValueAnimator>();
            }
        };
        sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
            @Override
            protected ArrayList<ValueAnimator> initialValue() {
                return new ArrayList<ValueAnimator>();
            }
        };
        sDefaultInterpolator = (Interpolator)new AccelerateDecelerateInterpolator();
        sIntEvaluator = new IntEvaluator();
        sFloatEvaluator = new FloatEvaluator();
        ValueAnimator.sFrameDelay = 10L;
    }
    
    public ValueAnimator() {
        this.mSeekTime = -1L;
        this.mPlayingBackwards = false;
        this.mCurrentIteration = 0;
        this.mCurrentFraction = 0.0f;
        this.mStartedDelay = false;
        this.mPlayingState = 0;
        this.mRunning = false;
        this.mStarted = false;
        this.mInitialized = false;
        this.mDuration = 300L;
        this.mStartDelay = 0L;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.mInterpolator = ValueAnimator.sDefaultInterpolator;
        this.mUpdateListeners = null;
    }
    
    public static void clearAllAnimations() {
        ValueAnimator.sAnimations.get().clear();
        ValueAnimator.sPendingAnimations.get().clear();
        ValueAnimator.sDelayedAnims.get().clear();
    }
    
    private boolean delayedAnimationFrame(final long mDelayStartTime) {
        if (!this.mStartedDelay) {
            this.mStartedDelay = true;
            this.mDelayStartTime = mDelayStartTime;
        }
        else {
            final long n = mDelayStartTime - this.mDelayStartTime;
            if (n > this.mStartDelay) {
                this.mStartTime = mDelayStartTime - (n - this.mStartDelay);
                this.mPlayingState = 1;
                return true;
            }
        }
        return false;
    }
    
    private void endAnimation() {
        ValueAnimator.sAnimations.get().remove(this);
        ValueAnimator.sPendingAnimations.get().remove(this);
        ValueAnimator.sDelayedAnims.get().remove(this);
        this.mPlayingState = 0;
        if (this.mRunning && this.mListeners != null) {
            final ArrayList list = (ArrayList)this.mListeners.clone();
            for (int size = list.size(), i = 0; i < size; ++i) {
                list.get(i).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }
    
    public static int getCurrentAnimationsCount() {
        return ValueAnimator.sAnimations.get().size();
    }
    
    public static long getFrameDelay() {
        return ValueAnimator.sFrameDelay;
    }
    
    public static ValueAnimator ofFloat(final float... floatValues) {
        final ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(floatValues);
        return valueAnimator;
    }
    
    public static ValueAnimator ofInt(final int... intValues) {
        final ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(intValues);
        return valueAnimator;
    }
    
    public static ValueAnimator ofObject(final TypeEvaluator evaluator, final Object... objectValues) {
        final ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objectValues);
        valueAnimator.setEvaluator(evaluator);
        return valueAnimator;
    }
    
    public static ValueAnimator ofPropertyValuesHolder(final PropertyValuesHolder... values) {
        final ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(values);
        return valueAnimator;
    }
    
    public static void setFrameDelay(final long sFrameDelay) {
        ValueAnimator.sFrameDelay = sFrameDelay;
    }
    
    private void start(final boolean mPlayingBackwards) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.mPlayingBackwards = mPlayingBackwards;
        this.mCurrentIteration = 0;
        this.mPlayingState = 0;
        this.mStarted = true;
        this.mStartedDelay = false;
        ValueAnimator.sPendingAnimations.get().add(this);
        if (this.mStartDelay == 0L) {
            this.setCurrentPlayTime(this.getCurrentPlayTime());
            this.mPlayingState = 0;
            this.mRunning = true;
            if (this.mListeners != null) {
                final ArrayList list = (ArrayList)this.mListeners.clone();
                for (int size = list.size(), i = 0; i < size; ++i) {
                    list.get(i).onAnimationStart(this);
                }
            }
        }
        AnimationHandler value;
        if ((value = ValueAnimator.sAnimationHandler.get()) == null) {
            value = new AnimationHandler();
            ValueAnimator.sAnimationHandler.set(value);
        }
        value.sendEmptyMessage(0);
    }
    
    private void startAnimation() {
        this.initAnimation();
        ValueAnimator.sAnimations.get().add(this);
        if (this.mStartDelay > 0L && this.mListeners != null) {
            final ArrayList list = (ArrayList)this.mListeners.clone();
            for (int size = list.size(), i = 0; i < size; ++i) {
                list.get(i).onAnimationStart(this);
            }
        }
    }
    
    public void addUpdateListener(final AnimatorUpdateListener e) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
        }
        this.mUpdateListeners.add(e);
    }
    
    void animateValue(float interpolation) {
        interpolation = this.mInterpolator.getInterpolation(interpolation);
        this.mCurrentFraction = interpolation;
        for (int length = this.mValues.length, i = 0; i < length; ++i) {
            this.mValues[i].calculateValue(interpolation);
        }
        if (this.mUpdateListeners != null) {
            for (int size = this.mUpdateListeners.size(), j = 0; j < size; ++j) {
                this.mUpdateListeners.get(j).onAnimationUpdate(this);
            }
        }
    }
    
    boolean animationFrame(final long mStartTime) {
        final boolean b = false;
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            if (this.mSeekTime < 0L) {
                this.mStartTime = mStartTime;
            }
            else {
                this.mStartTime = mStartTime - this.mSeekTime;
                this.mSeekTime = -1L;
            }
        }
        switch (this.mPlayingState) {
            default: {
                return false;
            }
            case 1:
            case 2: {
                float a;
                if (this.mDuration > 0L) {
                    a = (mStartTime - this.mStartTime) / (float)this.mDuration;
                }
                else {
                    a = 1.0f;
                }
                boolean b2 = b;
                float min = a;
                if (a >= 1.0f) {
                    if (this.mCurrentIteration < this.mRepeatCount || this.mRepeatCount == -1) {
                        if (this.mListeners != null) {
                            for (int size = this.mListeners.size(), i = 0; i < size; ++i) {
                                ((AnimatorListener)this.mListeners.get(i)).onAnimationRepeat(this);
                            }
                        }
                        if (this.mRepeatMode == 2) {
                            this.mPlayingBackwards = !this.mPlayingBackwards;
                        }
                        this.mCurrentIteration += (int)a;
                        min = a % 1.0f;
                        this.mStartTime += this.mDuration;
                        b2 = b;
                    }
                    else {
                        b2 = true;
                        min = Math.min(a, 1.0f);
                    }
                }
                float n = min;
                if (this.mPlayingBackwards) {
                    n = 1.0f - min;
                }
                this.animateValue(n);
                return b2;
            }
        }
    }
    
    @Override
    public void cancel() {
        if (this.mPlayingState != 0 || ValueAnimator.sPendingAnimations.get().contains(this) || ValueAnimator.sDelayedAnims.get().contains(this)) {
            if (this.mRunning && this.mListeners != null) {
                final Iterator<AnimatorListener> iterator = ((ArrayList)this.mListeners.clone()).iterator();
                while (iterator.hasNext()) {
                    iterator.next().onAnimationCancel(this);
                }
            }
            this.endAnimation();
        }
    }
    
    @Override
    public ValueAnimator clone() {
        final ValueAnimator valueAnimator = (ValueAnimator)super.clone();
        if (this.mUpdateListeners != null) {
            final ArrayList<AnimatorUpdateListener> mUpdateListeners = this.mUpdateListeners;
            valueAnimator.mUpdateListeners = new ArrayList<AnimatorUpdateListener>();
            for (int size = mUpdateListeners.size(), i = 0; i < size; ++i) {
                valueAnimator.mUpdateListeners.add(mUpdateListeners.get(i));
            }
        }
        valueAnimator.mSeekTime = -1L;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = 0;
        valueAnimator.mStartedDelay = false;
        final PropertyValuesHolder[] mValues = this.mValues;
        if (mValues != null) {
            final int length = mValues.length;
            valueAnimator.mValues = new PropertyValuesHolder[length];
            valueAnimator.mValuesMap = new HashMap<String, PropertyValuesHolder>(length);
            for (int j = 0; j < length; ++j) {
                final PropertyValuesHolder clone = mValues[j].clone();
                valueAnimator.mValues[j] = clone;
                valueAnimator.mValuesMap.put(clone.getPropertyName(), clone);
            }
        }
        return valueAnimator;
    }
    
    @Override
    public void end() {
        if (!ValueAnimator.sAnimations.get().contains(this) && !ValueAnimator.sPendingAnimations.get().contains(this)) {
            this.mStartedDelay = false;
            this.startAnimation();
        }
        else if (!this.mInitialized) {
            this.initAnimation();
        }
        if (this.mRepeatCount > 0 && (this.mRepeatCount & 0x1) == 0x1) {
            this.animateValue(0.0f);
        }
        else {
            this.animateValue(1.0f);
        }
        this.endAnimation();
    }
    
    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }
    
    public Object getAnimatedValue() {
        if (this.mValues != null && this.mValues.length > 0) {
            return this.mValues[0].getAnimatedValue();
        }
        return null;
    }
    
    public Object getAnimatedValue(final String key) {
        final PropertyValuesHolder propertyValuesHolder = this.mValuesMap.get(key);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.getAnimatedValue();
        }
        return null;
    }
    
    public long getCurrentPlayTime() {
        if (!this.mInitialized || this.mPlayingState == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }
    
    @Override
    public long getDuration() {
        return this.mDuration;
    }
    
    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }
    
    public int getRepeatCount() {
        return this.mRepeatCount;
    }
    
    public int getRepeatMode() {
        return this.mRepeatMode;
    }
    
    @Override
    public long getStartDelay() {
        return this.mStartDelay;
    }
    
    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }
    
    void initAnimation() {
        if (!this.mInitialized) {
            for (int length = this.mValues.length, i = 0; i < length; ++i) {
                this.mValues[i].init();
            }
            this.mInitialized = true;
        }
    }
    
    @Override
    public boolean isRunning() {
        return this.mPlayingState == 1 || this.mRunning;
    }
    
    @Override
    public boolean isStarted() {
        return this.mStarted;
    }
    
    public void removeAllUpdateListeners() {
        if (this.mUpdateListeners == null) {
            return;
        }
        this.mUpdateListeners.clear();
        this.mUpdateListeners = null;
    }
    
    public void removeUpdateListener(final AnimatorUpdateListener o) {
        if (this.mUpdateListeners != null) {
            this.mUpdateListeners.remove(o);
            if (this.mUpdateListeners.size() == 0) {
                this.mUpdateListeners = null;
            }
        }
    }
    
    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == 1) {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.mStartTime));
            return;
        }
        this.start(true);
    }
    
    public void setCurrentPlayTime(final long mSeekTime) {
        this.initAnimation();
        final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != 1) {
            this.mSeekTime = mSeekTime;
            this.mPlayingState = 2;
        }
        this.mStartTime = currentAnimationTimeMillis - mSeekTime;
        this.animationFrame(currentAnimationTimeMillis);
    }
    
    @Override
    public ValueAnimator setDuration(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + n);
        }
        this.mDuration = n;
        return this;
    }
    
    public void setEvaluator(final TypeEvaluator evaluator) {
        if (evaluator != null && this.mValues != null && this.mValues.length > 0) {
            this.mValues[0].setEvaluator(evaluator);
        }
    }
    
    public void setFloatValues(final float... floatValues) {
        if (floatValues == null || floatValues.length == 0) {
            return;
        }
        if (this.mValues == null || this.mValues.length == 0) {
            this.setValues(PropertyValuesHolder.ofFloat("", floatValues));
        }
        else {
            this.mValues[0].setFloatValues(floatValues);
        }
        this.mInitialized = false;
    }
    
    public void setIntValues(final int... intValues) {
        if (intValues == null || intValues.length == 0) {
            return;
        }
        if (this.mValues == null || this.mValues.length == 0) {
            this.setValues(PropertyValuesHolder.ofInt("", intValues));
        }
        else {
            this.mValues[0].setIntValues(intValues);
        }
        this.mInitialized = false;
    }
    
    @Override
    public void setInterpolator(final Interpolator mInterpolator) {
        if (mInterpolator != null) {
            this.mInterpolator = mInterpolator;
            return;
        }
        this.mInterpolator = (Interpolator)new LinearInterpolator();
    }
    
    public void setObjectValues(final Object... objectValues) {
        if (objectValues == null || objectValues.length == 0) {
            return;
        }
        if (this.mValues == null || this.mValues.length == 0) {
            this.setValues(PropertyValuesHolder.ofObject("", null, objectValues));
        }
        else {
            this.mValues[0].setObjectValues(objectValues);
        }
        this.mInitialized = false;
    }
    
    public void setRepeatCount(final int mRepeatCount) {
        this.mRepeatCount = mRepeatCount;
    }
    
    public void setRepeatMode(final int mRepeatMode) {
        this.mRepeatMode = mRepeatMode;
    }
    
    @Override
    public void setStartDelay(final long mStartDelay) {
        this.mStartDelay = mStartDelay;
    }
    
    public void setValues(final PropertyValuesHolder... mValues) {
        final int length = mValues.length;
        this.mValues = mValues;
        this.mValuesMap = new HashMap<String, PropertyValuesHolder>(length);
        for (int i = 0; i < length; ++i) {
            final PropertyValuesHolder value = mValues[i];
            this.mValuesMap.put(value.getPropertyName(), value);
        }
        this.mInitialized = false;
    }
    
    @Override
    public void start() {
        this.start(false);
    }
    
    @Override
    public String toString() {
        String string2;
        String string = string2 = "ValueAnimator@" + Integer.toHexString(this.hashCode());
        if (this.mValues != null) {
            int n = 0;
            while (true) {
                string2 = string;
                if (n >= this.mValues.length) {
                    break;
                }
                string = string + "\n    " + this.mValues[n].toString();
                ++n;
            }
        }
        return string2;
    }
    
    private static class AnimationHandler extends Handler
    {
        public void handleMessage(final Message message) {
            int n = 1;
            int n2 = 1;
            final ArrayList<ValueAnimator> list = ValueAnimator.sAnimations.get();
            final ArrayList<ValueAnimator> list2 = ValueAnimator.sDelayedAnims.get();
            Label_0162: {
                switch (message.what) {
                    case 0: {
                        final ArrayList list3 = ValueAnimator.sPendingAnimations.get();
                        if (list.size() > 0 || list2.size() > 0) {
                            n2 = 0;
                        }
                        while (true) {
                            n = n2;
                            if (list3.size() <= 0) {
                                break Label_0162;
                            }
                            final ArrayList list4 = (ArrayList)list3.clone();
                            list3.clear();
                            for (int size = list4.size(), i = 0; i < size; ++i) {
                                final ValueAnimator e = list4.get(i);
                                if (e.mStartDelay == 0L) {
                                    e.startAnimation();
                                }
                                else {
                                    list2.add(e);
                                }
                            }
                        }
                        break;
                    }
                    case 1: {
                        final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        final ArrayList<ValueAnimator> list5 = ValueAnimator.sReadyAnims.get();
                        final ArrayList<ValueAnimator> list6 = ValueAnimator.sEndingAnims.get();
                        for (int size2 = list2.size(), j = 0; j < size2; ++j) {
                            final ValueAnimator e2 = list2.get(j);
                            if (e2.delayedAnimationFrame(currentAnimationTimeMillis)) {
                                list5.add(e2);
                            }
                        }
                        final int size3 = list5.size();
                        if (size3 > 0) {
                            for (int k = 0; k < size3; ++k) {
                                final ValueAnimator o = list5.get(k);
                                o.startAnimation();
                                o.mRunning = true;
                                list2.remove(o);
                            }
                            list5.clear();
                        }
                        int size4 = list.size();
                        int l = 0;
                        while (l < size4) {
                            final ValueAnimator valueAnimator = list.get(l);
                            if (valueAnimator.animationFrame(currentAnimationTimeMillis)) {
                                list6.add(valueAnimator);
                            }
                            if (list.size() == size4) {
                                ++l;
                            }
                            else {
                                --size4;
                                list6.remove(valueAnimator);
                            }
                        }
                        if (list6.size() > 0) {
                            for (int index = 0; index < list6.size(); ++index) {
                                list6.get(index).endAnimation();
                            }
                            list6.clear();
                        }
                        if (n != 0 && (!list.isEmpty() || !list2.isEmpty())) {
                            this.sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
                            return;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    public interface AnimatorUpdateListener
    {
        void onAnimationUpdate(final ValueAnimator p0);
    }
}
