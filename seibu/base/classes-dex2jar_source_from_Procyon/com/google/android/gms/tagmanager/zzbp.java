// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzbp extends zzbr
{
    private static final String ID;
    private final zzfc zzbDy;
    
    static {
        ID = zzbf.zzdD.toString();
    }
    
    public zzbp(final zzfc zzbDy) {
        super(zzbp.ID, new String[0]);
        this.zzbDy = zzbDy;
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final String zzBK = this.zzbDy.zzBK();
        if (zzBK == null) {
            return zzgk.zzCh();
        }
        return zzgk.zzI(zzBK);
    }
}
