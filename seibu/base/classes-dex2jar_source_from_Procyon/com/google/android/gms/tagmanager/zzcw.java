// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;
import android.content.Context;

final class zzcw extends zzbr
{
    private static final String ID;
    private static final String zzbDo;
    private final Context zzqD;
    
    static {
        ID = zzbf.zzdY.toString();
        zzbDo = zzbg.zzgu.toString();
    }
    
    public zzcw(final Context zzqD) {
        super(zzcw.ID, new String[0]);
        this.zzqD = zzqD;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        String zzb;
        if (map.get(zzcw.zzbDo) != null) {
            zzb = zzgk.zzb(map.get(zzcw.zzbDo));
        }
        else {
            zzb = null;
        }
        final String zzL = zzcx.zzL(this.zzqD, zzb);
        if (zzL != null) {
            return zzgk.zzI(zzL);
        }
        return zzgk.zzCh();
    }
}
