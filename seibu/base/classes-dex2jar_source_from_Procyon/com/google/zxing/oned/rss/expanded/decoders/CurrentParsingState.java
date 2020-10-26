// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

final class CurrentParsingState
{
    private State encoding;
    private int position;
    
    CurrentParsingState() {
        this.position = 0;
        this.encoding = State.NUMERIC;
    }
    
    int getPosition() {
        return this.position;
    }
    
    void incrementPosition(final int n) {
        this.position += n;
    }
    
    boolean isAlpha() {
        return this.encoding == State.ALPHA;
    }
    
    boolean isIsoIec646() {
        return this.encoding == State.ISO_IEC_646;
    }
    
    boolean isNumeric() {
        return this.encoding == State.NUMERIC;
    }
    
    void setAlpha() {
        this.encoding = State.ALPHA;
    }
    
    void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }
    
    void setNumeric() {
        this.encoding = State.NUMERIC;
    }
    
    void setPosition(final int position) {
        this.position = position;
    }
    
    private enum State
    {
        ALPHA, 
        ISO_IEC_646, 
        NUMERIC;
    }
}
