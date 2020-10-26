// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request.target;

import android.widget.ImageView;
import android.graphics.Bitmap;

public class BitmapImageViewTarget extends ImageViewTarget<Bitmap>
{
    public BitmapImageViewTarget(final ImageView imageView) {
        super(imageView);
    }
    
    @Override
    protected void setResource(final Bitmap imageBitmap) {
        ((ImageView)this.view).setImageBitmap(imageBitmap);
    }
}
