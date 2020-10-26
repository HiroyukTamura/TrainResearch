// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common.detector;

import com.google.zxing.ResultPoint;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector
{
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;
    
    public WhiteRectangleDetector(final BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }
    
    public WhiteRectangleDetector(final BitMatrix image, int n, final int n2, final int n3) throws NotFoundException {
        this.image = image;
        this.height = image.getHeight();
        this.width = image.getWidth();
        n /= 2;
        this.leftInit = n2 - n;
        this.rightInit = n2 + n;
        this.upInit = n3 - n;
        this.downInit = n3 + n;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
    
    private ResultPoint[] centerEdges(final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4) {
        final float x = resultPoint.getX();
        final float y = resultPoint.getY();
        final float x2 = resultPoint2.getX();
        final float y2 = resultPoint2.getY();
        final float x3 = resultPoint3.getX();
        final float y3 = resultPoint3.getY();
        final float x4 = resultPoint4.getX();
        final float y4 = resultPoint4.getY();
        if (x < this.width / 2.0f) {
            return new ResultPoint[] { new ResultPoint(x4 - 1.0f, 1.0f + y4), new ResultPoint(1.0f + x2, 1.0f + y2), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(1.0f + x, y - 1.0f) };
        }
        return new ResultPoint[] { new ResultPoint(1.0f + x4, 1.0f + y4), new ResultPoint(1.0f + x2, y2 - 1.0f), new ResultPoint(x3 - 1.0f, 1.0f + y3), new ResultPoint(x - 1.0f, y - 1.0f) };
    }
    
    private boolean containsBlackPoint(int i, final int n, final int n2, final boolean b) {
        if (b) {
            while (i <= n) {
                if (this.image.get(i, n2)) {
                    return true;
                }
                ++i;
            }
            return false;
        }
        while (i <= n) {
            if (this.image.get(n2, i)) {
                return true;
            }
            ++i;
        }
        return false;
    }
    
    private ResultPoint getBlackPointOnSegment(final float n, final float n2, float n3, float n4) {
        final int round = MathUtils.round(MathUtils.distance(n, n2, n3, n4));
        n3 = (n3 - n) / round;
        n4 = (n4 - n2) / round;
        for (int i = 0; i < round; ++i) {
            final int round2 = MathUtils.round(i * n3 + n);
            final int round3 = MathUtils.round(i * n4 + n2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float)round2, (float)round3);
            }
        }
        return null;
    }
    
    public ResultPoint[] detect() throws NotFoundException {
        int leftInit = this.leftInit;
        int rightInit = this.rightInit;
        int upInit = this.upInit;
        int downInit = this.downInit;
        final int n = 0;
        int n2 = 1;
        boolean b = false;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            int n14 = 0;
            Block_25: {
                Block_20: {
                    Block_15: {
                        int n7;
                        int n8;
                        int n9;
                        int n10;
                        int n11;
                        while (true) {
                            n7 = downInit;
                            n8 = leftInit;
                            n9 = rightInit;
                            n10 = n;
                            n11 = upInit;
                            if (n2 == 0) {
                                break;
                            }
                            int n12 = 0;
                            boolean b2 = true;
                            n9 = rightInit;
                            int n13 = n3;
                            while ((b2 || n13 == 0) && n9 < this.width) {
                                final boolean containsBlackPoint = this.containsBlackPoint(upInit, downInit, n9, false);
                                if (containsBlackPoint) {
                                    ++n9;
                                    n12 = 1;
                                    n13 = 1;
                                    b2 = containsBlackPoint;
                                }
                                else {
                                    b2 = containsBlackPoint;
                                    if (n13 != 0) {
                                        continue;
                                    }
                                    ++n9;
                                    b2 = containsBlackPoint;
                                }
                            }
                            if (n9 >= this.width) {
                                n10 = 1;
                                n11 = upInit;
                                n8 = leftInit;
                                n7 = downInit;
                                break;
                            }
                            boolean b3 = true;
                            n14 = downInit;
                            int n15 = n4;
                            int n16 = n12;
                            while ((b3 || n15 == 0) && n14 < this.height) {
                                final boolean containsBlackPoint2 = this.containsBlackPoint(leftInit, n9, n14, true);
                                if (containsBlackPoint2) {
                                    ++n14;
                                    n16 = 1;
                                    n15 = 1;
                                    b3 = containsBlackPoint2;
                                }
                                else {
                                    b3 = containsBlackPoint2;
                                    if (n15 != 0) {
                                        continue;
                                    }
                                    ++n14;
                                    b3 = containsBlackPoint2;
                                }
                            }
                            if (n14 >= this.height) {
                                break Block_15;
                            }
                            boolean b4 = true;
                            n8 = leftInit;
                            int n17 = n5;
                            int n18 = n16;
                            while ((b4 || n17 == 0) && n8 >= 0) {
                                final boolean containsBlackPoint3 = this.containsBlackPoint(upInit, n14, n8, false);
                                if (containsBlackPoint3) {
                                    --n8;
                                    n18 = 1;
                                    n17 = 1;
                                    b4 = containsBlackPoint3;
                                }
                                else {
                                    b4 = containsBlackPoint3;
                                    if (n17 != 0) {
                                        continue;
                                    }
                                    --n8;
                                    b4 = containsBlackPoint3;
                                }
                            }
                            if (n8 < 0) {
                                break Block_20;
                            }
                            boolean b5 = true;
                            n11 = upInit;
                            int n19 = n6;
                            while ((b5 || n19 == 0) && n11 >= 0) {
                                final boolean containsBlackPoint4 = this.containsBlackPoint(n8, n9, n11, true);
                                if (containsBlackPoint4) {
                                    --n11;
                                    n18 = 1;
                                    n19 = 1;
                                    b5 = containsBlackPoint4;
                                }
                                else {
                                    b5 = containsBlackPoint4;
                                    if (n19 != 0) {
                                        continue;
                                    }
                                    --n11;
                                    b5 = containsBlackPoint4;
                                }
                            }
                            if (n11 < 0) {
                                break Block_25;
                            }
                            n2 = n18;
                            n4 = n15;
                            n5 = n17;
                            n3 = n13;
                            n6 = n19;
                            downInit = n14;
                            leftInit = n8;
                            rightInit = n9;
                            upInit = n11;
                            if (n18 == 0) {
                                continue;
                            }
                            b = true;
                            n2 = n18;
                            n4 = n15;
                            n5 = n17;
                            n3 = n13;
                            n6 = n19;
                            downInit = n14;
                            leftInit = n8;
                            rightInit = n9;
                            upInit = n11;
                        }
                        if (n10 != 0 || !b) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        final int n20 = n9 - n8;
                        ResultPoint blackPointOnSegment = null;
                        for (int n21 = 1; blackPointOnSegment == null && n21 < n20; blackPointOnSegment = this.getBlackPointOnSegment((float)n8, (float)(n7 - n21), (float)(n8 + n21), (float)n7), ++n21) {}
                        if (blackPointOnSegment == null) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        ResultPoint blackPointOnSegment2 = null;
                        for (int n22 = 1; blackPointOnSegment2 == null && n22 < n20; blackPointOnSegment2 = this.getBlackPointOnSegment((float)n8, (float)(n11 + n22), (float)(n8 + n22), (float)n11), ++n22) {}
                        if (blackPointOnSegment2 == null) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        ResultPoint blackPointOnSegment3 = null;
                        for (int n23 = 1; blackPointOnSegment3 == null && n23 < n20; blackPointOnSegment3 = this.getBlackPointOnSegment((float)n9, (float)(n11 + n23), (float)(n9 - n23), (float)n11), ++n23) {}
                        if (blackPointOnSegment3 == null) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        ResultPoint blackPointOnSegment4 = null;
                        for (int n24 = 1; blackPointOnSegment4 == null && n24 < n20; blackPointOnSegment4 = this.getBlackPointOnSegment((float)n9, (float)(n7 - n24), (float)(n9 - n24), (float)n7), ++n24) {}
                        if (blackPointOnSegment4 == null) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        return this.centerEdges(blackPointOnSegment4, blackPointOnSegment, blackPointOnSegment3, blackPointOnSegment2);
                    }
                    final int n25 = 1;
                    int n7 = n14;
                    int n8 = leftInit;
                    int n10 = n25;
                    int n11 = upInit;
                    continue;
                }
                final int n26 = 1;
                int n7 = n14;
                int n10 = n26;
                int n11 = upInit;
                continue;
            }
            final int n27 = 1;
            int n7 = n14;
            int n10 = n27;
            continue;
        }
    }
}
