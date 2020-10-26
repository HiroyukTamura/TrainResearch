// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;

public interface DataLoadProvider<T, Z>
{
    ResourceDecoder<File, Z> getCacheDecoder();
    
    ResourceEncoder<Z> getEncoder();
    
    ResourceDecoder<T, Z> getSourceDecoder();
    
    Encoder<T> getSourceEncoder();
}
