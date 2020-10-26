// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

final class Codeword
{
    private static final int BARCODE_ROW_UNKNOWN = -1;
    private final int bucket;
    private final int endX;
    private int rowNumber;
    private final int startX;
    private final int value;
    
    Codeword(final int startX, final int endX, final int bucket, final int value) {
        this.rowNumber = -1;
        this.startX = startX;
        this.endX = endX;
        this.bucket = bucket;
        this.value = value;
    }
    
    int getBucket() {
        return this.bucket;
    }
    
    int getEndX() {
        return this.endX;
    }
    
    int getRowNumber() {
        return this.rowNumber;
    }
    
    int getStartX() {
        return this.startX;
    }
    
    int getValue() {
        return this.value;
    }
    
    int getWidth() {
        return this.endX - this.startX;
    }
    
    boolean hasValidRowNumber() {
        return this.isValidRowNumber(this.rowNumber);
    }
    
    boolean isValidRowNumber(final int n) {
        return n != -1 && this.bucket == n % 3 * 3;
    }
    
    void setRowNumber(final int rowNumber) {
        this.rowNumber = rowNumber;
    }
    
    void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = this.value / 30 * 3 + this.bucket / 3;
    }
    
    @Override
    public String toString() {
        return this.rowNumber + "|" + this.value;
    }
}
