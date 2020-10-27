package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

final class zzbv extends zzbq {

    /* renamed from: ID */
    private static final String f970ID = zza.HASH.toString();
    private static final String zzags = zzb.ARG0.toString();
    private static final String zzagu = zzb.INPUT_FORMAT.toString();
    private static final String zzagx = zzb.ALGORITHM.toString();

    public zzbv() {
        super(f970ID, zzags);
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str;
        byte[] bArr;
        zzl zzl = map.get(zzags);
        if (zzl == null || zzl == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzl);
        zzl zzl2 = map.get(zzagx);
        String zzc2 = zzl2 == null ? "MD5" : zzgj.zzc(zzl2);
        zzl zzl3 = map.get(zzagu);
        String zzc3 = zzl3 == null ? "text" : zzgj.zzc(zzl3);
        if ("text".equals(zzc3)) {
            bArr = zzc.getBytes();
        } else if ("base16".equals(zzc3)) {
            bArr = zzo.decode(zzc);
        } else {
            String valueOf = String.valueOf(zzc3);
            str = valueOf.length() != 0 ? "Hash: unknown input format: ".concat(valueOf) : new String("Hash: unknown input format: ");
            zzdi.zzav(str);
            return zzgj.zzkc();
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(zzc2);
            instance.update(bArr);
            return zzgj.zzi(zzo.encode(instance.digest()));
        } catch (NoSuchAlgorithmException unused) {
            String valueOf2 = String.valueOf(zzc2);
            str = valueOf2.length() != 0 ? "Hash: unknown algorithm: ".concat(valueOf2) : new String("Hash: unknown algorithm: ");
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
