package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import org.json.JSONObject;

public final class zzaiu implements zzain, zzais {
    /* access modifiers changed from: private */
    public final zzbek zzdce;
    private final Context zzvf;

    public zzaiu(Context context, zzazz zzazz, @Nullable zzdt zzdt, zza zza) throws zzbew {
        Context context2 = context;
        this.zzvf = context2;
        zzq.zzkx();
        zzbek zza2 = zzbes.zza(context2, zzbfz.zzacl(), "", false, false, zzdt, zzazz, (zzaam) null, (zzi) null, (zza) null, zzst.zzmz(), (zzrv) null, false);
        this.zzdce = zza2;
        zza2.getView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzvj.zzpr();
        if (zzazm.zzye()) {
            runnable.run();
        } else {
            zzaxa.zzdwf.post(runnable);
        }
    }

    public final void destroy() {
        this.zzdce.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzdce.isDestroyed();
    }

    public final void zza(zzaiv zzaiv) {
        zzbfw zzabj = this.zzdce.zzabj();
        zzaiv.getClass();
        zzabj.zza(zzaiz.zzb(zzaiv));
    }

    public final void zza(String str, zzaga<? super zzakd> zzaga) {
        this.zzdce.zza(str, (zzaga<? super zzbek>) new zzajd(this, zzaga));
    }

    public final void zza(String str, Map map) {
        zzaim.zza((zzain) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaim.zza((zzain) this, str, jSONObject);
    }

    public final void zzb(String str, zzaga<? super zzakd> zzaga) {
        this.zzdce.zza(str, (Predicate<zzaga<? super zzbek>>) new zzaiw(zzaga));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaim.zzb(this, str, jSONObject);
    }

    public final void zzcx(String str) {
        runOnUiThread(new zzaiy(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzcy(String str) {
        runOnUiThread(new zzajb(this, str));
    }

    public final void zzcz(String str) {
        runOnUiThread(new zzaja(this, str));
    }

    public final void zzda(String str) {
        runOnUiThread(new zzaix(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdf(String str) {
        this.zzdce.zzda(str);
    }

    public final void zzj(String str, String str2) {
        zzaim.zza((zzain) this, str, str2);
    }

    public final zzakc zzsu() {
        return new zzakf(this);
    }
}
