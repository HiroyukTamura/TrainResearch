// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class QRCode
{
    public static final int NUM_MASK_PATTERNS = 8;
    private ErrorCorrectionLevel ecLevel;
    private int maskPattern;
    private ByteMatrix matrix;
    private Mode mode;
    private Version version;
    
    public QRCode() {
        this.maskPattern = -1;
    }
    
    public static boolean isValidMaskPattern(final int n) {
        return n >= 0 && n < 8;
    }
    
    public ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }
    
    public int getMaskPattern() {
        return this.maskPattern;
    }
    
    public ByteMatrix getMatrix() {
        return this.matrix;
    }
    
    public Mode getMode() {
        return this.mode;
    }
    
    public Version getVersion() {
        return this.version;
    }
    
    public void setECLevel(final ErrorCorrectionLevel ecLevel) {
        this.ecLevel = ecLevel;
    }
    
    public void setMaskPattern(final int maskPattern) {
        this.maskPattern = maskPattern;
    }
    
    public void setMatrix(final ByteMatrix matrix) {
        this.matrix = matrix;
    }
    
    public void setMode(final Mode mode) {
        this.mode = mode;
    }
    
    public void setVersion(final Version version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.mode);
        sb.append("\n ecLevel: ");
        sb.append(this.ecLevel);
        sb.append("\n version: ");
        sb.append(this.version);
        sb.append("\n maskPattern: ");
        sb.append(this.maskPattern);
        if (this.matrix == null) {
            sb.append("\n matrix: null\n");
        }
        else {
            sb.append("\n matrix:\n");
            sb.append(this.matrix);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
