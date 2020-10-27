package com.google.ads.mediation;

import android.app.Activity;
import com.google.ads.mediation.C0563e;
import com.google.ads.mediation.C0566f;

@Deprecated
public interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends C0566f, SERVER_PARAMETERS extends C0563e> extends C0554b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    void requestInterstitialAd(C0562d dVar, Activity activity, SERVER_PARAMETERS server_parameters, C0553a aVar, ADDITIONAL_PARAMETERS additional_parameters);

    void showInterstitial();
}
