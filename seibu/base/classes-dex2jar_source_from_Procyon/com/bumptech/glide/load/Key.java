// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public interface Key
{
    public static final String STRING_CHARSET_NAME = "UTF-8";
    
    boolean equals(final Object p0);
    
    int hashCode();
    
    void updateDiskCacheKey(final MessageDigest p0) throws UnsupportedEncodingException;
}
