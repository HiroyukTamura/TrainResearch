// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;

abstract class zzgi extends zzbr
{
    public zzgi(final String s, final String... array) {
        super(s, array);
    }
    
    @Override
    public boolean zzAE() {
        return false;
    }
    
    @Override
    public com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        this.zzq(map);
        return zzgk.zzCh();
    }
    
    public abstract void zzq(final Map<String, com.google.android.gms.internal.zzbr> p0);
}
