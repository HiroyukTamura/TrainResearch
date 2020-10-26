// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbr;

abstract class zzga extends zzeg
{
    public zzga(final String s) {
        super(s);
    }
    
    @Override
    protected final boolean zza(final com.google.android.gms.internal.zzbr zzbr, final com.google.android.gms.internal.zzbr zzbr2, final Map<String, com.google.android.gms.internal.zzbr> map) {
        final String zzb = zzgk.zzb(zzbr);
        final String zzb2 = zzgk.zzb(zzbr2);
        return zzb != zzgk.zzCg() && zzb2 != zzgk.zzCg() && this.zza(zzb, zzb2, map);
    }
    
    protected abstract boolean zza(final String p0, final String p1, final Map<String, com.google.android.gms.internal.zzbr> p2);
}
