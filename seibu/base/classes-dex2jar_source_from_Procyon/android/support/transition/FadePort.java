// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import android.animation.Animator$AnimatorListener;
import android.util.Log;
import android.animation.ObjectAnimator;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class FadePort extends VisibilityPort
{
    private static boolean DBG = false;
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_SCREEN_X = "android:fade:screenX";
    private static final String PROPNAME_SCREEN_Y = "android:fade:screenY";
    private int mFadingMode;
    
    static {
        FadePort.DBG = false;
    }
    
    public FadePort() {
        this(3);
    }
    
    public FadePort(final int mFadingMode) {
        this.mFadingMode = mFadingMode;
    }
    
    private void captureValues(final TransitionValues transitionValues) {
        final int[] array = new int[2];
        transitionValues.view.getLocationOnScreen(array);
        transitionValues.values.put("android:fade:screenX", array[0]);
        transitionValues.values.put("android:fade:screenY", array[1]);
    }
    
    private Animator createAnimation(final View view, final float n, final float n2, final AnimatorListenerAdapter animatorListenerAdapter) {
        final Animator animator = null;
        Object o;
        if (n == n2) {
            o = animator;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd((Animator)null);
                o = animator;
            }
        }
        else {
            final ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object)view, "alpha", new float[] { n, n2 });
            if (FadePort.DBG) {
                Log.d("Fade", "Created animator " + ofFloat);
            }
            o = ofFloat;
            if (animatorListenerAdapter != null) {
                ofFloat.addListener((Animator$AnimatorListener)animatorListenerAdapter);
                return (Animator)ofFloat;
            }
        }
        return (Animator)o;
    }
    
    @Override
    public void captureStartValues(final TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        this.captureValues(transitionValues);
    }
    
    @Override
    public Animator onAppear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int i, final TransitionValues transitionValues2, final int j) {
        if ((this.mFadingMode & 0x1) != 0x1 || transitionValues2 == null) {
            return null;
        }
        final View view = transitionValues2.view;
        if (FadePort.DBG) {
            View view2;
            if (transitionValues != null) {
                view2 = transitionValues.view;
            }
            else {
                view2 = null;
            }
            Log.d("Fade", "Fade.onAppear: startView, startVis, endView, endVis = " + view2 + ", " + i + ", " + view + ", " + j);
        }
        view.setAlpha(0.0f);
        this.addListener((TransitionListener)new TransitionListenerAdapter() {
            boolean mCanceled = false;
            float mPausedAlpha;
            
            @Override
            public void onTransitionCancel(final TransitionPort transitionPort) {
                view.setAlpha(1.0f);
                this.mCanceled = true;
            }
            
            @Override
            public void onTransitionEnd(final TransitionPort transitionPort) {
                if (!this.mCanceled) {
                    view.setAlpha(1.0f);
                }
            }
            
            @Override
            public void onTransitionPause(final TransitionPort transitionPort) {
                this.mPausedAlpha = view.getAlpha();
                view.setAlpha(1.0f);
            }
            
            @Override
            public void onTransitionResume(final TransitionPort transitionPort) {
                view.setAlpha(this.mPausedAlpha);
            }
        });
        return this.createAnimation(view, 0.0f, 1.0f, null);
    }
    
    @Override
    public Animator onDisappear(final ViewGroup viewGroup, final TransitionValues transitionValues, int i, final TransitionValues transitionValues2, final int j) {
        if ((this.mFadingMode & 0x2) != 0x2) {
            return null;
        }
        final View view = null;
        View view2;
        if (transitionValues != null) {
            view2 = transitionValues.view;
        }
        else {
            view2 = null;
        }
        View view3;
        if (transitionValues2 != null) {
            view3 = transitionValues2.view;
        }
        else {
            view3 = null;
        }
        if (FadePort.DBG) {
            Log.d("Fade", "Fade.onDisappear: startView, startVis, endView, endVis = " + view2 + ", " + i + ", " + view3 + ", " + j);
        }
        final View view4 = null;
        final View view5 = null;
        View view6;
        View view7;
        if (view3 == null || view3.getParent() == null) {
            if (view3 != null) {
                view6 = view3;
                view7 = view5;
            }
            else {
                view6 = view4;
                view3 = view;
                view7 = view5;
                if (view2 != null) {
                    if (view2.getParent() == null) {
                        view6 = view2;
                        view3 = view2;
                        view7 = view5;
                    }
                    else {
                        view6 = view4;
                        view3 = view;
                        view7 = view5;
                        if (view2.getParent() instanceof View) {
                            view6 = view4;
                            view3 = view;
                            view7 = view5;
                            if (view2.getParent().getParent() == null) {
                                i = ((View)view2.getParent()).getId();
                                view6 = view4;
                                view3 = view;
                                view7 = view5;
                                if (i != -1) {
                                    view6 = view4;
                                    view3 = view;
                                    view7 = view5;
                                    if (viewGroup.findViewById(i) != null) {
                                        view6 = view4;
                                        view3 = view;
                                        view7 = view5;
                                        if (this.mCanRemoveViews) {
                                            view6 = view2;
                                            view3 = view2;
                                            view7 = view5;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else if (j == 4) {
            view7 = view3;
            view6 = view4;
        }
        else if (view2 == view3) {
            view7 = view3;
            view6 = view4;
        }
        else {
            view3 = (view6 = view2);
            view7 = view5;
        }
        if (view6 != null) {
            i = transitionValues.values.get("android:fade:screenX");
            final int intValue = transitionValues.values.get("android:fade:screenY");
            final int[] array = new int[2];
            viewGroup.getLocationOnScreen(array);
            ViewCompat.offsetLeftAndRight(view6, i - array[0] - view6.getLeft());
            ViewCompat.offsetTopAndBottom(view6, intValue - array[1] - view6.getTop());
            ViewGroupOverlay.createFrom(viewGroup).add(view6);
            return this.createAnimation(view3, 1.0f, 0.0f, new AnimatorListenerAdapter() {
                public void onAnimationEnd(final Animator animator) {
                    view3.setAlpha(1.0f);
                    if (view7 != null) {
                        view7.setVisibility(j);
                    }
                    if (view6 != null) {
                        ViewGroupOverlay.createFrom(viewGroup).remove(view6);
                    }
                }
            });
        }
        if (view7 != null) {
            view7.setVisibility(0);
            return this.createAnimation(view3, 1.0f, 0.0f, new AnimatorListenerAdapter() {
                boolean mCanceled = false;
                float mPausedAlpha = -1.0f;
                
                public void onAnimationCancel(final Animator animator) {
                    this.mCanceled = true;
                    if (this.mPausedAlpha >= 0.0f) {
                        view3.setAlpha(this.mPausedAlpha);
                    }
                }
                
                public void onAnimationEnd(final Animator animator) {
                    if (!this.mCanceled) {
                        view3.setAlpha(1.0f);
                    }
                    if (view7 != null && !this.mCanceled) {
                        view7.setVisibility(j);
                    }
                    if (view6 != null) {
                        ViewGroupOverlay.createFrom(viewGroup).add(view6);
                    }
                }
            });
        }
        return null;
    }
}
