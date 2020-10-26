// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.io.IOException;
import com.google.common.annotations.Beta;

@Beta
public interface ByteProcessor<T>
{
    T getResult();
    
    boolean processBytes(final byte[] p0, final int p1, final int p2) throws IOException;
}
