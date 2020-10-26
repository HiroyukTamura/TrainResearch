// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.cache;

import java.io.File;
import android.content.Context;

public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory
{
    public ExternalCacheDiskCacheFactory(final Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }
    
    public ExternalCacheDiskCacheFactory(final Context context, final int n) {
        this(context, "image_manager_disk_cache", n);
    }
    
    public ExternalCacheDiskCacheFactory(final Context context, final String s, final int n) {
        super((CacheDirectoryGetter)new CacheDirectoryGetter() {
            @Override
            public File getCacheDirectory() {
                final File externalCacheDir = context.getExternalCacheDir();
                File file;
                if (externalCacheDir == null) {
                    file = null;
                }
                else {
                    file = externalCacheDir;
                    if (s != null) {
                        return new File(externalCacheDir, s);
                    }
                }
                return file;
            }
        }, n);
    }
}
