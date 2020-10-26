// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.ListIterator;
import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableList<E> extends ImmutableList<E>
{
    private final transient Object[] array;
    private final transient int offset;
    private final transient int size;
    
    RegularImmutableList(final Object[] array) {
        this(array, 0, array.length);
    }
    
    RegularImmutableList(final Object[] array, final int offset, final int size) {
        this.offset = offset;
        this.size = size;
        this.array = array;
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        System.arraycopy(this.array, this.offset, array, n, this.size);
        return this.size + n;
    }
    
    @Override
    public E get(final int n) {
        Preconditions.checkElementIndex(n, this.size);
        return (E)this.array[this.offset + n];
    }
    
    @Override
    public int indexOf(@Nullable final Object obj) {
        if (obj != null) {
            for (int i = 0; i < this.size; ++i) {
                final int n = i;
                if (this.array[this.offset + i].equals(obj)) {
                    return n;
                }
            }
            return -1;
        }
        return -1;
    }
    
    @Override
    boolean isPartialView() {
        return this.size != this.array.length;
    }
    
    @Override
    public int lastIndexOf(@Nullable final Object obj) {
        if (obj != null) {
            for (int i = this.size - 1; i >= 0; --i) {
                final int n = i;
                if (this.array[this.offset + i].equals(obj)) {
                    return n;
                }
            }
            return -1;
        }
        return -1;
    }
    
    @Override
    public UnmodifiableListIterator<E> listIterator(final int n) {
        return Iterators.forArray(this.array, this.offset, this.size, n);
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    ImmutableList<E> subListUnchecked(final int n, final int n2) {
        return new RegularImmutableList(this.array, this.offset + n, n2 - n);
    }
}
