// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class DropAnimationValue implements Value
{
    private int height;
    private int radius;
    private int width;
    
    public int getHeight() {
        return this.height;
    }
    
    public int getRadius() {
        return this.radius;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setRadius(final int radius) {
        this.radius = radius;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
