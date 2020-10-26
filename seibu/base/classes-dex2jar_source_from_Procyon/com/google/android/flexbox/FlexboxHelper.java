// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import android.support.annotation.VisibleForTesting;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.ViewCompat;
import java.util.Iterator;
import java.util.Collections;
import android.util.SparseIntArray;
import java.util.Arrays;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import android.view.View$MeasureSpec;
import android.view.View;
import java.util.List;
import android.support.annotation.Nullable;

class FlexboxHelper
{
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;
    @Nullable
    int[] mIndexToFlexLine;
    @Nullable
    long[] mMeasureSpecCache;
    @Nullable
    private long[] mMeasuredSizeCache;
    
    FlexboxHelper(final FlexContainer mFlexContainer) {
        this.mFlexContainer = mFlexContainer;
    }
    
    private void addFlexLine(final List<FlexLine> list, final FlexLine flexLine, final int mLastIndex, final int mSumCrossSizeBefore) {
        flexLine.mSumCrossSizeBefore = mSumCrossSizeBefore;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = mLastIndex;
        list.add(flexLine);
    }
    
    private void checkSizeConstraints(final View view, final int n) {
        int n2 = 0;
        final FlexItem flexItem = (FlexItem)view.getLayoutParams();
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        int n3;
        if (measuredWidth < flexItem.getMinWidth()) {
            n2 = 1;
            n3 = flexItem.getMinWidth();
        }
        else if ((n3 = measuredWidth) > flexItem.getMaxWidth()) {
            n2 = 1;
            n3 = flexItem.getMaxWidth();
        }
        int n4;
        if (measuredHeight < flexItem.getMinHeight()) {
            n2 = 1;
            n4 = flexItem.getMinHeight();
        }
        else if ((n4 = measuredHeight) > flexItem.getMaxHeight()) {
            n2 = 1;
            n4 = flexItem.getMaxHeight();
        }
        if (n2 != 0) {
            final int measureSpec = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
            final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(n4, 1073741824);
            view.measure(measureSpec, measureSpec2);
            this.updateMeasureCache(n, measureSpec, measureSpec2, view);
            this.mFlexContainer.updateViewCache(n, view);
        }
    }
    
    private List<FlexLine> constructFlexLinesForAlignContentCenter(final List<FlexLine> list, int i, int size) {
        i = (i - size) / 2;
        final ArrayList<FlexLine> list2 = new ArrayList<FlexLine>();
        final FlexLine flexLine = new FlexLine();
        flexLine.mCrossSize = i;
        for (i = 0, size = list.size(); i < size; ++i) {
            if (i == 0) {
                list2.add(flexLine);
            }
            list2.add(list.get(i));
            if (i == list.size() - 1) {
                list2.add(flexLine);
            }
        }
        return list2;
    }
    
    @NonNull
    private List<Order> createOrders(final int initialCapacity) {
        final ArrayList<Order> list = new ArrayList<Order>(initialCapacity);
        for (int i = 0; i < initialCapacity; ++i) {
            final FlexItem flexItem = (FlexItem)this.mFlexContainer.getFlexItemAt(i).getLayoutParams();
            final Order order = new Order();
            order.order = flexItem.getOrder();
            order.index = i;
            list.add(order);
        }
        return list;
    }
    
    private void ensureChildrenFrozen(int n) {
        if (this.mChildrenFrozen == null) {
            int n2;
            if ((n2 = n) < 10) {
                n2 = 10;
            }
            this.mChildrenFrozen = new boolean[n2];
            return;
        }
        if (this.mChildrenFrozen.length < n) {
            final int n3 = this.mChildrenFrozen.length * 2;
            if (n3 >= n) {
                n = n3;
            }
            this.mChildrenFrozen = new boolean[n];
            return;
        }
        Arrays.fill(this.mChildrenFrozen, false);
    }
    
