// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.internal;

import java.util.Map;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.animation.Animator;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.transition.TransitionValues;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;
import android.support.transition.Transition;

@TargetApi(14)
@RequiresApi(14)
public class TextScale extends Transition
{
    private static final String PROPNAME_SCALE = "android:textscale:scale";
    
    private void captureValues(final TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            transitionValues.values.put("android:textscale:scale", ((TextView)transitionValues.view).getScaleX());
        }
    }
    
    @Override
    public void captureEndValues(final TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }
    
    @Override
    public void captureStartValues(final TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }
    
    @Override
    public Animator createAnimator(final ViewGroup viewGroup, final TransitionValues transitionValues, final TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null && transitionValues.view instanceof TextView && transitionValues2.view instanceof TextView) {
            final TextView textView = (TextView)transitionValues2.view;
            final Map<String, Object> values = transitionValues.values;
            final Map<String, Object> values2 = transitionValues2.values;
            float floatValue;
            if (values.get("android:textscale:scale") != null) {
                floatValue = values.get("android:textscale:scale");
            }
            else {
                floatValue = 1.0f;
            }
            float floatValue2;
            if (values2.get("android:textscale:scale") != null) {
                floatValue2 = values2.get("android:textscale:scale");
            }
            else {
                floatValue2 = 1.0f;
            }
            if (floatValue != floatValue2) {
                final ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[] { floatValue, floatValue2 });
                ofFloat.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
                    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                        final float floatValue = (float)valueAnimator.getAnimatedValue();
                        textView.setScaleX(floatValue);
                        textView.setScaleY(floatValue);
                    }
                });
                return (Animator)ofFloat;
            }
        }
        return null;
    }
}
