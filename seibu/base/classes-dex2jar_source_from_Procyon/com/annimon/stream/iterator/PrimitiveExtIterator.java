// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.iterator;

import java.util.NoSuchElementException;

public final class PrimitiveExtIterator
{
    private PrimitiveExtIterator() {
    }
    
    public abstract static class OfDouble extends PrimitiveIterator.OfDouble
    {
        protected boolean hasNext;
        protected boolean isInit;
        protected double next;
        
        @Override
        public boolean hasNext() {
            if (!this.isInit) {
                this.nextIteration();
                this.isInit = true;
            }
            return this.hasNext;
        }
        
        @Override
        public double nextDouble() {
            if (!this.isInit) {
                this.hasNext();
            }
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            final double next = this.next;
            this.nextIteration();
            return next;
        }
        
        protected abstract void nextIteration();
    }
    
    public abstract static class OfInt extends PrimitiveIterator.OfInt
    {
        protected boolean hasNext;
        protected boolean isInit;
        protected int next;
        
        @Override
        public boolean hasNext() {
            if (!this.isInit) {
                this.nextIteration();
                this.isInit = true;
            }
            return this.hasNext;
        }
        
        @Override
        public int nextInt() {
            if (!this.isInit) {
                this.hasNext();
            }
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            final int next = this.next;
            this.nextIteration();
            return next;
        }
        
        protected abstract void nextIteration();
    }
    
    public abstract static class OfLong extends PrimitiveIterator.OfLong
    {
        protected boolean hasNext;
        protected boolean isInit;
        protected long next;
        
        @Override
        public boolean hasNext() {
            if (!this.isInit) {
                this.nextIteration();
                this.isInit = true;
            }
            return this.hasNext;
        }
        
        protected abstract void nextIteration();
        
        @Override
        public long nextLong() {
            if (!this.isInit) {
                this.hasNext();
            }
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            final long next = this.next;
            this.nextIteration();
            return next;
        }
    }
}
