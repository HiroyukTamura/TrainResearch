// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load;

import java.io.OutputStream;

public interface Encoder<T>
{
    boolean encode(final T p0, final OutputStream p1);
    
    String getId();
}
