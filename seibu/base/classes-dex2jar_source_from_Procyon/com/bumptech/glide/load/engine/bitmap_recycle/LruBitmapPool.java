// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.Collections;
import android.os.Build$VERSION;
import java.util.Collection;
import java.util.Arrays;
import java.util.HashSet;
import android.util.Log;
import java.util.Set;
import android.graphics.Bitmap$Config;

public class LruBitmapPool implements BitmapPool
{
    private static final Bitmap$Config DEFAULT_CONFIG;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap$Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;
    
    static {
        DEFAULT_CONFIG = Bitmap$Config.ARGB_8888;
    }
    
    public LruBitmapPool(final int n) {
        this(n, getDefaultStrategy(), getDefaultAllowedConfigs());
    }
    
    LruBitmapPool(final int n, final LruPoolStrategy strategy, final Set<Bitmap$Config> allowedConfigs) {
        this.initialMaxSize = n;
        this.maxSize = n;
        this.strategy = strategy;
        this.allowedConfigs = allowedConfigs;
        this.tracker = (BitmapTracker)new NullBitmapTracker();
    }
    
    public LruBitmapPool(final int n, final Set<Bitmap$Config> set) {
        this(n, getDefaultStrategy(), set);
    }
    
    private void dump() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            this.dumpUnchecked();
        }
    }
    
    private void dumpUnchecked() {
        Log.v("LruBitmapPool", "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }
    
    private void evict() {
        this.trimToSize(this.maxSize);
    }
    
    private static Set<Bitmap$Config> getDefaultAllowedConfigs() {
        final HashSet<Bitmap$Config> s = new HashSet<Bitmap$Config>();
        s.addAll((Collection<?>)Arrays.asList(Bitmap$Config.values()));
        if (Build$VERSION.SDK_INT >= 19) {
            s.add(null);
        }
        return (Set<Bitmap$Config>)Collections.unmodifiableSet((Set<?>)s);
    }
    
    private static LruPoolStrategy getDefaultStrategy() {
        if (Build$VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new AttributeStrategy();
    }
    
    private void trimToSize(final int n) {
        synchronized (this) {
            while (this.currentSize > n) {
                final Bitmap removeLast = this.strategy.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        this.dumpUnchecked();
                    }
                    this.currentSize = 0;
                    break;
                }
                this.tracker.remove(removeLast);
                this.currentSize -= this.strategy.getSize(removeLast);
                removeLast.recycle();
                ++this.evictions;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.strategy.logBitmap(removeLast));
                }
                this.dump();
            }
        }
    }
    
    @Override
    public void clearMemory() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        this.trimToSize(0);
    }
    
    @Override
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        synchronized (this) {
            final Bitmap dirty = this.getDirty(n, n2, bitmap$Config);
            if (dirty != null) {
                dirty.eraseColor(0);
            }
            return dirty;
        }
    }
    
    @TargetApi(12)
    @Override
    public Bitmap getDirty(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        synchronized (this) {
            final LruPoolStrategy strategy = this.strategy;
            Bitmap$Config default_CONFIG;
            if (bitmap$Config != null) {
                default_CONFIG = bitmap$Config;
            }
            else {
                default_CONFIG = LruBitmapPool.DEFAULT_CONFIG;
            }
            final Bitmap value = strategy.get(n, n2, default_CONFIG);
            if (value == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.strategy.logBitmap(n, n2, bitmap$Config));
                }
                ++this.misses;
            }
            else {
                ++this.hits;
                this.currentSize -= this.strategy.getSize(value);
                this.tracker.remove(value);
                if (Build$VERSION.SDK_INT >= 12) {
                    value.setHasAlpha(true);
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.strategy.logBitmap(n, n2, bitmap$Config));
            }
            this.dump();
            return value;
        }
    }
    
    @Override
    public int getMaxSize() {
        return this.maxSize;
    }
    
    @Override
    public boolean put(final Bitmap bitmap) {
        // monitorenter(this)
        if (bitmap == null) {
            try {
                throw new NullPointerException("Bitmap must not be null");
            }
            finally {
            }
            // monitorexit(this)
        }
        boolean b;
        if (!bitmap.isMutable() || this.strategy.getSize(bitmap) > this.maxSize || !this.allowedConfigs.contains(bitmap.getConfig())) {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap.getConfig()));
            }
            b = false;
        }
        else {
            final int size = this.strategy.getSize(bitmap);
            this.strategy.put(bitmap);
            this.tracker.add(bitmap);
            ++this.puts;
            this.currentSize += size;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.strategy.logBitmap(bitmap));
            }
            this.dump();
            this.evict();
            b = true;
        }
        // monitorexit(this)
        return b;
    }
    
    @Override
    public void setSizeMultiplier(final float n) {
        synchronized (this) {
            this.maxSize = Math.round(this.initialMaxSize * n);
            this.evict();
        }
    }
    
    @SuppressLint({ "InlinedApi" })
    @Override
    public void trimMemory(final int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            this.clearMemory();
        }
        else if (i >= 40) {
            this.trimToSize(this.maxSize / 2);
        }
    }
    
    private interface BitmapTracker
    {
        void add(final Bitmap p0);
        
        void remove(final Bitmap p0);
    }
    
    private static class NullBitmapTracker implements BitmapTracker
    {
        @Override
        public void add(final Bitmap bitmap) {
        }
        
        @Override
        public void remove(final Bitmap bitmap) {
        }
    }
    
    private static class ThrowingBitmapTracker implements BitmapTracker
    {
        private final Set<Bitmap> bitmaps;
        
        private ThrowingBitmapTracker() {
            this.bitmaps = Collections.synchronizedSet(new HashSet<Bitmap>());
        }
        
        @Override
        public void add(final Bitmap obj) {
            if (this.bitmaps.contains(obj)) {
                throw new IllegalStateException("Can't add already added bitmap: " + obj + " [" + obj.getWidth() + "x" + obj.getHeight() + "]");
            }
            this.bitmaps.add(obj);
        }
        
        @Override
        public void remove(final Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.bitmaps.remove(bitmap);
        }
    }
}
