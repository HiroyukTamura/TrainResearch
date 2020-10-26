// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

public final class IntPair<T>
{
    private final int first;
    private final T second;
    
    public IntPair(final int first, final T second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = false;
        boolean b2;
        if (this == o) {
            b2 = true;
        }
        else {
            b2 = b;
            if (o != null) {
                b2 = b;
                if (this.getClass() == o.getClass()) {
                    final IntPair intPair = (IntPair)o;
                    b2 = b;
                    if (this.first == intPair.first) {
                        if (this.second != intPair.second) {
                            b2 = b;
                            if (this.second == null) {
                                return b2;
                            }
                            b2 = b;
                            if (!this.second.equals(intPair.second)) {
                                return b2;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return b2;
    }
    
    public int getFirst() {
        return this.first;
    }
    
    public T getSecond() {
        return this.second;
    }
    
    @Override
    public int hashCode() {
        final int first = this.first;
        int hashCode;
        if (this.second != null) {
            hashCode = this.second.hashCode();
        }
        else {
            hashCode = 0;
        }
        return (first + 679) * 97 + hashCode;
    }
    
    @Override
    public String toString() {
        return "IntPair[" + this.first + ", " + this.second + ']';
    }
}
