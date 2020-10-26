// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import com.bumptech.glide.load.Key;

class OriginalKey implements Key
{
    private final String id;
    private final Key signature;
    
    public OriginalKey(final String id, final Key signature) {
        this.id = id;
        this.signature = signature;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final OriginalKey originalKey = (OriginalKey)o;
            if (!this.id.equals(originalKey.id)) {
                return false;
            }
            if (!this.signature.equals(originalKey.signature)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.id.hashCode() * 31 + this.signature.hashCode();
    }
    
    @Override
    public void updateDiskCacheKey(final MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
