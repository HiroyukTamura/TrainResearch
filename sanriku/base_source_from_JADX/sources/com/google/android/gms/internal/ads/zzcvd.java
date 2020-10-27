package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzq;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public final class zzcvd {
    public final String zzglg;
    public String zzglh;
    public Bundle zzgli = new Bundle();

    public zzcvd(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -995427962) {
                if (hashCode == -271442291 && nextName.equals("signal_dictionary")) {
                    c = 1;
                }
            } else if (nextName.equals("params")) {
                c = 0;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                hashMap = zzayu.zzb(jsonReader);
            }
        }
        this.zzglg = str;
        jsonReader.endObject();
        for (Map.Entry next : hashMap.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                this.zzgli.putString((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcvd zzo(Bundle bundle) {
        try {
            this.zzglh = zzq.zzkw().zzd(bundle).toString();
        } catch (JSONException unused) {
            this.zzglh = "{}";
        }
        return this;
    }
}
