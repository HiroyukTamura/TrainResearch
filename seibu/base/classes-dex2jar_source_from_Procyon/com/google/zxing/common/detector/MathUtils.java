// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common.detector;

public final class MathUtils
{
    private MathUtils() {
    }
    
    public static float distance(float n, float n2, final float n3, final float n4) {
        n -= n3;
        n2 -= n4;
        return (float)Math.sqrt(n * n + n2 * n2);
    }
    
    public static float distance(int n, int n2, final int n3, final int n4) {
        n -= n3;
        n2 -= n4;
        return (float)Math.sqrt(n * n + n2 * n2);
    }
    
    public static int round(final float n) {
        float n2;
        if (n < 0.0f) {
            n2 = -0.5f;
        }
        else {
            n2 = 0.5f;
        }
        return (int)(n2 + n);
    }
    
    public static int sum(final int[] array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i];
        }
        return n;
    }
}
