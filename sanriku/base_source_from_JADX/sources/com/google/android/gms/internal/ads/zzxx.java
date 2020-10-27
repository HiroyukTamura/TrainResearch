package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzxx {
    private final zzuk zzaca;
    private AppEventListener zzblk;
    private boolean zzbmf;
    private zzvz zzbsb;
    private String zzbsc;
    private final zzalm zzbse;
    private zzub zzceb;
    private AdListener zzcee;
    private AdMetadataListener zzcef;
    private OnCustomRenderedAdLoadedListener zzcha;
    @Nullable
    private OnPaidEventListener zzchd;
    private RewardedVideoAdListener zzchj;
    private boolean zzchk;
    private final Context zzvf;

    public zzxx(Context context) {
        this(context, zzuk.zzcev, (PublisherInterstitialAd) null);
    }

    public zzxx(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzuk.zzcev, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzxx(Context context, zzuk zzuk, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbse = new zzalm();
        this.zzvf = context;
        this.zzaca = zzuk;
    }

    private final void zzcp(String str) {
        if (this.zzbsb == null) {
            throw new IllegalStateException(C0681a.m313a(C0681a.m336b(str, 63), "The ad unit ID must be set on InterstitialAd before ", str, " is called."));
        }
    }

    public final AdListener getAdListener() {
        return this.zzcee;
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzbsb != null) {
                return this.zzbsb.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
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
            zzazw.zze("#008 Must be called on the main UI thread.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcha;
    }

    public final ResponseInfo getResponseInfo() {
        zzxg zzxg = null;
        try {
            if (this.zzbsb != null) {
                zzxg = this.zzbsb.zzki();
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
        return ResponseInfo.zza(zzxg);
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbsb == null) {
                return false;
            }
            return this.zzbsb.isReady();
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbsb == null) {
                return false;
            }
            return this.zzbsb.isLoading();
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzcee = adListener;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzvm) adListener != null ? new zzuf(adListener) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzcef = adMetadataListener;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzwc) adMetadataListener != null ? new zzug(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbsc == null) {
            this.zzbsc = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzblk = appEventListener;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzwh) appEventListener != null ? new zzuq(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbmf = z;
            if (this.zzbsb != null) {
                this.zzbsb.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcha = onCustomRenderedAdLoadedListener;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzaas) onCustomRenderedAdLoadedListener != null ? new zzaax(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
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

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzchj = rewardedVideoAdListener;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzasn) rewardedVideoAdListener != null ? new zzasu(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void show() {
        try {
            zzcp("show");
            this.zzbsb.showInterstitial();
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zza(zzub zzub) {
        try {
            this.zzceb = zzub;
            if (this.zzbsb != null) {
                this.zzbsb.zza((zzvl) zzub != null ? new zzua(zzub) : null);
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zza(zzxt zzxt) {
        try {
            if (this.zzbsb == null) {
                if (this.zzbsc == null) {
                    zzcp("loadAd");
                }
                zzum zzpi = this.zzchk ? zzum.zzpi() : new zzum();
                zzuu zzps = zzvj.zzps();
                Context context = this.zzvf;
                zzvz zzvz = (zzvz) new zzva(zzps, context, zzpi, this.zzbsc, this.zzbse).zzd(context, false);
                this.zzbsb = zzvz;
                if (this.zzcee != null) {
                    zzvz.zza((zzvm) new zzuf(this.zzcee));
                }
                if (this.zzceb != null) {
                    this.zzbsb.zza((zzvl) new zzua(this.zzceb));
                }
                if (this.zzcef != null) {
                    this.zzbsb.zza((zzwc) new zzug(this.zzcef));
                }
                if (this.zzblk != null) {
                    this.zzbsb.zza((zzwh) new zzuq(this.zzblk));
                }
                if (this.zzcha != null) {
                    this.zzbsb.zza((zzaas) new zzaax(this.zzcha));
                }
                if (this.zzchj != null) {
                    this.zzbsb.zza((zzasn) new zzasu(this.zzchj));
                }
                this.zzbsb.zza((zzxf) new zzyz(this.zzchd));
                this.zzbsb.setImmersiveMode(this.zzbmf);
            }
            if (this.zzbsb.zza(zzuk.zza(this.zzvf, zzxt))) {
                this.zzbse.zzf(zzxt.zzqk());
            }
        } catch (RemoteException e) {
            zzazw.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zzd(boolean z) {
        this.zzchk = true;
    }
}
