// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzgm extends zzbr
{
    private static final String ID;
    private static final String zzbEH;
    
    static {
        ID = zzbf.zzee.toString();
        zzbEH = zzbg.zzfR.toString();
    }
    
    public zzgm() {
        super(zzgm.ID, new String[] { zzgm.zzbEH });
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzgk.zzI(zzgk.zzb(map.get(zzgm.zzbEH)).toUpperCase());
    }
}
