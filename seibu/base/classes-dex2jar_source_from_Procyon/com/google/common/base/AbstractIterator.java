// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import java.util.NoSuchElementException;
import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
abstract class AbstractIterator<T> implements Iterator<T>
{
    private T next;
    private State state;
    
    protected AbstractIterator() {
        this.state = State.NOT_READY;
    }
    
    private boolean tryToComputeNext() {
        this.state = State.FAILED;
        this.next = this.computeNext();
        if (this.state != State.DONE) {
            this.state = State.READY;
            return true;
        }
        return false;
    }
    
    protected abstract T computeNext();
    
    protected final T endOfData() {
        this.state = State.DONE;
        return null;
    }
    
    @Override
    public final boolean hasNext() {
        final boolean b = false;
        Preconditions.checkState(this.state != State.FAILED);
        boolean tryToComputeNext = b;
        switch (this.state) {
            default: {
                tryToComputeNext = this.tryToComputeNext();
                return tryToComputeNext;
            }
            case DONE: {
                return tryToComputeNext;
            }
            case READY: {
                return true;
            }
        }
    }
    
    @Override
    public final T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = State.NOT_READY;
        final T next = this.next;
        this.next = null;
        return next;
    }
    
    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
    
    private enum State
    {
        DONE, 
        FAILED, 
        NOT_READY, 
        READY;
    }
}
