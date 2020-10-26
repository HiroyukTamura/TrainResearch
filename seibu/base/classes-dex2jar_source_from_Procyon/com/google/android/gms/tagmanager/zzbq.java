// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzbk;
import java.util.Map;
import com.google.android.gms.internal.zzbl;

final class zzbq
{
    private static void zza(final DataLayer dataLayer, final zzbl zzbl) {
        final zzbk[] zzkL = zzbl.zzkL;
        for (int length = zzkL.length, i = 0; i < length; ++i) {
            final zzbk zzbk = zzkL[i];
            if (zzbk.key == null) {
                zzdj.zzaT("GaExperimentRandom: No key");
            }
            else {
                Object o = dataLayer.get(zzbk.key);
                Long value;
                if (!(o instanceof Number)) {
                    value = null;
                }
                else {
                    value = ((Number)o).longValue();
                }
                final long zzkF = zzbk.zzkF;
                final long zzkG = zzbk.zzkG;
                if (!zzbk.zzkH || value == null || value < zzkF || value > zzkG) {
                    if (zzkF > zzkG) {
                        zzdj.zzaT("GaExperimentRandom: random range invalid");
                        continue;
                    }
                    o = Math.round(Math.random() * (zzkG - zzkF) + zzkF);
                }
                dataLayer.zzfc(zzbk.key);
                final Map<String, Object> zzn = DataLayer.zzn(zzbk.key, o);
                if (zzbk.zzkI > 0L) {
                    if (!zzn.containsKey("gtm")) {
                        zzn.put("gtm", DataLayer.mapOf("lifetime", zzbk.zzkI));
                    }
                    else {
                        final Object value2 = zzn.get("gtm");
                        if (value2 instanceof Map) {
                            ((Map<String, Long>)value2).put("lifetime", zzbk.zzkI);
                        }
                        else {
                            zzdj.zzaT("GaExperimentRandom: gtm not a map");
                        }
                    }
                }
                dataLayer.push(zzn);
            }
        }
    }
    
    public static void zza(final DataLayer dataLayer, final zzbp zzbp) {
        if (zzbp.zzlz == null) {
            zzdj.zzaT("supplemental missing experimentSupplemental");
            return;
        }
        final zzbr[] zzkK = zzbp.zzlz.zzkK;
        for (int length = zzkK.length, i = 0; i < length; ++i) {
            dataLayer.zzfc(zzgk.zzb(zzkK[i]));
        }
        final zzbr[] zzkJ = zzbp.zzlz.zzkJ;
        for (int length2 = zzkJ.length, j = 0; j < length2; ++j) {
            final Object zzg = zzgk.zzg(zzkJ[j]);
            Map<String, Object> map;
            if (!(zzg instanceof Map)) {
                final String value = String.valueOf(zzg);
                zzdj.zzaT(new StringBuilder(String.valueOf(value).length() + 36).append("value: ").append(value).append(" is not a map value, ignored.").toString());
                map = null;
            }
            else {
                map = (Map<String, Object>)zzg;
            }
            if (map != null) {
                dataLayer.push(map);
            }
        }
        zza(dataLayer, zzbp.zzlz);
    }
}
