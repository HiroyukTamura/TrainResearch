// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import android.graphics.Rect;
import java.util.List;
import android.view.View;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

public class FlexboxItemDecoration extends ItemDecoration
{
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    private static final int[] LIST_DIVIDER_ATTRS;
    public static final int VERTICAL = 2;
    private Drawable mDrawable;
    private int mOrientation;
    
    static {
        LIST_DIVIDER_ATTRS = new int[] { 16843284 };
    }
    
    public FlexboxItemDecoration(final Context context) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(FlexboxItemDecoration.LIST_DIVIDER_ATTRS);
        this.mDrawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.setOrientation(3);
    }
    
    private void drawHorizontalDecorations(final Canvas canvas, final RecyclerView recyclerView) {
        if (this.needsHorizontalDecoration()) {
            final FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager)recyclerView.getLayoutManager();
            final int flexDirection = flexboxLayoutManager.getFlexDirection();
            final int left = recyclerView.getLeft();
            final int paddingLeft = recyclerView.getPaddingLeft();
            final int right = recyclerView.getRight();
            final int paddingRight = recyclerView.getPaddingRight();
            for (int childCount = recyclerView.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = recyclerView.getChildAt(i);
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                int n;
                int n2;
                if (flexDirection == 3) {
                    n = child.getBottom() + layoutParams.bottomMargin;
                    n2 = n + this.mDrawable.getIntrinsicHeight();
                }
                else {
                    n2 = child.getTop() - layoutParams.topMargin;
                    n = n2 - this.mDrawable.getIntrinsicHeight();
                }
                int min;
                int max;
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    if (flexboxLayoutManager.isLayoutRtl()) {
                        min = Math.min(child.getRight() + layoutParams.rightMargin + this.mDrawable.getIntrinsicWidth(), right + paddingRight);
                        max = child.getLeft() - layoutParams.leftMargin;
                    }
                    else {
                        max = Math.max(child.getLeft() - layoutParams.leftMargin - this.mDrawable.getIntrinsicWidth(), left - paddingLeft);
                        min = child.getRight() + layoutParams.rightMargin;
                    }
                }
                else {
                    max = child.getLeft() - layoutParams.leftMargin;
                    min = child.getRight() + layoutParams.rightMargin;
                }
                this.mDrawable.setBounds(max, n, min, n2);
                this.mDrawable.draw(canvas);
            }
        }
    }
    
    private void drawVerticalDecorations(final Canvas canvas, final RecyclerView recyclerView) {
        if (this.needsVerticalDecoration()) {
            final FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager)recyclerView.getLayoutManager();
            final int top = recyclerView.getTop();
            final int paddingTop = recyclerView.getPaddingTop();
            final int bottom = recyclerView.getBottom();
            final int paddingBottom = recyclerView.getPaddingBottom();
            final int childCount = recyclerView.getChildCount();
            final int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i = 0; i < childCount; ++i) {
                final View child = recyclerView.getChildAt(i);
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                int n;
                int n2;
                if (flexboxLayoutManager.isLayoutRtl()) {
                    n = child.getRight() + layoutParams.rightMargin;
                    n2 = n + this.mDrawable.getIntrinsicWidth();
                }
                else {
                    n2 = child.getLeft() - layoutParams.leftMargin;
                    n = n2 - this.mDrawable.getIntrinsicWidth();
                }
                int max;
                int min;
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    max = child.getTop() - layoutParams.topMargin;
                    min = child.getBottom() + layoutParams.bottomMargin;
                }
                else if (flexDirection == 3) {
                    min = Math.min(child.getBottom() + layoutParams.bottomMargin + this.mDrawable.getIntrinsicHeight(), bottom + paddingBottom);
                    max = child.getTop() - layoutParams.topMargin;
                }
                else {
                    max = Math.max(child.getTop() - layoutParams.topMargin - this.mDrawable.getIntrinsicHeight(), top - paddingTop);
                    min = child.getBottom() + layoutParams.bottomMargin;
                }
                this.mDrawable.setBounds(n, max, n2, min);
                this.mDrawable.draw(canvas);
            }
        }
    }
    
    private boolean isFirstItemInLine(final int n, final List<FlexLine> list, final FlexboxLayoutManager flexboxLayoutManager) {
        final int positionToFlexLineIndex = flexboxLayoutManager.getPositionToFlexLineIndex(n);
        return (positionToFlexLineIndex != -1 && positionToFlexLineIndex < flexboxLayoutManager.getFlexLinesInternal().size() && flexboxLayoutManager.getFlexLinesInternal().get(positionToFlexLineIndex).mFirstIndex == n) || n == 0 || (list.size() != 0 && list.get(list.size() - 1).mLastIndex == n - 1);
    }
    
    private boolean needsHorizontalDecoration() {
        return (this.mOrientation & 0x1) > 0;
    }
    
    private boolean needsVerticalDecoration() {
        return (this.mOrientation & 0x2) > 0;
    }
    
    private void setOffsetAlongCrossAxis(final Rect rect, final int n, final FlexboxLayoutManager flexboxLayoutManager, final List<FlexLine> list) {
        if (list.size() != 0 && flexboxLayoutManager.getPositionToFlexLineIndex(n) != 0) {
            if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                if (!this.needsHorizontalDecoration()) {
                    rect.top = 0;
                    rect.bottom = 0;
                    return;
                }
                rect.top = this.mDrawable.getIntrinsicHeight();
                rect.bottom = 0;
            }
            else if (this.needsVerticalDecoration()) {
                if (flexboxLayoutManager.isLayoutRtl()) {
                    rect.right = this.mDrawable.getIntrinsicWidth();
                    rect.left = 0;
                    return;
                }
                rect.left = this.mDrawable.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }
    
    private void setOffsetAlongMainAxis(final Rect rect, final int n, final FlexboxLayoutManager flexboxLayoutManager, final List<FlexLine> list, final int n2) {
        if (this.isFirstItemInLine(n, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!this.needsVerticalDecoration()) {
                rect.left = 0;
                rect.right = 0;
                return;
            }
            if (flexboxLayoutManager.isLayoutRtl()) {
                rect.right = this.mDrawable.getIntrinsicWidth();
                rect.left = 0;
                return;
            }
            rect.left = this.mDrawable.getIntrinsicWidth();
            rect.right = 0;
        }
        else {
            if (!this.needsHorizontalDecoration()) {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
            if (n2 == 3) {
                rect.bottom = this.mDrawable.getIntrinsicHeight();
                rect.top = 0;
                return;
            }
            rect.top = this.mDrawable.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }
    
    @Override
    public void getItemOffsets(final Rect rect, final View view, final RecyclerView recyclerView, final State state) {
        final int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!this.needsHorizontalDecoration() && !this.needsVerticalDecoration()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        final FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager)recyclerView.getLayoutManager();
        final List<FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
        this.setOffsetAlongMainAxis(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        this.setOffsetAlongCrossAxis(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }
    
    @Override
    public void onDraw(final Canvas canvas, final RecyclerView recyclerView, final State state) {
        this.drawHorizontalDecorations(canvas, recyclerView);
        this.drawVerticalDecorations(canvas, recyclerView);
    }
    
    public void setDrawable(final Drawable mDrawable) {
        if (mDrawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.mDrawable = mDrawable;
    }
    
    public void setOrientation(final int mOrientation) {
        this.mOrientation = mOrientation;
    }
}
