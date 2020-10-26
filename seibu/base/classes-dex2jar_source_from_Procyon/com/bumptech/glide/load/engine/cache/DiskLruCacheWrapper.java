// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import android.util.Log;
import java.io.IOException;
import com.bumptech.glide.disklrucache.DiskLruCache;
import java.io.File;

public class DiskLruCacheWrapper implements DiskCache
{
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final int maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker;
    
    static {
        DiskLruCacheWrapper.wrapper = null;
    }
    
    protected DiskLruCacheWrapper(final File directory, final int maxSize) {
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = directory;
        this.maxSize = maxSize;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }
    
    public static DiskCache get(final File file, final int n) {
        synchronized (DiskLruCacheWrapper.class) {
            if (DiskLruCacheWrapper.wrapper == null) {
                DiskLruCacheWrapper.wrapper = new DiskLruCacheWrapper(file, n);
            }
            return DiskLruCacheWrapper.wrapper;
        }
    }
    
    private DiskLruCache getDiskCache() throws IOException {
        synchronized (this) {
            if (this.diskLruCache == null) {
                this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
            }
            return this.diskLruCache;
        }
    }
    
    private void resetDiskCache() {
        synchronized (this) {
            this.diskLruCache = null;
        }
    }
    
    @Override
    public void clear() {
        synchronized (this) {
            try {
                this.getDiskCache().delete();
                this.resetDiskCache();
            }
            catch (IOException ex) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache", (Throwable)ex);
                }
            }
        }
    }
    
    @Override
    public void delete(final Key key) {
        final String safeKey = this.safeKeyGenerator.getSafeKey(key);
        try {
            this.getDiskCache().remove(safeKey);
        }
        catch (IOException ex) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", (Throwable)ex);
            }
        }
    }
    
    @Override
    public File get(final Key key) {
        final String safeKey = this.safeKeyGenerator.getSafeKey(key);
        final File file = null;
        try {
            final DiskLruCache.Value value = this.getDiskCache().get(safeKey);
            File file2 = file;
            if (value != null) {
                file2 = value.getFile(0);
            }
            return file2;
        }
        catch (IOException ex) {
            final File file2 = file;
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", (Throwable)ex);
                return null;
            }
            return file2;
        }
    }
    
    @Override
    public void put(final Key key, final Writer writer) {
        final String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(key);
        try {
            final DiskLruCache.Editor edit = this.getDiskCache().edit(safeKey);
            if (edit == null) {
                return;
            }
            try {
                if (writer.write(edit.getFile(0))) {
                    edit.commit();
                }
            }
            finally {
                edit.abortUnlessCommitted();
            }
        }
        catch (IOException ex) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", (Throwable)ex);
                }
            }
            finally {
                this.writeLocker.release(key);
            }
        }
    }
}
