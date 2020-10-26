// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Arrays;
import com.annimon.stream.internal.Operators;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class IntSorted extends OfInt
{
    private int[] array;
    private int index;
    private final PrimitiveIterator.OfInt iterator;
    
    public IntSorted(final PrimitiveIterator.OfInt iterator) {
        this.iterator = iterator;
        this.index = 0;
    }
    
    @Override
    protected void nextIteration() {
        if (!this.isInit) {
            Arrays.sort(this.array = Operators.toIntArray(this.iterator));
        }
        this.hasNext = (this.index < this.array.length);
        if (this.hasNext) {
            this.next = this.array[this.index++];
        }
    }
}
