// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.request.ResourceCallback;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.executor.Prioritized;

class EngineRunnable implements Runnable, Prioritized
{
    private static final String TAG = "EngineRunnable";
    private final DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage;
    
    public EngineRunnable(final EngineRunnableManager manager, final DecodeJob<?, ?, ?> decodeJob, final Priority priority) {
        this.manager = manager;
        this.decodeJob = decodeJob;
        this.stage = Stage.CACHE;
        this.priority = priority;
    }
    
    private Resource<?> decode() throws Exception {
        if (this.isDecodingFromCache()) {
            return this.decodeFromCache();
        }
        return this.decodeFromSource();
    }
    
    private Resource<?> decodeFromCache() throws Exception {
        Resource<?> decodeSourceFromCache = null;
        while (true) {
            try {
                final Resource<?> decodeResultFromCache = this.decodeJob.decodeResultFromCache();
                if ((decodeSourceFromCache = decodeResultFromCache) == null) {
                    decodeSourceFromCache = this.decodeJob.decodeSourceFromCache();
                }
                return decodeSourceFromCache;
            }
            catch (Exception obj) {
                Resource<?> decodeResultFromCache = decodeSourceFromCache;
                if (Log.isLoggable("EngineRunnable", 3)) {
                    Log.d("EngineRunnable", "Exception decoding result from cache: " + obj);
                    decodeResultFromCache = decodeSourceFromCache;
                }
                continue;
            }
            break;
        }
    }
    
    private Resource<?> decodeFromSource() throws Exception {
        return this.decodeJob.decodeFromSource();
    }
    
    private boolean isDecodingFromCache() {
        return this.stage == Stage.CACHE;
    }
    
    private void onLoadComplete(final Resource resource) {
        this.manager.onResourceReady(resource);
    }
    
    private void onLoadFailed(final Exception ex) {
        if (this.isDecodingFromCache()) {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
            return;
        }
        this.manager.onException(ex);
    }
    
    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }
    
    @Override
    public int getPriority() {
        return this.priority.ordinal();
    }
    
    @Override
    public void run() {
        if (!this.isCancelled) {
            final Exception ex = null;
            Resource<?> decode = null;
            while (true) {
                try {
                    decode = this.decode();
                    if (this.isCancelled) {
                        if (decode != null) {
                            decode.recycle();
                        }
                        return;
                    }
                }
                catch (Exception ex) {
                    if (Log.isLoggable("EngineRunnable", 2)) {
                        Log.v("EngineRunnable", "Exception decoding", (Throwable)ex);
                    }
                    continue;
                }
                break;
            }
            if (decode == null) {
                this.onLoadFailed(ex);
                return;
            }
            this.onLoadComplete(decode);
        }
    }
    
    interface EngineRunnableManager extends ResourceCallback
    {
        void submitForSource(final EngineRunnable p0);
    }
    
    private enum Stage
    {
        CACHE, 
        SOURCE;
    }
}
