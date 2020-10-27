package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

public final class zzasc implements zzarn {
    private zzakh<JSONObject, JSONObject> zzdqu;
    private zzakh<JSONObject, JSONObject> zzdqz;

    public zzasc(Context context) {
        zzakp zza = zzq.zzlj().zza(context, zzazz.zzyi());
        zzakl<JSONObject> zzakl = zzakk.zzddu;
        this.zzdqz = zza.zza("google.afma.request.getAdDictionary", zzakl, zzakl);
        zzakp zza2 = zzq.zzlj().zza(context, zzazz.zzyi());
        zzakl<JSONObject> zzakl2 = zzakk.zzddu;
        this.zzdqu = zza2.zza("google.afma.sdkConstants.getSdkConstants", zzakl2, zzakl2);
    }

    public final zzakh<JSONObject, JSONObject> zzuu() {
        return this.zzdqu;
    }
}
