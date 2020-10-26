// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Arrays;
import com.annimon.stream.internal.Operators;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class DoubleSorted extends OfDouble
{
    private double[] array;
    private int index;
    private final PrimitiveIterator.OfDouble iterator;
    
    public DoubleSorted(final PrimitiveIterator.OfDouble iterator) {
        this.iterator = iterator;
        this.index = 0;
    }
    
    @Override
    protected void nextIteration() {
        if (!this.isInit) {
            Arrays.sort(this.array = Operators.toDoubleArray(this.iterator));
        }
        this.hasNext = (this.index < this.array.length);
        if (this.hasNext) {
            this.next = this.array[this.index++];
        }
    }
}
