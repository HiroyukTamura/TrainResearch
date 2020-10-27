package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

final /* synthetic */ class zzczq implements Callable {
    private final List zzgnv;

    zzczq(List list) {
        this.zzgnv = list;
    }

    public final Object call() {
        List<zzdri> list = this.zzgnv;
        JSONArray jSONArray = new JSONArray();
        for (zzdri zzdri : list) {
            if (((JSONObject) zzdri.get()) != null) {
                jSONArray.put(zzdri.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzczj(jSONArray.toString());
    }
}
