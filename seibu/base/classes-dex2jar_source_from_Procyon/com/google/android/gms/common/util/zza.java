// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.Iterator;
import android.support.v4.util.SimpleArrayMap;
import java.util.Collection;
import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;

@Deprecated
public final class zza<E> extends AbstractSet<E>
{
    private final ArrayMap<E, E> zzaJC;
    
    public zza() {
        this.zzaJC = new ArrayMap<E, E>();
    }
    
    public zza(final int n) {
        this.zzaJC = new ArrayMap<E, E>(n);
    }
    
    @Override
    public final boolean add(final E e) {
        if (this.zzaJC.containsKey(e)) {
            return false;
        }
        this.zzaJC.put(e, e);
        return true;
    }
    
    @Override
    public final boolean addAll(final Collection<? extends E> c) {
        if (c instanceof zza) {
            final zza<? extends E> zza = (zza<? extends E>)c;
            final int size = this.size();
            this.zzaJC.putAll((SimpleArrayMap<?, ?>)zza.zzaJC);
            return this.size() > size;
        }
        return super.addAll(c);
    }
    
    @Override
    public final void clear() {
        this.zzaJC.clear();
    }
    
    @Override
    public final boolean contains(final Object o) {
        return this.zzaJC.containsKey(o);
    }
    
    @Override
    public final Iterator<E> iterator() {
        return this.zzaJC.keySet().iterator();
    }
    
    @Override
    public final boolean remove(final Object o) {
        if (!this.zzaJC.containsKey(o)) {
            return false;
        }
        this.zzaJC.remove(o);
        return true;
    }
    
    @Override
    public final int size() {
        return this.zzaJC.size();
    }
}
