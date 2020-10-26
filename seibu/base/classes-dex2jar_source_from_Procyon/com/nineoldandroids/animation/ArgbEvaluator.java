// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

public class ArgbEvaluator implements TypeEvaluator
{
    @Override
    public Object evaluate(final float n, final Object o, final Object o2) {
        final int intValue = (int)o;
        final int n2 = intValue >> 24;
        final int n3 = intValue >> 16 & 0xFF;
        final int n4 = intValue >> 8 & 0xFF;
        final int n5 = intValue & 0xFF;
        final int intValue2 = (int)o2;
        return (int)(((intValue2 >> 24) - n2) * n) + n2 << 24 | (int)(((intValue2 >> 16 & 0xFF) - n3) * n) + n3 << 16 | (int)(((intValue2 >> 8 & 0xFF) - n4) * n) + n4 << 8 | (int)(((intValue2 & 0xFF) - n5) * n) + n5;
    }
}
