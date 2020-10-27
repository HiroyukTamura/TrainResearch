package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzcid implements zzdla {
    private final Clock zzbnt;
    private final Map<zzdkr, Long> zzfzf = new HashMap();
    private final zzchx zzfzg;
    private final Map<zzdkr, zzcic> zzfzh = new HashMap();

    public zzcid(zzchx zzchx, Set<zzcic> set, Clock clock) {
        this.zzfzg = zzchx;
        for (zzcic next : set) {
            this.zzfzh.put(next.zzfze, next);
        }
        this.zzbnt = clock;
    }

    private final void zza(zzdkr zzdkr, boolean z) {
        zzdkr zzb = this.zzfzh.get(zzdkr).zzfzd;
        String str = z ? "s." : "f.";
        if (this.zzfzf.containsKey(zzb)) {
            long elapsedRealtime = this.zzbnt.elapsedRealtime() - this.zzfzf.get(zzb).longValue();
            Map<String, String> zzrm = this.zzfzg.zzrm();
            String valueOf = String.valueOf(this.zzfzh.get(zzdkr).label);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrm.put(concat, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public final void zza(zzdkr zzdkr, String str) {
    }

    public final void zza(zzdkr zzdkr, String str, Throwable th) {
        if (this.zzfzf.containsKey(zzdkr)) {
            long elapsedRealtime = this.zzbnt.elapsedRealtime() - this.zzfzf.get(zzdkr).longValue();
            Map<String, String> zzrm = this.zzfzg.zzrm();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrm.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzfzh.containsKey(zzdkr)) {
            zza(zzdkr, false);
        }
    }

    public final void zzb(zzdkr zzdkr, String str) {
        this.zzfzf.put(zzdkr, Long.valueOf(this.zzbnt.elapsedRealtime()));
    }

    public final void zzc(zzdkr zzdkr, String str) {
        if (this.zzfzf.containsKey(zzdkr)) {
            long elapsedRealtime = this.zzbnt.elapsedRealtime() - this.zzfzf.get(zzdkr).longValue();
            Map<String, String> zzrm = this.zzfzg.zzrm();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzrm.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzfzh.containsKey(zzdkr)) {
            zza(zzdkr, true);
        }
    }
}
