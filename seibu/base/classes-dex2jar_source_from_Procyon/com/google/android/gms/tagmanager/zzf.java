// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import android.content.Context;
import com.google.android.gms.internal.zzbf;

final class zzf extends zzbr
{
    private static final String ID;
    private final zza zzbDn;
    
    static {
        ID = zzbf.zzdn.toString();
    }
    
    public zzf(final Context context) {
        this(zza.zzbl(context));
    }
    
    private zzf(final zza zzbDn) {
        super(zzf.ID, new String[0]);
        this.zzbDn = zzbDn;
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzgk.zzI(!this.zzbDn.isLimitAdTrackingEnabled());
    }
}
