// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.support.v7.widget.LinearSmoothScroller;
import android.os.Parcelable;
import android.graphics.PointF;
import android.view.View$MeasureSpec;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import java.util.ArrayList;
import android.util.SparseArray;
import android.view.View;
import android.support.v7.widget.OrientationHelper;
import java.util.List;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

public class FlexboxLayoutManager extends LayoutManager implements FlexContainer, ScrollVectorProvider
{
    private static final boolean DEBUG = false;
    private static final String TAG = "FlexboxLayoutManager";
    private static final Rect TEMP_RECT;
    private int mAlignItems;
    private AnchorInfo mAnchorInfo;
    private final Context mContext;
    private int mDirtyPosition;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private final FlexboxHelper mFlexboxHelper;
    private boolean mFromBottomToTop;
    private boolean mIsRtl;
    private int mJustifyContent;
    private int mLastHeight;
    private int mLastWidth;
    private LayoutState mLayoutState;
    private OrientationHelper mOrientationHelper;
    private View mParent;
    private SavedState mPendingSavedState;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private Recycler mRecycler;
    private State mState;
    private OrientationHelper mSubOrientationHelper;
    private SparseArray<View> mViewCache;
    
    static {
        TEMP_RECT = new Rect();
    }
    
    public FlexboxLayoutManager(final Context context) {
        this(context, 0, 1);
    }
    
    public FlexboxLayoutManager(final Context context, final int n) {
        this(context, n, 1);
    }
    
    public FlexboxLayoutManager(final Context mContext, final int flexDirection, final int flexWrap) {
        this.mFlexLines = new ArrayList<FlexLine>();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = (SparseArray<View>)new SparseArray();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        this.setFlexDirection(flexDirection);
        this.setFlexWrap(flexWrap);
        this.setAlignItems(4);
        ((RecyclerView.LayoutManager)this).setAutoMeasureEnabled(true);
        this.mContext = mContext;
    }
    
    public FlexboxLayoutManager(final Context mContext, final AttributeSet set, final int n, final int n2) {
        this.mFlexLines = new ArrayList<FlexLine>();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = (SparseArray<View>)new SparseArray();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        final Properties properties = RecyclerView.LayoutManager.getProperties(mContext, set, n, n2);
        switch (properties.orientation) {
            case 0: {
                if (properties.reverseLayout) {
                    this.setFlexDirection(1);
                    break;
                }
                this.setFlexDirection(0);
                break;
            }
            case 1: {
                if (properties.reverseLayout) {
                    this.setFlexDirection(3);
                    break;
                }
                this.setFlexDirection(2);
                break;
            }
        }
        this.setFlexWrap(1);
        this.setAlignItems(4);
        ((RecyclerView.LayoutManager)this).setAutoMeasureEnabled(true);
        this.mContext = mContext;
    }
    
