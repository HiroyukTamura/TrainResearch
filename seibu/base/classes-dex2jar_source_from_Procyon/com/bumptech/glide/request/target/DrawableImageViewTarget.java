// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request.target;

import android.widget.ImageView;
import android.graphics.drawable.Drawable;

public class DrawableImageViewTarget extends ImageViewTarget<Drawable>
{
    public DrawableImageViewTarget(final ImageView imageView) {
        super(imageView);
    }
    
    @Override
    protected void setResource(final Drawable imageDrawable) {
        ((ImageView)this.view).setImageDrawable(imageDrawable);
    }
}
