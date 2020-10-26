// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzej extends zzbr
{
    private static final String ID;
    private static final String zzbFN;
    private static final String zzbFO;
    
    static {
        ID = zzbf.zzdL.toString();
        zzbFN = zzbg.zzip.toString();
        zzbFO = zzbg.zzin.toString();
    }
    
    public zzej() {
        super(zzej.ID, new String[0]);
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzej.zzbFN);
        final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzej.zzbFO);
        Label_0118: {
            if (zzbr == null || zzbr == zzgk.zzCh() || zzbr2 == null || zzbr2 == zzgk.zzCh()) {
                break Label_0118;
            }
            final zzgj zzc = zzgk.zzc(zzbr);
            final zzgj zzc2 = zzgk.zzc(zzbr2);
            if (zzc == zzgk.zzCf() || zzc2 == zzgk.zzCf()) {
                break Label_0118;
            }
            final double doubleValue = zzc.doubleValue();
            final double doubleValue2 = zzc2.doubleValue();
            if (doubleValue > doubleValue2) {
                break Label_0118;
            }
            return zzgk.zzI(Math.round((doubleValue2 - doubleValue) * Math.random() + doubleValue));
        }
        final double doubleValue2 = 2.147483647E9;
        final double doubleValue = 0.0;
        return zzgk.zzI(Math.round((doubleValue2 - doubleValue) * Math.random() + doubleValue));
    }
}
