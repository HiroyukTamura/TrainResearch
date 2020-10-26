// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitMatrix;

public final class AztecCode
{
    private int codeWords;
    private boolean compact;
    private int layers;
    private BitMatrix matrix;
    private int size;
    
    public int getCodeWords() {
        return this.codeWords;
    }
    
    public int getLayers() {
        return this.layers;
    }
    
    public BitMatrix getMatrix() {
        return this.matrix;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public boolean isCompact() {
        return this.compact;
    }
    
    public void setCodeWords(final int codeWords) {
        this.codeWords = codeWords;
    }
    
    public void setCompact(final boolean compact) {
        this.compact = compact;
    }
    
    public void setLayers(final int layers) {
        this.layers = layers;
    }
    
    public void setMatrix(final BitMatrix matrix) {
        this.matrix = matrix;
    }
    
    public void setSize(final int size) {
        this.size = size;
    }
}
