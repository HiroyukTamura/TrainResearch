package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzcdq implements zzaga<Object> {
    private final zzegt<zzcdn> zzfrh;
    private final zzcdt zzftu;
    @Nullable
    private final zzady zzfwd;

    public zzcdq(zzcae zzcae, zzbzx zzbzx, zzcdt zzcdt, zzegt<zzcdn> zzegt) {
        this.zzfwd = zzcae.zzgc(zzbzx.getCustomTemplateId());
        this.zzftu = zzcdt;
        this.zzfrh = zzegt;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zzfwd.zza(this.zzfrh.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(C0681a.m336b(str, 40));
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzazw.zzd(sb.toString(), e);
        }
    }

    public final void zzamo() {
        if (this.zzfwd != null) {
            this.zzftu.zza("/nativeAdCustomClick", (zzaga<Object>) this);
        }
    }
}
