// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.drawable;

import com.bumptech.glide.load.engine.Resource;
import android.graphics.drawable.Drawable;

public abstract class DrawableResource<T extends Drawable> implements Resource<T>
{
    protected final T drawable;
    
    public DrawableResource(final T drawable) {
        if (drawable == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.drawable = drawable;
    }
    
    @Override
    public final T get() {
        return (T)this.drawable.getConstantState().newDrawable();
    }
}
