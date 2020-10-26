// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzgf extends zzbr
{
    private static final String ID;
    
    static {
        ID = zzbf.zzdR.toString();
    }
    
    public zzgf() {
        super(zzgf.ID, new String[0]);
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzgk.zzI(System.currentTimeMillis());
    }
}
