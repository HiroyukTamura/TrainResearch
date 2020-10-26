/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Pair
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewAnimationUtils
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.a.e;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.d.c;
import com.google.android.material.d.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.google.android.material.transformation.b;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior
extends ExpandableTransformationBehavior {
    private final Rect a = new Rect();
    private final RectF b = new RectF();
    private final RectF c = new RectF();
    private final int[] d = new int[2];
    private float e;
    private float f;

    public FabTransformationBehavior() {
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private float a(View view, View view2, j j2) {
        float f2;
        block3 : {
            float f3;
            block4 : {
                RectF rectF;
                RectF rectF2;
                block0 : {
                    block1 : {
                        block2 : {
                            rectF = this.b;
                            rectF2 = this.c;
                            this.b(view, rectF);
                            this.a(view2, rectF2);
                            int n2 = j2.a & 7;
                            if (n2 == 1) break block0;
                            if (n2 == 3) break block1;
                            if (n2 == 5) break block2;
                            f2 = 0.0f;
                            break block3;
                        }
                        f2 = rectF2.right;
                        f3 = rectF.right;
                        break block4;
                    }
                    f2 = rectF2.left;
                    f3 = rectF.left;
                    break block4;
                }
                f2 = rectF2.centerX();
                f3 = rectF.centerX();
            }
            f2 -= f3;
        }
        return f2 + j2.b;
    }

    private float a(a object, i i2, float f2, float f3) {
        long l2 = i2.a();
        long l3 = i2.b();
        object = ((a)object).a.b("expansion");
        float f4 = (float)(((i)object).a() + ((i)object).b() + 17L - l2) / (float)l3;
        return com.google.android.material.a.a.a(f2, f3, i2.c().getInterpolation(f4));
    }

    private Pair<i, i> a(float f2, float f3, boolean bl2, a object) {
        Object object2;
        String string2;
        float f4;
        if (f2 != 0.0f && (f4 = (f3 FCMPL 0.0f)) != false) {
            if (bl2 && f3 < 0.0f || !bl2 && f4 > 0) {
                object2 = ((a)object).a.b("translationXCurveUpwards");
                h h2 = ((a)object).a;
                string2 = "translationYCurveUpwards";
                object = object2;
                object2 = h2;
            } else {
                object2 = ((a)object).a.b("translationXCurveDownwards");
                h h3 = ((a)object).a;
                string2 = "translationYCurveDownwards";
                object = object2;
                object2 = h3;
            }
        } else {
            i i2 = ((a)object).a.b("translationXLinear");
            object2 = ((a)object).a;
            string2 = "translationYLinear";
            object = i2;
        }
        return new Pair(object, (Object)((h)object2).b(string2));
    }

    private ViewGroup a(View view) {
        View view2 = view.findViewById(a.e.mtrl_child_content_container);
        if (view2 != null) {
            return this.b(view2);
        }
        if (!(view instanceof b) && !(view instanceof com.google.android.material.transformation.a)) {
            return this.b(view);
        }
        return this.b(((ViewGroup)view).getChildAt(0));
    }

    private void a(View view, long l2, int n2, int n3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && l2 > 0L) {
            view = ViewAnimationUtils.createCircularReveal((View)view, (int)n2, (int)n3, (float)f2, (float)f2);
            view.setStartDelay(0L);
            view.setDuration(l2);
            list.add((Animator)view);
        }
    }

    private void a(View view, long l2, long l3, long l4, int n2, int n3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && (l2 += l3) < l4) {
            view = ViewAnimationUtils.createCircularReveal((View)view, (int)n2, (int)n3, (float)f2, (float)f2);
            view.setStartDelay(l2);
            view.setDuration(l4 - l2);
            list.add((Animator)view);
        }
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        int[] arrn = this.d;
        view.getLocationInWindow(arrn);
        rectF.offsetTo((float)arrn[0], (float)arrn[1]);
        rectF.offset((float)((int)(-view.getTranslationX())), (float)((int)(-view.getTranslationY())));
    }

    private void a(View view, View object, boolean bl2, a object2, List<Animator> list) {
        float f2 = this.a(view, (View)object, ((a)object2).b);
        float f3 = this.b(view, (View)object, ((a)object2).b);
        object2 = this.a(f2, f3, bl2, (a)object2);
        object = (i)((Pair)object2).first;
        object2 = (i)((Pair)object2).second;
        Property property = View.TRANSLATION_X;
        if (!bl2) {
            f2 = this.e;
        }
        property = ObjectAnimator.ofFloat((Object)view, (Property)property, (float[])new float[]{f2});
        Property property2 = View.TRANSLATION_Y;
        f2 = bl2 ? f3 : this.f;
        view = ObjectAnimator.ofFloat((Object)view, (Property)property2, (float[])new float[]{f2});
        ((i)object).a((Animator)property);
        ((i)object2).a((Animator)view);
        list.add((Animator)property);
        list.add((Animator)view);
    }

    private void a(View view, View view2, boolean bl2, boolean bl3, a a2, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (!(view2 instanceof d)) {
            return;
        }
        final d d2 = (d)view2;
        float f4 = this.c(view, view2, a2.b);
        float f5 = this.d(view, view2, a2.b);
        ((FloatingActionButton)view).a(this.a);
        float f6 = (float)this.a.width() / 2.0f;
        i i2 = a2.a.b("expansion");
        if (bl2) {
            if (!bl3) {
                d2.setRevealInfo(new d.d(f4, f5, f6));
            }
            if (bl3) {
                f6 = d2.getRevealInfo().c;
            }
            view = com.google.android.material.d.a.a(d2, f4, f5, com.google.android.material.g.a.a(f4, f5, 0.0f, 0.0f, f2, f3));
            view.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator object) {
                    object = d2.getRevealInfo();
                    object.c = Float.MAX_VALUE;
                    d2.setRevealInfo((d.d)object);
                }
            });
            this.a(view2, i2.a(), (int)f4, (int)f5, f6, list);
        } else {
            f2 = d2.getRevealInfo().c;
            view = com.google.android.material.d.a.a(d2, f4, f5, f6);
            long l2 = i2.a();
            int n2 = (int)f4;
            int n3 = (int)f5;
            this.a(view2, l2, n2, n3, f2, list);
            this.a(view2, i2.a(), i2.b(), a2.a.a(), n2, n3, f6, list);
        }
        i2.a((Animator)view);
        list.add((Animator)view);
        list2.add(com.google.android.material.d.a.a(d2));
    }

    @TargetApi(value=21)
    private void a(View view, View view2, boolean bl2, boolean bl3, a a2, List<Animator> list, List<Animator.AnimatorListener> arrf) {
        float f2 = t.n(view2) - t.n(view);
        if (bl2) {
            if (!bl3) {
                view2.setTranslationZ(-f2);
            }
            view = View.TRANSLATION_Z;
            arrf = new float[]{0.0f};
        } else {
            view = View.TRANSLATION_Z;
            arrf = new float[]{-f2};
        }
        view = ObjectAnimator.ofFloat((Object)view2, (Property)view, (float[])arrf);
        a2.a.b("elevation").a((Animator)view);
        list.add((Animator)view);
    }

    private void a(View objectAnimator, View view, boolean bl2, boolean bl3, a a2, List<Animator> list, List<Animator.AnimatorListener> objectAnimator2, RectF rectF) {
        float f2 = this.a((View)objectAnimator, view, a2.b);
        float f3 = this.b((View)objectAnimator, view, a2.b);
        objectAnimator = this.a(f2, f3, bl2, a2);
        i i2 = (i)objectAnimator.first;
        i i3 = (i)objectAnimator.second;
        if (bl2) {
            if (!bl3) {
                view.setTranslationX(-f2);
                view.setTranslationY(-f3);
            }
            objectAnimator = ObjectAnimator.ofFloat((Object)view, (Property)View.TRANSLATION_X, (float[])new float[]{0.0f});
            objectAnimator2 = ObjectAnimator.ofFloat((Object)view, (Property)View.TRANSLATION_Y, (float[])new float[]{0.0f});
            this.a(view, a2, i2, i3, -f2, -f3, 0.0f, 0.0f, rectF);
            view = objectAnimator2;
        } else {
            objectAnimator = ObjectAnimator.ofFloat((Object)view, (Property)View.TRANSLATION_X, (float[])new float[]{-f2});
            view = ObjectAnimator.ofFloat((Object)view, (Property)View.TRANSLATION_Y, (float[])new float[]{-f3});
        }
        i2.a((Animator)objectAnimator);
        i3.a((Animator)view);
        list.add((Animator)objectAnimator);
        list.add((Animator)view);
    }

    private void a(View view, a a2, i i2, i i3, float f2, float f3, float f4, float f5, RectF rectF) {
        f2 = this.a(a2, i2, f2, f4);
        f3 = this.a(a2, i3, f3, f5);
        i2 = this.a;
        view.getWindowVisibleDisplayFrame((Rect)i2);
        a2 = this.b;
        a2.set((Rect)i2);
        i2 = this.c;
        this.a(view, (RectF)i2);
        i2.offset(f2, f3);
        i2.intersect((RectF)a2);
        rectF.set((RectF)i2);
    }

    private float b(View view, View view2, j j2) {
        float f2;
        block3 : {
            float f3;
            block4 : {
                RectF rectF;
                RectF rectF2;
                block0 : {
                    block1 : {
                        block2 : {
                            rectF = this.b;
                            rectF2 = this.c;
                            this.b(view, rectF);
                            this.a(view2, rectF2);
                            int n2 = j2.a & 112;
                            if (n2 == 16) break block0;
                            if (n2 == 48) break block1;
                            if (n2 == 80) break block2;
                            f2 = 0.0f;
                            break block3;
                        }
                        f2 = rectF2.bottom;
                        f3 = rectF.bottom;
                        break block4;
                    }
                    f2 = rectF2.top;
                    f3 = rectF.top;
                    break block4;
                }
                f2 = rectF2.centerY();
                f3 = rectF.centerY();
            }
            f2 -= f3;
        }
        return f2 + j2.c;
    }

    private ViewGroup b(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup)view;
        }
        return null;
    }

    private void b(View view, RectF rectF) {
        this.a(view, rectF);
        rectF.offset(this.e, this.f);
    }

    private void b(View objectAnimator, final View view, boolean bl2, boolean bl3, a a2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (view instanceof d) {
            int[] arrn;
            if (!(objectAnimator instanceof ImageView)) {
                return;
            }
            final d d2 = (d)view;
            final Drawable drawable2 = ((ImageView)objectAnimator).getDrawable();
            if (drawable2 == null) {
                return;
            }
            drawable2.mutate();
            if (bl2) {
                if (!bl3) {
                    drawable2.setAlpha(255);
                }
                objectAnimator = e.a;
                arrn = new int[]{0};
            } else {
                objectAnimator = e.a;
                arrn = new int[]{255};
            }
            objectAnimator = ObjectAnimator.ofInt((Object)drawable2, objectAnimator, (int[])arrn);
            objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.invalidate();
                }
            });
            a2.a.b("iconFade").a((Animator)objectAnimator);
            list.add((Animator)objectAnimator);
            list2.add((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    d2.setCircularRevealOverlayDrawable(null);
                }

                public void onAnimationStart(Animator animator) {
                    d2.setCircularRevealOverlayDrawable(drawable2);
                }
            });
        }
    }

    private float c(View view, View view2, j j2) {
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        this.b(view, rectF);
        this.a(view2, rectF2);
        rectF2.offset(-this.a(view, view2, j2), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private int c(View view) {
        ColorStateList colorStateList = t.u(view);
        if (colorStateList != null) {
            return colorStateList.getColorForState(view.getDrawableState(), colorStateList.getDefaultColor());
        }
        return 0;
    }

    private void c(View view, View object, boolean bl2, boolean bl3, a a2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (!(object instanceof d)) {
            return;
        }
        object = (d)object;
        int n2 = this.c(view);
        if (bl2) {
            if (!bl3) {
                object.setCircularRevealScrimColor(n2);
            }
            view = ObjectAnimator.ofInt((Object)object, d.c.a, (int[])new int[]{16777215 & n2});
        } else {
            view = ObjectAnimator.ofInt((Object)object, d.c.a, (int[])new int[]{n2});
        }
        view.setEvaluator((TypeEvaluator)com.google.android.material.a.c.a());
        a2.a.b("color").a((Animator)view);
        list.add((Animator)view);
    }

    private float d(View view, View view2, j j2) {
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        this.b(view, rectF);
        this.a(view2, rectF2);
        rectF2.offset(0.0f, -this.b(view, view2, j2));
        return rectF.centerY() - rectF2.top;
    }

    private void d(View view, View view2, boolean bl2, boolean bl3, a a2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        if (view2 instanceof d && c.a == 0) {
            return;
        }
        view = this.a(view2);
        if (view == null) {
            return;
        }
        if (bl2) {
            if (!bl3) {
                com.google.android.material.a.d.a.set((Object)view, (Object)Float.valueOf(0.0f));
            }
            view = ObjectAnimator.ofFloat((Object)view, com.google.android.material.a.d.a, (float[])new float[]{1.0f});
        } else {
            view = ObjectAnimator.ofFloat((Object)view, com.google.android.material.a.d.a, (float[])new float[]{0.0f});
        }
        a2.a.b("contentFade").a((Animator)view);
        list.add((Animator)view);
    }

    protected abstract a a(Context var1, boolean var2);

    @Override
    public void a(CoordinatorLayout.e e2) {
        if (e2.h == 0) {
            e2.h = 80;
        }
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        block2 : {
            boolean bl2;
            block3 : {
                block4 : {
                    boolean bl3;
                    if (view.getVisibility() == 8) break block2;
                    boolean bl4 = view2 instanceof FloatingActionButton;
                    bl2 = bl3 = false;
                    if (!bl4) break block3;
                    int n2 = ((FloatingActionButton)view2).getExpandedComponentIdHint();
                    if (n2 == 0) break block4;
                    bl2 = bl3;
                    if (n2 != view.getId()) break block3;
                }
                bl2 = true;
            }
            return bl2;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override
    protected AnimatorSet b(final View view, final View view2, final boolean bl2, boolean bl3) {
        a a2 = this.a(view2.getContext(), bl2);
        if (bl2) {
            this.e = view.getTranslationX();
            this.f = view.getTranslationY();
        }
        ArrayList<Animator> arrayList = new ArrayList<Animator>();
        ArrayList<Animator.AnimatorListener> arrayList2 = new ArrayList<Animator.AnimatorListener>();
        if (Build.VERSION.SDK_INT >= 21) {
            this.a(view, view2, bl2, bl3, a2, arrayList, arrayList2);
        }
        RectF rectF = this.b;
        this.a(view, view2, bl2, bl3, a2, arrayList, arrayList2, rectF);
        float f2 = rectF.width();
        float f3 = rectF.height();
        this.a(view, view2, bl2, a2, arrayList);
        this.b(view, view2, bl2, bl3, a2, arrayList, arrayList2);
        this.a(view, view2, bl2, bl3, a2, f2, f3, arrayList, arrayList2);
        this.c(view, view2, bl2, bl3, a2, arrayList, arrayList2);
        this.d(view, view2, bl2, bl3, a2, arrayList, arrayList2);
        a2 = new AnimatorSet();
        com.google.android.material.a.b.a((AnimatorSet)a2, arrayList);
        a2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                if (!bl2) {
                    view2.setVisibility(4);
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (bl2) {
                    view2.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }
        });
        int n2 = arrayList2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            a2.addListener((Animator.AnimatorListener)arrayList2.get(i2));
        }
        return a2;
    }

    protected static class a {
        public h a;
        public j b;

        protected a() {
        }
    }

}

