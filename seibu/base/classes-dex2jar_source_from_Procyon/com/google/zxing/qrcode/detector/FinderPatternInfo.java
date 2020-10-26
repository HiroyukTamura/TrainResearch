// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.detector;

public final class FinderPatternInfo
{
    private final FinderPattern bottomLeft;
    private final FinderPattern topLeft;
    private final FinderPattern topRight;
    
    public FinderPatternInfo(final FinderPattern[] array) {
        this.bottomLeft = array[0];
        this.topLeft = array[1];
        this.topRight = array[2];
    }
    
    public FinderPattern getBottomLeft() {
        return this.bottomLeft;
    }
    
    public FinderPattern getTopLeft() {
        return this.topLeft;
    }
    
    public FinderPattern getTopRight() {
        return this.topRight;
    }
}