    private void expandFlexItems(final int n, final int n2, final FlexLine flexLine, final int n3, final int n4, final boolean b) {
        if (flexLine.mTotalFlexGrow > 0.0f && n3 >= flexLine.mMainSize) {
            final int mMainSize = flexLine.mMainSize;
            int n5 = 0;
            final float n6 = (n3 - flexLine.mMainSize) / flexLine.mTotalFlexGrow;
            flexLine.mMainSize = flexLine.mDividerLengthInMainSize + n4;
            int n7 = 0;
            if (!b) {
                flexLine.mCrossSize = Integer.MIN_VALUE;
            }
            float n8 = 0.0f;
            float n10;
            int n11;
            int n12;
            for (int i = 0; i < flexLine.mItemCount; ++i, n8 = n10, n7 = n11, n5 = n12) {
                final int n9 = flexLine.mFirstIndex + i;
                final View reorderedFlexItem = this.mFlexContainer.getReorderedFlexItemAt(n9);
                n10 = n8;
                n11 = n7;
                n12 = n5;
                if (reorderedFlexItem != null) {
                    if (reorderedFlexItem.getVisibility() == 8) {
                        n12 = n5;
                        n11 = n7;
                        n10 = n8;
                    }
                    else {
                        final FlexItem flexItem = (FlexItem)reorderedFlexItem.getLayoutParams();
                        final int flexDirection = this.mFlexContainer.getFlexDirection();
                        int b2;
                        if (flexDirection == 0 || flexDirection == 1) {
                            int n13 = reorderedFlexItem.getMeasuredWidth();
                            if (this.mMeasuredSizeCache != null) {
                                n13 = this.extractLowerInt(this.mMeasuredSizeCache[n9]);
                            }
                            int n14 = reorderedFlexItem.getMeasuredHeight();
                            if (this.mMeasuredSizeCache != null) {
                                n14 = this.extractHigherInt(this.mMeasuredSizeCache[n9]);
                            }
                            n10 = n8;
                            int measuredHeight = n14;
                            int measuredWidth = n13;
                            n12 = n5;
                            if (!this.mChildrenFrozen[n9]) {
                                n10 = n8;
                                measuredHeight = n14;
                                measuredWidth = n13;
                                n12 = n5;
                                if (flexItem.getFlexGrow() > 0.0f) {
                                    final float n15 = n13 + flexItem.getFlexGrow() * n6;
                                    float n16 = n8;
                                    float a = n15;
                                    if (i == flexLine.mItemCount - 1) {
                                        a = n15 + n8;
                                        n16 = 0.0f;
                                    }
                                    final int round = Math.round(a);
                                    int maxWidth;
                                    float n17;
                                    if (round > flexItem.getMaxWidth()) {
                                        n12 = 1;
                                        maxWidth = flexItem.getMaxWidth();
                                        this.mChildrenFrozen[n9] = true;
                                        flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                                        n17 = n16;
                                    }
                                    else {
                                        final float n18 = n16 + (a - round);
                                        if (n18 > 1.0) {
                                            maxWidth = round + 1;
                                            n17 = (float)(n18 - 1.0);
                                            n12 = n5;
                                        }
                                        else {
                                            n17 = n18;
                                            n12 = n5;
                                            maxWidth = round;
                                            if (n18 < -1.0) {
                                                maxWidth = round - 1;
                                                n17 = (float)(n18 + 1.0);
                                                n12 = n5;
                                            }
                                        }
                                    }
                                    final int childHeightMeasureSpecInternal = this.getChildHeightMeasureSpecInternal(n2, flexItem, flexLine.mSumCrossSizeBefore);
                                    final int measureSpec = View$MeasureSpec.makeMeasureSpec(maxWidth, 1073741824);
                                    reorderedFlexItem.measure(measureSpec, childHeightMeasureSpecInternal);
                                    measuredWidth = reorderedFlexItem.getMeasuredWidth();
                                    measuredHeight = reorderedFlexItem.getMeasuredHeight();
                                    this.updateMeasureCache(n9, measureSpec, childHeightMeasureSpecInternal, reorderedFlexItem);
                                    this.mFlexContainer.updateViewCache(n9, reorderedFlexItem);
                                    n10 = n17;
                                }
                            }
                            b2 = Math.max(n7, flexItem.getMarginTop() + measuredHeight + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItem));
                            flexLine.mMainSize += flexItem.getMarginLeft() + measuredWidth + flexItem.getMarginRight();
                        }
                        else {
                            int n19 = reorderedFlexItem.getMeasuredHeight();
                            if (this.mMeasuredSizeCache != null) {
                                n19 = this.extractHigherInt(this.mMeasuredSizeCache[n9]);
                            }
                            int n20 = reorderedFlexItem.getMeasuredWidth();
                            if (this.mMeasuredSizeCache != null) {
                                n20 = this.extractLowerInt(this.mMeasuredSizeCache[n9]);
                            }
                            n10 = n8;
                            int measuredHeight2 = n19;
                            int measuredWidth2 = n20;
                            n12 = n5;
                            if (!this.mChildrenFrozen[n9]) {
                                n10 = n8;
                                measuredHeight2 = n19;
                                measuredWidth2 = n20;
                                n12 = n5;
                                if (flexItem.getFlexGrow() > 0.0f) {
                                    final float n21 = n19 + flexItem.getFlexGrow() * n6;
                                    float n22 = n8;
                                    float a2 = n21;
                                    if (i == flexLine.mItemCount - 1) {
                                        a2 = n21 + n8;
                                        n22 = 0.0f;
                                    }
                                    final int round2 = Math.round(a2);
                                    int maxHeight;
                                    float n23;
                                    if (round2 > flexItem.getMaxHeight()) {
                                        n12 = 1;
                                        maxHeight = flexItem.getMaxHeight();
                                        this.mChildrenFrozen[n9] = true;
                                        flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                                        n23 = n22;
                                    }
                                    else {
                                        final float n24 = n22 + (a2 - round2);
                                        if (n24 > 1.0) {
                                            maxHeight = round2 + 1;
                                            n23 = (float)(n24 - 1.0);
                                            n12 = n5;
                                        }
                                        else {
                                            n23 = n24;
                                            n12 = n5;
                                            maxHeight = round2;
                                            if (n24 < -1.0) {
                                                maxHeight = round2 - 1;
                                                n23 = (float)(n24 + 1.0);
                                                n12 = n5;
                                            }
                                        }
                                    }
                                    final int childWidthMeasureSpecInternal = this.getChildWidthMeasureSpecInternal(n, flexItem, flexLine.mSumCrossSizeBefore);
                                    final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(maxHeight, 1073741824);
                                    reorderedFlexItem.measure(childWidthMeasureSpecInternal, measureSpec2);
                                    measuredWidth2 = reorderedFlexItem.getMeasuredWidth();
                                    measuredHeight2 = reorderedFlexItem.getMeasuredHeight();
                                    this.updateMeasureCache(n9, childWidthMeasureSpecInternal, measureSpec2, reorderedFlexItem);
                                    this.mFlexContainer.updateViewCache(n9, reorderedFlexItem);
                                    n10 = n23;
                                }
                            }
                            b2 = Math.max(n7, flexItem.getMarginLeft() + measuredWidth2 + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItem));
                            flexLine.mMainSize += flexItem.getMarginTop() + measuredHeight2 + flexItem.getMarginBottom();
                        }
                        flexLine.mCrossSize = Math.max(flexLine.mCrossSize, b2);
                        n11 = b2;
                    }
                }
            }
            if (n5 != 0 && mMainSize != flexLine.mMainSize) {
                this.expandFlexItems(n, n2, flexLine, n3, n4, true);
            }
        }
    }
    
    private int getChildHeightMeasureSpecInternal(int measureSpec, final FlexItem flexItem, int childHeightMeasureSpec) {
        childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(measureSpec, this.mFlexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + childHeightMeasureSpec, flexItem.getHeight());
        final int size = View$MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View$MeasureSpec.getMode(childHeightMeasureSpec));
        }
        else {
            measureSpec = childHeightMeasureSpec;
            if (size < flexItem.getMinHeight()) {
                return View$MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View$MeasureSpec.getMode(childHeightMeasureSpec));
            }
        }
        return measureSpec;
    }
    
    private int getChildWidthMeasureSpecInternal(int measureSpec, final FlexItem flexItem, int childWidthMeasureSpec) {
        childWidthMeasureSpec = this.mFlexContainer.getChildWidthMeasureSpec(measureSpec, this.mFlexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + childWidthMeasureSpec, flexItem.getWidth());
        final int size = View$MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View$MeasureSpec.getMode(childWidthMeasureSpec));
        }
        else {
            measureSpec = childWidthMeasureSpec;
            if (size < flexItem.getMinWidth()) {
                return View$MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View$MeasureSpec.getMode(childWidthMeasureSpec));
            }
        }
        return measureSpec;
    }
    
    private int getFlexItemMarginEndCross(final FlexItem flexItem, final boolean b) {
        if (b) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginEnd();
    }
    
    private int getFlexItemMarginEndMain(final FlexItem flexItem, final boolean b) {
        if (b) {
            return flexItem.getMarginEnd();
        }
        return flexItem.getMarginBottom();
    }
    
    private int getFlexItemMarginStartCross(final FlexItem flexItem, final boolean b) {
        if (b) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginStart();
    }
    
    private int getFlexItemMarginStartMain(final FlexItem flexItem, final boolean b) {
        if (b) {
            return flexItem.getMarginStart();
        }
        return flexItem.getMarginTop();
    }
    
    private int getFlexItemSizeCross(final FlexItem flexItem, final boolean b) {
        if (b) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }
    
    private int getFlexItemSizeMain(final FlexItem flexItem, final boolean b) {
        if (b) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }
    
    private int getPaddingEndCross(final boolean b) {
        if (b) {
            return this.mFlexContainer.getPaddingBottom();
        }
        return this.mFlexContainer.getPaddingEnd();
    }
    
    private int getPaddingEndMain(final boolean b) {
        if (b) {
            return this.mFlexContainer.getPaddingEnd();
        }
        return this.mFlexContainer.getPaddingBottom();
    }
    
    private int getPaddingStartCross(final boolean b) {
        if (b) {
            return this.mFlexContainer.getPaddingTop();
        }
        return this.mFlexContainer.getPaddingStart();
    }
    
    private int getPaddingStartMain(final boolean b) {
        if (b) {
            return this.mFlexContainer.getPaddingStart();
        }
        return this.mFlexContainer.getPaddingTop();
    }
    
    private int getViewMeasuredSizeCross(final View view, final boolean b) {
        if (b) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }
    
    private int getViewMeasuredSizeMain(final View view, final boolean b) {
        if (b) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }
    
    private boolean isLastFlexItem(final int n, final int n2, final FlexLine flexLine) {
        return n == n2 - 1 && flexLine.getItemCountNotGone() != 0;
    }
    
    private boolean isWrapRequired(final View view, int n, final int n2, final int n3, final int n4, final FlexItem flexItem, int decorationLengthMainAxis, final int n5) {
        boolean b = true;
        if (this.mFlexContainer.getFlexWrap() != 0) {
            if (flexItem.isWrapBefore()) {
                return true;
            }
            if (n != 0) {
                decorationLengthMainAxis = this.mFlexContainer.getDecorationLengthMainAxis(view, decorationLengthMainAxis, n5);
                n = n4;
                if (decorationLengthMainAxis > 0) {
                    n = n4 + decorationLengthMainAxis;
                }
                if (n2 >= n3 + n) {
                    b = false;
                }
                return b;
            }
        }
        return false;
    }
    
    private void shrinkFlexItems(final int n, final int n2, final FlexLine flexLine, final int n3, final int n4, final boolean b) {
        final int mMainSize = flexLine.mMainSize;
        if (flexLine.mTotalFlexShrink > 0.0f && n3 <= flexLine.mMainSize) {
            int n5 = 0;
            final float n6 = (flexLine.mMainSize - n3) / flexLine.mTotalFlexShrink;
            float n7 = 0.0f;
            flexLine.mMainSize = flexLine.mDividerLengthInMainSize + n4;
            int n8 = 0;
            if (!b) {
                flexLine.mCrossSize = Integer.MIN_VALUE;
            }
            float n10;
            int n11;
            int n12;
            for (int i = 0; i < flexLine.mItemCount; ++i, n7 = n10, n8 = n11, n5 = n12) {
                final int n9 = flexLine.mFirstIndex + i;
                final View reorderedFlexItem = this.mFlexContainer.getReorderedFlexItemAt(n9);
                n10 = n7;
                n11 = n8;
                n12 = n5;
                if (reorderedFlexItem != null) {
                    if (reorderedFlexItem.getVisibility() == 8) {
                        n12 = n5;
                        n11 = n8;
                        n10 = n7;
                    }
                    else {
                        final FlexItem flexItem = (FlexItem)reorderedFlexItem.getLayoutParams();
                        final int flexDirection = this.mFlexContainer.getFlexDirection();
                        int b2;
                        if (flexDirection == 0 || flexDirection == 1) {
                            int n13 = reorderedFlexItem.getMeasuredWidth();
                            if (this.mMeasuredSizeCache != null) {
                                n13 = this.extractLowerInt(this.mMeasuredSizeCache[n9]);
                            }
                            int n14 = reorderedFlexItem.getMeasuredHeight();
                            if (this.mMeasuredSizeCache != null) {
                                n14 = this.extractHigherInt(this.mMeasuredSizeCache[n9]);
                            }
                            n10 = n7;
                            int measuredHeight = n14;
                            int measuredWidth = n13;
                            n12 = n5;
                            if (!this.mChildrenFrozen[n9]) {
                                n10 = n7;
                                measuredHeight = n14;
                                measuredWidth = n13;
                                n12 = n5;
                                if (flexItem.getFlexShrink() > 0.0f) {
                                    final float n15 = n13 - flexItem.getFlexShrink() * n6;
                                    float n16 = n7;
                                    float a = n15;
                                    if (i == flexLine.mItemCount - 1) {
                                        a = n15 + n7;
                                        n16 = 0.0f;
                                    }
                                    final int round = Math.round(a);
                                    int minWidth;
                                    float n17;
                                    if (round < flexItem.getMinWidth()) {
                                        n12 = 1;
                                        minWidth = flexItem.getMinWidth();
                                        this.mChildrenFrozen[n9] = true;
                                        flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                                        n17 = n16;
                                    }
                                    else {
                                        final float n18 = n16 + (a - round);
                                        if (n18 > 1.0) {
                                            minWidth = round + 1;
                                            n17 = n18 - 1.0f;
                                            n12 = n5;
                                        }
                                        else {
                                            n17 = n18;
                                            n12 = n5;
                                            minWidth = round;
                                            if (n18 < -1.0) {
                                                minWidth = round - 1;
                                                n17 = n18 + 1.0f;
                                                n12 = n5;
                                            }
                                        }
                                    }
                                    final int childHeightMeasureSpecInternal = this.getChildHeightMeasureSpecInternal(n2, flexItem, flexLine.mSumCrossSizeBefore);
                                    final int measureSpec = View$MeasureSpec.makeMeasureSpec(minWidth, 1073741824);
                                    reorderedFlexItem.measure(measureSpec, childHeightMeasureSpecInternal);
                                    measuredWidth = reorderedFlexItem.getMeasuredWidth();
                                    measuredHeight = reorderedFlexItem.getMeasuredHeight();
                                    this.updateMeasureCache(n9, measureSpec, childHeightMeasureSpecInternal, reorderedFlexItem);
                                    this.mFlexContainer.updateViewCache(n9, reorderedFlexItem);
                                    n10 = n17;
                                }
                            }
                            b2 = Math.max(n8, flexItem.getMarginTop() + measuredHeight + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItem));
                            flexLine.mMainSize += flexItem.getMarginLeft() + measuredWidth + flexItem.getMarginRight();
                        }
                        else {
                            int n19 = reorderedFlexItem.getMeasuredHeight();
                            if (this.mMeasuredSizeCache != null) {
                                n19 = this.extractHigherInt(this.mMeasuredSizeCache[n9]);
                            }
                            int n20 = reorderedFlexItem.getMeasuredWidth();
                            if (this.mMeasuredSizeCache != null) {
                                n20 = this.extractLowerInt(this.mMeasuredSizeCache[n9]);
                            }
                            n10 = n7;
                            int measuredHeight2 = n19;
                            int measuredWidth2 = n20;
                            n12 = n5;
                            if (!this.mChildrenFrozen[n9]) {
                                n10 = n7;
                                measuredHeight2 = n19;
                                measuredWidth2 = n20;
                                n12 = n5;
                                if (flexItem.getFlexShrink() > 0.0f) {
                                    final float n21 = n19 - flexItem.getFlexShrink() * n6;
                                    float n22 = n7;
                                    float a2 = n21;
                                    if (i == flexLine.mItemCount - 1) {
                                        a2 = n21 + n7;
                                        n22 = 0.0f;
                                    }
                                    final int round2 = Math.round(a2);
                                    int minHeight;
                                    float n23;
                                    if (round2 < flexItem.getMinHeight()) {
                                        n12 = 1;
                                        minHeight = flexItem.getMinHeight();
                                        this.mChildrenFrozen[n9] = true;
                                        flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                                        n23 = n22;
                                    }
                                    else {
                                        final float n24 = n22 + (a2 - round2);
                                        if (n24 > 1.0) {
                                            minHeight = round2 + 1;
                                            n23 = n24 - 1.0f;
                                            n12 = n5;
                                        }
                                        else {
                                            n23 = n24;
                                            n12 = n5;
                                            minHeight = round2;
                                            if (n24 < -1.0) {
                                                minHeight = round2 - 1;
                                                n23 = n24 + 1.0f;
                                                n12 = n5;
                                            }
                                        }
                                    }
                                    final int childWidthMeasureSpecInternal = this.getChildWidthMeasureSpecInternal(n, flexItem, flexLine.mSumCrossSizeBefore);
                                    final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(minHeight, 1073741824);
                                    reorderedFlexItem.measure(childWidthMeasureSpecInternal, measureSpec2);
                                    measuredWidth2 = reorderedFlexItem.getMeasuredWidth();
                                    measuredHeight2 = reorderedFlexItem.getMeasuredHeight();
                                    this.updateMeasureCache(n9, childWidthMeasureSpecInternal, measureSpec2, reorderedFlexItem);
                                    this.mFlexContainer.updateViewCache(n9, reorderedFlexItem);
                                    n10 = n23;
                                }
                            }
                            b2 = Math.max(n8, flexItem.getMarginLeft() + measuredWidth2 + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItem));
                            flexLine.mMainSize += flexItem.getMarginTop() + measuredHeight2 + flexItem.getMarginBottom();
                        }
                        flexLine.mCrossSize = Math.max(flexLine.mCrossSize, b2);
                        n11 = b2;
                    }
                }
            }
            if (n5 != 0 && mMainSize != flexLine.mMainSize) {
                this.shrinkFlexItems(n, n2, flexLine, n3, n4, true);
            }
        }
    }
    
    private int[] sortOrdersIntoReorderedIndices(int n, final List<Order> list, final SparseIntArray sparseIntArray) {
        Collections.sort((List<Comparable>)list);
        sparseIntArray.clear();
        final int[] array = new int[n];
        n = 0;
        for (final Order order : list) {
            array[n] = order.index;
            sparseIntArray.append(order.index, order.order);
            ++n;
        }
        return array;
    }
    
    private void stretchViewHorizontally(final View view, int n, final int n2) {
        final FlexItem flexItem = (FlexItem)view.getLayoutParams();
        final int min = Math.min(Math.max(n - flexItem.getMarginLeft() - flexItem.getMarginRight() - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        if (this.mMeasuredSizeCache != null) {
            n = this.extractHigherInt(this.mMeasuredSizeCache[n2]);
        }
        else {
            n = view.getMeasuredHeight();
        }
        n = View$MeasureSpec.makeMeasureSpec(n, 1073741824);
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(measureSpec, n);
        this.updateMeasureCache(n2, measureSpec, n, view);
        this.mFlexContainer.updateViewCache(n2, view);
    }
    
    private void stretchViewVertically(final View view, int n, final int n2) {
        final FlexItem flexItem = (FlexItem)view.getLayoutParams();
        final int min = Math.min(Math.max(n - flexItem.getMarginTop() - flexItem.getMarginBottom() - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        if (this.mMeasuredSizeCache != null) {
            n = this.extractLowerInt(this.mMeasuredSizeCache[n2]);
        }
        else {
            n = view.getMeasuredWidth();
        }
        n = View$MeasureSpec.makeMeasureSpec(n, 1073741824);
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(n, measureSpec);
        this.updateMeasureCache(n2, n, measureSpec, view);
        this.mFlexContainer.updateViewCache(n2, view);
    }
    
    private void updateMeasureCache(final int n, final int n2, final int n3, final View view) {
        if (this.mMeasureSpecCache != null) {
            this.mMeasureSpecCache[n] = this.makeCombinedLong(n2, n3);
        }
        if (this.mMeasuredSizeCache != null) {
            this.mMeasuredSizeCache[n] = this.makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }
    
    void calculateFlexLines(final FlexLinesResult flexLinesResult, final int n, final int n2, final int n3, int mFirstIndex, final int n4, @Nullable final List<FlexLine> list) {
        final boolean mainAxisDirectionHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        int n5 = 0;
        List<FlexLine> mFlexLines;
        if (list == null) {
            mFlexLines = new ArrayList<FlexLine>();
        }
        else {
            mFlexLines = list;
        }
        flexLinesResult.mFlexLines = mFlexLines;
        int n6;
        if (n4 == -1) {
            n6 = 1;
        }
        else {
            n6 = 0;
        }
        final int paddingStartMain = this.getPaddingStartMain(mainAxisDirectionHorizontal);
        final int paddingEndMain = this.getPaddingEndMain(mainAxisDirectionHorizontal);
        final int paddingStartCross = this.getPaddingStartCross(mainAxisDirectionHorizontal);
        final int paddingEndCross = this.getPaddingEndCross(mainAxisDirectionHorizontal);
        int a = Integer.MIN_VALUE;
        final int n7 = 0;
        int n8 = 0;
        FlexLine flexLine = new FlexLine();
        flexLine.mFirstIndex = mFirstIndex;
        flexLine.mMainSize = paddingStartMain + paddingEndMain;
        final int flexItemCount = this.mFlexContainer.getFlexItemCount();
        int n9 = mFirstIndex;
        mFirstIndex = n7;
        int combineMeasuredStates;
        while (true) {
            combineMeasuredStates = n5;
            if (n9 >= flexItemCount) {
                break;
            }
            final View reorderedFlexItem = this.mFlexContainer.getReorderedFlexItemAt(n9);
            int n10;
            int n11;
            FlexLine flexLine2;
            int n12;
            int n13;
            int n14;
            if (reorderedFlexItem == null) {
                n10 = n8;
                n11 = n5;
                flexLine2 = flexLine;
                n12 = a;
                n13 = n6;
                n14 = mFirstIndex;
                if (this.isLastFlexItem(n9, flexItemCount, flexLine)) {
                    this.addFlexLine(mFlexLines, flexLine, n9, mFirstIndex);
                    n14 = mFirstIndex;
                    n13 = n6;
                    n12 = a;
                    flexLine2 = flexLine;
                    n11 = n5;
                    n10 = n8;
                }
            }
            else if (reorderedFlexItem.getVisibility() == 8) {
                ++flexLine.mGoneItemCount;
                ++flexLine.mItemCount;
                n10 = n8;
                n11 = n5;
                flexLine2 = flexLine;
                n12 = a;
                n13 = n6;
                n14 = mFirstIndex;
                if (this.isLastFlexItem(n9, flexItemCount, flexLine)) {
                    this.addFlexLine(mFlexLines, flexLine, n9, mFirstIndex);
                    n10 = n8;
                    n11 = n5;
                    flexLine2 = flexLine;
                    n12 = a;
                    n13 = n6;
                    n14 = mFirstIndex;
                }
            }
            else {
                final FlexItem flexItem = (FlexItem)reorderedFlexItem.getLayoutParams();
                if (flexItem.getAlignSelf() == 4) {
                    flexLine.mIndicesAlignSelfStretch.add(n9);
                }
                int n16;
                final int n15 = n16 = this.getFlexItemSizeMain(flexItem, mainAxisDirectionHorizontal);
                if (flexItem.getFlexBasisPercent() != -1.0f) {
                    n16 = n15;
                    if (mode == 1073741824) {
                        n16 = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                }
                int n17;
                if (mainAxisDirectionHorizontal) {
                    n17 = this.mFlexContainer.getChildWidthMeasureSpec(n, paddingStartMain + paddingEndMain + this.getFlexItemMarginStartMain(flexItem, true) + this.getFlexItemMarginEndMain(flexItem, true), n16);
                    final int childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(n2, paddingStartCross + paddingEndCross + this.getFlexItemMarginStartCross(flexItem, true) + this.getFlexItemMarginEndCross(flexItem, true) + mFirstIndex, this.getFlexItemSizeCross(flexItem, true));
                    reorderedFlexItem.measure(n17, childHeightMeasureSpec);
                    this.updateMeasureCache(n9, n17, childHeightMeasureSpec, reorderedFlexItem);
                }
                else {
                    final int childWidthMeasureSpec = this.mFlexContainer.getChildWidthMeasureSpec(n2, paddingStartCross + paddingEndCross + this.getFlexItemMarginStartCross(flexItem, false) + this.getFlexItemMarginEndCross(flexItem, false) + mFirstIndex, this.getFlexItemSizeCross(flexItem, false));
                    n17 = this.mFlexContainer.getChildHeightMeasureSpec(n, paddingStartMain + paddingEndMain + this.getFlexItemMarginStartMain(flexItem, false) + this.getFlexItemMarginEndMain(flexItem, false), n16);
                    reorderedFlexItem.measure(childWidthMeasureSpec, n17);
                    this.updateMeasureCache(n9, childWidthMeasureSpec, n17, reorderedFlexItem);
                }
                this.mFlexContainer.updateViewCache(n9, reorderedFlexItem);
                this.checkSizeConstraints(reorderedFlexItem, n9);
                combineMeasuredStates = ViewCompat.combineMeasuredStates(n5, ViewCompat.getMeasuredState(reorderedFlexItem));
                int n20;
                if (this.isWrapRequired(reorderedFlexItem, mode, size, flexLine.mMainSize, this.getFlexItemMarginEndMain(flexItem, mainAxisDirectionHorizontal) + (this.getViewMeasuredSizeMain(reorderedFlexItem, mainAxisDirectionHorizontal) + this.getFlexItemMarginStartMain(flexItem, mainAxisDirectionHorizontal)), flexItem, n9, n8)) {
                    int n18 = mFirstIndex;
                    if (flexLine.getItemCountNotGone() > 0) {
                        int n19;
                        if (n9 > 0) {
                            n19 = n9 - 1;
                        }
                        else {
                            n19 = 0;
                        }
                        this.addFlexLine(mFlexLines, flexLine, n19, mFirstIndex);
                        n18 = mFirstIndex + flexLine.mCrossSize;
                    }
                    if (mainAxisDirectionHorizontal) {
                        if (flexItem.getHeight() == -1) {
                            reorderedFlexItem.measure(n17, this.mFlexContainer.getChildHeightMeasureSpec(n2, this.mFlexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + n18, flexItem.getHeight()));
                            this.checkSizeConstraints(reorderedFlexItem, n9);
                        }
                    }
                    else if (flexItem.getWidth() == -1) {
                        reorderedFlexItem.measure(this.mFlexContainer.getChildWidthMeasureSpec(n2, this.mFlexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + n18, flexItem.getWidth()), n17);
                        this.checkSizeConstraints(reorderedFlexItem, n9);
                    }
                    flexLine = new FlexLine();
                    flexLine.mItemCount = 1;
                    flexLine.mMainSize = paddingStartMain + paddingEndMain;
                    flexLine.mFirstIndex = n9;
                    n20 = 0;
                    final int n21 = Integer.MIN_VALUE;
                    mFirstIndex = n18;
                    a = n21;
                }
                else {
                    ++flexLine.mItemCount;
                    n20 = n8 + 1;
                }
                if (this.mIndexToFlexLine != null) {
                    this.mIndexToFlexLine[n9] = mFlexLines.size();
                }
                flexLine.mMainSize += this.getViewMeasuredSizeMain(reorderedFlexItem, mainAxisDirectionHorizontal) + this.getFlexItemMarginStartMain(flexItem, mainAxisDirectionHorizontal) + this.getFlexItemMarginEndMain(flexItem, mainAxisDirectionHorizontal);
                flexLine.mTotalFlexGrow += flexItem.getFlexGrow();
                flexLine.mTotalFlexShrink += flexItem.getFlexShrink();
                this.mFlexContainer.onNewFlexItemAdded(reorderedFlexItem, n9, n20, flexLine);
                final int max = Math.max(a, this.getViewMeasuredSizeCross(reorderedFlexItem, mainAxisDirectionHorizontal) + this.getFlexItemMarginStartCross(flexItem, mainAxisDirectionHorizontal) + this.getFlexItemMarginEndCross(flexItem, mainAxisDirectionHorizontal) + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItem));
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, max);
                if (mainAxisDirectionHorizontal) {
                    if (this.mFlexContainer.getFlexWrap() != 2) {
                        flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, reorderedFlexItem.getBaseline() + flexItem.getMarginTop());
                    }
                    else {
                        flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, reorderedFlexItem.getMeasuredHeight() - reorderedFlexItem.getBaseline() + flexItem.getMarginBottom());
                    }
                }
                int n22 = mFirstIndex;
                if (this.isLastFlexItem(n9, flexItemCount, flexLine)) {
                    this.addFlexLine(mFlexLines, flexLine, n9, mFirstIndex);
                    n22 = mFirstIndex + flexLine.mCrossSize;
                }
                int n23 = n6;
                mFirstIndex = n22;
                if (n4 != -1) {
                    n23 = n6;
                    mFirstIndex = n22;
                    if (mFlexLines.size() > 0) {
                        n23 = n6;
                        mFirstIndex = n22;
                        if (mFlexLines.get(mFlexLines.size() - 1).mLastIndex >= n4) {
                            n23 = n6;
                            mFirstIndex = n22;
                            if (n9 >= n4) {
                                n23 = n6;
                                mFirstIndex = n22;
                                if (n6 == 0) {
                                    mFirstIndex = -flexLine.getCrossSize();
                                    n23 = 1;
                                }
                            }
                        }
                    }
                }
                n10 = n20;
                n11 = combineMeasuredStates;
                flexLine2 = flexLine;
                n12 = max;
                n13 = n23;
                if ((n14 = mFirstIndex) > n3) {
                    n10 = n20;
                    n11 = combineMeasuredStates;
                    flexLine2 = flexLine;
                    n12 = max;
                    n13 = n23;
                    n14 = mFirstIndex;
                    if (n23 != 0) {
                        break;
                    }
                }
            }
            ++n9;
            n8 = n10;
            n5 = n11;
            flexLine = flexLine2;
            a = n12;
            n6 = n13;
            mFirstIndex = n14;
        }
        flexLinesResult.mChildState = combineMeasuredStates;
    }
    
    void calculateHorizontalFlexLines(final FlexLinesResult flexLinesResult, final int n, final int n2) {
        this.calculateFlexLines(flexLinesResult, n, n2, Integer.MAX_VALUE, 0, -1, null);
    }
    
    void calculateHorizontalFlexLines(final FlexLinesResult flexLinesResult, final int n, final int n2, final int n3, final int n4, @Nullable final List<FlexLine> list) {
        this.calculateFlexLines(flexLinesResult, n, n2, n3, n4, -1, list);
    }
    
    void calculateHorizontalFlexLinesToIndex(final FlexLinesResult flexLinesResult, final int n, final int n2, final int n3, final int n4, final List<FlexLine> list) {
        this.calculateFlexLines(flexLinesResult, n, n2, n3, 0, n4, list);
    }
    
    void calculateVerticalFlexLines(final FlexLinesResult flexLinesResult, final int n, final int n2) {
        this.calculateFlexLines(flexLinesResult, n2, n, Integer.MAX_VALUE, 0, -1, null);
    }
    
    void calculateVerticalFlexLines(final FlexLinesResult flexLinesResult, final int n, final int n2, final int n3, final int n4, @Nullable final List<FlexLine> list) {
        this.calculateFlexLines(flexLinesResult, n2, n, n3, n4, -1, list);
    }
    
    void calculateVerticalFlexLinesToIndex(final FlexLinesResult flexLinesResult, final int n, final int n2, final int n3, final int n4, final List<FlexLine> list) {
        this.calculateFlexLines(flexLinesResult, n2, n, n3, 0, n4, list);
    }
    
    void clearFlexLines(final List<FlexLine> list, final int n) {
        assert this.mIndexToFlexLine != null;
        assert this.mMeasureSpecCache != null;
        int n2;
        if ((n2 = this.mIndexToFlexLine[n]) == -1) {
            n2 = 0;
        }
        for (int i = list.size() - 1; i >= n2; --i) {
            list.remove(i);
        }
        final int toIndex = this.mIndexToFlexLine.length - 1;
        if (n > toIndex) {
            Arrays.fill(this.mIndexToFlexLine, -1);
        }
        else {
            Arrays.fill(this.mIndexToFlexLine, n, toIndex, -1);
        }
        final int toIndex2 = this.mMeasureSpecCache.length - 1;
        if (n > toIndex2) {
            Arrays.fill(this.mMeasureSpecCache, 0L);
            return;
        }
        Arrays.fill(this.mMeasureSpecCache, n, toIndex2, 0L);
    }
    
    int[] createReorderedIndices(final SparseIntArray sparseIntArray) {
        final int flexItemCount = this.mFlexContainer.getFlexItemCount();
        return this.sortOrdersIntoReorderedIndices(flexItemCount, this.createOrders(flexItemCount), sparseIntArray);
    }
    
    int[] createReorderedIndices(final View view, int i, final ViewGroup$LayoutParams viewGroup$LayoutParams, final SparseIntArray sparseIntArray) {
        final int flexItemCount = this.mFlexContainer.getFlexItemCount();
        final List<Order> orders = this.createOrders(flexItemCount);
        final Order order = new Order();
        if (view != null && viewGroup$LayoutParams instanceof FlexItem) {
            order.order = ((FlexItem)viewGroup$LayoutParams).getOrder();
        }
        else {
            order.order = 1;
        }
        if (i == -1 || i == flexItemCount) {
            order.index = flexItemCount;
        }
        else if (i < this.mFlexContainer.getFlexItemCount()) {
            order.index = i;
            while (i < flexItemCount) {
                final Order order2 = orders.get(i);
                ++order2.index;
                ++i;
            }
        }
        else {
            order.index = flexItemCount;
        }
        orders.add(order);
        return this.sortOrdersIntoReorderedIndices(flexItemCount + 1, orders, sparseIntArray);
    }
    
    void determineCrossSize(int i, int j, int round) {
        final int flexDirection = this.mFlexContainer.getFlexDirection();
        switch (flexDirection) {
            default: {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            case 0:
            case 1: {
                final int mode = View$MeasureSpec.getMode(j);
                i = View$MeasureSpec.getSize(j);
                j = mode;
                break;
            }
            case 2:
            case 3: {
                j = View$MeasureSpec.getMode(i);
                i = View$MeasureSpec.getSize(i);
                break;
            }
        }
        final List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        if (j == 1073741824) {
            j = this.mFlexContainer.getSumOfCrossSize() + round;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mCrossSize = i - round;
            }
            else if (flexLinesInternal.size() >= 2) {
                switch (this.mFlexContainer.getAlignContent()) {
                    default: {}
                    case 1: {
                        final FlexLine flexLine = new FlexLine();
                        flexLine.mCrossSize = i - j;
                        flexLinesInternal.add(0, flexLine);
                    }
                    case 5: {
                        if (j < i) {
                            final float n = (i - j) / (float)flexLinesInternal.size();
                            float n2 = 0.0f;
                            FlexLine flexLine2;
                            float n3;
                            float n4;
                            float a;
                            float n5;
                            for (j = 0; j < flexLinesInternal.size(); ++j) {
                                flexLine2 = flexLinesInternal.get(j);
                                n3 = flexLine2.mCrossSize + n;
                                n4 = n2;
                                a = n3;
                                if (j == flexLinesInternal.size() - 1) {
                                    a = n3 + n2;
                                    n4 = 0.0f;
                                }
                                round = Math.round(a);
                                n5 = n4 + (a - round);
                                if (n5 > 1.0f) {
                                    i = round + 1;
                                    n2 = n5 - 1.0f;
                                }
                                else {
                                    n2 = n5;
                                    i = round;
                                    if (n5 < -1.0f) {
                                        i = round - 1;
                                        n2 = n5 + 1.0f;
                                    }
                                }
                                flexLine2.mCrossSize = i;
                            }
                            break;
                        }
                        break;
                    }
                    case 4: {
                        if (j >= i) {
                            this.mFlexContainer.setFlexLines(this.constructFlexLinesForAlignContentCenter(flexLinesInternal, i, j));
                            return;
                        }
                        i = (i - j) / (flexLinesInternal.size() * 2);
                        final ArrayList<FlexLine> flexLines = new ArrayList<FlexLine>();
                        final FlexLine flexLine3 = new FlexLine();
                        flexLine3.mCrossSize = i;
                        for (final FlexLine flexLine4 : flexLinesInternal) {
                            flexLines.add(flexLine3);
                            flexLines.add(flexLine4);
                            flexLines.add(flexLine3);
                        }
                        this.mFlexContainer.setFlexLines(flexLines);
                    }
                    case 3: {
                        if (j < i) {
                            final float a2 = (i - j) / (float)(flexLinesInternal.size() - 1);
                            float n6 = 0.0f;
                            final ArrayList<FlexLine> flexLines2 = new ArrayList<FlexLine>();
                            float n7;
                            FlexLine flexLine5;
                            float n8;
                            float n9;
                            for (i = 0, j = flexLinesInternal.size(); i < j; ++i, n6 = n7) {
                                flexLines2.add(flexLinesInternal.get(i));
                                n7 = n6;
                                if (i != flexLinesInternal.size() - 1) {
                                    flexLine5 = new FlexLine();
                                    if (i == flexLinesInternal.size() - 2) {
                                        flexLine5.mCrossSize = Math.round(a2 + n6);
                                        n6 = 0.0f;
                                    }
                                    else {
                                        flexLine5.mCrossSize = Math.round(a2);
                                    }
                                    n8 = n6 + (a2 - flexLine5.mCrossSize);
                                    if (n8 > 1.0f) {
                                        ++flexLine5.mCrossSize;
                                        n9 = n8 - 1.0f;
                                    }
                                    else {
                                        n9 = n8;
                                        if (n8 < -1.0f) {
                                            --flexLine5.mCrossSize;
                                            n9 = n8 + 1.0f;
                                        }
                                    }
                                    flexLines2.add(flexLine5);
                                    n7 = n9;
                                }
                            }
                            this.mFlexContainer.setFlexLines(flexLines2);
                            return;
                        }
                        break;
                    }
                    case 2: {
                        this.mFlexContainer.setFlexLines(this.constructFlexLinesForAlignContentCenter(flexLinesInternal, i, j));
                    }
                }
            }
        }
    }
    
    void determineMainSize(final int n, final int n2) {
        this.determineMainSize(n, n2, 0);
    }
    
    void determineMainSize(final int n, final int n2, int size) {
        this.ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (size < this.mFlexContainer.getFlexItemCount()) {
            final int flexDirection = this.mFlexContainer.getFlexDirection();
            int n4 = 0;
            int n5 = 0;
            switch (this.mFlexContainer.getFlexDirection()) {
                default: {
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                }
                case 0:
                case 1: {
                    final int mode = View$MeasureSpec.getMode(n);
                    int n3 = View$MeasureSpec.getSize(n);
                    if (mode != 1073741824) {
                        n3 = this.mFlexContainer.getLargestMainSize();
                    }
                    n4 = this.mFlexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight();
                    n5 = n3;
                    break;
                }
                case 2:
                case 3: {
                    final int mode2 = View$MeasureSpec.getMode(n2);
                    int n6 = View$MeasureSpec.getSize(n2);
                    if (mode2 != 1073741824) {
                        n6 = this.mFlexContainer.getLargestMainSize();
                    }
                    n4 = this.mFlexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom();
                    n5 = n6;
                    break;
                }
            }
            int i = 0;
            if (this.mIndexToFlexLine != null) {
                i = this.mIndexToFlexLine[size];
            }
            final List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
            FlexLine flexLine;
            for (size = flexLinesInternal.size(); i < size; ++i) {
                flexLine = flexLinesInternal.get(i);
                if (flexLine.mMainSize < n5) {
                    this.expandFlexItems(n, n2, flexLine, n5, n4, false);
                }
                else {
                    this.shrinkFlexItems(n, n2, flexLine, n5, n4, false);
                }
            }
        }
    }
    
    void ensureIndexToFlexLine(int newLength) {
        if (this.mIndexToFlexLine == null) {
            int n;
            if ((n = newLength) < 10) {
                n = 10;
            }
            this.mIndexToFlexLine = new int[n];
        }
        else if (this.mIndexToFlexLine.length < newLength) {
            final int n2 = this.mIndexToFlexLine.length * 2;
            if (n2 >= newLength) {
                newLength = n2;
            }
            this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, newLength);
        }
    }
    
    void ensureMeasureSpecCache(int newLength) {
        if (this.mMeasureSpecCache == null) {
            int n;
            if ((n = newLength) < 10) {
                n = 10;
            }
            this.mMeasureSpecCache = new long[n];
        }
        else if (this.mMeasureSpecCache.length < newLength) {
            final int n2 = this.mMeasureSpecCache.length * 2;
            if (n2 >= newLength) {
                newLength = n2;
            }
            this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, newLength);
        }
    }
    
    void ensureMeasuredSizeCache(int newLength) {
        if (this.mMeasuredSizeCache == null) {
            int n;
            if ((n = newLength) < 10) {
                n = 10;
            }
            this.mMeasuredSizeCache = new long[n];
        }
        else if (this.mMeasuredSizeCache.length < newLength) {
            final int n2 = this.mMeasuredSizeCache.length * 2;
            if (n2 >= newLength) {
                newLength = n2;
            }
            this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, newLength);
        }
    }
    
    int extractHigherInt(final long n) {
        return (int)(n >> 32);
    }
    
    int extractLowerInt(final long n) {
        return (int)n;
    }
    
    boolean isOrderChangedFromLastMeasurement(final SparseIntArray sparseIntArray) {
        final int flexItemCount = this.mFlexContainer.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; ++i) {
            final View flexItem = this.mFlexContainer.getFlexItemAt(i);
            if (flexItem != null && ((FlexItem)flexItem.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }
    
    void layoutSingleChildHorizontal(final View view, final FlexLine flexLine, final int n, final int n2, final int n3, int n4) {
        final FlexItem flexItem = (FlexItem)view.getLayoutParams();
        int n5 = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            n5 = flexItem.getAlignSelf();
        }
        final int mCrossSize = flexLine.mCrossSize;
        switch (n5) {
            default: {}
            case 0:
            case 4: {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    view.layout(n, flexItem.getMarginTop() + n2, n3, flexItem.getMarginTop() + n4);
                    return;
                }
                view.layout(n, n2 - flexItem.getMarginBottom(), n3, n4 - flexItem.getMarginBottom());
            }
            case 3: {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    final int max = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(n, n2 + max, n3, n4 + max);
                    return;
                }
                final int max2 = Math.max(flexLine.mMaxBaseline - view.getMeasuredHeight() + view.getBaseline(), flexItem.getMarginBottom());
                view.layout(n, n2 - max2, n3, n4 - max2);
            }
            case 1: {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    view.layout(n, n2 + mCrossSize - view.getMeasuredHeight() - flexItem.getMarginBottom(), n3, n2 + mCrossSize - flexItem.getMarginBottom());
                    return;
                }
                view.layout(n, n2 - mCrossSize + view.getMeasuredHeight() + flexItem.getMarginTop(), n3, n4 - mCrossSize + view.getMeasuredHeight() + flexItem.getMarginTop());
            }
            case 2: {
                n4 = (mCrossSize - view.getMeasuredHeight() + flexItem.getMarginTop() - flexItem.getMarginBottom()) / 2;
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    view.layout(n, n2 + n4, n3, n2 + n4 + view.getMeasuredHeight());
                    return;
                }
                view.layout(n, n2 - n4, n3, n2 - n4 + view.getMeasuredHeight());
            }
        }
    }
    
    void layoutSingleChildVertical(final View view, final FlexLine flexLine, final boolean b, final int n, final int n2, final int n3, final int n4) {
        final FlexItem flexItem = (FlexItem)view.getLayoutParams();
        int n5 = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            n5 = flexItem.getAlignSelf();
        }
        final int mCrossSize = flexLine.mCrossSize;
        switch (n5) {
            default: {}
            case 0:
            case 3:
            case 4: {
                if (!b) {
                    view.layout(flexItem.getMarginLeft() + n, n2, flexItem.getMarginLeft() + n3, n4);
                    return;
                }
                view.layout(n - flexItem.getMarginRight(), n2, n3 - flexItem.getMarginRight(), n4);
            }
            case 1: {
                if (!b) {
                    view.layout(n + mCrossSize - view.getMeasuredWidth() - flexItem.getMarginRight(), n2, n3 + mCrossSize - view.getMeasuredWidth() - flexItem.getMarginRight(), n4);
                    return;
                }
                view.layout(n - mCrossSize + view.getMeasuredWidth() + flexItem.getMarginLeft(), n2, n3 - mCrossSize + view.getMeasuredWidth() + flexItem.getMarginLeft(), n4);
            }
            case 2: {
                final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
                final int n6 = (mCrossSize - view.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart(viewGroup$MarginLayoutParams) - MarginLayoutParamsCompat.getMarginEnd(viewGroup$MarginLayoutParams)) / 2;
                if (!b) {
                    view.layout(n + n6, n2, n3 + n6, n4);
                    return;
                }
                view.layout(n - n6, n2, n3 - n6, n4);
            }
        }
    }
    
    @VisibleForTesting
    long makeCombinedLong(final int n, final int n2) {
        return (long)n2 << 32 | ((long)n & 0xFFFFFFFFL);
    }
    
    void stretchViews() {
        this.stretchViews(0);
    }
    
    void stretchViews(int i) {
        if (i < this.mFlexContainer.getFlexItemCount()) {
            final int flexDirection = this.mFlexContainer.getFlexDirection();
            if (this.mFlexContainer.getAlignItems() == 4) {
                int n = 0;
                if (this.mIndexToFlexLine != null) {
                    n = this.mIndexToFlexLine[i];
                }
                List<FlexLine> flexLinesInternal;
                FlexLine flexLine;
                int j;
                int n2;
                View reorderedFlexItem;
                FlexItem flexItem;
                for (flexLinesInternal = this.mFlexContainer.getFlexLinesInternal(), i = n; i < flexLinesInternal.size(); ++i) {
                    for (flexLine = flexLinesInternal.get(i), j = 0; j < flexLine.mItemCount; ++j) {
                        n2 = flexLine.mFirstIndex + j;
                        if (j < this.mFlexContainer.getFlexItemCount()) {
                            reorderedFlexItem = this.mFlexContainer.getReorderedFlexItemAt(n2);
                            if (reorderedFlexItem != null && reorderedFlexItem.getVisibility() != 8) {
                                flexItem = (FlexItem)reorderedFlexItem.getLayoutParams();
                                if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                                    switch (flexDirection) {
                                        default: {
                                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                        }
                                        case 0:
                                        case 1: {
                                            this.stretchViewVertically(reorderedFlexItem, flexLine.mCrossSize, n2);
                                            break;
                                        }
                                        case 2:
                                        case 3: {
                                            this.stretchViewHorizontally(reorderedFlexItem, flexLine.mCrossSize, n2);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else {
                for (final FlexLine flexLine2 : this.mFlexContainer.getFlexLinesInternal()) {
                    for (final Integer n3 : flexLine2.mIndicesAlignSelfStretch) {
                        final View reorderedFlexItem2 = this.mFlexContainer.getReorderedFlexItemAt(n3);
                        switch (flexDirection) {
                            default: {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            case 0:
                            case 1: {
                                this.stretchViewVertically(reorderedFlexItem2, flexLine2.mCrossSize, n3);
                                continue;
                            }
                            case 2:
                            case 3: {
                                this.stretchViewHorizontally(reorderedFlexItem2, flexLine2.mCrossSize, n3);
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }
    
    static class FlexLinesResult
    {
        int mChildState;
        List<FlexLine> mFlexLines;
        
        void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }
    
    private static class Order implements Comparable<Order>
    {
        int index;
        int order;
        
        @Override
        public int compareTo(@NonNull final Order order) {
            if (this.order != order.order) {
                return this.order - order.order;
            }
            return this.index - order.index;
        }
        
        @Override
        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }
    }
}
