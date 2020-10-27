package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

final class zzga implements DataLayer.zzb {
    private final /* synthetic */ TagManager zzalh;

    zzga(TagManager tagManager) {
        this.zzalh = tagManager;
    }

    public final void zzc(Map<String, Object> map) {
        Object obj = map.get("event");
        if (obj != null) {
            this.zzalh.zzbl(obj.toString());
        }
    }
}
