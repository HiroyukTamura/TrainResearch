package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqj;
import com.google.android.gms.internal.ads.zzbuj;
import java.util.Collections;

public final class zzcti extends zzvy implements zzbti {
    /* access modifiers changed from: private */
    public final ViewGroup zzfiv;
    private final zzbgy zzggh;
    /* access modifiers changed from: private */
    @Nullable
    public zzblx zzgiu;
    private final Context zzgiz;
    private final zzdhg zzgja = new zzdhg();
    private final zzctp zzgje = new zzctp();
    private final zzctm zzgjf = new zzctm();
    private final zzcto zzgjg = new zzcto();
    private final zzctk zzgjh = new zzctk();
    /* access modifiers changed from: private */
    public final zzbte zzgji;
    private zzum zzgjj;
    @Nullable
    private zzaas zzgjk;
    /* access modifiers changed from: private */
    @Nullable
    public zzdri<zzblx> zzgjl;

    public zzcti(zzbgy zzbgy, Context context, zzum zzum, String str) {
        this.zzfiv = new FrameLayout(context);
        this.zzggh = zzbgy;
        this.zzgiz = context;
        this.zzgja.zzd(zzum).zzgr(str);
        zzbte zzacz = zzbgy.zzacz();
        this.zzgji = zzacz;
        zzacz.zza(this, this.zzggh.zzacv());
        this.zzgjj = zzum;
    }

