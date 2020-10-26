// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.ResultPoint;

final class BoundingBox
{
    private ResultPoint bottomLeft;
    private ResultPoint bottomRight;
    private BitMatrix image;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private ResultPoint topLeft;
    private ResultPoint topRight;
    
    BoundingBox(final BitMatrix bitMatrix, final ResultPoint resultPoint, final ResultPoint resultPoint2, final ResultPoint resultPoint3, final ResultPoint resultPoint4) throws NotFoundException {
        if ((resultPoint == null && resultPoint3 == null) || (resultPoint2 == null && resultPoint4 == null) || (resultPoint != null && resultPoint2 == null) || (resultPoint3 != null && resultPoint4 == null)) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.init(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
    }
    
    BoundingBox(final BoundingBox boundingBox) {
        this.init(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox.topRight, boundingBox.bottomRight);
    }
    
    private void calculateMinMaxValues() {
        if (this.topLeft == null) {
            this.topLeft = new ResultPoint(0.0f, this.topRight.getY());
            this.bottomLeft = new ResultPoint(0.0f, this.bottomRight.getY());
        }
        else if (this.topRight == null) {
            this.topRight = new ResultPoint((float)(this.image.getWidth() - 1), this.topLeft.getY());
            this.bottomRight = new ResultPoint((float)(this.image.getWidth() - 1), this.bottomLeft.getY());
        }
        this.minX = (int)Math.min(this.topLeft.getX(), this.bottomLeft.getX());
        this.maxX = (int)Math.max(this.topRight.getX(), this.bottomRight.getX());
        this.minY = (int)Math.min(this.topLeft.getY(), this.topRight.getY());
        this.maxY = (int)Math.max(this.bottomLeft.getY(), this.bottomRight.getY());
    }
    
    private void init(final BitMatrix image, final ResultPoint topLeft, final ResultPoint bottomLeft, final ResultPoint topRight, final ResultPoint bottomRight) {
        this.image = image;
        this.topLeft = topLeft;
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.calculateMinMaxValues();
    }
    
    static BoundingBox merge(final BoundingBox boundingBox, final BoundingBox boundingBox2) throws NotFoundException {
        if (boundingBox == null) {
            return boundingBox2;
        }
        if (boundingBox2 == null) {
            return boundingBox;
        }
        return new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }
    
    BoundingBox addMissingRows(int n, int n2, final boolean b) throws NotFoundException {
        final ResultPoint topLeft = this.topLeft;
        final ResultPoint bottomLeft = this.bottomLeft;
        final ResultPoint topRight = this.topRight;
        final ResultPoint bottomRight = this.bottomRight;
        ResultPoint resultPoint = topLeft;
        ResultPoint resultPoint2 = topRight;
        if (n > 0) {
            ResultPoint resultPoint3;
            if (b) {
                resultPoint3 = this.topLeft;
            }
            else {
                resultPoint3 = this.topRight;
            }
            if ((n = (int)resultPoint3.getY() - n) < 0) {
                n = 0;
            }
            resultPoint = new ResultPoint(resultPoint3.getX(), (float)n);
            if (b) {
                resultPoint2 = topRight;
            }
            else {
                resultPoint2 = resultPoint;
                resultPoint = topLeft;
            }
        }
        ResultPoint resultPoint4 = bottomLeft;
        ResultPoint resultPoint5 = bottomRight;
        if (n2 > 0) {
            ResultPoint resultPoint6;
            if (b) {
                resultPoint6 = this.bottomLeft;
            }
            else {
                resultPoint6 = this.bottomRight;
            }
            n2 = (n = (int)resultPoint6.getY() + n2);
            if (n2 >= this.image.getHeight()) {
                n = this.image.getHeight() - 1;
            }
            resultPoint4 = new ResultPoint(resultPoint6.getX(), (float)n);
            if (b) {
                resultPoint5 = bottomRight;
            }
            else {
                resultPoint5 = resultPoint4;
                resultPoint4 = bottomLeft;
            }
        }
        this.calculateMinMaxValues();
        return new BoundingBox(this.image, resultPoint, resultPoint4, resultPoint2, resultPoint5);
    }
    
    ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }
    
    ResultPoint getBottomRight() {
        return this.bottomRight;
    }
    
    int getMaxX() {
        return this.maxX;
    }
    
    int getMaxY() {
        return this.maxY;
    }
    
    int getMinX() {
        return this.minX;
    }
    
    int getMinY() {
        return this.minY;
    }
    
    ResultPoint getTopLeft() {
        return this.topLeft;
    }
    
    ResultPoint getTopRight() {
        return this.topRight;
    }
}
