// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class ColorAnimationValue implements Value
{
    private int color;
    private int colorReverse;
    
    public int getColor() {
        return this.color;
    }
    
    public int getColorReverse() {
        return this.colorReverse;
    }
    
    public void setColor(final int color) {
        this.color = color;
    }
    
    public void setColorReverse(final int colorReverse) {
        this.colorReverse = colorReverse;
    }
}
