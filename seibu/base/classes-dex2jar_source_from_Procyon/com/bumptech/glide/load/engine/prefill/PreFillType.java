// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap$Config;

public final class PreFillType
{
    static final Bitmap$Config DEFAULT_CONFIG;
    private final Bitmap$Config config;
    private final int height;
    private final int weight;
    private final int width;
    
    static {
        DEFAULT_CONFIG = Bitmap$Config.RGB_565;
    }
    
    PreFillType(final int width, final int height, final Bitmap$Config config, final int weight) {
        if (config == null) {
            throw new NullPointerException("Config must not be null");
        }
        this.width = width;
        this.height = height;
        this.config = config;
        this.weight = weight;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof PreFillType) {
            final PreFillType preFillType = (PreFillType)o;
            b2 = b;
            if (this.height == preFillType.height) {
                b2 = b;
                if (this.width == preFillType.width) {
                    b2 = b;
                    if (this.weight == preFillType.weight) {
                        b2 = b;
                        if (this.config == preFillType.config) {
                            b2 = true;
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    Bitmap$Config getConfig() {
        return this.config;
    }
    
    int getHeight() {
        return this.height;
    }
    
    int getWeight() {
        return this.weight;
    }
    
    int getWidth() {
        return this.width;
    }
    
    @Override
    public int hashCode() {
        return ((this.width * 31 + this.height) * 31 + this.config.hashCode()) * 31 + this.weight;
    }
    
    @Override
    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + '}';
    }
    
    public static class Builder
    {
        private Bitmap$Config config;
        private final int height;
        private int weight;
        private final int width;
        
        public Builder(final int n) {
            this(n, n);
        }
        
        public Builder(final int width, final int height) {
            this.weight = 1;
            if (width <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (height <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.width = width;
            this.height = height;
        }
        
        PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }
        
        Bitmap$Config getConfig() {
            return this.config;
        }
        
        public Builder setConfig(final Bitmap$Config config) {
            this.config = config;
            return this;
        }
        
        public Builder setWeight(final int weight) {
            if (weight <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.weight = weight;
            return this;
        }
    }
}
