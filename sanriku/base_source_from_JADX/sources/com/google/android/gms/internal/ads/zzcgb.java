package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcgb {
    private final Executor executor;
    private final Map<String, Map<String, JSONObject>> zzfxv = new ConcurrentHashMap();
    private JSONObject zzfxw;
    private boolean zzwa;

    public zzcgb(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzane */
    public final synchronized void zzanh() {
        Map map;
        this.zzwa = true;
        zzawe zzww = zzq.zzla().zzwb().zzww();
        if (zzww != null) {
            JSONObject zzwk = zzww.zzwk();
            if (zzwk != null) {
                this.zzfxw = zzwk.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzwk.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString("format");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.zzfxv.containsKey(optString2)) {
                                    map = this.zzfxv.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zzfxv.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void zzand() {
        zzq.zzla().zzwb().zzb(new zzcga(this));
        this.executor.execute(new zzcgd(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzang() {
        this.executor.execute(new zzcgc(this));
    }
}
