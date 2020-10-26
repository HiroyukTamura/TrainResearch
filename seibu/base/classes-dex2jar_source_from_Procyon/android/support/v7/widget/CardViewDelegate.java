// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v7.widget;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(9)
@RequiresApi(9)
interface CardViewDelegate
{
    Drawable getCardBackground();
    
    View getCardView();
    
    boolean getPreventCornerOverlap();
    
    boolean getUseCompatPadding();
    
    void setCardBackground(final Drawable p0);
    
    void setMinWidthHeightInternal(final int p0, final int p1);
    
    void setShadowPadding(final int p0, final int p1, final int p2, final int p3);
}