    private final synchronized zzbmt zzb(zzdhe zzdhe) {
        return this.zzggh.zzadc().zzc(new zzbqj.zza().zzcb(this.zzgiz).zza(zzdhe).zzair()).zzc(new zzbuj.zza().zza((zzub) this.zzgje, this.zzggh.zzacv()).zza((zzub) this.zzgjf, this.zzggh.zzacv()).zza((zzbqx) this.zzgje, this.zzggh.zzacv()).zza((zzbsm) this.zzgje, this.zzggh.zzacv()).zza((zzbrc) this.zzgje, this.zzggh.zzacv()).zza((AppEventListener) this.zzgjg, this.zzggh.zzacv()).zza((zzbtb) this.zzgjh, this.zzggh.zzacv()).zzajm()).zza(new zzcsm(this.zzgjk)).zzb(new zzbyl(zzcae.zzfsw, (zzvm) null)).zza(new zzbnp(this.zzgji)).zzb(new zzbls(this.zzfiv)).zzafg();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzg(com.google.android.gms.internal.ads.zzuj r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0081 }
            com.google.android.gms.ads.internal.zzq.zzkw()     // Catch:{ all -> 0x0081 }
            android.content.Context r0 = r3.zzgiz     // Catch:{ all -> 0x0081 }
            boolean r0 = com.google.android.gms.internal.ads.zzaxa.zzbd(r0)     // Catch:{ all -> 0x0081 }
            r1 = 0
            if (r0 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzud r0 = r4.zzceu     // Catch:{ all -> 0x0081 }
            if (r0 != 0) goto L_0x0028
            java.lang.String r4 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzazw.zzfa(r4)     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzctp r4 = r3.zzgje     // Catch:{ all -> 0x0081 }
            if (r4 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzctp r4 = r3.zzgje     // Catch:{ all -> 0x0081 }
            r0 = 8
            r4.onAdFailedToLoad(r0)     // Catch:{ all -> 0x0081 }
        L_0x0026:
            monitor-exit(r3)
            return r1
        L_0x0028:
            com.google.android.gms.internal.ads.zzdri<com.google.android.gms.internal.ads.zzblx> r0 = r3.zzgjl     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r3)
            return r1
        L_0x002e:
            android.content.Context r0 = r3.zzgiz     // Catch:{ all -> 0x0081 }
            boolean r2 = r4.zzcej     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzdhn.zze(r0, r2)     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzdhg r0 = r3.zzgja     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzdhg r4 = r0.zzh((com.google.android.gms.internal.ads.zzuj) r4)     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzdhe r4 = r4.zzasc()     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzaaz<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabp.zzcxf     // Catch:{ all -> 0x0081 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0081 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0081 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0081 }
            r2 = 1
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzdhg r0 = r3.zzgja     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzum r0 = r0.zzkg()     // Catch:{ all -> 0x0081 }
            boolean r0 = r0.zzcfa     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzctp r0 = r3.zzgje     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzctp r4 = r3.zzgje     // Catch:{ all -> 0x0081 }
            r4.onAdFailedToLoad(r2)     // Catch:{ all -> 0x0081 }
            monitor-exit(r3)
            return r1
        L_0x0063:
            com.google.android.gms.internal.ads.zzbmt r4 = r3.zzb((com.google.android.gms.internal.ads.zzdhe) r4)     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzboq r0 = r4.zzaed()     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzdri r0 = r0.zzaii()     // Catch:{ all -> 0x0081 }
            r3.zzgjl = r0     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzctl r1 = new com.google.android.gms.internal.ads.zzctl     // Catch:{ all -> 0x0081 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzbgy r4 = r3.zzggh     // Catch:{ all -> 0x0081 }
            java.util.concurrent.Executor r4 = r4.zzacv()     // Catch:{ all -> 0x0081 }
            com.google.android.gms.internal.ads.zzdqw.zza(r0, r1, r4)     // Catch:{ all -> 0x0081 }
            monitor-exit(r3)
            return r2
        L_0x0081:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcti.zzg(com.google.android.gms.internal.ads.zzuj):boolean");
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgiu != null) {
            this.zzgiu.destroy();
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
        if (this.zzgiu == null || this.zzgiu.zzaia() == null) {
            return null;
        }
        return this.zzgiu.zzaia().getMediationAdapterClassName();
    }

    public final synchronized zzxl getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzgiu == null) {
            return null;
        }
        return this.zzgiu.getVideoController();
    }

    public final synchronized boolean isLoading() {
        return this.zzgjl != null && !this.zzgjl.isDone();
    }

    public final boolean isReady() {
        return false;
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgiu != null) {
            this.zzgiu.zzahz().zzbx((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgiu != null) {
            this.zzgiu.zzahz().zzby((Context) null);
        }
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgja.zzbp(z);
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
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
    }

    public final void zza(zzrn zzrn) {
    }

    public final synchronized void zza(zzum zzum) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzgja.zzd(zzum);
        this.zzgjj = zzum;
        if (this.zzgiu != null) {
            this.zzgiu.zza(this.zzfiv, zzum);
        }
    }

    public final void zza(zzut zzut) {
    }

    public final void zza(zzvl zzvl) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgjf.zzb(zzvl);
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
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzgja.zzc(zzze);
    }

    public final synchronized boolean zza(zzuj zzuj) {
        this.zzgja.zzd(this.zzgjj);
        this.zzgja.zzbo(this.zzgjj.zzcfd);
        return zzg(zzuj);
    }

    public final synchronized void zzaix() {
        boolean z;
        ViewParent parent = this.zzfiv.getParent();
        if (!(parent instanceof View)) {
            z = false;
        } else {
            View view = (View) parent;
            z = zzq.zzkw().zza(view, view.getContext());
        }
        if (z) {
            if (!(this.zzgiu == null || this.zzgiu.zzahi() == null)) {
                this.zzgja.zzd(zzdhh.zzb(this.zzgiz, Collections.singletonList(this.zzgiu.zzahi())));
            }
            zzg(this.zzgja.zzarz());
            return;
        }
        this.zzgji.zzdp(60);
    }

    public final void zzbn(String str) {
    }

    public final IObjectWrapper zzke() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfiv);
    }

    public final synchronized void zzkf() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzgiu != null) {
            this.zzgiu.zzkf();
        }
    }

    public final synchronized zzum zzkg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgiu != null) {
            return zzdhh.zzb(this.zzgiz, Collections.singletonList(this.zzgiu.zzahd()));
        }
        return this.zzgja.zzkg();
    }

    public final synchronized String zzkh() {
        if (this.zzgiu == null || this.zzgiu.zzaia() == null) {
            return null;
        }
        return this.zzgiu.zzaia().getMediationAdapterClassName();
    }

    public final synchronized zzxg zzki() {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcua)).booleanValue()) {
            return null;
        }
        if (this.zzgiu == null) {
            return null;
        }
        return this.zzgiu.zzaia();
    }

    public final zzwh zzkj() {
        return this.zzgjg.zzapk();
    }

    public final zzvm zzkk() {
        return this.zzgje.zzapl();
    }
}
