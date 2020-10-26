// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;

public class BytesResource implements Resource<byte[]>
{
    private final byte[] bytes;
    
    public BytesResource(final byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException("Bytes must not be null");
        }
        this.bytes = bytes;
    }
    
    @Override
    public byte[] get() {
        return this.bytes;
    }
    
    @Override
    public int getSize() {
        return this.bytes.length;
    }
    
    @Override
    public void recycle() {
    }
}
