package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.C0553a;
import com.google.ads.mediation.C0555c;
import com.google.ads.mediation.C0562d;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazw;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p029a.C0871a;
import p009e.p028d.p029a.C0873c;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, C0561d>, MediationInterstitialAdapter<CustomEventExtras, C0561d> {
    @VisibleForTesting

    /* renamed from: a */
    private CustomEventBanner f115a;
    @VisibleForTesting

    /* renamed from: b */
    private CustomEventInterstitial f116b;

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    static final class C0556a implements C0559b {
        public C0556a(CustomEventAdapter customEventAdapter, C0555c cVar) {
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    class C0557b implements C0560c {
        public C0557b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, C0562d dVar) {
        }
    }

    /* renamed from: a */
    private static <T> T m55a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(C0681a.m336b(message, C0681a.m336b(str, 46)));
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzazw.zzfc(sb.toString());
            return null;
        }
    }

    public final void destroy() {
        CustomEventBanner customEventBanner = this.f115a;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.f116b;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return null;
    }

    public final Class<C0561d> getServerParametersType() {
        return C0561d.class;
    }

    public final void requestBannerAd(C0555c cVar, Activity activity, C0561d dVar, C0873c cVar2, C0553a aVar, CustomEventExtras customEventExtras) {
        CustomEventBanner customEventBanner = (CustomEventBanner) m55a(dVar.f118b);
        this.f115a = customEventBanner;
        if (customEventBanner == null) {
            cVar.onFailedToReceiveAd(this, C0871a.INTERNAL_ERROR);
            return;
        }
        this.f115a.requestBannerAd(new C0556a(this, cVar), activity, dVar.f117a, dVar.f119c, cVar2, aVar, customEventExtras == null ? null : customEventExtras.getExtra(dVar.f117a));
    }

    public final void requestInterstitialAd(C0562d dVar, Activity activity, C0561d dVar2, C0553a aVar, CustomEventExtras customEventExtras) {
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) m55a(dVar2.f118b);
        this.f116b = customEventInterstitial;
        if (customEventInterstitial == null) {
            dVar.onFailedToReceiveAd(this, C0871a.INTERNAL_ERROR);
            return;
        }
        this.f116b.requestInterstitialAd(new C0557b(this, this, dVar), activity, dVar2.f117a, dVar2.f119c, aVar, customEventExtras == null ? null : customEventExtras.getExtra(dVar2.f117a));
    }

    public final void showInterstitial() {
        this.f116b.showInterstitial();
    }
}
