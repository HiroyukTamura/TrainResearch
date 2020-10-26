// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import android.content.Context;
import com.google.android.gms.internal.zzbf;

final class zze extends zzbr
{
    private static final String ID;
    private final zza zzbDn;
    
    static {
        ID = zzbf.zzdm.toString();
    }
    
    public zze(final Context context) {
        this(zza.zzbl(context));
    }
    
    private zze(final zza zzbDn) {
        super(zze.ID, new String[0]);
        (this.zzbDn = zzbDn).zzAy();
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final String zzAy = this.zzbDn.zzAy();
        if (zzAy == null) {
            return zzgk.zzCh();
        }
        return zzgk.zzI(zzAy);
    }
}
