package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzbk extends zzbq {

    /* renamed from: ID */
    private static final String f963ID = zza.ENCODE.toString();
    private static final String zzags = zzb.ARG0.toString();
    private static final String zzagt = zzb.NO_PADDING.toString();
    private static final String zzagu = zzb.INPUT_FORMAT.toString();
    private static final String zzagv = zzb.OUTPUT_FORMAT.toString();

    public zzbk() {
        super(f963ID, zzags);
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str;
        byte[] bArr;
        String str2;
        zzl zzl = map.get(zzags);
        if (zzl == null || zzl == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzl);
        zzl zzl2 = map.get(zzagu);
        String zzc2 = zzl2 == null ? "text" : zzgj.zzc(zzl2);
        zzl zzl3 = map.get(zzagv);
        String zzc3 = zzl3 == null ? "base16" : zzgj.zzc(zzl3);
        int i = 2;
        zzl zzl4 = map.get(zzagt);
        if (zzl4 != null && zzgj.zzg(zzl4).booleanValue()) {
            i = 3;
        }
        try {
            if ("text".equals(zzc2)) {
                bArr = zzc.getBytes();
            } else if ("base16".equals(zzc2)) {
                bArr = zzo.decode(zzc);
            } else if ("base64".equals(zzc2)) {
                bArr = Base64.decode(zzc, i);
            } else if ("base64url".equals(zzc2)) {
                bArr = Base64.decode(zzc, i | 8);
            } else {
                String valueOf = String.valueOf(zzc2);
                zzdi.zzav(valueOf.length() != 0 ? "Encode: unknown input format: ".concat(valueOf) : new String("Encode: unknown input format: "));
                return zzgj.zzkc();
            }
            if ("base16".equals(zzc3)) {
                str2 = zzo.encode(bArr);
            } else if ("base64".equals(zzc3)) {
                str2 = Base64.encodeToString(bArr, i);
            } else if ("base64url".equals(zzc3)) {
                str2 = Base64.encodeToString(bArr, i | 8);
            } else {
                String valueOf2 = String.valueOf(zzc3);
                str = valueOf2.length() != 0 ? "Encode: unknown output format: ".concat(valueOf2) : new String("Encode: unknown output format: ");
                zzdi.zzav(str);
                return zzgj.zzkc();
            }
            return zzgj.zzi(str2);
        } catch (IllegalArgumentException unused) {
            str = "Encode: invalid input:";
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
