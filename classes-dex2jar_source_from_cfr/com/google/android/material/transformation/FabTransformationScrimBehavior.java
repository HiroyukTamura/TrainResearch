/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.b;
import com.google.android.material.a.i;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior
extends ExpandableTransformationBehavior {
    private final i a = new i(75L, 150L);
    private final i b = new i(0L, 150L);

    public FabTransformationScrimBehavior() {
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, boolean bl2, boolean bl3, List<Animator> list, List<Animator.AnimatorListener> object) {
        float[] arrf;
        Property property;
        object = bl2 ? this.a : this.b;
        if (bl2) {
            if (!bl3) {
                view.setAlpha(0.0f);
            }
            property = View.ALPHA;
            arrf = new float[]{1.0f};
        } else {
            property = View.ALPHA;
            arrf = new float[]{0.0f};
        }
        view = ObjectAnimator.ofFloat((Object)view, (Property)property, (float[])arrf);
        ((i)object).a((Animator)view);
        list.add((Animator)view);
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override
    protected AnimatorSet b(View object, final View view, final boolean bl2, boolean bl3) {
        object = new ArrayList();
        this.a(view, bl2, bl3, (List<Animator>)object, new ArrayList<Animator.AnimatorListener>());
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, (List<Animator>)object);
        animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                if (!bl2) {
                    view.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (bl2) {
                    view.setVisibility(0);
                }
            }
        });
        return animatorSet;
    }

    @Override
    public boolean b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.b(coordinatorLayout, view, motionEvent);
    }

}

