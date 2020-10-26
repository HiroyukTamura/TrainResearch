// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

public class ResultPoint
{
    private final float x;
    private final float y;
    
    public ResultPoint(final float x, final float y) {
        this.x = x;
        this.y = y;
    }
    
    private static float crossProductZ(final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3) {
        final float x = resultPoint2.x;
        final float y = resultPoint2.y;
        return (resultPoint3.x - x) * (resultPoint.y - y) - (resultPoint3.y - y) * (resultPoint.x - x);
    }
    
    public static float distance(final ResultPoint resultPoint, final ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.x, resultPoint.y, resultPoint2.x, resultPoint2.y);
    }
    
    public static void orderBestPatterns(final ResultPoint[] array) {
        final float distance = distance(array[0], array[1]);
        final float distance2 = distance(array[1], array[2]);
        final float distance3 = distance(array[0], array[2]);
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint = array[0];
            resultPoint2 = array[1];
            resultPoint3 = array[2];
        }
        else if (distance3 >= distance2 && distance3 >= distance) {
            resultPoint = array[1];
            resultPoint2 = array[0];
            resultPoint3 = array[2];
        }
        else {
            resultPoint = array[2];
            resultPoint2 = array[0];
            resultPoint3 = array[1];
        }
        ResultPoint resultPoint4 = resultPoint2;
        ResultPoint resultPoint5 = resultPoint3;
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            resultPoint5 = resultPoint2;
            resultPoint4 = resultPoint3;
        }
        array[0] = resultPoint4;
        array[1] = resultPoint;
        array[2] = resultPoint5;
    }
    
    @Override
    public final boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof ResultPoint) {
            final ResultPoint resultPoint = (ResultPoint)o;
            b2 = b;
            if (this.x == resultPoint.x) {
                b2 = b;
                if (this.y == resultPoint.y) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public final float getX() {
        return this.x;
    }
    
    public final float getY() {
        return this.y;
    }
    
    @Override
    public final int hashCode() {
        return Float.floatToIntBits(this.x) * 31 + Float.floatToIntBits(this.y);
    }
    
    @Override
    public final String toString() {
        return "(" + this.x + ',' + this.y + ')';
    }
}
