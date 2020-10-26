// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

final class BlockParsedResult
{
    private final DecodedInformation decodedInformation;
    private final boolean finished;
    
    BlockParsedResult(final DecodedInformation decodedInformation, final boolean finished) {
        this.finished = finished;
        this.decodedInformation = decodedInformation;
    }
    
    BlockParsedResult(final boolean b) {
        this(null, b);
    }
    
    DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }
    
    boolean isFinished() {
        return this.finished;
    }
}
