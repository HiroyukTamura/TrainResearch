// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawableResource;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.Glide;
import android.content.Context;
import android.content.res.Resources;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import android.graphics.Bitmap;

public class GlideBitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, GlideBitmapDrawable>
{
    private final BitmapPool bitmapPool;
    private final Resources resources;
    
    public GlideBitmapDrawableTranscoder(final Context context) {
        this(context.getResources(), Glide.get(context).getBitmapPool());
    }
    
    public GlideBitmapDrawableTranscoder(final Resources resources, final BitmapPool bitmapPool) {
        this.resources = resources;
        this.bitmapPool = bitmapPool;
    }
    
    @Override
    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
    
    @Override
    public Resource<GlideBitmapDrawable> transcode(final Resource<Bitmap> resource) {
        return new GlideBitmapDrawableResource(new GlideBitmapDrawable(this.resources, resource.get()), this.bitmapPool);
    }
}
