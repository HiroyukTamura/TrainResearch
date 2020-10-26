// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.cache;

import java.io.File;
import android.content.Context;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory
{
    public InternalCacheDiskCacheFactory(final Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }
    
    public InternalCacheDiskCacheFactory(final Context context, final int n) {
        this(context, "image_manager_disk_cache", n);
    }
    
    public InternalCacheDiskCacheFactory(final Context context, final String s, final int n) {
        super((CacheDirectoryGetter)new CacheDirectoryGetter() {
            @Override
            public File getCacheDirectory() {
                final File cacheDir = context.getCacheDir();
                File file;
                if (cacheDir == null) {
                    file = null;
                }
                else {
                    file = cacheDir;
                    if (s != null) {
                        return new File(cacheDir, s);
                    }
                }
                return file;
            }
        }, n);
    }
}
