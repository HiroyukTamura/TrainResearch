// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.HashMap;
import android.support.v4.util.ArrayMap;
import java.util.HashSet;
import java.util.Collection;
import java.util.Set;
import java.util.Collections;
import java.util.Map;

public final class zzf
{
    public static <K, V> Map<K, V> zza(final K k, final V v, final K i, final V v2) {
        final Map<? extends K, ? extends V> zzg = zzg(2, false);
        zzg.put(k, v);
        zzg.put(i, v2);
        return (Map<K, V>)Collections.unmodifiableMap((Map<?, ?>)zzg);
    }
    
    public static <K, V> Map<K, V> zza(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4, final K m, final V v5, final K k2, final V v6) {
        final Map<? extends K, ? extends V> zzg = zzg(6, false);
        zzg.put(k, v);
        zzg.put(i, v2);
        zzg.put(j, v3);
        zzg.put(l, v4);
        zzg.put(m, v5);
        zzg.put(k2, v6);
        return (Map<K, V>)Collections.unmodifiableMap((Map<?, ?>)zzg);
    }
    
    public static <T> Set<T> zza(final T t, final T t2, final T t3) {
        final Set<? extends T> zzf = zzf(3, false);
        zzf.add(t);
        zzf.add(t2);
        zzf.add(t3);
        return (Set<T>)Collections.unmodifiableSet((Set<?>)zzf);
    }
    
    public static <T> Set<T> zzb(final T... elements) {
        switch (elements.length) {
            default: {
                final Set<? super T> zzf = zzf(elements.length, false);
                Collections.addAll(zzf, elements);
                return Collections.unmodifiableSet((Set<? extends T>)zzf);
            }
            case 0: {
                return Collections.emptySet();
            }
            case 1: {
                return Collections.singleton(elements[0]);
            }
            case 2: {
                final T t = elements[0];
                final T t2 = elements[1];
                final Set<? extends T> zzf2 = zzf(2, false);
                zzf2.add(t);
                zzf2.add(t2);
                return (Set<T>)Collections.unmodifiableSet((Set<?>)zzf2);
            }
            case 3: {
                return zza(elements[0], elements[1], elements[2]);
            }
            case 4: {
                final T t3 = elements[0];
                final T t4 = elements[1];
                final T t5 = elements[2];
                final T t6 = elements[3];
                final Set<? extends T> zzf3 = zzf(4, false);
                zzf3.add(t3);
                zzf3.add(t4);
                zzf3.add(t5);
                zzf3.add(t6);
                return (Set<T>)Collections.unmodifiableSet((Set<?>)zzf3);
            }
        }
    }
    
    private static <T> Set<T> zzf(final int initialCapacity, final boolean b) {
        if (initialCapacity <= 256) {
            return new zza<T>(initialCapacity);
        }
        return new HashSet<T>(initialCapacity, 1.0f);
    }
    
    private static <K, V> Map<K, V> zzg(final int initialCapacity, final boolean b) {
        if (initialCapacity <= 256) {
            return new ArrayMap<K, V>(initialCapacity);
        }
        return new HashMap<K, V>(initialCapacity, 1.0f);
    }
}
