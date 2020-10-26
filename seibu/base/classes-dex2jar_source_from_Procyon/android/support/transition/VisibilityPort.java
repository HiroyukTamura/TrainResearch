// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.view.View;
import android.animation.Animator;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
abstract class VisibilityPort extends TransitionPort
{
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties;
    
    static {
        sTransitionProperties = new String[] { "android:visibility:visibility", "android:visibility:parent" };
    }
    
    private void captureValues(final TransitionValues transitionValues) {
        transitionValues.values.put("android:visibility:visibility", transitionValues.view.getVisibility());
        transitionValues.values.put("android:visibility:parent", transitionValues.view.getParent());
    }
    
    private VisibilityInfo getVisibilityChangeInfo(final TransitionValues transitionValues, final TransitionValues transitionValues2) {
        final VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.visibilityChange = false;
        visibilityInfo.fadeIn = false;
        if (transitionValues != null) {
            visibilityInfo.startVisibility = transitionValues.values.get("android:visibility:visibility");
            visibilityInfo.startParent = transitionValues.values.get("android:visibility:parent");
        }
        else {
            visibilityInfo.startVisibility = -1;
            visibilityInfo.startParent = null;
        }
        if (transitionValues2 != null) {
            visibilityInfo.endVisibility = transitionValues2.values.get("android:visibility:visibility");
            visibilityInfo.endParent = transitionValues2.values.get("android:visibility:parent");
        }
        else {
            visibilityInfo.endVisibility = -1;
            visibilityInfo.endParent = null;
        }
        Label_0190: {
            if (transitionValues == null || transitionValues2 == null) {
                break Label_0190;
            }
            if (visibilityInfo.startVisibility != visibilityInfo.endVisibility || visibilityInfo.startParent != visibilityInfo.endParent) {
                if (visibilityInfo.startVisibility != visibilityInfo.endVisibility) {
                    if (visibilityInfo.startVisibility == 0) {
                        visibilityInfo.fadeIn = false;
                        visibilityInfo.visibilityChange = true;
                        break Label_0190;
                    }
                    if (visibilityInfo.endVisibility == 0) {
                        visibilityInfo.fadeIn = true;
                        visibilityInfo.visibilityChange = true;
                    }
                    break Label_0190;
                }
                else {
                    if (visibilityInfo.startParent == visibilityInfo.endParent) {
                        break Label_0190;
                    }
                    if (visibilityInfo.endParent == null) {
                        visibilityInfo.fadeIn = false;
                        visibilityInfo.visibilityChange = true;
                        break Label_0190;
                    }
                    if (visibilityInfo.startParent == null) {
                        visibilityInfo.fadeIn = true;
                        visibilityInfo.visibilityChange = true;
                    }
                    break Label_0190;
                }
            }
            return visibilityInfo;
        }
        if (transitionValues == null) {
            visibilityInfo.fadeIn = true;
            visibilityInfo.visibilityChange = true;
            return visibilityInfo;
        }
        if (transitionValues2 == null) {
            visibilityInfo.fadeIn = false;
            visibilityInfo.visibilityChange = true;
            return visibilityInfo;
        }
        return visibilityInfo;
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
        int id = -1;
        final Animator animator = null;
        final VisibilityInfo visibilityChangeInfo = this.getVisibilityChangeInfo(transitionValues, transitionValues2);
        Animator onAppear = animator;
        if (visibilityChangeInfo.visibilityChange) {
            boolean b = false;
            if (this.mTargets.size() > 0 || this.mTargetIds.size() > 0) {
                View view;
                if (transitionValues != null) {
                    view = transitionValues.view;
                }
                else {
                    view = null;
                }
                View view2;
                if (transitionValues2 != null) {
                    view2 = transitionValues2.view;
                }
                else {
                    view2 = null;
                }
                int id2;
                if (view != null) {
                    id2 = view.getId();
                }
                else {
                    id2 = -1;
                }
                if (view2 != null) {
                    id = view2.getId();
                }
                if (this.isValidTarget(view, id2) || this.isValidTarget(view2, id)) {
                    b = true;
                }
                else {
                    b = false;
                }
            }
            if (!b && visibilityChangeInfo.startParent == null) {
                onAppear = animator;
                if (visibilityChangeInfo.endParent == null) {
                    return onAppear;
                }
            }
            if (!visibilityChangeInfo.fadeIn) {
                return this.onDisappear(viewGroup, transitionValues, visibilityChangeInfo.startVisibility, transitionValues2, visibilityChangeInfo.endVisibility);
            }
            onAppear = this.onAppear(viewGroup, transitionValues, visibilityChangeInfo.startVisibility, transitionValues2, visibilityChangeInfo.endVisibility);
        }
        return onAppear;
    }
    
    @Override
    public String[] getTransitionProperties() {
        return VisibilityPort.sTransitionProperties;
    }
    
    public boolean isVisible(final TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        final int intValue = transitionValues.values.get("android:visibility:visibility");
        final View view = transitionValues.values.get("android:visibility:parent");
        return intValue == 0 && view != null;
    }
    
    public Animator onAppear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return null;
    }
    
    public Animator onDisappear(final ViewGroup viewGroup, final TransitionValues transitionValues, final int n, final TransitionValues transitionValues2, final int n2) {
        return null;
    }
    
    private static class VisibilityInfo
    {
        ViewGroup endParent;
        int endVisibility;
        boolean fadeIn;
        ViewGroup startParent;
        int startVisibility;
        boolean visibilityChange;
        
        VisibilityInfo() {
        }
    }
}
