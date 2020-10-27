package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzczv implements zzdak<zzczw> {
    private final zzazz zzbmo;
    private final zzdrh zzfur;
    private final Context zzvf;

    public zzczv(zzdrh zzdrh, Context context, zzazz zzazz) {
        this.zzfur = zzdrh;
        this.zzvf = context;
        this.zzbmo = zzazz;
    }

    public final zzdri<zzczw> zzaqa() {
        return this.zzfur.zzd(new zzczy(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzczw zzaqo() throws Exception {
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzvf).isCallerInstantApp();
        zzq.zzkw();
        boolean zzay = zzaxa.zzay(this.zzvf);
        String str = this.zzbmo.zzbnd;
        zzq.zzky();
        boolean zzxm = zzaxf.zzxm();
        zzq.zzkw();
        return new zzczw(isCallerInstantApp, zzay, str, zzxm, zzaxa.zzav(this.zzvf), DynamiteModule.getRemoteVersion(this.zzvf, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzvf, ModuleDescriptor.MODULE_ID));
    }
}
