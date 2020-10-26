// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.loader;

import android.view.View;
import android.content.Context;
import android.widget.ImageView;

public abstract class ImageLoader implements ImageLoaderInterface<ImageView>
{
    @Override
    public ImageView createImageView(final Context context) {
        return new ImageView(context);
    }
}
