// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.util.LruCache;

final class zzdd extends LruCache<Object, Object>
{
    private /* synthetic */ zzs zzbFn;
    
    zzdd(final zzdc zzdc, final int n, final zzs zzbFn) {
        this.zzbFn = zzbFn;
        super(n);
    }
    
    protected final int sizeOf(final Object o, final Object o2) {
        return this.zzbFn.sizeOf(o, o2);
    }
}
