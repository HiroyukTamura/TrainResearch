package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.HashMap;

public class zzuu {
    /* access modifiers changed from: private */
    public final zzuh zzcff;
    /* access modifiers changed from: private */
    public final zzue zzcfg;
    /* access modifiers changed from: private */
    public final zzyj zzcfh;
    /* access modifiers changed from: private */
    public final zzaew zzcfi;
    /* access modifiers changed from: private */
    public final zzasr zzcfj;
    private final zzatv zzcfk;
    /* access modifiers changed from: private */
    public final zzape zzcfl;
    /* access modifiers changed from: private */
    public final zzaez zzcfm;

    public zzuu(zzuh zzuh, zzue zzue, zzyj zzyj, zzaew zzaew, zzasr zzasr, zzatv zzatv, zzape zzape, zzaez zzaez) {
        this.zzcff = zzuh;
        this.zzcfg = zzue;
        this.zzcfh = zzyj;
        this.zzcfi = zzaew;
        this.zzcfj = zzasr;
        this.zzcfk = zzatv;
        this.zzcfl = zzape;
        this.zzcfm = zzaez;
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzvj.zzpr().zza(context, zzvj.zzpx().zzbnd, "gmob-apps", bundle, true);
    }

    public final zzacw zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzacw) new zzvf(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzadd zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzadd) new zzve(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzvz zza(Context context, zzum zzum, String str, zzalp zzalp) {
        return (zzvz) new zzuy(this, context, zzum, str, zzalp).zzd(context, false);
    }

    @Nullable
    public final zzapg zzb(Activity activity) {
        zzuz zzuz = new zzuz(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzazw.zzfa("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzapg) zzuz.zzd(activity, z);
    }

    public final zzvs zzb(Context context, String str, zzalp zzalp) {
        return (zzvs) new zzvd(this, context, str, zzalp).zzd(context, false);
    }

    public final zzatf zzc(Context context, String str, zzalp zzalp) {
        return (zzatf) new zzuw(this, context, str, zzalp).zzd(context, false);
    }
}
