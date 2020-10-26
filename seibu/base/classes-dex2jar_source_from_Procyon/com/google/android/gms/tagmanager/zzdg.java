// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbr;
import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzdg extends zzdz
{
    private static final String ID;
    
    static {
        ID = zzbf.zzeA.toString();
    }
    
    public zzdg() {
        super(zzdg.ID);
    }
    
    @Override
    protected final boolean zza(final zzgj zzgj, final zzgj zzgj2, final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzgj.zza(zzgj2) < 0;
    }
}
