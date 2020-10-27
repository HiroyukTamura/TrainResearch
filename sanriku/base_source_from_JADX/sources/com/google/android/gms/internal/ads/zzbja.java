package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzbja extends zzwo {
    private final zzazz zzbmo;
    private final zzauu zzboj;
    private final zzcfz zzffo;
    private final zzcnk<zzdhq, zzcos> zzffp;
    private final zzcsz zzffq;
    private final zzciz zzffr;
    private final zzcgb zzffs;
    private final Context zzvf;
    private boolean zzyw = false;

    zzbja(Context context, zzazz zzazz, zzcfz zzcfz, zzcnk<zzdhq, zzcos> zzcnk, zzcsz zzcsz, zzciz zzciz, zzauu zzauu, zzcgb zzcgb) {
        this.zzvf = context;
        this.zzbmo = zzazz;
        this.zzffo = zzcfz;
        this.zzffp = zzcnk;
        this.zzffq = zzcsz;
        this.zzffr = zzciz;
        this.zzboj = zzauu;
        this.zzffs = zzcgb;
    }

    public final String getVersionString() {
        return this.zzbmo.zzbnd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzyw     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)     // Catch:{ all -> 0x005d }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.zzvf     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzzz.initialize(r0)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzawd r0 = com.google.android.gms.ads.internal.zzq.zzla()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.zzvf     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzazz r2 = r3.zzbmo     // Catch:{ all -> 0x005d }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzrx r0 = com.google.android.gms.ads.internal.zzq.zzlc()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.zzvf     // Catch:{ all -> 0x005d }
            r0.initialize(r1)     // Catch:{ all -> 0x005d }
            r0 = 1
            r3.zzyw = r0     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzciz r0 = r3.zzffr     // Catch:{ all -> 0x005d }
            r0.zzaog()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcnc     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzcsz r0 = r3.zzffq     // Catch:{ all -> 0x005d }
            r0.zzand()     // Catch:{ all -> 0x005d }
        L_0x0044:
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzzz.zzcpl     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzcgb r0 = r3.zzffs     // Catch:{ all -> 0x005d }
            r0.zzand()     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r3)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbja.initialize():void");
    }

    public final synchronized void setAppMuted(boolean z) {
        zzq.zzlb().setAppMuted(z);
    }

    public final synchronized void setAppVolume(float f) {
        zzq.zzlb().setAppVolume(f);
    }

    public final void zza(zzahh zzahh) throws RemoteException {
        this.zzffr.zzb(zzahh);
    }

    public final void zza(zzalp zzalp) throws RemoteException {
        this.zzffo.zzb(zzalp);
    }

    public final void zza(zzyy zzyy) throws RemoteException {
        this.zzboj.zza(this.zzvf, zzyy);
    }

    public final void zza(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzzz.initialize(this.zzvf);
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcpm)).booleanValue()) {
            zzq.zzkw();
            str2 = zzaxa.zzbc(this.zzvf);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcpk)).booleanValue() | ((Boolean) zzvj.zzpv().zzd(zzzz.zzclk)).booleanValue();
            zzbjd zzbjd = null;
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzclk)).booleanValue()) {
                booleanValue = true;
                zzbjd = new zzbjd(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            }
            if (booleanValue) {
                zzq.zzle().zza(this.zzvf, this.zzbmo, str, (Runnable) zzbjd);
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzazw.zzfa("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzazw.zzfa("Context is null. Failed to open debug menu.");
            return;
        }
        zzaxr zzaxr = new zzaxr(context);
        zzaxr.setAdUnitId(str);
        zzaxr.zzac(this.zzbmo.zzbnd);
        zzaxr.showDialog();
    }

    public final synchronized void zzcf(String str) {
        zzzz.initialize(this.zzvf);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcpk)).booleanValue()) {
                zzq.zzle().zza(this.zzvf, this.zzbmo, str, (Runnable) null);
            }
        }
    }

    public final void zzcg(String str) {
        this.zzffq.zzgo(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzalk> zzwj = zzq.zzla().zzwb().zzww().zzwj();
        if (zzwj != null && !zzwj.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzazw.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzffo.zzanb()) {
                HashMap hashMap = new HashMap();
                for (zzalk zzalk : zzwj.values()) {
                    for (zzall next : zzalk.zzdes) {
                        String str = next.zzdfx;
                        for (String next2 : next.zzdfp) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzcnl<zzdhq, zzcos> zzf = this.zzffp.zzf(str2, jSONObject);
                        if (zzf != null) {
                            zzdhq zzdhq = (zzdhq) zzf.zzdgp;
                            if (!zzdhq.isInitialized()) {
                                if (zzdhq.zztk()) {
                                    zzdhq.zza(this.zzvf, (zzasy) (zzcos) zzf.zzgel, (List<String>) (List) entry.getValue());
                                    String valueOf = String.valueOf(str2);
                                    zzazw.zzed(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                                }
                            }
                        }
                    } catch (zzdhk e) {
                        StringBuilder sb = new StringBuilder(C0681a.m336b(str2, 56));
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str2);
                        sb.append("\"");
                        zzazw.zzd(sb.toString(), e);
                    }
                }
            }
        }
    }

    public final synchronized float zzqb() {
        return zzq.zzlb().zzqb();
    }

    public final synchronized boolean zzqc() {
        return zzq.zzlb().zzqc();
    }

    public final List<zzaha> zzqd() throws RemoteException {
        return this.zzffr.zzaoh();
    }
}
