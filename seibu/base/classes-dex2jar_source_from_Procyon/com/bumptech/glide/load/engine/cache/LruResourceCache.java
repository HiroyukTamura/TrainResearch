// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache
{
    private ResourceRemovedListener listener;
    
    public LruResourceCache(final int n) {
        super(n);
    }
    
    @Override
    protected int getSize(final Resource<?> resource) {
        return resource.getSize();
    }
    
    @Override
    protected void onItemEvicted(final Key key, final Resource<?> resource) {
        if (this.listener != null) {
            this.listener.onResourceRemoved(resource);
        }
    }
    
    @Override
    public void setResourceRemovedListener(final ResourceRemovedListener listener) {
        this.listener = listener;
    }
    
    @SuppressLint({ "InlinedApi" })
    @Override
    public void trimMemory(final int n) {
        if (n >= 60) {
            this.clearMemory();
        }
        else if (n >= 40) {
            this.trimToSize(this.getCurrentSize() / 2);
        }
    }
}
