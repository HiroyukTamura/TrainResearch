package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public final class zzcvz implements zzdak<zzcvx> {
    private final String zzdma;
    private final zzcfz zzgac;
    private final zzdrh zzglk;

    public zzcvz(String str, zzdrh zzdrh, zzcfz zzcfz) {
        this.zzdma = str;
        this.zzglk = zzdrh;
        this.zzgac = zzcfz;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|(1:4)|5|6|(1:8)|9) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e A[Catch:{ zzdhk -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.Bundle zzb(com.google.android.gms.internal.ads.zzdhq r3) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.google.android.gms.internal.ads.zzaoj r1 = r3.zzto()     // Catch:{ zzdhk -> 0x0018 }
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = "sdk_version"
            com.google.android.gms.internal.ads.zzaoj r2 = r3.zzto()     // Catch:{ zzdhk -> 0x0018 }
            java.lang.String r2 = r2.toString()     // Catch:{ zzdhk -> 0x0018 }
            r0.putString(r1, r2)     // Catch:{ zzdhk -> 0x0018 }
        L_0x0018:
            com.google.android.gms.internal.ads.zzaoj r1 = r3.zztn()     // Catch:{ zzdhk -> 0x002b }
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = "adapter_version"
            com.google.android.gms.internal.ads.zzaoj r3 = r3.zztn()     // Catch:{ zzdhk -> 0x002b }
            java.lang.String r3 = r3.toString()     // Catch:{ zzdhk -> 0x002b }
            r0.putString(r1, r3)     // Catch:{ zzdhk -> 0x002b }
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcvz.zzb(com.google.android.gms.internal.ads.zzdhq):android.os.Bundle");
    }

    public final zzdri<zzcvx> zzaqa() {
        if (new BigInteger(this.zzdma).equals(BigInteger.ONE)) {
            if (!zzdok.zzaq((String) zzvj.zzpv().zzd(zzzz.zzcmz))) {
                return this.zzglk.zzd(new zzcwc(this));
            }
        }
        return zzdqw.zzag(new zzcvx(new Bundle()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcvx zzaqc() throws Exception {
        List<String> asList = Arrays.asList(((String) zzvj.zzpv().zzd(zzzz.zzcmz)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                bundle.putBundle(str, zzb(this.zzgac.zzd(str, new JSONObject())));
            } catch (zzdhk unused) {
            }
        }
        return new zzcvx(bundle);
    }
}
