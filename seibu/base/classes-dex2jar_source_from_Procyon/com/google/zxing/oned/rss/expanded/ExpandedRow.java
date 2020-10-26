// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

final class ExpandedRow
{
    private final List<ExpandedPair> pairs;
    private final int rowNumber;
    private final boolean wasReversed;
    
    ExpandedRow(final List<ExpandedPair> c, final int rowNumber, final boolean wasReversed) {
        this.pairs = new ArrayList<ExpandedPair>(c);
        this.rowNumber = rowNumber;
        this.wasReversed = wasReversed;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof ExpandedRow) {
            final ExpandedRow expandedRow = (ExpandedRow)o;
            if (this.pairs.equals(expandedRow.getPairs()) && this.wasReversed == expandedRow.wasReversed) {
                return true;
            }
        }
        return false;
    }
    
    List<ExpandedPair> getPairs() {
        return this.pairs;
    }
    
    int getRowNumber() {
        return this.rowNumber;
    }
    
    @Override
    public int hashCode() {
        return this.pairs.hashCode() ^ Boolean.valueOf(this.wasReversed).hashCode();
    }
    
    boolean isEquivalent(final List<ExpandedPair> list) {
        return this.pairs.equals(list);
    }
    
    boolean isReversed() {
        return this.wasReversed;
    }
    
    @Override
    public String toString() {
        return "{ " + this.pairs + " }";
    }
}
