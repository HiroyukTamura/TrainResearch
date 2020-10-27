package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.C0616d;
import com.google.android.datatransport.runtime.backends.C0622h;
import com.google.android.datatransport.runtime.backends.C0628m;

@Keep
public class CctBackendFactory implements C0616d {
    public C0628m create(C0622h hVar) {
        return new C0607e(hVar.mo9539a(), hVar.mo9541c(), hVar.mo9540b());
    }
}
