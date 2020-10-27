package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzadp extends NativeContentAd {
    private final VideoController zzcgy = new VideoController();
    private final List<NativeAd.Image> zzcza = new ArrayList();
    private final NativeAd.AdChoicesInfo zzczc;
    private final zzadk zzczd;
    private final zzacx zzcze;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[Catch:{ RemoteException -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzadp(com.google.android.gms.internal.ads.zzadk r6) {
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
            r5.zzczd = r6
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
            com.google.android.gms.internal.ads.zzadk r6 = r5.zzczd     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.internal.ads.zzacs r6 = r6.zzsd()     // Catch:{ RemoteException -> 0x0065 }
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
            r5.zzcze = r2
            com.google.android.gms.internal.ads.zzadk r6 = r5.zzczd     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzack r6 = r6.zzsb()     // Catch:{ RemoteException -> 0x0081 }
            if (r6 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzacp r6 = new com.google.android.gms.internal.ads.zzacp     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzadk r2 = r5.zzczd     // Catch:{ RemoteException -> 0x0081 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadp.<init>(com.google.android.gms.internal.ads.zzadk):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrz */
    public final IObjectWrapper zzjq() {
        try {
            return this.zzczd.zzrz();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzczd.destroy();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzczc;
    }

    public final CharSequence getAdvertiser() {
        try {
            return this.zzczd.getAdvertiser();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getBody() {
        try {
            return this.zzczd.getBody();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzczd.getCallToAction();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.zzczd.getExtras();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzczd.getHeadline();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzcza;
    }

    public final NativeAd.Image getLogo() {
        return this.zzcze;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzczd.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzczd.getVideoController() != null) {
                this.zzcgy.zza(this.zzczd.getVideoController());
            }
        } catch (RemoteException e) {
            zzazw.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcgy;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzczd.performClick(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzczd.recordImpression(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzczd.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
