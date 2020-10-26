// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.model.ModelLoader;

public interface LoadProvider<A, T, Z, R> extends DataLoadProvider<T, Z>
{
    ModelLoader<A, T> getModelLoader();
    
    ResourceTranscoder<Z, R> getTranscoder();
}
