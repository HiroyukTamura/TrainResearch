// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbr;

abstract class zzdz extends zzeg
{
    public zzdz(final String s) {
        super(s);
    }
    
    @Override
    protected final boolean zza(final com.google.android.gms.internal.zzbr zzbr, final com.google.android.gms.internal.zzbr zzbr2, final Map<String, com.google.android.gms.internal.zzbr> map) {
        final zzgj zzc = zzgk.zzc(zzbr);
        final zzgj zzc2 = zzgk.zzc(zzbr2);
        return zzc != zzgk.zzCf() && zzc2 != zzgk.zzCf() && this.zza(zzc, zzc2, map);
    }
    
    protected abstract boolean zza(final zzgj p0, final zzgj p1, final Map<String, com.google.android.gms.internal.zzbr> p2);
}
