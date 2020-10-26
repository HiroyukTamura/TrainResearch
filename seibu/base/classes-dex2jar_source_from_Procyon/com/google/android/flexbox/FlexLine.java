// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FlexLine
{
    int mBottom;
    int mCrossSize;
    int mDividerLengthInMainSize;
    int mFirstIndex;
    int mGoneItemCount;
    List<Integer> mIndicesAlignSelfStretch;
    int mItemCount;
    int mLastIndex;
    int mLeft;
    int mMainSize;
    int mMaxBaseline;
    int mRight;
    int mSumCrossSizeBefore;
    int mTop;
    float mTotalFlexGrow;
    float mTotalFlexShrink;
    
    FlexLine() {
        this.mLeft = Integer.MAX_VALUE;
        this.mTop = Integer.MAX_VALUE;
        this.mRight = Integer.MIN_VALUE;
        this.mBottom = Integer.MIN_VALUE;
        this.mIndicesAlignSelfStretch = new ArrayList<Integer>();
    }
    
    public int getCrossSize() {
        return this.mCrossSize;
    }
    
    public int getFirstIndex() {
        return this.mFirstIndex;
    }
    
    public int getItemCount() {
        return this.mItemCount;
    }
    
    public int getItemCountNotGone() {
        return this.mItemCount - this.mGoneItemCount;
    }
    
    public int getMainSize() {
        return this.mMainSize;
    }
    
    public float getTotalFlexGrow() {
        return this.mTotalFlexGrow;
    }
    
    public float getTotalFlexShrink() {
        return this.mTotalFlexShrink;
    }
    
    void updatePositionFromView(final View view, final int n, final int n2, final int n3, final int n4) {
        final FlexItem flexItem = (FlexItem)view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, view.getLeft() - flexItem.getMarginLeft() - n);
        this.mTop = Math.min(this.mTop, view.getTop() - flexItem.getMarginTop() - n2);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + n3);
        this.mBottom = Math.max(this.mBottom, view.getBottom() + flexItem.getMarginBottom() + n4);
    }
}
