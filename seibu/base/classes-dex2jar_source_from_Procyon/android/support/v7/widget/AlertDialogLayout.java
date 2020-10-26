// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.R;
import android.view.ViewGroup;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View$MeasureSpec;
import android.util.AttributeSet;
import android.support.annotation.Nullable;
import android.content.Context;
import android.support.annotation.RestrictTo;

@RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
public class AlertDialogLayout extends LinearLayoutCompat
{
    public AlertDialogLayout(@Nullable final Context context) {
        super(context);
    }
    
    public AlertDialogLayout(@Nullable final Context context, @Nullable final AttributeSet set) {
        super(context, set);
    }
    
    private void forceUniformWidth(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                if (layoutParams.width == -1) {
                    final int height = layoutParams.height;
                    layoutParams.height = child.getMeasuredHeight();
                    this.measureChildWithMargins(child, measureSpec, 0, n2, 0);
                    layoutParams.height = height;
                }
            }
        }
    }
    
    private static int resolveMinimumHeight(final View view) {
        final int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }
    
    private void setChildFrame(final View view, final int n, final int n2, final int n3, final int n4) {
        view.layout(n, n2, n + n3, n2 + n4);
    }
    
    private boolean tryOnMeasure(final int n, final int n2) {
        View view = null;
        View view2 = null;
        View view3 = null;
        final int childCount = this.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final int id = child.getId();
                if (id == R.id.topPanel) {
                    view = child;
                }
                else if (id == R.id.buttonPanel) {
                    view2 = child;
                }
                else {
                    if (id != R.id.contentPanel && id != R.id.customPanel) {
                        return false;
                    }
                    if (view3 != null) {
                        return false;
                    }
                    view3 = child;
                }
            }
        }
        final int mode = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n2);
        final int mode2 = View$MeasureSpec.getMode(n);
        int combineMeasuredStates = 0;
        int n4;
        final int n3 = n4 = this.getPaddingTop() + this.getPaddingBottom();
        if (view != null) {
            view.measure(n, 0);
            n4 = n3 + view.getMeasuredHeight();
            combineMeasuredStates = ViewCompat.combineMeasuredStates(0, ViewCompat.getMeasuredState(view));
        }
        int resolveMinimumHeight = 0;
        int b = 0;
        int combineMeasuredStates2 = combineMeasuredStates;
        int n5 = n4;
        if (view2 != null) {
            view2.measure(n, 0);
            resolveMinimumHeight = resolveMinimumHeight(view2);
            b = view2.getMeasuredHeight() - resolveMinimumHeight;
            n5 = n4 + resolveMinimumHeight;
            combineMeasuredStates2 = ViewCompat.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(view2));
        }
        int measuredHeight = 0;
        int combineMeasuredStates3 = combineMeasuredStates2;
        int n6 = n5;
        if (view3 != null) {
            int measureSpec;
            if (mode == 0) {
                measureSpec = 0;
            }
            else {
                measureSpec = View$MeasureSpec.makeMeasureSpec(Math.max(0, size - n5), mode);
            }
            view3.measure(n, measureSpec);
            measuredHeight = view3.getMeasuredHeight();
            n6 = n5 + measuredHeight;
            combineMeasuredStates3 = ViewCompat.combineMeasuredStates(combineMeasuredStates2, ViewCompat.getMeasuredState(view3));
        }
        final int a = size - n6;
        int n7 = combineMeasuredStates3;
        int n8 = a;
        int n9 = n6;
        if (view2 != null) {
            final int min = Math.min(a, b);
            int n10 = resolveMinimumHeight;
            int n11 = a;
            if (min > 0) {
                n11 = a - min;
                n10 = resolveMinimumHeight + min;
            }
            view2.measure(n, View$MeasureSpec.makeMeasureSpec(n10, 1073741824));
            n9 = n6 - resolveMinimumHeight + view2.getMeasuredHeight();
            final int combineMeasuredStates4 = ViewCompat.combineMeasuredStates(combineMeasuredStates3, ViewCompat.getMeasuredState(view2));
            n8 = n11;
            n7 = combineMeasuredStates4;
        }
        int combineMeasuredStates5 = n7;
        int n12 = n9;
        if (view3 != null) {
            combineMeasuredStates5 = n7;
            n12 = n9;
            if (n8 > 0) {
                view3.measure(n, View$MeasureSpec.makeMeasureSpec(measuredHeight + n8, mode));
                n12 = n9 - measuredHeight + view3.getMeasuredHeight();
                combineMeasuredStates5 = ViewCompat.combineMeasuredStates(n7, ViewCompat.getMeasuredState(view3));
            }
        }
        int a2 = 0;
        int max;
        for (int j = 0; j < childCount; ++j, a2 = max) {
            final View child2 = this.getChildAt(j);
            max = a2;
            if (child2.getVisibility() != 8) {
                max = Math.max(a2, child2.getMeasuredWidth());
            }
        }
        this.setMeasuredDimension(ViewCompat.resolveSizeAndState(a2 + (this.getPaddingLeft() + this.getPaddingRight()), n, combineMeasuredStates5), ViewCompat.resolveSizeAndState(n12, n2, 0));
        if (mode2 != 1073741824) {
            this.forceUniformWidth(childCount, n2);
        }
        return true;
    }
    
    @Override
    protected void onLayout(final boolean b, int n, int gravity, int intrinsicHeight, int i) {
        final int paddingLeft = this.getPaddingLeft();
        final int n2 = intrinsicHeight - n;
        final int paddingRight = this.getPaddingRight();
        final int paddingRight2 = this.getPaddingRight();
        n = this.getMeasuredHeight();
        final int childCount = this.getChildCount();
        final int gravity2 = this.getGravity();
        switch (gravity2 & 0x70) {
            default: {
                n = this.getPaddingTop();
                break;
            }
            case 80: {
                n = this.getPaddingTop() + i - gravity - n;
                break;
            }
            case 16: {
                n = this.getPaddingTop() + (i - gravity - n) / 2;
                break;
            }
        }
        final Drawable dividerDrawable = this.getDividerDrawable();
        if (dividerDrawable == null) {
            intrinsicHeight = 0;
        }
        else {
            intrinsicHeight = dividerDrawable.getIntrinsicHeight();
        }
        View child;
        int measuredWidth;
        int measuredHeight;
        LayoutParams layoutParams;
        int n3;
        for (i = 0; i < childCount; ++i, n = gravity) {
            child = this.getChildAt(i);
            gravity = n;
            if (child != null) {
                gravity = n;
                if (child.getVisibility() != 8) {
                    measuredWidth = child.getMeasuredWidth();
                    measuredHeight = child.getMeasuredHeight();
                    layoutParams = (LayoutParams)child.getLayoutParams();
                    if ((gravity = layoutParams.gravity) < 0) {
                        gravity = (gravity2 & 0x800007);
                    }
                    switch (GravityCompat.getAbsoluteGravity(gravity, ViewCompat.getLayoutDirection((View)this)) & 0x7) {
                        default: {
                            gravity = paddingLeft + layoutParams.leftMargin;
                            break;
                        }
                        case 1: {
                            gravity = (n2 - paddingLeft - paddingRight2 - measuredWidth) / 2 + paddingLeft + layoutParams.leftMargin - layoutParams.rightMargin;
                            break;
                        }
                        case 5: {
                            gravity = n2 - paddingRight - measuredWidth - layoutParams.rightMargin;
                            break;
                        }
                    }
                    n3 = n;
                    if (this.hasDividerBeforeChildAt(i)) {
                        n3 = n + intrinsicHeight;
                    }
                    n = n3 + layoutParams.topMargin;
                    this.setChildFrame(child, gravity, n, measuredWidth, measuredHeight);
                    gravity = n + (layoutParams.bottomMargin + measuredHeight);
                }
            }
        }
    }
    
    @Override
    protected void onMeasure(final int n, final int n2) {
        if (!this.tryOnMeasure(n, n2)) {
            super.onMeasure(n, n2);
        }
    }
}
