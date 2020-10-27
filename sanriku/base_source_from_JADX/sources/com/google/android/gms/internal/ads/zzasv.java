package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzasv implements RewardedVideoAd {
    private final Object lock = new Object();
    @NonNull
    private final zzask zzdrd;
    private final zzasu zzdre = new zzasu((RewardedVideoAdListener) null);
    private String zzdrf;
    private String zzdrg;
    private final Context zzvf;

    public zzasv(Context context, @Nullable zzask zzask) {
        this.zzdrd = zzask == null ? new zzyu() : zzask;
        this.zzvf = context.getApplicationContext();
    }

    private final void zza(String str, zzxt zzxt) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.zza(zzuk.zza(this.zzvf, zzxt, str));
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy() {
        destroy((Context) null);
    }

    public final void destroy(Context context) {
        synchronized (this.lock) {
            this.zzdre.setRewardedVideoAdListener((RewardedVideoAdListener) null);
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.zzl(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    Bundle adMetadata = this.zzdrd.getAdMetadata();
                    return adMetadata;
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzdrg;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzdrd != null) {
                return this.zzdrd.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzxg zzxg = null;
        try {
            if (this.zzdrd != null) {
                zzxg = this.zzdrd.zzki();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzxg);
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzdre.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzdrf;
        }
        return str;
    }

    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzdrd == null) {
                return false;
            }
            try {
                boolean isLoaded = this.zzdrd.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzdq());
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzdq());
    }

    public final void pause() {
        pause((Context) null);
    }

    public final void pause(Context context) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.zzj(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void resume() {
        resume((Context) null);
    }

    public final void resume(Context context) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.zzk(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.zza((zzwc) new zzug(adMetadataListener));
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.setCustomData(str);
                    this.zzdrg = str;
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzdre.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.zza((zzasn) this.zzdre);
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzdrf = str;
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.setUserId(str);
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void show() {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                try {
                    this.zzdrd.show();
                } catch (RemoteException e) {
                    zzazw.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
