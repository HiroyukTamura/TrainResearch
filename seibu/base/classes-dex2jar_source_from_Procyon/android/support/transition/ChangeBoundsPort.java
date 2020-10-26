// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import java.util.Map;
import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.Animator;
import android.view.ViewGroup;
import android.view.View;
import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class ChangeBoundsPort extends TransitionPort
{
    private static final String LOG_TAG = "ChangeBounds";
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties;
    boolean mReparent;
    boolean mResizeClip;
    int[] tempLocation;
    
    static {
        sTransitionProperties = new String[] { "android:changeBounds:bounds", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
        ChangeBoundsPort.sRectEvaluator = new RectEvaluator();
    }
    
    ChangeBoundsPort() {
        this.tempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }
    
    private void captureValues(final TransitionValues transitionValues) {
        final View view = transitionValues.view;
        transitionValues.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put("android:changeBounds:parent", transitionValues.view.getParent());
        transitionValues.view.getLocationInWindow(this.tempLocation);
        transitionValues.values.put("android:changeBounds:windowX", this.tempLocation[0]);
        transitionValues.values.put("android:changeBounds:windowY", this.tempLocation[1]);
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
    public Animator createAnimator(ViewGroup viewGroup, final TransitionValues transitionValues, final TransitionValues transitionValues2) {
        Object ofPropertyValuesHolder;
        if (transitionValues == null || transitionValues2 == null) {
            ofPropertyValuesHolder = null;
        }
        else {
            final Map<String, Object> values = transitionValues.values;
            final Map<String, Object> values2 = transitionValues2.values;
            final ViewGroup viewGroup2 = values.get("android:changeBounds:parent");
            final ViewGroup viewGroup3 = values2.get("android:changeBounds:parent");
            if (viewGroup2 == null || viewGroup3 == null) {
                return null;
            }
            final View view = transitionValues2.view;
            boolean b;
            if (viewGroup2 == viewGroup3 || viewGroup2.getId() == viewGroup3.getId()) {
                b = true;
            }
            else {
                b = false;
            }
            if (!this.mReparent || b) {
                final Rect rect = transitionValues.values.get("android:changeBounds:bounds");
                final Rect rect2 = transitionValues2.values.get("android:changeBounds:bounds");
                final int left = rect.left;
                final int left2 = rect2.left;
                final int top = rect.top;
                final int top2 = rect2.top;
                final int right = rect.right;
                final int right2 = rect2.right;
                final int bottom = rect.bottom;
                final int bottom2 = rect2.bottom;
                final int a = right - left;
                final int a2 = bottom - top;
                final int b2 = right2 - left2;
                final int b3 = bottom2 - top2;
                final int n = 0;
                int n2 = 0;
                int n3 = n;
                if (a != 0) {
                    n3 = n;
                    if (a2 != 0) {
                        n3 = n;
                        if (b2 != 0) {
                            n3 = n;
                            if (b3 != 0) {
                                if (left != left2) {
                                    n2 = 0 + 1;
                                }
                                int n4 = n2;
                                if (top != top2) {
                                    n4 = n2 + 1;
                                }
                                int n5 = n4;
                                if (right != right2) {
                                    n5 = n4 + 1;
                                }
                                n3 = n5;
                                if (bottom != bottom2) {
                                    n3 = n5 + 1;
                                }
                            }
                        }
                    }
                }
                if (n3 > 0) {
                    if (this.mResizeClip) {
                        if (a != b2) {
                            view.setRight(Math.max(a, b2) + left2);
                        }
                        if (a2 != b3) {
                            view.setBottom(Math.max(a2, b3) + top2);
                        }
                        if (left != left2) {
                            view.setTranslationX((float)(left - left2));
                        }
                        if (top != top2) {
                            view.setTranslationY((float)(top - top2));
                        }
                        final float n6 = (float)(left2 - left);
                        final float n7 = (float)(top2 - top);
                        final int n8 = b2 - a;
                        final int n9 = b3 - a2;
                        int n10 = 0;
                        if (n6 != 0.0f) {
                            n10 = 0 + 1;
                        }
                        int n11 = n10;
                        if (n7 != 0.0f) {
                            n11 = n10 + 1;
                        }
                        int n12 = 0;
                        Label_0742: {
                            if (n8 == 0) {
                                n12 = n11;
                                if (n9 == 0) {
                                    break Label_0742;
                                }
                            }
                            n12 = n11 + 1;
                        }
                        final PropertyValuesHolder[] array = new PropertyValuesHolder[n12];
                        int n13;
                        if (n6 != 0.0f) {
                            n13 = 0 + 1;
                            array[0] = PropertyValuesHolder.ofFloat("translationX", new float[] { view.getTranslationX(), 0.0f });
                        }
                        else {
                            n13 = 0;
                        }
                        if (n7 != 0.0f) {
                            array[n13] = PropertyValuesHolder.ofFloat("translationY", new float[] { view.getTranslationY(), 0.0f });
                        }
                        if (n8 != 0 || n9 != 0) {
                            new Rect(0, 0, a, a2);
                            new Rect(0, 0, b2, b3);
                        }
                        final ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder((Object)view, array);
                        if (view.getParent() instanceof ViewGroup) {
                            final ViewGroup viewGroup4 = (ViewGroup)view.getParent();
                            this.addListener((TransitionListener)new TransitionListenerAdapter() {
                                boolean mCanceled = false;
                                
                                @Override
                                public void onTransitionCancel(final TransitionPort transitionPort) {
                                    this.mCanceled = true;
                                }
                                
                                @Override
                                public void onTransitionEnd(final TransitionPort transitionPort) {
                                    if (!this.mCanceled) {}
                                }
                                
                                @Override
                                public void onTransitionPause(final TransitionPort transitionPort) {
                                }
                                
                                @Override
                                public void onTransitionResume(final TransitionPort transitionPort) {
                                }
                            });
                        }
                        ofPropertyValuesHolder2.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter() {
                            public void onAnimationEnd(final Animator animator) {
                            }
                        });
                        return (Animator)ofPropertyValuesHolder2;
                    }
                    final PropertyValuesHolder[] array2 = new PropertyValuesHolder[n3];
                    if (left != left2) {
                        view.setLeft(left);
                    }
                    if (top != top2) {
                        view.setTop(top);
                    }
                    if (right != right2) {
                        view.setRight(right);
                    }
                    if (bottom != bottom2) {
                        view.setBottom(bottom);
                    }
                    int n14;
                    if (left != left2) {
                        n14 = 0 + 1;
                        array2[0] = PropertyValuesHolder.ofInt("left", new int[] { left, left2 });
                    }
                    else {
                        n14 = 0;
                    }
                    int n15 = n14;
                    if (top != top2) {
                        array2[n14] = PropertyValuesHolder.ofInt("top", new int[] { top, top2 });
                        n15 = n14 + 1;
                    }
                    int n16 = n15;
                    if (right != right2) {
                        array2[n15] = PropertyValuesHolder.ofInt("right", new int[] { right, right2 });
                        n16 = n15 + 1;
                    }
                    if (bottom != bottom2) {
                        array2[n16] = PropertyValuesHolder.ofInt("bottom", new int[] { bottom, bottom2 });
                    }
                    final ObjectAnimator objectAnimator = (ObjectAnimator)(ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((Object)view, array2));
                    if (view.getParent() instanceof ViewGroup) {
                        viewGroup = (ViewGroup)view.getParent();
                        this.addListener((TransitionListener)new TransitionListenerAdapter() {
                            boolean mCanceled = false;
                            
                            @Override
                            public void onTransitionCancel(final TransitionPort transitionPort) {
                                this.mCanceled = true;
                            }
                            
                            @Override
                            public void onTransitionEnd(final TransitionPort transitionPort) {
                                if (!this.mCanceled) {}
                            }
                            
                            @Override
                            public void onTransitionPause(final TransitionPort transitionPort) {
                            }
                            
                            @Override
                            public void onTransitionResume(final TransitionPort transitionPort) {
                            }
                        });
                        return (Animator)objectAnimator;
                    }
                    return (Animator)ofPropertyValuesHolder;
                }
            }
            else {
                final int intValue = transitionValues.values.get("android:changeBounds:windowX");
                final int intValue2 = transitionValues.values.get("android:changeBounds:windowY");
                final int intValue3 = transitionValues2.values.get("android:changeBounds:windowX");
                final int intValue4 = transitionValues2.values.get("android:changeBounds:windowY");
                if (intValue != intValue3 || intValue2 != intValue4) {
                    viewGroup.getLocationInWindow(this.tempLocation);
                    final Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap$Config.ARGB_8888);
                    view.draw(new Canvas(bitmap));
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    view.setVisibility(4);
                    ViewOverlay.createFrom((View)viewGroup).add((Drawable)bitmapDrawable);
                    final ObjectAnimator ofObject = ObjectAnimator.ofObject((Object)bitmapDrawable, "bounds", (TypeEvaluator)ChangeBoundsPort.sRectEvaluator, new Object[] { new Rect(intValue - this.tempLocation[0], intValue2 - this.tempLocation[1], intValue - this.tempLocation[0] + view.getWidth(), intValue2 - this.tempLocation[1] + view.getHeight()), new Rect(intValue3 - this.tempLocation[0], intValue4 - this.tempLocation[1], intValue3 - this.tempLocation[0] + view.getWidth(), intValue4 - this.tempLocation[1] + view.getHeight()) });
                    ofObject.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter() {
                        public void onAnimationEnd(final Animator animator) {
                            ViewOverlay.createFrom((View)viewGroup).remove((Drawable)bitmapDrawable);
                            view.setVisibility(0);
                        }
                    });
                    return (Animator)ofObject;
                }
            }
            return null;
        }
        return (Animator)ofPropertyValuesHolder;
    }
    
    @Override
    public String[] getTransitionProperties() {
        return ChangeBoundsPort.sTransitionProperties;
    }
    
    public void setReparent(final boolean mReparent) {
        this.mReparent = mReparent;
    }
    
    public void setResizeClip(final boolean mResizeClip) {
        this.mResizeClip = mResizeClip;
    }
}
