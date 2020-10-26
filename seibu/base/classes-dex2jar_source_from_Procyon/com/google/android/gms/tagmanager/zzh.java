// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.SharedPreferences;
import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;
import android.content.Context;

final class zzh extends zzbr
{
    private static final String ID;
    private static final String zzbDo;
    private static final String zzbDp;
    private final Context zzqD;
    
    static {
        ID = zzbf.zzdT.toString();
        zzbDo = zzbg.zzgu.toString();
        zzbDp = zzbg.zzgx.toString();
    }
    
    public zzh(final Context zzqD) {
        super(zzh.ID, new String[] { zzh.zzbDp });
        this.zzqD = zzqD;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzh.zzbDp);
        if (zzbr == null) {
            return zzgk.zzCh();
        }
        final String zzb = zzgk.zzb(zzbr);
        final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzh.zzbDo);
        String zzb2;
        if (zzbr2 != null) {
            zzb2 = zzgk.zzb(zzbr2);
        }
        else {
            zzb2 = null;
        }
        final Context zzqD = this.zzqD;
        String string;
        if ((string = zzcx.zzbEY.get(zzb)) == null) {
            final SharedPreferences sharedPreferences = zzqD.getSharedPreferences("gtm_click_referrers", 0);
            if (sharedPreferences != null) {
                string = sharedPreferences.getString(zzb, "");
            }
            else {
                string = "";
            }
            zzcx.zzbEY.put(zzb, string);
        }
        final String zzV = zzcx.zzV(string, zzb2);
        if (zzV != null) {
            return zzgk.zzI(zzV);
        }
        return zzgk.zzCh();
    }
}
