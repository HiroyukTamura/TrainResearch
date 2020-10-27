package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzaex extends UnifiedNativeAd {
    private final VideoController zzcgy = new VideoController();
    private final List<NativeAd.Image> zzcza = new ArrayList();
    private final zzacx zzczb;
    private final NativeAd.AdChoicesInfo zzczc;
    private final zzaes zzczj;
    private final List<MuteThisAdReason> zzczk = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[Catch:{ RemoteException -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaex(com.google.android.gms.internal.ads.zzaes r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzcza = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzcgy = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzczk = r1
            r5.zzczj = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x005a }
            if (r6 == 0) goto L_0x005e
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x005a }
        L_0x0027:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x005e
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x005a }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005a }
            if (r3 == 0) goto L_0x004c
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x004c
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005a }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzacs     // Catch:{ RemoteException -> 0x005a }
            if (r4 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzacs r3 = (com.google.android.gms.internal.ads.zzacs) r3     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x0046:
            com.google.android.gms.internal.ads.zzacu r3 = new com.google.android.gms.internal.ads.zzacu     // Catch:{ RemoteException -> 0x005a }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x004c:
            r3 = r1
        L_0x004d:
            if (r3 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzcza     // Catch:{ RemoteException -> 0x005a }
            com.google.android.gms.internal.ads.zzacx r4 = new com.google.android.gms.internal.ads.zzacx     // Catch:{ RemoteException -> 0x005a }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x005a }
            r2.add(r4)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x0027
        L_0x005a:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazw.zzc(r0, r6)
        L_0x005e:
            com.google.android.gms.internal.ads.zzaes r6 = r5.zzczj     // Catch:{ RemoteException -> 0x008d }
            java.util.List r6 = r6.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x008d }
            if (r6 == 0) goto L_0x0091
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x008d }
        L_0x006a:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x008d }
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x008d }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x008d }
            if (r3 == 0) goto L_0x007f
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzww r2 = com.google.android.gms.internal.ads.zzwz.zzg(r2)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x0080
        L_0x007f:
            r2 = r1
        L_0x0080:
            if (r2 == 0) goto L_0x006a
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzczk     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzxb r4 = new com.google.android.gms.internal.ads.zzxb     // Catch:{ RemoteException -> 0x008d }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x008d }
            r3.add(r4)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x006a
        L_0x008d:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazw.zzc(r0, r6)
        L_0x0091:
            com.google.android.gms.internal.ads.zzaes r6 = r5.zzczj     // Catch:{ RemoteException -> 0x009f }
            com.google.android.gms.internal.ads.zzacs r6 = r6.zzsa()     // Catch:{ RemoteException -> 0x009f }
            if (r6 == 0) goto L_0x00a3
            com.google.android.gms.internal.ads.zzacx r2 = new com.google.android.gms.internal.ads.zzacx     // Catch:{ RemoteException -> 0x009f }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x009f }
            goto L_0x00a4
        L_0x009f:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazw.zzc(r0, r6)
        L_0x00a3:
            r2 = r1
        L_0x00a4:
            r5.zzczb = r2
            com.google.android.gms.internal.ads.zzaes r6 = r5.zzczj     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzack r6 = r6.zzsb()     // Catch:{ RemoteException -> 0x00bb }
            if (r6 == 0) goto L_0x00bf
            com.google.android.gms.internal.ads.zzacp r6 = new com.google.android.gms.internal.ads.zzacp     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzaes r2 = r5.zzczj     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzack r2 = r2.zzsb()     // Catch:{ RemoteException -> 0x00bb }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00bb }
            r1 = r6
            goto L_0x00bf
        L_0x00bb:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazw.zzc(r0, r6)
        L_0x00bf:
            r5.zzczc = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaex.<init>(com.google.android.gms.internal.ads.zzaes):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrz */
    public final IObjectWrapper zzjq() {
        try {
            return this.zzczj.zzrz();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zzczj.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzazw.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final void destroy() {
        try {
            this.zzczj.destroy();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zzczj.zzsk();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzczc;
    }

    public final String getAdvertiser() {
        try {
            return this.zzczj.getAdvertiser();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.zzczj.getBody();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zzczj.getCallToAction();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzczj.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
        return new Bundle();
    }

    public final String getHeadline() {
        try {
            return this.zzczj.getHeadline();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzczb;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzcza;
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zzczj.zzsl() != null) {
                return new zzyg(this.zzczj.zzsl());
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzczj.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzczk;
    }

    public final String getPrice() {
        try {
            return this.zzczj.getPrice();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzxg zzxg;
        try {
            zzxg = this.zzczj.zzki();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            zzxg = null;
        }
        return ResponseInfo.zza(zzxg);
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzczj.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zzczj.getStore();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzczj.getVideoController() != null) {
                this.zzcgy.zza(this.zzczj.getVideoController());
            }
        } catch (RemoteException e) {
            zzazw.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcgy;
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzczj.isCustomClickGestureEnabled();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzczj.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzazw.zzfa("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzczj.zza((zzww) null);
            } else if (muteThisAdReason instanceof zzxb) {
                this.zzczj.zza(((zzxb) muteThisAdReason).zzqf());
            } else {
                zzazw.zzfa("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzczj.performClick(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zzczj.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzczj.recordImpression(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzczj.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzczj.zza((zzws) new zzwx(muteThisAdListener));
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzczj.zza((zzxf) new zzyz(onPaidEventListener));
        } catch (RemoteException e) {
            zzazw.zzc("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzczj.zza((zzaer) new zzafh(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzazw.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final Object zzjv() {
        try {
            IObjectWrapper zzsc = this.zzczj.zzsc();
            if (zzsc != null) {
                return ObjectWrapper.unwrap(zzsc);
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }
}
