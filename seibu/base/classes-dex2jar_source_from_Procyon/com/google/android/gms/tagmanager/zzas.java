// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzas extends zzbr
{
    private static final String ID;
    private static final String NAME;
    private static final String zzbEm;
    private final DataLayer zzbDx;
    
    static {
        ID = zzbf.zzdu.toString();
        NAME = zzbg.zzir.toString();
        zzbEm = zzbg.zzgW.toString();
    }
    
    public zzas(final DataLayer zzbDx) {
        super(zzas.ID, new String[] { zzas.NAME });
        this.zzbDx = zzbDx;
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final Object value = this.zzbDx.get(zzgk.zzb(map.get(zzas.NAME)));
        if (value != null) {
            return zzgk.zzI(value);
        }
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzas.zzbEm);
        if (zzbr != null) {
            return zzbr;
        }
        return zzgk.zzCh();
    }
}
