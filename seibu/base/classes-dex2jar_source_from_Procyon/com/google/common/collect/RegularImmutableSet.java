// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableSet<E> extends ImmutableSet<E>
{
    private final Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    @VisibleForTesting
    final transient Object[] table;
    
    RegularImmutableSet(final Object[] elements, final int hashCode, final Object[] table, final int mask) {
        this.elements = elements;
        this.table = table;
        this.mask = mask;
        this.hashCode = hashCode;
    }
    
    @Override
    public boolean contains(final Object obj) {
        if (obj != null) {
            int smear = Hashing.smear(obj.hashCode());
            while (true) {
                final Object o = this.table[this.mask & smear];
                if (o == null) {
                    return false;
                }
                if (o.equals(obj)) {
                    break;
                }
                ++smear;
            }
            return true;
        }
        return false;
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        System.arraycopy(this.elements, 0, array, n, this.elements.length);
        return this.elements.length + n;
    }
    
    @Override
    ImmutableList<E> createAsList() {
        return new RegularImmutableAsList<E>(this, this.elements);
    }
    
    @Override
    public int hashCode() {
        return this.hashCode;
    }
    
    @Override
    boolean isHashCodeFast() {
        return true;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.forArray((E[])this.elements);
    }
    
    @Override
    public int size() {
        return this.elements.length;
    }
}
