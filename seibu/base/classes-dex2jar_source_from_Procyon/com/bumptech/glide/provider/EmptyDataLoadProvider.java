// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;

public class EmptyDataLoadProvider<T, Z> implements DataLoadProvider<T, Z>
{
    private static final DataLoadProvider<?, ?> EMPTY_DATA_LOAD_PROVIDER;
    
    static {
        EMPTY_DATA_LOAD_PROVIDER = new EmptyDataLoadProvider<Object, Object>();
    }
    
    public static <T, Z> DataLoadProvider<T, Z> get() {
        return (DataLoadProvider<T, Z>)EmptyDataLoadProvider.EMPTY_DATA_LOAD_PROVIDER;
    }
    
    @Override
    public ResourceDecoder<File, Z> getCacheDecoder() {
        return null;
    }
    
    @Override
    public ResourceEncoder<Z> getEncoder() {
        return null;
    }
    
    @Override
    public ResourceDecoder<T, Z> getSourceDecoder() {
        return null;
    }
    
    @Override
    public Encoder<T> getSourceEncoder() {
        return null;
    }
}
