// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.transcode;

import java.util.HashMap;
import java.util.Map;
import com.bumptech.glide.util.MultiClassKey;

public class TranscoderRegistry
{
    private static final MultiClassKey GET_KEY;
    private final Map<MultiClassKey, ResourceTranscoder<?, ?>> factories;
    
    static {
        GET_KEY = new MultiClassKey();
    }
    
    public TranscoderRegistry() {
        this.factories = new HashMap<MultiClassKey, ResourceTranscoder<?, ?>>();
    }
    
    public <Z, R> ResourceTranscoder<Z, R> get(final Class<Z> obj, final Class<R> clazz) {
        ResourceTranscoder<?, ?> value;
        if (obj.equals(clazz)) {
            value = UnitTranscoder.get();
        }
        else {
            synchronized (TranscoderRegistry.GET_KEY) {
                TranscoderRegistry.GET_KEY.set(obj, clazz);
                final ResourceTranscoder<?, ?> resourceTranscoder = this.factories.get(TranscoderRegistry.GET_KEY);
                // monitorexit(TranscoderRegistry.GET_KEY)
                value = resourceTranscoder;
                if (resourceTranscoder == null) {
                    throw new IllegalArgumentException("No transcoder registered for " + obj + " and " + clazz);
                }
            }
        }
        return (ResourceTranscoder<Z, R>)value;
    }
    
    public <Z, R> void register(final Class<Z> clazz, final Class<R> clazz2, final ResourceTranscoder<Z, R> resourceTranscoder) {
        this.factories.put(new MultiClassKey(clazz, clazz2), resourceTranscoder);
    }
}
