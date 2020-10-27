package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzcij {
    @GuardedBy("this")
    private List<Map<String, String>> zzfzo = new ArrayList();
    @GuardedBy("this")
    private boolean zzfzp = false;
    @GuardedBy("this")
    private boolean zzfzq = false;
    private String zzfzr;
    private zzcie zzfzs;

    public zzcij(String str, zzcie zzcie) {
        this.zzfzr = str;
        this.zzfzs = zzcie;
    }

    private final Map<String, String> zzaof() {
        Map<String, String> zzaob = this.zzfzs.zzaob();
        zzaob.put("tms", Long.toString(zzq.zzld().elapsedRealtime(), 10));
        zzaob.put("tid", this.zzfzr);
        return zzaob;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzaod() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcnj     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.zzfzp     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            java.util.Map r0 = r3.zzaof()     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x002e }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzfzo     // Catch:{ all -> 0x002e }
            r1.add(r0)     // Catch:{ all -> 0x002e }
            r0 = 1
            r3.zzfzp = r0     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r3)
            return
        L_0x002e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcij.zzaod():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzaoe() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcnj     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.zzfzq     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0044
            java.util.Map r0 = r3.zzaof()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x0046 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.zzfzo     // Catch:{ all -> 0x0046 }
            r1.add(r0)     // Catch:{ all -> 0x0046 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r0 = r3.zzfzo     // Catch:{ all -> 0x0046 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0046 }
        L_0x002f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0041
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0046 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcie r2 = r3.zzfzs     // Catch:{ all -> 0x0046 }
            r2.zzn(r1)     // Catch:{ all -> 0x0046 }
            goto L_0x002f
        L_0x0041:
            r0 = 1
            r3.zzfzq = r0     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            goto L_0x004a
        L_0x0049:
            throw r0
        L_0x004a:
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcij.zzaoe():void");
    }

    public final synchronized void zzgh(String str) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnj)).booleanValue()) {
            Map<String, String> zzaof = zzaof();
            zzaof.put("action", "adapter_init_started");
            zzaof.put("ancn", str);
            this.zzfzo.add(zzaof);
        }
    }

    public final synchronized void zzgi(String str) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnj)).booleanValue()) {
            Map<String, String> zzaof = zzaof();
            zzaof.put("action", "adapter_init_finished");
            zzaof.put("ancn", str);
            this.zzfzo.add(zzaof);
        }
    }

    public final synchronized void zzr(String str, String str2) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnj)).booleanValue()) {
            Map<String, String> zzaof = zzaof();
            zzaof.put("action", "adapter_init_finished");
            zzaof.put("ancn", str);
            zzaof.put("rqe", str2);
            this.zzfzo.add(zzaof);
        }
    }
}
