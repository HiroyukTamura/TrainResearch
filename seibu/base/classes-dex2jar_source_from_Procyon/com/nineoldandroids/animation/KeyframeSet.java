// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.view.animation.Interpolator;

class KeyframeSet
{
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes;
    Keyframe mLastKeyframe;
    int mNumKeyframes;
    
    public KeyframeSet(final Keyframe... a) {
        this.mNumKeyframes = a.length;
        (this.mKeyframes = new ArrayList<Keyframe>()).addAll(Arrays.asList(a));
        this.mFirstKeyframe = this.mKeyframes.get(0);
        this.mLastKeyframe = this.mKeyframes.get(this.mNumKeyframes - 1);
        this.mInterpolator = this.mLastKeyframe.getInterpolator();
    }
    
    public static KeyframeSet ofFloat(final float... array) {
        final int length = array.length;
        final Keyframe.FloatKeyframe[] array2 = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            array2[0] = (Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0f);
            array2[1] = (Keyframe.FloatKeyframe)Keyframe.ofFloat(1.0f, array[0]);
        }
        else {
            array2[0] = (Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0f, array[0]);
            for (int i = 1; i < length; ++i) {
                array2[i] = (Keyframe.FloatKeyframe)Keyframe.ofFloat(i / (float)(length - 1), array[i]);
            }
        }
        return new FloatKeyframeSet(array2);
    }
    
    public static KeyframeSet ofInt(final int... array) {
        final int length = array.length;
        final Keyframe.IntKeyframe[] array2 = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            array2[0] = (Keyframe.IntKeyframe)Keyframe.ofInt(0.0f);
            array2[1] = (Keyframe.IntKeyframe)Keyframe.ofInt(1.0f, array[0]);
        }
        else {
            array2[0] = (Keyframe.IntKeyframe)Keyframe.ofInt(0.0f, array[0]);
            for (int i = 1; i < length; ++i) {
                array2[i] = (Keyframe.IntKeyframe)Keyframe.ofInt(i / (float)(length - 1), array[i]);
            }
        }
        return new IntKeyframeSet(array2);
    }
    
    public static KeyframeSet ofKeyframe(final Keyframe... array) {
        final int length = array.length;
        boolean b = false;
        boolean b2 = false;
        boolean b3 = false;
        for (int i = 0; i < length; ++i) {
            if (array[i] instanceof Keyframe.FloatKeyframe) {
                b = true;
            }
            else if (array[i] instanceof Keyframe.IntKeyframe) {
                b2 = true;
            }
            else {
                b3 = true;
            }
        }
        if (b && !b2 && !b3) {
            final Keyframe.FloatKeyframe[] array2 = new Keyframe.FloatKeyframe[length];
            for (int j = 0; j < length; ++j) {
                array2[j] = (Keyframe.FloatKeyframe)array[j];
            }
            return new FloatKeyframeSet(array2);
        }
        if (b2 && !b && !b3) {
            final Keyframe.IntKeyframe[] array3 = new Keyframe.IntKeyframe[length];
            for (int k = 0; k < length; ++k) {
                array3[k] = (Keyframe.IntKeyframe)array[k];
            }
            return new IntKeyframeSet(array3);
        }
        return new KeyframeSet(array);
    }
    
    public static KeyframeSet ofObject(final Object... array) {
        final int length = array.length;
        final Keyframe.ObjectKeyframe[] array2 = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            array2[0] = (Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0f);
            array2[1] = (Keyframe.ObjectKeyframe)Keyframe.ofObject(1.0f, array[0]);
        }
        else {
            array2[0] = (Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0f, array[0]);
            for (int i = 1; i < length; ++i) {
                array2[i] = (Keyframe.ObjectKeyframe)Keyframe.ofObject(i / (float)(length - 1), array[i]);
            }
        }
        return new KeyframeSet((Keyframe[])array2);
    }
    
    public KeyframeSet clone() {
        final ArrayList<Keyframe> mKeyframes = this.mKeyframes;
        final int size = this.mKeyframes.size();
        final Keyframe[] array = new Keyframe[size];
        for (int i = 0; i < size; ++i) {
            array[i] = mKeyframes.get(i).clone();
        }
        return new KeyframeSet(array);
    }
    
    public Object getValue(float n) {
        if (this.mNumKeyframes == 2) {
            float interpolation = n;
            if (this.mInterpolator != null) {
                interpolation = this.mInterpolator.getInterpolation(n);
            }
            return this.mEvaluator.evaluate(interpolation, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        }
        if (n <= 0.0f) {
            final Keyframe keyframe = this.mKeyframes.get(1);
            final Interpolator interpolator = keyframe.getInterpolator();
            float interpolation2 = n;
            if (interpolator != null) {
                interpolation2 = interpolator.getInterpolation(n);
            }
            n = this.mFirstKeyframe.getFraction();
            n = (interpolation2 - n) / (keyframe.getFraction() - n);
            return this.mEvaluator.evaluate(n, this.mFirstKeyframe.getValue(), keyframe.getValue());
        }
        if (n >= 1.0f) {
            final Keyframe keyframe2 = this.mKeyframes.get(this.mNumKeyframes - 2);
            final Interpolator interpolator2 = this.mLastKeyframe.getInterpolator();
            float interpolation3 = n;
            if (interpolator2 != null) {
                interpolation3 = interpolator2.getInterpolation(n);
            }
            n = keyframe2.getFraction();
            n = (interpolation3 - n) / (this.mLastKeyframe.getFraction() - n);
            return this.mEvaluator.evaluate(n, keyframe2.getValue(), this.mLastKeyframe.getValue());
        }
        Keyframe mFirstKeyframe = this.mFirstKeyframe;
        for (int i = 1; i < this.mNumKeyframes; ++i) {
            final Keyframe keyframe3 = this.mKeyframes.get(i);
            if (n < keyframe3.getFraction()) {
                final Interpolator interpolator3 = keyframe3.getInterpolator();
                float interpolation4 = n;
                if (interpolator3 != null) {
                    interpolation4 = interpolator3.getInterpolation(n);
                }
                n = mFirstKeyframe.getFraction();
                n = (interpolation4 - n) / (keyframe3.getFraction() - n);
                return this.mEvaluator.evaluate(n, mFirstKeyframe.getValue(), keyframe3.getValue());
            }
            mFirstKeyframe = keyframe3;
        }
        return this.mLastKeyframe.getValue();
    }
    
    public void setEvaluator(final TypeEvaluator mEvaluator) {
        this.mEvaluator = mEvaluator;
    }
    
    @Override
    public String toString() {
        String string = " ";
        for (int i = 0; i < this.mNumKeyframes; ++i) {
            string = string + this.mKeyframes.get(i).getValue() + "  ";
        }
        return string;
    }
}
