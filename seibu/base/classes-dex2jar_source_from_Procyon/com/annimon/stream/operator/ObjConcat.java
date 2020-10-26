// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Iterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjConcat<T> extends LsaExtIterator<T>
{
    private boolean firstStreamIsCurrent;
    private final Iterator<? extends T> iterator1;
    private final Iterator<? extends T> iterator2;
    
    public ObjConcat(final Iterator<? extends T> iterator1, final Iterator<? extends T> iterator2) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.firstStreamIsCurrent = true;
    }
    
    @Override
    protected void nextIteration() {
        if (this.firstStreamIsCurrent) {
            if (this.iterator1.hasNext()) {
                this.next = (T)this.iterator1.next();
                this.hasNext = true;
                return;
            }
            this.firstStreamIsCurrent = false;
        }
        if (this.iterator2.hasNext()) {
            this.next = (T)this.iterator2.next();
            this.hasNext = true;
            return;
        }
        this.hasNext = false;
    }
}
