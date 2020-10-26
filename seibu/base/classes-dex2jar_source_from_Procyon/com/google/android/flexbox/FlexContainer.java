// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import java.util.List;
import android.view.View;

interface FlexContainer
{
    void addView(final View p0);
    
    void addView(final View p0, final int p1);
    
    int getAlignContent();
    
    int getAlignItems();
    
    int getChildHeightMeasureSpec(final int p0, final int p1, final int p2);
    
    int getChildWidthMeasureSpec(final int p0, final int p1, final int p2);
    
    int getDecorationLengthCrossAxis(final View p0);
    
    int getDecorationLengthMainAxis(final View p0, final int p1, final int p2);
    
    int getFlexDirection();
    
    View getFlexItemAt(final int p0);
    
    int getFlexItemCount();
    
    List<FlexLine> getFlexLines();
    
    List<FlexLine> getFlexLinesInternal();
    
    int getFlexWrap();
    
    int getJustifyContent();
    
    int getLargestMainSize();
    
    int getPaddingBottom();
    
    int getPaddingEnd();
    
    int getPaddingLeft();
    
    int getPaddingRight();
    
    int getPaddingStart();
    
    int getPaddingTop();
    
    View getReorderedFlexItemAt(final int p0);
    
    int getSumOfCrossSize();
    
    boolean isMainAxisDirectionHorizontal();
    
    void onNewFlexItemAdded(final View p0, final int p1, final int p2, final FlexLine p3);
    
    void onNewFlexLineAdded(final FlexLine p0);
    
    void removeAllViews();
    
    void removeViewAt(final int p0);
    
    void setAlignContent(final int p0);
    
    void setAlignItems(final int p0);
    
    void setFlexDirection(final int p0);
    
    void setFlexLines(final List<FlexLine> p0);
    
    void setFlexWrap(final int p0);
    
    void setJustifyContent(final int p0);
    
    void updateViewCache(final int p0, final View p1);
}
