// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request.animation;

import android.view.View;
import android.graphics.drawable.Drawable;

public interface GlideAnimation<R>
{
    boolean animate(final R p0, final ViewAdapter p1);
    
    public interface ViewAdapter
    {
        Drawable getCurrentDrawable();
        
        View getView();
        
        void setDrawable(final Drawable p0);
    }
}
