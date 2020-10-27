package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONObject;

public final class zzaie extends zzair<zzakd> implements zzain, zzais {
    private final zzbgn zzdbs;
    /* access modifiers changed from: private */
    public zzaiv zzdbt;

    public zzaie(Context context, zzazz zzazz) throws zzbew {
        try {
            zzbgn zzbgn = new zzbgn(context, new zzaik(this));
            this.zzdbs = zzbgn;
            zzbgn.setWillNotDraw(true);
            this.zzdbs.addJavascriptInterface(new zzail(this), "GoogleJsInterface");
            zzq.zzkw().zza(context, zzazz.zzbnd, this.zzdbs.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbew("Init failed.", th);
        }
    }

    public final void destroy() {
        this.zzdbs.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzdbs.isDestroyed();
    }

    public final void zza(zzaiv zzaiv) {
        this.zzdbt = zzaiv;
    }

    public final void zza(String str, Map map) {
        zzaim.zza((zzain) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaim.zza((zzain) this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaim.zzb(this, str, jSONObject);
    }

    public final void zzcx(String str) {
        zzcy(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    public final void zzcy(String str) {
        zzbab.zzdzv.execute(new zzaih(this, str));
    }

    public final void zzcz(String str) {
        zzbab.zzdzv.execute(new zzaig(this, str));
    }

    public final void zzda(String str) {
        zzbab.zzdzv.execute(new zzaij(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdb(String str) {
        this.zzdbs.zzda(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdc(String str) {
        this.zzdbs.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdd(String str) {
        this.zzdbs.loadData(str, "text/html", "UTF-8");
    }

    public final void zzj(String str, String str2) {
        zzaim.zza((zzain) this, str, str2);
    }

    public final zzakc zzsu() {
        return new zzakf(this);
    }
}
