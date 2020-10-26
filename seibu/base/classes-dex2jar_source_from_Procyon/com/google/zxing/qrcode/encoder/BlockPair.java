// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.encoder;

final class BlockPair
{
    private final byte[] dataBytes;
    private final byte[] errorCorrectionBytes;
    
    BlockPair(final byte[] dataBytes, final byte[] errorCorrectionBytes) {
        this.dataBytes = dataBytes;
        this.errorCorrectionBytes = errorCorrectionBytes;
    }
    
    public byte[] getDataBytes() {
        return this.dataBytes;
    }
    
    public byte[] getErrorCorrectionBytes() {
        return this.errorCorrectionBytes;
    }
}
