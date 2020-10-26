// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.ViewGroup$MarginLayoutParams;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.ViewCompat;
import android.view.View$MeasureSpec;
import java.util.Iterator;
import android.graphics.Canvas;
import android.view.View;
import android.content.res.TypedArray;
import java.util.ArrayList;
import android.util.AttributeSet;
import android.content.Context;
import android.util.SparseIntArray;
import java.util.List;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public class FlexboxLayout extends ViewGroup implements FlexContainer
{
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    @Nullable
    private Drawable mDividerDrawableHorizontal;
    @Nullable
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private FlexboxHelper mFlexboxHelper;
    private int mJustifyContent;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;
    
    public FlexboxLayout(final Context context) {
        this(context, null);
    }
    
    public FlexboxLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public FlexboxLayout(final Context context, final AttributeSet set, int n) {
        super(context, set, n);
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mFlexLines = new ArrayList<FlexLine>();
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.FlexboxLayout, n, 0);
        this.mFlexDirection = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 4);
        this.mAlignContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 5);
        final Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            this.setDividerDrawableHorizontal(drawable);
            this.setDividerDrawableVertical(drawable);
        }
        final Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            this.setDividerDrawableHorizontal(drawable2);
        }
        final Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            this.setDividerDrawableVertical(drawable3);
        }
        n = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (n != 0) {
            this.mShowDividerVertical = n;
            this.mShowDividerHorizontal = n;
        }
        n = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (n != 0) {
            this.mShowDividerVertical = n;
        }
        n = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (n != 0) {
            this.mShowDividerHorizontal = n;
        }
        obtainStyledAttributes.recycle();
    }
    
    private boolean allFlexLinesAreDummyBefore(final int n) {
        for (int i = 0; i < n; ++i) {
            if (this.mFlexLines.get(i).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean allViewsAreGoneBefore(final int n, final int n2) {
        for (int i = 1; i <= n2; ++i) {
            final View reorderedChild = this.getReorderedChildAt(n - i);
            if (reorderedChild != null && reorderedChild.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }
    
    private void drawDividersHorizontal(final Canvas canvas, final boolean b, final boolean b2) {
        int n = 0;
        final int paddingLeft = this.getPaddingLeft();
        final int max = Math.max(0, this.getWidth() - this.getPaddingRight() - paddingLeft);
        for (int i = 0; i < this.mFlexLines.size(); ++i) {
            final FlexLine flexLine = this.mFlexLines.get(i);
            int n2;
            for (int j = 0; j < flexLine.mItemCount; ++j, n = n2) {
                final View reorderedChild = this.getReorderedChildAt(n);
                n2 = n;
                if (reorderedChild != null) {
                    if (reorderedChild.getVisibility() == 8) {
                        n2 = n;
                    }
                    else {
                        final LayoutParams layoutParams = (LayoutParams)reorderedChild.getLayoutParams();
                        if (this.hasDividerBeforeChildAtAlongMainAxis(n, j)) {
                            int n3;
                            if (b) {
                                n3 = reorderedChild.getRight() + layoutParams.rightMargin;
                            }
                            else {
                                n3 = reorderedChild.getLeft() - layoutParams.leftMargin - this.mDividerVerticalWidth;
                            }
                            this.drawVerticalDivider(canvas, n3, flexLine.mTop, flexLine.mCrossSize);
                        }
                        if (j == flexLine.mItemCount - 1 && (this.mShowDividerVertical & 0x4) > 0) {
                            int n4;
                            if (b) {
                                n4 = reorderedChild.getLeft() - layoutParams.leftMargin - this.mDividerVerticalWidth;
                            }
                            else {
                                n4 = reorderedChild.getRight() + layoutParams.rightMargin;
                            }
                            this.drawVerticalDivider(canvas, n4, flexLine.mTop, flexLine.mCrossSize);
                        }
                        n2 = n + 1;
                    }
                }
            }
            if (this.hasDividerBeforeFlexLine(i)) {
                int mBottom;
                if (b2) {
                    mBottom = flexLine.mBottom;
                }
                else {
                    mBottom = flexLine.mTop - this.mDividerHorizontalHeight;
                }
                this.drawHorizontalDivider(canvas, paddingLeft, mBottom, max);
            }
            if (this.hasEndDividerAfterFlexLine(i) && (this.mShowDividerHorizontal & 0x4) > 0) {
                int mBottom2;
                if (b2) {
                    mBottom2 = flexLine.mTop - this.mDividerHorizontalHeight;
                }
                else {
                    mBottom2 = flexLine.mBottom;
                }
                this.drawHorizontalDivider(canvas, paddingLeft, mBottom2, max);
            }
        }
    }
    
    private void drawDividersVertical(final Canvas canvas, final boolean b, final boolean b2) {
        int n = 0;
        final int paddingTop = this.getPaddingTop();
        final int max = Math.max(0, this.getHeight() - this.getPaddingBottom() - paddingTop);
        for (int i = 0; i < this.mFlexLines.size(); ++i) {
            final FlexLine flexLine = this.mFlexLines.get(i);
            int n2;
            for (int j = 0; j < flexLine.mItemCount; ++j, n = n2) {
                final View reorderedChild = this.getReorderedChildAt(n);
                n2 = n;
                if (reorderedChild != null) {
                    if (reorderedChild.getVisibility() == 8) {
                        n2 = n;
                    }
                    else {
                        final LayoutParams layoutParams = (LayoutParams)reorderedChild.getLayoutParams();
                        if (this.hasDividerBeforeChildAtAlongMainAxis(n, j)) {
                            int n3;
                            if (b2) {
                                n3 = reorderedChild.getBottom() + layoutParams.bottomMargin;
                            }
                            else {
                                n3 = reorderedChild.getTop() - layoutParams.topMargin - this.mDividerHorizontalHeight;
                            }
                            this.drawHorizontalDivider(canvas, flexLine.mLeft, n3, flexLine.mCrossSize);
                        }
                        if (j == flexLine.mItemCount - 1 && (this.mShowDividerHorizontal & 0x4) > 0) {
                            int n4;
                            if (b2) {
                                n4 = reorderedChild.getTop() - layoutParams.topMargin - this.mDividerHorizontalHeight;
                            }
                            else {
                                n4 = reorderedChild.getBottom() + layoutParams.bottomMargin;
                            }
                            this.drawHorizontalDivider(canvas, flexLine.mLeft, n4, flexLine.mCrossSize);
                        }
                        n2 = n + 1;
                    }
                }
            }
            if (this.hasDividerBeforeFlexLine(i)) {
                int mRight;
                if (b) {
                    mRight = flexLine.mRight;
                }
                else {
                    mRight = flexLine.mLeft - this.mDividerVerticalWidth;
                }
                this.drawVerticalDivider(canvas, mRight, paddingTop, max);
            }
            if (this.hasEndDividerAfterFlexLine(i) && (this.mShowDividerVertical & 0x4) > 0) {
                int mRight2;
                if (b) {
                    mRight2 = flexLine.mLeft - this.mDividerVerticalWidth;
                }
                else {
                    mRight2 = flexLine.mRight;
                }
                this.drawVerticalDivider(canvas, mRight2, paddingTop, max);
            }
        }
    }
    
    private void drawHorizontalDivider(final Canvas canvas, final int n, final int n2, final int n3) {
        if (this.mDividerDrawableHorizontal == null) {
            return;
        }
        this.mDividerDrawableHorizontal.setBounds(n, n2, n + n3, this.mDividerHorizontalHeight + n2);
        this.mDividerDrawableHorizontal.draw(canvas);
    }
    
    private void drawVerticalDivider(final Canvas canvas, final int n, final int n2, final int n3) {
        if (this.mDividerDrawableVertical == null) {
            return;
        }
        this.mDividerDrawableVertical.setBounds(n, n2, this.mDividerVerticalWidth + n, n2 + n3);
        this.mDividerDrawableVertical.draw(canvas);
    }
    
    private boolean hasDividerBeforeChildAtAlongMainAxis(final int n, final int n2) {
        if (this.allViewsAreGoneBefore(n, n2)) {
            if (this.isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerVertical & 0x1) == 0x0) {
                    return false;
                }
            }
            else if ((this.mShowDividerHorizontal & 0x1) == 0x0) {
                return false;
            }
        }
        else if (this.isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 0x2) == 0x0) {
                return false;
            }
        }
        else if ((this.mShowDividerHorizontal & 0x2) == 0x0) {
            return false;
        }
        return true;
    }
    
    private boolean hasDividerBeforeFlexLine(final int n) {
        boolean b = true;
        if (n < 0 || n >= this.mFlexLines.size()) {
            b = false;
        }
        else if (this.allFlexLinesAreDummyBefore(n)) {
            if (this.isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerHorizontal & 0x1) == 0x0) {
                    return false;
                }
            }
            else if ((this.mShowDividerVertical & 0x1) == 0x0) {
                return false;
            }
        }
        else if (this.isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 0x2) == 0x0) {
                return false;
            }
        }
        else if ((this.mShowDividerVertical & 0x2) == 0x0) {
            return false;
        }
        return b;
    }
    
    private boolean hasEndDividerAfterFlexLine(int i) {
        boolean b = true;
        if (i >= 0 && i < this.mFlexLines.size()) {
            for (++i; i < this.mFlexLines.size(); ++i) {
                if (this.mFlexLines.get(i).getItemCountNotGone() > 0) {
                    return false;
                }
            }
            if (this.isMainAxisDirectionHorizontal()) {
                return (this.mShowDividerHorizontal & 0x4) != 0x0;
            }
            if ((this.mShowDividerVertical & 0x4) == 0x0) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    private void layoutHorizontal(final boolean b, int i, int mDividerVerticalWidth, int j, int n) {
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int n2 = j - i;
        mDividerVerticalWidth = n - mDividerVerticalWidth - this.getPaddingBottom();
        i = this.getPaddingTop();
        FlexLine flexLine;
        int n3;
        float n4;
        float a;
        float n5 = 0.0f;
        float n6 = 0.0f;
        float n7;
        float n8;
        float n9;
        float max;
        float n10;
        int n11;
        View reorderedChild;
        float n12;
        float n13;
        LayoutParams layoutParams;
        float n14;
        float n15;
        int n16;
        float n17;
        float n18;
        int mDividerVerticalWidth2;
        float n19;
        for (j = 0; j < this.mFlexLines.size(); ++j) {
            flexLine = this.mFlexLines.get(j);
            n = mDividerVerticalWidth;
            n3 = i;
            if (this.hasDividerBeforeFlexLine(j)) {
                n = mDividerVerticalWidth - this.mDividerHorizontalHeight;
                n3 = i + this.mDividerHorizontalHeight;
            }
            n4 = 0.0f;
            a = 0.0f;
            switch (this.mJustifyContent) {
                default: {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                case 0: {
                    n5 = (float)paddingLeft;
                    n6 = (float)(n2 - paddingRight);
                    break;
                }
                case 1: {
                    n5 = (float)(n2 - flexLine.mMainSize + paddingRight);
                    n6 = (float)(flexLine.mMainSize - paddingLeft);
                    break;
                }
                case 2: {
                    n5 = paddingLeft + (n2 - flexLine.mMainSize) / 2.0f;
                    n6 = n2 - paddingRight - (n2 - flexLine.mMainSize) / 2.0f;
                    break;
                }
                case 4: {
                    i = flexLine.getItemCountNotGone();
                    a = n4;
                    if (i != 0) {
                        a = (n2 - flexLine.mMainSize) / (float)i;
                    }
                    n5 = paddingLeft + a / 2.0f;
                    n6 = n2 - paddingRight - a / 2.0f;
                    break;
                }
                case 3: {
                    n7 = (float)paddingLeft;
                    i = flexLine.getItemCountNotGone();
                    if (i != 1) {
                        n8 = (float)(i - 1);
                    }
                    else {
                        n8 = 1.0f;
                    }
                    a = (n2 - flexLine.mMainSize) / n8;
                    n9 = (float)(n2 - paddingRight);
                    n5 = n7;
                    n6 = n9;
                    break;
                }
            }
            max = Math.max(a, 0.0f);
            i = 0;
            n10 = n5;
            while (i < flexLine.mItemCount) {
                n11 = flexLine.mFirstIndex + i;
                reorderedChild = this.getReorderedChildAt(n11);
                n12 = n10;
                n13 = n6;
                if (reorderedChild != null) {
                    if (reorderedChild.getVisibility() == 8) {
                        n13 = n6;
                        n12 = n10;
                    }
                    else {
                        layoutParams = (LayoutParams)reorderedChild.getLayoutParams();
                        n14 = n10 + layoutParams.leftMargin;
                        n15 = n6 - layoutParams.rightMargin;
                        mDividerVerticalWidth = 0;
                        n16 = 0;
                        n17 = n14;
                        n18 = n15;
                        if (this.hasDividerBeforeChildAtAlongMainAxis(n11, i)) {
                            mDividerVerticalWidth = this.mDividerVerticalWidth;
                            n17 = n14 + mDividerVerticalWidth;
                            n18 = n15 - mDividerVerticalWidth;
                        }
                        mDividerVerticalWidth2 = n16;
                        if (i == flexLine.mItemCount - 1) {
                            mDividerVerticalWidth2 = n16;
                            if ((this.mShowDividerVertical & 0x4) > 0) {
                                mDividerVerticalWidth2 = this.mDividerVerticalWidth;
                            }
                        }
                        if (this.mFlexWrap == 2) {
                            if (b) {
                                this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChild, flexLine, Math.round(n18) - reorderedChild.getMeasuredWidth(), n - reorderedChild.getMeasuredHeight(), Math.round(n18), n);
                            }
                            else {
                                this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChild, flexLine, Math.round(n17), n - reorderedChild.getMeasuredHeight(), Math.round(n17) + reorderedChild.getMeasuredWidth(), n);
                            }
                        }
                        else if (b) {
                            this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChild, flexLine, Math.round(n18) - reorderedChild.getMeasuredWidth(), n3, Math.round(n18), n3 + reorderedChild.getMeasuredHeight());
                        }
                        else {
                            this.mFlexboxHelper.layoutSingleChildHorizontal(reorderedChild, flexLine, Math.round(n17), n3, Math.round(n17) + reorderedChild.getMeasuredWidth(), n3 + reorderedChild.getMeasuredHeight());
                        }
                        n19 = n17 + (reorderedChild.getMeasuredWidth() + max + layoutParams.rightMargin);
                        n13 = n18 - (reorderedChild.getMeasuredWidth() + max + layoutParams.leftMargin);
                        if (b) {
                            flexLine.updatePositionFromView(reorderedChild, mDividerVerticalWidth2, 0, mDividerVerticalWidth, 0);
                            n12 = n19;
                        }
                        else {
                            flexLine.updatePositionFromView(reorderedChild, mDividerVerticalWidth, 0, mDividerVerticalWidth2, 0);
                            n12 = n19;
                        }
                    }
                }
                ++i;
                n10 = n12;
                n6 = n13;
            }
            i = n3 + flexLine.mCrossSize;
            mDividerVerticalWidth = n - flexLine.mCrossSize;
        }
    }
    
    private void layoutVertical(final boolean b, final boolean b2, int i, int mDividerHorizontalHeight, int j, int n) {
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        final int paddingRight = this.getPaddingRight();
        final int paddingLeft = this.getPaddingLeft();
        final int n2 = n - mDividerHorizontalHeight;
        i = j - i - paddingRight;
        j = 0;
        final int size = this.mFlexLines.size();
        mDividerHorizontalHeight = paddingLeft;
        while (j < size) {
            final FlexLine flexLine = this.mFlexLines.get(j);
            n = i;
            int n3 = mDividerHorizontalHeight;
            if (this.hasDividerBeforeFlexLine(j)) {
                n3 = mDividerHorizontalHeight + this.mDividerVerticalWidth;
                n = i - this.mDividerVerticalWidth;
            }
            final float n4 = 0.0f;
            float a = 0.0f;
            float n5 = 0.0f;
            float n6 = 0.0f;
            switch (this.mJustifyContent) {
                default: {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                case 0: {
                    n5 = (float)paddingTop;
                    n6 = (float)(n2 - paddingBottom);
                    break;
                }
                case 1: {
                    n5 = (float)(n2 - flexLine.mMainSize + paddingBottom);
                    n6 = (float)(flexLine.mMainSize - paddingTop);
                    break;
                }
                case 2: {
                    n5 = paddingTop + (n2 - flexLine.mMainSize) / 2.0f;
                    n6 = n2 - paddingBottom - (n2 - flexLine.mMainSize) / 2.0f;
                    break;
                }
                case 4: {
                    i = flexLine.getItemCountNotGone();
                    a = n4;
                    if (i != 0) {
                        a = (n2 - flexLine.mMainSize) / (float)i;
                    }
                    n5 = paddingTop + a / 2.0f;
                    n6 = n2 - paddingBottom - a / 2.0f;
                    break;
                }
                case 3: {
                    n5 = (float)paddingTop;
                    i = flexLine.getItemCountNotGone();
                    float n7;
                    if (i != 1) {
                        n7 = (float)(i - 1);
                    }
                    else {
                        n7 = 1.0f;
                    }
                    a = (n2 - flexLine.mMainSize) / n7;
                    n6 = (float)(n2 - paddingBottom);
                    break;
                }
            }
            final float max = Math.max(a, 0.0f);
            int n8;
            View reorderedChild;
            float n9;
            float n10;
            LayoutParams layoutParams;
            float n11;
            float n12;
            int n13;
            float n14;
            float n15;
            int mDividerHorizontalHeight2;
            for (i = 0; i < flexLine.mItemCount; ++i, n6 = n9, n5 = n10) {
                n8 = flexLine.mFirstIndex + i;
                reorderedChild = this.getReorderedChildAt(n8);
                n9 = n6;
                n10 = n5;
                if (reorderedChild != null) {
                    if (reorderedChild.getVisibility() == 8) {
                        n10 = n5;
                        n9 = n6;
                    }
                    else {
                        layoutParams = (LayoutParams)reorderedChild.getLayoutParams();
                        n11 = n5 + layoutParams.topMargin;
                        n12 = n6 - layoutParams.bottomMargin;
                        mDividerHorizontalHeight = 0;
                        n13 = 0;
                        n14 = n12;
                        n15 = n11;
                        if (this.hasDividerBeforeChildAtAlongMainAxis(n8, i)) {
                            mDividerHorizontalHeight = this.mDividerHorizontalHeight;
                            n15 = n11 + mDividerHorizontalHeight;
                            n14 = n12 - mDividerHorizontalHeight;
                        }
                        mDividerHorizontalHeight2 = n13;
                        if (i == flexLine.mItemCount - 1) {
                            mDividerHorizontalHeight2 = n13;
                            if ((this.mShowDividerHorizontal & 0x4) > 0) {
                                mDividerHorizontalHeight2 = this.mDividerHorizontalHeight;
                            }
                        }
                        if (b) {
                            if (b2) {
                                this.mFlexboxHelper.layoutSingleChildVertical(reorderedChild, flexLine, true, n - reorderedChild.getMeasuredWidth(), Math.round(n14) - reorderedChild.getMeasuredHeight(), n, Math.round(n14));
                            }
                            else {
                                this.mFlexboxHelper.layoutSingleChildVertical(reorderedChild, flexLine, true, n - reorderedChild.getMeasuredWidth(), Math.round(n15), n, Math.round(n15) + reorderedChild.getMeasuredHeight());
                            }
                        }
                        else if (b2) {
                            this.mFlexboxHelper.layoutSingleChildVertical(reorderedChild, flexLine, false, n3, Math.round(n14) - reorderedChild.getMeasuredHeight(), n3 + reorderedChild.getMeasuredWidth(), Math.round(n14));
                        }
                        else {
                            this.mFlexboxHelper.layoutSingleChildVertical(reorderedChild, flexLine, false, n3, Math.round(n15), n3 + reorderedChild.getMeasuredWidth(), Math.round(n15) + reorderedChild.getMeasuredHeight());
                        }
                        n10 = n15 + (reorderedChild.getMeasuredHeight() + max + layoutParams.bottomMargin);
                        n9 = n14 - (reorderedChild.getMeasuredHeight() + max + layoutParams.topMargin);
                        if (b2) {
                            flexLine.updatePositionFromView(reorderedChild, 0, mDividerHorizontalHeight2, 0, mDividerHorizontalHeight);
                        }
                        else {
                            flexLine.updatePositionFromView(reorderedChild, 0, mDividerHorizontalHeight, 0, mDividerHorizontalHeight2);
                        }
                    }
                }
            }
            mDividerHorizontalHeight = n3 + flexLine.mCrossSize;
            i = n - flexLine.mCrossSize;
            ++j;
        }
    }
    
    private void measureHorizontal(final int n, final int n2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, n, n2);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(n, n2);
        if (this.mAlignItems == 3) {
            int n3 = 0;
            for (final FlexLine flexLine : this.mFlexLines) {
                int mCrossSize = Integer.MIN_VALUE;
                for (int i = n3; i < flexLine.mItemCount + n3; ++i) {
                    final View reorderedChild = this.getReorderedChildAt(i);
                    final LayoutParams layoutParams = (LayoutParams)reorderedChild.getLayoutParams();
                    if (this.mFlexWrap != 2) {
                        mCrossSize = Math.max(mCrossSize, reorderedChild.getHeight() + Math.max(flexLine.mMaxBaseline - reorderedChild.getBaseline(), layoutParams.topMargin) + layoutParams.bottomMargin);
                    }
                    else {
                        mCrossSize = Math.max(mCrossSize, reorderedChild.getHeight() + layoutParams.topMargin + Math.max(flexLine.mMaxBaseline - reorderedChild.getMeasuredHeight() + reorderedChild.getBaseline(), layoutParams.bottomMargin));
                    }
                }
                flexLine.mCrossSize = mCrossSize;
                n3 += flexLine.mItemCount;
            }
        }
        this.mFlexboxHelper.determineCrossSize(n, n2, this.getPaddingTop() + this.getPaddingBottom());
        this.mFlexboxHelper.stretchViews();
        this.setMeasuredDimensionForFlex(this.mFlexDirection, n, n2, this.mFlexLinesResult.mChildState);
    }
    
    private void measureVertical(final int n, final int n2) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, n, n2);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(n, n2);
        this.mFlexboxHelper.determineCrossSize(n, n2, this.getPaddingLeft() + this.getPaddingRight());
        this.mFlexboxHelper.stretchViews();
        this.setMeasuredDimensionForFlex(this.mFlexDirection, n, n2, this.mFlexLinesResult.mChildState);
    }
    
    private void setMeasuredDimensionForFlex(int i, int n, final int n2, int n3) {
        final int mode = View$MeasureSpec.getMode(n);
        final int size = View$MeasureSpec.getSize(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        final int size2 = View$MeasureSpec.getSize(n2);
        int largestMainSize = 0;
        switch (i) {
            default: {
                throw new IllegalArgumentException("Invalid flex direction: " + i);
            }
            case 0:
            case 1: {
                i = this.getSumOfCrossSize() + this.getPaddingTop() + this.getPaddingBottom();
                largestMainSize = this.getLargestMainSize();
                break;
            }
            case 2:
            case 3: {
                i = this.getLargestMainSize();
                largestMainSize = this.getSumOfCrossSize() + this.getPaddingLeft() + this.getPaddingRight();
                break;
            }
        }
        switch (mode) {
            default: {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            case 1073741824: {
                int combineMeasuredStates = n3;
                if (size < largestMainSize) {
                    combineMeasuredStates = ViewCompat.combineMeasuredStates(n3, 16777216);
                }
                n = ViewCompat.resolveSizeAndState(size, n, combineMeasuredStates);
                n3 = combineMeasuredStates;
                break;
            }
            case Integer.MIN_VALUE: {
                if (size < largestMainSize) {
                    n3 = ViewCompat.combineMeasuredStates(n3, 16777216);
                    largestMainSize = size;
                }
                n = ViewCompat.resolveSizeAndState(largestMainSize, n, n3);
                break;
            }
            case 0: {
                n = ViewCompat.resolveSizeAndState(largestMainSize, n, n3);
                break;
            }
        }
        switch (mode2) {
            default: {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            case 1073741824: {
                int combineMeasuredStates2 = n3;
                if (size2 < i) {
                    combineMeasuredStates2 = ViewCompat.combineMeasuredStates(n3, 256);
                }
                i = ViewCompat.resolveSizeAndState(size2, n2, combineMeasuredStates2);
                break;
            }
            case Integer.MIN_VALUE: {
                if (size2 < i) {
                    n3 = ViewCompat.combineMeasuredStates(n3, 256);
                    i = size2;
                }
                i = ViewCompat.resolveSizeAndState(i, n2, n3);
                break;
            }
            case 0: {
                i = ViewCompat.resolveSizeAndState(i, n2, n3);
                break;
            }
        }
        this.setMeasuredDimension(n, i);
    }
    
    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            this.setWillNotDraw(true);
            return;
        }
        this.setWillNotDraw(false);
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(this.getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(view, n, viewGroup$LayoutParams, this.mOrderCache);
        super.addView(view, n, viewGroup$LayoutParams);
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams;
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)new LayoutParams(viewGroup$LayoutParams);
    }
    
    public LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    public int getAlignContent() {
        return this.mAlignContent;
    }
    
    public int getAlignItems() {
        return this.mAlignItems;
    }
    
    public int getChildHeightMeasureSpec(final int n, final int n2, final int n3) {
        return getChildMeasureSpec(n, n2, n3);
    }
    
    public int getChildWidthMeasureSpec(final int n, final int n2, final int n3) {
        return getChildMeasureSpec(n, n2, n3);
    }
    
    public int getDecorationLengthCrossAxis(final View view) {
        return 0;
    }
    
    public int getDecorationLengthMainAxis(final View view, int n, final int n2) {
        final int n3 = 0;
        int n4 = 0;
        if (this.isMainAxisDirectionHorizontal()) {
            if (this.hasDividerBeforeChildAtAlongMainAxis(n, n2)) {
                n4 = 0 + this.mDividerVerticalWidth;
            }
            n = n4;
            if ((this.mShowDividerVertical & 0x4) > 0) {
                n = n4 + this.mDividerVerticalWidth;
            }
        }
        else {
            int n5 = n3;
            if (this.hasDividerBeforeChildAtAlongMainAxis(n, n2)) {
                n5 = 0 + this.mDividerHorizontalHeight;
            }
            n = n5;
            if ((this.mShowDividerHorizontal & 0x4) > 0) {
                return n5 + this.mDividerHorizontalHeight;
            }
        }
        return n;
    }
    
    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }
    
    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }
    
    public int getFlexDirection() {
        return this.mFlexDirection;
    }
    
    public View getFlexItemAt(final int n) {
        return this.getChildAt(n);
    }
    
    public int getFlexItemCount() {
        return this.getChildCount();
    }
    
    public List<FlexLine> getFlexLines() {
        final ArrayList<FlexLine> list = new ArrayList<FlexLine>(this.mFlexLines.size());
        for (final FlexLine flexLine : this.mFlexLines) {
            if (flexLine.getItemCountNotGone() != 0) {
                list.add(flexLine);
            }
        }
        return list;
    }
    
    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }
    
    public int getFlexWrap() {
        return this.mFlexWrap;
    }
    
    public int getJustifyContent() {
        return this.mJustifyContent;
    }
    
    public int getLargestMainSize() {
        int max = Integer.MIN_VALUE;
        final Iterator<FlexLine> iterator = this.mFlexLines.iterator();
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next().mMainSize);
        }
        return max;
    }
    
    public View getReorderedChildAt(final int n) {
        if (n < 0 || n >= this.mReorderedIndices.length) {
            return null;
        }
        return this.getChildAt(this.mReorderedIndices[n]);
    }
    
    public View getReorderedFlexItemAt(final int n) {
        return this.getReorderedChildAt(n);
    }
    
    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }
    
    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }
    
    public int getSumOfCrossSize() {
        int n = 0;
        for (int i = 0; i < this.mFlexLines.size(); ++i) {
            final FlexLine flexLine = this.mFlexLines.get(i);
            int n2 = n;
            if (this.hasDividerBeforeFlexLine(i)) {
                if (this.isMainAxisDirectionHorizontal()) {
                    n2 = n + this.mDividerHorizontalHeight;
                }
                else {
                    n2 = n + this.mDividerVerticalWidth;
                }
            }
            int n3 = n2;
            if (this.hasEndDividerAfterFlexLine(i)) {
                if (this.isMainAxisDirectionHorizontal()) {
                    n3 = n2 + this.mDividerHorizontalHeight;
                }
                else {
                    n3 = n2 + this.mDividerVerticalWidth;
                }
            }
            n = n3 + flexLine.mCrossSize;
        }
        return n;
    }
    
    public boolean isMainAxisDirectionHorizontal() {
        return this.mFlexDirection == 0 || this.mFlexDirection == 1;
    }
    
    protected void onDraw(final Canvas canvas) {
        if ((this.mDividerDrawableVertical == null && this.mDividerDrawableHorizontal == null) || (this.mShowDividerHorizontal == 0 && this.mShowDividerVertical == 0)) {
            return;
        }
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        final boolean b = false;
        boolean b2 = false;
        switch (this.mFlexDirection) {
            default: {}
            case 0: {
                final boolean b3 = layoutDirection == 1;
                if (this.mFlexWrap == 2) {
                    b2 = true;
                }
                this.drawDividersHorizontal(canvas, b3, b2);
            }
            case 1: {
                final boolean b4 = layoutDirection != 1;
                boolean b5 = b;
                if (this.mFlexWrap == 2) {
                    b5 = true;
                }
                this.drawDividersHorizontal(canvas, b4, b5);
            }
            case 2: {
                boolean b6 = layoutDirection == 1;
                if (this.mFlexWrap == 2) {
                    b6 = !b6;
                }
                this.drawDividersVertical(canvas, b6, false);
            }
            case 3: {
                boolean b7 = layoutDirection == 1;
                if (this.mFlexWrap == 2) {
                    b7 = !b7;
                }
                this.drawDividersVertical(canvas, b7, true);
            }
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        switch (this.mFlexDirection) {
            default: {
                throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
            }
            case 0: {
                this.layoutHorizontal(layoutDirection == 1, n, n2, n3, n4);
            }
            case 1: {
                this.layoutHorizontal(layoutDirection != 1, n, n2, n3, n4);
            }
            case 2: {
                boolean b2 = layoutDirection == 1;
                if (this.mFlexWrap == 2) {
                    b2 = !b2;
                }
                this.layoutVertical(b2, false, n, n2, n3, n4);
            }
            case 3: {
                boolean b3 = layoutDirection == 1;
                if (this.mFlexWrap == 2) {
                    b3 = !b3;
                }
                this.layoutVertical(b3, true, n, n2, n3, n4);
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(this.getChildCount());
        }
        if (this.mFlexboxHelper.isOrderChangedFromLastMeasurement(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(this.mOrderCache);
        }
        switch (this.mFlexDirection) {
            default: {
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
            }
            case 0:
            case 1: {
                this.measureHorizontal(n, n2);
            }
            case 2:
            case 3: {
                this.measureVertical(n, n2);
            }
        }
    }
    
    public void onNewFlexItemAdded(final View view, final int n, final int n2, final FlexLine flexLine) {
        if (this.hasDividerBeforeChildAtAlongMainAxis(n, n2)) {
            if (!this.isMainAxisDirectionHorizontal()) {
                flexLine.mMainSize += this.mDividerHorizontalHeight;
                flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
                return;
            }
            flexLine.mMainSize += this.mDividerVerticalWidth;
            flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
        }
    }
    
    public void onNewFlexLineAdded(final FlexLine flexLine) {
        if (this.isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 0x4) > 0) {
                flexLine.mMainSize += this.mDividerVerticalWidth;
                flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
            }
        }
        else if ((this.mShowDividerHorizontal & 0x4) > 0) {
            flexLine.mMainSize += this.mDividerHorizontalHeight;
            flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
        }
    }
    
    public void setAlignContent(final int mAlignContent) {
        if (this.mAlignContent != mAlignContent) {
            this.mAlignContent = mAlignContent;
            this.requestLayout();
        }
    }
    
    public void setAlignItems(final int mAlignItems) {
        if (this.mAlignItems != mAlignItems) {
            this.mAlignItems = mAlignItems;
            this.requestLayout();
        }
    }
    
    public void setDividerDrawable(final Drawable drawable) {
        this.setDividerDrawableHorizontal(drawable);
        this.setDividerDrawableVertical(drawable);
    }
    
    public void setDividerDrawableHorizontal(@Nullable final Drawable mDividerDrawableHorizontal) {
        if (mDividerDrawableHorizontal == this.mDividerDrawableHorizontal) {
            return;
        }
        if ((this.mDividerDrawableHorizontal = mDividerDrawableHorizontal) != null) {
            this.mDividerHorizontalHeight = mDividerDrawableHorizontal.getIntrinsicHeight();
        }
        else {
            this.mDividerHorizontalHeight = 0;
        }
        this.setWillNotDrawFlag();
        this.requestLayout();
    }
    
    public void setDividerDrawableVertical(@Nullable final Drawable mDividerDrawableVertical) {
        if (mDividerDrawableVertical == this.mDividerDrawableVertical) {
            return;
        }
        if ((this.mDividerDrawableVertical = mDividerDrawableVertical) != null) {
            this.mDividerVerticalWidth = mDividerDrawableVertical.getIntrinsicWidth();
        }
        else {
            this.mDividerVerticalWidth = 0;
        }
        this.setWillNotDrawFlag();
        this.requestLayout();
    }
    
    public void setFlexDirection(final int mFlexDirection) {
        if (this.mFlexDirection != mFlexDirection) {
            this.mFlexDirection = mFlexDirection;
            this.requestLayout();
        }
    }
    
    public void setFlexLines(final List<FlexLine> mFlexLines) {
        this.mFlexLines = mFlexLines;
    }
    
    public void setFlexWrap(final int mFlexWrap) {
        if (this.mFlexWrap != mFlexWrap) {
            this.mFlexWrap = mFlexWrap;
            this.requestLayout();
        }
    }
    
    public void setJustifyContent(final int mJustifyContent) {
        if (this.mJustifyContent != mJustifyContent) {
            this.mJustifyContent = mJustifyContent;
            this.requestLayout();
        }
    }
    
    public void setShowDivider(final int n) {
        this.setShowDividerVertical(n);
        this.setShowDividerHorizontal(n);
    }
    
    public void setShowDividerHorizontal(final int mShowDividerHorizontal) {
        if (mShowDividerHorizontal != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = mShowDividerHorizontal;
            this.requestLayout();
        }
    }
    
    public void setShowDividerVertical(final int mShowDividerVertical) {
        if (mShowDividerVertical != this.mShowDividerVertical) {
            this.mShowDividerVertical = mShowDividerVertical;
            this.requestLayout();
        }
    }
    
    public void updateViewCache(final int n, final View view) {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }
    
    public static class LayoutParams extends ViewGroup$MarginLayoutParams implements FlexItem
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
        private int mOrder;
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
            super(new ViewGroup$LayoutParams(n, n2));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        public LayoutParams(final Context context, final AttributeSet set) {
            super(context, set);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, 0);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }
        
        protected LayoutParams(final Parcel parcel) {
            boolean mWrapBefore = true;
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            if (parcel.readByte() == 0) {
                mWrapBefore = false;
            }
            this.mWrapBefore = mWrapBefore;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
        
        public LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        public LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }
        
        public LayoutParams(final LayoutParams layoutParams) {
            super((ViewGroup$MarginLayoutParams)layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = layoutParams.mOrder;
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
        
        public int getAlignSelf() {
            return this.mAlignSelf;
        }
        
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }
        
        public float getFlexGrow() {
            return this.mFlexGrow;
        }
        
        public float getFlexShrink() {
            return this.mFlexShrink;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public int getMarginBottom() {
            return this.bottomMargin;
        }
        
        public int getMarginLeft() {
            return this.leftMargin;
        }
        
        public int getMarginRight() {
            return this.rightMargin;
        }
        
        public int getMarginTop() {
            return this.topMargin;
        }
        
        public int getMaxHeight() {
            return this.mMaxHeight;
        }
        
        public int getMaxWidth() {
            return this.mMaxWidth;
        }
        
        public int getMinHeight() {
            return this.mMinHeight;
        }
        
        public int getMinWidth() {
            return this.mMinWidth;
        }
        
        public int getOrder() {
            return this.mOrder;
        }
        
        public int getWidth() {
            return this.width;
        }
        
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }
        
        public void setAlignSelf(final int mAlignSelf) {
            this.mAlignSelf = mAlignSelf;
        }
        
        public void setFlexBasisPercent(final float mFlexBasisPercent) {
            this.mFlexBasisPercent = mFlexBasisPercent;
        }
        
        public void setFlexGrow(final float mFlexGrow) {
            this.mFlexGrow = mFlexGrow;
        }
        
        public void setFlexShrink(final float mFlexShrink) {
            this.mFlexShrink = mFlexShrink;
        }
        
        public void setHeight(final int height) {
            this.height = height;
        }
        
        public void setMaxHeight(final int mMaxHeight) {
            this.mMaxHeight = mMaxHeight;
        }
        
        public void setMaxWidth(final int mMaxWidth) {
            this.mMaxWidth = mMaxWidth;
        }
        
        public void setMinHeight(final int mMinHeight) {
            this.mMinHeight = mMinHeight;
        }
        
        public void setMinWidth(final int mMinWidth) {
            this.mMinWidth = mMinWidth;
        }
        
        public void setOrder(final int mOrder) {
            this.mOrder = mOrder;
        }
        
        public void setWidth(final int width) {
            this.width = width;
        }
        
        public void setWrapBefore(final boolean mWrapBefore) {
            this.mWrapBefore = mWrapBefore;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeInt(this.mOrder);
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
}
