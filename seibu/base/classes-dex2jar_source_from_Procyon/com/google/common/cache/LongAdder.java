// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.cache;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(emulated = true)
final class LongAdder extends Striped64 implements Serializable, LongAddable
{
    private static final long serialVersionUID = 7249069246863182397L;
    
    public LongAdder() {
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.sum());
    }
    
    @Override
    public void add(final long n) {
        final Cell[] cells = this.cells;
        if (cells == null) {
            final long base = this.base;
            if (this.casBase(base, base + n)) {
                return;
            }
        }
        final boolean b = true;
        final int[] array = LongAdder.threadHashCode.get();
        boolean cas = b;
        if (array != null) {
            cas = b;
            if (cells != null) {
                final int length = cells.length;
                cas = b;
                if (length >= 1) {
                    final Cell cell = cells[length - 1 & array[0]];
                    cas = b;
                    if (cell != null) {
                        final long value = cell.value;
                        cas = cell.cas(value, value + n);
                        if (cas) {
                            return;
                        }
                    }
                }
            }
        }
        this.retryUpdate(n, array, cas);
    }
    
    public void decrement() {
        this.add(-1L);
    }
    
    @Override
    public double doubleValue() {
        return (double)this.sum();
    }
    
    @Override
    public float floatValue() {
        return (float)this.sum();
    }
    
    @Override
    final long fn(final long n, final long n2) {
        return n + n2;
    }
    
    @Override
    public void increment() {
        this.add(1L);
    }
    
    @Override
    public int intValue() {
        return (int)this.sum();
    }
    
    @Override
    public long longValue() {
        return this.sum();
    }
    
    public void reset() {
        this.internalReset(0L);
    }
    
    @Override
    public long sum() {
        long base = this.base;
        final Cell[] cells = this.cells;
        long n = base;
        if (cells != null) {
            final int length = cells.length;
            int n2 = 0;
            while (true) {
                n = base;
                if (n2 >= length) {
                    break;
                }
                final Cell cell = cells[n2];
                long n3 = base;
                if (cell != null) {
                    n3 = base + cell.value;
                }
                ++n2;
                base = n3;
            }
        }
        return n;
    }
    
    public long sumThenReset() {
        long base = this.base;
        final Cell[] cells = this.cells;
        this.base = 0L;
        long n = base;
        if (cells != null) {
            final int length = cells.length;
            int n2 = 0;
            while (true) {
                n = base;
                if (n2 >= length) {
                    break;
                }
                final Cell cell = cells[n2];
                long n3 = base;
                if (cell != null) {
                    n3 = base + cell.value;
                    cell.value = 0L;
                }
                ++n2;
                base = n3;
            }
        }
        return n;
    }
    
    @Override
    public String toString() {
        return Long.toString(this.sum());
    }
}
