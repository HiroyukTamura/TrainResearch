// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
public final class MonochromeRectangleDetector
{
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;
    
    public MonochromeRectangleDetector(final BitMatrix image) {
        this.image = image;
    }
    
    private int[] blackWhiteRange(int n, final int n2, int n3, final int n4, final boolean b) {
        int n5 = (n3 + n4) / 2;
        int n7 = 0;
        Label_0127: {
            int n6 = 0;
        Label_0104_Outer:
            while (true) {
                n6 = n5;
                if ((n7 = n6) >= n3) {
                    Label_0066: {
                        if (b) {
                            if (!this.image.get(n6, n)) {
                                break Label_0066;
                            }
                        }
                        else if (!this.image.get(n, n6)) {
                            break Label_0066;
                        }
                        n5 = n6 - 1;
                        continue Label_0104_Outer;
                    }
                    int n8 = n6;
                    int n9;
                    while (true) {
                        n9 = n8 - 1;
                        if (n9 < n3) {
                            break;
                        }
                        if (b) {
                            n8 = n9;
                            if (this.image.get(n9, n)) {
                                break;
                            }
                            continue Label_0104_Outer;
                        }
                        else {
                            n8 = n9;
                            if (this.image.get(n, n9)) {
                                break;
                            }
                            continue Label_0104_Outer;
                        }
                    }
                    while (true) {
                        if (n9 < n3) {
                            break;
                        }
                        n5 = n9;
                        if (n6 - n9 > n2) {
                            break;
                        }
                        continue Label_0104_Outer;
                        continue;
                    }
                }
                break Label_0127;
            }
            n7 = n6;
        }
        final int n10 = n7 + 1;
        int n11 = n5;
        int n12 = 0;
        Label_0266: {
        Label_0244_Outer:
            while (true) {
                n3 = n11;
                if ((n12 = n3) < n4) {
                    Label_0206: {
                        if (b) {
                            if (!this.image.get(n3, n)) {
                                break Label_0206;
                            }
                        }
                        else if (!this.image.get(n, n3)) {
                            break Label_0206;
                        }
                        n11 = n3 + 1;
                        continue Label_0244_Outer;
                    }
                    int n13 = n3;
                    int n14;
                    while (true) {
                        n14 = n13 + 1;
                        if (n14 >= n4) {
                            break;
                        }
                        if (b) {
                            n13 = n14;
                            if (this.image.get(n14, n)) {
                                break;
                            }
                            continue Label_0244_Outer;
                        }
                        else {
                            n13 = n14;
                            if (this.image.get(n, n14)) {
                                break;
                            }
                            continue Label_0244_Outer;
                        }
                    }
                    while (true) {
                        if (n14 >= n4) {
                            break;
                        }
                        n11 = n14;
                        if (n14 - n3 > n2) {
                            break;
                        }
                        continue Label_0244_Outer;
                        continue;
                    }
                }
                break Label_0266;
            }
            n12 = n3;
        }
        n = n12 - 1;
        if (n > n10) {
            return new int[] { n10, n };
        }
        return null;
    }
    
    private ResultPoint findCornerFromCenter(int n, int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) throws NotFoundException {
        int[] array = null;
        int n10 = n5;
        int n11 = n;
        while (n10 < n8 && n10 >= n7 && n11 < n4 && n11 >= n3) {
            int[] array2;
            if (n2 == 0) {
                array2 = this.blackWhiteRange(n10, n9, n3, n4, true);
            }
            else {
                array2 = this.blackWhiteRange(n11, n9, n7, n8, false);
            }
            if (array2 == null) {
                if (array == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (n2 == 0) {
                    n2 = n10 - n6;
                    if (array[0] >= n) {
                        return new ResultPoint((float)array[1], (float)n2);
                    }
                    if (array[1] > n) {
                        if (n6 > 0) {
                            n = 0;
                        }
                        else {
                            n = 1;
                        }
                        return new ResultPoint((float)array[n], (float)n2);
                    }
                    return new ResultPoint((float)array[0], (float)n2);
                }
                else {
                    n = n11 - n2;
                    if (array[0] >= n5) {
                        return new ResultPoint((float)n, (float)array[1]);
                    }
                    if (array[1] > n5) {
                        final float n12 = (float)n;
                        if (n2 < 0) {
                            n = 0;
                        }
                        else {
                            n = 1;
                        }
                        return new ResultPoint(n12, (float)array[n]);
                    }
                    return new ResultPoint((float)n, (float)array[0]);
                }
            }
            else {
                n10 += n6;
                n11 += n2;
                array = array2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    public ResultPoint[] detect() throws NotFoundException {
        final int height = this.image.getHeight();
        final int width = this.image.getWidth();
        final int n = height / 2;
        final int n2 = width / 2;
        final int max = Math.max(1, height / 256);
        final int max2 = Math.max(1, width / 256);
        final int n3 = (int)this.findCornerFromCenter(n2, 0, 0, width, n, -max, 0, height, n2 / 2).getY() - 1;
        final ResultPoint cornerFromCenter = this.findCornerFromCenter(n2, -max2, 0, width, n, 0, n3, height, n / 2);
        final int n4 = (int)cornerFromCenter.getX() - 1;
        final ResultPoint cornerFromCenter2 = this.findCornerFromCenter(n2, max2, n4, width, n, 0, n3, height, n / 2);
        final int n5 = (int)cornerFromCenter2.getX() + 1;
        final ResultPoint cornerFromCenter3 = this.findCornerFromCenter(n2, 0, n4, n5, n, max, n3, height, n2 / 2);
        return new ResultPoint[] { this.findCornerFromCenter(n2, 0, n4, n5, n, -max, n3, (int)cornerFromCenter3.getY() + 1, n2 / 4), cornerFromCenter, cornerFromCenter2, cornerFromCenter3 };
    }
}
