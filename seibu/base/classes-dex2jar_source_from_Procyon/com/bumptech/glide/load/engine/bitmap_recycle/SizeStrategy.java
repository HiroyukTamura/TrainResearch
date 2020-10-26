// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap$Config;
import com.bumptech.glide.util.Util;
import java.util.TreeMap;
import android.graphics.Bitmap;
import android.annotation.TargetApi;

@TargetApi(19)
class SizeStrategy implements LruPoolStrategy
{
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    private final TreeMap<Integer, Integer> sortedSizes;
    
    SizeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap<Key, Bitmap>();
        this.sortedSizes = new PrettyPrintTreeMap<Integer, Integer>();
    }
    
    private void decrementBitmapOfSize(final Integer key) {
        final Integer n = this.sortedSizes.get(key);
        if (n == 1) {
            this.sortedSizes.remove(key);
            return;
        }
        this.sortedSizes.put(key, n - 1);
    }
    
    private static String getBitmapString(final int i) {
        return "[" + i + "]";
    }
    
    private static String getBitmapString(final Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap));
    }
    
    @Override
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        final int bitmapByteSize = Util.getBitmapByteSize(n, n2, bitmap$Config);
        final Key value = this.keyPool.get(bitmapByteSize);
        final Integer n3 = this.sortedSizes.ceilingKey(bitmapByteSize);
        Poolable value2 = value;
        if (n3 != null) {
            value2 = value;
            if (n3 != bitmapByteSize) {
                value2 = value;
                if (n3 <= bitmapByteSize * 8) {
                    this.keyPool.offer(value);
                    value2 = this.keyPool.get(n3);
                }
            }
        }
        final Bitmap bitmap = this.groupedMap.get((Key)value2);
        if (bitmap != null) {
            bitmap.reconfigure(n, n2, bitmap$Config);
            this.decrementBitmapOfSize(n3);
        }
        return bitmap;
    }
    
    @Override
    public int getSize(final Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }
    
    @Override
    public String logBitmap(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return getBitmapString(Util.getBitmapByteSize(n, n2, bitmap$Config));
    }
    
    @Override
    public String logBitmap(final Bitmap bitmap) {
        return getBitmapString(bitmap);
    }
    
    @Override
    public void put(final Bitmap bitmap) {
        final Key value = this.keyPool.get(Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(value, bitmap);
        final Integer n = this.sortedSizes.get(value.size);
        final TreeMap<Integer, Integer> sortedSizes = this.sortedSizes;
        final int access$000 = value.size;
        int i;
        if (n == null) {
            i = 1;
        }
        else {
            i = n + 1;
        }
        sortedSizes.put(access$000, i);
    }
    
    @Override
    public Bitmap removeLast() {
        final Bitmap bitmap = this.groupedMap.removeLast();
        if (bitmap != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap));
        }
        return bitmap;
    }
    
    @Override
    public String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n" + "  SortedSizes" + this.sortedSizes;
    }
    
    static final class Key implements Poolable
    {
        private final KeyPool pool;
        private int size;
        
        Key(final KeyPool pool) {
            this.pool = pool;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = false;
            if (o instanceof Key) {
                final Key key = (Key)o;
                b = b;
                if (this.size == key.size) {
                    b = true;
                }
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            return this.size;
        }
        
        public void init(final int size) {
            this.size = size;
        }
        
        @Override
        public void offer() {
            this.pool.offer(this);
        }
        
        @Override
        public String toString() {
            return getBitmapString(this.size);
        }
    }
    
    static class KeyPool extends BaseKeyPool<Key>
    {
        @Override
        protected Key create() {
            return new Key(this);
        }
        
        public Key get(final int n) {
            final Key key = this.get();
            key.init(n);
            return key;
        }
    }
}
