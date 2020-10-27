package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzefy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaue implements zzaun {
    /* access modifiers changed from: private */
    public static List<Future<Void>> zzdro = Collections.synchronizedList(new ArrayList());
    private final Object lock = new Object();
    private final zzaum zzdon;
    private final zzefy.zzb.C2661zzb zzdrp;
    private final LinkedHashMap<String, zzefy.zzb.zzh.C2667zzb> zzdrq;
    private final List<String> zzdrr = new ArrayList();
    private final List<String> zzdrs = new ArrayList();
    private final zzaup zzdrt;
    @VisibleForTesting
    private boolean zzdru;
    private final zzaus zzdrv;
    private HashSet<String> zzdrw = new HashSet<>();
    private boolean zzdrx = false;
    private boolean zzdry = false;
    private boolean zzdrz = false;
    private final Context zzvf;

    public zzaue(Context context, zzazz zzazz, zzaum zzaum, String str, zzaup zzaup) {
        Preconditions.checkNotNull(zzaum, "SafeBrowsing config is not present.");
        this.zzvf = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdrq = new LinkedHashMap<>();
        this.zzdrt = zzaup;
        this.zzdon = zzaum;
        for (String lowerCase : zzaum.zzdsh) {
            this.zzdrw.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzdrw.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzefy.zzb.C2661zzb zzbhu = zzefy.zzb.zzbhu();
        zzbhu.zzb(zzefy.zzb.zzg.OCTAGON_AD);
        zzbhu.zzhw(str);
        zzbhu.zzhx(str);
        zzefy.zzb.zza.C2660zza zzbhw = zzefy.zzb.zza.zzbhw();
        String str2 = this.zzdon.zzdsd;
        if (str2 != null) {
            zzbhw.zzhz(str2);
        }
        zzbhu.zzb((zzefy.zzb.zza) ((zzecd) zzbhw.zzbet()));
        zzefy.zzb.zzi.zza zzbw = zzefy.zzb.zzi.zzbil().zzbw(Wrappers.packageManager(this.zzvf).isCallerInstantApp());
        String str3 = zzazz.zzbnd;
        if (str3 != null) {
            zzbw.zzie(str3);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzvf);
        if (apkVersion > 0) {
            zzbw.zzft(apkVersion);
        }
        zzbhu.zzb((zzefy.zzb.zzi) ((zzecd) zzbw.zzbet()));
        this.zzdrp = zzbhu;
        this.zzdrv = new zzaus(this.zzvf, this.zzdon.zzdsk, this);
    }

    @Nullable
    private final zzefy.zzb.zzh.C2667zzb zzeb(String str) {
        zzefy.zzb.zzh.C2667zzb zzb;
        synchronized (this.lock) {
            zzb = this.zzdrq.get(str);
        }
        return zzb;
    }

    static final /* synthetic */ Void zzec(String str) {
        return null;
    }

    @VisibleForTesting
    private final zzdri<Void> zzvj() {
        zzdri<Void> zzb;
        if (!((this.zzdru && this.zzdon.zzdsj) || (this.zzdrz && this.zzdon.zzdsi) || (!this.zzdru && this.zzdon.zzdsg))) {
            return zzdqw.zzag(null);
        }
        synchronized (this.lock) {
            for (zzefy.zzb.zzh.C2667zzb zzbet : this.zzdrq.values()) {
                this.zzdrp.zzb((zzefy.zzb.zzh) ((zzecd) zzbet.zzbet()));
            }
            this.zzdrp.zzo(this.zzdrr);
            this.zzdrp.zzp(this.zzdrs);
            if (zzauo.isEnabled()) {
                String url = this.zzdrp.getUrl();
                String zzbhs = this.zzdrp.zzbhs();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbhs).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbhs);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzefy.zzb.zzh next : this.zzdrp.zzbhr()) {
                    sb2.append("    [");
                    sb2.append(next.zzbii());
                    sb2.append("] ");
                    sb2.append(next.getUrl());
                }
                zzauo.zzed(sb2.toString());
            }
            zzdri<String> zza = new zzaym(this.zzvf).zza(1, this.zzdon.zzdse, (Map<String, String>) null, ((zzefy.zzb) ((zzecd) this.zzdrp.zzbet())).toByteArray());
            if (zzauo.isEnabled()) {
                zza.addListener(zzauf.zzdsa, zzbab.zzdzr);
            }
            zzb = zzdqw.zzb(zza, zzaui.zzdsc, (Executor) zzbab.zzdzw);
        }
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bitmap bitmap) {
        zzebd zzbcr = zzeaq.zzbcr();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbcr);
        synchronized (this.lock) {
            this.zzdrp.zzb((zzefy.zzb.zzf) ((zzecd) zzefy.zzb.zzf.zzbig().zzar(zzbcr.zzbce()).zzia("image/png").zzb(zzefy.zzb.zzf.zza.TYPE_CREATIVE).zzbet()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzdrz = r2     // Catch:{ all -> 0x00bd }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzefy$zzb$zzh$zzb> r2 = r6.zzdrq     // Catch:{ all -> 0x00bd }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x0024
            if (r9 != r1) goto L_0x0022
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzefy$zzb$zzh$zzb> r8 = r6.zzdrq     // Catch:{ all -> 0x00bd }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzh$zzb r7 = (com.google.android.gms.internal.ads.zzefy.zzb.zzh.C2667zzb) r7     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzh$zza r8 = com.google.android.gms.internal.ads.zzefy.zzb.zzh.zza.zzhq(r9)     // Catch:{ all -> 0x00bd }
            r7.zzb((com.google.android.gms.internal.ads.zzefy.zzb.zzh.zza) r8)     // Catch:{ all -> 0x00bd }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x0024:
            com.google.android.gms.internal.ads.zzefy$zzb$zzh$zzb r1 = com.google.android.gms.internal.ads.zzefy.zzb.zzh.zzbij()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzh$zza r9 = com.google.android.gms.internal.ads.zzefy.zzb.zzh.zza.zzhq(r9)     // Catch:{ all -> 0x00bd }
            if (r9 == 0) goto L_0x0031
            r1.zzb((com.google.android.gms.internal.ads.zzefy.zzb.zzh.zza) r9)     // Catch:{ all -> 0x00bd }
        L_0x0031:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzefy$zzb$zzh$zzb> r9 = r6.zzdrq     // Catch:{ all -> 0x00bd }
            int r9 = r9.size()     // Catch:{ all -> 0x00bd }
            r1.zzhr(r9)     // Catch:{ all -> 0x00bd }
            r1.zzic(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzd$zzb r9 = com.google.android.gms.internal.ads.zzefy.zzb.zzd.zzbib()     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r2 = r6.zzdrw     // Catch:{ all -> 0x00bd }
            int r2 = r2.size()     // Catch:{ all -> 0x00bd }
            if (r2 <= 0) goto L_0x00ab
            if (r8 == 0) goto L_0x00ab
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00bd }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00bd }
        L_0x0053:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00ab
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00bd }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00bd }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00bd }
            goto L_0x006e
        L_0x006c:
            java.lang.String r3 = ""
        L_0x006e:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x007b
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00bd }
            goto L_0x007d
        L_0x007b:
            java.lang.String r2 = ""
        L_0x007d:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r5 = r6.zzdrw     // Catch:{ all -> 0x00bd }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzefy$zzb$zzc$zza r4 = com.google.android.gms.internal.ads.zzefy.zzb.zzc.zzbhz()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeaq r3 = com.google.android.gms.internal.ads.zzeaq.zzhq(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzc$zza r3 = r4.zzao(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeaq r2 = com.google.android.gms.internal.ads.zzeaq.zzhq(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzc$zza r2 = r3.zzap(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzedo r2 = r2.zzbet()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzecd r2 = (com.google.android.gms.internal.ads.zzecd) r2     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzc r2 = (com.google.android.gms.internal.ads.zzefy.zzb.zzc) r2     // Catch:{ all -> 0x00bd }
            r9.zzb(r2)     // Catch:{ all -> 0x00bd }
            goto L_0x0053
        L_0x00ab:
            com.google.android.gms.internal.ads.zzedo r8 = r9.zzbet()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzecd r8 = (com.google.android.gms.internal.ads.zzecd) r8     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzefy$zzb$zzd r8 = (com.google.android.gms.internal.ads.zzefy.zzb.zzd) r8     // Catch:{ all -> 0x00bd }
            r1.zzb((com.google.android.gms.internal.ads.zzefy.zzb.zzd) r8)     // Catch:{ all -> 0x00bd }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzefy$zzb$zzh$zzb> r8 = r6.zzdrq     // Catch:{ all -> 0x00bd }
            r8.put(r7, r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x00bd:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            goto L_0x00c1
        L_0x00c0:
            throw r7
        L_0x00c1:
            goto L_0x00c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaue.zza(java.lang.String, java.util.Map, int):void");
    }

    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdrv.zzb(strArr).toArray(new String[0]);
    }

    public final void zzdy(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzdrp.zzbhy();
            } else {
                this.zzdrp.zzhy(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzdz(String str) {
        synchronized (this.lock) {
            this.zzdrr.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzea(String str) {
        synchronized (this.lock) {
            this.zzdrs.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzi(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzefy.zzb.zzh.C2667zzb zzeb = zzeb(str);
                            if (zzeb == null) {
                                String valueOf = String.valueOf(str);
                                zzauo.zzed(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzeb.zzid(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zzdru;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzdru = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzabq.zzcxh.get().booleanValue()) {
                    zzazw.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzdqw.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdru) {
            synchronized (this.lock) {
                this.zzdrp.zzb(zzefy.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzvj();
    }

    public final void zzl(View view) {
        if (this.zzdon.zzdsf && !this.zzdry) {
            zzq.zzkw();
            Bitmap zzn = zzaxa.zzn(view);
            if (zzn == null) {
                zzauo.zzed("Failed to capture the webview bitmap.");
                return;
            }
            this.zzdry = true;
            zzaxa.zzc(new zzaud(this, zzn));
        }
    }

    public final zzaum zzvf() {
        return this.zzdon;
    }

    public final boolean zzvg() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdon.zzdsf && !this.zzdry;
    }

    public final void zzvh() {
        this.zzdrx = true;
    }

    public final void zzvi() {
        synchronized (this.lock) {
            zzdri<O> zzb = zzdqw.zzb(this.zzdrt.zza(this.zzvf, this.zzdrq.keySet()), new zzaug(this), (Executor) zzbab.zzdzw);
            zzdri<O> zza = zzdqw.zza(zzb, 10, TimeUnit.SECONDS, zzbab.zzdzu);
            zzdqw.zza(zzb, new zzauh(this, zza), zzbab.zzdzw);
            zzdro.add(zza);
        }
    }
}
