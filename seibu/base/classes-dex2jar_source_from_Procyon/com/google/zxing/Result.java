// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class Result
{
    private final BarcodeFormat format;
    private final int numBits;
    private final byte[] rawBytes;
    private Map<ResultMetadataType, Object> resultMetadata;
    private ResultPoint[] resultPoints;
    private final String text;
    private final long timestamp;
    
    public Result(final String text, final byte[] rawBytes, final int numBits, final ResultPoint[] resultPoints, final BarcodeFormat format, final long timestamp) {
        this.text = text;
        this.rawBytes = rawBytes;
        this.numBits = numBits;
        this.resultPoints = resultPoints;
        this.format = format;
        this.resultMetadata = null;
        this.timestamp = timestamp;
    }
    
    public Result(final String s, final byte[] array, final ResultPoint[] array2, final BarcodeFormat barcodeFormat) {
        this(s, array, array2, barcodeFormat, System.currentTimeMillis());
    }
    
    public Result(final String s, final byte[] array, final ResultPoint[] array2, final BarcodeFormat barcodeFormat, final long n) {
        int n2;
        if (array == null) {
            n2 = 0;
        }
        else {
            n2 = array.length * 8;
        }
        this(s, array, n2, array2, barcodeFormat, n);
    }
    
    public void addResultPoints(final ResultPoint[] resultPoints) {
        final ResultPoint[] resultPoints2 = this.resultPoints;
        if (resultPoints2 == null) {
            this.resultPoints = resultPoints;
        }
        else if (resultPoints != null && resultPoints.length > 0) {
            final ResultPoint[] resultPoints3 = new ResultPoint[resultPoints2.length + resultPoints.length];
            System.arraycopy(resultPoints2, 0, resultPoints3, 0, resultPoints2.length);
            System.arraycopy(resultPoints, 0, resultPoints3, resultPoints2.length, resultPoints.length);
            this.resultPoints = resultPoints3;
        }
    }
    
    public BarcodeFormat getBarcodeFormat() {
        return this.format;
    }
    
    public int getNumBits() {
        return this.numBits;
    }
    
    public byte[] getRawBytes() {
        return this.rawBytes;
    }
    
    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.resultMetadata;
    }
    
    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }
    
    public String getText() {
        return this.text;
    }
    
    public long getTimestamp() {
        return this.timestamp;
    }
    
    public void putAllMetadata(final Map<ResultMetadataType, Object> resultMetadata) {
        if (resultMetadata != null) {
            if (this.resultMetadata != null) {
                this.resultMetadata.putAll(resultMetadata);
                return;
            }
            this.resultMetadata = resultMetadata;
        }
    }
    
    public void putMetadata(final ResultMetadataType resultMetadataType, final Object o) {
        if (this.resultMetadata == null) {
            this.resultMetadata = new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class);
        }
        this.resultMetadata.put(resultMetadataType, o);
    }
    
    @Override
    public String toString() {
        return this.text;
    }
}
