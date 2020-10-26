/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.AnimatorSet$Builder
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.animation.TimeInterpolator
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.h;
import com.google.android.material.k.c;
import java.util.ArrayList;

class b
extends a {
    private InsetDrawable x;

    b(h h2, c c2) {
        super(h2, c2);
    }

    private Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play((Animator)ObjectAnimator.ofFloat((Object)((Object)this.v), (String)"elevation", (float[])new float[]{f2}).setDuration(0L)).with((Animator)ObjectAnimator.ofFloat((Object)((Object)this.v), (Property)View.TRANSLATION_Z, (float[])new float[]{f3}).setDuration(100L));
        animatorSet.setInterpolator(a);
        return animatorSet;
    }

    @Override
    public float a() {
        return this.v.getElevation();
    }

    @Override
    void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.v.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(p, this.a(f2, f4));
            stateListAnimator.addState(q, this.a(f2, f3));
            stateListAnimator.addState(r, this.a(f2, f3));
            stateListAnimator.addState(s, this.a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList<ObjectAnimator> arrayList = new ArrayList<ObjectAnimator>();
            arrayList.add(ObjectAnimator.ofFloat((Object)((Object)this.v), (String)"elevation", (float[])new float[]{f2}).setDuration(0L));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat((Object)((Object)this.v), (Property)View.TRANSLATION_Z, (float[])new float[]{this.v.getTranslationZ()}).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat((Object)((Object)this.v), (Property)View.TRANSLATION_Z, (float[])new float[]{0.0f}).setDuration(100L));
            animatorSet.playSequentially(arrayList.toArray((T[])new Animator[0]));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(t, (Animator)animatorSet);
            stateListAnimator.addState(u, this.a(0.0f, 0.0f));
            this.v.setStateListAnimator(stateListAnimator);
        }
        if (this.w.b()) {
            this.l();
        }
    }

    @Override
    void a(Rect rect) {
        if (this.w.b()) {
            float f2 = this.w.a();
            float f3 = this.a() + this.m;
            int n2 = (int)Math.ceil(com.google.android.material.k.a.b(f3, f2, false));
            int n3 = (int)Math.ceil(com.google.android.material.k.a.a(f3, f2, false));
            rect.set(n2, n3, n2, n3);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    @Override
    void a(int[] object) {
        block0 : {
            float f2;
            block3 : {
                block4 : {
                    block1 : {
                        block2 : {
                            if (Build.VERSION.SDK_INT != 21) break block0;
                            boolean bl2 = this.v.isEnabled();
                            f2 = 0.0f;
                            if (!bl2) break block1;
                            this.v.setElevation(this.k);
                            if (!this.v.isPressed()) break block2;
                            object = this.v;
                            f2 = this.m;
                            break block3;
                        }
                        if (!this.v.isFocused() && !this.v.isHovered()) break block4;
                        object = this.v;
                        f2 = this.l;
                        break block3;
                    }
                    this.v.setElevation(0.0f);
                }
                object = this.v;
            }
            object.setTranslationZ(f2);
        }
    }

    @Override
    void b(ColorStateList colorStateList) {
        if (this.h instanceof RippleDrawable) {
            ((RippleDrawable)this.h).setColor(com.google.android.material.j.a.a(colorStateList));
            return;
        }
        super.b(colorStateList);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void b(Rect rect) {
        c c2;
        if (this.w.b()) {
            this.x = new InsetDrawable(this.h, rect.left, rect.top, rect.right, rect.bottom);
            c2 = this.w;
            rect = this.x;
        } else {
            c2 = this.w;
            rect = this.h;
        }
        c2.a((Drawable)rect);
    }

    @Override
    void g() {
    }

    @Override
    void k() {
        this.l();
    }

    @Override
    boolean o() {
        return false;
    }
}

