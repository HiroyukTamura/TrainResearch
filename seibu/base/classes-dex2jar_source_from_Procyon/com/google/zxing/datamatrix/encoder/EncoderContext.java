// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

import java.nio.charset.StandardCharsets;
import com.google.zxing.Dimension;

final class EncoderContext
{
    private final StringBuilder codewords;
    private Dimension maxSize;
    private Dimension minSize;
    private final String msg;
    private int newEncoding;
    int pos;
    private SymbolShapeHint shape;
    private int skipAtEnd;
    private SymbolInfo symbolInfo;
    
    EncoderContext(final String s) {
        final byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);
        final StringBuilder sb = new StringBuilder(bytes.length);
        for (int i = 0; i < bytes.length; ++i) {
            final char c = (char)(bytes[i] & 0xFF);
            if (c == '?' && s.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.msg = sb.toString();
        this.shape = SymbolShapeHint.FORCE_NONE;
        this.codewords = new StringBuilder(s.length());
        this.newEncoding = -1;
    }
    
    private int getTotalMessageCharCount() {
        return this.msg.length() - this.skipAtEnd;
    }
    
    public int getCodewordCount() {
        return this.codewords.length();
    }
    
    public StringBuilder getCodewords() {
        return this.codewords;
    }
    
    public char getCurrent() {
        return this.msg.charAt(this.pos);
    }
    
    public char getCurrentChar() {
        return this.msg.charAt(this.pos);
    }
    
    public String getMessage() {
        return this.msg;
    }
    
    public int getNewEncoding() {
        return this.newEncoding;
    }
    
    public int getRemainingCharacters() {
        return this.getTotalMessageCharCount() - this.pos;
    }
    
    public SymbolInfo getSymbolInfo() {
        return this.symbolInfo;
    }
    
    public boolean hasMoreCharacters() {
        return this.pos < this.getTotalMessageCharCount();
    }
    
    public void resetEncoderSignal() {
        this.newEncoding = -1;
    }
    
    public void resetSymbolInfo() {
        this.symbolInfo = null;
    }
    
    public void setSizeConstraints(final Dimension minSize, final Dimension maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }
    
    public void setSkipAtEnd(final int skipAtEnd) {
        this.skipAtEnd = skipAtEnd;
    }
    
    public void setSymbolShape(final SymbolShapeHint shape) {
        this.shape = shape;
    }
    
    public void signalEncoderChange(final int newEncoding) {
        this.newEncoding = newEncoding;
    }
    
    public void updateSymbolInfo() {
        this.updateSymbolInfo(this.getCodewordCount());
    }
    
    public void updateSymbolInfo(final int n) {
        if (this.symbolInfo == null || n > this.symbolInfo.getDataCapacity()) {
            this.symbolInfo = SymbolInfo.lookup(n, this.shape, this.minSize, this.maxSize, true);
        }
    }
    
    public void writeCodeword(final char c) {
        this.codewords.append(c);
    }
    
    public void writeCodewords(final String str) {
        this.codewords.append(str);
    }
}
