// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import java.util.List;

public final class DecoderResult
{
    private final List<byte[]> byteSegments;
    private final String ecLevel;
    private Integer erasures;
    private Integer errorsCorrected;
    private int numBits;
    private Object other;
    private final byte[] rawBytes;
    private final int structuredAppendParity;
    private final int structuredAppendSequenceNumber;
    private final String text;
    
    public DecoderResult(final byte[] array, final String s, final List<byte[]> list, final String s2) {
        this(array, s, list, s2, -1, -1);
    }
    
    public DecoderResult(final byte[] rawBytes, final String text, final List<byte[]> byteSegments, final String ecLevel, final int structuredAppendSequenceNumber, final int structuredAppendParity) {
        this.rawBytes = rawBytes;
        int numBits;
        if (rawBytes == null) {
            numBits = 0;
        }
        else {
            numBits = rawBytes.length * 8;
        }
        this.numBits = numBits;
        this.text = text;
        this.byteSegments = byteSegments;
        this.ecLevel = ecLevel;
        this.structuredAppendParity = structuredAppendParity;
        this.structuredAppendSequenceNumber = structuredAppendSequenceNumber;
    }
    
    public List<byte[]> getByteSegments() {
        return this.byteSegments;
    }
    
    public String getECLevel() {
        return this.ecLevel;
    }
    
    public Integer getErasures() {
        return this.erasures;
    }
    
    public Integer getErrorsCorrected() {
        return this.errorsCorrected;
    }
    
    public int getNumBits() {
        return this.numBits;
    }
    
    public Object getOther() {
        return this.other;
    }
    
    public byte[] getRawBytes() {
        return this.rawBytes;
    }
    
    public int getStructuredAppendParity() {
        return this.structuredAppendParity;
    }
    
    public int getStructuredAppendSequenceNumber() {
        return this.structuredAppendSequenceNumber;
    }
    
    public String getText() {
        return this.text;
    }
    
    public boolean hasStructuredAppend() {
        return this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0;
    }
    
    public void setErasures(final Integer erasures) {
        this.erasures = erasures;
    }
    
    public void setErrorsCorrected(final Integer errorsCorrected) {
        this.errorsCorrected = errorsCorrected;
    }
    
    public void setNumBits(final int numBits) {
        this.numBits = numBits;
    }
    
    public void setOther(final Object other) {
        this.other = other;
    }
}
