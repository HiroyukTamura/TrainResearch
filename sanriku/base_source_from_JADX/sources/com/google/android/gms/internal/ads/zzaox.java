package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzaox {
    private final boolean zzdjc;
    private final boolean zzdjd;
    private final boolean zzdje;
    private final boolean zzdjf;
    private final boolean zzdjg;

    private zzaox(zzaoz zzaoz) {
        this.zzdjc = zzaoz.zzdjc;
        this.zzdjd = zzaoz.zzdjd;
        this.zzdje = zzaoz.zzdje;
        this.zzdjf = zzaoz.zzdjf;
        this.zzdjg = zzaoz.zzdjg;
    }

    public final JSONObject zzuc() {
        try {
            return new JSONObject().put("sms", this.zzdjc).put("tel", this.zzdjd).put("calendar", this.zzdje).put("storePicture", this.zzdjf).put("inlineVideo", this.zzdjg);
        } catch (JSONException e) {
            zzazw.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
