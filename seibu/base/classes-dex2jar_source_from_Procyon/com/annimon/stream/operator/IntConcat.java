// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntConcat extends OfInt
{
    private boolean firstStreamIsCurrent;
    private final OfInt iterator1;
    private final OfInt iterator2;
    
    public IntConcat(final OfInt iterator1, final OfInt iterator2) {
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
    public int nextInt() {
        if (this.firstStreamIsCurrent) {
            return this.iterator1.nextInt();
        }
        return this.iterator2.nextInt();
    }
}
