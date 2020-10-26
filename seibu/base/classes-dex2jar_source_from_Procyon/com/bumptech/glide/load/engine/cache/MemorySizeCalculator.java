// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.cache;

import android.util.DisplayMetrics;
import android.text.format.Formatter;
import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.util.Log;
import android.app.ActivityManager;
import android.content.Context;

public class MemorySizeCalculator
{
    static final int BITMAP_POOL_TARGET_SCREENS = 4;
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;
    
    public MemorySizeCalculator(final Context context) {
        this(context, (ActivityManager)context.getSystemService("activity"), (ScreenDimensions)new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }
    
    MemorySizeCalculator(final Context context, final ActivityManager activityManager, final ScreenDimensions screenDimensions) {
        this.context = context;
        final int maxSize = getMaxSize(activityManager);
        final int n = screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels() * 4;
        final int bitmapPoolSize = n * 4;
        final int memoryCacheSize = n * 2;
        if (memoryCacheSize + bitmapPoolSize <= maxSize) {
            this.memoryCacheSize = memoryCacheSize;
            this.bitmapPoolSize = bitmapPoolSize;
        }
        else {
            final int round = Math.round(maxSize / 6.0f);
            this.memoryCacheSize = round * 2;
            this.bitmapPoolSize = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + this.toMb(this.memoryCacheSize) + " pool size: " + this.toMb(this.bitmapPoolSize) + " memory class limited? " + (memoryCacheSize + bitmapPoolSize > maxSize) + " max size: " + this.toMb(maxSize) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + isLowMemoryDevice(activityManager));
        }
    }
    
    private static int getMaxSize(final ActivityManager activityManager) {
        final int memoryClass = activityManager.getMemoryClass();
        final boolean lowMemoryDevice = isLowMemoryDevice(activityManager);
        final float n = (float)(memoryClass * 1024 * 1024);
        float n2;
        if (lowMemoryDevice) {
            n2 = 0.33f;
        }
        else {
            n2 = 0.4f;
        }
        return Math.round(n2 * n);
    }
    
    @TargetApi(19)
    private static boolean isLowMemoryDevice(final ActivityManager activityManager) {
        if (Build$VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return Build$VERSION.SDK_INT < 11;
    }
    
    private String toMb(final int n) {
        return Formatter.formatFileSize(this.context, (long)n);
    }
    
    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }
    
    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
    
    private static class DisplayMetricsScreenDimensions implements ScreenDimensions
    {
        private final DisplayMetrics displayMetrics;
        
        public DisplayMetricsScreenDimensions(final DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }
        
        @Override
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }
        
        @Override
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }
    
    interface ScreenDimensions
    {
        int getHeightPixels();
        
        int getWidthPixels();
    }
}
