package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzddf extends zzvy implements zzy, zzbsr, zzrh {
    /* access modifiers changed from: private */
    public final zzazz zzbml;
    private final String zzbsc;
    /* access modifiers changed from: private */
    public final ViewGroup zzfiv;
    private final zzbgy zzggh;
    private final Context zzgiz;
    private AtomicBoolean zzgqi = new AtomicBoolean();
    private final zzdcz zzgqj;
    /* access modifiers changed from: private */
    public final zzddn zzgqk;
    private long zzgql;
    @Nullable
    private zzblc zzgqm;
    @Nullable
    protected zzblr zzgqn;

    public zzddf(zzbgy zzbgy, Context context, String str, zzdcz zzdcz, zzddn zzddn, zzazz zzazz) {
        this.zzfiv = new FrameLayout(context);
        this.zzggh = zzbgy;
        this.zzgiz = context;
        this.zzbsc = str;
        this.zzgqj = zzdcz;
        this.zzgqk = zzddn;
        zzddn.zza((zzbsr) this);
        this.zzbml = zzazz;
    }

    /* access modifiers changed from: private */
    public final zzq zza(zzblr zzblr) {
        boolean zzaap = zzblr.zzaap();
        int intValue = ((Integer) zzvj.zzpv().zzd(zzzz.zzcqp)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = zzaap ? intValue : 0;
        zzp.paddingRight = zzaap ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        return new zzq(this.zzgiz, zzp, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzarf */
    public final void zzari() {
        if (this.zzgqi.compareAndSet(false, true)) {
            zzblr zzblr = this.zzgqn;
            if (!(zzblr == null || zzblr.zzahg() == null)) {
                this.zzgqk.zzb(this.zzgqn.zzahg());
            }
            this.zzgqk.onAdClosed();
            this.zzfiv.removeAllViews();
            zzblc zzblc = this.zzgqm;
            if (zzblc != null) {
                com.google.android.gms.ads.internal.zzq.zzkz().zzb(zzblc);
            }
            zzblr zzblr2 = this.zzgqn;
            if (zzblr2 != null) {
                zzblr2.zzfd(com.google.android.gms.ads.internal.zzq.zzld().elapsedRealtime() - this.zzgql);
            }
            destroy();
        }
    }

    /* access modifiers changed from: private */
    public final zzum zzarg() {
        return zzdhh.zzb(this.zzgiz, Collections.singletonList(this.zzgqn.zzahd()));
    }

    /* access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzblr zzblr) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzblr.zzaap() ? 11 : 9);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzblr zzblr) {
        zzblr.zza((zzrh) this);
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgqn != null) {
            this.zzgqn.destroy();
        }
    }

    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.zzbsc;
    }

    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    public final synchronized zzxl getVideoController() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.zzgqj.isLoading();
    }

    public final boolean isReady() {
        return false;
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final synchronized void zza(zzaas zzaas) {
    }

    public final void zza(zzapq zzapq) {
    }

    public final void zza(zzapw zzapw, String str) {
    }

    public final void zza(zzasn zzasn) {
    }

    public final void zza(zzrn zzrn) {
        this.zzgqk.zzb(zzrn);
    }

    public final synchronized void zza(zzum zzum) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zza(zzut zzut) {
        this.zzgqj.zza(zzut);
    }

    public final void zza(zzvl zzvl) {
    }

    public final void zza(zzvm zzvm) {
    }

    public final void zza(zzwc zzwc) {
    }

    public final void zza(zzwh zzwh) {
    }

    public final synchronized void zza(zzwn zzwn) {
    }

    public final void zza(zzxf zzxf) {
    }

    public final void zza(zzxr zzxr) {
    }

    public final synchronized void zza(zzze zzze) {
    }

    public final synchronized boolean zza(zzuj zzuj) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzq.zzkw();
        if (zzaxa.zzbd(this.zzgiz) && zzuj.zzceu == null) {
            zzazw.zzfa("Failed to load the ad because app ID is missing.");
            this.zzgqk.onAdFailedToLoad(8);
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzgqi = new AtomicBoolean();
            return this.zzgqj.zza(zzuj, this.zzbsc, new zzddk(this), new zzddj(this));
        }
    }

    public final void zzait() {
        if (this.zzgqn != null) {
            this.zzgql = com.google.android.gms.ads.internal.zzq.zzld().elapsedRealtime();
            int zzagv = this.zzgqn.zzagv();
            if (zzagv > 0) {
                zzblc zzblc = new zzblc(this.zzggh.zzacw(), com.google.android.gms.ads.internal.zzq.zzld());
                this.zzgqm = zzblc;
                zzblc.zza(zzagv, new zzddh(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzarh() {
        this.zzggh.zzacv().execute(new zzddi(this));
    }

    public final void zzbn(String str) {
    }

    public final IObjectWrapper zzke() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfiv);
    }

    public final synchronized void zzkf() {
    }

    public final synchronized zzum zzkg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgqn == null) {
            return null;
        }
        return zzdhh.zzb(this.zzgiz, Collections.singletonList(this.zzgqn.zzahd()));
    }

    public final synchronized String zzkh() {
        return null;
    }

    public final synchronized zzxg zzki() {
        return null;
    }

    public final zzwh zzkj() {
        return null;
    }

    public final zzvm zzkk() {
        return null;
    }

    public final void zzms() {
        zzari();
    }

    public final void zzug() {
        zzari();
    }
}
