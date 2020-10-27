package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdgs implements zzayv {
    @Nullable
    public final String zzdku = this.zzgui.optString("ad_base_url", (String) null);
    @Nullable
    public final String zzdkw;
    public final JSONObject zzfpz = this.zzgui.optJSONObject("ad_json");
    private final JSONObject zzgui;

    zzdgs(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzc = zzayu.zzc(jsonReader);
        this.zzgui = zzc;
        this.zzdkw = zzc.optString("ad_html", (String) null);
    }

    public final void zza(JsonWriter jsonWriter) throws IOException {
        zzayu.zza(jsonWriter, this.zzgui);
    }
}
