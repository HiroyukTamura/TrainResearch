package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzciz {
    /* access modifiers changed from: private */
    public final Executor executor;
    private final zzazz zzbml;
    private final Context zzciq;
    private final Executor zzfhi;
    private final ScheduledExecutorService zzfif;
    private boolean zzfzx = false;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public boolean zzfzy = false;
    /* access modifiers changed from: private */
    public final long zzfzz;
    /* access modifiers changed from: private */
    public final zzbaj<Boolean> zzgaa = new zzbaj<>();
    private final WeakReference<Context> zzgab;
    private final zzcfz zzgac;
    /* access modifiers changed from: private */
    public final zzcij zzgad;
    private Map<String, zzaha> zzgae = new ConcurrentHashMap();

    public zzciz(Executor executor2, Context context, WeakReference<Context> weakReference, Executor executor3, zzcfz zzcfz, ScheduledExecutorService scheduledExecutorService, zzcij zzcij, zzazz zzazz) {
        this.zzgac = zzcfz;
        this.zzciq = context;
        this.zzgab = weakReference;
        this.executor = executor3;
        this.zzfif = scheduledExecutorService;
        this.zzfhi = executor2;
        this.zzgad = zzcij;
        this.zzbml = zzazz;
        this.zzfzz = zzq.zzld().elapsedRealtime();
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzgae.put(str, new zzaha(str, z, i, str2));
    }

    private final synchronized zzdri<String> zzaoi() {
        String zzwh = zzq.zzla().zzwb().zzww().zzwh();
        if (!TextUtils.isEmpty(zzwh)) {
            return zzdqw.zzag(zzwh);
        }
        zzbaj zzbaj = new zzbaj();
        zzq.zzla().zzwb().zzb(new zzcja(this, zzbaj));
        return zzbaj;
    }

    /* access modifiers changed from: private */
    public final void zzgj(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzbaj zzbaj = new zzbaj();
                zzdri zza = zzdqw.zza(zzbaj, ((Long) zzvj.zzpv().zzd(zzzz.zzcnh)).longValue(), TimeUnit.SECONDS, this.zzfif);
                this.zzgad.zzgh(next);
                long elapsedRealtime = zzq.zzld().elapsedRealtime();
                Iterator<String> it = keys;
                zzcjc zzcjc = r1;
                zzcjc zzcjc2 = new zzcjc(this, obj, zzbaj, next, elapsedRealtime);
                zza.addListener(zzcjc, this.executor);
                arrayList.add(zza);
                zzcji zzcji = new zzcji(this, obj, next, elapsedRealtime, zzbaj);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzahk(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    this.zzfhi.execute(new zzcje(this, this.zzgac.zzd(next, new JSONObject()), zzcji, arrayList2, next));
                } catch (zzdhk unused2) {
                    try {
                        zzcji.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzazw.zzc("", e);
                    }
                }
                keys = it;
            }
            zzdqw.zzj(arrayList).zza(new zzcjf(this), this.executor);
        } catch (JSONException e2) {
            zzawr.zza("Malformed CLD response", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbaj zzbaj) {
        this.executor.execute(new zzcjh(this, zzbaj));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzazw.zzc("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.onInitializationFailed(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzdhq r2, com.google.android.gms.internal.ads.zzahc r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzgab     // Catch:{ zzdhk -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzdhk -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzdhk -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzciq     // Catch:{ zzdhk -> 0x0011 }
        L_0x000d:
            r2.zza((android.content.Context) r0, (com.google.android.gms.internal.ads.zzahc) r3, (java.util.List<com.google.android.gms.internal.ads.zzahk>) r4)     // Catch:{ zzdhk -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.onInitializationFailed(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzazw.zzc(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzciz.zza(com.google.android.gms.internal.ads.zzdhq, com.google.android.gms.internal.ads.zzahc, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzbaj zzbaj, String str, long j) {
        synchronized (obj) {
            if (!zzbaj.isDone()) {
                zza(str, false, "Timeout.", (int) (zzq.zzld().elapsedRealtime() - j));
                this.zzgad.zzr(str, "timeout");
                zzbaj.set(false);
            }
        }
    }

    public final void zzaog() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcnf)).booleanValue() && !zzabp.zzcxd.get().booleanValue()) {
            if (this.zzbml.zzdzo >= ((Integer) zzvj.zzpv().zzd(zzzz.zzcng)).intValue()) {
                if (!this.zzfzx) {
                    synchronized (this) {
                        if (!this.zzfzx) {
                            this.zzgad.zzaod();
                            this.zzgaa.addListener(new zzcjb(this), this.executor);
                            this.zzfzx = true;
                            zzdri<String> zzaoi = zzaoi();
                            this.zzfif.schedule(new zzcjd(this), ((Long) zzvj.zzpv().zzd(zzzz.zzcni)).longValue(), TimeUnit.SECONDS);
                            zzdqw.zza(zzaoi, new zzcjg(this), this.executor);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        zza("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zzgaa.set(false);
    }

    public final List<zzaha> zzaoh() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzgae.keySet()) {
            zzaha zzaha = this.zzgae.get(next);
            arrayList.add(new zzaha(next, zzaha.zzdbh, zzaha.zzdbi, zzaha.description));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaoj() throws Exception {
        this.zzgaa.set(true);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaok() {
        synchronized (this) {
            if (!this.zzfzy) {
                zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzq.zzld().elapsedRealtime() - this.zzfzz));
                this.zzgaa.setException(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaol() {
        this.zzgad.zzaoe();
    }

    public final void zzb(zzahh zzahh) {
        this.zzgaa.addListener(new zzciy(this, zzahh), this.zzfhi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzahh zzahh) {
        try {
            zzahh.zzd(zzaoh());
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
