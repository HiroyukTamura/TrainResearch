// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.IOException;
import android.util.Log;
import android.content.res.AssetManager;

public abstract class AssetPathFetcher<T> implements DataFetcher<T>
{
    private static final String TAG = "AssetUriFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;
    
    public AssetPathFetcher(final AssetManager assetManager, final String assetPath) {
        this.assetManager = assetManager;
        this.assetPath = assetPath;
    }
    
    @Override
    public void cancel() {
    }
    
    @Override
    public void cleanup() {
        if (this.data != null) {
            try {
                this.close(this.data);
            }
            catch (IOException ex) {
                if (Log.isLoggable("AssetUriFetcher", 2)) {
                    Log.v("AssetUriFetcher", "Failed to close data", (Throwable)ex);
                }
            }
        }
    }
    
    protected abstract void close(final T p0) throws IOException;
    
    @Override
    public String getId() {
        return this.assetPath;
    }
    
    @Override
    public T loadData(final Priority priority) throws Exception {
        return this.data = this.loadResource(this.assetManager, this.assetPath);
    }
    
    protected abstract T loadResource(final AssetManager p0, final String p1) throws IOException;
}
