package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

public final class zzctr extends zzvy {
    private final Executor zzfhi;
    private final zzbgy zzggh;
    private final Context zzgiz;
    private final zzdhg zzgja;
    private final zzctp zzgje = new zzctp();
    private final zzcto zzgjg = new zzcto();
    private final zzctk zzgjh = new zzctk();
    @Nullable
    private zzaas zzgjk;
    /* access modifiers changed from: private */
    @Nullable
    public zzdri<zzbws> zzgjl;
    private final zzdez zzgjw = new zzdez(new zzdih());
    /* access modifiers changed from: private */
    @Nullable
    public zzbws zzgjx;
    private boolean zzgjy;

    public zzctr(zzbgy zzbgy, Context context, zzum zzum, String str) {
        zzdhg zzdhg = new zzdhg();
        this.zzgja = zzdhg;
        this.zzgjy = false;
        this.zzggh = zzbgy;
        zzdhg.zzd(zzum).zzgr(str);
        this.zzfhi = zzbgy.zzacv();
        this.zzgiz = context;
    }

    private final synchronized boolean zzapm() {
        return this.zzgjx != null && !this.zzgjx.isClosed();
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgjx != null) {
            this.zzgjx.zzahz().zzbz((Context) null);
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.zzgja.zzasa();
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgjx == null || this.zzgjx.zzaia() == null) {
            return null;
        }
        return this.zzgjx.zzaia().getMediationAdapterClassName();
    }

    public final zzxl getVideoController() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.zzgjl != null && !this.zzgjl.isDone();
    }

    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzapm();
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgjx != null) {
            this.zzgjx.zzahz().zzbx((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgjx != null) {
            this.zzgjx.zzahz().zzby((Context) null);
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgjy = z;
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgja.zzbp(z);
    }

    public final void setUserId(String str) {
    }

    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzgjx != null) {
            this.zzgjx.zzbi(this.zzgjy);
        }
    }

    public final void stopLoading() {
    }

    public final synchronized void zza(zzaas zzaas) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgjk = zzaas;
    }

    public final void zza(zzapq zzapq) {
    }

    public final void zza(zzapw zzapw, String str) {
    }

    public final void zza(zzasn zzasn) {
        this.zzgjw.zzb(zzasn);
    }

    public final void zza(zzrn zzrn) {
    }

    public final void zza(zzum zzum) {
    }

    public final void zza(zzut zzut) {
    }

    public final void zza(zzvl zzvl) {
    }

    public final void zza(zzvm zzvm) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgje.zzc(zzvm);
    }

    public final void zza(zzwc zzwc) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zza(zzwh zzwh) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgjg.zzb(zzwh);
    }

    public final synchronized void zza(zzwn zzwn) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgja.zzc(zzwn);
    }

    public final void zza(zzxf zzxf) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzgjh.zzb(zzxf);
    }

    public final void zza(zzxr zzxr) {
    }

    public final synchronized void zza(zzze zzze) {
        this.zzgja.zzc(zzze);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0108, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.android.gms.internal.ads.zzuj r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x0109 }
            android.content.Context r0 = r4.zzgiz     // Catch:{ all -> 0x0109 }
            boolean r0 = com.google.android.gms.internal.ads.zzaxa.zzbd(r0)     // Catch:{ all -> 0x0109 }
            r1 = 0
            if (r0 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzud r0 = r5.zzceu     // Catch:{ all -> 0x0109 }
            if (r0 != 0) goto L_0x0028
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzazw.zzfa(r5)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzctp r5 = r4.zzgje     // Catch:{ all -> 0x0109 }
            if (r5 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzctp r5 = r4.zzgje     // Catch:{ all -> 0x0109 }
            r0 = 8
            r5.onAdFailedToLoad(r0)     // Catch:{ all -> 0x0109 }
        L_0x0026:
            monitor-exit(r4)
            return r1
        L_0x0028:
            com.google.android.gms.internal.ads.zzdri<com.google.android.gms.internal.ads.zzbws> r0 = r4.zzgjl     // Catch:{ all -> 0x0109 }
            if (r0 != 0) goto L_0x0107
            boolean r0 = r4.zzapm()     // Catch:{ all -> 0x0109 }
            if (r0 == 0) goto L_0x0034
            goto L_0x0107
        L_0x0034:
            android.content.Context r0 = r4.zzgiz     // Catch:{ all -> 0x0109 }
            boolean r1 = r5.zzcej     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdhn.zze(r0, r1)     // Catch:{ all -> 0x0109 }
            r0 = 0
            r4.zzgjx = r0     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdhg r0 = r4.zzgja     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdhg r5 = r0.zzh((com.google.android.gms.internal.ads.zzuj) r5)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdhe r5 = r5.zzasc()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r0 = new com.google.android.gms.internal.ads.zzbuj$zza     // Catch:{ all -> 0x0109 }
            r0.<init>()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdez r1 = r4.zzgjw     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzdez r1 = r4.zzgjw     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r2 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r2 = r2.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r1 = r0.zza((com.google.android.gms.internal.ads.zzbqx) r1, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdez r2 = r4.zzgjw     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r3 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r3 = r3.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r1 = r1.zza((com.google.android.gms.internal.ads.zzbsm) r2, (java.util.concurrent.Executor) r3)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdez r2 = r4.zzgjw     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r3 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r3 = r3.zzacv()     // Catch:{ all -> 0x0109 }
            r1.zza((com.google.android.gms.internal.ads.zzbrc) r2, (java.util.concurrent.Executor) r3)     // Catch:{ all -> 0x0109 }
        L_0x0074:
            com.google.android.gms.internal.ads.zzbgy r1 = r4.zzggh     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbxq r1 = r1.zzadf()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbqj$zza r2 = new com.google.android.gms.internal.ads.zzbqj$zza     // Catch:{ all -> 0x0109 }
            r2.<init>()     // Catch:{ all -> 0x0109 }
            android.content.Context r3 = r4.zzgiz     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbqj$zza r2 = r2.zzcb(r3)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbqj$zza r5 = r2.zza((com.google.android.gms.internal.ads.zzdhe) r5)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbqj r5 = r5.zzair()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbxq r5 = r1.zzd((com.google.android.gms.internal.ads.zzbqj) r5)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzctp r1 = r4.zzgje     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r2 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r2 = r2.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r0 = r0.zza((com.google.android.gms.internal.ads.zzbqx) r1, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzctp r1 = r4.zzgje     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r2 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r2 = r2.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r0 = r0.zza((com.google.android.gms.internal.ads.zzbsm) r1, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzctp r1 = r4.zzgje     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r2 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r2 = r2.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r0 = r0.zza((com.google.android.gms.internal.ads.zzbrc) r1, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzctp r1 = r4.zzgje     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r2 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r2 = r2.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r0 = r0.zza((com.google.android.gms.internal.ads.zzub) r1, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzcto r1 = r4.zzgjg     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r2 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r2 = r2.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r0 = r0.zza((com.google.android.gms.ads.doubleclick.AppEventListener) r1, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzctk r1 = r4.zzgjh     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbgy r2 = r4.zzggh     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r2 = r2.zzacv()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj$zza r0 = r0.zza((com.google.android.gms.internal.ads.zzbtb) r1, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbuj r0 = r0.zzajm()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbxq r5 = r5.zzd((com.google.android.gms.internal.ads.zzbuj) r0)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzcsm r0 = new com.google.android.gms.internal.ads.zzcsm     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzaas r1 = r4.zzgjk     // Catch:{ all -> 0x0109 }
            r0.<init>(r1)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbxq r5 = r5.zzb(r0)     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzbxr r5 = r5.zzafm()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzboq r0 = r5.zzaed()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdri r0 = r0.zzaii()     // Catch:{ all -> 0x0109 }
            r4.zzgjl = r0     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzctq r1 = new com.google.android.gms.internal.ads.zzctq     // Catch:{ all -> 0x0109 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Executor r5 = r4.zzfhi     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.ads.zzdqw.zza(r0, r1, r5)     // Catch:{ all -> 0x0109 }
            r5 = 1
            monitor-exit(r4)
            return r5
        L_0x0107:
            monitor-exit(r4)
            return r1
        L_0x0109:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzctr.zza(com.google.android.gms.internal.ads.zzuj):boolean");
    }

    public final void zzbn(String str) {
    }

    public final IObjectWrapper zzke() {
        return null;
    }

    public final void zzkf() {
    }

    public final zzum zzkg() {
        return null;
    }

    public final synchronized String zzkh() {
        if (this.zzgjx == null || this.zzgjx.zzaia() == null) {
            return null;
        }
        return this.zzgjx.zzaia().getMediationAdapterClassName();
    }

    public final synchronized zzxg zzki() {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcua)).booleanValue()) {
            return null;
        }
        if (this.zzgjx == null) {
            return null;
        }
        return this.zzgjx.zzaia();
    }

    public final zzwh zzkj() {
        return this.zzgjg.zzapk();
    }

    public final zzvm zzkk() {
        return this.zzgje.zzapl();
    }
}
