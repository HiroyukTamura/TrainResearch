package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzakf implements zzain, zzakc {
    private final zzakd zzddo;
    private final HashSet<AbstractMap.SimpleEntry<String, zzaga<? super zzakd>>> zzddp = new HashSet<>();

    public zzakf(zzakd zzakd) {
        this.zzddo = zzakd;
    }

    public final void zza(String str, zzaga<? super zzakd> zzaga) {
        this.zzddo.zza(str, zzaga);
        this.zzddp.add(new AbstractMap.SimpleEntry(str, zzaga));
    }

    public final void zza(String str, Map map) {
        zzaim.zza((zzain) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaim.zza((zzain) this, str, jSONObject);
    }

    public final void zzb(String str, zzaga<? super zzakd> zzaga) {
        this.zzddo.zzb(str, zzaga);
        this.zzddp.remove(new AbstractMap.SimpleEntry(str, zzaga));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaim.zzb(this, str, jSONObject);
    }

    public final void zzda(String str) {
        this.zzddo.zzda(str);
    }

    public final void zzj(String str, String str2) {
        zzaim.zza((zzain) this, str, str2);
    }

    public final void zztb() {
        Iterator<AbstractMap.SimpleEntry<String, zzaga<? super zzakd>>> it = this.zzddp.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzaga) next.getValue()).toString());
            zzawr.zzeg(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzddo.zzb((String) next.getKey(), (zzaga) next.getValue());
        }
        this.zzddp.clear();
    }
}
