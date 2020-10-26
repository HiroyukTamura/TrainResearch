// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine;

public interface Resource<Z>
{
    Z get();
    
    int getSize();
    
    void recycle();
}