    private boolean canViewBeRecycledFromEnd(final View view, final int n) {
        if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
            if (this.mOrientationHelper.getDecoratedEnd(view) > n) {
                return false;
            }
        }
        else if (this.mOrientationHelper.getDecoratedStart(view) < this.mOrientationHelper.getEnd() - n) {
            return false;
        }
        return true;
    }
    
    private boolean canViewBeRecycledFromStart(final View view, final int n) {
        if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
            if (this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) > n) {
                return false;
            }
        }
        else if (this.mOrientationHelper.getDecoratedEnd(view) > n) {
            return false;
        }
        return true;
    }
    
    private void clearFlexLines() {
        this.mFlexLines.clear();
        this.mAnchorInfo.reset();
        this.mAnchorInfo.mPerpendicularCoordinate = 0;
    }
    
    private int computeScrollExtent(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0) {
            final int itemCount = state.getItemCount();
            this.ensureOrientationHelper();
            final View firstReferenceChild = this.findFirstReferenceChild(itemCount);
            final View lastReferenceChild = this.findLastReferenceChild(itemCount);
            if (state.getItemCount() != 0 && firstReferenceChild != null && lastReferenceChild != null) {
                return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(lastReferenceChild) - this.mOrientationHelper.getDecoratedStart(firstReferenceChild));
            }
        }
        return 0;
    }
    
    private int computeScrollOffset(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0) {
            final int itemCount = state.getItemCount();
            final View firstReferenceChild = this.findFirstReferenceChild(itemCount);
            final View lastReferenceChild = this.findLastReferenceChild(itemCount);
            if (state.getItemCount() != 0 && firstReferenceChild != null && lastReferenceChild != null) {
                assert this.mFlexboxHelper.mIndexToFlexLine != null;
                final int position = ((RecyclerView.LayoutManager)this).getPosition(firstReferenceChild);
                final int position2 = ((RecyclerView.LayoutManager)this).getPosition(lastReferenceChild);
                final int abs = Math.abs(this.mOrientationHelper.getDecoratedEnd(lastReferenceChild) - this.mOrientationHelper.getDecoratedStart(firstReferenceChild));
                final int n = this.mFlexboxHelper.mIndexToFlexLine[position];
                if (n != 0 && n != -1) {
                    return Math.round(n * (abs / (float)(this.mFlexboxHelper.mIndexToFlexLine[position2] - n + 1)) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(firstReferenceChild)));
                }
            }
        }
        return 0;
    }
    
    private int computeScrollRange(final State state) {
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0) {
            final int itemCount = state.getItemCount();
            final View firstReferenceChild = this.findFirstReferenceChild(itemCount);
            final View lastReferenceChild = this.findLastReferenceChild(itemCount);
            if (state.getItemCount() != 0 && firstReferenceChild != null && lastReferenceChild != null) {
                assert this.mFlexboxHelper.mIndexToFlexLine != null;
                return (int)(Math.abs(this.mOrientationHelper.getDecoratedEnd(lastReferenceChild) - this.mOrientationHelper.getDecoratedStart(firstReferenceChild)) / (float)(this.findLastVisibleItemPosition() - this.findFirstVisibleItemPosition() + 1) * state.getItemCount());
            }
        }
        return 0;
    }
    
    private void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new LayoutState();
        }
    }
    
    private void ensureOrientationHelper() {
        if (this.mOrientationHelper != null) {
            return;
        }
        if (this.isMainAxisDirectionHorizontal()) {
            if (this.mFlexWrap == 0) {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
                return;
            }
            this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
            this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
        }
        else {
            if (this.mFlexWrap == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                return;
            }
            this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
            this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
        }
    }
    
    private int fill(final Recycler recycler, final State state, final LayoutState layoutState) {
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                layoutState.mScrollingOffset += layoutState.mAvailable;
            }
            this.recycleByLayoutState(recycler, layoutState);
        }
        final int access$1200 = layoutState.mAvailable;
        int access$1201 = layoutState.mAvailable;
        int n = 0;
        final boolean mainAxisDirectionHorizontal = this.isMainAxisDirectionHorizontal();
        while ((access$1201 > 0 || this.mLayoutState.mInfinite) && layoutState.hasMore(state, this.mFlexLines)) {
            final FlexLine flexLine = this.mFlexLines.get(layoutState.mFlexLinePosition);
            layoutState.mPosition = flexLine.mFirstIndex;
            n += this.layoutFlexLine(flexLine, layoutState);
            if (!mainAxisDirectionHorizontal && this.mIsRtl) {
                layoutState.mOffset -= flexLine.getCrossSize() * layoutState.mLayoutDirection;
            }
            else {
                layoutState.mOffset += flexLine.getCrossSize() * layoutState.mLayoutDirection;
            }
            access$1201 -= flexLine.getCrossSize();
        }
        layoutState.mAvailable -= n;
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            layoutState.mScrollingOffset += n;
            if (layoutState.mAvailable < 0) {
                layoutState.mScrollingOffset += layoutState.mAvailable;
            }
            this.recycleByLayoutState(recycler, layoutState);
        }
        return access$1200 - layoutState.mAvailable;
    }
    
    private View findFirstReferenceChild(int position) {
        assert this.mFlexboxHelper.mIndexToFlexLine != null;
        final View referenceChild = this.findReferenceChild(0, ((RecyclerView.LayoutManager)this).getChildCount(), position);
        if (referenceChild != null) {
            position = ((RecyclerView.LayoutManager)this).getPosition(referenceChild);
            position = this.mFlexboxHelper.mIndexToFlexLine[position];
            if (position != -1) {
                return this.findFirstReferenceViewInLine(referenceChild, this.mFlexLines.get(position));
            }
        }
        return null;
    }
    
    private View findFirstReferenceViewInLine(View view, final FlexLine flexLine) {
        final boolean mainAxisDirectionHorizontal = this.isMainAxisDirectionHorizontal();
        int i = 1;
        final int mItemCount = flexLine.mItemCount;
        View view2 = view;
        while (i < mItemCount) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            view = view2;
            if (child != null) {
                if (child.getVisibility() == 8) {
                    view = view2;
                }
                else if (this.mIsRtl && !mainAxisDirectionHorizontal) {
                    view = view2;
                    if (this.mOrientationHelper.getDecoratedEnd(view2) < this.mOrientationHelper.getDecoratedEnd(child)) {
                        view = child;
                    }
                }
                else {
                    view = view2;
                    if (this.mOrientationHelper.getDecoratedStart(view2) > this.mOrientationHelper.getDecoratedStart(child)) {
                        view = child;
                    }
                }
            }
            ++i;
            view2 = view;
        }
        return view2;
    }
    
    private View findLastReferenceChild(int position) {
        assert this.mFlexboxHelper.mIndexToFlexLine != null;
        final View referenceChild = this.findReferenceChild(((RecyclerView.LayoutManager)this).getChildCount() - 1, -1, position);
        if (referenceChild == null) {
            return null;
        }
        position = ((RecyclerView.LayoutManager)this).getPosition(referenceChild);
        position = this.mFlexboxHelper.mIndexToFlexLine[position];
        return this.findLastReferenceViewInLine(referenceChild, this.mFlexLines.get(position));
    }
    
    private View findLastReferenceViewInLine(View view, final FlexLine flexLine) {
        final boolean mainAxisDirectionHorizontal = this.isMainAxisDirectionHorizontal();
        int i = ((RecyclerView.LayoutManager)this).getChildCount() - 2;
        final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
        final int mItemCount = flexLine.mItemCount;
        View view2 = view;
        while (i > childCount - mItemCount - 1) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            view = view2;
            if (child != null) {
                if (child.getVisibility() == 8) {
                    view = view2;
                }
                else if (this.mIsRtl && !mainAxisDirectionHorizontal) {
                    view = view2;
                    if (this.mOrientationHelper.getDecoratedStart(view2) > this.mOrientationHelper.getDecoratedStart(child)) {
                        view = child;
                    }
                }
                else {
                    view = view2;
                    if (this.mOrientationHelper.getDecoratedEnd(view2) < this.mOrientationHelper.getDecoratedEnd(child)) {
                        view = child;
                    }
                }
            }
            --i;
            view2 = view;
        }
        return view2;
    }
    
    private View findOneVisibleChild(int i, final int n, final boolean b) {
        int n2;
        if (n > i) {
            n2 = 1;
        }
        else {
            n2 = -1;
        }
        while (i != n) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            if (this.isViewVisible(child, b)) {
                return child;
            }
            i += n2;
        }
        return null;
    }
    
    private View findReferenceChild(int i, final int n, final int n2) {
        this.ensureOrientationHelper();
        this.ensureLayoutState();
        View view = null;
        View view2 = null;
        final int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        final int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int n3;
        if (n > i) {
            n3 = 1;
        }
        else {
            n3 = -1;
        }
        while (i != n) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(i);
            final int position = ((RecyclerView.LayoutManager)this).getPosition(child);
            View view3 = view;
            View view4 = view2;
            if (position >= 0) {
                view3 = view;
                view4 = view2;
                if (position < n2) {
                    if (((RecyclerView.LayoutParams)child.getLayoutParams()).isItemRemoved()) {
                        view3 = view;
                        view4 = view2;
                        if (view == null) {
                            view4 = view2;
                            view3 = child;
                        }
                    }
                    else {
                        if (this.mOrientationHelper.getDecoratedStart(child) >= startAfterPadding) {
                            final View view5 = child;
                            if (this.mOrientationHelper.getDecoratedEnd(child) <= endAfterPadding) {
                                return view5;
                            }
                        }
                        view3 = view;
                        if ((view4 = view2) == null) {
                            view3 = view;
                            view4 = child;
                        }
                    }
                }
            }
            i += n3;
            view = view3;
            view2 = view4;
        }
        if (view2 == null) {
            view2 = view;
        }
        return view2;
    }
    
    private int fixLayoutEndGap(int n, final Recycler recycler, final State state, final boolean b) {
        final int n2 = 0;
        int n3;
        if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        int handleScrollingCrossAxis;
        if (n3 != 0) {
            final int n4 = n - this.mOrientationHelper.getStartAfterPadding();
            final int n5 = n2;
            if (n4 <= 0) {
                return n5;
            }
            handleScrollingCrossAxis = this.handleScrollingCrossAxis(n4, recycler, state);
        }
        else {
            final int n6 = this.mOrientationHelper.getEndAfterPadding() - n;
            final int n5 = n2;
            if (n6 <= 0) {
                return n5;
            }
            handleScrollingCrossAxis = -this.handleScrollingCrossAxis(-n6, recycler, state);
        }
        int n5 = handleScrollingCrossAxis;
        if (b) {
            n = this.mOrientationHelper.getEndAfterPadding() - (n + handleScrollingCrossAxis);
            n5 = handleScrollingCrossAxis;
            if (n > 0) {
                this.mOrientationHelper.offsetChildren(n);
                n5 = handleScrollingCrossAxis + n;
            }
        }
        return n5;
    }
    
    private int fixLayoutStartGap(int n, final Recycler recycler, final State state, final boolean b) {
        int n2 = 0;
        int handleScrollingCrossAxis;
        if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
            final int n3 = this.mOrientationHelper.getEndAfterPadding() - n;
            if (n3 <= 0) {
                return n2;
            }
            handleScrollingCrossAxis = this.handleScrollingCrossAxis(-n3, recycler, state);
        }
        else {
            final int n4 = n - this.mOrientationHelper.getStartAfterPadding();
            if (n4 <= 0) {
                return n2;
            }
            handleScrollingCrossAxis = -this.handleScrollingCrossAxis(n4, recycler, state);
        }
        n2 = handleScrollingCrossAxis;
        if (b) {
            n = n + handleScrollingCrossAxis - this.mOrientationHelper.getStartAfterPadding();
            n2 = handleScrollingCrossAxis;
            if (n > 0) {
                this.mOrientationHelper.offsetChildren(-n);
                n2 = handleScrollingCrossAxis - n;
            }
        }
        return n2;
    }
    
    private int getChildBottom(final View view) {
        return ((RecyclerView.LayoutManager)this).getDecoratedBottom(view) + ((RecyclerView.LayoutParams)view.getLayoutParams()).bottomMargin;
    }
    
    private View getChildClosestToStart() {
        return ((RecyclerView.LayoutManager)this).getChildAt(0);
    }
    
    private int getChildLeft(final View view) {
        return ((RecyclerView.LayoutManager)this).getDecoratedLeft(view) - ((RecyclerView.LayoutParams)view.getLayoutParams()).leftMargin;
    }
    
    private int getChildRight(final View view) {
        return ((RecyclerView.LayoutManager)this).getDecoratedRight(view) + ((RecyclerView.LayoutParams)view.getLayoutParams()).rightMargin;
    }
    
    private int getChildTop(final View view) {
        return ((RecyclerView.LayoutManager)this).getDecoratedTop(view) - ((RecyclerView.LayoutParams)view.getLayoutParams()).topMargin;
    }
    
    private int handleScrollingCrossAxis(int a, final Recycler recycler, final State state) {
        final int n = 1;
        int n2 = 1;
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0 && a != 0) {
            this.ensureOrientationHelper();
            this.mLayoutState.mShouldRecycle = true;
            boolean b;
            if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
                b = true;
            }
            else {
                b = false;
            }
            if (b) {
                if (a >= 0) {
                    n2 = -1;
                }
            }
            else if (a > 0) {
                n2 = n;
            }
            else {
                n2 = -1;
            }
            final int abs = Math.abs(a);
            this.updateLayoutState(n2, abs);
            final int n3 = this.mLayoutState.mScrollingOffset + this.fill(recycler, state, this.mLayoutState);
            if (n3 >= 0) {
                if (b) {
                    if (abs > n3) {
                        a = -n2 * n3;
                    }
                }
                else if (abs > n3) {
                    a = n2 * n3;
                }
                this.mOrientationHelper.offsetChildren(-a);
                this.mLayoutState.mLastScrollDelta = a;
                return a;
            }
        }
        return 0;
    }
    
    private int handleScrollingMainAxis(int min) {
        int n = 1;
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0 || min == 0) {
            return 0;
        }
        this.ensureOrientationHelper();
        final boolean mainAxisDirectionHorizontal = this.isMainAxisDirectionHorizontal();
        int n2;
        if (mainAxisDirectionHorizontal) {
            n2 = this.mParent.getWidth();
        }
        else {
            n2 = this.mParent.getHeight();
        }
        int n3;
        if (mainAxisDirectionHorizontal) {
            n3 = ((RecyclerView.LayoutManager)this).getWidth();
        }
        else {
            n3 = ((RecyclerView.LayoutManager)this).getHeight();
        }
        if (((RecyclerView.LayoutManager)this).getLayoutDirection() != 1) {
            n = 0;
        }
        if (n != 0) {
            final int abs = Math.abs(min);
            if (min < 0) {
                min = -Math.min(this.mAnchorInfo.mPerpendicularCoordinate + n3 - n2, abs);
            }
            else {
                int n4 = min;
                if (this.mAnchorInfo.mPerpendicularCoordinate + min > 0) {
                    n4 = -this.mAnchorInfo.mPerpendicularCoordinate;
                }
                min = n4;
            }
        }
        else if (min > 0) {
            min = Math.min(n3 - this.mAnchorInfo.mPerpendicularCoordinate - n2, min);
        }
        else if (this.mAnchorInfo.mPerpendicularCoordinate + min < 0) {
            min = -this.mAnchorInfo.mPerpendicularCoordinate;
        }
        return min;
    }
    
    private static boolean isMeasurementUpToDate(final int n, int size, final int n2) {
        final boolean b = true;
        final int mode = View$MeasureSpec.getMode(size);
        size = View$MeasureSpec.getSize(size);
        boolean b2;
        if (n2 > 0 && n != n2) {
            b2 = false;
        }
        else {
            b2 = b;
            switch (mode) {
                case 0: {
                    break;
                }
                default: {
                    return false;
                }
                case Integer.MIN_VALUE: {
                    b2 = b;
                    if (size < n) {
                        return false;
                    }
                    break;
                }
                case 1073741824: {
                    b2 = b;
                    if (size != n) {
                        return false;
                    }
                    break;
                }
            }
        }
        return b2;
    }
    
    private boolean isViewVisible(final View view, final boolean b) {
        final int paddingLeft = ((RecyclerView.LayoutManager)this).getPaddingLeft();
        final int paddingTop = ((RecyclerView.LayoutManager)this).getPaddingTop();
        final int n = ((RecyclerView.LayoutManager)this).getWidth() - ((RecyclerView.LayoutManager)this).getPaddingRight();
        final int n2 = ((RecyclerView.LayoutManager)this).getHeight() - ((RecyclerView.LayoutManager)this).getPaddingBottom();
        final int childLeft = this.getChildLeft(view);
        final int childTop = this.getChildTop(view);
        final int childRight = this.getChildRight(view);
        final int childBottom = this.getChildBottom(view);
        final int n3 = 0;
        boolean b2 = false;
        final int n4 = 0;
        boolean b3 = false;
        int n5 = n3;
        if (paddingLeft <= childLeft) {
            n5 = n3;
            if (n >= childRight) {
                n5 = 1;
            }
        }
        if (childLeft >= n || childRight >= paddingLeft) {
            b2 = true;
        }
        int n6 = n4;
        if (paddingTop <= childTop) {
            n6 = n4;
            if (n2 >= childBottom) {
                n6 = 1;
            }
        }
        if (childTop >= n2 || childBottom >= paddingTop) {
            b3 = true;
        }
        if (b) {
            return n5 != 0 && n6 != 0;
        }
        return b2 && b3;
    }
    
    private int layoutFlexLine(final FlexLine flexLine, final LayoutState layoutState) {
        if (this.isMainAxisDirectionHorizontal()) {
            return this.layoutFlexLineMainAxisHorizontal(flexLine, layoutState);
        }
        return this.layoutFlexLineMainAxisVertical(flexLine, layoutState);
    }
    
    private int layoutFlexLineMainAxisHorizontal(final FlexLine flexLine, final LayoutState layoutState) {
        assert this.mFlexboxHelper.mMeasureSpecCache != null;
        final int paddingLeft = ((RecyclerView.LayoutManager)this).getPaddingLeft();
        final int paddingRight = ((RecyclerView.LayoutManager)this).getPaddingRight();
        final int width = ((RecyclerView.LayoutManager)this).getWidth();
        int access$1000 = layoutState.mOffset;
        if (layoutState.mLayoutDirection == -1) {
            access$1000 -= flexLine.mCrossSize;
        }
        final int access$1001 = layoutState.mPosition;
        final float n = 0.0f;
        float a = 0.0f;
        float n2 = 0.0f;
        float n3 = 0.0f;
        switch (this.mJustifyContent) {
            default: {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            case 0: {
                n2 = (float)paddingLeft;
                n3 = (float)(width - paddingRight);
                break;
            }
            case 1: {
                n2 = (float)(width - flexLine.mMainSize + paddingRight);
                n3 = (float)(flexLine.mMainSize - paddingLeft);
                break;
            }
            case 2: {
                n2 = paddingLeft + (width - flexLine.mMainSize) / 2.0f;
                n3 = width - paddingRight - (width - flexLine.mMainSize) / 2.0f;
                break;
            }
            case 4: {
                a = n;
                if (flexLine.mItemCount != 0) {
                    a = (width - flexLine.mMainSize) / (float)flexLine.mItemCount;
                }
                n2 = paddingLeft + a / 2.0f;
                n3 = width - paddingRight - a / 2.0f;
                break;
            }
            case 3: {
                final float n4 = (float)paddingLeft;
                float n5;
                if (flexLine.mItemCount != 1) {
                    n5 = (float)(flexLine.mItemCount - 1);
                }
                else {
                    n5 = 1.0f;
                }
                a = (width - flexLine.mMainSize) / n5;
                final float n6 = (float)(width - paddingRight);
                n2 = n4;
                n3 = n6;
                break;
            }
        }
        final float n7 = n2 - this.mAnchorInfo.mPerpendicularCoordinate;
        float n8 = n3 - this.mAnchorInfo.mPerpendicularCoordinate;
        final float max = Math.max(a, 0.0f);
        int n9 = 0;
        int i = access$1001;
        final int itemCount = flexLine.getItemCount();
        float n10 = n7;
        while (i < access$1001 + itemCount) {
            final View flexItem = this.getFlexItemAt(i);
            if (flexItem != null) {
                if (layoutState.mLayoutDirection == 1) {
                    ((RecyclerView.LayoutManager)this).calculateItemDecorationsForChild(flexItem, FlexboxLayoutManager.TEMP_RECT);
                    ((RecyclerView.LayoutManager)this).addView(flexItem);
                }
                else {
                    ((RecyclerView.LayoutManager)this).calculateItemDecorationsForChild(flexItem, FlexboxLayoutManager.TEMP_RECT);
                    ((RecyclerView.LayoutManager)this).addView(flexItem, n9);
                    ++n9;
                }
                final long n11 = this.mFlexboxHelper.mMeasureSpecCache[i];
                final int lowerInt = this.mFlexboxHelper.extractLowerInt(n11);
                final int higherInt = this.mFlexboxHelper.extractHigherInt(n11);
                final LayoutParams layoutParams = (LayoutParams)flexItem.getLayoutParams();
                if (this.shouldMeasureChild(flexItem, lowerInt, higherInt, layoutParams)) {
                    flexItem.measure(lowerInt, higherInt);
                }
                final float n12 = n10 + (layoutParams.leftMargin + ((RecyclerView.LayoutManager)this).getLeftDecorationWidth(flexItem));
                final float n13 = n8 - (layoutParams.rightMargin + ((RecyclerView.LayoutManager)this).getRightDecorationWidth(flexItem));
                final int n14 = access$1000 + ((RecyclerView.LayoutManager)this).getTopDecorationHeight(flexItem);
                if (this.mIsRtl) {
                    this.mFlexboxHelper.layoutSingleChildHorizontal(flexItem, flexLine, Math.round(n13) - flexItem.getMeasuredWidth(), n14, Math.round(n13), n14 + flexItem.getMeasuredHeight());
                }
                else {
                    this.mFlexboxHelper.layoutSingleChildHorizontal(flexItem, flexLine, Math.round(n12), n14, flexItem.getMeasuredWidth() + Math.round(n12), n14 + flexItem.getMeasuredHeight());
                }
                n10 = n12 + (flexItem.getMeasuredWidth() + layoutParams.rightMargin + ((RecyclerView.LayoutManager)this).getRightDecorationWidth(flexItem) + max);
                n8 = n13 - (flexItem.getMeasuredWidth() + layoutParams.leftMargin + ((RecyclerView.LayoutManager)this).getLeftDecorationWidth(flexItem) + max);
            }
            ++i;
        }
        layoutState.mFlexLinePosition += this.mLayoutState.mLayoutDirection;
        return flexLine.getCrossSize();
    }
    
    private int layoutFlexLineMainAxisVertical(final FlexLine flexLine, final LayoutState layoutState) {
        assert this.mFlexboxHelper.mMeasureSpecCache != null;
        final int paddingTop = ((RecyclerView.LayoutManager)this).getPaddingTop();
        final int paddingBottom = ((RecyclerView.LayoutManager)this).getPaddingBottom();
        final int height = ((RecyclerView.LayoutManager)this).getHeight();
        final int access$1000 = layoutState.mOffset;
        final int access$1001 = layoutState.mOffset;
        int n = access$1000;
        int n2 = access$1001;
        if (layoutState.mLayoutDirection == -1) {
            n = access$1000 - flexLine.mCrossSize;
            n2 = access$1001 + flexLine.mCrossSize;
        }
        final int access$1002 = layoutState.mPosition;
        final float n3 = 0.0f;
        float a = 0.0f;
        float n4 = 0.0f;
        float n5 = 0.0f;
        switch (this.mJustifyContent) {
            default: {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            case 0: {
                n4 = (float)paddingTop;
                n5 = (float)(height - paddingBottom);
                break;
            }
            case 1: {
                n4 = (float)(height - flexLine.mMainSize + paddingBottom);
                n5 = (float)(flexLine.mMainSize - paddingTop);
                break;
            }
            case 2: {
                n4 = paddingTop + (height - flexLine.mMainSize) / 2.0f;
                n5 = height - paddingBottom - (height - flexLine.mMainSize) / 2.0f;
                break;
            }
            case 4: {
                a = n3;
                if (flexLine.mItemCount != 0) {
                    a = (height - flexLine.mMainSize) / (float)flexLine.mItemCount;
                }
                n4 = paddingTop + a / 2.0f;
                n5 = height - paddingBottom - a / 2.0f;
                break;
            }
            case 3: {
                n4 = (float)paddingTop;
                float n6;
                if (flexLine.mItemCount != 1) {
                    n6 = (float)(flexLine.mItemCount - 1);
                }
                else {
                    n6 = 1.0f;
                }
                a = (height - flexLine.mMainSize) / n6;
                n5 = (float)(height - paddingBottom);
                break;
            }
        }
        float n7 = n4 - this.mAnchorInfo.mPerpendicularCoordinate;
        float n8 = n5 - this.mAnchorInfo.mPerpendicularCoordinate;
        final float max = Math.max(a, 0.0f);
        int n9 = 0;
        for (int i = access$1002; i < access$1002 + flexLine.getItemCount(); ++i) {
            final View flexItem = this.getFlexItemAt(i);
            if (flexItem != null) {
                final long n10 = this.mFlexboxHelper.mMeasureSpecCache[i];
                final int lowerInt = this.mFlexboxHelper.extractLowerInt(n10);
                final int higherInt = this.mFlexboxHelper.extractHigherInt(n10);
                final LayoutParams layoutParams = (LayoutParams)flexItem.getLayoutParams();
                if (this.shouldMeasureChild(flexItem, lowerInt, higherInt, layoutParams)) {
                    flexItem.measure(lowerInt, higherInt);
                }
                final float n11 = n7 + (layoutParams.topMargin + ((RecyclerView.LayoutManager)this).getTopDecorationHeight(flexItem));
                final float n12 = n8 - (layoutParams.rightMargin + ((RecyclerView.LayoutManager)this).getBottomDecorationHeight(flexItem));
                if (layoutState.mLayoutDirection == 1) {
                    ((RecyclerView.LayoutManager)this).calculateItemDecorationsForChild(flexItem, FlexboxLayoutManager.TEMP_RECT);
                    ((RecyclerView.LayoutManager)this).addView(flexItem);
                }
                else {
                    ((RecyclerView.LayoutManager)this).calculateItemDecorationsForChild(flexItem, FlexboxLayoutManager.TEMP_RECT);
                    ((RecyclerView.LayoutManager)this).addView(flexItem, n9);
                    ++n9;
                }
                final int n13 = n + ((RecyclerView.LayoutManager)this).getLeftDecorationWidth(flexItem);
                final int n14 = n2 - ((RecyclerView.LayoutManager)this).getRightDecorationWidth(flexItem);
                if (this.mIsRtl) {
                    if (this.mFromBottomToTop) {
                        this.mFlexboxHelper.layoutSingleChildVertical(flexItem, flexLine, this.mIsRtl, n14 - flexItem.getMeasuredWidth(), Math.round(n12) - flexItem.getMeasuredHeight(), n14, Math.round(n12));
                    }
                    else {
                        this.mFlexboxHelper.layoutSingleChildVertical(flexItem, flexLine, this.mIsRtl, n14 - flexItem.getMeasuredWidth(), Math.round(n11), n14, flexItem.getMeasuredHeight() + Math.round(n11));
                    }
                }
                else if (this.mFromBottomToTop) {
                    this.mFlexboxHelper.layoutSingleChildVertical(flexItem, flexLine, this.mIsRtl, n13, Math.round(n12) - flexItem.getMeasuredHeight(), n13 + flexItem.getMeasuredWidth(), Math.round(n12));
                }
                else {
                    this.mFlexboxHelper.layoutSingleChildVertical(flexItem, flexLine, this.mIsRtl, n13, Math.round(n11), n13 + flexItem.getMeasuredWidth(), Math.round(n11) + flexItem.getMeasuredHeight());
                }
                n7 = n11 + (flexItem.getMeasuredHeight() + layoutParams.topMargin + ((RecyclerView.LayoutManager)this).getBottomDecorationHeight(flexItem) + max);
                n8 = n12 - (flexItem.getMeasuredHeight() + layoutParams.bottomMargin + ((RecyclerView.LayoutManager)this).getTopDecorationHeight(flexItem) + max);
            }
        }
        layoutState.mFlexLinePosition += this.mLayoutState.mLayoutDirection;
        return flexLine.getCrossSize();
    }
    
    private void recycleByLayoutState(final Recycler recycler, final LayoutState layoutState) {
        if (!layoutState.mShouldRecycle) {
            return;
        }
        if (layoutState.mLayoutDirection == -1) {
            this.recycleFlexLinesFromEnd(recycler, layoutState);
            return;
        }
        this.recycleFlexLinesFromStart(recycler, layoutState);
    }
    
    private void recycleChildren(final Recycler recycler, final int n, int i) {
        while (i >= n) {
            ((RecyclerView.LayoutManager)this).removeAndRecycleViewAt(i, recycler);
            --i;
        }
    }
    
    private void recycleFlexLinesFromEnd(final Recycler recycler, final LayoutState layoutState) {
        if (layoutState.mScrollingOffset >= 0) {
            assert this.mFlexboxHelper.mIndexToFlexLine != null;
            this.mOrientationHelper.getEnd();
            layoutState.mScrollingOffset;
            final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
            if (childCount != 0) {
                int n = this.mFlexboxHelper.mIndexToFlexLine[((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(childCount - 1))];
                if (n != -1) {
                    int n2 = childCount;
                    FlexLine flexLine = this.mFlexLines.get(n);
                    int n3 = childCount - 1;
                    int n4;
                    while (true) {
                        n4 = n2;
                        if (n3 < 0) {
                            break;
                        }
                        final View child = ((RecyclerView.LayoutManager)this).getChildAt(n3);
                        n4 = n2;
                        if (!this.canViewBeRecycledFromEnd(child, layoutState.mScrollingOffset)) {
                            break;
                        }
                        int n5 = n;
                        FlexLine flexLine2 = flexLine;
                        if (flexLine.mFirstIndex == ((RecyclerView.LayoutManager)this).getPosition(child)) {
                            n2 = n3;
                            if (n <= 0) {
                                n4 = n2;
                                break;
                            }
                            n5 = n + layoutState.mLayoutDirection;
                            flexLine2 = this.mFlexLines.get(n5);
                        }
                        --n3;
                        n = n5;
                        flexLine = flexLine2;
                    }
                    this.recycleChildren(recycler, n4, childCount - 1);
                }
            }
        }
    }
    
    private void recycleFlexLinesFromStart(final Recycler recycler, final LayoutState layoutState) {
        if (layoutState.mScrollingOffset >= 0) {
            assert this.mFlexboxHelper.mIndexToFlexLine != null;
            final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
            if (childCount != 0) {
                int n = this.mFlexboxHelper.mIndexToFlexLine[((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0))];
                if (n != -1) {
                    FlexLine flexLine = this.mFlexLines.get(n);
                    int n2 = -1;
                    int n3 = 0;
                    int n4;
                    while (true) {
                        n4 = n2;
                        if (n3 >= childCount) {
                            break;
                        }
                        final View child = ((RecyclerView.LayoutManager)this).getChildAt(n3);
                        n4 = n2;
                        if (!this.canViewBeRecycledFromStart(child, layoutState.mScrollingOffset)) {
                            break;
                        }
                        int n5 = n;
                        FlexLine flexLine2 = flexLine;
                        if (flexLine.mLastIndex == ((RecyclerView.LayoutManager)this).getPosition(child)) {
                            n2 = n3;
                            if (n >= this.mFlexLines.size() - 1) {
                                n4 = n2;
                                break;
                            }
                            n5 = n + layoutState.mLayoutDirection;
                            flexLine2 = this.mFlexLines.get(n5);
                        }
                        ++n3;
                        n = n5;
                        flexLine = flexLine2;
                    }
                    this.recycleChildren(recycler, 0, n4);
                }
            }
        }
    }
    
    private void resolveInfiniteAmount() {
        int n;
        if (this.isMainAxisDirectionHorizontal()) {
            n = ((RecyclerView.LayoutManager)this).getHeightMode();
        }
        else {
            n = ((RecyclerView.LayoutManager)this).getWidthMode();
        }
        this.mLayoutState.mInfinite = (n == 0 || n == Integer.MIN_VALUE);
    }
    
    private void resolveLayoutDirection() {
        final boolean b = false;
        final boolean b2 = true;
        final boolean b3 = true;
        final boolean b4 = true;
        final int layoutDirection = ((RecyclerView.LayoutManager)this).getLayoutDirection();
        switch (this.mFlexDirection) {
            default: {
                this.mIsRtl = false;
                this.mFromBottomToTop = false;
            }
            case 0: {
                this.mIsRtl = (layoutDirection == 1);
                this.mFromBottomToTop = (this.mFlexWrap == 2 && b4);
            }
            case 1: {
                this.mIsRtl = (layoutDirection != 1);
                this.mFromBottomToTop = (this.mFlexWrap == 2 && b2);
            }
            case 2: {
                this.mIsRtl = (layoutDirection == 1);
                if (this.mFlexWrap == 2) {
                    this.mIsRtl = (!this.mIsRtl && b3);
                }
                this.mFromBottomToTop = false;
            }
            case 3: {
                this.mIsRtl = (layoutDirection == 1);
                if (this.mFlexWrap == 2) {
                    boolean mIsRtl = b;
                    if (!this.mIsRtl) {
                        mIsRtl = true;
                    }
                    this.mIsRtl = mIsRtl;
                }
                this.mFromBottomToTop = true;
            }
        }
    }
    
    private boolean shouldMeasureChild(final View view, final int n, final int n2, final RecyclerView.LayoutParams layoutParams) {
        return view.isLayoutRequested() || !((RecyclerView.LayoutManager)this).isMeasurementCacheEnabled() || !isMeasurementUpToDate(view.getWidth(), n, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), n2, layoutParams.height);
    }
    
    private boolean updateAnchorFromChildren(final State state, final AnchorInfo anchorInfo) {
        if (((RecyclerView.LayoutManager)this).getChildCount() != 0) {
            View view;
            if (anchorInfo.mLayoutFromEnd) {
                view = this.findLastReferenceChild(state.getItemCount());
            }
            else {
                view = this.findFirstReferenceChild(state.getItemCount());
            }
            if (view != null) {
                anchorInfo.assignFromView(view);
                if (!state.isPreLayout() && ((RecyclerView.LayoutManager)this).supportsPredictiveItemAnimations()) {
                    int n;
                    if (this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(view) < this.mOrientationHelper.getStartAfterPadding()) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    if (n != 0) {
                        int n2;
                        if (anchorInfo.mLayoutFromEnd) {
                            n2 = this.mOrientationHelper.getEndAfterPadding();
                        }
                        else {
                            n2 = this.mOrientationHelper.getStartAfterPadding();
                        }
                        anchorInfo.mCoordinate = n2;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    private boolean updateAnchorFromPendingState(final State state, final AnchorInfo anchorInfo, final SavedState savedState) {
        boolean b = false;
        assert this.mFlexboxHelper.mIndexToFlexLine != null;
        if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
            return false;
        }
        if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
        }
        anchorInfo.mPosition = this.mPendingScrollPosition;
        anchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[anchorInfo.mPosition];
        if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor(state.getItemCount())) {
            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
            anchorInfo.mAssignedFromSavedState = true;
            anchorInfo.mFlexLinePosition = -1;
            return true;
        }
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
            final View viewByPosition = ((RecyclerView.LayoutManager)this).findViewByPosition(this.mPendingScrollPosition);
            if (viewByPosition == null) {
                if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
                    if (this.mPendingScrollPosition < ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0))) {
                        b = true;
                    }
                    anchorInfo.mLayoutFromEnd = b;
                }
                anchorInfo.assignCoordinateFromPadding();
                return true;
            }
            if (this.mOrientationHelper.getDecoratedMeasurement(viewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                anchorInfo.assignCoordinateFromPadding();
                return true;
            }
            if (this.mOrientationHelper.getDecoratedStart(viewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                anchorInfo.mLayoutFromEnd = false;
                return true;
            }
            if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(viewByPosition) < 0) {
                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                anchorInfo.mLayoutFromEnd = true;
                return true;
            }
            int decoratedStart;
            if (anchorInfo.mLayoutFromEnd) {
                decoratedStart = this.mOrientationHelper.getDecoratedEnd(viewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
            }
            else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(viewByPosition);
            }
            anchorInfo.mCoordinate = decoratedStart;
            return true;
        }
        else {
            if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
                anchorInfo.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                return true;
            }
            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
            return true;
        }
    }
    
    private void updateAnchorInfoForLayout(final State state, final AnchorInfo anchorInfo) {
        if (!this.updateAnchorFromPendingState(state, anchorInfo, this.mPendingSavedState) && !this.updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = 0;
            anchorInfo.mFlexLinePosition = 0;
        }
    }
    
    private void updateDirtyPosition(final int mDirtyPosition) {
        final int firstVisibleItemPosition = this.findFirstVisibleItemPosition();
        final int lastVisibleItemPosition = this.findLastVisibleItemPosition();
        if (mDirtyPosition < lastVisibleItemPosition) {
            final int childCount = ((RecyclerView.LayoutManager)this).getChildCount();
            this.mFlexboxHelper.ensureMeasureSpecCache(childCount);
            this.mFlexboxHelper.ensureMeasuredSizeCache(childCount);
            this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
            assert this.mFlexboxHelper.mIndexToFlexLine != null;
            if (mDirtyPosition < this.mFlexboxHelper.mIndexToFlexLine.length) {
                this.mDirtyPosition = mDirtyPosition;
                final View childClosestToStart = this.getChildClosestToStart();
                if (childClosestToStart != null && (firstVisibleItemPosition > mDirtyPosition || mDirtyPosition > lastVisibleItemPosition)) {
                    this.mPendingScrollPosition = ((RecyclerView.LayoutManager)this).getPosition(childClosestToStart);
                    if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
                        this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToStart) + this.mOrientationHelper.getEndPadding();
                        return;
                    }
                    this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
                }
            }
        }
    }
    
    private void updateFlexLines(final int n) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(((RecyclerView.LayoutManager)this).getWidth(), ((RecyclerView.LayoutManager)this).getWidthMode());
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(((RecyclerView.LayoutManager)this).getHeight(), ((RecyclerView.LayoutManager)this).getHeightMode());
        final int width = ((RecyclerView.LayoutManager)this).getWidth();
        final int height = ((RecyclerView.LayoutManager)this).getHeight();
        boolean b;
        int n2;
        if (this.isMainAxisDirectionHorizontal()) {
            if (this.mLastWidth != Integer.MIN_VALUE && this.mLastWidth != width) {
                b = true;
            }
            else {
                b = false;
            }
            if (this.mLayoutState.mInfinite) {
                n2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            }
            else {
                n2 = this.mLayoutState.mAvailable;
            }
        }
        else {
            if (this.mLastHeight != Integer.MIN_VALUE && this.mLastHeight != height) {
                b = true;
            }
            else {
                b = false;
            }
            if (this.mLayoutState.mInfinite) {
                n2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            }
            else {
                n2 = this.mLayoutState.mAvailable;
            }
        }
        this.mLastWidth = width;
        this.mLastHeight = height;
        if (this.mDirtyPosition != -1 || (this.mPendingScrollPosition == -1 && !b)) {
            int n3;
            if (this.mDirtyPosition != -1) {
                n3 = Math.min(this.mDirtyPosition, this.mAnchorInfo.mPosition);
            }
            else {
                n3 = this.mAnchorInfo.mPosition;
            }
            this.mFlexLinesResult.reset();
            if (this.isMainAxisDirectionHorizontal()) {
                if (this.mFlexLines.size() > 0) {
                    this.mFlexboxHelper.clearFlexLines(this.mFlexLines, n3);
                    this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, measureSpec, measureSpec2, n2, n3, this.mAnchorInfo.mPosition, this.mFlexLines);
                }
                else {
                    this.mFlexboxHelper.ensureIndexToFlexLine(n);
                    this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, measureSpec, measureSpec2, n2, 0, this.mFlexLines);
                }
            }
            else if (this.mFlexLines.size() > 0) {
                this.mFlexboxHelper.clearFlexLines(this.mFlexLines, n3);
                this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, measureSpec2, measureSpec, n2, n3, this.mAnchorInfo.mPosition, this.mFlexLines);
            }
            else {
                this.mFlexboxHelper.ensureIndexToFlexLine(n);
                this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, measureSpec, measureSpec2, n2, 0, this.mFlexLines);
            }
            this.mFlexLines = this.mFlexLinesResult.mFlexLines;
            this.mFlexboxHelper.determineMainSize(measureSpec, measureSpec2, n3);
            this.mFlexboxHelper.stretchViews(n3);
            return;
        }
        if (this.mAnchorInfo.mLayoutFromEnd) {
            return;
        }
        this.mFlexLines.clear();
        assert this.mFlexboxHelper.mIndexToFlexLine != null;
        this.mFlexLinesResult.reset();
        if (this.isMainAxisDirectionHorizontal()) {
            this.mFlexboxHelper.calculateHorizontalFlexLinesToIndex(this.mFlexLinesResult, measureSpec, measureSpec2, n2, this.mAnchorInfo.mPosition, this.mFlexLines);
        }
        else {
            this.mFlexboxHelper.calculateVerticalFlexLinesToIndex(this.mFlexLinesResult, measureSpec, measureSpec2, n2, this.mAnchorInfo.mPosition, this.mFlexLines);
        }
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(measureSpec, measureSpec2);
        this.mFlexboxHelper.stretchViews();
        this.mAnchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mAnchorInfo.mPosition];
        this.mLayoutState.mFlexLinePosition = this.mAnchorInfo.mFlexLinePosition;
    }
    
    private void updateLayoutState(int n, final int n2) {
        assert this.mFlexboxHelper.mIndexToFlexLine != null;
        this.mLayoutState.mLayoutDirection = n;
        final boolean mainAxisDirectionHorizontal = this.isMainAxisDirectionHorizontal();
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(((RecyclerView.LayoutManager)this).getWidth(), ((RecyclerView.LayoutManager)this).getWidthMode());
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(((RecyclerView.LayoutManager)this).getHeight(), ((RecyclerView.LayoutManager)this).getHeightMode());
        boolean b;
        if (!mainAxisDirectionHorizontal && this.mIsRtl) {
            b = true;
        }
        else {
            b = false;
        }
        if (n == 1) {
            final View child = ((RecyclerView.LayoutManager)this).getChildAt(((RecyclerView.LayoutManager)this).getChildCount() - 1);
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(child);
            n = ((RecyclerView.LayoutManager)this).getPosition(child);
            final View lastReferenceViewInLine = this.findLastReferenceViewInLine(child, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[n]));
            this.mLayoutState.mItemDirection = 1;
            this.mLayoutState.mPosition = this.mLayoutState.mItemDirection + n;
            if (this.mFlexboxHelper.mIndexToFlexLine.length <= this.mLayoutState.mPosition) {
                this.mLayoutState.mFlexLinePosition = -1;
            }
            else {
                this.mLayoutState.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mLayoutState.mPosition];
            }
            if (b) {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(lastReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = -this.mOrientationHelper.getDecoratedStart(lastReferenceViewInLine) + this.mOrientationHelper.getStartAfterPadding();
                final LayoutState mLayoutState = this.mLayoutState;
                if (this.mLayoutState.mScrollingOffset >= 0) {
                    n = this.mLayoutState.mScrollingOffset;
                }
                else {
                    n = 0;
                }
                mLayoutState.mScrollingOffset = n;
            }
            else {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(lastReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(lastReferenceViewInLine) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mLayoutState.mFlexLinePosition == -1 || this.mLayoutState.mFlexLinePosition > this.mFlexLines.size() - 1) && this.mLayoutState.mPosition <= this.getFlexItemCount()) {
                n = n2 - this.mLayoutState.mScrollingOffset;
                this.mFlexLinesResult.reset();
                if (n > 0) {
                    if (mainAxisDirectionHorizontal) {
                        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, measureSpec, measureSpec2, n, this.mLayoutState.mPosition, this.mFlexLines);
                    }
                    else {
                        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, measureSpec, measureSpec2, n, this.mLayoutState.mPosition, this.mFlexLines);
                    }
                    this.mFlexboxHelper.determineMainSize(measureSpec, measureSpec2, this.mLayoutState.mPosition);
                    this.mFlexboxHelper.stretchViews(this.mLayoutState.mPosition);
                }
            }
        }
        else {
            final View child2 = ((RecyclerView.LayoutManager)this).getChildAt(0);
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(child2);
            final int position = ((RecyclerView.LayoutManager)this).getPosition(child2);
            n = this.mFlexboxHelper.mIndexToFlexLine[position];
            final View firstReferenceViewInLine = this.findFirstReferenceViewInLine(child2, this.mFlexLines.get(n));
            this.mLayoutState.mItemDirection = 1;
            if ((n = this.mFlexboxHelper.mIndexToFlexLine[position]) == -1) {
                n = 0;
            }
            if (n > 0) {
                this.mLayoutState.mPosition = position - this.mFlexLines.get(n - 1).getItemCount();
            }
            else {
                this.mLayoutState.mPosition = -1;
            }
            final LayoutState mLayoutState2 = this.mLayoutState;
            if (n > 0) {
                --n;
            }
            else {
                n = 0;
            }
            mLayoutState2.mFlexLinePosition = n;
            if (b) {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(firstReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(firstReferenceViewInLine) - this.mOrientationHelper.getEndAfterPadding();
                final LayoutState mLayoutState3 = this.mLayoutState;
                if (this.mLayoutState.mScrollingOffset >= 0) {
                    n = this.mLayoutState.mScrollingOffset;
                }
                else {
                    n = 0;
                }
                mLayoutState3.mScrollingOffset = n;
            }
            else {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(firstReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = -this.mOrientationHelper.getDecoratedStart(firstReferenceViewInLine) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        this.mLayoutState.mAvailable = n2 - this.mLayoutState.mScrollingOffset;
    }
    
    private void updateLayoutStateToFillEnd(final AnchorInfo anchorInfo, final boolean b, final boolean b2) {
        if (b2) {
            this.resolveInfiniteAmount();
        }
        else {
            this.mLayoutState.mInfinite = false;
        }
        if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mLayoutState.mAvailable = anchorInfo.mCoordinate - ((RecyclerView.LayoutManager)this).getPaddingRight();
        }
        else {
            this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - anchorInfo.mCoordinate;
        }
        this.mLayoutState.mPosition = anchorInfo.mPosition;
        this.mLayoutState.mItemDirection = 1;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (b && this.mFlexLines.size() > 1 && anchorInfo.mFlexLinePosition >= 0 && anchorInfo.mFlexLinePosition < this.mFlexLines.size() - 1) {
            final FlexLine flexLine = this.mFlexLines.get(anchorInfo.mFlexLinePosition);
            this.mLayoutState.mFlexLinePosition++;
            final LayoutState mLayoutState = this.mLayoutState;
            mLayoutState.mPosition += flexLine.getItemCount();
        }
    }
    
    private void updateLayoutStateToFillStart(final AnchorInfo anchorInfo, final boolean b, final boolean b2) {
        if (b2) {
            this.resolveInfiniteAmount();
        }
        else {
            this.mLayoutState.mInfinite = false;
        }
        if (!this.isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mLayoutState.mAvailable = this.mParent.getWidth() - anchorInfo.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        else {
            this.mLayoutState.mAvailable = anchorInfo.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mPosition = anchorInfo.mPosition;
        this.mLayoutState.mItemDirection = 1;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (b && anchorInfo.mFlexLinePosition > 0 && this.mFlexLines.size() > anchorInfo.mFlexLinePosition) {
            final FlexLine flexLine = this.mFlexLines.get(anchorInfo.mFlexLinePosition);
            this.mLayoutState.mFlexLinePosition--;
            final LayoutState mLayoutState = this.mLayoutState;
            mLayoutState.mPosition -= flexLine.getItemCount();
        }
    }
    
    @Override
    public boolean canScrollHorizontally() {
        return !this.isMainAxisDirectionHorizontal() || ((RecyclerView.LayoutManager)this).getWidth() > this.mParent.getWidth();
    }
    
    @Override
    public boolean canScrollVertically() {
        return this.isMainAxisDirectionHorizontal() || ((RecyclerView.LayoutManager)this).getHeight() > this.mParent.getHeight();
    }
    
    @Override
    public boolean checkLayoutParams(final RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
    
    @Override
    public int computeHorizontalScrollExtent(final State state) {
        return this.computeScrollExtent(state);
    }
    
    @Override
    public int computeHorizontalScrollOffset(final State state) {
        this.computeScrollOffset(state);
        return this.computeScrollOffset(state);
    }
    
    @Override
    public int computeHorizontalScrollRange(final State state) {
        return this.computeScrollRange(state);
    }
    
    @Override
    public PointF computeScrollVectorForPosition(int n) {
        if (((RecyclerView.LayoutManager)this).getChildCount() == 0) {
            return null;
        }
        if (n < ((RecyclerView.LayoutManager)this).getPosition(((RecyclerView.LayoutManager)this).getChildAt(0))) {
            n = -1;
        }
        else {
            n = 1;
        }
        if (this.isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, (float)n);
        }
        return new PointF((float)n, 0.0f);
    }
    
    @Override
    public int computeVerticalScrollExtent(final State state) {
        return this.computeScrollExtent(state);
    }
    
    @Override
    public int computeVerticalScrollOffset(final State state) {
        return this.computeScrollOffset(state);
    }
    
    @Override
    public int computeVerticalScrollRange(final State state) {
        return this.computeScrollRange(state);
    }
    
    public int findFirstCompletelyVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(0, ((RecyclerView.LayoutManager)this).getChildCount(), true);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    public int findFirstVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(0, ((RecyclerView.LayoutManager)this).getChildCount(), false);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    public int findLastCompletelyVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(((RecyclerView.LayoutManager)this).getChildCount() - 1, -1, true);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    public int findLastVisibleItemPosition() {
        final View oneVisibleChild = this.findOneVisibleChild(((RecyclerView.LayoutManager)this).getChildCount() - 1, -1, false);
        if (oneVisibleChild == null) {
            return -1;
        }
        return ((RecyclerView.LayoutManager)this).getPosition(oneVisibleChild);
    }
    
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }
    
    @Override
    public RecyclerView.LayoutParams generateLayoutParams(final Context context, final AttributeSet set) {
        return new LayoutParams(context, set);
    }
    
    @Override
    public int getAlignContent() {
        return 5;
    }
    
    @Override
    public int getAlignItems() {
        return this.mAlignItems;
    }
    
    @Override
    public int getChildHeightMeasureSpec(final int n, final int n2, final int n3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(((RecyclerView.LayoutManager)this).getHeight(), ((RecyclerView.LayoutManager)this).getHeightMode(), n2, n3, this.canScrollVertically());
    }
    
    @Override
    public int getChildWidthMeasureSpec(final int n, final int n2, final int n3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(((RecyclerView.LayoutManager)this).getWidth(), ((RecyclerView.LayoutManager)this).getWidthMode(), n2, n3, this.canScrollHorizontally());
    }
    
    @Override
    public int getDecorationLengthCrossAxis(final View view) {
        if (this.isMainAxisDirectionHorizontal()) {
            return ((RecyclerView.LayoutManager)this).getTopDecorationHeight(view) + ((RecyclerView.LayoutManager)this).getBottomDecorationHeight(view);
        }
        return ((RecyclerView.LayoutManager)this).getLeftDecorationWidth(view) + ((RecyclerView.LayoutManager)this).getRightDecorationWidth(view);
    }
    
    @Override
    public int getDecorationLengthMainAxis(final View view, final int n, final int n2) {
        if (this.isMainAxisDirectionHorizontal()) {
            return ((RecyclerView.LayoutManager)this).getLeftDecorationWidth(view) + ((RecyclerView.LayoutManager)this).getRightDecorationWidth(view);
        }
        return ((RecyclerView.LayoutManager)this).getTopDecorationHeight(view) + ((RecyclerView.LayoutManager)this).getBottomDecorationHeight(view);
    }
    
    @Override
    public int getFlexDirection() {
        return this.mFlexDirection;
    }
    
    @Override
    public View getFlexItemAt(final int n) {
        final View view = (View)this.mViewCache.get(n);
        if (view != null) {
            return view;
        }
        return this.mRecycler.getViewForPosition(n);
    }
    
    @Override
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }
    
    @Override
    public List<FlexLine> getFlexLines() {
        final ArrayList<FlexLine> list = new ArrayList<FlexLine>(this.mFlexLines.size());
        for (int i = 0; i < this.mFlexLines.size(); ++i) {
            final FlexLine flexLine = this.mFlexLines.get(i);
            if (flexLine.getItemCount() != 0) {
                list.add(flexLine);
            }
        }
        return list;
    }
    
    @Override
    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }
    
    @Override
    public int getFlexWrap() {
        return this.mFlexWrap;
    }
    
    @Override
    public int getJustifyContent() {
        return this.mJustifyContent;
    }
    
    @Override
    public int getLargestMainSize() {
        int n;
        if (this.mFlexLines.size() == 0) {
            n = 0;
        }
        else {
            int max = Integer.MIN_VALUE;
            int n2 = 0;
            final int size = this.mFlexLines.size();
            while (true) {
                n = max;
                if (n2 >= size) {
                    break;
                }
                max = Math.max(max, this.mFlexLines.get(n2).mMainSize);
                ++n2;
            }
        }
        return n;
    }
    
    int getPositionToFlexLineIndex(final int n) {
        assert this.mFlexboxHelper.mIndexToFlexLine != null;
        return this.mFlexboxHelper.mIndexToFlexLine[n];
    }
    
    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }
    
    @Override
    public View getReorderedFlexItemAt(final int n) {
        return this.getFlexItemAt(n);
    }
    
    @Override
    public int getSumOfCrossSize() {
        int n = 0;
        for (int i = 0; i < this.mFlexLines.size(); ++i) {
            n += this.mFlexLines.get(i).mCrossSize;
        }
        return n;
    }
    
    boolean isLayoutRtl() {
        return this.mIsRtl;
    }
    
    @Override
    public boolean isMainAxisDirectionHorizontal() {
        return this.mFlexDirection == 0 || this.mFlexDirection == 1;
    }
    
    @Override
    public void onAdapterChanged(final Adapter adapter, final Adapter adapter2) {
        ((RecyclerView.LayoutManager)this).removeAllViews();
    }
    
    @Override
    public void onAttachedToWindow(final RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mParent = (View)recyclerView.getParent();
    }
    
    @Override
    public void onDetachedFromWindow(final RecyclerView recyclerView, final Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            ((RecyclerView.LayoutManager)this).removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }
    
    @Override
    public void onItemsAdded(final RecyclerView recyclerView, final int n, final int n2) {
        super.onItemsAdded(recyclerView, n, n2);
        this.updateDirtyPosition(n);
    }
    
    @Override
    public void onItemsMoved(final RecyclerView recyclerView, final int a, final int b, final int n) {
        super.onItemsMoved(recyclerView, a, b, n);
        this.updateDirtyPosition(Math.min(a, b));
    }
    
    @Override
    public void onItemsRemoved(final RecyclerView recyclerView, final int n, final int n2) {
        super.onItemsRemoved(recyclerView, n, n2);
        this.updateDirtyPosition(n);
    }
    
    @Override
    public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2) {
        super.onItemsUpdated(recyclerView, n, n2);
        this.updateDirtyPosition(n);
    }
    
    @Override
    public void onItemsUpdated(final RecyclerView recyclerView, final int n, final int n2, final Object o) {
        super.onItemsUpdated(recyclerView, n, n2, o);
        this.updateDirtyPosition(n);
    }
    
    @Override
    public void onLayoutChildren(final Recycler mRecycler, final State mState) {
        this.mRecycler = mRecycler;
        this.mState = mState;
        final int itemCount = mState.getItemCount();
        if (itemCount != 0 || !mState.isPreLayout()) {
            this.resolveLayoutDirection();
            this.ensureOrientationHelper();
            this.ensureLayoutState();
            this.mFlexboxHelper.ensureMeasureSpecCache(itemCount);
            this.mFlexboxHelper.ensureMeasuredSizeCache(itemCount);
            this.mFlexboxHelper.ensureIndexToFlexLine(itemCount);
            this.mLayoutState.mShouldRecycle = false;
            if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor(itemCount)) {
                this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            }
            if (!this.mAnchorInfo.mValid || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
                this.mAnchorInfo.reset();
                this.updateAnchorInfoForLayout(mState, this.mAnchorInfo);
                this.mAnchorInfo.mValid = true;
            }
            ((RecyclerView.LayoutManager)this).detachAndScrapAttachedViews(mRecycler);
            if (this.mAnchorInfo.mLayoutFromEnd) {
                this.updateLayoutStateToFillStart(this.mAnchorInfo, false, true);
            }
            else {
                this.updateLayoutStateToFillEnd(this.mAnchorInfo, false, true);
            }
            this.updateFlexLines(itemCount);
            int n;
            int n2;
            if (this.mAnchorInfo.mLayoutFromEnd) {
                this.fill(mRecycler, mState, this.mLayoutState);
                n = this.mLayoutState.mOffset;
                this.updateLayoutStateToFillEnd(this.mAnchorInfo, true, false);
                this.fill(mRecycler, mState, this.mLayoutState);
                n2 = this.mLayoutState.mOffset;
            }
            else {
                this.fill(mRecycler, mState, this.mLayoutState);
                n2 = this.mLayoutState.mOffset;
                this.updateLayoutStateToFillStart(this.mAnchorInfo, true, false);
                this.fill(mRecycler, mState, this.mLayoutState);
                n = this.mLayoutState.mOffset;
            }
            if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
                if (this.mAnchorInfo.mLayoutFromEnd) {
                    this.fixLayoutStartGap(n + this.fixLayoutEndGap(n2, mRecycler, mState, true), mRecycler, mState, false);
                    return;
                }
                this.fixLayoutEndGap(n2 + this.fixLayoutStartGap(n, mRecycler, mState, true), mRecycler, mState, false);
            }
        }
    }
    
    @Override
    public void onLayoutCompleted(final State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mDirtyPosition = -1;
        this.mAnchorInfo.reset();
        this.mViewCache.clear();
    }
    
    @Override
    public void onNewFlexItemAdded(final View view, int n, final int n2, final FlexLine flexLine) {
        ((RecyclerView.LayoutManager)this).calculateItemDecorationsForChild(view, FlexboxLayoutManager.TEMP_RECT);
        if (this.isMainAxisDirectionHorizontal()) {
            n = ((RecyclerView.LayoutManager)this).getLeftDecorationWidth(view) + ((RecyclerView.LayoutManager)this).getRightDecorationWidth(view);
            flexLine.mMainSize += n;
            flexLine.mDividerLengthInMainSize += n;
            return;
        }
        n = ((RecyclerView.LayoutManager)this).getTopDecorationHeight(view) + ((RecyclerView.LayoutManager)this).getBottomDecorationHeight(view);
        flexLine.mMainSize += n;
        flexLine.mDividerLengthInMainSize += n;
    }
    
    @Override
    public void onNewFlexLineAdded(final FlexLine flexLine) {
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState)parcelable;
            ((RecyclerView.LayoutManager)this).requestLayout();
        }
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return (Parcelable)new SavedState(this.mPendingSavedState);
        }
        final SavedState savedState = new SavedState();
        if (((RecyclerView.LayoutManager)this).getChildCount() > 0) {
            final View childClosestToStart = this.getChildClosestToStart();
            savedState.mAnchorPosition = ((RecyclerView.LayoutManager)this).getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            return (Parcelable)savedState;
        }
        savedState.invalidateAnchor();
        return (Parcelable)savedState;
    }
    
    @Override
    public int scrollHorizontallyBy(int n, final Recycler recycler, final State state) {
        if (!this.isMainAxisDirectionHorizontal()) {
            n = this.handleScrollingCrossAxis(n, recycler, state);
            this.mViewCache.clear();
            return n;
        }
        n = this.handleScrollingMainAxis(n);
        final AnchorInfo mAnchorInfo = this.mAnchorInfo;
        mAnchorInfo.mPerpendicularCoordinate += n;
        this.mSubOrientationHelper.offsetChildren(-n);
        return n;
    }
    
    @Override
    public void scrollToPosition(final int mPendingScrollPosition) {
        this.mPendingScrollPosition = mPendingScrollPosition;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchor();
        }
        ((RecyclerView.LayoutManager)this).requestLayout();
    }
    
    @Override
    public int scrollVerticallyBy(int n, final Recycler recycler, final State state) {
        if (this.isMainAxisDirectionHorizontal()) {
            n = this.handleScrollingCrossAxis(n, recycler, state);
            this.mViewCache.clear();
            return n;
        }
        n = this.handleScrollingMainAxis(n);
        final AnchorInfo mAnchorInfo = this.mAnchorInfo;
        mAnchorInfo.mPerpendicularCoordinate += n;
        this.mSubOrientationHelper.offsetChildren(-n);
        return n;
    }
    
    @Override
    public void setAlignContent(final int n) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }
    
    @Override
    public void setAlignItems(final int mAlignItems) {
        if (this.mAlignItems != mAlignItems) {
            if (this.mAlignItems == 4 || mAlignItems == 4) {
                ((RecyclerView.LayoutManager)this).removeAllViews();
                this.clearFlexLines();
            }
            this.mAlignItems = mAlignItems;
            ((RecyclerView.LayoutManager)this).requestLayout();
        }
    }
    
    @Override
    public void setFlexDirection(final int mFlexDirection) {
        if (this.mFlexDirection != mFlexDirection) {
            ((RecyclerView.LayoutManager)this).removeAllViews();
            this.mFlexDirection = mFlexDirection;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            this.clearFlexLines();
            ((RecyclerView.LayoutManager)this).requestLayout();
        }
    }
    
    @Override
    public void setFlexLines(final List<FlexLine> mFlexLines) {
        this.mFlexLines = mFlexLines;
    }
    
    @Override
    public void setFlexWrap(final int mFlexWrap) {
        if (mFlexWrap == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        if (this.mFlexWrap != mFlexWrap) {
            if (this.mFlexWrap == 0 || mFlexWrap == 0) {
                ((RecyclerView.LayoutManager)this).removeAllViews();
                this.clearFlexLines();
            }
            this.mFlexWrap = mFlexWrap;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            ((RecyclerView.LayoutManager)this).requestLayout();
        }
    }
    
    @Override
    public void setJustifyContent(final int mJustifyContent) {
        if (this.mJustifyContent != mJustifyContent) {
            this.mJustifyContent = mJustifyContent;
            ((RecyclerView.LayoutManager)this).requestLayout();
        }
    }
    
    public void setRecycleChildrenOnDetach(final boolean mRecycleChildrenOnDetach) {
        this.mRecycleChildrenOnDetach = mRecycleChildrenOnDetach;
    }
    
    @Override
    public void smoothScrollToPosition(final RecyclerView recyclerView, final State state, final int targetPosition) {
        final LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        ((RecyclerView.SmoothScroller)linearSmoothScroller).setTargetPosition(targetPosition);
        ((RecyclerView.LayoutManager)this).startSmoothScroll(linearSmoothScroller);
    }
    
    @Override
    public void updateViewCache(final int n, final View view) {
        this.mViewCache.put(n, (Object)view);
    }
    
    private class AnchorInfo
    {
        private boolean mAssignedFromSavedState;
        private int mCoordinate;
        private int mFlexLinePosition;
        private boolean mLayoutFromEnd;
        private int mPerpendicularCoordinate;
        private int mPosition;
        private boolean mValid;
        
        private AnchorInfo() {
            this.mPerpendicularCoordinate = 0;
        }
        
        private void assignCoordinateFromPadding() {
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.mIsRtl) {
                int endAfterPadding;
                if (this.mLayoutFromEnd) {
                    endAfterPadding = FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding();
                }
                else {
                    endAfterPadding = ((RecyclerView.LayoutManager)FlexboxLayoutManager.this).getWidth() - FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
                }
                this.mCoordinate = endAfterPadding;
                return;
            }
            int mCoordinate;
            if (this.mLayoutFromEnd) {
                mCoordinate = FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding();
            }
            else {
                mCoordinate = FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = mCoordinate;
        }
        
        private void assignFromView(final View view) {
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = FlexboxLayoutManager.this.mOrientationHelper.getDecoratedStart(view) + FlexboxLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
                }
                else {
                    this.mCoordinate = FlexboxLayoutManager.this.mOrientationHelper.getDecoratedEnd(view);
                }
            }
            else if (this.mLayoutFromEnd) {
                this.mCoordinate = FlexboxLayoutManager.this.mOrientationHelper.getDecoratedEnd(view) + FlexboxLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
            }
            else {
                this.mCoordinate = FlexboxLayoutManager.this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = ((RecyclerView.LayoutManager)FlexboxLayoutManager.this).getPosition(view);
            this.mAssignedFromSavedState = false;
            assert FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine != null;
            int mFlexLinePosition = FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine[this.mPosition];
            if (mFlexLinePosition == -1) {
                mFlexLinePosition = 0;
            }
            this.mFlexLinePosition = mFlexLinePosition;
            if (FlexboxLayoutManager.this.mFlexLines.size() > this.mFlexLinePosition) {
                this.mPosition = FlexboxLayoutManager.this.mFlexLines.get(this.mFlexLinePosition).mFirstIndex;
            }
        }
        
        private void reset() {
            final boolean b = true;
            final boolean b2 = true;
            final boolean b3 = true;
            boolean mLayoutFromEnd = true;
            this.mPosition = -1;
            this.mFlexLinePosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mAssignedFromSavedState = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                    if (FlexboxLayoutManager.this.mFlexDirection != 1) {
                        mLayoutFromEnd = false;
                    }
                    this.mLayoutFromEnd = mLayoutFromEnd;
                    return;
                }
                this.mLayoutFromEnd = (FlexboxLayoutManager.this.mFlexWrap == 2 && b);
            }
            else {
                if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                    this.mLayoutFromEnd = (FlexboxLayoutManager.this.mFlexDirection == 3 && b2);
                    return;
                }
                this.mLayoutFromEnd = (FlexboxLayoutManager.this.mFlexWrap == 2 && b3);
            }
        }
        
        @Override
        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mPerpendicularCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mAssignedFromSavedState + '}';
        }
    }
    
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem
    {
        public static final Parcelable$Creator<LayoutParams> CREATOR;
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<LayoutParams>() {
                public LayoutParams createFromParcel(final Parcel parcel) {
                    return new LayoutParams(parcel);
                }
                
                public LayoutParams[] newArray(final int n) {
                    return new LayoutParams[n];
                }
            };
        }
        
        public LayoutParams(final int n, final int n2) {
            super(n, n2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        public LayoutParams(final Context context, final AttributeSet set) {
            super(context, set);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        protected LayoutParams(final Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = (parcel.readByte() != 0);
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
        
        public LayoutParams(final RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        public LayoutParams(final LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams)layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }
        
        public int describeContents() {
            return 0;
        }
        
        @Override
        public int getAlignSelf() {
            return this.mAlignSelf;
        }
        
        @Override
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }
        
        @Override
        public float getFlexGrow() {
            return this.mFlexGrow;
        }
        
        @Override
        public float getFlexShrink() {
            return this.mFlexShrink;
        }
        
        @Override
        public int getHeight() {
            return this.height;
        }
        
        @Override
        public int getMarginBottom() {
            return this.bottomMargin;
        }
        
        @Override
        public int getMarginLeft() {
            return this.leftMargin;
        }
        
        @Override
        public int getMarginRight() {
            return this.rightMargin;
        }
        
        @Override
        public int getMarginTop() {
            return this.topMargin;
        }
        
        @Override
        public int getMaxHeight() {
            return this.mMaxHeight;
        }
        
        @Override
        public int getMaxWidth() {
            return this.mMaxWidth;
        }
        
        @Override
        public int getMinHeight() {
            return this.mMinHeight;
        }
        
        @Override
        public int getMinWidth() {
            return this.mMinWidth;
        }
        
        @Override
        public int getOrder() {
            return 1;
        }
        
        @Override
        public int getWidth() {
            return this.width;
        }
        
        @Override
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }
        
        @Override
        public void setAlignSelf(final int mAlignSelf) {
            this.mAlignSelf = mAlignSelf;
        }
        
        @Override
        public void setFlexBasisPercent(final float mFlexBasisPercent) {
            this.mFlexBasisPercent = mFlexBasisPercent;
        }
        
        @Override
        public void setFlexGrow(final float mFlexGrow) {
            this.mFlexGrow = mFlexGrow;
        }
        
        @Override
        public void setFlexShrink(final float mFlexShrink) {
            this.mFlexShrink = mFlexShrink;
        }
        
        @Override
        public void setHeight(final int height) {
            this.height = height;
        }
        
        @Override
        public void setMaxHeight(final int mMaxHeight) {
            this.mMaxHeight = mMaxHeight;
        }
        
        @Override
        public void setMaxWidth(final int mMaxWidth) {
            this.mMaxWidth = mMaxWidth;
        }
        
        @Override
        public void setMinHeight(final int mMinHeight) {
            this.mMinHeight = mMinHeight;
        }
        
        @Override
        public void setMinWidth(final int mMinWidth) {
            this.mMinWidth = mMinWidth;
        }
        
        @Override
        public void setOrder(final int n) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }
        
        @Override
        public void setWidth(final int width) {
            this.width = width;
        }
        
        @Override
        public void setWrapBefore(final boolean mWrapBefore) {
            this.mWrapBefore = mWrapBefore;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            byte b;
            if (this.mWrapBefore) {
                b = 1;
            }
            else {
                b = 0;
            }
            parcel.writeByte(b);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }
    }
    
    private static class LayoutState
    {
        private static final int ITEM_DIRECTION_TAIL = 1;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;
        private static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        private int mAvailable;
        private int mFlexLinePosition;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private boolean mShouldRecycle;
        
        private LayoutState() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }
        
        private boolean hasMore(final State state, final List<FlexLine> list) {
            return this.mPosition >= 0 && this.mPosition < state.getItemCount() && this.mFlexLinePosition >= 0 && this.mFlexLinePosition < list.size();
        }
        
        @Override
        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }
    
    private static class SavedState implements Parcelable
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        private int mAnchorOffset;
        private int mAnchorPosition;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState createFromParcel(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] newArray(final int n) {
                    return new SavedState[n];
                }
            };
        }
        
        SavedState() {
        }
        
        private SavedState(final Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }
        
        private SavedState(final SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
        
        private boolean hasValidAnchor(final int n) {
            return this.mAnchorPosition >= 0 && this.mAnchorPosition < n;
        }
        
        private void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }
        
        public int describeContents() {
            return 0;
        }
        
        @Override
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }
    }
}
