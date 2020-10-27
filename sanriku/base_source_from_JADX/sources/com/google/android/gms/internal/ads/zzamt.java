package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.C0554b;
import com.google.ads.mediation.C0563e;
import com.google.ads.mediation.C0566f;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p029a.C0873c;

public final class zzamt<NETWORK_EXTRAS extends C0566f, SERVER_PARAMETERS extends C0563e> extends zzalt {
    private final C0554b<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdhg;
    private final NETWORK_EXTRAS zzdhh;

    public zzamt(C0554b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar, NETWORK_EXTRAS network_extras) {
        this.zzdhg = bVar;
        this.zzdhh = network_extras;
    }

    private static boolean zzc(zzuj zzuj) {
        if (zzuj.zzcej) {
            return true;
        }
        zzvj.zzpr();
        return zzazm.zzyd();
    }

    private final SERVER_PARAMETERS zzdn(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                throw C0681a.m305a("", th);
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzdhg.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (C0563e) serverParametersType.newInstance();
        server_parameters.mo9417a(hashMap);
        return server_parameters;
    }

    public final void destroy() throws RemoteException {
        try {
            this.zzdhg.destroy();
        } catch (Throwable th) {
            throw C0681a.m305a("", th);
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final zzxl getVideoController() {
        return null;
    }

    public final boolean isInitialized() {
        return true;
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void showInterstitial() throws RemoteException {
        C0554b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdhg;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzazw.zzed("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdhg).showInterstitial();
        } catch (Throwable th) {
            throw C0681a.m305a("", th);
        }
    }

    public final void showVideo() {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzahc zzahc, List<zzahk> list) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzasy zzasy, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zza(iObjectWrapper, zzuj, str, (String) null, zzalv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzasy zzasy, String str2) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, String str2, zzalv zzalv) throws RemoteException {
        C0554b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdhg;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzazw.zzed("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdhg).requestInterstitialAd(new zzams(zzalv), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzdn(str), zzane.zza(zzuj, zzc(zzuj)), this.zzdhh);
        } catch (Throwable th) {
            throw C0681a.m305a("", th);
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, String str2, zzalv zzalv, zzaci zzaci, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzum zzum, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
        zza(iObjectWrapper, zzum, zzuj, str, (String) null, zzalv);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzum zzum, zzuj zzuj, String str, String str2, zzalv zzalv) throws RemoteException {
        C0873c cVar;
        C0554b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdhg;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzazw.zzed("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdhg;
            zzams zzams = new zzams(zzalv);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            C0563e zzdn = zzdn(str);
            int i = 0;
            C0873c[] cVarArr = {C0873c.f518b, C0873c.f519c, C0873c.f520d, C0873c.f521e, C0873c.f522f, C0873c.f523g};
            while (true) {
                if (i < 6) {
                    if (cVarArr[i].mo20271b() == zzum.width && cVarArr[i].mo20270a() == zzum.height) {
                        cVar = cVarArr[i];
                        break;
                    }
                    i++;
                } else {
                    cVar = new C0873c(zzb.zza(zzum.width, zzum.height, zzum.zzacf));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzams, activity, zzdn, cVar, zzane.zza(zzuj, zzc(zzuj)), this.zzdhh);
        } catch (Throwable th) {
            throw C0681a.m305a("", th);
        }
    }

    public final void zza(zzuj zzuj, String str) {
    }

    public final void zza(zzuj zzuj, String str, String str2) {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzuj zzuj, String str, zzalv zzalv) throws RemoteException {
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final IObjectWrapper zztf() throws RemoteException {
        C0554b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdhg;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzazw.zzfc(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) bVar).getBannerView());
        } catch (Throwable th) {
            throw C0681a.m305a("", th);
        }
    }

    public final zzaly zztg() {
        return null;
    }

    public final zzamd zzth() {
        return null;
    }

    public final Bundle zzti() {
        return new Bundle();
    }

    public final Bundle zztj() {
        return new Bundle();
    }

    public final boolean zztk() {
        return false;
    }

    public final zzado zztl() {
        return null;
    }

    public final zzame zztm() {
        return null;
    }

    public final zzaoj zztn() {
        return null;
    }

    public final zzaoj zzto() {
        return null;
    }
}
