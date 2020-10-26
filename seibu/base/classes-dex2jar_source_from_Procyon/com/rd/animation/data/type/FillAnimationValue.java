// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class FillAnimationValue extends ColorAnimationValue implements Value
{
    private int radius;
    private int radiusReverse;
    private int stroke;
    private int strokeReverse;
    
    public int getRadius() {
        return this.radius;
    }
    
    public int getRadiusReverse() {
        return this.radiusReverse;
    }
    
    public int getStroke() {
        return this.stroke;
    }
    
    public int getStrokeReverse() {
        return this.strokeReverse;
    }
    
    public void setRadius(final int radius) {
        this.radius = radius;
    }
    
    public void setRadiusReverse(final int radiusReverse) {
        this.radiusReverse = radiusReverse;
    }
    
    public void setStroke(final int stroke) {
        this.stroke = stroke;
    }
    
    public void setStrokeReverse(final int strokeReverse) {
        this.strokeReverse = strokeReverse;
    }
}
