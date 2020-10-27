package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.C0563e;
import com.google.ads.mediation.C0566f;
import p009e.p028d.p029a.C0873c;

@Deprecated
public interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends C0566f, SERVER_PARAMETERS extends C0563e> extends C0554b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    View getBannerView();

    void requestBannerAd(C0555c cVar, Activity activity, SERVER_PARAMETERS server_parameters, C0873c cVar2, C0553a aVar, ADDITIONAL_PARAMETERS additional_parameters);
}
