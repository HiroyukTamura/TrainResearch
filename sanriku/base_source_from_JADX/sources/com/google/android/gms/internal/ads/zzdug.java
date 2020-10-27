package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

final class zzdug extends zzdso<zzdsf, zzdwp> {
    zzdug(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) throws GeneralSecurityException {
        zzdwp zzdwp = (zzdwp) obj;
        zzdwo zzaza = zzdwp.zzazh().zzaza();
        zzdwt zzazc = zzaza.zzazc();
        zzdzd zza = zzdup.zza(zzazc.zzazp());
        byte[] byteArray = zzdwp.zzaxn().toByteArray();
        ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(1, byteArray), zzdzb.zza(zza));
        return new zzdyy((ECPrivateKey) zzdzi.zzhry.zzho("EC").generatePrivate(eCPrivateKeySpec), zzazc.zzazr().toByteArray(), zzdup.zza(zzazc.zzazq()), zzdup.zza(zzaza.zzaze()), new zzdur(zzaza.zzazd().zzayx()));
    }
}
