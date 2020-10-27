package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaci;
import com.google.android.gms.internal.ads.zzads;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzaey;
import com.google.android.gms.internal.ads.zzafa;
import com.google.android.gms.internal.ads.zzafb;
import com.google.android.gms.internal.ads.zzafc;
import com.google.android.gms.internal.ads.zzafd;
import com.google.android.gms.internal.ads.zzafe;
import com.google.android.gms.internal.ads.zzalm;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzuf;
import com.google.android.gms.internal.ads.zzuk;
import com.google.android.gms.internal.ads.zzum;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvr;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzxt;

public class AdLoader {
    private final zzuk zzaca;
    private final zzvr zzacb;
    private final Context zzvf;

    public static class Builder {
        private final zzvs zzabz;
        private final Context zzvf;

        private Builder(Context context, zzvs zzvs) {
            this.zzvf = context;
            this.zzabz = zzvs;
        }

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzvj.zzps().zzb(context, str, new zzalm()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zzvf, this.zzabz.zzqa());
            } catch (RemoteException e) {
                zzazw.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzabz.zza((zzads) new zzaey(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzazw.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzabz.zza((zzadx) new zzafb(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzazw.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.zzabz.zza(str, new zzafd(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzafa(onCustomClickListener));
            } catch (RemoteException e) {
                zzazw.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzabz.zza(new zzafc(onPublisherAdViewLoadedListener), new zzum(this.zzvf, adSizeArr));
            } catch (RemoteException e) {
                zzazw.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzabz.zza((zzael) new zzafe(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzazw.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzabz.zzb((zzvm) new zzuf(adListener));
            } catch (RemoteException e) {
                zzazw.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder withCorrelator(@NonNull Correlator correlator) {
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzabz.zza(new zzaci(nativeAdOptions));
            } catch (RemoteException e) {
                zzazw.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzabz.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzazw.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzvr zzvr) {
        this(context, zzvr, zzuk.zzcev);
    }

    private AdLoader(Context context, zzvr zzvr, zzuk zzuk) {
        this.zzvf = context;
        this.zzacb = zzvr;
        this.zzaca = zzuk;
    }

    private final void zza(zzxt zzxt) {
        try {
            this.zzacb.zzb(zzuk.zza(this.zzvf, zzxt));
        } catch (RemoteException e) {
            zzazw.zzc("Failed to load ad.", e);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzacb.zzkh();
        } catch (RemoteException e) {
            zzazw.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzacb.isLoading();
        } catch (RemoteException e) {
            zzazw.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdq());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdq());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzacb.zza(zzuk.zza(this.zzvf, adRequest.zzdq()), i);
        } catch (RemoteException e) {
            zzazw.zzc("Failed to load ads.", e);
        }
    }
}
