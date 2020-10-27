package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzaoa extends zzanu {
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdgt;
    private final RtbAdapter zzdhn;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzdho;
    private String zzdhp = "";

    public zzaoa(RtbAdapter rtbAdapter) {
        this.zzdhn = rtbAdapter;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzanq zzanq, zzalv zzalv) {
        return new zzaoh(this, zzanq, zzalv);
    }

    @Nullable
    private static String zza(String str, zzuj zzuj) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzuj.zzacs;
        }
    }

    private static boolean zzc(zzuj zzuj) {
        if (zzuj.zzcej) {
            return true;
        }
        zzvj.zzpr();
        return zzazm.zzyd();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r2.getBundle(r1.zzdhn.getClass().getName());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle zzd(com.google.android.gms.internal.ads.zzuj r2) {
        /*
            r1 = this;
            android.os.Bundle r2 = r2.zzcen
            if (r2 == 0) goto L_0x0015
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r0 = r1.zzdhn
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            android.os.Bundle r2 = r2.getBundle(r0)
            if (r2 == 0) goto L_0x0015
            return r2
        L_0x0015:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoa.zzd(com.google.android.gms.internal.ads.zzuj):android.os.Bundle");
    }

    private static Bundle zzdr(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzazw.zzfc(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzazw.zzc("", e);
            throw new RemoteException();
        }
    }

    public final zzxl getVideoController() {
        RtbAdapter rtbAdapter = this.zzdhn;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzazw.zzc("", th);
            return null;
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzum zzum, zzanw zzanw) throws RemoteException {
        AdFormat adFormat;
        try {
            zzaoe zzaoe = new zzaoe(this, zzanw);
            RtbAdapter rtbAdapter = this.zzdhn;
            char c = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c = 3;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c == 3) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, zzb.zza(zzum.width, zzum.height, zzum.zzacf)), zzaoe);
        } catch (Throwable th) {
            throw C0681a.m305a("Error generating signals for RTB", th);
        }
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanj zzanj, zzalv zzalv, zzum zzum) throws RemoteException {
        zzuj zzuj2 = zzuj;
        zzum zzum2 = zzum;
        try {
            zzaod zzaod = new zzaod(this, zzanj, zzalv);
            RtbAdapter rtbAdapter = this.zzdhn;
            Bundle zzdr = zzdr(str2);
            Bundle zzd = zzd(zzuj2);
            boolean zzc = zzc(zzuj);
            Location location = zzuj2.zzmp;
            int i = zzuj2.zzacq;
            int i2 = zzuj2.zzacr;
            String zza = zza(str2, zzuj);
            AdSize zza2 = zzb.zza(zzum2.width, zzum2.height, zzum2.zzacf);
            String str3 = this.zzdhp;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdr, zzd, zzc, location, i, i2, zza, zza2, str3);
            rtbAdapter.loadBannerAd(mediationBannerAdConfiguration, zzaod);
        } catch (Throwable th) {
            throw C0681a.m305a("Adapter failed to render banner ad.", th);
        }
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzank zzank, zzalv zzalv) throws RemoteException {
        zzuj zzuj2 = zzuj;
        try {
            this.zzdhn.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdr(str2), zzd(zzuj2), zzc(zzuj), zzuj2.zzmp, zzuj2.zzacq, zzuj2.zzacr, zza(str2, zzuj), this.zzdhp), new zzaoc(this, zzank, zzalv));
        } catch (Throwable th) {
            throw C0681a.m305a("Adapter failed to render interstitial ad.", th);
        }
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanp zzanp, zzalv zzalv) throws RemoteException {
        zzuj zzuj2 = zzuj;
        try {
            this.zzdhn.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdr(str2), zzd(zzuj2), zzc(zzuj), zzuj2.zzmp, zzuj2.zzacq, zzuj2.zzacr, zza(str2, zzuj), this.zzdhp), new zzaof(this, zzanp, zzalv));
        } catch (Throwable th) {
            throw C0681a.m305a("Adapter failed to render rewarded ad.", th);
        }
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanq zzanq, zzalv zzalv) throws RemoteException {
        zzuj zzuj2 = zzuj;
        try {
            this.zzdhn.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdr(str2), zzd(zzuj2), zzc(zzuj), zzuj2.zzmp, zzuj2.zzacq, zzuj2.zzacr, zza(str2, zzuj), this.zzdhp), zza(zzanq, zzalv));
        } catch (Throwable th) {
            throw C0681a.m305a("Adapter failed to render rewarded ad.", th);
        }
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzdgt;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzazw.zzc("", th);
            return true;
        }
    }

    public final void zzb(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanq zzanq, zzalv zzalv) throws RemoteException {
        zzuj zzuj2 = zzuj;
        try {
            this.zzdhn.zza(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdr(str2), zzd(zzuj2), zzc(zzuj), zzuj2.zzmp, zzuj2.zzacq, zzuj2.zzacr, zza(str2, zzuj), this.zzdhp), zza(zzanq, zzalv));
        } catch (Throwable th) {
            throw C0681a.m305a("Adapter failed to render rewarded interstitial ad.", th);
        }
    }

    public final void zzdp(String str) {
        this.zzdhp = str;
    }

    public final zzaoj zztn() throws RemoteException {
        return zzaoj.zza(this.zzdhn.getVersionInfo());
    }

    public final zzaoj zzto() throws RemoteException {
        return zzaoj.zza(this.zzdhn.getSDKVersionInfo());
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
    }

    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzdho;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzazw.zzc("", th);
            return true;
        }
    }
}
