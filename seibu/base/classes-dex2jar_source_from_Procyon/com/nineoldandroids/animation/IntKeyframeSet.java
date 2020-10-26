// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet
{
    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;
    
    public IntKeyframeSet(final Keyframe.IntKeyframe... array) {
        super((Keyframe[])array);
        this.firstTime = true;
    }
    
    @Override
    public IntKeyframeSet clone() {
        final ArrayList<Keyframe> mKeyframes = this.mKeyframes;
        final int size = this.mKeyframes.size();
        final Keyframe.IntKeyframe[] array = new Keyframe.IntKeyframe[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (Keyframe.IntKeyframe)mKeyframes.get(i).clone();
        }
        return new IntKeyframeSet(array);
    }
    
    public int getIntValue(float n) {
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe)this.mKeyframes.get(0)).getIntValue();
                this.lastValue = ((Keyframe.IntKeyframe)this.mKeyframes.get(1)).getIntValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            float interpolation = n;
            if (this.mInterpolator != null) {
                interpolation = this.mInterpolator.getInterpolation(n);
            }
            if (this.mEvaluator == null) {
                return this.firstValue + (int)(this.deltaValue * interpolation);
            }
            return this.mEvaluator.evaluate(interpolation, this.firstValue, this.lastValue).intValue();
        }
        else if (n <= 0.0f) {
            final Keyframe.IntKeyframe intKeyframe = this.mKeyframes.get(0);
            final Keyframe.IntKeyframe intKeyframe2 = this.mKeyframes.get(1);
            final int intValue = intKeyframe.getIntValue();
            final int intValue2 = intKeyframe2.getIntValue();
            final float fraction = intKeyframe.getFraction();
            final float fraction2 = intKeyframe2.getFraction();
            final Interpolator interpolator = intKeyframe2.getInterpolator();
            float interpolation2 = n;
            if (interpolator != null) {
                interpolation2 = interpolator.getInterpolation(n);
            }
            n = (interpolation2 - fraction) / (fraction2 - fraction);
            if (this.mEvaluator == null) {
                return (int)((intValue2 - intValue) * n) + intValue;
            }
            return this.mEvaluator.evaluate(n, intValue, intValue2).intValue();
        }
        else {
            if (n < 1.0f) {
                Keyframe keyframe = this.mKeyframes.get(0);
                int i = 1;
                while (i < this.mNumKeyframes) {
                    final Keyframe.IntKeyframe intKeyframe3 = this.mKeyframes.get(i);
                    if (n < intKeyframe3.getFraction()) {
                        final Interpolator interpolator2 = intKeyframe3.getInterpolator();
                        float interpolation3 = n;
                        if (interpolator2 != null) {
                            interpolation3 = interpolator2.getInterpolation(n);
                        }
                        n = (interpolation3 - keyframe.getFraction()) / (intKeyframe3.getFraction() - keyframe.getFraction());
                        final int intValue3 = ((Keyframe.IntKeyframe)keyframe).getIntValue();
                        final int intValue4 = intKeyframe3.getIntValue();
                        if (this.mEvaluator == null) {
                            return (int)((intValue4 - intValue3) * n) + intValue3;
                        }
                        return this.mEvaluator.evaluate(n, intValue3, intValue4).intValue();
                    }
                    else {
                        keyframe = intKeyframe3;
                        ++i;
                    }
                }
                return ((Number)this.mKeyframes.get(this.mNumKeyframes - 1).getValue()).intValue();
            }
            final Keyframe.IntKeyframe intKeyframe4 = this.mKeyframes.get(this.mNumKeyframes - 2);
            final Keyframe.IntKeyframe intKeyframe5 = this.mKeyframes.get(this.mNumKeyframes - 1);
            final int intValue5 = intKeyframe4.getIntValue();
            final int intValue6 = intKeyframe5.getIntValue();
            final float fraction3 = intKeyframe4.getFraction();
            final float fraction4 = intKeyframe5.getFraction();
            final Interpolator interpolator3 = intKeyframe5.getInterpolator();
            float interpolation4 = n;
            if (interpolator3 != null) {
                interpolation4 = interpolator3.getInterpolation(n);
            }
            n = (interpolation4 - fraction3) / (fraction4 - fraction3);
            if (this.mEvaluator == null) {
                return (int)((intValue6 - intValue5) * n) + intValue5;
            }
            return this.mEvaluator.evaluate(n, intValue5, intValue6).intValue();
        }
    }
    
    @Override
    public Object getValue(final float n) {
        return this.getIntValue(n);
    }
}
