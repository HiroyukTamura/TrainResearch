// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.util.LruCache;
import android.annotation.TargetApi;

@TargetApi(12)
final class zzdc<K, V> implements zzp<K, V>
{
    private LruCache<K, V> zzbFm;
    
    zzdc(final int n, final zzs<K, V> zzs) {
        this.zzbFm = (LruCache<K, V>)new zzdd(this, 1048576, zzs);
    }
    
    @Override
    public final V get(final K k) {
        return (V)this.zzbFm.get((Object)k);
    }
    
    @Override
    public final void zzf(final K k, final V v) {
        this.zzbFm.put((Object)k, (Object)v);
    }
}
