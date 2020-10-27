package com.google.ads.mediation;

import com.google.ads.mediation.C0563e;

@Deprecated
/* renamed from: com.google.ads.mediation.b */
public interface C0554b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends C0563e> {
    void destroy();

    Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

    Class<SERVER_PARAMETERS> getServerParametersType();
}
