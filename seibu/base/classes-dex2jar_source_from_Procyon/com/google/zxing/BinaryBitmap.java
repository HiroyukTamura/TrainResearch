// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public final class BinaryBitmap
{
    private final Binarizer binarizer;
    private BitMatrix matrix;
    
    public BinaryBitmap(final Binarizer binarizer) {
        if (binarizer == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.binarizer = binarizer;
    }
    
    public BinaryBitmap crop(final int n, final int n2, final int n3, final int n4) {
        return new BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().crop(n, n2, n3, n4)));
    }
    
    public BitMatrix getBlackMatrix() throws NotFoundException {
        if (this.matrix == null) {
            this.matrix = this.binarizer.getBlackMatrix();
        }
        return this.matrix;
    }
    
    public BitArray getBlackRow(final int n, final BitArray bitArray) throws NotFoundException {
        return this.binarizer.getBlackRow(n, bitArray);
    }
    
    public int getHeight() {
        return this.binarizer.getHeight();
    }
    
    public int getWidth() {
        return this.binarizer.getWidth();
    }
    
    public boolean isCropSupported() {
        return this.binarizer.getLuminanceSource().isCropSupported();
    }
    
    public boolean isRotateSupported() {
        return this.binarizer.getLuminanceSource().isRotateSupported();
    }
    
    public BinaryBitmap rotateCounterClockwise() {
        return new BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise()));
    }
    
    public BinaryBitmap rotateCounterClockwise45() {
        return new BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise45()));
    }
    
    @Override
    public String toString() {
        try {
            return this.getBlackMatrix().toString();
        }
        catch (NotFoundException ex) {
            return "";
        }
    }
}
