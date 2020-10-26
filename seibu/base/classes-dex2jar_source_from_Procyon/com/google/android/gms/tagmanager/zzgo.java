// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import com.google.android.gms.internal.zzbr;

final class zzgo
{
    private static zzea<zzbr> zza(final zzea<zzbr> zzea) {
        try {
            return new zzea<zzbr>(zzgk.zzI(zzfC(zzgk.zzb(zzea.getObject()))), zzea.zzBz());
        }
        catch (UnsupportedEncodingException ex) {
            zzdj.zzb("Escape URI: unsupported encoding", ex);
            return zzea;
        }
    }
    
    static zzea<zzbr> zza(zzea<zzbr> zza, final int... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final int j = array[i];
            if (!(zzgk.zzg(zza.getObject()) instanceof String)) {
                zzdj.e("Escaping can only be applied to strings.");
            }
            else {
                switch (j) {
                    default: {
                        zzdj.e(new StringBuilder(39).append("Unsupported Value Escaping: ").append(j).toString());
                        break;
                    }
                    case 12: {
                        zza = zza(zza);
                        break;
                    }
                }
            }
        }
        return zza;
    }
    
    static String zzfC(final String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
    }
}
