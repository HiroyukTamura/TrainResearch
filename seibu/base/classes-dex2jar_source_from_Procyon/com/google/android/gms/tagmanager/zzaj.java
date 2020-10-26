// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzaj extends zzbr
{
    private static final String ID;
    private final String zzaxs;
    
    static {
        ID = zzbf.zzdv.toString();
    }
    
    public zzaj(final String zzaxs) {
        super(zzaj.ID, new String[0]);
        this.zzaxs = zzaxs;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        if (this.zzaxs == null) {
            return zzgk.zzCh();
        }
        return zzgk.zzI(this.zzaxs);
    }
}
