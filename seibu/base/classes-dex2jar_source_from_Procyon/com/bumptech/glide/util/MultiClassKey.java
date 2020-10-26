// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.util;

public class MultiClassKey
{
    private Class<?> first;
    private Class<?> second;
    
    public MultiClassKey() {
    }
    
    public MultiClassKey(final Class<?> clazz, final Class<?> clazz2) {
        this.set(clazz, clazz2);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final MultiClassKey multiClassKey = (MultiClassKey)o;
            if (!this.first.equals(multiClassKey.first)) {
                return false;
            }
            if (!this.second.equals(multiClassKey.second)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.first.hashCode() * 31 + this.second.hashCode();
    }
    
    public void set(final Class<?> first, final Class<?> second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + '}';
    }
}
