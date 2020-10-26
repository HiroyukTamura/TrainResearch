// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongConcat extends OfLong
{
    private boolean firstStreamIsCurrent;
    private final OfLong iterator1;
    private final OfLong iterator2;
    
    public LongConcat(final OfLong iterator1, final OfLong iterator2) {
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
    public long nextLong() {
        if (this.firstStreamIsCurrent) {
            return this.iterator1.nextLong();
        }
        return this.iterator2.nextLong();
    }
}
