// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzdl extends zzbr
{
    private static final String ID;
    private static final String zzbEH;
    
    static {
        ID = zzbf.zzed.toString();
        zzbEH = zzbg.zzfR.toString();
    }
    
    public zzdl() {
        super(zzdl.ID, new String[] { zzdl.zzbEH });
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return zzgk.zzI(zzgk.zzb(map.get(zzdl.zzbEH)).toLowerCase());
    }
}
