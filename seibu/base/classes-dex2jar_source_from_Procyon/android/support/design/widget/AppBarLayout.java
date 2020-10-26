// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;
import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.support.v4.view.AbsSavedState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import android.support.annotation.VisibleForTesting;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import java.util.ArrayList;
import android.content.res.TypedArray;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.design.R;
import android.view.View;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.content.Context;
import java.util.List;
import android.support.v4.view.WindowInsetsCompat;
import android.widget.LinearLayout;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class AppBarLayout extends LinearLayout
{
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private boolean mCollapsed;
    private boolean mCollapsible;
    private int mDownPreScrollRange;
    private int mDownScrollRange;
    private boolean mHaveChildWithInterpolator;
    private WindowInsetsCompat mLastInsets;
    private List<OnOffsetChangedListener> mListeners;
    private int mPendingAction;
    private final int[] mTmpStatesArray;
    private int mTotalScrollRange;
    
    public AppBarLayout(final Context context) {
        this(context, null);
    }
    
    public AppBarLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
        this.mPendingAction = 0;
        this.mTmpStatesArray = new int[2];
        this.setOrientation(1);
        ThemeUtils.checkAppCompatTheme(context);
        if (Build$VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider((View)this);
            ViewUtilsLollipop.setStateListAnimatorFromAttrs((View)this, set, 0, R.style.Widget_Design_AppBarLayout);
        }
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        ViewCompat.setBackground((View)this, obtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            this.setExpanded(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build$VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator((View)this, (float)obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }
    
    private void invalidateScrollRanges() {
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
    }
    
    private boolean setCollapsibleState(final boolean mCollapsible) {
        if (this.mCollapsible != mCollapsible) {
            this.mCollapsible = mCollapsible;
            this.refreshDrawableState();
            return true;
        }
        return false;
    }
    
    private void setExpanded(final boolean b, final boolean b2, final boolean b3) {
        int n = 0;
        int n2;
        if (b) {
            n2 = 1;
        }
        else {
            n2 = 2;
        }
        int n3;
        if (b2) {
            n3 = 4;
        }
        else {
            n3 = 0;
        }
        if (b3) {
            n = 8;
        }
        this.mPendingAction = (n | (n3 | n2));
        this.requestLayout();
    }
    
    private void updateCollapsible() {
        final boolean b = false;
        int n = 0;
        final int childCount = this.getChildCount();
        boolean collapsibleState;
        while (true) {
            collapsibleState = b;
            if (n >= childCount) {
                break;
            }
            if (((LayoutParams)this.getChildAt(n).getLayoutParams()).isCollapsible()) {
                collapsibleState = true;
                break;
            }
            ++n;
        }
        this.setCollapsibleState(collapsibleState);
    }
    
    public void addOnOffsetChangedListener(final OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<OnOffsetChangedListener>();
        }
        if (onOffsetChangedListener != null && !this.mListeners.contains(onOffsetChangedListener)) {
            this.mListeners.add(onOffsetChangedListener);
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams;
    }
    
    void dispatchOffsetUpdates(final int n) {
        if (this.mListeners != null) {
            for (int i = 0; i < this.mListeners.size(); ++i) {
                final OnOffsetChangedListener onOffsetChangedListener = this.mListeners.get(i);
                if (onOffsetChangedListener != null) {
                    onOffsetChangedListener.onOffsetChanged(this, n);
                }
            }
        }
    }
    
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }
    
    public LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    protected LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (Build$VERSION.SDK_INT >= 19 && viewGroup$LayoutParams instanceof LinearLayout$LayoutParams) {
            return new LayoutParams((LinearLayout$LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new LayoutParams(viewGroup$LayoutParams);
    }
    
    int getDownNestedPreScrollRange() {
        if (this.mDownPreScrollRange != -1) {
            return this.mDownPreScrollRange;
        }
        int b = 0;
        int n2;
        for (int i = this.getChildCount() - 1; i >= 0; --i, b = n2) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final int measuredHeight = child.getMeasuredHeight();
            final int mScrollFlags = layoutParams.mScrollFlags;
            if ((mScrollFlags & 0x5) == 0x5) {
                final int n = b + (layoutParams.topMargin + layoutParams.bottomMargin);
                if ((mScrollFlags & 0x8) != 0x0) {
                    n2 = n + ViewCompat.getMinimumHeight(child);
                }
                else if ((mScrollFlags & 0x2) != 0x0) {
                    n2 = n + (measuredHeight - ViewCompat.getMinimumHeight(child));
                }
                else {
                    n2 = n + (measuredHeight - this.getTopInset());
                }
            }
            else if ((n2 = b) > 0) {
                break;
            }
        }
        return this.mDownPreScrollRange = Math.max(0, b);
    }
    
    int getDownNestedScrollRange() {
        if (this.mDownScrollRange != -1) {
            return this.mDownScrollRange;
        }
        int n = 0;
        int n2 = 0;
        final int childCount = this.getChildCount();
        int b;
        while (true) {
            b = n;
            if (n2 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n2);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final int measuredHeight = child.getMeasuredHeight();
            final int topMargin = layoutParams.topMargin;
            final int bottomMargin = layoutParams.bottomMargin;
            final int mScrollFlags = layoutParams.mScrollFlags;
            b = n;
            if ((mScrollFlags & 0x1) == 0x0) {
                break;
            }
            n += measuredHeight + (topMargin + bottomMargin);
            if ((mScrollFlags & 0x2) != 0x0) {
                b = n - (ViewCompat.getMinimumHeight(child) + this.getTopInset());
                break;
            }
            ++n2;
        }
        return this.mDownScrollRange = Math.max(0, b);
    }
    
    final int getMinimumHeightForVisibleOverlappingContent() {
        final int topInset = this.getTopInset();
        final int minimumHeight = ViewCompat.getMinimumHeight((View)this);
        if (minimumHeight != 0) {
            return minimumHeight * 2 + topInset;
        }
        final int childCount = this.getChildCount();
        int minimumHeight2;
        if (childCount >= 1) {
            minimumHeight2 = ViewCompat.getMinimumHeight(this.getChildAt(childCount - 1));
        }
        else {
            minimumHeight2 = 0;
        }
        if (minimumHeight2 != 0) {
            return minimumHeight2 * 2 + topInset;
        }
        return this.getHeight() / 3;
    }
    
    int getPendingAction() {
        return this.mPendingAction;
    }
    
    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }
    
    @VisibleForTesting
    final int getTopInset() {
        if (this.mLastInsets != null) {
            return this.mLastInsets.getSystemWindowInsetTop();
        }
        return 0;
    }
    
    public final int getTotalScrollRange() {
        if (this.mTotalScrollRange != -1) {
            return this.mTotalScrollRange;
        }
        int n = 0;
        int n2 = 0;
        final int childCount = this.getChildCount();
        int n3;
        while (true) {
            n3 = n;
            if (n2 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n2);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final int measuredHeight = child.getMeasuredHeight();
            final int mScrollFlags = layoutParams.mScrollFlags;
            n3 = n;
            if ((mScrollFlags & 0x1) == 0x0) {
                break;
            }
            n += layoutParams.topMargin + measuredHeight + layoutParams.bottomMargin;
            if ((mScrollFlags & 0x2) != 0x0) {
                n3 = n - ViewCompat.getMinimumHeight(child);
                break;
            }
            ++n2;
        }
        return this.mTotalScrollRange = Math.max(0, n3 - this.getTopInset());
    }
    
    int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }
    
    boolean hasChildWithInterpolator() {
        return this.mHaveChildWithInterpolator;
    }
    
    boolean hasScrollableChildren() {
        return this.getTotalScrollRange() != 0;
    }
    
    protected int[] onCreateDrawableState(int n) {
        final int[] mTmpStatesArray = this.mTmpStatesArray;
        final int[] onCreateDrawableState = super.onCreateDrawableState(mTmpStatesArray.length + n);
        if (this.mCollapsible) {
            n = R.attr.state_collapsible;
        }
        else {
            n = -R.attr.state_collapsible;
        }
        mTmpStatesArray[0] = n;
        if (this.mCollapsible && this.mCollapsed) {
            n = R.attr.state_collapsed;
        }
        else {
            n = -R.attr.state_collapsed;
        }
        mTmpStatesArray[1] = n;
        return mergeDrawableStates(onCreateDrawableState, mTmpStatesArray);
    }
    
    protected void onLayout(final boolean b, int i, int childCount, final int n, final int n2) {
        super.onLayout(b, i, childCount, n, n2);
        this.invalidateScrollRanges();
        this.mHaveChildWithInterpolator = false;
        for (i = 0, childCount = this.getChildCount(); i < childCount; ++i) {
            if (((LayoutParams)this.getChildAt(i).getLayoutParams()).getScrollInterpolator() != null) {
                this.mHaveChildWithInterpolator = true;
                break;
            }
        }
        this.updateCollapsible();
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        this.invalidateScrollRanges();
    }
    
    WindowInsetsCompat onWindowInsetChanged(final WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat mLastInsets = null;
        if (ViewCompat.getFitsSystemWindows((View)this)) {
            mLastInsets = windowInsetsCompat;
        }
        if (!ViewUtils.objectEquals(this.mLastInsets, mLastInsets)) {
            this.mLastInsets = mLastInsets;
            this.invalidateScrollRanges();
        }
        return windowInsetsCompat;
    }
    
    public void removeOnOffsetChangedListener(final OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners != null && onOffsetChangedListener != null) {
            this.mListeners.remove(onOffsetChangedListener);
        }
    }
    
    void resetPendingAction() {
        this.mPendingAction = 0;
    }
    
    boolean setCollapsedState(final boolean mCollapsed) {
        if (this.mCollapsed != mCollapsed) {
            this.mCollapsed = mCollapsed;
            this.refreshDrawableState();
            return true;
        }
        return false;
    }
    
    public void setExpanded(final boolean b) {
        this.setExpanded(b, ViewCompat.isLaidOut((View)this));
    }
    
    public void setExpanded(final boolean b, final boolean b2) {
        this.setExpanded(b, b2, true);
    }
    
    public void setOrientation(final int orientation) {
        if (orientation != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(orientation);
    }
    
    @Deprecated
    public void setTargetElevation(final float n) {
        if (Build$VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator((View)this, n);
        }
    }
    
    public static class Behavior extends HeaderBehavior<AppBarLayout>
    {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> mLastNestedScrollingChildRef;
        private ValueAnimatorCompat mOffsetAnimator;
        private int mOffsetDelta;
        private int mOffsetToChildIndexOnLayout;
        private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
        private float mOffsetToChildIndexOnLayoutPerc;
        private DragCallback mOnDragCallback;
        private boolean mSkipNestedPreScroll;
        private boolean mWasNestedFlung;
        
        public Behavior() {
            this.mOffsetToChildIndexOnLayout = -1;
        }
        
        public Behavior(final Context context, final AttributeSet set) {
            super(context, set);
            this.mOffsetToChildIndexOnLayout = -1;
        }
        
        private void animateOffsetTo(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final int n, float abs) {
            final int abs2 = Math.abs(this.getTopBottomOffsetForScrollingSibling() - n);
            abs = Math.abs(abs);
            int n2;
            if (abs > 0.0f) {
                n2 = Math.round(1000.0f * (abs2 / abs)) * 3;
            }
            else {
                n2 = (int)((1.0f + abs2 / (float)appBarLayout.getHeight()) * 150.0f);
            }
            this.animateOffsetWithDuration(coordinatorLayout, appBarLayout, n, n2);
        }
        
        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final int n, final int a) {
            final int topBottomOffsetForScrollingSibling = this.getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == n) {
                if (this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning()) {
                    this.mOffsetAnimator.cancel();
                }
                return;
            }
            if (this.mOffsetAnimator == null) {
                (this.mOffsetAnimator = ViewUtils.createAnimator()).setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.mOffsetAnimator.addUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                        Behavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, valueAnimatorCompat.getAnimatedIntValue());
                    }
                });
            }
            else {
                this.mOffsetAnimator.cancel();
            }
            this.mOffsetAnimator.setDuration(Math.min(a, 600));
            this.mOffsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, n);
            this.mOffsetAnimator.start();
        }
        
        private static boolean checkFlag(final int n, final int n2) {
            return (n & n2) == n2;
        }
        
        private static View getAppBarChildOnOffset(final AppBarLayout appBarLayout, int i) {
            final int abs = Math.abs(i);
            View child;
            for (i = 0; i < appBarLayout.getChildCount(); ++i) {
                child = appBarLayout.getChildAt(i);
                if (abs >= child.getTop() && abs <= child.getBottom()) {
                    return child;
                }
            }
            return null;
        }
        
        private int getChildIndexOnOffset(final AppBarLayout appBarLayout, final int n) {
            for (int i = 0; i < appBarLayout.getChildCount(); ++i) {
                final View child = appBarLayout.getChildAt(i);
                if (child.getTop() <= -n && child.getBottom() >= -n) {
                    return i;
                }
            }
            return -1;
        }
        
        private int interpolateOffset(final AppBarLayout appBarLayout, final int n) {
            final int abs = Math.abs(n);
            int n2 = 0;
            final int childCount = appBarLayout.getChildCount();
            int n3;
            while (true) {
                n3 = n;
                if (n2 >= childCount) {
                    break;
                }
                final View child = appBarLayout.getChildAt(n2);
                final AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)child.getLayoutParams();
                final Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs >= child.getTop() && abs <= child.getBottom()) {
                    n3 = n;
                    if (scrollInterpolator == null) {
                        break;
                    }
                    int n4 = 0;
                    final int scrollFlags = layoutParams.getScrollFlags();
                    if ((scrollFlags & 0x1) != 0x0) {
                        final int n5 = n4 = 0 + (child.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                        if ((scrollFlags & 0x2) != 0x0) {
                            n4 = n5 - ViewCompat.getMinimumHeight(child);
                        }
                    }
                    int n6 = n4;
                    if (ViewCompat.getFitsSystemWindows(child)) {
                        n6 = n4 - appBarLayout.getTopInset();
                    }
                    n3 = n;
                    if (n6 > 0) {
                        n3 = Integer.signum(n) * (child.getTop() + Math.round(n6 * scrollInterpolator.getInterpolation((abs - child.getTop()) / (float)n6)));
                        break;
                    }
                    break;
                }
                else {
                    ++n2;
                }
            }
            return n3;
        }
        
        private boolean shouldJumpElevationState(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
            final boolean b = false;
            final List<View> dependents = coordinatorLayout.getDependents((View)appBarLayout);
            int n = 0;
            final int size = dependents.size();
            boolean b2;
            while (true) {
                b2 = b;
                if (n >= size) {
                    break;
                }
                final CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)dependents.get(n).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    b2 = b;
                    if (((ScrollingViewBehavior)behavior).getOverlayTop() != 0) {
                        b2 = true;
                        break;
                    }
                    break;
                }
                else {
                    ++n;
                }
            }
            return b2;
        }
        
        private void snapToChildIfNeeded(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
            final int topBottomOffsetForScrollingSibling = this.getTopBottomOffsetForScrollingSibling();
            final int childIndexOnOffset = this.getChildIndexOnOffset(appBarLayout, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                final View child = appBarLayout.getChildAt(childIndexOnOffset);
                final int scrollFlags = ((AppBarLayout.LayoutParams)child.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 0x11) == 0x11) {
                    final int n = -child.getTop();
                    int n3;
                    final int n2 = n3 = -child.getBottom();
                    if (childIndexOnOffset == appBarLayout.getChildCount() - 1) {
                        n3 = n2 + appBarLayout.getTopInset();
                    }
                    int n4;
                    int n5;
                    if (checkFlag(scrollFlags, 2)) {
                        n4 = n3 + ViewCompat.getMinimumHeight(child);
                        n5 = n;
                    }
                    else {
                        n4 = n3;
                        n5 = n;
                        if (checkFlag(scrollFlags, 5)) {
                            n4 = n3 + ViewCompat.getMinimumHeight(child);
                            if (topBottomOffsetForScrollingSibling < n4) {
                                n5 = n4;
                                n4 = n3;
                            }
                            else {
                                n5 = n;
                            }
                        }
                    }
                    if (topBottomOffsetForScrollingSibling >= (n4 + n5) / 2) {
                        n4 = n5;
                    }
                    this.animateOffsetTo(coordinatorLayout, appBarLayout, MathUtils.constrain(n4, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }
        
        private void updateAppBarLayoutDrawableState(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final int n, final int n2, final boolean b) {
            final View appBarChildOnOffset = getAppBarChildOnOffset(appBarLayout, n);
            if (appBarChildOnOffset != null) {
                final int scrollFlags = ((AppBarLayout.LayoutParams)appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                boolean collapsedState = false;
                if ((scrollFlags & 0x1) != 0x0) {
                    final int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (n2 > 0 && (scrollFlags & 0xC) != 0x0) {
                        collapsedState = (-n >= appBarChildOnOffset.getBottom() - minimumHeight - appBarLayout.getTopInset());
                    }
                    else {
                        collapsedState = collapsedState;
                        if ((scrollFlags & 0x2) != 0x0) {
                            collapsedState = (-n >= appBarChildOnOffset.getBottom() - minimumHeight - appBarLayout.getTopInset());
                        }
                    }
                }
                final boolean setCollapsedState = appBarLayout.setCollapsedState(collapsedState);
                if (Build$VERSION.SDK_INT >= 11 && (b || (setCollapsedState && this.shouldJumpElevationState(coordinatorLayout, appBarLayout)))) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }
        
        @Override
        boolean canDragView(final AppBarLayout appBarLayout) {
            final boolean b = true;
            boolean canDrag;
            if (this.mOnDragCallback != null) {
                canDrag = this.mOnDragCallback.canDrag(appBarLayout);
            }
            else {
                canDrag = b;
                if (this.mLastNestedScrollingChildRef != null) {
                    final View view = this.mLastNestedScrollingChildRef.get();
                    if (view != null && view.isShown()) {
                        canDrag = b;
                        if (!ViewCompat.canScrollVertically(view, -1)) {
                            return canDrag;
                        }
                    }
                    return false;
                }
            }
            return canDrag;
        }
        
        @Override
        int getMaxDragOffset(final AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }
        
        @Override
        int getScrollRangeForDragFling(final AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }
        
        @Override
        int getTopBottomOffsetForScrollingSibling() {
            return this.getTopAndBottomOffset() + this.mOffsetDelta;
        }
        
        @VisibleForTesting
        boolean isOffsetAnimatorRunning() {
            return this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning();
        }
        
        @Override
        void onFlingFinished(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
            this.snapToChildIfNeeded(coordinatorLayout, appBarLayout);
        }
        
        @Override
        public boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int n) {
            final boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, n);
            final int pendingAction = appBarLayout.getPendingAction();
            if (this.mOffsetToChildIndexOnLayout >= 0 && (pendingAction & 0x8) == 0x0) {
                final View child = appBarLayout.getChildAt(this.mOffsetToChildIndexOnLayout);
                n = -child.getBottom();
                if (this.mOffsetToChildIndexOnLayoutIsMinHeight) {
                    n += ViewCompat.getMinimumHeight(child) + appBarLayout.getTopInset();
                }
                else {
                    n += Math.round(child.getHeight() * this.mOffsetToChildIndexOnLayoutPerc);
                }
                this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, n);
            }
            else if (pendingAction != 0) {
                if ((pendingAction & 0x4) != 0x0) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if ((pendingAction & 0x2) != 0x0) {
                    final int n2 = -appBarLayout.getUpNestedPreScrollRange();
                    if (n != 0) {
                        this.animateOffsetTo(coordinatorLayout, appBarLayout, n2, 0.0f);
                    }
                    else {
                        this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, n2);
                    }
                }
                else if ((pendingAction & 0x1) != 0x0) {
                    if (n != 0) {
                        this.animateOffsetTo(coordinatorLayout, appBarLayout, 0, 0.0f);
                    }
                    else {
                        this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.resetPendingAction();
            this.mOffsetToChildIndexOnLayout = -1;
            this.setTopAndBottomOffset(MathUtils.constrain(this.getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
            this.updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, this.getTopAndBottomOffset(), 0, true);
            appBarLayout.dispatchOffsetUpdates(this.getTopAndBottomOffset());
            return onLayoutChild;
        }
        
        public boolean onMeasureChild(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final int n, final int n2, final int n3, final int n4) {
            if (((CoordinatorLayout.LayoutParams)appBarLayout.getLayoutParams()).height == -2) {
                coordinatorLayout.onMeasureChild((View)appBarLayout, n, n2, View$MeasureSpec.makeMeasureSpec(0, 0), n4);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, appBarLayout, n, n2, n3, n4);
        }
        
        public boolean onNestedFling(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, final float n, final float n2, final boolean b) {
            final boolean b2 = false;
            boolean fling;
            if (!b) {
                fling = this.fling(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -n2);
            }
            else if (n2 < 0.0f) {
                final int n3 = -appBarLayout.getTotalScrollRange() + appBarLayout.getDownNestedPreScrollRange();
                fling = b2;
                if (this.getTopBottomOffsetForScrollingSibling() < n3) {
                    this.animateOffsetTo(coordinatorLayout, appBarLayout, n3, n2);
                    fling = true;
                }
            }
            else {
                final int n4 = -appBarLayout.getUpNestedPreScrollRange();
                fling = b2;
                if (this.getTopBottomOffsetForScrollingSibling() > n4) {
                    this.animateOffsetTo(coordinatorLayout, appBarLayout, n4, n2);
                    fling = true;
                }
            }
            return this.mWasNestedFlung = fling;
        }
        
        public void onNestedPreScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, int n, final int n2, final int[] array) {
            if (n2 != 0 && !this.mSkipNestedPreScroll) {
                int n3;
                if (n2 < 0) {
                    n = -appBarLayout.getTotalScrollRange();
                    n3 = n + appBarLayout.getDownNestedPreScrollRange();
                }
                else {
                    n = -appBarLayout.getUpNestedPreScrollRange();
                    n3 = 0;
                }
                array[1] = this.scroll(coordinatorLayout, appBarLayout, n2, n, n3);
            }
        }
        
        public void onNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, final int n, final int n2, final int n3, final int n4) {
            if (n4 < 0) {
                this.scroll(coordinatorLayout, appBarLayout, n4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.mSkipNestedPreScroll = true;
                return;
            }
            this.mSkipNestedPreScroll = false;
        }
        
        public void onRestoreInstanceState(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                final SavedState savedState = (SavedState)parcelable;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
                this.mOffsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
                this.mOffsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
                this.mOffsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
            this.mOffsetToChildIndexOnLayout = -1;
        }
        
        public Parcelable onSaveInstanceState(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
            final Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            final int topAndBottomOffset = this.getTopAndBottomOffset();
            for (int i = 0; i < appBarLayout.getChildCount(); ++i) {
                final View child = appBarLayout.getChildAt(i);
                final int n = child.getBottom() + topAndBottomOffset;
                if (child.getTop() + topAndBottomOffset <= 0 && n >= 0) {
                    final SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.firstVisibleChildIndex = i;
                    savedState.firstVisibleChildAtMinimumHeight = (n == ViewCompat.getMinimumHeight(child) + appBarLayout.getTopInset());
                    savedState.firstVisibleChildPercentageShown = n / (float)child.getHeight();
                    return (Parcelable)savedState;
                }
            }
            return onSaveInstanceState;
        }
        
        public boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View view, final View view2, final int n) {
            final boolean b = (n & 0x2) != 0x0 && appBarLayout.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (b && this.mOffsetAnimator != null) {
                this.mOffsetAnimator.cancel();
            }
            this.mLastNestedScrollingChildRef = null;
            return b;
        }
        
        public void onStopNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final View referent) {
            if (!this.mWasNestedFlung) {
                this.snapToChildIfNeeded(coordinatorLayout, appBarLayout);
            }
            this.mSkipNestedPreScroll = false;
            this.mWasNestedFlung = false;
            this.mLastNestedScrollingChildRef = new WeakReference<View>(referent);
        }
        
        public void setDragCallback(@Nullable final DragCallback mOnDragCallback) {
            this.mOnDragCallback = mOnDragCallback;
        }
        
        @Override
        int setHeaderTopBottomOffset(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int interpolateOffset, int constrain, int n) {
            final int topBottomOffsetForScrollingSibling = this.getTopBottomOffsetForScrollingSibling();
            final int n2 = 0;
            if (constrain != 0 && topBottomOffsetForScrollingSibling >= constrain && topBottomOffsetForScrollingSibling <= n) {
                constrain = MathUtils.constrain(interpolateOffset, constrain, n);
                interpolateOffset = n2;
                if (topBottomOffsetForScrollingSibling != constrain) {
                    if (appBarLayout.hasChildWithInterpolator()) {
                        interpolateOffset = this.interpolateOffset(appBarLayout, constrain);
                    }
                    else {
                        interpolateOffset = constrain;
                    }
                    final boolean setTopAndBottomOffset = this.setTopAndBottomOffset(interpolateOffset);
                    n = topBottomOffsetForScrollingSibling - constrain;
                    this.mOffsetDelta = constrain - interpolateOffset;
                    if (!setTopAndBottomOffset && appBarLayout.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged((View)appBarLayout);
                    }
                    appBarLayout.dispatchOffsetUpdates(this.getTopAndBottomOffset());
                    if (constrain < topBottomOffsetForScrollingSibling) {
                        interpolateOffset = -1;
                    }
                    else {
                        interpolateOffset = 1;
                    }
                    this.updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, constrain, interpolateOffset, false);
                    interpolateOffset = n;
                }
                return interpolateOffset;
            }
            return this.mOffsetDelta = 0;
        }
        
        public abstract static class DragCallback
        {
            public abstract boolean canDrag(@NonNull final AppBarLayout p0);
        }
        
        protected static class SavedState extends AbsSavedState
        {
            public static final Parcelable$Creator<SavedState> CREATOR;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            
            static {
                CREATOR = ParcelableCompat.newCreator((ParcelableCompatCreatorCallbacks<SavedState>)new ParcelableCompatCreatorCallbacks<SavedState>() {
                    @Override
                    public SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                        return new SavedState(parcel, classLoader);
                    }
                    
                    @Override
                    public SavedState[] newArray(final int n) {
                        return new SavedState[n];
                    }
                });
            }
            
            public SavedState(final Parcel parcel, final ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = (parcel.readByte() != 0);
            }
            
            public SavedState(final Parcelable parcelable) {
                super(parcelable);
            }
            
            @Override
            public void writeToParcel(final Parcel parcel, int n) {
                super.writeToParcel(parcel, n);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                if (this.firstVisibleChildAtMinimumHeight) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                parcel.writeByte((byte)n);
            }
        }
    }
    
    public static class LayoutParams extends LinearLayout$LayoutParams
    {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        int mScrollFlags;
        Interpolator mScrollInterpolator;
        
        public LayoutParams(final int n, final int n2) {
            super(n, n2);
            this.mScrollFlags = 1;
        }
        
        public LayoutParams(final int n, final int n2, final float n3) {
            super(n, n2, n3);
            this.mScrollFlags = 1;
        }
        
        public LayoutParams(final Context context, final AttributeSet set) {
            super(context, set);
            this.mScrollFlags = 1;
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.AppBarLayout_Layout);
            this.mScrollFlags = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.mScrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }
        
        @TargetApi(19)
        @RequiresApi(19)
        public LayoutParams(final LayoutParams layoutParams) {
            super((LinearLayout$LayoutParams)layoutParams);
            this.mScrollFlags = 1;
            this.mScrollFlags = layoutParams.mScrollFlags;
            this.mScrollInterpolator = layoutParams.mScrollInterpolator;
        }
        
        public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.mScrollFlags = 1;
        }
        
        public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
            this.mScrollFlags = 1;
        }
        
        @TargetApi(19)
        @RequiresApi(19)
        public LayoutParams(final LinearLayout$LayoutParams linearLayout$LayoutParams) {
            super(linearLayout$LayoutParams);
            this.mScrollFlags = 1;
        }
        
        public int getScrollFlags() {
            return this.mScrollFlags;
        }
        
        public Interpolator getScrollInterpolator() {
            return this.mScrollInterpolator;
        }
        
        boolean isCollapsible() {
            return (this.mScrollFlags & 0x1) == 0x1 && (this.mScrollFlags & 0xA) != 0x0;
        }
        
        public void setScrollFlags(final int mScrollFlags) {
            this.mScrollFlags = mScrollFlags;
        }
        
        public void setScrollInterpolator(final Interpolator mScrollInterpolator) {
            this.mScrollInterpolator = mScrollInterpolator;
        }
        
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
        public @interface ScrollFlags {
        }
    }
    
    public interface OnOffsetChangedListener
    {
        void onOffsetChanged(final AppBarLayout p0, final int p1);
    }
    
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior
    {
        public ScrollingViewBehavior() {
        }
        
        public ScrollingViewBehavior(final Context context, final AttributeSet set) {
            super(context, set);
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ScrollingViewBehavior_Layout);
            this.setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }
        
        private static int getAppBarLayoutOffset(final AppBarLayout appBarLayout) {
            final CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                return ((AppBarLayout.Behavior)behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }
        
        private void offsetChildAsNeeded(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
            final CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)view2.getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout.Behavior) {
                ViewCompat.offsetTopAndBottom(view, view2.getBottom() - view.getTop() + ((AppBarLayout.Behavior)behavior).mOffsetDelta + this.getVerticalLayoutGap() - this.getOverlapPixelsForOffset(view2));
            }
        }
        
        AppBarLayout findFirstDependency(final List<View> list) {
            for (int i = 0; i < list.size(); ++i) {
                final View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout)view;
                }
            }
            return null;
        }
        
        @Override
        float getOverlapRatioForOffset(final View view) {
            if (view instanceof AppBarLayout) {
                final AppBarLayout appBarLayout = (AppBarLayout)view;
                final int totalScrollRange = appBarLayout.getTotalScrollRange();
                final int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                final int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if (downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) {
                    final int n = totalScrollRange - downNestedPreScrollRange;
                    if (n != 0) {
                        return 1.0f + appBarLayoutOffset / (float)n;
                    }
                }
            }
            return 0.0f;
        }
        
        @Override
        int getScrollRange(final View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout)view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }
        
        @Override
        public boolean layoutDependsOn(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
            return view2 instanceof AppBarLayout;
        }
        
        @Override
        public boolean onDependentViewChanged(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
            this.offsetChildAsNeeded(coordinatorLayout, view, view2);
            return false;
        }
        
        @Override
        public boolean onRequestChildRectangleOnScreen(final CoordinatorLayout coordinatorLayout, final View view, final Rect rect, final boolean b) {
            final AppBarLayout firstDependency = this.findFirstDependency(coordinatorLayout.getDependencies(view));
            if (firstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                final Rect mTempRect1 = this.mTempRect1;
                mTempRect1.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!mTempRect1.contains(rect)) {
                    firstDependency.setExpanded(false, !b);
                    return true;
                }
            }
            return false;
        }
    }
}
