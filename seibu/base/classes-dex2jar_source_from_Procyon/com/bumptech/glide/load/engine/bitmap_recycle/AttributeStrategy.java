// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;

class AttributeStrategy implements LruPoolStrategy
{
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    
    AttributeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap<Key, Bitmap>();
    }
    
    private static String getBitmapString(final int i, final int j, final Bitmap$Config obj) {
        return "[" + i + "x" + j + "], " + obj;
    }
    
    private static String getBitmapString(final Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }
    
    @Override
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return this.groupedMap.get(this.keyPool.get(n, n2, bitmap$Config));
    }
    
    @Override
    public int getSize(final Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }
    
    @Override
    public String logBitmap(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return getBitmapString(n, n2, bitmap$Config);
    }
    
    @Override
    public String logBitmap(final Bitmap bitmap) {
        return getBitmapString(bitmap);
    }
    
    @Override
    public void put(final Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }
    
    @Override
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }
    
    @Override
    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }
    
    static class Key implements Poolable
    {
        private Bitmap$Config config;
        private int height;
        private final KeyPool pool;
        private int width;
        
        public Key(final KeyPool pool) {
            this.pool = pool;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof Key) {
                final Key key = (Key)o;
                b2 = b;
                if (this.width == key.width) {
                    b2 = b;
                    if (this.height == key.height) {
                        b2 = b;
                        if (this.config == key.config) {
                            b2 = true;
                        }
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            final int width = this.width;
            final int height = this.height;
            int hashCode;
            if (this.config != null) {
                hashCode = this.config.hashCode();
            }
            else {
                hashCode = 0;
            }
            return (width * 31 + height) * 31 + hashCode;
        }
        
        public void init(final int width, final int height, final Bitmap$Config config) {
            this.width = width;
            this.height = height;
            this.config = config;
        }
        
        @Override
        public void offer() {
            this.pool.offer(this);
        }
        
        @Override
        public String toString() {
            return getBitmapString(this.width, this.height, this.config);
        }
    }
    
    static class KeyPool extends BaseKeyPool<Key>
    {
        @Override
        protected Key create() {
            return new Key(this);
        }
        
        public Key get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
            final Key key = this.get();
            key.init(n, n2, bitmap$Config);
            return key;
        }
    }
}
