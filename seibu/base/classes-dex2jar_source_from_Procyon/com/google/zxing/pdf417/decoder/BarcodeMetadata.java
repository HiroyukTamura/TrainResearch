// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder;

final class BarcodeMetadata
{
    private final int columnCount;
    private final int errorCorrectionLevel;
    private final int rowCount;
    private final int rowCountLowerPart;
    private final int rowCountUpperPart;
    
    BarcodeMetadata(final int columnCount, final int rowCountUpperPart, final int rowCountLowerPart, final int errorCorrectionLevel) {
        this.columnCount = columnCount;
        this.errorCorrectionLevel = errorCorrectionLevel;
        this.rowCountUpperPart = rowCountUpperPart;
        this.rowCountLowerPart = rowCountLowerPart;
        this.rowCount = rowCountUpperPart + rowCountLowerPart;
    }
    
    int getColumnCount() {
        return this.columnCount;
    }
    
    int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }
    
    int getRowCount() {
        return this.rowCount;
    }
    
    int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }
    
    int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }
}
