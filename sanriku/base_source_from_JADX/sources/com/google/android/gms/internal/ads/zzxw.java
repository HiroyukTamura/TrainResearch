package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.List;
import p043jp.reifrontier.gym.RFGDef;

public final class zzxw {
    private static final Object lock = new Object();
    private static zzxw zzche;
    private zzwp zzchf;
    private RewardedVideoAd zzchg;
    @NonNull
    private RequestConfiguration zzchh = new RequestConfiguration.Builder().build();
    private InitializationStatus zzchi;

    private zzxw() {
    }

    private final void zza(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.zzchf.zza(new zzyy(requestConfiguration));
        } catch (RemoteException e) {
            zzazw.zzc("Unable to set request configuration parcel.", e);
        }
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzc(List<zzaha> list) {
        HashMap hashMap = new HashMap();
        for (zzaha next : list) {
            hashMap.put(next.zzdbg, new zzahi(next.zzdbh ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, next.description, next.zzdbi));
        }
        return new zzahl(hashMap);
    }

    public static zzxw zzqq() {
        zzxw zzxw;
        synchronized (lock) {
            if (zzche == null) {
                zzche = new zzxw();
            }
            zzxw = zzche;
        }
        return zzxw;
    }

    public final InitializationStatus getInitializationStatus() {
        Preconditions.checkState(this.zzchf != null, "MobileAds.initialize() must be called prior to getting initialization status.");
        try {
            return this.zzchi != null ? this.zzchi : zzc(this.zzchf.zzqd());
        } catch (RemoteException unused) {
            zzazw.zzfa("Unable to get Initialization status.");
            return null;
        }
    }

    @NonNull
    public final RequestConfiguration getRequestConfiguration() {
        return this.zzchh;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (lock) {
            if (this.zzchg != null) {
                RewardedVideoAd rewardedVideoAd = this.zzchg;
                return rewardedVideoAd;
            }
            zzasv zzasv = new zzasv(context, (zzask) new zzvh(zzvj.zzps(), context, new zzalm()).zzd(context, false));
            this.zzchg = zzasv;
            return zzasv;
        }
    }

    public final String getVersionString() {
        Preconditions.checkState(this.zzchf != null, "MobileAds.initialize() must be called prior to getting version string.");
        try {
            return zzdok.zzhe(this.zzchf.getVersionString());
        } catch (RemoteException e) {
            zzazw.zzc("Unable to get version string.", e);
            return "";
        }
    }

    public final void openDebugMenu(Context context, String str) {
        Preconditions.checkState(this.zzchf != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzchf.zzb(ObjectWrapper.wrap(context), str);
        } catch (RemoteException e) {
            zzazw.zzc("Unable to open debug menu.", e);
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        try {
            this.zzchf.zzcg(cls.getCanonicalName());
        } catch (RemoteException e) {
            zzazw.zzc("Unable to register RtbAdapter", e);
        }
    }

    public final void setAppMuted(boolean z) {
        Preconditions.checkState(this.zzchf != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.zzchf.setAppMuted(z);
        } catch (RemoteException e) {
            zzazw.zzc("Unable to set app mute state.", e);
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        if (this.zzchf == null) {
            z = false;
        }
        Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzchf.setAppVolume(f);
        } catch (RemoteException e) {
            zzazw.zzc("Unable to set app volume.", e);
        }
    }

    public final void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        RequestConfiguration requestConfiguration2 = this.zzchh;
        this.zzchh = requestConfiguration;
        if (this.zzchf != null) {
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zza(requestConfiguration);
            }
        }
    }

    public final void zza(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (lock) {
            if (this.zzchf == null) {
                if (context != null) {
                    try {
                        zzalh.zzte().zzc(context, str);
                        zzwp zzwp = (zzwp) new zzvc(zzvj.zzps(), context).zzd(context, false);
                        this.zzchf = zzwp;
                        if (onInitializationCompleteListener != null) {
                            zzwp.zza((zzahh) new zzyd(this, onInitializationCompleteListener, (zzya) null));
                        }
                        this.zzchf.zza((zzalp) new zzalm());
                        this.zzchf.initialize();
                        this.zzchf.zza(str, ObjectWrapper.wrap(new zzxz(this, context)));
                        if (!(this.zzchh.getTagForChildDirectedTreatment() == -1 && this.zzchh.getTagForUnderAgeOfConsent() == -1)) {
                            zza(this.zzchh);
                        }
                        zzzz.initialize(context);
                        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcrg)).booleanValue() && !getVersionString().endsWith(RFGDef.DEFAULT_GYM_ID)) {
                            zzazw.zzfa("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                            this.zzchi = new zzyb(this);
                            if (onInitializationCompleteListener != null) {
                                zzazm.zzzn.post(new zzxy(this, onInitializationCompleteListener));
                            }
                        }
                    } catch (RemoteException e) {
                        zzazw.zzd("MobileAdsSettingManager initialization failed", e);
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzchi);
    }

    public final float zzqb() {
        zzwp zzwp = this.zzchf;
        if (zzwp == null) {
            return 1.0f;
        }
        try {
            return zzwp.zzqb();
        } catch (RemoteException e) {
            zzazw.zzc("Unable to get app volume.", e);
            return 1.0f;
        }
    }

    public final boolean zzqc() {
        zzwp zzwp = this.zzchf;
        if (zzwp == null) {
            return false;
        }
        try {
            return zzwp.zzqc();
        } catch (RemoteException e) {
            zzazw.zzc("Unable to get app mute state.", e);
            return false;
        }
    }
}
