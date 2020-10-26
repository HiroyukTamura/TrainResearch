// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class WormAnimationValue implements Value
{
    private int rectEnd;
    private int rectStart;
    
    public int getRectEnd() {
        return this.rectEnd;
    }
    
    public int getRectStart() {
        return this.rectStart;
    }
    
    public void setRectEnd(final int rectEnd) {
        this.rectEnd = rectEnd;
    }
    
    public void setRectStart(final int rectStart) {
        this.rectStart = rectStart;
    }
}
