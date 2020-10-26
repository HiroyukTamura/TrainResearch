// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.flexbox;

import android.os.Parcelable;

interface FlexItem extends Parcelable
{
    public static final float FLEX_BASIS_PERCENT_DEFAULT = -1.0f;
    public static final float FLEX_GROW_DEFAULT = 0.0f;
    public static final float FLEX_SHRINK_DEFAULT = 1.0f;
    public static final int MAX_SIZE = 16777215;
    public static final int ORDER_DEFAULT = 1;
    
    int getAlignSelf();
    
    float getFlexBasisPercent();
    
    float getFlexGrow();
    
    float getFlexShrink();
    
    int getHeight();
    
    int getMarginBottom();
    
    int getMarginEnd();
    
    int getMarginLeft();
    
    int getMarginRight();
    
    int getMarginStart();
    
    int getMarginTop();
    
    int getMaxHeight();
    
    int getMaxWidth();
    
    int getMinHeight();
    
    int getMinWidth();
    
    int getOrder();
    
    int getWidth();
    
    boolean isWrapBefore();
    
    void setAlignSelf(final int p0);
    
    void setFlexBasisPercent(final float p0);
    
    void setFlexGrow(final float p0);
    
    void setFlexShrink(final float p0);
    
    void setHeight(final int p0);
    
    void setMaxHeight(final int p0);
    
    void setMaxWidth(final int p0);
    
    void setMinHeight(final int p0);
    
    void setMinWidth(final int p0);
    
    void setOrder(final int p0);
    
    void setWidth(final int p0);
    
    void setWrapBefore(final boolean p0);
}
