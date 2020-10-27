package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdup {
    public static zzdzd zza(zzdww zzdww) throws GeneralSecurityException {
        int i = zzdus.zzhld[zzdww.ordinal()];
        if (i == 1) {
            return zzdzd.NIST_P256;
        }
        if (i == 2) {
            return zzdzd.NIST_P384;
        }
        if (i == 3) {
            return zzdzd.NIST_P521;
        }
        String valueOf = String.valueOf(zzdww);
        throw new GeneralSecurityException(C0681a.m312a(valueOf.length() + 20, "unknown curve type: ", valueOf));
    }

    public static zzdzg zza(zzdwi zzdwi) throws GeneralSecurityException {
        int i = zzdus.zzhle[zzdwi.ordinal()];
        if (i == 1) {
            return zzdzg.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzdzg.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzdzg.COMPRESSED;
        }
        String valueOf = String.valueOf(zzdwi);
        throw new GeneralSecurityException(C0681a.m312a(valueOf.length() + 22, "unknown point format: ", valueOf));
    }

    public static String zza(zzdwy zzdwy) throws NoSuchAlgorithmException {
        int i = zzdus.zzhlc[zzdwy.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzdwy);
        throw new NoSuchAlgorithmException(C0681a.m312a(valueOf.length() + 27, "hash unsupported for HMAC: ", valueOf));
    }

    public static void zza(zzdwo zzdwo) throws GeneralSecurityException {
        zzdzb.zza(zza(zzdwo.zzazc().zzazp()));
        zza(zzdwo.zzazc().zzazq());
        if (zzdwo.zzaze() != zzdwi.UNKNOWN_FORMAT) {
            zzdsx.zza(zzdwo.zzazd().zzayx());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }
}
