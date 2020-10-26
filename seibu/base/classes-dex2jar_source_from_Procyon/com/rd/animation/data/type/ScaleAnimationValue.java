// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class ScaleAnimationValue extends ColorAnimationValue implements Value
{
    private int radius;
    private int radiusReverse;
    
    public int getRadius() {
        return this.radius;
    }
    
    public int getRadiusReverse() {
        return this.radiusReverse;
    }
    
    public void setRadius(final int radius) {
        this.radius = radius;
    }
    
    public void setRadiusReverse(final int radiusReverse) {
        this.radiusReverse = radiusReverse;
    }
}
