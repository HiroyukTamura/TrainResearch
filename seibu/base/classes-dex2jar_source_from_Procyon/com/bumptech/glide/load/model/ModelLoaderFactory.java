// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import android.content.Context;

public interface ModelLoaderFactory<T, Y>
{
    ModelLoader<T, Y> build(final Context p0, final GenericLoaderFactory p1);
    
    void teardown();
}
