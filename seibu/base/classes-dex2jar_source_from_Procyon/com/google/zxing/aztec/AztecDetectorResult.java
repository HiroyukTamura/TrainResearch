// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

public final class AztecDetectorResult extends DetectorResult
{
    private final boolean compact;
    private final int nbDatablocks;
    private final int nbLayers;
    
    public AztecDetectorResult(final BitMatrix bitMatrix, final ResultPoint[] array, final boolean compact, final int nbDatablocks, final int nbLayers) {
        super(bitMatrix, array);
        this.compact = compact;
        this.nbDatablocks = nbDatablocks;
        this.nbLayers = nbLayers;
    }
    
    public int getNbDatablocks() {
        return this.nbDatablocks;
    }
    
    public int getNbLayers() {
        return this.nbLayers;
    }
    
    public boolean isCompact() {
        return this.compact;
    }
}
