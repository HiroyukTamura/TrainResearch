/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.content.res.Resources
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.Resources;
import android.view.View;
import com.google.android.material.a;

class e {
    private static final int[] a = new int[]{16843848};

    static void a(View view, float f2) {
        int n2 = view.getResources().getInteger(a.f.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        int n3 = a.b.state_liftable;
        int n4 = -a.b.state_lifted;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"elevation", (float[])new float[]{0.0f});
        long l2 = n2;
        objectAnimator = objectAnimator.setDuration(l2);
        stateListAnimator.addState(new int[]{16842766, n3, n4}, (Animator)objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"elevation", (float[])new float[]{f2}).setDuration(l2);
        stateListAnimator.addState(new int[]{16842766}, (Animator)objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"elevation", (float[])new float[]{0.0f}).setDuration(0L);
        stateListAnimator.addState(new int[0], (Animator)objectAnimator);
        view.setStateListAnimator(stateListAnimator);
    }
}

