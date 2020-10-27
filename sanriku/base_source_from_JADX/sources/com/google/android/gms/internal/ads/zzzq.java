package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public final class zzzq {
    private final Collection<zzzk<?>> zzcig = new ArrayList();
    private final Collection<zzzk<String>> zzcih = new ArrayList();
    private final Collection<zzzk<String>> zzcii = new ArrayList();

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzzk next : this.zzcig) {
            if (next.getSource() == 1) {
                next.zza(editor, next.zzb(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzazw.zzfa("Flag Json is null.");
        }
    }

    public final void zza(zzzk zzzk) {
        this.zzcig.add(zzzk);
    }

    public final void zzb(zzzk<String> zzzk) {
        this.zzcih.add(zzzk);
    }

    public final void zzc(zzzk<String> zzzk) {
        this.zzcii.add(zzzk);
    }

    public final List<String> zzra() {
        ArrayList arrayList = new ArrayList();
        for (zzzk<String> zzd : this.zzcih) {
            String str = (String) zzvj.zzpv().zzd(zzd);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzaaa.zzre());
        return arrayList;
    }

    public final List<String> zzrb() {
        List<String> zzra = zzra();
        for (zzzk<String> zzd : this.zzcii) {
            String str = (String) zzvj.zzpv().zzd(zzd);
            if (!TextUtils.isEmpty(str)) {
                zzra.add(str);
            }
        }
        zzra.addAll(zzaaa.zzrf());
        return zzra;
    }
}
