// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;

public interface ModelLoader<T, Y>
{
    DataFetcher<Y> getResourceFetcher(final T p0, final int p1, final int p2);
}
