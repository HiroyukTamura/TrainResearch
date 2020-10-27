package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;

public final /* synthetic */ class zzaim {
    public static void zza(zzain zzain, String str, String str2) {
        zzain.zzda(C0681a.m314a(C0681a.m336b(str2, C0681a.m336b(str, 3)), str, "(", str2, ");"));
    }

    public static void zza(zzain zzain, String str, Map map) {
        try {
            zzain.zzb(str, zzq.zzkw().zzj((Map<String, ?>) map));
        } catch (JSONException unused) {
            zzazw.zzfc("Could not convert parameters to JSON.");
        }
    }

    public static void zza(zzain zzain, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzain.zzj(str, jSONObject.toString());
    }

    public static void zzb(zzain zzain, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzazw.zzed(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzain.zzda(sb.toString());
    }
}
