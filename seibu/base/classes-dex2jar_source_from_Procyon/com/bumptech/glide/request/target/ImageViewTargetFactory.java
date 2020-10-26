// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import android.widget.ImageView;

public class ImageViewTargetFactory
{
    public <Z> Target<Z> buildTarget(final ImageView imageView, final Class<Z> clazz) {
        if (GlideDrawable.class.isAssignableFrom(clazz)) {
            return (Target<Z>)new GlideDrawableImageViewTarget(imageView);
        }
        if (Bitmap.class.equals(clazz)) {
            return (Target<Z>)new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(clazz)) {
            return (Target<Z>)new DrawableImageViewTarget(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + clazz + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
