// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource;

import java.io.OutputStream;
import com.bumptech.glide.load.Encoder;

public class NullEncoder<T> implements Encoder<T>
{
    private static final NullEncoder<?> NULL_ENCODER;
    
    static {
        NULL_ENCODER = new NullEncoder<Object>();
    }
    
    public static <T> Encoder<T> get() {
        return (Encoder<T>)NullEncoder.NULL_ENCODER;
    }
    
    @Override
    public boolean encode(final T t, final OutputStream outputStream) {
        return false;
    }
    
    @Override
    public String getId() {
        return "";
    }
}
