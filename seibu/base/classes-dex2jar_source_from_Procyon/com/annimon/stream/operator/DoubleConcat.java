// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleConcat extends OfDouble
{
    private boolean firstStreamIsCurrent;
    private final OfDouble iterator1;
    private final OfDouble iterator2;
    
    public DoubleConcat(final OfDouble iterator1, final OfDouble iterator2) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.firstStreamIsCurrent = true;
    }
    
    @Override
    public boolean hasNext() {
        if (this.firstStreamIsCurrent) {
            if (this.iterator1.hasNext()) {
                return true;
            }
            this.firstStreamIsCurrent = false;
        }
        return this.iterator2.hasNext();
    }
    
    @Override
    public double nextDouble() {
        if (this.firstStreamIsCurrent) {
            return this.iterator1.nextDouble();
        }
        return this.iterator2.nextDouble();
    }
}
