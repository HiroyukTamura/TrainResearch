// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.iterator;

import java.util.Iterator;

public final class PrimitiveIterator
{
    private PrimitiveIterator() {
    }
    
    public abstract static class OfDouble implements Iterator<Double>
    {
        @Override
        public Double next() {
            return this.nextDouble();
        }
        
        public abstract double nextDouble();
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
    
    public abstract static class OfInt implements Iterator<Integer>
    {
        @Override
        public Integer next() {
            return this.nextInt();
        }
        
        public abstract int nextInt();
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
    
    public abstract static class OfLong implements Iterator<Long>
    {
        @Override
        public Long next() {
            return this.nextLong();
        }
        
        public abstract long nextLong();
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
