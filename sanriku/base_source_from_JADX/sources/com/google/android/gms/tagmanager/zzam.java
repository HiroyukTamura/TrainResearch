package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.HashMap;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
final class zzam extends zzbq {

    /* renamed from: ID */
    private static final String f958ID = zza.FUNCTION_CALL.toString();
    private static final String zzadw = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzafl = zzb.FUNCTION_CALL_NAME.toString();
    private final zzan zzafm;

    public zzam(zzan zzan) {
        super(f958ID, zzafl);
        this.zzafm = zzan;
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str;
        String zzc = zzgj.zzc(map.get(zzafl));
        HashMap hashMap = new HashMap();
        zzl zzl = map.get(zzadw);
        if (zzl != null) {
            Object zzh = zzgj.zzh(zzl);
            if (!(zzh instanceof Map)) {
                str = "FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.";
                zzdi.zzac(str);
                return zzgj.zzkc();
            }
            for (Map.Entry entry : ((Map) zzh).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzgj.zzi(this.zzafm.zza(zzc, hashMap));
        } catch (Exception e) {
            String message = e.getMessage();
            str = C0681a.m314a(C0681a.m336b(message, C0681a.m336b(zzc, 34)), "Custom macro/tag ", zzc, " threw exception ", message);
        }
    }

    public final boolean zzgw() {
        return false;
    }
}
