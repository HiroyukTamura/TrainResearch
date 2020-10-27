package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzcbb {
    private final zzcaf zzfra;
    private final zzcdt zzftu;
    private final zzcey zzfud;
    private final zzbky zzfue;

    public zzcbb(zzcey zzcey, zzcdt zzcdt, zzbky zzbky, zzcaf zzcaf) {
        this.zzfud = zzcey;
        this.zzftu = zzcdt;
        this.zzfue = zzbky;
        this.zzfra = zzcaf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbek zzbek, Map map) {
        zzazw.zzfb("Hiding native ads overlay.");
        zzbek.getView().setVisibility(8);
        this.zzfue.zzbf(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzftu.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    public final View zzamh() throws zzbew {
        zzbek zza = this.zzfud.zza(zzum.zzph(), false);
        zza.getView().setVisibility(8);
        zza.zza("/sendMessageToSdk", (zzaga<? super zzbek>) new zzcba(this));
        zza.zza("/adMuted", (zzaga<? super zzbek>) new zzcbd(this));
        this.zzftu.zza(new WeakReference(zza), "/loadHtml", new zzcbc(this));
        this.zzftu.zza(new WeakReference(zza), "/showOverlay", new zzcbf(this));
        this.zzftu.zza(new WeakReference(zza), "/hideOverlay", new zzcbe(this));
        return zza.getView();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbek zzbek, Map map) {
        zzazw.zzfb("Showing native ads overlay.");
        zzbek.getView().setVisibility(0);
        this.zzfue.zzbf(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbek zzbek, Map map) {
        this.zzfra.zzakm();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbek zzbek, Map map) {
        this.zzftu.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
