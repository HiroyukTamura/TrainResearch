// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.Map;

public interface Headers
{
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();
    @Deprecated
    public static final Headers NONE = new Headers() {
        @Override
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    };
    
    Map<String, String> getHeaders();
}
