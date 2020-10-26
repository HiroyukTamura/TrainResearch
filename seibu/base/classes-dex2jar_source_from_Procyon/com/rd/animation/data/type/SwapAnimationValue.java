// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class SwapAnimationValue implements Value
{
    private int coordinate;
    private int coordinateReverse;
    
    public int getCoordinate() {
        return this.coordinate;
    }
    
    public int getCoordinateReverse() {
        return this.coordinateReverse;
    }
    
    public void setCoordinate(final int coordinate) {
        this.coordinate = coordinate;
    }
    
    public void setCoordinateReverse(final int coordinateReverse) {
        this.coordinateReverse = coordinateReverse;
    }
}
