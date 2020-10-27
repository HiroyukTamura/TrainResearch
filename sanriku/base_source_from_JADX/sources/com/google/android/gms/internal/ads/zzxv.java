package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzxv {
    private final zzuk zzaca;
    private VideoOptions zzblb;
    private boolean zzbli;
    private AppEventListener zzblk;
    private zzvz zzbsb;
    private String zzbsc;
    private final zzalm zzbse;
    private zzub zzceb;
    private AdListener zzcee;
    private AdSize[] zzcfn;
    private final AtomicBoolean zzcgx;
    /* access modifiers changed from: private */
    public final VideoController zzcgy;
    @VisibleForTesting
    private final zzvi zzcgz;
    private OnCustomRenderedAdLoadedListener zzcha;
    private ViewGroup zzchb;
    private int zzchc;
    @Nullable
    private OnPaidEventListener zzchd;

    public zzxv(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzuk.zzcev, 0);
    }

    public zzxv(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzuk.zzcev, i);
    }

    public zzxv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzuk.zzcev, 0);
    }

    public zzxv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzuk.zzcev, i);
    }

    @VisibleForTesting
    private zzxv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzuk zzuk, int i) {
        this(viewGroup, attributeSet, z, zzuk, (zzvz) null, i);
    }

    @VisibleForTesting
    private zzxv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzuk zzuk, zzvz zzvz, int i) {
        zzum zzum;
        this.zzbse = new zzalm();
        this.zzcgy = new VideoController();
        this.zzcgz = new zzxu(this);
        this.zzchb = viewGroup;
        this.zzaca = zzuk;
        this.zzbsb = null;
        this.zzcgx = new AtomicBoolean(false);
        this.zzchc = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzuv zzuv = new zzuv(context, attributeSet);
                this.zzcfn = zzuv.zzy(z);
                this.zzbsc = zzuv.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzazm zzpr = zzvj.zzpr();
                    AdSize adSize = this.zzcfn[0];
                    int i2 = this.zzchc;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzum = zzum.zzpk();
                    } else {
                        zzum zzum2 = new zzum(context, adSize);
                        zzum2.zzcez = zzcv(i2);
                        zzum = zzum2;
                    }
                    zzpr.zza(viewGroup, zzum, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzvj.zzpr().zza(viewGroup, new zzum(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzum zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzum.zzpk();
            }
        }
        zzum zzum = new zzum(context, adSizeArr);
        zzum.zzcez = zzcv(i);
        return zzum;
    }

    private static boolean zzcv(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            if (this.zzbsb != null) {
                this.zzbsb.destroy();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcee;
    }

    public final AdSize getAdSize() {
        zzum zzkg;
        try {
            if (!(this.zzbsb == null || (zzkg = this.zzbsb.zzkg()) == null)) {
                return zzkg.zzpl();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzcfn;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzcfn;
    }

    public final String getAdUnitId() {
        zzvz zzvz;
        if (this.zzbsc == null && (zzvz = this.zzbsb) != null) {
            try {
                this.zzbsc = zzvz.getAdUnitId();
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
        return this.zzbsc;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzblk;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbsb != null) {
                return this.zzbsb.zzkh();
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcha;
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzxg zzxg = null;
        try {
            if (this.zzbsb != null) {
                zzxg = this.zzbsb.zzki();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzxg);
    }

    public final VideoController getVideoController() {
        return this.zzcgy;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzblb;
    }

    public final boolean isLoading() {
        try {
            if (this.zzbsb != null) {
                return this.zzbsb.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void pause() {
        try {
            if (this.zzbsb != null) {
                this.zzbsb.pause();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.zzcgx.getAndSet(true)) {
            try {
                if (this.zzbsb != null) {
                    this.zzbsb.zzkf();
                }
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            if (this.zzbsb != null) {
                this.zzbsb.resume();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcee = adListener;
        this.zzcgz.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzcfn == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void setAdUnitId(String str) {
        if (this.zzbsc == null) {
            this.zzbsc = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzblk = appEventListener;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzwh) appEventListener != null ? new zzuq(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbli = z;
        try {
            if (this.zzbsb != null) {
                this.zzbsb.setManualImpressionsEnabled(z);
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcha = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzaas) onCustomRenderedAdLoadedListener != null ? new zzaax(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzchd = onPaidEventListener;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzxf) new zzyz(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzblb = videoOptions;
        try {
            if (this.zzbsb != null) {
                this.zzbsb.zza(videoOptions == null ? null : new zzze(videoOptions));
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzub zzub) {
        try {
            this.zzceb = zzub;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzvl) zzub != null ? new zzua(zzub) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzxt zzxt) {
        Object zzd;
        try {
            if (this.zzbsb == null) {
                if ((this.zzcfn == null || this.zzbsc == null) && this.zzbsb == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzchb.getContext();
                zzum zza = zza(context, this.zzcfn, this.zzchc);
                if ("search_v2".equals(zza.zzacf)) {
                    zzd = new zzvb(zzvj.zzps(), context, zza, this.zzbsc).zzd(context, false);
                } else {
                    zzd = new zzux(zzvj.zzps(), context, zza, this.zzbsc, this.zzbse).zzd(context, false);
                }
                zzvz zzvz = (zzvz) zzd;
                this.zzbsb = zzvz;
                zzvz.zza((zzvm) new zzuf(this.zzcgz));
                if (this.zzceb != null) {
                    this.zzbsb.zza((zzvl) new zzua(this.zzceb));
                }
                if (this.zzblk != null) {
                    this.zzbsb.zza((zzwh) new zzuq(this.zzblk));
                }
                if (this.zzcha != null) {
                    this.zzbsb.zza((zzaas) new zzaax(this.zzcha));
                }
                if (this.zzblb != null) {
                    this.zzbsb.zza(new zzze(this.zzblb));
                }
                this.zzbsb.zza((zzxf) new zzyz(this.zzchd));
                this.zzbsb.setManualImpressionsEnabled(this.zzbli);
                try {
                    IObjectWrapper zzke = this.zzbsb.zzke();
                    if (zzke != null) {
                        this.zzchb.addView((View) ObjectWrapper.unwrap(zzke));
                    }
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.zzbsb.zza(zzuk.zza(this.zzchb.getContext(), zzxt))) {
                this.zzbse.zzf(zzxt.zzqk());
            }
        } catch (RemoteException e2) {
            zzazw.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzcfn = adSizeArr;
        try {
            if (this.zzbsb != null) {
                this.zzbsb.zza(zza(this.zzchb.getContext(), this.zzcfn, this.zzchc));
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        this.zzchb.requestLayout();
    }

    public final boolean zza(zzvz zzvz) {
        if (zzvz == null) {
            return false;
        }
        try {
            IObjectWrapper zzke = zzvz.zzke();
            if (zzke == null || ((View) ObjectWrapper.unwrap(zzke)).getParent() != null) {
                return false;
            }
            this.zzchb.addView((View) ObjectWrapper.unwrap(zzke));
            this.zzbsb = zzvz;
            return true;
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final zzxl zzdu() {
        zzvz zzvz = this.zzbsb;
        if (zzvz == null) {
            return null;
        }
        try {
            return zzvz.getVideoController();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
