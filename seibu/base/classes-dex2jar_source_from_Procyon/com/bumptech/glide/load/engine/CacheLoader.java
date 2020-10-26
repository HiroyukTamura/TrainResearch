// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine;

import java.io.IOException;
import android.util.Log;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;

class CacheLoader
{
    private static final String TAG = "CacheLoader";
    private final DiskCache diskCache;
    
    public CacheLoader(final DiskCache diskCache) {
        this.diskCache = diskCache;
    }
    
    public <Z> Resource<Z> load(final Key key, final ResourceDecoder<File, Z> resourceDecoder, final int n, final int n2) {
        final File value = this.diskCache.get(key);
        Resource<Z> resource;
        if (value == null) {
            resource = null;
        }
        else {
            resource = null;
            while (true) {
                try {
                    final Resource<Z> decode = resourceDecoder.decode(value, n, n2);
                    if ((resource = decode) == null) {
                        if (Log.isLoggable("CacheLoader", 3)) {
                            Log.d("CacheLoader", "Failed to decode image from cache or not present in cache");
                        }
                        this.diskCache.delete(key);
                        return decode;
                    }
                }
                catch (IOException ex) {
                    Resource<Z> decode = resource;
                    if (Log.isLoggable("CacheLoader", 3)) {
                        Log.d("CacheLoader", "Exception decoding image from cache", (Throwable)ex);
                        decode = resource;
                    }
                    continue;
                }
                break;
            }
        }
        return resource;
    }
}
