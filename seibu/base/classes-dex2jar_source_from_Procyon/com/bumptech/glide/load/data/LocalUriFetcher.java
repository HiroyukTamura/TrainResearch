// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import java.io.FileNotFoundException;
import android.content.ContentResolver;
import com.bumptech.glide.Priority;
import java.io.IOException;
import android.util.Log;
import android.net.Uri;
import android.content.Context;

public abstract class LocalUriFetcher<T> implements DataFetcher<T>
{
    private static final String TAG = "LocalUriFetcher";
    private final Context context;
    private T data;
    private final Uri uri;
    
    public LocalUriFetcher(final Context context, final Uri uri) {
        this.context = context.getApplicationContext();
        this.uri = uri;
    }
    
    @Override
    public void cancel() {
    }
    
    @Override
    public void cleanup() {
        if (this.data == null) {
            return;
        }
        try {
            this.close(this.data);
        }
        catch (IOException ex) {
            if (Log.isLoggable("LocalUriFetcher", 2)) {
                Log.v("LocalUriFetcher", "failed to close data", (Throwable)ex);
            }
        }
    }
    
    protected abstract void close(final T p0) throws IOException;
    
    @Override
    public String getId() {
        return this.uri.toString();
    }
    
    @Override
    public final T loadData(final Priority priority) throws Exception {
        return this.data = this.loadResource(this.uri, this.context.getContentResolver());
    }
    
    protected abstract T loadResource(final Uri p0, final ContentResolver p1) throws FileNotFoundException;
}
