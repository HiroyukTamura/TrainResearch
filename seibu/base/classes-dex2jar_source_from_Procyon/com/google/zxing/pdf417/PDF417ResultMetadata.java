// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417;

public final class PDF417ResultMetadata
{
    private String fileId;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentIndex;
    
    public String getFileId() {
        return this.fileId;
    }
    
    public int[] getOptionalData() {
        return this.optionalData;
    }
    
    public int getSegmentIndex() {
        return this.segmentIndex;
    }
    
    public boolean isLastSegment() {
        return this.lastSegment;
    }
    
    public void setFileId(final String fileId) {
        this.fileId = fileId;
    }
    
    public void setLastSegment(final boolean lastSegment) {
        this.lastSegment = lastSegment;
    }
    
    public void setOptionalData(final int[] optionalData) {
        this.optionalData = optionalData;
    }
    
    public void setSegmentIndex(final int segmentIndex) {
        this.segmentIndex = segmentIndex;
    }
}
