package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class zzgn {
    private static zzdz<zzl> zza(zzdz<zzl> zzdz) {
        try {
            return new zzdz<>(zzgj.zzi(zzbs(zzgj.zzc(zzdz.getObject()))), zzdz.zziu());
        } catch (UnsupportedEncodingException e) {
            zzdi.zza("Escape URI: unsupported encoding", e);
            return zzdz;
        }
    }

    static zzdz<zzl> zza(zzdz<zzl> zzdz, int... iArr) {
        String sb;
        for (int i : iArr) {
            if (!(zzgj.zzh(zzdz.getObject()) instanceof String)) {
                sb = "Escaping can only be applied to strings.";
            } else if (i != 12) {
                StringBuilder sb2 = new StringBuilder(39);
                sb2.append("Unsupported Value Escaping: ");
                sb2.append(i);
                sb = sb2.toString();
            } else {
                zzdz = zza(zzdz);
            }
            zzdi.zzav(sb);
        }
        return zzdz;
    }

    static String zzbs(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }
}
