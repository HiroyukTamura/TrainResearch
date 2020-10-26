// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.LsaIterator;

public class ObjArray<T> extends LsaIterator<T>
{
    private final T[] elements;
    private int index;
    
    public ObjArray(final T[] elements) {
        this.elements = elements;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.elements.length;
    }
    
    @Override
    public T nextIteration() {
        return this.elements[this.index++];
    }
}
