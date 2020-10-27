package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzadl extends NativeAppInstallAd {
    private final VideoController zzcgy = new VideoController();
    private final zzadg zzcyz;
    private final List<NativeAd.Image> zzcza = new ArrayList();
    private final zzacx zzczb;
    private final NativeAd.AdChoicesInfo zzczc;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[Catch:{ RemoteException -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzadl(com.google.android.gms.internal.ads.zzadg r6) {
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
            r5.zzcyz = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x0053 }
            if (r6 == 0) goto L_0x0057
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x0053 }
        L_0x0020:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x0053 }
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x0053 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0053 }
            if (r3 == 0) goto L_0x0045
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0053 }
            if (r2 == 0) goto L_0x0045
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x0053 }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzacs     // Catch:{ RemoteException -> 0x0053 }
            if (r4 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzacs r3 = (com.google.android.gms.internal.ads.zzacs) r3     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0046
        L_0x003f:
            com.google.android.gms.internal.ads.zzacu r3 = new com.google.android.gms.internal.ads.zzacu     // Catch:{ RemoteException -> 0x0053 }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0046
        L_0x0045:
            r3 = r1
        L_0x0046:
            if (r3 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzcza     // Catch:{ RemoteException -> 0x0053 }
            com.google.android.gms.internal.ads.zzacx r4 = new com.google.android.gms.internal.ads.zzacx     // Catch:{ RemoteException -> 0x0053 }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x0053 }
            r2.add(r4)     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0020
        L_0x0053:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazw.zzc(r0, r6)
        L_0x0057:
            com.google.android.gms.internal.ads.zzadg r6 = r5.zzcyz     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.internal.ads.zzacs r6 = r6.zzsa()     // Catch:{ RemoteException -> 0x0065 }
            if (r6 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzacx r2 = new com.google.android.gms.internal.ads.zzacx     // Catch:{ RemoteException -> 0x0065 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x006a
        L_0x0065:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazw.zzc(r0, r6)
        L_0x0069:
            r2 = r1
        L_0x006a:
            r5.zzczb = r2
            com.google.android.gms.internal.ads.zzadg r6 = r5.zzcyz     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzack r6 = r6.zzsb()     // Catch:{ RemoteException -> 0x0081 }
            if (r6 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzacp r6 = new com.google.android.gms.internal.ads.zzacp     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzadg r2 = r5.zzcyz     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzack r2 = r2.zzsb()     // Catch:{ RemoteException -> 0x0081 }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x0081 }
            r1 = r6
            goto L_0x0085
        L_0x0081:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzazw.zzc(r0, r6)
        L_0x0085:
            r5.zzczc = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadl.<init>(com.google.android.gms.internal.ads.zzadg):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrz */
    public final IObjectWrapper zzjq() {
        try {
            return this.zzcyz.zzrz();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzcyz.destroy();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzczc;
    }

    public final CharSequence getBody() {
        try {
            return this.zzcyz.getBody();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzcyz.getCallToAction();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.zzcyz.getExtras();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzcyz.getHeadline();
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

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzcyz.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getPrice() {
        try {
            return this.zzcyz.getPrice();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzcyz.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getStore() {
        try {
            return this.zzcyz.getStore();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzcyz.getVideoController() != null) {
                this.zzcgy.zza(this.zzcyz.getVideoController());
            }
        } catch (RemoteException e) {
            zzazw.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcgy;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzcyz.performClick(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzcyz.recordImpression(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzcyz.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
