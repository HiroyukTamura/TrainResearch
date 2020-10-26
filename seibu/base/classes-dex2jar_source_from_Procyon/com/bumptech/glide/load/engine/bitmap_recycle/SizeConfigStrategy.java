// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Iterator;
import com.bumptech.glide.util.Util;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Map;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.annotation.TargetApi;

@TargetApi(19)
public class SizeConfigStrategy implements LruPoolStrategy
{
    private static final Bitmap$Config[] ALPHA_8_IN_CONFIGS;
    private static final Bitmap$Config[] ARGB_4444_IN_CONFIGS;
    private static final Bitmap$Config[] ARGB_8888_IN_CONFIGS;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap$Config[] RGB_565_IN_CONFIGS;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    private final Map<Bitmap$Config, NavigableMap<Integer, Integer>> sortedSizes;
    
    static {
        ARGB_8888_IN_CONFIGS = new Bitmap$Config[] { Bitmap$Config.ARGB_8888, null };
        RGB_565_IN_CONFIGS = new Bitmap$Config[] { Bitmap$Config.RGB_565 };
        ARGB_4444_IN_CONFIGS = new Bitmap$Config[] { Bitmap$Config.ARGB_4444 };
        ALPHA_8_IN_CONFIGS = new Bitmap$Config[] { Bitmap$Config.ALPHA_8 };
    }
    
    public SizeConfigStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap<Key, Bitmap>();
        this.sortedSizes = new HashMap<Bitmap$Config, NavigableMap<Integer, Integer>>();
    }
    
    private void decrementBitmapOfSize(final Integer n, final Bitmap$Config bitmap$Config) {
        final NavigableMap<Integer, Integer> sizesForConfig = this.getSizesForConfig(bitmap$Config);
        final Integer n2 = sizesForConfig.get(n);
        if (n2 == 1) {
            sizesForConfig.remove(n);
            return;
        }
        sizesForConfig.put(n, n2 - 1);
    }
    
    private Key findBestKey(final Key key, final int i, final Bitmap$Config bitmap$Config) {
        final Bitmap$Config[] inConfigs = getInConfigs(bitmap$Config);
        final int length = inConfigs.length;
        int n = 0;
        Poolable value;
        while (true) {
            Bitmap$Config bitmap$Config2 = null;
            Label_0121: {
                while (true) {
                    value = key;
                    if (n >= length) {
                        break;
                    }
                    bitmap$Config2 = inConfigs[n];
                    final Integer n2 = this.getSizesForConfig(bitmap$Config2).ceilingKey(i);
                    if (n2 != null && n2 <= i * 8) {
                        if (n2 == i) {
                            if (bitmap$Config2 != null) {
                                break Label_0121;
                            }
                            value = key;
                            if (bitmap$Config == null) {
                                break;
                            }
                        }
                        this.keyPool.offer(key);
                        value = this.keyPool.get(n2, bitmap$Config2);
                        break;
                    }
                    ++n;
                }
                return (Key)value;
            }
            value = key;
            if (!bitmap$Config2.equals((Object)bitmap$Config)) {
                continue;
            }
            break;
        }
        return (Key)value;
    }
    
    private static String getBitmapString(final int i, final Bitmap$Config obj) {
        return "[" + i + "](" + obj + ")";
    }
    
    private static Bitmap$Config[] getInConfigs(final Bitmap$Config bitmap$Config) {
        switch (bitmap$Config) {
            default: {
                return new Bitmap$Config[] { bitmap$Config };
            }
            case ARGB_8888: {
                return SizeConfigStrategy.ARGB_8888_IN_CONFIGS;
            }
            case RGB_565: {
                return SizeConfigStrategy.RGB_565_IN_CONFIGS;
            }
            case ARGB_4444: {
                return SizeConfigStrategy.ARGB_4444_IN_CONFIGS;
            }
            case ALPHA_8: {
                return SizeConfigStrategy.ALPHA_8_IN_CONFIGS;
            }
        }
    }
    
    private NavigableMap<Integer, Integer> getSizesForConfig(final Bitmap$Config bitmap$Config) {
        NavigableMap<Integer, Integer> navigableMap;
        if ((navigableMap = this.sortedSizes.get(bitmap$Config)) == null) {
            navigableMap = new TreeMap<Integer, Integer>();
            this.sortedSizes.put(bitmap$Config, navigableMap);
        }
        return navigableMap;
    }
    
    @Override
    public Bitmap get(final int n, final int n2, Bitmap$Config bitmap$Config) {
        final int bitmapByteSize = Util.getBitmapByteSize(n, n2, bitmap$Config);
        final Bitmap bitmap = this.groupedMap.get(this.findBestKey(this.keyPool.get(bitmapByteSize, bitmap$Config), bitmapByteSize, bitmap$Config));
        if (bitmap != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
            if (bitmap.getConfig() != null) {
                bitmap$Config = bitmap.getConfig();
            }
            else {
                bitmap$Config = Bitmap$Config.ARGB_8888;
            }
            bitmap.reconfigure(n, n2, bitmap$Config);
        }
        return bitmap;
    }
    
    @Override
    public int getSize(final Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }
    
    @Override
    public String logBitmap(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return getBitmapString(Util.getBitmapByteSize(n, n2, bitmap$Config), bitmap$Config);
    }
    
    @Override
    public String logBitmap(final Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }
    
    @Override
    public void put(final Bitmap bitmap) {
        final Key value = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(value, bitmap);
        final NavigableMap<Integer, Integer> sizesForConfig = this.getSizesForConfig(bitmap.getConfig());
        final Integer n = sizesForConfig.get(value.size);
        final int access$000 = value.size;
        int i;
        if (n == null) {
            i = 1;
        }
        else {
            i = n + 1;
        }
        sizesForConfig.put(access$000, i);
    }
    
    @Override
    public Bitmap removeLast() {
        final Bitmap bitmap = this.groupedMap.removeLast();
        if (bitmap != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        }
        return bitmap;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.groupedMap).append(", sortedSizes=(");
        for (final Map.Entry<Bitmap$Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        return append.append(")}").toString();
    }
    
    static final class Key implements Poolable
    {
        private Bitmap$Config config;
        private final KeyPool pool;
        private int size;
        
        public Key(final KeyPool pool) {
            this.pool = pool;
        }
        
        Key(final KeyPool keyPool, final int n, final Bitmap$Config bitmap$Config) {
            this(keyPool);
            this.init(n, bitmap$Config);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof Key) {
                final Key key = (Key)o;
                b2 = b;
                if (this.size == key.size) {
                    if (this.config == null) {
                        b2 = b;
                        if (key.config != null) {
                            return b2;
                        }
                    }
                    else {
                        b2 = b;
                        if (!this.config.equals((Object)key.config)) {
                            return b2;
                        }
                    }
                    b2 = true;
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            final int size = this.size;
            int hashCode;
            if (this.config != null) {
                hashCode = this.config.hashCode();
            }
            else {
                hashCode = 0;
            }
            return size * 31 + hashCode;
        }
        
        public void init(final int size, final Bitmap$Config config) {
            this.size = size;
            this.config = config;
        }
        
        @Override
        public void offer() {
            this.pool.offer(this);
        }
        
        @Override
        public String toString() {
            return getBitmapString(this.size, this.config);
        }
    }
    
    static class KeyPool extends BaseKeyPool<Key>
    {
        @Override
        protected Key create() {
            return new Key(this);
        }
        
        public Key get(final int n, final Bitmap$Config bitmap$Config) {
            final Key key = this.get();
            key.init(n, bitmap$Config);
            return key;
        }
    }
}
