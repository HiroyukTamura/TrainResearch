package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzatu {
    private final zzatf zzdrj;
    private final Context zzzo;

    public zzatu(Context context, String str) {
        this.zzzo = context.getApplicationContext();
        this.zzdrj = zzvj.zzps().zzc(context, str, new zzalm());
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzdrj.getAdMetadata();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdrj.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzxg zzxg;
        try {
            zzxg = this.zzdrj.zzki();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            zzxg = null;
        }
        return ResponseInfo.zza(zzxg);
    }

    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzate zzqt = this.zzdrj.zzqt();
            if (zzqt == null) {
                return null;
            }
            return new zzatt(zzqt);
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzdrj.isLoaded();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzdrj.zza((zzxa) new zzyw(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdrj.zza((zzxf) new zzyz(onPaidEventListener));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdrj.zza(new zzaua(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.zzdrj.zza((zzatk) new zzatw(rewardedAdCallback));
            this.zzdrj.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.zzdrj.zza((zzatk) new zzatw(rewardedAdCallback));
            this.zzdrj.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzxt zzxt, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzdrj.zza(zzuk.zza(this.zzzo, zzxt), (zzatn) new zzatx(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
