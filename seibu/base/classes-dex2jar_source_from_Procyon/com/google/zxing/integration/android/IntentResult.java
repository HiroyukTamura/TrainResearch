// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.integration.android;

public final class IntentResult
{
    private final String barcodeImagePath;
    private final String contents;
    private final String errorCorrectionLevel;
    private final String formatName;
    private final Integer orientation;
    private final byte[] rawBytes;
    
    IntentResult() {
        this(null, null, null, null, null, null);
    }
    
    IntentResult(final String contents, final String formatName, final byte[] rawBytes, final Integer orientation, final String errorCorrectionLevel, final String barcodeImagePath) {
        this.contents = contents;
        this.formatName = formatName;
        this.rawBytes = rawBytes;
        this.orientation = orientation;
        this.errorCorrectionLevel = errorCorrectionLevel;
        this.barcodeImagePath = barcodeImagePath;
    }
    
    public String getBarcodeImagePath() {
        return this.barcodeImagePath;
    }
    
    public String getContents() {
        return this.contents;
    }
    
    public String getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }
    
    public String getFormatName() {
        return this.formatName;
    }
    
    public Integer getOrientation() {
        return this.orientation;
    }
    
    public byte[] getRawBytes() {
        return this.rawBytes;
    }
    
    @Override
    public String toString() {
        int length;
        if (this.rawBytes == null) {
            length = 0;
        }
        else {
            length = this.rawBytes.length;
        }
        return "Format: " + this.formatName + '\n' + "Contents: " + this.contents + '\n' + "Raw bytes: (" + length + " bytes)\nOrientation: " + this.orientation + '\n' + "EC level: " + this.errorCorrectionLevel + '\n' + "Barcode image: " + this.barcodeImagePath + '\n';
    }
}
